/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.app.NotificationManager
 *  android.content.Context
 *  android.database.Cursor
 *  android.database.sqlite.SQLiteDatabase
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.service.notification.StatusBarNotification
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  java.util.TreeMap
 */
package com.onesignal;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import com.onesignal.OneSignal;
import com.onesignal.OneSignalDbHelper;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

class NotificationLimitManager {
    static final String MAX_NUMBER_OF_NOTIFICATIONS_STR = Integer.toString((int)49);

    static void clearOldestOverLimit(Context context, int n2) {
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                NotificationLimitManager.clearOldestOverLimitStandard(context, n2);
                return;
            }
            NotificationLimitManager.clearOldestOverLimitFallback(context, n2);
            return;
        }
        catch (Throwable throwable) {
            NotificationLimitManager.clearOldestOverLimitFallback(context, n2);
            return;
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
    static void clearOldestOverLimitFallback(Context context, int n2) {
        Cursor cursor;
        Throwable throwable2222;
        block7 : {
            block8 : {
                OneSignalDbHelper oneSignalDbHelper = OneSignalDbHelper.getInstance(context);
                cursor = null;
                SQLiteDatabase sQLiteDatabase = oneSignalDbHelper.getReadableDbWithRetries();
                String[] arrstring = new String[]{"android_notification_id"};
                String string2 = OneSignalDbHelper.recentUninteractedWithNotificationsWhere().toString();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(NotificationLimitManager.getMaxNumberOfNotificationsString());
                stringBuilder.append(n2);
                cursor = sQLiteDatabase.query("notification", arrstring, string2, null, null, null, "_id", stringBuilder.toString());
                int n3 = cursor.getCount();
                int n4 = NotificationLimitManager.getMaxNumberOfNotificationsInt();
                int n5 = n2 + (n3 - n4);
                if (n5 < 1) {
                    if (cursor == null) return;
                    if (cursor.isClosed()) return;
                    cursor.close();
                    return;
                }
                while (cursor.moveToNext()) {
                    OneSignal.cancelNotification(cursor.getInt(cursor.getColumnIndex("android_notification_id")));
                    if (--n5 > 0) continue;
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
                        OneSignal.Log(OneSignal.LOG_LEVEL.ERROR, "Error clearing oldest notifications over limit! ", throwable3);
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

    static void clearOldestOverLimitStandard(Context context, int n2) throws Throwable {
        StatusBarNotification[] arrstatusBarNotification = ((NotificationManager)context.getSystemService("notification")).getActiveNotifications();
        int n3 = n2 + (arrstatusBarNotification.length - NotificationLimitManager.getMaxNumberOfNotificationsInt());
        if (n3 < 1) {
            return;
        }
        TreeMap treeMap = new TreeMap();
        for (StatusBarNotification statusBarNotification : arrstatusBarNotification) {
            if (NotificationLimitManager.isGroupSummary(statusBarNotification)) continue;
            treeMap.put((Object)statusBarNotification.getNotification().when, (Object)statusBarNotification.getId());
        }
        Iterator iterator = treeMap.entrySet().iterator();
        while (iterator.hasNext()) {
            OneSignal.cancelNotification((Integer)((Map.Entry)iterator.next()).getValue());
            if (--n3 > 0) continue;
        }
    }

    private static int getMaxNumberOfNotificationsInt() {
        return 49;
    }

    private static String getMaxNumberOfNotificationsString() {
        return MAX_NUMBER_OF_NOTIFICATIONS_STR;
    }

    static boolean isGroupSummary(StatusBarNotification statusBarNotification) {
        return (512 & statusBarNotification.getNotification().flags) != 0;
    }
}

