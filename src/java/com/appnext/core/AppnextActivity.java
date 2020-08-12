/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.app.Activity
 *  android.content.Context
 *  android.graphics.Color
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Handler
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 *  android.view.Window
 *  android.view.animation.Animation
 *  android.view.animation.RotateAnimation
 *  android.widget.ProgressBar
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  com.appnext.core.AppnextAd
 *  com.appnext.core.e
 *  com.appnext.core.e$a
 *  com.appnext.core.f
 *  com.appnext.core.p
 *  com.appnext.core.q
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Thread
 *  java.lang.Throwable
 */
package com.appnext.core;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.appnext.core.AppnextAd;
import com.appnext.core.e;
import com.appnext.core.f;
import com.appnext.core.p;
import com.appnext.core.q;

public abstract class AppnextActivity
extends Activity {
    protected String banner = "";
    protected String gm = "";
    private RelativeLayout gn;
    protected RelativeLayout go;
    protected String guid = "";
    protected Handler handler;
    protected String placementID;
    protected q userAction;

    protected final void a(ViewGroup viewGroup, Drawable drawable2) {
        if (this.gn != null) {
            this.aY();
        }
        this.gn = new RelativeLayout((Context)this);
        this.gn.setBackgroundColor(Color.parseColor((String)"#77ffffff"));
        viewGroup.addView((View)this.gn);
        this.gn.getLayoutParams().height = -1;
        this.gn.getLayoutParams().width = -1;
        ProgressBar progressBar = new ProgressBar((Context)this, null, 16842871);
        progressBar.setIndeterminateDrawable(drawable2);
        progressBar.setIndeterminate(true);
        this.gn.addView((View)progressBar);
        RotateAnimation rotateAnimation = new RotateAnimation(360.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(1000L);
        rotateAnimation.setRepeatCount(-1);
        progressBar.setAnimation((Animation)rotateAnimation);
        ((RelativeLayout.LayoutParams)progressBar.getLayoutParams()).addRule(13, -1);
        this.gn.setOnClickListener(new View.OnClickListener(){

            public final void onClick(View view) {
            }
        });
        this.handler.postDelayed(new Runnable(){

            public final void run() {
                AppnextActivity.this.aY();
            }
        }, 8000L);
    }

    protected void a(AppnextAd appnextAd, e.a a2) {
        q q2 = this.userAction;
        if (q2 != null && appnextAd != null) {
            q2.a(appnextAd, appnextAd.getImpressionURL(), a2);
        }
    }

    @SuppressLint(value={"NewApi"})
    protected final void aW() {
        int n2 = 2 ^ this.getWindow().getDecorView().getSystemUiVisibility();
        if (Build.VERSION.SDK_INT >= 16) {
            n2 ^= 4;
        }
        if (Build.VERSION.SDK_INT >= 18) {
            n2 ^= 4096;
        }
        this.getWindow().getDecorView().setSystemUiVisibility(n2);
    }

    @SuppressLint(value={"NewApi"})
    protected final void aX() {
        int n2 = 2 | this.getWindow().getDecorView().getSystemUiVisibility();
        if (Build.VERSION.SDK_INT >= 16) {
            n2 |= 4;
        }
        if (Build.VERSION.SDK_INT >= 18) {
            n2 |= 4096;
        }
        this.getWindow().getDecorView().setSystemUiVisibility(n2);
    }

    protected final void aY() {
        Handler handler;
        RelativeLayout relativeLayout = this.gn;
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
            this.gn.removeAllViewsInLayout();
            if (this.gn.getParent() != null) {
                ((RelativeLayout)this.gn.getParent()).removeView((View)this.gn);
            }
        }
        if ((handler = this.handler) != null) {
            handler.removeCallbacks(null);
        }
        this.gn = null;
    }

    protected void b(AppnextAd appnextAd, e.a a2) {
        q q2 = this.userAction;
        if (q2 != null && appnextAd != null) {
            q2.a(appnextAd, appnextAd.getAppURL(), this.placementID, a2);
        }
    }

    protected abstract p getConfig();

    protected void onCreate(Bundle bundle) {
        new Thread(new Runnable(){

            public final void run() {
                if (!f.s((Context)AppnextActivity.this)) {
                    AppnextActivity.this.finish();
                    AppnextActivity.this.runOnUiThread(new Runnable(){

                        public final void run() {
                            AppnextActivity.this.onError("Connection Error");
                        }
                    });
                }
            }

        }).start();
        this.requestWindowFeature(1);
        this.getWindow().setFlags(1024, 1024);
        this.getWindow().addFlags(128);
        super.onCreate(bundle);
        this.handler = new Handler();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    protected void onDestroy() {
        super.onDestroy();
        try {
            this.handler.removeCallbacks(null);
            this.handler = null;
            ** GOTO lbl-1000
        }
        catch (Throwable v0) {
            try lbl-1000: // 2 sources:
            {
                this.userAction.destroy();
                this.userAction = null;
                return;
            }
            catch (Throwable v1) {}
        }
    }

    protected abstract void onError(String var1);

}

