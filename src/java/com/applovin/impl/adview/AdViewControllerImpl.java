/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.net.Uri
 *  android.text.TextUtils
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.util.Log
 *  android.util.TypedValue
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 *  android.webkit.WebView
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  com.applovin.adview.AppLovinInterstitialActivity
 *  com.applovin.impl.sdk.ad.g
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.concurrent.atomic.AtomicReference
 */
package com.applovin.impl.adview;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.applovin.adview.AdViewController;
import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinAdViewEventListener;
import com.applovin.adview.AppLovinInterstitialActivity;
import com.applovin.impl.adview.AdViewControllerImpl;
import com.applovin.impl.adview.f;
import com.applovin.impl.adview.j;
import com.applovin.impl.sdk.AppLovinAdServiceImpl;
import com.applovin.impl.sdk.ad.g;
import com.applovin.impl.sdk.ad.i;
import com.applovin.impl.sdk.e.h;
import com.applovin.impl.sdk.e.m;
import com.applovin.impl.sdk.p;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdService;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdUpdateListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.concurrent.atomic.AtomicReference;

public class AdViewControllerImpl
implements AdViewController {
    private volatile AppLovinAdDisplayListener A;
    private volatile AppLovinAdViewEventListener B;
    private volatile AppLovinAdClickListener C;
    private volatile boolean D;
    private Context a;
    private ViewGroup b;
    private com.applovin.impl.sdk.j c;
    private AppLovinAdServiceImpl d;
    private p e;
    private AppLovinAdSize f;
    private String g;
    private String h;
    private com.applovin.impl.sdk.c.d i;
    private com.applovin.impl.adview.d j;
    private d k;
    private com.applovin.impl.adview.c l;
    private AppLovinAd m;
    private Runnable n;
    private Runnable o;
    private volatile AppLovinAd p = null;
    private volatile AppLovinAd q = null;
    private f r = null;
    private j s = null;
    private j t = null;
    private final AtomicReference<AppLovinAd> u = new AtomicReference();
    private volatile boolean v = false;
    private volatile boolean w = true;
    private volatile boolean x = false;
    private volatile boolean y = false;
    private volatile AppLovinAdLoadListener z;

    static /* synthetic */ j a(AdViewControllerImpl adViewControllerImpl) {
        return adViewControllerImpl.s;
    }

    static /* synthetic */ j a(AdViewControllerImpl adViewControllerImpl, j j2) {
        adViewControllerImpl.t = j2;
        return j2;
    }

    private void a(AppLovinAdView appLovinAdView, com.applovin.impl.sdk.j j2, AppLovinAdSize appLovinAdSize, String string, Context context) {
        if (appLovinAdView != null) {
            if (j2 != null) {
                if (appLovinAdSize != null) {
                    this.c = j2;
                    this.d = j2.n();
                    this.e = j2.u();
                    this.f = appLovinAdSize;
                    this.g = string;
                    this.a = context;
                    this.b = appLovinAdView;
                    this.m = new i();
                    this.j = new com.applovin.impl.adview.d(this, j2);
                    this.o = new Runnable(){

                        public void run() {
                            if (AdViewControllerImpl.this.l != null) {
                                AdViewControllerImpl.this.l.setVisibility(8);
                            }
                        }
                    };
                    this.n = new Runnable(){

                        public void run() {
                            if (AdViewControllerImpl.this.p != null) {
                                if (AdViewControllerImpl.this.l != null) {
                                    p p2 = AdViewControllerImpl.this.e;
                                    StringBuilder stringBuilder = new StringBuilder();
                                    stringBuilder.append("Rendering advertisement ad for #");
                                    stringBuilder.append(AdViewControllerImpl.this.p.getAdIdNumber());
                                    stringBuilder.append(" over placement: \"");
                                    stringBuilder.append(AdViewControllerImpl.this.h);
                                    stringBuilder.append("\"...");
                                    p2.a("AppLovinAdView", stringBuilder.toString());
                                    AdViewControllerImpl.b((View)AdViewControllerImpl.this.l, AdViewControllerImpl.this.p.getSize());
                                    AdViewControllerImpl.this.l.a(AdViewControllerImpl.this.p, AdViewControllerImpl.this.h);
                                    if (AdViewControllerImpl.this.p.getSize() != AppLovinAdSize.INTERSTITIAL && !AdViewControllerImpl.this.x && !(AdViewControllerImpl.this.p instanceof i)) {
                                        AdViewControllerImpl adViewControllerImpl = AdViewControllerImpl.this;
                                        adViewControllerImpl.i = new com.applovin.impl.sdk.c.d(adViewControllerImpl.p, AdViewControllerImpl.this.c);
                                        AdViewControllerImpl.this.i.a();
                                        AdViewControllerImpl.this.l.a(AdViewControllerImpl.this.i);
                                        if (AdViewControllerImpl.this.p instanceof g) {
                                            ((g)AdViewControllerImpl.this.p).setHasShown(true);
                                        }
                                    }
                                    if (AdViewControllerImpl.this.l.c() != null && AdViewControllerImpl.this.p instanceof g) {
                                        long l2 = ((g)AdViewControllerImpl.this.p).s() ? 0L : 1L;
                                        AdViewControllerImpl.this.l.c().a(l2);
                                        return;
                                    }
                                } else {
                                    p p3 = AdViewControllerImpl.this.c.u();
                                    StringBuilder stringBuilder = new StringBuilder();
                                    stringBuilder.append("Unable to render advertisement for ad #");
                                    stringBuilder.append(AdViewControllerImpl.this.p.getAdIdNumber());
                                    stringBuilder.append(". Please make sure you are not calling AppLovinAdView.destroy() prematurely.");
                                    p3.e("AppLovinAdView", stringBuilder.toString());
                                }
                            }
                        }
                    };
                    this.k = new d(this, j2);
                    this.a(appLovinAdSize);
                    return;
                }
                throw new IllegalArgumentException("No ad size specified");
            }
            throw new IllegalArgumentException("No sdk specified");
        }
        throw new IllegalArgumentException("No parent view specified");
    }

    static /* synthetic */ void a(AdViewControllerImpl adViewControllerImpl, AppLovinAdSize appLovinAdSize) {
        adViewControllerImpl.a(appLovinAdSize);
    }

    private void a(g g2, AppLovinAdView appLovinAdView, Uri uri) {
        if (this.r == null) {
            if (appLovinAdView != null) {
                this.e.a("AppLovinAdView", "Creating and rendering click overlay");
                this.r = new f(appLovinAdView.getContext(), this.c);
                this.r.setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
                appLovinAdView.addView((View)this.r);
                appLovinAdView.bringChildToFront((View)this.r);
                this.d.trackAndLaunchForegroundClick((AppLovinAd)g2, this.h, appLovinAdView, this, uri);
                return;
            }
            this.e.d("AppLovinAdView", "Skipping click overlay rendering because AppLovinAdView has been destroyed");
            return;
        }
        this.e.a("AppLovinAdView", "Skipping click overlay rendering because it already exists");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(AppLovinAdSize appLovinAdSize) {
        try {
            block8 : {
                Runnable runnable;
                block9 : {
                    block7 : {
                        this.l = new com.applovin.impl.adview.c(this.j, this.c, this.a);
                        this.l.setBackgroundColor(0);
                        this.l.setWillNotCacheDrawing(false);
                        this.b.setBackgroundColor(0);
                        this.b.addView((View)this.l);
                        AdViewControllerImpl.b((View)this.l, appLovinAdSize);
                        if (!this.c.g()) break block7;
                        if (!this.v && this.c.a(com.applovin.impl.sdk.b.b.eo).booleanValue()) {
                            this.a(this.o);
                        }
                        if (!this.c.a(com.applovin.impl.sdk.b.b.ep).booleanValue()) break block8;
                        runnable = new Runnable(){

                            /*
                             * Exception decompiling
                             */
                            public void run() {
                                // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                                // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
                                // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
                                // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
                                // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
                                // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
                                // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
                                // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
                                // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
                                // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
                                // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
                                // org.benf.cfr.reader.entities.g.p(Method.java:396)
                                // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
                                // org.benf.cfr.reader.entities.d.c(ClassFile.java:773)
                                // org.benf.cfr.reader.entities.d.e(ClassFile.java:870)
                                // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
                                // org.benf.cfr.reader.b.a(Driver.java:128)
                                // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
                                // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
                                // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
                                // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
                                // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
                                // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
                                // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
                                // java.lang.Thread.run(Thread.java:919)
                                throw new IllegalStateException("Decompilation failed");
                            }
                        };
                        break block9;
                    }
                    if (!this.v) {
                        this.a(this.o);
                    }
                    if (!this.c.a(com.applovin.impl.sdk.b.b.fp).booleanValue()) break block8;
                    runnable = new /* invalid duplicate definition of identical inner class */;
                }
                this.a(runnable);
            }
            this.v = true;
            return;
        }
        catch (Throwable throwable) {
            p p2 = this.e;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to create AdView: ");
            stringBuilder.append(throwable.getMessage());
            p2.e("AppLovinAdView", stringBuilder.toString());
            return;
        }
    }

    private void a(Runnable runnable) {
        AppLovinSdkUtils.runOnUiThread(runnable);
    }

    static /* synthetic */ j b(AdViewControllerImpl adViewControllerImpl, j j2) {
        adViewControllerImpl.s = j2;
        return j2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private void b() {
        block8 : {
            var1_1 = this.e;
            if (var1_1 != null) {
                var1_1.a("AppLovinAdView", "Destroying...");
            }
            if ((var2_2 = this.d) != null) {
                var2_2.removeAdUpdateListener(this.k, this.getSize());
            }
            if ((var3_3 = this.l) == null) break block8;
            var5_4 = var3_3.getParent();
            if (var5_4 != null && var5_4 instanceof ViewGroup) {
                ((ViewGroup)var5_4).removeView((View)this.l);
            }
            this.l.removeAllViews();
            var6_5 = this.c.a(com.applovin.impl.sdk.b.b.fc);
            if (!var6_5) ** GOTO lbl22
            try {
                this.l.loadUrl("about:blank");
                this.l.onPause();
                this.l.destroyDrawingCache();
                ** GOTO lbl22
            }
            catch (Throwable var7_6) {
                try {
                    this.e.b("AppLovinAdView", "Encountered error while cleaning up WebView", var7_6);
lbl22: // 3 sources:
                    this.l.destroy();
                    this.l = null;
                }
                catch (Throwable var4_7) {
                    this.e.a("AppLovinAdView", "Unable to destroy ad view", var4_7);
                }
            }
        }
        this.x = true;
    }

    private static void b(View view, AppLovinAdSize appLovinAdSize) {
        ViewGroup.LayoutParams layoutParams;
        if (view == null) {
            return;
        }
        DisplayMetrics displayMetrics = view.getResources().getDisplayMetrics();
        boolean bl = appLovinAdSize.getLabel().equals((Object)AppLovinAdSize.INTERSTITIAL.getLabel());
        int n2 = -1;
        int n3 = bl ? -1 : (appLovinAdSize.getWidth() == n2 ? displayMetrics.widthPixels : (int)TypedValue.applyDimension((int)1, (float)appLovinAdSize.getWidth(), (DisplayMetrics)displayMetrics));
        if (!appLovinAdSize.getLabel().equals((Object)AppLovinAdSize.INTERSTITIAL.getLabel())) {
            n2 = appLovinAdSize.getHeight() == n2 ? displayMetrics.heightPixels : (int)TypedValue.applyDimension((int)1, (float)appLovinAdSize.getHeight(), (DisplayMetrics)displayMetrics);
        }
        if ((layoutParams = view.getLayoutParams()) == null) {
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        }
        layoutParams.width = n3;
        layoutParams.height = n2;
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams)layoutParams;
            layoutParams2.addRule(10);
            layoutParams2.addRule(9);
        }
        view.setLayoutParams(layoutParams);
    }

    static /* synthetic */ AppLovinAdSize c(AdViewControllerImpl adViewControllerImpl) {
        return adViewControllerImpl.f;
    }

    private void c() {
        this.a(new Runnable(this){
            final /* synthetic */ AdViewControllerImpl a;
            {
                this.a = adViewControllerImpl;
            }

            public void run() {
                if (AdViewControllerImpl.a(this.a) != null) {
                    p p2 = AdViewControllerImpl.b(this.a);
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Detaching expanded ad: ");
                    stringBuilder.append((Object)AdViewControllerImpl.a(this.a).a());
                    p2.a("AppLovinAdView", stringBuilder.toString());
                    AdViewControllerImpl adViewControllerImpl = this.a;
                    AdViewControllerImpl.a(adViewControllerImpl, AdViewControllerImpl.a(adViewControllerImpl));
                    AdViewControllerImpl.b(this.a, null);
                    AdViewControllerImpl adViewControllerImpl2 = this.a;
                    AdViewControllerImpl.a(adViewControllerImpl2, AdViewControllerImpl.c(adViewControllerImpl2));
                }
            }
        });
    }

    private void d() {
        this.a(new Runnable(this){
            final /* synthetic */ AdViewControllerImpl a;
            {
                this.a = adViewControllerImpl;
            }

            public void run() {
                if (AdViewControllerImpl.o(this.a) != null || AdViewControllerImpl.a(this.a) != null) {
                    com.applovin.impl.sdk.ad.a a2;
                    if (AdViewControllerImpl.o(this.a) != null) {
                        a2 = AdViewControllerImpl.o(this.a).a();
                        AdViewControllerImpl.o(this.a).dismiss();
                        AdViewControllerImpl.a(this.a, null);
                    } else {
                        a2 = AdViewControllerImpl.a(this.a).a();
                        AdViewControllerImpl.a(this.a).dismiss();
                        AdViewControllerImpl.b(this.a, null);
                    }
                    h.b(AdViewControllerImpl.j(this.a), (AppLovinAd)a2, (AppLovinAdView)AdViewControllerImpl.h(this.a), AdViewControllerImpl.g(this.a));
                }
            }
        });
    }

    private void e() {
        com.applovin.impl.sdk.c.d d2 = this.i;
        if (d2 != null) {
            d2.c();
            this.i = null;
        }
    }

    static /* synthetic */ Context f(AdViewControllerImpl adViewControllerImpl) {
        return adViewControllerImpl.a;
    }

    static /* synthetic */ ViewGroup h(AdViewControllerImpl adViewControllerImpl) {
        return adViewControllerImpl.b;
    }

    static /* synthetic */ AppLovinAdViewEventListener j(AdViewControllerImpl adViewControllerImpl) {
        return adViewControllerImpl.B;
    }

    static /* synthetic */ AppLovinAdServiceImpl l(AdViewControllerImpl adViewControllerImpl) {
        return adViewControllerImpl.d;
    }

    static /* synthetic */ void m(AdViewControllerImpl adViewControllerImpl) {
        adViewControllerImpl.d();
    }

    static /* synthetic */ AppLovinAdLoadListener n(AdViewControllerImpl adViewControllerImpl) {
        return adViewControllerImpl.z;
    }

    static /* synthetic */ j o(AdViewControllerImpl adViewControllerImpl) {
        return adViewControllerImpl.t;
    }

    void a() {
        if (this.s == null && this.t == null) {
            p p2 = this.e;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Ad: ");
            stringBuilder.append((Object)this.p);
            stringBuilder.append(" with placement = \"");
            stringBuilder.append(this.h);
            stringBuilder.append("\" closed.");
            p2.a("AppLovinAdView", stringBuilder.toString());
            this.a(this.o);
            h.b(this.A, this.p, this.c);
            this.p = null;
            this.h = null;
            return;
        }
        if (this.c.a(com.applovin.impl.sdk.b.b.cF).booleanValue()) {
            this.contractAd();
        }
    }

    void a(int n2) {
        if (!this.x) {
            this.d.addAdUpdateListener(this.k, this.f);
            this.a(this.o);
        }
        this.a(new Runnable(this, n2){
            final /* synthetic */ int a;
            final /* synthetic */ AdViewControllerImpl b;
            {
                this.b = adViewControllerImpl;
                this.a = n2;
            }

            public void run() {
                try {
                    if (AdViewControllerImpl.n(this.b) != null) {
                        AdViewControllerImpl.n(this.b).failedToReceiveAd(this.a);
                        return;
                    }
                }
                catch (Throwable throwable) {
                    AdViewControllerImpl.b(this.b).c("AppLovinAdView", "Exception while running app load  callback", throwable);
                }
            }
        });
    }

    void a(AppLovinAd appLovinAd) {
        if (appLovinAd != null) {
            this.y = true;
            if (!this.x) {
                this.d.addAdUpdateListener(this.k, this.f);
                this.renderAd(appLovinAd);
            } else {
                this.u.set((Object)appLovinAd);
                this.e.a("AppLovinAdView", "Ad view has paused when an ad was received, ad saved for later");
            }
            this.a(new Runnable(this, appLovinAd){
                final /* synthetic */ AppLovinAd a;
                final /* synthetic */ AdViewControllerImpl b;
                {
                    this.b = adViewControllerImpl;
                    this.a = appLovinAd;
                }

                public void run() {
                    try {
                        if (AdViewControllerImpl.n(this.b) != null) {
                            AdViewControllerImpl.n(this.b).adReceived(this.a);
                            return;
                        }
                    }
                    catch (Throwable throwable) {
                        p p2 = AdViewControllerImpl.b(this.b);
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Exception while running ad load callback: ");
                        stringBuilder.append(throwable.getMessage());
                        p2.e("AppLovinAdView", stringBuilder.toString());
                    }
                }
            });
            return;
        }
        this.e.d("AppLovinAdView", "No provided when to the view controller");
        this.a(-1);
    }

    void a(AppLovinAd appLovinAd, String string, AppLovinAdView appLovinAdView, Uri uri) {
        String string2;
        p p2;
        h.a(this.C, appLovinAd, this.c);
        if (appLovinAdView != null) {
            if (appLovinAd instanceof g) {
                g g2 = (g)appLovinAd;
                if (this.c.a(com.applovin.impl.sdk.b.b.cg).booleanValue() && uri != null) {
                    this.a(g2, appLovinAdView, uri);
                    return;
                }
                this.d.trackAndLaunchClick((AppLovinAd)g2, string, appLovinAdView, this, uri);
                return;
            }
            p2 = this.e;
            string2 = "Unable to process ad click - EmptyAd is not supported.";
        } else {
            p2 = this.e;
            string2 = "Unable to process ad click - AppLovinAdView destroyed prematurely";
        }
        p2.d("AppLovinAdView", string2);
    }

    @Override
    public void contractAd() {
        this.a(new Runnable(this){
            final /* synthetic */ AdViewControllerImpl a;
            {
                this.a = adViewControllerImpl;
            }

            public void run() {
                AdViewControllerImpl.m(this.a);
                if (AdViewControllerImpl.h(this.a) != null && AdViewControllerImpl.e(this.a) != null && AdViewControllerImpl.e(this.a).getParent() == null) {
                    AdViewControllerImpl.h(this.a).addView((View)AdViewControllerImpl.e(this.a));
                    AdViewControllerImpl.a((View)AdViewControllerImpl.e(this.a), AdViewControllerImpl.d(this.a).getSize());
                }
            }
        });
    }

    @Override
    public void destroy() {
        if (this.l != null && this.s != null) {
            this.contractAd();
        }
        this.b();
    }

    public void dismissInterstitialIfRequired() {
        if (this.a instanceof AppLovinInterstitialActivity && this.p instanceof g) {
            boolean bl = ((g)this.p).F() == g.a.b;
            AppLovinInterstitialActivity appLovinInterstitialActivity = (AppLovinInterstitialActivity)this.a;
            if (bl && appLovinInterstitialActivity.getPoststitialWasDisplayed()) {
                appLovinInterstitialActivity.dismiss();
            }
        }
    }

    @Override
    public void expandAd() {
        this.a(new Runnable(this){
            final /* synthetic */ AdViewControllerImpl a;
            {
                this.a = adViewControllerImpl;
            }

            public void run() {
                if (AdViewControllerImpl.a(this.a) != null) {
                    return;
                }
                if (!(AdViewControllerImpl.d(this.a) instanceof com.applovin.impl.sdk.ad.a)) {
                    return;
                }
                if (AdViewControllerImpl.e(this.a) == null) {
                    return;
                }
                com.applovin.impl.sdk.ad.a a2 = (com.applovin.impl.sdk.ad.a)AdViewControllerImpl.d(this.a);
                android.app.Activity activity = AdViewControllerImpl.f(this.a) instanceof android.app.Activity ? (android.app.Activity)AdViewControllerImpl.f(this.a) : m.a((View)AdViewControllerImpl.e(this.a), AdViewControllerImpl.g(this.a));
                android.app.Activity activity2 = activity;
                if (activity2 != null) {
                    if (AdViewControllerImpl.h(this.a) != null) {
                        AdViewControllerImpl.h(this.a).removeView((View)AdViewControllerImpl.e(this.a));
                    }
                    AdViewControllerImpl adViewControllerImpl = this.a;
                    j j2 = new j(a2, AdViewControllerImpl.i(adViewControllerImpl), AdViewControllerImpl.e(this.a), activity2, AdViewControllerImpl.g(this.a));
                    AdViewControllerImpl.b(adViewControllerImpl, j2);
                    AdViewControllerImpl.a(this.a).setOnDismissListener(new android.content.DialogInterface$OnDismissListener(this){
                        final /* synthetic */ 2 a;
                        {
                            this.a = var1_1;
                        }

                        public void onDismiss(android.content.DialogInterface dialogInterface) {
                            this.a.a.contractAd();
                        }
                    });
                    AdViewControllerImpl.a(this.a).show();
                    h.a(AdViewControllerImpl.j(this.a), AdViewControllerImpl.d(this.a), (AppLovinAdView)AdViewControllerImpl.h(this.a), AdViewControllerImpl.g(this.a));
                    if (AdViewControllerImpl.k(this.a) != null) {
                        AdViewControllerImpl.k(this.a).d();
                        return;
                    }
                } else {
                    AdViewControllerImpl.b(this.a).e("AppLovinAdView", "Unable to expand ad. No Activity found.");
                    Uri uri = a2.g();
                    if (uri != null && AdViewControllerImpl.g(this.a).a(com.applovin.impl.sdk.b.b.cM).booleanValue()) {
                        AdViewControllerImpl.l(this.a).trackAndLaunchClick((AppLovinAd)a2, AdViewControllerImpl.i(this.a), this.a.getParentView(), this.a, uri);
                        if (AdViewControllerImpl.k(this.a) != null) {
                            AdViewControllerImpl.k(this.a).b();
                        }
                    }
                    AdViewControllerImpl.e(this.a).a("javascript:al_onFailedExpand();");
                }
            }
        });
    }

    public AppLovinAdViewEventListener getAdViewEventListener() {
        return this.B;
    }

    public com.applovin.impl.adview.c getAdWebView() {
        return this.l;
    }

    public AppLovinAd getCurrentAd() {
        return this.p;
    }

    public AppLovinAdView getParentView() {
        return (AppLovinAdView)this.b;
    }

    public com.applovin.impl.sdk.j getSdk() {
        return this.c;
    }

    @Override
    public AppLovinAdSize getSize() {
        return this.f;
    }

    @Override
    public String getZoneId() {
        return this.g;
    }

    @Override
    public void initializeAdView(AppLovinAdView appLovinAdView, Context context, AppLovinAdSize appLovinAdSize, String string, AppLovinSdk appLovinSdk, AttributeSet attributeSet) {
        if (appLovinAdView != null) {
            if (context == null) {
                Log.e((String)"AppLovinAdView", (String)"Unable to build AppLovinAdView: no context provided. Please use a different constructor for this view.");
                return;
            }
            if (appLovinAdSize == null && (appLovinAdSize = com.applovin.impl.sdk.e.b.a(attributeSet)) == null) {
                appLovinAdSize = AppLovinAdSize.BANNER;
            }
            AppLovinAdSize appLovinAdSize2 = appLovinAdSize;
            if (appLovinSdk == null) {
                appLovinSdk = AppLovinSdk.getInstance(context);
            }
            if (appLovinSdk != null && !appLovinSdk.hasCriticalErrors()) {
                this.a(appLovinAdView, m.a(appLovinSdk), appLovinAdSize2, string, context);
                if (com.applovin.impl.sdk.e.b.b(attributeSet)) {
                    this.loadNextAd();
                }
            }
            return;
        }
        throw new IllegalArgumentException("No parent view specified");
    }

    @Override
    public boolean isAdReadyToDisplay() {
        if (!TextUtils.isEmpty((CharSequence)this.g)) {
            return this.d.hasPreloadedAdForZoneId(this.g);
        }
        return this.d.hasPreloadedAd(this.f);
    }

    @Override
    public boolean isAutoDestroy() {
        return this.w;
    }

    public boolean isForegroundClickInvalidated() {
        return this.D;
    }

    @Override
    public void loadNextAd() {
        if (this.c != null && this.k != null && this.a != null && this.v) {
            this.d.loadNextAd(this.g, this.f, this.k);
            return;
        }
        Log.i((String)"AppLovinAdView", (String)"Unable to load next ad: AppLovinAdView is not initialized.");
    }

    public void onAdHtmlLoaded(WebView webView) {
        if (this.p instanceof g) {
            webView.setVisibility(0);
            try {
                if (this.p != this.q && this.A != null) {
                    this.q = this.p;
                    h.a(this.A, this.p, this.c);
                    return;
                }
            }
            catch (Throwable throwable) {
                this.e.c("AppLovinAdView", "Exception while notifying ad display listener", throwable);
            }
        }
    }

    @Override
    public void onDetachedFromWindow() {
        if (!this.v) {
            return;
        }
        if (this.p != this.m) {
            h.b(this.A, this.p, this.c);
        }
        if (this.l != null && this.s != null) {
            this.e.a("AppLovinAdView", "onDetachedFromWindowCalled with expanded ad present");
            if (this.c.a(com.applovin.impl.sdk.b.b.cE).booleanValue()) {
                this.contractAd();
            } else {
                this.c();
            }
        } else {
            this.e.a("AppLovinAdView", "onDetachedFromWindowCalled without an expanded ad present");
        }
        if (this.w) {
            this.b();
        }
    }

    @Override
    public void onVisibilityChanged(int n2) {
        if (!this.v) {
            return;
        }
        if (this.w) {
            if (n2 != 8 && n2 != 4) {
                if (n2 == 0) {
                    this.resume();
                    return;
                }
            } else {
                this.pause();
            }
        }
    }

    @Override
    public void pause() {
        if (!this.v) {
            return;
        }
        if (this.c.a(com.applovin.impl.sdk.b.b.fl).booleanValue()) {
            this.d.removeAdUpdateListener(this.k, this.getSize());
        }
        AppLovinAd appLovinAd = this.p;
        this.renderAd(this.m, this.h);
        if (appLovinAd != null) {
            this.u.set((Object)appLovinAd);
        }
        this.x = true;
    }

    public void removeClickTrackingOverlay() {
        f f2 = this.r;
        if (f2 != null) {
            ViewParent viewParent = f2.getParent();
            if (viewParent != null && viewParent instanceof ViewGroup) {
                ((ViewGroup)viewParent).removeView((View)this.r);
                this.r = null;
                return;
            }
        } else {
            this.e.a("AppLovinAdView", "Asked to remove an overlay when none existed. Skipping...");
        }
    }

    @Override
    public void renderAd(AppLovinAd appLovinAd) {
        this.renderAd(appLovinAd, null);
    }

    @Override
    public void renderAd(AppLovinAd appLovinAd, String string) {
        if (appLovinAd != null) {
            if (this.v) {
                String string2;
                p p2;
                AppLovinAd appLovinAd2 = m.b(appLovinAd, this.c);
                if (appLovinAd2 != null && appLovinAd2 != this.p) {
                    p p3 = this.e;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Rendering ad #");
                    stringBuilder.append(appLovinAd2.getAdIdNumber());
                    stringBuilder.append(" (");
                    stringBuilder.append((Object)appLovinAd2.getSize());
                    stringBuilder.append(") over placement: ");
                    stringBuilder.append(string);
                    p3.a("AppLovinAdView", stringBuilder.toString());
                    if (!(this.p instanceof i)) {
                        h.b(this.A, this.p, this.c);
                        if (!(appLovinAd2 instanceof i) && appLovinAd2.getSize() != AppLovinAdSize.INTERSTITIAL) {
                            this.e();
                        }
                    }
                    this.u.set(null);
                    this.q = null;
                    this.p = appLovinAd2;
                    this.h = string;
                    if (appLovinAd instanceof g && !this.x && (this.f == AppLovinAdSize.BANNER || this.f == AppLovinAdSize.MREC || this.f == AppLovinAdSize.LEADER)) {
                        this.c.n().trackImpression((g)appLovinAd, string);
                    }
                    if (appLovinAd2.getSize() == this.f) {
                        boolean bl = appLovinAd2 instanceof i;
                        if (!bl && this.s != null) {
                            if (this.c.a(com.applovin.impl.sdk.b.b.cD).booleanValue()) {
                                this.d();
                                this.e.a("AppLovinAdView", "Fade out the old ad scheduled");
                            } else {
                                this.c();
                            }
                        }
                        if (bl && (this.s != null || this.t != null)) {
                            this.e.a("AppLovinAdView", "Ignoring empty ad render with expanded ad");
                            return;
                        }
                        this.a(this.n);
                        return;
                    }
                    p p4 = this.e;
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("Unable to render ad: ad size ");
                    stringBuilder2.append((Object)appLovinAd2.getSize());
                    stringBuilder2.append(" does not match AdViewController size ");
                    stringBuilder2.append((Object)this.f);
                    stringBuilder2.append(".");
                    p4.d("AppLovinAdView", stringBuilder2.toString());
                    return;
                }
                if (appLovinAd2 == null) {
                    p2 = this.e;
                    string2 = "Unable to render ad. Ad is null. Internal inconsistency error.";
                } else {
                    p2 = this.e;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Ad #");
                    stringBuilder.append(appLovinAd2.getAdIdNumber());
                    stringBuilder.append(" is already showing, ignoring");
                    string2 = stringBuilder.toString();
                }
                p2.c("AppLovinAdView", string2);
                return;
            }
            Log.i((String)"AppLovinAdView", (String)"Unable to render ad: AppLovinAdView is not initialized.");
            return;
        }
        throw new IllegalArgumentException("No ad specified");
    }

    @Override
    public void resume() {
        AppLovinAd appLovinAd;
        if (!this.v) {
            return;
        }
        if (this.y && this.c.a(com.applovin.impl.sdk.b.b.fl).booleanValue()) {
            this.d.addAdUpdateListener(this.k, this.f);
        }
        if ((appLovinAd = (AppLovinAd)this.u.getAndSet(null)) != null) {
            this.renderAd(appLovinAd, this.h);
        }
        this.x = false;
    }

    @Override
    public void setAdClickListener(AppLovinAdClickListener appLovinAdClickListener) {
        this.C = appLovinAdClickListener;
    }

    @Override
    public void setAdDisplayListener(AppLovinAdDisplayListener appLovinAdDisplayListener) {
        this.A = appLovinAdDisplayListener;
    }

    @Override
    public void setAdLoadListener(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.z = appLovinAdLoadListener;
    }

    @Override
    public void setAdVideoPlaybackListener(AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
    }

    @Override
    public void setAdViewEventListener(AppLovinAdViewEventListener appLovinAdViewEventListener) {
        this.B = appLovinAdViewEventListener;
    }

    @Override
    public void setAutoDestroy(boolean bl) {
        this.w = bl;
    }

    public void setIsForegroundClickInvalidated(boolean bl) {
        this.D = bl;
    }

    public void setStatsManagerHelper(com.applovin.impl.sdk.c.d d2) {
        com.applovin.impl.adview.c c2 = this.l;
        if (c2 != null) {
            c2.a(d2);
        }
    }

    static class d
    implements AppLovinAdLoadListener,
    AppLovinAdUpdateListener {
        private final AppLovinAdService a;
        private final p b;
        private final AdViewControllerImpl c;

        d(AdViewControllerImpl adViewControllerImpl, com.applovin.impl.sdk.j j2) {
            if (adViewControllerImpl != null) {
                if (j2 != null) {
                    this.b = j2.u();
                    this.a = j2.n();
                    this.c = adViewControllerImpl;
                    return;
                }
                throw new IllegalArgumentException("No sdk specified");
            }
            throw new IllegalArgumentException("No view specified");
        }

        private AdViewControllerImpl a() {
            return this.c;
        }

        @Override
        public void adReceived(AppLovinAd appLovinAd) {
            AdViewControllerImpl adViewControllerImpl = this.a();
            if (adViewControllerImpl != null) {
                adViewControllerImpl.a(appLovinAd);
                return;
            }
            this.b.e("AppLovinAdView", "Ad view has been garbage collected by the time an ad was received");
        }

        @Override
        public void adUpdated(AppLovinAd appLovinAd) {
            AdViewControllerImpl adViewControllerImpl = this.a();
            if (adViewControllerImpl != null) {
                adViewControllerImpl.a(appLovinAd);
                return;
            }
            this.a.removeAdUpdateListener(this, appLovinAd.getSize());
            this.b.e("AppLovinAdView", "Ad view has been garbage collected by the time an ad was updated");
        }

        @Override
        public void failedToReceiveAd(int n2) {
            AdViewControllerImpl adViewControllerImpl = this.a();
            if (adViewControllerImpl != null) {
                adViewControllerImpl.a(n2);
            }
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[AdViewController listener: ");
            stringBuilder.append(this.hashCode());
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

}

