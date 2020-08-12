/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageManager
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Locale
 */
package com.tappx.a.a.a.d;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import java.util.Locale;

public final class b {
    public final String a;
    public final String b;
    public final String c;

    public b(String string2, String string3, String string4) {
        this.b = string2;
        this.a = string3;
        this.c = string4;
    }

    public static class a {
        private static volatile a a;
        private static final String b = "Unknown";
        private static final String c = "en-us";
        private final Context d;

        public a(Context context) {
            this.d = context;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public static final a a(Context context) {
            if (a != null) return a;
            Class<a> class_ = a.class;
            synchronized (a.class) {
                if (a != null) return a;
                a = new a(context);
                // ** MonitorExit[var2_1] (shouldn't be in output)
                return a;
            }
        }

        private String b() {
            Locale locale = this.d.getResources().getConfiguration().locale;
            if (locale == null) {
                locale = Locale.getDefault();
            }
            if (locale != null) {
                return locale.getLanguage();
            }
            return c;
        }

        private String c() {
            return this.d.getApplicationInfo().loadLabel(this.d.getPackageManager()).toString();
        }

        public b a() {
            String string2 = this.d.getPackageName();
            return new b(this.c(), string2, this.b());
        }
    }

}

