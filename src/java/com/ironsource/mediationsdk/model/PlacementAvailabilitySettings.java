/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.ironsource.mediationsdk.model;

import com.ironsource.mediationsdk.model.PlacementCappingType;

public class PlacementAvailabilitySettings {
    private PlacementCappingType cappingType;
    private int cappingValue;
    private boolean isCappingEnabled;
    private boolean isDeliveryEnabled;
    private boolean isPacingEnabled;
    private int pacingValue;

    private PlacementAvailabilitySettings(boolean bl2, boolean bl3, boolean bl4, PlacementCappingType placementCappingType, int n2, int n3) {
        this.isDeliveryEnabled = bl2;
        this.isCappingEnabled = bl3;
        this.isPacingEnabled = bl4;
        this.cappingType = placementCappingType;
        this.cappingValue = n2;
        this.pacingValue = n3;
    }

    public PlacementCappingType getCappingType() {
        return this.cappingType;
    }

    public int getCappingValue() {
        return this.cappingValue;
    }

    public int getPacingValue() {
        return this.pacingValue;
    }

    public boolean isCappingEnabled() {
        return this.isCappingEnabled;
    }

    public boolean isDeliveryEnabled() {
        return this.isDeliveryEnabled;
    }

    public boolean isPacingEnabled() {
        return this.isPacingEnabled;
    }

    public static class PlacementAvailabilitySettingsBuilder {
        private PlacementCappingType cappingType = null;
        private int cappingValue = 0;
        private boolean isCappingEnabled = false;
        private boolean isDeliveryEnabled = true;
        private boolean isPacingEnabled = false;
        private int pacingValue = 0;

        public PlacementAvailabilitySettings build() {
            PlacementAvailabilitySettings placementAvailabilitySettings = new PlacementAvailabilitySettings(this.isDeliveryEnabled, this.isCappingEnabled, this.isPacingEnabled, this.cappingType, this.cappingValue, this.pacingValue);
            return placementAvailabilitySettings;
        }

        public PlacementAvailabilitySettingsBuilder capping(boolean bl2, PlacementCappingType placementCappingType, int n2) {
            this.isCappingEnabled = bl2;
            if (placementCappingType == null) {
                placementCappingType = PlacementCappingType.PER_DAY;
            }
            this.cappingType = placementCappingType;
            this.cappingValue = n2;
            return this;
        }

        public PlacementAvailabilitySettingsBuilder delivery(boolean bl2) {
            this.isDeliveryEnabled = bl2;
            return this;
        }

        public PlacementAvailabilitySettingsBuilder pacing(boolean bl2, int n2) {
            this.isPacingEnabled = bl2;
            this.pacingValue = n2;
            return this;
        }
    }

}

