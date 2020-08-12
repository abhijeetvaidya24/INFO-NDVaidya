/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.io.File
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.ref.WeakReference
 *  java.util.concurrent.ExecutorService
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.adcolony.sdk;

import android.content.Context;
import com.adcolony.sdk.AdColonyAppOptions;
import com.adcolony.sdk.ad;
import com.adcolony.sdk.ae;
import com.adcolony.sdk.af;
import com.adcolony.sdk.am;
import com.adcolony.sdk.au;
import com.adcolony.sdk.l;
import com.adcolony.sdk.w;
import com.adcolony.sdk.y;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;
import org.json.JSONObject;

class a {
    static boolean a;
    static boolean b;
    private static WeakReference<Context> c;
    private static l d;

    static af a(String string, af af2, boolean bl) {
        a.a().p().a(string, af2);
        return af2;
    }

    static l a() {
        if (!a.b()) {
            Context context = a.c();
            if (context != null) {
                d = new l();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(context.getFilesDir().getAbsolutePath());
                stringBuilder.append("/adc3/AppInfo");
                JSONObject jSONObject = w.c(stringBuilder.toString());
                JSONArray jSONArray = w.g(jSONObject, "zoneIds");
                String string = w.b(jSONObject, "appId");
                AdColonyAppOptions adColonyAppOptions = new AdColonyAppOptions().a(string).a(w.a(jSONArray));
                d.a(adColonyAppOptions, false);
            } else {
                return new l();
            }
        }
        return d;
    }

    static void a(Context context) {
        if (context == null) {
            c.clear();
            return;
        }
        c = new WeakReference((Object)context);
    }

    static void a(final Context context, AdColonyAppOptions adColonyAppOptions, boolean bl) {
        a.a(context);
        b = true;
        l l2 = d;
        if (l2 == null) {
            d = new l();
            d.a(adColonyAppOptions, bl);
        } else {
            l2.a(adColonyAppOptions);
        }
        au.b.execute(new Runnable(){

            public void run() {
                d.a(context, null);
            }
        });
        new y.a().a("Configuring AdColony").a(y.c);
        d.b(false);
        d.k().d(true);
        d.k().e(true);
        d.k().f(false);
        l l3 = d;
        l3.f = true;
        l3.k().a(false);
    }

    static void a(String string, af af2) {
        a.a().p().a(string, af2);
    }

    static void a(String string, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = w.a();
        }
        w.a(jSONObject, "m_type", string);
        a.a().p().a(jSONObject);
    }

    static void b(String string, af af2) {
        a.a().p().b(string, af2);
    }

    static boolean b() {
        return d != null;
    }

    static Context c() {
        WeakReference<Context> weakReference = c;
        if (weakReference == null) {
            return null;
        }
        return (Context)weakReference.get();
    }

    static boolean d() {
        WeakReference<Context> weakReference = c;
        return weakReference != null && weakReference.get() != null;
    }

    static boolean e() {
        return a;
    }

    static void f() {
        a.a().p().b();
    }

}

