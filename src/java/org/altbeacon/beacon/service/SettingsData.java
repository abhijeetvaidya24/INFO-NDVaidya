/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  java.io.Serializable
 *  java.lang.Boolean
 *  java.lang.ClassLoader
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 */
package org.altbeacon.beacon.service;

import android.content.Context;
import android.os.Bundle;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.altbeacon.beacon.Beacon;
import org.altbeacon.beacon.BeaconManager;
import org.altbeacon.beacon.BeaconParser;
import org.altbeacon.beacon.Region;
import org.altbeacon.beacon.logging.LogManager;
import org.altbeacon.beacon.service.BeaconService;
import org.altbeacon.beacon.service.MonitoringStatus;
import org.altbeacon.beacon.service.RangeState;

public class SettingsData
implements Serializable {
    private static final String TAG = "SettingsData";
    Boolean mAndroidLScanningDisabled;
    ArrayList<BeaconParser> mBeaconParsers;
    Boolean mHardwareEqualityEnforced;
    Long mRegionExitPeriod;
    Boolean mRegionStatePersistenceEnabled;
    Boolean mUseTrackingCache;

    public static SettingsData fromBundle(Bundle bundle) {
        bundle.setClassLoader(Region.class.getClassLoader());
        if (bundle.get(TAG) != null) {
            return (SettingsData)bundle.getSerializable(TAG);
        }
        return null;
    }

    public void apply(BeaconService beaconService) {
        boolean bl2;
        BeaconManager beaconManager;
        block8 : {
            LogManager.d(TAG, "Applying settings changes to scanner in other process", new Object[0]);
            beaconManager = BeaconManager.getInstanceForApplication((Context)beaconService);
            List<BeaconParser> list = beaconManager.getBeaconParsers();
            int n2 = list.size();
            int n3 = this.mBeaconParsers.size();
            bl2 = true;
            if (n2 == n3) {
                for (int i2 = 0; i2 < list.size(); ++i2) {
                    if (((BeaconParser)list.get(i2)).equals(this.mBeaconParsers.get(i2))) continue;
                    String string = TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Beacon parsers have changed to: ");
                    stringBuilder.append(((BeaconParser)this.mBeaconParsers.get(i2)).getLayout());
                    LogManager.d(string, stringBuilder.toString(), new Object[0]);
                    break block8;
                }
                bl2 = false;
            } else {
                LogManager.d(TAG, "Beacon parsers have been added or removed.", new Object[0]);
            }
        }
        if (bl2) {
            LogManager.d(TAG, "Updating beacon parsers", new Object[0]);
            beaconManager.getBeaconParsers().clear();
            beaconManager.getBeaconParsers().addAll(this.mBeaconParsers);
            beaconService.reloadParsers();
        } else {
            LogManager.d(TAG, "Beacon parsers unchanged.", new Object[0]);
        }
        MonitoringStatus monitoringStatus = MonitoringStatus.getInstanceForApplication((Context)beaconService);
        if (monitoringStatus.isStatePreservationOn() && !this.mRegionStatePersistenceEnabled.booleanValue()) {
            monitoringStatus.stopStatusPreservation();
        } else if (!monitoringStatus.isStatePreservationOn() && this.mRegionStatePersistenceEnabled.booleanValue()) {
            monitoringStatus.startStatusPreservation();
        }
        BeaconManager.setAndroidLScanningDisabled(this.mAndroidLScanningDisabled);
        BeaconManager.setRegionExitPeriod(this.mRegionExitPeriod);
        RangeState.setUseTrackingCache(this.mUseTrackingCache);
        Beacon.setHardwareEqualityEnforced(this.mHardwareEqualityEnforced);
    }

    public SettingsData collect(Context context) {
        BeaconManager beaconManager = BeaconManager.getInstanceForApplication(context);
        this.mBeaconParsers = new ArrayList(beaconManager.getBeaconParsers());
        this.mRegionStatePersistenceEnabled = beaconManager.isRegionStatePersistenceEnabled();
        this.mAndroidLScanningDisabled = BeaconManager.isAndroidLScanningDisabled();
        this.mRegionExitPeriod = BeaconManager.getRegionExitPeriod();
        this.mUseTrackingCache = RangeState.getUseTrackingCache();
        this.mHardwareEqualityEnforced = Beacon.getHardwareEqualityEnforced();
        return this;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putSerializable(TAG, (Serializable)this);
        return bundle;
    }
}

