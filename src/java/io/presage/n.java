/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.lang.Object
 *  java.lang.Throwable
 */
package io.presage;

import java.io.Closeable;

public final class n {
    public static final void a(Closeable closeable) {
        try {
            closeable.close();
        }
        catch (Throwable throwable) {}
    }
}

