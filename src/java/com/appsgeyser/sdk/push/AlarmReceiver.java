/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.app.NotificationChannel
 *  android.app.NotificationManager
 *  android.app.PendingIntent
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.os.Build
 *  android.os.Build$VERSION
 *  androidx.core.app.NotificationCompat
 *  androidx.core.app.NotificationCompat$Builder
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 */
package com.appsgeyser.sdk.push;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.appsgeyser.sdk.R;
import com.appsgeyser.sdk.configuration.PreferencesCoder;
import com.appsgeyser.sdk.configuration.models.ConfigPhp;

public class AlarmReceiver
extends BroadcastReceiver {
    private void createNotificationChannel(Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel("Appsgeyser_channel_id", (CharSequence)context.getString(R.string.app_name), 3);
            notificationChannel.setDescription("");
            NotificationManager notificationManager = (NotificationManager)context.getSystemService(NotificationManager.class);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(notificationChannel);
            }
        }
    }

    public void onReceive(Context context, Intent intent) {
        String string2 = "";
        String string3 = new PreferencesCoder(context).getPrefString("ServerResponse", null);
        if (string3 != null) {
            String string4;
            String string5 = ConfigPhp.parseFromJson(string3).getInactivityReminderText();
            PackageManager packageManager = context.getPackageManager();
            try {
                string4 = (String)packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 128));
            }
            catch (PackageManager.NameNotFoundException nameNotFoundException) {
                nameNotFoundException.printStackTrace();
                string4 = string2;
            }
            PendingIntent pendingIntent = PendingIntent.getActivity((Context)context, (int)0, (Intent)context.getPackageManager().getLaunchIntentForPackage(context.getPackageName()), (int)1073741824);
            NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "Appsgeyser_channel_id");
            NotificationCompat.Builder builder2 = builder.setAutoCancel(true).setDefaults(-1).setWhen(System.currentTimeMillis()).setSmallIcon(R.drawable.ic_os_notification_fallback_white_24dp).setContentTitle((CharSequence)string4).setContentIntent(pendingIntent);
            if (string5 != null) {
                string2 = string5;
            }
            builder2.setContentText((CharSequence)string2).setDefaults(5).setPriority(1);
            this.createNotificationChannel(context);
            NotificationManager notificationManager = (NotificationManager)context.getSystemService("notification");
            if (notificationManager != null) {
                notificationManager.notify(1, builder.build());
            }
        }
    }
}

