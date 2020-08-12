/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.os.Handler
 *  android.view.View
 *  android.widget.RelativeLayout
 *  com.chartboost.sdk.Tracking.a
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.Collection
 *  java.util.IdentityHashMap
 *  java.util.Iterator
 *  java.util.Map
 *  org.json.JSONObject
 */
package com.chartboost.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Handler;
import android.view.View;
import android.widget.RelativeLayout;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.c;
import com.chartboost.sdk.d;
import com.chartboost.sdk.impl.aw;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public abstract class e {
    public final Handler a;
    public final c b;
    public boolean c = false;
    protected JSONObject d;
    public final com.chartboost.sdk.Model.c e;
    protected int f;
    public final Map<View, Runnable> g = new IdentityHashMap();
    protected boolean h = true;
    protected boolean i = true;
    private boolean j;
    private a k;

    public e(com.chartboost.sdk.Model.c c2, Handler handler, c c3) {
        this.a = handler;
        this.b = c3;
        this.e = c2;
        this.k = null;
        this.f = CBUtility.a();
        this.j = false;
    }

    /*
     * Exception decompiling
     */
    public static int a(String var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl27 : ALOAD_0 : trying to set 0 previously set to 1
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

    public static boolean a(Context context) {
        return (15 & context.getResources().getConfiguration().screenLayout) >= 4;
    }

    public int a() {
        return this.f;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(View view, Runnable runnable, long l2) {
        Map<View, Runnable> map;
        Map<View, Runnable> map2 = map = this.g;
        synchronized (map2) {
            Runnable runnable2 = (Runnable)this.g.get((Object)view);
            if (runnable2 != null) {
                this.a.removeCallbacks(runnable2);
            }
            this.g.put((Object)view, (Object)runnable);
        }
        this.a.postDelayed(runnable, l2);
    }

    public void a(CBError.CBImpressionError cBImpressionError) {
        this.e.a(cBImpressionError);
    }

    public void a(boolean bl, View view) {
        this.a(bl, view, true);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(final boolean bl, final View view, boolean bl2) {
        int n2 = 8;
        if (bl && view.getVisibility() == 0 || !bl && view.getVisibility() == n2) {
            Map<View, Runnable> map;
            Map<View, Runnable> map2 = map = this.g;
            synchronized (map2) {
                if (!this.g.containsKey((Object)view)) {
                    return;
                }
            }
        }
        if (bl2) {
            Runnable runnable = new Runnable(){

                /*
                 * Enabled aggressive block sorting
                 * Enabled unnecessary exception pruning
                 * Enabled aggressive exception aggregation
                 */
                public void run() {
                    Map<View, Runnable> map;
                    if (!bl) {
                        view.setVisibility(8);
                        view.setClickable(false);
                    }
                    Map<View, Runnable> map2 = map = e.this.g;
                    synchronized (map2) {
                        e.this.g.remove((Object)view);
                        return;
                    }
                }
            };
            this.e.i.a.a(bl, view, 500L);
            this.a(view, runnable, 500L);
            return;
        }
        if (bl) {
            n2 = 0;
        }
        view.setVisibility(n2);
        view.setClickable(bl);
    }

    public boolean a(JSONObject jSONObject) {
        this.d = com.chartboost.sdk.Libraries.e.a(jSONObject, "assets");
        if (this.d == null) {
            this.d = new JSONObject();
            CBLogging.b("CBViewProtocol", "Media got from the response is null or empty");
            this.a(CBError.CBImpressionError.INVALID_RESPONSE);
            return false;
        }
        return true;
    }

    protected abstract a b(Context var1);

    public void b() {
        this.i();
    }

    public boolean b(JSONObject jSONObject) {
        return this.e.a(jSONObject);
    }

    public CBError.CBImpressionError c() {
        Activity activity = this.b.b();
        if (activity == null) {
            this.k = null;
            return CBError.CBImpressionError.NO_HOST_ACTIVITY;
        }
        if (!this.i && !this.h) {
            return CBError.CBImpressionError.WRONG_ORIENTATION;
        }
        if (this.k == null) {
            this.k = this.b((Context)activity);
        }
        if (this.e.p.b == 0) {
            if (this.k.a(activity)) {
                return null;
            }
            this.k = null;
            return CBError.CBImpressionError.ERROR_CREATING_VIEW;
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void d() {
        Map<View, Runnable> map;
        this.f();
        Map<View, Runnable> map2 = map = this.g;
        synchronized (map2) {
            Iterator iterator = this.g.values().iterator();
            do {
                if (!iterator.hasNext()) {
                    this.g.clear();
                    return;
                }
                Runnable runnable = (Runnable)iterator.next();
                this.a.removeCallbacks(runnable);
            } while (true);
        }
    }

    public a e() {
        return this.k;
    }

    public void f() {
        a a2 = this.k;
        if (a2 != null) {
            a2.b();
        }
        this.k = null;
    }

    public JSONObject g() {
        return this.d;
    }

    public void h() {
        if (this.j) {
            return;
        }
        this.j = true;
        this.e.c();
    }

    protected void i() {
        this.e.d();
    }

    public float j() {
        return 0.0f;
    }

    public float k() {
        return 0.0f;
    }

    public boolean l() {
        return false;
    }

    public void m() {
        a a2;
        if (this.c) {
            this.c = false;
        }
        if ((a2 = this.e()) != null && (a2.a == null || CBUtility.a() != a2.a)) {
            a2.a(false);
        }
    }

    public void n() {
        this.c = true;
    }

    public abstract class a
    extends RelativeLayout {
        Integer a;
        private boolean c;
        private int d;
        private int e;
        private int f;
        private int g;

        public a(Context context) {
            super(context);
            this.c = false;
            this.d = -1;
            this.e = -1;
            this.f = -1;
            this.g = -1;
            this.a = null;
            this.setFocusableInTouchMode(true);
            this.requestFocus();
        }

        private boolean b(int n2, int n3) {
            Integer n4;
            com.chartboost.sdk.Model.c c2 = e.this.e;
            int n5 = 1;
            if (c2 != null && e.this.e.p.b == n5) {
                return n5;
            }
            if (this.c) {
                return false;
            }
            int n6 = CBUtility.a();
            if (this.d == n2 && this.e == n3 && (n4 = this.a) != null && n4 == n6) {
                return n5;
            }
            this.c = n5;
            try {
                if (e.this.h && CBUtility.a(n6)) {
                    e.this.f = n6;
                } else if (e.this.i && CBUtility.b(n6)) {
                    e.this.f = n6;
                }
                this.a(n2, n3);
                this.post(new Runnable(){

                    public void run() {
                        a.this.requestLayout();
                    }
                });
                this.d = n2;
                this.e = n3;
                this.a = n6;
            }
            catch (Exception exception) {
                CBLogging.a("CBViewProtocol", "Exception raised while layouting Subviews", exception);
                com.chartboost.sdk.Tracking.a.a((Class)this.getClass(), (String)"tryLayout", (Exception)exception);
                n5 = 0;
            }
            this.c = false;
            return n5;
        }

        public final void a() {
            this.a(false);
        }

        protected abstract void a(int var1, int var2);

        public final void a(View view) {
            int n2 = 200;
            int n3 = this.getId();
            if (n2 == n3) {
                n2 = 201;
            }
            View view2 = this.findViewById(n2);
            while (view2 != null) {
                view2 = this.findViewById(++n2);
            }
            view.setId(n2);
            view.setSaveEnabled(false);
        }

        public final void a(boolean bl) {
            if (bl) {
                this.a = null;
            }
            this.a((Activity)this.getContext());
        }

        /*
         * Exception decompiling
         */
        public boolean a(Activity var1) {
            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
            // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl45 : ILOAD_2 : trying to set 1 previously set to 0
            // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
            // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
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

        public void b() {
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public void onDetachedFromWindow() {
            Map<View, Runnable> map;
            super.onDetachedFromWindow();
            Map<View, Runnable> map2 = map = e.this.g;
            synchronized (map2) {
                Iterator iterator = e.this.g.values().iterator();
                do {
                    if (!iterator.hasNext()) {
                        e.this.g.clear();
                        return;
                    }
                    Runnable runnable = (Runnable)iterator.next();
                    e.this.a.removeCallbacks(runnable);
                } while (true);
            }
        }

        protected void onSizeChanged(int n2, int n3, int n4, int n5) {
            super.onSizeChanged(n2, n3, n4, n5);
            this.f = n2;
            this.g = n3;
            if (this.d != -1 && this.e != -1 && e.this.e != null && e.this.e.p.b == 0) {
                this.a();
            }
        }

    }

}

