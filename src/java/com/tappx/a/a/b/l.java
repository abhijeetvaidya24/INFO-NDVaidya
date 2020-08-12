/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  java.lang.Object
 *  java.lang.String
 */
package com.tappx.a.a.b;

import android.content.Context;
import android.view.View;
import com.tappx.a.a.a.a.b;
import com.tappx.a.a.a.c.a;
import com.tappx.a.a.b.k;
import com.tappx.a.a.b.o;
import com.tappx.a.a.b.s;

public class l
implements k {
    private k.b a;
    private final Context b;
    private o c;
    private o.b d = new o.b(){

        @Override
        public void a() {
            a.e("xhf99ytwwl8bVeOsPAy3pg", new Object[0]);
            if (l.this.a != null) {
                l.this.a.a((View)l.this.c);
            }
        }

        @Override
        public void b() {
            a.e("EO6JnLxOUsi6kIdAfPMA//Kib626NzkhHKkXIfYGxxc", new Object[0]);
            if (l.this.a != null) {
                l.this.a.a();
            }
        }

        @Override
        public void c() {
            if (l.this.a != null) {
                l.this.a.c();
            }
        }
    };

    l(Context context) {
        this.b = context;
    }

    private boolean a(k.a a2) {
        if (a2 == null) {
            return false;
        }
        return a2.a();
    }

    @Override
    public View a(s s2, String string, k.a a2) {
        a.e("h0fTNqXwKZ+DG4kdf/GC5w", new Object[0]);
        this.c = new o(this.b, this.a(a2));
        this.c.setListener(this.d);
        if (s2 == s.a || b.a) {
            this.c.a();
        }
        this.c.a(string);
        return this.c;
    }

    @Override
    public void a() {
        o o2 = this.c;
        if (o2 != null) {
            o2.setListener(null);
            this.c.destroy();
        }
    }

    @Override
    public void a(k.b b2) {
        this.a = b2;
    }

    @Override
    public void a(boolean bl) {
    }

    @Override
    public void b() {
    }

}

