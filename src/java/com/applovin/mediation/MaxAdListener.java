/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.applovin.mediation;

import com.applovin.mediation.MaxAd;

public interface MaxAdListener {
    public void onAdClicked(MaxAd var1);

    public void onAdDisplayFailed(MaxAd var1, int var2);

    public void onAdDisplayed(MaxAd var1);

    public void onAdHidden(MaxAd var1);

    public void onAdLoadFailed(String var1, int var2);

    public void onAdLoaded(MaxAd var1);
}

