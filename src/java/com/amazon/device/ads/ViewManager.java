/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.view.View$OnKeyListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 *  android.webkit.ConsoleMessage
 *  android.webkit.WebChromeClient
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  com.amazon.device.ads.MobileAdsLogger
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.HashSet
 *  java.util.Set
 */
package com.amazon.device.ads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.amazon.device.ads.AndroidTargetUtils;
import com.amazon.device.ads.MobileAdsLogger;
import com.amazon.device.ads.MobileAdsLoggerFactory;
import com.amazon.device.ads.PreloadCallback;
import com.amazon.device.ads.ThreadUtils;
import com.amazon.device.ads.WebViewFactory;
import java.util.HashSet;
import java.util.Set;

class ViewManager {
    private static final String CONTENT_DESCRIPTION_NEW_WEBVIEW = "newWebView";
    private static final String CONTENT_DESCRIPTION_ORIGINAL_WEBVIEW = "originalWebView";
    private static final String CONTENT_DESCRIPTION_PRELOADED_WEBVIEW = "preloadedWebView";
    private static final String LOGTAG = "ViewManager";
    private final AndroidTargetUtils.AndroidClassAdapter androidClassAdapter;
    private WebView currentWebView;
    private boolean disableHardwareAcceleration = false;
    private int gravity = 17;
    private final Set<String> javascriptInterfaceNames = new HashSet();
    private View.OnKeyListener keyListener;
    private final MobileAdsLogger logger = new MobileAdsLoggerFactory().createMobileAdsLogger(LOGTAG);
    private final ViewGroup parent;
    private WebView preloadedWebView;
    private WebView stashedWebView;
    private WebViewClient webViewClient;
    private final WebViewFactory webViewFactory;
    private int webViewHeight = -1;
    private int webViewWidth = -1;

    public ViewManager(ViewGroup viewGroup) {
        this(viewGroup, WebViewFactory.getInstance(), AndroidTargetUtils.getDefaultAndroidClassAdapter());
    }

    ViewManager(ViewGroup viewGroup, WebViewFactory webViewFactory, AndroidTargetUtils.AndroidClassAdapter androidClassAdapter) {
        this.parent = viewGroup;
        this.webViewFactory = webViewFactory;
        this.androidClassAdapter = androidClassAdapter;
    }

    private /* varargs */ void destroyWebViews(final WebView ... arrwebView) {
        ThreadUtils.executeOnMainThread(new Runnable(){

            public void run() {
                for (WebView webView : arrwebView) {
                    if (webView == null) continue;
                    if (webView.getParent() != null) {
                        ((ViewGroup)webView.getParent()).removeView((View)webView);
                    }
                    try {
                        webView.destroy();
                    }
                    catch (IllegalArgumentException illegalArgumentException) {
                        MobileAdsLogger mobileAdsLogger = ViewManager.this.logger;
                        Object[] arrobject = new Object[]{illegalArgumentException.getMessage()};
                        mobileAdsLogger.w("Caught an IllegalArgumentException while destroying a WebView: %s", arrobject);
                    }
                }
            }
        });
    }

    private WebView getCurrentWebView() {
        if (this.currentWebView == null) {
            WebView webView = this.createWebView(this.getContext((View)this.parent));
            if (this.validateWebView(webView)) {
                webView.setContentDescription((CharSequence)CONTENT_DESCRIPTION_ORIGINAL_WEBVIEW);
                this.setWebView(webView, false);
            } else {
                throw new IllegalStateException("Could not create WebView");
            }
        }
        return this.currentWebView;
    }

    private WebView getPreloadedWebView() {
        if (this.preloadedWebView == null) {
            this.preloadedWebView = this.createWebView(this.parent.getContext());
            this.preloadedWebView.setContentDescription((CharSequence)CONTENT_DESCRIPTION_PRELOADED_WEBVIEW);
        }
        return this.preloadedWebView;
    }

    private boolean isInitialized() {
        return this.currentWebView != null;
    }

    private void updateLayoutParamsIfNeeded() {
        if (this.isInitialized()) {
            this.setWebViewLayoutParams(this.getCurrentWebView(), this.webViewWidth, this.webViewHeight, this.gravity);
        }
    }

