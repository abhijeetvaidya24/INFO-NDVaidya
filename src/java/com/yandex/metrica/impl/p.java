/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.util.SparseArray
 *  com.yandex.metrica.impl.an
 *  com.yandex.metrica.impl.e
 *  com.yandex.metrica.impl.h
 *  java.lang.CharSequence
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.util.EnumSet
 */
package com.yandex.metrica.impl;

import android.text.TextUtils;
import android.util.SparseArray;
import com.yandex.metrica.impl.an;
import com.yandex.metrica.impl.e;
import com.yandex.metrica.impl.h;
import java.util.EnumSet;

public final class p {
    public static final EnumSet<a> a;
    private static final EnumSet<a> b;
    private static final EnumSet<a> c;
    private static final EnumSet<a> d;
    private static final EnumSet<a> e;
    private static final EnumSet<a> f;
    private static final EnumSet<a> g;

    static {
        a a2 = a.a;
        Enum[] arrenum = new a[]{a.m, a.j, a.t, a.u, a.v, a.h, a.w, a.x, a.z};
        b = EnumSet.of((Enum)a2, (Enum[])arrenum);
        a a3 = a.k;
        Enum[] arrenum2 = new a[]{a.l, a.r, a.j, a.a, a.b, a.E, a.h, a.i, a.p, a.q, a.w, a.x, a.z};
        c = EnumSet.of((Enum)a3, (Enum[])arrenum2);
        d = EnumSet.of((Enum)a.e, (Enum)a.k, (Enum)a.l);
        a a4 = a.b;
        Enum[] arrenum3 = new a[]{a.p, a.C, a.A, a.t, a.h, a.E};
        a = EnumSet.of((Enum)a4, (Enum[])arrenum3);
        a a5 = a.q;
        Enum[] arrenum4 = new a[]{a.j, a.t, a.h, a.u, a.v, a.a, a.i, a.p, a.w, a.x};
        e = EnumSet.of((Enum)a5, (Enum[])arrenum4);
        f = EnumSet.of((Enum)a.f, (Enum)a.y, (Enum)a.g, (Enum)a.o, (Enum)a.c);
        g = EnumSet.of((Enum)a.c);
    }

    public static h a(an an2) {
        String string2 = an2 == null ? "" : an2.a();
        return new e(string2, a.z.b(), a.z.a());
    }

    static h a(a a2, String string2) {
        return new e(string2, a2.b(), a2.a());
    }

    public static h a(String string2) {
        return new e(string2, a.c.a());
    }

    static h a(String string2, String string3) {
        return new e(string3, string2, a.c.a());
    }

    public static boolean a(int n2) {
        return d.contains((Object)a.a(n2));
    }

    public static boolean a(h h2) {
        return (h2.c() == a.k.a() || h2.c() == a.l.a()) && !TextUtils.isEmpty((CharSequence)h2.l());
    }

    public static boolean a(a a2) {
        return !b.contains((Object)a2);
    }

    static h b(String string2) {
        return new e(string2, a.B.a());
    }

    static h b(String string2, String string3) {
        return new e(string3, string2, a.g.a());
    }

    public static boolean b(int n2) {
        return f.contains((Object)a.a(n2));
    }

    public static boolean b(a a2) {
        return !c.contains((Object)a2);
    }

    static h c(String string2) {
        return new e(string2, a.e.a());
    }

    static h c(String string2, String string3) {
        return new e(string3, string2, a.y.a());
    }

    public static boolean c(int n2) {
        return g.contains((Object)a.a(n2));
    }

    public static boolean c(a a2) {
        return !e.contains((Object)a2);
    }

    public static h d(a a2) {
        return new e(a2.b(), a2.a());
    }

    public static h d(String string2) {
        return new e("", string2, a.t.a());
    }

    public static final class a
    extends Enum<a> {
        public static final /* enum */ a A;
        public static final /* enum */ a B;
        public static final /* enum */ a C;
        public static final /* enum */ a D;
        public static final /* enum */ a E;
        public static final /* enum */ a F;
        public static final /* enum */ a G;
        static final SparseArray<a> H;
        private static final /* synthetic */ a[] K;
        public static final /* enum */ a a;
        public static final /* enum */ a b;
        public static final /* enum */ a c;
        public static final /* enum */ a d;
        public static final /* enum */ a e;
        public static final /* enum */ a f;
        public static final /* enum */ a g;
        public static final /* enum */ a h;
        public static final /* enum */ a i;
        public static final /* enum */ a j;
        public static final /* enum */ a k;
        public static final /* enum */ a l;
        public static final /* enum */ a m;
        public static final /* enum */ a n;
        public static final /* enum */ a o;
        public static final /* enum */ a p;
        public static final /* enum */ a q;
        public static final /* enum */ a r;
        public static final /* enum */ a s;
        public static final /* enum */ a t;
        public static final /* enum */ a u;
        public static final /* enum */ a v;
        public static final /* enum */ a w;
        public static final /* enum */ a x;
        public static final /* enum */ a y;
        public static final /* enum */ a z;
        private final int I;
        private final String J;

        static {
            a = new a(-1, "Unrecognized action");
            b = new a(0, "First initialization event");
            c = new a(1, "Regular event");
            d = new a(2, "Start of interaction with UI");
            e = new a(3, "End of interaction with UI");
            f = new a(4, "Deprecated crash of App");
            g = new a(5, "Error from developer");
            h = new a(6, "Deprecated sending referrer");
            i = new a(7, "App is still alive");
            j = new a(8, "Update collect apps");
            k = new a(9, "User info");
            l = new a(10, "Report user info");
            m = new a(256, "Forcible buffer clearing");
            n = new a(512, "Manual start of session");
            o = new a(768, "Native crash of App");
            p = new a(1280, "First initialization event in background mode");
            q = new a(1536, "Sending the startup due to lack of data");
            r = new a(1792, "System identification");
            s = new a(2304, "Event with statistical data");
            t = new a(4096, "Referrer received");
            u = new a(4352, "Migrate event format");
            v = new a(4608, "Migrate to uuid api key");
            w = new a(5376, "App Environment Updated");
            x = new a(5632, "App Environment Cleared");
            y = new a(5888, "Crash of App");
            z = new a(6144, "Activation of metrica");
            A = new a(6145, "First activation of metrica");
            B = new a(6400, "Start of new session");
            C = new a(8192, "Custom event");
            D = new a(8208, "App open event");
            E = new a(8224, "App update event");
            F = new a(12288, "Permissions changed event");
            G = new a(12289, "Features, required by application");
            a[] arra = new a[]{a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, C, D, E, F, G};
            K = arra;
            H = new SparseArray();
            for (a a2 : a.values()) {
                H.put(a2.a(), (Object)a2);
            }
        }

        private a(int n3, String string3) {
            this.I = n3;
            this.J = string3;
        }

        public static a a(int n2) {
            a a2 = (a)((Object)H.get(n2));
            if (a2 == null) {
                a2 = a;
            }
            return a2;
        }

        public static a valueOf(String string2) {
            return (a)Enum.valueOf(a.class, (String)string2);
        }

        public static a[] values() {
            return (a[])K.clone();
        }

        public int a() {
            return this.I;
        }

        public String b() {
            return this.J;
        }
    }

}

