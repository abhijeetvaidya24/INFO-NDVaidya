/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.app.Activity
 *  android.content.res.Configuration
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewParent
 *  android.view.Window
 *  java.lang.Object
 *  java.lang.String
 */
package com.amazon.device.ads;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import com.amazon.device.ads.AdActivity;
import com.amazon.device.ads.AdControlAccessor;
import com.amazon.device.ads.AdController;
import com.amazon.device.ads.AdControllerFactory;
import com.amazon.device.ads.AndroidBuildInfo;
import com.amazon.device.ads.AndroidTargetUtils;
import com.amazon.device.ads.InterstitialAd;
import com.amazon.device.ads.MobileAdsLogger;
import com.amazon.device.ads.MobileAdsLoggerFactory;
import com.amazon.device.ads.SDKEvent;
import com.amazon.device.ads.SDKEventListener;

@SuppressLint(value={"NewApi"})
class InterstitialAdActivityAdapter
implements AdActivity.AdActivityAdapter {
    private static final String LOGTAG = "InterstitialAdActivityAdapter";
    private Activity activity = null;
    private AdController adController;
    private final AndroidBuildInfo buildInfo = new AndroidBuildInfo();
    private final MobileAdsLogger logger = new MobileAdsLoggerFactory().createMobileAdsLogger(LOGTAG);

    InterstitialAdActivityAdapter() {
    }

    private void finishActivity() {
        if (!this.activity.isFinishing()) {
            this.adController = null;
            this.activity.finish();
        }
    }

    Activity getActivity() {
        return this.activity;
    }

    AdController getAdController() {
        return AdControllerFactory.getCachedAdController();
    }

    @Override
    public boolean onBackPressed() {
        AdController adController = this.adController;
        if (adController != null) {
            return adController.onBackButtonPress();
        }
        return false;
    }

    @Override
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override
    public void onCreate() {
        AndroidTargetUtils.enableHardwareAcceleration(this.buildInfo, this.activity.getWindow());
        AdController adController = this.adController = this.getAdController();
        if (adController == null) {
            this.logger.e("Failed to show interstitial ad due to an error in the Activity.");
            InterstitialAd.resetIsAdShowing();
            this.activity.finish();
            return;
        }
        adController.setAdActivity(this.activity);
        this.adController.addSDKEventListener(new InterstitialAdSDKEventListener());
        ViewGroup viewGroup = (ViewGroup)this.adController.getView().getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this.adController.getView());
        }
        this.activity.setContentView(this.adController.getView());
        this.adController.adShown();
    }

    @Override
    public void onDestroy() {
        AdController adController = this.adController;
        if (adController != null) {
            adController.fireViewableEvent();
            this.adController.closeAd();
        }
    }

    @Override
    public void onPause() {
        AdController adController = this.adController;
        if (adController != null) {
            adController.fireViewableEvent();
        }
    }

    @Override
    public void onResume() {
    }

    @Override
    public void onStop() {
        AdController adController;
        if (this.activity.isFinishing() && (adController = this.adController) != null) {
            adController.fireViewableEvent();
            this.adController.closeAd();
        }
    }

    @Override
    public void onWindowFocusChanged() {
        AdController adController = this.adController;
        if (adController != null) {
            adController.fireViewableEvent();
        }
    }

    @Override
    public void preOnCreate() {
        this.activity.requestWindowFeature(1);
        this.activity.getWindow().setFlags(1024, 1024);
        AndroidTargetUtils.hideActionAndStatusBars(this.buildInfo, this.activity);
    }

    @Override
    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    class InterstitialAdSDKEventListener
    implements SDKEventListener {
        InterstitialAdSDKEventListener() {
        }

        @Override
        public void onSDKEvent(SDKEvent sDKEvent, AdControlAccessor adControlAccessor) {
            if (sDKEvent.getEventType().equals((Object)SDKEvent.SDKEventType.CLOSED)) {
                InterstitialAdActivityAdapter.this.finishActivity();
            }
        }
    }

}

