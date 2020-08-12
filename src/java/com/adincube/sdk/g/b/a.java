/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.adincube.sdk.d.a.h
 *  com.adincube.sdk.d.a.m
 *  com.adincube.sdk.d.a.o
 *  com.adincube.sdk.g.a
 *  com.adincube.sdk.g.b
 *  com.adincube.sdk.g.b.a$1
 *  com.adincube.sdk.g.b.c.d
 *  com.adincube.sdk.g.b.c.e
 *  com.adincube.sdk.g.b.c.h
 *  com.adincube.sdk.g.b.c.i
 *  com.adincube.sdk.g.b.c.j
 *  com.adincube.sdk.g.b.c.k
 *  com.adincube.sdk.g.b.c.m
 *  com.adincube.sdk.g.b.c.n
 *  com.adincube.sdk.g.b.d
 *  com.adincube.sdk.g.b.e.b.b
 *  com.adincube.sdk.g.b.f
 *  com.adincube.sdk.g.b.g
 *  com.adincube.sdk.g.b.g$a
 *  com.adincube.sdk.g.b.h
 *  com.adincube.sdk.g.b.i
 *  com.adincube.sdk.g.b.j
 *  com.adincube.sdk.g.b.j$b
 *  com.adincube.sdk.g.b.k
 *  com.adincube.sdk.g.c
 *  com.adincube.sdk.h.b.b
 *  com.adincube.sdk.h.b.c
 *  com.adincube.sdk.h.c.a
 *  com.adincube.sdk.h.c.b
 *  com.adincube.sdk.h.c.d
 *  com.adincube.sdk.h.c.e
 *  com.adincube.sdk.h.c.f
 *  com.adincube.sdk.h.g
 *  com.adincube.sdk.j.h
 *  java.lang.Boolean
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.List
 *  java.util.Locale
 *  org.json.JSONObject
 */
package com.adincube.sdk.g.b;

import android.content.Context;
import com.adincube.sdk.g.b;
import com.adincube.sdk.g.b.a;
import com.adincube.sdk.g.b.c.d;
import com.adincube.sdk.g.b.c.e;
import com.adincube.sdk.g.b.c.l;
import com.adincube.sdk.g.b.c.m;
import com.adincube.sdk.g.b.c.n;
import com.adincube.sdk.g.b.f;
import com.adincube.sdk.g.b.g;
import com.adincube.sdk.g.b.h;
import com.adincube.sdk.g.b.i;
import com.adincube.sdk.g.b.j;
import com.adincube.sdk.g.b.k;
import com.adincube.sdk.g.c;
import com.adincube.sdk.util.ErrorReportingHelper;
import com.adincube.sdk.util.o;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

