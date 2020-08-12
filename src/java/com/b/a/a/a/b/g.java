/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.b.a.a.a.b;

import com.b.a.a.a.e.e;

public class g {
    private final String a;
    private final String b;

    private g(String string2, String string3) {
        this.a = string2;
        this.b = string3;
    }

    public static g a(String string2, String string3) {
        e.a(string2, "Name is null or empty");
        e.a(string3, "Version is null or empty");
        return new g(string2, string3);
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }
}

