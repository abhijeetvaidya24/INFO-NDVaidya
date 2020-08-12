/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.net.ConnectivityManager
 *  android.net.NetworkInfo
 *  android.os.Bundle
 *  java.lang.Object
 *  java.lang.String
 */
package com.ironsource.environment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

public class NetworkStateReceiver
extends BroadcastReceiver {
    private boolean mConnected;
    private NetworkStateReceiverListener mListener;
    private ConnectivityManager mManager;

    public NetworkStateReceiver(Context context, NetworkStateReceiverListener networkStateReceiverListener) {
        this.mListener = networkStateReceiverListener;
        this.mManager = (ConnectivityManager)context.getSystemService("connectivity");
        this.checkAndSetState();
    }

    private boolean checkAndSetState() {
        boolean bl2 = this.mConnected;
        NetworkInfo networkInfo = this.mManager.getActiveNetworkInfo();
        boolean bl3 = networkInfo != null && networkInfo.isConnectedOrConnecting();
        this.mConnected = bl3;
        return bl2 != this.mConnected;
    }

    private void notifyState() {
        NetworkStateReceiverListener networkStateReceiverListener = this.mListener;
        if (networkStateReceiverListener != null) {
            if (this.mConnected) {
                networkStateReceiverListener.onNetworkAvailabilityChanged(true);
                return;
            }
            networkStateReceiverListener.onNetworkAvailabilityChanged(false);
        }
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            if (intent.getExtras() == null) {
                return;
            }
            if (this.checkAndSetState()) {
                this.notifyState();
            }
        }
    }

    public static interface NetworkStateReceiverListener {
        public void onNetworkAvailabilityChanged(boolean var1);
    }

}

