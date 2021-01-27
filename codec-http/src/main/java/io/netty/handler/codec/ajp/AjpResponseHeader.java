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

import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.util.AsciiString;

/**
 * Encoded servlet container response headers.
 */
public enum AjpResponseHeader {
    CONTENT_TYPE(HttpHeaderNames.CONTENT_TYPE,0xA001),
    CONTENT_LANGUAGE(HttpHeaderNames.CONTENT_LANGUAGE,0xA002),
    CONTENT_LENGTH(HttpHeaderNames.CONTENT_LENGTH,0xA003),
    DATE(HttpHeaderNames.DATE,0xA004),
    LAST_MODIFIED(HttpHeaderNames.LAST_MODIFIED,0xA005),
    LOCATION(HttpHeaderNames.LOCATION,0xA006),
    SET_COOKIE(HttpHeaderNames.SET_COOKIE, 0xA007),
    SET_COOKIE2(HttpHeaderNames.SET_COOKIE2, 0xA008),
    SERVLET_ENGINE(AsciiString.cached("servlet-engine"),0xA009),
    STATUS(AsciiString.cached("status"), 0xA00A),
    WWW_AUTHENTICATE(HttpHeaderNames.WWW_AUTHENTICATE,0xA00B);

    private final AsciiString header;
    private final int id;
    private static final AjpResponseHeader[] HEADERS = new AjpResponseHeader[WWW_AUTHENTICATE.ordinal() + 1];

    /**
     * Converts an AJP coded server request header to the enum.
     * @param id the coded value
     * @return enum value of the server request header
     */
    public static AjpResponseHeader valueOf(final int id) {
        if (id < 1 || id > HEADERS.length) {
            throw new IllegalArgumentException();
        }
        return HEADERS[id - 1];
    }

    /**
     * Constructor.
     * @param header HTTP header
     * @param id code value
     */
    AjpResponseHeader(final AsciiString header, final int id) {
        this.header = header;
        this.id = id;
    }

    /**
     * Returns HTTP header.
     * @return HTTP header
     */
    public final AsciiString getHeader() {
        return header;
    }

    /**
     * Returns code value.
     * @return code value
     */
    public final int getId() {
        return id;
    }

    /**
     * String description of this enum.
     * @return string description
     */
    @Override
    public final String toString() {
        return header.toString();
    }
}
