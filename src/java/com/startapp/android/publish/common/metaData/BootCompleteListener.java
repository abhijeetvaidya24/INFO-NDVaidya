/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.os.SystemClock
 *  java.lang.Exception
 *  java.lang.Long
 *  java.lang.String
 */
package com.startapp.android.publish.common.metaData;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.startapp.android.publish.adsCommon.Utils.b;
import com.startapp.android.publish.adsCommon.f.d;
import com.startapp.android.publish.adsCommon.f.f;
import com.startapp.common.a.g;

public class BootCompleteListener
extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        try {
            g.a(3, "BootCompleteListener - onReceive");
            long l2 = 60000L + SystemClock.elapsedRealtime();
            b.a(context);
            b.a(context, (Long)l2);
            b.a(context, l2);
            return;
        }
        catch (Exception exception) {
            f.a(context, d.b, "BootCompleteListener.onReceive - failed to start services", exception.getMessage(), "");
            return;
        }
    }
}

