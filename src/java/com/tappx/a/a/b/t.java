/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Rect
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnTouchListener
 *  android.webkit.ConsoleMessage
 *  android.webkit.JsResult
 *  android.webkit.WebChromeClient
 *  android.webkit.WebChromeClient$CustomViewCallback
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  com.tappx.a.a.b.ah
 *  com.tappx.a.a.b.t$2
 *  com.tappx.a.a.b.t$4
 *  com.tappx.a.a.b.t$6
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.NoSuchFieldError
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.net.URI
 *  java.util.Map
 *  org.json.JSONObject
 */
package com.tappx.a.a.b;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tappx.a.a.a.a.b;
import com.tappx.a.a.b.aa;
import com.tappx.a.a.b.ab;
import com.tappx.a.a.b.ac;
import com.tappx.a.a.b.ad;
import com.tappx.a.a.b.ae;
import com.tappx.a.a.b.ah;
import com.tappx.a.a.b.am;
import com.tappx.a.a.b.c;
import com.tappx.a.a.b.f;
import com.tappx.a.a.b.g;
import com.tappx.a.a.b.s;
import com.tappx.a.a.b.t;
import com.tappx.a.a.b.w;
import com.tappx.a.a.b.x;
import com.tappx.a.a.b.y;
import java.net.URI;
import java.util.Map;
import org.json.JSONObject;

