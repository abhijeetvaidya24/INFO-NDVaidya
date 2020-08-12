/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Service
 *  android.content.Context
 *  android.content.Intent
 *  android.os.IBinder
 *  com.onesignal.OneSignalSyncServiceUtils$LegacySyncRunnable
 */
package com.onesignal;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.onesignal.OneSignalSyncServiceUtils;

/*
 * Exception performing whole class analysis.
 */
public class SyncService
extends Service {
    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand(Intent intent, int n2, int n3) {
        OneSignalSyncServiceUtils.doBackgroundSync((Context)this, (OneSignalSyncServiceUtils.SyncRunnable)new /* Unavailable Anonymous Inner Class!! */);
        return 1;
    }
}

