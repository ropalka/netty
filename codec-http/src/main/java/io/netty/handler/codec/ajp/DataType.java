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
 * Protocol data types. All data types are using network byte order.
 */
public enum DataType {
    /**
     * A single byte.
     */
    BYTE,
    /**
     * A single byte, 1 = true, 0 = false.
     */
    BOOLEAN,
    /**
     * A number in the range of 0 to 2^16. Stored in 2 bytes with the high-order byte first.
     */
    INTEGER,
    /**
     * A variable-sized string (length bounded by 2^16).
     * Encoded with the length packed into two bytes first,
     * followed by the string (including the terminating '\0').
     */
    STRING
}
