/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.app.Activity
 *  android.content.Context
 *  android.graphics.Point
 *  android.net.Uri
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.CountDownTimer
 *  android.view.View
 *  android.view.View$OnTouchListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  android.webkit.WebView
 *  com.adincube.sdk.b.a
 *  com.adincube.sdk.b.a$a
 *  com.adincube.sdk.b.b$1
 *  com.adincube.sdk.f.a
 *  com.adincube.sdk.g.e.a
 *  com.adincube.sdk.g.e.b.a
 *  com.adincube.sdk.g.e.b.a$b
 *  com.adincube.sdk.h.a.c
 *  com.adincube.sdk.i.b
 *  com.adincube.sdk.i.c
 *  com.adincube.sdk.i.c$c
 *  com.adincube.sdk.i.c$d
 *  com.adincube.sdk.i.e
 *  com.adincube.sdk.i.f
 *  com.adincube.sdk.mediation.w.f
 *  com.adincube.sdk.util.f.a.a
 *  java.io.IOException
 *  java.lang.Double
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Iterator
 *  java.util.List
 */
package com.adincube.sdk.b;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import com.adincube.sdk.b.a;
import com.adincube.sdk.b.b;
import com.adincube.sdk.g.e.b.a;
import com.adincube.sdk.h.a.c;
import com.adincube.sdk.h.a.e;
import com.adincube.sdk.i.c;
import com.adincube.sdk.i.f;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public final class b
extends a
implements ViewTreeObserver.OnGlobalLayoutListener {
    private static CountDownTimer s;
    private com.adincube.sdk.i.c n;
    private com.adincube.sdk.util.f.a.a o = null;
    private com.adincube.sdk.i.b p;
    private com.adincube.sdk.g.e.b.a q = null;
    private com.adincube.sdk.i.e r = null;
    private c.d t = new c.d(){

        public final void a(String string, String string2) {
            b.this.r.a(string, string2);
        }
    };
    private c.c u = new c.c(){

        public final void a() {
            b.this.b();
        }

        public final void a(Uri uri) {
            b.this.o.b(uri);
        }

        public final void b(Uri uri) {
            b.this.o.c(uri);
        }
    };

    public final View a(Activity activity, Bundle bundle, c c2, com.adincube.sdk.mediation.w.f f2) {
        CountDownTimer countDownTimer = s;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            s = null;
        }
        this.r = new com.adincube.sdk.i.e();
        View view = super.a(activity, bundle, c2, f2);
        activity.findViewById(16908290).getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
        this.o = new com.adincube.sdk.util.f.a.a((Context)activity, f2, this.l, this.q);
        this.g.a(true);
        if (!(this.d.l == null || bundle != null && bundle.getBoolean("canClose", false))) {
            this.g.a(false);
            this.p = com.adincube.sdk.i.b.a((com.adincube.sdk.mediation.w.f)this.d, (com.adincube.sdk.f.a)this.g, (com.adincube.sdk.i.e)this.r);
            this.p.start();
        }
        return view;
    }

    public final void a(Bundle bundle) {
        com.adincube.sdk.i.b b2 = this.p;
        boolean bl = b2 == null || b2.b;
        bundle.putBoolean("canClose", bl);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected final void g() {
        com.adincube.sdk.i.b b2;
        List list;
        super.g();
        this.n.a(f.e);
        com.adincube.sdk.i.c c2 = this.n;
        if (c2.e != null && Build.VERSION.SDK_INT >= 11) {
            c2.e.onPause();
        }
        if ((b2 = this.p) != null) {
            b2.cancel();
        }
        com.adincube.sdk.g.e.b.a a2 = this.q;
        List list2 = list = a2.b;
        synchronized (list2) {
            Iterator iterator = a2.b.iterator();
            do {
                if (!iterator.hasNext()) {
                    a2.b.clear();
                    return;
                }
                a2.a((a.b)iterator.next());
            } while (true);
        }
    }

    public final void h() {
        super.h();
        1 var1_1 = new 1(this);
        s = var1_1;
        var1_1.start();
    }

    public final void i() {
        if (this.a != null) {
            this.a.findViewById(16908290).getViewTreeObserver().removeGlobalOnLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
        }
    }

    protected final com.adincube.sdk.f.a j() {
        com.adincube.sdk.f.a a2 = super.j();
        if (this.b.t != null && this.b.s != null) {
            double d2 = this.b.t.intValue();
            double d3 = this.b.s.intValue();
            Double.isNaN((double)d2);
            Double.isNaN((double)d3);
            a2.a(Double.valueOf((double)(d2 / d3)));
        }
        return a2;
    }

    @SuppressLint(value={"NewApi"})
    protected final View k() {
        WebView webView = new WebView((Context)this.a);
        com.adincube.sdk.i.c c2 = this.n = new com.adincube.sdk.i.c((Context)this.a, (e)this.b, this.d);
        c2.l = this.u;
        c2.m = this.t;
        c2.a(webView);
        try {
            this.n.a();
        }
        catch (IOException iOException) {
            this.k.a((Throwable)iOException);
        }
        this.q = new com.adincube.sdk.g.e.b.a((e)this.b, this.d, this.e);
        webView.setOnTouchListener((View.OnTouchListener)this.q);
        this.q.a();
        return webView;
    }

    protected final ViewGroup.LayoutParams l() {
        return new ViewGroup.LayoutParams(-1, -1);
    }

    public final void onGlobalLayout() {
        com.adincube.sdk.i.c c2 = this.n;
        boolean bl = c2.j.x != 0 || c2.j.y != 0;
        this.n.d();
        com.adincube.sdk.i.c c3 = this.n;
        int n2 = c3.e.getVisibility();
        boolean bl2 = false;
        if (n2 == 0) {
            bl2 = true;
        }
        c3.a(bl2);
        if (!bl) {
            this.n.c();
            this.n.a(f.b);
            this.n.b();
        }
    }

}

