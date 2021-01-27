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

import io.netty.handler.codec.http.HttpMethod;

/**
 * Encoded HTTP methods.
 */
public enum AjpHttpMethod {
    OPTIONS(HttpMethod.OPTIONS, 1),
    GET(HttpMethod.GET, 2),
    HEAD(HttpMethod.HEAD, 3),
    POST(HttpMethod.POST, 4),
    PUT(HttpMethod.PUT, 5),
    DELETE(HttpMethod.DELETE, 6),
    TRACE(HttpMethod.TRACE, 7),
    PROPFIND(HttpMethod.valueOf("PROPFIND"), 8),
    PROPPATCH(HttpMethod.valueOf("PROPPATCH"), 9),
    MKCOL(HttpMethod.valueOf("MKCOL"), 10),
    COPY(HttpMethod.valueOf("COPY"), 11),
    MOVE(HttpMethod.valueOf("MOVE"), 12),
    LOCK(HttpMethod.valueOf("LOCK"), 13),
    UNLOCK(HttpMethod.valueOf("UNLOCK"), 14),
    ACL(HttpMethod.valueOf("ACL"), 15),
    REPORT(HttpMethod.valueOf("REPORT"), 16),
    VERSION_CONTROL(HttpMethod.valueOf("VERSION-CONTROL"), 17),
    CHECKIN(HttpMethod.valueOf("CHECKIN"), 18),
    CHECKOUT(HttpMethod.valueOf("CHECKOUT"), 19),
    UNCHECKOUT(HttpMethod.valueOf("UNCHECKOUT"), 20),
    SEARCH(HttpMethod.valueOf("SEARCH"), 21),
    MKWORKSPACE(HttpMethod.valueOf("MKWORKSPACE"), 22),
    UPDATE(HttpMethod.valueOf("UPDATE"), 23),
    LABEL(HttpMethod.valueOf("LABEL"), 24),
    MERGE(HttpMethod.valueOf("MERGE"), 25),
    BASELINE_CONTROL(HttpMethod.valueOf("BASELINE_CONTROL"), 26),
    MKACTIVITY(HttpMethod.valueOf("MKACTIVITY"), 27);

    private final HttpMethod method;
    private final int id;
    private static final AjpHttpMethod[] METHODS = new AjpHttpMethod[27];

    static {
        METHODS[OPTIONS.id - 1] = OPTIONS;
        METHODS[GET.id - 1] = GET;
        METHODS[HEAD.id - 1] = HEAD;
        METHODS[POST.id - 1] = POST;
        METHODS[PUT.id - 1] = PUT;
        METHODS[DELETE.id - 1] = DELETE;
        METHODS[TRACE.id - 1] = TRACE;
        METHODS[PROPFIND.id - 1] = PROPFIND;
        METHODS[PROPPATCH.id - 1] = PROPPATCH;
        METHODS[MKCOL.id - 1] = MKCOL;
        METHODS[COPY.id - 1] = COPY;
        METHODS[MOVE.id - 1] = MOVE;
        METHODS[LOCK.id - 1] = LOCK;
        METHODS[UNLOCK.id - 1] = UNLOCK;
        METHODS[ACL.id - 1] = ACL;
        METHODS[REPORT.id - 1] = REPORT;
        METHODS[VERSION_CONTROL.id - 1] = VERSION_CONTROL;
        METHODS[CHECKIN.id - 1] = CHECKIN;
        METHODS[CHECKOUT.id - 1] = CHECKOUT;
        METHODS[UNCHECKOUT.id - 1] = UNCHECKOUT;
        METHODS[SEARCH.id - 1] = SEARCH;
        METHODS[MKWORKSPACE.id - 1] = MKWORKSPACE;
        METHODS[UPDATE.id - 1] = UPDATE;
        METHODS[LABEL.id - 1] = LABEL;
        METHODS[MERGE.id - 1] = MERGE;
        METHODS[BASELINE_CONTROL.id - 1] = BASELINE_CONTROL;
        METHODS[MKACTIVITY.id - 1] = MKACTIVITY;
    }

    /**
     * Converts an AJP coded HTTP method to the enum.
     * @param id the coded value
     * @return enum value of the HTTP method
     */
    public static AjpHttpMethod valueOf(final int id) {
        if (id < 1 || id > METHODS.length) {
            throw new IllegalArgumentException();
        }
        return METHODS[id - 1];
    }

    /**
     * Constructor.
     * @param method HTTP method
     * @param id code value
     */
    AjpHttpMethod(final HttpMethod method, final int id) {
        this.method = method;
        this.id = id;
    }

    /**
     * Returns HTTP method.
     * @return HTTP method
     */
    public final HttpMethod getMethod() {
        return method;
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
        return method.toString();
    }
}
