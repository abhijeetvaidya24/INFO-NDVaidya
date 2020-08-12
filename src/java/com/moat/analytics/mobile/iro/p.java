/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Application
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
 *  com.google.android.gms.ads.identifier.AdvertisingIdClient
 *  com.google.android.gms.ads.identifier.AdvertisingIdClient$Info
 *  com.moat.analytics.mobile.iro.j
 *  java.lang.CharSequence
 *  java.lang.Double
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.ref.WeakReference
 */
package com.moat.analytics.mobile.iro;

import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.os.AsyncTask;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.moat.analytics.mobile.iro.MoatAnalytics;
import com.moat.analytics.mobile.iro.j;
import com.moat.analytics.mobile.iro.o;
import java.lang.ref.WeakReference;

final class p {
    private static long \u02ca = 9141242330850693853L;
    private static String \u02cb;
    private static a \u02cf;
    private static b \u0971;

    p() {
    }

    private static int \u02bc() {
        try {
            int n2 = ((AudioManager)com.moat.analytics.mobile.iro.a.\u02ce().getSystemService(p.\u0971("\u31d5\ua369\uf102\u07c6\u55e0\u6b9b").intern())).getStreamVolume(3);
            return n2;
        }
        catch (Exception exception) {
            o.\u0971(exception);
            return 0;
        }
    }

    static a \u02ca() {
        a a2 = \u02cf;
        if (a2 == null || !a2.\u141d) {
            \u02cf = new a(0);
        }
        return \u02cf;
    }

    static void \u02ca(Application application) {
        try {
            AsyncTask.execute((Runnable)new Runnable(application){
                private /* synthetic */ Application \u02ca;
                {
                    this.\u02ca = application;
                }

                /*
                 * Enabled aggressive block sorting
                 * Enabled unnecessary exception pruning
                 * Enabled aggressive exception aggregation
                 */
                public final void run() {
                    try {
                        AdvertisingIdClient.Info info = AdvertisingIdClient.getAdvertisingIdInfo((Context)this.\u02ca);
                        boolean bl2 = info.isLimitAdTrackingEnabled();
                        if (!bl2) {
                            \u02cb = info.getId();
                            StringBuilder stringBuilder = new StringBuilder("Retrieved Advertising ID = ");
                            stringBuilder.append(\u02cb);
                            com.moat.analytics.mobile.iro.b.\u02cf(3, "Util", this, stringBuilder.toString());
                            return;
                        }
                        com.moat.analytics.mobile.iro.b.\u02cf(3, "Util", this, "User has limited ad tracking");
                        return;
                    }
                    catch (Exception exception) {
                        o.\u0971(exception);
                        return;
                    }
                }
            });
            return;
        }
        catch (Exception exception) {
            o.\u0971(exception);
            return;
        }
    }

    static /* synthetic */ boolean \u02ca\u0971() {
        int n2;
        WeakReference weakReference = ((j)MoatAnalytics.getInstance()).\u02cb;
        Context context = weakReference != null ? (Context)weakReference.get() : null;
        int n3 = context == null ? 57 : 88;
        int n4 = n3 != 57 ? ((n2 = Build.VERSION.SDK_INT < 17 ? 14 : 74) != 74 ? Settings.Secure.getInt((ContentResolver)context.getContentResolver(), (String)p.\u0971("\u6d93\uff2f\u499f\uda06\u24ce\ub167\u03c1\u6db9\ufe27\u489a\ud506\u27e8").intern(), (int)0) : Settings.Global.getInt((ContentResolver)context.getContentResolver(), (String)p.\u0971("\u6d93\uff2f\u499f\uda06\u24ce\ub167\u03c1\u6db9\ufe27\u489a\ud506\u27e8").intern(), (int)0)) : 0;
        int n5 = n4 != 1 ? 99 : 47;
        return n5 != 99;
    }

    static Context \u02cb() {
        WeakReference weakReference = ((j)MoatAnalytics.getInstance()).\u02cb;
        if (weakReference != null) {
            return (Context)weakReference.get();
        }
        return null;
    }

    static b \u02ce() {
        b b2 = \u0971;
        if (b2 == null || !b2.\u0971) {
            \u0971 = new b(0);
        }
        return \u0971;
    }

    static boolean \u02ce(Context context) {
        return (2 & context.getApplicationInfo().flags) != 0;
    }

    static String \u02cf() {
        return \u02cb;
    }

    static double \u0971() {
        int n2;
        int n3;
        try {
            AudioManager audioManager = (AudioManager)com.moat.analytics.mobile.iro.a.\u02ce().getSystemService(p.\u0971("\u31d5\ua369\uf102\u07c6\u55e0\u6b9b").intern());
            n3 = p.\u02bc();
            n2 = audioManager.getStreamMaxVolume(3);
        }
        catch (Exception exception) {
            o.\u0971(exception);
            return 0.0;
        }
        double d2 = n3;
        double d3 = n2;
        Double.isNaN((double)d2);
        Double.isNaN((double)d3);
        return d2 / d3;
    }

    private static String \u0971(String string2) {
        char[] arrc = string2.toCharArray();
        char c2 = arrc[0];
        int n2 = arrc.length;
        int n3 = 1;
        char[] arrc2 = new char[n2 - n3];
        int n4;
        while ((n4 = n3 < arrc.length ? 75 : 11) == 75) {
            arrc2[n3 - 1] = (char)((long)(arrc[n3] ^ n3 * c2) ^ \u02ca);
            ++n3;
        }
        return new String(arrc2);
    }

    static final class a {
        String \u02ca = "_unknown_";
        String \u02cb = "_unknown_";
        Integer \u02ce = -1;
        boolean \u02cf = false;
        boolean \u0971 = false;
        boolean \u141d = false;

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        private a() {
            Context context;
            try {
                context = p.\u02cb();
                if (context == null) return;
            }
            catch (Exception exception) {
                o.\u0971(exception);
                return;
            }
            this.\u141d = true;
            TelephonyManager telephonyManager = (TelephonyManager)context.getSystemService("phone");
            this.\u02cb = telephonyManager.getSimOperatorName();
            this.\u02ca = telephonyManager.getNetworkOperatorName();
            this.\u02ce = telephonyManager.getPhoneType();
            this.\u02cf = p.\u02ca\u0971();
            this.\u0971 = p.\u02ce(context);
        }

        /* synthetic */ a(byte by) {
            this();
        }
    }

    static final class b {
        private String \u02cb = "_unknown_";
        private String \u02ce = "_unknown_";
        private String \u02cf = "_unknown_";
        private boolean \u0971 = false;

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        private b() {
            try {
                Context context = p.\u02cb();
                if (context != null) {
                    this.\u0971 = true;
                    PackageManager packageManager = context.getPackageManager();
                    this.\u02cb = context.getPackageName();
                    this.\u02ce = packageManager.getApplicationLabel(context.getApplicationInfo()).toString();
                    this.\u02cf = packageManager.getInstallerPackageName(this.\u02cb);
                    return;
                }
                com.moat.analytics.mobile.iro.b.\u02cf(3, "Util", this, "Can't get app name, appContext is null.");
                return;
            }
            catch (Exception exception) {
                o.\u0971(exception);
                return;
            }
        }

        /* synthetic */ b(byte by) {
            this();
        }

        final String \u02cb() {
            return this.\u02cb;
        }

        final String \u02cf() {
            return this.\u02ce;
        }

        final String \u0971() {
            String string2 = this.\u02cf;
            if (string2 != null) {
                return string2;
            }
            return "_unknown_";
        }
    }

}

