/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.tapjoy.internal;

import com.tapjoy.internal.dk;
import com.tapjoy.internal.dl;
import com.tapjoy.internal.dn;
import com.tapjoy.internal.do;
import com.tapjoy.internal.dp;
import com.tapjoy.internal.ds;
import com.tapjoy.internal.hx;

public final class ed
extends dl {
    public static final dn c;
    public static final Integer d;
    public static final Integer e;
    public static final Integer f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;
    public final Integer m;
    public final Integer n;
    public final Integer o;
    public final String p;
    public final String q;
    public final String r;
    public final String s;
    public final String t;
    public final String u;
    public final String v;
    public final String w;

    static {
        Integer n2;
        c = new b();
        d = n2 = Integer.valueOf((int)0);
        e = n2;
        f = n2;
    }

    public ed(String string, String string2, String string3, String string4, String string5, String string6, Integer n2, Integer n3, Integer n4, String string7, String string8, String string9, String string10, String string11, String string12, String string13, String string14, hx hx2) {
        super(c, hx2);
        this.g = string;
        this.h = string2;
        this.i = string3;
        this.j = string4;
        this.k = string5;
        this.l = string6;
        this.m = n2;
        this.n = n3;
        this.o = n4;
        this.p = string7;
        this.q = string8;
        this.r = string9;
        this.s = string10;
        this.t = string11;
        this.u = string12;
        this.v = string13;
        this.w = string14;
    }

    public final boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof ed)) {
            return false;
        }
        ed ed2 = (ed)object;
        return this.a().equals(ed2.a()) && ds.a((Object)this.g, (Object)ed2.g) && ds.a((Object)this.h, (Object)ed2.h) && ds.a((Object)this.i, (Object)ed2.i) && ds.a((Object)this.j, (Object)ed2.j) && ds.a((Object)this.k, (Object)ed2.k) && ds.a((Object)this.l, (Object)ed2.l) && ds.a((Object)this.m, (Object)ed2.m) && ds.a((Object)this.n, (Object)ed2.n) && ds.a((Object)this.o, (Object)ed2.o) && ds.a((Object)this.p, (Object)ed2.p) && ds.a((Object)this.q, (Object)ed2.q) && ds.a((Object)this.r, (Object)ed2.r) && ds.a((Object)this.s, (Object)ed2.s) && ds.a((Object)this.t, (Object)ed2.t) && ds.a((Object)this.u, (Object)ed2.u) && ds.a((Object)this.v, (Object)ed2.v) && ds.a((Object)this.w, (Object)ed2.w);
    }

    public final int hashCode() {
        int n2 = this.b;
        if (n2 == 0) {
            int n3 = 37 * this.a().hashCode();
            String string = this.g;
            int n4 = string != null ? string.hashCode() : 0;
            int n5 = 37 * (n3 + n4);
            String string2 = this.h;
            int n6 = string2 != null ? string2.hashCode() : 0;
            int n7 = 37 * (n5 + n6);
            String string3 = this.i;
            int n8 = string3 != null ? string3.hashCode() : 0;
            int n9 = 37 * (n7 + n8);
            String string4 = this.j;
            int n10 = string4 != null ? string4.hashCode() : 0;
            int n11 = 37 * (n9 + n10);
            String string5 = this.k;
            int n12 = string5 != null ? string5.hashCode() : 0;
            int n13 = 37 * (n11 + n12);
            String string6 = this.l;
            int n14 = string6 != null ? string6.hashCode() : 0;
            int n15 = 37 * (n13 + n14);
            Integer n16 = this.m;
            int n17 = n16 != null ? n16.hashCode() : 0;
            int n18 = 37 * (n15 + n17);
            Integer n19 = this.n;
            int n20 = n19 != null ? n19.hashCode() : 0;
            int n21 = 37 * (n18 + n20);
            Integer n22 = this.o;
            int n23 = n22 != null ? n22.hashCode() : 0;
            int n24 = 37 * (n21 + n23);
            String string7 = this.p;
            int n25 = string7 != null ? string7.hashCode() : 0;
            int n26 = 37 * (n24 + n25);
            String string8 = this.q;
            int n27 = string8 != null ? string8.hashCode() : 0;
            int n28 = 37 * (n26 + n27);
            String string9 = this.r;
            int n29 = string9 != null ? string9.hashCode() : 0;
            int n30 = 37 * (n28 + n29);
            String string10 = this.s;
            int n31 = string10 != null ? string10.hashCode() : 0;
            int n32 = 37 * (n30 + n31);
            String string11 = this.t;
            int n33 = string11 != null ? string11.hashCode() : 0;
            int n34 = 37 * (n32 + n33);
            String string12 = this.u;
            int n35 = string12 != null ? string12.hashCode() : 0;
            int n36 = 37 * (n34 + n35);
            String string13 = this.v;
            int n37 = string13 != null ? string13.hashCode() : 0;
            int n38 = 37 * (n36 + n37);
            String string14 = this.w;
            int n39 = 0;
            if (string14 != null) {
                n39 = string14.hashCode();
            }
            this.b = n2 = n38 + n39;
        }
        return n2;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.g != null) {
            stringBuilder.append(", mac=");
            stringBuilder.append(this.g);
        }
        if (this.h != null) {
            stringBuilder.append(", deviceId=");
            stringBuilder.append(this.h);
        }
        if (this.i != null) {
            stringBuilder.append(", deviceMaker=");
            stringBuilder.append(this.i);
        }
        if (this.j != null) {
            stringBuilder.append(", deviceModel=");
            stringBuilder.append(this.j);
        }
        if (this.k != null) {
            stringBuilder.append(", osName=");
            stringBuilder.append(this.k);
        }
        if (this.l != null) {
            stringBuilder.append(", osVer=");
            stringBuilder.append(this.l);
        }
        if (this.m != null) {
            stringBuilder.append(", displayD=");
            stringBuilder.append((Object)this.m);
        }
        if (this.n != null) {
            stringBuilder.append(", displayW=");
            stringBuilder.append((Object)this.n);
        }
        if (this.o != null) {
            stringBuilder.append(", displayH=");
            stringBuilder.append((Object)this.o);
        }
        if (this.p != null) {
            stringBuilder.append(", locale=");
            stringBuilder.append(this.p);
        }
        if (this.q != null) {
            stringBuilder.append(", timezone=");
            stringBuilder.append(this.q);
        }
        if (this.r != null) {
            stringBuilder.append(", pkgId=");
            stringBuilder.append(this.r);
        }
        if (this.s != null) {
            stringBuilder.append(", pkgSign=");
            stringBuilder.append(this.s);
        }
        if (this.t != null) {
            stringBuilder.append(", sdk=");
            stringBuilder.append(this.t);
        }
        if (this.u != null) {
            stringBuilder.append(", countrySim=");
            stringBuilder.append(this.u);
        }
        if (this.v != null) {
            stringBuilder.append(", countryNet=");
            stringBuilder.append(this.v);
        }
        if (this.w != null) {
            stringBuilder.append(", imei=");
            stringBuilder.append(this.w);
        }
        StringBuilder stringBuilder2 = stringBuilder.replace(0, 2, "Info{");
        stringBuilder2.append('}');
        return stringBuilder2.toString();
    }

    public static final class a
    extends dl.a {
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;
        public Integer i;
        public Integer j;
        public Integer k;
        public String l;
        public String m;
        public String n;
        public String o;
        public String p;
        public String q;
        public String r;
        public String s;

        public final ed b() {
            ed ed2 = new ed(this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, super.a());
            return ed2;
        }
    }

    static final class b
    extends dn {
        b() {
            super(dk.c, ed.class);
        }

        @Override
        public final /* synthetic */ int a(Object object) {
            ed ed2 = (ed)object;
            int n2 = ed2.g != null ? dn.p.a(1, (Object)ed2.g) : 0;
            int n3 = ed2.h != null ? dn.p.a(2, (Object)ed2.h) : 0;
            int n4 = n2 + n3;
            int n5 = ed2.i != null ? dn.p.a(3, (Object)ed2.i) : 0;
            int n6 = n4 + n5;
            int n7 = ed2.j != null ? dn.p.a(4, (Object)ed2.j) : 0;
            int n8 = n6 + n7;
            int n9 = ed2.k != null ? dn.p.a(5, (Object)ed2.k) : 0;
            int n10 = n8 + n9;
            int n11 = ed2.l != null ? dn.p.a(6, (Object)ed2.l) : 0;
            int n12 = n10 + n11;
            int n13 = ed2.m != null ? dn.d.a(7, (Object)ed2.m) : 0;
            int n14 = n12 + n13;
            int n15 = ed2.n != null ? dn.d.a(8, (Object)ed2.n) : 0;
            int n16 = n14 + n15;
            int n17 = ed2.o != null ? dn.d.a(9, (Object)ed2.o) : 0;
            int n18 = n16 + n17;
            int n19 = ed2.p != null ? dn.p.a(10, (Object)ed2.p) : 0;
            int n20 = n18 + n19;
            int n21 = ed2.q != null ? dn.p.a(11, (Object)ed2.q) : 0;
            int n22 = n20 + n21;
            int n23 = ed2.r != null ? dn.p.a(12, (Object)ed2.r) : 0;
            int n24 = n22 + n23;
            int n25 = ed2.s != null ? dn.p.a(13, (Object)ed2.s) : 0;
            int n26 = n24 + n25;
            int n27 = ed2.t != null ? dn.p.a(14, (Object)ed2.t) : 0;
            int n28 = n26 + n27;
            int n29 = ed2.u != null ? dn.p.a(15, (Object)ed2.u) : 0;
            int n30 = n28 + n29;
            int n31 = ed2.v != null ? dn.p.a(16, (Object)ed2.v) : 0;
            int n32 = n30 + n31;
            String string = ed2.w;
            int n33 = 0;
            if (string != null) {
                n33 = dn.p.a(17, (Object)ed2.w);
            }
            return n32 + n33 + ed2.a().c();
        }

        @Override
        public final /* synthetic */ Object a(do do_) {
            int n2;
            a a2 = new a();
            long l2 = do_.a();
            block19 : while ((n2 = do_.b()) != -1) {
                switch (n2) {
                    default: {
                        dk dk2 = do_.c();
                        a2.a(n2, dk2, dk2.a().a(do_));
                        continue block19;
                    }
                    case 17: {
                        a2.s = (String)dn.p.a(do_);
                        continue block19;
                    }
                    case 16: {
                        a2.r = (String)dn.p.a(do_);
                        continue block19;
                    }
                    case 15: {
                        a2.q = (String)dn.p.a(do_);
                        continue block19;
                    }
                    case 14: {
                        a2.p = (String)dn.p.a(do_);
                        continue block19;
                    }
                    case 13: {
                        a2.o = (String)dn.p.a(do_);
                        continue block19;
                    }
                    case 12: {
                        a2.n = (String)dn.p.a(do_);
                        continue block19;
                    }
                    case 11: {
                        a2.m = (String)dn.p.a(do_);
                        continue block19;
                    }
                    case 10: {
                        a2.l = (String)dn.p.a(do_);
                        continue block19;
                    }
                    case 9: {
                        a2.k = (Integer)dn.d.a(do_);
                        continue block19;
                    }
                    case 8: {
                        a2.j = (Integer)dn.d.a(do_);
                        continue block19;
                    }
                    case 7: {
                        a2.i = (Integer)dn.d.a(do_);
                        continue block19;
                    }
                    case 6: {
                        a2.h = (String)dn.p.a(do_);
                        continue block19;
                    }
                    case 5: {
                        a2.g = (String)dn.p.a(do_);
                        continue block19;
                    }
                    case 4: {
                        a2.f = (String)dn.p.a(do_);
                        continue block19;
                    }
                    case 3: {
                        a2.e = (String)dn.p.a(do_);
                        continue block19;
                    }
                    case 2: {
                        a2.d = (String)dn.p.a(do_);
                        continue block19;
                    }
                    case 1: 
                }
                a2.c = (String)dn.p.a(do_);
            }
            do_.a(l2);
            return a2.b();
        }
    }

}

