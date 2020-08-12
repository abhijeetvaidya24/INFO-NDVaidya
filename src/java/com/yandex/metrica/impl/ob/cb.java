/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.bq;
import com.yandex.metrica.impl.ob.dk;

public abstract class cb {
    private final bq a;
    private final String b;

    static {
        cb.class.getSimpleName();
    }

    public cb(bq bq2) {
        this(bq2, null);
    }

    public cb(bq bq2, String string2) {
        this.a = bq2;
        this.b = string2;
        this.f();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected <T extends cb> T a(String string2, int n2) {
        cb cb2 = this;
        synchronized (cb2) {
            this.a.b(string2, n2);
            return (T)this;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected <T extends cb> T a(String string2, long l2) {
        cb cb2 = this;
        synchronized (cb2) {
            this.a.b(string2, l2);
            return (T)this;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected <T extends cb> T a(String string2, String string3) {
        cb cb2 = this;
        synchronized (cb2) {
            this.a.b(string2, string3);
            return (T)this;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected <T extends cb> T a(String string2, boolean bl2) {
        cb cb2 = this;
        synchronized (cb2) {
            this.a.b(string2, bl2);
            return (T)this;
        }
    }

    int b(String string2, int n2) {
        return this.a.a(string2, n2);
    }

    long b(String string2, long l2) {
        return this.a.a(string2, l2);
    }

    String b(String string2, String string3) {
        return this.a.a(string2, string3);
    }

    boolean b(String string2, boolean bl2) {
        return this.a.a(string2, bl2);
    }

    protected void f() {
    }

    public String g() {
        return this.b;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void h() {
        cb cb2 = this;
        synchronized (cb2) {
            this.a.b();
            return;
        }
    }

    protected dk q(String string2) {
        return new dk(string2, this.g());
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected <T extends cb> T r(String string2) {
        cb cb2 = this;
        synchronized (cb2) {
            this.a.a(string2);
            return (T)this;
        }
    }
}

