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
 * Encoded web server request headers.
 */
public enum AjpRequestHeader {

    ACCEPT(HttpHeaderNames.ACCEPT, 1),
    ACCEPT_CHARSET(HttpHeaderNames.ACCEPT_CHARSET, 2),
    ACCEPT_ENCODING(HttpHeaderNames.ACCEPT_ENCODING, 3),
    ACCEPT_LANGUAGE(HttpHeaderNames.ACCEPT_LANGUAGE, 4),
    AUTHORIZATION(HttpHeaderNames.AUTHORIZATION,5),
    CONNECTION(HttpHeaderNames.CONNECTION, 6),
    CONTENT_TYPE(HttpHeaderNames.CONTENT_TYPE, 7),
    CONTENT_LENGTH(HttpHeaderNames.CONTENT_LENGTH, 8),
    COOKIE(HttpHeaderNames.COOKIE, 9),
    COOKIE2(AsciiString.cached("cookie2"), 10),
    HOST(HttpHeaderNames.HOST, 11),
    PRAGMA(HttpHeaderNames.PRAGMA, 12),
    REFERER(HttpHeaderNames.REFERER, 13),
    USER_AGENT(HttpHeaderNames.USER_AGENT, 14);

    private final AsciiString header;
    private final int id;
    private static final AjpRequestHeader[] HEADERS = new AjpRequestHeader[USER_AGENT.ordinal() + 1];

    static {
        HEADERS[ACCEPT.id - 1] = ACCEPT;
        HEADERS[ACCEPT_CHARSET.id - 1] = ACCEPT_CHARSET;
        HEADERS[ACCEPT_ENCODING.id - 1] = ACCEPT_ENCODING;
        HEADERS[ACCEPT_LANGUAGE.id - 1] = ACCEPT_LANGUAGE;
        HEADERS[AUTHORIZATION.id - 1] = AUTHORIZATION;
        HEADERS[CONNECTION.id - 1] = CONNECTION;
        HEADERS[CONTENT_TYPE.id - 1] = CONTENT_TYPE;
        HEADERS[CONTENT_LENGTH.id - 1] = CONTENT_LENGTH;
        HEADERS[COOKIE.id - 1] = COOKIE;
        HEADERS[COOKIE2.id - 1] = COOKIE2;
        HEADERS[HOST.id - 1] = HOST;
        HEADERS[PRAGMA.id - 1] = PRAGMA;
        HEADERS[REFERER.id - 1] = REFERER;
        HEADERS[USER_AGENT.id - 1] = USER_AGENT;
    }

    /**
     * Converts an AJP coded server request header to the enum.
     * @param id the coded value
     * @return enum value of the server request header
     */
    public static AjpRequestHeader valueOf(final int id) {
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
    AjpRequestHeader(final AsciiString header, final int id) {
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
