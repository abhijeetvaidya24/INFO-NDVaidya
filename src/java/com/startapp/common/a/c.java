/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.annotation.SuppressLint
 *  android.app.Activity
 *  android.app.ActivityManager
 *  android.app.ActivityManager$MemoryInfo
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.pm.Signature
 *  android.graphics.Paint
 *  android.net.wifi.ScanResult
 *  android.net.wifi.WifiManager
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.StatFs
 *  android.os.SystemClock
 *  android.provider.Settings
 *  android.provider.Settings$Global
 *  android.provider.Settings$Secure
 *  android.provider.Settings$System
 *  android.telephony.CellInfo
 *  android.telephony.TelephonyManager
 *  android.view.Display
 *  android.view.View
 *  android.view.View$OnLayoutChangeListener
 *  android.view.ViewPropertyAnimator
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  android.view.WindowManager
 *  android.view.inputmethod.InputMethodInfo
 *  android.view.inputmethod.InputMethodManager
 *  android.view.inputmethod.InputMethodSubtype
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  java.io.File
 *  java.io.InputStream
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.lang.reflect.Method
 *  java.util.Arrays
 *  java.util.Comparator
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Set
 */
package com.startapp.common.a;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.Paint;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.StatFs;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.CellInfo;
import android.telephony.TelephonyManager;
import android.view.Display;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import android.view.inputmethod.InputMethodSubtype;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.startapp.common.Constants;
import com.startapp.common.a.g;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class c {
    private static Object a;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int a(int n2) {
        if (Build.VERSION.SDK_INT >= 17) return n2;
        if (n2 == 16) return 0;
        if (n2 == 17) return 1;
        if (n2 == 20) return 9;
        if (n2 == 21) return 11;
        if (n2 != 8388611) {
            if (n2 != 8388613) {
                return n2;
            }
            if (Build.VERSION.SDK_INT >= 14) return n2;
            return 5;
        }
        if (Build.VERSION.SDK_INT >= 14) return n2;
        return 3;
    }

    public static int a(int n2, int n3, boolean bl) {
        if (n2 != 1) {
            if (n2 != 2) {
                return 1;
            }
            if (Build.VERSION.SDK_INT <= 8) {
                return 0;
            }
            if (!bl && n3 != 0) {
                if (n3 == 1) {
                    return 0;
                }
                return 8;
            }
            return 0;
        }
        if (Build.VERSION.SDK_INT <= 8) {
            return 1;
        }
        if (!(bl || n3 != 1 && n3 != 2)) {
            return 9;
        }
        return 1;
    }

    public static int a(Activity activity, int n2, boolean bl) {
        int n3 = c.a(n2, activity.getWindowManager().getDefaultDisplay().getRotation(), bl);
        c.a(activity, n3);
        return n3;
    }

    public static long a(ScanResult scanResult) {
        if (Build.VERSION.SDK_INT >= 17) {
            return System.currentTimeMillis() - SystemClock.elapsedRealtime() + scanResult.timestamp / 1000L;
        }
        return 0L;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static long a(File var0, long var1_1) {
        if (var0 == null) ** GOTO lbl14
        try {
            if (var0.isDirectory()) {
                if (Build.VERSION.SDK_INT >= 9) {
                    return var0.getFreeSpace();
                }
                var7_2 = new StatFs(var0.getPath());
                if (Build.VERSION.SDK_INT >= 18) {
                    var8_3 = var7_2.getBlockSizeLong();
                    var10_4 = var7_2.getFreeBlocksLong();
                    return var8_3 * var10_4;
                }
                var8_3 = var7_2.getBlockSize();
                var10_4 = var7_2.getFreeBlocks();
                return var8_3 * var10_4;
            }
lbl14: // 3 sources:
            g.a("ApiUtil", 6, "Invalid filesDir argument - null or not a directory");
            return var1_1;
        }
        catch (Exception var3_5) {}
        var4_6 = new StringBuilder();
        var4_6.append("Failed calculating free space with error: ");
        var4_6.append(var3_5.getMessage());
        g.a("ApiUtil", 6, var4_6.toString());
        return var1_1;
    }

    public static Long a(ActivityManager.MemoryInfo memoryInfo) {
        if (Build.VERSION.SDK_INT >= 16) {
            return memoryInfo.totalMem;
        }
        return null;
    }

    public static List<ScanResult> a(Context context, WifiManager wifiManager) {
        if (context != null) {
            if (wifiManager == null) {
                return null;
            }
            int n2 = Build.VERSION.SDK_INT;
            boolean bl = true;
            if (n2 >= 23 && !c.a(context, "android.permission.ACCESS_FINE_LOCATION") && !c.a(context, "android.permission.ACCESS_COARSE_LOCATION")) {
                bl = false;
            }
            if (bl) {
                try {
                    List list = wifiManager.getScanResults();
                    return list;
                }
                catch (Exception exception) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Failed to retreive WIFI scan results: ");
                    stringBuilder.append(exception.getLocalizedMessage());
                    g.a("ApiUtil", 6, stringBuilder.toString());
                    return null;
                }
            }
            g.a("ApiUtil", 3, "Unable to get WIFI scan results: API level >= 23 but no location permission granted");
        }
        return null;
    }

    public static List<CellInfo> a(Context context, TelephonyManager telephonyManager) {
        if (context != null) {
            if (telephonyManager == null) {
                return null;
            }
            if ((c.a(context, "android.permission.ACCESS_FINE_LOCATION") || c.a(context, "android.permission.ACCESS_COARSE_LOCATION")) && Build.VERSION.SDK_INT >= 17) {
                return telephonyManager.getAllCellInfo();
            }
        }
        return null;
    }

    public static List<PackageInfo> a(PackageManager packageManager) {
        String string = new String(new byte[]{103, 101, 116, 73, 110, 115, 116, 97, 108, 108, 101, 100, 80, 97, 99, 107, 97, 103, 101, 115});
        Class class_ = packageManager.getClass();
        Class[] arrclass = new Class[]{Integer.TYPE};
        Method method = class_.getMethod(string, arrclass);
        Object[] arrobject = new Object[]{8192};
        return (List)method.invoke((Object)packageManager, arrobject);
    }

    public static void a(Activity activity) {
        if (Build.VERSION.SDK_INT >= 9) {
            c.a(activity, 7);
            return;
        }
        c.a(activity, 1);
    }

    public static void a(Activity activity, int n2) {
        try {
            activity.setRequestedOrientation(n2);
            return;
        }
        catch (Exception exception) {
            g.a(6, "Error to setRequestedOrientation ", exception);
            return;
        }
    }

    @SuppressLint(value={"NewApi"})
    public static void a(SharedPreferences.Editor editor) {
        if (Build.VERSION.SDK_INT < 9) {
            editor.commit();
            return;
        }
        editor.apply();
    }

    public static void a(View view, float f2) {
        if (Build.VERSION.SDK_INT >= 11) {
            view.setAlpha(f2);
        }
    }

    public static void a(View view, long l2) {
        view.animate().alpha(1.0f).setDuration(l2).setListener(null);
    }

    public static void a(View view, final a a2) {
        if (Build.VERSION.SDK_INT >= 11) {
            view.addOnLayoutChangeListener(new View.OnLayoutChangeListener(){

                public void onLayoutChange(View view, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9) {
                    a2.a(view, n2, n3, n4, n5, n6, n7, n8, n9);
                }
            });
        }
    }

    public static void a(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        if (Build.VERSION.SDK_INT >= 16) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
            return;
        }
        viewTreeObserver.removeGlobalOnLayoutListener(onGlobalLayoutListener);
    }

    public static void a(WebView webView) {
        if (Build.VERSION.SDK_INT >= 17) {
            webView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        }
    }

    public static void a(WebView webView, Paint paint) {
        if (Build.VERSION.SDK_INT >= 11) {
            webView.setLayerType(1, paint);
        }
    }

    public static boolean a() {
        return Build.VERSION.SDK_INT >= 12;
    }

    /*
     * Exception decompiling
     */
    public static boolean a(Context var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl26.1 : ICONST_0 : trying to set 1 previously set to 0
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

    public static boolean a(Context context, String string) {
        block4 : {
            try {
                if (Build.VERSION.SDK_INT < 23) break block4;
                return context.checkSelfPermission(string) == 0;
            }
            catch (Throwable throwable) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Exception while checking permission: ");
                stringBuilder.append((Object)throwable);
                String string2 = stringBuilder.toString() != null ? throwable.getMessage() : "";
                g.a(6, string2);
                return false;
            }
        }
        int n2 = context.checkCallingOrSelfPermission(string);
        boolean bl = false;
        if (n2 == 0) {
            bl = true;
        }
        return bl;
    }

    /*
     * Exception decompiling
     */
    public static boolean a(Context var0, String var1, int var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
        // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
        // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
        // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
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

    public static boolean a(PackageInfo packageInfo) {
        int n2 = packageInfo.applicationInfo.flags;
        boolean bl = true;
        if ((n2 & bl) == 0) {
            if ((128 & packageInfo.applicationInfo.flags) != 0) {
                return bl;
            }
            bl = false;
        }
        return bl;
    }

    public static boolean a(View view, boolean bl) {
        if (Build.VERSION.SDK_INT < 11) {
            return false;
        }
        if (1 == view.getLayerType()) {
            return false;
        }
        if (bl) {
            return view.isHardwareAccelerated();
        }
        return false;
    }

    public static CharSequence b(ScanResult scanResult) {
        if (Build.VERSION.SDK_INT >= 23) {
            return scanResult.venueName;
        }
        return "";
    }

    /*
     * Exception decompiling
     */
    public static String b(Context var0, TelephonyManager var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl64 : ACONST_NULL : trying to set 0 previously set to 1
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

    public static Set<String> b(Context context) {
        HashSet hashSet = new HashSet();
        if (Build.VERSION.SDK_INT >= 11) {
            try {
                InputMethodManager inputMethodManager = (InputMethodManager)context.getSystemService("input_method");
                Iterator iterator = inputMethodManager.getEnabledInputMethodList().iterator();
                while (iterator.hasNext()) {
                    for (InputMethodSubtype inputMethodSubtype : inputMethodManager.getEnabledInputMethodSubtypeList((InputMethodInfo)iterator.next(), true)) {
                        if (!inputMethodSubtype.getMode().equals((Object)"keyboard")) continue;
                        hashSet.add((Object)inputMethodSubtype.getLocale());
                    }
                }
            }
            catch (Exception exception) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Failed to retreive keyboard input langs: ");
                stringBuilder.append(exception.getLocalizedMessage());
                g.a("ApiUtil", 6, stringBuilder.toString());
            }
        }
        return hashSet;
    }

    public static void b(Activity activity) {
        if (Build.VERSION.SDK_INT >= 9) {
            c.a(activity, 6);
            return;
        }
        c.a(activity, 0);
    }

    public static void b(WebView webView) {
        if (Build.VERSION.SDK_INT >= 11) {
            webView.onPause();
            return;
        }
        try {
            Class.forName((String)"android.webkit.WebView").getMethod("onPause", (Class[])null).invoke((Object)webView, (Object[])null);
            return;
        }
        catch (Exception exception) {
            g.a(6, "Error while calling webView.onPause()");
            return;
        }
    }

    public static boolean b() {
        return Build.VERSION.SDK_INT >= 14;
    }

    public static void c(WebView webView) {
        if (Build.VERSION.SDK_INT >= 11) {
            webView.onResume();
            return;
        }
        try {
            Class.forName((String)"android.webkit.WebView").getMethod("onResume", (Class[])null).invoke((Object)webView, (Object[])null);
            return;
        }
        catch (Exception exception) {
            g.a(6, "Error while calling webView.onResume()");
            return;
        }
    }

    public static boolean c(Context context) {
        return Build.VERSION.SDK_INT >= 17 ? Settings.Global.getInt((ContentResolver)context.getContentResolver(), (String)"auto_time", (int)0) > 0 : Settings.System.getInt((ContentResolver)context.getContentResolver(), (String)"auto_time", (int)0) > 0;
    }

    public static int d(Context context) {
        int n2;
        n2 = 0;
        try {
            n2 = context.getPackageManager().getPackageInfo((String)context.getPackageName(), (int)0).versionCode;
        }
        catch (PackageManager.NameNotFoundException | Exception throwable) {}
        return n2;
    }

    public static String e(Context context) {
        try {
            String string = context.getPackageManager().getPackageInfo((String)context.getPackageName(), (int)0).versionName;
            return string;
        }
        catch (PackageManager.NameNotFoundException | Exception throwable) {
            return null;
        }
    }

    public static int f(Context context) {
        g.a("ApiUtil", 3, "getPackageList entered");
        int n2 = 0;
        try {
            for (PackageInfo packageInfo : c.a(context.getPackageManager())) {
                boolean bl;
                if (c.a(packageInfo) && !(bl = packageInfo.packageName.equals((Object)Constants.a))) continue;
            }
        }
        catch (Exception exception) {
            g.a("ApiUtil", 6, "Could not complete getPackagesList", exception);
        }
        {
            ++n2;
            continue;
            break;
        }
        return n2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean g(Context context) {
        try {
            int n2 = Build.VERSION.SDK_INT;
            int n3 = n2 < 17 ? Settings.Secure.getInt((ContentResolver)context.getContentResolver(), (String)"adb_enabled", (int)0) : Settings.Global.getInt((ContentResolver)context.getContentResolver(), (String)"adb_enabled", (int)0);
            boolean bl = false;
            if (n3 == 0) return bl;
            return true;
        }
        catch (Exception exception) {
            g.a("ApiUtil", 6, "getUsbDebug", exception);
            return false;
        }
    }

    public static boolean h(Context context) {
        try {
            boolean bl = com.startapp.android.b.c.a(context);
            return bl;
        }
        catch (Throwable throwable) {
            g.a("ApiUtil", 6, "isRooted", throwable);
            return false;
        }
    }

    public static boolean i(Context context) {
        try {
            boolean bl = com.startapp.android.a.a.a(context);
            return bl;
        }
        catch (Throwable throwable) {
            g.a("ApiUtil", 6, "isSimulator", throwable);
            return false;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String j(Context context) {
        StringBuilder stringBuilder;
        int n2;
        Object[] arrobject;
        try {
            arrobject = context.getPackageManager().getPackageInfo((String)context.getPackageName(), (int)64).signatures;
            if (arrobject != null && arrobject.length > 0) {
                int n3 = arrobject.length;
                n2 = 0;
                if (n3 == 1) {
                    return arrobject[0].toCharsString();
                }
            } else {
                g.a("ApiUtil", 6, "getApkSignature: empty signatures");
                return null;
            }
            Arrays.sort((Object[])arrobject, (Comparator)new Comparator<Signature>(){

                public int a(Signature signature, Signature signature2) {
                    return signature.toCharsString().compareTo(signature2.toCharsString());
                }

                public /* synthetic */ int compare(Object object, Object object2) {
                    return this.a((Signature)object, (Signature)object2);
                }
            });
            stringBuilder = new StringBuilder();
        }
        catch (Exception exception) {
            g.a("ApiUtil", 6, "getApkSignature", exception);
            return null;
        }
        while (n2 < arrobject.length) {
            stringBuilder.append(arrobject[n2].toCharsString());
            if (n2 < arrobject.length - 1) {
                stringBuilder.append(';');
            }
            ++n2;
        }
        return stringBuilder.toString();
    }

    /*
     * Exception decompiling
     */
    public String a(InputStream var1, String var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl68.1 : ALOAD_3 : trying to set 1 previously set to 0
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

    /*
     * Exception decompiling
     */
    public String a(String var1, Context var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl14 : ACONST_NULL : trying to set 1 previously set to 0
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

    public static interface a {
        public void a(View var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9);
    }

}

