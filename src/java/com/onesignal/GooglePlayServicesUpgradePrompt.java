/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.AlertDialog
 *  android.app.AlertDialog$Builder
 *  android.app.PendingIntent
 *  android.app.PendingIntent$CanceledException
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  com.google.android.gms.common.GoogleApiAvailability
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.onesignal;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.google.android.gms.common.GoogleApiAvailability;
import com.onesignal.ActivityLifecycleHandler;
import com.onesignal.OSUtils;
import com.onesignal.OneSignal;
import com.onesignal.OneSignalPrefs;

class GooglePlayServicesUpgradePrompt {
    private static void OpenPlayStoreToApp(Activity activity) {
        try {
            GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
            googleApiAvailability.getErrorResolutionPendingIntent((Context)activity, googleApiAvailability.isGooglePlayServicesAvailable(OneSignal.appContext), 9000).send();
            return;
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        catch (PendingIntent.CanceledException canceledException) {}
    }

    static void ShowUpdateGPSDialog() {
        if (!GooglePlayServicesUpgradePrompt.isGMSInstalledAndEnabled()) {
            if (!GooglePlayServicesUpgradePrompt.isGooglePlayStoreInstalled()) {
                return;
            }
            if (OneSignalPrefs.getBool(OneSignalPrefs.PREFS_ONESIGNAL, "GT_DO_NOT_SHOW_MISSING_GPS", false)) {
                return;
            }
            OSUtils.runOnMainUIThread(new Runnable(){

                public void run() {
                    final Activity activity = ActivityLifecycleHandler.curActivity;
                    if (activity != null) {
                        if (OneSignal.mInitBuilder.mDisableGmsMissingPrompt) {
                            return;
                        }
                        String string2 = OSUtils.getResourceString((Context)activity, "onesignal_gms_missing_alert_text", "To receive push notifications please press 'Update' to enable 'Google Play services'.");
                        String string3 = OSUtils.getResourceString((Context)activity, "onesignal_gms_missing_alert_button_update", "Update");
                        String string4 = OSUtils.getResourceString((Context)activity, "onesignal_gms_missing_alert_button_skip", "Skip");
                        String string5 = OSUtils.getResourceString((Context)activity, "onesignal_gms_missing_alert_button_close", "Close");
                        new AlertDialog.Builder((Context)activity).setMessage((CharSequence)string2).setPositiveButton((CharSequence)string3, new DialogInterface.OnClickListener(){

                            public void onClick(DialogInterface dialogInterface, int n2) {
                                GooglePlayServicesUpgradePrompt.OpenPlayStoreToApp(activity);
                            }
                        }).setNegativeButton((CharSequence)string4, new DialogInterface.OnClickListener(){

                            public void onClick(DialogInterface dialogInterface, int n2) {
                                OneSignalPrefs.saveBool(OneSignalPrefs.PREFS_ONESIGNAL, "GT_DO_NOT_SHOW_MISSING_GPS", true);
                            }
                        }).setNeutralButton((CharSequence)string5, null).create().show();
                    }
                }

            });
        }
    }

    static boolean isGMSInstalledAndEnabled() {
        try {
            boolean bl2 = OneSignal.appContext.getPackageManager().getPackageInfo((String)"com.google.android.gms", (int)128).applicationInfo.enabled;
            return bl2;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            return false;
        }
    }

    /*
     * Exception decompiling
     */
    private static boolean isGooglePlayStoreInstalled() {
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

}

