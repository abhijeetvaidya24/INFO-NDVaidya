/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.util.Log
 *  com.mopub.mobileads.CustomEventInterstitial
 *  com.mopub.mobileads.CustomEventInterstitial$CustomEventInterstitialListener
 *  com.mopub.mobileads.MoPubErrorCode
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Map
 */
package com.tappx.sdk.android;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.mopub.mobileads.CustomEventInterstitial;
import com.mopub.mobileads.MoPubErrorCode;
import com.tappx.sdk.android.AdRequest;
import com.tappx.sdk.android.MopubInterstitialAdapter;
import com.tappx.sdk.android.TappxAdError;
import com.tappx.sdk.android.TappxInterstitial;
import com.tappx.sdk.android.TappxInterstitialListener;
import java.util.Map;

public class MopubInterstitialAdapter
extends CustomEventInterstitial {
    private TappxInterstitial a;

    private static MoPubErrorCode b(TappxAdError tappxAdError) {
        int n2 = 1.a[tappxAdError.ordinal()];
        if (n2 != 1) {
            if (n2 != 2) {
                if (n2 != 3) {
                    return MoPubErrorCode.NO_FILL;
                }
                return MoPubErrorCode.SERVER_ERROR;
            }
            return MoPubErrorCode.INTERNAL_ERROR;
        }
        return MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR;
    }

    protected void loadInterstitial(Context context, CustomEventInterstitial.CustomEventInterstitialListener customEventInterstitialListener, Map<String, Object> map, Map<String, String> map2) {
        String string = (String)map2.get((Object)"appKey");
        boolean bl = context instanceof Activity;
        if (string != null && !string.isEmpty()) {
            if (!bl) {
                customEventInterstitialListener.onInterstitialFailed(MoPubErrorCode.NO_FILL);
                return;
            }
            this.a = new TappxInterstitial(context, string);
            this.a.setListener(new TappxInterstitialListener(customEventInterstitialListener){
                private final CustomEventInterstitial.CustomEventInterstitialListener a;
                {
                    this.a = customEventInterstitialListener;
                }

                @Override
                public void onInterstitialClicked(TappxInterstitial tappxInterstitial) {
                    this.a.onInterstitialClicked();
                }

                @Override
                public void onInterstitialDismissed(TappxInterstitial tappxInterstitial) {
                    this.a.onInterstitialDismissed();
                }

                @Override
                public void onInterstitialLoadFailed(TappxInterstitial tappxInterstitial, TappxAdError tappxAdError) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("MoPub adapter: Interstitial load failed ");
                    stringBuilder.append((Object)tappxAdError);
                    Log.v((String)"Tappx", (String)stringBuilder.toString());
                    this.a.onInterstitialFailed(MopubInterstitialAdapter.b(tappxAdError));
                }

                @Override
                public void onInterstitialLoaded(TappxInterstitial tappxInterstitial) {
                    Log.v((String)"Tappx", (String)"MoPub adapter: Interstitial loaded");
                    this.a.onInterstitialLoaded();
                }

                @Override
                public void onInterstitialShown(TappxInterstitial tappxInterstitial) {
                    this.a.onInterstitialShown();
                }
            });
            AdRequest adRequest = new AdRequest().mediator("mopub");
            this.a.loadAd(adRequest);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Loading ");
            stringBuilder.append(this.getClass().getSimpleName());
            Log.v((String)"Tappx", (String)stringBuilder.toString());
            return;
        }
        Log.e((String)"Tappx", (String)"MoPub adapter: invalid app key as server parameter");
        customEventInterstitialListener.onInterstitialFailed(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
    }

    protected void onInvalidate() {
        TappxInterstitial tappxInterstitial = this.a;
        if (tappxInterstitial != null) {
            tappxInterstitial.destroy();
            this.a.setListener(null);
            this.a = null;
        }
    }

    protected void showInterstitial() {
        TappxInterstitial tappxInterstitial = this.a;
        if (tappxInterstitial != null) {
            tappxInterstitial.show();
        }
    }

}

