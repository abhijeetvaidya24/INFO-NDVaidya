/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  com.ironsource.mediationsdk.logger.IronSourceLoggerManager
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.Set
 *  org.json.JSONObject
 */
package com.ironsource.adapters.supersonicads;

import android.text.TextUtils;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.ProviderSettings;
import com.ironsource.mediationsdk.model.ProviderSettingsHolder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public class SupersonicConfig {
    private static SupersonicConfig mInstance;
    private final String APPLICATION_PRIVATE_KEY = "privateKey";
    private final String CAMPAIGN_ID = "campaignId";
    private final String CLIENT_SIDE_CALLBACKS = "useClientSideCallbacks";
    private final String CUSTOM_PARAM_PREFIX = "custom_";
    private final String DYNAMIC_CONTROLLER_DEBUG_MODE = "debugMode";
    private final String DYNAMIC_CONTROLLER_URL = "controllerUrl";
    private final String ITEM_COUNT = "itemCount";
    private final String ITEM_NAME = "itemName";
    private final String LANGUAGE = "language";
    private final String MAX_VIDEO_LENGTH = "maxVideoLength";
    private Map<String, String> mOfferwallCustomParams;
    ProviderSettings mProviderSettings = new ProviderSettings(ProviderSettingsHolder.getProviderSettingsHolder().getProviderSettings("Mediation"));
    private Map<String, String> mRewardedVideoCustomParams;

    private SupersonicConfig() {
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private Map<String, String> convertCustomParams(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        if (map == null) return hashMap;
        Set set = map.keySet();
        if (set == null) return hashMap;
        try {
            for (String string : set) {
                String string2;
                if (TextUtils.isEmpty((CharSequence)string) || TextUtils.isEmpty((CharSequence)(string2 = (String)map.get((Object)string)))) continue;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("custom_");
                stringBuilder.append(string);
                hashMap.put((Object)stringBuilder.toString(), (Object)string2);
            }
            return hashMap;
        }
        catch (Exception exception) {
            IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, ":convertCustomParams()", (Throwable)exception);
        }
        return hashMap;
    }

    public static SupersonicConfig getConfigObj() {
        if (mInstance == null) {
            mInstance = new SupersonicConfig();
        }
        return mInstance;
    }

    public boolean getClientSideCallbacks() {
        ProviderSettings providerSettings = this.mProviderSettings;
        boolean bl2 = false;
        if (providerSettings != null) {
            JSONObject jSONObject = providerSettings.getRewardedVideoSettings();
            bl2 = false;
            if (jSONObject != null) {
                boolean bl3 = this.mProviderSettings.getRewardedVideoSettings().has("useClientSideCallbacks");
                bl2 = false;
                if (bl3) {
                    bl2 = this.mProviderSettings.getRewardedVideoSettings().optBoolean("useClientSideCallbacks", false);
                }
            }
        }
        return bl2;
    }

    Map<String, String> getOfferwallCustomParams() {
        return this.mOfferwallCustomParams;
    }

    Map<String, String> getRewardedVideoCustomParams() {
        return this.mRewardedVideoCustomParams;
    }

    public void setCampaignId(String string) {
        this.mProviderSettings.setRewardedVideoSettings("campaignId", string);
    }

    public void setClientSideCallbacks(boolean bl2) {
        this.mProviderSettings.setRewardedVideoSettings("useClientSideCallbacks", String.valueOf((boolean)bl2));
    }

    public void setCustomControllerUrl(String string) {
        this.mProviderSettings.setRewardedVideoSettings("controllerUrl", string);
        this.mProviderSettings.setInterstitialSettings("controllerUrl", string);
    }

    public void setDebugMode(int n2) {
        this.mProviderSettings.setRewardedVideoSettings("debugMode", n2);
        this.mProviderSettings.setInterstitialSettings("debugMode", n2);
    }

    public void setLanguage(String string) {
        this.mProviderSettings.setRewardedVideoSettings("language", string);
        this.mProviderSettings.setInterstitialSettings("language", string);
    }

    public void setOfferwallCustomParams(Map<String, String> map) {
        this.mOfferwallCustomParams = this.convertCustomParams(map);
    }

    public void setRewardedVideoCustomParams(Map<String, String> map) {
        this.mRewardedVideoCustomParams = this.convertCustomParams(map);
    }
}

