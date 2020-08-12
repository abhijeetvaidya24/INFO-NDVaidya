/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.pm.PackageManager
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.util.Pair
 *  java.lang.Class
 *  java.lang.ClassNotFoundException
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.lang.reflect.Method
 *  java.util.ArrayList
 */
package com.ironsource.mediationsdk.integration;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import android.util.Pair;
import com.ironsource.mediationsdk.IntegrationData;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class IntegrationHelper {
    private static IntegrationData getIntegrationData(Activity activity, String string) {
        try {
            IntegrationData integrationData = (IntegrationData)Class.forName((String)string).getMethod("getIntegrationData", new Class[]{Activity.class}).invoke(null, new Object[]{activity});
            Log.i((String)"IntegrationHelper", (String)"Adapter - VERIFIED");
            return integrationData;
        }
        catch (Exception exception) {
            Log.e((String)"IntegrationHelper", (String)"Adapter version - NOT VERIFIED");
            return null;
        }
        catch (ClassNotFoundException classNotFoundException) {
            Log.e((String)"IntegrationHelper", (String)"Adapter - MISSING");
            return null;
        }
    }

    /*
     * Exception decompiling
     */
    private static boolean isActivitiesValid(Activity var0, String[] var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl90 : ICONST_0 : trying to set 1 previously set to 0
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

    private static boolean isAdapterSdkValid(String string) {
        if (string == null) {
            return true;
        }
        try {
            Class.forName((String)string);
            Log.i((String)"IntegrationHelper", (String)"SDK - VERIFIED");
            return true;
        }
        catch (Exception exception) {
            Log.e((String)"IntegrationHelper", (String)"SDK - MISSING");
            return false;
        }
    }

    private static boolean isAdapterValid(Activity activity, String string) {
        boolean bl2;
        block17 : {
            block18 : {
                IntegrationData integrationData;
                block16 : {
                    block15 : {
                        block14 : {
                            block13 : {
                                block12 : {
                                    block11 : {
                                        try {
                                            if (string.equalsIgnoreCase("SupersonicAds")) {
                                                Log.i((String)"IntegrationHelper", (String)"--------------- IronSource  --------------");
                                            } else {
                                                StringBuilder stringBuilder = new StringBuilder();
                                                stringBuilder.append("--------------- ");
                                                stringBuilder.append(string);
                                                stringBuilder.append(" --------------");
                                                Log.i((String)"IntegrationHelper", (String)stringBuilder.toString());
                                            }
                                            StringBuilder stringBuilder = new StringBuilder();
                                            stringBuilder.append("com.ironsource.adapters.");
                                            stringBuilder.append(string.toLowerCase());
                                            stringBuilder.append(".");
                                            stringBuilder.append(string);
                                            stringBuilder.append("Adapter");
                                            integrationData = IntegrationHelper.getIntegrationData(activity, stringBuilder.toString());
                                            if (integrationData != null) break block11;
                                            return false;
                                        }
                                        catch (Exception exception) {
                                            StringBuilder stringBuilder = new StringBuilder();
                                            stringBuilder.append("isAdapterValid ");
                                            stringBuilder.append(string);
                                            Log.e((String)"IntegrationHelper", (String)stringBuilder.toString(), (Throwable)exception);
                                            return false;
                                        }
                                    }
                                    if (string.equalsIgnoreCase("SupersonicAds") || IntegrationHelper.isAdapterVersionValid(integrationData)) break block12;
                                    return false;
                                }
                                IntegrationHelper.verifyBannerAdapterVersion(integrationData);
                                bl2 = IntegrationHelper.isAdapterSdkValid(integrationData.sdkName);
                                if (IntegrationHelper.isActivitiesValid(activity, integrationData.activities)) break block13;
                                bl2 = false;
                            }
                            if (IntegrationHelper.isExternalLibsValid(integrationData.externalLibs)) break block14;
                            bl2 = false;
                        }
                        if (IntegrationHelper.isBroadcastReceiversValid(activity, integrationData.broadcastReceivers)) break block15;
                        bl2 = false;
                    }
                    if (IntegrationHelper.isServicesValid(activity, integrationData.services)) break block16;
                    bl2 = false;
                }
                if (!integrationData.validateWriteExternalStorage || Build.VERSION.SDK_INT > 18) break block17;
                if (activity.getPackageManager().checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", activity.getPackageName()) != 0) break block18;
                Log.i((String)"IntegrationHelper", (String)"android.permission.WRITE_EXTERNAL_STORAGE - VERIFIED");
                return bl2;
            }
            Log.e((String)"IntegrationHelper", (String)"android.permission.WRITE_EXTERNAL_STORAGE - MISSING");
            bl2 = false;
        }
        return bl2;
    }

    private static boolean isAdapterVersionValid(IntegrationData integrationData) {
        if (!integrationData.version.startsWith("4.1") && !integrationData.version.startsWith("4.2")) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(integrationData.name);
            stringBuilder.append(" adapter ");
            stringBuilder.append(integrationData.version);
            stringBuilder.append(" is incompatible with SDK version ");
            stringBuilder.append(IronSourceUtils.getSDKVersion());
            stringBuilder.append(", please update your adapter to version ");
            stringBuilder.append("4.1");
            stringBuilder.append(".*");
            Log.e((String)"IntegrationHelper", (String)stringBuilder.toString());
            return false;
        }
        Log.i((String)"IntegrationHelper", (String)"Adapter version - VERIFIED");
        return true;
    }

    /*
     * Exception decompiling
     */
    private static boolean isBroadcastReceiversValid(Activity var0, String[] var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl90 : ICONST_0 : trying to set 1 previously set to 0
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
    private static boolean isExternalLibsValid(ArrayList<Pair<String, String>> var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl14 : ALOAD_3 : trying to set 1 previously set to 0
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
    private static boolean isServicesValid(Activity var0, String[] var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl90 : ICONST_0 : trying to set 1 previously set to 0
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

    private static void validateGooglePlayServices(final Activity activity) {
        new Thread(){

            /*
             * Exception decompiling
             */
            public void run() {
                // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl60 : RETURN : trying to set 1 previously set to 0
                // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
                // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
                // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
                // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
                // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
                // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
                // org.benf.cfr.reader.entities.g.p(Method.java:396)
                // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
                // org.benf.cfr.reader.entities.d.c(ClassFile.java:773)
                // org.benf.cfr.reader.entities.d.e(ClassFile.java:870)
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
        }.start();
    }

    public static void validateIntegration(Activity activity) {
        Log.i((String)"IntegrationHelper", (String)"Verifying Integration:");
        IntegrationHelper.validatePermissions(activity);
        String[] arrstring = new String[15];
        arrstring[0] = "SupersonicAds";
        arrstring[1] = "AdColony";
        arrstring[2] = "AppLovin";
        arrstring[3] = "Chartboost";
        arrstring[4] = "HyprMX";
        arrstring[5] = "UnityAds";
        arrstring[6] = "Vungle";
        arrstring[7] = "InMobi";
        arrstring[8] = "Facebook";
        arrstring[9] = "Fyber";
        arrstring[10] = "MediaBrix";
        arrstring[11] = "Tapjoy";
        arrstring[12] = "AdMob";
        arrstring[13] = "MoPub";
        arrstring[14] = "Maio";
        for (String string : arrstring) {
            if (IntegrationHelper.isAdapterValid(activity, string)) {
                if (string.equalsIgnoreCase("SupersonicAds")) {
                    Log.i((String)"IntegrationHelper", (String)">>>> IronSource - VERIFIED");
                    continue;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(">>>> ");
                stringBuilder.append(string);
                stringBuilder.append(" - VERIFIED");
                Log.i((String)"IntegrationHelper", (String)stringBuilder.toString());
                continue;
            }
            if (string.equalsIgnoreCase("SupersonicAds")) {
                Log.e((String)"IntegrationHelper", (String)">>>> IronSource - NOT VERIFIED");
                continue;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(">>>> ");
            stringBuilder.append(string);
            stringBuilder.append(" - NOT VERIFIED");
            Log.e((String)"IntegrationHelper", (String)stringBuilder.toString());
        }
        IntegrationHelper.validateGooglePlayServices(activity);
    }

    private static void validatePermissions(Activity activity) {
        Log.i((String)"IntegrationHelper", (String)"*** Permissions ***");
        PackageManager packageManager = activity.getPackageManager();
        if (packageManager.checkPermission("android.permission.INTERNET", activity.getPackageName()) == 0) {
            Log.i((String)"IntegrationHelper", (String)"android.permission.INTERNET - VERIFIED");
        } else {
            Log.e((String)"IntegrationHelper", (String)"android.permission.INTERNET - MISSING");
        }
        if (packageManager.checkPermission("android.permission.ACCESS_NETWORK_STATE", activity.getPackageName()) == 0) {
            Log.i((String)"IntegrationHelper", (String)"android.permission.ACCESS_NETWORK_STATE - VERIFIED");
            return;
        }
        Log.e((String)"IntegrationHelper", (String)"android.permission.ACCESS_NETWORK_STATE - MISSING");
    }

    private static void verifyBannerAdapterVersion(IntegrationData integrationData) {
        if (!(integrationData.name.equalsIgnoreCase("AppLovin") || integrationData.name.equalsIgnoreCase("AdMob") || integrationData.name.equalsIgnoreCase("Facebook") || integrationData.name.equalsIgnoreCase("InMobi") || integrationData.name.equalsIgnoreCase("Fyber"))) {
            return;
        }
        if (!integrationData.version.startsWith("4.2")) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(integrationData.name);
            stringBuilder.append(" adapter ");
            stringBuilder.append(integrationData.version);
            stringBuilder.append(" is incompatible for showing banners with SDK version ");
            stringBuilder.append(IronSourceUtils.getSDKVersion());
            stringBuilder.append(", please update your adapter to version ");
            stringBuilder.append("4.2");
            stringBuilder.append(".*");
            Log.e((String)"IntegrationHelper", (String)stringBuilder.toString());
        }
    }

}

