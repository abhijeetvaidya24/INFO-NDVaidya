/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.ironsource.mediationsdk.model;

public class ApplicationEvents {
    private int mBackupThreshold;
    private String mEventsType;
    private int mMaxEventsPerBatch;
    private int mMaxNumberOfEvents;
    private int[] mOptOutEvents;
    private boolean mSendEventsToggle;
    private boolean mSendUltraEvents;
    private String mServerEventsURL;

    public ApplicationEvents() {
    }

    public ApplicationEvents(boolean bl2, boolean bl3, String string, String string2, int n2, int n3, int n4, int[] arrn) {
        this.mSendUltraEvents = bl2;
        this.mSendEventsToggle = bl3;
        this.mServerEventsURL = string;
        this.mEventsType = string2;
        this.mBackupThreshold = n2;
        this.mMaxNumberOfEvents = n3;
        this.mMaxEventsPerBatch = n4;
        this.mOptOutEvents = arrn;
    }

    public int getEventsBackupThreshold() {
        return this.mBackupThreshold;
    }

    public String getEventsType() {
        return this.mEventsType;
    }

    public String getEventsURL() {
        return this.mServerEventsURL;
    }

    public int getMaxEventsPerBatch() {
        return this.mMaxEventsPerBatch;
    }

    public int getMaxNumberOfEvents() {
        return this.mMaxNumberOfEvents;
    }

    public int[] getOptOutEvents() {
        return this.mOptOutEvents;
    }

    public boolean isEventsEnabled() {
        return this.mSendEventsToggle;
    }

    public boolean isUltraEventsEnabled() {
        return this.mSendUltraEvents;
    }
}

