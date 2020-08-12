/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.app.Activity
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.os.Bundle
 *  android.os.Looper
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.animation.AlphaAnimation
 *  android.view.animation.Animation
 *  android.view.animation.Animation$AnimationListener
 *  com.adincube.sdk.h.a.c
 *  java.lang.Boolean
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.Throwable
 */
package com.adincube.sdk.b;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.adincube.sdk.b.a;
import com.adincube.sdk.f.a;
import com.adincube.sdk.h.a.e;
import com.adincube.sdk.mediation.w.f;
import com.adincube.sdk.util.ErrorReportingHelper;
import com.adincube.sdk.util.f.b;
import com.adincube.sdk.util.o;

public abstract class a {
    protected Activity a;
    public com.adincube.sdk.h.a.c b;
    public com.adincube.sdk.h.b.b c = com.adincube.sdk.g.a.a().a(true, true);
    public f d;
    protected com.adincube.sdk.g.e.a e;
    public boolean f;
    public com.adincube.sdk.f.a g;
    public int h = 0;
    public c i = null;
    protected b j = null;
    protected a k = null;
    protected com.adincube.sdk.util.f.b l = new com.adincube.sdk.util.f.b();
    protected Long m = null;

    public View a(Activity activity, Bundle bundle, com.adincube.sdk.h.a.c c2, f f2) {
        this.a = activity;
        this.b = c2;
        this.d = f2;
        com.adincube.sdk.util.f.b b2 = this.l;
        b2.a = c2;
        b2.a(f2);
        if (bundle != null) {
            this.b(bundle);
        }
        this.g = this.j();
        this.g.a(this.h);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        activity.setContentView((View)this.g, layoutParams);
        if (this.f) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400L);
            this.g.startAnimation((Animation)alphaAnimation);
        }
        return this.g;
    }

    public void a() {
        this.l.a();
    }

    public void a(Bundle bundle) {
    }

    public final void a(a a2) {
        this.k = a2;
    }

    public final void a(b b2) {
        this.j = b2;
    }

    public final void a(com.adincube.sdk.g.e.a a2) {
        this.e = a2;
    }

    public final void a(b.a a2) {
        this.l.b = a2;
    }

    public void a(boolean bl) {
        this.f = bl;
    }

    protected final void b() {
        this.b(true);
    }

    public void b(Bundle bundle) {
    }

    public final void b(boolean bl) {
        if (this.g != null && this.f && bl) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                this.c();
                return;
            }
            o.a(new Runnable(){

                public final void run() {
                    a.this.c();
                }
            });
            return;
        }
        this.f();
        this.g();
    }

    final void c() {
        try {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(350L);
            alphaAnimation.setFillAfter(true);
            alphaAnimation.setAnimationListener(new Animation.AnimationListener(){

                public final void onAnimationEnd(Animation animation) {
                    try {
                        a.this.f();
                        a.this.g();
                        return;
                    }
                    catch (Throwable throwable) {
                        ErrorReportingHelper.report("AdDisplayer.hideAd.onAnimationEnd", (e)a.this.b, throwable);
                        com.adincube.sdk.util.a.c("AdDisplayer#AnimationListener.onAnimationEnd() Exception : ", new Object[]{throwable});
                        return;
                    }
                }

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationStart(Animation animation) {
                }
            });
            this.g.startAnimation((Animation)alphaAnimation);
            return;
        }
        catch (Throwable throwable) {
            com.adincube.sdk.util.a.c("AdDisplayer.animateHideAd", new Object[]{throwable});
            ErrorReportingHelper.report("AdDisplayer.animateHideAd", com.adincube.sdk.h.c.b.a, throwable);
            return;
        }
    }

    public final boolean d() {
        com.adincube.sdk.f.a a2 = this.g;
        if (a2 != null && a2.a.a()) {
            this.e();
            this.b(true);
            return true;
        }
        return false;
    }

    protected void e() {
    }

    protected final void f() {
        this.j.a();
    }

    @SuppressLint(value={"NewApi"})
    protected void g() {
        this.a.finish();
        this.a.overridePendingTransition(0, 0);
    }

    public void h() {
    }

    public void i() {
    }

    @SuppressLint(value={"NewApi"})
    public com.adincube.sdk.f.a j() {
        com.adincube.sdk.f.a a2 = new com.adincube.sdk.f.a((Context)this.a);
        com.adincube.sdk.c.a a3 = new com.adincube.sdk.c.a((Context)this.a);
        a3.setBounds(0, 0, a3.getIntrinsicWidth(), a3.getIntrinsicHeight());
        a2.a = a3;
        a2.a.setCallback(a2.c);
        a2.a(true);
        a2.b = new a.a(this){
            final /* synthetic */ a a;
            {
                this.a = a2;
            }

            public final void a() {
                try {
                    if (this.a.m == null) {
                        this.a.m = java.lang.System.currentTimeMillis();
                        this.a.e();
                        this.a.b();
                    }
                    return;
                }
                catch (Throwable throwable) {
                    com.adincube.sdk.util.a.c("AdDisplayer#OnCloseButtonClickListener.onCloseButtonClicked()", new Object[]{throwable});
                    return;
                }
            }
        };
        a2.addView(this.k(), this.l());
        return a2;
    }

    public abstract View k();

    public abstract ViewGroup.LayoutParams l();

    public static interface a {
        public void a(Throwable var1);
    }

    public static interface b {
        public void a();
    }

    public static interface c {
        public void a(com.adincube.sdk.h.a.c var1, Boolean var2);
    }

}

