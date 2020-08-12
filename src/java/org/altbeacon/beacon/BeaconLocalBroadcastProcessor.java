/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  androidx.localbroadcastmanager.content.LocalBroadcastManager
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package org.altbeacon.beacon;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import org.altbeacon.beacon.IntentHandler;
import org.altbeacon.beacon.logging.LogManager;

public class BeaconLocalBroadcastProcessor {
    static int registerCallCount;
    private Context mContext;
    private BroadcastReceiver mLocalBroadcastReceiver = new BroadcastReceiver(){

        public void onReceive(Context context, Intent intent) {
            new IntentHandler().convertIntentsToCallbacks(context, intent);
        }
    };
    int registerCallCountForInstnace = 0;

    private BeaconLocalBroadcastProcessor() {
    }

    public BeaconLocalBroadcastProcessor(Context context) {
        this.mContext = context;
    }

    public void register() {
        registerCallCount = 1 + registerCallCount;
        this.registerCallCountForInstnace = 1 + this.registerCallCountForInstnace;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Register calls: global=");
        stringBuilder.append(registerCallCount);
        stringBuilder.append(" instance=");
        stringBuilder.append(this.registerCallCountForInstnace);
        LogManager.d("BeaconLocalBroadcastProcessor", stringBuilder.toString(), new Object[0]);
        this.unregister();
        LocalBroadcastManager.getInstance((Context)this.mContext).registerReceiver(this.mLocalBroadcastReceiver, new IntentFilter("org.altbeacon.beacon.range_notification"));
        LocalBroadcastManager.getInstance((Context)this.mContext).registerReceiver(this.mLocalBroadcastReceiver, new IntentFilter("org.altbeacon.beacon.monitor_notification"));
    }

    public void unregister() {
        LocalBroadcastManager.getInstance((Context)this.mContext).unregisterReceiver(this.mLocalBroadcastReceiver);
    }

}

