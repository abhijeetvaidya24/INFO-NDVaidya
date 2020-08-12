/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  androidx.localbroadcastmanager.content.LocalBroadcastManager
 *  java.io.Serializable
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package org.altbeacon.beacon.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import java.io.Serializable;
import org.altbeacon.beacon.BeaconManager;
import org.altbeacon.beacon.logging.LogManager;

public class Callback
implements Serializable {
    public Callback(String string) {
    }

    public boolean call(Context context, String string, Bundle bundle) {
        if (BeaconManager.getInstanceForApplication(context).getScheduledScanJobsEnabled()) {
            String string2 = string == "rangingData" ? "org.altbeacon.beacon.range_notification" : "org.altbeacon.beacon.monitor_notification";
            Intent intent = new Intent(string2);
            intent.putExtra(string, bundle);
            LogManager.d("Callback", "attempting callback via local broadcast intent: %s", string2);
            return LocalBroadcastManager.getInstance((Context)context).sendBroadcast(intent);
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context.getPackageName(), "org.altbeacon.beacon.BeaconIntentProcessor"));
        intent.putExtra(string, bundle);
        Object[] arrobject = new Object[]{intent.getComponent()};
        LogManager.d("Callback", "attempting callback via global broadcast intent: %s", arrobject);
        try {
            context.startService(intent);
            return true;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed attempting to start service: ");
            stringBuilder.append(intent.getComponent().flattenToString());
            LogManager.e("Callback", stringBuilder.toString(), new Object[]{exception});
            return false;
        }
    }
}

