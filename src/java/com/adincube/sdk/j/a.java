/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.net.NetworkInfo
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.provider.Settings
 *  android.provider.Settings$Secure
 *  android.telephony.TelephonyManager
 *  android.util.DisplayMetrics
 *  com.adincube.sdk.g.a
 *  com.adincube.sdk.g.a.b
 *  com.adincube.sdk.h.a
 *  com.adincube.sdk.h.b.a
 *  com.adincube.sdk.h.b.b
 *  com.adincube.sdk.h.c.a
 *  com.adincube.sdk.h.c.b
 *  com.adincube.sdk.h.f.d
 *  com.adincube.sdk.h.f.e
 *  com.adincube.sdk.j.a.a
 *  com.adincube.sdk.j.a.a$a
 *  com.adincube.sdk.j.a.b
 *  com.adincube.sdk.j.a.b$a
 *  com.adincube.sdk.j.a.d
 *  com.adincube.sdk.j.a.d$a
 *  com.adincube.sdk.j.b
 *  java.lang.Boolean
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.Locale
 *  org.json.JSONObject
 */
package com.adincube.sdk.j;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.NetworkInfo;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.adincube.sdk.h.f.e;
import com.adincube.sdk.j.a.a;
import com.adincube.sdk.j.a.b;
import com.adincube.sdk.j.a.d;
import com.adincube.sdk.util.ErrorReportingHelper;
import com.adincube.sdk.util.b.g;
import com.adincube.sdk.util.b.j;
import com.adincube.sdk.util.f;
import com.adincube.sdk.util.p;
import com.adincube.sdk.util.y;
import java.util.Locale;
import org.json.JSONObject;

