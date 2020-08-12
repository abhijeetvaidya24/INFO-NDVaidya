/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.applovin.sdk.AppLovinSdk
 *  java.lang.Deprecated
 *  java.lang.Object
 */
package com.applovin.adview;

import android.content.Context;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.sdk.AppLovinSdk;

@Deprecated
public interface InterstitialAdDialogCreator {
    public AppLovinInterstitialAdDialog createInterstitialAdDialog(AppLovinSdk var1, Context var2);
}

