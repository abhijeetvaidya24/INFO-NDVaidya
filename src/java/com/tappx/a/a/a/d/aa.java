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
import com.tappx.a.a.a.d.aa;
import com.tappx.a.a.a.d.c;
import com.tappx.a.a.a.d.q;
import com.tappx.a.a.a.e.b;
import com.tappx.a.a.a.e.f;
import com.tappx.a.a.a.e.g;
import com.tappx.a.a.a.j;
import com.tappx.a.a.a.o;

public class aa
extends c<g> {
    private final i a;
    private q b;
    private c.b c;
    private i.b d;

    aa(com.tappx.a.a.a.i.a.a a2, i i2) {
        super(a2);
        this.a = i2;
    }

    static /* synthetic */ c.b a(aa aa2) {
        return aa2.c;
    }

    static /* synthetic */ void a(aa aa2, f f2) {
        aa2.a(f2);
    }

    private void a(f f2) {
        int n2 = com.tappx.a.a.a.a.a.t;
        if (f2.o() > 0) {
            n2 = f2.o();
        }
        this.a(n2);
    }

    static /* synthetic */ void b(aa aa2, f f2) {
        aa2.b(f2);
    }

    private void b(f f2) {
        this.a().a(f2.c());
        this.b.a(f2, this.c);
    }

    @Override
    protected long a(g g2) {
        if (g2.i() > 0) {
            return g2.i();
        }
        return super.a(g2);
    }

    protected void a(Context context, c.b b2, g g2) {
        com.tappx.a.a.a.c.a.e("7qjY7245E0dfSy30XptPQ6Kjsb63PLX1qtOqZ64iM50", new Object[0]);
        this.c = b2;
        this.b = new q(context);
        this.d = this.a.a(g2, new o<f>(this){
            final /* synthetic */ aa a;
            {
                this.a = aa2;
            }

            public void a(f f2) {
                aa.a(this.a, f2);
                aa.b(this.a, f2);
                com.tappx.a.a.a.c.a.e("hxsTS1PgJe7SvMvbIVXAleqYGWt1TgQOogRt9pTwP9Y", new Object[0]);
            }
        }, new j<i.a>(this){
            final /* synthetic */ aa a;
            {
                this.a = aa2;
            }

            public void a(i.a a2) {
                com.tappx.a.a.a.c.a.e("wA68d1p5v8MSlvKrjle67r38zreZaMrbDBiCU39LXJU", new Object[]{a2});
                aa.a(this.a).a(com.tappx.a.a.a.e.h.a);
            }
        });
    }

    @Override
    protected /* synthetic */ void b(Context context, c.b b2, b b3) {
        this.a(context, b2, (g)b3);
    }

    @Override
    protected void c() {
        q q2;
        i.b b2 = this.d;
        if (b2 != null) {
            this.a.a(b2);
        }
        if ((q2 = this.b) != null) {
            q2.a();
        }
        this.b = null;
    }

    i g() {
        return this.a;
    }

}

