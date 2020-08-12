/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.webkit.WebSettings
 *  android.webkit.WebSettings$PluginState
 *  android.webkit.WebView
 *  java.io.File
 *  java.lang.Object
 *  java.lang.String
 */
package com.tappx.a.a.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.tappx.a.a.b.an;
import java.io.File;

public class c
extends WebView {
    private static boolean c;
    private a a;
    private boolean b;

    public c(Context context) {
        super(context.getApplicationContext());
        this.a(false);
        this.d();
        an.a(this);
        if (!c) {
            this.a(this.getContext());
            c = true;
        }
        int n2 = this.getVisibility();
        boolean bl = false;
        if (n2 == 0) {
            bl = true;
        }
        this.b = bl;
    }

    /*
     * Exception decompiling
     */
    private void a(Context var1) {
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

    private void d() {
        this.getSettings().setAllowFileAccess(false);
        if (Build.VERSION.SDK_INT >= 11) {
            this.getSettings().setAllowContentAccess(false);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            this.getSettings().setAllowFileAccessFromFileURLs(false);
            this.getSettings().setAllowUniversalAccessFromFileURLs(false);
        }
    }

    public void a() {
        if (Build.VERSION.SDK_INT >= 17) {
            this.getSettings().setMediaPlaybackRequiresUserGesture(false);
        }
    }

    public void a(boolean bl) {
        if (Build.VERSION.SDK_INT >= 18) {
            return;
        }
        if (bl) {
            this.getSettings().setPluginState(WebSettings.PluginState.ON);
            return;
        }
        this.getSettings().setPluginState(WebSettings.PluginState.OFF);
    }

    @SuppressLint(value={"SetJavaScriptEnabled"})
    public void b() {
        this.getSettings().setJavaScriptEnabled(true);
        this.getSettings().setDomStorageEnabled(true);
        this.getSettings().setAppCacheEnabled(true);
        this.getSettings().setAppCachePath(this.getContext().getCacheDir().getAbsolutePath());
    }

    public boolean c() {
        return this.b;
    }

    public void destroy() {
        an.a((View)this);
        this.removeAllViews();
        super.destroy();
    }

    protected void onVisibilityChanged(View view, int n2) {
        super.onVisibilityChanged(view, n2);
        boolean bl = n2 == 0;
        if (bl != this.b) {
            this.b = bl;
            a a2 = this.a;
            if (a2 != null) {
                a2.a(this.b);
            }
        }
    }

    public void setVisibilityChangedListener(a a2) {
        this.a = a2;
    }

    public static interface a {
        public void a(boolean var1);
    }

}

