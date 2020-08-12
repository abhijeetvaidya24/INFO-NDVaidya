/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.gson.annotations.SerializedName
 *  java.lang.Object
 */
package com.appsgeyser.sdk.configuration.models;

import com.google.gson.annotations.SerializedName;

public class AdNetworkSdkModel {
    @SerializedName(value="active")
    private boolean isActive;

    public boolean isActive() {
        return this.isActive;
    }
}

