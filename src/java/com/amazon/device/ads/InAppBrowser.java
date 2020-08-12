/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Configuration
 *  android.graphics.Bitmap
 *  android.graphics.BitmapFactory
 *  android.util.DisplayMetrics
 *  android.view.Display
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.Window
 *  android.view.WindowManager
 *  android.webkit.WebChromeClient
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  android.widget.ImageButton
 *  android.widget.ImageView
 *  android.widget.ImageView$ScaleType
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Void
 *  java.util.concurrent.atomic.AtomicBoolean
 */
package com.amazon.device.ads;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.amazon.device.ads.AdActivity;
import com.amazon.device.ads.AndroidTargetUtils;
import com.amazon.device.ads.Assets;
import com.amazon.device.ads.DeviceInfo;
import com.amazon.device.ads.InAppBrowser;
import com.amazon.device.ads.LayoutFactory;
import com.amazon.device.ads.MobileAdsInfoStore;
import com.amazon.device.ads.MobileAdsLogger;
import com.amazon.device.ads.MobileAdsLoggerFactory;
import com.amazon.device.ads.Settings;
import com.amazon.device.ads.StringUtils;
import com.amazon.device.ads.ThreadUtils;
import com.amazon.device.ads.WebUtils2;
import com.amazon.device.ads.WebViewFactory;
import java.util.concurrent.atomic.AtomicBoolean;

