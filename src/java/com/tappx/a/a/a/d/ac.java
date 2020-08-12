/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.res.Resources
 *  android.provider.Settings
 *  android.provider.Settings$Secure
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 */
package com.tappx.a.a.a.d;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.provider.Settings;
import com.tappx.a.a.a.d.o;
import com.tappx.a.a.a.h;
import com.tappx.a.a.a.j.d;

public final class ac {
    public final String a;
    public final String b;
    public final String c;
    public final String d = "2.0";
    public final String e;
    public final String f;
    public final boolean g;

    public ac(String string2, String string3, String string4, String string5, String string6, boolean bl2) {
        this.a = string2;
        this.e = string3;
        this.b = string5;
        this.c = string6;
        this.f = string4;
        this.g = bl2;
    }

    public static class a {
        private static volatile a a;
        private final Context b;
        private final o c;

        public a(Context context) {
            this(context, new o(context));
        }

        a(Context context, o o2) {
            this.b = context;
            this.c = o2;
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

        private String c() {
            try {
                String string2 = String.valueOf((int)this.b.getPackageManager().getPackageInfo((String)"com.google.android.gms", (int)0).versionCode);
                return string2;
            }
            catch (PackageManager.NameNotFoundException nameNotFoundException) {
                return null;
            }
        }

        private String d() {
            int n2 = this.b.getResources().getIdentifier("google_play_services_version", "string", this.b.getPackageName());
            if (n2 == 0) {
                return null;
            }
            return String.valueOf((int)this.b.getResources().getInteger(n2));
        }

        private String e() {
            String string2 = Settings.Secure.getString((ContentResolver)this.b.getContentResolver(), (String)"android_id");
            if (string2 == null) {
                return null;
            }
            return d.a(string2);
        }

        public ac a() {
            String string2;
            boolean bl2;
            String string3 = this.b();
            o.a a2 = this.c.b();
            if (a2 != null) {
                boolean bl3 = a2.b();
                String string4 = a2.a();
                bl2 = bl3;
                string2 = string4;
            } else {
                com.tappx.a.a.a.c.a.b(h.a("krJOYpdJwB0z9kroej+tvgvunIIlLf/GdGehIr+r2OSbd/1jAuDbW6Z7w8Rb+zP0p97z+Ss5rCSYnT4eKWDNHxv5azbxwwxG3XGQe+SC2+3s6Z9kUQ084l1qIWDEae3FGWLeg8k8luby4GoV6Q0RRg"), new Object[0]);
                string2 = null;
                bl2 = false;
            }
            String string5 = this.e();
            String string6 = this.c();
            String string7 = this.d();
            ac ac2 = new ac(string3, string2, string5, string6, string7, bl2);
            return ac2;
        }

        public String b() {
            return "3.1.2";
        }
    }

}

