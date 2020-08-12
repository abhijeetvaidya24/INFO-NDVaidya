/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  java.io.Serializable
 *  java.lang.ClassLoader
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Iterator
 */
package org.altbeacon.beacon.service;

import android.os.Bundle;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.altbeacon.beacon.Beacon;
import org.altbeacon.beacon.Region;

public class RangingData {
    private final Collection<Beacon> mBeacons;
    private final Region mRegion;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public RangingData(Collection<Beacon> collection, Region region) {
        Collection<Beacon> collection2 = collection;
        synchronized (collection2) {
            this.mBeacons = collection;
        }
        this.mRegion = region;
    }

    public static RangingData fromBundle(Bundle bundle) {
        bundle.setClassLoader(Region.class.getClassLoader());
        Collection collection = bundle.get("beacons") != null ? (Collection)bundle.getSerializable("beacons") : null;
        Object object = bundle.get("region");
        Region region = null;
        if (object != null) {
            region = (Region)bundle.getSerializable("region");
        }
        return new RangingData((Collection<Beacon>)collection, region);
    }

    public Collection<Beacon> getBeacons() {
        return this.mBeacons;
    }

    public Region getRegion() {
        return this.mRegion;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putSerializable("region", (Serializable)this.mRegion);
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.mBeacons.iterator();
        while (iterator.hasNext()) {
            arrayList.add((Object)((Beacon)iterator.next()));
        }
        bundle.putSerializable("beacons", (Serializable)arrayList);
        return bundle;
    }
}

