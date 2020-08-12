/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  java.lang.Class
 *  java.lang.ClassCastException
 *  java.lang.Object
 *  java.lang.String
 */
package com.tappx.a.a.a.d;

import android.content.Context;
import android.view.View;
import com.tappx.a.a.a.a.a;
import com.tappx.a.a.a.d.ad;
import com.tappx.a.a.a.d.c;
import com.tappx.a.a.a.e.h;

public abstract class c<T extends com.tappx.a.a.a.e.b>
implements ad.a {
    private final com.tappx.a.a.a.i.a.a a;
    private final ad b;
    private c<T> c;
    private T d;
    private boolean e;

    public c(com.tappx.a.a.a.i.a.a a2) {
        this(a2, new ad());
    }

    protected c(com.tappx.a.a.a.i.a.a a2, ad ad2) {
        this.a = a2;
        this.b = ad2;
        ad2.a(this);
    }

    protected long a(T t2) {
        return com.tappx.a.a.a.a.a.b;
    }

    public com.tappx.a.a.a.i.a.a a() {
        return this.a;
    }

    protected void a(long l2) {
        if (l2 < a.a.a) {
            Object[] arrobject = new Object[]{l2};
            com.tappx.a.a.a.c.a.e("/K518OsQwGWEySte999XTohBdjGQhBkPInQIUsTjG/cUwA8AiN+9hbf5gwErXHcf", arrobject);
            l2 = a.a.a;
        } else if (l2 > a.a.b) {
            Object[] arrobject = new Object[]{l2};
            com.tappx.a.a.a.c.a.e("wUWo9wuOBqc42QHm8/JVjGXXMTT2DoYHEa3wguYezUW0KEhBaolGwT3KPMo6Sz+d", arrobject);
            l2 = a.a.b;
        }
        this.b.a(l2);
    }

    public void a(Context context, b b2, com.tappx.a.a.a.e.b b3) {
        try {
            this.d = b3;
            this.a(false);
            this.c = new c(b2);
            this.b();
            Object[] arrobject = new Object[]{this.getClass().getSimpleName()};
            com.tappx.a.a.a.c.a.e("w73w5GD8aw/6JbEwVsPDUQ", arrobject);
            this.b(context, (Object)this.c, this.d);
            return;
        }
        catch (ClassCastException classCastException) {
            b2.a(h.d);
            return;
        }
    }

    public void a(boolean bl) {
        this.e = bl;
        if (bl) {
            this.b.a();
        }
    }

    void b() {
        this.a(this.a(this.d));
    }

    protected abstract void b(Context var1, b var2, T var3);

    protected abstract void c();

    protected void d() {
        this.b.a();
        this.c();
    }

    T e() {
        return this.d;
    }

    @Override
    public void f() {
        if (!this.e) {
            com.tappx.a.a.a.c.a.e("tJ/RDdwmde5sNRNl2OtVTfCw4OuAfiMIPu/zkSLGIT2zwNm3C7thqGQX04tsdosL", new Object[0]);
            c<T> c2 = this.c;
            if (c2 != null) {
                ((c)((Object)c2)).a(h.e);
            }
        }
    }

    private class c
    implements b {
        private final b b;

        private c(b b2) {
            this.b = b2;
        }

        @Override
        public void a() {
            this.b.a();
        }

        @Override
        public void a(View view) {
            c.this.a(true);
            this.b.a(view);
        }

        @Override
        public void a(h h2) {
            c.this.a(true);
            this.b.a(h2);
        }

        @Override
        public void b() {
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

