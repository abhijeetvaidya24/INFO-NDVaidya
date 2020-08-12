/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.tapjoy.internal.dd$1
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.logging.Logger
 */
package com.tapjoy.internal;

import com.tapjoy.internal.dd;
import com.tapjoy.internal.dh;
import com.tapjoy.internal.di;
import java.util.logging.Logger;

public abstract class dd
implements di {
    private static final Logger a = Logger.getLogger((String)dd.class.getName());
    private final di b = new 1(this);

    static /* synthetic */ Logger g() {
        return a;
    }

    public void a() {
    }

    public abstract void b();

    public void c() {
    }

    public void d() {
    }

    @Override
    public final dh e() {
        return this.b.e();
    }

    @Override
    public final di.a f() {
        return this.b.f();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getClass().getSimpleName());
        stringBuilder.append(" [");
        stringBuilder.append((Object)((Object)this.f()));
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

