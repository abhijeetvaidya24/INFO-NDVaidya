/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.ads.mediation.NetworkExtras
 *  com.google.android.gms.ads.mediation.customevent.CustomEventExtras
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.startapp.android.mediation.admob;

import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;
import com.startapp.android.mediation.admob.StartAppBannerExtras;
import com.startapp.android.mediation.admob.StartAppExtras;

public class StartAppBannerExtras
extends StartAppExtras {
    private BannerMode bannerMode;

    private StartAppBannerExtras() {
    }

    public BannerMode getBannerMode() {
        return this.bannerMode;
    }

    public StartAppExtras setBannerMode(BannerMode bannerMode) {
        this.bannerMode = bannerMode;
        return this;
    }

}

