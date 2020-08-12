/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 */
package com.aerserv.sdk.utils;

public class ReflectionUtils {
    public static boolean canFindClass(String string) {
        try {
            Class.forName((String)string);
            return true;
        }
        catch (Exception exception) {
            return false;
        }
    }
}

