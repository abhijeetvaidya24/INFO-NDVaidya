/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.app.job.JobParameters
 *  android.app.job.JobService
 *  android.bluetooth.BluetoothDevice
 *  android.bluetooth.le.ScanRecord
 *  android.bluetooth.le.ScanResult
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  java.lang.Boolean
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 *  org.altbeacon.beacon.distance.ModelSpecificDistanceCalculator
 */
package org.altbeacon.beacon.service;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.altbeacon.beacon.Beacon;
import org.altbeacon.beacon.BeaconManager;
import org.altbeacon.beacon.BeaconParser;
import org.altbeacon.beacon.Region;
import org.altbeacon.beacon.distance.DistanceCalculator;
import org.altbeacon.beacon.distance.ModelSpecificDistanceCalculator;
import org.altbeacon.beacon.logging.LogManager;
import org.altbeacon.beacon.service.ExtraDataBeaconTracker;
import org.altbeacon.beacon.service.MonitoringStatus;
import org.altbeacon.beacon.service.RangeState;
import org.altbeacon.beacon.service.RegionMonitoringState;
import org.altbeacon.beacon.service.ScanHelper;
import org.altbeacon.beacon.service.ScanJobScheduler;
import org.altbeacon.beacon.service.ScanState;
import org.altbeacon.beacon.service.scanner.CycledLeScanner;
import org.altbeacon.beacon.utils.ProcessUtils;
import org.altbeacon.bluetooth.BluetoothCrashResolver;

