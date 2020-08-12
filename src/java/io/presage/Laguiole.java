/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.net.ConnectivityManager
 *  android.net.NetworkInfo
 *  java.lang.Object
 *  java.lang.String
 */
package io.presage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import io.presage.Mascare;
import io.presage.ak;

public final class Laguiole {
    @SuppressLint(value={"MissingPermission"})
    public static final NetworkInfo a(Context context) {
        if (Mascare.a(context, "android.permission.ACCESS_NETWORK_STATE")) {
            Object object = context.getSystemService("connectivity");
            if (object != null) {
                return ((ConnectivityManager)object).getActiveNetworkInfo();
            }
            throw new ak("null cannot be cast to non-null type android.net.ConnectivityManager");
        }
        return null;
    }

    public static final boolean a(NetworkInfo networkInfo) {
        return networkInfo.isConnected() && networkInfo.getType() == 1;
    }

    public static final boolean b(Context context) {
        NetworkInfo networkInfo = Laguiole.a(context);
        return networkInfo != null && networkInfo.isConnected();
    }
}

