/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package io.presage;

public abstract class Beaufort {
    private final String a;

    private Beaufort(String string2) {
        this.a = string2;
    }

    public /* synthetic */ Beaufort(String string2, byte by) {
        this(string2);
    }

    public final String f() {
        return this.a;
    }
}

