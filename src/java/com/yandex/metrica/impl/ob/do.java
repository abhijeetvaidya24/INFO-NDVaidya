/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.yandex.metrica.impl.ob;

public class do {
    protected int a = 0;
    private final int b;
    private boolean c;

    public do(int n2) {
        this.b = n2;
    }

    public void a() {
        this.a = 1 + this.a;
        this.c = false;
    }

    public boolean b() {
        return this.c && this.a < this.b;
    }

    public void c() {
        this.c = true;
    }
}

