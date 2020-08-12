/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.view.Display
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.Window
 *  android.view.WindowManager
 *  android.view.animation.Animation
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  com.tappx.a.a.b.a
 *  com.tappx.a.a.b.a.a$1
 *  com.tappx.a.a.b.a.a$2
 *  com.tappx.a.a.b.b
 *  com.tappx.a.a.b.d
 *  com.tappx.a.a.b.g
 *  com.tappx.a.a.b.g$c
 *  com.tappx.a.a.b.h
 *  com.tappx.a.a.b.k
 *  com.tappx.a.a.b.k$a
 *  com.tappx.a.a.b.k$b
 *  com.tappx.a.a.b.n
 *  com.tappx.a.a.b.p
 *  com.tappx.a.a.b.s
 *  com.tappx.sdk.a.a
 *  java.lang.Object
 *  java.lang.String
 */
package com.tappx.a.a.b.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import com.tappx.a.a.b.a.a;
import com.tappx.a.a.b.a.c;
import com.tappx.a.a.b.a.d;
import com.tappx.a.a.b.b;
import com.tappx.a.a.b.g;
import com.tappx.a.a.b.h;
import com.tappx.a.a.b.k;
import com.tappx.a.a.b.n;
import com.tappx.a.a.b.p;
import com.tappx.a.a.b.s;

public final class a {
    static final String a = "aavc_fagZVUC6pOQOxawVwpVy";
    static final String b = "aavc_otZMuRlffpTHI9DsaLyI";
    private final Activity c;
    private final com.tappx.a.a.a.h.g d;
    private d.a e;
    private com.tappx.sdk.a.a f;
    private k g;
    private g h;
    private k.b i = new 2(this);

    public a(Activity activity) {
        this.c = activity;
        this.d = com.tappx.a.a.a.h.h.a((Context)activity).a();
    }

    static /* synthetic */ Activity a(a a2) {
        return a2.c;
    }

    private void a(View view, b b2) {
        Animation animation = com.tappx.a.a.b.d.a((b)b2);
        if (animation != null) {
            view.startAnimation(animation);
        }
    }

    private void a(com.tappx.a.a.b.a a2) {
        if (a2 != null) {
            if (a2 == com.tappx.a.a.b.a.a) {
                return;
            }
            h.a((Activity)this.c, (com.tappx.a.a.b.a)a2);
        }
    }

    static /* synthetic */ d.a b(a a2) {
        return a2.e;
    }

    static /* synthetic */ void c(a a2) {
        a2.l();
    }

    static /* synthetic */ void d(a a2) {
        a2.k();
    }

    private void e() {
        int n2 = this.f.f() ? com.tappx.a.a.a.a.a.g : -16777216;
        this.c.getWindow().setBackgroundDrawable((Drawable)new ColorDrawable(n2));
    }

    private View f() {
        View view = this.i();
        this.h = new g((Context)this.c);
        this.h.setCloseListener((g.c)new 1(this));
        FrameLayout.LayoutParams layoutParams = this.j();
        layoutParams.gravity = 17;
        view.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        this.h.a(view, layoutParams);
        this.h.a(this.f.a(), this.f.b());
        this.g();
        this.a((View)this.h, this.f.c());
        return this.h;
    }

    private void g() {
        if (!this.d.h()) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 83);
        View view = this.h();
        this.h.addView(view, (ViewGroup.LayoutParams)layoutParams);
    }

    private View h() {
        return com.tappx.a.a.a.k.a.b((Context)this.c);
    }

    private View i() {
        String string2 = p.a((Intent)this.c.getIntent());
        if (string2 == null) {
            this.c.finish();
            return new View((Context)this.c);
        }
        this.g = n.a((Context)this.c, (String)string2);
        this.g.a(this.i);
        return this.g.a(s.b, string2, new k.a().a(this.f.g()));
    }

    private FrameLayout.LayoutParams j() {
        int n2;
        int n3;
        Display display = this.c.getWindowManager().getDefaultDisplay();
        int n4 = this.f.d();
        int n5 = display.getWidth();
        int n6 = -1;
        if (n4 <= 0 || (n3 = h.d((float)n4, (Context)this.c)) > n5) {
            n3 = -1;
        }
        int n7 = this.f.e();
        int n8 = display.getHeight();
        if (n7 > 0 && (n2 = h.d((float)n7, (Context)this.c)) <= n8) {
            n6 = n2;
        }
        return new FrameLayout.LayoutParams(n3, n6);
    }

    private void k() {
        this.h.setCloseEnabled(true);
    }

    private void l() {
        this.h.setCloseEnabled(false);
    }

    public void a() {
        k k2 = this.g;
        if (k2 != null) {
            k2.a(this.c.isFinishing());
        }
    }

    public void a(Bundle bundle) {
        this.e = c.a(this.c.getIntent().getIntExtra(b, -1));
        d.a a2 = this.e;
        if (a2 != null) {
            a2.c();
        }
        this.f = (com.tappx.sdk.a.a)this.c.getIntent().getParcelableExtra(a);
        if (this.f == null) {
            this.c.finish();
            return;
        }
        this.e();
        this.c.requestWindowFeature(1);
        this.c.getWindow().addFlags(1024);
        this.a(this.f.h());
        View view = this.f();
        this.c.setContentView(view);
    }

    public void b() {
        k k2 = this.g;
        if (k2 != null) {
            k2.b();
        }
    }

    public void c() {
        k k2 = this.g;
        if (k2 != null) {
            k2.a();
        }
        this.h.removeAllViews();
        d.a a2 = this.e;
        if (a2 != null) {
            a2.f();
        }
        this.e = null;
    }

    public boolean d() {
        return this.h.a();
    }
}

