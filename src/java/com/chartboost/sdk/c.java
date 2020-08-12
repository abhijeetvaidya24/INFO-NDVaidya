/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.app.Activity
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.content.ActivityNotFoundException
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.Handler
 *  android.view.Window
 *  android.view.WindowManager
 *  android.view.WindowManager$LayoutParams
 *  com.chartboost.sdk.Tracking.a
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.HashSet
 */
package com.chartboost.sdk;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import com.chartboost.sdk.CBImpressionActivity;
import com.chartboost.sdk.Chartboost;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Libraries.j;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.c;
import com.chartboost.sdk.d;
import com.chartboost.sdk.h;
import com.chartboost.sdk.i;
import com.chartboost.sdk.impl.ai;
import com.chartboost.sdk.impl.aq;
import com.chartboost.sdk.impl.bc;
import com.chartboost.sdk.impl.s;
import java.util.HashSet;

public class c {
    final h a;
    final Handler b;
    public final d c;
    j d;
    CBImpressionActivity e = null;
    com.chartboost.sdk.Model.c f = null;
    Runnable g;
    final Application.ActivityLifecycleCallbacks h;
    private final ai i;
    private final com.chartboost.sdk.Tracking.a j;
    private boolean k = false;
    private final HashSet<Integer> l = new HashSet();
    private j m;

