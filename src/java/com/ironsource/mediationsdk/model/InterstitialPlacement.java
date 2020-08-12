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

public class InterstitialPlacement {
    private PlacementAvailabilitySettings mPlacementAvailabilitySettings;
    private int mPlacementId;
    private String mPlacementName;

    public InterstitialPlacement(int n2, String string, PlacementAvailabilitySettings placementAvailabilitySettings) {
        this.mPlacementId = n2;
        this.mPlacementName = string;
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

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("placement name: ");
        stringBuilder.append(this.mPlacementName);
        return stringBuilder.toString();
    }
}

