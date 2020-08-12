/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  android.content.pm.PackageManager
 *  android.content.pm.ResolveInfo
 *  android.content.pm.ServiceInfo
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.RemoteException
 *  com.a.a.a.a.a
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.List
 *  java.util.concurrent.CountDownLatch
 *  java.util.concurrent.TimeUnit
 */
package com.startapp.android.publish.adsCommon.i;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.a.a.a.a.a;
import com.startapp.android.publish.adsCommon.i.b;
import com.startapp.common.a.g;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class a {
    private static CountDownLatch a;
    private static b b;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static b a(Context context) {
        if (b != null) return b;
        try {
            a a2;
            a = new CountDownLatch(1);
            a2 = new a(context.getPackageName());
            Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
            intent.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
            List list = context.getPackageManager().queryIntentServices(intent, 0);
            if (list == null) return b;
            if (list.isEmpty()) return b;
            ResolveInfo resolveInfo = (ResolveInfo)list.get(0);
            if (resolveInfo.serviceInfo == null) return b;
            String string = resolveInfo.serviceInfo.packageName;
            String string2 = resolveInfo.serviceInfo.name;
            if (!"com.android.vending".equals((Object)string)) return b;
            if (string2 == null) return b;
            if (!a.b(context)) return b;
            boolean bl = context.bindService(new Intent(intent), (ServiceConnection)a2, 1);
            if (!bl) {
                g.a("PlayReferrer", 5, "failed to connect to referrer service");
                return b;
            }
            try {
                a.await(1L, TimeUnit.SECONDS);
            }
            catch (InterruptedException interruptedException) {}
            context.unbindService((ServiceConnection)a2);
            return b;
        }
        catch (Throwable throwable) {
            g.a("PlayReferrer", 5, "getReferrerDetails", throwable);
        }
        return b;
    }

    /*
     * Exception decompiling
     */
    private static boolean b(Context var0) {
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

    private static final class a
    implements ServiceConnection {
        private String a;

        private a(String string) {
            this.a = string;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            com.a.a.a.a.a a2 = a.a.a(iBinder);
            Bundle bundle = new Bundle();
            bundle.putString("package_name", this.a);
            try {
                b = new b(a2.a(bundle));
            }
            catch (RemoteException remoteException) {
                g.a("PlayReferrer", 5, "InstallReferrerServiceConnection.onServiceConnected", remoteException);
            }
            a.countDown();
        }

        public void onServiceDisconnected(ComponentName componentName) {
            g.a("PlayReferrer", 5, "InstallReferrerServiceConnection.onServiceDisconnected");
            a.countDown();
        }
    }

}

