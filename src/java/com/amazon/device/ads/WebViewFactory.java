/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.webkit.CookieManager
 *  android.webkit.CookieSyncManager
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  com.amazon.device.ads.MobileAdsLogger
 *  java.lang.Boolean
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.amazon.device.ads;

import android.annotation.SuppressLint;
import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.amazon.device.ads.AndroidTargetUtils;
import com.amazon.device.ads.DebugProperties;
import com.amazon.device.ads.DeviceInfo;
import com.amazon.device.ads.MobileAdsInfoStore;
import com.amazon.device.ads.MobileAdsLogger;
import com.amazon.device.ads.MobileAdsLoggerFactory;
import com.amazon.device.ads.RegistrationInfo;

class WebViewFactory {
    private static WebViewFactory instance = new WebViewFactory();
    private final MobileAdsCookieManager cookieManager;
    private final DebugProperties debugProperties;
    private final MobileAdsInfoStore infoStore;
    private final MobileAdsLoggerFactory loggerFactory;
    private final WebViewConstructor webViewConstructor;
    private boolean webViewDebugging = false;

    protected WebViewFactory() {
        this(MobileAdsInfoStore.getInstance(), new MobileAdsLoggerFactory(), DebugProperties.getInstance(), new MobileAdsCookieManager(), new WebViewConstructor());
    }

    WebViewFactory(MobileAdsInfoStore mobileAdsInfoStore, MobileAdsLoggerFactory mobileAdsLoggerFactory, DebugProperties debugProperties, MobileAdsCookieManager mobileAdsCookieManager, WebViewConstructor webViewConstructor) {
        this.infoStore = mobileAdsInfoStore;
        this.loggerFactory = mobileAdsLoggerFactory;
        this.debugProperties = debugProperties;
        this.cookieManager = mobileAdsCookieManager;
        this.webViewConstructor = webViewConstructor;
    }

    public static final WebViewFactory getInstance() {
        return instance;
    }

    private void shouldDebugWebViews() {
        boolean bl = this.debugProperties.getDebugPropertyAsBoolean("debug.webViews", this.webViewDebugging);
        if (bl != this.webViewDebugging) {
            this.webViewDebugging = bl;
            AndroidTargetUtils.enableWebViewDebugging(this.webViewDebugging);
        }
    }

    private void updateAdIdCookie() {
        if (this.cookieManager.isCookieSyncManagerCreated()) {
            String string = this.infoStore.getRegistrationInfo().getAdId();
            if (string == null) {
                string = "";
            }
            MobileAdsCookieManager mobileAdsCookieManager = this.cookieManager;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ad-id=");
            stringBuilder.append(string);
            stringBuilder.append("; Domain=.amazon-adsystem.com");
            mobileAdsCookieManager.setCookie("http://amazon-adsystem.com", stringBuilder.toString());
        }
    }

    public WebView createWebView(Context context) {
        WebViewFactory webViewFactory = this;
        synchronized (webViewFactory) {
            this.shouldDebugWebViews();
            Context context2 = context.getApplicationContext();
            WebView webView = this.webViewConstructor.createWebView(context2);
            this.infoStore.getDeviceInfo().setUserAgentString(webView.getSettings().getUserAgentString());
            webView.getSettings().setUserAgentString(this.infoStore.getDeviceInfo().getUserAgentString());
            this.cookieManager.createCookieSyncManager(context);
            this.updateAdIdCookie();
            return webView;
        }
    }

    /*
     * Exception decompiling
     */
    public boolean isWebViewOk(Context var1) {
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

    @SuppressLint(value={"SetJavaScriptEnabled"})
    public boolean setJavaScriptEnabledForWebView(boolean bl, WebView webView, String string) {
        try {
            webView.getSettings().setJavaScriptEnabled(bl);
            return true;
        }
        catch (NullPointerException nullPointerException) {
            this.loggerFactory.createMobileAdsLogger(string).w("Could not set JavaScriptEnabled because a NullPointerException was encountered.");
            return false;
        }
    }

    static class MobileAdsCookieManager {
        private boolean cookieSyncManagerCreated = false;

        MobileAdsCookieManager() {
        }

        public void createCookieSyncManager(Context context) {
            if (!this.cookieSyncManagerCreated) {
                CookieSyncManager.createInstance((Context)context);
                this.cookieSyncManagerCreated = true;
            }
        }

        public boolean isCookieSyncManagerCreated() {
            return this.cookieSyncManagerCreated;
        }

        public void setCookie(String string, String string2) {
            CookieManager.getInstance().setCookie(string, string2);
        }

        public void startSync() {
            CookieSyncManager.getInstance().startSync();
        }

        public void stopSync() {
            CookieSyncManager.getInstance().stopSync();
        }
    }

    static class WebViewConstructor {
        WebViewConstructor() {
        }

        public WebView createWebView(Context context) {
            return new WebView(context);
        }
    }

}

