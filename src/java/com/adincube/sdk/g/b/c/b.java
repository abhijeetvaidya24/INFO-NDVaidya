/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.adincube.sdk.g.b.c.a$a
 *  com.adincube.sdk.g.b.c.e
 *  com.adincube.sdk.g.b.c.h
 *  com.adincube.sdk.g.b.c.i
 *  com.adincube.sdk.g.b.c.j
 *  com.adincube.sdk.g.b.c.k
 *  com.adincube.sdk.g.b.c.k$a
 *  com.adincube.sdk.g.b.c.n
 *  com.adincube.sdk.g.b.c.q
 *  com.adincube.sdk.g.g.e
 *  com.adincube.sdk.h.c.d
 *  com.adincube.sdk.h.c.e
 *  com.adincube.sdk.h.f.a
 *  com.adincube.sdk.h.f.c
 *  com.adincube.sdk.h.f.d
 *  com.adincube.sdk.h.f.e
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 */
package com.adincube.sdk.g.b.c;

import android.content.Context;
import com.adincube.sdk.g.b.c.a;
import com.adincube.sdk.g.b.c.e;
import com.adincube.sdk.g.b.c.h;
import com.adincube.sdk.g.b.c.i;
import com.adincube.sdk.g.b.c.j;
import com.adincube.sdk.g.b.c.k;
import com.adincube.sdk.g.b.c.n;
import com.adincube.sdk.g.b.c.q;
import com.adincube.sdk.h.f.c;
import com.adincube.sdk.h.f.d;
import com.adincube.sdk.mediation.f;
import com.adincube.sdk.util.ErrorReportingHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

