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
 * Encoded HTTP methods.
 */
public enum AjpHttpMethod {
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
    BASELINE_CONTROL("BASELINE_CONTROL", 26),
    MKACTIVITY("MKACTIVITY", 27);

    private final String method;
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
    public static AjpHttpMethod of(final int id) {
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
    AjpHttpMethod(final String method, final int id) {
        this.method = method;
        this.id = id;
    }

    /**
     * Returns HTTP method.
     * @return HTTP method
     */
    public final String getMethod() {
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
        return method;
    }
}
