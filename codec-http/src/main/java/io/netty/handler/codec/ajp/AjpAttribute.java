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
 * Encoded optional attributes.
 */
public enum AjpAttribute {
    CONTEXT("?context", 1),
    SERVLET_PATH("?servlet_path", 2),
    REMOTE_USER("?remote_user", 3),
    AUTH_TYPE("?auth_type", 4),
    QUERY_STRING("?query_string", 5),
    ROUTE("?route", 6),
    SSL_CERT("?ssl_cert", 7),
    SSL_CIPHER("?ssl_cipher", 8),
    SSL_SESSION("?ssl_session", 9),
    REQ_ATTRIBUTE("?req_attribute", 10),
    SSL_KEY_SIZE("?ssl_key_size", 11),
    SECRET("?secret", 12),
    STORED_METHOD("?stored_method", 13);

    private final String description;
    private final int id;
    private static final AjpAttribute[] ATTRIBUTES = new AjpAttribute[STORED_METHOD.ordinal() + 1];

    static {
        ATTRIBUTES[CONTEXT.id - 1] = CONTEXT;
        ATTRIBUTES[SERVLET_PATH.id - 1] = SERVLET_PATH;
        ATTRIBUTES[REMOTE_USER.id - 1] = REMOTE_USER;
        ATTRIBUTES[AUTH_TYPE.id - 1] = AUTH_TYPE;
        ATTRIBUTES[QUERY_STRING.id - 1] = QUERY_STRING;
        ATTRIBUTES[ROUTE.id - 1] = ROUTE;
        ATTRIBUTES[SSL_CERT.id - 1] = SSL_CERT;
        ATTRIBUTES[SSL_CIPHER.id - 1] = SSL_CIPHER;
        ATTRIBUTES[SSL_SESSION.id - 1] = SSL_SESSION;
        ATTRIBUTES[REQ_ATTRIBUTE.id - 1] = REQ_ATTRIBUTE;
        ATTRIBUTES[SSL_KEY_SIZE.id - 1] = SSL_KEY_SIZE;
        ATTRIBUTES[SECRET.id - 1] = SECRET;
        ATTRIBUTES[STORED_METHOD.id - 1] = STORED_METHOD;
    }

    /**
     * Converts an AJP coded attribute type to the enum.
     * @param id the coded value
     * @return enum value of the attribute type
     */
    public static AjpAttribute valueOf(final int id) {
        if (id < 1 || id > ATTRIBUTES.length) {
            throw new IllegalArgumentException();
        }
        return ATTRIBUTES[id - 1];
    }

    /**
     * Constructor.
     * @param description name of the attribute
     * @param id code value
     */
    AjpAttribute(final String description, final int id) {
        this.description = description;
        this.id = id;
    }

    /**
     * Returns attribute description.
     * @return attribute description
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
     * String description of this enum.
     * @return string description
     */
    @Override
    public final String toString() {
        return description;
    }
}
