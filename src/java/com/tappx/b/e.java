/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.tappx.b;

import com.tappx.b.r;
import com.tappx.b.u;

public class e
implements r {
    public static final int a = 2500;
    public static final int b = 1;
    public static final float c = 1.0f;
    private int d;
    private int e;
    private final int f;
    private final float g;

    public e() {
        this(2500, 1, 1.0f);
    }

    public e(int n2, int n3, float f2) {
        this.d = n2;
        this.f = n3;
        this.g = f2;
    }

    @Override
    public int a() {
        return this.d;
    }

    @Override
    public void a(u u2) {
        this.e = 1 + this.e;
        int n2 = this.d;
        this.d = (int)((float)n2 + (float)n2 * this.g);
        if (this.d()) {
            return;
        }
        throw u2;
    }

    @Override
    public int b() {
        return this.e;
    }

    public float c() {
        return this.g;
    }

    protected boolean d() {
        return this.e <= this.f;
    }
}

