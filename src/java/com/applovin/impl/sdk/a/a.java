/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.net.Uri
 *  com.applovin.impl.sdk.AppLovinAdBase
 *  com.applovin.impl.sdk.AppLovinAdServiceImpl
 *  com.applovin.impl.sdk.a.a$2
 *  com.applovin.impl.sdk.a.a$a
 *  com.applovin.impl.sdk.a.a$b
 *  com.applovin.impl.sdk.ad.a
 *  com.applovin.impl.sdk.ad.g
 *  com.applovin.impl.sdk.ad.h
 *  com.applovin.impl.sdk.d
 *  com.applovin.impl.sdk.d.ab
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.ref.SoftReference
 */
package com.applovin.impl.sdk.a;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import com.applovin.adview.AppLovinInterstitialAd;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.AppLovinAdServiceImpl;
import com.applovin.impl.sdk.a.a;
import com.applovin.impl.sdk.a.c;
import com.applovin.impl.sdk.ad.d;
import com.applovin.impl.sdk.ad.g;
import com.applovin.impl.sdk.ad.h;
import com.applovin.impl.sdk.ad.j;
import com.applovin.impl.sdk.d.ab;
import com.applovin.impl.sdk.d.q;
import com.applovin.impl.sdk.e.m;
import com.applovin.impl.sdk.p;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinAdService;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdk;
import java.lang.ref.SoftReference;

/*
 * Exception performing whole class analysis.
 */
public class a {
    protected final com.applovin.impl.sdk.j a;
    protected final AppLovinAdServiceImpl b;
    private AppLovinAd c;
    private String d;
    private SoftReference<AppLovinAdLoadListener> e;
    private final Object f;
    private volatile String g;
    private ab h;
    private volatile boolean i;
    private SoftReference<AppLovinInterstitialAdDialog> j;

    public a(String string2, AppLovinSdk appLovinSdk) {
        this.f = new Object();
        this.i = false;
        this.a = m.a(appLovinSdk);
        this.b = (AppLovinAdServiceImpl)appLovinSdk.getAdService();
        this.d = string2;
    }

