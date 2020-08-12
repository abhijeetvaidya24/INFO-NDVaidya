/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  java.io.File
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 *  java.util.concurrent.ConcurrentHashMap
 */
package org.altbeacon.beacon.service;

import android.content.Context;
import android.os.Bundle;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.altbeacon.beacon.Beacon;
import org.altbeacon.beacon.Region;
import org.altbeacon.beacon.logging.LogManager;
import org.altbeacon.beacon.service.Callback;
import org.altbeacon.beacon.service.MonitoringData;
import org.altbeacon.beacon.service.RegionMonitoringState;

public class MonitoringStatus {
    private static final Object SINGLETON_LOCK = new Object();
    private static final String TAG = "MonitoringStatus";
    private static volatile MonitoringStatus sInstance;
    private Context mContext;
    private Map<Region, RegionMonitoringState> mRegionsStatesMap;
    private boolean mStatePreservationIsOn = true;

    public MonitoringStatus(Context context) {
        this.mContext = context;
    }

    private RegionMonitoringState addLocalRegion(Region region, Callback callback) {
        if (this.getRegionsStateMap().containsKey((Object)region)) {
            for (Region region2 : this.getRegionsStateMap().keySet()) {
                if (!region2.equals(region)) continue;
                if (region2.hasSameIdentifiers(region)) {
                    return (RegionMonitoringState)this.getRegionsStateMap().get((Object)region2);
                }
                String string = TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Replacing region with unique identifier ");
                stringBuilder.append(region.getUniqueId());
                LogManager.d(string, stringBuilder.toString(), new Object[0]);
                String string2 = TAG;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Old definition: ");
                stringBuilder2.append((Object)region2);
                LogManager.d(string2, stringBuilder2.toString(), new Object[0]);
                String string3 = TAG;
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append("New definition: ");
                stringBuilder3.append((Object)region);
                LogManager.d(string3, stringBuilder3.toString(), new Object[0]);
                LogManager.d(TAG, "clearing state", new Object[0]);
                this.getRegionsStateMap().remove((Object)region);
                break;
            }
        }
        RegionMonitoringState regionMonitoringState = new RegionMonitoringState(callback);
        this.getRegionsStateMap().put((Object)region, (Object)regionMonitoringState);
        return regionMonitoringState;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static MonitoringStatus getInstanceForApplication(Context context) {
        Object object;
        MonitoringStatus monitoringStatus = sInstance;
        if (monitoringStatus != null) {
            return monitoringStatus;
        }
        Object object2 = object = SINGLETON_LOCK;
        synchronized (object2) {
            MonitoringStatus monitoringStatus2 = sInstance;
            if (monitoringStatus2 == null) {
                sInstance = monitoringStatus2 = new MonitoringStatus(context.getApplicationContext());
            }
            return monitoringStatus2;
        }
    }

    private Map<Region, RegionMonitoringState> getRegionsStateMap() {
        if (this.mRegionsStatesMap == null) {
            this.restoreOrInitializeMonitoringStatus();
        }
        return this.mRegionsStatesMap;
    }

    private List<Region> regionsMatchingTo(Beacon beacon) {
        ArrayList arrayList = new ArrayList();
        for (Region region : this.regions()) {
            if (region.matchesBeacon(beacon)) {
                arrayList.add((Object)region);
                continue;
            }
            LogManager.d(TAG, "This region (%s) does not match beacon: %s", region, beacon);
        }
        return arrayList;
    }

    private void restoreOrInitializeMonitoringStatus() {
        long l2 = System.currentTimeMillis() - this.getLastMonitoringStatusUpdateTime();
        this.mRegionsStatesMap = new ConcurrentHashMap();
        if (!this.mStatePreservationIsOn) {
            LogManager.d(TAG, "Not restoring monitoring state because persistence is disabled", new Object[0]);
            return;
        }
        if (l2 > 900000L) {
            String string = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Not restoring monitoring state because it was recorded too many milliseconds ago: ");
            stringBuilder.append(l2);
            LogManager.d(string, stringBuilder.toString(), new Object[0]);
            return;
        }
        this.restoreMonitoringStatus();
        LogManager.d(TAG, "Done restoring monitoring status", new Object[0]);
    }

    public RegionMonitoringState addLocalRegion(Region region) {
        return this.addLocalRegion(region, new Callback(null));
    }

    public void addRegion(Region region, Callback callback) {
        MonitoringStatus monitoringStatus = this;
        synchronized (monitoringStatus) {
            this.addLocalRegion(region, callback);
            this.saveMonitoringStatusIfOn();
            return;
        }
    }

    protected long getLastMonitoringStatusUpdateTime() {
        return this.mContext.getFileStreamPath("org.altbeacon.beacon.service.monitoring_status_state").lastModified();
    }

    public boolean isStatePreservationOn() {
        return this.mStatePreservationIsOn;
    }

    public Set<Region> regions() {
        MonitoringStatus monitoringStatus = this;
        synchronized (monitoringStatus) {
            Set set = this.getRegionsStateMap().keySet();
            return set;
        }
    }

    public int regionsCount() {
        MonitoringStatus monitoringStatus = this;
        synchronized (monitoringStatus) {
            int n2 = this.regions().size();
            return n2;
        }
    }

    public void removeLocalRegion(Region region) {
        this.getRegionsStateMap().remove((Object)region);
    }

    public void removeRegion(Region region) {
        MonitoringStatus monitoringStatus = this;
        synchronized (monitoringStatus) {
            this.removeLocalRegion(region);
            this.saveMonitoringStatusIfOn();
            return;
        }
    }

    /*
     * Exception decompiling
     */
    protected void restoreMonitoringStatus() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl118.3 : FAKE_TRY : trying to set 0 previously set to 1
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

    /*
     * Exception decompiling
     */
    protected void saveMonitoringStatusIfOn() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl71.3 : FAKE_TRY : trying to set 0 previously set to 1
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

    public void startStatusPreservation() {
        MonitoringStatus monitoringStatus = this;
        synchronized (monitoringStatus) {
            if (!this.mStatePreservationIsOn) {
                this.mStatePreservationIsOn = true;
                this.saveMonitoringStatusIfOn();
            }
            return;
        }
    }

    public RegionMonitoringState stateOf(Region region) {
        MonitoringStatus monitoringStatus = this;
        synchronized (monitoringStatus) {
            RegionMonitoringState regionMonitoringState = (RegionMonitoringState)this.getRegionsStateMap().get((Object)region);
            return regionMonitoringState;
        }
    }

    public void stopStatusPreservation() {
        MonitoringStatus monitoringStatus = this;
        synchronized (monitoringStatus) {
            this.mContext.deleteFile("org.altbeacon.beacon.service.monitoring_status_state");
            this.mStatePreservationIsOn = false;
            return;
        }
    }

    public void updateLocalState(Region region, Integer n2) {
        RegionMonitoringState regionMonitoringState = (RegionMonitoringState)this.getRegionsStateMap().get((Object)region);
        if (regionMonitoringState == null) {
            regionMonitoringState = this.addLocalRegion(region);
        }
        if (n2 != null) {
            if (n2 == 0) {
                regionMonitoringState.markOutside();
            }
            if (n2 == 1) {
                regionMonitoringState.markInside();
            }
        }
    }

    protected void updateMonitoringStatusTime(long l2) {
        this.mContext.getFileStreamPath("org.altbeacon.beacon.service.monitoring_status_state").setLastModified(l2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void updateNewlyInsideInRegionsContaining(Beacon beacon) {
        MonitoringStatus monitoringStatus = this;
        synchronized (monitoringStatus) {
            List<Region> list = this.regionsMatchingTo(beacon);
            boolean bl2 = false;
            for (Region region : list) {
                RegionMonitoringState regionMonitoringState = (RegionMonitoringState)this.getRegionsStateMap().get((Object)region);
                if (regionMonitoringState == null || !regionMonitoringState.markInside()) continue;
                bl2 = true;
                regionMonitoringState.getCallback().call(this.mContext, "monitoringData", new MonitoringData(regionMonitoringState.getInside(), region).toBundle());
            }
            if (bl2) {
                this.saveMonitoringStatusIfOn();
            } else {
                this.updateMonitoringStatusTime(System.currentTimeMillis());
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void updateNewlyOutside() {
        MonitoringStatus monitoringStatus = this;
        synchronized (monitoringStatus) {
            Iterator iterator = this.regions().iterator();
            boolean bl2 = false;
            while (iterator.hasNext()) {
                Region region = (Region)iterator.next();
                RegionMonitoringState regionMonitoringState = this.stateOf(region);
                if (!regionMonitoringState.markOutsideIfExpired()) continue;
                LogManager.d(TAG, "found a monitor that expired: %s", region);
                regionMonitoringState.getCallback().call(this.mContext, "monitoringData", new MonitoringData(regionMonitoringState.getInside(), region).toBundle());
                bl2 = true;
            }
            if (bl2) {
                this.saveMonitoringStatusIfOn();
            } else {
                this.updateMonitoringStatusTime(System.currentTimeMillis());
            }
            return;
        }
    }
}

