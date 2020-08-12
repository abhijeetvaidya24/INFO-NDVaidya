/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.security.cert.X509Certificate
 *  java.util.concurrent.atomic.AtomicInteger
 */
package com.yandex.metrica.impl.ob;

import java.security.cert.X509Certificate;
import java.util.concurrent.atomic.AtomicInteger;

public class ff {
    private static final AtomicInteger a = new AtomicInteger(0);
    private X509Certificate[] b;
    private boolean c;

    ff(X509Certificate[] arrx509Certificate) {
        a.incrementAndGet();
        this.b = arrx509Certificate;
        this.c = false;
    }

    public X509Certificate[] a() {
        return (X509Certificate[])this.b.clone();
    }

    public boolean b() {
        return this.c;
    }

    void c() {
        this.c = true;
    }
}

