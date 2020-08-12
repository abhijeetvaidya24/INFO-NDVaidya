/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.ConnectivityManager
 *  android.net.NetworkInfo
 *  java.lang.Object
 *  java.lang.String
 */
package com.adincube.sdk.util.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.adincube.sdk.util.b.f;

public final class g {
    public static NetworkInfo a(Context context) {
        if (!f.a(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return null;
        }
        NetworkInfo networkInfo = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            return networkInfo;
        }
        return null;
    }
}

