/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Date
 */
package com.ogury.consent.manager;

import android.content.Context;
import android.content.SharedPreferences;
import com.ogury.consent.manager.ConsentManager;
import com.ogury.consent.manager.green255;
import com.ogury.consent.manager.tx5040;
import com.ogury.consent.manager.tx6480;
import com.ogury.consent.manager.util.consent.ansi;
import java.util.Date;

public final class fswiss {
    public static final rtf1 a = new rtf1(null);

    public static void a(String string2, Context context) {
        tx6480.b(string2, "assetKey");
        tx6480.b((Object)context, "context");
        SharedPreferences.Editor editor = context.getSharedPreferences("cacheConsent", 0).edit();
        editor.putString("iabString", ansi.a().d());
        editor.putString("optin", ansi.a().c().toString());
        editor.putLong("cacheFor", ansi.d().getTime());
        editor.putString("aaid", ansi.c().b());
        editor.putString("acceptedVendors", ansi.a().a());
        editor.putString("refusedVendors", ansi.a().b());
        editor.putString("purposes", ansi.a().e());
        int n2 = ((CharSequence)string2).length();
        boolean bl2 = false;
        if (n2 > 0) {
            bl2 = true;
        }
        if (bl2) {
            editor.putString("assetKey", string2);
        }
        editor.putString("bundleId", ansi.c().a());
        editor.apply();
    }

    public static void b(String string2, Context context) {
        String string3;
        String string4;
        tx6480.b(string2, "assetKey");
        tx6480.b((Object)context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences("cacheConsent", 0);
        tx6480.a((Object)sharedPreferences, "prefs");
        boolean bl2 = tx6480.a((Object)sharedPreferences.getString("assetKey", ""), (Object)string2);
        boolean bl3 = true;
        if (!(bl2 ^ bl3 || bl3 ^ tx6480.a((Object)(string4 = sharedPreferences.getString("bundleId", "")), (Object)ansi.c().a()) || bl3 ^ tx6480.a((Object)(string3 = sharedPreferences.getString("aaid", "")), (Object)ansi.c().b()))) {
            bl3 = false;
        }
        if (bl3) {
            sharedPreferences.edit().clear().apply();
            ansi.a(new Date());
            return;
        }
        green255 green2552 = ansi.a();
        String string5 = sharedPreferences.getString("iabString", "");
        tx6480.a((Object)string5, "prefs.getString(IAB_STRING_KEY, \"\")");
        green2552.c(string5);
        green255 green2553 = ansi.a();
        String string6 = sharedPreferences.getString("optin", "NO_ANSWER");
        tx6480.a((Object)string6, "prefs.getString(OPTIN_KEY, \"NO_ANSWER\")");
        green2553.a(ConsentManager.Answer.valueOf(string6));
        green255 green2554 = ansi.a();
        String string7 = sharedPreferences.getString("purposes", "");
        tx6480.a((Object)string7, "prefs.getString(PURPOSES, \"\")");
        green2554.d(string7);
        green255 green2555 = ansi.a();
        String string8 = sharedPreferences.getString("acceptedVendors", "");
        tx6480.a((Object)string8, "prefs.getString(ACCEPTED_VENDORS, \"\")");
        green2555.a(string8);
        green255 green2556 = ansi.a();
        String string9 = sharedPreferences.getString("refusedVendors", "");
        tx6480.a((Object)string9, "prefs.getString(REFUSED_VENDORS, \"\")");
        green2556.b(string9);
        ansi.a(sharedPreferences.getLong("cacheFor", 0L));
    }

    public static final class rtf1 {
        private rtf1() {
        }

        public /* synthetic */ rtf1(tx5040 tx50402) {
            this();
        }
    }

}

