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
 *  com.chartboost.sdk.impl.b
 *  com.google.android.gms.ads.identifier.AdvertisingIdClient
 *  com.google.android.gms.ads.identifier.AdvertisingIdClient$Info
 *  com.moat.analytics.mobile.cha.f
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
package com.moat.analytics.mobile.cha;

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
import com.chartboost.sdk.impl.b;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.moat.analytics.mobile.cha.MoatAnalytics;
import com.moat.analytics.mobile.cha.a;
import com.moat.analytics.mobile.cha.c;
import com.moat.analytics.mobile.cha.f;
import com.moat.analytics.mobile.cha.o;
import java.lang.ref.WeakReference;

final class r {
    private static int \u02bb;
    private static e \u02ca;
    private static d \u02cb;
    private static int \u02ce;
    private static String \u02cf;
    private static int[] \u0971;

    static {
        \u0971 = new int[]{-39340411, 1646369784, -593413711, -1069164445, -50787683, -1327220997, 423245644, -742130253, 54775946, -495304555, 1880137505, 1742082653, 65717847, 1497802820, 828947133, -614454858, 941569790, -1897799303};
        \u02ce = 0;
        \u02bb = 1;
        \u02ca = null;
        \u02cb = null;
    }

    r() {
    }

    static /* synthetic */ boolean \u02bb() {
        int n2;
        WeakReference weakReference = ((f)MoatAnalytics.getInstance()).\u02ca;
        Context context = weakReference != null ? (Context)weakReference.get() : null;
        boolean bl2 = context != null;
        if (bl2) {
            int n3 = 27 + \u02bb;
            \u02ce = n3 % 128;
            n3 % 2;
            int n4 = Build.VERSION.SDK_INT < 17 ? 22 : 19;
            if (n4 != 22) {
                int n5 = 87 + \u02bb;
                \u02ce = n5 % 128;
                n5 % 2;
                n2 = Settings.Global.getInt((ContentResolver)context.getContentResolver(), (String)r.\u02ce(new int[]{-474338915, -1244865125, 562481890, 44523707, -1306238932, 74746991}, 11).intern(), (int)0);
            } else {
                n2 = Settings.Secure.getInt((ContentResolver)context.getContentResolver(), (String)r.\u02ce(new int[]{-474338915, -1244865125, 562481890, 44523707, -1306238932, 74746991}, 11).intern(), (int)0);
            }
        } else {
            n2 = 0;
        }
        boolean bl3 = n2 == 1;
        if (!bl3) {
            return false;
        }
        int n6 = 33 + \u02ce;
        \u02bb = n6 % 128;
        n6 % 2;
        return true;
    }

    private static int \u02bc() {
        try {
            int n2 = ((AudioManager)c.\u02cf().getSystemService(r.\u02ce(new int[]{-1741845568, 995393484, -1443163044, -1832527325}, 5).intern())).getStreamVolume(3);
            return n2;
        }
        catch (Exception exception) {
            o.\u02ce(exception);
            return 0;
        }
    }

    static e \u02ca() {
        e e2 = \u02ca;
        if (e2 == null || !e2.\u02cf) {
            \u02ca = new e(0);
        }
        return \u02ca;
    }

    static d \u02cb() {
        d d2 = \u02cb;
        if (d2 == null || !d2.\u02bd) {
            \u02cb = new d(0);
        }
        return \u02cb;
    }

    static boolean \u02cb(Context context) {
        return (2 & context.getApplicationInfo().flags) != 0;
    }

    static String \u02ce() {
        return \u02cf;
    }

    private static String \u02ce(int[] arrn, int n2) {
        boolean bl2;
        char[] arrc = new char[4];
        char[] arrc2 = new char[arrn.length << 1];
        int[] arrn2 = (int[])\u0971.clone();
        int n3 = 0;
        while (!(bl2 = n3 >= arrn.length)) {
            arrc[0] = (char)(arrn[n3] >>> 16);
            arrc[1] = (char)arrn[n3];
            int n4 = n3 + 1;
            arrc[2] = (char)(arrn[n4] >>> 16);
            arrc[3] = (char)arrn[n4];
            b.a((char[])arrc, (int[])arrn2, (boolean)false);
            int n5 = n3 << 1;
            arrc2[n5] = arrc[0];
            arrc2[n5 + 1] = arrc[1];
            arrc2[n5 + 2] = arrc[2];
            arrc2[n5 + 3] = arrc[3];
            n3 += 2;
        }
        return new String(arrc2, 0, n2);
    }