public abstract class a
extends com.adincube.sdk.j.b {
    public com.adincube.sdk.h.c.b a;
    public com.adincube.sdk.h.c.a b;
    public Boolean c;

    public final JSONObject a() {
        return this.a(com.adincube.sdk.g.g.d.a().c());
    }

    public JSONObject a(e e2) {
        com.adincube.sdk.h.a a2;
        JSONObject jSONObject = new JSONObject();
        Context context = f.a();
        new a$a();
        com.adincube.sdk.j.a.a a3 = new com.adincube.sdk.j.a.a();
        a3.a = context.getPackageName();
        a3.b = com.adincube.sdk.util.b.b.a(context);
        a3.c = com.adincube.sdk.util.b.b.b(context);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("pa", (Object)a3.a);
        jSONObject2.put("vc", a3.b);
        jSONObject2.put("vn", (Object)a3.c);
        jSONObject.put("a", (Object)jSONObject2);
        new b$a();
        com.adincube.sdk.h.b.b b2 = this.b();
        b b3 = new b();
        com.adincube.sdk.h.b.b b4 = com.adincube.sdk.g.a.a().a(true, true);
        String string = b4 != null && com.adincube.sdk.h.b.b.a((com.adincube.sdk.h.b.b)b4, (com.adincube.sdk.h.b.a)com.adincube.sdk.h.b.a.d) ? Settings.Secure.getString((ContentResolver)context.getContentResolver(), (String)"android_id") : null;
        if (string != null) {
            b3.a = com.adincube.sdk.util.g.a(b2, string);
        }
        if ((a2 = com.adincube.sdk.g.a.b.a().b()) != null) {
            if (a2.a != null) {
                b3.b = com.adincube.sdk.util.g.a(b2, a2.a);
            }
            b3.c = a2.b;
        }
        b3.d = com.adincube.sdk.util.e.a.b(context);
        b3.i = com.adincube.sdk.util.b.a.b();
        b3.j = Build.VERSION.RELEASE;
        if (com.adincube.sdk.util.b.d.c(context) != null) {
            b3.e = com.adincube.sdk.util.g.a(b2, com.adincube.sdk.util.b.d.c(context));
            String string2 = com.adincube.sdk.util.b.d.d(context);
            String string3 = string2 == null ? null : p.a("SHA-1", string2);
            b3.f = com.adincube.sdk.util.g.a(b2, string3);
        }
        if (com.adincube.sdk.util.b.d.a(context) != null) {
            b3.g = com.adincube.sdk.util.g.a(b2, com.adincube.sdk.util.b.d.a(context));
            String string4 = com.adincube.sdk.util.b.d.b(context);
            String string5 = string4 == null ? null : p.a("SHA-1", string4);
            b3.h = com.adincube.sdk.util.g.a(b2, string5);
        }
        b3.k = j.a((Context)context).widthPixels;
        b3.l = j.a((Context)context).heightPixels;
        DisplayMetrics displayMetrics = j.a(context);
        b3.m = (int)Math.max((float)displayMetrics.xdpi, (float)displayMetrics.ydpi);
        b3.n = j.a((Context)context).density;
        NetworkInfo networkInfo = g.a(context);
        Integer n2 = networkInfo == null ? null : Integer.valueOf((int)networkInfo.getType());
        b3.o = n2;
        NetworkInfo networkInfo2 = g.a(context);
        Integer n3 = networkInfo2 == null ? null : Integer.valueOf((int)networkInfo2.getSubtype());
        b3.p = n3;
        b3.q = ((TelephonyManager)context.getSystemService("phone")).getNetworkOperator();
        b3.r = ((TelephonyManager)context.getSystemService("phone")).getNetworkOperatorName();
        TelephonyManager telephonyManager = (TelephonyManager)context.getSystemService("phone");
        String string6 = telephonyManager.getSimCountryIso();
        if ((string6 == null || string6.length() == 0) && telephonyManager.getPhoneType() != 2) {
            string6 = telephonyManager.getNetworkCountryIso();
        }
        if (string6 == null || string6.length() == 0) {
            string6 = context.getResources().getConfiguration().locale.getCountry();
        }
        if (string6 != null) {
            string6 = string6.toUpperCase(Locale.US);
        }
        if (string6 != null && string6.length() > 2) {
            string6 = string6.substring(0, 2);
        }
        b3.s = string6;
        String string7 = context.getResources().getConfiguration().locale.getLanguage();
        if (string7 == null) {
            string7 = Locale.getDefault().getLanguage();
        }
        b3.t = string7;
        b3.u = Build.MANUFACTURER;
        b3.v = Build.MODEL;
        b3.w = Build.PRODUCT;
        b3.x = Build.CPU_ABI;
        com.adincube.sdk.h.f.d d2 = e2.a;
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("s", b3.i);
        jSONObject3.put("v", (Object)b3.j);
        if (b3.e != null) {
            jSONObject3.put("im", (Object)b3.e);
            jSONObject3.put("is", (Object)b3.f);
        }
        if (b3.g != null) {
            jSONObject3.put("mm", (Object)b3.g);
            jSONObject3.put("ms", (Object)b3.h);
        }
        jSONObject3.put("sw", b3.k);
        jSONObject3.put("sh", b3.l);
        jSONObject3.put("sd", b3.m);
        jSONObject3.put("sdf", (double)b3.n);
        jSONObject3.put("nt", (Object)b3.o);
        jSONObject3.put("nst", (Object)b3.p);
        jSONObject3.put("ma", (Object)b3.u);
        jSONObject3.put("mo", (Object)b3.v);
        jSONObject3.put("p", (Object)b3.w);
        jSONObject3.put("cp", (Object)b3.x);
        if (d2 != null && d2.a()) {
            if (b3.a != null) {
                jSONObject3.put("a", (Object)b3.a);
            }
            jSONObject3.put("ai", (Object)b3.b);
            jSONObject3.put("lat", b3.c);
            jSONObject3.put("bua", (Object)b3.d);
            jSONObject3.put("c", (Object)b3.s);
            jSONObject3.put("l", (Object)b3.t);
            jSONObject3.put("no", (Object)b3.q);
            jSONObject3.put("non", (Object)b3.r);
        }
        jSONObject.put("d", (Object)jSONObject3);
        new d$a();
        d d3 = new d();
        d3.a = com.adincube.sdk.util.d.b();
        d3.b = "2.7.5";
        d3.c = "Java";
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put("pk", (Object)d3.a);
        jSONObject4.put("v", (Object)d3.b);
        jSONObject4.put("t", (Object)d3.c);
        jSONObject.put("s", (Object)jSONObject4);
        if (e2.a != null) {
            jSONObject.put("c", (Object)e2.a.f);
            jSONObject.put("cn", (Object)e2.b);
        }
        jSONObject.put("lct", (Object)this.c());
        com.adincube.sdk.h.c.b b5 = this.a;
        if (b5 != null) {
            jSONObject.put("at", (Object)b5.e);
            com.adincube.sdk.h.c.a a4 = this.b;
            if (a4 != null) {
                jSONObject.put("ast", (Object)a4.e);
            }
            jSONObject.put("ar", (Object)this.c);
        }
        jSONObject.put("t", System.currentTimeMillis());
        return jSONObject;
    }

    protected void a(Throwable throwable) {
        ErrorReportingHelper.report("GenericAdinCubeRequest.run", this.a, this.b, this.c, throwable);
    }

    protected final void a(boolean bl) {
        if (y.a()) {
            y.b();
            this.e = -1 + this.e;
            this.k();
            return;
        }
        super.a(bl);
    }

    protected com.adincube.sdk.h.b.b b() {
        return com.adincube.sdk.g.a.a().a(true, false);
    }

    protected Long c() {
        return com.adincube.sdk.g.a.a().a(true);
    }

    protected final String d() {
        String string = this.i();
        if (this.a != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append(" - ");
            stringBuilder.append(this.a.e);
            String string2 = stringBuilder.toString();
            if (this.b != null) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(string2);
                stringBuilder2.append(" - ");
                stringBuilder2.append(this.b.e);
                return stringBuilder2.toString();
            }
            string = string2;
        }
        return string;
    }
}

