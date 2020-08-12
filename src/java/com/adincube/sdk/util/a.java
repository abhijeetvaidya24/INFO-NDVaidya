/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.adincube.sdk.util.a$a$1
 *  com.adincube.sdk.util.a$a$2
 *  com.adincube.sdk.util.a$a$3
 *  com.adincube.sdk.util.a$a$4
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.adincube.sdk.util;

import com.adincube.sdk.util.a;

public final class a {
    private static boolean a;

    public static /* varargs */ void a(a a2, String string, Object ... arrobject) {
        if (a) {
            return;
        }
        if (arrobject.length != 0) {
            string = String.format((String)string, (Object[])arrobject);
        }
        int n2 = arrobject.length;
        Throwable throwable = null;
        if (n2 > 0) {
            boolean bl = arrobject[-1 + arrobject.length] instanceof Throwable;
            throwable = null;
            if (bl) {
                throwable = (Throwable)((Object)arrobject[-1 + arrobject.length]);
            }
        }
        a2.a(string, throwable);
    }

    public static /* varargs */ void a(String string, Object ... arrobject) {
        a.a(a.b, string, arrobject);
    }

    public static /* varargs */ void b(String string, Object ... arrobject) {
        a.a(a.c, string, arrobject);
    }

    public static /* varargs */ void c(String string, Object ... arrobject) {
        a.a(a.d, string, arrobject);
    }

    public static abstract class a
    extends Enum<a> {
        public static final /* enum */ a a = new 1("DEBUG");
        public static final /* enum */ a b = new 2("INFO");
        public static final /* enum */ a c = new 3("WARNING");
        public static final /* enum */ a d = new 4("ERROR");
        private static final /* synthetic */ a[] e;

        static {
            a[] arra = new a[]{a, b, c, d};
            e = arra;
        }

        private a() {
        }

        /* synthetic */ a(String string, int n2, byte by) {
            this();
        }

        public abstract void a(String var1, Throwable var2);
    }

}

