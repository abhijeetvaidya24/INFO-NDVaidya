/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 */
package com.ironsource.sdk.data;

import com.ironsource.sdk.listeners.OnAdProductListener;
import java.util.Map;

public class DemandSource {
    private boolean mAvailabilityState;
    private Map<String, String> mExtraParams;
    private int mInitState;
    private OnAdProductListener mListener;
    private int mMediationState = -1;
    private String mName;

    public DemandSource(String string, Map<String, String> map, OnAdProductListener onAdProductListener) {
        this.mName = string;
        this.mExtraParams = map;
        this.mListener = onAdProductListener;
        this.mInitState = 0;
        this.mAvailabilityState = false;
    }

    public boolean getAvailabilityState() {
        return this.mAvailabilityState;
    }

    public int getDemandSourceInitState() {
        return this.mInitState;
    }

    public String getDemandSourceName() {
        return this.mName;
    }

    public Map<String, String> getExtraParams() {
        return this.mExtraParams;
    }

    public OnAdProductListener getListener() {
        return this.mListener;
    }

    public int getMediationState() {
        return this.mMediationState;
    }

    public boolean isMediationState(int n2) {
        return this.mMediationState == n2;
    }

    public void setAvailabilityState(boolean bl2) {
        this.mAvailabilityState = bl2;
    }

    public void setDemandSourceInitState(int n2) {
        DemandSource demandSource = this;
        synchronized (demandSource) {
            this.mInitState = n2;
            return;
        }
    }

    public void setMediationState(int n2) {
        this.mMediationState = n2;
    }
}

