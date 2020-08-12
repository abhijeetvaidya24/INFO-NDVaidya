/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.LocaleList
 *  android.telephony.TelephonyManager
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Locale
 */
package io.presage.core;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;
import android.telephony.TelephonyManager;
import java.util.Locale;

public final class lIIIIIIl {
    public static String IIIIIIII(Context context) {
        String string2;
        TelephonyManager telephonyManager = (TelephonyManager)context.getSystemService("phone");
        int n2 = telephonyManager.getPhoneType();
        String string3 = "";
        if (n2 != 4 && (string2 = telephonyManager.getNetworkCountryIso()) != null && !string2.isEmpty()) {
            string3 = new Locale(string3, string2).getISO3Country();
        }
        if (string3 != null && !string3.isEmpty()) {
            return string3;
        }
        return lIIIIIIl.IIIIIIIl(context).getISO3Country();
    }

    public static Locale IIIIIIIl(Context context) {
        Configuration configuration = context.getResources().getConfiguration();
        Locale locale = context.getResources().getConfiguration().locale;
        if (Build.VERSION.SDK_INT >= 24 && !configuration.getLocales().isEmpty()) {
            locale = configuration.getLocales().get(0);
        }
        return locale;
    }
}

