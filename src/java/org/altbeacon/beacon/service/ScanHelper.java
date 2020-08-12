/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.app.PendingIntent
 *  android.bluetooth.BluetoothAdapter
 *  android.bluetooth.BluetoothDevice
 *  android.bluetooth.BluetoothManager
 *  android.bluetooth.le.BluetoothLeScanner
 *  android.bluetooth.le.ScanFilter
 *  android.bluetooth.le.ScanSettings
 *  android.bluetooth.le.ScanSettings$Builder
 *  android.content.Context
 *  android.content.Intent
 *  android.os.AsyncTask
 *  android.os.Bundle
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Runtime
 *  java.lang.SecurityException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Void
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 *  java.util.concurrent.Executor
 *  java.util.concurrent.ExecutorService
 *  java.util.concurrent.Executors
 *  java.util.concurrent.RejectedExecutionException
 *  org.altbeacon.beacon.service.ScanHelper$1
 */
package org.altbeacon.beacon.service;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanSettings;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import org.altbeacon.beacon.Beacon;
import org.altbeacon.beacon.BeaconManager;
import org.altbeacon.beacon.BeaconParser;
import org.altbeacon.beacon.Region;
import org.altbeacon.beacon.logging.LogManager;
import org.altbeacon.beacon.service.Callback;
import org.altbeacon.beacon.service.DetectionTracker;
import org.altbeacon.beacon.service.ExtraDataBeaconTracker;
import org.altbeacon.beacon.service.MonitoringStatus;
import org.altbeacon.beacon.service.RangeState;
import org.altbeacon.beacon.service.RangingData;
import org.altbeacon.beacon.service.ScanHelper;
import org.altbeacon.beacon.service.Stats;
import org.altbeacon.beacon.service.scanner.CycledLeScanCallback;
import org.altbeacon.beacon.service.scanner.CycledLeScanner;
import org.altbeacon.beacon.service.scanner.DistinctPacketDetector;
import org.altbeacon.beacon.service.scanner.NonBeaconLeScanCallback;
import org.altbeacon.beacon.service.scanner.ScanFilterUtils;
import org.altbeacon.beacon.startup.StartupBroadcastReceiver;
import org.altbeacon.bluetooth.BluetoothCrashResolver;

class ScanHelper {
    private static final String TAG = "ScanHelper";
    private BeaconManager mBeaconManager;
    private Set<BeaconParser> mBeaconParsers = new HashSet();
    private Context mContext;
    private final CycledLeScanCallback mCycledLeScanCallback = new 1(this);
    private CycledLeScanner mCycledScanner;
    private DistinctPacketDetector mDistinctPacketDetector = new DistinctPacketDetector();
    private ExecutorService mExecutor;
    private ExtraDataBeaconTracker mExtraDataBeaconTracker = new ExtraDataBeaconTracker();
    private MonitoringStatus mMonitoringStatus;
    private final Map<Region, RangeState> mRangedRegionState = new HashMap();
    private List<Beacon> mSimulatedScanData = null;

    ScanHelper(Context context) {
        this.mContext = context;
        this.mBeaconManager = BeaconManager.getInstanceForApplication(context);
        this.mExecutor = Executors.newFixedThreadPool((int)(1 + Runtime.getRuntime().availableProcessors()));
    }

    static /* synthetic */ MonitoringStatus access$100(ScanHelper scanHelper) {
        return scanHelper.mMonitoringStatus;
    }

    static /* synthetic */ void access$200(ScanHelper scanHelper) {
        scanHelper.processRangeData();
    }

    static /* synthetic */ List access$300(ScanHelper scanHelper) {
        return scanHelper.mSimulatedScanData;
    }

    static /* synthetic */ Context access$500(ScanHelper scanHelper) {
        return scanHelper.mContext;
    }

