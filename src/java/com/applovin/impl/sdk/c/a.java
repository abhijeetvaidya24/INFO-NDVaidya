/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.applovin.impl.sdk.c;

public class a {
    private final String a;
    private final String b;

    public a(String string2, String string3) {
        this.a = string2;
        this.b = string3;
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[AdEventPostback url=");
        stringBuilder.append(this.a);
        stringBuilder.append(", backupUrl=");
        stringBuilder.append(this.b);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

