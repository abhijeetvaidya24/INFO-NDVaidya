/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.content.Context
 *  java.lang.String
 *  org.altbeacon.beacon.service.scanner.CycledLeScannerForLollipop
 */
package org.altbeacon.beacon.service.scanner;

import android.annotation.TargetApi;
import android.content.Context;
import org.altbeacon.beacon.service.scanner.CycledLeScanCallback;
import org.altbeacon.beacon.service.scanner.CycledLeScannerForLollipop;
import org.altbeacon.bluetooth.BluetoothCrashResolver;

@TargetApi(value=26)
class CycledLeScannerForAndroidO
extends CycledLeScannerForLollipop {
    private static final String TAG = "CycledLeScannerForAndroidO";

    CycledLeScannerForAndroidO(Context context, long l2, long l3, boolean bl2, CycledLeScanCallback cycledLeScanCallback, BluetoothCrashResolver bluetoothCrashResolver) {
        super(context, l2, l3, bl2, cycledLeScanCallback, bluetoothCrashResolver);
    }
}

