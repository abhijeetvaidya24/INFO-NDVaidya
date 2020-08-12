/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.graphics.Bitmap
 *  android.net.Uri
 *  android.os.AsyncTask
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Handler
 *  android.view.ContextThemeWrapper
 *  android.view.KeyEvent
 *  android.view.View
 *  android.view.View$OnSystemUiVisibilityChangeListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 *  android.view.Window
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  android.widget.ProgressBar
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  com.ironsource.sdk.agent.IronSourceAdsPublisherAgent
 *  com.ironsource.sdk.controller.IronSourceWebView
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.StackTraceElement
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.Iterator
 *  java.util.List
 */
package com.ironsource.sdk.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.ironsource.sdk.agent.IronSourceAdsPublisherAgent;
import com.ironsource.sdk.controller.IronSourceWebView;
import com.ironsource.sdk.utils.IronSourceAsyncHttpRequestTask;
import com.ironsource.sdk.utils.IronSourceSharedPrefHelper;
import com.ironsource.sdk.utils.Logger;
import com.ironsource.sdk.utils.SDKUtils;
import java.util.Iterator;
import java.util.List;

public class OpenUrlActivity
extends Activity {
    private static final int PROGRESS_BAR_VIEW_ID;
    private static final int WEB_VIEW_VIEW_ID;
    private final Runnable decorViewSettings = new Runnable(){

        public void run() {
            OpenUrlActivity.this.getWindow().getDecorView().setSystemUiVisibility(SDKUtils.getActivityUIFlags(OpenUrlActivity.this.mIsImmersive));
        }
    };
    boolean isSecondaryWebview;
    private boolean mIsImmersive = false;
    private ProgressBar mProgressBar;
    private Handler mUiThreadHandler = new Handler();
    private String mUrl;
    private IronSourceWebView mWebViewController;
    private RelativeLayout mainLayout;
    private WebView webView = null;

    static {
        WEB_VIEW_VIEW_ID = SDKUtils.generateViewId();
        PROGRESS_BAR_VIEW_ID = SDKUtils.generateViewId();
    }

    private void createProgressBarForWebView() {
        if (this.mProgressBar == null) {
            this.mProgressBar = Build.VERSION.SDK_INT >= 11 ? new ProgressBar((Context)new ContextThemeWrapper((Context)this, 16973939)) : new ProgressBar((Context)this);
            this.mProgressBar.setId(PROGRESS_BAR_VIEW_ID);
        }
        if (this.findViewById(PROGRESS_BAR_VIEW_ID) == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            this.mProgressBar.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
            this.mProgressBar.setVisibility(4);
            this.mainLayout.addView((View)this.mProgressBar);
        }
    }

    private void createWebView() {
        if (this.webView == null) {
            this.webView = new WebView(this.getApplicationContext());
            this.webView.setId(WEB_VIEW_VIEW_ID);
            this.webView.getSettings().setJavaScriptEnabled(true);
            this.webView.setWebViewClient((WebViewClient)new Client());
            this.loadUrl(this.mUrl);
        }
        if (this.findViewById(WEB_VIEW_VIEW_ID) == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            this.mainLayout.addView((View)this.webView, (ViewGroup.LayoutParams)layoutParams);
        }
        this.createProgressBarForWebView();
        IronSourceWebView ironSourceWebView = this.mWebViewController;
        if (ironSourceWebView != null) {
            ironSourceWebView.viewableChange(true, "secondary");
        }
    }

    private void destroyWebView() {
        WebView webView = this.webView;
        if (webView != null) {
            webView.destroy();
        }
    }

    private void hideActivityTitle() {
        this.requestWindowFeature(1);
    }

    private void hideActivtiyStatusBar() {
        this.getWindow().setFlags(1024, 1024);
    }

    private void removeWebViewFromLayout() {
        IronSourceWebView ironSourceWebView = this.mWebViewController;
        if (ironSourceWebView != null) {
            ViewGroup viewGroup;
            ironSourceWebView.viewableChange(false, "secondary");
            if (this.mainLayout != null && (viewGroup = (ViewGroup)this.webView.getParent()) != null) {
                if (viewGroup.findViewById(WEB_VIEW_VIEW_ID) != null) {
                    viewGroup.removeView((View)this.webView);
                }
                if (viewGroup.findViewById(PROGRESS_BAR_VIEW_ID) != null) {
                    viewGroup.removeView((View)this.mProgressBar);
                }
            }
        }
    }

    public void finish() {
        if (this.isSecondaryWebview) {
            this.mWebViewController.engageEnd("secondaryClose");
        }
        super.finish();
    }

    public void loadUrl(String string) {
        this.webView.stopLoading();
        this.webView.clearHistory();
        try {
            this.webView.loadUrl(string);
            return;
        }
        catch (Throwable throwable) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("OpenUrlActivity:: loadUrl: ");
            stringBuilder.append(throwable.toString());
            Logger.e("OpenUrlActivity", stringBuilder.toString());
            IronSourceAsyncHttpRequestTask ironSourceAsyncHttpRequestTask = new IronSourceAsyncHttpRequestTask();
            Object[] arrobject = new String[1];
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("https://www.supersonicads.com/mobile/sdk5/log?method=");
            stringBuilder2.append(throwable.getStackTrace()[0].getMethodName());
            arrobject[0] = stringBuilder2.toString();
            ironSourceAsyncHttpRequestTask.execute(arrobject);
            return;
        }
    }

    public void onBackPressed() {
        if (this.webView.canGoBack()) {
            this.webView.goBack();
            return;
        }
        super.onBackPressed();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Logger.i("OpenUrlActivity", "onCreate()");
        try {
            this.mWebViewController = IronSourceAdsPublisherAgent.getInstance((Activity)this).getWebViewController();
            this.hideActivityTitle();
            this.hideActivtiyStatusBar();
            Bundle bundle2 = this.getIntent().getExtras();
            this.mUrl = bundle2.getString(IronSourceWebView.EXTERNAL_URL);
            this.isSecondaryWebview = bundle2.getBoolean(IronSourceWebView.SECONDARY_WEB_VIEW);
            this.mIsImmersive = this.getIntent().getBooleanExtra("immersive", false);
            if (this.mIsImmersive) {
                this.getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener(){

                    public void onSystemUiVisibilityChange(int n2) {
                        if ((n2 & 4098) == 0) {
                            OpenUrlActivity.this.mUiThreadHandler.removeCallbacks(OpenUrlActivity.this.decorViewSettings);
                            OpenUrlActivity.this.mUiThreadHandler.postDelayed(OpenUrlActivity.this.decorViewSettings, 500L);
                        }
                    }
                });
                this.runOnUiThread(this.decorViewSettings);
            }
            this.mainLayout = new RelativeLayout((Context)this);
            this.setContentView((View)this.mainLayout, new ViewGroup.LayoutParams(-1, -1));
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            this.finish();
            return;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        this.destroyWebView();
    }

    public boolean onKeyDown(int n2, KeyEvent keyEvent) {
        if (this.mIsImmersive && (n2 == 25 || n2 == 24)) {
            this.mUiThreadHandler.postDelayed(this.decorViewSettings, 500L);
        }
        return super.onKeyDown(n2, keyEvent);
    }

    protected void onPause() {
        super.onPause();
        this.removeWebViewFromLayout();
    }

    protected void onResume() {
        super.onResume();
        this.createWebView();
    }

    public void onWindowFocusChanged(boolean bl2) {
        super.onWindowFocusChanged(bl2);
        if (this.mIsImmersive && bl2) {
            this.runOnUiThread(this.decorViewSettings);
        }
    }

    private class Client
    extends WebViewClient {
        private Client() {
        }

        public void onPageFinished(WebView webView, String string) {
            super.onPageFinished(webView, string);
            OpenUrlActivity.this.mProgressBar.setVisibility(4);
        }

        public void onPageStarted(WebView webView, String string, Bitmap bitmap) {
            super.onPageStarted(webView, string, bitmap);
            OpenUrlActivity.this.mProgressBar.setVisibility(0);
        }

        public void onReceivedError(WebView webView, int n2, String string, String string2) {
            super.onReceivedError(webView, n2, string, string2);
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String string) {
            List<String> list = IronSourceSharedPrefHelper.getSupersonicPrefHelper().getSearchKeys();
            if (list != null && !list.isEmpty()) {
                Iterator iterator = list.iterator();
                while (iterator.hasNext()) {
                    if (!string.contains((CharSequence)((String)iterator.next()))) continue;
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse((String)string));
                    OpenUrlActivity.this.startActivity(intent);
                    OpenUrlActivity.this.mWebViewController.interceptedUrlToStore();
                    OpenUrlActivity.this.finish();
                    return true;
                }
            }
            return super.shouldOverrideUrlLoading(webView, string);
        }
    }

}

