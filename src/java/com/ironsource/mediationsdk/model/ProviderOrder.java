/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 */
package com.ironsource.mediationsdk.model;

import android.text.TextUtils;
import java.util.ArrayList;

public class ProviderOrder {
    private ArrayList<String> mBannerProviderOrder = new ArrayList();
    private String mISBackFillProvider;
    private String mISPremiumProvider;
    private ArrayList<String> mInterstitialProviderOrder = new ArrayList();
    private String mRVBackFillProvider;
    private String mRVPremiumProvider;
    private ArrayList<String> mRewardedVideoProviderOrder = new ArrayList();

    public void addBannerProvider(String string) {
        if (!TextUtils.isEmpty((CharSequence)string)) {
            this.mBannerProviderOrder.add((Object)string);
        }
    }

    public void addInterstitialProvider(String string) {
        if (!TextUtils.isEmpty((CharSequence)string)) {
            this.mInterstitialProviderOrder.add((Object)string);
        }
    }

    public void addRewardedVideoProvider(String string) {
        if (!TextUtils.isEmpty((CharSequence)string)) {
            this.mRewardedVideoProviderOrder.add((Object)string);
        }
    }

    public ArrayList<String> getBannerProviderOrder() {
        return this.mBannerProviderOrder;
    }

    public ArrayList<String> getInterstitialProviderOrder() {
        return this.mInterstitialProviderOrder;
    }

    public String getRVBackFillProvider() {
        return this.mRVBackFillProvider;
    }

    public String getRVPremiumProvider() {
        return this.mRVPremiumProvider;
    }

    public ArrayList<String> getRewardedVideoProviderOrder() {
        return this.mRewardedVideoProviderOrder;
    }

    public void setISBackFillProvider(String string) {
        this.mISBackFillProvider = string;
    }

    public void setISPremiumProvider(String string) {
        this.mISPremiumProvider = string;
    }

    public void setRVBackFillProvider(String string) {
        this.mRVBackFillProvider = string;
    }

    public void setRVPremiumProvider(String string) {
        this.mRVPremiumProvider = string;
    }
}

