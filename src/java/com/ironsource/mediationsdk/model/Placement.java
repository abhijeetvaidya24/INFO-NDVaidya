/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.ironsource.mediationsdk.model;

import com.ironsource.mediationsdk.model.PlacementAvailabilitySettings;

public class Placement {
    private PlacementAvailabilitySettings mPlacementAvailabilitySettings;
    private int mPlacementId;
    private String mPlacementName;
    private int mRewardAmount;
    private String mRewardName;

    public Placement(int n2, String string, String string2, int n3, PlacementAvailabilitySettings placementAvailabilitySettings) {
        this.mPlacementId = n2;
        this.mPlacementName = string;
        this.mRewardName = string2;
        this.mRewardAmount = n3;
        this.mPlacementAvailabilitySettings = placementAvailabilitySettings;
    }

    public PlacementAvailabilitySettings getPlacementAvailabilitySettings() {
        return this.mPlacementAvailabilitySettings;
    }

    public int getPlacementId() {
        return this.mPlacementId;
    }

    public String getPlacementName() {
        return this.mPlacementName;
    }

    public int getRewardAmount() {
        return this.mRewardAmount;
    }

    public String getRewardName() {
        return this.mRewardName;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("placement name: ");
        stringBuilder.append(this.mPlacementName);
        stringBuilder.append(", reward name: ");
        stringBuilder.append(this.mRewardName);
        stringBuilder.append(" , amount:");
        stringBuilder.append(this.mRewardAmount);
        return stringBuilder.toString();
    }
}

