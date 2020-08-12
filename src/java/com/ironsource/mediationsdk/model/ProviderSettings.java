/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.ironsource.mediationsdk.model;

import org.json.JSONException;
import org.json.JSONObject;

public class ProviderSettings {
    private JSONObject mApplicationSettings;
    private JSONObject mBannerSettings;
    private JSONObject mInterstitialSettings;
    private boolean mIsMultipleInstances;
    private int mProviderBNPriority;
    private int mProviderISPriority;
    private String mProviderInstanceName;
    private String mProviderName;
    private int mProviderRVPriority;
    private String mProviderTypeForReflection;
    private JSONObject mRewardedVideoSettings;
    private String mSubProviderId;

    public ProviderSettings(ProviderSettings providerSettings) {
        this.mProviderName = providerSettings.getProviderName();
        this.mProviderInstanceName = providerSettings.getProviderName();
        this.mProviderTypeForReflection = providerSettings.getProviderTypeForReflection();
        this.mRewardedVideoSettings = providerSettings.getRewardedVideoSettings();
        this.mInterstitialSettings = providerSettings.getInterstitialSettings();
        this.mBannerSettings = providerSettings.getBannerSettings();
        this.mApplicationSettings = providerSettings.getApplicationSettings();
        this.mProviderRVPriority = providerSettings.getRewardedVideoPriority();
        this.mProviderISPriority = providerSettings.getInterstitialPriority();
        this.mProviderBNPriority = providerSettings.getBannerPriority();
    }

    public ProviderSettings(String string) {
        this.mProviderName = string;
        this.mProviderInstanceName = string;
        this.mProviderTypeForReflection = string;
        this.mRewardedVideoSettings = new JSONObject();
        this.mInterstitialSettings = new JSONObject();
        this.mBannerSettings = new JSONObject();
        this.mApplicationSettings = new JSONObject();
        this.mProviderRVPriority = -1;
        this.mProviderISPriority = -1;
        this.mProviderBNPriority = -1;
    }

    public ProviderSettings(String string, String string2, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4) {
        this.mProviderName = string;
        this.mProviderInstanceName = string;
        this.mProviderTypeForReflection = string2;
        this.mRewardedVideoSettings = jSONObject2;
        this.mInterstitialSettings = jSONObject3;
        this.mBannerSettings = jSONObject4;
        this.mApplicationSettings = jSONObject;
        this.mProviderRVPriority = -1;
        this.mProviderISPriority = -1;
        this.mProviderBNPriority = -1;
    }

    public JSONObject getApplicationSettings() {
        return this.mApplicationSettings;
    }

    public int getBannerPriority() {
        return this.mProviderBNPriority;
    }

    public JSONObject getBannerSettings() {
        return this.mBannerSettings;
    }

    public int getInterstitialPriority() {
        return this.mProviderISPriority;
    }

    public JSONObject getInterstitialSettings() {
        return this.mInterstitialSettings;
    }

    public String getProviderInstanceName() {
        return this.mProviderInstanceName;
    }

    public String getProviderName() {
        return this.mProviderName;
    }

    public String getProviderTypeForReflection() {
        return this.mProviderTypeForReflection;
    }

    public int getRewardedVideoPriority() {
        return this.mProviderRVPriority;
    }

    public JSONObject getRewardedVideoSettings() {
        return this.mRewardedVideoSettings;
    }

    public String getSubProviderId() {
        return this.mSubProviderId;
    }

    public boolean isMultipleInstances() {
        return this.mIsMultipleInstances;
    }

    public void setBannerPriority(int n2) {
        this.mProviderBNPriority = n2;
    }

    public void setBannerSettings(JSONObject jSONObject) {
        this.mBannerSettings = jSONObject;
    }

    public void setInterstitialPriority(int n2) {
        this.mProviderISPriority = n2;
    }

    public void setInterstitialSettings(String string, Object object) {
        try {
            this.mInterstitialSettings.put(string, object);
            return;
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
            return;
        }
    }

    public void setInterstitialSettings(JSONObject jSONObject) {
        this.mInterstitialSettings = jSONObject;
    }

    public void setIsMultipleInstances(boolean bl2) {
        this.mIsMultipleInstances = bl2;
    }

    public void setRewardedVideoPriority(int n2) {
        this.mProviderRVPriority = n2;
    }

    public void setRewardedVideoSettings(String string, Object object) {
        try {
            this.mRewardedVideoSettings.put(string, object);
            return;
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
            return;
        }
    }

    public void setRewardedVideoSettings(JSONObject jSONObject) {
        this.mRewardedVideoSettings = jSONObject;
    }

    public void setSubProviderId(String string) {
        this.mSubProviderId = string;
    }
}

