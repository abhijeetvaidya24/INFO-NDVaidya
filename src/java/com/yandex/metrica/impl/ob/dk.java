/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.yandex.metrica.impl.ob;

public class dk {
    private final String a;
    private final String b;

    public dk(String string2) {
        this(string2, null);
    }

    public dk(String string2, String string3) {
        this.a = string2;
        this.b = this.a(string3);
    }

    public String a() {
        return this.a;
    }

    public String a(String string2) {
        if (string2 != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.a);
            stringBuilder.append(string2);
            return stringBuilder.toString();
        }
        return this.a;
    }

    public String b() {
        return this.b;
    }
}

