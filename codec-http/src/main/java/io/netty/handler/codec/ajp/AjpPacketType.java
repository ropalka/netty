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

/**
 * Encoded packet types.
 */
public enum AjpPacketType {
    DATA("Data", 1, true),
    FORWARD_REQUEST("Forward Request", 2, true),
    SEND_BODY_CHUNK("Send Body Chunk", 3, false),
    SEND_HEADERS("Send Headers", 4, false),
    END_RESPONSE("End Response", 5, false),
    GET_BODY_CHUNK("Get Body Chunk", 6, false),
    SHUTDOWN("Shutdown", 7, true),
    PING("Ping", 8, true),
    CPONG_REPLY("CPong Reply", 9, false),
    CPING("CPing", 10, true);

    private final String description;
    private final int id;
    private final boolean isWebServerPacket;
    private static final AjpPacketType[] PACKETS = new AjpPacketType[CPING.ordinal() + 1];

    static {
        PACKETS[DATA.id - 1] = DATA;
        PACKETS[FORWARD_REQUEST.id - 1] = FORWARD_REQUEST;
        PACKETS[SEND_BODY_CHUNK.id - 1] = SEND_BODY_CHUNK;
        PACKETS[SEND_HEADERS.id - 1] = SEND_HEADERS;
        PACKETS[END_RESPONSE.id - 1] = END_RESPONSE;
        PACKETS[GET_BODY_CHUNK.id - 1] = GET_BODY_CHUNK;
        PACKETS[SHUTDOWN.id - 1] = SHUTDOWN;
        PACKETS[PING.id - 1] = PING;
        PACKETS[CPONG_REPLY.id - 1] = CPONG_REPLY;
        PACKETS[CPING.id - 1] = CPING;
    }

    /**
     * Converts an AJP coded packet type to the enum.
     * @param id the coded value
     * @return enum value of the packet type
     */
    public static AjpPacketType valueOf(final int id) {
        if (id < 2 || id > PACKETS.length) {
            throw new IllegalArgumentException();
        }
        return PACKETS[id - 1];
    }

    /**
     * Constructor.
     * @param description name of the packet
     * @param id code value
     * @param isWebServerPacket <code>true</code> if it is web server packet <code>false</code> if it is servlet container packet
     */
    AjpPacketType(final String description, final int id, final boolean isWebServerPacket) {
        this.description = description;
        this.id = id;
        this.isWebServerPacket = isWebServerPacket;
    }

    /**
     * Returns packet description.
     * @return packet description
     */
    public final String getDescription() {
        return description;
    }

    /**
     * Returns code value.
     * @return code value
     */
    public final int getId() {
        return id;
    }

    /**
     * Returns <code>true</code> if it is web server packet <code>false</code> if it is servlet container packet.
     * @return <code>true</code> if it is web server packet <code>false</code> if it is servlet container packet
     */
    public final boolean isWebServerPacket() {
        return isWebServerPacket;
    }

    /**
     * String description of this enum.
     * @return string description
     */
    @Override
    public final String toString() {
        return description;
    }
}
