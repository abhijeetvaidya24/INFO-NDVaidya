/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Dialog
 *  android.content.Context
 *  android.os.Bundle
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.Window
 *  android.view.WindowManager
 *  android.view.WindowManager$LayoutParams
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  com.applovin.impl.sdk.ad.a
 *  java.lang.Boolean
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.applovin.impl.adview;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import com.applovin.impl.adview.c;
import com.applovin.impl.adview.g;
import com.applovin.impl.adview.i;
import com.applovin.impl.adview.j;
import com.applovin.impl.sdk.ad.a;
import com.applovin.impl.sdk.b.b;
import com.applovin.impl.sdk.c.d;
import com.applovin.impl.sdk.p;
import com.applovin.sdk.AppLovinSdkUtils;

class j
extends Dialog
implements i {
    private final Activity a;
    private final com.applovin.impl.sdk.j b;
    private final p c;
    private final c d;
    private final a e;
    private final String f;
    private RelativeLayout g;
    private g h;

    j(a a2, String string, c c2, Activity activity, com.applovin.impl.sdk.j j2) {
        super((Context)activity, 16973840);
        if (a2 != null) {
            if (c2 != null) {
                if (j2 != null) {
                    if (activity != null) {
                        this.b = j2;
                        this.c = j2.u();
                        this.a = activity;
                        this.d = c2;
                        this.e = a2;
                        this.f = string;
                        this.requestWindowFeature(1);
                        this.setCancelable(false);
                        return;
                    }
                    throw new IllegalArgumentException("No activity specified");
                }
                throw new IllegalArgumentException("No sdk specified");
            }
            throw new IllegalArgumentException("No main view specified");
        }
        throw new IllegalArgumentException("No ad specified");
    }

    private int a(int n2) {
        return AppLovinSdkUtils.dpToPx((Context)this.a, n2);
    }

    static /* synthetic */ c a(j j2) {
        return j2.d;
    }

    private void a(g.a a2) {
        if (this.h != null) {
            this.c.c("ExpandedAdDialog", "Attempting to create duplicate close button");
            return;
        }
        this.h = g.a(this.b, this.getContext(), a2);
        this.h.setVisibility(8);
        this.h.setOnClickListener(new View.OnClickListener(this){
            final /* synthetic */ j a;
            {
                this.a = j2;
            }

            public void onClick(View view) {
                j.d(this.a);
            }
        });
        this.h.setClickable(false);
        int n2 = this.a(this.b.a(b.cH));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(n2, n2);
        layoutParams.addRule(10);
        boolean bl = this.b.a(b.cK);
        int n3 = 9;
        int n4 = bl ? 9 : 11;
        layoutParams.addRule(n4);
        this.h.a(n2);
        int n5 = this.a(this.b.a(b.cJ));
        int n6 = this.a(this.b.a(b.cI));
        layoutParams.setMargins(n6, n5, n6, 0);
        this.g.addView((View)this.h, (ViewGroup.LayoutParams)layoutParams);
        this.h.bringToFront();
        int n7 = this.a(this.b.a(b.cL));
        View view = new View((Context)this.a);
        view.setBackgroundColor(0);
        int n8 = n2 + n7;
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(n8, n8);
        layoutParams2.addRule(10);
        if (!this.b.a(b.cK).booleanValue()) {
            n3 = 11;
        }
        layoutParams2.addRule(n3);
        layoutParams2.setMargins(n6 - this.a(5), n5 - this.a(5), n6 - this.a(5), 0);
        view.setOnClickListener(new View.OnClickListener(this){
            final /* synthetic */ j a;
            {
                this.a = j2;
            }

            public void onClick(View view) {
                if (j.e(this.a).isClickable()) {
                    j.e(this.a).performClick();
                }
            }
        });
        this.g.addView(view, (ViewGroup.LayoutParams)layoutParams2);
        view.bringToFront();
    }

    static /* synthetic */ RelativeLayout b(j j2) {
        return j2.g;
    }

    private void b() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        this.d.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        this.g = new RelativeLayout((Context)this.a);
        this.g.setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
        this.g.setBackgroundColor(-1157627904);
        this.g.addView((View)this.d);
        if (!this.e.k()) {
            this.a(this.e.l());
            this.d();
        }
        this.setContentView((View)this.g);
    }

    private void c() {
        this.d.a("javascript:al_onCloseTapped();", new Runnable(this){
            final /* synthetic */ j a;
            {
                this.a = j2;
            }

            public void run() {
                this.a.dismiss();
            }
        });
    }

    static /* synthetic */ void c(j j2) {
        super.dismiss();
    }

    private void d() {
        this.a.runOnUiThread(new Runnable(this){
            final /* synthetic */ j a;
            {
                this.a = j2;
            }

            public void run() {
                try {
                    if (j.e(this.a) == null) {
                        j.d(this.a);
                    }
                    j.e(this.a).setVisibility(0);
                    j.e(this.a).bringToFront();
                    android.view.animation.AlphaAnimation alphaAnimation = new android.view.animation.AlphaAnimation(0.0f, 1.0f);
                    alphaAnimation.setDuration(j.f(this.a).a(b.cG).longValue());
                    alphaAnimation.setAnimationListener(new android.view.animation.Animation$AnimationListener(this){
                        final /* synthetic */ 6 a;
                        {
                            this.a = var1_1;
                        }

                        public void onAnimationEnd(android.view.animation.Animation animation) {
                            j.e(this.a.a).setClickable(true);
                        }

                        public void onAnimationRepeat(android.view.animation.Animation animation) {
                        }

                        public void onAnimationStart(android.view.animation.Animation animation) {
                        }
                    });
                    j.e(this.a).startAnimation((android.view.animation.Animation)alphaAnimation);
                    return;
                }
                catch (Throwable throwable) {
                    j.g(this.a).b("ExpandedAdDialog", "Unable to fade in close button", throwable);
                    j.d(this.a);
                    return;
                }
            }
        });
    }

    static /* synthetic */ void d(j j2) {
        j2.c();
    }

    static /* synthetic */ g e(j j2) {
        return j2.h;
    }

    static /* synthetic */ com.applovin.impl.sdk.j f(j j2) {
        return j2.b;
    }

    static /* synthetic */ p g(j j2) {
        return j2.c;
    }

    public a a() {
        return this.e;
    }

    @Override
    public void dismiss() {
        d d2 = this.d.c();
        if (d2 != null) {
            d2.e();
        }
        this.a.runOnUiThread(new Runnable(this){
            final /* synthetic */ j a;
            {
                this.a = j2;
            }

            public void run() {
                j.b(this.a).removeView((View)j.a(this.a));
                j.c(this.a);
            }
        });
    }

    public void onBackPressed() {
        this.d.a("javascript:al_onBackPressed();", new Runnable(this){
            final /* synthetic */ j a;
            {
                this.a = j2;
            }

            public void run() {
                this.a.dismiss();
            }
        });
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected void onStart() {
        super.onStart();
        try {
            Window window = this.getWindow();
            if (window != null) {
                window.setFlags(this.a.getWindow().getAttributes().flags, this.a.getWindow().getAttributes().flags);
                if (!this.e.w()) return;
                window.addFlags(16777216);
                return;
            }
            this.c.d("ExpandedAdDialog", "Unable to turn on hardware acceleration - window is null");
            return;
        }
        catch (Throwable throwable) {
            this.c.b("ExpandedAdDialog", "Setting window flags failed.", throwable);
        }
    }
}

