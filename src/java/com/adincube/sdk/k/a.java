/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.adincube.sdk.h.b.d
 *  com.adincube.sdk.k.a$a
 *  java.lang.Double
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.ListIterator
 *  java.util.Map
 */
package com.adincube.sdk.k;

import com.adincube.sdk.h.b.d;
import com.adincube.sdk.k.a;
import com.adincube.sdk.k.b.b.f;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/*
 * Exception performing whole class analysis.
 */
public final class a {
    private d a;
    private double b;

    public a(d d2, int n2, int n3, float f2) {
        this.a = d2;
        double d3 = n2;
        double d4 = n3;
        Double.isNaN((double)d3);
        Double.isNaN((double)d4);
        double d5 = d3 + d4;
        double d6 = f2;
        Double.isNaN((double)d6);
        this.b = d5 / d6;
    }

    private static int a(double d2, double d3, double d4) {
        return (int)Math.floor((double)((d3 / d2 - 1.0) / d4));
    }

    public final List<a> a(List<f> list) {
        ArrayList arrayList = new ArrayList();
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            f f2 = (f)listIterator.next();
            if (!f2.b().matches(this.a.a)) continue;
            a a2 = new /* Unavailable Anonymous Inner Class!! */;
            a2.a = f2;
            a2.b = 0.0;
            arrayList.add((Object)a2);
        }
        return arrayList;
    }

    public final void b(List<a> list) {
        for (a a2 : list) {
            double d2;
            double d3;
            double d4;
            double d5 = a2.a.c() + a2.a.d();
            int n2 = a.a(this.b, d5, this.a.b);
            if (n2 >= 0) {
                d2 = a2.b;
                d4 = n2;
                d3 = this.a.c;
            } else {
                d2 = a2.b;
                d4 = -n2;
                d3 = this.a.d;
            }
            Double.isNaN((double)d4);
            a2.b = d2 + d4 * d3;
        }
    }

    public final void c(List<a> list) {
        for (a a2 : list) {
            Double d2 = (Double)this.a.e.get((Object)a2.a.b());
            if (d2 == null) continue;
            a2.b += d2.doubleValue();
        }
    }

    public final void d(List<a> list) {
        for (a a2 : list) {
            if (a2.a.e() == null) continue;
            int n2 = a.a(this.a.f, a2.a.e().intValue(), this.a.g);
            double d2 = a2.b;
            double d3 = Math.abs((int)n2);
            double d4 = this.a.h;
            Double.isNaN((double)d3);
            a2.b = d2 + d3 * d4;
        }
    }
}

