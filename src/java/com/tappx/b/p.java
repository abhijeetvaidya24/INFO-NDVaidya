/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.tappx.b;

import com.tappx.b.b;
import com.tappx.b.u;

public class p<T> {
    public final T a;
    public final b.a b;
    public final u c;
    public boolean d = false;

    private p(u u2) {
        this.a = null;
        this.b = null;
        this.c = u2;
    }

    private p(T t2, b.a a2) {
        this.a = t2;
        this.b = a2;
        this.c = null;
    }

    public static <T> p<T> a(u u2) {
        return new p<T>(u2);
    }

    public static <T> p<T> a(T t2, b.a a2) {
        return new p<T>(t2, a2);
    }

    public boolean a() {
        return this.c == null;
    }

    public static interface a {
        public void a(u var1);
    }

    public static interface b<T> {
        public void a(T var1);
    }

}

