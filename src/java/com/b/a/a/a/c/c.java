/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  java.lang.Object
 */
package com.b.a.a.a.c;

import android.annotation.SuppressLint;
import android.content.Context;

public class c {
    @SuppressLint(value={"StaticFieldLeak"})
    private static c a = new c();
    private Context b;

    private c() {
    }

    public static c a() {
        return a;
    }

    public void a(Context context) {
        Context context2 = context != null ? context.getApplicationContext() : null;
        this.b = context2;
    }

    public Context b() {
        return this.b;
    }
}

