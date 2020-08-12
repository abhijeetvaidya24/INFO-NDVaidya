/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.webkit.URLUtil
 *  java.lang.Object
 *  java.lang.String
 */
package com.tappx.a.a.a.b;

import android.content.SharedPreferences;
import android.webkit.URLUtil;
import com.tappx.a.a.a.a.a;

public class g {
    private static final String a = "tappx_privacy_consent_endpoint";
    private final SharedPreferences b;

    public g(SharedPreferences sharedPreferences) {
        this.b = sharedPreferences;
    }

    public String a() {
        String string2 = this.b.getString(a, null);
        if (string2 != null && URLUtil.isValidUrl((String)string2)) {
            return string2;
        }
        return a.e();
    }

    public void a(String string2) {
        this.b.edit().putString(a, string2).apply();
    }
}

