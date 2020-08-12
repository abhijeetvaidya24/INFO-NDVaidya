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
 *  com.moat.analytics.mobile.ogury.e
 *  com.moat.analytics.mobile.ogury.i
 *  io.presage.CamembertauCalvados
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
 *  java.lang.ref.WeakReference
 *  java.lang.reflect.Method
 */
package com.moat.analytics.mobile.ogury;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.os.AsyncTask;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.moat.analytics.mobile.ogury.MoatAnalytics;
import com.moat.analytics.mobile.ogury.e;
import com.moat.analytics.mobile.ogury.i;
import com.moat.analytics.mobile.ogury.l;
import io.presage.CamembertauCalvados;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;

final class s {
    private static long \u02ca = 5996206772453036003L;
    private static String \u02cb;
    private static b \u02ce;
    private static a \u02cf;
    private static int \u0971 = 0;
    private static int \u0971\u0971 = 1;

    static {
        int n2 = 121 + \u0971;
        \u0971\u0971 = n2 % 128;
        boolean bl2 = n2 % 2 == 0;
        if (bl2) {
            super.hashCode();
        }
    }

    s() {
    }

    static /* synthetic */ String \u02bb() {
        int n2 = 27 + \u0971;
        \u0971\u0971 = n2 % 128;
        n2 % 2;
        String string2 = \u02cb;
        int n3 = 115 + \u0971\u0971;
        \u0971 = n3 % 128;
        int n4 = n3 % 2 != 0 ? 42 : 77;
        if (n4 != 42) {
            // empty if block
        }
        return string2;
    }

    static /* synthetic */ boolean \u02bc() {
        int n2;
        int n3;
        int n4 = 107 + \u0971\u0971;
        \u0971 = n4 % 128;
        n4 % 2;
        WeakReference weakReference = ((i)MoatAnalytics.getInstance()).\u02cf;
        Context context = null;
        if (weakReference != null) {
            int n5 = 3 + \u0971\u0971;
            \u0971 = n5 % 128;
            if (n5 % 2 != 0) {
                Context context2 = (Context)weakReference.get();
                super.hashCode();
                context = context2;
            } else {
                context = (Context)weakReference.get();
            }
        }
        if ((n2 = context != null ? 80 : 65) != 65) {
            int n6;
            int n7 = 9 + \u0971;
            \u0971\u0971 = n7 % 128;
            n3 = (n7 % 2 == 0 ? Build.VERSION.SDK_INT >= 108 : (n6 = Build.VERSION.SDK_INT >= 17 ? 55 : 99) != 99) ? Settings.Global.getInt((ContentResolver)context.getContentResolver(), (String)s.\u02ce("\ub091\u15f0\ub0f0\uda77\u2bb2\ub416\u4918\u26ee\u8f78\u1af1\u6b25\ue64f\ucfe5\u5b6e\uaaac").intern(), (int)0) : Settings.Secure.getInt((ContentResolver)context.getContentResolver(), (String)s.\u02ce("\ub091\u15f0\ub0f0\uda77\u2bb2\ub416\u4918\u26ee\u8f78\u1af1\u6b25\ue64f\ucfe5\u5b6e\uaaac").intern(), (int)0);
        } else {
            n3 = 0;
        }
        return n3 == 1;
    }

    private static int \u02bd() {
        int n2;
        int n3 = 39 + \u0971\u0971;
        \u0971 = n3 % 128;
        n3 % 2;
        try {
            n2 = ((AudioManager)com.moat.analytics.mobile.ogury.a.\u02cf().getSystemService(s.\u02ce("\ua67c\u3789\ua61d\uf81f\uab60\u34c2\uf295\u9d55\u999f").intern())).getStreamVolume(3);
        }
        catch (Exception exception) {
            l.\u0971(exception);
            return 0;
        }
        int n4 = 57 + \u0971\u0971;
        \u0971 = n4 % 128;
        if (n4 % 2 != 0) {
            // empty if block
        }
        return n2;
    }

