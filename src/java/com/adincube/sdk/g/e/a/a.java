/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Date
 */
package com.adincube.sdk.g.e.a;

import com.adincube.sdk.g.e.a.a;
import com.adincube.sdk.h.a.e;
import com.adincube.sdk.h.b.b;
import com.adincube.sdk.j.b;
import com.adincube.sdk.j.d;
import com.adincube.sdk.util.f;
import com.adincube.sdk.util.n;
import java.io.File;
import java.util.Date;

public abstract class a {
    protected a a = null;
    private com.adincube.sdk.g.a b = com.adincube.sdk.g.a.a();
    private d.a c = new d.a(this){
        final /* synthetic */ a a;
        {
            this.a = a2;
        }

        public final void a(com.adincube.sdk.h.a.a.a a2) {
            this.a.c(a2);
        }
    };
    private b.a d = new b.a(this){
        final /* synthetic */ a a;
        {
            this.a = a2;
        }

        public final void a(com.adincube.sdk.j.b b2) {
        }
    };

    protected a() {
    }

    public static boolean a(com.adincube.sdk.h.a.a.a a2) {
        if (a2.b()) {
            return f.a().getFileStreamPath(n.b(a2)).exists();
        }
        return true;
    }

    public final void a(a a2) {
        this.a = a2;
    }

    public abstract void a(e var1);

    public final boolean b(com.adincube.sdk.h.a.a.a a2) {
        new Object[1][0] = a2.a();
        if (a2.b()) {
            if (a.a(a2)) {
                new Object[1][0] = a2.a();
                File file = f.a().getFileStreamPath(n.b(a2));
                if (file.exists()) {
                    file.setLastModified(new Date().getTime());
                }
                return false;
            }
            d d2 = new d();
            d2.a = a2;
            d2.d = a2.a.u;
            d2.b = this.c;
            d2.a(this.d);
            b b2 = this.b.a(true, true);
            Integer n2 = b2.T;
            d2.f = n2 != null && n2 > 0 ? n2 : 15000;
            Integer n3 = b2.U;
            d2.g = n3 != null && n3 > 0 ? n3 : 15000;
            d2.a(b2.V);
            d2.k();
            return true;
        }
        new Object[1][0] = a2.a();
        return false;
    }

    public abstract boolean b(e var1);

    public abstract void c(com.adincube.sdk.h.a.a.a var1);

    public static interface a {
        public void a();

        public void a(Exception var1);

        public void b();
    }

}

