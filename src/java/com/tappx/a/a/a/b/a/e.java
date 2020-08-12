/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Comparator
 *  java.util.Map
 *  java.util.TreeMap
 */
package com.tappx.a.a.a.b.a;

import com.tappx.a.a.a.b.a.d;
import com.tappx.a.a.a.b.a.g;
import com.tappx.a.a.a.b.a.h;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public abstract class e<T> {
    private g.b<T> a;
    private g.a b;
    private boolean c;
    private h d;
    private b e = b.b;

    protected e(g.b<T> b2, g.a a2) {
        this.a = b2;
        this.b = a2;
    }

    public g.a V() {
        return this.b;
    }

    public g.b<T> W() {
        return this.a;
    }

    public h X() {
        return this.d;
    }

    public boolean Y() {
        return this.c;
    }

    public b Z() {
        return this.e;
    }

    public abstract a a();

    protected abstract g<T> a(d var1);

    public void a(b b2) {
        this.e = b2;
    }

    public void a(g.a a2) {
        this.b = a2;
    }

    public void a(g.b<T> b2) {
        this.a = b2;
    }

    public void a(h h2) {
        this.d = h2;
    }

    protected void a(T t2) {
        g.b<T> b2 = this.a;
        if (b2 != null) {
            b2.a(t2);
        }
    }

    public void a(boolean bl2) {
        this.c = bl2;
    }

    protected Map<String, String> aa() {
        return new TreeMap(String.CASE_INSENSITIVE_ORDER);
    }

    public abstract String b();

    public abstract byte[] c();

    public abstract Map<String, String> d();

    public static final class a
    extends Enum<a> {
        public static final /* enum */ a a = new a();
        public static final /* enum */ a b = new a();
        public static final /* enum */ a c = new a();
        public static final /* enum */ a d = new a();
        public static final /* enum */ a e = new a();
        public static final /* enum */ a f = new a();
        public static final /* enum */ a g = new a();
        public static final /* enum */ a h = new a();
        private static final /* synthetic */ a[] i;

        static {
            a[] arra = new a[]{a, b, c, d, e, f, g, h};
            i = arra;
        }

        public static a valueOf(String string2) {
            return (a)Enum.valueOf(a.class, (String)string2);
        }

        public static a[] values() {
            return (a[])i.clone();
        }
    }

    public static final class b
    extends Enum<b> {
        public static final /* enum */ b a = new b();
        public static final /* enum */ b b = new b();
        public static final /* enum */ b c = new b();
        public static final /* enum */ b d = new b();
        private static final /* synthetic */ b[] e;

        static {
            b[] arrb = new b[]{a, b, c, d};
            e = arrb;
        }

        public static b valueOf(String string2) {
            return (b)Enum.valueOf(b.class, (String)string2);
        }

        public static b[] values() {
            return (b[])e.clone();
        }
    }

}

