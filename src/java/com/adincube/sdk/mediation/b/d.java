/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.location.Location
 *  com.adcolony.sdk.AdColony
 *  com.adcolony.sdk.AdColonyAppOptions
 *  com.adcolony.sdk.AdColonyUserMetadata
 *  com.adincube.sdk.h.g
 */
package com.adincube.sdk.mediation.b;

import android.content.Context;
import android.location.Location;
import com.adcolony.sdk.AdColony;
import com.adcolony.sdk.AdColonyAppOptions;
import com.adcolony.sdk.AdColonyUserMetadata;
import com.adincube.sdk.h.g;
import com.adincube.sdk.mediation.h;

public final class d
extends h {
    private AdColonyUserMetadata a = null;

    @Override
    public final void a(Context context, g g2) {
        AdColonyUserMetadata adColonyUserMetadata = AdColony.getAppOptions() != null ? AdColony.getAppOptions().getUserMetadata() : null;
        if (adColonyUserMetadata == null) {
            adColonyUserMetadata = new AdColonyUserMetadata();
        }
        this.a = adColonyUserMetadata;
        super.a(context, g2);
        AdColony.getAppOptions().setUserMetadata(this.a);
    }

    @Override
    public final void a(Location location) {
        this.a.setUserLocation(location);
    }
}

