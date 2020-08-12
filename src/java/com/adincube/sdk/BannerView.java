/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.content.res.Resources
 *  android.util.DisplayMetrics
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.LinearLayout
 *  com.adincube.sdk.g.b.a.c
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.adincube.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.adincube.sdk.AdinCube;
import com.adincube.sdk.AdinCubeBannerEventListener;
import com.adincube.sdk.BannerView;
import com.adincube.sdk.g.b.a.a.b;
import com.adincube.sdk.g.b.a.a.c;
import com.adincube.sdk.g.b.a.a.d;
import com.adincube.sdk.g.b.a.a.e;
import com.adincube.sdk.g.b.c.m;
import com.adincube.sdk.g.b.g;
import com.adincube.sdk.g.b.h;
import com.adincube.sdk.g.b.k;
import com.adincube.sdk.h.c.a;
import com.adincube.sdk.h.f;
import com.adincube.sdk.util.ErrorReportingHelper;
import com.adincube.sdk.util.a.b;
import com.adincube.sdk.util.b.j;
import com.adincube.sdk.util.o;

public class BannerView
extends LinearLayout {
    private com.adincube.sdk.h.c.c a = null;
    private boolean b = true;
    private d c = null;
    private e d = null;
    private b e = null;
    private Integer f = null;
    private boolean g = false;
    private com.adincube.sdk.g.b.a.c h = null;
    private com.adincube.sdk.g.b.a.a i = null;
    private com.adincube.sdk.util.a.b j = null;
    private DisplayMetrics k = null;
    private b.a l = new b.a(this){
        final /* synthetic */ BannerView a;
        {
            this.a = bannerView;
        }

        public final void a(boolean bl) {
            try {
                BannerView.a(this.a).a(bl);
                BannerView.b(this.a).a(bl);
                BannerView.c(this.a).a(bl);
                return;
            }
            catch (Throwable throwable) {
                new Object[1][0] = throwable;
                ErrorReportingHelper.report("BannerView#OnScreenStateChangedListener.onScreenStateChanged", com.adincube.sdk.h.c.b.b, BannerView.d(this.a), throwable);
                return;
            }
        }
    };
    private c m = new c(this){
        final /* synthetic */ BannerView a;
        {
            this.a = bannerView;
        }

        public final void a(Integer n2, boolean bl) {
            if (BannerView.e(this.a) == null || bl) {
                if (bl) {
                    BannerView.a(this.a, n2);
                }
                if (n2 != null) {
                    BannerView.a(this.a, (int)n2);
                }
            }
        }
    };

    public BannerView(Context context, AdinCube.Banner.Size size) {
        super(context);
        if (size != null) {
            this.a();
            this.a(com.adincube.sdk.h.c.c.a(size));
            return;
        }
        throw new IllegalArgumentException("size must not be null.");
    }

    static /* synthetic */ d a(BannerView bannerView) {
        return bannerView.c;
    }

    static /* synthetic */ Integer a(BannerView bannerView, Integer n2) {
        bannerView.f = n2;
        return n2;
    }

    private void a() {
        this.setOrientation(1);
        this.m.a(8, true);
        this.k = this.getResources().getDisplayMetrics();
    }

    static /* synthetic */ void a(BannerView bannerView, int n2) {
        super.setVisibility(n2);
    }

    private void a(com.adincube.sdk.h.c.c c2) {
        b b2;
        e e2;
        d d2;
        com.adincube.sdk.g.b.a.c c3;
        com.adincube.sdk.util.f.a(this.getContext());
        com.adincube.sdk.util.e.a.a(this.getContext());
        com.adincube.sdk.g.a a2 = com.adincube.sdk.g.a.a();
        com.adincube.sdk.g.a.b b3 = com.adincube.sdk.g.a.b.a();
        this.j = new com.adincube.sdk.util.a.b(this.getContext(), com.adincube.sdk.h.c.b.b, this.c());
        this.j.b = this.l;
        com.adincube.sdk.util.e.b b4 = com.adincube.sdk.util.e.b.a();
        h h2 = h.a();
        com.adincube.sdk.g.b.e.b.c c4 = new com.adincube.sdk.g.b.e.b.c();
        com.adincube.sdk.g.b.e e3 = new com.adincube.sdk.g.b.e(com.adincube.sdk.h.c.b.b, a2);
        m m2 = m.a();
        com.adincube.sdk.g.b.f f2 = com.adincube.sdk.g.b.f.a(com.adincube.sdk.h.c.b.b);
        g g2 = g.a();
        com.adincube.sdk.g.h.a a3 = com.adincube.sdk.g.h.a.a(this.getContext());
        com.adincube.sdk.g.g.d d3 = com.adincube.sdk.g.g.d.a();
        k k2 = k.a();
        com.adincube.sdk.g.b.c c5 = new com.adincube.sdk.g.b.c(com.adincube.sdk.h.c.b.b, a2, e3, g2, h2, d3);
        this.i = new com.adincube.sdk.g.b.a.a(this, a2);
        this.h = c3 = new com.adincube.sdk.g.b.a.c(this.getContext(), a2, b4, this.i, h2, (com.adincube.sdk.g.b.e.b.b)c4, (com.adincube.sdk.g.b.j)c5, m2, f2, g2, d3, k2);
        this.c = d2 = new d(this, this.m, a2, b3, this.i, this.h);
        this.e = b2 = new b(this, this.m, a2, b3, a3, this.i, this.h);
        this.d = e2 = new e(this, this.m, a2, b3, this.i, this.h, this.e);
        this.b(c2);
    }

    static /* synthetic */ e b(BannerView bannerView) {
        return bannerView.d;
    }

    private static void b() {
        if (!o.a()) {
            com.adincube.sdk.util.a.c("Update on the UI in background thread is not supported by Android and will lead to unpredictable behavior.", new Object[0]);
        }
    }

    private void b(com.adincube.sdk.h.c.c c2) {
        this.a = c2;
        com.adincube.sdk.g.b.a.c c3 = this.h;
        c3.o = c2;
        if (c2 != null) {
            c3.j.b = c2.i;
            c3.c.a(c2.i);
        }
        this.c.a(c2);
        this.d.a(c2);
        this.e.a(c2);
    }

    static /* synthetic */ b c(BannerView bannerView) {
        return bannerView.e;
    }

    private a c() {
        com.adincube.sdk.h.c.c c2 = this.a;
        if (c2 == null) {
            return null;
        }
        return c2.i;
    }

    static /* synthetic */ a d(BannerView bannerView) {
        return bannerView.c();
    }

    private f d() {
        f f2;
        if (this.getChildCount() == 0) {
            f2 = null;
        } else {
            View view = this.getChildAt(0);
            f f3 = new f(view.getWidth(), view.getHeight());
            int n2 = f3.a;
            f2 = null;
            if (n2 != 0) {
                f2 = f3.b == 0 ? null : f3;
            }
        }
        if (f2 == null) {
            f2 = this.h.o();
        }
        if (this.a == com.adincube.sdk.h.c.c.b) {
            int n3 = j.a((Context)this.getContext()).widthPixels;
            if (f2 != null && f2.a < n3) {
                f2 = new f(n3, f2.b);
            }
        }
        return f2;
    }

    static /* synthetic */ Integer e(BannerView bannerView) {
        return bannerView.f;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void destroy() {
        try {
            IllegalArgumentException illegalArgumentException2;
            block6 : {
                if (!o.a()) {
                    o.a(new Runnable(){

                        public final void run() {
                            BannerView.this.destroy();
                        }
                    });
                    return;
                }
                try {
                    if (this.getChildCount() > 0) {
                        this.removeAllViews();
                    }
                }
                catch (IllegalArgumentException illegalArgumentException2) {
                    if (illegalArgumentException2.getMessage() == null || !illegalArgumentException2.getMessage().startsWith("Receiver not registered: android.webkit.WebViewClassic")) break block6;
                }
                this.h.m();
                this.c.g();
                this.d.g();
                this.e.g();
                return;
            }
            throw illegalArgumentException2;
        }
        catch (Throwable throwable) {
            new Object[1][0] = throwable;
            ErrorReportingHelper.report("BannerView.dismiss", com.adincube.sdk.h.c.b.b, this.c(), throwable);
            return;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public Integer getExpectedHeight() {
        f f2 = this.d();
        if (f2 == null) return null;
        try {
            return f2.b;
        }
        catch (Throwable throwable) {
            com.adincube.sdk.util.a.c("BannerView.getExpectedHeight", new Object[]{throwable});
            ErrorReportingHelper.report("BannerView.getExpectedHeight", com.adincube.sdk.h.c.b.b, throwable);
        }
        return null;
    }

    public String getExpectedNetwork() {
        try {
            String string = this.h.l();
            return string;
        }
        catch (Throwable throwable) {
            com.adincube.sdk.util.a.c("BannerView.getExpectedNetwork", new Object[]{throwable});
            ErrorReportingHelper.report("BannerView.getExpectedNetwork", com.adincube.sdk.h.c.b.b, throwable);
            return null;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public Integer getExpectedWidth() {
        f f2 = this.d();
        if (f2 == null) return null;
        try {
            return f2.a;
        }
        catch (Throwable throwable) {
            com.adincube.sdk.util.a.c("BannerView.getExpectedWidth", new Object[]{throwable});
            ErrorReportingHelper.report("BannerView.getExpectedWidth", com.adincube.sdk.h.c.b.b, throwable);
        }
        return null;
    }

    public String getNetwork() {
        String string;
        block5 : {
            try {
                string = this.e.h();
                if (string != null) break block5;
            }
            catch (Throwable throwable) {
                com.adincube.sdk.util.a.c("BannerView.getNetwork", new Object[]{throwable});
                ErrorReportingHelper.report("BannerView.getNetwork", com.adincube.sdk.h.c.b.b, throwable);
                return null;
            }
            string = this.d.h();
        }
        if (string == null) {
            string = this.c.h();
        }
        return string;
    }

    public void load() {
        this.c.i();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        try {
            BannerView.b();
            if (!this.g) {
                this.getContext().registerReceiver((BroadcastReceiver)this.j, new IntentFilter("android.intent.action.SCREEN_ON"));
                this.getContext().registerReceiver((BroadcastReceiver)this.j, new IntentFilter("android.intent.action.SCREEN_OFF"));
                this.g = true;
            }
            this.c.d();
            this.d.d();
            this.e.d();
            return;
        }
        catch (Throwable throwable) {
            new Object[1][0] = throwable;
            ErrorReportingHelper.report("BannerView.onAttachedToWindow", com.adincube.sdk.h.c.b.b, this.c(), throwable);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            block7 : {
                BannerView.b();
                boolean bl = this.g;
                if (bl) {
                    IllegalArgumentException illegalArgumentException2;
                    block6 : {
                        try {
                            this.getContext().unregisterReceiver((BroadcastReceiver)this.j);
                        }
                        catch (IllegalArgumentException illegalArgumentException2) {
                            if (illegalArgumentException2.getMessage() == null || !illegalArgumentException2.getMessage().startsWith("Receiver not registered")) break block6;
                        }
                        this.g = false;
                        break block7;
                    }
                    throw illegalArgumentException2;
                }
            }
            this.c.f();
            this.d.f();
            this.e.f();
        }
        catch (Exception exception) {
            com.adincube.sdk.util.a.c("BannerView.onDetachedFromWindow", new Object[]{exception});
            ErrorReportingHelper.report("BannerView.onDetachedFromWindow", com.adincube.sdk.h.c.b.b, this.c(), (Throwable)exception);
        }
        if (this.b) {
            this.destroy();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected void onMeasure(int n2, int n3) {
        super.onMeasure(n2, n3);
        try {
            block4 : {
                int n4;
                int n5;
                block6 : {
                    int n6;
                    block5 : {
                        BannerView.b();
                        n6 = View.MeasureSpec.getSize((int)n2);
                        if (View.MeasureSpec.getMode((int)n2) == 1073741824) break block4;
                        if (this.a != com.adincube.sdk.h.c.c.b) break block5;
                        n5 = View.MeasureSpec.makeMeasureSpec((int)n6, (int)1073741824);
                        n4 = this.getMeasuredHeightAndState();
                        break block6;
                    }
                    if (this.getMeasuredWidth() != 0) break block4;
                    n5 = View.MeasureSpec.makeMeasureSpec((int)Math.min((int)n6, (int)this.a.a(this.k)), (int)1073741824);
                    n4 = this.getMeasuredHeightAndState();
                }
                this.setMeasuredDimension(n5, n4);
            }
            this.c.e();
            this.d.e();
            this.e.e();
            return;
        }
        catch (Throwable throwable) {
            com.adincube.sdk.util.a.c("BannerView.onMeasure", new Object[]{throwable});
            ErrorReportingHelper.report("BannerView.onMeasure", com.adincube.sdk.h.c.b.b, this.c(), throwable);
            return;
        }
    }

    protected void onWindowVisibilityChanged(int n2) {
        super.onWindowVisibilityChanged(n2);
        try {
            BannerView.b();
            this.c.b(n2);
            this.d.b(n2);
            this.e.b(n2);
            return;
        }
        catch (Throwable throwable) {
            com.adincube.sdk.util.a.c("BannerView.onWindowVisibilityChanged", new Object[]{throwable});
            ErrorReportingHelper.report("BannerView.onWindowVisibilityChanged", com.adincube.sdk.h.c.b.b, this.c(), throwable);
            return;
        }
    }

    public void setAutoDestroyOnDetach(boolean bl) {
        this.b = bl;
    }

    public void setEventListener(AdinCubeBannerEventListener adinCubeBannerEventListener) {
        this.i.b = adinCubeBannerEventListener;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
        try {
            if (this.a == null) {
                com.adincube.sdk.h.c.c c2;
                if (layoutParams == null) {
                    c2 = com.adincube.sdk.h.c.c.a;
                } else {
                    float f2 = this.k.density;
                    int n2 = layoutParams.height;
                    if (n2 > 0) {
                        n2 = (int)((float)n2 / f2);
                    }
                    c2 = com.adincube.sdk.h.c.c.a(n2);
                }
                this.b(c2);
                new Object[1][0] = this.a;
                if (this.a == com.adincube.sdk.h.c.c.b) {
                    this.setVisibility(0);
                }
            }
            this.c.c();
            this.d.c();
            this.e.c();
            return;
        }
        catch (Throwable throwable) {
            com.adincube.sdk.util.a.c("BannerView.setLayoutParams", new Object[]{throwable});
            ErrorReportingHelper.report("BannerView.setLayoutParams", com.adincube.sdk.h.c.b.b, this.c(), throwable);
            return;
        }
    }

    public void setVisibility(int n2) {
        this.m.a(n2, false);
        this.c.a(n2);
        this.d.a(n2);
        this.e.a(n2);
    }

}

