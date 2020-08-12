/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.os.Bundle
 *  java.io.Serializable
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Deprecated
 *  java.lang.Enum
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.startapp.android.publish.adsCommon;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.startapp.android.publish.ads.splash.SplashConfig;
import com.startapp.android.publish.ads.splash.SplashHideListener;
import com.startapp.android.publish.adsCommon.Ad;
import com.startapp.android.publish.adsCommon.AutoInterstitialPreferences;
import com.startapp.android.publish.adsCommon.StartAppAd;
import com.startapp.android.publish.adsCommon.StartAppSDK;
import com.startapp.android.publish.adsCommon.Utils.i;
import com.startapp.android.publish.adsCommon.VideoListener;
import com.startapp.android.publish.adsCommon.a.a;
import com.startapp.android.publish.adsCommon.activities.AppWallActivity;
import com.startapp.android.publish.adsCommon.activities.OverlayActivity;
import com.startapp.android.publish.adsCommon.adListeners.AdDisplayListener;
import com.startapp.android.publish.adsCommon.adListeners.AdEventListener;
import com.startapp.android.publish.adsCommon.b;
import com.startapp.android.publish.adsCommon.c;
import com.startapp.android.publish.adsCommon.e;
import com.startapp.android.publish.adsCommon.f;
import com.startapp.android.publish.adsCommon.f.d;
import com.startapp.android.publish.adsCommon.g;
import com.startapp.android.publish.adsCommon.k;
import com.startapp.android.publish.adsCommon.m;
import com.startapp.android.publish.adsCommon.n;
import com.startapp.android.publish.common.metaData.MetaData;
import com.startapp.android.publish.common.model.AdPreferences;
import com.startapp.common.Constants;
import java.io.Serializable;

