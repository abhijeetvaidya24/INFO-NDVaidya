/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.res.Resources
 *  android.util.DisplayMetrics
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  com.adincube.sdk.d.a.a.c
 *  com.adincube.sdk.g.b.a.c
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package com.adincube.sdk.g.b.a.a;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.adincube.sdk.AdinCubeBannerEventListener;
import com.adincube.sdk.BannerView;
import com.adincube.sdk.g.a.b;
import com.adincube.sdk.g.b.a.a;
import com.adincube.sdk.g.b.a.c;
import com.adincube.sdk.util.ErrorReportingHelper;
import com.adincube.sdk.util.b.j;
import com.adincube.sdk.util.o;

public abstract class a {
    protected com.adincube.sdk.h.c.c a;
    protected Integer b = null;
    protected int c = 0;
    protected BannerView d;
    protected com.adincube.sdk.g.b.a.a.c e;
    protected com.adincube.sdk.g.a f;
    protected b g;
    protected com.adincube.sdk.g.b.a.a h;
    protected c i;
    protected String j = null;

    public a(BannerView bannerView, com.adincube.sdk.g.b.a.a.c c2, com.adincube.sdk.g.a a2, b b2, com.adincube.sdk.g.b.a.a a3, c c3) {
        this.d = bannerView;
        this.e = c2;
        this.f = a2;
        this.g = b2;
        this.i = c3;
        this.h = a3;
    }

    protected final LinearLayout.LayoutParams a(View view) {
        LinearLayout.LayoutParams layoutParams = view.getLayoutParams() == null ? (this.a == com.adincube.sdk.h.c.c.b ? new LinearLayout.LayoutParams(-1, -2) : new LinearLayout.LayoutParams(this.a.a(this.d.getResources().getDisplayMetrics()), this.a.b(this.d.getResources().getDisplayMetrics()))) : new LinearLayout.LayoutParams(view.getLayoutParams());
        layoutParams.gravity = 1;
        return layoutParams;
    }

    protected final com.adincube.sdk.h.c.a a() {
        return this.i.b();
    }

    public void a(int n2) {
        this.b = n2;
    }

    protected final void a(com.adincube.sdk.d.a.c c2) {
        try {
            c2.a();
            com.adincube.sdk.g.b.a.a a2 = this.h;
            new StringBuilder("onError - ").append(c2.a);
            o.b(a2.b, new com.adincube.sdk.util.c.a<AdinCubeBannerEventListener>(a2, c2){
                final /* synthetic */ com.adincube.sdk.d.a.c a;
                final /* synthetic */ com.adincube.sdk.g.b.a.a b;
                {
                    this.b = a2;
                    this.a = c2;
                }

                public final /* synthetic */ void a(Object object) {
                    ((AdinCubeBannerEventListener)object).onError(this.b.a, this.a.a);
                }
            });
            return;
        }
        catch (Throwable throwable) {
            com.adincube.sdk.util.a.c("BannerView.printShowError", new Object[]{throwable});
            ErrorReportingHelper.report("BannerView.printShowError", throwable);
            return;
        }
    }

    public final void a(com.adincube.sdk.h.c.c c2) {
        this.a = c2;
    }

    public void a(boolean bl) {
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public final void b() {
        if (this.a != com.adincube.sdk.h.c.c.b) {
            var19_1 = j.a((Context)this.d.getContext()).widthPixels;
            var20_2 = j.a((Context)this.d.getContext()).heightPixels;
            if (this.a.a(this.d.getContext(), var19_1, var20_2) == false) throw new com.adincube.sdk.d.a.a.c(this.d, this.a);
        }
        if (this.d.getMeasuredWidth() <= 0 && this.d.getMeasuredHeight() <= 0) {
            var15_3 = this.d.getLayoutParams();
            var16_4 = this.a;
            var17_5 = this.d.getContext();
            var18_6 = var15_3 == null ? true : var16_4.a(var17_5, var15_3.width, var15_3.height);
            if (var18_6 == false) throw new com.adincube.sdk.d.a.a.c(this.d, this.a);
            return;
        }
        var1_7 = this.d.getLayoutParams();
        var2_8 = var1_7.width;
        var3_9 = var1_7.height;
        if (var2_8 != -2) {
            var2_8 = this.d.getMeasuredWidth();
        }
        if (var3_9 != -2) {
            var3_9 = this.d.getMeasuredHeight();
        }
        var4_10 = this.a;
        var5_11 = this.d.getContext();
        if (!(var5_11 instanceof Activity) || (var6_13 = ((Activity)var5_11).findViewById(16908290)) == null) ** GOTO lbl-1000
        var7_14 = var6_13.getWidth();
        if (var7_14 == 0) {
            var7_14 = var6_13.getMeasuredWidth();
        }
        if ((var8_15 = var6_13.getHeight()) == 0) {
            var8_15 = var6_13.getMeasuredHeight();
        }
        if (var7_14 == 0 || var8_15 == 0) lbl-1000: // 2 sources:
        {
            var13_12 = var4_10.a(var5_11, var2_8, var3_9);
        } else {
            var9_16 = j.a(var5_11, var2_8);
            var10_17 = j.a(var5_11, var3_9);
            var11_18 = j.a(var5_11, var7_14);
            j.a(var5_11, var8_15);
            var13_12 = var4_10.a(var9_16, var10_17, var11_18);
        }
        if (var13_12) {
            return;
        }
        var14_19 = new com.adincube.sdk.d.a.a.c(this.d, this.a);
        throw var14_19;
    }

    public void b(int n2) {
        this.c = n2;
    }

    public void c() {
    }

    public void d() {
    }

    public void e() {
    }

    public void f() {
    }

    public void g() {
    }

    public final String h() {
        return this.j;
    }
}