public abstract class a
implements com.adincube.sdk.g.b.c.j,
n,
j.b {
    protected h a;
    protected com.adincube.sdk.g.b.e.b.b b;
    public j c;
    public m d;
    public f e;
    protected g f;
    public b g;
    public com.adincube.sdk.g.g.d h;
    public com.adincube.sdk.g.a i;
    public c j;
    public com.adincube.sdk.util.e.b k;
    public com.adincube.sdk.g.b.d l;
    public com.adincube.sdk.h.c.d m = null;
    public boolean n = false;
    private i o;
    private k p;
    private long q = 0L;
    private boolean r = false;
    private final com.adincube.sdk.mediation.g s = new com.adincube.sdk.mediation.g(){

        @Override
        public final void a(com.adincube.sdk.mediation.b b2, JSONObject jSONObject) {
            com.adincube.sdk.h.c.e e22;
            com.adincube.sdk.h.c.d d2;
            block3 : {
                d2 = a.this.m;
                if (d2 == null) {
                    return;
                }
                for (com.adincube.sdk.h.c.e e22 : d2.d) {
                    if (e22.f != b2) continue;
                    break block3;
                }
                e22 = null;
            }
            if (e22 == null) {
                return;
            }
            e22.c = jSONObject;
            a.this.b.a(a.this.b(), d2);
        }
    };

    public a(com.adincube.sdk.g.a a2, com.adincube.sdk.util.e.b b2, com.adincube.sdk.g.b.d d2, h h2, com.adincube.sdk.g.b.e.b.b b3, j j2, m m2, f f2, g g2, com.adincube.sdk.g.g.d d3, k k2) {
        this.a = h2;
        this.b = b3;
        this.c = j2;
        this.d = m2;
        this.e = f2;
        this.f = g2;
        this.h = d3;
        this.p = k2;
        this.i = a2;
        this.k = b2;
        this.l = d2;
        this.j = new c(this.a());
        this.g = new b(a2, this.j);
        this.o = new i(this.a(), g2);
        j2.a((j.b)this);
    }

    private void f(com.adincube.sdk.h.c.d d2) {
        this.m = d2;
        this.b.a(this.b(), d2);
    }

    private void g(com.adincube.sdk.h.c.d d2) {
        if (d2 != null) {
            if (d2.b()) {
                return;
            }
            if (!this.p.b()) {
                return;
            }
            com.adincube.sdk.h.g g2 = this.p.c();
            for (com.adincube.sdk.h.c.e e2 : d2.d) {
                try {
                    e2.f.f().a(g2);
                }
                catch (Throwable throwable) {
                    Object[] arrobject = new Object[]{e2.a};
                    com.adincube.sdk.util.a.c("Error catched while updating user information for network '%s'. Mediation will continue without.", arrobject);
                    ErrorReportingHelper.report("AbstractNetworkMediationManager.updateUserInformationForNetworkOrder", e2.a, d2.a, this.b(), throwable);
                }
            }
        }
    }

    public abstract com.adincube.sdk.h.c.b a();

    public abstract com.adincube.sdk.mediation.b a(boolean var1, com.adincube.sdk.mediation.i var2, Context var3);

    public final void a(com.adincube.sdk.h.c.d d2, com.adincube.sdk.h.c.e e2) {
        com.adincube.sdk.h.b.b b2 = this.i.a(true, true);
        if (!b2.P.contains((Object)e2.a)) {
            c c2 = this.j;
            Object[] arrobject = new Object[]{e2.a, c2.a};
            com.adincube.sdk.j.h h2 = new com.adincube.sdk.j.h();
            h2.a = c2.a;
            h2.b = c2.b;
            h2.c = d2.b;
            h2.j = e2.a;
            h2.k();
        }
        if (b2.N.contains((Object)e2.a)) {
            Object[] arrobject = new Object[]{e2.a};
            com.adincube.sdk.util.a.b("Network '%s' reported to be loaded but was not. Deactivating network until app relaunch.", arrobject);
            this.e.a(e2.a);
            return;
        }
        Object[] arrobject = new Object[]{e2.a};
        com.adincube.sdk.util.a.b("Network '%s' reported to be loaded but was not. Mediation will continue.", arrobject);
    }

    public final void a(com.adincube.sdk.h.c.d d2, com.adincube.sdk.mediation.b b2) {
        if (d2 != null) {
            if (d2.f != null) {
                d2.f.a(null);
                d2.f.l();
            }
            d2.f = null;
            for (com.adincube.sdk.h.c.e e2 : d2.d) {
                if (e2.f != b2) {
                    this.a(e2.f);
                }
                e2.e = null;
                e2.c = null;
                e2.f = null;
            }
        }
        this.f(null);
    }

    public final void a(com.adincube.sdk.h.c.d d2, List<com.adincube.sdk.h.c.e> list) {
        com.adincube.sdk.h.b.b b2 = this.i.a(true, true);
        StringBuilder stringBuilder = new StringBuilder();
        for (com.adincube.sdk.h.c.e e2 : list) {
            d2.f.b(e2).a(e.l);
            if (!b2.O.contains((Object)e2.a)) {
                this.e.a(e2.a);
            }
            if (stringBuilder.length() > 0) {
                stringBuilder.append(", ");
            }
            Locale locale = Locale.US;
            Object[] arrobject = new Object[]{e2.a};
            stringBuilder.append(String.format((Locale)locale, (String)"'%s'", (Object[])arrobject));
        }
        com.adincube.sdk.util.a.b("Networks %s were detected loaded but were not. Deactivating networks until app relaunch.", new Object[]{stringBuilder});
    }

    /*
     * Exception decompiling
     */
    public final void a(com.adincube.sdk.h.c.d var1_1, boolean var2_2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
        // org.benf.cfr.reader.b.a.a.j.b(Op04StructuredStatement.java:409)
        // org.benf.cfr.reader.b.a.a.j.d(Op04StructuredStatement.java:487)
        // org.benf.cfr.reader.b.a.a.i.a(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:692)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:919)
        throw new IllegalStateException("Decompilation failed");
    }

    public final void a(com.adincube.sdk.h.c.e e2) {
        Object[] arrobject = new Object[]{e2.b(), e2.e.a(this.a()), e2.c};
    }

    public final void a(com.adincube.sdk.h.c.e e2, e e3) {
        Object[] arrobject = new Object[2];
        arrobject[0] = e2.b();
        int n2 = 1;
        arrobject[n2] = e3;
        g g2 = this.f;
        com.adincube.sdk.h.c.b b2 = this.a();
        com.adincube.sdk.mediation.f f2 = e2.f.b();
        Integer n3 = f2 != null ? f2.b : null;
        String string = e2.b();
        if (e3 == e.c || e3 == e.d) {
            g.a a2 = new g.a();
            a2.a = string;
            a2.b = b2;
            a2.c = n3;
            if (e3 != e.d) {
                n2 = 0;
            }
            a2.d = n2;
            a2.e = System.currentTimeMillis();
            g2.a(a2);
        }
    }

    public final void a(com.adincube.sdk.mediation.b b2) {
        if (b2 == null) {
            return;
        }
        this.d.a(this.a(), b2.f().f());
        b2.a((com.adincube.sdk.mediation.a)null);
        this.b(b2);
        try {
            b2.e();
            return;
        }
        catch (Throwable throwable) {
            Object[] arrobject = new Object[]{b2.f().f(), throwable};
            com.adincube.sdk.util.a.c("Error caught while dismissing network '%s'. Mediation will continue.", arrobject);
            ErrorReportingHelper.report("AbstractNetworkMediationManager.dismissMediationAdapter", b2.f().f(), this.a(), this.b(), throwable);
            return;
        }
    }

    public final void a(boolean bl, com.adincube.sdk.d.a.c c2) {
        this.l.a(bl, c2);
    }

    protected boolean a(com.adincube.sdk.h.c.d d2) {
        return com.adincube.sdk.h.c.d.a((com.adincube.sdk.h.c.d)d2) && d2.f.p();
    }

    protected boolean a(com.adincube.sdk.h.c.d d2, com.adincube.sdk.h.b.b b2) {
        return this.b(d2, b2);
    }

    public abstract com.adincube.sdk.h.c.a b();

    protected final void b(com.adincube.sdk.h.c.d d2) {
        this.a(d2, (com.adincube.sdk.mediation.b)null);
        this.f();
    }

    public abstract void b(com.adincube.sdk.mediation.b var1);

    protected final boolean b(com.adincube.sdk.h.c.d d2, com.adincube.sdk.h.b.b b2) {
        if (d2.f.j()) {
            long l2;
            long l3;
            boolean bl = b2 != null && ((l2 = System.currentTimeMillis()) < (l3 = this.q) || l2 > l3 + b2.v);
            if (bl) {
                this.b(d2);
                return true;
            }
            this.d();
        }
        return false;
    }

    public com.adincube.sdk.g.b.c.i c(com.adincube.sdk.h.c.d d2, com.adincube.sdk.h.b.b b2) {
        d d3 = new d(d2, (com.adincube.sdk.g.b.c.k)new l(this.a(), this.b()), this.h, (com.adincube.sdk.g.b.c.j)this, this.d, b2.i, b2.b(this.a()), b2.l);
        d3.a((n)this);
        return d3;
    }

    public void c() {
        if (this.n) {
            return;
        }
        this.r = true;
        com.adincube.sdk.h.c.d d2 = this.m;
        if (d2 == null && (d2 = this.b.a(this.b())) != null && d2.g) {
            d2 = null;
        }
        if (this.a(d2)) {
            this.l.a(d2.b);
            return;
        }
        this.a(d2, true);
    }

    public final void c(com.adincube.sdk.h.c.d d2) {
        o.a("AbstractNetworkMediationManager.onNextNetworkOrderReceived", (Runnable)new 1(this, d2));
    }

    protected void d() {
    }

    public final void d(com.adincube.sdk.h.c.d d2) {
        this.l.a(d2.b);
        this.q = 0L;
    }

    public abstract Context e();

    public void e(com.adincube.sdk.h.c.d d2) {
        this.q = System.currentTimeMillis();
    }

    public abstract void f();

    public void g() {
        com.adincube.sdk.h.c.d d2 = this.i();
        if (d2.c().a() == null) {
            this.g.b(this.h(), d2);
            if (d2.f != null && d2.f.j()) {
                this.g.a(this.h(), d2);
                throw new com.adincube.sdk.d.a.m();
            }
            throw new com.adincube.sdk.d.a.h();
        }
    }

    public abstract com.adincube.sdk.h.b.c h();

    public final com.adincube.sdk.h.c.d i() {
        com.adincube.sdk.h.c.d d2 = this.m;
        if (d2 == null) {
            if (!this.c.b()) {
                if (!this.c.c()) {
                    this.j();
                    this.k();
                    return d2;
                }
                throw this.c.d();
            }
            throw new com.adincube.sdk.d.a.h();
        }
        return d2;
    }

    public void j() {
        if (!this.r) {
            return;
        }
        throw new com.adincube.sdk.d.a.o();
    }

    public abstract void k();

    public final String l() {
        com.adincube.sdk.h.c.d d2 = this.m;
        if (d2 == null) {
            return null;
        }
        com.adincube.sdk.g.b.c.i i2 = d2.f;
        if (i2 != null && !i2.m()) {
            if (!i2.p()) {
                return null;
            }
            com.adincube.sdk.h.c.e e2 = i2.a(e.c);
            if (e2 == null) {
                return null;
            }
            return e2.b();
        }
        return null;
    }

    public void m() {
        this.n = true;
        this.a(this.m, (com.adincube.sdk.mediation.b)null);
        this.c.a();
    }

}

