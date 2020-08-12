/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  com.tapjoy.mraid.controller.Display
 *  java.lang.Object
 *  java.lang.String
 */
package com.tapjoy.mraid.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tapjoy.mraid.controller.Display;

public class ConfigBroadcastReceiver
extends BroadcastReceiver {
    private Display a;
    private int b;

    public ConfigBroadcastReceiver(Display display) {
        this.a = display;
        this.b = this.a.getOrientation();
    }

    public void onReceive(Context context, Intent intent) {
        int n2;
        if (intent.getAction().equals((Object)"android.intent.action.CONFIGURATION_CHANGED") && (n2 = this.a.getOrientation()) != this.b) {
            this.b = n2;
            this.a.onOrientationChanged(this.b);
        }
    }
}

