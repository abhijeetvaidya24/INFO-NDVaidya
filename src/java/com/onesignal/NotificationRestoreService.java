/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.IntentService
 *  android.content.Context
 *  android.content.Intent
 *  androidx.legacy.content.WakefulBroadcastReceiver
 *  java.lang.String
 *  java.lang.Thread
 */
package com.onesignal;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.onesignal.NotificationRestorer;
import com.onesignal.OneSignal;

public class NotificationRestoreService
extends IntentService {
    public NotificationRestoreService() {
        super("NotificationRestoreService");
    }

    protected void onHandleIntent(Intent intent) {
        if (intent == null) {
            return;
        }
        Thread.currentThread().setPriority(10);
        OneSignal.setAppContext((Context)this);
        NotificationRestorer.restore((Context)this);
        WakefulBroadcastReceiver.completeWakefulIntent((Intent)intent);
    }
}

