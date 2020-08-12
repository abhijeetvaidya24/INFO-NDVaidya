/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.app.Activity
 *  android.content.ActivityNotFoundException
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Bundle
 *  android.util.Log
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.webkit.WebResourceRequest
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.appsgeyser.sdk;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.appsgeyser.sdk.PausedContentInfoActivity$$Lambda$1;
import com.appsgeyser.sdk.R;
import com.appsgeyser.sdk.configuration.Configuration;
import com.appsgeyser.sdk.configuration.PreferencesCoder;
import com.appsgeyser.sdk.server.network.NetworkManager;

public class PausedContentInfoActivity
extends Activity {
    public static void checkBanApp(Context context, boolean bl) {
        boolean bl2 = new PreferencesCoder(context).getPrefBoolean("Ban_App", false);
        if (!NetworkManager.isOnline(context) && bl2 || bl2) {
            PausedContentInfoActivity.startPausedContentInfoActivity(context, bl);
        }
    }

    static /* synthetic */ void lambda$onCreate$0(PausedContentInfoActivity pausedContentInfoActivity, View view) {
        pausedContentInfoActivity.finish();
    }

    public static void startPausedContentInfoActivity(Context context, boolean bl) {
        Intent intent = new Intent(context, PausedContentInfoActivity.class);
        intent.putExtra("CustomHtmlAboutKey", bl);
        intent.setFlags(67108864);
        context.startActivity(intent);
    }

    public void onBackPressed() {
        if (this.getIntent().getBooleanExtra("CustomHtmlAboutKey", false)) {
            super.onBackPressed();
        }
    }

    protected void onCreate(Bundle bundle) {
        String string2;
        super.onCreate(bundle);
        this.setContentView(R.layout.appsgeysersdk_paused_content_activity);
        Log.d((String)"PausedContentInfo", (String)"created pausedActivity");
        WebView webView = (WebView)this.findViewById(R.id.webView);
        final boolean bl = this.getIntent().getBooleanExtra("CustomHtmlAboutKey", false);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("http://www.appsgeyser.com/branding/");
        stringBuilder.append(Configuration.getInstance((Context)this).getApplicationId());
        final String string3 = stringBuilder.toString();
        if (bl) {
            string2 = string3;
        } else {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("https://www.appsgeyser.com/paused/");
            stringBuilder2.append(Configuration.getInstance((Context)this).getApplicationId());
            string2 = stringBuilder2.toString();
        }
        if (bl) {
            ImageView imageView = (ImageView)this.findViewById(R.id.close_screen);
            imageView.setVisibility(0);
            imageView.setOnClickListener(PausedContentInfoActivity$$Lambda$1.lambdaFactory$(this));
            imageView.bringToFront();
        }
        if (NetworkManager.isOnline((Context)this)) {
            webView.setWebViewClient(new WebViewClient(){

                @TargetApi(value=21)
                public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
                    if (!bl || webResourceRequest.getUrl().toString().equals((Object)string3)) {
                        webView.loadUrl(webResourceRequest.getUrl().toString());
                    }
                    return super.shouldOverrideUrlLoading(webView, webResourceRequest);
                }

                public boolean shouldOverrideUrlLoading(WebView webView, String string2) {
                    if (Uri.parse((String)string2).getScheme().equals((Object)"market")) {
                        try {
                            webView.stopLoading();
                            webView.goBack();
                            Intent intent = new Intent("android.intent.action.VIEW");
                            intent.setData(Uri.parse((String)string2));
                            ((Activity)webView.getContext()).startActivity(intent);
                            return false;
                        }
                        catch (ActivityNotFoundException activityNotFoundException) {
                            Uri uri = Uri.parse((String)string2);
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("http://play.google.com/store/apps/");
                            stringBuilder.append(uri.getHost());
                            stringBuilder.append("?");
                            stringBuilder.append(uri.getQuery());
                            webView.loadUrl(stringBuilder.toString());
                            return false;
                        }
                    }
                    if (bl && !string2.contains((CharSequence)"appsgeyser.com/branding/")) {
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse((String)string2));
                        PausedContentInfoActivity.this.startActivity(intent);
                        return true;
                    }
                    webView.loadUrl(string2);
                    return false;
                }
            });
            webView.loadUrl(string2);
            return;
        }
        if (!bl) {
            webView.setVisibility(8);
            ((FrameLayout)this.findViewById(R.id.ban_view)).setVisibility(0);
        }
    }

}

