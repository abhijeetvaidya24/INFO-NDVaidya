/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  com.adincube.sdk.mediation.chartboost.a
 *  com.chartboost.sdk.Chartboost
 *  com.chartboost.sdk.ChartboostDelegate
 *  java.lang.Object
 *  java.lang.String
 */
package com.adincube.sdk.mediation.chartboost;

import android.app.Activity;
import com.adincube.sdk.mediation.chartboost.a;
import com.chartboost.sdk.Chartboost;
import com.chartboost.sdk.ChartboostDelegate;

public final class i {
    public static void a(Activity activity, String string, String string2) {
        Chartboost.startWithAppId((Activity)activity, (String)string, (String)string2);
        Chartboost.setAutoCacheAds((boolean)false);
        Chartboost.setDelegate((ChartboostDelegate)a.a());
    }
}

