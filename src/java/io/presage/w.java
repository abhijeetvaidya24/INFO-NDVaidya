/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package io.presage;

public final class w
extends Exception {
    private final int a;

    public w(int n2) {
        StringBuilder stringBuilder = new StringBuilder("Received ");
        stringBuilder.append(n2);
        stringBuilder.append(" from the server");
        super(stringBuilder.toString());
        this.a = n2;
    }
}

