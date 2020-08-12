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
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.content.pm.PackageManager
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Process
 *  android.util.Log
 *  io.presage.core.IIIIIIII$2
 *  io.presage.core.IIIIIIII$4
 *  io.presage.core.IIlIIllI
 *  io.presage.core.lIIIlIIl
 *  io.presage.core.lIIIlIlI
 *  io.presage.core.lIIIlIlI$IIllIlIl
 *  io.presage.core.lIIlIIII
 *  io.presage.core.lIIlllII
 *  io.presage.core.lIIlllII$IIIIIIII
 *  io.presage.core.lIIllllI
 *  io.presage.core.lIlIIIII
 *  io.presage.core.service.AMJobService
 *  io.presage.core.service.TJobService
 *  io.presage.core.service.TService
 *  java.io.File
 *  java.io.PrintWriter
 *  java.io.StringWriter
 *  java.io.Writer
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.StackTraceElement
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Thread
 *  java.lang.Thread$UncaughtExceptionHandler
 *  java.lang.Throwable
 *  java.lang.Void
 */
package io.presage.core;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.util.Log;
import io.presage.core.IIIIIIII;
import io.presage.core.IIIIIIIl;
import io.presage.core.IIIIIIlI;
import io.presage.core.IIIIIlII;
import io.presage.core.IIlIIIll;
import io.presage.core.IIlIIllI;
import io.presage.core.IIlIIlll;
import io.presage.core.IlIlllll;
import io.presage.core.IllIllII;
import io.presage.core.IlllIlll;
import io.presage.core.IllllllI;
import io.presage.core.activity.ABActivity;
import io.presage.core.lIIIIIlI;
import io.presage.core.lIIIIIll;
import io.presage.core.lIIIlIIl;
import io.presage.core.lIIIlIlI;
import io.presage.core.lIIlIIII;
import io.presage.core.lIIlllII;
import io.presage.core.lIIllllI;
import io.presage.core.lIlIIIII;
import io.presage.core.service.AMJobService;
import io.presage.core.service.TJobService;
import io.presage.core.service.TService;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

public final class IIIIIIII {
    private static final String IIIIIIlI = lIIIIIlI.IIIIlIlI.IIIIIIII;
    private static final String IIIIIIll = lIIIIIlI.IIIIlIlI.IIIIIIIl;
    private static final String IIIIIlII = lIIIIIlI.IIIIlIlI.IIIIIIlI;
    private static volatile IIIIIIII IIIIIlIl;
    public Context IIIIIIII;
    public IIIIIIlI IIIIIIIl;
    private Thread.UncaughtExceptionHandler IIIIIllI;

    private IIIIIIII(Context context) {
        if (context != null) {
            this.IIIIIIII = context.getApplicationContext();
            this.IIIIIIIl = new IIIIIIlI(this.IIIIIIII);
            Context context2 = this.IIIIIIII;
            IIIIIIlI iIIIIIlI = this.IIIIIIIl;
            File file = new File(context2.getFilesDir(), IIIIIIlI);
            new Handler(Looper.getMainLooper()).post(new Runnable(context2, iIIIIIlI, file){
                final /* synthetic */ Context IIIIIIII;
                final /* synthetic */ IIIIIIlI IIIIIIIl;
                final /* synthetic */ File IIIIIIlI;
                {
                    this.IIIIIIII = context;
                    this.IIIIIIIl = iIIIIIlI;
                    this.IIIIIIlI = file;
                }

                /*
                 * Exception decompiling
                 */
                public final void run(}
        }
        java.lang.IllegalStateException: Parameters not created
        
        