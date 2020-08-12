/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.AlarmManager
 *  android.app.NotificationManager
 *  android.app.PendingIntent
 *  android.app.job.JobInfo
 *  android.app.job.JobInfo$Builder
 *  android.app.job.JobScheduler
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.database.Cursor
 *  android.database.sqlite.SQLiteDatabase
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.service.notification.StatusBarNotification
 *  android.text.TextUtils
 *  com.onesignal.NotificationExtenderService
 *  com.onesignal.RestoreJobService
 *  com.onesignal.RestoreKickoffJobService
 *  java.io.Serializable
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Iterable
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.util.ArrayList
 */
package com.onesignal;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.onesignal.BadgeCountUpdater;
import com.onesignal.NotificationBundleProcessor;
import com.onesignal.NotificationExtenderService;
import com.onesignal.NotificationLimitManager;
import com.onesignal.NotificationRestoreService;
import com.onesignal.OSUtils;
import com.onesignal.OneSignal;
import com.onesignal.OneSignalDbHelper;
import com.onesignal.RestoreJobService;
import com.onesignal.RestoreKickoffJobService;
import java.io.Serializable;
import java.util.ArrayList;

class NotificationRestorer {
    static final String[] COLUMNS_FOR_RESTORE = new String[]{"android_notification_id", "full_data", "created_time"};
    public static boolean restored;

    private static Intent addRestoreExtras(Intent intent, Cursor cursor) {
        int n2 = cursor.getInt(cursor.getColumnIndex("android_notification_id"));
        String string2 = cursor.getString(cursor.getColumnIndex("full_data"));
        Long l2 = cursor.getLong(cursor.getColumnIndex("created_time"));
        intent.putExtra("json_payload", string2).putExtra("android_notif_id", n2).putExtra("restoring", true).putExtra("timestamp", (Serializable)l2);
        return intent;
    }

