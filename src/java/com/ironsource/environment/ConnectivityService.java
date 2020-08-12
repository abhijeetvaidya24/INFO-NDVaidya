/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.net.ConnectivityManager
 *  android.net.NetworkInfo
 *  android.telephony.TelephonyManager
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.ironsource.environment;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

public class ConnectivityService {
    public static String getConnectionType(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        NetworkInfo networkInfo = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            String string = networkInfo.getTypeName();
            int n2 = networkInfo.getType();
            if (n2 == 0) {
                stringBuilder.append("3g");
            } else if (n2 == 1) {
                stringBuilder.append("wifi");
            } else {
                stringBuilder.append(string);
            }
        }
        return stringBuilder.toString();
    }

    public static int getNetworkMCC(Context context) {
        try {
            int n2 = context.getResources().getConfiguration().mcc;
            return n2;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return -1;
        }
    }

    public static int getNetworkMNC(Context context) {
        try {
            int n2 = context.getResources().getConfiguration().mnc;
            return n2;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return -1;
        }
    }

    public static int getPhoneType(Context context) {
        try {
            int n2 = ((TelephonyManager)context.getSystemService("phone")).getPhoneType();
            return n2;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return -1;
        }
    }

    public static String getSimOperator(Context context) {
        try {
            String string = ((TelephonyManager)context.getSystemService("phone")).getSimOperator();
            return string;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public static boolean isConnected(Context context) {
        NetworkInfo networkInfo = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

    public static boolean isConnectedMobile(Context context) {
        NetworkInfo networkInfo = ((ConnectivityManager)context.getSystemService("connectivity")).getNetworkInfo(0);
        boolean bl2 = false;
        if (networkInfo != null) {
            boolean bl3 = networkInfo.isConnected();
            bl2 = false;
            if (bl3) {
                bl2 = true;
            }
        }
        return bl2;
    }

    public static boolean isConnectedWifi(Context context) {
        NetworkInfo networkInfo = ((ConnectivityManager)context.getSystemService("connectivity")).getNetworkInfo(1);
        return networkInfo != null && networkInfo.isConnected();
    }
}

