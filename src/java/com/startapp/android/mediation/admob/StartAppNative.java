/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.location.Location
 *  android.os.Bundle
 *  androidx.annotation.Keep
 *  com.google.android.gms.ads.formats.NativeAdOptions
 *  com.google.android.gms.ads.mediation.NativeMediationAdRequest
 *  com.google.android.gms.ads.mediation.customevent.CustomEventNative
 *  com.google.android.gms.ads.mediation.customevent.CustomEventNativeListener
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.Date
 *  java.util.Iterator
 *  java.util.Set
 */
package com.startapp.android.mediation.admob;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.ads.mediation.customevent.CustomEventNative;
import com.google.android.gms.ads.mediation.customevent.CustomEventNativeListener;
import com.startapp.android.mediation.admob.StartAppNative;
import com.startapp.android.mediation.admob.Utils;
import com.startapp.android.publish.ads.nativead.NativeAdPreferences;
import com.startapp.android.publish.ads.nativead.StartAppNativeAd;
import com.startapp.android.publish.adsCommon.SDKAdPreferences;
import com.startapp.android.publish.adsCommon.adListeners.AdEventListener;
import com.startapp.android.publish.common.model.AdPreferences;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

@Keep
public class StartAppNative
implements CustomEventNative {
    public static final String EXTRAS_CATEGORY = "category";
    public static final String EXTRAS_INSTALLS = "installs";

    private static NativeAdPreferences createNativeAdPreferences(NativeMediationAdRequest nativeMediationAdRequest) {
        NativeAdOptions nativeAdOptions = nativeMediationAdRequest.getNativeAdOptions();
        boolean bl = nativeAdOptions != null && !nativeAdOptions.shouldReturnUrlsForImageAssets();
        NativeAdPreferences nativeAdPreferences = new NativeAdPreferences();
        nativeAdPreferences.setAutoBitmapDownload(bl);
        if (nativeMediationAdRequest.getGender() == 1) {
            nativeAdPreferences.setGender(SDKAdPreferences.Gender.MALE);
        } else if (nativeMediationAdRequest.getGender() == 2) {
            nativeAdPreferences.setGender(SDKAdPreferences.Gender.FEMALE);
        }
        if (nativeMediationAdRequest.getBirthday() != null) {
            nativeAdPreferences.setAge(Utils.getDiffInYears(System.currentTimeMillis(), nativeMediationAdRequest.getBirthday().getTime()));
        }
        if (nativeMediationAdRequest.getKeywords() != null) {
            StringBuilder stringBuilder = new StringBuilder();
            Iterator iterator = nativeMediationAdRequest.getKeywords().iterator();
            while (iterator.hasNext()) {
                stringBuilder.append((String)iterator.next());
                stringBuilder.append(',');
            }
            nativeAdPreferences.setKeywords(stringBuilder.substring(0, stringBuilder.length() - 1));
        }
        if (nativeMediationAdRequest.getLocation() != null) {
            nativeAdPreferences.setLongitude(nativeMediationAdRequest.getLocation().getLongitude());
            nativeAdPreferences.setLatitude(nativeMediationAdRequest.getLocation().getLatitude());
        }
        return nativeAdPreferences;
    }

    public void onDestroy() {
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void requestNativeAd(Context context, CustomEventNativeListener customEventNativeListener, String string, NativeMediationAdRequest nativeMediationAdRequest, Bundle bundle) {
        if (nativeMediationAdRequest.isDesignedForFamilies()) {
            customEventNativeListener.onAdFailedToLoad(3);
            return;
        }
        StartAppNativeAd startAppNativeAd = new StartAppNativeAd(context);
        startAppNativeAd.loadAd(StartAppNative.createNativeAdPreferences(nativeMediationAdRequest), new AdEventListener(this, startAppNativeAd, customEventNativeListener, context){
            final /* synthetic */ StartAppNative this$0;
            final /* synthetic */ Context val$context;
            final /* synthetic */ CustomEventNativeListener val$listener;
            final /* synthetic */ StartAppNativeAd val$nativeAd;
            {
                this.this$0 = startAppNative;
                this.val$nativeAd = startAppNativeAd;
                this.val$listener = customEventNativeListener;
                this.val$context = context;
            }

            public void onFailedToReceiveAd(com.startapp.android.publish.adsCommon.Ad ad2) {
                this.val$listener.onAdFailedToLoad(0);
            }

            public void onReceiveAd(com.startapp.android.publish.adsCommon.Ad ad2) {
                java.util.ArrayList<com.startapp.android.publish.ads.nativead.NativeAdDetails> arrayList = this.val$nativeAd.getNativeAds();
                if (arrayList != null && arrayList.size() > 0) {
                    this.val$listener.onAdLoaded(com.startapp.android.mediation.admob.StartAppNativeAdMapperBuilder.buildMapper(this.val$context, (com.startapp.android.publish.ads.nativead.NativeAdDetails)arrayList.get(0)));
                    return;
                }
                this.val$listener.onAdFailedToLoad(3);
            }
        });
    }
}

