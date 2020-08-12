/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  com.aerserv.sdk.model.ad.HTMLProviderAd
 *  com.aerserv.sdk.model.ad.MraidProviderAd
 *  com.aerserv.sdk.model.ad.ThirdPartyProviderAd
 *  com.aerserv.sdk.model.ad.VASTProviderAd
 *  com.aerserv.sdk.model.ad.VideoWithEndCardProviderAd
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.aerserv.sdk.factory;

import android.text.TextUtils;
import com.aerserv.sdk.controller.listener.AdFactoryListener;
import com.aerserv.sdk.model.Placement;
import com.aerserv.sdk.model.ad.AdType;
import com.aerserv.sdk.model.ad.HTMLProviderAd;
import com.aerserv.sdk.model.ad.MraidProviderAd;
import com.aerserv.sdk.model.ad.ProviderAd;
import com.aerserv.sdk.model.ad.ThirdPartyProviderAd;
import com.aerserv.sdk.model.ad.VASTProviderAd;
import com.aerserv.sdk.model.ad.VideoWithEndCardProviderAd;
import com.aerserv.sdk.utils.AerServLog;
import com.aerserv.sdk.utils.VersionUtils;

public class AdFactory {
    private static final String LOG_TAG = "AdFactory";

    private AdFactory() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void buildAd(Placement placement, AdFactoryListener adFactoryListener) {
        try {
            AdType adType = AdFactory.detectAdType(placement);
            if (adType == null) {
                adFactoryListener.adBuildFailed("Could not determine ad type");
                return;
            }
            if (adType == AdType.MRAID && !VersionUtils.checkVersion(19)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Cannot display MRAID ad.  MRAID requires at least API version of ");
                stringBuilder.append(19);
                String string = stringBuilder.toString();
                AerServLog.i(LOG_TAG, string);
                adFactoryListener.adBuildFailed(string);
            }
            if (placement.getAdMarkup().isEmpty()) {
                adFactoryListener.adBuildFailed("Empty markup returned");
                return;
            }
            int n2 = 1.$SwitchMap$com$aerserv$sdk$model$ad$AdType[adType.ordinal()];
            if (n2 == 1) {
                adFactoryListener.adBuildSucceeded((ProviderAd)new HTMLProviderAd(placement));
                return;
            }
            if (n2 == 2) {
                adFactoryListener.adBuildSucceeded((ProviderAd)new MraidProviderAd(placement));
                return;
            }
            if (n2 == 3) {
                VASTProviderAd.buildVASTAd((Placement)placement, (AdFactoryListener)adFactoryListener);
                return;
            }
            if (n2 == 4) {
                adFactoryListener.adBuildSucceeded((ProviderAd)new ThirdPartyProviderAd(placement));
                return;
            }
            if (n2 == 5) {
                adFactoryListener.adBuildSucceeded((ProviderAd)new VideoWithEndCardProviderAd(placement));
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("detectAdType returned unknown type ");
            stringBuilder.append((Object)adType);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        catch (Exception exception) {
            AerServLog.d(LOG_TAG, "AdFactory failed to build ad", exception);
            adFactoryListener.adBuildFailed(exception.getMessage());
            return;
        }
    }

    public static MraidProviderAd buildExpandedMraidProviderAd(Placement placement) {
        return new MraidProviderAd(placement, AdType.EXPANDED_MRAID);
    }

    public static MraidProviderAd buildVideoMraidProviderAd(Placement placement) {
        return new MraidProviderAd(placement, AdType.VIDEO);
    }

    private static AdType detectAdType(Placement placement) {
        String string = placement.getContentType();
        String string2 = placement.getAdMarkup();
        AdType adType = !TextUtils.isEmpty((CharSequence)placement.getEndCardMarkup()) ? AdType.VIDEO_WITH_END_CARD : (string.contains((CharSequence)"json") ? AdType.THIRD_PARTY : (string.contains((CharSequence)"xml") ? AdType.VAST : (string.contains((CharSequence)"html") ? (string2.contains((CharSequence)"mraid.js") ? AdType.MRAID : AdType.HTML) : null)));
        String string3 = LOG_TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Ad type determined to be ");
        stringBuilder.append((Object)adType);
        AerServLog.d(string3, stringBuilder.toString());
        return adType;
    }

}

