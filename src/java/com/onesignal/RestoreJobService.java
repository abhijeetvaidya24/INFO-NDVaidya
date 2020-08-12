/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.IBinder
 */
package com.onesignal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.onesignal.BundleCompatBundle;
import com.onesignal.JobIntentService;
import com.onesignal.NotificationBundleProcessor;

public class RestoreJobService
extends JobIntentService {
    @Override
    protected final void onHandleWork(Intent intent) {
        if (intent == null) {
            return;
        }
        Bundle bundle = intent.getExtras();
        if (bundle == null) {
            return;
        }
        NotificationBundleProcessor.ProcessFromGCMIntentService(this.getApplicationContext(), new BundleCompatBundle(bundle), null);
    }
}

