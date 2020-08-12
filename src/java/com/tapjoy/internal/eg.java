/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.Integer
 *  java.lang.Long
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

public final class eg
extends dl {
    public static final dn c = new b();
    public static final Integer d = 1;
    public static final Double e = 0.0;
    public static final Integer f = 0;
    public static final Long g = 0L;
    public final String h;
    public final Integer i;
    public final Double j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;
    public final String o;
    public final Integer p;
    public final Long q;
    public final String r;
    public final String s;
    public final String t;
    public final String u;

    public eg(String string, Integer n2, Double d2, String string2, String string3, String string4, String string5, String string6, Integer n3, Long l2, String string7, String string8, String string9, String string10, hx hx2) {
        super(c, hx2);
        this.h = string;
        this.i = n2;
        this.j = d2;
        this.k = string2;
        this.l = string3;
        this.m = string4;
        this.n = string5;
        this.o = string6;
        this.p = n3;
        this.q = l2;
        this.r = string7;
        this.s = string8;
        this.t = string9;
        this.u = string10;
    }

    public final boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof eg)) {
            return false;
        }
        eg eg2 = (eg)object;
        return this.a().equals(eg2.a()) && this.h.equals((Object)eg2.h) && ds.a((Object)this.i, (Object)eg2.i) && ds.a((Object)this.j, (Object)eg2.j) && ds.a((Object)this.k, (Object)eg2.k) && ds.a((Object)this.l, (Object)eg2.l) && ds.a((Object)this.m, (Object)eg2.m) && ds.a((Object)this.n, (Object)eg2.n) && ds.a((Object)this.o, (Object)eg2.o) && ds.a((Object)this.p, (Object)eg2.p) && ds.a((Object)this.q, (Object)eg2.q) && ds.a((Object)this.r, (Object)eg2.r) && ds.a((Object)this.s, (Object)eg2.s) && ds.a((Object)this.t, (Object)eg2.t) && ds.a((Object)this.u, (Object)eg2.u);
    }

    public final int hashCode() {
        int n2 = this.b;
        if (n2 == 0) {
            int n3 = 37 * (37 * this.a().hashCode() + this.h.hashCode());
            Integer n4 = this.i;
            int n5 = n4 != null ? n4.hashCode() : 0;
            int n6 = 37 * (n3 + n5);
            Double d2 = this.j;
            int n7 = d2 != null ? d2.hashCode() : 0;
            int n8 = 37 * (n6 + n7);
            String string = this.k;
            int n9 = string != null ? string.hashCode() : 0;
            int n10 = 37 * (n8 + n9);
            String string2 = this.l;
            int n11 = string2 != null ? string2.hashCode() : 0;
            int n12 = 37 * (n10 + n11);
            String string3 = this.m;
            int n13 = string3 != null ? string3.hashCode() : 0;
            int n14 = 37 * (n12 + n13);
            String string4 = this.n;
            int n15 = string4 != null ? string4.hashCode() : 0;
            int n16 = 37 * (n14 + n15);
            String string5 = this.o;
            int n17 = string5 != null ? string5.hashCode() : 0;
            int n18 = 37 * (n16 + n17);
            Integer n19 = this.p;
            int n20 = n19 != null ? n19.hashCode() : 0;
            int n21 = 37 * (n18 + n20);
            Long l2 = this.q;
            int n22 = l2 != null ? l2.hashCode() : 0;
            int n23 = 37 * (n21 + n22);
            String string6 = this.r;
            int n24 = string6 != null ? string6.hashCode() : 0;
            int n25 = 37 * (n23 + n24);
            String string7 = this.s;
            int n26 = string7 != null ? string7.hashCode() : 0;
            int n27 = 37 * (n25 + n26);
            String string8 = this.t;
            int n28 = string8 != null ? string8.hashCode() : 0;
            int n29 = 37 * (n27 + n28);
            String string9 = this.u;
            int n30 = 0;
            if (string9 != null) {
                n30 = string9.hashCode();
            }
            this.b = n2 = n29 + n30;
        }
        return n2;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(", productId=");
        stringBuilder.append(this.h);
        if (this.i != null) {
            stringBuilder.append(", productQuantity=");
            stringBuilder.append((Object)this.i);
        }
        if (this.j != null) {
            stringBuilder.append(", productPrice=");
            stringBuilder.append((Object)this.j);
        }
        if (this.k != null) {
            stringBuilder.append(", productPriceCurrency=");
            stringBuilder.append(this.k);
        }
        if (this.l != null) {
            stringBuilder.append(", productType=");
            stringBuilder.append(this.l);
        }
        if (this.m != null) {
            stringBuilder.append(", productTitle=");
            stringBuilder.append(this.m);
        }
        if (this.n != null) {
            stringBuilder.append(", productDescription=");
            stringBuilder.append(this.n);
        }
        if (this.o != null) {
            stringBuilder.append(", transactionId=");
            stringBuilder.append(this.o);
        }
        if (this.p != null) {
            stringBuilder.append(", transactionState=");
            stringBuilder.append((Object)this.p);
        }
        if (this.q != null) {
            stringBuilder.append(", transactionDate=");
            stringBuilder.append((Object)this.q);
        }
        if (this.r != null) {
            stringBuilder.append(", campaignId=");
            stringBuilder.append(this.r);
        }
        if (this.s != null) {
            stringBuilder.append(", currencyPrice=");
            stringBuilder.append(this.s);
        }
        if (this.t != null) {
            stringBuilder.append(", receipt=");
            stringBuilder.append(this.t);
        }
        if (this.u != null) {
            stringBuilder.append(", signature=");
            stringBuilder.append(this.u);
        }
        StringBuilder stringBuilder2 = stringBuilder.replace(0, 2, "Purchase{");
        stringBuilder2.append('}');
        return stringBuilder2.toString();
    }

    public static final class a
    extends dl.a {
        public String c;
        public Integer d;
        public Double e;
        public String f;
        public String g;
        public String h;
        public String i;
        public String j;
        public Integer k;
        public Long l;
        public String m;
        public String n;
        public String o;
        public String p;

        public final eg b() {
            String string = this.c;
            if (string != null) {
                eg eg2 = new eg(string, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, super.a());
                return eg2;
            }
            throw ds.a(new Object[]{string, "productId"});
        }
    }

    static final class b
    extends dn {
        b() {
            super(dk.c, eg.class);
        }

        @Override
        public final /* synthetic */ int a(Object object) {
            eg eg2 = (eg)object;
            int n2 = dn.p.a(1, (Object)eg2.h);
            int n3 = eg2.i != null ? dn.d.a(2, (Object)eg2.i) : 0;
            int n4 = n2 + n3;
            int n5 = eg2.j != null ? dn.o.a(3, (Object)eg2.j) : 0;
            int n6 = n4 + n5;
            int n7 = eg2.k != null ? dn.p.a(4, (Object)eg2.k) : 0;
            int n8 = n6 + n7;
            int n9 = eg2.l != null ? dn.p.a(5, (Object)eg2.l) : 0;
            int n10 = n8 + n9;
            int n11 = eg2.m != null ? dn.p.a(6, (Object)eg2.m) : 0;
            int n12 = n10 + n11;
            int n13 = eg2.n != null ? dn.p.a(7, (Object)eg2.n) : 0;
            int n14 = n12 + n13;
            int n15 = eg2.o != null ? dn.p.a(8, (Object)eg2.o) : 0;
            int n16 = n14 + n15;
            int n17 = eg2.p != null ? dn.d.a(9, (Object)eg2.p) : 0;
            int n18 = n16 + n17;
            int n19 = eg2.q != null ? dn.i.a(10, (Object)eg2.q) : 0;
            int n20 = n18 + n19;
            int n21 = eg2.r != null ? dn.p.a(11, (Object)eg2.r) : 0;
            int n22 = n20 + n21;
            int n23 = eg2.s != null ? dn.p.a(12, (Object)eg2.s) : 0;
            int n24 = n22 + n23;
            int n25 = eg2.t != null ? dn.p.a(13, (Object)eg2.t) : 0;
            int n26 = n24 + n25;
            String string = eg2.u;
            int n27 = 0;
            if (string != null) {
                n27 = dn.p.a(14, (Object)eg2.u);
            }
            return n26 + n27 + eg2.a().c();
        }

        @Override
        public final /* synthetic */ Object a(do do_) {
            int n2;
            a a2 = new a();
            long l2 = do_.a();
            block16 : while ((n2 = do_.b()) != -1) {
                switch (n2) {
                    default: {
                        dk dk2 = do_.c();
                        a2.a(n2, dk2, dk2.a().a(do_));
                        continue block16;
                    }
                    case 14: {
                        a2.p = (String)dn.p.a(do_);
                        continue block16;
                    }
                    case 13: {
                        a2.o = (String)dn.p.a(do_);
                        continue block16;
                    }
                    case 12: {
                        a2.n = (String)dn.p.a(do_);
                        continue block16;
                    }
                    case 11: {
                        a2.m = (String)dn.p.a(do_);
                        continue block16;
                    }
                    case 10: {
                        a2.l = (Long)dn.i.a(do_);
                        continue block16;
                    }
                    case 9: {
                        a2.k = (Integer)dn.d.a(do_);
                        continue block16;
                    }
                    case 8: {
                        a2.j = (String)dn.p.a(do_);
                        continue block16;
                    }
                    case 7: {
                        a2.i = (String)dn.p.a(do_);
                        continue block16;
                    }
                    case 6: {
                        a2.h = (String)dn.p.a(do_);
                        continue block16;
                    }
                    case 5: {
                        a2.g = (String)dn.p.a(do_);
                        continue block16;
                    }
                    case 4: {
                        a2.f = (String)dn.p.a(do_);
                        continue block16;
                    }
                    case 3: {
                        a2.e = (Double)dn.o.a(do_);
                        continue block16;
                    }
                    case 2: {
                        a2.d = (Integer)dn.d.a(do_);
                        continue block16;
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

