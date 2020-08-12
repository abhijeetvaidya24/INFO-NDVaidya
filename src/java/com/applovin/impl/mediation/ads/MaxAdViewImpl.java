/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorListenerAdapter
 *  android.app.Activity
 *  android.content.res.Resources
 *  android.util.DisplayMetrics
 *  android.util.TypedValue
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewPropertyAnimator
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  com.applovin.impl.mediation.a.b
 *  com.applovin.impl.mediation.ads.MaxAdViewImpl$a
 *  com.applovin.impl.mediation.ads.MaxAdViewImpl$c
 *  java.lang.Boolean
 *  java.lang.IllegalArgumentException
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.List
 *  java.util.concurrent.TimeUnit
 */
package com.applovin.impl.mediation.ads;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.RelativeLayout;
import com.applovin.impl.mediation.MediationServiceImpl;
import com.applovin.impl.mediation.a.b;
import com.applovin.impl.mediation.ads.MaxAdViewImpl;
import com.applovin.impl.mediation.f;
import com.applovin.impl.sdk.d.aa;
import com.applovin.impl.sdk.d.q;
import com.applovin.impl.sdk.e;
import com.applovin.impl.sdk.e.h;
import com.applovin.impl.sdk.e.m;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.p;
import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.v;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.ads.MaxAdView;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.List;
import java.util.concurrent.TimeUnit;

/*
 * Exception performing whole class analysis.
 */
