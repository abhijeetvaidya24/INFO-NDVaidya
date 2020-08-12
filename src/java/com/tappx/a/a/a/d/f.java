/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.DisplayMetrics
 *  android.view.Display
 *  android.view.WindowManager
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  com.tappx.a.a.a.m
 *  java.lang.Class
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.reflect.Constructor
 *  java.util.Locale
 *  java.util.concurrent.CountDownLatch
 */
package com.tappx.a.a.a.d;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.tappx.a.a.a.m;
import java.lang.reflect.Constructor;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;

public final class f {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final int f;
    public final int g;
    public final int h;
    public final String i;
    public final String j;
    public final String k;

    public f(String string2, String string3, String string4, String string5, String string6, String string7, int n2, int n3, int n4, String string8, String string9) {
        this.k = string2;
        this.a = string3;
        this.b = string4;
        this.c = string5;
        this.d = string6;
        this.e = string7;
        this.g = n2;
        this.h = n3;
        this.f = n4;
        this.i = string8;
        this.j = string9;
    }

    public static class com.tappx.a.a.a.d.f$a {
        public static final String a = "http.agent";
        private static volatile com.tappx.a.a.a.d.f$a b;
        private static final String c = "en-us";
        private static final String d = "android";
        private final Context e;
        private final com.tappx.a.a.a.f<String> f = new m();
        private final a g;

        public com.tappx.a.a.a.d.f$a(Context context) {
            this(context, new a(context));
        }

        com.tappx.a.a.a.d.f$a(Context context, a a2) {
            this.e = context;
            this.g = a2;
        }

        private int a(int n2, int n3) {
            if (n2 == n3) {
                return 0;
            }
            if (n2 < n3) {
                return 1;
            }
            return 2;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public static final com.tappx.a.a.a.d.f$a a(Context context) {
            if (b != null) return b;
            Class<com.tappx.a.a.a.d.f$a> class_ = com.tappx.a.a.a.d.f$a.class;
            synchronized (com.tappx.a.a.a.d.f$a.class) {
                if (b != null) return b;
                b = new com.tappx.a.a.a.d.f$a(context.getApplicationContext());
                // ** MonitorExit[var2_1] (shouldn't be in output)
                return b;
            }
        }

        private String b() {
            Locale locale = Locale.getDefault();
            if (locale != null) {
                return locale.getLanguage();
            }
            return c;
        }

        private String c() {
            String string2 = this.f.a();
            if (string2 == null) {
                string2 = this.g.a();
                this.f.a(string2);
            }
            return string2;
        }

        public f a() {
            String string2 = this.b();
            String string3 = Build.MANUFACTURER;
            String string4 = Build.MODEL;
            String string5 = Build.PRODUCT;
            String string6 = Build.VERSION.RELEASE;
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager)this.e.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            int n2 = displayMetrics.widthPixels;
            int n3 = displayMetrics.heightPixels;
            int n4 = this.a(n2, n3);
            String string7 = String.valueOf((float)displayMetrics.scaledDensity);
            String string8 = this.c();
            f f2 = new f(string2, string3, string4, string5, d, string6, n2, n3, n4, string7, string8);
            return f2;
        }

        static class com.tappx.a.a.a.d.f$a$a {
            private final Context a;

            public com.tappx.a.a.a.d.f$a$a(Context context) {
                this.a = context;
            }

            private String b() {
                Constructor constructor = WebSettings.class.getDeclaredConstructor(new Class[]{Context.class, WebView.class});
                boolean bl2 = constructor.isAccessible();
                if (!bl2) {
                    constructor.setAccessible(true);
                }
                try {
                    Object[] arrobject = new Object[]{this.a, null};
                    String string2 = ((WebSettings)constructor.newInstance(arrobject)).getUserAgentString();
                    return string2;
                }
                finally {
                    if (!bl2) {
                        constructor.setAccessible(false);
                    }
                }
            }

            @TargetApi(value=17)
            private String c() {
                return WebSettings.getDefaultUserAgent((Context)this.a);
            }

            private String d() {
                return new a(this.a).a();
            }

            /*
             * Exception decompiling
             */
            public String a() {
                // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl9.3 : FAKE_TRY : trying to set 0 previously set to 1
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

            private static final class a {
                private String a;
                private final Context b;

                private a(Context context) {
                    this.b = context;
                }

                private String b() {
                    WebView webView = new WebView(this.b);
                    String string2 = webView.getSettings().getUserAgentString();
                    webView.destroy();
                    return string2;
                }

                public String a() {
                    if (com.tappx.a.a.a.j.f.a()) {
                        return this.b();
                    }
                    final CountDownLatch countDownLatch = new CountDownLatch(1);
                    com.tappx.a.a.a.j.f.a(new Runnable(){

                        public void run() {
                            a a2 = a.this;
                            a2.a = a2.b();
                            countDownLatch.countDown();
                        }
                    });
                    try {
                        countDownLatch.await();
                        String string2 = this.a;
                        return string2;
                    }
                    catch (InterruptedException interruptedException) {
                        return null;
                    }
                }

            }

        }

    }

}