public class t {
    private final s a;
    private final ab b;
    private a c;
    private ah d;
    private x e;
    private boolean f;
    private boolean g;
    private final WebViewClient h = new WebViewClient(){

        public void onPageFinished(WebView webView, String string2) {
            t.this.h();
        }

        public void onReceivedError(WebView webView, int n2, String string2, String string3) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Error: ");
            stringBuilder.append(string2);
            aa.c(stringBuilder.toString());
            super.onReceivedError(webView, n2, string2, string3);
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String string2) {
            return t.this.d(string2);
        }
    };

    t(s s2) {
        this(s2, new ab());
    }

    t(s s2, ab ab2) {
        this.a = s2;
        this.b = ab2;
    }

    private int a(int n2, int n3, int n4) {
        if (n2 >= n3 && n2 <= n4) {
            return n2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("param out of range: ");
        stringBuilder.append(n2);
        throw new w(stringBuilder.toString());
    }

    private g.a a(String string2, g.a a2) {
        if (TextUtils.isEmpty((CharSequence)string2)) {
            return a2;
        }
        if (string2.equals((Object)"top-left")) {
            return g.a.a;
        }
        if (string2.equals((Object)"top-right")) {
            return g.a.c;
        }
        if (string2.equals((Object)"center")) {
            return g.a.d;
        }
        if (string2.equals((Object)"bottom-left")) {
            return g.a.e;
        }
        if (string2.equals((Object)"bottom-right")) {
            return g.a.g;
        }
        if (string2.equals((Object)"top-center")) {
            return g.a.b;
        }
        if (string2.equals((Object)"bottom-center")) {
            return g.a.f;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid position '");
        stringBuilder.append(string2);
        stringBuilder.append("'");
        throw new w(stringBuilder.toString());
    }

    private String a(Rect rect) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(rect.left);
        stringBuilder.append(",");
        stringBuilder.append(rect.top);
        stringBuilder.append(",");
        stringBuilder.append(rect.width());
        stringBuilder.append(",");
        stringBuilder.append(rect.height());
        return stringBuilder.toString();
    }

    static /* synthetic */ void a(t t2, y y2, String string2) {
        t2.a(y2, string2);
    }

    private void a(y y2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("window.mraidbridge.nativeCallComplete(");
        stringBuilder.append(JSONObject.quote((String)y2.a()));
        stringBuilder.append(")");
        this.c(stringBuilder.toString());
    }

    private void a(y y2, String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("window.mraidbridge.notifyErrorEvent(");
        stringBuilder.append(JSONObject.quote((String)y2.a()));
        stringBuilder.append(", ");
        stringBuilder.append(JSONObject.quote((String)string2));
        stringBuilder.append(")");
        this.c(stringBuilder.toString());
    }

    static /* synthetic */ boolean a(t t2, boolean bl) {
        t2.f = bl;
        return bl;
    }

    private boolean a(String string2, boolean bl) {
        if (string2 == null) {
            return bl;
        }
        return this.g(string2);
    }

    private String b(Rect rect) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(rect.width());
        stringBuilder.append(",");
        stringBuilder.append(rect.height());
        return stringBuilder.toString();
    }

    private int e(String string2) {
        try {
            int n2 = Integer.parseInt((String)string2, (int)10);
            return n2;
        }
        catch (NumberFormatException numberFormatException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid param: ");
            stringBuilder.append(string2);
            throw new w(stringBuilder.toString());
        }
    }

    private ac f(String string2) {
        if ("portrait".equals((Object)string2)) {
            return ac.a;
        }
        if ("landscape".equals((Object)string2)) {
            return ac.b;
        }
        if ("none".equals((Object)string2)) {
            return ac.c;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid orientation '");
        stringBuilder.append(string2);
        stringBuilder.append("'");
        throw new w(stringBuilder.toString());
    }

    private boolean g(String string2) {
        if ("true".equals((Object)string2)) {
            return true;
        }
        if ("false".equals((Object)string2)) {
            return false;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid boolean parameter: ");
        stringBuilder.append(string2);
        throw new w(stringBuilder.toString());
    }

    private void h() {
        if (this.g) {
            return;
        }
        this.g = true;
        a a2 = this.c;
        if (a2 != null) {
            a2.a();
        }
    }

    void a() {
        this.d = null;
    }

    public void a(ae ae2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("mraidbridge.setScreenSize(");
        stringBuilder.append(this.b(ae2.c()));
        stringBuilder.append(");mraidbridge.setMaxSize(");
        stringBuilder.append(this.b(ae2.e()));
        stringBuilder.append(");mraidbridge.setCurrentPosition(");
        stringBuilder.append(this.a(ae2.g()));
        stringBuilder.append(");mraidbridge.setDefaultPosition(");
        stringBuilder.append(this.a(ae2.i()));
        stringBuilder.append(")");
        this.c(stringBuilder.toString());
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("mraidbridge.notifySizeChangeEvent(");
        stringBuilder2.append(this.b(ae2.f()));
        stringBuilder2.append(")");
        this.c(stringBuilder2.toString());
    }

    void a(ah ah2) {
        this.d = ah2;
        this.e = new x(ah2.getContext());
        this.d.getSettings().setJavaScriptEnabled(true);
        if (Build.VERSION.SDK_INT >= 17 && (this.a == s.b || b.b)) {
            ah2.getSettings().setMediaPlaybackRequiresUserGesture(false);
        }
        this.e.a((WebView)ah2);
        this.d.setScrollContainer(false);
        this.d.setVerticalScrollBarEnabled(false);
        this.d.setHorizontalScrollBarEnabled(false);
        this.d.setBackgroundColor(-16777216);
        this.d.setWebViewClient(this.h);
        this.d.setWebChromeClient(new WebChromeClient(){

            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                if (t.this.c != null) {
                    return t.this.c.a(consoleMessage);
                }
                return super.onConsoleMessage(consoleMessage);
            }

            public boolean onJsAlert(WebView webView, String string2, String string3, JsResult jsResult) {
                if (t.this.c != null) {
                    return t.this.c.a(string3, jsResult);
                }
                return super.onJsAlert(webView, string2, string3, jsResult);
            }

            public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
                super.onShowCustomView(view, customViewCallback);
            }
        });
        final f f2 = new f();
        f2.a((f.a)new 2(this));
        this.d.setOnTouchListener(new View.OnTouchListener(){

            public boolean onTouch(View view, MotionEvent motionEvent) {
                f2.a(motionEvent);
                int n2 = motionEvent.getAction();
                if (!(n2 != 0 && n2 != 1 || view.hasFocus())) {
                    view.requestFocus();
                }
                return false;
            }
        });
        this.d.setVisibilityChangedListener((c.a)new 4(this));
    }

    void a(am am2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("mraidbridge.setState(");
        stringBuilder.append(JSONObject.quote((String)am2.a()));
        stringBuilder.append(")");
        this.c(stringBuilder.toString());
    }

    void a(s s2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("mraidbridge.setPlacementType(");
        stringBuilder.append(JSONObject.quote((String)s2.a()));
        stringBuilder.append(")");
        this.c(stringBuilder.toString());
    }

    void a(a a2) {
        this.c = a2;
    }

    void a(y y2, Map<String, String> map) {
        if (y2.a(this.a) && !this.f) {
            throw new w("Click required");
        }
        if (this.c != null) {
            if (this.d != null) {
                switch (7.a[y2.ordinal()]) {
                    default: {
                        return;
                    }
                    case 10: {
                        throw new w("Unspecified command");
                    }
                    case 9: {
                        URI uRI = ad.d((String)map.get((Object)"uri"));
                        this.b.a(this.d.getContext(), uRI.toString());
                        return;
                    }
                    case 8: {
                        URI uRI = ad.d((String)map.get((Object)"uri"));
                        this.b.a(this.d.getContext(), uRI.toString(), (ab.a)new 6(this, y2));
                        return;
                    }
                    case 7: {
                        URI uRI = ad.d((String)map.get((Object)"url"));
                        this.b.a(this.d.getContext(), uRI);
                        this.c.a(uRI);
                        return;
                    }
                    case 6: {
                        this.b.a(this.d.getContext(), map);
                        return;
                    }
                    case 5: {
                        boolean bl = this.g((String)map.get((Object)"allowOrientationChange"));
                        ac ac2 = this.f((String)map.get((Object)"forceOrientation"));
                        this.c.a(bl, ac2);
                        return;
                    }
                    case 4: {
                        boolean bl = this.a((String)map.get((Object)"shouldUseCustomClose"), false);
                        this.c.b(bl);
                        return;
                    }
                    case 3: {
                        URI uRI = ad.a((String)map.get((Object)"url"), null);
                        boolean bl = this.a((String)map.get((Object)"shouldUseCustomClose"), false);
                        this.c.a(uRI, bl);
                        return;
                    }
                    case 2: {
                        int n2 = this.a(this.e((String)map.get((Object)"width")), 0, 100000);
                        int n3 = this.a(this.e((String)map.get((Object)"height")), 0, 100000);
                        int n4 = this.a(this.e((String)map.get((Object)"offsetX")), -100000, 100000);
                        int n5 = this.a(this.e((String)map.get((Object)"offsetY")), -100000, 100000);
                        g.a a2 = this.a((String)map.get((Object)"customClosePosition"), g.a.c);
                        boolean bl = this.a((String)map.get((Object)"allowOffscreen"), true);
                        this.c.a(n2, n3, n4, n5, a2, bl);
                        return;
                    }
                    case 1: 
                }
                this.c.c();
                return;
            }
            throw new w("Destroyed");
        }
        throw new w("Invalid state");
    }

    public void a(String string2) {
        if (this.d == null) {
            aa.c("MRAID bridge called setContentHtml before WebView was attached");
            return;
        }
        x x2 = this.e;
        if (x2 != null) {
            string2 = x2.a(string2);
        }
        String string3 = string2;
        this.g = false;
        this.d.loadDataWithBaseURL(null, string3, "text/html", "UTF-8", null);
    }

    void a(boolean bl) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("mraidbridge.setIsViewable(");
        stringBuilder.append(bl);
        stringBuilder.append(")");
        this.c(stringBuilder.toString());
    }

    void a(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("mraidbridge.setSupports(");
        stringBuilder.append(bl);
        stringBuilder.append(",");
        stringBuilder.append(bl2);
        stringBuilder.append(",");
        stringBuilder.append(bl3);
        stringBuilder.append(",");
        stringBuilder.append(bl4);
        stringBuilder.append(",");
        stringBuilder.append(bl5);
        stringBuilder.append(")");
        this.c(stringBuilder.toString());
    }

    void b() {
        this.c("mraidbridge.notifyReadyEvent();");
    }

    public void b(String string2) {
        ah ah2 = this.d;
        if (ah2 == null) {
            aa.c("MRAID bridge called setContentHtml while WebView was not attached");
            return;
        }
        this.g = false;
        ah2.loadUrl(string2);
    }

    void b(boolean bl) {
        this.f = bl;
    }

    void c(String string2) {
        if (this.d == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Attempted to inject Javascript into MRAID WebView while was not attached:\n\t");
            stringBuilder.append(string2);
            aa.c(stringBuilder.toString());
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Injecting Javascript into MRAID WebView:\t");
        stringBuilder.append(string2);
        aa.b(stringBuilder.toString());
        ah ah2 = this.d;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("javascript:");
        stringBuilder2.append(string2);
        ah2.loadUrl(stringBuilder2.toString());
    }

    boolean c() {
        return this.f;
    }

    boolean d() {
        ah ah2 = this.d;
        return ah2 != null && ah2.c();
    }

    /*
     * Exception decompiling
     */
    boolean d(String var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl128 : ICONST_0 : trying to set 0 previously set to 1
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

    boolean e() {
        return this.d != null;
    }

    boolean f() {
        return this.g;
    }

    ah g() {
        return this.d;
    }

    public static interface a {
        public void a();

        public void a(int var1, int var2, int var3, int var4, g.a var5, boolean var6);

        public void a(URI var1);

        public void a(URI var1, boolean var2);

        public void a(boolean var1);

        public void a(boolean var1, ac var2);

        public boolean a(ConsoleMessage var1);

        public boolean a(String var1, JsResult var2);

        public void b();

        public void b(boolean var1);

        public void c();
    }

}