    static Context \u02ca() {
        int n2 = 39 + \u0971\u0971;
        \u0971 = n2 % 128;
        n2 % 2;
        WeakReference weakReference = ((i)MoatAnalytics.getInstance()).\u02cf;
        int n3 = weakReference != null ? 99 : 1;
        if (n3 != 99) {
            return null;
        }
        int n4 = 103 + \u0971\u0971;
        \u0971 = n4 % 128;
        int n5 = n4 % 2 != 0 ? 55 : 42;
        if (n5 != 55) {
            return (Context)weakReference.get();
        }
        return (Context)weakReference.get();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static double \u02cb() {
        Exception exception2;
        block5 : {
            int n2;
            int n3;
            block4 : {
                int n4 = 81 + \u0971;
                \u0971\u0971 = n4 % 128;
                int n5 = n4 % 2 == 0 ? 48 : 33;
                if (n5 != 48) {
                    AudioManager audioManager = (AudioManager)com.moat.analytics.mobile.ogury.a.\u02cf().getSystemService(s.\u02ce("\ua67c\u3789\ua61d\uf81f\uab60\u34c2\uf295\u9d55\u999f").intern());
                    int n6 = s.\u02bd();
                    int n7 = audioManager.getStreamMaxVolume(3);
                    double d2 = n6;
                    double d3 = n7;
                    Double.isNaN((double)d2);
                    Double.isNaN((double)d3);
                    return d2 / d3;
                }
                try {
                    AudioManager audioManager = (AudioManager)com.moat.analytics.mobile.ogury.a.\u02cf().getSystemService(s.\u02ce("\ua67c\u3789\ua61d\uf81f\uab60\u34c2\uf295\u9d55\u999f").intern());
                    n2 = s.\u02bd();
                    n3 = audioManager.getStreamMaxVolume(2);
                    break block4;
                }
                catch (Exception exception2) {}
                break block5;
            }
            double d4 = n2;
            double d5 = n3;
            Double.isNaN((double)d4);
            Double.isNaN((double)d5);
            return d4 * d5;
        }
        l.\u0971(exception2);
        return 0.0;
    }

    static /* synthetic */ String \u02cb(String string2) {
        int n2 = 125 + \u0971\u0971;
        \u0971 = n2 % 128;
        boolean bl2 = n2 % 2 != 0;
        if (!bl2) {
            \u02cb = string2;
        } else {
            \u02cb = string2;
            super.hashCode();
        }
        int n3 = 43 + \u0971;
        \u0971\u0971 = n3 % 128;
        if (n3 % 2 == 0) {
            // empty if block
        }
        return string2;
    }

    static a \u02ce() {
        int n2 = 103 + \u0971;
        \u0971\u0971 = n2 % 128;
        n2 % 2;
        boolean bl2 = \u02cf != null;
        if (!bl2 || !\u02cf.\u0971) {
            \u02cf = new a(0);
            int n3 = 65 + \u0971;
            \u0971\u0971 = n3 % 128;
            n3 % 2;
        }
        return \u02cf;
    }

    private static String \u02ce(String arrc) {
        block4 : {
            block5 : {
                block3 : {
                    int n2 = 31 + \u0971\u0971;
                    \u0971 = n2 % 128;
                    if (n2 % 2 == 0) break block3;
                    if (arrc == null) break block4;
                    break block5;
                }
                boolean bl2 = arrc == null;
                if (bl2) break block4;
            }
            int n3 = 121 + \u0971;
            \u0971\u0971 = n3 % 128;
            int n4 = n3 % 2 == 0 ? 58 : 2;
            arrc = n4 != 58 ? arrc.toCharArray() : arrc.toCharArray();
        }
        char[] arrc2 = arrc;
        char[] arrc3 = CamembertauCalvados.a((long)\u02ca, (char[])arrc2);
        for (int i2 = 4; i2 < arrc3.length; ++i2) {
            int n5 = i2 - 4;
            arrc3[i2] = (char)((long)(arrc3[i2] ^ arrc3[i2 % 4]) ^ (long)n5 * \u02ca);
            int n6 = 107 + \u0971\u0971;
            \u0971 = n6 % 128;
            if (n6 % 2 == 0) continue;
        }
        return new String(arrc3, 4, arrc3.length - 4);
    }

    static void \u02ce(Context context) {
        try {
            AsyncTask.execute((Runnable)new Runnable(context){
                private /* synthetic */ Context \u02ca;
                {
                    this.\u02ca = context;
                }

                public final void run() {
                    try {
                        Class class_ = Class.forName((String)"com.google.android.gms.ads.identifier.AdvertisingIdClient");
                        Class class_2 = Class.forName((String)"com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
                        Method method = class_.getMethod("getAdvertisingIdInfo", new Class[]{Context.class});
                        Object[] arrobject = new Object[]{this.\u02ca};
                        Object object = method.invoke(null, arrobject);
                        if (!((Boolean)class_2.getMethod("isLimitAdTrackingEnabled", new Class[0]).invoke(object, new Object[0])).booleanValue()) {
                            s.\u02cb((String)class_2.getMethod("getId", new Class[0]).invoke(object, new Object[0]));
                            StringBuilder stringBuilder = new StringBuilder("Retrieved Advertising ID = ");
                            stringBuilder.append(s.\u02bb());
                            e.1.\u02cb(3, "Util", this, stringBuilder.toString());
                            return;
                        }
                        e.1.\u02cb(3, "Util", this, "User has limited ad tracking");
                        return;
                    }
                    catch (Exception exception) {
                        l.\u0971(exception);
                        return;
                    }
                    catch (NoSuchMethodException noSuchMethodException) {
                        e.1.\u02cf("Util", this, "NoSuchMethodException while retrieving Advertising ID", noSuchMethodException);
                        return;
                    }
                    catch (ClassNotFoundException classNotFoundException) {
                        e.1.\u02cf("Util", this, "ClassNotFoundException while retrieving Advertising ID", classNotFoundException);
                        return;
                    }
                }
            });
        }
        catch (Exception exception) {
            l.\u0971(exception);
            return;
        }
        int n2 = 103 + \u0971\u0971;
        \u0971 = n2 % 128;
        if (n2 % 2 != 0) {
            // empty if block
        }
    }

    static b \u02cf() {
        block3 : {
            block2 : {
                boolean bl2 = \u02ce != null;
                if (!bl2) break block2;
                int n2 = 31 + \u0971\u0971;
                \u0971 = n2 % 128;
                n2 % 2;
                if (s.\u02ce.\u02bd) break block3;
            }
            \u02ce = new b(0);
            int n3 = 45 + \u0971\u0971;
            \u0971 = n3 % 128;
            n3 % 2;
        }
        return \u02ce;
    }

    static String \u0971() {
        int n2 = 117 + \u0971;
        \u0971\u0971 = n2 % 128;
        n2 % 2;
        String string2 = \u02cb;
        int n3 = 1 + \u0971;
        \u0971\u0971 = n3 % 128;
        boolean bl2 = n3 % 2 == 0;
        if (!bl2) {
            // empty if block
        }
        return string2;
    }

    static boolean \u0971(Context context) {
        boolean bl2;
        int n2 = 83 + \u0971;
        \u0971\u0971 = n2 % 128;
        if (n2 % 2 == 0 ? (4 & context.getApplicationInfo().flags) != 0 : !(bl2 = (2 & context.getApplicationInfo().flags) == 0)) {
            int n3 = 97 + \u0971;
            \u0971\u0971 = n3 % 128;
            int n4 = n3 % 2 == 0 ? 39 : 68;
            if (n4 != 68) {
                // empty if block
            }
            return true;
        }
        return false;
    }

    static final class a {
        private String \u02cb = "_unknown_";
        private String \u02ce = "_unknown_";
        private String \u02cf = "_unknown_";
        private boolean \u0971 = false;

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        private a() {
            try {
                Context context = s.\u02ca();
                if (context != null) {
                    this.\u0971 = true;
                    PackageManager packageManager = context.getPackageManager();
                    this.\u02cb = context.getPackageName();
                    this.\u02ce = packageManager.getApplicationLabel(context.getApplicationInfo()).toString();
                    this.\u02cf = packageManager.getInstallerPackageName(this.\u02cb);
                    return;
                }
                e.1.\u02cb(3, "Util", this, "Can't get app name, appContext is null.");
                return;
            }
            catch (Exception exception) {
                l.\u0971(exception);
                return;
            }
        }

        /* synthetic */ a(byte by) {
            this();
        }

        final String \u02cb() {
            String string2 = this.\u02cf;
            if (string2 != null) {
                return string2;
            }
            return "_unknown_";
        }

        final String \u02cf() {
            return this.\u02cb;
        }

        final String \u0971() {
            return this.\u02ce;
        }
    }

    static final class b {
        boolean \u02bd = false;
        String \u02ca = "_unknown_";
        Integer \u02cb = -1;
        String \u02ce = "_unknown_";
        boolean \u02cf = false;
        boolean \u0971 = false;

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        private b() {
            Context context;
            try {
                context = s.\u02ca();
                if (context == null) return;
            }
            catch (Exception exception) {
                l.\u0971(exception);
                return;
            }
            this.\u02bd = true;
            TelephonyManager telephonyManager = (TelephonyManager)context.getSystemService("phone");
            this.\u02ce = telephonyManager.getSimOperatorName();
            this.\u02ca = telephonyManager.getNetworkOperatorName();
            this.\u02cb = telephonyManager.getPhoneType();
            this.\u02cf = s.\u02bc();
            this.\u0971 = s.\u0971(context);
        }

        /* synthetic */ b(byte by) {
            this();
        }
    }

}