abstract class b<T extends h>
implements i,
com.adincube.sdk.g.g.e {
    protected com.adincube.sdk.h.c.d a;
    protected k b;
    protected boolean c;
    protected final a.a d = new a.a(){

        public final void a(com.adincube.sdk.h.c.e e2) {
            Object t2 = b.this.b(e2);
            b.this.a(e2, t2.e());
        }
    };
    protected final k.a e = new k.a(){

        public final void a(com.adincube.sdk.h.c.e e2) {
            Object t2 = b.this.b(e2);
            t2.a(e.f);
            b.this.a(e2, t2.e());
        }
    };
    private long f;
    private Map<com.adincube.sdk.h.c.e, T> g = new HashMap();
    private int h;
    private int i;
    private long j;
    private n k;
    private boolean l = false;
    private boolean m = false;
    private j n;
    private com.adincube.sdk.g.g.d o;
    private q p;

    public b(com.adincube.sdk.h.c.d d2, k k2, com.adincube.sdk.g.g.d d3, j j2, int n2, int n3, long l2) {
        this.b = k2;
        this.f = System.currentTimeMillis();
        com.adincube.sdk.g.g.d d4 = this.o = d3;
        if (d4 != null) {
            d4.a(this);
        }
        this.p = new q(j2, d3);
        this.a = d2;
        this.n = j2;
        this.h = n2;
        this.i = n3;
        this.j = l2;
        this.b = k2;
        this.b.a((i)this);
        this.b.a(this.e);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected static void a(com.adincube.sdk.h.c.e e2) {
        com.adincube.sdk.mediation.c c2 = e2.f.f().b();
        if (c2 != null && !c2.b) {
            com.adincube.sdk.mediation.c c3 = c2;
            synchronized (c3) {
                if (!c2.b) {
                    c2.a.run();
                    c2.b = true;
                }
                return;
            }
        }
    }

    private void a(com.adincube.sdk.h.c.e e2, e e3, e e4) {
        Iterator iterator = this.a.d.iterator();
        block0 : do {
            boolean bl = false;
            while (iterator.hasNext()) {
                T t2;
                com.adincube.sdk.h.c.e e5 = (com.adincube.sdk.h.c.e)iterator.next();
                if (!bl) {
                    if (e5 != e2) continue block0;
                    bl = true;
                    continue;
                }
                if (!e5.a.equals((Object)e2.a) || (t2 = this.b(e5)).e() != e3) continue;
                t2.a(e4);
                this.a(e5, t2.e());
            }
            break;
        } while (true);
    }

    private void s() {
        if (!this.l && !this.m) {
            this.l = true;
            n n2 = this.k;
            if (n2 != null) {
                n2.d(this.a);
            }
        }
    }

    private void t() {
        if (!this.l && !this.m) {
            this.m = true;
            n n2 = this.k;
            if (n2 != null) {
                n2.e(this.a);
            }
        }
    }

    public com.adincube.sdk.h.c.e a(e e2) {
        Iterator iterator = this.f().iterator();
        com.adincube.sdk.h.c.e e3 = null;
        while (iterator.hasNext() && e3 == null) {
            com.adincube.sdk.h.c.e e4 = (com.adincube.sdk.h.c.e)iterator.next();
            if (this.b(e4).e() != e2) continue;
            e3 = e4;
        }
        return e3;
    }

    public void a() {
        b b2 = this;
        synchronized (b2) {
            block9 : {
                block8 : {
                    if (this.f().isEmpty()) {
                        this.t();
                        return;
                    }
                    boolean bl = this.m();
                    if (!bl) break block8;
                    return;
                }
                boolean bl = this.b();
                if (!bl) break block9;
                return;
            }
            try {
                if (!this.b.a()) {
                    this.b.b();
                }
                this.d();
                this.c();
                Iterator iterator = this.e().iterator();
                while (iterator.hasNext()) {
                    this.d((com.adincube.sdk.h.c.e)iterator.next());
                }
                return;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    public void a(n n2) {
        this.k = n2;
    }

    final void a(com.adincube.sdk.h.c.e e2, e e3) {
        n n2;
        this.b.a(e2);
        this.b(e2, e3);
        if (!this.m() && (n2 = this.k) != null) {
            n2.a(e2, this.b(e2).e());
            if (this.p()) {
                this.s();
            } else if (this.k()) {
                this.t();
            }
        }
        this.a();
    }

    protected final void a(com.adincube.sdk.h.c.e e2, h h2) {
        com.adincube.sdk.mediation.aa.c c2;
        q q2 = this.p;
        if (q2.b != null && e2.e.a.a() && (c2 = q.a((com.adincube.sdk.h.c.e)e2)) != null) {
            if (c2.a()) {
                com.adincube.sdk.h.f.a a2 = q2.b.b();
                Object[] arrobject = new Object[]{a2.a, a2.b, e2.b()};
                Context context = q2.a.e();
                q.a((com.adincube.sdk.h.c.e)e2).a(context, a2.a);
                h2.e = a2;
                return;
            }
            com.adincube.sdk.h.f.e e3 = q2.b.a(e2.a);
            Context context = q2.a.e();
            if (e2.f.b() != null && e2.f.b().d) {
                new Object[1][0] = e2.b();
                e3 = new com.adincube.sdk.h.f.e(d.d, "Overridden");
            } else {
                Object[] arrobject = new Object[]{e3.a.f, e3.b, e2.b()};
            }
            q.a((com.adincube.sdk.h.c.e)e2).a(context, e3.a);
            h2.d = e3;
        }
    }

    public T b(com.adincube.sdk.h.c.e e2) {
        b b2 = this;
        synchronized (b2) {
            Object object;
            block4 : {
                object = (h)this.g.get((Object)e2);
                if (object != null) break block4;
                object = this.c(e2);
                this.g.put((Object)e2, object);
            }
            return (T)object;
        }
    }

    protected void b(com.adincube.sdk.h.c.e e2, e e3) {
        if (e3 == e.f) {
            this.a(e2, e.a, e.g);
            return;
        }
        if (e3 != e.g) {
            this.a(e2, e.g, e.a);
        }
    }

    abstract boolean b();

    protected abstract T c(com.adincube.sdk.h.c.e var1);

    public void c() {
    }

    /*
     * Exception decompiling
     */
    public void d() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Statement already marked as first in another block
        // org.benf.cfr.reader.b.a.a.i.b(Op03SimpleStatement.java:414)
        // org.benf.cfr.reader.b.a.a.b.ad.a(Misc.java:226)
        // org.benf.cfr.reader.b.a.a.b.l.a(ConditionalRewriter.java:623)
        // org.benf.cfr.reader.b.a.a.b.l.a(ConditionalRewriter.java:52)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:576)
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

    abstract void d(com.adincube.sdk.h.c.e var1);

    protected abstract List<com.adincube.sdk.h.c.e> e();

    protected final void e(com.adincube.sdk.h.c.e e2) {
        n n2 = this.k;
        if (n2 != null) {
            n2.a(e2);
        }
    }

    protected List<com.adincube.sdk.h.c.e> f() {
        return this.a.d;
    }

    protected final void f(com.adincube.sdk.h.c.e e2) {
        j j2 = this.n;
        if (j2 == null) {
            return;
        }
        Context context = j2.e();
        if (context == null) {
            return;
        }
        com.adincube.sdk.mediation.i i2 = e2.f.f();
        if (i2 == null) {
            return;
        }
        i2.a(context);
    }

    public int g() {
        int n2;
        int n3;
        int n4;
        int n5 = (int)((System.currentTimeMillis() - this.f) / this.j);
        if (n5 < 0) {
            n5 = 0;
        }
        if ((n3 = (n4 = this.h) + n5) > (n2 = this.i)) {
            return n2;
        }
        return n4 + n5;
    }

    protected final void g(com.adincube.sdk.h.c.e e2) {
        n n2 = this.k;
        if (n2 != null) {
            n2.a(this.a, e2);
        }
    }

    public boolean h() {
        T t2;
        com.adincube.sdk.h.c.e e2;
        Iterator iterator = this.f().iterator();
        while (iterator.hasNext() && !(t2 = this.b(e2 = (com.adincube.sdk.h.c.e)iterator.next())).c()) {
            boolean bl;
            if (t2.d()) {
                return false;
            }
            if (!t2.b()) continue;
            try {
                bl = e2.f.d();
            }
            catch (Throwable throwable) {
                StringBuilder stringBuilder = new StringBuilder("Cannot check if network '");
                stringBuilder.append(e2.b());
                stringBuilder.append("' has been properly loaded. Mediation will continue");
                com.adincube.sdk.util.a.c(stringBuilder.toString(), new Object[]{throwable});
                ErrorReportingHelper.report("AbstractNetworkOrderLoader.isFirstNetworkBeenLoadedAndNoMoreLoaded", throwable);
                bl = false;
            }
            if (bl) break;
            return true;
        }
        return false;
    }

    final boolean i() {
        ArrayList arrayList = new ArrayList();
        for (com.adincube.sdk.h.c.e e2 : this.f()) {
            T t2 = this.b(e2);
            if (arrayList.contains((Object)e2.a)) continue;
            if (t2.e() == e.l) {
                arrayList.add((Object)e2.a);
            }
            if (!t2.e().n) {
                return false;
            }
            if (t2.e() != e.f) continue;
            return false;
        }
        return true;
    }

    public boolean j() {
        ArrayList arrayList = new ArrayList();
        for (com.adincube.sdk.h.c.e e2 : this.f()) {
            T t2 = this.b(e2);
            if (arrayList.contains((Object)e2.a)) continue;
            if (t2.e() == e.l) {
                arrayList.add((Object)e2.a);
            }
            if (t2.e().n) continue;
            return false;
        }
        return true;
    }

    protected boolean k() {
        return this.i();
    }

    public void l() {
        this.c = true;
        this.b.c();
        com.adincube.sdk.g.g.d d2 = this.o;
        if (d2 != null) {
            d2.a.remove((Object)this);
        }
    }

    public boolean m() {
        return this.c;
    }

    public void n() {
        b b2 = this;
        synchronized (b2) {
            this.c = false;
            this.l = false;
            this.m = false;
            if (this.k()) {
                this.t();
            }
            if (this.b()) {
                this.s();
            }
            this.a();
            return;
        }
    }

    public Map<String, h> o() {
        HashMap hashMap = new HashMap();
        for (com.adincube.sdk.h.c.e e2 : this.f()) {
            T t2 = this.b(e2);
            h h2 = (h)hashMap.get((Object)e2.a);
            if (h2 != null) {
                e e3 = t2.e();
                e e4 = h2.e();
                boolean bl = e3.o > e4.o;
                if (!bl) continue;
            }
            hashMap.put((Object)e2.a, t2);
        }
        return hashMap;
    }

    public boolean p() {
        return false;
    }

    public void q() {
    }

    public void r() {
        this.a();
    }

}

