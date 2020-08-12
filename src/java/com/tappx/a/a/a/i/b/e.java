/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.ActivityInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.os.Bundle
 *  com.tappx.sdk.android.TrackInstallReceiver
 *  java.lang.Class
 *  java.lang.ClassNotFoundException
 *  java.lang.IllegalAccessException
 *  java.lang.InstantiationException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Set
 */
package com.tappx.a.a.a.i.b;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.tappx.a.a.a.c.a;
import com.tappx.a.a.a.i.b.c;
import com.tappx.sdk.android.TrackInstallReceiver;
import java.util.Set;

public class e {
    /*
     * Exception decompiling
     */
    private void b(Context var1, Intent var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
        // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
        // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
        // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
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

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void c(Context context, Intent intent) {
        try {
            ActivityInfo activityInfo = context.getPackageManager().getReceiverInfo(new ComponentName(context, TrackInstallReceiver.class.getName()), 128);
            if (activityInfo == null) {
                return;
            }
            Bundle bundle = activityInfo.metaData;
            if (bundle == null) {
                return;
            }
            Set set = bundle.keySet();
            if (set == null) {
                return;
            }
            for (String string2 : set) {
                if (string2 == null || string2.isEmpty()) continue;
                String string3 = bundle.getString(string2);
                try {
                    ((BroadcastReceiver)Class.forName((String)string3).newInstance()).onReceive(context, intent);
                }
                catch (ClassNotFoundException classNotFoundException) {
                    a.b(classNotFoundException.getMessage(), new Object[0]);
                }
                catch (IllegalAccessException illegalAccessException) {
                    a.b(illegalAccessException.getMessage(), new Object[0]);
                }
                catch (InstantiationException instantiationException) {
                    a.b(instantiationException.getMessage(), new Object[0]);
                }
            }
            return;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            a.b(nameNotFoundException.getMessage(), new Object[0]);
        }
    }

    public void a(Context context, Intent intent) {
        this.b(context, intent);
        com.tappx.a.a.a.e.a(context).i().a(intent);
        this.c(context, intent);
    }
}