    static /* synthetic */ String a(a a2) {
        return a2.e();
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a(AppLovinAdBase appLovinAdBase, String string2, Context context, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        Activity activity;
        block5 : {
            block8 : {
                p p2;
                String string3;
                block4 : {
                    block6 : {
                        com.applovin.impl.sdk.ad.a a2;
                        block7 : {
                            block3 : {
                                if (appLovinAdBase.getType().equals(AppLovinAdType.INCENTIVIZED)) break block3;
                                p2 = this.a.u();
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("Failed to render an ad of type ");
                                stringBuilder.append((Object)appLovinAdBase.getType());
                                stringBuilder.append(" in an Incentivized Ad interstitial.");
                                string3 = stringBuilder.toString();
                                break block4;
                            }
                            if (!m.a((AppLovinAd)appLovinAdBase, this.a)) {
                                this.a((AppLovinAd)appLovinAdBase, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener);
                                return;
                            }
                            g g2 = appLovinAdBase instanceof h ? (g)this.a.L().c(appLovinAdBase.getAdZone()) : (g)appLovinAdBase;
                            if (m.a(g2, context, this.a)) break block5;
                            this.a.D().a(com.applovin.impl.sdk.c.g.o);
                            if (!(g2 instanceof com.applovin.impl.sdk.ad.a)) break block6;
                            a2 = (com.applovin.impl.sdk.ad.a)g2;
                            if (!a2.ag() || !a2.d()) break block7;
                            p p3 = this.a.u();
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Cached video removed from local filesystem for ad server ad. Restored video uri to video stream url: ");
                            stringBuilder.append((Object)a2.e());
                            p3.d("IncentivizedAdController", stringBuilder.toString());
                            break block5;
                        }
                        p p4 = this.a.u();
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Cached video removed from local filesystem for ad server ad: ");
                        stringBuilder.append(a2.getAdIdNumber());
                        stringBuilder.append(" and could not restore video stream url. Failing ad show.");
                        p4.d("IncentivizedAdController", stringBuilder.toString());
                        break block8;
                    }
                    p2 = this.a.u();
                    string3 = "Failed to render an ad: video cache has been removed.";
                }
                p2.d("IncentivizedAdController", string3);
            }
            this.a((AppLovinAd)appLovinAdBase, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener);
            return;
        }
        Runnable runnable = new Runnable(this, appLovinAdBase, context, appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener, string2){
            final /* synthetic */ AppLovinAdBase a;
            final /* synthetic */ Context b;
            final /* synthetic */ AppLovinAdRewardListener c;
            final /* synthetic */ AppLovinAdVideoPlaybackListener d;
            final /* synthetic */ AppLovinAdDisplayListener e;
            final /* synthetic */ AppLovinAdClickListener f;
            final /* synthetic */ String g;
            final /* synthetic */ a h;
            {
                this.h = a2;
                this.a = appLovinAdBase;
                this.b = context;
                this.c = appLovinAdRewardListener;
                this.d = appLovinAdVideoPlaybackListener;
                this.e = appLovinAdDisplayListener;
                this.f = appLovinAdClickListener;
                this.g = string2;
            }

            public void run() {
                AppLovinAd appLovinAd = m.b((AppLovinAd)this.a, this.h.a);
                if (appLovinAd != null) {
                    AppLovinInterstitialAdDialog appLovinInterstitialAdDialog = AppLovinInterstitialAd.create(this.h.a.K(), this.b);
                    b b2 = new /* Unavailable Anonymous Inner Class!! */;
                    appLovinInterstitialAdDialog.setAdDisplayListener((AppLovinAdDisplayListener)b2);
                    appLovinInterstitialAdDialog.setAdVideoPlaybackListener((AppLovinAdVideoPlaybackListener)b2);
                    appLovinInterstitialAdDialog.setAdClickListener((AppLovinAdClickListener)b2);
                    appLovinInterstitialAdDialog.showAndRender(appLovinAd, this.g);
                    this.h.j = new SoftReference((Object)appLovinInterstitialAdDialog);
                    if (appLovinAd instanceof g) {
                        this.h.a((g)appLovinAd, (AppLovinAdRewardListener)b2);
                        return;
                    }
                } else {
                    this.h.a((AppLovinAd)this.a, this.d, this.e);
                }
            }
        };
        boolean bl = this.a.a(com.applovin.impl.sdk.b.b.bW);
        if (bl && context instanceof Activity && !(activity = (Activity)context).isFinishing()) {
            c.a().a(this.a).a(activity).a(this).a(appLovinAdRewardListener).a(runnable).a().a((AppLovinAd)appLovinAdBase);
            return;
        }
        if (bl) {
            this.a.u().e("IncentivizedAdController", "Unable to show Incentivized Ad prompt. Must pass in an active Activity context.");
        }
        this.a.D().a(com.applovin.impl.sdk.c.g.j);
        runnable.run();
    }

    static /* synthetic */ void a(a a2, AppLovinAd appLovinAd) {
        a2.a(appLovinAd);
    }

    static /* synthetic */ void a(a a2, String string2) {
        a2.a(string2);
    }

    static /* synthetic */ void a(a a2, String string2, Context context) {
        a2.a(string2, context);
    }

    private void a(g g2, AppLovinAdRewardListener appLovinAdRewardListener) {
        this.h = new ab(g2, appLovinAdRewardListener, this.a);
        this.a.C().a((com.applovin.impl.sdk.d.a)this.h, q.a.h);
    }

    private void a(AppLovinAd appLovinAd) {
        AppLovinAd appLovinAd2 = this.c;
        if (appLovinAd2 != null && (appLovinAd2 instanceof h ? appLovinAd == ((h)appLovinAd2).a() : appLovinAd == appLovinAd2)) {
            this.c = null;
        }
    }

    private void a(AppLovinAd appLovinAd, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener) {
        this.a.D().a(com.applovin.impl.sdk.c.g.m);
        com.applovin.impl.sdk.e.h.a(appLovinAdVideoPlaybackListener, appLovinAd, 0.0, false, this.a);
        com.applovin.impl.sdk.e.h.b(appLovinAdDisplayListener, appLovinAd, this.a);
    }

    private void a(AppLovinAd appLovinAd, String string2, Context context, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        if (appLovinAd == null) {
            appLovinAd = this.c;
        }
        AppLovinAdBase appLovinAdBase = (AppLovinAdBase)appLovinAd;
        if (appLovinAdBase != null) {
            this.a(appLovinAdBase, string2, context, appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
            return;
        }
        this.a.u().e("IncentivizedAdController", "Skipping incentivized video playback: user attempted to play an incentivized video before one was preloaded.");
        this.d();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(String string2) {
        Object object;
        Object object2 = object = this.f;
        synchronized (object2) {
            this.g = string2;
            return;
        }
    }

    private void a(String string2, Context context) {
        if (string2 != null && this.a.a(com.applovin.impl.sdk.b.b.bX).booleanValue()) {
            new com.applovin.impl.sdk.a.b(this.a, context, string2).a();
        }
    }

    static /* synthetic */ boolean a(a a2, boolean bl) {
        a2.i = bl;
        return bl;
    }

    static /* synthetic */ AppLovinAd b(a a2, AppLovinAd appLovinAd) {
        a2.c = appLovinAd;
        return appLovinAd;
    }

    private void b(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.b.loadNextIncentivizedAd(this.d, appLovinAdLoadListener);
    }

    static /* synthetic */ boolean b(a a2) {
        return a2.i;
    }

    static /* synthetic */ ab c(a a2) {
        return a2.h;
    }

    private void d() {
        AppLovinAdLoadListener appLovinAdLoadListener;
        SoftReference<AppLovinAdLoadListener> softReference = this.e;
        if (softReference != null && (appLovinAdLoadListener = (AppLovinAdLoadListener)softReference.get()) != null) {
            appLovinAdLoadListener.failedToReceiveAd(-300);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private String e() {
        Object object;
        Object object2 = object = this.f;
        synchronized (object2) {
            return this.g;
        }
    }

    private AppLovinAdRewardListener f() {
        return new 2(this);
    }

    public void a(AppLovinAd appLovinAd, Context context, String string2, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        if (appLovinAdRewardListener == null) {
            appLovinAdRewardListener = this.f();
        }
        this.a(appLovinAd, string2, context, appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
    }

    void a(AppLovinAd appLovinAd, AppLovinAdRewardListener appLovinAdRewardListener) {
        com.applovin.impl.sdk.e.h.a(appLovinAdRewardListener, appLovinAd, this.a);
    }

    public void a(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.a.u().a("IncentivizedAdController", "User requested preload of incentivized ad...");
        this.e = new SoftReference((Object)appLovinAdLoadListener);
        if (this.a()) {
            this.a.u().e("IncentivizedAdController", "Attempted to call preloadAndNotify: while an ad was already loaded or currently being played. Do not call preloadAndNotify: again until the last ad has been closed (adHidden).");
            if (appLovinAdLoadListener != null) {
                appLovinAdLoadListener.adReceived(this.c);
            }
            return;
        }
        this.b((AppLovinAdLoadListener)new /* Unavailable Anonymous Inner Class!! */);
    }

    public boolean a() {
        return this.c != null;
    }

    public String b() {
        return this.d;
    }

    public void c() {
        AppLovinInterstitialAdDialog appLovinInterstitialAdDialog;
        SoftReference<AppLovinInterstitialAdDialog> softReference = this.j;
        if (softReference != null && (appLovinInterstitialAdDialog = (AppLovinInterstitialAdDialog)softReference.get()) != null) {
            appLovinInterstitialAdDialog.dismiss();
        }
    }

}

