/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.SystemClock
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 *  android.view.Window
 *  android.view.Window$Callback
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Thread
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.Map
 */
package com.tapjoy.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import com.tapjoy.TJContentActivity;
import com.tapjoy.TapjoyErrorMessage;
import com.tapjoy.TapjoyLog;
import com.tapjoy.internal.ct;
import com.tapjoy.internal.ep;
import com.tapjoy.internal.et;
import com.tapjoy.internal.ey;
import com.tapjoy.internal.ez;
import com.tapjoy.internal.fi;
import com.tapjoy.internal.fo;
import com.tapjoy.internal.fv;
import com.tapjoy.internal.fy;
import com.tapjoy.internal.gc;
import com.tapjoy.internal.gd;
import com.tapjoy.internal.gj;
import com.tapjoy.internal.gu;
import com.tapjoy.internal.ha;
import com.tapjoy.internal.hc;
import com.tapjoy.internal.hd;
import com.tapjoy.internal.hr;
import com.tapjoy.internal.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class fy
extends gj {
    private static final String h = "fy";
    private static fy i;
    final String a;
    final gu b;
    private final gc j;
    private boolean k;
    private boolean l;
    private long m;
    private Context n;
    private hr o;
    private Activity p;
    private gd q;
    private Handler r;
    private Runnable s;

    public fy(gc gc2, String string, gu gu2, Context context) {
        this.j = gc2;
        this.a = string;
        this.b = gu2;
        this.n = context;
    }

    public static void a() {
        fy fy2 = i;
        if (fy2 != null) {
            Runnable runnable = new Runnable(fy2){
                final /* synthetic */ fy a;
                {
                    this.a = fy2;
                }

                public final void run() {
                    fy.a(this.a);
                }
            };
            Looper looper = Looper.getMainLooper();
            boolean bl = looper != null && looper.getThread() == Thread.currentThread();
            if (bl) {
                runnable.run();
                return;
            }
            x.a().post(runnable);
        }
    }

    private void a(final Activity activity, final gd gd2, ez ez2) {
        if (this.k) {
            TapjoyLog.e(h, new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, "Content is already displayed"));
            return;
        }
        this.k = true;
        this.l = true;
        i = this;
        this.g = ez2.a;
        this.o = new hr((Context)activity, this.b, new hr.a(){

            @Override
            public final void a() {
                fy.a(fy.this);
            }

            @Override
            public final void a(hc hc2) {
                ey ey2;
                if (fy.this.g instanceof ey && (ey2 = (ey)fy.this.g) != null && ey2.c != null) {
                    ey2.c.a();
                }
                fy.this.j.a(fy.this.b.b, hc2.k);
                if (!ct.c(hc2.h)) {
                    fy.this.e.a((Context)activity, hc2.h, ct.b(hc2.i));
                    fy.this.d = true;
                } else if (!ct.c(hc2.g)) {
                    gj.a((Context)activity, hc2.g);
                }
                gd2.a(fy.this.a, null);
                if (hc2.j) {
                    fy.a(fy.this);
                }
            }
        });
        Window window = activity.getWindow();
        hr hr2 = this.o;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
        Window.Callback callback = window.getCallback();
        window.setCallback(null);
        window.addContentView((View)hr2, (ViewGroup.LayoutParams)layoutParams);
        window.setCallback(callback);
        this.m = SystemClock.elapsedRealtime();
        this.j.a(this.b.b);
        ez2.a();
        et et2 = this.g;
        if (et2 != null) {
            et2.b();
        }
        gd2.c(this.a);
        if (this.b.c > 0.0f) {
            this.r = new Handler(Looper.getMainLooper());
            this.s = new Runnable(this){
                final /* synthetic */ fy a;
                {
                    this.a = fy2;
                }

                public final void run() {
                    fy.a(this.a);
                }
            };
            this.r.postDelayed(this.s, (long)(1000.0f * this.b.c));
        }
    }

    static /* synthetic */ void a(fy fy2) {
        if (fy2.l) {
            ViewGroup viewGroup;
            gd gd2;
            fy2.l = false;
            Handler handler = fy2.r;
            if (handler != null) {
                handler.removeCallbacks(fy2.s);
                fy2.s = null;
                fy2.r = null;
            }
            if (i == fy2) {
                i = null;
            }
            fy2.j.a(fy2.b.b, SystemClock.elapsedRealtime() - fy2.m);
            if (!fy2.d && (gd2 = fy2.q) != null) {
                gd2.a(fy2.a, fy2.f, null);
                fy2.q = null;
            }
            if ((viewGroup = (ViewGroup)fy2.o.getParent()) != null) {
                viewGroup.removeView((View)fy2.o);
            }
            fy2.o = null;
            Activity activity = fy2.p;
            if (activity instanceof TJContentActivity) {
                activity.finish();
            }
            fy2.p = null;
        }
    }

    /*
     * Exception decompiling
     */
    @Override
    public final void a(gd var1, ez var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl28.1 : ALOAD_0 : trying to set 0 previously set to 1
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

    @Override
    public final void b() {
        Iterator iterator = this.b.a.iterator();
        while (iterator.hasNext()) {
            for (hc hc2 : ((hd)iterator.next()).c) {
                if (hc2.l != null) {
                    hc2.l.b();
                }
                if (hc2.m == null) continue;
                hc2.m.b();
            }
        }
    }

    @Override
    public final boolean c() {
        Iterator iterator = this.b.a.iterator();
        boolean bl = true;
        while (iterator.hasNext()) {
            block2 : {
                for (hc hc2 : ((hd)iterator.next()).c) {
                    if ((hc2.l == null || hc2.l.a()) && (hc2.m == null || hc2.m.a())) continue;
                    bl = false;
                    break block2;
                }
                bl = true;
            }
            if (bl) continue;
            return false;
        }
        return bl;
    }

}

