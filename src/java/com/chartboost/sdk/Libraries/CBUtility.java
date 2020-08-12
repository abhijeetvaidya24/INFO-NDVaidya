/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.app.Activity
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.DisplayMetrics
 *  android.view.Display
 *  android.view.View
 *  android.view.Window
 *  android.view.WindowManager
 *  android.view.WindowManager$LayoutParams
 *  com.chartboost.sdk.i
 *  com.chartboost.sdk.impl.s
 *  java.io.File
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Math
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.String
 *  java.text.SimpleDateFormat
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Date
 *  java.util.Locale
 *  java.util.TimeZone
 */
package com.chartboost.sdk.Libraries;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.chartboost.sdk.Chartboost;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Model.e;
import com.chartboost.sdk.i;
import com.chartboost.sdk.impl.s;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class CBUtility {
    private CBUtility() {
    }

    public static float a(float f2, Context context) {
        return f2 * CBUtility.a(context);
    }

    public static float a(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static int a() {
        Context context = i.m;
        Display display = ((WindowManager)context.getSystemService("window")).getDefaultDisplay();
        int n2 = display.getRotation();
        boolean bl = display.getWidth() == display.getHeight() ? context.getResources().getConfiguration().orientation != 2 : display.getWidth() < display.getHeight();
        if (n2 != 0 && n2 != 2) {
            bl ^= true;
        }
        if (bl) {
            if (n2 == 1) {
                return 1;
            }
            if (n2 == 2) {
                return 2;
            }
            if (n2 != 3) {
                return 0;
            }
            return 3;
        }
        if (n2 == 1) {
            return 2;
        }
        if (n2 == 2) {
            return 3;
        }
        return n2 != 3;
    }

    public static int a(int n2, Context context) {
        return Math.round((float)((float)n2 * CBUtility.a(context)));
    }

    public static ArrayList<File> a(File file, boolean bl) {
        if (file == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        File[] arrfile = file.listFiles();
        if (arrfile != null) {
            for (File file2 : arrfile) {
                if (file2.isFile() && !file2.getName().equals((Object)".nomedia")) {
                    arrayList.add((Object)file2);
                    continue;
                }
                if (!file2.isDirectory() || !bl) continue;
                arrayList.addAll(CBUtility.a(file2, bl));
            }
        }
        return arrayList;
    }

    @TargetApi(value=19)
    public static void a(Activity activity) {
        if (activity != null && i.g) {
            s s2 = s.a();
            if (s2.a(11)) {
                boolean bl = s2.a(14);
                int n2 = 0;
                if (bl) {
                    n2 = 2;
                    if (s2.a(16)) {
                        n2 = 1798;
                        if (s2.a(19)) {
                            n2 = 5894;
                        }
                    }
                }
                activity.getWindow().getDecorView().setSystemUiVisibility(n2);
            }
            return;
        }
        if ((1024 & activity.getWindow().getAttributes().flags) != 0) {
            CBLogging.d("CBUtility", "Attempting to show Status and Navigation bars on a fullscreen activity. Please change your Chartboost activity theme to: \"@android:style/Theme.Translucent\"` in your Manifest file");
        }
    }

    public static void a(Activity activity, int n2, e e2) {
        if (activity != null) {
            if (CBUtility.b(activity)) {
                return;
            }
            if (n2 == 1 && e2.y && e2.C || n2 == 0 && e2.e && e2.h) {
                int n3 = CBUtility.a();
                if (n3 == 0) {
                    activity.setRequestedOrientation(1);
                    return;
                }
                if (n3 == 2) {
                    activity.setRequestedOrientation(9);
                    return;
                }
                if (n3 == 1) {
                    activity.setRequestedOrientation(0);
                    return;
                }
                activity.setRequestedOrientation(8);
            }
        }
    }

    public static boolean a(int n2) {
        return n2 == 0 || n2 == 2;
        {
        }
    }

    public static boolean a(Chartboost.CBFramework cBFramework) {
        return i.d != null && i.d == cBFramework;
    }

    public static String b() {
        Object[] arrobject = new Object[3];
        arrobject[0] = "Chartboost-Android-SDK";
        Object object = i.d == null ? "" : i.d;
        arrobject[1] = object;
        arrobject[2] = "7.2.1";
        return String.format((String)"%s %s %s", (Object[])arrobject);
    }

    public static void b(Activity activity, int n2, e e2) {
        if (activity != null) {
            if (CBUtility.b(activity)) {
                return;
            }
            if (n2 == 1 && e2.y && e2.C || n2 == 0 && e2.e && e2.h) {
                activity.setRequestedOrientation(-1);
            }
        }
    }

    public static boolean b(int n2) {
        int n3 = 1;
        if (n2 != n3) {
            if (n2 == 3) {
                return n3;
            }
            n3 = 0;
        }
        return n3;
    }

    public static boolean b(Activity activity) {
        boolean bl = true;
        if (activity != null && activity.getWindow() != null && activity.getWindow().getDecorView() != null) {
            if (activity.getWindow().getDecorView().getBackground() == null) {
                return bl;
            }
            if (Build.VERSION.SDK_INT == 26 && activity.getApplicationInfo().targetSdkVersion > 26 && activity.getWindow().getDecorView().getBackground().getAlpha() != 255) {
                return bl;
            }
            bl = false;
        }
        return bl;
    }

    public static boolean c() {
        return CBUtility.e() || CBUtility.f() || CBUtility.g();
        {
        }
    }

    public static String d() {
        SimpleDateFormat simpleDateFormat = Build.VERSION.SDK_INT >= 18 ? new SimpleDateFormat("ZZZZ", Locale.US) : new SimpleDateFormat("'GMT'ZZZZ", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getDefault());
        return simpleDateFormat.format(new Date());
    }

    private static boolean e() {
        String string2 = Build.TAGS;
        return string2 != null && string2.contains((CharSequence)"test-keys");
    }

    private static boolean f() {
        return new File("/system/app/Superuser.apk").exists();
    }

    private static boolean g() {
        String[] arrstring = new String[]{"/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su"};
        int n2 = arrstring.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (!new File(arrstring[i2]).exists()) continue;
            return true;
        }
        return false;
    }

    public static void throwProguardError(Exception exception) {
        if (exception instanceof NoSuchMethodException) {
            CBLogging.b("CBUtility", "Chartboost library error! Have you used proguard on your application? Make sure to add the line '-keep class com.chartboost.sdk.** { *; }' to your proguard config file.");
            return;
        }
        if (exception != null && exception.getMessage() != null) {
            CBLogging.b("CBUtility", exception.getMessage());
            return;
        }
        CBLogging.b("CBUtility", "Unknown Proguard error");
    }
}

