/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.security.cert.X509Certificate
 *  java.util.List
 */
package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.fj;
import java.security.cert.X509Certificate;
import java.util.List;

public class fd {
    private fj a;
    private boolean b = true;
    private boolean c = false;
    private long d = 86400000L;
    private String e = "https://certificate.mobile.yandex.net/api/v1/pins";
    private List<X509Certificate> f;

    fd() {
    }

    public fd(fj fj2) {
        this.a = fj2;
    }

    public fd(fj fj2, boolean bl2, boolean bl3) {
        this(fj2);
        this.b = bl2;
        this.c = bl3;
    }

    long a() {
        return this.d;
    }

    public void a(String string2, List<X509Certificate> list) {
        this.e = string2;
        this.f = list;
    }

    String b() {
        return this.e;
    }

    List<X509Certificate> c() {
        return this.f;
    }

    fj d() {
        return this.a;
    }

    boolean e() {
        return this.c;
    }

    boolean f() {
        return this.b;
    }
}

