/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.job.JobParameters
 *  android.app.job.JobService
 *  android.content.Context
 *  com.onesignal.OneSignalSyncServiceUtils$LollipopSyncRunnable
 */
package com.onesignal;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import com.onesignal.OneSignalSyncServiceUtils;

/*
 * Exception performing whole class analysis.
 */
public class SyncJobService
extends JobService {
    public boolean onStartJob(JobParameters jobParameters) {
        OneSignalSyncServiceUtils.doBackgroundSync((Context)this, (OneSignalSyncServiceUtils.SyncRunnable)new /* Unavailable Anonymous Inner Class!! */);
        return true;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        return OneSignalSyncServiceUtils.stopSyncBgThread();
    }
}

