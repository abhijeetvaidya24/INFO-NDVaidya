/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.AlarmManager
 *  android.app.PendingIntent
 *  android.app.job.JobInfo
 *  android.app.job.JobInfo$Builder
 *  android.app.job.JobScheduler
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Build
 *  android.os.Build$VERSION
 *  com.onesignal.OneSignalSyncServiceUtils$SyncRunnable$1
 *  java.lang.Class
 *  java.lang.Long
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Thread
 *  java.util.concurrent.atomic.AtomicBoolean
 */
package com.onesignal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.onesignal.AndroidSupportV4Compat;
import com.onesignal.LocationGMS;
import com.onesignal.OneSignal;
import com.onesignal.OneSignalStateSynchronizer;
import com.onesignal.OneSignalSyncServiceUtils;
import com.onesignal.SyncJobService;
import com.onesignal.SyncService;
import java.util.concurrent.atomic.AtomicBoolean;

class OneSignalSyncServiceUtils {
    private static Long nextScheduledSyncTime = 0L;
    private static AtomicBoolean runningOnFocusTime = new AtomicBoolean();
    private static Thread syncBgThread;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static void cancelSyncTask(Context context) {
        Long l2;
        Long l3 = l2 = nextScheduledSyncTime;
        synchronized (l3) {
            nextScheduledSyncTime = 0L;
            if (LocationGMS.scheduleUpdate(context)) {
                return;
            }
            if (OneSignalSyncServiceUtils.useJob()) {
                ((JobScheduler)context.getSystemService("jobscheduler")).cancel(2071862118);
            } else {
                ((AlarmManager)context.getSystemService("alarm")).cancel(OneSignalSyncServiceUtils.syncServicePendingIntent(context));
            }
            return;
        }
    }

    static void doBackgroundSync(Context context, SyncRunnable syncRunnable) {
        OneSignal.setAppContext(context);
        syncBgThread = new Thread((Runnable)syncRunnable, "OS_SYNCSRV_BG_SYNC");
        syncBgThread.start();
    }

    private static boolean hasBootPermission(Context context) {
        return AndroidSupportV4Compat.ContextCompat.checkSelfPermission(context, "android.permission.RECEIVE_BOOT_COMPLETED") == 0;
    }

    private static void internalSyncOnFocusTime() {
        long l2 = OneSignal.GetUnsentActiveTime();
        if (l2 < 60L) {
            return;
        }
        OneSignal.sendOnFocus(l2, true);
    }

    static void scheduleLocationUpdateTask(Context context, long l2) {
        OneSignal.LOG_LEVEL lOG_LEVEL = OneSignal.LOG_LEVEL.VERBOSE;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("scheduleLocationUpdateTask:delayMs: ");
        stringBuilder.append(l2);
        OneSignal.Log(lOG_LEVEL, stringBuilder.toString());
        OneSignalSyncServiceUtils.scheduleSyncTask(context, l2);
    }

    private static void scheduleSyncServiceAsAlarm(Context context, long l2) {
        OneSignal.LOG_LEVEL lOG_LEVEL = OneSignal.LOG_LEVEL.VERBOSE;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("scheduleServiceSyncTask:atTime: ");
        stringBuilder.append(l2);
        OneSignal.Log(lOG_LEVEL, stringBuilder.toString());
        PendingIntent pendingIntent = OneSignalSyncServiceUtils.syncServicePendingIntent(context);
        ((AlarmManager)context.getSystemService("alarm")).set(0, l2 + (l2 + System.currentTimeMillis()), pendingIntent);
    }

