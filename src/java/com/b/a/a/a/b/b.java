/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  com.b.a.a.a.b.i
 *  java.lang.Object
 */
package com.b.a.a.a.b;

import android.view.View;
import com.b.a.a.a.b.c;
import com.b.a.a.a.b.d;
import com.b.a.a.a.b.i;
import com.b.a.a.a.e.e;

public abstract class b {
    public static b a(c c2, d d2) {
        e.a();
        e.a(c2, "AdSessionConfiguration is null");
        e.a(d2, "AdSessionContext is null");
        return new i(c2, d2);
    }

    public abstract void a();

    public abstract void a(View var1);

    public abstract void b();

    public abstract void b(View var1);
}

