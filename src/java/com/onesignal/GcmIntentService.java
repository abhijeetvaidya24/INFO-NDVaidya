/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.IntentService
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  com.onesignal.BundleCompatBundle
 *  com.onesignal.GcmBroadcastReceiver
 *  java.lang.String
 */
package com.onesignal;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.onesignal.BundleCompat;
import com.onesignal.BundleCompatBundle;
import com.onesignal.GcmBroadcastReceiver;
import com.onesignal.NotificationBundleProcessor;

public class GcmIntentService
extends IntentService {
    public GcmIntentService() {
        super("GcmIntentService");
        this.setIntentRedelivery(true);
    }

    protected void onHandleIntent(Intent intent) {
        Bundle bundle = intent.getExtras();
        if (bundle == null) {
            return;
        }
        NotificationBundleProcessor.ProcessFromGCMIntentService((Context)this, (BundleCompat)new BundleCompatBundle(bundle), null);
        GcmBroadcastReceiver.completeWakefulIntent((Intent)intent);
    }
}