    public c(Activity activity, ai ai2, h h2, com.chartboost.sdk.Tracking.a a2, Handler handler, d d2) {
        this.i = ai2;
        this.a = h2;
        this.j = a2;
        this.b = handler;
        this.c = d2;
        this.d = this.a(activity);
        aq.a("CBUIManager.assignHostActivityRef", (Object)this.d);
        this.g = new Runnable(){
            private final int b;
            private final int c;
            private final int d;
            {
                com.chartboost.sdk.a a2 = this.a();
                CBImpressionActivity cBImpressionActivity = c.this.e;
                int n2 = -1;
                int n3 = cBImpressionActivity == null ? -1 : c.this.e.hashCode();
                this.b = n3;
                int n4 = c.this.d == null ? -1 : c.this.d.hashCode();
                this.c = n4;
                if (a2 != null) {
                    n2 = a2.hashCode();
                }
                this.d = n2;
            }

            private com.chartboost.sdk.a a() {
                return i.c;
            }

            public void run() {
                aq.a("ClearMemoryRunnable.run");
                com.chartboost.sdk.a a2 = this.a();
                if (c.this.d != null && c.this.d.hashCode() == this.c) {
                    c.this.d = null;
                    aq.a("CBUIManager.clearHostActivityRef");
                }
                if (a2 != null && a2.hashCode() == this.d) {
                    i.c = null;
                    aq.a("SdkSettings.clearDelegate");
                }
            }
        };
        if (s.a().a(14)) {
            this.h = new Application.ActivityLifecycleCallbacks(){

                public void onActivityCreated(Activity activity, Bundle bundle) {
                    aq.a("CBUIManager.ActivityCallbackListener.onActivityCreated", (Object)activity);
                    CBLogging.a("CBUIManager", "######## onActivityCreated callback called");
                    if (!(activity instanceof CBImpressionActivity)) {
                        c.this.b(activity);
                    }
                }

                public void onActivityDestroyed(Activity activity) {
                    aq.a("CBUIManager.ActivityCallbackListener.onActivityDestroyed", (Object)activity);
                    if (!(activity instanceof CBImpressionActivity)) {
                        CBLogging.a("CBUIManager", "######## onActivityDestroyed callback called from developer side");
                        c.this.j(activity);
                        return;
                    }
                    CBLogging.a("CBUIManager", "######## onActivityDestroyed callback called from CBImpressionactivity");
                    c.this.k(activity);
                }

                public void onActivityPaused(Activity activity) {
                    aq.a("CBUIManager.ActivityCallbackListener.onActivityPaused", (Object)activity);
                    if (!(activity instanceof CBImpressionActivity)) {
                        CBLogging.a("CBUIManager", "######## onActivityPaused callback called from developer side");
                        c.this.g(activity);
                        return;
                    }
                    CBLogging.a("CBUIManager", "######## onActivityPaused callback called from CBImpressionactivity");
                    c.this.a(activity);
                    c.this.i();
                }

                public void onActivityResumed(Activity activity) {
                    aq.a("CBUIManager.ActivityCallbackListener.onActivityResumed", (Object)activity);
                    if (!(activity instanceof CBImpressionActivity)) {
                        CBLogging.a("CBUIManager", "######## onActivityResumed callback called from developer side");
                        c.this.f(activity);
                        return;
                    }
                    CBLogging.a("CBUIManager", "######## onActivityResumed callback called from CBImpressionactivity");
                    c.this.a(activity);
                    c.this.h();
                }

                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                }

                public void onActivityStarted(Activity activity) {
                    aq.a("CBUIManager.ActivityCallbackListener.onActivityStarted", (Object)activity);
                    if (!(activity instanceof CBImpressionActivity)) {
                        CBLogging.a("CBUIManager", "######## onActivityStarted callback called from developer side");
                        c.this.d(activity);
                        return;
                    }
                    CBLogging.a("CBUIManager", "######## onActivityStarted callback called from CBImpressionactivity");
                    c.this.e(activity);
                }

                public void onActivityStopped(Activity activity) {
                    aq.a("CBUIManager.ActivityCallbackListener.onActivityStopped", (Object)activity);
                    if (!(activity instanceof CBImpressionActivity)) {
                        CBLogging.a("CBUIManager", "######## onActivityStopped callback called from developer side");
                        c.this.h(activity);
                        return;
                    }
                    CBLogging.a("CBUIManager", "######## onActivityStopped callback called from CBImpressionactivity");
                    c.this.i(activity);
                }
            };
            return;
        }
        this.h = null;
    }

    private void a(int n2, boolean bl) {
        if (bl) {
            this.l.add((Object)n2);
            return;
        }
        this.l.remove((Object)n2);
    }

    private void b(j j2, boolean bl) {
    }

    private boolean c(j j2) {
        if (j2 == null) {
            return this.e == null;
        }
        return j2.a(this.e);
    }

    private boolean l(Activity activity) {
        return this.e == activity;
    }

    private boolean m() {
        aq.a("CBUIManager.closeImpressionImpl");
        com.chartboost.sdk.Model.c c2 = this.d();
        if (c2 != null && c2.l == 2) {
            if (c2.q()) {
                return true;
            }
            h.b(new Runnable(7){
                public final int a;
                Activity b = null;
                boolean c = false;
                public com.chartboost.sdk.Model.c d = null;
                {
                    this.a = n2;
                }

                /*
                 * Exception decompiling
                 */
                public void run() {
                    // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                    // org.benf.cfr.reader.util.ConfusedCFRException: Extractable last case doesn't follow previous
                    // org.benf.cfr.reader.b.a.a.b.as.a(SwitchReplacer.java:478)
                    // org.benf.cfr.reader.b.a.a.b.as.a(SwitchReplacer.java:328)
                    // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:462)
                    // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
                    // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
                    // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
                    // org.benf.cfr.reader.entities.g.p(Method.java:396)
                    // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
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
            return true;
        }
        return false;
    }

    public Activity a() {
        j j2 = this.d;
        if (j2 != null) {
            return (Activity)j2.get();
        }
        return null;
    }

    j a(Activity activity) {
        j j2 = this.m;
        if (j2 == null || j2.a != activity.hashCode()) {
            this.m = new j(activity);
        }
        return this.m;
    }

    public void a(Activity activity, com.chartboost.sdk.Model.c c2) {
        Intent intent = new Intent((Context)activity, CBImpressionActivity.class);
        boolean bl = (1024 & activity.getWindow().getAttributes().flags) != 0;
        boolean bl2 = (2048 & activity.getWindow().getAttributes().flags) != 0;
        boolean bl3 = false;
        if (bl) {
            bl3 = false;
            if (!bl2) {
                bl3 = true;
            }
        }
        intent.putExtra("paramFullscreen", bl3);
        intent.putExtra("isChartboost", true);
        try {
            activity.startActivity(intent);
            this.k = true;
            return;
        }
        catch (ActivityNotFoundException activityNotFoundException) {
            CBLogging.b("CBUIManager", "Please add CBImpressionActivity in AndroidManifest.xml following README.md instructions.");
            this.f = null;
            c2.a(CBError.CBImpressionError.ACTIVITY_MISSING_IN_MANIFEST);
            return;
        }
    }

    void a(Activity activity, boolean bl) {
        if (activity == null) {
            return;
        }
        this.a(activity.hashCode(), bl);
    }

    void a(CBImpressionActivity cBImpressionActivity) {
        aq.a("CBUIManager.setImpressionActivity", (Object)cBImpressionActivity);
        if (this.e == null) {
            i.m = cBImpressionActivity.getApplicationContext();
            this.e = cBImpressionActivity;
        }
        this.b.removeCallbacks(this.g);
    }

    void a(j j2, boolean bl) {
        if (j2 == null) {
            return;
        }
        this.a(j2.a, bl);
    }

    public void a(com.chartboost.sdk.Model.c c2) {
        aq.a("CBUIManager.queueDisplayView", c2);
        if (this.e()) {
            c2.a(CBError.CBImpressionError.IMPRESSION_ALREADY_VISIBLE);
            return;
        }
        if (this.e != null) {
            this.c.a(c2);
            return;
        }
        if (!this.g()) {
            c2.a(CBError.CBImpressionError.NO_HOST_ACTIVITY);
            return;
        }
        Activity activity = this.a();
        if (activity == null) {
            CBLogging.b("CBUIManager", "Failed to display impression as the host activity reference has been lost!");
            c2.a(CBError.CBImpressionError.NO_HOST_ACTIVITY);
            return;
        }
        com.chartboost.sdk.Model.c c3 = this.f;
        if (c3 != null && c3 != c2) {
            c2.a(CBError.CBImpressionError.IMPRESSION_ALREADY_VISIBLE);
            return;
        }
        this.f = c2;
        if (i.c != null) {
            if (c2.n != 1 && c2.n != 2) {
                if (c2.n == 0) {
                    i.c.willDisplayInterstitial(c2.m);
                }
            } else {
                i.c.willDisplayVideo(c2.m);
            }
        }
        if (i.d != null) {
            Runnable runnable = new /* invalid duplicate definition of identical inner class */;
            runnable.b = activity;
            runnable.d = c2;
            this.b.postDelayed(runnable, (long)1);
            return;
        }
        this.a(activity, c2);
    }

    boolean a(j j2) {
        if (j2 == null) {
            return false;
        }
        return this.l.contains((Object)j2.a);
    }

    public Activity b() {
        return this.e;
    }

    void b(Activity activity) {
        aq.a("CBUIManager.onCreateCallback", (Object)activity);
        if (com.chartboost.sdk.b.b()) {
            if (!com.chartboost.sdk.b.a(activity)) {
                return;
            }
            Runnable runnable = new /* invalid duplicate definition of identical inner class */;
            runnable.b = activity;
            h.b(runnable);
        }
    }

    void b(j j2) {
        aq.a("CBUIManager.onStop", (Object)j2);
        if (!(j2.get() instanceof CBImpressionActivity)) {
            this.a(j2, false);
        }
        this.a.c();
    }

    public void b(com.chartboost.sdk.Model.c c2) {
        d d2;
        if (c2.l == 2) {
            d d3 = this.c();
            if (d3 != null) {
                d3.b(c2);
            }
        } else if (c2.p.b == 1 && c2.l == 1 && (d2 = this.c()) != null) {
            d2.d(c2);
        }
        if (c2.v()) {
            this.j.d(c2.a.a(c2.p.b), c2.m, c2.o());
            return;
        }
        this.j.e(c2.a.a(c2.p.b), c2.m, c2.o());
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    boolean b(Activity activity, com.chartboost.sdk.Model.c c2) {
        int n2;
        if (c2 == null || (n2 = c2.l) == 0) return true;
        if (n2 != 1) {
            if (n2 != 2) {
                if (n2 != 3) {
                    return true;
                }
            } else {
                if (c2.g()) return true;
                if (i.d != null && i.d.doesWrapperUseCustomBackgroundingBehavior() && !(activity instanceof CBImpressionActivity)) {
                    return false;
                }
                d d2 = this.c();
                if (d2 == null) return true;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Error onActivityStart ");
                stringBuilder.append(c2.l);
                CBLogging.b("CBUIManager", stringBuilder.toString());
                d2.d(c2);
                return true;
            }
        }
        this.a(c2);
        return true;
    }

    public d c() {
        if (this.b() == null) {
            return null;
        }
        return this.c;
    }

    void c(Activity activity) {
        aq.a("CBUIManager.onCreateImpl", (Object)activity);
        j j2 = this.d;
        if (j2 != null && !j2.a(activity) && this.g()) {
            this.b(this.d);
            this.a(this.d, false);
        }
        this.b.removeCallbacks(this.g);
        this.d = this.a(activity);
        aq.a("CBUIManager.assignHostActivityRef", (Object)this.d);
    }

    com.chartboost.sdk.Model.c d() {
        d d2 = this.c();
        bc bc2 = d2 == null ? null : d2.a();
        if (bc2 != null) {
            if (!bc2.f()) {
                return null;
            }
            return bc2.e();
        }
        return null;
    }

    void d(Activity activity) {
        aq.a("CBUIManager.onStartCallback", (Object)activity);
        if (com.chartboost.sdk.b.b()) {
            if (!com.chartboost.sdk.b.a(activity)) {
                return;
            }
            Runnable runnable = new /* invalid duplicate definition of identical inner class */;
            runnable.b = activity;
            h.b(runnable);
        }
    }

    void e(Activity activity) {
        aq.a("CBUIManager.onStartImpl", (Object)activity);
        i.m = activity.getApplicationContext();
        boolean bl = activity instanceof CBImpressionActivity;
        if (!bl) {
            this.d = this.a(activity);
            aq.a("CBUIManager.assignHostActivityRef", (Object)this.d);
            this.a(this.d, true);
        } else {
            this.a((CBImpressionActivity)activity);
        }
        this.b.removeCallbacks(this.g);
        boolean bl2 = i.d != null && i.d.doesWrapperUseCustomBackgroundingBehavior();
        if (activity != null) {
            com.chartboost.sdk.Model.c c2;
            if (!bl2 && !this.l(activity)) {
                return;
            }
            this.b(this.a(activity), true);
            if (bl) {
                this.k = false;
            }
            if (this.b(activity, this.f)) {
                this.f = null;
            }
            if ((c2 = this.d()) != null) {
                c2.s();
            }
        }
    }

    public boolean e() {
        return this.d() != null;
    }

    void f() {
        aq.a("CBUIManager.clearImpressionActivity");
        this.e = null;
    }

    void f(Activity activity) {
        aq.a("CBUIManager.onResumeCallback", (Object)activity);
        if (com.chartboost.sdk.b.b()) {
            if (!com.chartboost.sdk.b.a(activity)) {
                return;
            }
            this.a.e();
            Runnable runnable = new /* invalid duplicate definition of identical inner class */;
            runnable.b = activity;
            h.b(runnable);
        }
    }

    void g(Activity activity) {
        aq.a("CBUIManager.onPauseCallback", (Object)activity);
        if (com.chartboost.sdk.b.b()) {
            if (!com.chartboost.sdk.b.a(activity)) {
                return;
            }
            Runnable runnable = new /* invalid duplicate definition of identical inner class */;
            runnable.b = activity;
            h.b(runnable);
        }
    }

    boolean g() {
        return this.a(this.d);
    }

    void h() {
        aq.a("CBUIManager.onResumeImpl", null);
        this.i.b(i.m);
        com.chartboost.sdk.Model.c c2 = this.d();
        if (CBUtility.a(Chartboost.CBFramework.CBFrameworkUnity)) {
            this.a.b();
        }
        if (c2 != null) {
            c2.r();
        }
    }

    void h(Activity activity) {
        aq.a("CBUIManager.onStopCallback", (Object)activity);
        if (com.chartboost.sdk.b.b()) {
            if (!com.chartboost.sdk.b.a(activity)) {
                return;
            }
            Runnable runnable = new /* invalid duplicate definition of identical inner class */;
            runnable.b = activity;
            h.b(runnable);
        }
    }

    void i() {
        aq.a("CBUIManager.onPauseImpl", null);
        com.chartboost.sdk.Model.c c2 = this.d();
        if (c2 != null) {
            c2.t();
        }
        this.i.c(i.m);
    }

    void i(Activity activity) {
        j j2 = this.a(activity);
        aq.a("CBUIManager.onStopImpl", (Object)j2);
        com.chartboost.sdk.Model.c c2 = this.d();
        if (c2 != null && c2.p.b == 0) {
            d d2 = this.c();
            if (this.c(j2) && d2 != null) {
                d2.c(c2);
                this.f = c2;
                this.b(j2, false);
            }
            if (!(j2.get() instanceof CBImpressionActivity)) {
                this.a(j2, false);
            }
        }
    }

    void j(Activity activity) {
        aq.a("CBUIManager.onDestroyCallback", (Object)activity);
        if (com.chartboost.sdk.b.b()) {
            if (!com.chartboost.sdk.b.a(activity)) {
                return;
            }
            Runnable runnable = new /* invalid duplicate definition of identical inner class */;
            runnable.b = activity;
            h.b(runnable);
        }
    }

    boolean j() {
        aq.a("CBUIManager.onBackPressedCallback");
        if (!com.chartboost.sdk.b.b()) {
            return false;
        }
        if (this.d == null) {
            CBLogging.b("CBUIManager", "The Chartboost methods onCreate(), onStart(), onStop(), and onDestroy() must be called in the corresponding methods of your activity in order for Chartboost to function properly.");
            return false;
        }
        if (this.k) {
            this.k = false;
            this.k();
            return true;
        }
        return false;
    }

    void k(Activity activity) {
        com.chartboost.sdk.Model.c c2;
        aq.a("CBUIManager.onDestroyImpl", (Object)activity);
        this.b(this.a(activity), false);
        com.chartboost.sdk.Model.c c3 = this.d();
        if (c3 != null || activity != this.e || (c2 = this.f) == null) {
            c2 = c3;
        }
        d d2 = this.c();
        if (d2 != null && c2 != null) {
            d2.d(c2);
        }
        this.f = null;
    }

    boolean k() {
        aq.a("CBUIManager.onBackPressedImpl");
        return this.m();
    }

    boolean l() {
        com.chartboost.sdk.Model.c c2 = this.d();
        if (c2 == null) {
            return false;
        }
        c2.z = true;
        this.b(c2);
        return true;
    }

}

