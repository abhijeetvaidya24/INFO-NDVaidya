/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Color
 *  android.graphics.Paint
 *  android.graphics.drawable.ClipDrawable
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.ShapeDrawable
 *  android.graphics.drawable.shapes.RectShape
 *  android.graphics.drawable.shapes.Shape
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.util.AttributeSet
 *  android.view.KeyEvent
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.webkit.WebBackForwardList
 *  android.webkit.WebChromeClient
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  android.widget.FrameLayout
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  android.widget.TextView
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Math
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.startapp.android.publish.inappbrowser;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.startapp.android.publish.adsCommon.Utils.h;
import com.startapp.android.publish.adsCommon.c;
import com.startapp.android.publish.adsCommon.f.d;
import com.startapp.android.publish.adsCommon.f.f;
import com.startapp.android.publish.inappbrowser.AnimatingProgressBar;
import com.startapp.android.publish.inappbrowser.a;
import com.startapp.android.publish.inappbrowser.b;
import com.startapp.common.a.g;

public class a
extends com.startapp.android.publish.ads.a.b
implements View.OnClickListener {
    protected static boolean j;
    protected RelativeLayout d;
    protected b e;
    protected WebView f;
    protected AnimatingProgressBar g;
    protected FrameLayout h;
    protected String i;

    public a(String string) {
        this.i = string;
    }

    private void A() {
        try {
            j = true;
            this.f.stopLoading();
            this.f.removeAllViews();
            this.f.postInvalidate();
            com.startapp.common.a.c.b(this.f);
            this.f.destroy();
            this.f = null;
            return;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("IABrowserMode::destroyWebview error ");
            stringBuilder.append(exception.getMessage());
            g.a("IABrowserMode", 6, stringBuilder.toString());
            return;
        }
    }

    private void b(String string) {
        g.a("IABrowserMode", 3, "initUi");
        if (this.e == null) {
            this.e = new b((Context)this.b());
            this.e.a();
            this.e.b();
            this.e.setButtonsListener(this);
        }
        this.d.addView((View)this.e);
        this.g = new AnimatingProgressBar((Context)this.b(), null, 16842872);
        ShapeDrawable shapeDrawable = new ShapeDrawable((Shape)new RectShape());
        shapeDrawable.getPaint().setColor(Color.parseColor((String)"#45d200"));
        ClipDrawable clipDrawable = new ClipDrawable((Drawable)shapeDrawable, 3, 1);
        this.g.setProgressDrawable((Drawable)clipDrawable);
        this.g.setBackgroundColor(-1);
        this.g.setId(2108);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, h.a((Context)this.b(), 4));
        layoutParams.addRule(3, 2101);
        this.d.addView((View)this.g, (ViewGroup.LayoutParams)layoutParams);
        this.h = new FrameLayout((Context)this.b());
        if (this.f == null) {
            try {
                this.y();
                this.f.loadUrl(string);
            }
            catch (Exception exception) {
                this.e.c();
                c.c((Context)this.b(), string);
                f.a((Context)this.b(), d.b, "IABrowserMode.initUi - Webvie  failed", exception.getMessage(), "");
                this.b().finish();
            }
        }
        this.h.addView((View)this.f);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(15);
        layoutParams2.addRule(3, 2108);
        this.d.addView((View)this.h, (ViewGroup.LayoutParams)layoutParams2);
    }

    private void y() {
        this.f = new WebView((Context)this.b());
        this.z();
        this.f.setWebViewClient(new WebViewClient((Context)this.b(), this.e, this.g, this){
            private Context a;
            private a b;
            private b c;
            private AnimatingProgressBar d;
            private int e = 0;
            private boolean f = false;
            {
                this.a = context;
                this.d = animatingProgressBar;
                this.c = b2;
                this.b = a2;
            }

            public void onPageFinished(WebView webView, String string) {
                if (!a.j) {
                    int n2;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("IABWebViewClient::onPageFinished - [");
                    stringBuilder.append(string);
                    stringBuilder.append("]");
                    g.a("IABrowserMode", 3, stringBuilder.toString());
                    this.c.a(webView);
                    this.e = n2 = -1 + this.e;
                    if (n2 == 0) {
                        this.f = false;
                        this.d.a();
                        if (this.d.isShown()) {
                            this.d.setVisibility(8);
                        }
                        this.c.a(webView);
                    }
                    super.onPageFinished(webView, string);
                }
            }

            public void onPageStarted(WebView webView, String string, Bitmap bitmap) {
                if (!a.j) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("IABWebViewClient::onPageStarted - [");
                    stringBuilder.append(string);
                    stringBuilder.append("]");
                    stringBuilder.append("REDIRECTED  -> ");
                    stringBuilder.append(this.e);
                    stringBuilder.append(" Can go back ");
                    stringBuilder.append(webView.canGoBack());
                    g.a("IABrowserMode", 3, stringBuilder.toString());
                    if (this.f) {
                        this.e = 1;
                        this.d.a();
                        this.c.a(webView);
                    } else {
                        this.e = Math.max((int)this.e, (int)1);
                    }
                    this.d.setVisibility(0);
                    this.c.getUrlTxt().setText((CharSequence)string);
                    this.c.a(webView);
                    super.onPageStarted(webView, string, bitmap);
                }
            }

            public void onReceivedError(WebView webView, int n2, String string, String string2) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("IABWebViewClient::onReceivedError - [");
                stringBuilder.append(string);
                stringBuilder.append("], [");
                stringBuilder.append(string2);
                stringBuilder.append("]");
                g.a("IABrowserMode", 3, stringBuilder.toString());
                this.d.a();
                super.onReceivedError(webView, n2, string, string2);
            }

            public boolean shouldOverrideUrlLoading(WebView webView, String string) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("IABWebViewClient::shouldOverrideUrlLoading - [");
                stringBuilder.append(string);
                stringBuilder.append("]");
                g.a("IABrowserMode", 3, stringBuilder.toString());
                if (!a.j) {
                    if (!this.f) {
                        this.f = true;
                        this.d.a();
                        this.e = 0;
                    }
                    this.e = 1 + this.e;
                    if (c.d(string) && !c.b(string)) {
                        return false;
                    }
                    this.e = 1;
                    c.c(this.a, string);
                    a a2 = this.b;
                    if (a2 != null) {
                        a2.x();
                    }
                }
                return true;
            }
        });
        this.f.setWebChromeClient(new WebChromeClient(this){
            final /* synthetic */ a a;
            {
                this.a = a2;
            }

            public void onProgressChanged(WebView webView, int n2) {
                this.a.g.setProgress(n2);
            }

            public void onReceivedTitle(WebView webView, String string) {
                if (string != null && !string.equals((java.lang.Object)"")) {
                    this.a.e.getTitleTxt().setText((CharSequence)string);
                }
            }
        });
    }

    private void z() {
        this.f.getSettings().setJavaScriptEnabled(true);
        this.f.getSettings().setUseWideViewPort(true);
        this.f.getSettings().setLoadWithOverviewMode(true);
        this.f.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        this.f.getSettings().setBuiltInZoomControls(true);
        if (Build.VERSION.SDK_INT >= 11) {
            this.f.getSettings().setDisplayZoomControls(false);
        }
    }

    @Override
    public void a(Bundle bundle) {
        super.a(bundle);
        j = false;
        this.d = new RelativeLayout((Context)this.b());
        this.b(this.i);
        if (bundle != null) {
            this.c(bundle);
        }
        this.b().setContentView((View)this.d, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-2, -2));
    }

    @Override
    public boolean a(int n2, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && n2 == 4) {
            WebView webView = this.f;
            if (webView != null && webView.canGoBack()) {
                g.a("IABrowserMode", 3, "IABWebViewClient::KEYCODE_BACK can go back");
                this.g.a();
                this.f.goBack();
            } else {
                g.a("IABrowserMode", 3, "IABWebViewClient::KEYCODE_BACK canT go back");
                this.x();
            }
            return true;
        }
        return super.a(n2, keyEvent);
    }

    @Override
    public void b(Bundle bundle) {
        this.f.saveState(bundle);
    }

    @Override
    public void c(Bundle bundle) {
        this.f.restoreState(bundle);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            default: {
                return;
            }
            case 2106: {
                WebView webView = this.f;
                if (webView == null || !webView.canGoForward()) break;
                this.g.a();
                this.f.goForward();
                return;
            }
            case 2105: {
                WebView webView = this.f;
                if (webView == null || !webView.canGoBack()) break;
                this.g.a();
                this.f.goBack();
                return;
            }
            case 2104: {
                if (this.f == null) break;
                c.c((Context)this.b(), this.f.getUrl());
                this.x();
                return;
            }
            case 2103: {
                this.x();
            }
        }
    }

    @Override
    public void s() {
    }

    @Override
    public void u() {
    }

    void x() {
        this.A();
        this.e.c();
        this.b().finish();
    }

}

