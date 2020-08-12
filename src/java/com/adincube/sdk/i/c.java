/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.graphics.Point
 *  android.net.Uri
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.webkit.ConsoleMessage
 *  android.webkit.WebChromeClient
 *  android.webkit.WebResourceResponse
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  java.io.ByteArrayInputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.net.URL
 *  java.util.Arrays
 *  java.util.List
 */
package com.adincube.sdk.i;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.adincube.sdk.h.a.e;
import com.adincube.sdk.i.f;
import com.adincube.sdk.i.g;
import com.adincube.sdk.i.h;
import com.adincube.sdk.util.ErrorReportingHelper;
import com.adincube.sdk.util.b.j;
import com.adincube.sdk.util.n;
import com.adincube.sdk.util.w;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public final class c {
    List<String> a = null;
    Context b;
    e c;
    com.adincube.sdk.mediation.w.f d;
    public WebView e = null;
    g f = null;
    com.adincube.sdk.i.a g = null;
    boolean h = true;
    String i = "none";
    public Point j = new Point(0, 0);
    boolean k = false;
    public c l = null;
    public d m = null;
    private h n = null;
    private f o = null;
    private boolean p = false;
    private boolean q = false;

    public c(Context context, e e2, com.adincube.sdk.mediation.w.f f2) {
        this.c = e2;
        this.d = f2;
        this.b = context;
        this.a = Arrays.asList((Object[])new String[]{"none", "portrait", "landscape"});
    }

    public final void a() {
        block8 : {
            String string;
            com.adincube.sdk.h.a.a.a a2 = com.adincube.sdk.util.c.a(this.c, com.adincube.sdk.h.a.a.b.b);
            InputStream inputStream = null;
            try {
                inputStream = n.a(this.b, a2);
                string = w.a(inputStream);
                if (string == null) break block8;
            }
            catch (Throwable throwable) {
                try {
                    inputStream.close();
                }
                catch (Throwable throwable2) {}
                throw throwable;
            }
            if (string.length() <= 0) break block8;
            this.n.a("http://adincube/index.html", string, "text/html", "UTF-8");
            try {
                inputStream.close();
            }
            catch (Throwable throwable) {}
            return;
        }
        throw new IOException("Cannot read ad content from resource.");
    }

    public final void a(WebView webView) {
        this.o = f.a;
        this.p = false;
        this.q = false;
        this.e = webView;
        this.n = new h(webView);
        this.g = new com.adincube.sdk.i.a(this.n);
        this.f = new g(this.b, this.c, webView, this.g);
        webView.setWebViewClient((WebViewClient)new b(0));
        webView.setWebChromeClient((WebChromeClient)new a(0));
        webView.setVerticalScrollBarEnabled(false);
        webView.setHorizontalScrollBarEnabled(false);
        WebSettings webSettings = webView.getSettings();
        if (g.b()) {
            webSettings.setUseWideViewPort(true);
            webSettings.setSupportZoom(false);
        }
        if (Build.VERSION.SDK_INT >= 17) {
            webSettings.setMediaPlaybackRequiresUserGesture(false);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            webSettings.setAllowFileAccessFromFileURLs(false);
            webSettings.setAllowUniversalAccessFromFileURLs(false);
        }
        if (Build.VERSION.SDK_INT >= 11) {
            webSettings.setAllowContentAccess(false);
        }
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(false);
        webView.clearCache(true);
        webSettings.setCacheMode(2);
        if (Build.VERSION.SDK_INT >= 19) {
            WebView.setWebContentsDebuggingEnabled((boolean)true);
        }
        com.adincube.sdk.i.a a2 = this.g;
        Object[] arrobject = new Object[]{this.c.d().h};
        a2.a("_setPlacementType", arrobject);
        if (Build.VERSION.SDK_INT >= 18) {
            this.g.a("_setSupportFor", "inlineVideo", "true");
        }
    }

    public final void a(f f2) {
        if (this.o != f2) {
            this.o = f2;
            this.g.a("_setState", new Object[]{f2});
            this.g.a(com.adincube.sdk.i.d.c, new Object[]{f2});
        }
    }

    public final void a(boolean bl) {
        if (this.q != bl) {
            this.q = bl;
            com.adincube.sdk.i.a a2 = this.g;
            Object[] arrobject = new Object[]{bl};
            a2.a("_setVisible", arrobject);
            if (this.p) {
                com.adincube.sdk.i.a a3 = this.g;
                com.adincube.sdk.i.d d2 = com.adincube.sdk.i.d.d;
                Object[] arrobject2 = new Object[]{bl};
                a3.a(d2, arrobject2);
            }
        }
    }

    public final void b() {
        if (!this.p) {
            this.p = true;
            this.g.a(com.adincube.sdk.i.d.a, new Object[0]);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public final void c() {
        block2 : {
            g g2;
            int n2;
            int n3;
            block4 : {
                block3 : {
                    g2 = this.f;
                    if (g.b()) break block2;
                    if (g2.b.s == null || g2.b.t == null) break block3;
                    if (g2.b.s == null || g2.b.t == null) break block2;
                    n3 = g2.b.t;
                    n2 = g2.b.s;
                    break block4;
                }
                if (g2.c.getWidth() == 0 && g2.c.getHeight() == 0) break block2;
                n3 = j.a(g2.a, g2.c.getWidth());
                n2 = j.a(g2.a, g2.c.getHeight());
            }
            g2.a(n3, n2);
        }
        this.f.a();
    }

    public final void d() {
        int n2;
        Point point = new Point();
        if (this.c.t != null && this.c.s != null) {
            point.x = this.c.t;
            n2 = this.c.s;
        } else {
            point.x = j.a(this.b, this.e.getWidth());
            n2 = j.a(this.b, this.e.getHeight());
        }
        point.y = n2;
        if (point.x != this.j.x || point.y != this.j.y) {
            com.adincube.sdk.i.a a2 = this.g;
            Object[] arrobject = new Object[]{point.x, point.y};
            a2.a("_setMaxSize", arrobject);
            com.adincube.sdk.i.a a3 = this.g;
            Object[] arrobject2 = new Object[]{point.x, point.y};
            a3.a("_setScreenSize", arrobject2);
            if (this.p) {
                com.adincube.sdk.i.a a4 = this.g;
                com.adincube.sdk.i.d d2 = com.adincube.sdk.i.d.e;
                Object[] arrobject3 = new Object[]{this.j.x, this.j.y};
                a4.a(d2, arrobject3);
            }
            this.j = point;
        }
    }

    private final class a
    extends WebChromeClient {
        private a() {
        }

        /* synthetic */ a(byte by2) {
            this();
        }

        @SuppressLint(value={"NewApi"})
        public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            return true;
        }
    }

    private final class b
    extends WebViewClient {
        private b() {
        }

        /* synthetic */ b(byte by2) {
            this();
        }

        private com.adincube.sdk.h.a.a.a a(URL uRL) {
            for (com.adincube.sdk.h.a.a.a a2 : com.adincube.sdk.util.c.a(c.this.c, com.adincube.sdk.h.a.a.b.b, false)) {
                if (!uRL.equals((Object)a2.c())) continue;
                return a2;
            }
            return null;
        }

        private void a() {
            c.this.f.d = true;
            c.this.f.a();
            c c2 = c.this;
            if (!c2.k) {
                c2.k = true;
                String string = c2.c.r != null && c2.c.r.length() > 0 ? c2.c.r : c2.d.p;
                if (string != null) {
                    if (string.length() == 0) {
                        return;
                    }
                    c2.g.a(string);
                }
            }
        }

        private static WebResourceResponse b() {
            byte[] arrby = new byte[]{};
            try {
                arrby = com.adincube.sdk.util.e.c("InVzZSBzdHJpY3QiO3dpbmRvdy5fbXJhaWQ9KGZ1bmN0aW9uKCl7dmFyIG1yYWlkU3RhdGVzPVsibG9hZGluZyIsImRlZmF1bHQiLCJleHBhbmRlZCIsInJlc2l6ZWQiLCJoaWRkZW4iXTt2YXIgbXJhaWRFdmVudHM9WyJyZWFkeSIsImVycm9yIiwic3RhdGVDaGFuZ2UiLCJ2aWV3YWJsZUNoYW5nZSIsInNpemVDaGFuZ2UiXTt2YXIgc3RhdGU9ImxvYWRpbmciO3ZhciB2aXNpYmxlPWZhbHNlO3ZhciBzY3JlZW5TaXplPXt9O3ZhciBtYXhTaXplPXt9O3ZhciBzdXBwb3J0cz17c21zOmZhbHNlLHRlbDpmYWxzZSxjYWxlbmRhcjpmYWxzZSxzdG9yZVBpY3R1cmU6ZmFsc2UsaW5saW5lVmlkZW86ZmFsc2V9O3ZhciBvcmllbnRhdGlvblByb3BlcnRpZXM9e2FsbG93T3JpZW50YXRpb25DaGFuZ2U6dHJ1ZSxmb3JjZU9yaWVudGF0aW9uOiJub25lIn07dmFyIHBsYWNlbWVudFR5cGU9bnVsbDt2YXIgZXZlbnRDYWxsYmFja3M9e307Zm9yKHZhciBpPTA7aTxtcmFpZEV2ZW50cy5sZW5ndGg7aSsrKXtldmVudENhbGxiYWNrc1ttcmFpZEV2ZW50c1tpXV09W119dmFyIHNlbGY9e19maXJlRXZlbnQ6ZnVuY3Rpb24oZXZlbnQpe2lmKG1yYWlkRXZlbnRzLmluZGV4T2YoZXZlbnQpPT0tMSl7cmV0dXJufXZhciBhcmdzPVtdO2Zvcih2YXIgaj0xO2o8YXJndW1lbnRzLmxlbmd0aDtqKyspe2FyZ3MucHVzaChhcmd1bWVudHNbal0pfXZhciBmdW5jdGlvbnM9ZXZlbnRDYWxsYmFja3NbZXZlbnRdO2Zvcih2YXIgaT0wO2k8ZnVuY3Rpb25zLmxlbmd0aDtpKyspe2Z1bmN0aW9uc1tpXS5hcHBseSh1bmRlZmluZWQsYXJncyl9fSxfY2FsbEFjdGlvbjpmdW5jdGlvbihhY3Rpb24scGFyYW1zKXt2YXIgdXJsPSJtcmFpZDovL2FkaW5jdWJlLyIrYWN0aW9uO2lmKHBhcmFtcyE9dW5kZWZpbmVkKXt2YXIgcXVlcnlQYXJhbWV0ZXJzPSIiO2Zvcih2YXIgcGFyYW1OYW1lIGluIHBhcmFtcyl7aWYocXVlcnlQYXJhbWV0ZXJzLmxlbmd0aD09MCl7cXVlcnlQYXJhbWV0ZXJzKz0iPyJ9ZWxzZXtxdWVyeVBhcmFtZXRlcnMrPSImIn1xdWVyeVBhcmFtZXRlcnMrPXBhcmFtTmFtZSsiPSIrZW5jb2RlVVJJQ29tcG9uZW50KHBhcmFtc1twYXJhbU5hbWVdKX11cmwrPXF1ZXJ5UGFyYW1ldGVyc312YXIgaWZyYW1lPWRvY3VtZW50LmNyZWF0ZUVsZW1lbnQoImlmcmFtZSIpO2lmcmFtZS5zZXRBdHRyaWJ1dGUoInNyYyIsdXJsKTtpZnJhbWUuc2V0QXR0cmlidXRlKCJzdHlsZSIsImRpc3BsYXk6IG5vbmU7Iik7aWYoZG9jdW1lbnQuYm9keSE9bnVsbCl7ZG9jdW1lbnQuYm9keS5hcHBlbmRDaGlsZChpZnJhbWUpfWVsc2V7ZG9jdW1lbnQuYWRkRXZlbnRMaXN0ZW5lcigiRE9NQ29udGVudExvYWRlZCIsZnVuY3Rpb24oKXtkb2N1bWVudC5ib2R5LmFwcGVuZENoaWxkKGlmcmFtZSl9LGZhbHNlKX19LF9zZXRTdXBwb3J0Rm9yOmZ1bmN0aW9uKGZlYXR1cmUsdmFsdWUpe2lmKHN1cHBvcnRzW2ZlYXR1cmVdPT11bmRlZmluZWQpe3JldHVybn1zdXBwb3J0c1tmZWF0dXJlXT0odmFsdWU9PSJ0cnVlIil9LF9zdXBwb3J0czpmdW5jdGlvbihmZWF0dXJlKXtpZihzdXBwb3J0c1tmZWF0dXJlXT09dW5kZWZpbmVkKXtyZXR1cm4gZmFsc2V9cmV0dXJuIHN1cHBvcnRzW2ZlYXR1cmVdfSxfc2V0U3RhdGU6ZnVuY3Rpb24obmV3U3RhdGUpe3N0YXRlPW5ld1N0YXRlfSxfZ2V0U3RhdGU6ZnVuY3Rpb24oKXtyZXR1cm4gc3RhdGV9LF9zZXRWaXNpYmxlOmZ1bmN0aW9uKHYpe3Zpc2libGU9KHY9PSJ0cnVlIil9LF9pc1ZpZXdhYmxlOmZ1bmN0aW9uKCl7cmV0dXJuKHZpc2libGU9PXRydWUpfSxfc2V0TWF4U2l6ZTpmdW5jdGlvbih3aWR0aCxoZWlnaHQpe21heFNpemU9e3dpZHRoOnBhcnNlSW50KHdpZHRoKSxoZWlnaHQ6cGFyc2VJbnQoaGVpZ2h0KX19LF9nZXRNYXhTaXplOmZ1bmN0aW9uKCl7cmV0dXJuIG1heFNpemV9LF9zZXRTY3JlZW5TaXplOmZ1bmN0aW9uKHdpZHRoLGhlaWdodCl7c2NyZWVuU2l6ZT17d2lkdGg6cGFyc2VJbnQod2lkdGgpLGhlaWdodDpwYXJzZUludChoZWlnaHQpfX0sX2dldFNjcmVlblNpemU6ZnVuY3Rpb24oKXtyZXR1cm4gc2NyZWVuU2l6ZX0sX3NldE9yaWVudGF0aW9uUHJvcGVydGllczpmdW5jdGlvbihhbGxvd09yaWVudGF0aW9uQ2hhbmdlLGZvcmNlT3JpZW50YXRpb24pe3NlbGYuX2NhbGxBY3Rpb24oInNldE9yaWVudGF0aW9uUHJvcGVydGllcyIse2FsbG93T3JpZW50YXRpb25DaGFuZ2U6YWxsb3dPcmllbnRhdGlvbkNoYW5nZXx8dHJ1ZSxmb3JjZU9yaWVudGF0aW9uOmZvcmNlT3JpZW50YXRpb258fCJub25lIn0pfSxfZ2V0T3JpZW50YXRpb25Qcm9wZXJ0aWVzOmZ1bmN0aW9uKCl7fSxfc2V0UGxhY2VtZW50VHlwZTpmdW5jdGlvbihwdCl7cGxhY2VtZW50VHlwZT1wdH0sX2dldFBsYWNlbWVudFR5cGU6ZnVuY3Rpb24oKXtyZXR1cm4gcGxhY2VtZW50VHlwZX0sX29wZW46ZnVuY3Rpb24odXJsKXtpZih1cmw9PXVuZGVmaW5lZCl7c2VsZi5fZmlyZUV2ZW50KCJlcnJvciIsInVybCBwYXJhbWF0ZXIgaXMgbWFuZGF0b3J5Iiwib3BlbiIpO3JldHVybn1zZWxmLl9jYWxsQWN0aW9uKCJvcGVuIix7dXJsOnVybH0pfSxfcGxheVZpZGVvOmZ1bmN0aW9uKHVyaSl7aWYodXJpPT11bmRlZmluZWQpe3NlbGYuX2ZpcmVFdmVudCgiZXJyb3IiLCJ1cmkgcGFyYW1hdGVyIGlzIG1hbmRhdG9yeSIsIm9wZW4iKTtyZXR1cm59c2VsZi5fY2FsbEFjdGlvbigicGxheVZpZGVvIix7dXJpOnVyaX0pfSxfY2xvc2U6ZnVuY3Rpb24oKXtzZWxmLl9jYWxsQWN0aW9uKCJjbG9zZSIpfSxfYWRkRXZlbnRMaXN0ZW5lcjpmdW5jdGlvbihldmVudCxjYWxsYmFjayl7aWYobXJhaWRFdmVudHMuaW5kZXhPZihldmVudCk9PS0xKXtzZWxmLl9maXJlRXZlbnQoImVycm9yIixldmVudCsiIGlzIG5vdCBhIHZhbGlkIE1SQUlEIDIuMCBldmVudC4iLCJhZGRFdmVudExpc3RlbmVyIik7cmV0dXJufWV2ZW50Q2FsbGJhY2tzW2V2ZW50XS5wdXNoKGNhbGxiYWNrKX0sX3JlbW92ZUV2ZW50TGlzdGVuZXI6ZnVuY3Rpb24oZXZlbnQsY2FsbGJhY2spe2lmKG1yYWlkRXZlbnRzLmluZGV4T2YoZXZlbnQpPT0tMSl7cmV0dXJufXZhciBpbmRleD1ldmVudENhbGxiYWNrc1tldmVudF0uaW5kZXhPZihjYWxsYmFjayk7aWYoaW5kZXghPS0xKXtldmVudENhbGxiYWNrc1tldmVudF0uc3BsaWNlKDEsMSl9fX07cmV0dXJuIHNlbGZ9KSgpO3ZhciBtcmFpZD0oZnVuY3Rpb24oKXtyZXR1cm57YWRkRXZlbnRMaXN0ZW5lcjp3aW5kb3cuX21yYWlkLl9hZGRFdmVudExpc3RlbmVyLGNyZWF0ZUNhbGVuZGFyRXZlbnQ6ZnVuY3Rpb24oKXt9LGNsb3NlOndpbmRvdy5fbXJhaWQuX2Nsb3NlLGV4cGFuZDpmdW5jdGlvbigpe30sZ2V0Q3VycmVudFBvc2l0aW9uOmZ1bmN0aW9uKCl7cmV0dXJue3g6MCx5OjAsd2lkdGg6d2luZG93Ll9tcmFpZC5fZ2V0TWF4U2l6ZSgpLndpZHRoLGhlaWdodDp3aW5kb3cuX21yYWlkLl9nZXRNYXhTaXplKCkuaGVpZ2h0fX0sZ2V0RGVmYXVsdFBvc2l0aW9uOmZ1bmN0aW9uKCl7cmV0dXJue3g6MCx5OjAsd2lkdGg6d2luZG93Ll9tcmFpZC5fZ2V0TWF4U2l6ZSgpLndpZHRoLGhlaWdodDp3aW5kb3cuX21yYWlkLl9nZXRNYXhTaXplKCkuaGVpZ2h0fX0sZ2V0RXhwYW5kUHJvcGVydGllczpmdW5jdGlvbigpe3JldHVybnt3aWR0aDp3aW5kb3cuX21yYWlkLl9nZXRNYXhTaXplKCkud2lkdGgsaGVpZ2h0OndpbmRvdy5fbXJhaWQuX2dldE1heFNpemUoKS5oZWlnaHQsdXNlQ3VzdG9tQ2xvc2U6ZmFsc2UsaXNNb2RhbDp0cnVlfX0sZ2V0TWF4U2l6ZTp3aW5kb3cuX21yYWlkLl9nZXRNYXhTaXplLGdldE9yaWVudGF0aW9uUHJvcGVydGllczp3aW5kb3cuX21yYWlkLl9nZXRPcmllbnRhdGlvblByb3BlcnRpZXMsZ2V0UGxhY2VtZW50VHlwZTp3aW5kb3cuX21yYWlkLl9nZXRQbGFjZW1lbnRUeXBlLGdldFJlc2l6ZVByb3BlcnRpZXM6ZnVuY3Rpb24oKXtyZXR1cm57d2lkdGg6d2luZG93Ll9tcmFpZC5fZ2V0TWF4U2l6ZSgpLndpZHRoLGhlaWdodDp3aW5kb3cuX21yYWlkLl9nZXRNYXhTaXplKCkuaGVpZ2h0LG9mZnNldFg6MCxvZmZzZXRZOjB9fSxnZXRTY3JlZW5TaXplOndpbmRvdy5fbXJhaWQuX2dldFNjcmVlblNpemUsZ2V0U3RhdGU6d2luZG93Ll9tcmFpZC5fZ2V0U3RhdGUsZ2V0VmVyc2lvbjpmdW5jdGlvbigpe3JldHVybiIyLjAifSxpc1ZpZXdhYmxlOndpbmRvdy5fbXJhaWQuX2lzVmlld2FibGUsb3Blbjp3aW5kb3cuX21yYWlkLl9vcGVuLHBsYXlWaWRlbzp3aW5kb3cuX21yYWlkLl9wbGF5VmlkZW8scmVtb3ZlRXZlbnRMaXN0ZW5lcjp3aW5kb3cuX21yYWlkLl9yZW1vdmVFdmVudExpc3RlbmVyLHJlc2l6ZTpmdW5jdGlvbigpe30sc2V0RXhwYW5kUHJvcGVydGllczpmdW5jdGlvbigpe30sc2V0T3JpZW50YXRpb25Qcm9wZXJ0aWVzOmZ1bmN0aW9uKG9wKXt3aW5kb3cuX21yYWlkLl9zZXRPcmllbnRhdGlvblByb3BlcnRpZXMob3AuYWxsb3dPcmllbnRhdGlvbkNoYW5nZSxvcC5mb3JjZU9yaWVudGF0aW9ufHwibm9uZSIpfSxzZXRSZXNpemVQcm9wZXJ0aWVzOmZ1bmN0aW9uKCl7fSxzdG9yZVBpY3R1cmU6ZnVuY3Rpb24oKXt9LHN1cHBvcnRzOndpbmRvdy5fbXJhaWQuX3N1cHBvcnRzLHVzZUN1c3RvbUNsb3NlOmZ1bmN0aW9uKCl7fX19KSgpOw==").getBytes("UTF-8");
            }
            catch (Throwable throwable) {
                com.adincube.sdk.util.a.c("MRAIDController.injectMraidJavascript", new Object[]{throwable});
                ErrorReportingHelper.report("MRAIDController.injectMraidJavascript", throwable);
            }
            return new WebResourceResponse("application/javascript", null, (InputStream)new ByteArrayInputStream(arrby));
        }

        public final void onPageFinished(WebView webView, String string) {
            try {
                this.a();
                return;
            }
            catch (Throwable throwable) {
                ErrorReportingHelper.report("MRAIDController#ABWebViewClient.onPageFinished", com.adincube.sdk.h.c.b.a, throwable);
                com.adincube.sdk.util.a.c("MRAIDController#ABWebViewClient.onPageFinished()", new Object[]{throwable});
                return;
            }
        }

        /*
         * Exception decompiling
         */
        @SuppressLint(value={"NewApi"})
        public final WebResourceResponse shouldInterceptRequest(WebView var1, String var2) {
            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
            // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl300 : ALOAD_2 : trying to set 1 previously set to 0
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

        public final boolean shouldOverrideUrlLoading(WebView webView, String string) {
            try {
                if (!(string.startsWith("data:") || string.startsWith("adincube://") || string.startsWith("mraid://"))) {
                    c.this.l.a(Uri.parse((String)string));
                    return true;
                }
            }
            catch (Throwable throwable) {
                ErrorReportingHelper.report("MRAIDController#ABWebViewClient.shouldOverrideUrlLoading", com.adincube.sdk.h.c.b.a, throwable);
                com.adincube.sdk.util.a.c("MRAIDController#ABWebViewClient.shouldOverrideUrlLoading()", new Object[]{throwable});
            }
            return false;
        }
    }

    public static interface c {
        public void a();

        public void a(Uri var1);

        public void b(Uri var1);
    }

    public static interface d {
        public void a(String var1, String var2);
    }

}

