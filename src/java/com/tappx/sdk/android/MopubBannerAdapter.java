/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Log
 *  android.view.View
 *  com.mopub.mobileads.CustomEventBanner
 *  com.mopub.mobileads.CustomEventBanner$CustomEventBannerListener
 *  com.mopub.mobileads.MoPubErrorCode
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Map
 */
package com.tappx.sdk.android;

import android.content.Context;
import android.util.Log;
import android.view.View;
import com.mopub.mobileads.CustomEventBanner;
import com.mopub.mobileads.MoPubErrorCode;
import com.tappx.sdk.android.AdRequest;
import com.tappx.sdk.android.MopubBannerAdapter;
import com.tappx.sdk.android.TappxAdError;
import com.tappx.sdk.android.TappxBanner;
import com.tappx.sdk.android.TappxBannerListener;
import java.util.Map;

class MopubBannerAdapter
extends CustomEventBanner {
    private TappxBanner a;

    MopubBannerAdapter() {
    }

    private int a(Map<String, String> map, String string, int n2) {
        try {
            int n3 = Integer.parseInt((String)((String)map.get((Object)string)));
            return n3;
        }
        catch (NumberFormatException numberFormatException) {
            return n2;
        }
    }

    private TappxBanner.AdSize a(int n2, int n3) {
        if (n2 <= TappxBanner.AdSize.BANNER_320x50.getWidth() && n3 <= TappxBanner.AdSize.BANNER_320x50.getHeight()) {
            return TappxBanner.AdSize.BANNER_320x50;
        }
        if (n2 <= TappxBanner.AdSize.BANNER_300x250.getWidth() && n3 <= TappxBanner.AdSize.BANNER_300x250.getHeight()) {
            return TappxBanner.AdSize.BANNER_300x250;
        }
        if (n2 <= TappxBanner.AdSize.BANNER_728x90.getWidth() && n3 <= TappxBanner.AdSize.BANNER_728x90.getHeight()) {
            return TappxBanner.AdSize.BANNER_728x90;
        }
        return TappxBanner.AdSize.SMART_BANNER;
    }

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

    protected void loadBanner(Context context, CustomEventBanner.CustomEventBannerListener customEventBannerListener, Map<String, Object> map, Map<String, String> map2) {
        String string = (String)map2.get((Object)"appKey");
        int n2 = this.a(map2, "adWidth", -1);
        int n3 = this.a(map2, "adHeight", -1);
        if (string != null && !string.isEmpty()) {
            TappxBanner.AdSize adSize = this.a(n2, n3);
            this.a = new TappxBanner(context, string);
            this.a.setListener(new a(customEventBannerListener));
            this.a.setAdSize(adSize);
            AdRequest adRequest = new AdRequest().mediator("mopub");
            this.a.loadAd(adRequest);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Loading ");
            stringBuilder.append(this.getClass().getSimpleName());
            Log.v((String)"Tappx", (String)stringBuilder.toString());
            return;
        }
        Log.e((String)"Tappx", (String)"MoPub adapter: invalid app key as server parameter");
        customEventBannerListener.onBannerFailed(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
    }

    protected void onInvalidate() {
        TappxBanner tappxBanner = this.a;
        if (tappxBanner != null) {
            tappxBanner.setListener(null);
            this.a.destroy();
        }
    }

    private static final class a
    implements TappxBannerListener {
        private final CustomEventBanner.CustomEventBannerListener a;

        private a(CustomEventBanner.CustomEventBannerListener customEventBannerListener) {
            this.a = customEventBannerListener;
        }

        @Override
        public void onBannerClicked(TappxBanner tappxBanner) {
            this.a.onBannerClicked();
        }

        @Override
        public void onBannerCollapsed(TappxBanner tappxBanner) {
            this.a.onBannerCollapsed();
        }

        @Override
        public void onBannerExpanded(TappxBanner tappxBanner) {
            this.a.onBannerExpanded();
        }

        @Override
        public void onBannerLoadFailed(TappxBanner tappxBanner, TappxAdError tappxAdError) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("MoPub adapter: Banner load failed ");
            stringBuilder.append((Object)tappxAdError);
            Log.v((String)"Tappx", (String)stringBuilder.toString());
            this.a.onBannerFailed(MopubBannerAdapter.b(tappxAdError));
        }

        @Override
        public void onBannerLoaded(TappxBanner tappxBanner) {
            Log.v((String)"Tappx", (String)"MoPub adapter: Banner loaded");
            this.a.onBannerLoaded((View)tappxBanner);
        }
    }

}

