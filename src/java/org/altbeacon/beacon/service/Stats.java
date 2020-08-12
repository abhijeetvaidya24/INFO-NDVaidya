/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.text.SimpleDateFormat
 *  java.util.ArrayList
 *  java.util.Date
 *  java.util.Iterator
 */
package org.altbeacon.beacon.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import org.altbeacon.beacon.Beacon;
import org.altbeacon.beacon.logging.LogManager;

public class Stats {
    private static final Stats INSTANCE = new Stats();
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("HH:mm:ss.SSS");
    private boolean mEnableHistoricalLogging;
    private boolean mEnableLogging;
    private boolean mEnabled;
    private Sample mSample;
    private long mSampleIntervalMillis = 0L;
    private ArrayList<Sample> mSamples;

    private Stats() {
        this.clearSamples();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private String formattedDate(Date date) {
        SimpleDateFormat simpleDateFormat;
        if (date == null) return "";
        SimpleDateFormat simpleDateFormat2 = simpleDateFormat = SIMPLE_DATE_FORMAT;
        synchronized (simpleDateFormat2) {
            return SIMPLE_DATE_FORMAT.format(date);
        }
    }

    public static Stats getInstance() {
        return INSTANCE;
    }

    private void logSample(Sample sample, boolean bl2) {
        if (bl2) {
            LogManager.d("Stats", "sample start time, sample stop time, first detection time, last detection time, max millis between detections, detection count", new Object[0]);
        }
        Object[] arrobject = new Object[]{this.formattedDate(sample.sampleStartTime), this.formattedDate(sample.sampleStopTime), this.formattedDate(sample.firstDetectionTime), this.formattedDate(sample.lastDetectionTime), sample.maxMillisBetweenDetections, sample.detectionCount};
        LogManager.d("Stats", "%s, %s, %s, %s, %s, %s", arrobject);
    }

    private void logSamples() {
        boolean bl2 = true;
        Object[] arrobject = new Object[bl2];
        arrobject[0] = this.mSamples.size();
        LogManager.d("Stats", "--- Stats for %s samples", arrobject);
        Iterator iterator = this.mSamples.iterator();
        while (iterator.hasNext()) {
            this.logSample((Sample)iterator.next(), bl2);
            bl2 = false;
        }
    }

    private void rollSampleIfNeeded() {
        if (this.mSample == null || this.mSampleIntervalMillis > 0L && new Date().getTime() - this.mSample.sampleStartTime.getTime() >= this.mSampleIntervalMillis) {
            this.newSampleInterval();
        }
    }

    public void clearSamples() {
        this.mSamples = new ArrayList();
        this.newSampleInterval();
    }

    public boolean isEnabled() {
        return this.mEnabled;
    }

    public void log(Beacon beacon) {
        long l2;
        this.rollSampleIfNeeded();
        Sample sample = this.mSample;
        sample.detectionCount = 1L + sample.detectionCount;
        if (this.mSample.firstDetectionTime == null) {
            this.mSample.firstDetectionTime = new Date();
        }
        if (this.mSample.lastDetectionTime != null && (l2 = new Date().getTime() - this.mSample.lastDetectionTime.getTime()) > this.mSample.maxMillisBetweenDetections) {
            this.mSample.maxMillisBetweenDetections = l2;
        }
        this.mSample.lastDetectionTime = new Date();
    }

    public void newSampleInterval() {
        Date date = new Date();
        Sample sample = this.mSample;
        if (sample != null) {
            date = new Date(sample.sampleStartTime.getTime() + this.mSampleIntervalMillis);
            Sample sample2 = this.mSample;
            sample2.sampleStopTime = date;
            if (!this.mEnableHistoricalLogging && this.mEnableLogging) {
                this.logSample(sample2, true);
            }
        }
        Sample sample3 = this.mSample = new Sample();
        sample3.sampleStartTime = date;
        this.mSamples.add((Object)sample3);
        if (this.mEnableHistoricalLogging) {
            this.logSamples();
        }
    }

    public static class Sample {
        public long detectionCount = 0L;
        public Date firstDetectionTime;
        public Date lastDetectionTime;
        public long maxMillisBetweenDetections;
        public Date sampleStartTime;
        public Date sampleStopTime;
    }

}

