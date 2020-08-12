/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.NotificationManager
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageManager
 *  android.database.Cursor
 *  android.database.sqlite.SQLiteDatabase
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.service.notification.StatusBarNotification
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.onesignal;

import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import com.onesignal.NotificationLimitManager;
import com.onesignal.OSUtils;
import com.onesignal.OneSignal;
import com.onesignal.OneSignalDbHelper;
import com.onesignal.shortcutbadger.ShortcutBadger;

class BadgeCountUpdater {
    private static int badgesEnabled = -1;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static boolean areBadgeSettingsEnabled(Context context) {
        int n2 = badgesEnabled;
        if (n2 != -1) {
            boolean bl2 = false;
            if (n2 != 1) return bl2;
            return true;
        }
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo((String)context.getPackageName(), (int)128).metaData;
            if (bundle != null) {
                int n3 = "DISABLE".equals((Object)bundle.getString("com.onesignal.BadgeCount")) ? 0 : 1;
                badgesEnabled = n3;
            } else {
                badgesEnabled = 1;
            }
        }
        catch (Throwable throwable) {
            badgesEnabled = 0;
            OneSignal.Log(OneSignal.LOG_LEVEL.ERROR, "Error reading meta-data tag 'com.onesignal.BadgeCount'. Disabling badge setting.", throwable);
        }
        int n4 = badgesEnabled;
        boolean bl3 = false;
        if (n4 != 1) return bl3;
        return true;
    }

    private static boolean areBadgesEnabled(Context context) {
        return BadgeCountUpdater.areBadgeSettingsEnabled(context) && OSUtils.areNotificationsEnabled(context);
    }

    static void update(SQLiteDatabase sQLiteDatabase, Context context) {
        if (!BadgeCountUpdater.areBadgesEnabled(context)) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            BadgeCountUpdater.updateStandard(context);
            return;
        }
        BadgeCountUpdater.updateFallback(sQLiteDatabase, context);
    }

    static void updateCount(int n2, Context context) {
        if (!BadgeCountUpdater.areBadgeSettingsEnabled(context)) {
            return;
        }
        try {
            ShortcutBadger.applyCountOrThrow(context, n2);
        }
        catch (Throwable throwable) {}
    }

    private static void updateFallback(SQLiteDatabase sQLiteDatabase, Context context) {
        Cursor cursor = sQLiteDatabase.query("notification", null, OneSignalDbHelper.recentUninteractedWithNotificationsWhere().toString(), null, null, null, null, NotificationLimitManager.MAX_NUMBER_OF_NOTIFICATIONS_STR);
        int n2 = cursor.getCount();
        cursor.close();
        BadgeCountUpdater.updateCount(n2, context);
    }

    private static void updateStandard(Context context) {
        StatusBarNotification[] arrstatusBarNotification = ((NotificationManager)context.getSystemService("notification")).getActiveNotifications();
        int n2 = arrstatusBarNotification.length;
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (NotificationLimitManager.isGroupSummary(arrstatusBarNotification[i2])) continue;
            ++n3;
        }
        BadgeCountUpdater.updateCount(n3, context);
    }
}

