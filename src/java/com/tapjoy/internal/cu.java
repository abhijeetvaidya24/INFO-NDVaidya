/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Error
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.Throwable
 */
package com.tapjoy.internal;

import com.tapjoy.internal.cs;

public final class cu {
    public static RuntimeException a(Throwable throwable) {
        Throwable throwable2 = (Throwable)((Object)cs.a((Object)throwable));
        cu.a(throwable2, Error.class);
        cu.a(throwable2, RuntimeException.class);
        throw new RuntimeException(throwable);
    }

    private static void a(Throwable throwable, Class class_) {
        if (throwable != null) {
            if (!class_.isInstance((Object)throwable)) {
                return;
            }
            throw (Throwable)((Object)class_.cast((Object)throwable));
        }
    }
}

