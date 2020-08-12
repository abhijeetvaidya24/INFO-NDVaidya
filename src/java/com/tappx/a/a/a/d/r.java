/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 *  java.lang.String
 */
package com.tappx.a.a.a.d;

import android.content.Context;
import com.tappx.a.a.a.d.s;
import com.tappx.a.a.a.d.t;
import com.tappx.a.a.a.e.b;
import com.tappx.a.a.a.e.f;

public class r
extends t<f> {
    private s a;
    private f b;

    r(com.tappx.a.a.a.i.a.a a2) {
        super(a2);
    }

    @Override
    protected long a(f f2) {
        int n2 = f2.o();
        if (n2 > 0) {
            return n2;
        }
        return com.tappx.a.a.a.a.a.t;
    }

    @Override
    public void a() {
        s s2 = this.a;
        if (s2 != null) {
            s2.a();
        }
    }

    @Override
    protected void a(Context context, t.b b2, f f2) {
        this.b = f2;
        this.g().a(f2.c());
        this.a = new s(context);
        this.a.a(f2, b2, this);
    }

    @Override
    protected void b() {
        s s2 = this.a;
        if (s2 != null) {
            s2.b();
        }
    }

}

