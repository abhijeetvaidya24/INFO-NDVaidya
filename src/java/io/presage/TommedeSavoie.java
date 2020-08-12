/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package io.presage;

public final class TommedeSavoie {
    private final boolean a;
    private boolean b;
    private final String c;
    private boolean d;
    private boolean e;
    private boolean f;

    private TommedeSavoie(boolean bl2, boolean bl3, String string2, boolean bl4) {
        this.a = bl2;
        this.b = bl3;
        this.c = string2;
        this.d = bl4;
        this.e = false;
        this.f = false;
    }

    public /* synthetic */ TommedeSavoie(boolean bl2, boolean bl3, String string2, boolean bl4, int n2) {
        if ((n2 & 8) != 0) {
            bl4 = false;
        }
        this(bl2, bl3, string2, bl4);
    }

    public final boolean a() {
        return this.a;
    }

    public final boolean b() {
        return this.b;
    }

    public final String c() {
        return this.c;
    }

    public final boolean d() {
        return this.d;
    }

    public final void e() {
        this.d = true;
    }

    public final boolean f() {
        return this.e;
    }

    public final void g() {
        this.e = true;
    }

    public final boolean h() {
        return this.f;
    }

    public final void i() {
        this.f = true;
    }
}

