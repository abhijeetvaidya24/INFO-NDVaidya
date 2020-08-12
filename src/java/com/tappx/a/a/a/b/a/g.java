/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.tappx.a.a.a.b.a;

public class g<T> {
    public final T a;
    public final com.tappx.a.a.a.b.a.b b;

    private g(com.tappx.a.a.a.b.a.b b2) {
        this.a = null;
        this.b = b2;
    }

    private g(T t2) {
        this.a = t2;
        this.b = null;
    }

    public static <T> g<T> a(com.tappx.a.a.a.b.a.b b2) {
        return new g<T>(b2);
    }

    public static <T> g<T> a(T t2) {
        return new g<T>(t2);
    }

    public boolean a() {
        return this.b == null;
    }

    public static interface a {
        public void a(com.tappx.a.a.a.b.a.b var1);
    }

    public static interface b<T> {
        public void a(T var1);
    }

}

