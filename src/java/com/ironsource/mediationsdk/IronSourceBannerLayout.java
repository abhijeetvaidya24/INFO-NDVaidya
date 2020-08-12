/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.view.View
 *  android.widget.FrameLayout
 *  com.ironsource.mediationsdk.logger.IronSourceLoggerManager
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.ironsource.mediationsdk;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.ironsource.mediationsdk.EBannerSize;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.sdk.BannerListener;
import com.ironsource.mediationsdk.sdk.BannerManagerListener;

public class IronSourceBannerLayout
extends FrameLayout {
    private boolean isDestroyed = false;
    private Activity mActivity;
    private BannerListener mBannerListener;
    private View mBannerView;
    private boolean mIsBannerDisplayed = false;
    private String mPlacementName;
    private EBannerSize mSize;

    public IronSourceBannerLayout(Activity activity, EBannerSize eBannerSize, BannerManagerListener bannerManagerListener) {
        super((Context)activity);
        this.mActivity = activity;
        if (eBannerSize == null) {
            eBannerSize = EBannerSize.BANNER;
        }
        this.mSize = eBannerSize;
    }

    protected void destroyBanner() {
        this.isDestroyed = true;
        this.mBannerListener = null;
        this.mActivity = null;
        this.mSize = null;
        this.mPlacementName = null;
        this.mBannerView = null;
    }

    public Activity getActivity() {
        return this.mActivity;
    }

    public BannerListener getBannerListener() {
        return this.mBannerListener;
    }

    public View getBannerView() {
        return this.mBannerView;
    }

    public String getPlacementName() {
        return this.mPlacementName;
    }

    public EBannerSize getSize() {
        return this.mSize;
    }

    public boolean isDestroyed() {
        return this.isDestroyed;
    }

    void sendBannerAdLoadFailed(IronSourceError ironSourceError) {
        BannerListener bannerListener;
        if (this.mIsBannerDisplayed) {
            this.mBannerListener.onBannerAdLoadFailed(ironSourceError);
            return;
        }
        IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onBannerAdLoadFailed() | internal | ");
        stringBuilder.append((Object)ironSourceError);
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 0);
        try {
            if (this.mBannerView != null) {
                this.removeView(this.mBannerView);
                this.mBannerView = null;
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        if ((bannerListener = this.mBannerListener) != null) {
            bannerListener.onBannerAdLoadFailed(ironSourceError);
        }
    }

    public void setBannerListener(BannerListener bannerListener) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, "setBannerListener()", 1);
        this.mBannerListener = bannerListener;
    }

    public void setPlacementName(String string) {
        this.mPlacementName = string;
    }
}

