/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.AlarmManager
 *  android.app.PendingIntent
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager
 *  android.os.Parcelable
 *  android.os.SystemClock
 *  java.lang.Integer
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.System
 *  java.sql.Timestamp
 */
package com.tapjoy.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Parcelable;
import android.os.SystemClock;
import com.tapjoy.internal.ae;
import com.tapjoy.internal.ct;
import com.tapjoy.internal.s;
import com.tapjoy.internal.t;
import java.sql.Timestamp;

public abstract class r
extends s {
    public final Context a;
    public final t b;
    private boolean c = false;

    public r(Context context, t t2) {
        this.a = context.getApplicationContext();
        this.b = t2;
    }

    private static void b(Context context, Intent intent) {
        intent.putExtra("app", (Parcelable)PendingIntent.getBroadcast((Context)context, (int)0, (Intent)new Intent(), (int)0));
    }

    private boolean b() {
        long l2;
        boolean bl = this.b.e(this.a);
        if (bl && (l2 = this.b.f(this.a)) != 0L && System.currentTimeMillis() > l2) {
            new Object[1][0] = new Timestamp(l2);
            return false;
        }
        return bl;
    }

    private static boolean b(Context context, String string) {
        int n2;
        block4 : {
            try {
                n2 = ae.b(context.getPackageManager(), "com.google.android.gms");
                if (n2 < 3159130) break block4;
            }
            catch (RuntimeException runtimeException) {}
            Object[] arrobject = new Object[]{n2, string};
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            r.b(context, intent);
            intent.putExtra("sender", string);
            return context.startService(intent) != null;
        }
        new Object[1][0] = n2;
        return false;
    }

    /*
     * Exception decompiling
     */
    private static boolean c(Context var0, String var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl43.1 : ICONST_0 : trying to set 1 previously set to 0
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

    private void e(String string) {
        this.b.a(this.a, string);
        this.b.a(this.a, true);
        if (!this.c && r.b(this.a, string)) {
            return;
        }
        if (r.c(this.a, string)) {
            // empty if block
        }
    }

    private void f(String string) {
        r r2 = this;
        synchronized (r2) {
            this.a(this.a);
            this.b.a(this.a, false);
            int n2 = ae.a(this.a);
            this.b.a(this.a, n2);
            if (!string.equals((Object)this.b.b(this.a))) {
                new Object[1][0] = string;
                this.b.b(this.a, false);
                this.b.b(this.a, string);
                this.a(this.a, string);
                return;
            }
            if (!this.b()) {
                new Object[1][0] = string;
                this.a(this.a, string);
                return;
            }
            new Object[1][0] = string;
            return;
        }
    }

    protected final void a(Context context) {
        this.b.b(context, 3000);
    }

    protected final void a(String string) {
        String string2 = this.b.b(this.a);
        if (string2.length() == 0) {
            this.e(string);
            return;
        }
        String string3 = this.b.a(this.a);
        if (!string.equals((Object)string3)) {
            Object[] arrobject = new Object[]{string3, string, string2};
            this.e(string);
            return;
        }
        int n2 = this.b.d(this.a);
        int n3 = ae.a(this.a);
        if (n2 != Integer.MIN_VALUE && n2 != n3) {
            Object[] arrobject = new Object[]{n2, n3, string2};
            this.e(string);
            return;
        }
        if (this.b.c(this.a)) {
            new Object[1][0] = string2;
            this.e(string);
            return;
        }
        if (!this.b()) {
            Object[] arrobject = new Object[]{string, string2};
            this.a(this.a, string2);
            return;
        }
        Object[] arrobject = new Object[]{string, string2};
    }

    public final boolean a() {
        String string = this.b.a(this.a);
        if (!ct.c(string)) {
            this.a(string);
            return true;
        }
        return false;
    }

    public final boolean a(Intent intent) {
        String string = intent.getAction();
        if ("com.google.android.c2dm.intent.REGISTRATION".equals((Object)string)) {
            String string2 = intent.getStringExtra("registration_id");
            String string3 = intent.getStringExtra("unregistered");
            String string4 = intent.getStringExtra("error");
            if (string2 != null) {
                if (string2.length() > 0) {
                    if (string2.startsWith("|")) {
                        return false;
                    }
                    this.f(string2);
                    return false;
                }
                if (string3 == null && string4 == null && !this.c) {
                    this.c = true;
                    this.a();
                    return true;
                }
            }
            if (string3 != null) {
                String string5 = this.b.b(this.a);
                this.a(this.a);
                this.b.b(this.a, false);
                this.b.b(this.a, "");
                this.b.a(this.a, true);
                this.b(string5);
                return false;
            }
            if (string4 != null) {
                boolean bl;
                if ("SERVICE_NOT_AVAILABLE".equals((Object)string4)) {
                    bl = this.c(string4);
                } else {
                    if (!this.c) {
                        this.c(string4);
                        this.c = true;
                        this.a();
                        return true;
                    }
                    bl = this.d(string4);
                }
                if (bl) {
                    int n2 = this.b.g(this.a);
                    new Object[1][0] = n2;
                    Intent intent2 = new Intent("com.google.android.gcm.intent.RETRY");
                    intent2.setPackage(this.a.getPackageName());
                    PendingIntent pendingIntent = PendingIntent.getBroadcast((Context)this.a, (int)0, (Intent)intent2, (int)0);
                    ((AlarmManager)this.a.getSystemService("alarm")).set(3, SystemClock.elapsedRealtime() + (long)n2, pendingIntent);
                    if (n2 < 3600000) {
                        this.b.b(this.a, n2 * 2);
                    }
                }
                return true;
            }
            return false;
        }
        if ("com.google.android.c2dm.intent.RECEIVE".equals((Object)string)) {
            String string6 = intent.getStringExtra("message_type");
            if (string6 != null) {
                if ("deleted_messages".equals((Object)string6)) {
                    String string7 = intent.getStringExtra("total_deleted");
                    if (string7 != null) {
                        try {
                            int n3 = Integer.parseInt((String)string7);
                            new Object[1][0] = n3;
                            this.a(n3);
                            return false;
                        }
                        catch (NumberFormatException numberFormatException) {
                            new Object[1][0] = string7;
                            return false;
                        }
                    }
                } else {
                    new Object[1][0] = string6;
                }
                return false;
            }
            return this.a(this.a, intent);
        }
        if ("com.google.android.gcm.intent.RETRY".equals((Object)string)) {
            String string8 = intent.getPackage();
            if (string8 != null && string8.equals((Object)this.a.getPackageName())) {
                this.a();
                return true;
            }
            new Object[1][0] = string8;
            return false;
        }
        new Object[1][0] = string;
        return false;
    }
}

