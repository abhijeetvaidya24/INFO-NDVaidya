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
import com.tappx.a.a.a.b.i;
import com.tappx.a.a.a.d.ab;
import com.tappx.a.a.a.d.s;
import com.tappx.a.a.a.d.t;
import com.tappx.a.a.a.e.b;
import com.tappx.a.a.a.e.f;
import com.tappx.a.a.a.e.g;
import com.tappx.a.a.a.j;
import com.tappx.a.a.a.o;
import com.tappx.a.a.b.a.d;

public class ab
extends t<g> {
    private d a;
    private t.b b;
    private final i c;
    private s d;
    private i.b e;

    ab(com.tappx.a.a.a.i.a.a a2, i i2) {
        super(a2);
        this.c = i2;
    }

    static /* synthetic */ i.b a(ab ab2, i.b b2) {
        ab2.e = b2;
        return b2;
    }

    static /* synthetic */ t.b a(ab ab2) {
        return ab2.b;
    }

    static /* synthetic */ void a(ab ab2, f f2) {
        ab2.a(f2);
    }

    private void a(f f2) {
        this.b(f2);
        this.g().a(f2.c());
        this.d.a(f2, this.b, this);
    }

    private void b(f f2) {
        int n2 = com.tappx.a.a.a.a.a.t;
        if (f2.o() > 0) {
            n2 = f2.o();
        }
        this.a(n2);
    }

    @Override
    protected long a(g g2) {
        if (g2.i() > 0) {
            return g2.i();
        }
        return super.a(g2);
    }

    @Override
    public void a() {
        s s2 = this.d;
        if (s2 != null) {
            s2.a();
        }
    }

    @Override
    protected void a(Context context, t.b b2, g g2) {
        com.tappx.a.a.a.c.a.e("EecDzDUbtS5qsctGaW8eD9qka7saamJrDJfaB/3470s", new Object[0]);
        this.b = b2;
        this.d = new s(context);
        this.e = this.c.a(g2, new o<f>(this){
            final /* synthetic */ ab a;
            {
                this.a = ab2;
            }

            public void a(f f2) {
                ab.a(this.a, null);
                ab.a(this.a, f2);
                com.tappx.a.a.a.c.a.e("hxsTS1PgJe7SvMvbIVXAleqYGWt1TgQOogRt9pTwP9Y", new Object[0]);
            }
        }, new j<i.a>(this){
            final /* synthetic */ ab a;
            {
                this.a = ab2;
            }

            public void a(i.a a2) {
                com.tappx.a.a.a.c.a.e("hxsTS1PgJe7SvMvbIVXAlWNuK93hkAa0eyf9OlSh3dE", new Object[0]);
                ab.a(this.a, null);
                if (ab.a(this.a) != null) {
                    ab.a(this.a).a(com.tappx.a.a.a.e.h.a);
                }
            }
        });
    }

    @Override
    protected void b() {
        i.b b2;
        s s2 = this.d;
        if (s2 != null) {
            s2.b();
        }
        if ((b2 = this.e) != null) {
            this.c.a(b2);
        }
        this.d = null;
    }

    i h() {
        return this.c;
    }

}

