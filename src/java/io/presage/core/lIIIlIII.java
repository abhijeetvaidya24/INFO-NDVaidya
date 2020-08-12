/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.ConnectivityManager
 *  android.net.Network
 *  android.net.NetworkCapabilities
 *  android.net.NetworkInfo
 *  android.os.Build
 *  android.os.Build$VERSION
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 */
package io.presage.core;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import io.presage.core.lIIIlIlI;

public final class lIIIlIII {
    private static final String IIIIIIII = lIIIlIlI.IIIlllIl.IIIIIIIl;
    private static final String IIIIIIIl = lIIIlIlI.IIIlllIl.IIIIIIII;
    private static final String IIIIIIlI = lIIIlIlI.IIIlllIl.IIIIIIlI;

    public static String IIIIIIII() {
        return System.getProperty((String)IIIIIIlI);
    }

    public static boolean IIIIIIII(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService("connectivity");
        if (Build.VERSION.SDK_INT >= 23) {
            Network network = connectivityManager.getActiveNetwork();
            if (network == null) {
                return false;
            }
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(network);
            if (networkCapabilities == null) {
                return false;
            }
            return networkCapabilities.hasTransport(1);
        }
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo == null) {
            return false;
        }
        return networkInfo.getType() == 1;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean IIIIIIIl(Context context) {
        if (lIIIlIII.IIIIIIII(context)) return true;
        ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService("connectivity");
        if (Build.VERSION.SDK_INT < 23) {
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo == null) return false;
            if (networkInfo.getType() != 0) return false;
            return true;
        }
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
        if (networkCapabilities == null) return false;
        boolean bl2 = networkCapabilities.hasTransport(0);
        if (!bl2) return false;
        return true;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static String IIIIIIlI(Context context) {
        StringBuilder stringBuilder;
        ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService("connectivity");
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo == null) {
            return IIIIIIII;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            Network network = connectivityManager.getActiveNetwork();
            if (network == null) {
                return IIIIIIII;
            }
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(network);
            if (networkCapabilities == null) {
                return IIIIIIII;
            }
            if (networkCapabilities.hasTransport(1)) {
                return networkInfo.getTypeName();
            }
            if (!networkCapabilities.hasTransport(0)) {
                return networkInfo.getTypeName();
            }
            stringBuilder = new StringBuilder();
        } else {
            if (networkInfo.getType() == 1) {
                return networkInfo.getTypeName();
            }
            if (networkInfo.getType() != 0) {
                return networkInfo.getTypeName();
            }
            stringBuilder = new StringBuilder();
        }
        stringBuilder.append(networkInfo.getTypeName());
        stringBuilder.append(" - ");
        stringBuilder.append(networkInfo.getSubtypeName());
        return stringBuilder.toString();
    }

    public static String IIIIIIll(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService("connectivity");
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo == null) {
            return IIIIIIIl;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            Network network = connectivityManager.getActiveNetwork();
            if (network == null) {
                return IIIIIIIl;
            }
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(network);
            if (networkCapabilities == null) {
                return IIIIIIIl;
            }
            if (networkCapabilities.hasTransport(1)) {
                return networkInfo.getTypeName();
            }
            if (networkCapabilities.hasTransport(0)) {
                return networkInfo.getSubtypeName();
            }
            return networkInfo.getTypeName();
        }
        if (networkInfo.getType() == 1) {
            return networkInfo.getTypeName();
        }
        if (networkInfo.getType() == 0) {
            return networkInfo.getSubtypeName();
        }
        return networkInfo.getTypeName();
    }
}

