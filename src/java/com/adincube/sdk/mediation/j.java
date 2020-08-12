/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.adincube.sdk.mediation;

import com.adincube.sdk.mediation.b;
import com.adincube.sdk.mediation.i;
import com.adincube.sdk.util.m;

public final class j {
    public b a;
    public a b;
    private i c;
    private String d;

    public j(b b2, a a2) {
        this.a = b2;
        this.c = b2.f();
        this.b = a2;
    }

    public j(b b2, a a2, String string) {
        this(b2, a2);
        this.d = string;
    }

    public j(b b2, a a2, Throwable throwable) {
        this(b2, a2);
        this.d = m.a(throwable);
    }

    public final String a() {
        String string = this.d;
        if (string == null) {
            string = "Unknown";
        }
        return string;
    }

    public static final class a
    extends Enum<a> {
        public static final /* enum */ a a = new a("INTEGRATION");
        public static final /* enum */ a b = new a("NO_MORE_INVENTORY");
        public static final /* enum */ a c = new a("NETWORK");
        public static final /* enum */ a d = new a("UNKNOWN");
        private static final /* synthetic */ a[] f;
        public String e;

        static {
            a[] arra = new a[]{a, b, c, d};
            f = arra;
        }

        private a(String string2) {
            this.e = string2;
        }

        public static a[] a() {
            return (a[])f.clone();
        }
    }

}

