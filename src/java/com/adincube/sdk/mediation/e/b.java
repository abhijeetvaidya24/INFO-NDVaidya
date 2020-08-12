/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.adincube.sdk.mediation.e.g
 *  com.amazon.device.ads.AdTargetingOptions
 *  java.lang.Long
 *  java.lang.Object
 */
package com.adincube.sdk.mediation.e;

import com.adincube.sdk.mediation.e.g;
import com.amazon.device.ads.AdTargetingOptions;

public final class b {
    public static AdTargetingOptions a(g g2) {
        AdTargetingOptions adTargetingOptions = new AdTargetingOptions();
        if (g2.d() != null) {
            adTargetingOptions.setFloorPrice(g2.d().longValue());
        }
        return adTargetingOptions;
    }
}

