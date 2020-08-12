/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.job.JobInfo
 *  android.app.job.JobInfo$Builder
 *  android.app.job.JobScheduler
 *  android.bluetooth.le.ScanResult
 *  android.content.ComponentName
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.PersistableBundle
 *  android.os.SystemClock
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 */
package org.altbeacon.beacon.service;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.bluetooth.le.ScanResult;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.PersistableBundle;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.altbeacon.beacon.BeaconLocalBroadcastProcessor;
import org.altbeacon.beacon.BeaconManager;
import org.altbeacon.beacon.logging.LogManager;
import org.altbeacon.beacon.service.ScanJob;
import org.altbeacon.beacon.service.ScanState;

public class ScanJobScheduler {
    private static final Object SINGLETON_LOCK = new Object();
    private static final String TAG = "ScanJobScheduler";
    private static volatile ScanJobScheduler sInstance = null;
    private List<ScanResult> mBackgroundScanResultQueue = new ArrayList();
    private BeaconLocalBroadcastProcessor mBeaconNotificationProcessor;
    private Long mScanJobScheduleTime = 0L;

    private ScanJobScheduler() {
    }

    private void applySettingsToScheduledJob(Context context, BeaconManager beaconManager, ScanState scanState) {
        scanState.applyChanges(beaconManager);
        String string = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Applying scan job settings with background mode ");
        stringBuilder.append((Object)scanState.getBackgroundMode());
        LogManager.d(string, stringBuilder.toString(), new Object[0]);
        this.schedule(context, scanState, false);
    }

    private void ensureNotificationProcessorSetup(Context context) {
        if (this.mBeaconNotificationProcessor == null) {
            this.mBeaconNotificationProcessor = new BeaconLocalBroadcastProcessor(context);
            this.mBeaconNotificationProcessor.register();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static ScanJobScheduler getInstance() {
        Object object;
        ScanJobScheduler scanJobScheduler = sInstance;
        if (scanJobScheduler != null) {
            return scanJobScheduler;
        }
        Object object2 = object = SINGLETON_LOCK;
        synchronized (object2) {
            ScanJobScheduler scanJobScheduler2 = sInstance;
            if (scanJobScheduler2 == null) {
                sInstance = scanJobScheduler2 = new ScanJobScheduler();
            }
            return scanJobScheduler2;
        }
    }

    private void schedule(Context context, ScanState scanState, boolean bl2) {
        long l2;
        this.ensureNotificationProcessorSetup(context);
        long l3 = scanState.getScanJobIntervalMillis() - scanState.getScanJobRuntimeMillis();
        if (bl2) {
            LogManager.d(TAG, "We just woke up in the background based on a new scan result.  Start scan job immediately.", new Object[0]);
            l2 = 0L;
        } else {
            l2 = l3 > 0L ? SystemClock.elapsedRealtime() % (long)scanState.getScanJobIntervalMillis() : 0L;
            if (l2 < 50L) {
                l2 = 50L;
            }
        }
        JobScheduler jobScheduler = (JobScheduler)context.getSystemService("jobscheduler");
        if (!bl2 && scanState.getBackgroundMode().booleanValue()) {
            LogManager.d(TAG, "Not scheduling an immediate scan because we are in background mode.   Cancelling existing immediate scan.", new Object[0]);
            jobScheduler.cancel(ScanJob.getImmediateScanJobId(context));
        } else if (l2 < (long)(-50 + scanState.getScanJobIntervalMillis())) {
            String string = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Scheduling immediate ScanJob to run in ");
            stringBuilder.append(l2);
            stringBuilder.append(" millis");
            LogManager.d(string, stringBuilder.toString(), new Object[0]);
            int n2 = jobScheduler.schedule(new JobInfo.Builder(ScanJob.getImmediateScanJobId(context), new ComponentName(context, ScanJob.class)).setPersisted(true).setExtras(new PersistableBundle()).setMinimumLatency(l2).setOverrideDeadline(l2).build());
            if (n2 < 0) {
                String string2 = TAG;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Failed to schedule scan job.  Beacons will not be detected. Error: ");
                stringBuilder2.append(n2);
                LogManager.e(string2, stringBuilder2.toString(), new Object[0]);
            }
        } else {
            LogManager.d(TAG, "Not scheduling immediate scan, assuming periodic is about to run", new Object[0]);
        }
        JobInfo.Builder builder = new JobInfo.Builder(ScanJob.getPeriodicScanJobId(context), new ComponentName(context, ScanJob.class)).setPersisted(true).setExtras(new PersistableBundle());
        if (Build.VERSION.SDK_INT >= 24) {
            builder.setPeriodic((long)scanState.getScanJobIntervalMillis(), 0L).build();
        } else {
            builder.setPeriodic((long)scanState.getScanJobIntervalMillis()).build();
        }
        JobInfo jobInfo = builder.build();
        String string = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Scheduling ScanJob ");
        stringBuilder.append((Object)jobInfo);
        stringBuilder.append(" to run every ");
        stringBuilder.append(scanState.getScanJobIntervalMillis());
        stringBuilder.append(" millis");
        LogManager.d(string, stringBuilder.toString(), new Object[0]);
        int n3 = jobScheduler.schedule(jobInfo);
        if (n3 < 0) {
            String string3 = TAG;
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("Failed to schedule scan job.  Beacons will not be detected. Error: ");
            stringBuilder3.append(n3);
            LogManager.e(string3, stringBuilder3.toString(), new Object[0]);
        }
    }

    public void applySettingsToScheduledJob(Context context, BeaconManager beaconManager) {
        LogManager.d(TAG, "Applying settings to ScanJob", new Object[0]);
        (JobScheduler)context.getSystemService("jobscheduler");
        this.applySettingsToScheduledJob(context, beaconManager, ScanState.restore(context));
    }

    List<ScanResult> dumpBackgroundScanResultQueue() {
        List<ScanResult> list = this.mBackgroundScanResultQueue;
        this.mBackgroundScanResultQueue = new ArrayList();
        return list;
    }

    public void forceScheduleNextScan(Context context) {
        this.schedule(context, ScanState.restore(context), false);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void scheduleAfterBackgroundWakeup(Context context, List<ScanResult> list) {
        if (list != null) {
            this.mBackgroundScanResultQueue.addAll(list);
        }
        ScanJobScheduler scanJobScheduler = this;
        synchronized (scanJobScheduler) {
            if (System.currentTimeMillis() - this.mScanJobScheduleTime > 10000L) {
                String string = TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("scheduling an immediate scan job because last did ");
                stringBuilder.append(System.currentTimeMillis() - this.mScanJobScheduleTime);
                stringBuilder.append("seconds ago.");
                LogManager.d(string, stringBuilder.toString(), new Object[0]);
                this.mScanJobScheduleTime = System.currentTimeMillis();
                // MONITOREXIT [2, 3] lbl13 : w: MONITOREXIT : var10_3
                this.schedule(context, ScanState.restore(context), true);
                return;
            }
            LogManager.d(TAG, "Not scheduling an immediate scan job because we just did recently.", new Object[0]);
            return;
        }
    }
}

