/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.bluetooth.le.ScanResult
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Build
 *  android.os.Build$VERSION
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.List
 */
package org.altbeacon.beacon.startup;

import android.bluetooth.le.ScanResult;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import java.util.ArrayList;
import java.util.List;
import org.altbeacon.beacon.BeaconManager;
import org.altbeacon.beacon.logging.LogManager;
import org.altbeacon.beacon.service.ScanJobScheduler;

public class StartupBroadcastReceiver
extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        LogManager.d("StartupBroadcastReceiver", "onReceive called in startup broadcast receiver", new Object[0]);
        if (Build.VERSION.SDK_INT < 18) {
            Object[] arrobject = new Object[]{Build.VERSION.SDK_INT};
            LogManager.w("StartupBroadcastReceiver", "Not starting up beacon service because we do not have API version 18 (Android 4.3).  We have: %s", arrobject);
            return;
        }
        BeaconManager beaconManager = BeaconManager.getInstanceForApplication(context.getApplicationContext());
        if (!beaconManager.isAnyConsumerBound() && !beaconManager.getScheduledScanJobsEnabled()) {
            LogManager.d("StartupBroadcastReceiver", "No consumers are bound.  Ignoring broadcast receiver.", new Object[0]);
            return;
        }
        int n2 = intent.getIntExtra("android.bluetooth.le.extra.CALLBACK_TYPE", -1);
        if (n2 != -1) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Passive background scan callback type: ");
            stringBuilder.append(n2);
            LogManager.d("StartupBroadcastReceiver", stringBuilder.toString(), new Object[0]);
            LogManager.d("StartupBroadcastReceiver", "got Android O background scan via intent", new Object[0]);
            int n3 = intent.getIntExtra("android.bluetooth.le.extra.ERROR_CODE", -1);
            if (n3 != -1) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Passive background scan failed.  Code; ");
                stringBuilder2.append(n3);
                LogManager.w("StartupBroadcastReceiver", stringBuilder2.toString(), new Object[0]);
            }
            ArrayList arrayList = intent.getParcelableArrayListExtra("android.bluetooth.le.extra.LIST_SCAN_RESULT");
            ScanJobScheduler.getInstance().scheduleAfterBackgroundWakeup(context, (List<ScanResult>)arrayList);
            return;
        }
        if (intent.getBooleanExtra("wakeup", false)) {
            LogManager.d("StartupBroadcastReceiver", "got wake up intent", new Object[0]);
            return;
        }
        Object[] arrobject = new Object[]{intent, intent.getStringExtra("wakeup")};
        LogManager.d("StartupBroadcastReceiver", "Already started.  Ignoring intent: %s of type: %s", arrobject);
    }
}

