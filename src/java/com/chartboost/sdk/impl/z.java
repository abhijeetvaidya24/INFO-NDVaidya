/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.animation.Animation
 *  android.view.animation.TranslateAnimation
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  com.chartboost.sdk.impl.v
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.util.Map
 */
package com.chartboost.sdk.impl;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.impl.aa;
import com.chartboost.sdk.impl.v;
import java.util.Map;

public abstract class z
extends RelativeLayout {
    protected v a;
    private aa b;
    private int c;

    public z(Context context, v v2) {
        super(context);
        this.a = v2;
        this.c = 1;
        this.a(context);
    }

    private void a(Context context) {
        Context context2 = this.getContext();
        this.setGravity(17);
        this.b = new aa(context2);
        this.b.a(-1);
        this.b.setBackgroundColor(-855638017);
        this.addView((View)this.b, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
        this.addView(this.a(), (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(final boolean bl, long l2) {
        TranslateAnimation translateAnimation;
        Map map;
        this.a.C = bl;
        if (bl && this.getVisibility() == 0 || !bl && this.getVisibility() == 8) {
            return;
        }
        Runnable runnable = new Runnable(){

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            public void run() {
                Map map;
                if (!bl) {
                    z.this.setVisibility(8);
                    z.this.clearAnimation();
                }
                Map map2 = map = z.this.a.g;
                synchronized (map2) {
                    z.this.a.g.remove((Object)z.this);
                    return;
                }
            }
        };
        if (bl) {
            this.setVisibility(0);
        }
        float f2 = CBUtility.a((float)this.b(), this.getContext());
        int n2 = this.c;
        if (n2 != 0) {
            if (n2 != 1) {
                if (n2 != 2) {
                    if (n2 != 3) {
                        translateAnimation = null;
                    } else {
                        float f3 = bl ? f2 : 0.0f;
                        if (bl) {
                            f2 = 0.0f;
                        }
                        translateAnimation = new TranslateAnimation(f3, f2, 0.0f, 0.0f);
                    }
                } else {
                    float f4 = bl ? -f2 : 0.0f;
                    float f5 = bl ? 0.0f : -f2;
                    translateAnimation = new TranslateAnimation(f4, f5, 0.0f, 0.0f);
                }
            } else {
                float f6 = bl ? f2 : 0.0f;
                if (bl) {
                    f2 = 0.0f;
                }
                translateAnimation = new TranslateAnimation(0.0f, 0.0f, f6, f2);
            }
        } else {
            float f7 = bl ? -f2 : 0.0f;
            float f8 = bl ? 0.0f : -f2;
            translateAnimation = new TranslateAnimation(0.0f, 0.0f, f7, f8);
        }
        translateAnimation.setDuration(l2);
        translateAnimation.setFillAfter(bl ^ true);
        this.startAnimation((Animation)translateAnimation);
        Map map2 = map = this.a.g;
        synchronized (map2) {
            this.a.g.put((Object)this, (Object)runnable);
        }
        this.a.a.postDelayed(runnable, l2);
    }

    protected abstract View a();

    public void a(int n2) {
        RelativeLayout.LayoutParams layoutParams;
        this.c = n2;
        this.setClickable(false);
        int n3 = this.b();
        int n4 = this.c;
        if (n4 != 0) {
            if (n4 != 1) {
                if (n4 != 2) {
                    if (n4 != 3) {
                        layoutParams = null;
                    } else {
                        layoutParams = new RelativeLayout.LayoutParams(CBUtility.a(n3, this.getContext()), -1);
                        layoutParams.addRule(11);
                        this.b.b(2);
                    }
                } else {
                    layoutParams = new RelativeLayout.LayoutParams(CBUtility.a(n3, this.getContext()), -1);
                    layoutParams.addRule(9);
                    this.b.b(8);
                }
            } else {
                layoutParams = new RelativeLayout.LayoutParams(-1, CBUtility.a(n3, this.getContext()));
                layoutParams.addRule(12);
                this.b.b(4);
            }
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-1, CBUtility.a(n3, this.getContext()));
            layoutParams.addRule(10);
            this.b.b(1);
        }
        this.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    }

    public void a(boolean bl) {
        this.a(bl, 500L);
    }

    protected abstract int b();

}

