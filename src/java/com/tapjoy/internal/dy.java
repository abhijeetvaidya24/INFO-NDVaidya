/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
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
import com.tapjoy.internal.dx;
import com.tapjoy.internal.ea;
import com.tapjoy.internal.eb;
import com.tapjoy.internal.ec;
import com.tapjoy.internal.ed;
import com.tapjoy.internal.ef;
import com.tapjoy.internal.eg;
import com.tapjoy.internal.ek;
import com.tapjoy.internal.hx;
import java.util.List;

public final class dy
extends dl {
    public static final dn c;
    public static final eb d;
    public static final Long e;
    public static final Long f;
    public static final Long g;
    public static final Long h;
    public static final Integer i;
    public static final Integer j;
    public static final Integer k;
    public static final Long l;
    public static final Long m;
    public final eg A;
    public final String B;
    public final String C;
    public final ef D;
    public final String E;
    public final String F;
    public final String G;
    public final List H;
    public final String I;
    public final Integer J;
    public final Long K;
    public final Long L;
    public final eb n;
    public final String o;
    public final Long p;
    public final Long q;
    public final String r;
    public final Long s;
    public final Long t;
    public final ed u;
    public final dx v;
    public final ek w;
    public final Integer x;
    public final Integer y;
    public final ea z;

    static {
        Integer n2;
        Long l2;
        c = new b();
        d = eb.APP;
        e = l2 = Long.valueOf((long)0L);
        f = l2;
        g = l2;
        h = l2;
        i = n2 = Integer.valueOf((int)0);
        j = n2;
        k = n2;
        l = l2;
        m = l2;
    }

    public dy(eb eb2, String string, Long l2, Long l3, String string2, Long l4, Long l5, ed ed2, dx dx2, ek ek2, Integer n2, Integer n3, ea ea2, eg eg2, String string3, String string4, ef ef2, String string5, String string6, String string7, List list, String string8, Integer n4, Long l6, Long l7, hx hx2) {
        super(c, hx2);
        this.n = eb2;
        this.o = string;
        this.p = l2;
        this.q = l3;
        this.r = string2;
        this.s = l4;
        this.t = l5;
        this.u = ed2;
        this.v = dx2;
        this.w = ek2;
        this.x = n2;
        this.y = n3;
        this.z = ea2;
        this.A = eg2;
        this.B = string3;
        this.C = string4;
        this.D = ef2;
        this.E = string5;
        this.F = string6;
        this.G = string7;
        this.H = ds.a("values", list);
        this.I = string8;
        this.J = n4;
        this.K = l6;
        this.L = l7;
    }

    public final boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof dy)) {
            return false;
        }
        dy dy2 = (dy)object;
        return this.a().equals(dy2.a()) && this.n.equals((Object)dy2.n) && this.o.equals((Object)dy2.o) && this.p.equals((Object)dy2.p) && ds.a((Object)this.q, (Object)dy2.q) && ds.a((Object)this.r, (Object)dy2.r) && ds.a((Object)this.s, (Object)dy2.s) && ds.a((Object)this.t, (Object)dy2.t) && ds.a((Object)this.u, (Object)dy2.u) && ds.a((Object)this.v, (Object)dy2.v) && ds.a((Object)this.w, (Object)dy2.w) && ds.a((Object)this.x, (Object)dy2.x) && ds.a((Object)this.y, (Object)dy2.y) && ds.a((Object)this.z, (Object)dy2.z) && ds.a((Object)this.A, (Object)dy2.A) && ds.a((Object)this.B, (Object)dy2.B) && ds.a((Object)this.C, (Object)dy2.C) && ds.a((Object)this.D, (Object)dy2.D) && ds.a((Object)this.E, (Object)dy2.E) && ds.a((Object)this.F, (Object)dy2.F) && ds.a((Object)this.G, (Object)dy2.G) && this.H.equals((Object)dy2.H) && ds.a((Object)this.I, (Object)dy2.I) && ds.a((Object)this.J, (Object)dy2.J) && ds.a((Object)this.K, (Object)dy2.K) && ds.a((Object)this.L, (Object)dy2.L);
    }

    public final int hashCode() {
        int n2 = this.b;
        if (n2 == 0) {
            int n3 = 37 * (37 * (37 * (37 * this.a().hashCode() + this.n.hashCode()) + this.o.hashCode()) + this.p.hashCode());
            Long l2 = this.q;
            int n4 = l2 != null ? l2.hashCode() : 0;
            int n5 = 37 * (n3 + n4);
            String string = this.r;
            int n6 = string != null ? string.hashCode() : 0;
            int n7 = 37 * (n5 + n6);
            Long l3 = this.s;
            int n8 = l3 != null ? l3.hashCode() : 0;
            int n9 = 37 * (n7 + n8);
            Long l4 = this.t;
            int n10 = l4 != null ? l4.hashCode() : 0;
            int n11 = 37 * (n9 + n10);
            ed ed2 = this.u;
            int n12 = ed2 != null ? ed2.hashCode() : 0;
            int n13 = 37 * (n11 + n12);
            dx dx2 = this.v;
            int n14 = dx2 != null ? dx2.hashCode() : 0;
            int n15 = 37 * (n13 + n14);
            ek ek2 = this.w;
            int n16 = ek2 != null ? ek2.hashCode() : 0;
            int n17 = 37 * (n15 + n16);
            Integer n18 = this.x;
            int n19 = n18 != null ? n18.hashCode() : 0;
            int n20 = 37 * (n17 + n19);
            Integer n21 = this.y;
            int n22 = n21 != null ? n21.hashCode() : 0;
            int n23 = 37 * (n20 + n22);
            ea ea2 = this.z;
            int n24 = ea2 != null ? ea2.hashCode() : 0;
            int n25 = 37 * (n23 + n24);
            eg eg2 = this.A;
            int n26 = eg2 != null ? eg2.hashCode() : 0;
            int n27 = 37 * (n25 + n26);
            String string2 = this.B;
            int n28 = string2 != null ? string2.hashCode() : 0;
            int n29 = 37 * (n27 + n28);
            String string3 = this.C;
            int n30 = string3 != null ? string3.hashCode() : 0;
            int n31 = 37 * (n29 + n30);
            ef ef2 = this.D;
            int n32 = ef2 != null ? ef2.hashCode() : 0;
            int n33 = 37 * (n31 + n32);
            String string4 = this.E;
            int n34 = string4 != null ? string4.hashCode() : 0;
            int n35 = 37 * (n33 + n34);
            String string5 = this.F;
            int n36 = string5 != null ? string5.hashCode() : 0;
            int n37 = 37 * (n35 + n36);
            String string6 = this.G;
            int n38 = string6 != null ? string6.hashCode() : 0;
            int n39 = 37 * (37 * (n37 + n38) + this.H.hashCode());
            String string7 = this.I;
            int n40 = string7 != null ? string7.hashCode() : 0;
            int n41 = 37 * (n39 + n40);
            Integer n42 = this.J;
            int n43 = n42 != null ? n42.hashCode() : 0;
            int n44 = 37 * (n41 + n43);
            Long l5 = this.K;
            int n45 = l5 != null ? l5.hashCode() : 0;
            int n46 = 37 * (n44 + n45);
            Long l6 = this.L;
            int n47 = 0;
            if (l6 != null) {
                n47 = l6.hashCode();
            }
            this.b = n2 = n46 + n47;
        }
        return n2;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(", type=");
        stringBuilder.append((Object)this.n);
        stringBuilder.append(", name=");
        stringBuilder.append(this.o);
        stringBuilder.append(", time=");
        stringBuilder.append((Object)this.p);
        if (this.q != null) {
            stringBuilder.append(", systemTime=");
            stringBuilder.append((Object)this.q);
        }
        if (this.r != null) {
            stringBuilder.append(", instanceId=");
            stringBuilder.append(this.r);
        }
        if (this.s != null) {
            stringBuilder.append(", elapsedRealtime=");
            stringBuilder.append((Object)this.s);
        }
        if (this.t != null) {
            stringBuilder.append(", duration=");
            stringBuilder.append((Object)this.t);
        }
        if (this.u != null) {
            stringBuilder.append(", info=");
            stringBuilder.append((Object)this.u);
        }
        if (this.v != null) {
            stringBuilder.append(", app=");
            stringBuilder.append((Object)this.v);
        }
        if (this.w != null) {
            stringBuilder.append(", user=");
            stringBuilder.append((Object)this.w);
        }
        if (this.x != null) {
            stringBuilder.append(", xxx_session_seq=");
            stringBuilder.append((Object)this.x);
        }
        if (this.y != null) {
            stringBuilder.append(", eventSeq=");
            stringBuilder.append((Object)this.y);
        }
        if (this.z != null) {
            stringBuilder.append(", eventPrev=");
            stringBuilder.append((Object)this.z);
        }
        if (this.A != null) {
            stringBuilder.append(", purchase=");
            stringBuilder.append((Object)this.A);
        }
        if (this.B != null) {
            stringBuilder.append(", exception=");
            stringBuilder.append(this.B);
        }
        if (this.C != null) {
            stringBuilder.append(", metaBase=");
            stringBuilder.append(this.C);
        }
        if (this.D != null) {
            stringBuilder.append(", meta=");
            stringBuilder.append((Object)this.D);
        }
        if (this.E != null) {
            stringBuilder.append(", category=");
            stringBuilder.append(this.E);
        }
        if (this.F != null) {
            stringBuilder.append(", p1=");
            stringBuilder.append(this.F);
        }
        if (this.G != null) {
            stringBuilder.append(", p2=");
            stringBuilder.append(this.G);
        }
        if (!this.H.isEmpty()) {
            stringBuilder.append(", values=");
            stringBuilder.append((Object)this.H);
        }
        if (this.I != null) {
            stringBuilder.append(", dimensions=");
            stringBuilder.append(this.I);
        }
        if (this.J != null) {
            stringBuilder.append(", count=");
            stringBuilder.append((Object)this.J);
        }
        if (this.K != null) {
            stringBuilder.append(", firstTime=");
            stringBuilder.append((Object)this.K);
        }
        if (this.L != null) {
            stringBuilder.append(", lastTime=");
            stringBuilder.append((Object)this.L);
        }
        StringBuilder stringBuilder2 = stringBuilder.replace(0, 2, "Event{");
        stringBuilder2.append('}');
        return stringBuilder2.toString();
    }

    public static final class a
    extends dl.a {
        public Long A;
        public eb c;
        public String d;
        public Long e;
        public Long f;
        public String g;
        public Long h;
        public Long i;
        public ed j;
        public dx k;
        public ek l;
        public Integer m;
        public Integer n;
        public ea o;
        public eg p;
        public String q;
        public String r;
        public ef s;
        public String t;
        public String u;
        public String v;
        public List w = ds.a();
        public String x;
        public Integer y;
        public Long z;

        public final dy b() {
            Long l2;
            String string;
            eb eb2 = this.c;
            if (eb2 != null && (string = this.d) != null && (l2 = this.e) != null) {
                dy dy2 = new dy(eb2, string, l2, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.v, this.w, this.x, this.y, this.z, this.A, super.a());
                return dy2;
            }
            Object[] arrobject = new Object[]{this.c, "type", this.d, "name", this.e, "time"};
            throw ds.a(arrobject);
        }
    }

    static final class b
    extends dn {
        b() {
            super(dk.c, dy.class);
        }

        private static dy b(do do_) {
            int n2;
            a a2 = new a();
            long l2 = do_.a();
            block29 : while ((n2 = do_.b()) != -1) {
                switch (n2) {
                    default: {
                        dk dk2 = do_.c();
                        a2.a(n2, dk2, dk2.a().a(do_));
                        continue block29;
                    }
                    case 25: {
                        a2.A = (Long)dn.i.a(do_);
                        continue block29;
                    }
                    case 24: {
                        a2.z = (Long)dn.i.a(do_);
                        continue block29;
                    }
                    case 23: {
                        a2.y = (Integer)dn.d.a(do_);
                        continue block29;
                    }
                    case 22: {
                        a2.x = (String)dn.p.a(do_);
                        continue block29;
                    }
                    case 21: {
                        a2.h = (Long)dn.i.a(do_);
                        continue block29;
                    }
                    case 20: {
                        a2.g = (String)dn.p.a(do_);
                        continue block29;
                    }
                    case 19: {
                        a2.f = (Long)dn.i.a(do_);
                        continue block29;
                    }
                    case 18: {
                        a2.s = (ef)ef.c.a(do_);
                        continue block29;
                    }
                    case 17: {
                        a2.w.add(ec.c.a(do_));
                        continue block29;
                    }
                    case 16: {
                        a2.v = (String)dn.p.a(do_);
                        continue block29;
                    }
                    case 15: {
                        a2.u = (String)dn.p.a(do_);
                        continue block29;
                    }
                    case 14: {
                        a2.t = (String)dn.p.a(do_);
                        continue block29;
                    }
                    case 13: {
                        a2.r = (String)dn.p.a(do_);
                        continue block29;
                    }
                    case 12: {
                        a2.q = (String)dn.p.a(do_);
                        continue block29;
                    }
                    case 11: {
                        a2.p = (eg)eg.c.a(do_);
                        continue block29;
                    }
                    case 10: {
                        a2.o = (ea)ea.c.a(do_);
                        continue block29;
                    }
                    case 9: {
                        a2.n = (Integer)dn.d.a(do_);
                        continue block29;
                    }
                    case 8: {
                        a2.m = (Integer)dn.d.a(do_);
                        continue block29;
                    }
                    case 7: {
                        a2.l = (ek)ek.c.a(do_);
                        continue block29;
                    }
                    case 6: {
                        a2.k = (dx)dx.c.a(do_);
                        continue block29;
                    }
                    case 5: {
                        a2.j = (ed)ed.c.a(do_);
                        continue block29;
                    }
                    case 4: {
                        a2.i = (Long)dn.i.a(do_);
                        continue block29;
                    }
                    case 3: {
                        a2.e = (Long)dn.i.a(do_);
                        continue block29;
                    }
                    case 2: {
                        a2.d = (String)dn.p.a(do_);
                        continue block29;
                    }
                    case 1: 
                }
                try {
                    a2.c = (eb)eb.ADAPTER.a(do_);
                }
                catch (dn.a a3) {
                    a2.a(n2, dk.a, a3.a);
                }
            }
            do_.a(l2);
            return a2.b();
        }

        @Override
        public final /* synthetic */ int a(Object object) {
            dy dy2 = (dy)object;
            int n2 = eb.ADAPTER.a(1, (Object)dy2.n) + dn.p.a(2, (Object)dy2.o) + dn.i.a(3, (Object)dy2.p);
            int n3 = dy2.q != null ? dn.i.a(19, (Object)dy2.q) : 0;
            int n4 = n2 + n3;
            int n5 = dy2.r != null ? dn.p.a(20, (Object)dy2.r) : 0;
            int n6 = n4 + n5;
            int n7 = dy2.s != null ? dn.i.a(21, (Object)dy2.s) : 0;
            int n8 = n6 + n7;
            int n9 = dy2.t != null ? dn.i.a(4, (Object)dy2.t) : 0;
            int n10 = n8 + n9;
            int n11 = dy2.u != null ? ed.c.a(5, (Object)dy2.u) : 0;
            int n12 = n10 + n11;
            int n13 = dy2.v != null ? dx.c.a(6, (Object)dy2.v) : 0;
            int n14 = n12 + n13;
            int n15 = dy2.w != null ? ek.c.a(7, (Object)dy2.w) : 0;
            int n16 = n14 + n15;
            int n17 = dy2.x != null ? dn.d.a(8, (Object)dy2.x) : 0;
            int n18 = n16 + n17;
            int n19 = dy2.y != null ? dn.d.a(9, (Object)dy2.y) : 0;
            int n20 = n18 + n19;
            int n21 = dy2.z != null ? ea.c.a(10, (Object)dy2.z) : 0;
            int n22 = n20 + n21;
            int n23 = dy2.A != null ? eg.c.a(11, (Object)dy2.A) : 0;
            int n24 = n22 + n23;
            int n25 = dy2.B != null ? dn.p.a(12, (Object)dy2.B) : 0;
            int n26 = n24 + n25;
            int n27 = dy2.C != null ? dn.p.a(13, (Object)dy2.C) : 0;
            int n28 = n26 + n27;
            int n29 = dy2.D != null ? ef.c.a(18, (Object)dy2.D) : 0;
            int n30 = n28 + n29;
            int n31 = dy2.E != null ? dn.p.a(14, (Object)dy2.E) : 0;
            int n32 = n30 + n31;
            int n33 = dy2.F != null ? dn.p.a(15, (Object)dy2.F) : 0;
            int n34 = n32 + n33;
            int n35 = dy2.G != null ? dn.p.a(16, (Object)dy2.G) : 0;
            int n36 = n34 + n35 + ec.c.a().a(17, (Object)dy2.H);
            int n37 = dy2.I != null ? dn.p.a(22, (Object)dy2.I) : 0;
            int n38 = n36 + n37;
            int n39 = dy2.J != null ? dn.d.a(23, (Object)dy2.J) : 0;
            int n40 = n38 + n39;
            int n41 = dy2.K != null ? dn.i.a(24, (Object)dy2.K) : 0;
            int n42 = n40 + n41;
            Long l2 = dy2.L;
            int n43 = 0;
            if (l2 != null) {
                n43 = dn.i.a(25, (Object)dy2.L);
            }
            return n42 + n43 + dy2.a().c();
        }

        @Override
        public final /* synthetic */ Object a(do do_) {
            return b.b(do_);
        }
    }

}

