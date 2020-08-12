/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.job.JobInfo
 *  android.app.job.JobInfo$Builder
 *  android.app.job.JobScheduler
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Build
 *  android.os.Build$VERSION
 *  io.presage.core.service.MCJobService
 *  io.presage.core.service.MCService
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.util.concurrent.atomic.AtomicBoolean
 */
package io.presage.core;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import io.presage.core.IIIIIIll;
import io.presage.core.service.MCJobService;
import io.presage.core.service.MCService;
import java.util.concurrent.atomic.AtomicBoolean;

public final class IIIIIlII {
    private static IIIIIlII IIIIIIII;
    private Context IIIIIIIl;

    private IIIIIlII(Context context) {
        this.IIIIIIIl = context;
    }

    public static IIIIIlII IIIIIIII(Context context) {
        if (IIIIIIII == null) {
            IIIIIIII = new IIIIIlII(context);
        }
        return IIIIIIII;
    }

    public final void IIIIIIII() {
        if (Build.VERSION.SDK_INT >= 26) {
            JobScheduler jobScheduler = (JobScheduler)this.IIIIIIIl.getSystemService("jobscheduler");
            if (jobScheduler.getPendingJob(475439700) != null) {
                new Object[1][0] = 475439700;
                new Object[1][0] = IIIIIIll.IIIIIIII((Context)this.IIIIIIIl).IIIIIIIl.get();
                if (!IIIIIIll.IIIIIIII((Context)this.IIIIIIIl).IIIIIIIl.get()) {
                    jobScheduler.cancel(475439700);
                }
            }
            if (jobScheduler.getPendingJob(475439700) == null) {
                new Object[1][0] = 475439700;
                int n2 = jobScheduler.schedule(new JobInfo.Builder(475439700, new ComponentName(this.IIIIIIIl, MCJobService.class)).setMinimumLatency(500L).setOverrideDeadline(1000L).setBackoffCriteria(10000L, 0).build());
                new Object[1][0] = n2;
            }
            return;
        }
        Intent intent = new Intent(this.IIIIIIIl, MCService.class);
        this.IIIIIIIl.startService(intent);
    }

    public final void IIIIIIIl() {
        if (Build.VERSION.SDK_INT >= 26) {
            ((JobScheduler)this.IIIIIIIl.getSystemService("jobscheduler")).cancel(475439700);
            return;
        }
        Intent intent = new Intent(this.IIIIIIIl, MCService.class);
        this.IIIIIIIl.stopService(intent);
    }
}

