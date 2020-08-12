/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.preference.PreferenceManager
 *  android.text.TextUtils
 *  com.adincube.sdk.h.f.d
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
package com.adincube.sdk.mediation.aa;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.adincube.sdk.h.f.d;
import com.adincube.sdk.mediation.aa.c;

public final class a
implements c {
    @Override
    public final void a(Context context, d d2) {
    }

    @Override
    public final void a(Context context, String string) {
        if (!TextUtils.equals((CharSequence)PreferenceManager.getDefaultSharedPreferences((Context)context).getString("IABConsent_ConsentString", ""), (CharSequence)string)) {
            PreferenceManager.getDefaultSharedPreferences((Context)context).edit().putString("IABConsent_ConsentString", string).apply();
        }
    }

    @Override
    public final boolean a() {
        return true;
    }

    @Override
    public final String b() {
        return null;
    }
}

