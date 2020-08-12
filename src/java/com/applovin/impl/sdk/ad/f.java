/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.applovin.impl.sdk.ad;

public class f {
    private final String a;
    private final boolean b;

    public f(String string2, boolean bl) {
        this.a = string2;
        this.b = bl;
    }

    public String a() {
        return this.a;
    }

    public boolean b() {
        return this.b;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("BidToken{mBase64EncodedId='");
        stringBuilder.append(this.a);
        stringBuilder.append('\'');
        stringBuilder.append(", mIsIdfaCollected=");
        stringBuilder.append(this.b);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

