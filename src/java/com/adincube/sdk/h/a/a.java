/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.String
 */
package com.adincube.sdk.h.a;

import com.adincube.sdk.g.e.a.c;
import com.adincube.sdk.h.a.a;
import com.adincube.sdk.h.a.a.b;

public class a
extends Enum<a> {
    public static final /* enum */ a a = new a(new com.adincube.sdk.g.e.a.b(), b.b){

        public final com.adincube.sdk.b.a a() {
            return new com.adincube.sdk.b.b();
        }
    };
    public static final /* enum */ a b = new a(new c(), b.a){

        public final com.adincube.sdk.b.a a() {
            return new com.adincube.sdk.b.c();
        }
    };
    private static final /* synthetic */ a[] f;
    public com.adincube.sdk.g.e.a.a c;
    b d;
    private String e;

    static {
        a[] arra = new a[]{a, b};
        f = arra;
    }

    private a(String string2, com.adincube.sdk.g.e.a.a a2, b b2) {
        this.e = string2;
        this.c = a2;
        this.d = b2;
    }

    /* synthetic */ a(String string, int n2, String string2, com.adincube.sdk.g.e.a.a a2, b b2, byte by2) {
        this(string2, a2, b2);
    }

    public com.adincube.sdk.b.a a() {
        return null;
    }
}

