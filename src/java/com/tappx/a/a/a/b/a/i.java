/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 *  java.lang.String
 */
package com.tappx.a.a.a.b.a;

import android.content.Context;
import com.tappx.a.a.a.b.a.b;
import com.tappx.a.a.a.b.a.c;
import com.tappx.a.a.a.b.a.e;
import com.tappx.a.a.a.b.a.f;
import com.tappx.a.a.a.b.a.g;
import com.tappx.a.a.a.b.a.j;
import com.tappx.b.a.x;
import com.tappx.b.n;
import com.tappx.b.o;

public final class i
implements c {
    private static final String a = "http";
    private final o b;
    private final f c;

    public i(Context context) {
        this(x.a(context), new f());
    }

    i(o o2, f f2) {
        this.c = f2;
        this.b = o2;
        f2.a(this);
    }

    private boolean a(String string) {
        return string != null && string.startsWith(a);
    }

    @Override
    public void a(e<?> e2) {
        if (!this.a(e2.b())) {
            g.a a2 = e2.V();
            if (a2 != null) {
                a2.a(new b(b.a.c));
            }
            return;
        }
        j j2 = new j(e2);
        j2.b(e2);
        this.b.a(j2);
    }

    @Override
    public void a(e<?> e2, int n2) {
        this.c.a(e2, n2);
    }

    public void b(e e2) {
        if (this.c.a(e2)) {
            return;
        }
        this.b.a(e2);
    }
}

