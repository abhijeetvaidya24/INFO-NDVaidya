/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  com.tappx.a.a.a.b.d
 *  com.tappx.a.a.a.b.f
 *  com.tappx.a.a.a.b.h
 *  com.tappx.a.a.a.b.l
 *  com.tappx.a.a.a.d.ah
 *  com.tappx.a.a.a.e$1
 *  com.tappx.a.a.a.e$2
 *  com.tappx.a.a.a.e$3
 *  com.tappx.a.a.a.e$4
 *  com.tappx.a.a.a.i.b.d
 *  com.tappx.a.a.a.j.f$a
 *  java.lang.Class
 *  java.lang.Deprecated
 *  java.lang.Object
 *  java.lang.String
 */
package com.tappx.a.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import com.tappx.a.a.a.a.a;
import com.tappx.a.a.a.b.d;
import com.tappx.a.a.a.b.f;
import com.tappx.a.a.a.b.g;
import com.tappx.a.a.a.b.h;
import com.tappx.a.a.a.b.i;
import com.tappx.a.a.a.b.k;
import com.tappx.a.a.a.b.l;
import com.tappx.a.a.a.d.ac;
import com.tappx.a.a.a.d.ag;
import com.tappx.a.a.a.d.ah;
import com.tappx.a.a.a.d.b;
import com.tappx.a.a.a.d.f;
import com.tappx.a.a.a.d.w;
import com.tappx.a.a.a.d.x;
import com.tappx.a.a.a.d.y;
import com.tappx.a.a.a.d.z;
import com.tappx.a.a.a.e;
import com.tappx.a.a.a.i.b.c;
import com.tappx.a.a.a.i.b.d;
import com.tappx.a.a.a.j.f;
import com.tappx.a.a.a.n;

/*
 * Exception performing whole class analysis.
 */
public class e {
    private static final String a = "tappx";
    private static volatile e b;
    private final Context c;
    private final n<com.tappx.a.a.a.b.a.c> d;
    private final n<com.tappx.a.a.a.i.a.a> e;
    private final n<i> f;
    private final n<com.tappx.a.a.a.f.a> g;

    public e(Context context) {
        this.c = context;
        this.p();
        this.d = new n(new 1(this));
        this.e = new n(new 2(this));
        this.f = new n(new 3(this));
        this.g = new n(new 4(this));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static e a(Context context) {
        e e2 = b;
        if (e2 != null) {
            return e2;
        }
        Class<e> class_ = e.class;
        synchronized (e.class) {
            e e3 = b;
            if (e3 != null) return e3;
            b = new e(context.getApplicationContext());
            return b;
        }
    }

    @Deprecated
    public static void a(e e2) {
        b = e2;
    }

    static /* synthetic */ Context b(e e2) {
        return e2.c;
    }

    static /* synthetic */ com.tappx.a.a.a.b.a.c c(e e2) {
        return e2.u();
    }

    static /* synthetic */ f.a d(e e2) {
        return e2.q();
    }

    static /* synthetic */ d.a e(e e2) {
        return e2.r();
    }

    static /* synthetic */ String f(e e2) {
        return e2.t();
    }

    static /* synthetic */ com.tappx.a.a.a.h.g g(e e2) {
        return e2.v();
    }

    private void p() {
        new com.tappx.a.a.a.b.a(this.c).a();
    }

    private f.a q() {
        return new f.a(this.s());
    }

    private d.a r() {
        return new d.a(this.s());
    }

    private k s() {
        return new k();
    }

    private String t() {
        return a.a();
    }

    private com.tappx.a.a.a.b.a.c u() {
        return this.d.a();
    }

    private com.tappx.a.a.a.h.g v() {
        return com.tappx.a.a.a.h.h.a(this.c()).a();
    }

    private com.tappx.a.a.a.f.a w() {
        return this.g.a();
    }

    private z.a x() {
        return z.a.a(this.c);
    }

    private f.c y() {
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    private com.tappx.a.a.a.g z() {
        return new com.tappx.a.a.a.g();
    }

    public l.a a() {
        l.a a2 = new l.a(this.s(), this.j(), this.k(), this.m(), this.l(), this.n(), this.x());
        return a2;
    }

    public h.a b() {
        return new h.a(this.k(), new g(this.o()), this.x(), this.m());
    }

    public Context c() {
        return this.c;
    }

    public i d() {
        return this.f.a();
    }

    public com.tappx.a.a.a.d.a e() {
        return new com.tappx.a.a.a.d.a();
    }

    public com.tappx.a.a.a.i.a.a f() {
        return this.e.a();
    }

    public ag g() {
        return new ah(this.d(), this.e(), this.w());
    }

    public x h() {
        return new x(this.c);
    }

    public c i() {
        return d.a((Context)this.c);
    }

    public f.a j() {
        return f.a.a(this.c);
    }

    public ac.a k() {
        return ac.a.a(this.c);
    }

    public y.a l() {
        return y.a.a(this.c);
    }

    public b.a m() {
        return b.a.a(this.c);
    }

    public w.b n() {
        return w.b.a(this.c);
    }

    public SharedPreferences o() {
        return this.c.getSharedPreferences(a, 0);
    }
}

