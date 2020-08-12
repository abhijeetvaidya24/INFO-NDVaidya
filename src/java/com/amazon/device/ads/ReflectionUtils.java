/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.ClassNotFoundException
 *  java.lang.Object
 *  java.lang.String
 */
package com.amazon.device.ads;

class ReflectionUtils {
    ReflectionUtils() {
    }

    public boolean isClassAvailable(String string) {
        try {
            Class.forName((String)string);
            return true;
        }
        catch (ClassNotFoundException classNotFoundException) {
            return false;
        }
    }
}

