/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.List
 */
package com.tapjoy.internal;

import com.tapjoy.internal.dk;
import com.tapjoy.internal.dl;
import com.tapjoy.internal.dn;
import com.tapjoy.internal.do;
import com.tapjoy.internal.dp;
import com.tapjoy.internal.ds;
import com.tapjoy.internal.eh;
import com.tapjoy.internal.hx;
import java.util.List;

public final class ek
extends dl {
    public static final dn c;
    public static final Long d;
    public static final Integer e;
    public static final Integer f;
    public static final Integer g;
    public static final Long h;
    public static final Long i;
    public static final Long j;
    public static final Integer k;
    public static final Double l;
    public static final Long m;
    public static final Double n;
    public static final Boolean o;
    public static final Integer p;
    public static final Integer q;
    public static final Boolean r;
    public final Long A;
    public final String B;
    public final Integer C;
    public final Double D;
    public final Long E;
    public final Double F;
    public final String G;
    public final Boolean H;
    public final String I;
    public final Integer J;
    public final Integer K;
    public final String L;
    public final String M;
    public final String N;
    public final String O;
    public final String P;
    public final List Q;
    public final Boolean R;
    public final Long s;
    public final String t;
    public final Integer u;
    public final Integer v;
    public final List w;
    public final Integer x;
    public final Long y;
    public final Long z;

    static {
        Double d2;
        Integer n2;
        Long l2;
        c = new b();
        d = l2 = Long.valueOf((long)0L);
        Boolean bl = false;
        e = n2 = Integer.valueOf((int)0);
        f = n2;
        g = n2;
        h = l2;
        i = l2;
        j = l2;
        k = n2;
        l = d2 = Double.valueOf((double)0.0);
        m = l2;
        n = d2;
        o = bl;
        p = n2;
        q = n2;
        r = bl;
    }

    public ek(Long l2, String string, Integer n2, Integer n3, List list, Integer n4, Long l3, Long l4, Long l5, String string2, Integer n5, Double d2, Long l6, Double d3, String string3, Boolean bl, String string4, Integer n6, Integer n7, String string5, String string6, String string7, String string8, String string9, List list2, Boolean bl2, hx hx2) {
        super(c, hx2);
        this.s = l2;
        this.t = string;
        this.u = n2;
        this.v = n3;
        this.w = ds.a("pushes", list);
        this.x = n4;
        this.y = l3;
        this.z = l4;
        this.A = l5;
        this.B = string2;
        this.C = n5;
        this.D = d2;
        this.E = l6;
        this.F = d3;
        this.G = string3;
        this.H = bl;
        this.I = string4;
        this.J = n6;
        this.K = n7;
        this.L = string5;
        this.M = string6;
        this.N = string7;
        this.O = string8;
        this.P = string9;
        this.Q = ds.a("tags", list2);
        this.R = bl2;
    }

    public final boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof ek)) {
            return false;
        }
        ek ek2 = (ek)object;
        return this.a().equals(ek2.a()) && ds.a((Object)this.s, (Object)ek2.s) && ds.a((Object)this.t, (Object)ek2.t) && ds.a((Object)this.u, (Object)ek2.u) && ds.a((Object)this.v, (Object)ek2.v) && this.w.equals((Object)ek2.w) && ds.a((Object)this.x, (Object)ek2.x) && ds.a((Object)this.y, (Object)ek2.y) && ds.a((Object)this.z, (Object)ek2.z) && ds.a((Object)this.A, (Object)ek2.A) && ds.a((Object)this.B, (Object)ek2.B) && ds.a((Object)this.C, (Object)ek2.C) && ds.a((Object)this.D, (Object)ek2.D) && ds.a((Object)this.E, (Object)ek2.E) && ds.a((Object)this.F, (Object)ek2.F) && ds.a((Object)this.G, (Object)ek2.G) && ds.a((Object)this.H, (Object)ek2.H) && ds.a((Object)this.I, (Object)ek2.I) && ds.a((Object)this.J, (Object)ek2.J) && ds.a((Object)this.K, (Object)ek2.K) && ds.a((Object)this.L, (Object)ek2.L) && ds.a((Object)this.M, (Object)ek2.M) && ds.a((Object)this.N, (Object)ek2.N) && ds.a((Object)this.O, (Object)ek2.O) && ds.a((Object)this.P, (Object)ek2.P) && this.Q.equals((Object)ek2.Q) && ds.a((Object)this.R, (Object)ek2.R);
    }

    public final int hashCode() {
        int n2 = this.b;
        if (n2 == 0) {
            int n3 = 37 * this.a().hashCode();
            Long l2 = this.s;
            int n4 = l2 != null ? l2.hashCode() : 0;
            int n5 = 37 * (n3 + n4);
            String string = this.t;
            int n6 = string != null ? string.hashCode() : 0;
            int n7 = 37 * (n5 + n6);
            Integer n8 = this.u;
            int n9 = n8 != null ? n8.hashCode() : 0;
            int n10 = 37 * (n7 + n9);
            Integer n11 = this.v;
            int n12 = n11 != null ? n11.hashCode() : 0;
            int n13 = 37 * (37 * (n10 + n12) + this.w.hashCode());
            Integer n14 = this.x;
            int n15 = n14 != null ? n14.hashCode() : 0;
            int n16 = 37 * (n13 + n15);
            Long l3 = this.y;
            int n17 = l3 != null ? l3.hashCode() : 0;
            int n18 = 37 * (n16 + n17);
            Long l4 = this.z;
            int n19 = l4 != null ? l4.hashCode() : 0;
            int n20 = 37 * (n18 + n19);
            Long l5 = this.A;
            int n21 = l5 != null ? l5.hashCode() : 0;
            int n22 = 37 * (n20 + n21);
            String string2 = this.B;
            int n23 = string2 != null ? string2.hashCode() : 0;
            int n24 = 37 * (n22 + n23);
            Integer n25 = this.C;
            int n26 = n25 != null ? n25.hashCode() : 0;
            int n27 = 37 * (n24 + n26);
            Double d2 = this.D;
            int n28 = d2 != null ? d2.hashCode() : 0;
            int n29 = 37 * (n27 + n28);
            Long l6 = this.E;
            int n30 = l6 != null ? l6.hashCode() : 0;
            int n31 = 37 * (n29 + n30);
            Double d3 = this.F;
            int n32 = d3 != null ? d3.hashCode() : 0;
            int n33 = 37 * (n31 + n32);
            String string3 = this.G;
            int n34 = string3 != null ? string3.hashCode() : 0;
            int n35 = 37 * (n33 + n34);
            Boolean bl = this.H;
            int n36 = bl != null ? bl.hashCode() : 0;
            int n37 = 37 * (n35 + n36);
            String string4 = this.I;
            int n38 = string4 != null ? string4.hashCode() : 0;
            int n39 = 37 * (n37 + n38);
            Integer n40 = this.J;
            int n41 = n40 != null ? n40.hashCode() : 0;
            int n42 = 37 * (n39 + n41);
            Integer n43 = this.K;
            int n44 = n43 != null ? n43.hashCode() : 0;
            int n45 = 37 * (n42 + n44);
            String string5 = this.L;
            int n46 = string5 != null ? string5.hashCode() : 0;
            int n47 = 37 * (n45 + n46);
            String string6 = this.M;
            int n48 = string6 != null ? string6.hashCode() : 0;
            int n49 = 37 * (n47 + n48);
            String string7 = this.N;
            int n50 = string7 != null ? string7.hashCode() : 0;
            int n51 = 37 * (n49 + n50);
            String string8 = this.O;
            int n52 = string8 != null ? string8.hashCode() : 0;
            int n53 = 37 * (n51 + n52);
            String string9 = this.P;
            int n54 = string9 != null ? string9.hashCode() : 0;
            int n55 = 37 * (37 * (n53 + n54) + this.Q.hashCode());
            Boolean bl2 = this.R;
            int n56 = 0;
            if (bl2 != null) {
                n56 = bl2.hashCode();
            }
            this.b = n2 = n55 + n56;
        }
        return n2;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.s != null) {
            stringBuilder.append(", installed=");
            stringBuilder.append((Object)this.s);
        }
        if (this.t != null) {
            stringBuilder.append(", referrer=");
            stringBuilder.append(this.t);
        }
        if (this.u != null) {
            stringBuilder.append(", fq7=");
            stringBuilder.append((Object)this.u);
        }
        if (this.v != null) {
            stringBuilder.append(", fq30=");
            stringBuilder.append((Object)this.v);
        }
        if (!this.w.isEmpty()) {
            stringBuilder.append(", pushes=");
            stringBuilder.append((Object)this.w);
        }
        if (this.x != null) {
            stringBuilder.append(", sessionTotalCount=");
            stringBuilder.append((Object)this.x);
        }
        if (this.y != null) {
            stringBuilder.append(", sessionTotalDuration=");
            stringBuilder.append((Object)this.y);
        }
        if (this.z != null) {
            stringBuilder.append(", sessionLastTime=");
            stringBuilder.append((Object)this.z);
        }
        if (this.A != null) {
            stringBuilder.append(", sessionLastDuration=");
            stringBuilder.append((Object)this.A);
        }
        if (this.B != null) {
            stringBuilder.append(", purchaseCurrency=");
            stringBuilder.append(this.B);
        }
        if (this.C != null) {
            stringBuilder.append(", purchaseTotalCount=");
            stringBuilder.append((Object)this.C);
        }
        if (this.D != null) {
            stringBuilder.append(", purchaseTotalPrice=");
            stringBuilder.append((Object)this.D);
        }
        if (this.E != null) {
            stringBuilder.append(", purchaseLastTime=");
            stringBuilder.append((Object)this.E);
        }
        if (this.F != null) {
            stringBuilder.append(", purchaseLastPrice=");
            stringBuilder.append((Object)this.F);
        }
        if (this.G != null) {
            stringBuilder.append(", idfa=");
            stringBuilder.append(this.G);
        }
        if (this.H != null) {
            stringBuilder.append(", idfaOptout=");
            stringBuilder.append((Object)this.H);
        }
        if (this.I != null) {
            stringBuilder.append(", userId=");
            stringBuilder.append(this.I);
        }
        if (this.J != null) {
            stringBuilder.append(", userLevel=");
            stringBuilder.append((Object)this.J);
        }
        if (this.K != null) {
            stringBuilder.append(", friendCount=");
            stringBuilder.append((Object)this.K);
        }
        if (this.L != null) {
            stringBuilder.append(", uv1=");
            stringBuilder.append(this.L);
        }
        if (this.M != null) {
            stringBuilder.append(", uv2=");
            stringBuilder.append(this.M);
        }
        if (this.N != null) {
            stringBuilder.append(", uv3=");
            stringBuilder.append(this.N);
        }
        if (this.O != null) {
            stringBuilder.append(", uv4=");
            stringBuilder.append(this.O);
        }
        if (this.P != null) {
            stringBuilder.append(", uv5=");
            stringBuilder.append(this.P);
        }
        if (!this.Q.isEmpty()) {
            stringBuilder.append(", tags=");
            stringBuilder.append((Object)this.Q);
        }
        if (this.R != null) {
            stringBuilder.append(", pushOptout=");
            stringBuilder.append((Object)this.R);
        }
        StringBuilder stringBuilder2 = stringBuilder.replace(0, 2, "User{");
        stringBuilder2.append('}');
        return stringBuilder2.toString();
    }

    public static final class a
    extends dl.a {
        public List A = ds.a();
        public Boolean B;
        public Long c;
        public String d;
        public Integer e;
        public Integer f;
        public List g = ds.a();
        public Integer h;
        public Long i;
        public Long j;
        public Long k;
        public String l;
        public Integer m;
        public Double n;
        public Long o;
        public Double p;
        public String q;
        public Boolean r;
        public String s;
        public Integer t;
        public Integer u;
        public String v;
        public String w;
        public String x;
        public String y;
        public String z;

        public final ek b() {
            ek ek2 = new ek(this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.v, this.w, this.x, this.y, this.z, this.A, this.B, super.a());
            return ek2;
        }
    }

    static final class b
    extends dn {
        b() {
            super(dk.c, ek.class);
        }

        @Override
        public final /* synthetic */ int a(Object object) {
            ek ek2 = (ek)object;
            int n2 = ek2.s != null ? dn.i.a(1, (Object)ek2.s) : 0;
            int n3 = ek2.t != null ? dn.p.a(2, (Object)ek2.t) : 0;
            int n4 = n2 + n3;
            int n5 = ek2.u != null ? dn.d.a(13, (Object)ek2.u) : 0;
            int n6 = n4 + n5;
            int n7 = ek2.v != null ? dn.d.a(14, (Object)ek2.v) : 0;
            int n8 = n6 + n7 + eh.c.a().a(15, (Object)ek2.w);
            int n9 = ek2.x != null ? dn.d.a(16, (Object)ek2.x) : 0;
            int n10 = n8 + n9;
            int n11 = ek2.y != null ? dn.i.a(17, (Object)ek2.y) : 0;
            int n12 = n10 + n11;
            int n13 = ek2.z != null ? dn.i.a(18, (Object)ek2.z) : 0;
            int n14 = n12 + n13;
            int n15 = ek2.A != null ? dn.i.a(19, (Object)ek2.A) : 0;
            int n16 = n14 + n15;
            int n17 = ek2.B != null ? dn.p.a(20, (Object)ek2.B) : 0;
            int n18 = n16 + n17;
            int n19 = ek2.C != null ? dn.d.a(3, (Object)ek2.C) : 0;
            int n20 = n18 + n19;
            int n21 = ek2.D != null ? dn.o.a(21, (Object)ek2.D) : 0;
            int n22 = n20 + n21;
            int n23 = ek2.E != null ? dn.i.a(4, (Object)ek2.E) : 0;
            int n24 = n22 + n23;
            int n25 = ek2.F != null ? dn.o.a(22, (Object)ek2.F) : 0;
            int n26 = n24 + n25;
            int n27 = ek2.G != null ? dn.p.a(23, (Object)ek2.G) : 0;
            int n28 = n26 + n27;
            int n29 = ek2.H != null ? dn.c.a(24, (Object)ek2.H) : 0;
            int n30 = n28 + n29;
            int n31 = ek2.I != null ? dn.p.a(5, (Object)ek2.I) : 0;
            int n32 = n30 + n31;
            int n33 = ek2.J != null ? dn.d.a(6, (Object)ek2.J) : 0;
            int n34 = n32 + n33;
            int n35 = ek2.K != null ? dn.d.a(7, (Object)ek2.K) : 0;
            int n36 = n34 + n35;
            int n37 = ek2.L != null ? dn.p.a(8, (Object)ek2.L) : 0;
            int n38 = n36 + n37;
            int n39 = ek2.M != null ? dn.p.a(9, (Object)ek2.M) : 0;
            int n40 = n38 + n39;
            int n41 = ek2.N != null ? dn.p.a(10, (Object)ek2.N) : 0;
            int n42 = n40 + n41;
            int n43 = ek2.O != null ? dn.p.a(11, (Object)ek2.O) : 0;
            int n44 = n42 + n43;
            int n45 = ek2.P != null ? dn.p.a(12, (Object)ek2.P) : 0;
            int n46 = n44 + n45 + dn.p.a().a(26, (Object)ek2.Q);
            Boolean bl = ek2.R;
            int n47 = 0;
            if (bl != null) {
                n47 = dn.c.a(25, (Object)ek2.R);
            }
            return n46 + n47 + ek2.a().c();
        }

        @Override
        public final /* synthetic */ Object a(do do_) {
            int n2;
            a a2 = new a();
            long l2 = do_.a();
            block28 : while ((n2 = do_.b()) != -1) {
                switch (n2) {
                    default: {
                        dk dk2 = do_.c();
                        a2.a(n2, dk2, dk2.a().a(do_));
                        continue block28;
                    }
                    case 26: {
                        a2.A.add(dn.p.a(do_));
                        continue block28;
                    }
                    case 25: {
                        a2.B = (Boolean)dn.c.a(do_);
                        continue block28;
                    }
                    case 24: {
                        a2.r = (Boolean)dn.c.a(do_);
                        continue block28;
                    }
                    case 23: {
                        a2.q = (String)dn.p.a(do_);
                        continue block28;
                    }
                    case 22: {
                        a2.p = (Double)dn.o.a(do_);
                        continue block28;
                    }
                    case 21: {
                        a2.n = (Double)dn.o.a(do_);
                        continue block28;
                    }
                    case 20: {
                        a2.l = (String)dn.p.a(do_);
                        continue block28;
                    }
                    case 19: {
                        a2.k = (Long)dn.i.a(do_);
                        continue block28;
                    }
                    case 18: {
                        a2.j = (Long)dn.i.a(do_);
                        continue block28;
                    }
                    case 17: {
                        a2.i = (Long)dn.i.a(do_);
                        continue block28;
                    }
                    case 16: {
                        a2.h = (Integer)dn.d.a(do_);
                        continue block28;
                    }
                    case 15: {
                        a2.g.add(eh.c.a(do_));
                        continue block28;
                    }
                    case 14: {
                        a2.f = (Integer)dn.d.a(do_);
                        continue block28;
                    }
                    case 13: {
                        a2.e = (Integer)dn.d.a(do_);
                        continue block28;
                    }
                    case 12: {
                        a2.z = (String)dn.p.a(do_);
                        continue block28;
                    }
                    case 11: {
                        a2.y = (String)dn.p.a(do_);
                        continue block28;
                    }
                    case 10: {
                        a2.x = (String)dn.p.a(do_);
                        continue block28;
                    }
                    case 9: {
                        a2.w = (String)dn.p.a(do_);
                        continue block28;
                    }
                    case 8: {
                        a2.v = (String)dn.p.a(do_);
                        continue block28;
                    }
                    case 7: {
                        a2.u = (Integer)dn.d.a(do_);
                        continue block28;
                    }
                    case 6: {
                        a2.t = (Integer)dn.d.a(do_);
                        continue block28;
                    }
                    case 5: {
                        a2.s = (String)dn.p.a(do_);
                        continue block28;
                    }
                    case 4: {
                        a2.o = (Long)dn.i.a(do_);
                        continue block28;
                    }
                    case 3: {
                        a2.m = (Integer)dn.d.a(do_);
                        continue block28;
                    }
                    case 2: {
                        a2.d = (String)dn.p.a(do_);
                        continue block28;
                    }
                    case 1: 
                }
                a2.c = (Long)dn.i.a(do_);
            }
            do_.a(l2);
            return a2.b();
        }
    }

}

