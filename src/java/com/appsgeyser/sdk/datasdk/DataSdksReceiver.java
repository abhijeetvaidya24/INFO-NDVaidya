/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  com.android.volley.Response
 *  com.android.volley.Response$ErrorListener
 *  com.android.volley.Response$Listener
 *  com.appsgeyser.sdk.datasdk.DataSdksReceiver$1
 *  com.appsgeyser.sdk.datasdk.DataSdksReceiver$2
 *  java.lang.Integer
 *  java.lang.String
 */
package com.appsgeyser.sdk.datasdk;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.android.volley.Response;
import com.appsgeyser.sdk.configuration.PreferencesCoder;
import com.appsgeyser.sdk.datasdk.DataSdksReceiver;
import com.appsgeyser.sdk.server.network.NetworkManager;

public class DataSdksReceiver
extends BroadcastReceiver {
    static /* synthetic */ void access$000(DataSdksReceiver dataSdksReceiver, Context context, Intent intent) {
        dataSdksReceiver.passDataToSdk(context, intent);
    }

    static /* synthetic */ void access$100(DataSdksReceiver dataSdksReceiver, Context context, Intent intent) {
        dataSdksReceiver.onServerError(context, intent);
    }

    private void onServerError(Context context, Intent intent) {
        new PreferencesCoder(context);
        this.passDataToSdk(context, intent);
    }

    private void passDataToSdk(Context context, Intent intent) {
        intent.getAction();
    }

    @SuppressLint(value={"UnsafeProtectedBroadcastReceiver"})
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String string2 = new PreferencesCoder(context).getPrefString("ConfigPhpURLWithParams", "");
            1 var4_4 = new 1(this, context, intent);
            2 var5_5 = new 2(this, context, intent);
            NetworkManager.getInstance().sendRequestAsync(string2, (Integer)NetworkManager.RequestType.CONFIG_PHP.ordinal(), context, (Response.Listener<String>)var4_4, (Response.ErrorListener)var5_5);
        }
    }
}

