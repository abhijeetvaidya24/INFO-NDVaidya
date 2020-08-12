/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  java.io.Serializable
 *  java.lang.ClassLoader
 *  java.lang.Object
 *  java.lang.String
 */
package org.altbeacon.beacon.service;

import android.os.Bundle;
import java.io.Serializable;
import org.altbeacon.beacon.Region;

public class MonitoringData {
    private final boolean mInside;
    private final Region mRegion;

    public MonitoringData(boolean bl2, Region region) {
        this.mInside = bl2;
        this.mRegion = region;
    }

    public static MonitoringData fromBundle(Bundle bundle) {
        bundle.setClassLoader(Region.class.getClassLoader());
        Region region = bundle.get("region") != null ? (Region)bundle.getSerializable("region") : null;
        return new MonitoringData(bundle.getBoolean("inside"), region);
    }

    public Region getRegion() {
        return this.mRegion;
    }

    public boolean isInside() {
        return this.mInside;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putSerializable("region", (Serializable)this.mRegion);
        bundle.putBoolean("inside", this.mInside);
        return bundle;
    }
}

