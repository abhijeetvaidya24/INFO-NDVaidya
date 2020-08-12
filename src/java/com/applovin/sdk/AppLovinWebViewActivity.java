/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.view.View
 *  android.view.Window
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Set
 */
package com.applovin.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.applovin.impl.sdk.e.j;
import com.applovin.impl.sdk.p;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkSettings;
import java.util.Set;

public class AppLovinWebViewActivity
extends Activity {
    public static final String EVENT_DISMISSED_VIA_BACK_BUTTON = "dismissed_via_back_button";
    public static final String INTENT_EXTRA_KEY_IMMERSIVE_MODE_ON = "immersive_mode_on";
    public static final String INTENT_EXTRA_KEY_SDK_KEY = "sdk_key";
    private WebView a;
    private EventListener b;

    public void loadUrl(String string2, EventListener eventListener) {
        this.b = eventListener;
        this.a.loadUrl(string2);
    }

    public void onBackPressed() {
        EventListener eventListener = this.b;
        if (eventListener != null) {
            eventListener.onReceivedEvent(EVENT_DISMISSED_VIA_BACK_BUTTON);
        }
        super.onBackPressed();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String string2 = this.getIntent().getStringExtra(INTENT_EXTRA_KEY_SDK_KEY);
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            final AppLovinSdk appLovinSdk = AppLovinSdk.getInstance(string2, new AppLovinSdkSettings(), this.getApplicationContext());
            this.a = new WebView((Context)this);
            this.setContentView((View)this.a);
            WebSettings webSettings = this.a.getSettings();
            webSettings.setSupportMultipleWindows(false);
            webSettings.setJavaScriptEnabled(true);
            this.a.setVerticalScrollBarEnabled(true);
            this.a.setHorizontalScrollBarEnabled(true);
            this.a.setScrollBarStyle(33554432);
            this.a.setWebViewClient(new WebViewClient(){

                public boolean shouldOverrideUrlLoading(WebView webView, String string2) {
                    Uri uri = Uri.parse((String)string2);
                    String string3 = uri.getScheme();
                    String string4 = uri.getHost();
                    String string5 = uri.getPath();
                    p p2 = appLovinSdk.getLogger();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Handling url load: ");
                    stringBuilder.append(string2);
                    p2.a("AppLovinWebViewActivity", stringBuilder.toString());
                    if ("applovin".equalsIgnoreCase(string3) && "com.applovin.sdk".equalsIgnoreCase(string4) && AppLovinWebViewActivity.this.b != null) {
                        if (string5.endsWith("webview_event")) {
                            Set set = uri.getQueryParameterNames();
                            String string6 = set.isEmpty() ? "" : (String)set.toArray()[0];
                            if (j.b(string6)) {
                                String string7 = uri.getQueryParameter(string6);
                                p p3 = appLovinSdk.getLogger();
                                StringBuilder stringBuilder2 = new StringBuilder();
                                stringBuilder2.append("Parsed WebView event parameter name: ");
                                stringBuilder2.append(string6);
                                stringBuilder2.append(" and value: ");
                                stringBuilder2.append(string7);
                                p3.a("AppLovinWebViewActivity", stringBuilder2.toString());
                                AppLovinWebViewActivity.this.b.onReceivedEvent(string7);
                            } else {
                                appLovinSdk.getLogger().d("AppLovinWebViewActivity", "Failed to parse WebView event parameter");
                            }
                        }
                        return true;
                    }
                    return super.shouldOverrideUrlLoading(webView, string2);
                }
            });
            if (this.getIntent().getBooleanExtra(INTENT_EXTRA_KEY_IMMERSIVE_MODE_ON, false)) {
                this.getWindow().getDecorView().setSystemUiVisibility(5894);
            }
            return;
        }
        throw new IllegalArgumentException("No SDK key specified");
    }

    public static interface EventListener {
        public void onReceivedEvent(String var1);
    }

}

