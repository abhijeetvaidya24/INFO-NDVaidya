/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Service
 *  android.content.Context
 *  android.content.Intent
 *  android.os.IBinder
 *  java.lang.String
 */
package com.appsgeyser.sdk.push;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.appsgeyser.sdk.utils.ReminderAlarmManager;

public class AlarmService
extends Service {
    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand(Intent intent, int n2, int n3) {
        ReminderAlarmManager.startReminderAlarm((Context)this, intent.getIntExtra("days_inactivity", 1), false);
        return 2;
    }
}