public class StartAppAd
extends Ad {
    private static final String TAG = "StartAppAd";
    private static final long serialVersionUID = 1L;
    private static boolean testMode;
    g ad = null;
    private com.startapp.android.publish.cache.c adKey = null;
    private AdMode adMode = AdMode.AUTOMATIC;
    private AdPreferences adPreferences = null;
    AdDisplayListener callback = null;
    private BroadcastReceiver callbackBroadcastReceiver = new BroadcastReceiver(this){
        final /* synthetic */ StartAppAd a;
        {
            this.a = startAppAd;
        }

        private void a(Context context) {
            com.startapp.common.b.a(context).a(this);
        }

        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals((Object)"com.startapp.android.ShowFailedDisplayBroadcastListener")) {
                if (intent.getExtras().containsKey("showFailedReason")) {
                    this.a.setNotDisplayedReason((AdDisplayListener.NotDisplayedReason)intent.getExtras().getSerializable("showFailedReason"));
                }
                if (this.a.callback != null) {
                    this.a.callback.adNotDisplayed(this.a);
                }
                this.a(context);
            } else if (intent.getAction().equals((Object)"com.startapp.android.ShowDisplayBroadcastListener")) {
                if (this.a.callback != null) {
                    this.a.callback.adDisplayed(this.a);
                }
            } else if (intent.getAction().equals((Object)"com.startapp.android.OnClickCallback")) {
                if (this.a.callback != null) {
                    this.a.callback.adClicked(this.a);
                }
            } else if (intent.getAction().equals((Object)"com.startapp.android.OnVideoCompleted")) {
                if (this.a.videoListener != null) {
                    new android.os.Handler(android.os.Looper.getMainLooper()).post(new java.lang.Runnable(this){
                        final /* synthetic */ 1 a;
                        {
                            this.a = var1_1;
                        }

                        public void run() {
                            this.a.a.videoListener.onVideoCompleted();
                        }
                    });
                }
            } else {
                if (this.a.callback != null) {
                    this.a.callback.adHidden(this.a);
                }
                this.a(context);
            }
            this.a.ad = null;
        }
    };
    VideoListener videoListener = null;

    public StartAppAd(Context context) {
        super(context, null);
    }

    public static void disableAutoInterstitial() {
        f.a().c();
    }

    public static void disableSplash() {
        m.a().j();
    }

    public static void enableAutoInterstitial() {
        f.a().b();
    }

    public static void init(Context context, String string, String string2) {
        StartAppSDK.init(context, string, string2);
    }

    /*
     * Exception decompiling
     */
    private boolean isAppOnForeground() {
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

    public static void onBackPressed(Context context) {
        new StartAppAd(context).onBackPressed();
    }

    private void registerBroadcastReceiver(String string) {
        com.startapp.common.b.a(this.context).a(this.callbackBroadcastReceiver, new IntentFilter(string));
    }

    private void setAdMode(AdMode adMode) {
        this.adMode = adMode;
    }

    private void setAdPrefs(AdPreferences adPreferences) {
        this.adPreferences = adPreferences;
    }

    public static void setAutoInterstitialPreferences(AutoInterstitialPreferences autoInterstitialPreferences) {
        f.a().a(autoInterstitialPreferences);
    }

    public static boolean showAd(Context context) {
        try {
            boolean bl = new StartAppAd(context).showAd();
            return bl;
        }
        catch (Exception exception) {
            com.startapp.android.publish.adsCommon.f.f.a(context, d.b, "StartAppAd.showAd(one line integration) - unexpected Error occurd", exception.getMessage(), "");
            return false;
        }
    }

    private boolean showPreparedVideoFallbackAd(String string) {
        if (this.canShowAd()) {
            if (!b.a().H().h()) {
                return false;
            }
            AdPreferences adPreferences = this.adPreferences;
            if (adPreferences == null) {
                adPreferences = new AdPreferences();
            }
            adPreferences.setType(Ad.AdType.NON_VIDEO);
            AdPreferences.Placement placement = this.getPlacement();
            g g2 = com.startapp.android.publish.cache.a.a().b(new com.startapp.android.publish.cache.c(placement, adPreferences));
            if (g2 != null && g2.isReady() && this.shouldDisplayAd(string, placement).a()) {
                g2.setVideoCancelCallBack(true);
                if (Constants.a().booleanValue()) {
                    com.startapp.common.a.i.a().a(this.context, "display Video fallback");
                }
                return g2.a(string);
            }
        }
        return false;
    }

    public static void showSplash(Activity activity, Bundle bundle) {
        StartAppAd.showSplash(activity, bundle, new SplashConfig());
    }

    public static void showSplash(Activity activity, Bundle bundle, SplashConfig splashConfig) {
        StartAppAd.showSplash(activity, bundle, splashConfig, new AdPreferences());
    }

    public static void showSplash(Activity activity, Bundle bundle, SplashConfig splashConfig, AdPreferences adPreferences) {
        StartAppAd.showSplash(activity, bundle, splashConfig, adPreferences, null);
    }

    public static void showSplash(Activity activity, Bundle bundle, SplashConfig splashConfig, AdPreferences adPreferences, SplashHideListener splashHideListener) {
        StartAppAd.showSplash(activity, bundle, splashConfig, adPreferences, splashHideListener, true);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static void showSplash(Activity activity, Bundle bundle, SplashConfig splashConfig, AdPreferences adPreferences, SplashHideListener splashHideListener, boolean bl) {
        block6 : {
            if (bundle == null && MetaData.getInstance().canShowAd()) {
                try {
                    m m2 = m.a();
                    if (!m2.k() && bl) {
                        m2.d(true);
                    }
                    m2.c(bl);
                    if (!bl) {
                        if (adPreferences == null) {
                            adPreferences = new AdPreferences();
                        }
                        adPreferences.setAs(true);
                    }
                    splashConfig.setDefaults((Context)activity);
                    i.a(activity, true);
                    Intent intent = new Intent((Context)activity, i.a((Context)activity, OverlayActivity.class, AppWallActivity.class));
                    intent.putExtra("SplashConfig", (Serializable)splashConfig);
                    intent.putExtra("AdPreference", (Serializable)adPreferences);
                    intent.putExtra("testMode", testMode);
                    intent.putExtra("fullscreen", c.a(activity));
                    intent.putExtra("placement", AdPreferences.Placement.INAPP_SPLASH.getIndex());
                    intent.addFlags(1140883456);
                    activity.startActivity(intent);
                    BroadcastReceiver broadcastReceiver = new BroadcastReceiver(activity, splashHideListener){
                        final /* synthetic */ Activity a;
                        final /* synthetic */ SplashHideListener b;
                        {
                            this.a = activity;
                            this.b = splashHideListener;
                        }

                        public void onReceive(Context context, Intent intent) {
                            i.a(this.a, false);
                            SplashHideListener splashHideListener = this.b;
                            if (splashHideListener != null) {
                                splashHideListener.splashHidden();
                            }
                            com.startapp.common.b.a((Context)this.a).a(this);
                        }
                    };
                    com.startapp.common.b.a((Context)activity).a(broadcastReceiver, new IntentFilter("com.startapp.android.splashHidden"));
                    return;
                }
                catch (Exception exception) {
                    if (splashHideListener == null) break block6;
                    splashHideListener.splashHidden();
                    com.startapp.android.publish.adsCommon.f.f.a((Context)activity, d.b, "StartAppAd.showSplash - unexpected Error occurd", exception.getMessage(), "");
                }
            }
        }
    }

    public static void showSplash(Activity activity, Bundle bundle, AdPreferences adPreferences) {
        StartAppAd.showSplash(activity, bundle, new SplashConfig(), adPreferences);
    }

    public void close() {
        if (this.callbackBroadcastReceiver != null) {
            com.startapp.common.b.a(this.context).a(this.callbackBroadcastReceiver);
        }
        Intent intent = new Intent("com.startapp.android.CloseAdActivity");
        com.startapp.common.b.a(this.context).a(intent);
    }

    protected String getAdHtml() {
        g g2 = com.startapp.android.publish.cache.a.a().b(this.adKey);
        if (g2 != null && g2 instanceof e) {
            return ((e)((Object)g2)).f();
        }
        return null;
    }

    protected String getLauncherName() {
        g g2 = com.startapp.android.publish.cache.a.a().b(this.adKey);
        if (g2 != null) {
            return g2.a_();
        }
        return i.c(this.getContext());
    }

    @Override
    protected AdPreferences.Placement getPlacement() {
        AdPreferences.Placement placement = super.getPlacement();
        if (placement == null && this.adKey != null && com.startapp.android.publish.cache.a.a().b(this.adKey) != null) {
            placement = ((Ad)((Object)com.startapp.android.publish.cache.a.a().b(this.adKey))).getPlacement();
        }
        return placement;
    }

    @Override
    public Ad.AdState getState() {
        g g2 = com.startapp.android.publish.cache.a.a().b(this.adKey);
        if (g2 != null) {
            return g2.getState();
        }
        return Ad.AdState.UN_INITIALIZED;
    }

    @Override
    public boolean isBelowMinCPM() {
        g g2 = com.startapp.android.publish.cache.a.a().b(this.adKey);
        if (g2 != null) {
            return g2.isBelowMinCPM();
        }
        return false;
    }

    public boolean isNetworkAvailable() {
        return i.a(this.context);
    }

    @Override
    public boolean isReady() {
        g g2 = com.startapp.android.publish.cache.a.a().b(this.adKey);
        if (g2 != null) {
            return g2.isReady();
        }
        return false;
    }

    @Deprecated
    @Override
    public boolean load(AdPreferences adPreferences, AdEventListener adEventListener) {
        if (!this.canShowAd()) {
            if (adEventListener != null) {
                this.setErrorMessage("serving ads disabled");
                adEventListener.onFailedToReceiveAd(this);
            }
            return false;
        }
        com.startapp.android.publish.cache.c c2 = this.adKey = com.startapp.android.publish.cache.a.a().a(this.context, this, this.adMode, adPreferences, adEventListener);
        boolean bl = false;
        if (c2 != null) {
            bl = true;
        }
        return bl;
    }

    public void loadAd() {
        this.loadAd(AdMode.AUTOMATIC, new AdPreferences(), null);
    }

    public void loadAd(AdMode adMode) {
        this.loadAd(adMode, new AdPreferences(), null);
    }

    public void loadAd(AdMode adMode, AdEventListener adEventListener) {
        this.loadAd(adMode, new AdPreferences(), adEventListener);
    }

    public void loadAd(AdMode adMode, AdPreferences adPreferences) {
        this.loadAd(adMode, adPreferences, null);
    }

    public void loadAd(AdMode adMode, AdPreferences adPreferences, AdEventListener adEventListener) {
        this.setAdMode(adMode);
        this.setAdPrefs(adPreferences);
        try {
            this.load(adPreferences, adEventListener);
            return;
        }
        catch (Exception exception) {
            com.startapp.android.publish.adsCommon.f.f.a(this.context, d.b, "StartAppAd.loadAd - unexpected Error occurd", exception.getMessage(), "");
            if (adEventListener != null) {
                adEventListener.onFailedToReceiveAd(this);
            }
            return;
        }
    }

    public void loadAd(AdEventListener adEventListener) {
        this.loadAd(AdMode.AUTOMATIC, new AdPreferences(), adEventListener);
    }

    public void loadAd(AdPreferences adPreferences) {
        this.loadAd(AdMode.AUTOMATIC, adPreferences, null);
    }

    public void loadAd(AdPreferences adPreferences, AdEventListener adEventListener) {
        this.loadAd(AdMode.AUTOMATIC, adPreferences, adEventListener);
    }

    @Override
    protected void loadAds(AdPreferences adPreferences, AdEventListener adEventListener) {
    }

    public com.startapp.android.publish.cache.c loadSplash(AdPreferences adPreferences, AdEventListener adEventListener) {
        this.adKey = com.startapp.android.publish.cache.a.a().a(this.context, this, adPreferences, adEventListener);
        return this.adKey;
    }

    public void onBackPressed() {
        if (!this.showAd("exit_ad")) {
            com.startapp.common.a.g.a(TAG, 3, "Could not display StartAppAd onBackPressed");
        }
        m.a().m();
    }

    public void onPause() {
    }

    public void onRestoreInstanceState(Bundle bundle) {
        int n2 = bundle.getInt("AdMode");
        this.adMode = AdMode.AUTOMATIC;
        if (n2 == 1) {
            this.adMode = AdMode.FULLPAGE;
        } else if (n2 == 2) {
            this.adMode = AdMode.OFFERWALL;
        } else if (n2 == 3) {
            this.adMode = AdMode.OVERLAY;
        } else if (n2 == 4) {
            this.adMode = AdMode.REWARDED_VIDEO;
        } else if (n2 == 5) {
            this.adMode = AdMode.VIDEO;
        }
        Serializable serializable = bundle.getSerializable("AdPrefs");
        if (serializable != null) {
            this.adPreferences = (AdPreferences)serializable;
        }
    }

    public void onResume() {
        if (!this.isReady()) {
            this.loadAd();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        AdPreferences adPreferences;
        int n2 = 3.a[this.adMode.ordinal()];
        int n3 = 4;
        if (n2 != 1) {
            if (n2 != 2) {
                if (n2 != 3) {
                    if (n2 != n3) {
                        n3 = 0;
                    }
                } else {
                    n3 = 3;
                }
            } else {
                n3 = 2;
            }
        } else {
            n3 = 1;
        }
        if ((adPreferences = this.adPreferences) != null) {
            bundle.putSerializable("AdPrefs", (Serializable)adPreferences);
        }
        bundle.putInt("AdMode", n3);
    }

    public void setVideoListener(VideoListener videoListener) {
        this.videoListener = videoListener;
    }

    protected com.startapp.android.publish.adsCommon.a.f shouldDisplayAd(String string, AdPreferences.Placement placement) {
        return b.a().F().a(placement, string);
    }

    @Deprecated
    @Override
    public boolean show() {
        return this.show(null, null);
    }

    @Deprecated
    public boolean show(String string, AdDisplayListener adDisplayListener) {
        boolean bl;
        boolean bl2;
        com.startapp.android.publish.adsCommon.a.f f2;
        block31 : {
            block30 : {
                block32 : {
                    block23 : {
                        block24 : {
                            block25 : {
                                boolean bl3;
                                block29 : {
                                    block27 : {
                                        block26 : {
                                            AdPreferences.Placement placement;
                                            Integer n2;
                                            block28 : {
                                                this.setNotDisplayedReason(null);
                                                this.callback = new com.startapp.android.publish.adsCommon.adListeners.a(adDisplayListener);
                                                boolean bl4 = this.canShowAd();
                                                bl2 = false;
                                                n2 = 0;
                                                if (!bl4) {
                                                    this.setNotDisplayedReason(AdDisplayListener.NotDisplayedReason.SERVING_ADS_DISABLED);
                                                    this.callback.adNotDisplayed(this);
                                                    return false;
                                                }
                                                if (this.adKey == null) {
                                                    this.loadAd();
                                                }
                                                if (!this.isAppOnForeground()) break block23;
                                                if (!this.isNetworkAvailable()) break block24;
                                                boolean bl5 = this.isReady();
                                                bl = true;
                                                if (!bl5) break block25;
                                                placement = this.getPlacement();
                                                f2 = this.shouldDisplayAd(string, placement);
                                                if (!f2.a()) break block26;
                                                this.ad = com.startapp.android.publish.cache.a.a().a(this.adKey);
                                                if (this.ad == null) break block27;
                                                if (this.placement != AdPreferences.Placement.INAPP_SPLASH || !m.a().n()) break block28;
                                                com.startapp.common.a.g.a(TAG, 3, "App in background, can't display splash");
                                                this.setNotDisplayedReason(AdDisplayListener.NotDisplayedReason.APP_IN_BACKGROUND);
                                                break block27;
                                            }
                                            bl3 = this.ad.a(string);
                                            if (bl3) {
                                                AdPreferences adPreferences;
                                                com.startapp.android.publish.adsCommon.a.b.a().a(new a(placement, string));
                                                if (this.adMode == null || this.placement == AdPreferences.Placement.INAPP_SPLASH || (adPreferences = this.adPreferences) != null && !adPreferences.equals(new AdPreferences())) {
                                                    bl = false;
                                                }
                                                if (bl) {
                                                    com.startapp.android.publish.cache.a a2 = com.startapp.android.publish.cache.a.a();
                                                    String string2 = a2.a(this.adMode);
                                                    StringBuilder stringBuilder = new StringBuilder();
                                                    stringBuilder.append("reset autoLoad after show ");
                                                    stringBuilder.append(string2);
                                                    com.startapp.common.a.g.a("preCache", 3, stringBuilder.toString());
                                                    k.b(this.context, string2, n2);
                                                    if (this.adMode == AdMode.AUTOMATIC) {
                                                        k.b(this.context, a2.a(AdMode.FULLPAGE), n2);
                                                        k.b(this.context, a2.a(AdMode.OFFERWALL), n2);
                                                    }
                                                }
                                            } else {
                                                g g2 = this.ad;
                                                if (g2 instanceof Ad) {
                                                    this.setNotDisplayedReason(((Ad)((Object)g2)).getNotDisplayedReason());
                                                }
                                            }
                                            this.loadAd(this.adMode, this.adPreferences, null);
                                            break block29;
                                        }
                                        this.setNotDisplayedReason(AdDisplayListener.NotDisplayedReason.AD_RULES);
                                        if (Constants.a().booleanValue()) {
                                            com.startapp.common.a.i.a().a(this.context, f2.b());
                                        }
                                    }
                                    bl3 = false;
                                }
                                bl2 = bl3;
                                break block30;
                            }
                            if (this.adMode == AdMode.REWARDED_VIDEO || this.adMode == AdMode.VIDEO || !this.showPreparedVideoFallbackAd(string)) {
                                bl = false;
                            }
                            if (!bl) {
                                this.setNotDisplayedReason(AdDisplayListener.NotDisplayedReason.AD_NOT_READY);
                            }
                            bl2 = false;
                            f2 = null;
                            break block31;
                        }
                        this.setNotDisplayedReason(AdDisplayListener.NotDisplayedReason.NETWORK_PROBLEM);
                        break block32;
                    }
                    this.setNotDisplayedReason(AdDisplayListener.NotDisplayedReason.APP_IN_BACKGROUND);
                }
                f2 = null;
            }
            bl = false;
        }
        if (bl2 || bl) {
            this.registerBroadcastReceiver("com.startapp.android.HideDisplayBroadcastListener");
            this.registerBroadcastReceiver("com.startapp.android.ShowDisplayBroadcastListener");
            this.registerBroadcastReceiver("com.startapp.android.ShowFailedDisplayBroadcastListener");
            this.registerBroadcastReceiver("com.startapp.android.OnClickCallback");
            this.registerBroadcastReceiver("com.startapp.android.OnVideoCompleted");
        }
        if (!bl2) {
            AdDisplayListener adDisplayListener2;
            if (this.getNotDisplayedReason() == null) {
                this.setNotDisplayedReason(AdDisplayListener.NotDisplayedReason.INTERNAL_ERROR);
            }
            if (this.getNotDisplayedReason() != AdDisplayListener.NotDisplayedReason.NETWORK_PROBLEM) {
                if (this.getNotDisplayedReason() != AdDisplayListener.NotDisplayedReason.AD_RULES) {
                    if (bl) {
                        Context context = this.context;
                        g g3 = this.ad;
                        if (g3 == null) {
                            g3 = com.startapp.android.publish.cache.a.a().b(this.adKey);
                        }
                        c.a(context, c.a(g3), string, AdDisplayListener.NotDisplayedReason.AD_NOT_READY_VIDEO_FALLBACK.toString());
                    } else {
                        Context context = this.context;
                        g g4 = this.ad;
                        if (g4 == null) {
                            g4 = com.startapp.android.publish.cache.a.a().b(this.adKey);
                        }
                        c.a(context, c.a(g4), string, this.getNotDisplayedReason().toString());
                    }
                } else if (f2 != null) {
                    c.a(this.context, c.a(com.startapp.android.publish.cache.a.a().b(this.adKey)), string, f2.c());
                }
            }
            this.ad = null;
            if (!bl && (adDisplayListener2 = this.callback) != null) {
                adDisplayListener2.adNotDisplayed(this);
            }
        }
        return bl2;
    }

    public boolean showAd() {
        return this.showAd(null, null);
    }

    public boolean showAd(AdDisplayListener adDisplayListener) {
        return this.showAd(null, adDisplayListener);
    }

    public boolean showAd(String string) {
        return this.showAd(string, null);
    }

    public boolean showAd(String string, AdDisplayListener adDisplayListener) {
        try {
            boolean bl = this.show(string, adDisplayListener);
            return bl;
        }
        catch (Exception exception) {
            com.startapp.android.publish.adsCommon.f.f.a(this.context, d.b, "StartAppAd.showAd - unexpected Error occurd", exception.getMessage(), "");
            this.setNotDisplayedReason(AdDisplayListener.NotDisplayedReason.INTERNAL_ERROR);
            if (adDisplayListener != null) {
                adDisplayListener.adNotDisplayed(null);
            }
            return false;
        }
    }

}

