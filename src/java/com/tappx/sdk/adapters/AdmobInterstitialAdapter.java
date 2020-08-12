/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.util.Log
 *  com.google.android.gms.ads.mediation.MediationAdRequest
 *  com.google.android.gms.ads.mediation.customevent.CustomEventInterstitial
 *  com.google.android.gms.ads.mediation.customevent.CustomEventInterstitialListener
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Calendar
 *  java.util.Date
 *  java.util.Set
 */
package com.tappx.sdk.adapters;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.customevent.CustomEventInterstitial;
import com.google.android.gms.ads.mediation.customevent.CustomEventInterstitialListener;
import com.tappx.sdk.adapters.AdmobInterstitialAdapter;
import com.tappx.sdk.android.AdRequest;
import com.tappx.sdk.android.TappxAdError;
import com.tappx.sdk.android.TappxInterstitial;
import com.tappx.sdk.android.TappxInterstitialListener;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

public class AdmobInterstitialAdapter
implements CustomEventInterstitial {
    private static final String TEST_REQUEST_SUFIX = "|1";
    private TappxInterstitial interstitial;

    private static int convertToAdmobReason(TappxAdError tappxAdError) {
        int n2 = 1.$SwitchMap$com$tappx$sdk$android$TappxAdError[tappxAdError.ordinal()];
        if (n2 != 1) {
            if (n2 != 2) {
                return 3;
            }
            return 0;
        }
        return 2;
    }

    private AdRequest.Gender getGender(MediationAdRequest mediationAdRequest) {
        int n2 = mediationAdRequest.getGender();
        if (n2 != 1) {
            if (n2 != 2) {
                return AdRequest.Gender.UNKNOWN;
            }
            return AdRequest.Gender.FEMALE;
        }
        return AdRequest.Gender.MALE;
    }

    private String getKeywords(MediationAdRequest mediationAdRequest) {
        Set set = mediationAdRequest.getKeywords();
        if (set != null && !set.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String string : set) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append(',');
                }
                stringBuilder.append(string);
            }
            return stringBuilder.toString();
        }
        return null;
    }

    private void setAge(AdRequest adRequest, MediationAdRequest mediationAdRequest) {
        Date date = mediationAdRequest.getBirthday();
        if (date == null) {
            return;
        }
        int n2 = Calendar.getInstance().get(1);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int n3 = calendar.get(1);
        int n4 = n2 - n3;
        if (n4 >= 0 && n4 < 120) {
            adRequest.age(n3);
        }
        adRequest.yearOfBirth(n3);
    }

    public void onDestroy() {
        TappxInterstitial tappxInterstitial = this.interstitial;
        if (tappxInterstitial != null) {
            tappxInterstitial.destroy();
            this.interstitial.setListener(null);
            this.interstitial = null;
        }
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void requestInterstitialAd(Context context, CustomEventInterstitialListener customEventInterstitialListener, String string, MediationAdRequest mediationAdRequest, Bundle bundle) {
        if (string != null && !string.isEmpty()) {
            AdRequest adRequest = new AdRequest().mediator("admob");
            if (string.endsWith(TEST_REQUEST_SUFIX)) {
                string = string.substring(0, -2 + string.length());
                adRequest.useTestAds(true);
            }
            this.interstitial = new TappxInterstitial(context, string);
            this.interstitial.setListener(new TappxInterstitialListener(customEventInterstitialListener){
                final CustomEventInterstitialListener admobListener;
                {
                    this.admobListener = customEventInterstitialListener;
                }

                @Override
                public void onInterstitialClicked(TappxInterstitial tappxInterstitial) {
                    this.admobListener.onAdClicked();
                }

                @Override
                public void onInterstitialDismissed(TappxInterstitial tappxInterstitial) {
                    this.admobListener.onAdClosed();
                }

                @Override
                public void onInterstitialLoadFailed(TappxInterstitial tappxInterstitial, TappxAdError tappxAdError) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Admob adapter: Interstitial load failed ");
                    stringBuilder.append((Object)tappxAdError);
                    Log.d((String)"Tappx", (String)stringBuilder.toString());
                    this.admobListener.onAdFailedToLoad(AdmobInterstitialAdapter.convertToAdmobReason(tappxAdError));
                }

                @Override
                public void onInterstitialLoaded(TappxInterstitial tappxInterstitial) {
                    Log.d((String)"Tappx", (String)"Admob adapter: Interstitial loaded");
                    this.admobListener.onAdLoaded();
                }

                @Override
                public void onInterstitialShown(TappxInterstitial tappxInterstitial) {
                    this.admobListener.onAdOpened();
                }
            });
            if (mediationAdRequest != null) {
                adRequest.keywords(this.getKeywords(mediationAdRequest));
                adRequest.gender(this.getGender(mediationAdRequest));
                this.setAge(adRequest, mediationAdRequest);
            }
            this.interstitial.loadAd(adRequest);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Loading ");
            stringBuilder.append(this.getClass().getSimpleName());
            Log.e((String)"Tappx", (String)stringBuilder.toString());
            return;
        }
        Log.e((String)"Tappx", (String)"Admob adapter: invalid app key as server parameter");
        customEventInterstitialListener.onAdFailedToLoad(0);
    }

    public void showInterstitial() {
        TappxInterstitial tappxInterstitial = this.interstitial;
        if (tappxInterstitial != null) {
            tappxInterstitial.show();
        }
    }

}

