/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.job.JobParameters
 *  android.app.job.JobService
 *  android.os.AsyncTask
 *  java.lang.Object
 *  java.lang.Void
 *  java.util.HashMap
 *  java.util.Map
 */
package com.appnext.base.operations;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.AsyncTask;
import com.appnext.base.operations.AsyncJobTask;
import java.util.HashMap;
import java.util.Map;

public abstract class AppnextOperationJobService
extends JobService {
    private final Map<JobParameters, AsyncJobTask> ej = new HashMap();
    private AsyncJobTask ek;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected final void a(JobParameters jobParameters) {
        Map<JobParameters, AsyncJobTask> map;
        Map<JobParameters, AsyncJobTask> map2 = map = this.ej;
        synchronized (map2) {
            this.ej.remove((Object)jobParameters);
        }
        this.ek.finishJob();
    }

    public abstract int onRunJob(JobParameters var1);

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean onStartJob(JobParameters jobParameters) {
        Map<JobParameters, AsyncJobTask> map;
        this.ek = new AsyncJobTask(this, jobParameters);
        Map<JobParameters, AsyncJobTask> map2 = map = this.ej;
        synchronized (map2) {
            this.ej.put((Object)jobParameters, (Object)((Object)this.ek));
        }
        this.ek.execute((Object[])new Void[0]);
        return true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean onStopJob(JobParameters jobParameters) {
        Map<JobParameters, AsyncJobTask> map;
        Map<JobParameters, AsyncJobTask> map2 = map = this.ej;
        synchronized (map2) {
            AsyncJobTask asyncJobTask = (AsyncJobTask)((Object)this.ej.remove((Object)jobParameters));
            if (asyncJobTask != null) {
                asyncJobTask.cancel(true);
                return false;
            }
            return false;
        }
    }
}

