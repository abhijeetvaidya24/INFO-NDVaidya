/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.ConnectivityManager
 *  android.net.NetworkInfo
 *  android.telephony.TelephonyManager
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 */
package com.tappx.a.a.a.d;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.tappx.a.a.a.j.c;

public final class y {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;

    public y(String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9) {
        this.a = string2;
        this.b = string3;
        this.c = string4;
        this.d = string5;
        this.e = string6;
        this.f = string7;
        this.g = string8;
        this.h = string9;
    }

    public static class a {
        private static volatile a a;
        private final Context b;

        public a(Context context) {
            this.b = context;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public static final a a(Context context) {
            if (a != null) return a;
            Class<a> class_ = a.class;
            synchronized (a.class) {
                if (a != null) return a;
                a = new a(context.getApplicationContext());
                // ** MonitorExit[var2_1] (shouldn't be in output)
                return a;
            }
        }

        private String a(String string2) {
            if (string2 != null && string2.trim().isEmpty()) {
                string2 = null;
            }
            return string2;
        }

        public y a() {
            String string2;
            String string3;
            NetworkInfo networkInfo;
            TelephonyManager telephonyManager = (TelephonyManager)this.b.getSystemService("phone");
            if (c.a(this.b, "android.permission.ACCESS_NETWORK_STATE") && (networkInfo = ((ConnectivityManager)this.b.getSystemService("connectivity")).getActiveNetworkInfo()) != null) {
                String string4 = networkInfo.getTypeName();
                string2 = networkInfo.getSubtypeName();
                string3 = string4;
            } else {
                string3 = null;
                string2 = null;
            }
            String string5 = this.a(telephonyManager.getSimOperator());
            String string6 = this.a(telephonyManager.getSimOperatorName());
            String string7 = this.a(telephonyManager.getSimCountryIso());
            String string8 = this.a(telephonyManager.getNetworkOperator());
            String string9 = this.a(telephonyManager.getNetworkOperatorName());
            String string10 = this.a(telephonyManager.getNetworkCountryIso());
            y y2 = new y(string3, string2, string5, string6, string7, string8, string9, string10);
            return y2;
        }
    }

}

