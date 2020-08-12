/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Handler
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 *  android.view.Window
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  com.chartboost.sdk.Tracking.a
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.concurrent.atomic.AtomicReference
 */
package com.chartboost.sdk;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import com.chartboost.sdk.CBImpressionActivity;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.Model.e;
import com.chartboost.sdk.Tracking.a;
import com.chartboost.sdk.c;
import com.chartboost.sdk.g;
import com.chartboost.sdk.impl.aw;
import com.chartboost.sdk.impl.ax;
import com.chartboost.sdk.impl.bc;
import com.chartboost.sdk.impl.c;
import com.chartboost.sdk.impl.l;
import com.chartboost.sdk.impl.s;
import java.util.concurrent.atomic.AtomicReference;

public class d {
    final aw a;
    bc b = null;
    private final l c;
    private final AtomicReference<e> d;
    private final Handler e;
    private int f = -1;

    public d(aw aw2, l l2, AtomicReference<e> atomicReference, Handler handler) {
        this.a = aw2;
        this.c = l2;
        this.d = atomicReference;
        this.e = handler;
    }

    private void e(com.chartboost.sdk.Model.c c2) {
        bc bc2 = this.b;
        if (bc2 != null && bc2.e() != c2) {
            CBLogging.b("CBViewController", "Impression already visible");
            c2.a(CBError.CBImpressionError.IMPRESSION_ALREADY_VISIBLE);
            return;
        }
        int n2 = c2.l;
        int n3 = 1;
        boolean bl = n2 != 2;
        c2.l = 2;
        Activity activity = c2.g.b();
        CBError.CBImpressionError cBImpressionError = activity == null ? CBError.CBImpressionError.NO_HOST_ACTIVITY : null;
        if (cBImpressionError == null) {
            cBImpressionError = c2.j();
        }
        if (cBImpressionError != null) {
            CBLogging.b("CBViewController", "Unable to create the view while trying th display the impression");
            c2.a(cBImpressionError);
            return;
        }
        if (this.b == null) {
            this.b = g.a().a(new bc((Context)activity, c2));
            activity.addContentView((View)this.b, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
        }
        CBUtility.a(activity, c2.p.b, (e)this.d.get());
        if (s.a().a(11) && this.f == -1 && (c2.n == n3 || c2.n == 2)) {
            this.f = activity.getWindow().getDecorView().getSystemUiVisibility();
            CBUtility.a(activity);
        }
        this.b.a();
        CBLogging.e("CBViewController", "Displaying the impression");
        c2.s = this.b;
        if (bl) {
            Integer n4;
            if (c2.p.b == 0) {
                this.b.c().a(this.a, c2.p);
            }
            if (c2.p.b == n3) {
                n3 = 6;
            }
            if ((n4 = aw.a(c2.p.o)) != null) {
                n3 = n4;
            }
            c2.m();
            com.chartboost.sdk.c c3 = c2.g;
            c3.getClass();
            Runnable runnable = new Runnable(12){
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
            };
            runnable.d = c2;
            this.a.a(n3, c2, runnable, this);
            this.c.a();
        }
    }

    public bc a() {
        return this.b;
    }

    void a(com.chartboost.sdk.Model.c c2) {
        if (c2.l != 0) {
            this.e(c2);
        }
    }

    void a(com.chartboost.sdk.Model.c c2, Activity activity) {
        com.chartboost.sdk.c c3 = c2.g;
        c3.getClass();
        Runnable runnable = new /* invalid duplicate definition of identical inner class */;
        runnable.d = c2;
        this.e.post(runnable);
        c2.l();
        CBUtility.b(activity, c2.p.b, (e)this.d.get());
        if (this.f != -1 && (c2.n == 1 || c2.n == 2)) {
            activity.getWindow().getDecorView().setSystemUiVisibility(this.f);
            this.f = -1;
        }
    }

    void a(com.chartboost.sdk.c c2) {
        CBLogging.e("CBViewController", "Attempting to close impression activity");
        Activity activity = c2.b();
        if (activity != null && activity instanceof CBImpressionActivity) {
            CBLogging.e("CBViewController", "Closing impression activity");
            c2.f();
            activity.finish();
        }
    }

    public void b(final com.chartboost.sdk.Model.c c2) {
        CBLogging.e("CBViewController", "Dismissing impression");
        Runnable runnable = new Runnable(c2.g.b()){
            final /* synthetic */ Activity b;
            {
                this.b = activity;
            }

            public void run() {
                Integer n2;
                com.chartboost.sdk.Model.c c22 = c2;
                c22.l = 4;
                int n3 = c22.p.b;
                int n4 = 1;
                if (n3 == n4) {
                    n4 = 6;
                }
                if ((n2 = aw.a(c2.p.o)) != null) {
                    n4 = n2;
                }
                com.chartboost.sdk.c c3 = c2.g;
                c3.getClass();
                Runnable runnable = new /* invalid duplicate definition of identical inner class */;
                runnable.d = c2;
                runnable.b = this.b;
                d.this.a.a(n4, c2, runnable);
            }
        };
        if (c2.t) {
            c2.a(runnable);
            return;
        }
        runnable.run();
    }

    void c(com.chartboost.sdk.Model.c c2) {
        CBLogging.e("CBViewController", "Removing impression silently");
        c2.i();
        try {
            ((ViewGroup)this.b.getParent()).removeView((View)this.b);
        }
        catch (Exception exception) {
            CBLogging.a("CBViewController", "Exception removing impression silently", exception);
            a.a((Class)this.getClass(), (String)"removeImpressionSilently", (Exception)exception);
        }
        this.b = null;
    }

    public void d(com.chartboost.sdk.Model.c c2) {
        CBLogging.e("CBViewController", "Removing impression");
        c2.l = 5;
        c2.h();
        this.b = null;
        this.c.b();
        Handler handler = this.e;
        c c3 = c2.a;
        c3.getClass();
        handler.post((Runnable)new c.a(c3, 3, c2.m, null));
        if (c2.v()) {
            Handler handler2 = this.e;
            c c4 = c2.a;
            c4.getClass();
            handler2.post((Runnable)new c.a(c4, 2, c2.m, null));
        }
        this.a(c2.g);
    }

}

