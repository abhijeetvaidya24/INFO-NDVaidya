/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.job.JobScheduler
 *  android.content.Context
 *  java.lang.Object
 *  java.lang.String
 */
package io.presage.core;

import android.app.job.JobScheduler;
import android.content.Context;

public final class lIIllllI {
    public static lIIllllI IIIIIIII;
    public Context IIIIIIIl;
    public JobScheduler IIIIIIlI;

    public lIIllllI(Context context) {
        this.IIIIIIIl = context;
        this.IIIIIIlI = (JobScheduler)context.getSystemService("jobscheduler");
    }
}

