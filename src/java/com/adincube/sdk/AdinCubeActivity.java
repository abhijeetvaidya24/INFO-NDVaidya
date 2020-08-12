/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.view.View
 *  android.view.Window
 *  android.view.WindowManager
 *  android.view.WindowManager$LayoutParams
 *  com.adincube.sdk.h.a.c
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  org.json.JSONObject
 */
package com.adincube.sdk;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.adincube.sdk.AdinCubeActivity;
import com.adincube.sdk.b.a;
import com.adincube.sdk.g.b.b.b;
import com.adincube.sdk.g.e.a;
import com.adincube.sdk.h.a.c;
import com.adincube.sdk.h.a.e;
import com.adincube.sdk.h.d;
import com.adincube.sdk.mediation.w.f;
import com.adincube.sdk.util.ErrorReportingHelper;
import com.adincube.sdk.util.f.b;
import com.adincube.sdk.util.v;
import org.json.JSONObject;

public class AdinCubeActivity
extends Activity {
    private static EventListener a;
    private c b;
    private com.adincube.sdk.h.c.b c;
    private com.adincube.sdk.b.a d;
    private com.adincube.sdk.g.a e = null;
    private com.adincube.sdk.g.e.b f = null;
    private a g = null;
    private boolean h = false;
    private boolean i = false;
    private a.c j = new a.c(this){
        final /* synthetic */ AdinCubeActivity a;
        {
            this.a = adinCubeActivity;
        }

        public final void a(c c2, java.lang.Boolean bl) {
            if (!AdinCubeActivity.a(this.a)) {
                AdinCubeActivity.b(this.a);
                com.adincube.sdk.g.e.b b2 = AdinCubeActivity.c(this.a);
                com.adincube.sdk.j.g g2 = new com.adincube.sdk.j.g();
                g2.a = b2.a;
                g2.j = "RTB";
                g2.k = c2;
                g2.n = bl;
                g2.k();
            }
        }
    };
    private b.a k = new b.a(this){
        final /* synthetic */ AdinCubeActivity a;
        {
            this.a = adinCubeActivity;
        }

        public final void a(e e2) {
            if (AdinCubeActivity.a() != null) {
                AdinCubeActivity.a().onAdClicked();
            }
            com.adincube.sdk.g.e.b b2 = AdinCubeActivity.c(this.a);
            com.adincube.sdk.j.c c2 = new com.adincube.sdk.j.c();
            c2.a = b2.a;
            c2.j = "RTB";
            c2.k = e2;
            c2.k();
        }
    };
    private a.b l = new a.b(this){
        final /* synthetic */ AdinCubeActivity a;
        {
            this.a = adinCubeActivity;
        }

        public final void a() {
            if (AdinCubeActivity.a() != null) {
                AdinCubeActivity.a().onAdHidden();
            }
        }
    };
    private a.a m = new a.a(this){
        final /* synthetic */ AdinCubeActivity a;
        {
            this.a = adinCubeActivity;
        }

        public final void a(Throwable throwable) {
            if (AdinCubeActivity.a() != null) {
                AdinCubeActivity.a().onError();
            }
            ErrorReportingHelper.report("AdinCubeActivity.onError", (e)AdinCubeActivity.d(this.a), throwable);
            this.a.finish();
        }
    };

    static /* synthetic */ EventListener a() {
        return a;
    }

    static /* synthetic */ boolean a(AdinCubeActivity adinCubeActivity) {
        return adinCubeActivity.i;
    }

    static /* synthetic */ boolean b(AdinCubeActivity adinCubeActivity) {
        adinCubeActivity.i = true;
        return true;
    }

    static /* synthetic */ com.adincube.sdk.g.e.b c(AdinCubeActivity adinCubeActivity) {
        return adinCubeActivity.f;
    }

    static /* synthetic */ c d(AdinCubeActivity adinCubeActivity) {
        return adinCubeActivity.b;
    }

    public static void setEventListener(EventListener eventListener) {
        a = eventListener;
    }

    public void finish() {
        super.finish();
        a = null;
    }

    /*
     * Exception decompiling
     */
    public boolean hasHardwareAcceleration() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl27.1 : ICONST_0 : trying to set 1 previously set to 0
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

    public void onBackPressed() {
        try {
            if (!this.h) {
                this.h = this.d.d();
            }
            return;
        }
        catch (Throwable throwable) {
            ErrorReportingHelper.report("AdinCubeActivity.onBackPressed", (e)this.b, throwable);
            com.adincube.sdk.util.a.c("AdinCubeActivity.onBackPressed() Exception : ", new Object[]{throwable});
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @TargetApi(value=11)
    protected void onCreate(Bundle bundle) {
        boolean bl;
        boolean bl2;
        boolean bl3;
        block12 : {
            try {
                super.onCreate(bundle);
                com.adincube.sdk.util.f.a((Context)this);
                Bundle bundle2 = this.getIntent().getExtras();
                if (bundle2 != null && bundle2.containsKey("a") && bundle2.containsKey("at")) {
                    this.b = new c(new JSONObject(bundle2.getString("a")));
                    this.c = com.adincube.sdk.h.c.b.a(bundle2.getString("at"));
                    bl2 = true;
                    break block12;
                }
                com.adincube.sdk.util.a.c("invalid AdinCubeActivity intent.", new Object[0]);
                if (a != null) {
                    a.onError();
                }
            }
            catch (Throwable throwable) {
                ErrorReportingHelper.report("AdinCubeActivity.onCreate", (e)this.b, throwable);
                com.adincube.sdk.util.a.c("AdinCubeActivity.onCreate() Exception : ", new Object[]{throwable});
                this.finish();
                return;
            }
            bl2 = false;
        }
        if (!bl2) {
            this.finish();
            return;
        }
        v v2 = v.a();
        this.e = com.adincube.sdk.g.a.a();
        this.f = new com.adincube.sdk.g.e.b(this.c);
        this.g = new a(this.e, this.f, v2);
        com.adincube.sdk.util.b b2 = new com.adincube.sdk.util.b((Context)this);
        c c2 = this.b;
        if (c2.f != null && c2.f != d.c) {
            int n2 = 5.a[c2.f.ordinal()];
            int n3 = n2 != 1 ? (n2 != 2 ? this.getRequestedOrientation() : 1) : 0;
            this.setRequestedOrientation(n3);
        }
        b2.a(this.getIntent().getExtras());
        int n4 = this.getResources().getColor(17170446);
        this.getWindow().getDecorView().setBackgroundColor(n4);
        if (bundle != null) {
            this.i = bundle.getBoolean("hasImpressionBeenSent");
        }
        if (bl = this.e.a(true, true) == null) {
            b.b().c();
            this.finish();
            return;
        }
        f f2 = com.adincube.sdk.g.a.a().a((boolean)true, (boolean)true).S;
        this.d = this.b.e().a();
        this.d.a(this.hasHardwareAcceleration());
        this.d.a(this.g);
        this.d.i = this.j;
        this.d.a(this.k);
        this.d.a(this.l);
        this.d.a(this.m);
        Window window = this.getWindow();
        com.adincube.sdk.b.a a2 = this.d;
        if (Build.VERSION.SDK_INT >= 19 && (bl3 = (67108864 & window.getAttributes().flags) != 0)) {
            int n5;
            a2.h = n5 = com.adincube.sdk.util.b.a((Context)this);
            if (a2.g != null) {
                a2.g.a(n5);
            }
        }
        View view = this.d.a(this, bundle, this.b, f2);
        Bundle bundle3 = this.getIntent().getExtras();
        if (Build.VERSION.SDK_INT >= 19 && bundle3.containsKey("suf")) {
            int n6 = bundle3.getInt("suf");
            boolean bl4 = (n6 & 512) != 0;
            boolean bl5 = (n6 & 1024) != 0;
            boolean bl6 = (n6 & 2) != 0;
            boolean bl7 = (n6 & 4) != 0;
            if (bl5 && !bl7 || bl4 && !bl6) {
                view.setFitsSystemWindows(true);
            }
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        try {
            if (this.d != null) {
                this.d.i();
            }
            return;
        }
        catch (Throwable throwable) {
            ErrorReportingHelper.report("AdinCubeActivity.onDestroy", (e)this.b, throwable);
            com.adincube.sdk.util.a.c("AdinCubeActivity.onDestroy() Exception : ", new Object[]{throwable});
            return;
        }
    }

    protected void onRestart() {
        super.onRestart();
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        try {
            bundle.putBoolean("hasImpressionBeenSent", this.i);
            if (this.d != null) {
                this.d.a(bundle);
            }
            return;
        }
        catch (Throwable throwable) {
            ErrorReportingHelper.report("AdinCubeActivity.onSaveInstanceState", (e)this.b, throwable);
            com.adincube.sdk.util.a.c("AdinCubeActivity.onSaveInstanceState() Exception : ", new Object[]{throwable});
            return;
        }
    }

    protected void onStart() {
        try {
            super.onStart();
            new com.adincube.sdk.util.b((Context)this).b(this.getIntent().getExtras());
            this.d.a();
            return;
        }
        catch (Throwable throwable) {
            ErrorReportingHelper.report("AdinCubeActivity.onStart", (e)this.b, throwable);
            com.adincube.sdk.util.a.c("AdinCubeActivity.onStart() Exception : ", new Object[]{throwable});
            return;
        }
    }

    protected void onStop() {
        super.onStop();
        try {
            if (this.d != null) {
                this.d.h();
            }
            return;
        }
        catch (Throwable throwable) {
            ErrorReportingHelper.report("AdinCubeActivity.onStop", (e)this.b, throwable);
            com.adincube.sdk.util.a.c("AdinCubeActivity.onStop() Exception : ", new Object[]{throwable});
            return;
        }
    }

    public static interface EventListener {
        public void onAdClicked();

        public void onAdHidden();

        public void onError();
    }

}

