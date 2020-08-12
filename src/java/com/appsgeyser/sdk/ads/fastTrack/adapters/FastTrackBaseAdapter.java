/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.view.ViewGroup
 *  java.lang.Boolean
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.Map
 */
package com.appsgeyser.sdk.ads.fastTrack.adapters;

import android.content.Context;
import android.os.Handler;
import android.view.ViewGroup;
import com.appsgeyser.sdk.ads.fastTrack.FastTrackSdkModel;
import com.appsgeyser.sdk.configuration.PreferencesCoder;
import com.appsgeyser.sdk.ui.AppsgeyserProgressDialog;
import java.util.HashMap;
import java.util.Map;

public abstract class FastTrackBaseAdapter {
    final HashMap<String, String> appDetails;
    final HashMap<String, String> bannerDetails;
    ViewGroup bannerViewContainer;
    Context context;
    FastTrackSdkModel fastTrackSdkModel;
    FullscreenListener fullscreenListener;
    Handler handler;
    final HashMap<String, String> interstitialDetails;
    boolean isInForeground;
    final HashMap<String, String> nativeAdsDetails;
    boolean pendingFullscreenRequest;
    PreferencesCoder preferencesCoder;
    AppsgeyserProgressDialog progressDialog;
    final HashMap<String, String> rewardedDetails;
    String rewardedVideoCurrentPlacement;
    RewardedVideoListener rewardedVideoListener;
    boolean videoDownloadError;
    boolean videoShowRequested;

    /*
     * Exception decompiling
     */
    FastTrackBaseAdapter(FastTrackSdkModel var1, Context var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl67 : ALOAD_0 : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
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

    Integer getBannerViewRefreshRate(String string2) {
        Integer n2 = this.fastTrackSdkModel.getBannerPlacementsRefreshTimerMap() != null && string2 != null ? (Integer)this.fastTrackSdkModel.getBannerPlacementsRefreshTimerMap().get((Object)string2) : null;
        if (n2 != null) {
            return n2;
        }
        int n3 = this.fastTrackSdkModel.getDefaultBannerRefreshTimer() != null ? this.fastTrackSdkModel.getDefaultBannerRefreshTimer() : 15000;
        return n3;
    }

    public Context getContext() {
        return this.context;
    }

    Integer getFullscreenFrequencyTimerValue() {
        Integer n2 = this.fastTrackSdkModel.getFullscreenFrequencyTimer();
        int n3 = n2 != null && n2 >= 15000 ? n2 : 120000;
        return n3;
    }

    Integer getFullscreenIntensityPoints(String string2) {
        Integer n2 = this.fastTrackSdkModel.getFullscreenPlacementsIntensityMap() != null && string2 != null ? (Integer)this.fastTrackSdkModel.getFullscreenPlacementsIntensityMap().get((Object)string2) : null;
        if (n2 != null) {
            return n2;
        }
        int n3 = this.fastTrackSdkModel.getDefaultFullscreenIntensity() != null ? this.fastTrackSdkModel.getDefaultFullscreenIntensity() : 100;
        return n3;
    }

    public FullscreenListener getFullscreenListener() {
        return this.fullscreenListener;
    }

    Integer getFullscreenPendingDelayTimerValue() {
        Integer n2 = this.fastTrackSdkModel.getFullscreenPendingDelayTimer();
        int n3 = n2 != null && n2 >= 10000 ? n2 : 15000;
        return n3;
    }

    public Boolean getRewardedVideoActivationStatus(String string2) {
        boolean bl = true;
        Boolean bl2 = bl;
        if (this.fastTrackSdkModel.getRewardedPlacementsActivationMap() != null && string2 != null) {
            bl2 = (Boolean)this.fastTrackSdkModel.getRewardedPlacementsActivationMap().get((Object)string2);
        }
        if (bl2 != null) {
            bl = bl2;
        }
        return bl;
    }

    protected abstract void init();

    public abstract void initBannerView(ViewGroup var1, String var2);

    public abstract void loadFullscreen();

    public abstract void loadNativeAds(int var1);

    public abstract void loadRewardedVideo();

    public void onPause() {
        this.isInForeground = false;
    }

    public void onResume(Context context) {
        Context context2 = this.context;
        if (context2 != null && !context2.equals((Object)context)) {
            this.context = context;
        }
        this.isInForeground = true;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setFullscreenListener(FullscreenListener fullscreenListener) {
        this.fullscreenListener = fullscreenListener;
    }

    public void setProgressDialog(AppsgeyserProgressDialog appsgeyserProgressDialog) {
        this.progressDialog = appsgeyserProgressDialog;
    }

    public abstract void showFullscreen(String var1, String var2, boolean var3);

    public abstract void showRewardedVideo(RewardedVideoListener var1, String var2);

    public static interface FullscreenListener {
        public void onClose();

        public void onFailedToShow();

        public void onRequest();

        public void onShow();
    }

    public static interface RewardedVideoListener {
        public void onVideoClicked();

        public void onVideoClosed();

        public void onVideoDeactivated();

        public void onVideoError(String var1);

        public void onVideoFinished();

        public void onVideoOpened();
    }

}

