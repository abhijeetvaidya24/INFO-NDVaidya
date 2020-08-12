/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  com.appsgeyser.sdk.server.network.NetworkAvailableReceiver$1
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 */
package com.appsgeyser.sdk.server.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.appsgeyser.sdk.server.network.NetworkAvailableReceiver;
import com.appsgeyser.sdk.server.network.NetworkManager;
import com.appsgeyser.sdk.server.network.OnNetworkStateChangedListener;
import java.util.ArrayList;

public class NetworkAvailableReceiver
extends BroadcastReceiver {
    private final ArrayList<OnNetworkStateChangedListener> listeners = new ArrayList();

    public static NetworkAvailableReceiver createAndRegisterNetworkReceiver(Context context) {
        Class<NetworkAvailableReceiver> class_ = NetworkAvailableReceiver.class;
        synchronized (NetworkAvailableReceiver.class) {
            NetworkAvailableReceiver networkAvailableReceiver = new NetworkAvailableReceiver();
            context.registerReceiver((BroadcastReceiver)networkAvailableReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            // ** MonitorExit[var4_1] (shouldn't be in output)
            return networkAvailableReceiver;
        }
    }

    private void notifyAllListeners(Context context) {
        int n2;
        boolean bl = NetworkManager.isOnline(context);
        if (bl) {
            int n3 = this.listeners.size();
            for (n2 = 0; n2 < n3; ++n2) {
                ((OnNetworkStateChangedListener)this.listeners.get(n2)).networkIsUp();
            }
        } else {
            int n4 = this.listeners.size();
            while (n2 < n4) {
                ((OnNetworkStateChangedListener)this.listeners.get(n2)).networkIsDown();
                ++n2;
            }
        }
    }

    public void addListener(OnNetworkStateChangedListener onNetworkStateChangedListener) {
        if (!this.listeners.contains((Object)onNetworkStateChangedListener)) {
            this.listeners.add((Object)onNetworkStateChangedListener);
        }
    }

    public OnNetworkStateChangedListener createNetworkAvailableListener(Context context) {
        return new 1(this, this.getClass().getSimpleName(), context);
    }

    public void onReceive(Context context, Intent intent) {
        this.notifyAllListeners(context);
    }
}

