/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.net.ConnectivityManager
 *  android.net.NetworkInfo
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.SecurityException
 *  java.lang.String
 */
package com.adcolony.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.adcolony.sdk.a;
import com.adcolony.sdk.y;

class ah {
    ah() {
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @SuppressLint(value={"MissingPermission"})
    boolean a() {
        ConnectivityManager connectivityManager;
        block5 : {
            Context context = a.c();
            if (context == null) {
                return false;
            }
            connectivityManager = (ConnectivityManager)context.getApplicationContext().getSystemService("connectivity");
            if (connectivityManager != null) break block5;
            return false;
        }
        try {
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo == null) return false;
            int n2 = networkInfo.getType();
            boolean bl = false;
            if (n2 != 1) return bl;
            return true;
        }
        catch (Exception exception) {
            new y.a().a("Exception occurred when retrieving activeNetworkInfo in ").a("ADCNetwork.using_wifi(): ").a(exception.toString()).a(y.h);
            return false;
        }
        catch (SecurityException securityException) {
            new y.a().a("SecurityException - please ensure you added the ").a("ACCESS_NETWORK_STATE permission: ").a(securityException.toString()).a(y.g);
            return false;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @SuppressLint(value={"MissingPermission"})
    boolean b() {
        ConnectivityManager connectivityManager;
        block5 : {
            Context context = a.c();
            if (context == null) {
                return false;
            }
            connectivityManager = (ConnectivityManager)context.getApplicationContext().getSystemService("connectivity");
            if (connectivityManager != null) break block5;
            return false;
        }
        try {
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo == null) return false;
            int n2 = networkInfo.getType();
            if (n2 == 0) return true;
            boolean bl = false;
            if (n2 < 2) return bl;
            return true;
        }
        catch (Exception exception) {
            new y.a().a("Exception occurred when retrieving activeNetworkInfo in ").a("ADCNetwork.using_mobile(): ").a(exception.toString()).a(y.h);
            return false;
        }
        catch (SecurityException securityException) {
            new y.a().a("SecurityException - please ensure you added the ").a("ACCESS_NETWORK_STATE permission: ").a(securityException.toString()).a(y.g);
            return false;
        }
    }

    String c() {
        if (this.a()) {
            return "wifi";
        }
        if (this.b()) {
            return "cell";
        }
        return "none";
    }
}

