/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.app.job.JobParameters
 *  android.app.job.JobService
 *  io.presage.EcirdelAubrac
 *  io.presage.common.profig.schedule.ProfigJobService$CamembertauCalvados
 *  io.presage.common.profig.schedule.ProfigJobService$CamembertdeNormandie
 *  io.presage.common.profig.schedule.ProfigJobService$EcirdelAubrac
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package io.presage.common.profig.schedule;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import io.presage.AbbayedeTamie;
import io.presage.EcirdelAubrac;
import io.presage.cc;
import io.presage.cd;
import io.presage.common.profig.schedule.ProfigJobService;

@TargetApi(value=21)
public final class ProfigJobService
extends JobService {
    private JobParameters a;

    private final void a() {
        StringBuilder stringBuilder = new StringBuilder("marking job as finished ");
        JobParameters jobParameters = this.a;
        String string2 = jobParameters != null ? jobParameters.toString() : null;
        stringBuilder.append(string2);
        this.jobFinished(this.a, false);
    }

    public static final /* synthetic */ void a(ProfigJobService profigJobService) {
        profigJobService.a();
    }

    public final boolean onStartJob(JobParameters jobParameters) {
        this.a = jobParameters;
        EcirdelAubrac.CamembertauCalvados.a((cc)new CamembertauCalvados(this)).a((cd)new CamembertdeNormandie(this)).a((cc)new EcirdelAubrac(this));
        return true;
    }

    public final boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}