    public void addJavascriptInterface(Object object, boolean bl, String string) {
        this.logger.d("Add JavaScript Interface %s", new Object[]{string});
        this.javascriptInterfaceNames.add((Object)string);
        if (bl) {
            this.getPreloadedWebView().addJavascriptInterface(object, string);
            return;
        }
        this.getCurrentWebView().addJavascriptInterface(object, string);
    }

    void addViewToParent(WebView webView) {
        this.parent.addView((View)webView);
    }

    public boolean canShowViews() {
        Context context = this.getContext((View)this.parent);
        return this.webViewFactory.isWebViewOk(context);
    }

    WebView createWebView(Context context) {
        WebView webView = this.webViewFactory.createWebView(context);
        if (!this.webViewFactory.setJavaScriptEnabledForWebView(true, webView, LOGTAG)) {
            return null;
        }
        WebSettings webSettings = webView.getSettings();
        this.androidClassAdapter.withWebSettings(webSettings).setMediaPlaybackRequiresUserGesture(false);
        webView.setScrollContainer(false);
        webView.setBackgroundColor(0);
        webView.setVerticalScrollBarEnabled(false);
        webView.setHorizontalScrollBarEnabled(false);
        webView.setWebChromeClient((WebChromeClient)new AdWebChromeClient());
        webSettings.setDomStorageEnabled(true);
        if (this.disableHardwareAcceleration) {
            AndroidTargetUtils.disableHardwareAcceleration((View)webView);
        }
        return webView;
    }

    public void destroy() {
        WebView[] arrwebView = new WebView[]{this.currentWebView, this.stashedWebView, this.preloadedWebView};
        this.destroyWebViews(arrwebView);
        this.currentWebView = null;
        this.stashedWebView = null;
        this.preloadedWebView = null;
    }

    public void disableHardwareAcceleration(boolean bl) {
        this.disableHardwareAcceleration = bl;
    }

    Context getContext(View view) {
        return view.getContext();
    }

    public WebView getCurrentAdView() {
        return this.currentWebView;
    }

    public int getHeight() {
        if (this.isInitialized()) {
            return this.getCurrentWebView().getHeight();
        }
        return 0;
    }

    public void getLocationOnScreen(int[] arrn) {
        if (this.isInitialized()) {
            this.getCurrentWebView().getLocationOnScreen(arrn);
        }
    }

    public int getWidth() {
        if (this.isInitialized()) {
            return this.getCurrentWebView().getWidth();
        }
        return 0;
    }

    public void initialize() throws IllegalStateException {
        this.getCurrentWebView();
    }

    public boolean isCurrentView(View view) {
        return view.equals((Object)this.currentWebView);
    }

    public void listenForKey(View.OnKeyListener onKeyListener) {
        this.keyListener = onKeyListener;
        this.getCurrentWebView().requestFocus();
        this.getCurrentWebView().setOnKeyListener(this.keyListener);
    }

    public void loadDataWithBaseURL(String string, String string2, String string3, String string4, String string5) {
        this.loadDataWithBaseURL(string, string2, string3, string4, string5, false, null);
    }

    public void loadDataWithBaseURL(String string, String string2, String string3, String string4, String string5, boolean bl, PreloadCallback preloadCallback) {
        if (bl) {
            if (preloadCallback != null) {
                this.getPreloadedWebView().setWebViewClient((WebViewClient)new PreloadWebViewClient(preloadCallback));
            }
            this.getPreloadedWebView().loadDataWithBaseURL(string, string2, string3, string4, string5);
            return;
        }
        this.getCurrentWebView().loadDataWithBaseURL(string, string2, string3, string4, string5);
    }

    public void loadUrl(String string) {
        this.loadUrl(string, false, null);
    }

    public void loadUrl(String string, boolean bl, PreloadCallback preloadCallback) {
        if (bl) {
            if (preloadCallback != null) {
                this.getPreloadedWebView().setWebViewClient((WebViewClient)new PreloadWebViewClient(preloadCallback));
            }
            this.getPreloadedWebView().loadUrl(string);
            return;
        }
        MobileAdsLogger mobileAdsLogger = this.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Loading URL: ");
        stringBuilder.append(string);
        mobileAdsLogger.d(stringBuilder.toString());
        this.getCurrentWebView().loadUrl(string);
    }

