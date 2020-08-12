/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.tappx.a.a.a.e.f
 *  com.tappx.a.a.a.e.g
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Void
 */
package com.tappx.a.a.a.b;

import com.tappx.a.a.a.e.d;
import com.tappx.a.a.a.e.f;
import com.tappx.a.a.a.e.g;
import com.tappx.a.a.a.j;
import com.tappx.a.a.a.o;

public interface i {
    public b a(long var1, com.tappx.a.a.a.h.i var3, o<Void> var4, j<Void> var5);

    public b a(g var1, o<f> var2, j<a> var3);

    public b a(com.tappx.a.a.a.e.i var1, o<d> var2, j<a> var3);

    public b a(o<com.tappx.a.a.a.h.b> var1, j<Void> var2);

    public void a(b var1);

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

    public static class b {
        b() {
        }
    }

}

