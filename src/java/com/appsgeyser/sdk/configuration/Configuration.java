/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.appsgeyser.sdk.configuration;

import android.content.Context;
import android.text.TextUtils;
import com.appsgeyser.sdk.GuidGenerator;
import com.appsgeyser.sdk.configuration.PreferencesCoder;
import org.json.JSONException;
import org.json.JSONObject;

public final class Configuration {
    private static Configuration instance;
    private String appGuid = "";
    private String appName = "";
    private String applicationId = "";
    private String publisherName = "";
    private boolean registered = false;
    private PreferencesCoder settingsCoder;

    private Configuration() {
    }

    public static Configuration getInstance(Context context) {
        if (instance == null) {
            instance = new Configuration();
        }
        PreferencesCoder preferencesCoder = new PreferencesCoder(context);
        instance.setSettingsCoder(preferencesCoder);
        return instance;
    }

    private void setSettingsCoder(PreferencesCoder preferencesCoder) {
        this.settingsCoder = preferencesCoder;
    }

    public void clearApplicationSettings() {
        this.applicationId = "";
        this.appGuid = "";
        this.settingsCoder.savePrefString("ApplicationId", "");
        this.settingsCoder.savePrefString("AppGuid", "");
    }

    public String getAppGuid() {
        if (TextUtils.isEmpty((CharSequence)this.appGuid)) {
            this.appGuid = GuidGenerator.generateNewGuid();
            PreferencesCoder preferencesCoder = this.settingsCoder;
            if (preferencesCoder != null) {
                preferencesCoder.savePrefString("AppGuid", this.appGuid);
            }
        }
        return this.appGuid;
    }

    public String getApplicationId() {
        return this.applicationId;
    }

    public String getMetricaOnStartEvent() {
        return this.settingsCoder.getPrefString("metricaJsonLoad", null);
    }

    public String getPublisherName() {
        return this.publisherName;
    }

    public PreferencesCoder getSettingsCoder() {
        return this.settingsCoder;
    }

    public String getTemplateVersion() {
        return this.settingsCoder.getPrefString("TemplateVersion", "");
    }

    public boolean isRegistered() {
        return this.registered;
    }

    public void loadConfiguration() {
        this.publisherName = "";
        this.applicationId = this.settingsCoder.getPrefString("ApplicationId", "");
        this.appGuid = this.settingsCoder.getPrefString("AppGuid", "");
        this.registered = this.settingsCoder.getPrefBoolean("Registered", false);
    }

    public void registerNew() {
        this.registered = true;
        this.settingsCoder.savePrefBoolean("Registered", true);
    }

    public void setApplicationId(String string2) {
        this.applicationId = string2;
        PreferencesCoder preferencesCoder = this.settingsCoder;
        if (preferencesCoder != null) {
            preferencesCoder.savePrefString("ApplicationId", this.applicationId);
        }
    }

    public void setMetricaOnStartEvent(String string2, String string3) {
        try {
            JSONObject jSONObject = new JSONObject(string2);
            jSONObject.put("templateVersion", (Object)string3);
            jSONObject.put("appsgeyserSdkVersion", (Object)"2.14.s");
            this.settingsCoder.savePrefString("metricaJsonLoad", jSONObject.toString());
            return;
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
            return;
        }
    }

    public void setTemplateVersion(String string2) {
        this.settingsCoder.savePrefString("TemplateVersion", string2);
    }
}

