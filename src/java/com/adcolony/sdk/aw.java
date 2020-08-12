/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.webkit.ValueCallback
 *  android.webkit.WebChromeClient
 *  android.webkit.WebResourceError
 *  android.webkit.WebResourceRequest
 *  android.webkit.WebResourceResponse
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  com.adcolony.sdk.AdColony
 *  com.adcolony.sdk.AdColonyInterstitial
 *  com.adcolony.sdk.AdColonyInterstitialListener
 *  com.adcolony.sdk.a
 *  com.adcolony.sdk.ad
 *  com.adcolony.sdk.ae
 *  com.adcolony.sdk.af
 *  com.adcolony.sdk.ag
 *  com.adcolony.sdk.au
 *  com.adcolony.sdk.aw$1
 *  com.adcolony.sdk.aw$4
 *  com.adcolony.sdk.aw$9
 *  com.adcolony.sdk.aw$a
 *  com.adcolony.sdk.b
 *  com.adcolony.sdk.c
 *  com.adcolony.sdk.d
 *  com.adcolony.sdk.t
 *  com.adcolony.sdk.w
 *  com.adcolony.sdk.y
 *  com.adcolony.sdk.y$a
 *  java.io.FileInputStream
 *  java.io.IOException
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.IndexOutOfBoundsException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.concurrent.ConcurrentHashMap
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.adcolony.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.adcolony.sdk.AdColony;
import com.adcolony.sdk.AdColonyInterstitial;
import com.adcolony.sdk.AdColonyInterstitialListener;
import com.adcolony.sdk.ad;
import com.adcolony.sdk.ae;
import com.adcolony.sdk.af;
import com.adcolony.sdk.ag;
import com.adcolony.sdk.au;
import com.adcolony.sdk.aw;
import com.adcolony.sdk.b;
import com.adcolony.sdk.c;
import com.adcolony.sdk.d;
import com.adcolony.sdk.t;
import com.adcolony.sdk.w;
import com.adcolony.sdk.y;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/*
 * Exception performing whole class analysis.
 */
