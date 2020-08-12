/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.presage.aa
 *  java.io.Closeable
 *  java.lang.Object
 *  java.lang.Throwable
 */
package io.presage;

import io.presage.aa;
import java.io.Closeable;

public final class bt {
    public static final void a(Closeable closeable, Throwable throwable) {
        if (throwable == null) {
            closeable.close();
            return;
        }
        try {
            closeable.close();
            return;
        }
        catch (Throwable throwable2) {
            aa.a((Throwable)throwable, (Throwable)throwable2);
            return;
        }
    }
}

