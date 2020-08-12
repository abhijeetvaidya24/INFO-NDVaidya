/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Iterator
 *  java.util.List
 */
package com.tappx.a.a.a.d;

import android.content.Context;
import com.tappx.a.a.a.c.a;
import com.tappx.a.a.a.d.ae;
import com.tappx.a.a.a.e.b;
import com.tappx.a.a.a.e.d;
import com.tappx.a.a.a.h;
import java.util.Iterator;
import java.util.List;

abstract class af
implements ae {
    private static final int a;
    private int b = 0;
    private d c;
    private Context d;

    af() {
    }

    private void a(d d2) {
        Iterator iterator = d2.a().iterator();
        String string = "{";
        while (iterator.hasNext()) {
            b b2 = (b)iterator.next();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append(b2.getClass().getSimpleName());
            stringBuilder.append(",");
            string = stringBuilder.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append("}");
        a.e("vowRFCKLTs9aEktGgLPt1r38zreZaMrbDBiCU39LXJU", stringBuilder.toString());
    }

    private void g() {
        this.a();
        if (this.c.a().size() <= this.b) {
            this.a(com.tappx.a.a.a.e.h.a);
            return;
        }
        b b2 = (b)this.c.a().get(this.b);
        this.b = 1 + this.b;
        String string = h.a("mo5jy7IL/t1GLb3J/P8gjQ");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(b2.f());
        a.a(stringBuilder.toString(), new Object[0]);
        Object[] arrobject = new Object[]{b2.f()};
        a.e("w73w5GD8aw/6JbEwVsPDUQ", arrobject);
        if (!this.a(this.d, b2)) {
            this.g();
        }
    }

    protected abstract void a();

    @Override
    public void a(Context context, d d2) {
        this.a(d2);
        this.d = context;
        this.c = d2;
        this.b = 0;
        this.g();
    }

    protected abstract void a(com.tappx.a.a.a.e.h var1);

    protected abstract boolean a(Context var1, b var2);

    protected abstract void b();

    @Override
    public void c() {
        this.a();
        this.b();
    }

    @Override
    public void d() {
        this.a();
    }

    protected void e() {
        this.g();
    }

    void f() {
    }
}

