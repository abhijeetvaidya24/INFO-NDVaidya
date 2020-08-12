/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 *  android.content.Context
 *  android.content.Intent
 *  android.database.sqlite.SQLiteDatabase
 *  androidx.core.app.NotificationManagerCompat
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.onesignal;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import androidx.core.app.NotificationManagerCompat;
import com.onesignal.BadgeCountUpdater;
import com.onesignal.NotificationBundleProcessor;
import com.onesignal.NotificationSummaryManager;
import com.onesignal.OneSignal;
import com.onesignal.OneSignalDbHelper;
import org.json.JSONArray;
import org.json.JSONObject;

class NotificationOpenedProcessor {
    /*
     * Exception decompiling
     */
    private static void addChildNotifications(JSONArray var0, String var1, SQLiteDatabase var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl58 : ALOAD_3 : trying to set 1 previously set to 0
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

    private static void handleDismissFromActionButtonPress(Context context, Intent intent) {
        if (intent.getBooleanExtra("action_button", false)) {
            NotificationManagerCompat.from((Context)context).cancel(intent.getIntExtra("notificationId", 0));
            context.sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        }
    }

    private static boolean isOneSignalIntent(Intent intent) {
        return intent.hasExtra("onesignal_data") || intent.hasExtra("summary") || intent.hasExtra("notificationId");
        {
        }
    }

    private static void markNotificationsConsumed(Context context, Intent intent, SQLiteDatabase sQLiteDatabase) {
        String[] arrstring;
        String string2;
        String string3 = intent.getStringExtra("summary");
        if (string3 != null) {
            arrstring = new String[]{string3};
            string2 = "group_id = ?";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("android_notification_id = ");
            stringBuilder.append(intent.getIntExtra("notificationId", 0));
            string2 = stringBuilder.toString();
            arrstring = null;
        }
        sQLiteDatabase.update("notification", NotificationOpenedProcessor.newContentValuesWithConsumed(intent), string2, arrstring);
        BadgeCountUpdater.update(sQLiteDatabase, context);
    }

    private static ContentValues newContentValuesWithConsumed(Intent intent) {
        ContentValues contentValues = new ContentValues();
        boolean bl2 = intent.getBooleanExtra("dismissed", false);
        Integer n2 = 1;
        if (bl2) {
            contentValues.put("dismissed", n2);
            return contentValues;
        }
        contentValues.put("opened", n2);
        return contentValues;
    }

    static void processFromContext(Context context, Intent intent) {
        if (!NotificationOpenedProcessor.isOneSignalIntent(intent)) {
            return;
        }
        OneSignal.setAppContext(context);
        NotificationOpenedProcessor.handleDismissFromActionButtonPress(context, intent);
        NotificationOpenedProcessor.processIntent(context, intent);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    static void processIntent(Context var0, Intent var1_1) {
        block17 : {
            block16 : {
                var2_2 = var1_1.getStringExtra("summary");
                var3_3 = var1_1.getBooleanExtra("dismissed", false);
                var4_4 = null;
                if (!var3_3) {
                    try {
                        var12_5 = new JSONObject(var1_1.getStringExtra("onesignal_data"));
                        var12_5.put("notificationId", var1_1.getIntExtra("notificationId", 0));
                        var1_1.putExtra("onesignal_data", var12_5.toString());
                        var5_6 = NotificationBundleProcessor.newJsonArray(new JSONObject(var1_1.getStringExtra("onesignal_data")));
                        break block16;
                    }
                    catch (Throwable var13_7) {
                        var13_7.printStackTrace();
                    }
                }
                var5_6 = null;
            }
            var6_8 = OneSignalDbHelper.getInstance(var0);
            var4_4 = var6_8.getWritableDbWithRetries();
            var4_4.beginTransaction();
            if (!var3_3 && var2_2 != null) {
                NotificationOpenedProcessor.addChildNotifications(var5_6, var2_2, var4_4);
            }
            NotificationOpenedProcessor.markNotificationsConsumed(var0, var1_1, var4_4);
            if (var2_2 == null && (var11_9 = var1_1.getStringExtra("grp")) != null) {
                NotificationSummaryManager.updateSummaryNotificationAfterChildRemoved(var0, var4_4, var11_9, var3_3);
            }
            var4_4.setTransactionSuccessful();
            ** if (var4_4 == null) goto lbl-1000
lbl-1000: // 1 sources:
            {
                var4_4.endTransaction();
            }
lbl-1000: // 2 sources:
            {
            }
            {
                catch (Throwable var9_10) {
                    break block17;
                }
                catch (Exception var7_11) {}
                {
                    OneSignal.Log(OneSignal.LOG_LEVEL.ERROR, "Error processing notification open or dismiss record! ", var7_11);
                    ** if (var4_4 == null) goto lbl-1000
                }
lbl-1000: // 1 sources:
                {
                    var4_4.endTransaction();
                }
lbl-1000: // 2 sources:
                {
                }
                catch (Throwable var8_12) {
                    OneSignal.Log(OneSignal.LOG_LEVEL.ERROR, "Error closing transaction! ", var8_12);
                }
            }
            if (var3_3 != false) return;
            OneSignal.handleNotificationOpen(var0, var5_6, var1_1.getBooleanExtra("from_alert", false));
            return;
        }
        if (var4_4 == null) throw var9_10;
        try {
            var4_4.endTransaction();
            throw var9_10;
        }
        catch (Throwable var10_13) {
            OneSignal.Log(OneSignal.LOG_LEVEL.ERROR, "Error closing transaction! ", var10_13);
        }
        throw var9_10;
    }
}

