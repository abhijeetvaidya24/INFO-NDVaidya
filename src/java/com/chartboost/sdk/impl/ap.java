/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.res.Resources
 *  android.graphics.Rect
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.telephony.TelephonyManager
 *  android.text.TextUtils
 *  android.util.DisplayMetrics
 *  android.view.Display
 *  android.view.View
 *  android.view.Window
 *  android.view.WindowManager
 *  com.chartboost.sdk.Tracking.a
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.Locale
 *  java.util.concurrent.atomic.AtomicReference
 *  org.json.JSONObject
 */
package com.chartboost.sdk.impl;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.chartboost.sdk.Chartboost;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Libraries.d;
import com.chartboost.sdk.Libraries.e;
import com.chartboost.sdk.Libraries.i;
import com.chartboost.sdk.Tracking.a;
import com.chartboost.sdk.g;
import com.chartboost.sdk.impl.ai;
import com.chartboost.sdk.impl.ar;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

public class ap {
    final d a;
    final ai b;
    final AtomicReference<com.chartboost.sdk.Model.e> c;
    final SharedPreferences d;
    final i e;
    final String f;
    final String g;
    final String h;
    final String i;
    String j;
    String k;
    final String l;
    final Integer m;
    final Integer n;
    final Integer o;
    final Integer p;
    final String q;
    final Float r;
    final String s;
    final String t;
    final String u;
    final JSONObject v;
    final boolean w;
    final String x;
    final Integer y;

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public ap(Context context, String string, d d2, ai ai2, AtomicReference<com.chartboost.sdk.Model.e> atomicReference, SharedPreferences sharedPreferences, i i2) {
        int n3;
        WindowManager windowManager;
        int n2;
        block16 : {
            void var19_25;
            block17 : {
                block15 : {
                    JSONObject jSONObject;
                    this.a = d2;
                    this.b = ai2;
                    this.c = atomicReference;
                    this.d = sharedPreferences;
                    this.e = i2;
                    this.s = string;
                    this.f = !("sdk".equals((Object)Build.PRODUCT) || "google_sdk".equals((Object)Build.PRODUCT) || Build.MANUFACTURER != null && Build.MANUFACTURER.contains((CharSequence)"Genymotion")) ? Build.MODEL : "Android Simulator";
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(Build.MANUFACTURER);
                    stringBuilder.append(" ");
                    stringBuilder.append(Build.MODEL);
                    this.t = stringBuilder.toString();
                    this.u = ar.a(context);
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("Android ");
                    stringBuilder2.append(Build.VERSION.RELEASE);
                    this.g = stringBuilder2.toString();
                    this.h = Locale.getDefault().getCountry();
                    this.i = Locale.getDefault().getLanguage();
                    this.l = "7.2.1";
                    this.r = Float.valueOf((float)context.getResources().getDisplayMetrics().density);
                    try {
                        String string2 = context.getPackageName();
                        this.j = context.getPackageManager().getPackageInfo((String)string2, (int)128).versionName;
                        this.k = string2;
                    }
                    catch (Exception exception) {
                        CBLogging.a("RequestBody", "Exception raised getting package mager object", exception);
                    }
                    TelephonyManager telephonyManager = (TelephonyManager)context.getSystemService("phone");
                    n2 = 0;
                    if (telephonyManager != null && telephonyManager.getPhoneType() != 0 && telephonyManager.getSimState() == 5) {
                        String string4;
                        String string3;
                        String string5 = null;
                        try {
                            string4 = telephonyManager.getSimOperator();
                        }
                        catch (Exception exception) {
                            a.a(Chartboost.class, (String)"Unable to retrieve sim operator information", (Exception)exception);
                            string4 = null;
                        }
                        if (string4 != null && !TextUtils.isEmpty((CharSequence)string4)) {
                            string5 = string4.substring(0, 3);
                            string3 = string4.substring(3);
                        } else {
                            string3 = null;
                        }
                        e.a[] arra = new e.a[]{e.a("carrier-name", (Object)telephonyManager.getNetworkOperatorName()), e.a("mobile-country-code", (Object)string5), e.a("mobile-network-code", (Object)string3), e.a("iso-country-code", (Object)telephonyManager.getNetworkCountryIso()), e.a("phone-type", telephonyManager.getPhoneType())};
                        jSONObject = e.a(arra);
                    } else {
                        jSONObject = new JSONObject();
                    }
                    this.v = jSONObject;
                    this.w = CBUtility.c();
                    this.x = CBUtility.d();
                    this.y = ai.d(context);
                    if (!(context instanceof Activity)) break block15;
                    Activity activity = (Activity)context;
                    Rect rect = new Rect();
                    activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                    n3 = rect.width();
                    try {
                        n2 = rect.height();
                        break block16;
                    }
                    catch (Exception exception) {
                        break block17;
                    }
                }
                n3 = 0;
                n2 = 0;
                break block16;
                catch (Exception exception) {
                    n3 = 0;
                }
            }
            CBLogging.b("RequestBody", "Exception getting activity size", (Throwable)var19_25);
        }
        DisplayMetrics displayMetrics = g.a().a(new DisplayMetrics());
        displayMetrics.setTo(context.getResources().getDisplayMetrics());
        if (Build.VERSION.SDK_INT >= 17 && (windowManager = (WindowManager)context.getSystemService("window")) != null) {
            windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        }
        int n4 = displayMetrics.widthPixels;
        int n5 = displayMetrics.heightPixels;
        this.o = n4;
        this.p = n5;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(displayMetrics.densityDpi);
        this.q = stringBuilder.toString();
        if (n3 > 0 && n3 <= n4) {
            n4 = n3;
        }
        if (n2 <= 0 || n2 > n5) {
            n2 = n5;
        }
        this.m = n4;
        this.n = n2;
    }
}

