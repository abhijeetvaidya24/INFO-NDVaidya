/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Rect
 *  android.os.Handler
 *  android.os.SystemClock
 *  android.view.View
 *  android.view.ViewParent
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnPreDrawListener
 *  com.applovin.impl.mediation.a.b
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.ref.WeakReference
 */
package com.applovin.impl.sdk;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import com.applovin.impl.sdk.b.b;
import com.applovin.impl.sdk.e.m;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.p;
import com.applovin.mediation.ads.MaxAdView;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;

public class v {
    private final j a;
    private final Object b = new Object();
    private final Rect c = new Rect();
    private final Handler d;
    private final Runnable e;
    private final ViewTreeObserver.OnPreDrawListener f;
    private WeakReference<ViewTreeObserver> g;
    private View h;
    private int i;
    private long j;
    private long k = Long.MIN_VALUE;

    public v(final MaxAdView maxAdView, j j2, final a a2) {
        this.a = j2;
        this.d = new Handler();
        this.e = new Runnable(){

            public void run() {
                if (v.this.h == null) {
                    return;
                }
                v v2 = v.this;
                if (v2.b((View)maxAdView, v2.h)) {
                    v.this.a();
                    a2.onLogVisibilityImpression();
                    return;
                }
                v.this.b();
            }
        };
        this.f = new ViewTreeObserver.OnPreDrawListener(){

            public boolean onPreDraw() {
                v.this.b();
                return true;
            }
        };
    }

    private void a(Context context, View view) {
        View view2 = m.a(context, view);
        if (view2 == null) {
            this.a.u().a("VisibilityTracker", "Unable to set view tree observer due to no root view.");
            return;
        }
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            this.a.u().c("VisibilityTracker", "Unable to set view tree observer since the view tree observer is not alive.");
            return;
        }
        this.g = new WeakReference((Object)viewTreeObserver);
        viewTreeObserver.addOnPreDrawListener(this.f);
    }

    private boolean a(View view, View view2) {
        boolean bl = false;
        if (view2 != null) {
            int n2 = view2.getVisibility();
            bl = false;
            if (n2 == 0) {
                if (view.getParent() == null) {
                    return false;
                }
                int n3 = view2.getWidth();
                bl = false;
                if (n3 > 0) {
                    if (view2.getHeight() <= 0) {
                        return false;
                    }
                    if (!view2.getGlobalVisibleRect(this.c)) {
                        return false;
                    }
                    long l2 = (long)(AppLovinSdkUtils.pxToDp(view2.getContext(), this.c.width()) * AppLovinSdkUtils.pxToDp(view2.getContext(), this.c.height())) LCMP (long)this.i;
                    bl = false;
                    if (l2 >= 0) {
                        bl = true;
                    }
                }
            }
        }
        return bl;
    }

    private void b() {
        this.d.postDelayed(this.e, this.a.a(b.cw).longValue());
    }

    private boolean b(View view, View view2) {
        boolean bl = this.a(view, view2);
        boolean bl2 = false;
        if (bl) {
            if (this.k == Long.MIN_VALUE) {
                this.k = SystemClock.uptimeMillis();
            }
            long l2 = SystemClock.uptimeMillis() - this.k LCMP this.j;
            bl2 = false;
            if (l2 >= 0) {
                bl2 = true;
            }
        }
        return bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a() {
        Object object;
        Object object2 = object = this.b;
        synchronized (object2) {
            this.d.removeMessages(0);
            if (this.g != null) {
                ViewTreeObserver viewTreeObserver = (ViewTreeObserver)this.g.get();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnPreDrawListener(this.f);
                }
                this.g.clear();
            }
            this.k = Long.MIN_VALUE;
            this.h = null;
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(Context context, com.applovin.impl.mediation.a.b b2) {
        Object object;
        Object object2 = object = this.b;
        synchronized (object2) {
            this.a();
            this.h = b2.j();
            this.i = b2.o();
            this.j = b2.q();
            this.a(context, this.h);
            return;
        }
    }

    public static interface a {
        public void onLogVisibilityImpression();
    }

}