@TargetApi(value=21)
public class ScanJob
extends JobService {
    private static final String TAG = "ScanJob";
    private static int sOverrideImmediateScanJobId = -1;
    private static int sOverridePeriodicScanJobId = -1;
    private boolean mInitialized = false;
    private ScanHelper mScanHelper;
    private ScanState mScanState;
    private Handler mStopHandler = new Handler();

    public static int getImmediateScanJobId(Context context) {
        if (sOverrideImmediateScanJobId >= 0) {
            String string = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Using ImmediateScanJobId from static override: ");
            stringBuilder.append(sOverrideImmediateScanJobId);
            LogManager.i(string, stringBuilder.toString(), new Object[0]);
            return sOverrideImmediateScanJobId;
        }
        return ScanJob.getJobIdFromManifest(context, "immediateScanJobId");
    }

    /*
     * Exception decompiling
     */
    private static int getJobIdFromManifest(Context var0, String var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl14 : ALOAD_2 : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:919)
        throw new IllegalStateException("Decompilation failed");
    }

    public static int getPeriodicScanJobId(Context context) {
        if (sOverrideImmediateScanJobId >= 0) {
            String string = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Using PeriodicScanJobId from static override: ");
            stringBuilder.append(sOverridePeriodicScanJobId);
            LogManager.i(string, stringBuilder.toString(), new Object[0]);
            return sOverridePeriodicScanJobId;
        }
        return ScanJob.getJobIdFromManifest(context, "periodicScanJobId");
    }

    private void initialzeScanHelper() {
        this.mScanHelper = new ScanHelper((Context)this);
        this.mScanState = ScanState.restore((Context)this);
        this.mScanState.setLastScanStartTimeMillis(System.currentTimeMillis());
        this.mScanHelper.setMonitoringStatus(this.mScanState.getMonitoringStatus());
        this.mScanHelper.setRangedRegionState(this.mScanState.getRangedRegionState());
        this.mScanHelper.setBeaconParsers(this.mScanState.getBeaconParsers());
        this.mScanHelper.setExtraDataBeaconTracker(this.mScanState.getExtraBeaconDataTracker());
        if (this.mScanHelper.getCycledScanner() == null) {
            this.mScanHelper.createCycledLeScanner(this.mScanState.getBackgroundMode(), null);
        }
    }

    private boolean restartScanning() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.mScanHelper.stopAndroidOBackgroundScan();
        }
        Long l2 = this.mScanState.getBackgroundMode() != false ? this.mScanState.getBackgroundScanPeriod() : this.mScanState.getForegroundScanPeriod();
        long l3 = l2;
        Long l4 = this.mScanState.getBackgroundMode() != false ? this.mScanState.getBackgroundBetweenScanPeriod() : this.mScanState.getForegroundBetweenScanPeriod();
        long l5 = l4;
        this.mScanHelper.getCycledScanner().setScanPeriods(l3, l5, this.mScanState.getBackgroundMode());
        this.mInitialized = true;
        if (l3 <= 0L) {
            LogManager.w(TAG, "Starting scan with scan period of zero.  Exiting ScanJob.", new Object[0]);
            this.mScanHelper.getCycledScanner().stop();
            return false;
        }
        if (this.mScanHelper.getRangedRegionState().size() <= 0 && this.mScanHelper.getMonitoringStatus().regions().size() <= 0) {
            this.mScanHelper.getCycledScanner().stop();
            return false;
        }
        this.mScanHelper.getCycledScanner().start();
        return true;
    }

    private void scheduleNextScan() {
        if (!this.mScanState.getBackgroundMode().booleanValue()) {
            LogManager.d(TAG, "In foreground mode, schedule next scan", new Object[0]);
            ScanJobScheduler.getInstance().forceScheduleNextScan((Context)this);
            return;
        }
        this.startPassiveScanIfNeeded();
    }

    private void startPassiveScanIfNeeded() {
        LogManager.d(TAG, "Checking to see if we need to start a passive scan", new Object[0]);
        Iterator iterator = new ArrayList(this.mScanState.getMonitoringStatus().regions()).iterator();
        boolean bl2 = false;
        while (iterator.hasNext()) {
            Region region = (Region)iterator.next();
            RegionMonitoringState regionMonitoringState = this.mScanState.getMonitoringStatus().stateOf(region);
            if (regionMonitoringState == null || !regionMonitoringState.getInside()) continue;
            bl2 = true;
        }
        if (bl2) {
            LogManager.i(TAG, "We are inside a beacon region.  We will not scan between cycles.", new Object[0]);
            return;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            this.mScanHelper.startAndroidOBackgroundScan(this.mScanState.getBeaconParsers());
            return;
        }
        LogManager.d(TAG, "This is not Android O.  No scanning between cycles when using ScanJob", new Object[0]);
    }

    private boolean startScanning() {
        BeaconManager beaconManager = BeaconManager.getInstanceForApplication(this.getApplicationContext());
        beaconManager.setScannerInSameProcess(true);
        if (beaconManager.isMainProcess()) {
            LogManager.i(TAG, "scanJob version %s is starting up on the main process", "2.13.1");
        } else {
            LogManager.i(TAG, "beaconScanJob library version %s is starting up on a separate process", "2.13.1");
            ProcessUtils processUtils = new ProcessUtils((Context)this);
            String string = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("beaconScanJob PID is ");
            stringBuilder.append(processUtils.getPid());
            stringBuilder.append(" with process name ");
            stringBuilder.append(processUtils.getProcessName());
            LogManager.i(string, stringBuilder.toString(), new Object[0]);
        }
        Beacon.setDistanceCalculator((DistanceCalculator)new ModelSpecificDistanceCalculator((Context)this, BeaconManager.getDistanceModelUpdateUrl()));
        return this.restartScanning();
    }

    private void stopScanning() {
        this.mInitialized = false;
        this.mScanHelper.getCycledScanner().stop();
        this.mScanHelper.getCycledScanner().destroy();
        LogManager.d(TAG, "Scanning stopped", new Object[0]);
    }

    public boolean onStartJob(final JobParameters jobParameters) {
        boolean bl2;
        this.initialzeScanHelper();
        if (jobParameters.getJobId() == ScanJob.getImmediateScanJobId((Context)this)) {
            String string = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Running immediate scan job: instance is ");
            stringBuilder.append((Object)this);
            LogManager.i(string, stringBuilder.toString(), new Object[0]);
        } else {
            String string = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Running periodic scan job: instance is ");
            stringBuilder.append((Object)this);
            LogManager.i(string, stringBuilder.toString(), new Object[0]);
        }
        List<ScanResult> list = ScanJobScheduler.getInstance().dumpBackgroundScanResultQueue();
        String string = TAG;
        Object[] arrobject = new Object[]{list.size()};
        LogManager.d(string, "Processing %d queued scan resuilts", arrobject);
        for (ScanResult scanResult : list) {
            ScanRecord scanRecord = scanResult.getScanRecord();
            if (scanRecord == null) continue;
            this.mScanHelper.processScanResult(scanResult.getDevice(), scanResult.getRssi(), scanRecord.getBytes());
        }
        LogManager.d(TAG, "Done processing queued scan resuilts", new Object[0]);
        if (this.mInitialized) {
            LogManager.d(TAG, "Scanning already started.  Resetting for current parameters", new Object[0]);
            bl2 = this.restartScanning();
        } else {
            bl2 = this.startScanning();
        }
        this.mStopHandler.removeCallbacksAndMessages(null);
        if (bl2) {
            String string2 = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Scan job running for ");
            stringBuilder.append(this.mScanState.getScanJobRuntimeMillis());
            stringBuilder.append(" millis");
            LogManager.i(string2, stringBuilder.toString(), new Object[0]);
            this.mStopHandler.postDelayed(new Runnable(){

                public void run() {
                    String string = TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Scan job runtime expired: ");
                    stringBuilder.append((Object)ScanJob.this);
                    LogManager.i(string, stringBuilder.toString(), new Object[0]);
                    ScanJob.this.stopScanning();
                    ScanJob.this.mScanState.save();
                    ScanJob.this.jobFinished(jobParameters, false);
                    ScanJob.this.mStopHandler.post(new Runnable(){

                        public void run() {
                            ScanJob.this.scheduleNextScan();
                        }
                    });
                }

            }, (long)this.mScanState.getScanJobRuntimeMillis());
            return true;
        }
        LogManager.i(TAG, "Scanning not started so Scan job is complete.", new Object[0]);
        this.jobFinished(jobParameters, false);
        return true;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        if (jobParameters.getJobId() == ScanJob.getPeriodicScanJobId((Context)this)) {
            String string = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onStopJob called for periodic scan ");
            stringBuilder.append((Object)this);
            LogManager.i(string, stringBuilder.toString(), new Object[0]);
        } else {
            String string = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onStopJob called for immediate scan ");
            stringBuilder.append((Object)this);
            LogManager.i(string, stringBuilder.toString(), new Object[0]);
        }
        this.mStopHandler.removeCallbacksAndMessages(null);
        this.stopScanning();
        this.startPassiveScanIfNeeded();
        return false;
    }

}

