/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 *  java.lang.String
 */
package com.tappx.a.a.b.a;

import android.content.Context;
import com.tappx.a.a.b.a.b;
import com.tappx.a.a.b.a.c;
import com.tappx.a.a.b.a.d;
import com.tappx.a.a.b.a.f;
import com.tappx.sdk.a.a;

public class e
implements d {
    private final f a;
    private d.a b;
    private Context c;
    private String d;
    private a e;
    private int f = -1;

    public e() {
        this(new f());
    }

    e(f f2) {
        this.a = f2;
    }

    @Override
    public void a() {
        b.a(this.c, this.d, this.e, this.f);
    }

    @Override
    public void a(Context context, String string, a a2) {
        this.c = context;
        this.d = string;
        this.e = a2;
        this.f = c.a(this.b);
        this.a.a(context, string, this.b);
    }

    @Override
    public void a(d.a a2) {
        this.b = a2;
    }

    @Override
    public void b() {
        c.b(this.f);
        this.a.a();
    }
}

