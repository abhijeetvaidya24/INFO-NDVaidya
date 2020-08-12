/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.View$OnTouchListener
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  java.lang.Object
 *  java.lang.String
 */
package com.tappx.a.a.b;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tappx.a.a.b.ak;
import com.tappx.a.a.b.c;
import com.tappx.a.a.b.f;
import com.tappx.a.a.b.o;

public class o
extends c {
    private boolean a;
    private final f b;
    private b c;
    private final f.a d = new f.a(){

        @Override
        public void a() {
            o.this.a = true;
        }
    };

    public o(Context context, boolean bl) {
        super(context);
        if (!bl) {
            this.d();
        }
        this.getSettings().setJavaScriptEnabled(true);
        if (Build.VERSION.SDK_INT >= 14) {
            this.a(true);
        }
        this.setBackgroundColor(0);
        this.b = new f();
        this.b.a(this.d);
        this.setWebViewClient(new WebViewClient(){
            private final ak b = new ak();

            /*
             * Exception decompiling
             */
            public boolean shouldOverrideUrlLoading(WebView var1, String var2) {
                // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl67 : ICONST_0 : trying to set 0 previously set to 1
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
        });
        this.setOnTouchListener(new View.OnTouchListener(this){
            final /* synthetic */ o a;
            {
                this.a = o2;
            }

            public boolean onTouch(View view, android.view.MotionEvent motionEvent) {
                o.a(this.a).a(motionEvent);
                int n2 = motionEvent.getAction();
                if (!(n2 != 0 && n2 != 1 || view.hasFocus())) {
                    view.requestFocus();
                }
                return false;
            }
        });
    }

    static /* synthetic */ f a(o o2) {
        return o2.b;
    }

    static /* synthetic */ b b(o o2) {
        return o2.c;
    }

    static /* synthetic */ boolean c(o o2) {
        return o2.a;
    }

    void a(String string) {
        this.loadDataWithBaseURL(null, string, "text/html", "utf-8", null);
    }

    void d() {
        this.setHorizontalScrollBarEnabled(false);
        this.setHorizontalScrollbarOverlay(false);
        this.setVerticalScrollBarEnabled(false);
        this.setVerticalScrollbarOverlay(false);
        this.getSettings().setSupportZoom(false);
    }

    public void setListener(b b2) {
        this.c = b2;
    }

}