    static void \u02ce(Application application) {
        try {
            AsyncTask.execute((Runnable)new Runnable(application){
                private /* synthetic */ Application \u02ce;
                {
                    this.\u02ce = application;
                }

                /*
                 * Enabled aggressive block sorting
                 * Enabled unnecessary exception pruning
                 * Enabled aggressive exception aggregation
                 */
                public final void run() {
                    try {
                        AdvertisingIdClient.Info info = AdvertisingIdClient.getAdvertisingIdInfo((Context)this.\u02ce);
                        boolean bl2 = info.isLimitAdTrackingEnabled();
                        if (!bl2) {
                            \u02cf = info.getId();
                            StringBuilder stringBuilder = new StringBuilder("Retrieved Advertising ID = ");
                            stringBuilder.append(\u02cf);
                            a.\u02cf(3, "Util", this, stringBuilder.toString());
                            return;
                        }
                        a.\u02cf(3, "Util", this, "User has limited ad tracking");
                        return;
                    }
                    catch (Exception exception) {
                        o.\u02ce(exception);
                        return;
                    }
                }
            });
            return;
        }
        catch (Exception exception) {
            o.\u02ce(exception);
            return;
        }
    }

    static Context \u02cf() {
        WeakReference weakReference = ((f)MoatAnalytics.getInstance()).\u02ca;
        if (weakReference != null) {
            return (Context)weakReference.get();
        }
        return null;
    }

    static double \u0971() {
        int n2;
        int n3;
        try {
            AudioManager audioManager = (AudioManager)c.\u02cf().getSystemService(r.\u02ce(new int[]{-1741845568, 995393484, -1443163044, -1832527325}, 5).intern());
            n3 = r.\u02bc();
            n2 = audioManager.getStreamMaxVolume(3);
        }
        catch (Exception exception) {
            o.\u02ce(exception);
            return 0.0;
        }
        double d2 = n3;
        double d3 = n2;
        Double.isNaN((double)d2);
        Double.isNaN((double)d3);
        return d2 / d3;
    }

    static final class d {
        boolean \u02bd = false;
        boolean \u02ca = false;
        boolean \u02cb = false;
        String \u02ce = "_unknown_";
        String \u02cf = "_unknown_";
        Integer \u0971 = -1;

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        private d() {
            Context context;
            try {
                context = r.\u02cf();
                if (context == null) return;
            }
            catch (Exception exception) {
                o.\u02ce(exception);
                return;
            }
            this.\u02bd = true;
            TelephonyManager telephonyManager = (TelephonyManager)context.getSystemService("phone");
            this.\u02ce = telephonyManager.getSimOperatorName();
            this.\u02cf = telephonyManager.getNetworkOperatorName();
            this.\u0971 = telephonyManager.getPhoneType();
            this.\u02cb = r.\u02bb();
            this.\u02ca = r.\u02cb(context);
        }

        /* synthetic */ d(byte by) {
            this();
        }
    }

    static final class e {
        private String \u02ca = "_unknown_";
        private String \u02cb = "_unknown_";
        private boolean \u02cf = false;
        private String \u0971 = "_unknown_";

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        private e() {
            try {
                Context context = r.\u02cf();
                if (context != null) {
                    this.\u02cf = true;
                    PackageManager packageManager = context.getPackageManager();
                    this.\u02cb = context.getPackageName();
                    this.\u02ca = packageManager.getApplicationLabel(context.getApplicationInfo()).toString();
                    this.\u0971 = packageManager.getInstallerPackageName(this.\u02cb);
                    return;
                }
                a.\u02cf(3, "Util", this, "Can't get app name, appContext is null.");
                return;
            }
            catch (Exception exception) {
                o.\u02ce(exception);
                return;
            }
        }

        /* synthetic */ e(byte by) {
            this();
        }

        final String \u02cb() {
            return this.\u02cb;
        }

        final String \u02ce() {
            return this.\u02ca;
        }

        final String \u0971() {
            String string = this.\u0971;
            if (string != null) {
                return string;
            }
            return "_unknown_";
        }
    }

}

