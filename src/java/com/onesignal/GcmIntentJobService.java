/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.job.JobParameters
 *  android.app.job.JobService
 *  android.content.Context
 *  android.os.PersistableBundle
 */
package com.onesignal;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.os.PersistableBundle;
import com.onesignal.BundleCompatPersistableBundle;
import com.onesignal.NotificationBundleProcessor;
import com.onesignal.OneSignalJobServiceBase;

public class GcmIntentJobService
extends OneSignalJobServiceBase {
    @Override
    void startProcessing(JobService jobService, JobParameters jobParameters) {
        NotificationBundleProcessor.ProcessFromGCMIntentService((Context)jobService, new BundleCompatPersistableBundle(jobParameters.getExtras()), null);
    }
}