@SuppressLint(value={"SetJavaScriptEnabled"})
class aw
extends WebView
implements ag {
    static boolean a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private JSONArray v;
    private JSONObject w;
    private c x;
    private ad y;

    aw(Context context, int n2, boolean bl) {
        super(context);
        this.d = "";
        this.e = "";
        this.g = "";
        this.h = "";
        this.v = w.b();
        this.w = w.a();
        this.n = n2;
        this.q = bl;
    }

    aw(Context context, ad ad2, int n2, int n3, c c2) {
        super(context);
        this.d = "";
        this.e = "";
        this.g = "";
        this.h = "";
        this.v = w.b();
        this.w = w.a();
        this.y = ad2;
        this.a(ad2, n2, n3, c2);
        this.d();
    }

    static /* synthetic */ JSONArray a(aw aw2, JSONArray jSONArray) {
        aw2.v = jSONArray;
        return jSONArray;
    }

    static /* synthetic */ void a(aw aw2, String string) {
        aw2.b(string);
    }

    static /* synthetic */ void a(aw aw2, JSONObject jSONObject, String string) {
        aw2.a(jSONObject, string);
    }

    private void a(JSONObject jSONObject, String string) {
        Context context = com.adcolony.sdk.a.c();
        if (context != null && context instanceof b) {
            ad ad2 = new ad("AdSession.finish_fullscreen_ad", 0);
            w.b((JSONObject)jSONObject, (String)"status", (int)1);
            new y.a().a(string).a(y.g);
            ((b)context).a(ad2);
            return;
        }
        if (this.n == 1) {
            new y.a().a("Unable to communicate with controller, disabling AdColony.").a(y.g);
            AdColony.disable();
        }
    }

    static /* synthetic */ boolean a(aw aw2, boolean bl) {
        aw2.s = bl;
        return bl;
    }

    private boolean a(Exception exception) {
        new y.a().a(exception.getClass().toString()).a(" during metadata injection w/ metadata = ").a(w.b((JSONObject)this.w, (String)"metadata")).a(y.h);
        AdColonyInterstitial adColonyInterstitial = (AdColonyInterstitial)com.adcolony.sdk.a.a().l().c().remove((Object)w.b((JSONObject)this.w, (String)"ad_session_id"));
        if (adColonyInterstitial == null) {
            return false;
        }
        AdColonyInterstitialListener adColonyInterstitialListener = adColonyInterstitial.getListener();
        if (adColonyInterstitialListener == null) {
            return false;
        }
        adColonyInterstitialListener.onExpiring(adColonyInterstitial);
        adColonyInterstitial.a(true);
        return true;
    }

    private void b(Exception exception) {
        new y.a().a(exception.getClass().toString()).a(" during metadata injection w/ metadata = ").a(w.b((JSONObject)this.w, (String)"metadata")).a(y.h);
        JSONObject jSONObject = w.a();
        w.a((JSONObject)jSONObject, (String)"id", (String)this.f);
        new ad("AdSession.on_error", this.x.c(), jSONObject).b();
    }

    private void b(String string) {
        JSONArray jSONArray = w.b((String)string);
        if (jSONArray == null) {
            new y.a().a("[INTERNAL] ADCJSON parse error in dispatch_messages ").a("javascript interface function").a(y.g);
            return;
        }
        for (int i2 = 0; i2 < jSONArray.length(); ++i2) {
            com.adcolony.sdk.a.a().p().a(w.d((JSONArray)jSONArray, (int)i2));
        }
    }

    private void b(boolean bl) {
        int n2 = bl ? 0 : -1;
        this.setBackgroundColor(n2);
    }

    static /* synthetic */ boolean b(aw aw2, boolean bl) {
        aw2.u = bl;
        return bl;
    }

    static /* synthetic */ boolean d(aw aw2, boolean bl) {
        aw2.r = bl;
        return bl;
    }

    static /* synthetic */ String f(aw aw2) {
        return aw2.g;
    }

    static /* synthetic */ JSONArray g(aw aw2) {
        return aw2.v;
    }

    static /* synthetic */ boolean h(aw aw2) {
        return aw2.o;
    }

    static /* synthetic */ int i(aw aw2) {
        return aw2.n;
    }

    static /* synthetic */ boolean j(aw aw2) {
        return aw2.p;
    }

    static /* synthetic */ String k(aw aw2) {
        return aw2.e;
    }

    static /* synthetic */ boolean l(aw aw2) {
        return aw2.s;
    }

    static /* synthetic */ JSONObject m(aw aw2) {
        return aw2.w;
    }

    static /* synthetic */ ad n(aw aw2) {
        return aw2.y;
    }

    public int a() {
        return this.n;
    }

    void a(ad ad2, int n2, int n3, c c2) {
        boolean bl;
        block12 : {
            block11 : {
                JSONObject jSONObject = ad2.c();
                this.b = w.b((JSONObject)jSONObject, (String)"url");
                if (this.b.equals((Object)"")) {
                    this.b = w.b((JSONObject)jSONObject, (String)"data");
                }
                this.e = w.b((JSONObject)jSONObject, (String)"base_url");
                this.d = w.b((JSONObject)jSONObject, (String)"custom_js");
                this.f = w.b((JSONObject)jSONObject, (String)"ad_session_id");
                this.w = w.f((JSONObject)jSONObject, (String)"info");
                this.h = w.b((JSONObject)jSONObject, (String)"mraid_filepath");
                if (!this.q) {
                    try {
                        this.g = com.adcolony.sdk.a.a().j().a(this.h, false).toString();
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("bridge.os_name = \"\";\nvar ADC_DEVICE_INFO = ");
                        stringBuilder.append(this.w.toString());
                        stringBuilder.append(";\n");
                        String string = stringBuilder.toString();
                        this.g = this.g.replaceFirst("bridge.os_name\\s*=\\s*\"\"\\s*;", string);
                    }
                    catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                        this.b((Exception)indexOutOfBoundsException);
                    }
                    catch (IllegalArgumentException illegalArgumentException) {
                        this.b((Exception)illegalArgumentException);
                    }
                    catch (IOException iOException) {
                        this.b((Exception)iOException);
                    }
                }
                this.i = n2;
                this.x = c2;
                if (n3 >= 0) {
                    this.n = n3;
                } else {
                    this.e();
                }
                this.l = w.c((JSONObject)jSONObject, (String)"width");
                this.m = w.c((JSONObject)jSONObject, (String)"height");
                this.j = w.c((JSONObject)jSONObject, (String)"x");
                this.k = w.c((JSONObject)jSONObject, (String)"y");
                if (w.d((JSONObject)jSONObject, (String)"enable_messages")) break block11;
                boolean bl2 = this.p;
                bl = false;
                if (!bl2) break block12;
            }
            bl = true;
        }
        this.o = bl;
    }

    void a(ad ad2, int n2, c c2) {
        this.a(ad2, n2, -1, c2);
        this.f();
    }

    void a(String string) {
        if (this.t) {
            new y.a().a("Ignoring call to execute_js as WebView has been destroyed.").a(y.b);
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            this.evaluateJavascript(string, null);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("javascript:");
        stringBuilder.append(string);
        this.loadUrl(stringBuilder.toString());
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(JSONObject jSONObject) {
        JSONArray jSONArray;
        JSONArray jSONArray2 = jSONArray = this.v;
        synchronized (jSONArray2) {
            this.v.put((Object)jSONObject);
            return;
        }
    }

    void a(boolean bl) {
        this.t = bl;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @SuppressLint(value={"AddJavascriptInterface"})
    void a(boolean bl, ad ad2) {
        block18 : {
            JSONObject jSONObject;
            block17 : {
                String string;
                if (this.y == null) {
                    this.y = ad2;
                }
                jSONObject = this.y.c();
                this.p = bl;
                this.q = w.d((JSONObject)jSONObject, (String)"is_display_module");
                if (bl) {
                    String string2;
                    this.c = string2 = w.b((JSONObject)jSONObject, (String)"filepath");
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("file://");
                    stringBuilder.append(string2);
                    this.b = stringBuilder.toString();
                    this.w = w.f((JSONObject)jSONObject, (String)"info");
                    this.o = true;
                }
                this.setFocusable(true);
                this.setHorizontalScrollBarEnabled(false);
                this.setVerticalScrollBarEnabled(false);
                if (Build.VERSION.SDK_INT >= 19) {
                    aw.setWebContentsDebuggingEnabled((boolean)true);
                }
                this.setWebChromeClient((WebChromeClient)new 1(this, jSONObject));
                WebSettings webSettings = this.getSettings();
                webSettings.setJavaScriptEnabled(true);
                webSettings.setBuiltInZoomControls(true);
                webSettings.setGeolocationEnabled(true);
                webSettings.setUseWideViewPort(true);
                if (Build.VERSION.SDK_INT >= 17) {
                    webSettings.setMediaPlaybackRequiresUserGesture(false);
                }
                if (Build.VERSION.SDK_INT >= 16) {
                    webSettings.setAllowFileAccessFromFileURLs(true);
                    webSettings.setAllowUniversalAccessFromFileURLs(true);
                }
                a a2 = Build.VERSION.SDK_INT >= 23 ? new a(){

                    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                        if (aw.this.x != null) {
                            JSONObject jSONObject = w.a();
                            w.b((JSONObject)jSONObject, (String)"id", (int)aw.this.i);
                            w.a((JSONObject)jSONObject, (String)"ad_session_id", (String)aw.this.f);
                            w.b((JSONObject)jSONObject, (String)"container_id", (int)aw.this.x.d());
                            w.b((JSONObject)jSONObject, (String)"code", (int)webResourceError.getErrorCode());
                            w.a((JSONObject)jSONObject, (String)"error", (String)webResourceError.getDescription().toString());
                            w.a((JSONObject)jSONObject, (String)"url", (String)aw.this.b);
                            new ad("WebView.on_error", aw.this.x.c(), jSONObject).b();
                        }
                        new y.a().a("onReceivedError: ").a(webResourceError.getDescription().toString()).a(y.h);
                    }

                    /*
                     * Exception decompiling
                     */
                    public WebResourceResponse shouldInterceptRequest(WebView var1, WebResourceRequest var2) {
                        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl37 : ACONST_NULL : trying to set 0 previously set to 1
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

                    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
                        if (aw.this.r && webResourceRequest.isForMainFrame()) {
                            Uri uri = webResourceRequest.getUrl();
                            au.a((Intent)new Intent("android.intent.action.VIEW", uri));
                            JSONObject jSONObject = w.a();
                            w.a((JSONObject)jSONObject, (String)"url", (String)uri.toString());
                            new ad("WebView.redirect_detected", aw.this.x.c(), jSONObject).b();
                            return true;
                        }
                        return false;
                    }
                } : (Build.VERSION.SDK_INT >= 21 ? new a(){

                    /*
                     * Exception decompiling
                     */
                    public WebResourceResponse shouldInterceptRequest(WebView var1, WebResourceRequest var2) {
                        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl37 : ACONST_NULL : trying to set 0 previously set to 1
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
                } : new /* Unavailable Anonymous Inner Class!! */);
                this.addJavascriptInterface((Object)new 4(this), "NativeLayer");
                this.setWebViewClient((WebViewClient)a2);
                if (!this.q) break block17;
                try {
                    int n2;
                    FileInputStream fileInputStream = new FileInputStream(this.c);
                    StringBuilder stringBuilder = new StringBuilder(fileInputStream.available());
                    byte[] arrby = new byte[1024];
                    while ((n2 = fileInputStream.read(arrby, 0, 1024)) >= 0) {
                        stringBuilder.append(new String(arrby, 0, n2));
                    }
                    String string3 = stringBuilder.toString();
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("var ADC_DEVICE_INFO = ");
                    stringBuilder2.append(w.b((JSONObject)w.f((JSONObject)jSONObject, (String)"info"), (String)"metadata"));
                    stringBuilder2.append(";\n");
                    string = string3.replaceFirst("var\\s*ADC_DEVICE_INFO\\s*=\\s*null\\s*;", stringBuilder2.toString());
                }
                catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                    this.a((Exception)indexOutOfBoundsException);
                    return;
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    this.a((Exception)illegalArgumentException);
                    return;
                }
                catch (IOException iOException) {
                    this.a((Exception)iOException);
                    return;
                }
                this.loadDataWithBaseURL(this.b, string, "text/html", null, null);
                break block18;
            }
            if (!this.b.startsWith("http") && !this.b.startsWith("file")) {
                String string = this.e.equals((Object)"") ? "data" : this.e;
                String string4 = bl ? w.b((JSONObject)jSONObject, (String)"data") : this.b;
                this.loadDataWithBaseURL(string, string4, "text/html", null, null);
            } else if (!this.b.contains((CharSequence)".html")) {
                String string = this.b;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("<html><script src=\"");
                stringBuilder.append(this.b);
                stringBuilder.append("\"></script></html>");
                this.loadDataWithBaseURL(string, stringBuilder.toString(), "text/html", null, null);
            } else {
                this.loadUrl(this.b);
            }
        }
        if (!bl) {
            this.e();
            this.f();
        }
        if (bl || this.o) {
            com.adcolony.sdk.a.a().p().a((ag)this);
        }
        if (!this.d.equals((Object)"")) {
            this.a(this.d);
        }
    }

    boolean a(ad ad2) {
        JSONObject jSONObject = ad2.c();
        return w.c((JSONObject)jSONObject, (String)"id") == this.i && w.c((JSONObject)jSONObject, (String)"container_id") == this.x.d() && w.b((JSONObject)jSONObject, (String)"ad_session_id").equals((Object)this.x.b());
    }

    public void b() {
    }

    void b(ad ad2) {
        JSONObject jSONObject = ad2.c();
        this.j = w.c((JSONObject)jSONObject, (String)"x");
        this.k = w.c((JSONObject)jSONObject, (String)"y");
        this.l = w.c((JSONObject)jSONObject, (String)"width");
        this.m = w.c((JSONObject)jSONObject, (String)"height");
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)this.getLayoutParams();
        layoutParams.setMargins(this.j, this.k, 0, 0);
        layoutParams.width = this.l;
        layoutParams.height = this.m;
        this.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        if (this.p) {
            JSONObject jSONObject2 = w.a();
            w.a((JSONObject)jSONObject2, (String)"success", (boolean)true);
            w.b((JSONObject)jSONObject2, (String)"id", (int)this.n);
            ad2.a(jSONObject2).b();
        }
    }

    public void c() {
        if (com.adcolony.sdk.a.d() && this.r && !this.u) {
            this.g();
        }
    }

    void c(ad ad2) {
        if (w.d((JSONObject)ad2.c(), (String)"visible")) {
            this.setVisibility(0);
        } else {
            this.setVisibility(4);
        }
        if (this.p) {
            JSONObject jSONObject = w.a();
            w.a((JSONObject)jSONObject, (String)"success", (boolean)true);
            w.b((JSONObject)jSONObject, (String)"id", (int)this.n);
            ad2.a(jSONObject).b();
        }
    }

    void d() {
        this.a(false, null);
    }

    void e() {
        this.x.m().add((Object)com.adcolony.sdk.a.a((String)"WebView.set_visible", (af)new af(){

            public void a(ad ad2) {
                if (aw.this.a(ad2)) {
                    aw.this.c(ad2);
                }
            }
        }, (boolean)true));
        this.x.m().add((Object)com.adcolony.sdk.a.a((String)"WebView.set_bounds", (af)new af(){

            public void a(ad ad2) {
                if (aw.this.a(ad2)) {
                    aw.this.b(ad2);
                }
            }
        }, (boolean)true));
        this.x.m().add((Object)com.adcolony.sdk.a.a((String)"WebView.execute_js", (af)new af(){

            public void a(ad ad2) {
                if (aw.this.a(ad2)) {
                    aw.this.a(w.b((JSONObject)ad2.c(), (String)"custom_js"));
                }
            }
        }, (boolean)true));
        this.x.m().add((Object)com.adcolony.sdk.a.a((String)"WebView.set_transparent", (af)new af(){

            public void a(ad ad2) {
                if (aw.this.a(ad2)) {
                    aw.this.b(w.d((JSONObject)ad2.c(), (String)"transparent"));
                }
            }
        }, (boolean)true));
        this.x.n().add((Object)"WebView.set_visible");
        this.x.n().add((Object)"WebView.set_bounds");
        this.x.n().add((Object)"WebView.execute_js");
        this.x.n().add((Object)"WebView.set_transparent");
    }

    void f() {
        this.setVisibility(4);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.l, this.m);
        layoutParams.setMargins(this.j, this.k, 0, 0);
        layoutParams.gravity = 0;
        this.x.addView((View)this, (ViewGroup.LayoutParams)layoutParams);
    }

    void g() {
        au.a((Runnable)new 9(this));
    }

    boolean h() {
        return this.q;
    }

}

