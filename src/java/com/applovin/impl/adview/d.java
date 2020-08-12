/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager
 *  android.net.Uri
 *  android.view.ViewParent
 *  android.webkit.WebResourceRequest
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  com.applovin.impl.a.a
 *  com.applovin.impl.adview.AdViewControllerImpl
 *  com.applovin.impl.sdk.AppLovinAdServiceImpl
 *  com.applovin.impl.sdk.ad.g
 *  com.applovin.impl.sdk.b.b
 *  com.applovin.impl.sdk.c.d
 *  com.applovin.impl.sdk.j
 *  com.applovin.impl.sdk.p
 *  com.applovin.sdk.AppLovinAd
 *  java.lang.Boolean
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.List
 *  java.util.Set
 */
package com.applovin.impl.adview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.ViewParent;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.a.a;
import com.applovin.impl.a.b;
import com.applovin.impl.a.g;
import com.applovin.impl.a.i;
import com.applovin.impl.adview.AdViewControllerImpl;
import com.applovin.impl.adview.c;
import com.applovin.impl.sdk.AppLovinAdServiceImpl;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.p;
import com.applovin.sdk.AppLovinAd;
import java.util.List;
import java.util.Set;

class d
extends WebViewClient {
    private final j a;
    private final p b;
    private final AdViewControllerImpl c;

    public d(AdViewControllerImpl adViewControllerImpl, j j2) {
        this.a = j2;
        this.b = j2.u();
        this.c = adViewControllerImpl;
    }

    private void a() {
        this.c.a();
    }

    /*
     * Exception decompiling
     */
    private void a(Uri var1, c var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl117 : RETURN : trying to set 1 previously set to 0
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

    private void a(a a2, c c2) {
        b b2 = a2.d();
        if (b2 != null) {
            i.a(b2.c(), this.c.getSdk());
            this.a(c2, b2.a());
        }
    }

    private void a(c c2) {
        ViewParent viewParent = c2.getParent();
        if (viewParent instanceof AppLovinAdView) {
            ((AppLovinAdView)viewParent).loadNextAd();
        }
    }

    private void a(c c2, Uri uri) {
        AppLovinAd appLovinAd = c2.a();
        String string = c2.b();
        AppLovinAdView appLovinAdView = this.c.getParentView();
        if (appLovinAdView != null && appLovinAd != null) {
            com.applovin.impl.sdk.c.d d2 = c2.c();
            if (d2 != null) {
                d2.b();
            }
            this.c.a(appLovinAd, string, appLovinAdView, uri);
            return;
        }
        p p2 = this.b;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Attempting to track click that is null or not an ApplovinAdView instance for clickedUri = ");
        stringBuilder.append((Object)uri);
        p2.d("AdWebViewClient", stringBuilder.toString());
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean a(WebView webView, String string, boolean bl) {
        String string2;
        p p2;
        block22 : {
            block20 : {
                Uri uri;
                c c2;
                block23 : {
                    a a2;
                    block19 : {
                        AppLovinAd appLovinAd;
                        block21 : {
                            String string3;
                            String string4;
                            block17 : {
                                String string5;
                                block18 : {
                                    p p3 = this.b;
                                    StringBuilder stringBuilder = new StringBuilder();
                                    stringBuilder.append("Processing click on ad URL \"");
                                    stringBuilder.append(string);
                                    stringBuilder.append("\"");
                                    p3.b("AdWebViewClient", stringBuilder.toString());
                                    if (string == null || !(webView instanceof c)) return true;
                                    uri = Uri.parse((String)string);
                                    c2 = (c)webView;
                                    string3 = uri.getScheme();
                                    string4 = uri.getHost();
                                    string5 = uri.getPath();
                                    appLovinAd = this.c.getCurrentAd();
                                    if (!"applovin".equals((Object)string3) || !"com.applovin.sdk".equals((Object)string4)) break block17;
                                    if ("/adservice/next_ad".equals((Object)string5)) {
                                        this.a(c2);
                                        return true;
                                    }
                                    if ("/adservice/close_ad".equals((Object)string5)) {
                                        this.a();
                                        return true;
                                    }
                                    if ("/adservice/expand_ad".equals((Object)string5)) {
                                        this.b();
                                        return true;
                                    }
                                    if ("/adservice/contract_ad".equals((Object)string5)) {
                                        this.c();
                                        return true;
                                    }
                                    if (AppLovinAdServiceImpl.URI_NO_OP.equals((Object)string5)) {
                                        return true;
                                    }
                                    if (AppLovinAdServiceImpl.URI_LOAD_URL.equals((Object)string5)) {
                                        this.a(uri, c2);
                                        return true;
                                    }
                                    if (!AppLovinAdServiceImpl.URI_TRACK_CLICK_IMMEDIATELY.equals((Object)string5)) break block18;
                                    if (!(appLovinAd instanceof a)) {
                                        this.a(c2, Uri.parse((String)AppLovinAdServiceImpl.URI_TRACK_CLICK_IMMEDIATELY));
                                        return true;
                                    }
                                    a2 = (a)appLovinAd;
                                    break block19;
                                }
                                if (string5 != null && string5.startsWith("/launch/")) {
                                    List list = uri.getPathSegments();
                                    if (list == null || list.size() <= 1) return true;
                                    {
                                        String string6 = (String)list.get(list.size() - 1);
                                        try {
                                            Context context = webView.getContext();
                                            context.startActivity(context.getPackageManager().getLaunchIntentForPackage(string6));
                                            this.a(c2, null);
                                            return true;
                                        }
                                        catch (Exception exception) {
                                            p p4 = this.b;
                                            StringBuilder stringBuilder = new StringBuilder();
                                            stringBuilder.append("Threw Exception Trying to Launch App for Package: ");
                                            stringBuilder.append(string6);
                                            p4.b("AdWebViewClient", stringBuilder.toString(), (Throwable)exception);
                                            return true;
                                        }
                                    }
                                }
                                p p5 = this.b;
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("Unknown URL: ");
                                stringBuilder.append(string);
                                p5.c("AdWebViewClient", stringBuilder.toString());
                                p p6 = this.b;
                                StringBuilder stringBuilder2 = new StringBuilder();
                                stringBuilder2.append("Path: ");
                                stringBuilder2.append(string5);
                                p6.c("AdWebViewClient", stringBuilder2.toString());
                                return true;
                            }
                            if (!bl) {
                                return false;
                            }
                            if (!(appLovinAd instanceof com.applovin.impl.sdk.ad.g)) break block20;
                            com.applovin.impl.sdk.ad.g g2 = (com.applovin.impl.sdk.ad.g)appLovinAd;
                            List list = g2.as();
                            List list2 = g2.at();
                            if (!(!list.isEmpty() && !list.contains((Object)string3) || !list2.isEmpty() && !list2.contains((Object)string4))) break block21;
                            p2 = this.b;
                            string2 = "URL is not whitelisted - bypassing click";
                            break block22;
                        }
                        if (!(appLovinAd instanceof a) || !(a2 = (a)appLovinAd).i()) break block23;
                    }
                    this.a(a2, c2);
                    return true;
                }
                this.a(c2, uri);
                return true;
            }
            p2 = this.b;
            string2 = "Bypassing click for ad of invalid type";
        }
        p2.d("AdWebViewClient", string2);
        return true;
    }

    private void b() {
        this.c.expandAd();
    }

    private void c() {
        this.c.contractAd();
    }

    public void onPageFinished(WebView webView, String string) {
        super.onPageFinished(webView, string);
        this.c.onAdHtmlLoaded(webView);
    }

    @TargetApi(value=24)
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        boolean bl = (Boolean)this.a.a(com.applovin.impl.sdk.b.b.ce) != false ? webResourceRequest.hasGesture() : true;
        Uri uri = webResourceRequest.getUrl();
        if (uri != null) {
            return this.a(webView, uri.toString(), bl);
        }
        this.b.d("AdWebViewClient", "No url found for request");
        return false;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String string) {
        return this.a(webView, string, true);
    }
}

