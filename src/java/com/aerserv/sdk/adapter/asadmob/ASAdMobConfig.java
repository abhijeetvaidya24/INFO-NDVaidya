/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.provider.Settings
 *  android.provider.Settings$Secure
 *  com.aerserv.sdk.model.ad.ThirdPartyProviderAd
 *  java.lang.Boolean
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.math.BigInteger
 *  java.security.MessageDigest
 *  java.security.NoSuchAlgorithmException
 *  java.util.Properties
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.aerserv.sdk.adapter.asadmob;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import com.aerserv.sdk.controller.listener.ProviderListener;
import com.aerserv.sdk.controller.listener.ProviderListenerLocator;
import com.aerserv.sdk.model.ad.ThirdPartyProviderAd;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;
import org.json.JSONException;
import org.json.JSONObject;

public class ASAdMobConfig {
    private String adMobAdUnitId;
    private String adMobDeviceId;
    private Context context;
    private String controllerId;
    private boolean isDebug;
    private ProviderListener providerListener;

    public ASAdMobConfig(Properties properties) throws JSONException {
        if (properties.get((Object)"context") != null) {
            this.context = (Context)properties.get((Object)"context");
            if (properties.get((Object)"controllerId") != null) {
                this.controllerId = (String)properties.get((Object)"controllerId");
                if (properties.get((Object)"providerAd") != null) {
                    ThirdPartyProviderAd thirdPartyProviderAd = (ThirdPartyProviderAd)properties.get((Object)"providerAd");
                    this.providerListener = ProviderListenerLocator.getProviderListener(this.controllerId);
                    if (this.providerListener != null) {
                        this.adMobAdUnitId = thirdPartyProviderAd.getData().getJSONObject("ASAdMob").getString("AdMobAdUnitID");
                        String string = this.adMobAdUnitId;
                        if (string != null && string.length() != 0) {
                            this.adMobDeviceId = this.makeUpperCaseMD5AndroidId(this.context);
                            if (properties.get((Object)"isDebug") == null) {
                                this.isDebug = false;
                                return;
                            }
                            this.isDebug = (Boolean)properties.get((Object)"isDebug");
                            return;
                        }
                        throw new IllegalArgumentException("properties does not contain key 'AdMobAdUnitID");
                    }
                    throw new IllegalArgumentException("Could not locate provider listener. Cannot continue.");
                }
                throw new IllegalArgumentException("properties does not contain providerAd");
            }
            throw new IllegalArgumentException("properties does not contain controllerId");
        }
        throw new IllegalArgumentException("properties does not contain context");
    }

    private String makeUpperCaseMD5AndroidId(Context context) {
        MessageDigest messageDigest;
        String string = Settings.Secure.getString((ContentResolver)context.getContentResolver(), (String)"android_id");
        try {
            messageDigest = MessageDigest.getInstance((String)"MD5");
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            noSuchAlgorithmException.printStackTrace();
            messageDigest = null;
        }
        messageDigest.reset();
        messageDigest.update(string.getBytes());
        return new BigInteger(1, messageDigest.digest()).toString(16).toUpperCase();
    }

    public String getAdMobAdUnitId() {
        return this.adMobAdUnitId;
    }

    public String getAdMobDeviceId() {
        return this.adMobDeviceId;
    }

    public Context getContext() {
        return this.context;
    }

    public String getControllerId() {
        return this.controllerId;
    }

    public boolean getIsDebug() {
        return this.isDebug;
    }

    public ProviderListener getProviderListener() {
        return this.providerListener;
    }
}

