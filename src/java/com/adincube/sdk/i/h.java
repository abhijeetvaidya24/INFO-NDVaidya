/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.webkit.WebView
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.concurrent.atomic.AtomicInteger
 */
package com.adincube.sdk.i;

import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import com.adincube.sdk.util.ErrorReportingHelper;
import com.adincube.sdk.util.x;
import java.util.concurrent.atomic.AtomicInteger;

public final class h {
    private WebView a;
    private AtomicInteger b = new AtomicInteger(0);

    public h(WebView webView) {
        this.a = webView;
    }

    final void a(a a2) {
        try {
            Object[] arrobject = new Object[]{x.a(a2.a), x.a(a2.b)};
            this.b.incrementAndGet();
            if (a2.b == null) {
                this.a.loadUrl(a2.a);
                return;
            }
            this.a.loadDataWithBaseURL(a2.a, a2.b, a2.c, a2.d, null);
            return;
        }
        catch (Throwable throwable) {
            com.adincube.sdk.util.a.c("WebViewLoader.loadContentInUiThread", new Object[]{throwable});
            ErrorReportingHelper.report("WebViewLoader.loadContentInUiThread", throwable);
            return;
        }
    }

    public final void a(String string, String string2, String string3, String string4) {
        final a a2 = new a(0);
        a2.a = string;
        a2.b = string2;
        a2.c = string3;
        a2.d = string4;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.a(a2);
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable(){

            public final void run() {
                h.this.a(a2);
            }
        });
    }

    private static final class a {
        public String a;
        public String b;
        public String c;
        public String d;

        private a() {
        }

        /* synthetic */ a(byte by2) {
            this();
        }
    }

}

