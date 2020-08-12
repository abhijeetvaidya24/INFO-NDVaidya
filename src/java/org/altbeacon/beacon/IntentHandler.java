/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.Set
 */
package org.altbeacon.beacon;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.altbeacon.beacon.Beacon;
import org.altbeacon.beacon.BeaconManager;
import org.altbeacon.beacon.MonitorNotifier;
import org.altbeacon.beacon.RangeNotifier;
import org.altbeacon.beacon.Region;
import org.altbeacon.beacon.logging.LogManager;
import org.altbeacon.beacon.service.MonitoringData;
import org.altbeacon.beacon.service.MonitoringStatus;
import org.altbeacon.beacon.service.RangingData;

class IntentHandler {
    private static final String TAG = "IntentHandler";

    IntentHandler() {
    }

    public void convertIntentsToCallbacks(Context context, Intent intent) {
        MonitoringData monitoringData;
        RangingData rangingData = null;
        if (intent != null && intent.getExtras() != null) {
            monitoringData = intent.getExtras().getBundle("monitoringData") != null ? MonitoringData.fromBundle(intent.getExtras().getBundle("monitoringData")) : null;
            Bundle bundle = intent.getExtras().getBundle("rangingData");
            rangingData = null;
            if (bundle != null) {
                rangingData = RangingData.fromBundle(intent.getExtras().getBundle("rangingData"));
            }
        } else {
            monitoringData = null;
        }
        if (rangingData != null) {
            RangeNotifier rangeNotifier;
            LogManager.d(TAG, "got ranging data", new Object[0]);
            if (rangingData.getBeacons() == null) {
                LogManager.w(TAG, "Ranging data has a null beacons collection", new Object[0]);
            }
            Set<RangeNotifier> set = BeaconManager.getInstanceForApplication(context).getRangingNotifiers();
            Collection<Beacon> collection = rangingData.getBeacons();
            if (set != null) {
                Iterator iterator = set.iterator();
                while (iterator.hasNext()) {
                    ((RangeNotifier)iterator.next()).didRangeBeaconsInRegion(collection, rangingData.getRegion());
                }
            } else {
                LogManager.d(TAG, "but ranging notifier is null, so we're dropping it.", new Object[0]);
            }
            if ((rangeNotifier = BeaconManager.getInstanceForApplication(context).getDataRequestNotifier()) != null) {
                rangeNotifier.didRangeBeaconsInRegion(collection, rangingData.getRegion());
            }
        }
        if (monitoringData != null) {
            LogManager.d(TAG, "got monitoring data", new Object[0]);
            Set<MonitorNotifier> set = BeaconManager.getInstanceForApplication(context).getMonitoringNotifiers();
            if (set != null) {
                for (MonitorNotifier monitorNotifier : set) {
                    LogManager.d(TAG, "Calling monitoring notifier: %s", monitorNotifier);
                    Region region = monitoringData.getRegion();
                    Integer n2 = (int)monitoringData.isInside();
                    monitorNotifier.didDetermineStateForRegion(n2, region);
                    MonitoringStatus.getInstanceForApplication(context).updateLocalState(region, n2);
                    if (monitoringData.isInside()) {
                        monitorNotifier.didEnterRegion(monitoringData.getRegion());
                        continue;
                    }
                    monitorNotifier.didExitRegion(monitoringData.getRegion());
                }
            }
        }
    }
}