public class MaxAdViewImpl
extends com.applovin.impl.mediation.ads.a.a
implements e.a,
v.a {
    private final Activity a;
    private final MaxAdView b;
    private MaxAd c;
    private final a d;
    private final c e;
    private final e f;
    private final u g;
    private final v h;
    private final Object i;
    private b j;
    private boolean k;
    private boolean l;
    private boolean m;

    public MaxAdViewImpl(String string, MaxAdView maxAdView, j j2, Activity activity) {
        super(string, "MaxAdView", j2);
        this.i = new Object();
        this.j = null;
        this.m = false;
        if (activity != null) {
            this.a = activity;
            this.b = maxAdView;
            this.d = new /* Unavailable Anonymous Inner Class!! */;
            this.e = new /* Unavailable Anonymous Inner Class!! */;
            this.f = new e(j2, this);
            this.g = new u(maxAdView, j2);
            this.h = new v(maxAdView, j2, this);
            p p2 = this.logger;
            String string2 = this.tag;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Created new MaxAdView (");
            stringBuilder.append((Object)this);
            stringBuilder.append(")");
            p2.a(string2, stringBuilder.toString());
            return;
        }
        throw new IllegalArgumentException("No activity specified");
    }

    static /* synthetic */ MaxAdListener A(MaxAdViewImpl maxAdViewImpl) {
        return maxAdViewImpl.adListener;
    }

    static /* synthetic */ j B(MaxAdViewImpl maxAdViewImpl) {
        return maxAdViewImpl.sdk;
    }

    static /* synthetic */ MaxAdListener C(MaxAdViewImpl maxAdViewImpl) {
        return maxAdViewImpl.adListener;
    }

    static /* synthetic */ j D(MaxAdViewImpl maxAdViewImpl) {
        return maxAdViewImpl.sdk;
    }

    static /* synthetic */ MaxAdListener E(MaxAdViewImpl maxAdViewImpl) {
        return maxAdViewImpl.adListener;
    }

    static /* synthetic */ j F(MaxAdViewImpl maxAdViewImpl) {
        return maxAdViewImpl.sdk;
    }

    static /* synthetic */ MaxAdListener G(MaxAdViewImpl maxAdViewImpl) {
        return maxAdViewImpl.adListener;
    }

    static /* synthetic */ j H(MaxAdViewImpl maxAdViewImpl) {
        return maxAdViewImpl.sdk;
    }

    static /* synthetic */ MaxAdListener I(MaxAdViewImpl maxAdViewImpl) {
        return maxAdViewImpl.adListener;
    }

    static /* synthetic */ j J(MaxAdViewImpl maxAdViewImpl) {
        return maxAdViewImpl.sdk;
    }

    static /* synthetic */ String K(MaxAdViewImpl maxAdViewImpl) {
        return maxAdViewImpl.tag;
    }

    static /* synthetic */ String L(MaxAdViewImpl maxAdViewImpl) {
        return maxAdViewImpl.adUnitId;
    }

    static /* synthetic */ j M(MaxAdViewImpl maxAdViewImpl) {
        return maxAdViewImpl.sdk;
    }

    static /* synthetic */ e N(MaxAdViewImpl maxAdViewImpl) {
        return maxAdViewImpl.f;
    }

    static /* synthetic */ MaxAdListener O(MaxAdViewImpl maxAdViewImpl) {
        return maxAdViewImpl.adListener;
    }

    static /* synthetic */ j P(MaxAdViewImpl maxAdViewImpl) {
        return maxAdViewImpl.sdk;
    }

    static /* synthetic */ String Q(MaxAdViewImpl maxAdViewImpl) {
        return maxAdViewImpl.tag;
    }

    static /* synthetic */ p R(MaxAdViewImpl maxAdViewImpl) {
        return maxAdViewImpl.logger;
    }

    static /* synthetic */ String S(MaxAdViewImpl maxAdViewImpl) {
        return maxAdViewImpl.adUnitId;
    }

    static /* synthetic */ MaxAdListener T(MaxAdViewImpl maxAdViewImpl) {
        return maxAdViewImpl.adListener;
    }

    static /* synthetic */ j U(MaxAdViewImpl maxAdViewImpl) {
        return maxAdViewImpl.sdk;
    }

    static /* synthetic */ String V(MaxAdViewImpl maxAdViewImpl) {
        return maxAdViewImpl.tag;
    }

    static /* synthetic */ p W(MaxAdViewImpl maxAdViewImpl) {
        return maxAdViewImpl.logger;
    }

    static /* synthetic */ String X(MaxAdViewImpl maxAdViewImpl) {
        return maxAdViewImpl.tag;
    }

    static /* synthetic */ p Y(MaxAdViewImpl maxAdViewImpl) {
        return maxAdViewImpl.logger;
    }

    static /* synthetic */ b a(MaxAdViewImpl maxAdViewImpl) {
        return maxAdViewImpl.j;
    }

    static /* synthetic */ b a(MaxAdViewImpl maxAdViewImpl, b b2) {
        maxAdViewImpl.j = b2;
        return b2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private void a() {
        Object object;
        MaxAdView maxAdView = this.b;
        if (maxAdView != null) {
            maxAdView.removeAllViews();
        }
        this.h.a();
        Object object2 = object = this.i;
        // MONITORENTER : object2
        b b2 = this.j;
        // MONITOREXIT : object2
        if (b2 == null) return;
        this.sdk.a(this.a).destroyAd((MaxAd)b2);
    }

    private void a(int n2) {
        if (this.sdk.b(com.applovin.impl.sdk.b.a.x).contains((Object)String.valueOf((int)n2))) {
            p p2 = this.sdk.u();
            String string = this.tag;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Ignoring banner ad refresh for error code '");
            stringBuilder.append(n2);
            stringBuilder.append("'...");
            p2.a(string, stringBuilder.toString());
            return;
        }
        this.k = true;
        long l2 = this.sdk.a(com.applovin.impl.sdk.b.a.w);
        if (l2 >= 0L) {
            p p3 = this.sdk.u();
            String string = this.tag;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Scheduling failed banner ad refresh ");
            stringBuilder.append(l2);
            stringBuilder.append(" milliseconds from now for '");
            stringBuilder.append(this.adUnitId);
            stringBuilder.append("'...");
            p3.a(string, stringBuilder.toString());
            this.f.a(l2);
        }
    }

    private void a(long l2) {
        if (m.a(l2, this.sdk.a(com.applovin.impl.sdk.b.a.H))) {
            p p2 = this.logger;
            String string = this.tag;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Undesired flags matched - current: ");
            stringBuilder.append(Long.toBinaryString((long)l2));
            stringBuilder.append(", undesired: ");
            stringBuilder.append(Long.toBinaryString((long)l2));
            p2.a(string, stringBuilder.toString());
            this.logger.a(this.tag, "Waiting for refresh timer to manually fire request");
            this.k = true;
            return;
        }
        this.logger.a(this.tag, "No undesired viewability flags matched - scheduling viewability");
        this.k = false;
        this.b();
    }

    private void a(AnimatorListenerAdapter animatorListenerAdapter) {
        b b2 = this.j;
        if (b2 != null) {
            View view = b2.j();
            long l2 = this.sdk.a(com.applovin.impl.sdk.b.a.C);
            view.animate().alpha(0.0f).setDuration(l2).setListener((Animator.AnimatorListener)animatorListenerAdapter).start();
            return;
        }
        animatorListenerAdapter.onAnimationEnd(null);
    }

    private static void a(View view, b b2) {
        int n2;
        DisplayMetrics displayMetrics = view.getResources().getDisplayMetrics();
        int n3 = b2.h();
        int n4 = n3 == (n2 = -1) ? -1 : (int)TypedValue.applyDimension((int)1, (float)b2.h(), (DisplayMetrics)displayMetrics);
        if (b2.i() != n2) {
            n2 = (int)TypedValue.applyDimension((int)1, (float)b2.i(), (DisplayMetrics)displayMetrics);
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        }
        layoutParams.width = n4;
        layoutParams.height = n2;
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams)layoutParams;
            layoutParams2.addRule(10);
            layoutParams2.addRule(9);
        }
        view.setLayoutParams(layoutParams);
    }

    private void a(b b2) {
        AppLovinSdkUtils.runOnUiThread(new Runnable(this, b2){
            final /* synthetic */ b a;
            final /* synthetic */ MaxAdViewImpl b;
            {
                this.b = maxAdViewImpl;
                this.a = b2;
            }

            public void run() {
                String string;
                p p2;
                String string2;
                if (this.a.j() != null) {
                    MaxAdView maxAdView = MaxAdViewImpl.l(this.b);
                    if (maxAdView != null) {
                        MaxAdViewImpl.a(this.b, new AnimatorListenerAdapter(this, maxAdView){
                            final /* synthetic */ MaxAdView a;
                            final /* synthetic */ 2 b;
                            {
                                this.b = var1_1;
                                this.a = maxAdView;
                            }

                            /*
                             * Enabled aggressive block sorting
                             * Enabled unnecessary exception pruning
                             * Enabled aggressive exception aggregation
                             */
                            public void onAnimationEnd(Animator animator) {
                                Object object;
                                super.onAnimationEnd(animator);
                                MaxAdViewImpl.m(this.b.b);
                                if (this.b.a.p()) {
                                    MaxAdViewImpl.n(this.b.b).a((android.content.Context)MaxAdViewImpl.j(this.b.b), this.b.a);
                                }
                                MaxAdViewImpl.a(this.b.b, this.b.a, this.a);
                                Object object2 = object = MaxAdViewImpl.o(this.b.b);
                                synchronized (object2) {
                                    MaxAdViewImpl.a(this.b.b, this.b.a);
                                }
                                MaxAdViewImpl.q(this.b.b).a(MaxAdViewImpl.p(this.b.b), "Scheduling impression for ad manually...");
                                MaxAdViewImpl.r(this.b.b).a(MaxAdViewImpl.j(this.b.b)).maybeScheduleRawAdImpressionPostback((com.applovin.impl.mediation.a.a)this.b.a);
                                AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable(this){
                                    final /* synthetic */ com.applovin.impl.mediation.ads.MaxAdViewImpl$2$1 a;
                                    {
                                        this.a = var1_1;
                                    }

                                    public void run() {
                                        long l2 = MaxAdViewImpl.b(this.a.b.b).a(this.a.b.a);
                                        if (!this.a.b.a.p()) {
                                            MaxAdViewImpl.a(this.a.b.b, this.a.b.a, l2);
                                        }
                                        MaxAdViewImpl.a(this.a.b.b, l2);
                                    }
                                }, this.b.a.k());
                            }
                        });
                        return;
                    }
                    p2 = MaxAdViewImpl.t(this.b);
                    string2 = MaxAdViewImpl.s(this.b);
                    string = "Max ad view does not have a parent View";
                } else {
                    p2 = MaxAdViewImpl.w(this.b);
                    string2 = MaxAdViewImpl.v(this.b);
                    string = "Max ad does not have a loaded ad view";
                }
                p2.d(string2, string);
                MaxAdViewImpl.u(this.b).onAdDisplayFailed((MaxAd)this.a, -5201);
            }
        });
    }

    private void a(b b2, long l2) {
        this.logger.a(this.tag, "Scheduling viewability impression for ad...");
        this.sdk.a(this.a).maybeScheduleViewabilityAdImpressionPostback(b2, l2);
    }

    private void a(b b2, MaxAdView maxAdView) {
        View view = b2.j();
        view.setAlpha(0.0f);
        MaxAdViewImpl.a(view, b2);
        maxAdView.setBackgroundColor(0);
        maxAdView.addView(view);
        long l2 = this.sdk.a(com.applovin.impl.sdk.b.a.B);
        view.animate().alpha(1.0f).setDuration(l2).start();
    }

    static /* synthetic */ void a(MaxAdViewImpl maxAdViewImpl, int n2) {
        maxAdViewImpl.a(n2);
    }

    static /* synthetic */ void a(MaxAdViewImpl maxAdViewImpl, long l2) {
        maxAdViewImpl.a(l2);
    }

    static /* synthetic */ void a(MaxAdViewImpl maxAdViewImpl, AnimatorListenerAdapter animatorListenerAdapter) {
        maxAdViewImpl.a(animatorListenerAdapter);
    }

    static /* synthetic */ void a(MaxAdViewImpl maxAdViewImpl, b b2, long l2) {
        maxAdViewImpl.a(b2, l2);
    }

    static /* synthetic */ void a(MaxAdViewImpl maxAdViewImpl, b b2, MaxAdView maxAdView) {
        maxAdViewImpl.a(b2, maxAdView);
    }

    static /* synthetic */ void a(MaxAdViewImpl maxAdViewImpl, MaxAd maxAd) {
        maxAdViewImpl.a(maxAd);
    }

    static /* synthetic */ void a(MaxAdViewImpl maxAdViewImpl, MaxAdListener maxAdListener) {
        maxAdViewImpl.a(maxAdListener);
    }

    private void a(MaxAd maxAd) {
        if (this.l) {
            this.l = false;
            p p2 = this.logger;
            String string = this.tag;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Rendering precache request ad: ");
            stringBuilder.append(maxAd.getAdUnitId());
            stringBuilder.append("...");
            p2.a(string, stringBuilder.toString());
            this.d.onAdLoaded(maxAd);
            return;
        }
        this.c = maxAd;
    }

    private void a(MaxAdListener maxAdListener) {
        if (this.d()) {
            this.logger.e(this.tag, "Unable to load new ad; ad is already destroyed");
            h.a(this.adListener, this.adUnitId, -1, this.sdk);
            return;
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable(this, maxAdListener){
            final /* synthetic */ MaxAdListener a;
            final /* synthetic */ MaxAdViewImpl b;
            {
                this.b = maxAdViewImpl;
                this.a = maxAdListener;
            }

            public void run() {
                if (MaxAdViewImpl.a(this.b) != null) {
                    long l2 = MaxAdViewImpl.b(this.b).a(MaxAdViewImpl.a(this.b));
                    MaxAdViewImpl.c(this.b).a("visible_ad_ad_unit_id", MaxAdViewImpl.a(this.b).getAdUnitId()).a("viewability_flags", String.valueOf((long)l2));
                } else {
                    MaxAdViewImpl.d(this.b).a("visible_ad_ad_unit_id").a("viewability_flags");
                }
                p p2 = MaxAdViewImpl.g(this.b);
                String string = MaxAdViewImpl.e(this.b);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Loading banner ad for '");
                stringBuilder.append(MaxAdViewImpl.f(this.b));
                stringBuilder.append("' and notifying ");
                stringBuilder.append((Object)this.a);
                stringBuilder.append("...");
                p2.a(string, stringBuilder.toString());
                MaxAdViewImpl.k(this.b).a(MaxAdViewImpl.j(this.b)).loadAd(MaxAdViewImpl.h(this.b), MaxAdFormat.BANNER, MaxAdViewImpl.i(this.b).a(), MaxAdViewImpl.j(this.b), this.a);
            }
        });
    }

    static /* synthetic */ u b(MaxAdViewImpl maxAdViewImpl) {
        return maxAdViewImpl.g;
    }

    private void b() {
        if (!this.c()) {
            return;
        }
        long l2 = this.sdk.a(com.applovin.impl.sdk.b.a.I);
        p p2 = this.logger;
        String string = this.tag;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Scheduling refresh precache request in ");
        stringBuilder.append(TimeUnit.MICROSECONDS.toSeconds(l2));
        stringBuilder.append(" seconds...");
        p2.a(string, stringBuilder.toString());
        aa aa2 = new aa(this.sdk, new Runnable(this){
            final /* synthetic */ MaxAdViewImpl a;
            {
                this.a = maxAdViewImpl;
            }

            public void run() {
                MaxAdViewImpl maxAdViewImpl = this.a;
                MaxAdViewImpl.a(maxAdViewImpl, (MaxAdListener)MaxAdViewImpl.x(maxAdViewImpl));
            }
        });
        q.a a2 = com.applovin.impl.mediation.c.c.a(MaxAdFormat.BANNER, q.a.i, this.sdk);
        this.sdk.C().a(aa2, a2, l2);
    }

    static /* synthetic */ void b(MaxAdViewImpl maxAdViewImpl, b b2) {
        maxAdViewImpl.a(b2);
    }

    static /* synthetic */ f.a c(MaxAdViewImpl maxAdViewImpl) {
        return maxAdViewImpl.loadRequestBuilder;
    }

    private boolean c() {
        return this.sdk.a(com.applovin.impl.sdk.b.a.I) > 0L;
    }

    static /* synthetic */ f.a d(MaxAdViewImpl maxAdViewImpl) {
        return maxAdViewImpl.loadRequestBuilder;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean d() {
        Object object;
        Object object2 = object = this.i;
        synchronized (object2) {
            return this.m;
        }
    }

    static /* synthetic */ String e(MaxAdViewImpl maxAdViewImpl) {
        return maxAdViewImpl.tag;
    }

    static /* synthetic */ String f(MaxAdViewImpl maxAdViewImpl) {
        return maxAdViewImpl.adUnitId;
    }

    static /* synthetic */ p g(MaxAdViewImpl maxAdViewImpl) {
        return maxAdViewImpl.logger;
    }

    static /* synthetic */ String h(MaxAdViewImpl maxAdViewImpl) {
        return maxAdViewImpl.adUnitId;
    }

    static /* synthetic */ f.a i(MaxAdViewImpl maxAdViewImpl) {
        return maxAdViewImpl.loadRequestBuilder;
    }

    static /* synthetic */ Activity j(MaxAdViewImpl maxAdViewImpl) {
        return maxAdViewImpl.a;
    }

    static /* synthetic */ j k(MaxAdViewImpl maxAdViewImpl) {
        return maxAdViewImpl.sdk;
    }

    static /* synthetic */ MaxAdView l(MaxAdViewImpl maxAdViewImpl) {
        return maxAdViewImpl.b;
    }

    static /* synthetic */ void m(MaxAdViewImpl maxAdViewImpl) {
        maxAdViewImpl.a();
    }

    static /* synthetic */ v n(MaxAdViewImpl maxAdViewImpl) {
        return maxAdViewImpl.h;
    }

    static /* synthetic */ Object o(MaxAdViewImpl maxAdViewImpl) {
        return maxAdViewImpl.i;
    }

    static /* synthetic */ String p(MaxAdViewImpl maxAdViewImpl) {
        return maxAdViewImpl.tag;
    }

    static /* synthetic */ p q(MaxAdViewImpl maxAdViewImpl) {
        return maxAdViewImpl.logger;
    }

    static /* synthetic */ j r(MaxAdViewImpl maxAdViewImpl) {
        return maxAdViewImpl.sdk;
    }

    static /* synthetic */ String s(MaxAdViewImpl maxAdViewImpl) {
        return maxAdViewImpl.tag;
    }

    static /* synthetic */ p t(MaxAdViewImpl maxAdViewImpl) {
        return maxAdViewImpl.logger;
    }

    static /* synthetic */ a u(MaxAdViewImpl maxAdViewImpl) {
        return maxAdViewImpl.d;
    }

    static /* synthetic */ String v(MaxAdViewImpl maxAdViewImpl) {
        return maxAdViewImpl.tag;
    }

    static /* synthetic */ p w(MaxAdViewImpl maxAdViewImpl) {
        return maxAdViewImpl.logger;
    }

    static /* synthetic */ c x(MaxAdViewImpl maxAdViewImpl) {
        return maxAdViewImpl.e;
    }

    static /* synthetic */ MaxAdListener y(MaxAdViewImpl maxAdViewImpl) {
        return maxAdViewImpl.adListener;
    }

    static /* synthetic */ j z(MaxAdViewImpl maxAdViewImpl) {
        return maxAdViewImpl.sdk;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void destroy() {
        Object object;
        this.a();
        Object object2 = object = this.i;
        synchronized (object2) {
            this.m = true;
        }
        this.f.e();
    }

    public void loadAd() {
        p p2 = this.logger;
        String string = this.tag;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append((Object)this);
        stringBuilder.append(" Loading ad for ");
        stringBuilder.append(this.adUnitId);
        stringBuilder.append("...");
        p2.a(string, stringBuilder.toString());
        if (this.d()) {
            this.logger.e(this.tag, "Unable to load new ad; ad is already destroyed");
            h.a(this.adListener, this.adUnitId, -1, this.sdk);
            return;
        }
        if (this.sdk.a(com.applovin.impl.sdk.b.a.J).booleanValue() && this.f.a()) {
            p p3 = this.logger;
            String string2 = this.tag;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Unable to load a new ad. An ad refresh has already been scheduled in ");
            stringBuilder2.append(TimeUnit.MILLISECONDS.toSeconds(this.f.d()));
            stringBuilder2.append(" seconds.");
            p3.e(string2, stringBuilder2.toString());
            return;
        }
        this.a((MaxAdListener)this.d);
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void onAdRefresh() {
        String string;
        String string2;
        p p2;
        this.l = false;
        if (this.c != null) {
            p p3 = this.logger;
            String string3 = this.tag;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Refreshing for cached ad: ");
            stringBuilder.append(this.c.getAdUnitId());
            stringBuilder.append("...");
            p3.a(string3, stringBuilder.toString());
            this.d.onAdLoaded(this.c);
            this.c = null;
            return;
        }
        if (this.c()) {
            if (!this.k) {
                this.logger.d(this.tag, "Ignoring attempt to refresh ad - either still waiting for precache or did not attempt request due to visibility requirement not met");
                this.l = true;
                return;
            }
            p2 = this.logger;
            string2 = this.tag;
            string = "Refreshing ad from network due to viewability requirements not met for refresh request...";
        } else {
            p2 = this.logger;
            string2 = this.tag;
            string = "Refreshing ad from network...";
        }
        p2.a(string2, string);
        this.loadAd();
    }

    @Override
    public void onLogVisibilityImpression() {
        long l2 = this.g.a(this.j);
        this.a(this.j, l2);
    }

    public void startAutoRefresh() {
        this.f.g();
        p p2 = this.logger;
        String string = this.tag;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Resumed autorefresh with remaining time: ");
        stringBuilder.append(this.f.d());
        p2.a(string, stringBuilder.toString());
    }

    public void stopAutoRefresh() {
        p p2 = this.logger;
        String string = this.tag;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Pausing autorefresh with remaining time: ");
        stringBuilder.append(this.f.d());
        p2.a(string, stringBuilder.toString());
        this.f.f();
    }
}

