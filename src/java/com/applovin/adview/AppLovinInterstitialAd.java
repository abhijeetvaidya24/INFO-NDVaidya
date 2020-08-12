/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.View
 *  com.applovin.impl.adview.InterstitialAdDialogCreatorImpl
 *  com.applovin.sdk.AppLovinAdService
 *  com.applovin.sdk.AppLovinAdSize
 *  com.applovin.sdk.AppLovinSdk
 *  com.applovin.sdk.AppLovinSdkUtils
 *  java.lang.Deprecated
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
package com.applovin.adview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.impl.adview.InterstitialAdDialogCreatorImpl;
import com.applovin.sdk.AppLovinAdService;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;

public class AppLovinInterstitialAd
extends View {
    private AppLovinInterstitialAdDialog a = null;

    public AppLovinInterstitialAd(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppLovinInterstitialAd(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        AppLovinSdk appLovinSdk = AppLovinSdk.getInstance((Context)context);
        if (appLovinSdk != null && !appLovinSdk.hasCriticalErrors()) {
            this.a = new InterstitialAdDialogCreatorImpl().createInterstitialAdDialog(appLovinSdk, context);
        }
        this.setVisibility(8);
    }

    public static AppLovinInterstitialAdDialog create(AppLovinSdk appLovinSdk, Context context) {
        if (appLovinSdk != null) {
            if (context != null) {
                return new InterstitialAdDialogCreatorImpl().createInterstitialAdDialog(appLovinSdk, context);
            }
            throw new IllegalArgumentException("No context specified");
        }
        throw new IllegalArgumentException("No sdk specified");
    }

    @Deprecated
    public static boolean isAdReadyToDisplay(Context context) {
        return AppLovinSdk.getInstance((Context)context).getAdService().hasPreloadedAd(AppLovinAdSize.INTERSTITIAL);
    }

    public static void show(Context context) {
        AppLovinInterstitialAd.show(context, null);
    }

    @Deprecated
    public static void show(Context context, String string) {
        if (context != null) {
            AppLovinSdk appLovinSdk = AppLovinSdk.getInstance((Context)context);
            if (appLovinSdk != null && !appLovinSdk.hasCriticalErrors()) {
                AppLovinInterstitialAd.show(appLovinSdk, context, string);
            }
            return;
        }
        throw new IllegalArgumentException("No context specified");
    }

    @Deprecated
    public static void show(final AppLovinSdk appLovinSdk, final Context context, final String string) {
        if (appLovinSdk != null) {
            if (context != null) {
                AppLovinSdkUtils.runOnUiThread((Runnable)new Runnable(){

                    public void run() {
                        new InterstitialAdDialogCreatorImpl().createInterstitialAdDialog(appLovinSdk, context).show(string);
                    }
                });
                return;
            }
            throw new IllegalArgumentException("No context specified");
        }
        throw new IllegalArgumentException("No sdk specified");
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        AppLovinInterstitialAdDialog appLovinInterstitialAdDialog = this.a;
        if (appLovinInterstitialAdDialog != null) {
            appLovinInterstitialAdDialog.show();
        }
    }

}

