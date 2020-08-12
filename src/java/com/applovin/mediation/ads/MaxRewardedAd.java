/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.text.TextUtils
 *  com.applovin.impl.mediation.ads.MaxRewardedImpl
 *  com.applovin.mediation.MaxRewardedAdListener
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.Map
 */
package com.applovin.mediation.ads;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.applovin.impl.mediation.ads.MaxRewardedImpl;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxRewardedAdListener;
import com.applovin.sdk.AppLovinSdk;
import java.util.HashMap;
import java.util.Map;

public class MaxRewardedAd {
    private static final Map<String, MaxRewardedAd> a = new HashMap();
    private static final Object b = new Object();
    private final MaxRewardedImpl c;

    private MaxRewardedAd(String string2, AppLovinSdk appLovinSdk) {
        this.c = new MaxRewardedImpl(string2, appLovinSdk);
    }

    public static MaxRewardedAd getInstance(String string2, Activity activity) {
        return MaxRewardedAd.getInstance(string2, AppLovinSdk.getInstance((Context)activity), activity);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static MaxRewardedAd getInstance(String string2, AppLovinSdk appLovinSdk, Activity activity) {
        Object object;
        if (string2 == null) {
            throw new IllegalArgumentException("No ad unit ID specified");
        }
        if (TextUtils.isEmpty((CharSequence)string2)) {
            throw new IllegalArgumentException("Empty ad unit ID specified");
        }
        if (activity == null) {
            throw new IllegalArgumentException("No activity specified");
        }
        if (appLovinSdk == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        MaxRewardedAd.updateActivity(activity);
        Object object2 = object = b;
        synchronized (object2) {
            MaxRewardedAd maxRewardedAd = (MaxRewardedAd)a.get((Object)string2);
            if (maxRewardedAd != null) {
                return maxRewardedAd;
            }
            MaxRewardedAd maxRewardedAd2 = new MaxRewardedAd(string2, appLovinSdk);
            a.put((Object)string2, (Object)maxRewardedAd2);
            return maxRewardedAd2;
        }
    }

    public static void updateActivity(Activity activity) {
        MaxRewardedImpl.updateActivity((Activity)activity);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void destroy() {
        Object object;
        Object object2 = object = b;
        synchronized (object2) {
            a.remove((Object)this.c.getAdUnitId());
        }
        this.c.destroy();
    }

    public boolean isReady() {
        return this.c.isReady();
    }

    public void loadAd() {
        this.c.loadAd();
    }

    public void setExtrasParameter(String string2, String string3) {
        this.c.setExtraParameter(string2, string3);
    }

    public void setListener(MaxRewardedAdListener maxRewardedAdListener) {
        this.c.setListener((MaxAdListener)maxRewardedAdListener);
    }

    public void showAd() {
        this.c.showAd();
    }
}

