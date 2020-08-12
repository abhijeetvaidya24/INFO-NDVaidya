/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.Map
 */
package com.aerserv.sdk.utils;

import java.util.HashMap;
import java.util.Map;

public class LocalCache {
    private static Map<String, Object> data = new HashMap();

    public static Object get(String string) {
        return data.get((Object)string);
    }

    public static void put(String string, Object object) {
        data.put((Object)string, object);
    }
}

