/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.job.JobParameters
 *  android.app.job.JobService
 *  android.content.Context
 *  io.presage.core.service.MCJobService$1
 */
package io.presage.core.service;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import io.presage.core.IIIIIIII;
import io.presage.core.IIIIIIIl;
import io.presage.core.IIIIIIlI;
import io.presage.core.IIIIIIll;
import io.presage.core.service.MCJobService;

public class MCJobService
extends JobService {
    private boolean IIIIIIII;

    static /* synthetic */ boolean IIIIIIII(MCJobService mCJobService) {
        mCJobService.IIIIIIII = false;
        return false;
    }

    public void onCreate() {
        this.IIIIIIII = true;
    }

    public void onDestroy() {
        if (this.IIIIIIII) {
            IIIIIIll.IIIIIIII((Context)this).IIIIIIII();
        }
    }

    public boolean onStartJob(JobParameters jobParameters) {
        try {
            IIIIIIll.IIIIIIII((Context)this).IIIIIIII(IIIIIIII.IIIIIIII((Context)this).IIIIIIIl, (IIIIIIll.IIIIIIII)new 1(this, jobParameters));
        }
        catch (IIIIIIIl iIIIIIIl) {}
        return true;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        IIIIIIll.IIIIIIII((Context)this).IIIIIIII();
        this.IIIIIIII = false;
        return true;
    }
}

