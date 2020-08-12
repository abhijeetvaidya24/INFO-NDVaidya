/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  com.ironsource.mediationsdk.IronSourceObject
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.ironsource.mediationsdk;

import android.app.Activity;
import com.ironsource.mediationsdk.IronSourceObject;
import com.ironsource.mediationsdk.sdk.InterstitialListener;
import com.ironsource.mediationsdk.sdk.RewardedVideoListener;

public abstract class IronSource {
    public static /* varargs */ void init(Activity activity, String string, AD_UNIT ... arraD_UNIT) {
        IronSourceObject.getInstance().init(activity, string, false, arraD_UNIT);
    }

    public static boolean isInterstitialReady() {
        return IronSourceObject.getInstance().isInterstitialReady();
    }

    public static void loadInterstitial() {
        IronSourceObject.getInstance().loadInterstitial();
    }

    public static void removeInterstitialListener() {
        IronSourceObject.getInstance().removeInterstitialListener();
    }

    public static void setConsent(boolean bl2) {
        IronSourceObject.getInstance().setConsent(bl2);
    }

    public static void setInterstitialListener(InterstitialListener interstitialListener) {
        IronSourceObject.getInstance().setInterstitialListener(interstitialListener);
    }

    public static void setRewardedVideoListener(RewardedVideoListener rewardedVideoListener) {
        IronSourceObject.getInstance().setRewardedVideoListener(rewardedVideoListener);
    }

    public static void showInterstitial(String string) {
        IronSourceObject.getInstance().showInterstitial(string);
    }

    public static final class AD_UNIT
    extends Enum<AD_UNIT> {
        private static final /* synthetic */ AD_UNIT[] $VALUES;
        public static final /* enum */ AD_UNIT BANNER;
        public static final /* enum */ AD_UNIT INTERSTITIAL;
        public static final /* enum */ AD_UNIT OFFERWALL;
        public static final /* enum */ AD_UNIT REWARDED_VIDEO;
        private String mValue;

        static {
            REWARDED_VIDEO = new AD_UNIT("rewardedVideo");
            INTERSTITIAL = new AD_UNIT("interstitial");
            OFFERWALL = new AD_UNIT("offerwall");
            BANNER = new AD_UNIT("banner");
            AD_UNIT[] arraD_UNIT = new AD_UNIT[]{REWARDED_VIDEO, INTERSTITIAL, OFFERWALL, BANNER};
            $VALUES = arraD_UNIT;
        }

        private AD_UNIT(String string2) {
            this.mValue = string2;
        }

        public static AD_UNIT valueOf(String string) {
            return (AD_UNIT)Enum.valueOf(AD_UNIT.class, (String)string);
        }

        public static AD_UNIT[] values() {
            return (AD_UNIT[])$VALUES.clone();
        }

        public String toString() {
            return this.mValue;
        }
    }

}

