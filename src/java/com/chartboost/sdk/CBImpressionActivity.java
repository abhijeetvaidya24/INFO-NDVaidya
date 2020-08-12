/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.annotation.TargetApi
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.Handler
 *  android.view.MotionEvent
 *  android.view.SurfaceView
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.Window
 *  android.widget.RelativeLayout
 *  com.chartboost.sdk.Tracking.a
 *  com.chartboost.sdk.c
 *  com.chartboost.sdk.h
 *  com.chartboost.sdk.i
 *  com.chartboost.sdk.impl.s
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.chartboost.sdk;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Libraries.j;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.Tracking.a;
import com.chartboost.sdk.c;
import com.chartboost.sdk.h;
import com.chartboost.sdk.i;
import com.chartboost.sdk.impl.s;

@SuppressLint(value={"Registered"})
public class CBImpressionActivity
extends Activity {
    final a a;
    final Handler b;
    final c c;
    private Activity d;

    public CBImpressionActivity() {
        a a2 = h.a() != null ? h.a().o : null;
        this.a = a2;
        Handler handler = h.a() != null ? h.a().p : null;
        this.b = handler;
        c c2 = h.a() != null ? h.a().q : null;
        this.c = c2;
        this.d = null;
    }

    @TargetApi(value=11)
    private void a() {
        if (s.a().a(11)) {
            this.getWindow().setFlags(16777216, 16777216);
        }
    }

    private void b() {
        if (!s.a().a(14)) {
            this.b.post(new Runnable(){

                public void run() {
                    try {
                        CBLogging.e("VideoInit", "preparing activity for video surface");
                        SurfaceView surfaceView = new SurfaceView((Context)CBImpressionActivity.this);
                        CBImpressionActivity.this.addContentView((View)surfaceView, new ViewGroup.LayoutParams(0, 0));
                        return;
                    }
                    catch (Exception exception) {
                        a.a(CBImpressionActivity.class, (String)"postCreateSurfaceView Runnable.run", (Exception)exception);
                        return;
                    }
                }
            });
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Activity activity = this.d;
        if (activity != null) {
            return activity.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void forwardTouchEvents(Activity activity) {
        this.d = activity;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onAttachedToWindow() {
        try {
            super.onAttachedToWindow();
            if (!s.a().a(14)) return;
            if (this.getWindow() == null) return;
            if (this.getWindow().getDecorView() == null) return;
            if (this.getWindow().getDecorView().isHardwareAccelerated()) return;
            if (this.c == null) return;
            CBLogging.b("CBImpressionActivity", "The activity passed down is not hardware accelerated, so Chartboost cannot show ads");
            com.chartboost.sdk.Model.c c2 = this.c.d();
            if (c2 != null) {
                c2.a(CBError.CBImpressionError.HARDWARE_ACCELERATION_DISABLED);
            }
            this.finish();
            return;
        }
        catch (Exception exception) {
            a.a((Class)this.getClass(), (String)"onAttachedToWindow", (Exception)exception);
        }
    }

    public void onBackPressed() {
        try {
            if (this.c == null || !this.c.k()) {
                super.onBackPressed();
                return;
            }
        }
        catch (Exception exception) {
            a.a((Class)this.getClass(), (String)"onBackPressed", (Exception)exception);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if ((this.getIntent() == null || this.getIntent().getBooleanExtra("isChartboost", false)) && this.a != null && this.b != null && this.c != null) {
            this.a();
            this.requestWindowFeature(1);
            this.getWindow().setWindowAnimations(0);
            this.c.a(this);
            this.setContentView((View)new RelativeLayout((Context)this));
            this.b();
            CBLogging.a("CBImpressionActivity", "Impression Activity onCreate() called");
            return;
        }
        CBLogging.b("CBImpressionActivity", "This activity cannot be called from outside chartboost SDK");
        this.finish();
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    protected void onDestroy() {
        block4 : {
            if (this.c == null || i.s) break block4;
            this.c.k((Activity)this);
            {
                catch (Throwable throwable) {
                    super.onDestroy();
                    throw throwable;
                }
            }
        }
        try {
            super.onDestroy();
            return;
        }
        catch (Exception exception) {
            a.a((Class)this.getClass(), (String)"onDestroy", (Exception)exception);
            return;
        }
    }

    protected void onPause() {
        try {
            super.onPause();
            if (this.c != null && !i.s) {
                this.c.a((Activity)this);
                this.c.i();
                return;
            }
        }
        catch (Exception exception) {
            a.a((Class)this.getClass(), (String)"onPause", (Exception)exception);
        }
    }

    protected void onResume() {
        try {
            super.onResume();
            if (this.c != null && !i.s) {
                this.c.a((Activity)this);
                this.c.h();
            }
        }
        catch (Exception exception) {
            a.a((Class)this.getClass(), (String)"onResume", (Exception)exception);
        }
        CBUtility.a(this);
    }

    protected void onStart() {
        try {
            super.onStart();
            if (this.c != null && !i.s) {
                this.c.e((Activity)this);
                return;
            }
        }
        catch (Exception exception) {
            a.a((Class)this.getClass(), (String)"onStart", (Exception)exception);
        }
    }

    protected void onStop() {
        try {
            super.onStop();
            if (this.c != null && !i.s) {
                this.c.i((Activity)this);
                return;
            }
        }
        catch (Exception exception) {
            a.a((Class)this.getClass(), (String)"onStop", (Exception)exception);
        }
    }

}

