/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.os.Build
 *  java.io.BufferedReader
 *  java.io.File
 *  java.io.InputStream
 *  java.io.InputStreamReader
 *  java.io.Reader
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.Process
 *  java.lang.Runtime
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.startapp.android.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.startapp.android.b.a;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class c {
    private static a a;

    private static boolean a() {
        String string2 = Build.TAGS;
        return string2 != null && string2.contains((CharSequence)"test-keys");
    }

    public static boolean a(Context context) {
        if (a == null) {
            a = new a(context.getApplicationContext());
        }
        return a.a() || c.a() || c.b() || c.b() || c.c() || c.d() || c.b(context);
        {
        }
    }

    private static boolean a(Context context, String string2) {
        PackageManager packageManager = context.getPackageManager();
        try {
            packageManager.getPackageInfo(string2, 1);
            return true;
        }
        catch (Throwable throwable) {
            return false;
        }
    }

    private static boolean b() {
        String[] arrstring = new String[]{"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su"};
        int n2 = arrstring.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (!new File(arrstring[i2]).exists()) continue;
            return true;
        }
        return false;
    }

    private static boolean b(Context context) {
        String[] arrstring = new String[]{"com.noshufou.android.su", "com.thirdparty.superuser", "eu.chainfire.supersu", "com.koushikdutta.superuser", "com.zachspong.temprootremovejb", "com.ramdroid.appquarantine"};
        int n2 = arrstring.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (!c.a(context, arrstring[i2])) continue;
            return true;
        }
        return false;
    }

    private static boolean c() {
        boolean bl2;
        block6 : {
            Process process = null;
            try {
                process = Runtime.getRuntime().exec(new String[]{"/system/xbin/which", "su"});
                String string2 = new BufferedReader((Reader)new InputStreamReader(process.getInputStream())).readLine();
                bl2 = false;
                if (string2 != null) {
                    bl2 = true;
                }
                if (process == null) break block6;
            }
            catch (Throwable throwable) {
                if (process != null) {
                    process.destroy();
                }
                throw throwable;
            }
            catch (Throwable throwable) {
                if (process != null) {
                    process.destroy();
                }
                return false;
            }
            process.destroy();
        }
        return bl2;
    }

    private static boolean d() {
        try {
            boolean bl2 = new File("/system/app/Superuser.apk").exists();
            return bl2;
        }
        catch (Throwable throwable) {
            return false;
        }
    }
}

