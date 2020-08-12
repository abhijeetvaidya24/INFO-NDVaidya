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
import com.tappx.a.a.a.d.c;
import com.tappx.a.a.a.d.q;
import com.tappx.a.a.a.e.b;
import com.tappx.a.a.a.e.f;

public final class p
extends c<f> {
    private q a;

    p(com.tappx.a.a.a.i.a.a a2) {
        super(a2);
    }

    @Override
    protected long a(f f2) {
        int n2 = f2.o();
        if (n2 > 0) {
            return n2;
        }
        return super.a(f2);
    }

    protected void a(Context context, c.b b2, f f2) {
        this.a().a(f2.c());
        this.a = new q(context);
        this.a.a(f2, b2);
    }

    @Override
    protected /* synthetic */ void b(Context context, c.b b2, b b3) {
        this.a(context, b2, (f)b3);
    }

    @Override
    protected void c() {
        q q2 = this.a;
        if (q2 != null) {
            q2.a();
        }
        this.a = null;
    }

}

