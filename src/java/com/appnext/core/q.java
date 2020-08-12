/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.net.ConnectivityManager
 *  android.net.NetworkInfo
 *  android.net.Uri
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Process
 *  com.appnext.core.AppnextAd
 *  com.appnext.core.h
 *  com.appnext.core.q$1$1
 *  com.appnext.core.q$3
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.lang.Throwable
 */
package com.appnext.core;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.appnext.core.Ad;
import com.appnext.core.AppnextAd;
import com.appnext.core.e;
import com.appnext.core.f;
import com.appnext.core.h;
import com.appnext.core.p;
import com.appnext.core.q;
import java.io.IOException;

public final class q {
    private static final String y = "error_no_market";
    private String banner = "";
    private e click;
    private Context context;
    private String gm = "";
    private String guid = "";
    private h hJ;
    private a hK;
    private e.a hL = new 3(this);

    public q(Context context, a a2) {
        this.context = context;
        this.click = e.k(context);
        this.hK = a2;
    }

    static /* synthetic */ h a(q q2, h h2) {
        q2.hJ = h2;
        return h2;
    }

    static /* synthetic */ String a(q q2, String string2) {
        q2.gm = string2;
        return string2;
    }

    static /* synthetic */ String b(q q2, String string2) {
        q2.guid = string2;
        return string2;
    }

    static /* synthetic */ String c(q q2) {
        return q2.gm;
    }

    static /* synthetic */ String c(q q2, String string2) {
        q2.banner = string2;
        return string2;
    }

    static /* synthetic */ void d(q q2, String string2) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse((String)string2));
        intent.addFlags(268435456);
        q2.context.startActivity(intent);
    }

    static /* synthetic */ Context f(q q2) {
        return q2.context;
    }

    static /* synthetic */ a g(q q2) {
        return q2.hK;
    }

    static /* synthetic */ h h(q q2) {
        return q2.hJ;
    }

    private void openLink(String string2) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse((String)string2));
        intent.addFlags(268435456);
        this.context.startActivity(intent);
    }

    public final void a(AppnextAd appnextAd, String string2, e.a a2) {
        e e2 = this.click;
        if (e2 == null) {
            return;
        }
        new Thread(new Runnable(){

            public final void run() {
                try {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(appnextAd.getImpressionURL());
                    stringBuilder.append("&device=");
                    stringBuilder.append(f.bc());
                    stringBuilder.append("&ox=0");
                    f.a(stringBuilder.toString(), null);
                }
                catch (Throwable throwable) {}
            }
        }).start();
    }

    public final void a(final AppnextAd appnextAd, final String string2, final String string3, final e.a a2) {
        Runnable runnable = new Runnable(){

            public final void run() {
                if (!q.this.bm()) {
                    new Handler(Looper.getMainLooper()).post(new Runnable(){

                        public final void run() {
                            e.a a2 = q.this.hL;
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append(string2);
                            stringBuilder.append("&device=");
                            stringBuilder.append(f.bc());
                            a2.error(stringBuilder.toString());
                            if (a2 != null) {
                                e.a a3 = a2;
                                StringBuilder stringBuilder2 = new StringBuilder();
                                stringBuilder2.append(string2);
                                stringBuilder2.append("&device=");
                                stringBuilder2.append(f.bc());
                                a3.error(stringBuilder2.toString());
                            }
                        }
                    });
                    return;
                }
                if (appnextAd == null) {
                    return;
                }
                new Handler(Looper.getMainLooper()).post(new Runnable(){

                    /*
                     * Exception decompiling
                     */
                    public final void run() {
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
                        // org.benf.cfr.reader.entities.d.c(ClassFile.java:773)
                        // org.benf.cfr.reader.entities.d.e(ClassFile.java:870)
                        // org.benf.cfr.reader.entities.d.c(ClassFile.java:773)
                        // org.benf.cfr.reader.entities.d.e(ClassFile.java:870)
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

                });
            }

        };
        new Thread(runnable).start();
    }

    public final void b(final AppnextAd appnextAd, final String string2, final e.a a2) {
        if (this.click == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable(){

            public final void run() {
                try {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(string2);
                    stringBuilder.append("&device=");
                    stringBuilder.append(f.bc());
                    stringBuilder.append("&ox=0");
                    String string22 = stringBuilder.toString();
                    q.this.click.a(appnextAd.getAppURL(), appnextAd.getMarketUrl(), string22, appnextAd.getBannerID(), (e.a)new 1(this));
                }
                catch (Throwable throwable) {}
            }
        });
    }

    public final void b(String string2, String string3, String string4, String string5, String string6, String string7) {
        e e2 = this.click;
        if (e2 == null) {
            return;
        }
        Runnable runnable = new Runnable(){

            public final void run() {
                try {
                    java.util.HashMap hashMap = new java.util.HashMap();
                    hashMap.put((Object)"guid", (Object)string2);
                    hashMap.put((Object)"bannerId", (Object)string3);
                    hashMap.put((Object)"placementId", (Object)string4);
                    hashMap.put((Object)"vid", (Object)string5);
                    hashMap.put((Object)"url", (Object)string6);
                    StringBuilder stringBuilder = new StringBuilder("https://admin.appnext.com/AdminService.asmx/");
                    stringBuilder.append(string7);
                    f.a(stringBuilder.toString(), (java.util.HashMap<String, String>)hashMap);
                }
                catch (Throwable throwable) {}
            }
        };
        new Thread(runnable).start();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    protected final boolean bm() {
        NetworkInfo networkInfo;
        try {
            if (this.context.checkPermission("android.permission.ACCESS_NETWORK_STATE", Process.myPid(), Process.myUid()) != 0) {
                f.a("http://www.appnext.com/myid.html", null);
                return true;
            }
            networkInfo = ((ConnectivityManager)this.context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (networkInfo == null) throw new IOException();
        }
        catch (Throwable throwable) {
            return false;
        }
        if (networkInfo.isConnected()) return true;
        throw new IOException();
    }

    public final void destroy() {
        try {
            if (this.hJ != null) {
                this.hJ.a(this.context);
            }
            this.hJ = null;
        }
        catch (Throwable throwable) {}
        this.context = null;
        if (this.click != null) {
            this.click = null;
        }
    }

    /*
     * Exception decompiling
     */
    public final void e(AppnextAd var1) {
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

    public static interface a {
        public Ad e();

        public AppnextAd f();

        public p g();

        public void report(String var1);
    }

}

