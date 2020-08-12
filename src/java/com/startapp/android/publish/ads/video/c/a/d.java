/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Double
 *  java.lang.Math
 *  java.util.Comparator
 */
package com.startapp.android.publish.ads.video.c.a;

import android.content.Context;
import com.startapp.android.publish.ads.video.c.a.a.b;
import com.startapp.android.publish.ads.video.c.a.c;
import com.startapp.android.publish.ads.video.c.a.d;
import java.util.Comparator;

public class d
extends c {
    private final double c;
    private final int d;
    private final int e;

    public d(Context context, int n2) {
        super(context);
        this.e = n2;
        double d2 = this.a;
        double d3 = this.b;
        Double.isNaN((double)d2);
        Double.isNaN((double)d3);
        this.c = d2 / d3;
        this.d = this.a * this.b;
    }

    static /* synthetic */ double a(d d2) {
        return d2.c;
    }

    static /* synthetic */ int a(int n2, int n3) {
        return d.b(n2, n3);
    }

    private Double a(int n2, int n3, double d2, int n4) {
        double d3 = n2;
        double d4 = n3;
        Double.isNaN((double)d3);
        Double.isNaN((double)d4);
        double d5 = d3 / d4;
        int n5 = n2 * n3;
        double d6 = d5 / d2;
        double d7 = n5;
        double d8 = n4;
        Double.isNaN((double)d7);
        Double.isNaN((double)d8);
        double d9 = d7 / d8;
        return 40.0 * Math.abs((double)Math.log((double)d6)) + 60.0 * Math.abs((double)Math.log((double)d9));
    }

    static /* synthetic */ Double a(d d2, int n2, int n3, double d3, int n4) {
        return d2.a(n2, n3, d3, n4);
    }

    private static int b(int n2, int n3) {
        if (n2 < n3) {
            return -1;
        }
        return n2 != n3;
    }

    static /* synthetic */ int b(d d2) {
        return d2.d;
    }

    static /* synthetic */ int c(d d2) {
        return d2.e;
    }

    @Override
    protected Comparator<b> a() {
        return new Comparator<b>(this){
            final /* synthetic */ d a;
            {
                this.a = d2;
            }

            public int a(b b2, b b3) {
                double d2;
                double d3 = d.a(this.a, b2.d(), b2.e(), d.a(this.a), d.b(this.a));
                if (d3 < (d2 = d.a(this.a, b3.d(), b3.e(), d.a(this.a), d.b(this.a)).doubleValue())) {
                    return -1;
                }
                if (d3 > d2) {
                    return 1;
                }
                java.lang.Integer n2 = b2.c();
                java.lang.Integer n3 = b3.c();
                if (n2 == null && n3 == null) {
                    return 0;
                }
                if (n2 == null) {
                    return 1;
                }
                if (n3 == null) {
                    return -1;
                }
                java.lang.Integer n4 = Math.abs((int)(d.c(this.a) - n2));
                java.lang.Integer n5 = Math.abs((int)(d.c(this.a) - n3));
                return d.a(n4, n5);
            }

            public /* synthetic */ int compare(java.lang.Object object, java.lang.Object object2) {
                return this.a((b)object, (b)object2);
            }
        };
    }
}

