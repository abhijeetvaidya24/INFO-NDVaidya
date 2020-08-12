/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.job.JobParameters
 *  android.app.job.JobService
 *  android.content.Context
 *  io.presage.core.service.TJobService$1
 */
package io.presage.core.service;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import io.presage.core.IllllllI;
import io.presage.core.lIIIlIII;
import io.presage.core.service.TJobService;

public class TJobService
extends JobService {
    public boolean onStartJob(JobParameters jobParameters) {
        if (lIIIlIII.IIIIIIIl((Context)this)) {
            IllllllI.IIIIIIII((IllllllI.IIIIIIII)new 1(this, jobParameters));
        }
        return true;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}

