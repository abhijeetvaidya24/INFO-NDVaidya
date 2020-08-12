/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.StrictMode
 *  android.os.StrictMode$ThreadPolicy
 *  com.applovin.adview.AppLovinInterstitialActivity
 *  com.applovin.impl.a.a
 *  com.applovin.impl.sdk.ad.a
 *  com.applovin.impl.sdk.ad.g
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.ref.WeakReference
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.UUID
 */
package com.applovin.impl.adview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
import com.applovin.adview.AppLovinInterstitialActivity;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.impl.a.a;
import com.applovin.impl.a.k;
import com.applovin.impl.adview.i;
import com.applovin.impl.adview.l;
import com.applovin.impl.sdk.AppLovinAdServiceImpl;
import com.applovin.impl.sdk.ad.g;
import com.applovin.impl.sdk.b.b;
import com.applovin.impl.sdk.c;
import com.applovin.impl.sdk.c.h;
import com.applovin.impl.sdk.e.e;
import com.applovin.impl.sdk.e.m;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.p;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

class l
implements AppLovinInterstitialAdDialog {
    public static volatile boolean b;
    public static volatile boolean c;
    private static final Map<String, l> d;
    private static volatile boolean p;
    protected final j a;
    private final String e;
    private final c f;
    private final WeakReference<Context> g;
    private volatile AppLovinAdLoadListener h;
    private volatile AppLovinAdDisplayListener i;
    private volatile AppLovinAdVideoPlaybackListener j;
    private volatile AppLovinAdClickListener k;
    private volatile g l;
    private volatile g.b m;
    private volatile i n;
    private volatile String o;

    static {
        d = Collections.synchronizedMap((Map)new HashMap());
        b = false;
        c = false;
    }

    l(AppLovinSdk appLovinSdk, Context context) {
        if (appLovinSdk != null) {
            if (context != null) {
                this.a = m.a(appLovinSdk);
                this.e = UUID.randomUUID().toString();
                this.f = new c();
                this.g = new WeakReference((Object)context);
                b = true;
                c = false;
                return;
            }
            throw new IllegalArgumentException("No context specified");
        }
        throw new IllegalArgumentException("No sdk specified");
    }

    public static l a(String string) {
        return (l)d.get((Object)string);
    }

    static /* synthetic */ AppLovinAdLoadListener a(l l2) {
        return l2.h;
    }

    private void a(int n2) {
        AppLovinSdkUtils.runOnUiThread(new Runnable(this, n2){
            final /* synthetic */ int a;
            final /* synthetic */ l b;
            {
                this.b = l2;
                this.a = n2;
            }

            public void run() {
                if (l.a(this.b) != null) {
                    l.a(this.b).failedToReceiveAd(this.a);
                }
            }
        });
    }

    private void a(Context context) {
        Intent intent = new Intent(context, AppLovinInterstitialActivity.class);
        intent.putExtra("com.applovin.interstitial.wrapper_id", this.e);
        AppLovinInterstitialActivity.lastKnownWrapper = this;
        StrictMode.ThreadPolicy threadPolicy = StrictMode.allowThreadDiskReads();
        if (context instanceof Activity) {
            try {
                context.startActivity(intent);
                ((Activity)context).overridePendingTransition(0, 0);
            }
            catch (Throwable throwable) {
                this.a.u().b("InterstitialAdDialogWrapper", "Unable to remove pending transition animations", throwable);
            }
        } else {
            intent.setFlags(268435456);
            context.startActivity(intent);
        }
        StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)threadPolicy);
        this.a(true);
    }

    static /* synthetic */ void a(l l2, Context context) {
        l2.a(context);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private void a(g var1_1, String var2_2, Context var3_3) {
        block6 : {
            block7 : {
                block8 : {
                    l.d.put((Object)this.e, (Object)this);
                    this.l = var1_1;
                    this.o = var2_2;
                    var5_4 = this.l != null ? this.l.m() : g.b.a;
                    this.m = var5_4;
                    if (m.a(var1_1, var3_3, this.a)) break block6;
                    this.a.D().a(com.applovin.impl.sdk.c.g.o);
                    if (!(this.l instanceof a)) break block7;
                    var25_5 = ((a)this.l).c();
                    if (var25_5 == null) break block8;
                    var26_6 = this.a.u();
                    var27_7 = new StringBuilder();
                    var27_7.append("Cached video removed from local filesystem for VAST ad. Setting videoUri to source: ");
                    var27_7.append((Object)var25_5.a());
                    var26_6.d("InterstitialAdDialogWrapper", var27_7.toString());
                    var25_5.a(var25_5.a());
                    break block6;
                }
                this.a.u().d("InterstitialAdDialogWrapper", "Cached video removed from local filesystem for VAST ad and source uri not found. Failing ad show.");
                ** GOTO lbl37
            }
            if (!(this.l instanceof com.applovin.impl.sdk.ad.a)) break block6;
            var15_8 = (com.applovin.impl.sdk.ad.a)this.l;
            if (var15_8.ag() && var15_8.d()) {
                var21_9 = this.a.u();
                var22_10 = new StringBuilder();
                var22_10.append("Cached video removed from local filesystem for ad server ad. Restored video uri to video stream url: ");
                var22_10.append((Object)var15_8.e());
                var21_9.d("InterstitialAdDialogWrapper", var22_10.toString());
            } else {
                var16_11 = this.a.u();
                var17_12 = new StringBuilder();
                var17_12.append("Cached video removed from local filesystem for ad server ad: ");
                var17_12.append(var15_8.getAdIdNumber());
                var17_12.append(" and could not restore video stream url. Failing ad show.");
                var16_11.d("InterstitialAdDialogWrapper", var17_12.toString());
lbl37: // 2 sources:
                this.a((AppLovinAd)var1_1);
                return;
            }
        }
        if (e.a(AppLovinInterstitialActivity.class, var3_3)) {
            var6_13 = Math.max((long)0L, (long)this.a.a(b.dh));
            var8_14 = this.a.u();
            var9_15 = new StringBuilder();
            var9_15.append("Presenting ad with delay of ");
            var9_15.append(var6_13);
            var8_14.a("InterstitialAdDialogWrapper", var9_15.toString());
            new Handler(var3_3.getMainLooper()).postDelayed(new Runnable(this, var3_3){
                final /* synthetic */ Context a;
                final /* synthetic */ l b;
                {
                    this.b = l2;
                    this.a = context;
                }

                public void run() {
                    l.a(this.b, this.a);
                }
            }, var6_13);
            return;
        }
        this.a.u().e("AppLovinInterstitialAdDialog", "Unable to show ad. Please make sure you have AppLovinInterstitialActivity declared in your Android Manifest: <activity android:name=\"com.applovin.adview.AppLovinInterstitialActivity\" android:configChanges=\"orientation|screenSize\"/>");
        this.a((AppLovinAd)var1_1);
    }

    private void a(AppLovinAd appLovinAd) {
        if (this.i != null) {
            this.i.adHidden(appLovinAd);
        }
        p = false;
    }

    static /* synthetic */ i b(l l2) {
        return l2.n;
    }

    private void b(AppLovinAd appLovinAd) {
        AppLovinSdkUtils.runOnUiThread(new Runnable(this, appLovinAd){
            final /* synthetic */ AppLovinAd a;
            final /* synthetic */ l b;
            {
                this.b = l2;
                this.a = appLovinAd;
            }

            public void run() {
                if (l.a(this.b) != null) {
                    l.a(this.b).adReceived(this.a);
                }
            }
        });
    }

    private Context i() {
        WeakReference<Context> weakReference = this.g;
        if (weakReference != null) {
            return (Context)weakReference.get();
        }
        return null;
    }

    public j a() {
        return this.a;
    }

    public void a(i i2) {
        this.n = i2;
    }

    protected void a(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.a.n().loadNextAd(AppLovinAdSize.INTERSTITIAL, appLovinAdLoadListener);
    }

    public void a(boolean bl) {
        p = bl;
    }

    public AppLovinAd b() {
        return this.l;
    }

    public AppLovinAdVideoPlaybackListener c() {
        return this.j;
    }

    public AppLovinAdDisplayListener d() {
        return this.i;
    }

    @Override
    public void dismiss() {
        AppLovinSdkUtils.runOnUiThread(new Runnable(this){
            final /* synthetic */ l a;
            {
                this.a = l2;
            }

            public void run() {
                if (!this.a.a.a(b.fh).booleanValue() || l.b(this.a) != null) {
                    l.b(this.a).dismiss();
                }
            }
        });
    }

    public AppLovinAdClickListener e() {
        return this.k;
    }

    public g.b f() {
        return this.m;
    }

    public String g() {
        return this.o;
    }

    public void h() {
        b = false;
        c = true;
        d.remove((Object)this.e);
        if (this.l != null && this.l.P()) {
            this.n = null;
        }
    }

    @Override
    public boolean isAdReadyToDisplay() {
        return this.a.n().hasPreloadedAd(AppLovinAdSize.INTERSTITIAL);
    }

    @Override
    public boolean isShowing() {
        return p;
    }

    @Override
    public void setAdClickListener(AppLovinAdClickListener appLovinAdClickListener) {
        this.k = appLovinAdClickListener;
        this.f.a(appLovinAdClickListener);
    }

    @Override
    public void setAdDisplayListener(AppLovinAdDisplayListener appLovinAdDisplayListener) {
        this.i = appLovinAdDisplayListener;
        this.f.a(appLovinAdDisplayListener);
    }

    @Override
    public void setAdLoadListener(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.h = appLovinAdLoadListener;
    }

    @Override
    public void setAdVideoPlaybackListener(AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        this.j = appLovinAdVideoPlaybackListener;
    }

    @Override
    public void show() {
        this.show(null);
    }

    @Override
    public void show(final String string) {
        this.a(new AppLovinAdLoadListener(){

            @Override
            public void adReceived(AppLovinAd appLovinAd) {
                l.this.b(appLovinAd);
                l.this.showAndRender(appLovinAd, string);
            }

            @Override
            public void failedToReceiveAd(int n2) {
                l.this.a(n2);
            }
        });
    }

    @Override
    public void showAndRender(AppLovinAd appLovinAd) {
        this.showAndRender(appLovinAd, null);
    }

    @Override
    public void showAndRender(AppLovinAd appLovinAd, String string) {
        String string2;
        p p2;
        if (this.isShowing() && !this.a.a(b.fg).booleanValue()) {
            this.a.u().e("AppLovinInterstitialAdDialog", "Attempted to show an interstitial while one is already displayed; ignoring.");
            return;
        }
        if (!m.a(appLovinAd, this.a)) {
            this.a(appLovinAd);
            return;
        }
        Context context = this.i();
        if (context != null) {
            AppLovinAd appLovinAd2 = m.b(appLovinAd, this.a);
            if (appLovinAd2 != null) {
                if (appLovinAd2 instanceof g) {
                    this.a((g)appLovinAd2, string, context);
                    return;
                }
                p p3 = this.a.u();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Failed to show interstitial: unknown ad type provided: '");
                stringBuilder.append((Object)appLovinAd2);
                stringBuilder.append("'");
                p3.d("InterstitialAdDialogWrapper", stringBuilder.toString());
                this.a(appLovinAd2);
                return;
            }
            p2 = this.a.u();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to show ad: ");
            stringBuilder.append((Object)appLovinAd);
            string2 = stringBuilder.toString();
        } else {
            p2 = this.a.u();
            string2 = "Failed to show interstitial: stale activity reference provided";
        }
        p2.d("InterstitialAdDialogWrapper", string2);
        this.a(appLovinAd);
    }

}

