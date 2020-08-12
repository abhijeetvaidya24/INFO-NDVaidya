/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.AlarmManager
 *  android.app.PendingIntent
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.SystemClock
 *  io.presage.core.receiver.AlarmReceiver$1
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 */
package io.presage.core.receiver;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;
import io.presage.core.IIIIIIII;
import io.presage.core.IIIIIIIl;
import io.presage.core.lIlIIIII;
import io.presage.core.receiver.AlarmReceiver;

public class AlarmReceiver
extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        lIlIIIII lIlIIIII2 = lIlIIIII.IIIIIIII(context);
        new Object[1][0] = lIlIIIII2.IIIIIIIl();
        if (lIlIIIII2.IIIIIIlI()) {
            Intent intent2 = new Intent(lIlIIIII2.IIIIIIIl, AlarmReceiver.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast((Context)lIlIIIII2.IIIIIIIl, (int)0, (Intent)intent2, (int)268435456);
            AlarmManager alarmManager = (AlarmManager)lIlIIIII2.IIIIIIIl.getSystemService("alarm");
            if (Build.VERSION.SDK_INT >= 19) {
                alarmManager.setExact(3, SystemClock.elapsedRealtime() + lIlIIIII2.IIIIIIIl(), pendingIntent);
            } else {
                alarmManager.set(3, SystemClock.elapsedRealtime() + lIlIIIII2.IIIIIIIl(), pendingIntent);
            }
        }
        try {
            IIIIIIII.IIIIIIII(context).IIIIIIII((IIIIIIII.IIIIIIII)new 1(this));
        }
        catch (IIIIIIIl iIIIIIIl) {}
    }
}

