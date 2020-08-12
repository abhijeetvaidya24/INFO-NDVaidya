/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.io.Serializable
 *  java.lang.Boolean
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 */
package org.altbeacon.beacon.service;

import android.content.Context;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.altbeacon.beacon.BeaconManager;
import org.altbeacon.beacon.BeaconParser;
import org.altbeacon.beacon.Region;
import org.altbeacon.beacon.logging.LogManager;
import org.altbeacon.beacon.service.Callback;
import org.altbeacon.beacon.service.ExtraDataBeaconTracker;
import org.altbeacon.beacon.service.MonitoringStatus;
import org.altbeacon.beacon.service.RangeState;

public class ScanState
implements Serializable {
    public static int MIN_SCAN_JOB_INTERVAL_MILLIS = 300000;
    private static final String TAG = "ScanState";
    private long mBackgroundBetweenScanPeriod;
    private boolean mBackgroundMode;
    private long mBackgroundScanPeriod;
    private Set<BeaconParser> mBeaconParsers = new HashSet();
    private transient Context mContext;
    private ExtraDataBeaconTracker mExtraBeaconDataTracker = new ExtraDataBeaconTracker();
    private long mForegroundBetweenScanPeriod;
    private long mForegroundScanPeriod;
    private long mLastScanStartTimeMillis = 0L;
    private transient MonitoringStatus mMonitoringStatus;
    private Map<Region, RangeState> mRangedRegionState = new HashMap();

    public ScanState(Context context) {
        this.mContext = context;
    }

    /*
     * Exception decompiling
     */
    public static ScanState restore(Context var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl150 : ALOAD_3 : trying to set 1 previously set to 0
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

    public void applyChanges(BeaconManager beaconManager) {
        this.mBeaconParsers = new HashSet(beaconManager.getBeaconParsers());
        this.mForegroundScanPeriod = beaconManager.getForegroundScanPeriod();
        this.mForegroundBetweenScanPeriod = beaconManager.getForegroundBetweenScanPeriod();
        this.mBackgroundScanPeriod = beaconManager.getBackgroundScanPeriod();
        this.mBackgroundBetweenScanPeriod = beaconManager.getBackgroundBetweenScanPeriod();
        this.mBackgroundMode = beaconManager.getBackgroundMode();
        ArrayList arrayList = new ArrayList(this.mMonitoringStatus.regions());
        ArrayList arrayList2 = new ArrayList((Collection)this.mRangedRegionState.keySet());
        ArrayList arrayList3 = new ArrayList(beaconManager.getMonitoredRegions());
        ArrayList arrayList4 = new ArrayList(beaconManager.getRangedRegions());
        String string = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ranged regions: old=");
        stringBuilder.append(arrayList2.size());
        stringBuilder.append(" new=");
        stringBuilder.append(arrayList4.size());
        LogManager.d(string, stringBuilder.toString(), new Object[0]);
        String string2 = TAG;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("monitored regions: old=");
        stringBuilder2.append(arrayList.size());
        stringBuilder2.append(" new=");
        stringBuilder2.append(arrayList3.size());
        LogManager.d(string2, stringBuilder2.toString(), new Object[0]);
        for (Region region : arrayList4) {
            if (arrayList2.contains((Object)region)) continue;
            String string3 = TAG;
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("Starting ranging region: ");
            stringBuilder3.append((Object)region);
            LogManager.d(string3, stringBuilder3.toString(), new Object[0]);
            this.mRangedRegionState.put((Object)region, (Object)new RangeState(new Callback(this.mContext.getPackageName())));
        }
        for (Region region : arrayList2) {
            if (arrayList4.contains((Object)region)) continue;
            String string4 = TAG;
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append("Stopping ranging region: ");
            stringBuilder4.append((Object)region);
            LogManager.d(string4, stringBuilder4.toString(), new Object[0]);
            this.mRangedRegionState.remove((Object)region);
        }
        String string5 = TAG;
        StringBuilder stringBuilder5 = new StringBuilder();
        stringBuilder5.append("Updated state with ");
        stringBuilder5.append(arrayList4.size());
        stringBuilder5.append(" ranging regions and ");
        stringBuilder5.append(arrayList3.size());
        stringBuilder5.append(" monitoring regions.");
        LogManager.d(string5, stringBuilder5.toString(), new Object[0]);
        this.save();
    }

    public Long getBackgroundBetweenScanPeriod() {
        return this.mBackgroundBetweenScanPeriod;
    }

    public Boolean getBackgroundMode() {
        return this.mBackgroundMode;
    }

    public Long getBackgroundScanPeriod() {
        return this.mBackgroundScanPeriod;
    }

    public Set<BeaconParser> getBeaconParsers() {
        return this.mBeaconParsers;
    }

    public ExtraDataBeaconTracker getExtraBeaconDataTracker() {
        return this.mExtraBeaconDataTracker;
    }

    public Long getForegroundBetweenScanPeriod() {
        return this.mForegroundBetweenScanPeriod;
    }

    public Long getForegroundScanPeriod() {
        return this.mForegroundScanPeriod;
    }

    public MonitoringStatus getMonitoringStatus() {
        return this.mMonitoringStatus;
    }

    public Map<Region, RangeState> getRangedRegionState() {
        return this.mRangedRegionState;
    }

    public int getScanJobIntervalMillis() {
        long l2;
        long l3;
        if (this.getBackgroundMode().booleanValue()) {
            l3 = this.getBackgroundScanPeriod();
            l2 = this.getBackgroundBetweenScanPeriod();
        } else {
            l3 = this.getForegroundScanPeriod();
            l2 = this.getForegroundBetweenScanPeriod();
        }
        long l4 = l3 + l2;
        int n2 = MIN_SCAN_JOB_INTERVAL_MILLIS;
        if (l4 > (long)n2) {
            n2 = (int)l4;
        }
        return n2;
    }

    public int getScanJobRuntimeMillis() {
        int n2;
        String string = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ScanState says background mode for ScanJob is ");
        stringBuilder.append((Object)this.getBackgroundMode());
        LogManager.d(string, stringBuilder.toString(), new Object[0]);
        long l2 = this.getBackgroundMode() != false ? this.getBackgroundScanPeriod().longValue() : this.getForegroundScanPeriod().longValue();
        if (!this.getBackgroundMode().booleanValue() && l2 < (long)(n2 = MIN_SCAN_JOB_INTERVAL_MILLIS)) {
            return n2;
        }
        return (int)l2;
    }

    /*
     * Exception decompiling
     */
    public void save() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl150.1 : ALOAD_0 : trying to set 1 previously set to 0
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

    public void setLastScanStartTimeMillis(long l2) {
        this.mLastScanStartTimeMillis = l2;
    }
}

