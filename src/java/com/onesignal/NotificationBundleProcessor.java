/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.ContentValues
 *  android.content.Context
 *  android.content.Intent
 *  android.database.Cursor
 *  android.database.sqlite.SQLiteDatabase
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.SystemClock
 *  com.onesignal.NotificationExtenderService
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.Set
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.onesignal;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import com.onesignal.BadgeCountUpdater;
import com.onesignal.BundleCompat;
import com.onesignal.NotificationExtenderService;
import com.onesignal.NotificationGenerationJob;
import com.onesignal.OSNotificationPayload;
import com.onesignal.OSUtils;
import com.onesignal.OneSignal;
import com.onesignal.OneSignalDbHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class NotificationBundleProcessor {
    /*
     * Exception decompiling
     */
    static OSNotificationPayload OSNotificationPayloadFrom(JSONObject var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
        // org.benf.cfr.reader.b.a.a.j.b(Op04StructuredStatement.java:409)
        // org.benf.cfr.reader.b.a.a.j.d(Op04StructuredStatement.java:487)
        // org.benf.cfr.reader.b.a.a.i.a(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:692)
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
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static void ProcessFromGCMIntentService(Context context, BundleCompat bundleCompat, NotificationExtenderService.OverrideSettings overrideSettings) {
        OneSignal.setAppContext(context);
        try {
            String string2 = bundleCompat.getString("json_payload");
            if (string2 == null) {
                OneSignal.LOG_LEVEL lOG_LEVEL = OneSignal.LOG_LEVEL.ERROR;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("json_payload key is nonexistent from mBundle passed to ProcessFromGCMIntentService: ");
                stringBuilder.append((Object)bundleCompat);
                OneSignal.Log(lOG_LEVEL, stringBuilder.toString());
                return;
            }
            NotificationGenerationJob notificationGenerationJob = new NotificationGenerationJob(context);
            notificationGenerationJob.restoring = bundleCompat.getBoolean("restoring", false);
            notificationGenerationJob.shownTimeStamp = bundleCompat.getLong("timestamp");
            notificationGenerationJob.jsonPayload = new JSONObject(string2);
            if (!notificationGenerationJob.restoring && OneSignal.notValidOrDuplicated(context, notificationGenerationJob.jsonPayload)) {
                return;
            }
            if (bundleCompat.containsKey("android_notif_id")) {
                if (overrideSettings == null) {
                    overrideSettings = new NotificationExtenderService.OverrideSettings();
                }
                overrideSettings.androidNotificationId = bundleCompat.getInt("android_notif_id");
            }
            notificationGenerationJob.overrideSettings = overrideSettings;
            NotificationBundleProcessor.ProcessJobForDisplay(notificationGenerationJob);
            if (!notificationGenerationJob.restoring) return;
            OSUtils.sleep(100);
            return;
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
        }
    }

    /*
     * Exception decompiling
     */
    static int ProcessJobForDisplay(NotificationGenerationJob var0) {
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

    static JSONObject bundleAsJSONObject(Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        for (String string2 : bundle.keySet()) {
            try {
                jSONObject.put(string2, bundle.get(string2));
            }
            catch (JSONException jSONException) {
                OneSignal.LOG_LEVEL lOG_LEVEL = OneSignal.LOG_LEVEL.ERROR;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("bundleAsJSONObject error for key: ");
                stringBuilder.append(string2);
                OneSignal.Log(lOG_LEVEL, stringBuilder.toString(), jSONException);
            }
        }
        return jSONObject;
    }

    private static JSONArray bundleAsJsonArray(Bundle bundle) {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put((Object)NotificationBundleProcessor.bundleAsJSONObject(bundle));
        return jSONArray;
    }

    static void deleteOldNotifications(SQLiteDatabase sQLiteDatabase) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("created_time < ");
        stringBuilder.append(System.currentTimeMillis() / 1000L - 604800L);
        sQLiteDatabase.delete("notification", stringBuilder.toString(), null);
    }

    static boolean hasRemoteResource(Bundle bundle) {
        return NotificationBundleProcessor.isBuildKeyRemote(bundle, "licon") || NotificationBundleProcessor.isBuildKeyRemote(bundle, "bicon") || bundle.getString("bg_img", null) != null;
        {
        }
    }

    private static boolean isBuildKeyRemote(Bundle bundle, String string2) {
        String string3 = bundle.getString(string2, "").trim();
        return string3.startsWith("http://") || string3.startsWith("https://");
        {
        }
    }

    static JSONArray newJsonArray(JSONObject jSONObject) {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put((Object)jSONObject);
        return jSONArray;
    }

    static ProcessedBundleResult processBundleFromReceiver(Context context, final Bundle bundle) {
        ProcessedBundleResult processedBundleResult = new ProcessedBundleResult();
        if (OneSignal.getNotificationIdFromGCMBundle(bundle) == null) {
            return processedBundleResult;
        }
        processedBundleResult.isOneSignalPayload = true;
        NotificationBundleProcessor.unMinifyBundle(bundle);
        if (NotificationBundleProcessor.startExtenderService(context, bundle, processedBundleResult)) {
            return processedBundleResult;
        }
        processedBundleResult.isDup = OneSignal.notValidOrDuplicated(context, NotificationBundleProcessor.bundleAsJSONObject(bundle));
        if (processedBundleResult.isDup) {
            return processedBundleResult;
        }
        if (!NotificationBundleProcessor.shouldDisplay(bundle.getString("alert"))) {
            NotificationBundleProcessor.saveNotification(context, bundle, true, -1);
            new Thread(new Runnable(){

                public void run() {
                    OneSignal.handleNotificationReceived(NotificationBundleProcessor.bundleAsJsonArray(bundle), false, false);
                }
            }, "OS_PROC_BUNDLE").start();
        }
        return processedBundleResult;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private static void processCollapseKey(NotificationGenerationJob notificationGenerationJob) {
        Cursor cursor;
        Throwable throwable2222;
        block7 : {
            block8 : {
                if (notificationGenerationJob.restoring) {
                    return;
                }
                if (!notificationGenerationJob.jsonPayload.has("collapse_key")) return;
                if ("do_not_collapse".equals((Object)notificationGenerationJob.jsonPayload.optString("collapse_key"))) {
                    return;
                }
                String string2 = notificationGenerationJob.jsonPayload.optString("collapse_key");
                OneSignalDbHelper oneSignalDbHelper = OneSignalDbHelper.getInstance(notificationGenerationJob.context);
                cursor = null;
                cursor = oneSignalDbHelper.getReadableDbWithRetries().query("notification", new String[]{"android_notification_id"}, "collapse_id = ? AND dismissed = 0 AND opened = 0 ", new String[]{string2}, null, null, null);
                if (cursor.moveToFirst()) {
                    notificationGenerationJob.setAndroidIdWithOutOverriding(cursor.getInt(cursor.getColumnIndex("android_notification_id")));
                }
                if (cursor == null) return;
                if (cursor.isClosed()) return;
                break block8;
                {
                    catch (Throwable throwable2222) {
                        break block7;
                    }
                    catch (Throwable throwable3) {}
                    {
                        OneSignal.Log(OneSignal.LOG_LEVEL.ERROR, "Could not read DB to find existing collapse_key!", throwable3);
                        if (cursor == null) return;
                    }
                    if (cursor.isClosed()) return;
                }
            }
            cursor.close();
            return;
        }
        if (cursor == null) throw throwable2222;
        if (cursor.isClosed()) throw throwable2222;
        cursor.close();
        throw throwable2222;
    }

    private static void saveNotification(Context context, Bundle bundle, boolean bl2, int n2) {
        NotificationGenerationJob notificationGenerationJob = new NotificationGenerationJob(context);
        notificationGenerationJob.jsonPayload = NotificationBundleProcessor.bundleAsJSONObject(bundle);
        notificationGenerationJob.overrideSettings = new NotificationExtenderService.OverrideSettings();
        notificationGenerationJob.overrideSettings.androidNotificationId = n2;
        NotificationBundleProcessor.saveNotification(notificationGenerationJob, bl2);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    static void saveNotification(NotificationGenerationJob var0, boolean var1_1) {
        block25 : {
            var2_2 = var0.context;
            var3_3 = var0.jsonPayload;
            var4_4 = new JSONObject(var0.jsonPayload.optString("custom"));
            var6_5 = OneSignalDbHelper.getInstance(var0.context);
            var7_6 = null;
            var12_7 = var6_5.getWritableDbWithRetries();
            try {
                var12_7.beginTransaction();
                NotificationBundleProcessor.deleteOldNotifications(var12_7);
                var14_8 = var0.getAndroidIdWithoutCreate();
                var15_9 = 1;
                if (var14_8 != -1) {
                    var19_10 = new StringBuilder();
                    var19_10.append("android_notification_id = ");
                    var19_10.append(var0.getAndroidIdWithoutCreate());
                    var22_11 = var19_10.toString();
                    var23_12 = new ContentValues();
                    var23_12.put("dismissed", Integer.valueOf((int)var15_9));
                    var12_7.update("notification", var23_12, var22_11, null);
                    BadgeCountUpdater.update(var12_7, var2_2);
                }
                var16_13 = new ContentValues();
                var16_13.put("notification_id", var4_4.optString("i"));
                if (var3_3.has("grp")) {
                    var16_13.put("group_id", var3_3.optString("grp"));
                }
                if (!var3_3.has("collapse_key") || "do_not_collapse".equals((Object)var3_3.optString("collapse_key"))) break block25;
                var16_13.put("collapse_id", var3_3.optString("collapse_key"));
            }
            catch (Throwable var11_18) {
                ** GOTO lbl75
            }
            catch (Exception var8_21) {
                var7_6 = var12_7;
                ** GOTO lbl-1000
            }
        }
        if (!var1_1) {
            var15_9 = 0;
        }
        var16_13.put("opened", Integer.valueOf((int)var15_9));
        if (!var1_1) {
            var16_13.put("android_notification_id", Integer.valueOf((int)var0.getAndroidIdWithoutCreate()));
        }
        if (var0.getTitle() != null) {
            var16_13.put("title", var0.getTitle().toString());
        }
        if (var0.getBody() != null) {
            var16_13.put("message", var0.getBody().toString());
        }
        var16_13.put("expire_time", Long.valueOf((long)(var3_3.optLong("google.sent_time", SystemClock.currentThreadTimeMillis()) / 1000L + (long)var3_3.optInt("google.ttl", 259200))));
        var16_13.put("full_data", var3_3.toString());
        var12_7.insertOrThrow("notification", null, var16_13);
        if (!var1_1) {
            BadgeCountUpdater.update(var12_7, var2_2);
        }
        var12_7.setTransactionSuccessful();
        if (var12_7 == null) return;
        try {
            var12_7.endTransaction();
            return;
        }
        catch (Throwable var9_14) {
            var10_17 = OneSignal.LOG_LEVEL.ERROR;
lbl58: // 2 sources:
            do {
                OneSignal.Log(var10_17, "Error closing transaction! ", (Throwable)var9_15);
                return;
                break;
            } while (true);
        }
        catch (Throwable var11_19) {
            var12_7 = var7_6;
            ** GOTO lbl75
        }
        catch (Exception var8_22) {
            // empty catch block
        }
lbl-1000: // 2 sources:
        {
            OneSignal.Log(OneSignal.LOG_LEVEL.ERROR, "Error saving notification record! ", (Throwable)var8_23);
            if (var7_6 == null) return;
        }
        try {
            try {
                var7_6.endTransaction();
                return;
            }
            catch (Throwable var9_16) {
                var10_17 = OneSignal.LOG_LEVEL.ERROR;
                ** continue;
            }
lbl75: // 2 sources:
            if (var12_7 == null) throw var11_20;
            try {
                var12_7.endTransaction();
                throw var11_20;
            }
            catch (Throwable var13_24) {
                OneSignal.Log(OneSignal.LOG_LEVEL.ERROR, "Error closing transaction! ", var13_24);
            }
            throw var11_20;
        }
        catch (JSONException var5_25) {
            var5_25.printStackTrace();
        }
    }

    private static void setActionButtons(OSNotificationPayload oSNotificationPayload) throws Throwable {
        if (oSNotificationPayload.additionalData != null && oSNotificationPayload.additionalData.has("actionButtons")) {
            JSONArray jSONArray = oSNotificationPayload.additionalData.getJSONArray("actionButtons");
            oSNotificationPayload.actionButtons = new ArrayList();
            for (int i2 = 0; i2 < jSONArray.length(); ++i2) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                OSNotificationPayload.ActionButton actionButton = new OSNotificationPayload.ActionButton();
                actionButton.id = jSONObject.optString("id", null);
                actionButton.text = jSONObject.optString("text", null);
                actionButton.icon = jSONObject.optString("icon", null);
                oSNotificationPayload.actionButtons.add((Object)actionButton);
            }
            oSNotificationPayload.additionalData.remove("actionSelected");
            oSNotificationPayload.additionalData.remove("actionButtons");
        }
    }

    private static void setBackgroundImageLayout(OSNotificationPayload oSNotificationPayload, JSONObject jSONObject) throws Throwable {
        String string2 = jSONObject.optString("bg_img", null);
        if (string2 != null) {
            JSONObject jSONObject2 = new JSONObject(string2);
            oSNotificationPayload.backgroundImageLayout = new OSNotificationPayload.BackgroundImageLayout();
            oSNotificationPayload.backgroundImageLayout.image = jSONObject2.optString("img");
            oSNotificationPayload.backgroundImageLayout.titleTextColor = jSONObject2.optString("tc");
            oSNotificationPayload.backgroundImageLayout.bodyTextColor = jSONObject2.optString("bc");
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    static boolean shouldDisplay(String string2) {
        boolean bl2 = true;
        boolean bl3 = string2 != null && !"".equals((Object)string2);
        boolean bl4 = OneSignal.getInAppAlertNotificationEnabled();
        boolean bl5 = OneSignal.isAppActive();
        if (!bl3) return false;
        if (OneSignal.getNotificationsWhenActiveEnabled()) return bl2;
        if (bl4) return bl2;
        if (bl5) return false;
        return bl2;
    }

    private static boolean startExtenderService(Context context, Bundle bundle, ProcessedBundleResult processedBundleResult) {
        Intent intent = NotificationExtenderService.getIntent((Context)context);
        if (intent == null) {
            return false;
        }
        intent.putExtra("json_payload", NotificationBundleProcessor.bundleAsJSONObject(bundle).toString());
        intent.putExtra("timestamp", System.currentTimeMillis() / 1000L);
        int n2 = Integer.parseInt((String)bundle.getString("pri", "0"));
        boolean bl2 = false;
        if (n2 > 9) {
            bl2 = true;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            NotificationExtenderService.enqueueWork((Context)context, (ComponentName)intent.getComponent(), (int)2071862121, (Intent)intent, (boolean)bl2);
        } else {
            context.startService(intent);
        }
        processedBundleResult.hasExtenderService = true;
        return true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void unMinifyBundle(Bundle bundle) {
        JSONObject jSONObject;
        int n2;
        JSONArray jSONArray;
        JSONObject jSONObject2;
        if (!bundle.containsKey("o")) {
            return;
        }
        try {
            jSONObject2 = new JSONObject(bundle.getString("custom"));
            jSONObject = jSONObject2.has("a") ? jSONObject2.getJSONObject("a") : new JSONObject();
            jSONArray = new JSONArray(bundle.getString("o"));
            bundle.remove("o");
            n2 = 0;
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
            return;
        }
        do {
            if (n2 < jSONArray.length()) {
                String string2;
                JSONObject jSONObject3 = jSONArray.getJSONObject(n2);
                String string3 = jSONObject3.getString("n");
                jSONObject3.remove("n");
                if (jSONObject3.has("i")) {
                    string2 = jSONObject3.getString("i");
                    jSONObject3.remove("i");
                } else {
                    string2 = string3;
                }
                jSONObject3.put("id", (Object)string2);
                jSONObject3.put("text", (Object)string3);
                if (jSONObject3.has("p")) {
                    jSONObject3.put("icon", (Object)jSONObject3.getString("p"));
                    jSONObject3.remove("p");
                }
            } else {
                jSONObject.put("actionButtons", (Object)jSONArray);
                jSONObject.put("actionSelected", (Object)"__DEFAULT__");
                if (!jSONObject2.has("a")) {
                    jSONObject2.put("a", (Object)jSONObject);
                }
                bundle.putString("custom", jSONObject2.toString());
                return;
            }
            ++n2;
        } while (true);
    }

    static class ProcessedBundleResult {
        boolean hasExtenderService;
        boolean isDup;
        boolean isOneSignalPayload;

        ProcessedBundleResult() {
        }

        boolean processed() {
            return !this.isOneSignalPayload || this.hasExtenderService || this.isDup;
            {
            }
        }
    }

}