    static void asyncRestore(final Context context) {
        new Thread(new Runnable(){

            public void run() {
                Thread.currentThread().setPriority(10);
                NotificationRestorer.restore(context);
            }
        }, "OS_RESTORE_NOTIFS").start();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private static void deleteOldNotificationsFromDb(OneSignalDbHelper oneSignalDbHelper) {
        Throwable throwable3222;
        SQLiteDatabase sQLiteDatabase = null;
        sQLiteDatabase = oneSignalDbHelper.getWritableDbWithRetries();
        sQLiteDatabase.beginTransaction();
        NotificationBundleProcessor.deleteOldNotifications(sQLiteDatabase);
        sQLiteDatabase.setTransactionSuccessful();
        if (sQLiteDatabase == null) return;
        sQLiteDatabase.endTransaction();
        return;
        {
            catch (Throwable throwable2) {
                OneSignal.Log(OneSignal.LOG_LEVEL.ERROR, "Error closing transaction! ", throwable2);
                return;
            }
            catch (Throwable throwable3222) {
            }
            catch (Throwable throwable4) {}
            {
                OneSignal.Log(OneSignal.LOG_LEVEL.ERROR, "Error deleting old notification records! ", throwable4);
                if (sQLiteDatabase == null) return;
            }
            {
                sQLiteDatabase.endTransaction();
                return;
            }
        }
        if (sQLiteDatabase == null) throw throwable3222;
        try {
            sQLiteDatabase.endTransaction();
            throw throwable3222;
        }
        catch (Throwable throwable5) {
            OneSignal.Log(OneSignal.LOG_LEVEL.ERROR, "Error closing transaction! ", throwable5);
        }
        throw throwable3222;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private static void queryAndRestoreNotificationsAndBadgeCount(Context context, OneSignalDbHelper oneSignalDbHelper, StringBuilder stringBuilder) {
        Cursor cursor;
        Throwable throwable2222;
        block4 : {
            block5 : {
                OneSignal.LOG_LEVEL lOG_LEVEL = OneSignal.LOG_LEVEL.INFO;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Querying DB for notifs to restore: ");
                stringBuilder2.append(stringBuilder.toString());
                OneSignal.Log(lOG_LEVEL, stringBuilder2.toString());
                cursor = null;
                SQLiteDatabase sQLiteDatabase = oneSignalDbHelper.getReadableDbWithRetries();
                cursor = sQLiteDatabase.query("notification", COLUMNS_FOR_RESTORE, stringBuilder.toString(), null, null, null, "_id DESC", NotificationLimitManager.MAX_NUMBER_OF_NOTIFICATIONS_STR);
                NotificationRestorer.showNotificationsFromCursor(context, cursor, 200);
                BadgeCountUpdater.update(sQLiteDatabase, context);
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

    public static void restore(Context context) {
        if (!OSUtils.areNotificationsEnabled(context)) {
            return;
        }
        if (restored) {
            return;
        }
        restored = true;
        OneSignal.Log(OneSignal.LOG_LEVEL.INFO, "Restoring notifications");
        OneSignalDbHelper oneSignalDbHelper = OneSignalDbHelper.getInstance(context);
        NotificationRestorer.deleteOldNotificationsFromDb(oneSignalDbHelper);
        StringBuilder stringBuilder = OneSignalDbHelper.recentUninteractedWithNotificationsWhere();
        NotificationRestorer.skipVisibleNotifications(context, stringBuilder);
        NotificationRestorer.queryAndRestoreNotificationsAndBadgeCount(context, oneSignalDbHelper, stringBuilder);
    }

    static void showNotificationsFromCursor(Context context, Cursor cursor, int n2) {
        if (!cursor.moveToFirst()) {
            return;
        }
        boolean bl2 = NotificationExtenderService.getIntent((Context)context) != null;
        do {
            if (bl2) {
                Intent intent = NotificationExtenderService.getIntent((Context)context);
                NotificationRestorer.addRestoreExtras(intent, cursor);
                NotificationExtenderService.enqueueWork((Context)context, (ComponentName)intent.getComponent(), (int)2071862121, (Intent)intent, (boolean)false);
            } else {
                Intent intent = NotificationRestorer.addRestoreExtras(new Intent(), cursor);
                RestoreJobService.enqueueWork((Context)context, (ComponentName)new ComponentName(context, RestoreJobService.class), (int)2071862122, (Intent)intent, (boolean)false);
            }
            if (n2 <= 0) continue;
            OSUtils.sleep(n2);
        } while (cursor.moveToNext());
    }

    private static void skipVisibleNotifications(Context context, StringBuilder stringBuilder) {
        if (Build.VERSION.SDK_INT < 23) {
            return;
        }
        NotificationManager notificationManager = (NotificationManager)context.getSystemService("notification");
        StatusBarNotification[] arrstatusBarNotification = notificationManager.getActiveNotifications();
        if (arrstatusBarNotification.length == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int n2 = arrstatusBarNotification.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            arrayList.add((Object)arrstatusBarNotification[i2].getId());
        }
        try {
            stringBuilder.append(" AND android_notification_id NOT IN (");
            stringBuilder.append(TextUtils.join((CharSequence)",", (Iterable)arrayList));
            stringBuilder.append(")");
        }
        catch (Throwable throwable) {}
    }

    static void startDelayedRestoreTaskFromReceiver(Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            OneSignal.Log(OneSignal.LOG_LEVEL.INFO, "scheduleRestoreKickoffJob");
            JobInfo jobInfo = new JobInfo.Builder(2071862120, new ComponentName(context, RestoreKickoffJobService.class)).setOverrideDeadline(15000L).setMinimumLatency(15000L).build();
            ((JobScheduler)context.getSystemService("jobscheduler")).schedule(jobInfo);
            return;
        }
        OneSignal.Log(OneSignal.LOG_LEVEL.INFO, "scheduleRestoreKickoffAlarmTask");
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context.getPackageName(), NotificationRestoreService.class.getName()));
        PendingIntent pendingIntent = PendingIntent.getService((Context)context, (int)2071862120, (Intent)intent, (int)268435456);
        long l2 = 15000L + System.currentTimeMillis();
        ((AlarmManager)context.getSystemService("alarm")).set(1, l2, pendingIntent);
    }

}

