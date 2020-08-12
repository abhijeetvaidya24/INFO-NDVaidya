/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.lang.Object
 *  java.lang.Throwable
 */
package com.ogury.consent.manager;

import com.ogury.consent.manager.tx1440;
import com.ogury.consent.manager.tx2160;
import com.ogury.consent.manager.tx6480;
import java.io.Closeable;

public final class tx3600 {
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
            tx6480.b((Object)throwable, "$receiver");
            tx6480.b((Object)throwable2, "exception");
            tx2160.a.a(throwable, throwable2);
            return;
        }
    }
}

