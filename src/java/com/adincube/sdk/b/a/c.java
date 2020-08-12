/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.CountDownTimer
 *  com.adincube.sdk.b.a
 *  com.adincube.sdk.b.a$c
 *  com.adincube.sdk.b.a.a.e$a
 *  com.adincube.sdk.b.a.a.g
 *  com.adincube.sdk.b.a.c$a
 *  com.adincube.sdk.h.a.c
 *  com.adincube.sdk.h.g.a
 *  com.adincube.sdk.util.h.a
 *  java.lang.Boolean
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.adincube.sdk.b.a;

import android.os.CountDownTimer;
import com.adincube.sdk.b.a;
import com.adincube.sdk.b.a.a.e;
import com.adincube.sdk.b.a.a.g;
import com.adincube.sdk.b.a.c;
import com.adincube.sdk.k.b.b.d;
import com.adincube.sdk.util.h.a;
import com.adincube.sdk.util.j;

/*
 * Exception performing whole class analysis.
 */
public final class c
implements e.a,
j {
    private com.adincube.sdk.h.a.c a;
    private String b;
    private long c;
    private long d;
    private com.adincube.sdk.util.h.a e;
    private a f;
    private Boolean g;
    private Boolean h;
    private a.c i;
    private a.a j;

    public c(e e2, com.adincube.sdk.util.h.a a2, com.adincube.sdk.h.a.c c2, String string, long l2, long l3, a.c c3) {
        this.e = null;
        this.f = null;
        this.j = new a.a(){

            @Override
            public final void s() {
                c.this.a();
            }
        };
        this.a = c2;
        this.b = string;
        this.c = l2;
        this.d = l3;
        this.e = a2;
        this.i = c3;
        if (l2 > l3) {
            e2.a(this);
        }
    }

    private boolean d() {
        if (this.g == null) {
            this.g = "impression".equals((Object)this.b);
        }
        return this.g;
    }

    private boolean e() {
        if (this.h == null) {
            boolean bl = com.adincube.sdk.h.g.a.a((String)this.b, (long)this.c) != null;
            this.h = bl;
        }
        return this.h;
    }

    private boolean f() {
        return !this.d() && !this.e();
    }

    public final void a() {
        this.i.a(this.a, Boolean.valueOf((boolean)true));
    }

    public final void a(e e2) {
        if (this.e()) {
            a a2 = this.f;
            if (a2 != null) {
                a2.cancel();
            }
            this.a();
        }
    }

    public final void a(e e2, g g2) {
    }

    public final void a(d d2) {
        if (this.f() && d2.w.equals((Object)this.b)) {
            this.a();
        }
    }

    @Override
    public final void b() {
        a a2;
        if (this.e() && (a2 = this.f) != null) {
            a2.cancel();
        }
    }

    public final void b(e e2) {
    }

    public final void b_() {
        if (this.d()) {
            this.a();
            return;
        }
        if (this.e()) {
            Long l2 = com.adincube.sdk.h.g.a.a((String)this.b, (long)this.c).a - this.d;
            if (l2 < 0L) {
                StringBuilder stringBuilder = new StringBuilder("Impression will be send in ");
                stringBuilder.append((Object)l2);
                stringBuilder.append("ms");
                this.f = new /* Unavailable Anonymous Inner Class!! */;
                this.f.start();
            }
            return;
        }
        if (this.f()) {
            StringBuilder stringBuilder = new StringBuilder("Impression will be send on event '");
            stringBuilder.append(this.b);
            stringBuilder.append("'.");
            if ("skipoffset".equals((Object)this.b)) {
                this.e.a(this.j);
            }
        }
    }

}

