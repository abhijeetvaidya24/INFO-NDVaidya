/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.CloneNotSupportedException
 *  java.lang.Cloneable
 *  java.lang.Object
 *  java.lang.String
 */
package com.appsgeyser.sdk.deviceidparser;

import com.appsgeyser.sdk.deviceidparser.LimitAdTrackingEnabledStates;

public class DeviceIdParameters
implements Cloneable {
    private String aId = null;
    private String advId = null;
    private LimitAdTrackingEnabledStates limitAdTrackingEnabledStates = null;

    DeviceIdParameters() {
    }

    void clear() {
        this.advId = null;
        this.aId = null;
        this.limitAdTrackingEnabledStates = null;
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getAdvId() {
        return this.advId;
    }

    void setAdvId(String string2) {
        this.advId = string2;
    }

    void setLimitAdTrackingEnabled(LimitAdTrackingEnabledStates limitAdTrackingEnabledStates) {
        this.limitAdTrackingEnabledStates = limitAdTrackingEnabledStates;
    }

    void setaId(String string2) {
        this.aId = string2;
    }
}

