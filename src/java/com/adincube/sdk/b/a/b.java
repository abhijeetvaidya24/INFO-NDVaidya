/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.app.Activity
 *  android.content.Context
 *  android.net.Uri
 *  android.os.Bundle
 *  android.view.SurfaceView
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.ImageButton
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  com.adincube.sdk.b.a
 *  com.adincube.sdk.b.a$c
 *  com.adincube.sdk.b.a.a.d
 *  com.adincube.sdk.b.a.a.e$a
 *  com.adincube.sdk.b.a.a.f
 *  com.adincube.sdk.b.a.a.g
 *  com.adincube.sdk.b.a.a.h
 *  com.adincube.sdk.b.a.e
 *  com.adincube.sdk.f.a
 *  com.adincube.sdk.h.a.a.a
 *  com.adincube.sdk.h.a.c
 *  com.adincube.sdk.h.b.b
 *  com.adincube.sdk.h.c.b
 *  com.adincube.sdk.mediation.w.f
 *  com.adincube.sdk.util.h.a
 *  java.lang.Boolean
 *  java.lang.Double
 *  java.lang.Long
 *  java.lang.String
 */
package com.adincube.sdk.b.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import com.adincube.sdk.b.a;
import com.adincube.sdk.b.a.a;
import com.adincube.sdk.b.a.a.e;
import com.adincube.sdk.b.a.a.f;
import com.adincube.sdk.b.a.a.g;
import com.adincube.sdk.b.a.a.h;
import com.adincube.sdk.b.a.c;
import com.adincube.sdk.b.a.d;
import com.adincube.sdk.b.a.e;
import com.adincube.sdk.util.ErrorReportingHelper;
import com.adincube.sdk.util.h.a;

@TargetApi(value=14)
public abstract class b
extends com.adincube.sdk.b.a
implements a.c,
e.a,
a.a {
    public d n = null;
    public com.adincube.sdk.b.a.a.e o = null;
    public e p = null;
    public c q = null;
    public a r = null;
    private com.adincube.sdk.util.h.a s = null;
    private long t = 0L;

    public final View a(Activity activity, Bundle bundle, com.adincube.sdk.h.a.c c2, com.adincube.sdk.mediation.w.f f2) {
        this.a((Context)activity, c2);
        View view = super.a(activity, bundle, c2, f2);
        if (this.a((Context)activity, bundle)) {
            boolean bl = this.d.t;
            Long l2 = null;
            boolean bl2 = false;
            if (bundle != null) {
                bl2 = bundle.getBoolean("c");
                bl = bundle.getBoolean("m");
                l2 = bundle.getLong("p");
            }
            if (!bl2) {
                this.o.a(this.o());
                if (l2 != null) {
                    this.o.a(l2);
                }
            }
            this.p.a(bl, true);
        }
        com.adincube.sdk.f.a a2 = this.g;
        d d2 = this.n;
        e e2 = this.p;
        RelativeLayout relativeLayout = new RelativeLayout(d2.a);
        ImageButton imageButton = e2.a();
        if (imageButton != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(10);
            layoutParams.addRule(11);
            relativeLayout.addView((View)imageButton, (ViewGroup.LayoutParams)layoutParams);
        }
        a2.addView((View)relativeLayout, 1);
        return view;
    }

    public final void a() {
        super.a();
        this.o.l();
    }

    public void a(Context context, com.adincube.sdk.h.a.c c2) {
        this.n = new d(context, c2);
    }

    public void a(Bundle bundle) {
        long l2 = this.o.o();
        if (l2 > this.t) {
            this.t = l2;
        }
        bundle.putBoolean("m", this.p.a);
        boolean bl = this.o.a() == h.f;
        bundle.putBoolean("c", bl);
        bundle.putLong("p", l2);
        bundle.putLong("mp", this.t);
    }

    public void a(com.adincube.sdk.b.a.a.e e2) {
        this.g.a(true);
    }

    public void a(com.adincube.sdk.b.a.a.e e2, g g2) {
        this.g.a(true);
        if (this.c.q) {
            ErrorReportingHelper.report(g2, this.p(), com.adincube.sdk.h.c.b.a, null, null);
        }
    }

    public void a(com.adincube.sdk.h.a.c c2, Boolean bl) {
        this.i.a(c2, bl);
    }

    public final void a(boolean bl) {
        this.f = false;
    }

    public boolean a(Context context, Bundle bundle) {
        c c2;
        this.o = new f(new com.adincube.sdk.b.a.a.d(this.d)).a(context);
        this.p = new e(context, this.o);
        this.s = new com.adincube.sdk.util.h.a(this.o, this.g, this.r());
        this.r = new a(this.o, this.g, this.d.n);
        this.q = c2 = new c(this.o, this.s, this.b, this.n(), this.q(), this.t, this);
        this.o.a(this);
        this.s.a((a.a)this);
        this.o.a(this.n.a());
        return true;
    }

    protected final void b(Bundle bundle) {
        this.t = bundle.getLong("mp");
        if (bundle.getBoolean("c")) {
            this.b(false);
        }
    }

    public final void b(com.adincube.sdk.b.a.a.e e2) {
    }

    public final void b_() {
    }

    public final void h() {
        super.h();
        this.o.m();
    }

    public final void i() {
        this.q.b();
        this.o.b();
        this.s.b();
        this.n.b();
    }

    protected final com.adincube.sdk.f.a j() {
        Double d2;
        com.adincube.sdk.f.a a2 = super.j();
        com.adincube.sdk.h.a.a.a a3 = this.m();
        if (a3 != null) {
            int n2 = com.adincube.sdk.util.h.b.b(a3);
            int n3 = com.adincube.sdk.util.h.b.c(a3);
            double d3 = n2;
            double d4 = n3;
            Double.isNaN((double)d3);
            Double.isNaN((double)d4);
            d2 = d3 / d4;
        } else {
            d2 = null;
        }
        a2.a(d2);
        return a2;
    }

    protected final View k() {
        return this.n.a();
    }

    protected final ViewGroup.LayoutParams l() {
        return new ViewGroup.LayoutParams(-2, -2);
    }

    public abstract com.adincube.sdk.h.a.a.a m();

    public abstract String n();

    public abstract Uri o();

    public Uri p() {
        return this.o();
    }

    public abstract long q();

    public abstract long r();

    @Override
    public final void s() {
    }
}

