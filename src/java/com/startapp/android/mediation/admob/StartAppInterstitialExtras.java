/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.ads.mediation.NetworkExtras
 *  com.google.android.gms.ads.mediation.customevent.CustomEventExtras
 *  java.lang.Object
 *  java.lang.String
 */
package com.startapp.android.mediation.admob;

import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;
import com.startapp.android.mediation.admob.StartAppExtras;
import com.startapp.android.mediation.admob.StartAppInterstitialExtras;
import com.startapp.android.publish.adsCommon.StartAppAd;

public class StartAppInterstitialExtras
extends StartAppExtras {
    private StartAppAd.AdMode adMode;

    private StartAppInterstitialExtras() {
    }

    public StartAppAd.AdMode getAdMode() {
        return this.adMode;
    }

    public StartAppExtras setAdMode(StartAppAd.AdMode adMode) {
        this.adMode = adMode;
        return this;
    }

}

