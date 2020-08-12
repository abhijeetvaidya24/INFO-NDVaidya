/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.app.Activity
 *  android.content.BroadcastReceiver
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.content.pm.ActivityInfo
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.ResolveInfo
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.media.AudioManager
 *  android.net.Uri
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.StatFs
 *  android.provider.Settings
 *  android.provider.Settings$System
 *  android.telephony.TelephonyManager
 *  android.text.TextUtils
 *  android.util.DisplayMetrics
 *  android.view.Display
 *  android.view.View
 *  android.view.Window
 *  android.view.WindowManager
 *  java.io.File
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.ClassNotFoundException
 *  java.lang.Exception
 *  java.lang.IllegalAccessException
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.reflect.InvocationTargetException
 *  java.lang.reflect.Method
 *  java.text.SimpleDateFormat
 *  java.util.Date
 *  java.util.List
 *  java.util.Locale
 *  java.util.UUID
 *  org.json.JSONObject
 */
package com.ironsource.environment;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONObject;

public class DeviceStatus {
    private static String uniqueId;

    /*
     * Exception decompiling
     */
    private static boolean findBinary(String var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl73.1 : ICONST_0 : trying to set 1 previously set to 0
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

    public static int getActivityRequestedOrientation(Context context) {
        if (context instanceof Activity) {
            return ((Activity)context).getRequestedOrientation();
        }
        return -1;
    }

    public static String[] getAdvertisingIdInfo(Context context) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class class_ = Class.forName((String)"com.google.android.gms.ads.identifier.AdvertisingIdClient");
        Object object = class_.getMethod("getAdvertisingIdInfo", new Class[]{Context.class}).invoke((Object)class_, new Object[]{context});
        Method method = object.getClass().getMethod("getId", new Class[0]);
        Method method2 = object.getClass().getMethod("isLimitAdTrackingEnabled", new Class[0]);
        String string = method.invoke(object, new Object[0]).toString();
        boolean bl2 = (Boolean)method2.invoke(object, new Object[0]);
        String[] arrstring = new String[2];
        arrstring[0] = string;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(bl2);
        arrstring[1] = stringBuilder.toString();
        return arrstring;
    }

    public static int getAndroidAPIVersion() {
        return Build.VERSION.SDK_INT;
    }

    public static String getAndroidOsVersion() {
        return Build.VERSION.RELEASE;
    }

    public static int getApplicationRotation(Context context) {
        return ((WindowManager)context.getSystemService("window")).getDefaultDisplay().getRotation();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static JSONObject getAppsInstallTime(Context var0, boolean var1_1) {
        var2_2 = new Intent("android.intent.action.MAIN", null);
        var2_2.addCategory("android.intent.category.LAUNCHER");
        var4_3 = var0.getPackageManager().queryIntentActivities(var2_2, 0);
        var5_4 = new JSONObject();
        var6_5 = var0.getPackageManager();
        var7_6 = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        var8_7 = 0;
        while (var8_7 < var4_3.size()) {
            block4 : {
                var9_8 = (ResolveInfo)var4_3.get(var8_7);
                if (var1_1) ** GOTO lbl13
                try {
                    if (DeviceStatus.isSystemPackage(var9_8)) break block4;
lbl13: // 2 sources:
                    var11_10 = var7_6.format(new Date(var6_5.getPackageInfo((String)var9_8.activityInfo.packageName, (int)4096).firstInstallTime));
                    var5_4.put(var11_10, 1 + var5_4.optInt(var11_10, 0));
                }
                catch (Exception var10_9) {
                    var10_9.printStackTrace();
                }
            }
            ++var8_7;
        }
        return var5_4;
    }

    public static long getAvailableMemorySizeInMegaBytes(String string) {
        return DeviceStatus.getFreeStorageInBytes(new File(string));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static int getBatteryLevel(Context context) {
        int n2;
        int n3;
        try {
            Intent intent = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            n2 = intent != null ? intent.getIntExtra("level", -1) : 0;
            n3 = 0;
            if (intent != null) {
                n3 = intent.getIntExtra("scale", -1);
            }
            if (n2 == -1 || n3 == -1) return -1;
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return (int)(100.0f * ((float)n2 / (float)n3));
        return -1;
    }

    public static float getDeviceDensity() {
        return Resources.getSystem().getDisplayMetrics().density;
    }

    public static int getDeviceHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    public static String getDeviceModel() {
        return Build.MODEL;
    }

    public static String getDeviceOEM() {
        return Build.MANUFACTURER;
    }

    public static int getDeviceOrientation(Context context) {
        return context.getResources().getConfiguration().orientation;
    }

    public static String getDeviceOs() {
        return "android";
    }

    public static int getDeviceWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static File getExternalCacheDir(Context context) {
        return context.getExternalCacheDir();
    }

    private static long getFreeStorageInBytes(File file) {
        long l2;
        long l3;
        StatFs statFs = new StatFs(file.getPath());
        if (Build.VERSION.SDK_INT < 19) {
            l3 = statFs.getAvailableBlocks();
            l2 = statFs.getBlockSize();
        } else {
            l3 = statFs.getAvailableBlocksLong();
            l2 = statFs.getBlockSizeLong();
        }
        return l3 * l2 / 0x100000L;
    }

    public static List<ApplicationInfo> getInstalledApplications(Context context) {
        return context.getPackageManager().getInstalledApplications(0);
    }

    public static String getInternalCacheDirPath(Context context) {
        File file = context.getCacheDir();
        if (file != null) {
            return file.getPath();
        }
        return null;
    }

    public static String getMobileCarrier(Context context) {
        return ((TelephonyManager)context.getSystemService("phone")).getNetworkOperatorName();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String getOrGenerateOnceUniqueIdentifier(Context context) {
        Class<DeviceStatus> class_ = DeviceStatus.class;
        synchronized (DeviceStatus.class) {
            if (!TextUtils.isEmpty((CharSequence)uniqueId)) {
                return uniqueId;
            }
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences("Mediation_Shared_Preferences", 0);
                if (!sharedPreferences.getBoolean("uuidEnabled", true)) return uniqueId;
                String string = sharedPreferences.getString("cachedUUID", "");
                if (TextUtils.isEmpty((CharSequence)string)) {
                    uniqueId = UUID.randomUUID().toString();
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("cachedUUID", uniqueId);
                    editor.apply();
                    return uniqueId;
                } else {
                    uniqueId = string;
                }
                return uniqueId;
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
            return uniqueId;
        }
    }

    public static float getSystemVolumePercent(Context context) {
        AudioManager audioManager = (AudioManager)context.getSystemService("audio");
        return (float)audioManager.getStreamVolume(3) / (float)audioManager.getStreamMaxVolume(3);
    }

    public static boolean isDeviceOrientationLocked(Context context) {
        int n2 = Settings.System.getInt((ContentResolver)context.getContentResolver(), (String)"accelerometer_rotation", (int)0);
        boolean bl2 = false;
        if (n2 != 1) {
            bl2 = true;
        }
        return bl2;
    }

    @TargetApi(value=19)
    public static boolean isImmersiveSupported(Activity activity) {
        int n2 = activity.getWindow().getDecorView().getSystemUiVisibility();
        return (n2 | 4096) == n2 || (n2 | 2048) == n2;
        {
        }
    }

    public static boolean isRootedDevice() {
        return DeviceStatus.findBinary("su");
    }

    private static boolean isSystemPackage(ResolveInfo resolveInfo) {
        return (1 & resolveInfo.activityInfo.applicationInfo.flags) != 0;
    }
}

