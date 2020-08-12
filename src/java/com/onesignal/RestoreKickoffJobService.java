/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.job.JobParameters
 *  android.app.job.JobService
 *  android.content.Context
 *  java.lang.Thread
 */
package com.onesignal;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import com.onesignal.NotificationRestorer;
import com.onesignal.OneSignal;
import com.onesignal.OneSignalJobServiceBase;

public class RestoreKickoffJobService
extends OneSignalJobServiceBase {
    @Override
    void startProcessing(JobService jobService, JobParameters jobParameters) {
        Thread.currentThread().setPriority(10);
        OneSignal.setAppContext((Context)this);
        NotificationRestorer.restore(this.getApplicationContext());
    }
}

