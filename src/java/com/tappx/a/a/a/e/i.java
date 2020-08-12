/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.tappx.a.a.a.e;

public class i {
    private static final int a = -1;
    private static final int b = -1;
    private static final int c = 0;
    private static final int d = 120;
    private static final int e = 1900;
    private static final int f = 2100;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private int m = -1;
    private int n = -1;
    private String o;
    private String p;
    private boolean q;

    private int a(int n2, int n3, int n4, int n5) {
        boolean bl2 = n2 >= n3 && n2 <= n4;
        if (!bl2) {
            return n5;
        }
        return n2;
    }

    public String a() {
        return this.i;
    }

    public void a(int n2) {
        this.n = this.a(n2, 0, 120, -1);
    }

    public void a(String string2) {
        this.i = string2;
    }

    public void a(boolean bl2) {
        this.q = bl2;
    }

    public String b() {
        return this.h;
    }

    public void b(int n2) {
        this.m = this.a(n2, 1900, 2100, -1);
    }

    public void b(String string2) {
        this.h = string2;
    }

    public int c() {
        return this.n;
    }

    public void c(String string2) {
        this.g = string2;
    }

    public String d() {
        return this.g;
    }

    public void d(String string2) {
        this.o = string2;
    }

    public String e() {
        return this.o;
    }

    public void e(String string2) {
        this.p = string2;
    }

    public String f() {
        return this.p;
    }

    public void f(String string2) {
        this.l = string2;
    }

    public String g() {
        return this.l;
    }

    public void g(String string2) {
        this.k = string2;
    }

    public String h() {
        return this.k;
    }

    public void h(String string2) {
        this.j = string2;
    }

    public String i() {
        return this.j;
    }

    public boolean j() {
        return this.q;
    }

    public int k() {
        return this.m;
    }
}

