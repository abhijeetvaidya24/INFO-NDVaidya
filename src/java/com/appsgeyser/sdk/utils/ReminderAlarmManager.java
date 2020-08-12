/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.AlarmManager
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.content.Intent
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 */
package com.appsgeyser.sdk.utils;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.appsgeyser.sdk.configuration.PreferencesCoder;
import com.appsgeyser.sdk.push.AlarmReceiver;

public class ReminderAlarmManager {
    public static void startReminderAlarm(Context context, int n2, boolean bl) {
        AlarmManager alarmManager = (AlarmManager)context.getSystemService("alarm");
        PreferencesCoder preferencesCoder = new PreferencesCoder(context);
        PendingIntent pendingIntent = PendingIntent.getBroadcast((Context)context, (int)994, (Intent)new Intent(context, AlarmReceiver.class), (int)0);
        long l2 = 86400000L * (long)n2;
        if (alarmManager != null) {
            long l3 = System.currentTimeMillis();
            if (bl) {
                alarmManager.cancel(pendingIntent);
                alarmManager.setRepeating(0, l3 + l2, 86400000L, pendingIntent);
                preferencesCoder.savePrefLong("appsgeyserSdk_lastReminderSetTiming", l3);
                return;
            }
            alarmManager.setRepeating(0, l2 + preferencesCoder.getPrefLong("appsgeyserSdk_lastReminderSetTiming", System.currentTimeMillis()), 86400000L, pendingIntent);
        }
    }
}

