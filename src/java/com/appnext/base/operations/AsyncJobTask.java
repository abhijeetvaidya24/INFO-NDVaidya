/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.job.JobParameters
 *  android.os.AsyncTask
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Void
 */
package com.appnext.base.operations;

import android.app.job.JobParameters;
import android.os.AsyncTask;
import com.appnext.base.operations.AppnextOperationJobService;

public class AsyncJobTask
extends AsyncTask<Void, Void, Integer> {
    private final JobParameters jobParameters;
    private final AppnextOperationJobService jobService;

    public AsyncJobTask(AppnextOperationJobService appnextOperationJobService, JobParameters jobParameters) {
        this.jobService = appnextOperationJobService;
        this.jobParameters = jobParameters;
    }

    protected /* varargs */ Integer doInBackground(Void ... arrvoid) {
        return this.jobService.onRunJob(this.jobParameters);
    }

    public void finishJob() {
        this.jobService.jobFinished(this.jobParameters, false);
    }

    protected void onPostExecute(Integer n2) {
    }
}

