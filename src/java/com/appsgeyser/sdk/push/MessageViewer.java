/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.app.ActionBar
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageManager
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.util.DisplayMetrics
 *  android.view.KeyEvent
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  android.widget.ImageView
 *  android.widget.RelativeLayout
 *  android.widget.TextView
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.appsgeyser.sdk.push;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.appsgeyser.sdk.R;

public class MessageViewer
extends Activity {
    private String createHtml(String string2, String string3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<!DOCTYPE html><html><head><title></title><meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"><style>body {background-color:#ffffff;background-repeat:no-repeat;background-position:top left;background-attachment:fixed;}h1{font-family:Arial, sans-serif;font-size:16px;color:#000000;background-color:#ffffff;}p {font-family:Georgia, serif;font-size:14px;font-style:normal;font-weight:normal;color:#000000;background-color:#ffffff;}</style></head><body><h1>");
        stringBuilder.append(string2);
        stringBuilder.append("</h1>");
        stringBuilder.append(string3);
        stringBuilder.append("</body></html>");
        return stringBuilder.toString();
    }

    public static void launchWithContent(Context context, String string2, String string3) {
        Intent intent = new Intent(context, MessageViewer.class);
        intent.addFlags(67108864);
        intent.addFlags(268435456);
        intent.addFlags(2097152);
        intent.putExtra("com.appsgeyser.sdk.push.MessageViewer.title", string2);
        intent.putExtra("com.appsgeyser.sdk.push.MessageViewer.message", string3);
        context.startActivity(intent);
    }

    @SuppressLint(value={"SetJavaScriptEnabled"})
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(R.layout.appsgeysersdk_message_viewer);
        Intent intent = this.getIntent();
        if (intent != null) {
            ActionBar actionBar;
            if (Build.VERSION.SDK_INT >= 11 && (actionBar = this.getActionBar()) != null) {
                actionBar.hide();
            }
            TextView textView = (TextView)this.findViewById(R.id.message_viewer_app_name_text_view);
            PackageManager packageManager = this.getPackageManager();
            CharSequence charSequence = packageManager.getApplicationLabel(this.getApplicationInfo());
            if (charSequence != null) {
                textView.setText(charSequence);
            } else {
                textView.setVisibility(8);
            }
            ImageView imageView = (ImageView)this.findViewById(R.id.message_viewer_imageView_icon);
            Drawable drawable2 = packageManager.getApplicationIcon(this.getApplicationInfo());
            if (drawable2 != null) {
                Resources resources = this.getResources();
                int n2 = (int)(0.5f + 36.0f * resources.getDisplayMetrics().density);
                imageView.setImageDrawable((Drawable)new BitmapDrawable(resources, Bitmap.createScaledBitmap((Bitmap)((BitmapDrawable)drawable2).getBitmap(), (int)n2, (int)n2, (boolean)true)));
            } else {
                imageView.setVisibility(8);
            }
            if (imageView.getVisibility() == 8 && textView.getVisibility() == 8) {
                ((RelativeLayout)this.findViewById(R.id.message_viewer_app_bar_fake)).setVisibility(8);
            }
            WebView webView = (WebView)this.findViewById(R.id.message_viewer_web_view);
            String string2 = intent.getStringExtra("com.appsgeyser.sdk.push.MessageViewer.title");
            String string3 = intent.getStringExtra("com.appsgeyser.sdk.push.MessageViewer.message");
            if (string2 != null && string3 != null) {
                webView.loadDataWithBaseURL(null, this.createHtml(string2, string3), "text/html", "utf-8", null);
                WebSettings webSettings = webView.getSettings();
                webSettings.setJavaScriptEnabled(true);
                webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
                webSettings.setAllowFileAccess(true);
                webSettings.setGeolocationEnabled(true);
                webSettings.setCacheMode(-1);
                webView.setVerticalScrollBarEnabled(false);
                webView.setHorizontalScrollBarEnabled(false);
                webSettings.setLoadWithOverviewMode(true);
                webSettings.setUseWideViewPort(true);
                webView.setInitialScale(0);
            }
            this.findViewById(R.id.message_viewer_button).setOnClickListener(new View.OnClickListener((Context)this){
                final /* synthetic */ Context val$activity;
                {
                    this.val$activity = context;
                }

                public void onClick(View view) {
                    Intent intent = this.val$activity.getPackageManager().getLaunchIntentForPackage(this.val$activity.getPackageName());
                    intent.addFlags(67108864);
                    intent.addFlags(268435456);
                    intent.addFlags(2097152);
                    this.val$activity.startActivity(intent);
                }
            });
        }
    }

    public boolean onKeyDown(int n2, KeyEvent keyEvent) {
        if (n2 == 4) {
            this.finish();
            return true;
        }
        return super.onKeyDown(n2, keyEvent);
    }

    protected void onPause() {
        super.onPause();
        if (this.isFinishing()) {
            this.finish();
        }
    }

}

