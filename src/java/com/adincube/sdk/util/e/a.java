/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.os.Looper
 *  com.adincube.sdk.h.a
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Arrays
 *  java.util.Date
 *  java.util.Iterator
 *  java.util.List
 */
package com.adincube.sdk.util.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import com.adincube.sdk.util.ErrorReportingHelper;
import com.adincube.sdk.util.b.k;
import com.adincube.sdk.util.d;
import com.adincube.sdk.util.e.c;
import com.adincube.sdk.util.f;
import com.adincube.sdk.util.o;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public final class a {
    private static boolean a;

    public static void a(final Context context) {
        if (a) {
            return;
        }
        a = true;
        if (c.a(context, "ua") == null) {
            Runnable runnable = new Runnable(){

                /*
                 * Enabled aggressive block sorting
                 * Enabled unnecessary exception pruning
                 * Enabled aggressive exception aggregation
                 */
                public final void run() {
                    try {
                        Context context2 = context;
                        String string = k.a(context2);
                        if (string == null) {
                            string = k.b(context2);
                        }
                        if (string == null) {
                            string = k.c(context2);
                        }
                        c.a(context, "ua", string);
                        a = false;
                        return;
                    }
                    catch (Throwable throwable) {
                        com.adincube.sdk.util.a.c("ConfigPreferencesHelper.updateUserAgent", new Object[]{throwable});
                        ErrorReportingHelper.report("ConfigPreferencesHelper.updateUserAgent", throwable);
                        return;
                    }
                }
            };
            if (Looper.getMainLooper() != Looper.myLooper()) {
                o.a(runnable);
                return;
            }
            runnable.run();
        }
    }

    public static void a(Context context, com.adincube.sdk.h.a a2) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("AIC-prefs", 0);
        com.adincube.sdk.h.a a3 = a.c(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (!a3.a() || !a3.equals((Object)a2)) {
            editor.putString("ai", a2.a);
            editor.putBoolean("lat", a2.b);
        }
        editor.putLong("aif", new Date().getTime());
        editor.apply();
    }

    public static boolean a() {
        Context context = f.a();
        String string = d.b();
        if (!context.getSharedPreferences("AIC-prefs", 0).contains("lak")) {
            c.a(context, "lak", string);
            return false;
        }
        if (!string.equals((Object)c.a(context, "lak"))) {
            c.a(context, "lak", string);
            return true;
        }
        return false;
    }

    public static String b(Context context) {
        return c.a(context, "ua");
    }

    public static void b() {
        Context context = f.a();
        List list = Arrays.asList((Object[])new String[]{"lak", "tm", "ai", "aif", "lat", "ua"});
        SharedPreferences.Editor editor = context.getSharedPreferences("AIC-prefs", 0).edit();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            editor.remove((String)iterator.next());
        }
        editor.apply();
        c.a(context, "lak", d.b());
        a.a(context);
    }

    public static com.adincube.sdk.h.a c(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("AIC-prefs", 0);
        return new com.adincube.sdk.h.a(sharedPreferences.getString("ai", null), sharedPreferences.getBoolean("lat", false), sharedPreferences.getLong("aif", -1L));
    }

}

