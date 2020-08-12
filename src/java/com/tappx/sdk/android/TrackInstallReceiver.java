/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  java.lang.String
 */
package com.tappx.sdk.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tappx.a.a.a.c.a;
import com.tappx.a.a.a.i.b.e;

public class TrackInstallReceiver
extends BroadcastReceiver {
    private final e a = new e();

    public void onReceive(Context context, Intent intent) {
        if (intent.hasExtra("ilp")) {
            a.a(intent.getStringExtra("ilp"));
            return;
        }
        if ("com.android.vending.INSTALL_REFERRER".equalsIgnoreCase(intent.getAction())) {
            this.a.a(context, intent);
        }
    }
}

