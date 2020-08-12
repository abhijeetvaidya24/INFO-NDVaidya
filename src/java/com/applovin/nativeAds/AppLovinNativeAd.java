/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Deprecated
 *  java.lang.Object
 *  java.lang.String
 */
package com.applovin.nativeAds;

import android.content.Context;
import com.applovin.sdk.AppLovinPostbackListener;

public interface AppLovinNativeAd {
    public long getAdId();

    public String getCaptionText();

    @Deprecated
    public String getClickUrl();

    public String getCtaText();

    public String getDescriptionText();

    public String getIconUrl();

    public String getImageUrl();

    public String getImpressionTrackingUrl();

    public float getStarRating();

    public String getTitle();

    public String getVideoEndTrackingUrl(int var1, boolean var2);

    public String getVideoStartTrackingUrl();

    public String getVideoUrl();

    public String getZoneId();

    public boolean isImagePrecached();

    public boolean isVideoPrecached();

    public void launchClickTarget(Context var1);

    public void trackImpression();

    public void trackImpression(AppLovinPostbackListener var1);
}

