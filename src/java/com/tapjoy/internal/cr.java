/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.tapjoy.internal;

import com.tapjoy.internal.cs;

public final class cr {
    public static boolean a(Object object, Object object2) {
        return object == object2 || object != null && object.equals(object2);
        {
        }
    }

    public static Object b(Object object, Object object2) {
        if (object != null) {
            return object;
        }
        return cs.a(object2);
    }
}

