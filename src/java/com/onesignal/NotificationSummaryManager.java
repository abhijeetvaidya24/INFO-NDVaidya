/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.NotificationManager
 *  android.content.ContentValues
 *  android.content.Context
 *  android.database.Cursor
 *  android.database.sqlite.SQLiteDatabase
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.onesignal;

import android.app.NotificationManager;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.onesignal.GenerateNotification;
import com.onesignal.NotificationGenerationJob;
import com.onesignal.NotificationRestorer;
import com.onesignal.OneSignal;
import com.onesignal.OneSignalDbHelper;
import org.json.JSONException;
import org.json.JSONObject;

class NotificationSummaryManager {
    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private static Integer getSummaryNotificationId(SQLiteDatabase var0, String var1_1) {
        block9 : {
            block8 : {
                var2_2 = null;
                var10_3 = var0.query("notification", new String[]{"android_notification_id"}, "group_id = ? AND dismissed = 0 AND opened = 0 AND is_summary = 1", new String[]{var1_1}, null, null, null);
                var12_4 = var10_3.moveToFirst();
                var2_2 = null;
                if (var12_4) break block8;
                var10_3.close();
                if (var10_3 == null) return null;
                if (var10_3.isClosed() != false) return null;
                var10_3.close();
                return null;
            }
            try {
                var2_2 = Integer.valueOf((int)var10_3.getInt(var10_3.getColumnIndex("android_notification_id")));
                var10_3.close();
                if (var10_3 == null) return var2_2;
            }
            catch (Throwable var9_5) {
                var2_2 = var10_3;
                break block9;
            }
            catch (Throwable var3_8) {
                var11_11 = var2_2;
                var2_2 = var10_3;
                var4_12 = var11_11;
                ** GOTO lbl-1000
            }
            if (var10_3.isClosed() != false) return var2_2;
            var10_3.close();
            return var2_2;
            catch (Throwable var9_6) {
                break block9;
            }
            catch (Throwable var3_9) {
                var4_12 = null;
            }
lbl-1000: // 2 sources:
            {
                var5_13 = OneSignal.LOG_LEVEL.ERROR;
                var6_14 = new StringBuilder();
                var6_14.append("Error getting android notification id for summary notification group: ");
                var6_14.append(var1_1);
                OneSignal.Log(var5_13, var6_14.toString(), (Throwable)var3_10);
                if (var2_2 == null) return var4_12;
            }
            if (var2_2.isClosed() != false) return var4_12;
            var2_2.close();
            return var4_12;
        }
        if (var2_2 == null) throw var9_7;
        if (var2_2.isClosed() != false) throw var9_7;
        var2_2.close();
        throw var9_7;
    }

    private static Cursor internalUpdateSummaryNotificationAfterChildRemoved(Context context, SQLiteDatabase sQLiteDatabase, String string2, boolean bl2) {
        Cursor cursor;
        Long l2;
        block7 : {
            cursor = sQLiteDatabase.query("notification", new String[]{"android_notification_id", "created_time"}, "group_id = ? AND dismissed = 0 AND opened = 0 AND is_summary = 0", new String[]{string2}, null, null, "_id DESC");
            int n2 = cursor.getCount();
            if (n2 == 0) {
                cursor.close();
                Integer n3 = NotificationSummaryManager.getSummaryNotificationId(sQLiteDatabase, string2);
                if (n3 == null) {
                    return cursor;
                }
                ((NotificationManager)context.getSystemService("notification")).cancel(n3.intValue());
                ContentValues contentValues = new ContentValues();
                String string3 = bl2 ? "dismissed" : "opened";
                contentValues.put(string3, Integer.valueOf((int)1));
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("android_notification_id = ");
                stringBuilder.append((Object)n3);
                sQLiteDatabase.update("notification", contentValues, stringBuilder.toString(), null);
                return cursor;
            }
            if (n2 == 1) {
                cursor.close();
                if (NotificationSummaryManager.getSummaryNotificationId(sQLiteDatabase, string2) == null) {
                    return cursor;
                }
                NotificationSummaryManager.restoreSummary(context, string2);
                return cursor;
            }
            try {
                cursor.moveToFirst();
                l2 = cursor.getLong(cursor.getColumnIndex("created_time"));
                cursor.close();
                if (NotificationSummaryManager.getSummaryNotificationId(sQLiteDatabase, string2) != null) break block7;
                return cursor;
            }
            catch (JSONException jSONException) {}
        }
        NotificationGenerationJob notificationGenerationJob = new NotificationGenerationJob(context);
        notificationGenerationJob.restoring = true;
        notificationGenerationJob.shownTimeStamp = l2;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("grp", (Object)string2);
        notificationGenerationJob.jsonPayload = jSONObject;
        GenerateNotification.updateSummaryNotification(notificationGenerationJob);
        return cursor;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private static void restoreSummary(Context context, String string2) {
        Cursor cursor;
        Throwable throwable2222;
        block4 : {
            block5 : {
                OneSignalDbHelper oneSignalDbHelper = OneSignalDbHelper.getInstance(context);
                String[] arrstring = new String[]{string2};
                cursor = null;
                cursor = oneSignalDbHelper.getReadableDbWithRetries().query("notification", NotificationRestorer.COLUMNS_FOR_RESTORE, "group_id = ? AND dismissed = 0 AND opened = 0 AND is_summary = 0", arrstring, null, null, null);
                NotificationRestorer.showNotificationsFromCursor(context, cursor, 0);
                if (cursor == null) return;
                if (cursor.isClosed()) return;
                break block5;
                {
                    catch (Throwable throwable2222) {
                        break block4;
                    }
                    catch (Throwable throwable3) {}
                    {
                        OneSignal.Log(OneSignal.LOG_LEVEL.ERROR, "Error restoring notification records! ", throwable3);
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

    static void updatePossibleDependentSummaryOnDismiss(Context context, SQLiteDatabase sQLiteDatabase, int n2) {
        String[] arrstring = new String[]{"group_id"};
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("android_notification_id = ");
        stringBuilder.append(n2);
        Cursor cursor = sQLiteDatabase.query("notification", arrstring, stringBuilder.toString(), null, null, null, null);
        if (cursor.moveToFirst()) {
            String string2 = cursor.getString(cursor.getColumnIndex("group_id"));
            cursor.close();
            if (string2 != null) {
                NotificationSummaryManager.updateSummaryNotificationAfterChildRemoved(context, sQLiteDatabase, string2, true);
                return;
            }
        } else {
            cursor.close();
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    static void updateSummaryNotificationAfterChildRemoved(Context context, SQLiteDatabase sQLiteDatabase, String string2, boolean bl2) {
        Cursor cursor = NotificationSummaryManager.internalUpdateSummaryNotificationAfterChildRemoved(context, sQLiteDatabase, string2, bl2);
        if (cursor == null) return;
        if (cursor.isClosed()) return;
        cursor.close();
        return;
        {
            catch (Throwable throwable) {
                throw throwable;
            }
            catch (Throwable throwable) {}
            {
                OneSignal.Log(OneSignal.LOG_LEVEL.ERROR, "Error running updateSummaryNotificationAfterChildRemoved!", throwable);
                return;
            }
        }
    }
}

