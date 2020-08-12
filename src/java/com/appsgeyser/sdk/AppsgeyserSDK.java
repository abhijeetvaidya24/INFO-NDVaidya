/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.content.Context
 *  com.appsgeyser.sdk.InternalEntryPoint
 *  java.lang.Object
 *  java.lang.String
 */
package com.appsgeyser.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.appsgeyser.sdk.InternalEntryPoint;
import com.appsgeyser.sdk.ads.fastTrack.FastTrackAdsController;

public final class AppsgeyserSDK {
    public static void areInAppPurchasesEnabled(Context context, OnInAppPurchasesEnableListener onInAppPurchasesEnableListener) {
        InternalEntryPoint.getInstance().getNewConfigPhp(context, onInAppPurchasesEnableListener);
    }

    public static String getAdditionalJsCode() {
        return InternalEntryPoint.getInstance().getAdditionalJsCode();
    }

    public static FastTrackAdsController getFastTrackAdsController() {
        return InternalEntryPoint.getInstance().getFastTrackAdsController();
    }

    public static void isAboutDialogEnabled(Context context, OnAboutDialogEnableListener onAboutDialogEnableListener) {
        InternalEntryPoint.getInstance().getNewConfigPhp(context, onAboutDialogEnableListener);
    }

    public static void isOfferWallEnabled(Context context, OfferWallEnabledListener offerWallEnabledListener) {
        InternalEntryPoint.getInstance().checkIsOfferWallEnabled(context, offerWallEnabledListener);
    }

    public static void launchDisableAdsBillingFlow(Activity activity) {
        InternalEntryPoint.getInstance().launchDisableAdsBillingFlow(activity);
    }

    public static void onPause(Context context) {
        InternalEntryPoint.getInstance().onPause(context);
    }

    public static void onResume(Context context) {
        InternalEntryPoint.getInstance().onResume(context);
    }

    public static void setApplicationInstance(Application application) {
        InternalEntryPoint.getInstance().setApplication(application);
    }

    public static void showAboutDialog(Activity activity) {
        InternalEntryPoint.getInstance().showAboutDialog(activity);
    }

    public static void takeOff(Activity activity, String string2, String string3, String string4) {
        InternalEntryPoint.getInstance().takeOff(activity, string2, string3, string4);
    }

    public static interface OfferWallEnabledListener {
        public void isOfferWallEnabled(boolean var1);
    }

    public static interface OnAboutDialogEnableListener {
        public void onDialogEnableReceived(boolean var1);
    }

    public static interface OnInAppPurchasesEnableListener {
        public void onInAppPurchasesEnableReceived(boolean var1);
    }

}

