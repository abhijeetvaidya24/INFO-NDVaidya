/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  com.adincube.sdk.BannerView
 *  com.adincube.sdk.d.a.p
 *  com.adincube.sdk.g.a
 *  com.adincube.sdk.g.a.b
 *  com.adincube.sdk.g.b.a.a.a
 *  com.adincube.sdk.g.b.a.a.c
 *  com.adincube.sdk.g.b.a.a.e$1
 *  com.adincube.sdk.g.b.a.b
 *  com.adincube.sdk.g.b.a.c
 *  com.adincube.sdk.h.c.b
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.adincube.sdk.g.b.a.a;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.adincube.sdk.BannerView;
import com.adincube.sdk.d.a.p;
import com.adincube.sdk.g.b.a.a;
import com.adincube.sdk.g.b.a.a.e;
import com.adincube.sdk.g.b.a.b;
import com.adincube.sdk.g.b.a.c;
import com.adincube.sdk.util.ErrorReportingHelper;

public final class e
extends com.adincube.sdk.g.b.a.a.a {
    private boolean k = false;
    private boolean l = true;
    private com.adincube.sdk.g.b.a.a.b m;
    private b n = new b(){

        public final void a(boolean bl) {
        }

        public final void a(boolean bl, com.adincube.sdk.d.a.c c2) {
        }

        public final void b(boolean bl) {
            if (!bl) {
                com.adincube.sdk.g.b.a.a.c c2;
                Integer n2;
                e.this.e.a(null, true);
                if (e.this.b != null) {
                    c2 = e.this.e;
                    n2 = e.this.b;
                } else {
                    c2 = e.this.e;
                    n2 = 0;
                }
                c2.a(n2, false);
                e.a(e.this);
            }
        }
    };

    public e(BannerView bannerView, com.adincube.sdk.g.b.a.a.c c2, com.adincube.sdk.g.a a2, com.adincube.sdk.g.a.b b2, a a3, c c3, com.adincube.sdk.g.b.a.a.b b3) {
        super(bannerView, c2, a2, b2, a3, c3);
        this.m = b3;
        a3.a(this.n);
    }

    static /* synthetic */ void a(e e2) {
        p p2;
        try {
            if (e2.d.getChildCount() > 0) {
                return;
            }
            if (e2.i.n) {
                return;
            }
            if (e2.d.getVisibility() != 0) {
                e2.l = true;
                return;
            }
            if (e2.d.getMeasuredWidth() == 0) {
                e2.k = true;
                return;
            }
            e2.b();
            View view = e2.i.p();
            e2.d.addView(view, (ViewGroup.LayoutParams)e2.a(view));
            e2.j = e2.i.r;
            e2.h.b(false);
            e2.m.i();
            p2 = null;
        }
        catch (Throwable throwable) {
            p p3 = new p(throwable);
            ErrorReportingHelper.report("BannerViewShowManager.show", com.adincube.sdk.h.c.b.b, throwable);
            p2 = p3;
        }
        catch (com.adincube.sdk.d.a.c c2) {
            // empty catch block
        }
        if (p2 != null) {
            e2.e.a(Integer.valueOf((int)8), true);
            e2.a((com.adincube.sdk.d.a.c)p2);
        }
    }

    private void i() {
        new Handler(Looper.getMainLooper()).post((Runnable)new 1(this));
    }

    public final void a(int n2) {
        super.a(n2);
        if (n2 == 0 && this.l) {
            this.l = false;
            this.i();
        }
    }

    public final void e() {
        if (this.k) {
            this.k = false;
            this.i();
        }
    }

}

