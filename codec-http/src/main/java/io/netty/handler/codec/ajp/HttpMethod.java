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
 * HTTP methods.
 */
public enum HttpMethod {
    OPTIONS("OPTIONS", 1),
    GET("GET", 2),
    HEAD("HEAD", 3),
    POST("POST", 4),
    PUT("PUT", 5),
    DELETE("DELETE", 6),
    TRACE("TRACE", 7),
    PROPFIND("PROPFIND", 8),
    PROPPATCH("PROPPATCH", 9),
    MKCOL("MKCOL", 10),
    COPY("COPY", 11),
    MOVE("MOVE", 12),
    LOCK("LOCK", 13),
    UNLOCK("UNLOCK", 14),
    ACL("ACL", 15),
    REPORT("REPORT", 16),
    VERSION_CONTROL("VERSION-CONTROL", 17),
    CHECKIN("CHECKIN", 18),
    CHECKOUT("CHECKOUT", 19),
    UNCHECKOUT("UNCHECKOUT", 20),
    SEARCH("SEARCH", 21),
    MKWORKSPACE("MKWORKSPACE", 22),
    UPDATE("UPDATE", 23),
    LABEL("LABEL", 24),
    MERGE("MERGE", 25),
    BASELINE_CONTRO("BASELINE_CONTRO", 26),
    MKACTIVITY("MKACTIVITY", 27);

    public final String method;
    public final int id;

    HttpMethod(final String method, final int id) {
        this.method = method;
        this.id = id;
    }
}