    public boolean popView() {
        WebView webView = this.stashedWebView;
        if (webView != null) {
            this.stashedWebView = null;
            this.setWebView(webView, true);
            return true;
        }
        return false;
    }

    public void removePreviousInterfaces() {
        if (this.currentWebView != null) {
            if (AndroidTargetUtils.isAtLeastAndroidAPI(11)) {
                for (String string : this.javascriptInterfaceNames) {
                    AndroidTargetUtils.removeJavascriptInterface(this.currentWebView, string);
                }
            } else {
                this.setWebView(this.createWebView(this.parent.getContext()), true);
                this.currentWebView.setContentDescription((CharSequence)CONTENT_DESCRIPTION_ORIGINAL_WEBVIEW);
            }
        }
        this.javascriptInterfaceNames.clear();
    }

    public void setHeight(int n) {
        this.webViewHeight = n;
        this.updateLayoutParamsIfNeeded();
    }

    public void setLayoutParams(int n, int n2, int n3) {
        this.webViewWidth = n;
        this.webViewHeight = n2;
        this.gravity = n3;
        this.updateLayoutParamsIfNeeded();
    }

    void setWebView(WebView webView, boolean bl) {
        WebView webView2 = this.currentWebView;
        if (webView2 != null) {
            webView2.setOnKeyListener(null);
            webView2.setWebViewClient(new WebViewClient());
            this.parent.removeView((View)webView2);
            if (bl) {
                this.destroyWebViews(webView2);
            }
        }
        webView.setWebViewClient(this.webViewClient);
        this.currentWebView = webView;
        this.updateLayoutParamsIfNeeded();
        this.addViewToParent(this.currentWebView);
        View.OnKeyListener onKeyListener = this.keyListener;
        if (onKeyListener != null) {
            this.listenForKey(onKeyListener);
        }
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        this.webViewClient = webViewClient;
        if (this.isInitialized()) {
            this.getCurrentWebView().setWebViewClient(this.webViewClient);
        }
    }

    protected void setWebViewLayoutParams(WebView webView, int n, int n2, int n3) {
        if (webView.getLayoutParams() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(n, n2);
            layoutParams.gravity = n3;
            webView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
            return;
        }
        webView.getLayoutParams().width = n;
        webView.getLayoutParams().height = n2;
        if (webView.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams)webView.getLayoutParams()).gravity = n3;
        }
    }

    public void stashView() {
        WebView webView = this.stashedWebView;
        if (webView != null) {
            this.destroyWebViews(webView);
        }
        this.stashedWebView = this.currentWebView;
        WebView webView2 = this.preloadedWebView;
        if (webView2 == null) {
            webView2 = this.createWebView(this.parent.getContext());
            webView2.setContentDescription((CharSequence)CONTENT_DESCRIPTION_NEW_WEBVIEW);
        } else {
            this.preloadedWebView = this.createWebView(this.parent.getContext());
        }
        this.setWebView(webView2, false);
    }

    boolean validateWebView(WebView webView) {
        return webView != null;
    }

    private class AdWebChromeClient
    extends WebChromeClient {
        private AdWebChromeClient() {
        }

        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            MobileAdsLogger mobileAdsLogger = ViewManager.this.logger;
            Object[] arrobject = new Object[]{consoleMessage.lineNumber(), consoleMessage.message()};
            mobileAdsLogger.d("JS Console Message Line number %d : %s", arrobject);
            return false;
        }
    }

    private class PreloadWebViewClient
    extends WebViewClient {
        private final PreloadCallback callback;

        public PreloadWebViewClient(PreloadCallback preloadCallback) {
            this.callback = preloadCallback;
        }

        public void onPageFinished(WebView webView, String string) {
            PreloadCallback preloadCallback = this.callback;
            if (preloadCallback != null) {
                preloadCallback.onPreloadComplete(string);
            }
        }
    }

}

