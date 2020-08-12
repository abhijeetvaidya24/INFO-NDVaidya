/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothDevice
 *  java.lang.Object
 */
package org.altbeacon.beacon.service.scanner;

import android.bluetooth.BluetoothDevice;

public interface NonBeaconLeScanCallback {
    public void onNonBeaconLeScan(BluetoothDevice var1, int var2, byte[] var3);
}

