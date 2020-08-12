/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 */
package com.tapjoy.internal;

final class dm {
    static void a(Object object, String string2) {
        if (object != null) {
            return;
        }
        throw new NullPointerException(string2);
    }
}

