/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.ironsource.mediationsdk.model;

import com.ironsource.mediationsdk.model.ApplicationConfigurations;
import com.ironsource.mediationsdk.model.BannerConfigurations;
import com.ironsource.mediationsdk.model.InterstitialConfigurations;
import com.ironsource.mediationsdk.model.OfferwallConfigurations;
import com.ironsource.mediationsdk.model.RewardedVideoConfigurations;

public class Configurations {
    private ApplicationConfigurations mApplicationConfig;
    private BannerConfigurations mBannerConfig;
    private InterstitialConfigurations mInterstitialConfig;
    private OfferwallConfigurations mOfferwallConfig;
    private RewardedVideoConfigurations mRewardedVideoConfig;

    public Configurations() {
    }

    public Configurations(RewardedVideoConfigurations rewardedVideoConfigurations, InterstitialConfigurations interstitialConfigurations, OfferwallConfigurations offerwallConfigurations, BannerConfigurations bannerConfigurations, ApplicationConfigurations applicationConfigurations) {
        if (rewardedVideoConfigurations != null) {
            this.mRewardedVideoConfig = rewardedVideoConfigurations;
        }
        if (interstitialConfigurations != null) {
            this.mInterstitialConfig = interstitialConfigurations;
        }
        if (offerwallConfigurations != null) {
            this.mOfferwallConfig = offerwallConfigurations;
        }
        if (bannerConfigurations != null) {
            this.mBannerConfig = bannerConfigurations;
        }
        this.mApplicationConfig = applicationConfigurations;
    }

    public ApplicationConfigurations getApplicationConfigurations() {
        return this.mApplicationConfig;
    }

    public BannerConfigurations getBannerConfigurations() {
        return this.mBannerConfig;
    }

    public InterstitialConfigurations getInterstitialConfigurations() {
        return this.mInterstitialConfig;
    }

    public OfferwallConfigurations getOfferwallConfigurations() {
        return this.mOfferwallConfig;
    }

    public RewardedVideoConfigurations getRewardedVideoConfigurations() {
        return this.mRewardedVideoConfig;
    }
}

