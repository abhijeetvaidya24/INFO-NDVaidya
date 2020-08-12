/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.tappx.a.a.a;

public class n<E> {
    private volatile E a;
    private final a<E> b;

    public n(a<E> a2) {
        this.b = a2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public E a() {
        E e2 = this.a;
        if (e2 != null) {
            return e2;
        }
        n n2 = this;
        synchronized (n2) {
            E e3 = this.a;
            if (e3 == null) {
                e3 = this.a = this.b.b();
            }
            return e3;
        }
    }

    public static interface a<E> {
        public E b();
    }

}

