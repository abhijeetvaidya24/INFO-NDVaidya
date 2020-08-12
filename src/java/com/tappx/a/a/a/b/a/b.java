/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 */
package com.tappx.a.a.a.b.a;

import java.util.Map;

public class b
extends Exception {
    public final a a;
    public final Map<String, String> b;
    public final int c;

    public b(a a2) {
        this(a2, null, -1);
    }

    public b(a a2, Map<String, String> map, int n2) {
        this.a = a2;
        this.b = map;
        this.c = n2;
    }

    public a a() {
        return this.a;
    }

    public static final class a
    extends Enum<a> {
        public static final /* enum */ a a = new a();
        public static final /* enum */ a b = new a();
        public static final /* enum */ a c = new a();
        public static final /* enum */ a d = new a();
        private static final /* synthetic */ a[] e;

        static {
            a[] arra = new a[]{a, b, c, d};
            e = arra;
        }

        public static a valueOf(String string2) {
            return (a)Enum.valueOf(a.class, (String)string2);
        }

        public static a[] values() {
            return (a[])e.clone();
        }
    }

}

