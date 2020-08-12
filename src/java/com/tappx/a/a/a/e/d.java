/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 */
package com.tappx.a.a.a.e;

import com.tappx.a.a.a.e.b;
import java.util.ArrayList;
import java.util.List;

public class d {
    public static final int a;
    private int b = -1;
    private int c = -1;
    private int d;
    private boolean e;
    private String f;
    private final List<b> g = new ArrayList();

    public List<b> a() {
        return this.g;
    }

    public void a(int n2) {
        this.b = n2;
    }

    public void a(boolean bl2, int n2, String string2) {
        this.e = bl2;
        this.d = n2;
        this.f = string2;
    }

    public void b(int n2) {
        this.c = n2;
    }

    public boolean b() {
        return this.g.isEmpty();
    }

    public int c() {
        return this.b;
    }

    public int d() {
        return this.c;
    }

    public int e() {
        return this.d;
    }

    public boolean f() {
        return this.e;
    }

    public String g() {
        return this.f;
    }
}

