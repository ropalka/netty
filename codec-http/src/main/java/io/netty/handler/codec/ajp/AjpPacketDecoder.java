/*
 * Copyright 2021 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package io.netty.handler.codec.ajp;

import io.netty.buffer.ByteBuf;

/**
 * Decodes {@link ByteBuf}s into AJP Packets.
 */
public final class AjpPacketDecoder {

    private static final int BYTE_MASK = 0xFF;
    private static final int AJP_PACKET_HEADER_MARK_OFFSET   = 0;
    private static final int AJP_PACKET_HEADER_LENGTH_OFFSET  = 2;
    private static final int AJP_PACKET_HEADER_SIZE = 4;

    private volatile State state; // TODO: question is if this class is used by multiple threads or not?
    private volatile int length; // TODO: question is if this class is used by multiple threads or not?

    private enum State {
        READ_PACKET_HEADER,
        READ_PACKET_CONTENT,
        READ_FORWARD_REQUEST_BODY,
    }

    public AjpPacketDecoder() {
        state = State.READ_PACKET_HEADER;
    }

    public AjpPacket decode(final ByteBuf buffer) {
        while (true) {
            switch (state) {
            case READ_PACKET_HEADER: {
                if (buffer.readableBytes() < AJP_PACKET_HEADER_SIZE) {
                    return null;
                }
                final int packetOffset = buffer.readerIndex();
                final int markOffset = packetOffset + AJP_PACKET_HEADER_MARK_OFFSET;
                final int lengthOffset = packetOffset + AJP_PACKET_HEADER_LENGTH_OFFSET;
                buffer.skipBytes(AJP_PACKET_HEADER_SIZE);

                final int mark = readUnsignedShort(buffer, markOffset);
                if (mark != AjpPacketUtils.WEB_SERVER_to_SERVLET_CONTAINER_message_mark) {
                    return null; // TODO: report error
                }
                length = readUnsignedShort(buffer, lengthOffset);
                if (length > AjpPacketUtils.MAX_PACKET_SIZE) {
                    return null; // TODO: report error
                }
                if (length == 0) {
                    return null; // ignore zero length packets
                }
                state = State.READ_PACKET_CONTENT;
            } break;
            case READ_PACKET_CONTENT: {
                if (buffer.readableBytes() < length) {
                    return null;
                }
                // TODO: here we know the whole packet body size - read whole packet instead
                final int packetTypeByte = buffer.readByte();
                final AjpPacketType packetType = AjpPacketType.valueOf(packetTypeByte); // TODO: handle potential exception
                if (packetType == AjpPacketType.CPING) {
                    state = State.READ_PACKET_HEADER;
                    return AjpCPingPacket.INSTANCE;
                }
                if (packetType != AjpPacketType.FORWARD_REQUEST) {
                    state = State.READ_PACKET_HEADER;
                    return null; // TODO: report error
                }
                state = State.READ_FORWARD_REQUEST_BODY;
            } break;
            case READ_FORWARD_REQUEST_BODY: {
                // TODO: process FORWARD_REQUEST body
            }
            }
        }
    }

    private static int readUnsignedShort(final ByteBuf buf, final int offset) {
        return (buf.getByte(offset) & BYTE_MASK) << 8 | buf.getByte(offset + 1) & BYTE_MASK;
    }

}
