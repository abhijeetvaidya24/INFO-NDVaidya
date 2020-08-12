/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 */
package org.altbeacon.beacon.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.altbeacon.beacon.Beacon;

public class ExtraDataBeaconTracker
implements Serializable {
    private final HashMap<String, HashMap<Integer, Beacon>> mBeaconsByKey = new HashMap();
    private final boolean matchBeaconsByServiceUUID;

    public ExtraDataBeaconTracker() {
        this(true);
    }

    public ExtraDataBeaconTracker(boolean bl2) {
        this.matchBeaconsByServiceUUID = bl2;
    }

    private String getBeaconKey(Beacon beacon) {
        if (this.matchBeaconsByServiceUUID) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(beacon.getBluetoothAddress());
            stringBuilder.append(beacon.getServiceUuid());
            return stringBuilder.toString();
        }
        return beacon.getBluetoothAddress();
    }

    private Beacon trackGattBeacon(Beacon beacon) {
        if (beacon.isExtraBeaconData()) {
            this.updateTrackedBeacons(beacon);
            return null;
        }
        String string = this.getBeaconKey(beacon);
        HashMap hashMap = (HashMap)this.mBeaconsByKey.get((Object)string);
        if (hashMap == null) {
            hashMap = new HashMap();
        } else {
            beacon.setExtraDataFields(((Beacon)hashMap.values().iterator().next()).getExtraDataFields());
        }
        hashMap.put((Object)beacon.hashCode(), (Object)beacon);
        this.mBeaconsByKey.put((Object)string, (Object)hashMap);
        return beacon;
    }

    private void updateTrackedBeacons(Beacon beacon) {
        HashMap hashMap = (HashMap)this.mBeaconsByKey.get((Object)this.getBeaconKey(beacon));
        if (hashMap != null) {
            for (Beacon beacon2 : hashMap.values()) {
                beacon2.setRssi(beacon.getRssi());
                beacon2.setExtraDataFields(beacon.getDataFields());
            }
        }
    }

    public Beacon track(Beacon beacon) {
        ExtraDataBeaconTracker extraDataBeaconTracker = this;
        synchronized (extraDataBeaconTracker) {
            if (beacon.isMultiFrameBeacon() || beacon.getServiceUuid() != -1) {
                beacon = this.trackGattBeacon(beacon);
            }
            return beacon;
        }
    }
}

