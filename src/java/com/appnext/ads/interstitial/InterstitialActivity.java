/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Handler
 *  android.text.TextUtils
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 *  android.webkit.JavascriptInterface
 *  android.webkit.WebChromeClient
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  android.widget.RelativeLayout
 *  com.appnext.ads.interstitial.InterstitialAd
 *  com.appnext.core.AppnextAd
 *  java.io.Serializable
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.appnext.ads.interstitial;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import com.appnext.R;
import com.appnext.ads.interstitial.Interstitial;
import com.appnext.ads.interstitial.InterstitialActivity;
import com.appnext.ads.interstitial.InterstitialAd;
import com.appnext.ads.interstitial.c;
import com.appnext.core.Ad;
import com.appnext.core.AppnextActivity;
import com.appnext.core.AppnextAd;
import com.appnext.core.callbacks.OnAdClicked;
import com.appnext.core.callbacks.OnAdClosed;
import com.appnext.core.e;
import com.appnext.core.f;
import com.appnext.core.k;
import com.appnext.core.p;
import com.appnext.core.q;
import com.appnext.core.result.ResultPageActivity;
import com.appnext.core.result.d;
import com.appnext.core.webview.AppnextWebView;
import com.appnext.core.webview.WebAppInterface;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class InterstitialActivity
extends AppnextActivity {
    private AppnextAd aE;
    private com.appnext.ads.b aF;
    private ArrayList<AppnextAd> ads;
    private Boolean autoPlay;
    protected WebView bP;
    private boolean bQ = false;
    private Interstitial bR;
    private InterstitialAd bS;
    private String bT = "";
    private int bU = 0;
    private Handler bV;
    private e.a bW;
    private WebAppInterface bX;
    private boolean bY = false;
    private boolean bZ = false;
    private String ca;
    private Boolean canClose;
    private String cc = "";
    private boolean cd = false;
    private Runnable ce = new Runnable(this){
        final /* synthetic */ InterstitialActivity cf;
        {
            this.cf = interstitialActivity;
        }

        public final void run() {
            InterstitialActivity.l(this.cf);
        }
    };
    private boolean closed = false;
    private Boolean mute;

    private static String a(int n2) {
        Object[] arrobject = new Object[]{n2 & 16777215};
        return String.format((String)"#%06X", (Object[])arrobject);
    }

    static /* synthetic */ String a(InterstitialActivity interstitialActivity, String string2) {
        interstitialActivity.cc = string2;
        return string2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static /* synthetic */ void a(InterstitialActivity interstitialActivity) {
        WebAppInterface webAppInterface;
        com.appnext.core.webview.a a2;
        AppnextWebView appnextWebView;
        String string2;
        String string3;
        try {
            appnextWebView = AppnextWebView.u((Context)interstitialActivity);
            ArrayList<AppnextAd> arrayList = interstitialActivity.ads;
            String string4 = arrayList != null ? "fullscreen" : "interstitial";
            interstitialActivity.bP = appnextWebView.aj(string4);
            string2 = interstitialActivity.bR.getPageUrl();
            webAppInterface = interstitialActivity.w();
            a2 = interstitialActivity.bR.getFallback();
            string3 = interstitialActivity.ads != null ? "fullscreen" : "interstitial";
        }
        catch (Throwable throwable) {
            interstitialActivity.onError("Internal error");
            interstitialActivity.finish();
            return;
        }
        interstitialActivity.bP = appnextWebView.a((Context)interstitialActivity, string2, webAppInterface, a2, string3);
        interstitialActivity.bP.setWebViewClient(new WebViewClient(interstitialActivity){
            final /* synthetic */ InterstitialActivity cf;
            {
                this.cf = interstitialActivity;
            }

            public final void onPageFinished(WebView webView, String string2) {
                super.onPageFinished(webView, string2);
                InterstitialActivity.k(this.cf).removeCallbacksAndMessages(null);
                InterstitialActivity.l(this.cf);
            }

            public final boolean shouldOverrideUrlLoading(WebView webView, String string2) {
                if (string2 == null) {
                    return false;
                }
                if (string2.startsWith("http")) {
                    webView.loadUrl(string2);
                    return true;
                }
                return super.shouldOverrideUrlLoading(webView, string2);
            }
        });
        interstitialActivity.bP.setWebChromeClient(new WebChromeClient(interstitialActivity){
            final /* synthetic */ InterstitialActivity cf;
            {
                this.cf = interstitialActivity;
            }

            public final boolean onConsoleMessage(android.webkit.ConsoleMessage consoleMessage) {
                new StringBuilder("console ").append(consoleMessage.message());
                if (!consoleMessage.message().contains((CharSequence)"pause") && (consoleMessage.message().contains((CharSequence)"TypeError") || consoleMessage.message().contains((CharSequence)"has no method") || consoleMessage.message().contains((CharSequence)"is not a function"))) {
                    this.cf.onError("Internal error");
                    this.cf.finish();
                }
                return true;
            }
        });
    }

    protected static void a(String string2, String string3, String string4) {
    }

    static /* synthetic */ void b(InterstitialActivity interstitialActivity, String string2) {
        com.appnext.ads.interstitial.a.G();
        AppnextAd appnextAd = (AppnextAd)com.appnext.ads.interstitial.a.parseAd(string2);
        if (appnextAd != null) {
            interstitialActivity.aE = new InterstitialAd(appnextAd);
            Interstitial interstitial = interstitialActivity.bR;
            if (interstitial != null && interstitial.getOnAdClickedCallback() != null) {
                interstitialActivity.bR.getOnAdClickedCallback().adClicked();
            }
            interstitialActivity.b(interstitialActivity.aE, interstitialActivity.bW);
            interstitialActivity.report("click_event");
            String string3 = interstitialActivity.aE.getBannerID();
            InterstitialAd interstitialAd = interstitialActivity.bS;
            String string4 = interstitialAd != null ? interstitialAd.getBannerID() : "";
            if (string3.equals((Object)string4)) {
                if (!interstitialActivity.bY) {
                    interstitialActivity.bY = true;
                    interstitialActivity.report("interstitial_main_click");
                    return;
                }
            } else if (!interstitialActivity.bZ) {
                interstitialActivity.bZ = true;
                interstitialActivity.report("interstitial_suggested_click");
            }
        }
    }

    private String d(String string2) {
        String string3 = c.K().get(string2);
        if (string3 == null) {
            string3 = "";
        }
        return string3;
    }

    static /* synthetic */ void d(InterstitialActivity interstitialActivity, String string2) {
        interstitialActivity.report(string2);
    }

    private void e(String string2) {
        com.appnext.ads.interstitial.a.G();
        AppnextAd appnextAd = (AppnextAd)com.appnext.ads.interstitial.a.parseAd(string2);
        if (appnextAd == null) {
            return;
        }
        this.aE = new InterstitialAd(appnextAd);
        Interstitial interstitial = this.bR;
        if (interstitial != null && interstitial.getOnAdClickedCallback() != null) {
            this.bR.getOnAdClickedCallback().adClicked();
        }
        this.b(this.aE, this.bW);
        this.report("click_event");
        String string3 = this.aE.getBannerID();
        InterstitialAd interstitialAd = this.bS;
        String string4 = interstitialAd != null ? interstitialAd.getBannerID() : "";
        if (string3.equals((Object)string4)) {
            if (!this.bY) {
                this.bY = true;
                this.report("interstitial_main_click");
                return;
            }
        } else if (!this.bZ) {
            this.bZ = true;
            this.report("interstitial_suggested_click");
        }
    }

    private static boolean hasVideo(AppnextAd appnextAd) {
        return !appnextAd.getVideoUrl().equals((Object)"") || !appnextAd.getVideoUrlHigh().equals((Object)"") || !appnextAd.getVideoUrl30Sec().equals((Object)"") || !appnextAd.getVideoUrlHigh30Sec().equals((Object)"");
        {
        }
    }

    static /* synthetic */ void l(InterstitialActivity interstitialActivity) {
        Handler handler = interstitialActivity.bV;
        if (handler != null) {
            handler.removeCallbacks(interstitialActivity.ce);
        }
        interstitialActivity.bQ = true;
        interstitialActivity.bT = interstitialActivity.getIntent().getExtras().getString("creative");
        String string2 = interstitialActivity.bT;
        if (string2 == null || string2.equals((Object)"managed")) {
            interstitialActivity.bT = interstitialActivity.d("creative");
        }
        new Thread(new Runnable(interstitialActivity){
            final /* synthetic */ InterstitialActivity cf;
            {
                this.cf = interstitialActivity;
            }

            public final void run() {
                this.cf.x();
            }
        }).start();
        WebView webView = interstitialActivity.bP;
        if (webView == null) {
            interstitialActivity.onError("Internal error");
            interstitialActivity.finish();
            return;
        }
        if (webView.getParent() != null) {
            ((ViewGroup)interstitialActivity.bP.getParent()).removeView((View)interstitialActivity.bP);
        }
        interstitialActivity.go.addView((View)interstitialActivity.bP);
        interstitialActivity.bP.getLayoutParams().width = -1;
        interstitialActivity.bP.getLayoutParams().height = -1;
    }

    private void loadJS(String string2) {
        this.runOnUiThread(new Runnable(this, string2){
            final /* synthetic */ InterstitialActivity cf;
            final /* synthetic */ String cg;
            {
                this.cf = interstitialActivity;
                this.cg = string2;
            }

            public final void run() {
                if (this.cf.bP != null) {
                    WebView webView = this.cf.bP;
                    StringBuilder stringBuilder = new StringBuilder("javascript:(function() { try { ");
                    stringBuilder.append(this.cg);
                    stringBuilder.append("} catch(err){ Appnext.jsError(err.message); }})()");
                    webView.loadUrl(stringBuilder.toString());
                }
            }
        });
    }

    static /* synthetic */ void n(InterstitialActivity interstitialActivity) {
        interstitialActivity.onClose();
    }

    private void onClose() {
        Interstitial interstitial = this.bR;
        if (interstitial != null && interstitial.getOnAdClosedCallback() != null) {
            this.bR.getOnAdClosedCallback().onAdClosed();
        }
    }

    private void pageFinished() {
        Handler handler = this.bV;
        if (handler != null) {
            handler.removeCallbacks(this.ce);
        }
        this.bQ = true;
        this.bT = this.getIntent().getExtras().getString("creative");
        String string2 = this.bT;
        if (string2 == null || string2.equals((Object)"managed")) {
            this.bT = this.d("creative");
        }
        new Thread(new /* invalid duplicate definition of identical inner class */).start();
        WebView webView = this.bP;
        if (webView == null) {
            this.onError("Internal error");
            this.finish();
            return;
        }
        if (webView.getParent() != null) {
            ((ViewGroup)this.bP.getParent()).removeView((View)this.bP);
        }
        this.go.addView((View)this.bP);
        this.bP.getLayoutParams().width = -1;
        this.bP.getLayoutParams().height = -1;
    }

    private void play() {
        this.loadJS("Appnext.Layout.Video.play();");
    }

    private void report(String string2) {
        Interstitial interstitial = this.bR;
        if (interstitial != null) {
            String string3 = interstitial.getTID();
            String string4 = this.bR.getVID();
            String string5 = this.bR.getAUID();
            String string6 = this.bR.getPlacementID();
            String string7 = this.bR.getSessionId();
            InterstitialAd interstitialAd = this.bS;
            String string8 = interstitialAd != null ? interstitialAd.getBannerID() : "";
            InterstitialAd interstitialAd2 = this.bS;
            String string9 = interstitialAd2 != null ? interstitialAd2.getCampaignID() : "";
            f.a(string3, string4, string5, string6, string7, string2, "current_interstitial", string8, string9);
        }
    }

    private void stop() {
        WebView webView = this.bP;
        if (webView != null) {
            webView.loadUrl("javascript:(function() { Appnext.Layout.Video.pause();})()");
        }
    }

    static /* synthetic */ int u(InterstitialActivity interstitialActivity) {
        int n2 = interstitialActivity.bU;
        interstitialActivity.bU = n2 + 1;
        return n2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void v() {
        WebAppInterface webAppInterface;
        com.appnext.core.webview.a a2;
        AppnextWebView appnextWebView;
        String string2;
        String string3;
        try {
            appnextWebView = AppnextWebView.u((Context)this);
            ArrayList<AppnextAd> arrayList = this.ads;
            String string4 = arrayList != null ? "fullscreen" : "interstitial";
            this.bP = appnextWebView.aj(string4);
            string2 = this.bR.getPageUrl();
            webAppInterface = this.w();
            a2 = this.bR.getFallback();
            string3 = this.ads != null ? "fullscreen" : "interstitial";
        }
        catch (Throwable throwable) {
            this.onError("Internal error");
            this.finish();
            return;
        }
        this.bP = appnextWebView.a((Context)this, string2, webAppInterface, a2, string3);
        this.bP.setWebViewClient(new /* invalid duplicate definition of identical inner class */);
        this.bP.setWebChromeClient(new /* invalid duplicate definition of identical inner class */);
    }

    static /* synthetic */ q y(InterstitialActivity interstitialActivity) {
        return interstitialActivity.userAction;
    }

    static /* synthetic */ q z(InterstitialActivity interstitialActivity) {
        return interstitialActivity.userAction;
    }

    @Override
    protected final void b(AppnextAd appnextAd, e.a a2) {
        this.a((ViewGroup)this.go, this.getResources().getDrawable(R.drawable.apnxt_loader));
        super.b(appnextAd, a2);
    }

    @Override
    protected final p getConfig() {
        return c.K();
    }

    public void onBackPressed() {
        Boolean bl = this.canClose;
        if (bl != null ? bl != false : Boolean.parseBoolean((String)this.d("can_close"))) {
            this.loadJS("Appnext.Layout.destroy('internal');");
            this.closed = true;
            this.onClose();
            this.finish();
        }
    }

    @Override
    protected void onCreate(Bundle bundle) {
        this.setRequestedOrientation(7);
        super.onCreate(bundle);
        if (Interstitial.currentAd == null) {
            this.finish();
            return;
        }
        this.bR = new Interstitial(Interstitial.currentAd);
        if (this.getRequestedOrientation() == 6) {
            this.report("loaded_landscape");
        } else {
            this.report("loaded_portrait");
        }
        this.go = new RelativeLayout((Context)this);
        this.setContentView((View)this.go);
        this.go.getLayoutParams().width = -1;
        this.go.getLayoutParams().height = -1;
        this.go.setBackgroundColor(-1);
        try {
            this.placementID = this.getIntent().getExtras().getString("id");
        }
        catch (Throwable throwable) {
            this.finish();
            return;
        }
        if (this.getIntent().hasExtra("auto_play")) {
            this.autoPlay = this.getIntent().getBooleanExtra("auto_play", true);
            if (this.autoPlay.booleanValue()) {
                this.report("auto_play_on");
            } else {
                this.report("auto_play_off");
            }
        }
        if (this.getIntent().hasExtra("can_close")) {
            this.canClose = this.getIntent().getBooleanExtra("can_close", false);
        }
        if (this.getIntent().hasExtra("mute")) {
            this.mute = this.getIntent().getBooleanExtra("mute", true);
            if (this.mute.booleanValue()) {
                this.report("mute_on");
            } else {
                this.report("mute_off");
            }
        }
        if (this.getIntent().hasExtra("pview")) {
            this.gm = this.getIntent().getStringExtra("pview");
            this.banner = this.getIntent().getStringExtra("banner");
            this.guid = this.getIntent().getStringExtra("guid");
        }
        if (this.getIntent().getSerializableExtra("ads") != null) {
            this.ads = (ArrayList)this.getIntent().getSerializableExtra("ads");
        }
        this.bV = new Handler();
        AppnextWebView.u((Context)this).a(this.bR.getPageUrl(), new AppnextWebView.c(){

            @Override
            public final void error(String string2) {
                InterstitialActivity.a(InterstitialActivity.this);
            }

            @Override
            public final void f(String string2) {
                InterstitialActivity.a(InterstitialActivity.this);
            }
        });
        this.bW = new e.a(){

            @Override
            public final void error(String string2) {
                if (InterstitialActivity.this.handler != null) {
                    InterstitialActivity.this.handler.removeCallbacks(null);
                }
                InterstitialActivity.this.aY();
                InterstitialActivity.this.placementID;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(new InterstitialAd(InterstitialActivity.this.aE).getAppURL());
                stringBuilder.append(" ");
                stringBuilder.append(string2);
            }

            @Override
            public final void onMarket(String string2) {
                new StringBuilder("marketUrl ").append(string2);
                if (InterstitialActivity.this.handler != null) {
                    InterstitialActivity.this.handler.removeCallbacks(null);
                }
                InterstitialActivity.this.aY();
            }
        };
        this.userAction = new q((Context)this, new q.a(){

            @Override
            public final Ad e() {
                return InterstitialActivity.this.bR;
            }

            @Override
            public final AppnextAd f() {
                return InterstitialActivity.this.aE;
            }

            @Override
            public final p g() {
                return InterstitialActivity.this.getConfig();
            }

            @Override
            public final void report(String string2) {
            }
        });
        new Thread(new Runnable(this){
            final /* synthetic */ InterstitialActivity cf;
            {
                this.cf = interstitialActivity;
            }

            public final void run() {
                InterstitialActivity interstitialActivity = this.cf;
                InterstitialActivity.a(interstitialActivity, f.b((Context)interstitialActivity, true));
            }
        }).start();
    }

    /*
     * Exception decompiling
     */
    @Override
    protected void onDestroy() {
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

    @Override
    protected final void onError(String string2) {
        this.runOnUiThread(new Runnable(this, string2){
            final /* synthetic */ String bN;
            final /* synthetic */ InterstitialActivity cf;
            {
                this.cf = interstitialActivity;
                this.bN = string2;
            }

            public final void run() {
                if (InterstitialActivity.j(this.cf) != null && InterstitialActivity.j(this.cf).getOnAdErrorCallback() != null) {
                    InterstitialActivity.j(this.cf).getOnAdErrorCallback().adError(this.bN);
                }
            }
        });
    }

    protected void onPause() {
        WebView webView;
        super.onPause();
        if (!this.closed && (webView = this.bP) != null) {
            webView.loadUrl("javascript:(function() { Appnext.Layout.Video.pause();})()");
        }
    }

    protected void onResume() {
        Boolean bl;
        super.onResume();
        if (this.cd) {
            this.onClose();
            this.finish();
            return;
        }
        if (this.bQ && (bl = this.autoPlay) != null && bl.booleanValue()) {
            this.loadJS("Appnext.Layout.Video.play();");
        }
        try {
            this.bP.loadUrl("javascript:(function() { try{Appnext.countToClose();}catch(e){}})()");
        }
        catch (Throwable throwable) {}
    }

    protected final WebAppInterface w() {
        if (this.bX == null) {
            this.bX = new WebInterface();
        }
        return this.bX;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    protected final void x() {
        block13 : {
            block12 : {
                block11 : {
                    block10 : {
                        block9 : {
                            block8 : {
                                var27_1 = this;
                                // MONITORENTER : var27_1
                                var4_2 = com.appnext.ads.interstitial.a.G().b((Context)this, this.bR, this.bT);
                                if (var4_2 == null) {
                                    this.finish();
                                    this.onError("No Ads");
                                    // MONITOREXIT : var27_1
                                    return;
                                }
                                var5_3 = com.appnext.ads.interstitial.a.G().a(var4_2);
                                if (var5_3 == null) {
                                    this.finish();
                                    this.onError("No Ads");
                                    // MONITOREXIT : var27_1
                                    return;
                                }
                                this.ca = var6_4 = var5_3.replace((CharSequence)"\u2028", (CharSequence)"\\u2028").replace((CharSequence)"\u2029", (CharSequence)"\\u2029");
                                this.bS = new InterstitialAd((AppnextAd)var4_2.get(0));
                                var8_5 = this.y();
                                var9_6 = (AppnextAd)var4_2.get(0);
                                var10_7 = var9_6.getVideoUrl().equals((Object)"");
                                var11_8 = true;
                                if (var10_7 && var9_6.getVideoUrlHigh().equals((Object)"") && var9_6.getVideoUrl30Sec().equals((Object)"") && var9_6.getVideoUrlHigh30Sec().equals((Object)"")) break block8;
                                break block9;
                                catch (Throwable var1_16) {
                                    this.finish();
                                    this.onError("Internal error");
                                    f.b(var1_16);
                                    // MONITOREXIT : var27_1
                                    return;
                                }
                            }
                            var12_9 = false;
                            break block10;
                        }
                        var12_9 = true;
                    }
                    if (!var12_9) break block11;
                    var13_10 = new StringBuilder();
                    if (this.autoPlay == null || !this.autoPlay.booleanValue()) break block12;
                    break block13;
                }
                var8_5.put("remote_auto_play", (Object)"false");
lbl45: // 2 sources:
                do {
                    var16_11 = new InterstitialAd((AppnextAd)var4_2.get(0));
                    var17_12 = var16_11.getButtonText().equals((Object)"") ? (f.c((Context)this, var16_11.getAdPackage()) ? this.d("existing_button_text") : this.d("new_button_text")) : var16_11.getButtonText();
                    var8_5.put("b_title", (Object)var17_12);
                    var19_13 = new StringBuilder("Appnext.setParams(");
                    var19_13.append(var8_5.toString());
                    var19_13.append(");");
                    this.loadJS(var19_13.toString());
                    var22_14 = new StringBuilder("Appnext.loadInterstitial(");
                    var22_14.append(var6_4);
                    var22_14.append(");");
                    this.loadJS(var22_14.toString());
                    com.appnext.ads.interstitial.a.G().a(this.bS.getBannerID(), Interstitial.currentAd);
                    this.handler.post(new Runnable(this){
                        final /* synthetic */ InterstitialActivity cf;
                        {
                            this.cf = interstitialActivity;
                        }

                        public final void run() {
                            if (Interstitial.currentAd != null && Interstitial.currentAd.getOnAdOpenedCallback() != null) {
                                Interstitial.currentAd.getOnAdOpenedCallback().adOpened();
                            }
                        }
                    });
                    // MONITOREXIT : var27_1
                    return;
                    break;
                } while (true);
            }
            var11_8 = false;
        }
        var13_10.append(var11_8);
        var8_5.put("remote_auto_play", (Object)var13_10.toString());
        ** while (true)
    }

    /*
     * Exception decompiling
     */
    protected final JSONObject y() throws JSONException {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl438 : ALOAD_2 : trying to set 1 previously set to 0
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

    protected class WebInterface
    extends WebAppInterface {
        public WebInterface() {
            super((Context)InterstitialActivity.this);
        }

        @JavascriptInterface
        @Override
        public void destroy(String string2) {
            if (string2.equals((Object)"c_close")) {
                InterstitialActivity.this.cd = true;
                InterstitialActivity.this.runOnUiThread(new Runnable(this){
                    final /* synthetic */ WebInterface ci;
                    {
                        this.ci = webInterface;
                    }

                    public final void run() {
                        try {
                            JSONObject jSONObject = new JSONObject(InterstitialActivity.m(this.ci.InterstitialActivity.this).getAdJSON());
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append(jSONObject.getString("urlApp"));
                            stringBuilder.append("&tem_id=156");
                            jSONObject.put("urlApp", (Object)stringBuilder.toString());
                            InterstitialActivity.b(this.ci.InterstitialActivity.this, jSONObject.toString());
                            return;
                        }
                        catch (JSONException jSONException) {
                            InterstitialActivity.b(this.ci.InterstitialActivity.this, InterstitialActivity.m(this.ci.InterstitialActivity.this).getAdJSON());
                            return;
                        }
                    }
                });
                return;
            }
            if (string2.equals((Object)"close")) {
                InterstitialActivity.this.runOnUiThread(new Runnable(this){
                    final /* synthetic */ WebInterface ci;
                    {
                        this.ci = webInterface;
                    }

                    public final void run() {
                        InterstitialActivity.n(this.ci.InterstitialActivity.this);
                        this.ci.InterstitialActivity.this.finish();
                    }
                });
                return;
            }
            InterstitialActivity.this.runOnUiThread(new Runnable(this){
                final /* synthetic */ WebInterface ci;
                {
                    this.ci = webInterface;
                }

                public final void run() {
                    this.ci.InterstitialActivity.this.onError("Ad Not Ready");
                    this.ci.InterstitialActivity.this.finish();
                }
            });
        }

        @JavascriptInterface
        @Override
        public String filterAds(String string2) {
            return string2;
        }

        @JavascriptInterface
        @Override
        public void gotoAppWall() {
        }

        @JavascriptInterface
        @Override
        public void jsError(String string2) {
            if (TextUtils.isEmpty((CharSequence)string2) && (string2.contains((CharSequence)"is not a function") || string2.contains((CharSequence)"has no method"))) {
                if (InterstitialActivity.u(InterstitialActivity.this) < 5) {
                    InterstitialActivity.this.bV.postDelayed(InterstitialActivity.this.ce, 500L);
                    return;
                }
                InterstitialActivity.this.onError("Internal error");
                InterstitialActivity.this.finish();
                return;
            }
            new StringBuilder("jsError ").append(string2);
            InterstitialActivity.this.onError("Internal error");
            InterstitialActivity.this.finish();
        }

        @JavascriptInterface
        @Override
        public String loadAds() {
            return "";
        }

        @JavascriptInterface
        @Override
        public void logSTP(String string2, String string3) {
            f.a(InterstitialActivity.this.bR, (AppnextAd)InterstitialActivity.this.bS, string2, string3, InterstitialActivity.this.getConfig());
        }

        @JavascriptInterface
        @Override
        public void notifyImpression(String string2) {
            super.notifyImpression(string2);
            if (InterstitialActivity.this.bS != null) {
                InterstitialActivity.this.bS.setImpressionURL(string2);
                InterstitialActivity.this.handler.postDelayed(new Runnable(string2){
                    AppnextAd ch;
                    {
                        this.ch = new InterstitialAd((AppnextAd)InterstitialActivity.this.bS);
                        ((InterstitialAd)this.ch).setImpressionURL(string2);
                    }

                    /*
                     * Exception decompiling
                     */
                    public final void run() {
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
                }, 1000L * Long.parseLong((String)InterstitialActivity.this.getConfig().get("postpone_impression_sec")));
            }
            if (InterstitialActivity.this.autoPlay != null && InterstitialActivity.this.autoPlay.booleanValue()) {
                this.play();
            }
        }

        @JavascriptInterface
        @Override
        public void openLink(String string2) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse((String)string2));
            InterstitialActivity.this.startActivity(intent);
        }

        @JavascriptInterface
        @Override
        public void openResultPage(String string2) {
            d.bp().a(new com.appnext.core.result.c(){

                @Override
                public final String A() {
                    return com.appnext.ads.interstitial.a.G().l(InterstitialActivity.this.bR);
                }

                @Override
                public final String B() {
                    return InterstitialActivity.this.ca;
                }

                @Override
                public final p C() {
                    return InterstitialActivity.this.getConfig();
                }

                @Override
                public final Ad D() {
                    return InterstitialActivity.this.bR;
                }

                @Override
                public final com.appnext.core.result.a E() {
                    return new com.appnext.core.result.a(){

                        @Override
                        public final Object F() {
                            return null;
                        }

                        @Override
                        public final String getFallbackScript() {
                            return null;
                        }

                        @Override
                        public final String getJSurl() {
                            return "https://cdn.appnext.com/tools/sdk/interstitial/v75/result.min.js";
                        }

                        @Override
                        public final WebViewClient getWebViewClient() {
                            return null;
                        }
                    };
                }

                @Override
                public final JSONObject getConfigParams() throws JSONException {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("vid", (Object)"2.5.0.472");
                    Interstitial interstitial = InterstitialActivity.this.bR;
                    String string2 = "";
                    String string3 = interstitial == null ? string2 : InterstitialActivity.this.bR.getTID();
                    jSONObject.put("tid", (Object)string3);
                    if (InterstitialActivity.this.bR != null) {
                        string2 = InterstitialActivity.this.bR.getAUID();
                    }
                    jSONObject.put("auid", (Object)string2);
                    jSONObject.put("osid", (Object)"100");
                    jSONObject.put("tem_id", (Object)"1601");
                    jSONObject.put("id", (Object)this.getPlacementId());
                    jSONObject.put("cat", (Object)InterstitialActivity.this.bS.getCategories());
                    jSONObject.put("pview", (Object)InterstitialActivity.this.getConfig().get("pview"));
                    jSONObject.put("devn", (Object)f.bc());
                    jSONObject.put("dosv", Build.VERSION.SDK_INT);
                    jSONObject.put("dds", (Object)"0");
                    jSONObject.put("ads_type", (Object)"banner");
                    jSONObject.put("country", (Object)InterstitialActivity.this.bS.getCountry());
                    jSONObject.put("gdpr", k.a((AppnextAd)InterstitialActivity.this.bS, InterstitialActivity.this.getConfig()));
                    return jSONObject;
                }

                @Override
                public final String getPlacementId() {
                    return InterstitialActivity.this.placementID;
                }

                @Override
                public final AppnextAd getSelectedAd() {
                    return InterstitialActivity.this.bS;
                }

                @Override
                public final String z() {
                    return "160";
                }

            });
            Intent intent = new Intent((Context)InterstitialActivity.this, ResultPageActivity.class);
            intent.putExtra("shouldClose", false);
            intent.setFlags(65536);
            InterstitialActivity.this.startActivity(intent);
        }

        @JavascriptInterface
        @Override
        public void openStore(String string2) {
            InterstitialActivity.this.runOnUiThread(new Runnable(this, string2){
                final /* synthetic */ WebInterface ci;
                final /* synthetic */ String cj;
                {
                    this.ci = webInterface;
                    this.cj = string2;
                }

                public final void run() {
                    InterstitialActivity.b(this.ci.InterstitialActivity.this, this.cj);
                }
            });
        }

        @JavascriptInterface
        @Override
        public void play() {
            InterstitialActivity.this.placementID;
            InterstitialActivity.this.loadJS("Appnext.Layout.Video.play();");
        }

        @JavascriptInterface
        @Override
        public void postView(String string2) {
            String string3 = InterstitialActivity.this.ads != null ? "false" : InterstitialActivity.this.d("pview");
            if (Boolean.parseBoolean((String)string3)) {
                InterstitialActivity.this.handler.postDelayed(new Runnable(string2){
                    AppnextAd ch;
                    {
                        try {
                            com.appnext.ads.interstitial.a.G();
                            this.ch = (AppnextAd)com.appnext.ads.interstitial.a.parseAd(string2);
                        }
                        catch (Throwable throwable) {}
                    }

                    public final void run() {
                        InterstitialActivity.this.a(this.ch, null);
                    }
                }, 1000L * Long.parseLong((String)InterstitialActivity.this.getConfig().get("postpone_vta_sec")));
            }
        }

        @JavascriptInterface
        @Override
        public void videoPlayed() {
        }

    }

}

