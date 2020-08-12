/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.IntentService
 *  android.content.Context
 *  android.content.Intent
 *  java.lang.String
 */
package org.altbeacon.beacon;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import org.altbeacon.beacon.IntentHandler;

public class BeaconIntentProcessor
extends IntentService {
    public BeaconIntentProcessor() {
        super("BeaconIntentProcessor");
    }

    protected void onHandleIntent(Intent intent) {
        new IntentHandler().convertIntentsToCallbacks(this.getApplicationContext(), intent);
    }
}

