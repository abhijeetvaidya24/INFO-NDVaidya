/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Class
 *  java.lang.ClassCastException
 *  java.lang.Object
 *  java.lang.String
 */
package com.tappx.a.a.a.d;

import android.content.Context;
import com.tappx.a.a.a.a.a;
import com.tappx.a.a.a.d.ad;
import com.tappx.a.a.a.e.h;

public abstract class t<T extends com.tappx.a.a.a.e.b>
implements ad.a {
    private final com.tappx.a.a.a.i.a.a a;
    private final ad b;
    private T c;
    private boolean d;
    private t<T> e;

    protected t(com.tappx.a.a.a.i.a.a a2) {
        this(a2, new ad());
    }

    protected t(com.tappx.a.a.a.i.a.a a2, ad ad2) {
        this.a = a2;
        this.b = ad2;
        ad2.a(this);
    }

    protected long a(T t2) {
        return 15000L;
    }

    public abstract void a();

    protected void a(long l2) {
        if (l2 < a.a.c) {
            Object[] arrobject = new Object[]{l2};
            com.tappx.a.a.a.c.a.e("tJ/RDdwmde5sNRNl2OtVTfCw4OuAfiMIPu/zkSLGIT2zwNm3C7thqGQX04tsdosL", arrobject);
            l2 = a.a.c;
        } else if (l2 > a.a.d) {
            Object[] arrobject = new Object[]{l2};
            com.tappx.a.a.a.c.a.e("w73w5GD8aw/6JbEwVsPDUQ", arrobject);
            l2 = a.a.d;
        }
        this.b.a(l2);
    }

    protected abstract void a(Context var1, b var2, T var3);

    public void a(boolean bl) {
        this.d = bl;
        if (bl) {
            this.b.a();
        }
    }

    protected abstract void b();

    public void b(Context context, b b2, com.tappx.a.a.a.e.b b3) {
        try {
            this.c = b3;
            this.a(false);
            this.e = new c(b2);
            this.c();
            Object[] arrobject = new Object[]{this.getClass().getSimpleName()};
            com.tappx.a.a.a.c.a.e("w73w5GD8aw/6JbEwVsPDUQ", arrobject);
            this.a(context, (Object)this.e, this.c);
            return;
        }
        catch (ClassCastException classCastException) {
            b2.a(h.d);
            return;
        }
    }

    void c() {
        this.a(this.a(this.c));
    }

    T d() {
        return this.c;
    }

    public void e() {
        this.b.a();
        this.b();
    }

    @Override
    public void f() {
        if (!this.d) {
            com.tappx.a.a.a.c.a.e("wUWo9wuOBqc42QHm8/JVjGXXMTT2DoYHEa3wguYezUW0KEhBaolGwT3KPMo6Sz+d", new Object[0]);
            t<T> t2 = this.e;
            if (t2 != null) {
                ((c)((Object)t2)).a(h.e);
            }
        }
    }

    public com.tappx.a.a.a.i.a.a g() {
        return this.a;
    }

    private class c
    implements b {
        private final b b;

        public c(b b2) {
            this.b = b2;
        }

        @Override
        public void a() {
            t.this.g().a(((com.tappx.a.a.a.e.b)t.this.d()).d());
            this.b.a();
        }

        @Override
        public void a(t t2) {
            t.this.a(true);
            this.b.a(t2);
        }

        @Override
        public void a(h h2) {
            t.this.a(true);
            this.b.a(h2);
        }

        @Override
        public void b() {
            t.this.g().a(((com.tappx.a.a.a.e.b)t.this.d()).b());
            this.b.b();
        }

        @Override
        public void c() {
            this.b.c();
        }

        @Override
        public void d() {
            this.b.d();
        }
    }

}

