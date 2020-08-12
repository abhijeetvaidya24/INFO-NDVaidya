/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.fr;

public class fw {
    private int a;
    private int b;
    private final int c;
    private final float d;

    public fw() {
        this(2500, 1, 1.0f);
    }

    public fw(int n2, int n3, float f2) {
        this.a = n2;
        this.c = n3;
        this.d = f2;
    }

    public int a() {
        return this.a;
    }

    public void a(fr fr2) throws fr {
        this.b = 1 + this.b;
        int n2 = this.a;
        this.a = (int)((float)n2 + (float)n2 * this.d);
        if (this.b()) {
            return;
        }
        throw fr2;
    }

    protected boolean b() {
        return this.b <= this.c;
    }
}

