/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Random
 */
package com.yandex.metrica.impl.ob;

import java.util.Random;

public class dm {
    private int a;
    private int b;
    private Random c;
    private int d;

    public dm(int n2) {
        this.a = n2 > 0 && n2 <= 31 ? n2 : 31;
        this.c = new Random();
    }

    public int a() {
        int n2 = this.b;
        if (n2 < this.a) {
            this.b = n2 + 1;
            this.d = 1 << this.b;
        }
        return this.c.nextInt(this.d);
    }
}

