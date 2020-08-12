/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.location.Location
 *  android.location.LocationManager
 *  android.provider.Settings
 *  android.provider.Settings$Secure
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.math.BigInteger
 *  java.security.MessageDigest
 *  java.security.NoSuchAlgorithmException
 *  java.util.Properties
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.aerserv.sdk.adapter;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.provider.Settings;
import com.aerserv.sdk.adapter.Provider;
import com.aerserv.sdk.controller.listener.ProviderListener;
import com.aerserv.sdk.controller.listener.ProviderListenerLocator;
import com.aerserv.sdk.model.ad.ThirdPartyProviderAd;
import com.aerserv.sdk.utils.AerServLog;
import com.aerserv.sdk.utils.ReflectionUtils;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class AbstractCustomProvider
implements Provider {
    private static final String LOG_TAG = "AbstractCustomProvider";
    private Context context = null;
    protected String controllerId = null;
    private boolean isDebug = false;
    protected long programmaticTimeoutMillis = 6000L;
    private Properties properties = null;
    protected ProviderListener providerListener = null;
    private String providerName = null;
    protected long timeoutMillis = 6000L;

    protected AbstractCustomProvider(String string) {
        this.providerName = string;
    }

    protected static void checkDependency(String string) {
        if (ReflectionUtils.canFindClass(string)) {
            return;
        }
        throw new IllegalStateException("Could not find partner's ad class.  Failing over.");
    }

    private JSONObject getProviderData() {
        ThirdPartyProviderAd thirdPartyProviderAd = this.getProviderAd();
        if (thirdPartyProviderAd != null && thirdPartyProviderAd.getData() != null && thirdPartyProviderAd.getData().optJSONObject(this.providerName) != null) {
            return thirdPartyProviderAd.getData().optJSONObject(this.providerName);
        }
        throw new IllegalArgumentException("Properties does not contain provider data");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected void configureRequest(Properties properties) {
        if (properties == null) {
            throw new IllegalArgumentException("Properties cannot be null");
        }
        this.properties = properties;
        if (properties.get((Object)"context") == null) {
            throw new IllegalArgumentException("Properties does not contain key context");
        }
        this.context = (Context)properties.get((Object)"context");
        boolean bl = properties.get((Object)"preinit") != null ? Boolean.parseBoolean((String)properties.get((Object)"preinit").toString()) : false;
        if (!bl) {
            if (properties.get((Object)"controllerId") == null) {
                throw new IllegalArgumentException("Properties does not contain controllerId");
            }
            this.controllerId = (String)properties.get((Object)"controllerId");
            this.providerListener = ProviderListenerLocator.getProviderListener(this.controllerId);
            if (this.providerListener == null) {
                throw new IllegalArgumentException("Could not locate provider listener. Cannot continue.");
            }
        }
        boolean bl2 = properties.get((Object)"isDebug") == null ? false : (Boolean)properties.get((Object)"isDebug");
        this.isDebug = bl2;
        try {
            String string = this.getProperty("Timeout", false);
            if (string != null) {
                this.timeoutMillis = Math.max((long)1000L, (long)Long.parseLong((String)string.toString()));
                return;
            }
            this.timeoutMillis = this.programmaticTimeoutMillis;
            return;
        }
        catch (Exception exception) {
            String string = LOG_TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Enable to read adapter timeout: ");
            stringBuilder.append(exception.getMessage());
            AerServLog.w(string, stringBuilder.toString());
            this.timeoutMillis = this.programmaticTimeoutMillis;
            return;
        }
    }

    protected String[] getArrayProperty(String string, boolean bl) {
        JSONObject jSONObject = this.getProviderData();
        JSONArray jSONArray = jSONObject != null ? jSONObject.optJSONArray(string) : null;
        if (jSONArray == null) {
            if (!bl) {
                return null;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Properties does not contain key ");
            stringBuilder.append(string);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        String[] arrstring = new String[jSONArray.length()];
        for (int i2 = 0; i2 < jSONArray.length(); ++i2) {
            arrstring[i2] = jSONArray.optString(i2);
        }
        return arrstring;
    }

    protected Context getContext() {
        return this.context;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    protected Location getLocation() {
        Location location = null;
        LocationManager locationManager = (LocationManager)this.context.getSystemService("location");
        location = locationManager.getLastKnownLocation("network");
        if (location != null) return location;
        location = locationManager.getLastKnownLocation("gps");
        if (location != null) return location;
        try {
            return locationManager.getLastKnownLocation("passive");
        }
        catch (Exception exception) {
            String string = LOG_TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Error getting location: ");
            stringBuilder.append(exception.getMessage());
            AerServLog.i(string, stringBuilder.toString());
        }
        return location;
    }

    protected String getProperty(String string, boolean bl) throws JSONException {
        JSONObject jSONObject = this.getProviderData();
        if (jSONObject != null && !"".equals((Object)jSONObject.optString(string))) {
            return jSONObject.optString(string);
        }
        if (!bl) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Properties does not contain key ");
        stringBuilder.append(string);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    protected ThirdPartyProviderAd getProviderAd() {
        if (this.properties.get((Object)"providerAd") != null) {
            if (this.properties.get((Object)"providerAd") instanceof ThirdPartyProviderAd) {
                return (ThirdPartyProviderAd)this.properties.get((Object)"providerAd");
            }
            throw new IllegalArgumentException("Properties providerAd is not of type ThirdPartyProviderAd");
        }
        throw new IllegalArgumentException("Properties does not contain key providerAd");
    }

    protected abstract void initExistingInstance(Properties var1) throws JSONException;

    protected abstract void initNewInstance(Properties var1) throws JSONException;

    protected boolean isDebug() {
        return this.isDebug;
    }

    protected boolean isMyActivity(Activity activity) {
        return activity.getClass().getName().equals((Object)this.getContext().getClass().getName());
    }

    protected String makeUpperCaseMD5AndroidId() {
        MessageDigest messageDigest;
        String string = Settings.Secure.getString((ContentResolver)this.getContext().getContentResolver(), (String)"android_id");
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
}

