/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.app.ActivityManager
 *  android.content.BroadcastReceiver
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.os.AsyncTask
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.provider.Settings
 *  android.provider.Settings$Secure
 *  android.security.NetworkSecurityPolicy
 *  android.telephony.TelephonyManager
 *  android.util.DisplayMetrics
 *  android.view.Display
 *  android.view.WindowManager
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  java.lang.Double
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.Runtime
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Void
 *  java.util.Date
 *  java.util.Locale
 *  java.util.TimeZone
 *  java.util.concurrent.Executor
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.adcolony.sdk;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Build;
import android.provider.Settings;
import android.security.NetworkSecurityPolicy;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.adcolony.sdk.ad;
import com.adcolony.sdk.af;
import com.adcolony.sdk.au;
import com.adcolony.sdk.n;
import com.adcolony.sdk.q;
import com.adcolony.sdk.w;
import com.adcolony.sdk.y;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;

class n {
    static int f = 2;
    String a = "";
    String b = "";
    boolean c;
    boolean d;
    JSONObject e = w.a();
    String g = "";
    private String i = "android";
    private String j = "android_native";

    n() {
    }

    /*
     * Exception decompiling
     */
    static JSONObject a(n var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl297 : ALOAD_0 : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:919)
        throw new IllegalStateException("Decompilation failed");
    }

    boolean A() {
        return Build.VERSION.SDK_INT < 23 || NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
        {
        }
    }

    int B() {
        Context context = com.adcolony.sdk.a.c();
        if (context == null) {
            return 2;
        }
        int n2 = context.getResources().getConfiguration().orientation;
        if (n2 != 1) {
            if (n2 != 2) {
                return 2;
            }
            return 1;
        }
        return 0;
    }

    int C() {
        Context context = com.adcolony.sdk.a.c();
        if (context == null) {
            return 0;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager)context.getSystemService("window");
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics.densityDpi;
    }

    String D() {
        return "3.3.7";
    }

    String E() {
        final Context context = com.adcolony.sdk.a.c();
        if (this.b.equals((Object)"") && context != null) {
            au.a(new Runnable(){

                public void run() {
                    n.this.b = new WebView(context).getSettings().getUserAgentString();
                    com.adcolony.sdk.a.a().r().a(n.this.b);
                }
            });
        }
        return this.b;
    }

    String F() {
        Context context = com.adcolony.sdk.a.c();
        if (context == null) {
            return "unknown";
        }
        return context.getPackageName();
    }

    boolean G() {
        if (!com.adcolony.sdk.a.d()) {
            return false;
        }
        int n2 = this.B();
        if (n2 != 0) {
            if (n2 != 1) {
                return false;
            }
            if (f == 0) {
                new y.a().a("Sending device info update").a(y.d);
                f = n2;
                if (this.r() < 14) {
                    new a(null, this, true).execute((Object[])new Void[0]);
                    return true;
                }
                new a(null, this, true).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Object[])new Void[0]);
                return true;
            }
        } else if (f == 1) {
            new y.a().a("Sending device info update").a(y.d);
            f = n2;
            if (this.r() < 14) {
                new a(null, this, true).execute((Object[])new Void[0]);
                return true;
            }
            new a(null, this, true).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Object[])new Void[0]);
            return true;
        }
        return false;
    }

    double a(Context context) {
        double d2 = 0.0;
        if (context == null) {
            return d2;
        }
        Intent intent = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (intent == null) {
            return d2;
        }
        int n2 = intent.getIntExtra("level", -1);
        int n3 = intent.getIntExtra("scale", -1);
        if (n2 >= 0) {
            if (n3 < 0) {
                return d2;
            }
            double d3 = n2;
            double d4 = n3;
            Double.isNaN((double)d3);
            Double.isNaN((double)d4);
            d2 = d3 / d4;
        }
        return d2;
    }

    JSONObject a() {
        return this.e;
    }

    void a(JSONObject jSONObject) {
        this.e = jSONObject;
    }

    @SuppressLint(value={"HardwareIds"})
    String b() {
        Context context = com.adcolony.sdk.a.c();
        if (context == null) {
            return "";
        }
        return Settings.Secure.getString((ContentResolver)context.getContentResolver(), (String)"android_id");
    }

    String c() {
        return this.a;
    }

    String d() {
        return System.getProperty((String)"os.arch").toLowerCase(Locale.ENGLISH);
    }

    void e() {
        this.c = false;
        com.adcolony.sdk.a.a("Device.get_info", new af(this){
            final /* synthetic */ n a;
            {
                this.a = n2;
            }

            public void a(ad ad2) {
                au.a(new Runnable(this, ad2){
                    final /* synthetic */ ad a;
                    final /* synthetic */ 1 b;
                    {
                        this.b = var1_1;
                        this.a = ad2;
                    }

                    public void run() {
                        if (this.b.a.r() < 14) {
                            new a(this.a, this.b.a, false).execute((Object[])new Void[0]);
                            return;
                        }
                        new a(this.a, this.b.a, false).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Object[])new Void[0]);
                    }
                });
            }
        });
        com.adcolony.sdk.a.a("Device.application_exists", new af(this){
            final /* synthetic */ n a;
            {
                this.a = n2;
            }

            public void a(ad ad2) {
                JSONObject jSONObject = w.a();
                w.a(jSONObject, "result", au.a(w.b(ad2.c(), "name")));
                w.a(jSONObject, "success", true);
                ad2.a(jSONObject).b();
            }
        });
    }

    String f() {
        if (this.s()) {
            return "tablet";
        }
        return "phone";
    }

    boolean g() {
        return this.d;
    }

    String h() {
        Context context = com.adcolony.sdk.a.c();
        String string = "";
        if (context == null) {
            return string;
        }
        TelephonyManager telephonyManager = (TelephonyManager)context.getSystemService("phone");
        if (telephonyManager != null) {
            string = telephonyManager.getNetworkOperatorName();
        }
        if (string.length() == 0) {
            string = "unknown";
        }
        return string;
    }

    int i() {
        Context context = com.adcolony.sdk.a.c();
        if (context == null) {
            return 0;
        }
        ActivityManager activityManager = (ActivityManager)context.getApplicationContext().getSystemService("activity");
        if (activityManager == null) {
            return 0;
        }
        return activityManager.getMemoryClass();
    }

    String j() {
        Context context = com.adcolony.sdk.a.c();
        if (context == null) {
            return "";
        }
        TelephonyManager telephonyManager = (TelephonyManager)context.getSystemService("phone");
        String string = telephonyManager == null ? null : telephonyManager.getSimCountryIso();
        if (string == null) {
            string = "";
        }
        return string;
    }

    String k() {
        return TimeZone.getDefault().getID();
    }

    int l() {
        return TimeZone.getDefault().getOffset(15L) / 60000;
    }

    int m() {
        TimeZone timeZone = TimeZone.getDefault();
        if (!timeZone.inDaylightTime(new Date())) {
            return 0;
        }
        return timeZone.getDSTSavings() / 60000;
    }

    long n() {
        Runtime runtime = Runtime.getRuntime();
        return (runtime.totalMemory() - runtime.freeMemory()) / (long)1048576;
    }

    float o() {
        Context context = com.adcolony.sdk.a.c();
        if (context == null) {
            return 0.0f;
        }
        return context.getResources().getDisplayMetrics().density;
    }

    int p() {
        Context context = com.adcolony.sdk.a.c();
        if (context == null) {
            return 0;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager)context.getSystemService("window");
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics.widthPixels;
    }

    int q() {
        Context context = com.adcolony.sdk.a.c();
        if (context == null) {
            return 0;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager)context.getSystemService("window");
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics.heightPixels;
    }

    int r() {
        return Build.VERSION.SDK_INT;
    }

    boolean s() {
        Context context = com.adcolony.sdk.a.c();
        if (context == null) {
            return false;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float f2 = (float)displayMetrics.widthPixels / displayMetrics.xdpi;
        float f3 = (float)displayMetrics.heightPixels / displayMetrics.ydpi;
        double d2 = Math.sqrt((double)(f2 * f2 + f3 * f3)) DCMPL 6.0;
        boolean bl = false;
        if (d2 >= 0) {
            bl = true;
        }
        return bl;
    }

    String t() {
        return Locale.getDefault().getLanguage();
    }

    String u() {
        return Locale.getDefault().getCountry();
    }

    String v() {
        return "";
    }

    String w() {
        return Build.MANUFACTURER;
    }

    String x() {
        return Build.MODEL;
    }

    String y() {
        return Build.VERSION.RELEASE;
    }

    JSONArray z() {
        return au.d(com.adcolony.sdk.a.c());
    }

    static class a
    extends AsyncTask<Void, Void, JSONObject> {
        ad a;
        n b;
        boolean c;

        a(ad ad2, n n2, boolean bl) {
            this.a = ad2;
            this.b = n2;
            this.c = bl;
        }

        protected /* varargs */ JSONObject a(Void ... arrvoid) {
            if (Build.VERSION.SDK_INT < 14) {
                return null;
            }
            return n.a(this.b);
        }

        protected void a(JSONObject jSONObject) {
            if (this.c) {
                new ad("Device.update_info", 1, jSONObject).b();
                return;
            }
            this.a.a(jSONObject).b();
        }

        protected /* synthetic */ Object doInBackground(Object[] arrobject) {
            return this.a((Void[])arrobject);
        }

        protected /* synthetic */ void onPostExecute(Object object) {
            this.a((JSONObject)object);
        }
    }

}

