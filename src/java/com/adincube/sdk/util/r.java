/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.adincube.sdk.util;

public final class r {
    public static boolean a(Object object, Object object2) {
        if (object == object2) {
            return true;
        }
        if (object != null) {
            return object.equals(object2);
        }
        return object2.equals(object);
    }
}

