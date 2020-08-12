/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.AlarmManager
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.content.Intent
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.SystemClock
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 */
package io.presage.core;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.SystemClock;
import io.presage.core.lIIIIIlI;
import io.presage.core.receiver.AlarmReceiver;

public final class lIlIIIII {
    public static final String IIIIIIII;
    private static final String IIIIIIll;
    private static final String IIIIIlII;
    private static lIlIIIII IIIIIlIl;
    public Context IIIIIIIl;
    public SharedPreferences IIIIIIlI;

    static {
        IIIIIIll = lIIIIIlI.IIIIIIII.IIIIIIII;
        IIIIIlII = lIIIIIlI.IIIIIIII.IIIIIIIl;
        IIIIIIII = lIIIIIlI.IIIIIIII.IIIIIIlI;
    }

    private lIlIIIII(Context context) {
        this.IIIIIIIl = context;
        this.IIIIIIlI = this.IIIIIIIl.getSharedPreferences(IIIIIIll, 0);
    }

    public static lIlIIIII IIIIIIII(Context context) {
        if (IIIIIlIl == null) {
            IIIIIlIl = new lIlIIIII(context);
        }
        return IIIIIlIl;
    }

    public final void IIIIIIII() {
        if (this.IIIIIIlI()) {
            new Object[1][0] = this.IIIIIIIl();
            Intent intent = new Intent(this.IIIIIIIl, AlarmReceiver.class);
            if (PendingIntent.getBroadcast((Context)this.IIIIIIIl, (int)0, (Intent)intent, (int)536870912) == null) {
                PendingIntent pendingIntent = PendingIntent.getBroadcast((Context)this.IIIIIIIl, (int)0, (Intent)intent, (int)0);
                AlarmManager alarmManager = (AlarmManager)this.IIIIIIIl.getSystemService("alarm");
                if (Build.VERSION.SDK_INT >= 19) {
                    alarmManager.setExact(3, SystemClock.elapsedRealtime() + this.IIIIIIIl(), pendingIntent);
                    return;
                }
                alarmManager.set(3, SystemClock.elapsedRealtime() + this.IIIIIIIl(), pendingIntent);
            }
        }
    }

    public final void IIIIIIII(boolean bl2) {
        SharedPreferences.Editor editor = this.IIIIIIlI.edit();
        editor.putBoolean(IIIIIlII, bl2);
        editor.apply();
    }

    public final long IIIIIIIl() {
        return this.IIIIIIlI.getLong(IIIIIIII, 0L);
    }

    public final boolean IIIIIIlI() {
        return this.IIIIIIlI.getBoolean(IIIIIlII, false);
    }
}

