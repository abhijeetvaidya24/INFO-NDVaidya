/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageManager
 *  android.media.AudioManager
 *  android.os.AsyncTask
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.provider.Settings
 *  android.provider.Settings$Global
 *  android.provider.Settings$Secure
 *  android.telephony.TelephonyManager
 *  com.moat.analytics.mobile.mpub.k
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.ClassNotFoundException
 *  java.lang.Double
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.ref.WeakReference
 *  java.lang.reflect.Method
 */
package com.moat.analytics.mobile.mpub;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.os.AsyncTask;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.moat.analytics.mobile.mpub.MoatAnalytics;
import com.moat.analytics.mobile.mpub.k;
import com.moat.analytics.mobile.mpub.m;
import com.moat.analytics.mobile.mpub.p;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;

class s {
    private static String a;
    private static a b;
    private static b c;

    s() {
    }

    static double a() {
        int n2;
        int n3;
        try {
            AudioManager audioManager = (AudioManager)com.moat.analytics.mobile.mpub.a.a().getSystemService("audio");
            n3 = s.h();
            n2 = audioManager.getStreamMaxVolume(3);
        }
        catch (Exception exception) {
            m.a(exception);
            return 0.0;
        }
        double d2 = n3;
        double d3 = n2;
        Double.isNaN((double)d2);
        Double.isNaN((double)d3);
        return d2 / d3;
    }

    static void a(final Context context) {
        try {
            AsyncTask.execute((Runnable)new Runnable(){

                /*
                 * Enabled aggressive block sorting
                 * Enabled unnecessary exception pruning
                 * Enabled aggressive exception aggregation
                 */
                public void run() {
                    String string2;
                    void var1_11;
                    try {
                        String string3;
                        Class class_ = Class.forName((String)"com.google.android.gms.ads.identifier.AdvertisingIdClient");
                        Class class_2 = Class.forName((String)"com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
                        Method method = class_.getMethod("getAdvertisingIdInfo", new Class[]{Context.class});
                        Object[] arrobject = new Object[]{context};
                        Object object = method.invoke(null, arrobject);
                        if (!((Boolean)class_2.getMethod("isLimitAdTrackingEnabled", new Class[0]).invoke(object, new Object[0])).booleanValue()) {
                            a = (String)class_2.getMethod("getId", new Class[0]).invoke(object, new Object[0]);
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Retrieved Advertising ID = ");
                            stringBuilder.append(a);
                            string3 = stringBuilder.toString();
                        } else {
                            string3 = "User has limited ad tracking";
                        }
                        p.a(3, "Util", this, string3);
                        return;
                    }
                    catch (Exception exception) {
                        m.a(exception);
                        return;
                    }
                    catch (NoSuchMethodException noSuchMethodException) {
                        string2 = "NoSuchMethodException while retrieving Advertising ID";
                    }
                    catch (ClassNotFoundException classNotFoundException) {
                        string2 = "ClassNotFoundException while retrieving Advertising ID";
                    }
                    p.a("Util", this, string2, (Throwable)var1_11);
                }
            });
            return;
        }
        catch (Exception exception) {
            m.a(exception);
            return;
        }
    }

    static String b() {
        return a;
    }

    static boolean b(Context context) {
        return (2 & context.getApplicationInfo().flags) != 0;
    }

    static Context c() {
        WeakReference weakReference = ((k)MoatAnalytics.getInstance()).e;
        if (weakReference != null) {
            return (Context)weakReference.get();
        }
        return null;
    }

    static a d() {
        a a2 = b;
        if (a2 == null || !a2.a) {
            b = new a();
        }
        return b;
    }

    static b e() {
        b b2 = c;
        if (b2 == null || !b2.f) {
            c = new b();
        }
        return c;
    }

    private static int h() {
        try {
            int n2 = ((AudioManager)com.moat.analytics.mobile.mpub.a.a().getSystemService("audio")).getStreamVolume(3);
            return n2;
        }
        catch (Exception exception) {
            m.a(exception);
            return 0;
        }
    }

    private static boolean i() {
        Context context = s.c();
        int n2 = context != null ? (Build.VERSION.SDK_INT >= 17 ? Settings.Global.getInt((ContentResolver)context.getContentResolver(), (String)"adb_enabled", (int)0) : Settings.Secure.getInt((ContentResolver)context.getContentResolver(), (String)"adb_enabled", (int)0)) : 0;
        boolean bl2 = false;
        if (n2 == 1) {
            bl2 = true;
        }
        return bl2;
    }

    static class a {
        private boolean a = false;
        private String b = "_unknown_";
        private String c = "_unknown_";
        private String d = "_unknown_";

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        private a() {
            try {
                Context context = s.c();
                if (context != null) {
                    this.a = true;
                    PackageManager packageManager = context.getPackageManager();
                    this.c = context.getPackageName();
                    this.b = packageManager.getApplicationLabel(context.getApplicationInfo()).toString();
                    this.d = packageManager.getInstallerPackageName(this.c);
                    return;
                }
                p.a(3, "Util", this, "Can't get app name, appContext is null.");
                return;
            }
            catch (Exception exception) {
                m.a(exception);
                return;
            }
        }

        String a() {
            return this.b;
        }

        String b() {
            return this.c;
        }

        String c() {
            String string2 = this.d;
            if (string2 != null) {
                return string2;
            }
            return "_unknown_";
        }
    }

    static class b {
        String a = "_unknown_";
        String b = "_unknown_";
        Integer c = -1;
        boolean d = false;
        boolean e = false;
        boolean f = false;

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        private b() {
            Context context = s.c();
            if (context == null) return;
            try {
                this.f = true;
                TelephonyManager telephonyManager = (TelephonyManager)context.getSystemService("phone");
                this.a = telephonyManager.getSimOperatorName();
                this.b = telephonyManager.getNetworkOperatorName();
                this.c = telephonyManager.getPhoneType();
                this.d = s.i();
                this.e = s.b(context);
                return;
            }
            catch (Exception exception) {
                m.a(exception);
            }
        }
    }

}

