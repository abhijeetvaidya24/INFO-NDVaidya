/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.applovin.impl.sdk.d;

import android.content.Context;
import com.applovin.impl.sdk.c.i;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.p;

public abstract class a
implements Runnable {
    private final String a;
    protected final j b;
    private final p c;
    private final Context d;
    private final boolean e;

    public a(String string2, j j2) {
        this(string2, j2, false);
    }

    public a(String string2, j j2, boolean bl) {
        this.a = string2;
        this.b = j2;
        this.c = j2.u();
        this.d = j2.w();
        this.e = bl;
    }

    public abstract i a();

    protected void a(String string2) {
        this.c.a(this.a, string2);
    }

    protected void a(String string2, Throwable throwable) {
        this.c.b(this.a, string2, throwable);
    }

    protected j b() {
        return this.b;
    }

    protected void b(String string2) {
        this.c.b(this.a, string2);
    }

    public String c() {
        return this.a;
    }

    protected void c(String string2) {
        this.c.c(this.a, string2);
    }

    protected Context d() {
        return this.d;
    }

    protected void d(String string2) {
        this.c.d(this.a, string2);
    }

    public boolean e() {
        return this.e;
    }
}

