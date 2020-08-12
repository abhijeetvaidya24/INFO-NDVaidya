/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.View$OnTouchListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.webkit.WebView
 *  com.adincube.sdk.g.a
 *  com.adincube.sdk.g.e.a
 *  com.adincube.sdk.g.e.b
 *  com.adincube.sdk.g.e.b.a
 *  com.adincube.sdk.h.a.b
 *  com.adincube.sdk.h.a.e
 *  com.adincube.sdk.h.c.a
 *  com.adincube.sdk.h.c.b
 *  com.adincube.sdk.h.c.c
 *  com.adincube.sdk.i.c
 *  com.adincube.sdk.i.c$c
 *  com.adincube.sdk.i.c$d
 *  com.adincube.sdk.i.e
 *  com.adincube.sdk.i.f
 *  com.adincube.sdk.l.c$2
 *  com.adincube.sdk.l.c$3
 *  com.adincube.sdk.mediation.w.f
 *  com.adincube.sdk.util.f.a.a
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.Throwable
 */
package com.adincube.sdk.l;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.adincube.sdk.g.e.a;
import com.adincube.sdk.h.a.e;
import com.adincube.sdk.h.c.b;
import com.adincube.sdk.i.c;
import com.adincube.sdk.i.f;
import com.adincube.sdk.l.c;
import com.adincube.sdk.util.ErrorReportingHelper;
import com.adincube.sdk.util.o;
import com.adincube.sdk.util.v;

public final class c
extends ViewGroup {
    public com.adincube.sdk.util.f.b a = null;
    public com.adincube.sdk.util.f.a.b b = null;
    private com.adincube.sdk.h.a.b c = null;
    private com.adincube.sdk.h.c.c d = null;
    private WebView e = null;
    private com.adincube.sdk.i.c f = null;
    private com.adincube.sdk.util.f.a.a g = null;
    private com.adincube.sdk.i.e h = null;
    private com.adincube.sdk.g.e.b.a i = null;
    private boolean j = false;
    private c.c k = new 2(this);
    private c.d l = new 3(this);

    public c(Context context, com.adincube.sdk.h.c.c c2, com.adincube.sdk.h.a.b b2, com.adincube.sdk.mediation.w.f f2) {
        super(context);
        this.c = b2;
        this.d = c2;
        com.adincube.sdk.g.a a2 = com.adincube.sdk.g.a.a();
        v v2 = v.a();
        this.i = new com.adincube.sdk.g.e.b.a((e)b2, f2, new a(a2, new com.adincube.sdk.g.e.b(b.b), v2));
        this.a = new com.adincube.sdk.util.f.b();
        this.g = new com.adincube.sdk.util.f.a.a(context, f2, this.a, this.i);
        this.h = new com.adincube.sdk.i.e();
        this.b = new com.adincube.sdk.util.f.a.b((e)b2, c2, f2, this.h);
        com.adincube.sdk.util.f.b b3 = this.a;
        b3.a = b2;
        b3.a(f2);
        try {
            this.e = new WebView(context);
            com.adincube.sdk.i.c c3 = new com.adincube.sdk.i.c(context, (e)b2, f2);
            c3.l = this.k;
            c3.m = this.l;
            this.f = c3;
            this.f.a(this.e);
            com.adincube.sdk.g.e.b.a a3 = this.i;
            this.e.setOnTouchListener((View.OnTouchListener)a3);
            this.addView((View)this.e, new ViewGroup.LayoutParams(-1, -1));
            return;
        }
        catch (Throwable throwable) {
            com.adincube.sdk.util.a.c("RTBBannerView", new Object[]{throwable});
            ErrorReportingHelper.report("RTBBannerView", b.b, c2.i, throwable);
            return;
        }
    }

    static /* synthetic */ void b(c c2) {
        try {
            if (!c2.j) {
                c2.j = true;
                c2.f.a(f.b);
                c2.f.b();
                c2.f.a();
                c2.i.a();
            }
            return;
        }
        catch (Throwable throwable) {
            com.adincube.sdk.util.a.c("RTBBannerView.loadAdContent", new Object[0]);
            ErrorReportingHelper.report("RTBBannerView.loadAdContent", b.b, c2.d.i, throwable);
            return;
        }
    }

    static /* synthetic */ com.adincube.sdk.util.f.a.a c(c c2) {
        return c2.g;
    }

    static /* synthetic */ com.adincube.sdk.i.e d(c c2) {
        return c2.h;
    }

    static /* synthetic */ com.adincube.sdk.util.f.a.b e(c c2) {
        return c2.b;
    }

    protected final void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected final void onAttachedToWindow() {
        com.adincube.sdk.i.c c2;
        boolean bl;
        super.onAttachedToWindow();
        try {
            this.a.a();
            c2 = this.f;
            bl = this.getVisibility() == 0;
        }
        catch (Throwable throwable) {
            com.adincube.sdk.util.a.c("RTBBannerView.onAttachedToWindow", new Object[]{throwable});
            ErrorReportingHelper.report("RTBBannerView.onAttachedToWindow", this.c, this.d, throwable);
            return;
        }
        c2.a(bl);
    }

    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            com.adincube.sdk.util.f.a.b b2 = this.b;
            if (b2.a(b2.d.a(true))) {
                b2.a();
            }
            this.f.a(false);
            this.f.a(f.e);
            return;
        }
        catch (Throwable throwable) {
            com.adincube.sdk.util.a.c("RTBBannerView.onDetachedFromWindow", new Object[]{throwable});
            ErrorReportingHelper.report("RTBBannerView.onDetachedFromWindow", this.c, this.d, throwable);
            return;
        }
    }

    protected final void onLayout(boolean bl, int n2, int n3, int n4, int n5) {
        if (bl) {
            this.e.layout(this.getPaddingLeft(), this.getPaddingTop(), n4 - n2 - this.getPaddingLeft() - this.getPaddingRight(), n5 - n3 - this.getPaddingTop() - this.getPaddingBottom());
        }
    }

    protected final void onMeasure(int n2, int n3) {
        try {
            int n4 = View.MeasureSpec.getSize((int)n2);
            int n5 = View.MeasureSpec.getSize((int)n3);
            int n6 = View.MeasureSpec.makeMeasureSpec((int)(n4 - this.getPaddingLeft() - this.getPaddingRight()), (int)1073741824);
            int n7 = View.MeasureSpec.makeMeasureSpec((int)(n5 - this.getPaddingTop() - this.getPaddingBottom()), (int)1073741824);
            this.e.measure(n6, n7);
            this.setMeasuredDimension(View.MeasureSpec.makeMeasureSpec((int)n4, (int)1073741824), View.MeasureSpec.makeMeasureSpec((int)n5, (int)1073741824));
            o.a(new Runnable(){

                public final void run() {
                    c.this.f.d();
                    c.this.f.c();
                    c.b(c.this);
                }
            });
            return;
        }
        catch (Throwable throwable) {
            com.adincube.sdk.util.a.c("RTBBannerView.onMeasure", new Object[]{throwable});
            ErrorReportingHelper.report("RTBBannerView.onMeasure", this.c, this.d, throwable);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void setVisibility(int n2) {
        boolean bl;
        com.adincube.sdk.i.c c2;
        super.setVisibility(n2);
        try {
            c2 = this.f;
            bl = n2 == 0;
        }
        catch (Throwable throwable) {
            com.adincube.sdk.util.a.c("RTBBannerView.setVisibility", new Object[]{throwable});
            ErrorReportingHelper.report("RTBBannerView.setVisibility", this.c, this.d, throwable);
            return;
        }
        c2.a(bl);
    }

}

