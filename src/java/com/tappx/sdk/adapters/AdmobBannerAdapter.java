/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.util.Log
 *  android.view.View
 *  com.google.android.gms.ads.AdSize
 *  com.google.android.gms.ads.mediation.MediationAdRequest
 *  com.google.android.gms.ads.mediation.customevent.CustomEventBanner
 *  com.google.android.gms.ads.mediation.customevent.CustomEventBannerListener
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
import android.view.View;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.customevent.CustomEventBanner;
import com.google.android.gms.ads.mediation.customevent.CustomEventBannerListener;
import com.tappx.sdk.adapters.AdmobBannerAdapter;
import com.tappx.sdk.android.AdRequest;
import com.tappx.sdk.android.TappxAdError;
import com.tappx.sdk.android.TappxBanner;
import com.tappx.sdk.android.TappxBannerListener;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

public class AdmobBannerAdapter
implements CustomEventBanner {
    private static final String TEST_REQUEST_SUFIX = "|1";
    private TappxBanner banner;

    private TappxBanner.AdSize convertAdSize(AdSize adSize) {
        if (AdSize.BANNER.equals((Object)adSize)) {
            return TappxBanner.AdSize.BANNER_320x50;
        }
        if (AdSize.MEDIUM_RECTANGLE.equals((Object)adSize)) {
            return TappxBanner.AdSize.BANNER_300x250;
        }
        if (AdSize.LEADERBOARD.equals((Object)adSize)) {
            return TappxBanner.AdSize.BANNER_728x90;
        }
        return TappxBanner.AdSize.SMART_BANNER;
    }

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
        TappxBanner tappxBanner = this.banner;
        if (tappxBanner != null) {
            tappxBanner.setListener(null);
            this.banner.destroy();
            this.banner = null;
        }
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void requestBannerAd(Context context, CustomEventBannerListener customEventBannerListener, String string, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle bundle) {
        if (string != null && !string.isEmpty()) {
            AdRequest adRequest = new AdRequest();
            if (string.endsWith(TEST_REQUEST_SUFIX)) {
                string = string.substring(0, -2 + string.length());
                adRequest.useTestAds(true);
            }
            this.banner = new TappxBanner(context, string);
            TappxBanner.AdSize adSize2 = this.convertAdSize(adSize);
            this.banner.setAdSize(adSize2);
            this.banner.setListener(new TappxBannerListener(customEventBannerListener){
                final CustomEventBannerListener admobListener;
                {
                    this.admobListener = customEventBannerListener;
                }

                @Override
                public void onBannerClicked(TappxBanner tappxBanner) {
                    this.admobListener.onAdClicked();
                }

                @Override
                public void onBannerCollapsed(TappxBanner tappxBanner) {
                    this.admobListener.onAdClosed();
                }

                @Override
                public void onBannerExpanded(TappxBanner tappxBanner) {
                    this.admobListener.onAdOpened();
                }

                @Override
                public void onBannerLoadFailed(TappxBanner tappxBanner, TappxAdError tappxAdError) {
                    this.admobListener.onAdFailedToLoad(AdmobBannerAdapter.convertToAdmobReason(tappxAdError));
                }

                @Override
                public void onBannerLoaded(TappxBanner tappxBanner) {
                    Log.v((String)"Tappx", (String)"Admob adapter: banner loaded");
                    this.admobListener.onAdLoaded((View)tappxBanner);
                }
            });
            adRequest.mediator("admob");
            if (mediationAdRequest != null) {
                adRequest.keywords(this.getKeywords(mediationAdRequest));
                adRequest.gender(this.getGender(mediationAdRequest));
                this.setAge(adRequest, mediationAdRequest);
            }
            this.banner.setEnableAutoRefresh(false);
            this.banner.loadAd(adRequest);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Loading ");
            stringBuilder.append(this.getClass().getSimpleName());
            Log.v((String)"Tappx", (String)stringBuilder.toString());
            return;
        }
        Log.e((String)"Tappx", (String)"Admob adapter: invalid app key as server parameter");
        customEventBannerListener.onAdFailedToLoad(0);
    }

}

