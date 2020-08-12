/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.os.Build
 *  android.os.Looper
 *  android.provider.Settings
 *  android.provider.Settings$Secure
 *  android.provider.Settings$SettingNotFoundException
 *  android.util.Base64
 *  com.chartboost.sdk.i
 *  com.chartboost.sdk.impl.ar
 *  com.chartboost.sdk.impl.as
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONObject
 */
package com.chartboost.sdk.Libraries;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.provider.Settings;
import android.util.Base64;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.e;
import com.chartboost.sdk.i;
import com.chartboost.sdk.impl.ar;
import com.chartboost.sdk.impl.as;
import org.json.JSONObject;

public class d {
    private int a = -1;
    private String b = null;
    private final String c;

    public d(Context context) {
        this.c = ar.b((Context)context);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(Context context) {
        ContentResolver contentResolver;
        boolean bl;
        try {
            contentResolver = context.getContentResolver();
            bl = Settings.Secure.getInt((ContentResolver)contentResolver, (String)"limit_ad_tracking") != 0;
        }
        catch (Settings.SettingNotFoundException settingNotFoundException) {
            this.a = -1;
            this.b = null;
            return;
        }
        if (bl) {
            this.a = 1;
            this.b = null;
            return;
        }
        String string2 = Settings.Secure.getString((ContentResolver)contentResolver, (String)"advertising_id");
        if ("00000000-0000-0000-0000-000000000000".equals((Object)string2)) {
            this.a = 1;
            this.b = null;
            return;
        }
        this.a = 0;
        this.b = string2;
    }

    private static boolean b() {
        return true ^ "Amazon".equalsIgnoreCase(Build.MANUFACTURER);
    }

    private void c() {
        if (!as.a((Context)i.m)) {
            return;
        }
        com.chartboost.sdk.Libraries.a a2 = new com.chartboost.sdk.Libraries.a(i.m);
        this.a = a2.a;
        this.b = a2.b;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public a a() {
        d d2 = this;
        synchronized (d2) {
            if (Looper.myLooper() == Looper.getMainLooper() && !"robolectric".equals((Object)Build.FINGERPRINT)) {
                CBLogging.b("CBIdentity", "I must be called from a background thread");
                return null;
            }
            if (d.b()) {
                this.c();
            } else {
                this.a(i.m);
            }
            String string2 = this.b;
            JSONObject jSONObject = new JSONObject();
            if (this.c != null && string2 == null) {
                String string3 = i.x ? "000000000" : this.c;
                e.a(jSONObject, "uuid", (Object)string3);
            }
            if (string2 != null) {
                String string4 = i.x ? "000000000" : string2;
                e.a(jSONObject, "gaid", (Object)string4);
            }
            int n2 = this.a;
            String string5 = Base64.encodeToString((byte[])jSONObject.toString().getBytes(), (int)0);
            String string6 = !i.x && string2 == null ? this.c : "000000000";
            if (!i.x) return new a(n2, string5, string6, string2);
            string2 = "000000000";
            return new a(n2, string5, string6, string2);
        }
    }

    public static class a {
        public final int a;
        public final String b;
        public final String c;
        public final String d;

        public a(int n2, String string2, String string3, String string4) {
            this.a = n2;
            this.b = string2;
            this.c = string3;
            this.d = string4;
        }
    }

}

