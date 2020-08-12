/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.Set
 */
package org.altbeacon.beacon.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.altbeacon.beacon.Beacon;
import org.altbeacon.beacon.logging.LogManager;
import org.altbeacon.beacon.service.Callback;
import org.altbeacon.beacon.service.RangedBeacon;

public class RangeState
implements Serializable {
    private static boolean sUseTrackingCache;
    private Callback mCallback;
    private Map<Beacon, RangedBeacon> mRangedBeacons = new HashMap();

    public RangeState(Callback callback) {
        this.mCallback = callback;
    }

    public static boolean getUseTrackingCache() {
        return sUseTrackingCache;
    }

    public static void setUseTrackingCache(boolean bl2) {
        sUseTrackingCache = bl2;
    }

    public void addBeacon(Beacon beacon) {
        if (this.mRangedBeacons.containsKey((Object)beacon)) {
            RangedBeacon rangedBeacon = (RangedBeacon)this.mRangedBeacons.get((Object)beacon);
            if (LogManager.isVerboseLoggingEnabled()) {
                LogManager.d("RangeState", "adding %s to existing range for: %s", beacon, rangedBeacon);
            }
            rangedBeacon.updateBeacon(beacon);
            return;
        }
        if (LogManager.isVerboseLoggingEnabled()) {
            LogManager.d("RangeState", "adding %s to new rangedBeacon", beacon);
        }
        this.mRangedBeacons.put((Object)beacon, (Object)new RangedBeacon(beacon));
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Collection<Beacon> finalizeBeacons() {
        var11_1 = this;
        synchronized (var11_1) {
            var1_2 = new HashMap();
            var2_3 = new ArrayList();
            var12_5 = var4_4 = this.mRangedBeacons;
            ** synchronized (var12_5)
            {
lbl11: // 1 sources:
                var6_6 = this.mRangedBeacons.keySet().iterator();
                do {
                    if (!var6_6.hasNext()) {
                        this.mRangedBeacons = var1_2;
                        return var2_3;
                    }
                    var7_7 = (Beacon)var6_6.next();
                    var8_8 = (RangedBeacon)this.mRangedBeacons.get((Object)var7_7);
                    if (var8_8.isTracked()) {
                        var8_8.commitMeasurements();
                        if (!var8_8.noMeasurementsAvailable()) {
                            var2_3.add((Object)var8_8.getBeacon());
                        }
                    }
                    if (true ^ var8_8.noMeasurementsAvailable()) {
                        if (!RangeState.sUseTrackingCache || var8_8.isExpired()) {
                            var8_8.setTracked(false);
                        }
                        var1_2.put((Object)var7_7, (Object)var8_8);
                        continue;
                    }
                    LogManager.d("RangeState", "Dumping beacon from RangeState because it has no recent measurements.", new Object[0]);
                } while (true);
            }
        }
    }

    public Callback getCallback() {
        return this.mCallback;
    }
}