    private List<Region> matchingRegions(Beacon beacon, Collection<Region> collection) {
        ArrayList arrayList = new ArrayList();
        for (Region region : collection) {
            if (region.matchesBeacon(beacon)) {
                arrayList.add((Object)region);
                continue;
            }
            LogManager.d(TAG, "This region (%s) does not match beacon: %s", region, beacon);
        }
        return arrayList;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void processBeaconFromScan(Beacon beacon) {
        Beacon beacon2;
        Map<Region, RangeState> map;
        if (Stats.getInstance().isEnabled()) {
            Stats.getInstance().log(beacon);
        }
        if (LogManager.isVerboseLoggingEnabled()) {
            String string = TAG;
            Object[] arrobject = new Object[]{beacon.toString()};
            LogManager.d(string, "beacon detected : %s", arrobject);
        }
        if ((beacon2 = this.mExtraDataBeaconTracker.track(beacon)) == null) {
            if (!LogManager.isVerboseLoggingEnabled()) return;
            LogManager.d(TAG, "not processing detections for GATT extra data beacon", new Object[0]);
            return;
        }
        this.mMonitoringStatus.updateNewlyInsideInRegionsContaining(beacon2);
        LogManager.d(TAG, "looking for ranging region matches for this beacon", new Object[0]);
        Map<Region, RangeState> map2 = map = this.mRangedRegionState;
        synchronized (map2) {
            Iterator iterator = this.matchingRegions(beacon2, (Collection<Region>)this.mRangedRegionState.keySet()).iterator();
            while (iterator.hasNext()) {
                Region region = (Region)iterator.next();
                LogManager.d(TAG, "matches ranging region: %s", region);
                RangeState rangeState = (RangeState)this.mRangedRegionState.get((Object)region);
                if (rangeState == null) continue;
                rangeState.addBeacon(beacon2);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void processRangeData() {
        Map<Region, RangeState> map;
        Map<Region, RangeState> map2 = map = this.mRangedRegionState;
        synchronized (map2) {
            Iterator iterator = this.mRangedRegionState.keySet().iterator();
            while (iterator.hasNext()) {
                Region region = (Region)iterator.next();
                RangeState rangeState = (RangeState)this.mRangedRegionState.get((Object)region);
                LogManager.d(TAG, "Calling ranging callback", new Object[0]);
                rangeState.getCallback().call(this.mContext, "rangingData", new RangingData(rangeState.finalizeBeacons(), region).toBundle());
            }
            return;
        }
    }

    void createCycledLeScanner(boolean bl2, BluetoothCrashResolver bluetoothCrashResolver) {
        this.mCycledScanner = CycledLeScanner.createScanner(this.mContext, 1100L, 0L, bl2, this.mCycledLeScanCallback, bluetoothCrashResolver);
    }

    CycledLeScanner getCycledScanner() {
        return this.mCycledScanner;
    }

    MonitoringStatus getMonitoringStatus() {
        return this.mMonitoringStatus;
    }

    Map<Region, RangeState> getRangedRegionState() {
        return this.mRangedRegionState;
    }

    PendingIntent getScanCallbackIntent() {
        Intent intent = new Intent(this.mContext, StartupBroadcastReceiver.class);
        intent.putExtra("o-scan", true);
        return PendingIntent.getBroadcast((Context)this.mContext, (int)0, (Intent)intent, (int)134217728);
    }

    @TargetApi(value=11)
    void processScanResult(BluetoothDevice bluetoothDevice, int n2, byte[] arrby) {
        NonBeaconLeScanCallback nonBeaconLeScanCallback = this.mBeaconManager.getNonBeaconLeScanCallback();
        try {
            ScanProcessor scanProcessor = new ScanProcessor(nonBeaconLeScanCallback);
            ExecutorService executorService = this.mExecutor;
            Object[] arrobject = new ScanData[]{new ScanData(bluetoothDevice, n2, arrby)};
            scanProcessor.executeOnExecutor((Executor)executorService, arrobject);
            return;
        }
        catch (RejectedExecutionException rejectedExecutionException) {
            LogManager.w(TAG, "Ignoring scan result because we cannot keep up.", new Object[0]);
            return;
        }
    }

    void reloadParsers() {
        HashSet hashSet = new HashSet();
        hashSet.addAll(this.mBeaconManager.getBeaconParsers());
        Iterator iterator = this.mBeaconManager.getBeaconParsers().iterator();
        boolean bl2 = true;
        while (iterator.hasNext()) {
            BeaconParser beaconParser = (BeaconParser)iterator.next();
            if (beaconParser.getExtraDataParsers().size() <= 0) continue;
            hashSet.addAll(beaconParser.getExtraDataParsers());
            bl2 = false;
        }
        this.mBeaconParsers = hashSet;
        this.mExtraDataBeaconTracker = new ExtraDataBeaconTracker(bl2);
    }

    void setBeaconParsers(Set<BeaconParser> set) {
        this.mBeaconParsers = set;
    }

    void setExtraDataBeaconTracker(ExtraDataBeaconTracker extraDataBeaconTracker) {
        this.mExtraDataBeaconTracker = extraDataBeaconTracker;
    }

    void setMonitoringStatus(MonitoringStatus monitoringStatus) {
        this.mMonitoringStatus = monitoringStatus;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    void setRangedRegionState(Map<Region, RangeState> map) {
        Map<Region, RangeState> map2;
        Map<Region, RangeState> map3 = map2 = this.mRangedRegionState;
        synchronized (map3) {
            this.mRangedRegionState.clear();
            this.mRangedRegionState.putAll(map);
            return;
        }
    }

    void setSimulatedScanData(List<Beacon> list) {
        this.mSimulatedScanData = list;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    void startAndroidOBackgroundScan(Set<BeaconParser> set) {
        ScanSettings scanSettings = new ScanSettings.Builder().setScanMode(0).build();
        List<ScanFilter> list = new ScanFilterUtils().createScanFiltersForBeaconParsers((List<BeaconParser>)new ArrayList(set));
        try {
            BluetoothAdapter bluetoothAdapter = ((BluetoothManager)this.mContext.getApplicationContext().getSystemService("bluetooth")).getAdapter();
            if (bluetoothAdapter == null) {
                LogManager.w(TAG, "Failed to construct a BluetoothAdapter", new Object[0]);
                return;
            }
            if (!bluetoothAdapter.isEnabled()) {
                LogManager.w(TAG, "Failed to start background scan on Android O: BluetoothAdapter is not enabled", new Object[0]);
                return;
            }
            int n2 = bluetoothAdapter.getBluetoothLeScanner().startScan(list, scanSettings, this.getScanCallbackIntent());
            if (n2 != 0) {
                String string = TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Failed to start background scan on Android O.  Code: ");
                stringBuilder.append(n2);
                LogManager.e(string, stringBuilder.toString(), new Object[0]);
                return;
            }
            LogManager.d(TAG, "Started passive beacon scan", new Object[0]);
            return;
        }
        catch (SecurityException securityException) {
            LogManager.e(TAG, "SecurityException making Android O background scanner", new Object[0]);
            return;
        }
    }

    /*
     * Exception decompiling
     */
    void stopAndroidOBackgroundScan() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl41 : RETURN : trying to set 1 previously set to 0
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

    private class ScanData {
        BluetoothDevice device;
        final int rssi;
        byte[] scanRecord;

        ScanData(BluetoothDevice bluetoothDevice, int n2, byte[] arrby) {
            this.device = bluetoothDevice;
            this.rssi = n2;
            this.scanRecord = arrby;
        }
    }

    private class ScanProcessor
    extends AsyncTask<ScanData, Void, Void> {
        final DetectionTracker mDetectionTracker = DetectionTracker.getInstance();
        private final NonBeaconLeScanCallback mNonBeaconLeScanCallback;

        ScanProcessor(NonBeaconLeScanCallback nonBeaconLeScanCallback) {
            this.mNonBeaconLeScanCallback = nonBeaconLeScanCallback;
        }

        protected /* varargs */ Void doInBackground(ScanData ... arrscanData) {
            ScanData scanData = arrscanData[0];
            Iterator iterator = ScanHelper.this.mBeaconParsers.iterator();
            Beacon beacon = null;
            while (iterator.hasNext() && (beacon = ((BeaconParser)iterator.next()).fromScanData(scanData.scanRecord, scanData.rssi, scanData.device)) == null) {
            }
            if (beacon != null) {
                if (LogManager.isVerboseLoggingEnabled()) {
                    String string = TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Beacon packet detected for: ");
                    stringBuilder.append((Object)beacon);
                    stringBuilder.append(" with rssi ");
                    stringBuilder.append(beacon.getRssi());
                    LogManager.d(string, stringBuilder.toString(), new Object[0]);
                }
                this.mDetectionTracker.recordDetection();
                if (ScanHelper.this.mCycledScanner != null && !ScanHelper.this.mCycledScanner.getDistinctPacketsDetectedPerScan() && !ScanHelper.this.mDistinctPacketDetector.isPacketDistinct(scanData.device.getAddress(), scanData.scanRecord)) {
                    LogManager.i(TAG, "Non-distinct packets detected in a single scan.  Restarting scans unecessary.", new Object[0]);
                    ScanHelper.this.mCycledScanner.setDistinctPacketsDetectedPerScan(true);
                }
                ScanHelper.this.processBeaconFromScan(beacon);
                return null;
            }
            NonBeaconLeScanCallback nonBeaconLeScanCallback = this.mNonBeaconLeScanCallback;
            if (nonBeaconLeScanCallback != null) {
                nonBeaconLeScanCallback.onNonBeaconLeScan(scanData.device, scanData.rssi, scanData.scanRecord);
            }
            return null;
        }

        protected void onPostExecute(Void void_) {
        }

        protected void onPreExecute() {
        }

        protected /* varargs */ void onProgressUpdate(Void ... arrvoid) {
        }
    }

}

