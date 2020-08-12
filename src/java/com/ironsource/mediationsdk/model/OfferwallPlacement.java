/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.ironsource.mediationsdk.model;

public class OfferwallPlacement {
    private int mPlacementId;
    private String mPlacementName;

    public OfferwallPlacement(int n2, String string) {
        this.mPlacementId = n2;
        this.mPlacementName = string;
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
        stringBuilder.append(", placement id: ");
        stringBuilder.append(this.mPlacementId);
        return stringBuilder.toString();
    }
}

