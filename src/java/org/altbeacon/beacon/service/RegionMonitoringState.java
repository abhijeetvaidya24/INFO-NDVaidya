/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.SystemClock
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 */
package org.altbeacon.beacon.service;

import android.os.SystemClock;
import java.io.Serializable;
import org.altbeacon.beacon.BeaconManager;
import org.altbeacon.beacon.logging.LogManager;
import org.altbeacon.beacon.service.Callback;

public class RegionMonitoringState
implements Serializable {
    private static final String TAG = "RegionMonitoringState";
    private final Callback callback;
    private boolean inside = false;
    private long lastSeenTime = 0L;

    public RegionMonitoringState(Callback callback) {
        this.callback = callback;
    }

    public Callback getCallback() {
        return this.callback;
    }

    public boolean getInside() {
        return this.inside;
    }

    public boolean markInside() {
        this.lastSeenTime = SystemClock.elapsedRealtime();
        if (!this.inside) {
            this.inside = true;
            return true;
        }
        return false;
    }

    public void markOutside() {
        this.inside = false;
        this.lastSeenTime = 0L;
    }

    public boolean markOutsideIfExpired() {
        if (this.inside && this.lastSeenTime > 0L && SystemClock.elapsedRealtime() - this.lastSeenTime > BeaconManager.getRegionExitPeriod()) {
            String string = TAG;
            Object[] arrobject = new Object[]{this.lastSeenTime, SystemClock.elapsedRealtime() - this.lastSeenTime, BeaconManager.getRegionExitPeriod()};
            LogManager.d(string, "We are newly outside the region because the lastSeenTime of %s was %s seconds ago, and that is over the expiration duration of %s", arrobject);
            this.markOutside();
            return true;
        }
        return false;
    }
}