    private static void scheduleSyncServiceAsJob(Context context, long l2) {
        OneSignal.LOG_LEVEL lOG_LEVEL = OneSignal.LOG_LEVEL.VERBOSE;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("scheduleSyncServiceAsJob:atTime: ");
        stringBuilder.append(l2);
        OneSignal.Log(lOG_LEVEL, stringBuilder.toString());
        JobInfo.Builder builder = new JobInfo.Builder(2071862118, new ComponentName(context, SyncJobService.class));
        builder.setMinimumLatency(l2).setRequiredNetworkType(1);
        if (OneSignalSyncServiceUtils.hasBootPermission(context)) {
            builder.setPersisted(true);
        }
        JobScheduler jobScheduler = (JobScheduler)context.getSystemService("jobscheduler");
        try {
            int n2 = jobScheduler.schedule(builder.build());
            OneSignal.LOG_LEVEL lOG_LEVEL2 = OneSignal.LOG_LEVEL.INFO;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("scheduleSyncServiceAsJob:result: ");
            stringBuilder2.append(n2);
            OneSignal.Log(lOG_LEVEL2, stringBuilder2.toString());
            return;
        }
        catch (NullPointerException nullPointerException) {
            OneSignal.Log(OneSignal.LOG_LEVEL.ERROR, "scheduleSyncServiceAsJob called JobScheduler.jobScheduler which triggered an internal null Android error. Skipping job.", nullPointerException);
            return;
        }
    }

    static void scheduleSyncTask(Context context) {
        OneSignal.Log(OneSignal.LOG_LEVEL.VERBOSE, "scheduleSyncTask:SYNC_AFTER_BG_DELAY_MS: 120000");
        OneSignalSyncServiceUtils.scheduleSyncTask(context, 120000L);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void scheduleSyncTask(Context context, long l2) {
        Long l3;
        Long l4 = l3 = nextScheduledSyncTime;
        synchronized (l4) {
            if (nextScheduledSyncTime != 0L && l2 + System.currentTimeMillis() > nextScheduledSyncTime) {
                return;
            }
            if (l2 < 5000L) {
                l2 = 5000L;
            }
            if (OneSignalSyncServiceUtils.useJob()) {
                OneSignalSyncServiceUtils.scheduleSyncServiceAsJob(context, l2);
            } else {
                OneSignalSyncServiceUtils.scheduleSyncServiceAsAlarm(context, l2);
            }
            nextScheduledSyncTime = l2 + System.currentTimeMillis();
            return;
        }
    }

    static boolean stopSyncBgThread() {
        Thread thread = syncBgThread;
        if (thread == null) {
            return false;
        }
        if (!thread.isAlive()) {
            return false;
        }
        syncBgThread.interrupt();
        return true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static void syncOnFocusTime() {
        AtomicBoolean atomicBoolean;
        if (runningOnFocusTime.get()) {
            return;
        }
        AtomicBoolean atomicBoolean2 = atomicBoolean = runningOnFocusTime;
        synchronized (atomicBoolean2) {
            runningOnFocusTime.set(true);
            OneSignalSyncServiceUtils.internalSyncOnFocusTime();
            runningOnFocusTime.set(false);
            return;
        }
    }

    private static PendingIntent syncServicePendingIntent(Context context) {
        return PendingIntent.getService((Context)context, (int)2071862118, (Intent)new Intent(context, SyncService.class), (int)134217728);
    }

    private static boolean useJob() {
        return Build.VERSION.SDK_INT >= 21;
    }

    static abstract class SyncRunnable
    implements Runnable {
        SyncRunnable() {
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Converted monitor instructions to comments
         * Lifted jumps to return sites
         */
        public final void run() {
            Long l2;
            Long l3 = l2 = nextScheduledSyncTime;
            // MONITORENTER : l3
            nextScheduledSyncTime = 0L;
            // MONITOREXIT : l3
            if (OneSignal.getUserId() == null) {
                this.stopSync();
                return;
            }
            OneSignal.appId = OneSignal.getSavedAppId();
            OneSignalStateSynchronizer.initUserState();
            1 var4_3 = new 1(this);
            LocationGMS.getLocation(OneSignal.appContext, false, (LocationGMS.LocationHandler)var4_3);
        }

        protected abstract void stopSync();
    }

}

