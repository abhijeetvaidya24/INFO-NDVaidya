/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.annotation.TargetApi
 *  android.app.AlarmManager
 *  android.app.PendingIntent
 *  android.app.job.JobInfo
 *  android.app.job.JobInfo$Builder
 *  android.app.job.JobParameters
 *  android.app.job.JobScheduler
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.ServiceInfo
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.PersistableBundle
 *  android.os.SystemClock
 *  com.startapp.common.b.a$1$1
 *  com.startapp.common.b.a$2$1
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 *  java.util.concurrent.ConcurrentHashMap
 *  java.util.concurrent.ExecutorService
 *  java.util.concurrent.Executors
 *  java.util.concurrent.ScheduledExecutorService
 *  java.util.concurrent.ScheduledFuture
 *  java.util.concurrent.TimeUnit
 *  java.util.concurrent.atomic.AtomicInteger
 */
package com.startapp.common.b;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.SystemClock;
import com.startapp.android.publish.common.metaData.InfoEventService;
import com.startapp.android.publish.common.metaData.PeriodicJobService;
import com.startapp.common.b.a;
import com.startapp.common.b.a.b;
import com.startapp.common.b.a.c;
import com.startapp.common.b.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class a {
    @SuppressLint(value={"StaticFieldLeak"})
    private static volatile a a;
    private static volatile c b;
    private static volatile Integer c;
    private static volatile int d = 60000;
    private static final ExecutorService j;
    private static final ScheduledExecutorService k;
    private Context e;
    private List<com.startapp.common.b.a.a> f = Collections.synchronizedList((List)new ArrayList());
    private Map<Integer, Integer> g = new ConcurrentHashMap();
    private AtomicInteger h = new AtomicInteger(0);
    private boolean i;

    static {
        j = Executors.newSingleThreadExecutor();
        k = Executors.newScheduledThreadPool((int)1);
    }

    private a(Context context) {
        this.e = context.getApplicationContext();
        this.i = this.d(context);
    }

    private static com.startapp.common.b.a.b a(int n2) {
        Iterator iterator = a.a.f.iterator();
        com.startapp.common.b.a.b b2 = null;
        while (iterator.hasNext() && (b2 = ((com.startapp.common.b.a.a)iterator.next()).create(n2)) == null) {
        }
        return b2;
    }

    /*
     * Exception decompiling
     */
    public static a a(Context var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl158.1 : IINC : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:919)
        throw new IllegalStateException("Decompilation failed");
    }

    @TargetApi(value=21)
    private static b a(JobParameters jobParameters) {
        int n2;
        PersistableBundle persistableBundle = jobParameters.getExtras();
        int n3 = persistableBundle.getInt("__RUNNER_RECURRING_ID__");
        if (n3 != (n2 = 1)) {
            n2 = 0;
        }
        long l2 = persistableBundle.getLong("__RUNNER_TRIGGER_ID__", 0L);
        HashMap hashMap = new HashMap(persistableBundle.keySet().size());
        for (String string : persistableBundle.keySet()) {
            Object object = persistableBundle.get(string);
            if (!(object instanceof String)) continue;
            hashMap.put((Object)string, (Object)((String)object));
        }
        return new b.a(jobParameters.getJobId()).a((Map<String, String>)hashMap).a((boolean)n2).a(l2).a();
    }

    private static b a(Intent intent) {
        HashMap hashMap;
        int n2 = intent.getIntExtra("__RUNNER_TASK_ID__", -1);
        boolean bl = intent.getBooleanExtra("__RUNNER_RECURRING_ID__", false);
        long l2 = intent.getLongExtra("__RUNNER_TRIGGER_ID__", 0L);
        if (intent.getExtras() != null) {
            hashMap = new HashMap(intent.getExtras().keySet().size());
            for (String string : intent.getExtras().keySet()) {
                Object object = intent.getExtras().get(string);
                if (!(object instanceof String)) continue;
                hashMap.put((Object)string, (Object)((String)object));
            }
        } else {
            hashMap = null;
        }
        return new b.a(n2).a((Map<String, String>)hashMap).a(bl).a(l2).a();
    }

    public static void a(int n2, String string, String string2) {
        a.a(n2, string, string2, null);
    }

    public static void a(int n2, String string, String string2, Throwable throwable) {
        if (b != null) {
            b.a(n2, string, string2, throwable);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @SuppressLint(value={"NewApi"})
    public static void a(int n2, boolean bl) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("cancelAlarm ");
        stringBuilder.append(n2);
        a.a(3, "RunnerManager", stringBuilder.toString());
        try {
            n2 = a.b(n2, bl);
            if (!a.a.i) {
                a.a.g.remove((Object)n2);
                return;
            }
            if (a.b()) {
                JobScheduler jobScheduler = a.c(a.a.e);
                if (jobScheduler == null) {
                    return;
                }
                jobScheduler.cancel(n2);
                return;
            }
            AlarmManager alarmManager = a.b(a.a.e);
            if (alarmManager == null) {
                return;
            }
            Intent intent = new Intent(a.a.e, InfoEventService.class);
            a.a(a.a.e, intent, alarmManager, n2);
            return;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("cancelAlarm ");
            stringBuilder2.append(n2);
            a.a(6, "RunnerManager", stringBuilder2.toString(), exception);
            return;
        }
    }

    private static void a(Context context, Intent intent, AlarmManager alarmManager, int n2) {
        PendingIntent pendingIntent = PendingIntent.getService((Context)context, (int)n2, (Intent)intent, (int)134217728);
        if (PendingIntent.getService((Context)context, (int)0, (Intent)intent, (int)268435456) != null) {
            alarmManager.cancel(pendingIntent);
            pendingIntent.cancel();
        }
    }

    public static void a(com.startapp.common.b.a.a a2) {
        a.a.f.add((Object)a2);
        String string = a2.getClass().getName();
        SharedPreferences sharedPreferences = a.a.e.getSharedPreferences("RunnerManager", 0);
        String string2 = sharedPreferences.getString("RegisteredClassesNames", null);
        if (string2 == null) {
            sharedPreferences.edit().putString("RegisteredClassesNames", string).commit();
            return;
        }
        if (!string2.contains((CharSequence)string)) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(",");
            stringBuilder.append(string);
            editor.putString("RegisteredClassesNames", stringBuilder.toString()).commit();
        }
    }

    public static void a(c c2) {
        b = c2;
    }

    @TargetApi(value=21)
    private static boolean a(int n2, b b2) {
        JobScheduler jobScheduler = a.c(a.a.e);
        if (jobScheduler == null) {
            return false;
        }
        PersistableBundle persistableBundle = new PersistableBundle();
        Map<String, String> map = b2.b();
        for (String string : map.keySet()) {
            persistableBundle.putString(string, (String)map.get((Object)string));
        }
        persistableBundle.putInt("__RUNNER_RECURRING_ID__", (int)b2.e());
        persistableBundle.putLong("__RUNNER_TRIGGER_ID__", b2.c());
        JobInfo.Builder builder = new JobInfo.Builder(n2, new ComponentName(a.a.e, PeriodicJobService.class));
        builder.setExtras(persistableBundle);
        if (b2.e()) {
            builder.setPeriodic(b2.c());
        } else {
            builder.setMinimumLatency(b2.c()).setOverrideDeadline(b2.c() + (long)d);
        }
        builder.setRequiredNetworkType((int)b2.f());
        int n3 = jobScheduler.schedule(builder.build());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("jobScheduler.schedule ");
        stringBuilder.append(n3);
        a.a(3, "RunnerManager", stringBuilder.toString());
        return n3 == 1;
    }

    @TargetApi(value=21)
    public static boolean a(JobParameters jobParameters, b$b b2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("runJob ");
        stringBuilder.append((Object)jobParameters);
        a.a(3, "RunnerManager", stringBuilder.toString());
        return a.b(a.a(jobParameters), b2);
    }

    public static boolean a(Intent intent, b$b b2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("runJob ");
        Object object = intent != null ? intent : "NULL";
        stringBuilder.append(object);
        a.a(3, "RunnerManager", stringBuilder.toString());
        return intent != null && a.b(a.a(intent), b2);
    }

    public static boolean a(b b2) {
        try {
            int n2 = a.b(b2.a(), b2.e());
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("schedule ");
            stringBuilder.append(n2);
            stringBuilder.append(" ");
            stringBuilder.append((Object)b2);
            a.a(3, "RunnerManager", stringBuilder.toString());
            if (a.c()) {
                if (a.b()) {
                    return a.a(n2, b2);
                }
                return a.b(n2, b2);
            }
            boolean bl = a.c(n2, b2);
            return bl;
        }
        catch (Exception exception) {
            a.a(6, "RunnerManager", "schedule error", exception);
            return false;
        }
    }

    private static int b(int n2) {
        return n2 & Integer.MAX_VALUE;
    }

    private static int b(int n2, boolean bl) {
        if (bl) {
            n2 |= Integer.MIN_VALUE;
        }
        return n2;
    }

    private static AlarmManager b(Context context) {
        AlarmManager alarmManager = (AlarmManager)context.getSystemService("alarm");
        if (alarmManager == null) {
            a.a(6, "RunnerManager", "failed to get AlarmManager");
        }
        return alarmManager;
    }

    private static boolean b() {
        int n2 = Build.VERSION.SDK_INT;
        if (c != null) {
            n2 = c;
        }
        return n2 >= 21;
    }

    private static boolean b(int n2, b b2) {
        AlarmManager alarmManager = a.b(a.a.e);
        if (alarmManager == null) {
            return false;
        }
        Intent intent = new Intent(a.a.e, InfoEventService.class);
        Map<String, String> map = b2.b();
        for (String string : map.keySet()) {
            intent.putExtra(string, (String)map.get((Object)string));
        }
        intent.putExtra("__RUNNER_TASK_ID__", n2);
        intent.putExtra("__RUNNER_RECURRING_ID__", b2.e());
        intent.putExtra("__RUNNER_TRIGGER_ID__", b2.c());
        PendingIntent pendingIntent = PendingIntent.getService((Context)a.a.e, (int)n2, (Intent)intent, (int)134217728);
        alarmManager.cancel(pendingIntent);
        if (b2.e()) {
            alarmManager.setRepeating(0, System.currentTimeMillis() + b2.d(), b2.c(), pendingIntent);
        } else {
            alarmManager.set(3, SystemClock.elapsedRealtime() + b2.c(), pendingIntent);
        }
        return true;
    }

    private static boolean b(final b b2, final b$b b3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RunnerJob ");
        stringBuilder.append(b2.a());
        stringBuilder.append(" ");
        stringBuilder.append(a.b(b2.a()));
        a.a(3, "RunnerManager", stringBuilder.toString());
        final int n2 = a.b(b2.a());
        final com.startapp.common.b.a.b b4 = a.a(n2);
        if (b4 != null) {
            j.execute(new Runnable(){

                public void run() {
                    b4.a(a.e, n2, b2.b(), (b$b)new 1(this));
                }
            });
            return true;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("runJob: failed to get job for ID ");
        stringBuilder2.append(b2.a());
        a.a(5, "RunnerManager", stringBuilder2.toString());
        b3.a(b$a.b);
        return false;
    }

    @TargetApi(value=21)
    private static JobScheduler c(Context context) {
        JobScheduler jobScheduler = (JobScheduler)context.getSystemService("jobscheduler");
        if (jobScheduler == null) {
            a.a(6, "RunnerManager", "failed to get JobScheduler");
        }
        return jobScheduler;
    }

    private static boolean c() {
        return a.a.i;
    }

    private static boolean c(final int n2, final b b2) {
        final int n3 = a.a.h.incrementAndGet();
        Runnable runnable = new Runnable(){

            public void run() {
                Integer n22 = (Integer)a.g.get((Object)n2);
                if (n22 != null && n22 == n3) {
                    if (!b2.e()) {
                        a.g.remove((Object)n2);
                    }
                    a.b(b2, (b$b)new 1(this));
                }
            }
        };
        if (b2.e()) {
            k.scheduleAtFixedRate(runnable, b2.d(), b2.d(), TimeUnit.MILLISECONDS);
        } else {
            k.schedule(runnable, b2.c(), TimeUnit.MILLISECONDS);
        }
        a.a.g.put((Object)n2, (Object)n3);
        return true;
    }

    private boolean d(Context context) {
        ServiceInfo[] arrserviceInfo = context.getPackageManager().getPackageInfo((String)context.getPackageName(), (int)4).services;
        int n2 = arrserviceInfo.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            try {
                boolean bl = arrserviceInfo[i2].name.equals((Object)InfoEventService.class.getName());
                if (!bl) continue;
                return true;
            }
            catch (Throwable throwable) {
                a.a(6, "RunnerManager", "servicesDefined", throwable);
                break;
            }
        }
        return false;
    }

}

