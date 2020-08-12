/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.net.wifi.WifiInfo
 *  android.net.wifi.WifiManager
 *  android.telephony.TelephonyManager
 *  com.adincube.sdk.g.a
 *  com.adincube.sdk.h.b.a
 *  com.adincube.sdk.h.b.b
 *  java.lang.Object
 *  java.lang.String
 */
package com.adincube.sdk.util.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import com.adincube.sdk.h.b.a;
import com.adincube.sdk.h.b.b;
import com.adincube.sdk.util.b.f;
import com.adincube.sdk.util.p;

public final class d {
    public static String a(Context context) {
        String string = d.b(context);
        if (string == null) {
            return null;
        }
        return p.a("MD5", string);
    }

    @SuppressLint(value={"MissingPermission", "HardwareIds"})
    public static String b(Context context) {
        b b2 = com.adincube.sdk.g.a.a().a(true, true);
        if (b2 != null) {
            if (!b.a((b)b2, (a)a.b)) {
                return null;
            }
            if (!f.a(context, "android.permission.ACCESS_WIFI_STATE")) {
                return null;
            }
            WifiManager wifiManager = (WifiManager)context.getApplicationContext().getSystemService("wifi");
            if (wifiManager == null) {
                return null;
            }
            WifiInfo wifiInfo = wifiManager.getConnectionInfo();
            if (wifiInfo == null) {
                return null;
            }
            return wifiInfo.getMacAddress();
        }
        return null;
    }

    public static String c(Context context) {
        String string = d.d(context);
        if (string == null) {
            return null;
        }
        return p.a("MD5", string);
    }

    @SuppressLint(value={"MissingPermission", "HardwareIds"})
    public static String d(Context context) {
        b b2 = com.adincube.sdk.g.a.a().a(true, true);
        if (b2 != null) {
            if (!b.a((b)b2, (a)a.a)) {
                return null;
            }
            if (!f.a(context, "android.permission.READ_PHONE_STATE")) {
                return null;
            }
            TelephonyManager telephonyManager = (TelephonyManager)context.getSystemService("phone");
            if (telephonyManager == null) {
                return null;
            }
            return telephonyManager.getDeviceId();
        }
        return null;
    }
}

