/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.app.job.JobParameters
 *  android.app.job.JobService
 *  android.content.Context
 *  com.startapp.android.publish.common.metaData.PeriodicJobService$1
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.startapp.android.publish.common.metaData;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import com.startapp.android.publish.common.metaData.PeriodicJobService;
import com.startapp.common.b.a;
import com.startapp.common.b.a.b;

@TargetApi(value=21)
public class PeriodicJobService
extends JobService {
    private static final String a = "PeriodicJobService";

    public boolean onStartJob(JobParameters jobParameters) {
        a.a((Context)this);
        boolean bl = a.a(jobParameters, (b.b)new 1(this, jobParameters));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onStartJob: RunnerManager.runJob");
        stringBuilder.append(bl);
        a.a(3, a, stringBuilder.toString(), null);
        return bl;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}

