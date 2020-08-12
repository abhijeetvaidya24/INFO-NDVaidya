/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  com.tapjoy.TapjoyLog
 *  com.tapjoy.internal.ct
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.tapjoy;

import android.content.Context;
import android.content.SharedPreferences;
import com.tapjoy.TapjoyLog;
import com.tapjoy.internal.ct;

public class TapjoyAppSettings {
    public static final String TAG = "TapjoyAppSettings";
    private static TapjoyAppSettings b;
    String a;
    private Context c;
    private SharedPreferences d;

    private TapjoyAppSettings(Context context) {
        this.c = context;
        this.d = this.c.getSharedPreferences("tjcPrefrences", 0);
        this.a = this.d.getString("tapjoyLogLevel", null);
        if (!ct.c((String)this.a)) {
            String string = TAG;
            StringBuilder stringBuilder = new StringBuilder("restoreLoggingLevel from sharedPref -- loggingLevel=");
            stringBuilder.append(this.a);
            TapjoyLog.d((String)string, (String)stringBuilder.toString());
            TapjoyLog.a((String)this.a, (boolean)true);
        }
    }

    public static TapjoyAppSettings getInstance() {
        return b;
    }

    public static void init(Context context) {
        TapjoyLog.d((String)TAG, (String)"initializing app settings");
        b = new TapjoyAppSettings(context);
    }

    public void clearLoggingLevel() {
        SharedPreferences.Editor editor = this.d.edit();
        editor.remove("tapjoyLogLevel");
        editor.commit();
        this.a = null;
        boolean bl = TapjoyLog.isLoggingEnabled();
        String string = TAG;
        StringBuilder stringBuilder = new StringBuilder("Tapjoy remote device debugging 'Disabled'. The SDK Debug-setting is: ");
        String string2 = bl ? "'Enabled'" : "'Disabled'";
        stringBuilder.append(string2);
        TapjoyLog.i((String)string, (String)stringBuilder.toString());
        TapjoyLog.setDebugEnabled((boolean)bl);
    }

    public String getConnectResult(String string, long l2) {
        long l3;
        String string2 = this.d.getString("connectResult", null);
        if (ct.c((String)string2)) {
            return null;
        }
        if (!ct.c((String)string) && string.equals((Object)this.d.getString("connectParamsHash", null)) && ((l3 = this.d.getLong("connectResultExpires", -1L)) < 0L || l3 >= l2)) {
            return string2;
        }
        return null;
    }

    public void removeConnectResult() {
        if (this.d.getString("connectParamsHash", null) != null) {
            SharedPreferences.Editor editor = this.d.edit();
            editor.remove("connectResult");
            editor.remove("connectParamsHash");
            editor.remove("connectResultExpires");
            TapjoyLog.i((String)TAG, (String)"Removed connect result");
            editor.commit();
        }
    }

    public void saveConnectResultAndParams(String string, String string2, long l2) {
        if (!ct.c((String)string)) {
            if (ct.c((String)string2)) {
                return;
            }
            SharedPreferences.Editor editor = this.d.edit();
            editor.putString("connectResult", string);
            editor.putString("connectParamsHash", string2);
            if (l2 >= 0L) {
                editor.putLong("connectResultExpires", l2);
            } else {
                editor.remove("connectResultExpires");
            }
            TapjoyLog.i((String)TAG, (String)"Stored connect result");
            editor.commit();
        }
    }

    public void saveLoggingLevel(String string) {
        if (ct.c((String)string)) {
            TapjoyLog.d((String)TAG, (String)"saveLoggingLevel -- server logging level is NULL or Empty string");
            return;
        }
        String string2 = TAG;
        StringBuilder stringBuilder = new StringBuilder("saveLoggingLevel -- currentLevel=");
        stringBuilder.append(this.a);
        stringBuilder.append(";newLevel=");
        stringBuilder.append(string);
        TapjoyLog.d((String)string2, (String)stringBuilder.toString());
        if (ct.c((String)this.a) || !this.a.equals((Object)string)) {
            SharedPreferences.Editor editor = this.d.edit();
            editor.putString("tapjoyLogLevel", string);
            editor.commit();
            this.a = string;
            TapjoyLog.a((String)this.a, (boolean)true);
        }
        boolean bl = TapjoyLog.isLoggingEnabled();
        String string3 = TAG;
        StringBuilder stringBuilder2 = new StringBuilder("Tapjoy remote device debugging set to '");
        stringBuilder2.append(string);
        stringBuilder2.append("'. The SDK Debug-setting is: ");
        String string4 = bl ? "'Enabled'" : "'Disabled'";
        stringBuilder2.append(string4);
        TapjoyLog.i((String)string3, (String)stringBuilder2.toString());
    }
}

