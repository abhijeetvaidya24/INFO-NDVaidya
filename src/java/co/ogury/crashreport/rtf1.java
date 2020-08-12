/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package co.ogury.crashreport;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import co.ogury.crashreport.f0;
import co.ogury.crashreport.tx8640;

public final class rtf1 {
    public static final rtf1 a = new rtf1(0);
    private final String b;
    private final String c;

    public rtf1(String string, String string2) {
        tx8640.b(string, "version");
        tx8640.b(string2, "packageName");
        this.b = string;
        this.c = string2;
    }

    public final String a() {
        return this.b;
    }

    public final String b() {
        return this.c;
    }

    public static final class rtf1 {
        private rtf1() {
        }

        public /* synthetic */ rtf1(byte by2) {
            this();
        }

        private static int a(int n2, int n3) {
            int n4 = n2 % n3;
            if (n4 >= 0) {
                return n4;
            }
            return n4 + n3;
        }

        public static int a(int n2, int n3, int n4) {
            if (n4 > 0) {
                if (n2 >= n3) {
                    return n3;
                }
                return n3 - rtf1.b(n3, n2, n4);
            }
            if (n4 < 0) {
                if (n2 <= n3) {
                    return n3;
                }
                return n3 + rtf1.b(n2, n3, -n4);
            }
            throw (Throwable)new IllegalArgumentException("Step is zero.");
        }

        public static rtf1 a(Context context) {
            PackageInfo packageInfo;
            String string;
            tx8640.b((Object)context, "context");
            try {
                packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            }
            catch (Exception exception) {
                f0.a(exception);
                packageInfo = null;
            }
            if (packageInfo == null || (string = packageInfo.versionName) == null) {
                string = "";
            }
            String string2 = context.getPackageName();
            tx8640.a((Object)string2, "context.packageName");
            return new rtf1(string, string2);
        }

        private static int b(int n2, int n3, int n4) {
            return rtf1.a(rtf1.a(n2, n4) - rtf1.a(n3, n4), n4);
        }
    }

}

