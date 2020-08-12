/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 */
package org.altbeacon.beacon.service;

public interface RssiFilter {
    public void addMeasurement(Integer var1);

    public double calculateRssi();

    public int getMeasurementCount();

    public boolean noMeasurementsAvailable();
}

