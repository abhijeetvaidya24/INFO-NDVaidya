/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.UUID
 */
package com.appsgeyser.sdk;

import java.util.UUID;

public class GuidGenerator {
    public static String generateNewGuid() {
        return UUID.randomUUID().toString();
    }
}

