/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 */
package com.yandex.metrica.impl.ob;

public class cw {
    private final String a;
    private final boolean b;

    public cw(String string2, boolean bl2) {
        this.a = string2;
        this.b = bl2;
    }

    public boolean a() {
        return this.b;
    }

    public String b() {
        return this.a;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null) {
            if (this.getClass() != object.getClass()) {
                return false;
            }
            cw cw2 = (cw)object;
            if (this.b != cw2.b) {
                return false;
            }
            return this.a.equals((Object)cw2.a);
        }
        return false;
    }

    public int hashCode() {
        return 31 * this.a.hashCode() + this.b;
    }
}

