/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.util.concurrent.TimeUnit
 */
package io.presage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import io.presage.Munster;
import io.presage.cl;
import java.util.concurrent.TimeUnit;

public final class EpoissesdeBourgogne {
    public static final CamembertauCalvados a = new CamembertauCalvados(0);
    @SuppressLint(value={"StaticFieldLeak"})
    private static EpoissesdeBourgogne c;
    private final SharedPreferences b;

    private EpoissesdeBourgogne(Context context) {
        this.b = context.getSharedPreferences("profig", 0);
    }

    public /* synthetic */ EpoissesdeBourgogne(Context context, byte by) {
        this(context);
    }

    public static final /* synthetic */ void a(EpoissesdeBourgogne epoissesdeBourgogne) {
        c = epoissesdeBourgogne;
    }

    public final int a() {
        return this.b.getInt("numberOfProfigApiCalls", 0);
    }

    public final void a(int n2) {
        this.b.edit().putInt("numberOfProfigApiCalls", n2).apply();
    }

    public final void a(long l2) {
        this.b.edit().putLong("last_profig_sync", l2).apply();
    }

    public final void a(String string2) {
        this.b.edit().putString("md5Profig", string2).apply();
    }

    public final String b() {
        String string2 = this.b.getString("md5Profig", "");
        cl.a((Object)string2, "sharedPref.getString(MD5_PROFIG, \"\")");
        return string2;
    }

    public final void b(String string2) {
        this.b.edit().putString("aaid", string2).apply();
    }

    public final String c() {
        String string2 = this.b.getString("aaid", "");
        cl.a((Object)string2, "sharedPref.getString(AAID, \"\")");
        return string2;
    }

    public final void c(String string2) {
        this.b.edit().putString("fullProfigResponseJson", string2).apply();
    }

    public final String d() {
        String string2 = this.b.getString("fullProfigResponseJson", "");
        cl.a((Object)string2, "sharedPref.getString(FUL\u2026PROFIG_RESPONSE_JSON, \"\")");
        return string2;
    }

    public final void d(String string2) {
        this.b.edit().putString("appVersion", string2).apply();
    }

    public final void e() {
        long l2 = System.currentTimeMillis() / TimeUnit.DAYS.toMillis(1L);
        this.b.edit().putLong("numberOfDays", l2).apply();
    }

    public final void e(String string2) {
        this.b.edit().putString("api_key", string2).apply();
    }

    public final long f() {
        return this.b.getLong("numberOfDays", 0L);
    }

    public final String g() {
        String string2 = this.b.getString("appVersion", Munster.a());
        cl.a((Object)string2, "sharedPref.getString(APP\u2026ERSION, fullSdkVersion())");
        return string2;
    }

    public final long h() {
        return this.b.getLong("last_profig_sync", 0L);
    }

    public final String i() {
        String string2 = this.b.getString("api_key", "");
        cl.a((Object)string2, "sharedPref.getString(API_KEY, \"\")");
        return string2;
    }

    public static final class CamembertauCalvados {
        private CamembertauCalvados() {
        }

        public /* synthetic */ CamembertauCalvados(byte by) {
            this();
        }

        public static EpoissesdeBourgogne a(Context context) {
            EpoissesdeBourgogne epoissesdeBourgogne;
            if (c == null) {
                Context context2 = context.getApplicationContext();
                cl.a((Object)context2, "context.applicationContext");
                EpoissesdeBourgogne.a(new EpoissesdeBourgogne(context2, 0));
            }
            if ((epoissesdeBourgogne = c) == null) {
                cl.a();
            }
            return epoissesdeBourgogne;
        }
    }

}