class InAppBrowser
implements AdActivity.AdActivityAdapter {
    protected static final int BUTTON_SIZE_DP = 50;
    private static final String CONTENT_DESCRIPTION_BACK_BUTTON = "inAppBrowserBackButton";
    private static final String CONTENT_DESCRIPTION_BUTTON_LAYOUT = "inAppBrowserButtonLayout";
    private static final String CONTENT_DESCRIPTION_CLOSE_BUTTON = "inAppBrowserCloseButton";
    private static final String CONTENT_DESCRIPTION_FORWARD_BUTTON = "inAppBrowserForwardButton";
    private static final String CONTENT_DESCRIPTION_HORZ_RULE = "inAppBrowserHorizontalRule";
    private static final String CONTENT_DESCRIPTION_MAIN_LAYOUT = "inAppBrowserMainLayout";
    private static final String CONTENT_DESCRIPTION_OPEN_EXT_BRWSR_BUTTON = "inAppBrowserOpenExternalBrowserButton";
    private static final String CONTENT_DESCRIPTION_REFRESH_BUTTON = "inAppBrowserRefreshButton";
    private static final String CONTENT_DESCRIPTION_RELATIVE_LAYOUT = "inAppBrowserRelativeLayout";
    private static final String CONTENT_DESCRIPTION_WEB_VIEW = "inAppBrowserWebView";
    protected static final int HORIZONTAL_RULE_SIZE_DP = 3;
    protected static final String LOGTAG = "InAppBrowser";
    protected static final String SHOW_OPEN_EXTERNAL_BROWSER_BTN = "extra_open_btn";
    protected static final String URL_EXTRA = "extra_url";
    private Activity activity;
    private final Assets assets;
    private ImageButton browserBackButton;
    private ImageButton browserForwardButton;
    private final AtomicBoolean buttonsCreated = new AtomicBoolean(false);
    private ImageButton closeButton;
    private final WebViewFactory.MobileAdsCookieManager cookieManager;
    private final MobileAdsInfoStore infoStore;
    private final LayoutFactory layoutFactory;
    private final MobileAdsLogger logger;
    private ImageButton openExternalBrowserButton;
    private ImageButton refreshButton;
    private final Settings settings;
    private boolean showOpenExternalBrowserButton;
    private final ThreadUtils.ThreadRunner threadRunner;
    private final WebUtils2 webUtils;
    private WebView webView;
    private final WebViewFactory webViewFactory;

    InAppBrowser() {
        this(new WebUtils2(), WebViewFactory.getInstance(), new MobileAdsLoggerFactory(), MobileAdsInfoStore.getInstance(), Settings.getInstance(), Assets.getInstance(), new LayoutFactory(), new WebViewFactory.MobileAdsCookieManager(), ThreadUtils.getThreadRunner());
    }

    InAppBrowser(WebUtils2 webUtils2, WebViewFactory webViewFactory, MobileAdsLoggerFactory mobileAdsLoggerFactory, MobileAdsInfoStore mobileAdsInfoStore, Settings settings, Assets assets, LayoutFactory layoutFactory, WebViewFactory.MobileAdsCookieManager mobileAdsCookieManager, ThreadUtils.ThreadRunner threadRunner) {
        this.webUtils = webUtils2;
        this.webViewFactory = webViewFactory;
        this.logger = mobileAdsLoggerFactory.createMobileAdsLogger(LOGTAG);
        this.infoStore = mobileAdsInfoStore;
        this.settings = settings;
        this.assets = assets;
        this.layoutFactory = layoutFactory;
        this.cookieManager = mobileAdsCookieManager;
        this.threadRunner = threadRunner;
    }

    static /* synthetic */ MobileAdsLogger access$000(InAppBrowser inAppBrowser) {
        return inAppBrowser.logger;
    }

    static /* synthetic */ WebUtils2 access$100(InAppBrowser inAppBrowser) {
        return inAppBrowser.webUtils;
    }

    static /* synthetic */ Activity access$200(InAppBrowser inAppBrowser) {
        return inAppBrowser.activity;
    }

    static /* synthetic */ void access$300(InAppBrowser inAppBrowser, WebView webView) {
        inAppBrowser.updateNavigationButtons(webView);
    }

    static /* synthetic */ WebView access$400(InAppBrowser inAppBrowser) {
        return inAppBrowser.webView;
    }

    private ImageButton createButton(String string, int n2, int n3, int n4, int n5) {
        ImageButton imageButton = new ImageButton((Context)this.activity);
        imageButton.setImageBitmap(BitmapFactory.decodeFile((String)string));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(n4, n5);
        layoutParams.addRule(n2, n3);
        layoutParams.addRule(12);
        imageButton.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        imageButton.setBackgroundColor(0);
        imageButton.setScaleType(ImageView.ScaleType.FIT_CENTER);
        return imageButton;
    }

    private void enableCookies() {
        this.cookieManager.createCookieSyncManager((Context)this.activity);
        this.cookieManager.startSync();
    }

    @SuppressLint(value={"InlinedApi"})
    private void initialize(Intent intent) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.getMetrics(displayMetrics);
        float f2 = displayMetrics.density;
        int n2 = (int)(0.5f + 50.0f * f2);
        int n3 = (int)(0.5f + f2 * 3.0f);
        int n4 = this.showOpenExternalBrowserButton ? 5 : 4;
        int n5 = Math.min((int)(displayMetrics.widthPixels / n4), (int)(n2 * 2));
        ViewGroup viewGroup = this.layoutFactory.createLayout((Context)this.activity, LayoutFactory.LayoutType.RELATIVE_LAYOUT, CONTENT_DESCRIPTION_BUTTON_LAYOUT);
        viewGroup.setId(10280);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, n2 + n3);
        layoutParams.addRule(12);
        viewGroup.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        viewGroup.setBackgroundColor(-986896);
        ThreadUtils.ThreadRunner threadRunner = this.threadRunner;
        LoadButtonsTask loadButtonsTask = new LoadButtonsTask(intent, viewGroup, n5, n2);
        threadRunner.executeAsyncTask(loadButtonsTask, (T[])new Void[0]);
        View view = new View((Context)this.activity);
        view.setContentDescription((CharSequence)CONTENT_DESCRIPTION_HORZ_RULE);
        view.setBackgroundColor(-3355444);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, n3);
        layoutParams2.addRule(10);
        view.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
        viewGroup.addView(view);
        this.webView = this.webViewFactory.createWebView((Context)this.activity);
        WebSettings webSettings = this.webView.getSettings();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.infoStore.getDeviceInfo().getUserAgentString());
        stringBuilder.append("-inAppBrowser");
        webSettings.setUserAgentString(stringBuilder.toString());
        this.webView.setContentDescription((CharSequence)CONTENT_DESCRIPTION_WEB_VIEW);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams3.addRule(2, viewGroup.getId());
        this.webView.setLayoutParams((ViewGroup.LayoutParams)layoutParams3);
        ViewGroup viewGroup2 = this.layoutFactory.createLayout((Context)this.activity, LayoutFactory.LayoutType.RELATIVE_LAYOUT, CONTENT_DESCRIPTION_RELATIVE_LAYOUT);
        viewGroup2.setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -2));
        viewGroup2.addView((View)this.webView);
        viewGroup2.addView((View)viewGroup);
        LinearLayout linearLayout = (LinearLayout)this.layoutFactory.createLayout((Context)this.activity, LayoutFactory.LayoutType.LINEAR_LAYOUT, CONTENT_DESCRIPTION_MAIN_LAYOUT);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -1));
        linearLayout.addView((View)viewGroup2);
        this.activity.setContentView((View)linearLayout);
    }

    private void initializeButtons(Intent intent) {
        this.browserBackButton.setOnClickListener(new View.OnClickListener(this){
            final /* synthetic */ InAppBrowser this$0;
            {
                this.this$0 = inAppBrowser;
            }

            public void onClick(View view) {
                if (InAppBrowser.access$400(this.this$0).canGoBack()) {
                    InAppBrowser.access$400(this.this$0).goBack();
                }
            }
        });
        this.browserForwardButton.setOnClickListener(new View.OnClickListener(this){
            final /* synthetic */ InAppBrowser this$0;
            {
                this.this$0 = inAppBrowser;
            }

            public void onClick(View view) {
                if (InAppBrowser.access$400(this.this$0).canGoForward()) {
                    InAppBrowser.access$400(this.this$0).goForward();
                }
            }
        });
        this.refreshButton.setOnClickListener(new View.OnClickListener(this){
            final /* synthetic */ InAppBrowser this$0;
            {
                this.this$0 = inAppBrowser;
            }

            public void onClick(View view) {
                InAppBrowser.access$400(this.this$0).reload();
            }
        });
        this.closeButton.setOnClickListener(new View.OnClickListener(this){
            final /* synthetic */ InAppBrowser this$0;
            {
                this.this$0 = inAppBrowser;
            }

            public void onClick(View view) {
                InAppBrowser.access$200(this.this$0).finish();
            }
        });
        if (this.showOpenExternalBrowserButton) {
            String string = intent.getStringExtra(URL_EXTRA);
            this.openExternalBrowserButton.setOnClickListener(new View.OnClickListener(this, string){
                final /* synthetic */ InAppBrowser this$0;
                final /* synthetic */ String val$originalUrl;
                {
                    this.this$0 = inAppBrowser;
                    this.val$originalUrl = string;
                }

                public void onClick(View view) {
                    String string = InAppBrowser.access$400(this.this$0).getUrl();
                    if (string == null) {
                        InAppBrowser.access$000(this.this$0).w("The current URL is null. Reverting to the original URL for external browser.");
                        string = this.val$originalUrl;
                    }
                    InAppBrowser.access$100(this.this$0).launchActivityForIntentLink(string, InAppBrowser.access$400(this.this$0).getContext());
                }
            });
        }
    }

    private void initializeWebView(Intent intent) {
        this.webViewFactory.setJavaScriptEnabledForWebView(true, this.webView, LOGTAG);
        this.webView.loadUrl(intent.getStringExtra(URL_EXTRA));
        this.webView.setWebViewClient(new WebViewClient(this){
            final /* synthetic */ InAppBrowser this$0;
            {
                this.this$0 = inAppBrowser;
            }

            public void onReceivedError(WebView webView, int n2, String string, String string2) {
                InAppBrowser.access$000(this.this$0).w("InApp Browser error: %s", string);
            }

            public boolean shouldOverrideUrlLoading(WebView webView, String string) {
                if (StringUtils.isNullOrWhiteSpace(string)) {
                    return false;
                }
                String string2 = InAppBrowser.access$100(this.this$0).getScheme(string);
                if (!string2.equals((Object)"http")) {
                    if (string2.equals((Object)"https")) {
                        return false;
                    }
                    return InAppBrowser.access$100(this.this$0).launchActivityForIntentLink(string, (Context)InAppBrowser.access$200(this.this$0));
                }
                return false;
            }
        });
        this.webView.setWebChromeClient(new WebChromeClient(this){
            final /* synthetic */ InAppBrowser this$0;
            {
                this.this$0 = inAppBrowser;
            }

            public void onProgressChanged(WebView webView, int n2) {
                InAppBrowser.access$200(this.this$0).setTitle((CharSequence)"Loading...");
                InAppBrowser.access$200(this.this$0).setProgress(n2 * 100);
                if (n2 == 100) {
                    InAppBrowser.access$200(this.this$0).setTitle((CharSequence)webView.getUrl());
                }
                InAppBrowser.access$300(this.this$0, webView);
            }
        });
    }

    private void updateNavigationButtons(WebView webView) {
        if (this.browserBackButton != null && this.browserForwardButton != null) {
            if (webView.canGoBack()) {
                AndroidTargetUtils.setImageButtonAlpha(this.browserBackButton, 255);
            } else {
                AndroidTargetUtils.setImageButtonAlpha(this.browserBackButton, 102);
            }
            if (webView.canGoForward()) {
                AndroidTargetUtils.setImageButtonAlpha(this.browserForwardButton, 255);
                return;
            }
            AndroidTargetUtils.setImageButtonAlpha(this.browserForwardButton, 102);
        }
    }

    void getMetrics(DisplayMetrics displayMetrics) {
        ((WindowManager)this.activity.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
    }

    @Override
    public boolean onBackPressed() {
        return false;
    }

    @Override
    public void onConfigurationChanged(Configuration configuration) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.getMetrics(displayMetrics);
        int n2 = (int)(0.5f + 50.0f * displayMetrics.density);
        int n3 = this.showOpenExternalBrowserButton ? 5 : 4;
        int n4 = Math.min((int)(displayMetrics.widthPixels / n3), (int)(n2 * 2));
        MobileAdsLogger mobileAdsLogger = this.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Width: ");
        stringBuilder.append(displayMetrics.widthPixels);
        stringBuilder.append(" ButtonWidth: ");
        stringBuilder.append(n4);
        mobileAdsLogger.d(stringBuilder.toString());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(n4, n2);
        if (this.browserBackButton != null) {
            layoutParams.addRule(9);
            layoutParams.addRule(12);
            this.browserBackButton.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        }
        if (this.browserForwardButton != null) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(n4, n2);
            layoutParams2.addRule(1, this.browserBackButton.getId());
            layoutParams2.addRule(12);
            this.browserForwardButton.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
        }
        if (this.closeButton != null) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(n4, n2);
            layoutParams3.addRule(11);
            layoutParams3.addRule(12);
            this.closeButton.setLayoutParams((ViewGroup.LayoutParams)layoutParams3);
        }
        if (this.openExternalBrowserButton != null) {
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(n4, n2);
            layoutParams4.addRule(1, this.browserForwardButton.getId());
            layoutParams4.addRule(12);
            this.openExternalBrowserButton.setLayoutParams((ViewGroup.LayoutParams)layoutParams4);
            if (this.refreshButton != null) {
                RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(n4, n2);
                layoutParams5.addRule(1, this.openExternalBrowserButton.getId());
                layoutParams5.addRule(12);
                this.refreshButton.setLayoutParams((ViewGroup.LayoutParams)layoutParams5);
                return;
            }
        } else if (this.refreshButton != null) {
            RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(n4, n2);
            layoutParams6.addRule(1, this.browserForwardButton.getId());
            layoutParams6.addRule(12);
            this.refreshButton.setLayoutParams((ViewGroup.LayoutParams)layoutParams6);
        }
    }

    @Override
    public void onCreate() {
        this.activity.getWindow().requestFeature(2);
        this.activity.getWindow().setFeatureInt(2, -1);
        Intent intent = this.activity.getIntent();
        this.showOpenExternalBrowserButton = intent.getBooleanExtra(SHOW_OPEN_EXTERNAL_BROWSER_BTN, false);
        this.initialize(intent);
        this.initializeWebView(intent);
        this.enableCookies();
    }

    @Override
    public void onDestroy() {
        this.webView.destroy();
        this.activity.finish();
    }

    @Override
    public void onPause() {
        this.logger.d("onPause");
        this.webView.onPause();
        if (this.settings.getBoolean("shouldPauseWebViewTimersInWebViewRelatedActivities", false)) {
            this.webView.pauseTimers();
        }
        this.cookieManager.stopSync();
    }

    @Override
    public void onResume() {
        this.logger.d("onResume");
        this.webView.onResume();
        if (this.settings.getBoolean("shouldPauseWebViewTimersInWebViewRelatedActivities", false)) {
            this.webView.resumeTimers();
        }
        this.cookieManager.startSync();
    }

    @Override
    public void onStop() {
    }

    @Override
    public void onWindowFocusChanged() {
    }

    @Override
    public void preOnCreate() {
    }

    @Override
    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    class LoadButtonsTask
    extends ThreadUtils.MobileAdsAsyncTask<Void, Void, Void> {
        private final int buttonHeight;
        private final int buttonWidth;
        private final Intent intent;
        private final ViewGroup layout;

        public LoadButtonsTask(Intent intent, ViewGroup viewGroup, int n2, int n3) {
            this.intent = intent;
            this.layout = viewGroup;
            this.buttonWidth = n2;
            this.buttonHeight = n3;
        }

        protected /* varargs */ Void doInBackground(Void ... arrvoid) {
            InAppBrowser inAppBrowser = InAppBrowser.this;
            inAppBrowser.browserBackButton = inAppBrowser.createButton(inAppBrowser.assets.getFilePath("amazon_ads_leftarrow.png"), 9, -1, this.buttonWidth, this.buttonHeight);
            InAppBrowser.this.browserBackButton.setContentDescription((CharSequence)InAppBrowser.CONTENT_DESCRIPTION_BACK_BUTTON);
            InAppBrowser.this.browserBackButton.setId(10537);
            InAppBrowser inAppBrowser2 = InAppBrowser.this;
            inAppBrowser2.browserForwardButton = inAppBrowser2.createButton(inAppBrowser2.assets.getFilePath("amazon_ads_rightarrow.png"), 1, InAppBrowser.this.browserBackButton.getId(), this.buttonWidth, this.buttonHeight);
            InAppBrowser.this.browserForwardButton.setContentDescription((CharSequence)InAppBrowser.CONTENT_DESCRIPTION_FORWARD_BUTTON);
            InAppBrowser.this.browserForwardButton.setId(10794);
            InAppBrowser inAppBrowser3 = InAppBrowser.this;
            inAppBrowser3.closeButton = inAppBrowser3.createButton(inAppBrowser3.assets.getFilePath("amazon_ads_close.png"), 11, -1, this.buttonWidth, this.buttonHeight);
            InAppBrowser.this.closeButton.setContentDescription((CharSequence)InAppBrowser.CONTENT_DESCRIPTION_CLOSE_BUTTON);
            if (InAppBrowser.this.showOpenExternalBrowserButton) {
                InAppBrowser inAppBrowser4 = InAppBrowser.this;
                inAppBrowser4.openExternalBrowserButton = inAppBrowser4.createButton(inAppBrowser4.assets.getFilePath("amazon_ads_open_external_browser.png"), 1, InAppBrowser.this.browserForwardButton.getId(), this.buttonWidth, this.buttonHeight);
                InAppBrowser.this.openExternalBrowserButton.setContentDescription((CharSequence)InAppBrowser.CONTENT_DESCRIPTION_OPEN_EXT_BRWSR_BUTTON);
                InAppBrowser.this.openExternalBrowserButton.setId(10795);
                InAppBrowser inAppBrowser5 = InAppBrowser.this;
                inAppBrowser5.refreshButton = inAppBrowser5.createButton(inAppBrowser5.assets.getFilePath("amazon_ads_refresh.png"), 1, InAppBrowser.this.openExternalBrowserButton.getId(), this.buttonWidth, this.buttonHeight);
            } else {
                InAppBrowser inAppBrowser6 = InAppBrowser.this;
                inAppBrowser6.refreshButton = inAppBrowser6.createButton(inAppBrowser6.assets.getFilePath("amazon_ads_refresh.png"), 1, InAppBrowser.this.browserForwardButton.getId(), this.buttonWidth, this.buttonHeight);
            }
            InAppBrowser.this.refreshButton.setContentDescription((CharSequence)InAppBrowser.CONTENT_DESCRIPTION_REFRESH_BUTTON);
            return null;
        }

        @Override
        protected void onPostExecute(Void void_) {
            this.layout.addView((View)InAppBrowser.this.browserBackButton);
            this.layout.addView((View)InAppBrowser.this.browserForwardButton);
            this.layout.addView((View)InAppBrowser.this.refreshButton);
            this.layout.addView((View)InAppBrowser.this.closeButton);
            if (InAppBrowser.this.showOpenExternalBrowserButton) {
                this.layout.addView((View)InAppBrowser.this.openExternalBrowserButton);
            }
            InAppBrowser.this.initializeButtons(this.intent);
            InAppBrowser.this.buttonsCreated.set(true);
        }
    }

}

