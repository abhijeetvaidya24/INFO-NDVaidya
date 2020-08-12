/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.SystemClock
 *  java.io.Serializable
 *  java.lang.Integer
 *  java.lang.Object
 */
package org.altbeacon.beacon.service;

import android.os.SystemClock;
import java.io.Serializable;
import org.altbeacon.beacon.Beacon;
import org.altbeacon.beacon.logging.LogManager;
import org.altbeacon.beacon.service.RssiFilter;

public class RangedBeacon
implements Serializable {
    public static long maxTrackingAge = 5000L;
    private static long sampleExpirationMilliseconds = 20000L;
    protected long lastTrackedTimeMillis = 0L;
    Beacon mBeacon;
    protected transient RssiFilter mFilter = null;
    private boolean mTracked = true;
    private int packetCount = 0;

    public RangedBeacon(Beacon beacon) {
        this.updateBeacon(beacon);
    }

    /*
     * Exception decompiling
     */
    private RssiFilter getFilter() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl27 : ALOAD_0 : trying to set 1 previously set to 0
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

    public void addMeasurement(Integer n2) {
        if (n2 != 127) {
            this.mTracked = true;
            this.lastTrackedTimeMillis = SystemClock.elapsedRealtime();
            this.getFilter().addMeasurement(n2);
        }
    }

    public void commitMeasurements() {
        if (!this.getFilter().noMeasurementsAvailable()) {
            double d2 = this.getFilter().calculateRssi();
            this.mBeacon.setRunningAverageRssi(d2);
            this.mBeacon.setRssiMeasurementCount(this.getFilter().getMeasurementCount());
            Object[] arrobject = new Object[]{d2};
            LogManager.d("RangedBeacon", "calculated new runningAverageRssi: %s", arrobject);
        } else {
            LogManager.d("RangedBeacon", "No measurements available to calculate running average", new Object[0]);
        }
        this.mBeacon.setPacketCount(this.packetCount);
        this.packetCount = 0;
    }

    public Beacon getBeacon() {
        return this.mBeacon;
    }

    public long getTrackingAge() {
        return SystemClock.elapsedRealtime() - this.lastTrackedTimeMillis;
    }

    public boolean isExpired() {
        return this.getTrackingAge() > maxTrackingAge;
    }

    public boolean isTracked() {
        return this.mTracked;
    }

    public boolean noMeasurementsAvailable() {
        return this.getFilter().noMeasurementsAvailable();
    }

    public void setTracked(boolean bl2) {
        this.mTracked = bl2;
    }

    public void updateBeacon(Beacon beacon) {
        this.packetCount = 1 + this.packetCount;
        this.mBeacon = beacon;
        this.addMeasurement(this.mBeacon.getRssi());
    }
}

