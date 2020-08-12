/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.net.NetworkInfo
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.DisplayMetrics
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Locale
 *  org.json.JSONObject
 */
package com.ogury.consent.manager;

import android.content.Context;
import android.content.res.Resources;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.DisplayMetrics;
import com.ogury.consent.manager.rtf1;
import com.ogury.consent.manager.tx5040;
import com.ogury.consent.manager.tx6480;
import com.ogury.consent.manager.util.consent.ansi;
import com.ogury.consent.manager.vieww10800;
import java.util.Locale;
import org.json.JSONObject;

public final class f0 {
    public static final rtf1 a = new rtf1(null);

    public static String a(Context context, String string2) {
        tx6480.b((Object)context, "context");
        tx6480.b(string2, "appKey");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("assetType", (Object)"android");
        jSONObject.put("assetKey", (Object)string2);
        jSONObject.put("deviceId", (Object)ansi.c().b());
        jSONObject.put("sdkVersion", (Object)"1.1.4");
        NetworkInfo networkInfo = rtf1.rtf1.a(context);
        String string3 = networkInfo != null ? networkInfo.getTypeName() : null;
        jSONObject.put("connectivity", (Object)string3);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Build.MANUFACTURER);
        stringBuilder.append(" ");
        stringBuilder.append(Build.MODEL);
        String string4 = stringBuilder.toString();
        if (string4.length() > 32) {
            if (string4 != null) {
                string4 = string4.substring(0, 31);
                tx6480.a((Object)string4, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
            } else {
                throw new vieww10800("null cannot be cast to non-null type java.lang.String");
            }
        }
        jSONObject.put("deviceModel", (Object)string4);
        jSONObject.put("deviceOsVersion", (Object)String.valueOf((int)Build.VERSION.SDK_INT));
        Context context2 = context.getApplicationContext();
        tx6480.a((Object)context2, "context.applicationContext");
        Resources resources = context2.getResources();
        tx6480.a((Object)resources, "context.applicationContext.resources");
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        tx6480.a((Object)displayMetrics, "context.applicationConte\u2026.resources.displayMetrics");
        jSONObject.put("deviceScreenWidth", displayMetrics.widthPixels);
        jSONObject.put("deviceScreenHeight", displayMetrics.heightPixels);
        jSONObject.put("bundle", (Object)ansi.c().a());
        StringBuilder stringBuilder2 = new StringBuilder();
        Locale locale = Locale.getDefault();
        tx6480.a((Object)locale, "Locale.getDefault()");
        stringBuilder2.append(locale.getLanguage());
        stringBuilder2.append("-");
        Locale locale2 = Locale.getDefault();
        tx6480.a((Object)locale2, "Locale.getDefault()");
        stringBuilder2.append(locale2.getCountry());
        jSONObject.put("locale", (Object)stringBuilder2.toString());
        jSONObject.put("deviceScreenDensity", displayMetrics.densityDpi);
        String string5 = jSONObject.toString();
        tx6480.a((Object)string5, "json.toString()");
        return string5;
    }

    public static final class rtf1 {
        private rtf1() {
        }

        public /* synthetic */ rtf1(tx5040 tx50402) {
            this();
        }
    }

}

