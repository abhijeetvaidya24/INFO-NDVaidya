/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.SystemClock
 *  java.lang.Object
 */
package org.altbeacon.beacon.service;

import android.os.SystemClock;

public class DetectionTracker {
    private static final DetectionTracker INSTANCE = new DetectionTracker();
    private long mLastDetectionTime = 0L;

    private DetectionTracker() {
    }

    public static DetectionTracker getInstance() {
        return INSTANCE;
    }

    public long getLastDetectionTime() {
        return this.mLastDetectionTime;
    }

    public void recordDetection() {
        this.mLastDetectionTime = SystemClock.elapsedRealtime();
    }
}

