/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.graphics.Paint
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 */
package com.ogury.consent.manager;

import android.app.Activity;
import android.content.Context;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.ogury.consent.manager.ansi;
import com.ogury.consent.manager.tx5040;
import com.ogury.consent.manager.tx6480;
import com.ogury.consent.manager.util.consent.ConsentException;
import com.ogury.consent.manager.util.consent.cocoasubrtf100;
import java.util.HashMap;

public class ConsentActivity
extends Activity {
    public static final rtf1 a = new rtf1(null);
    private static com.ogury.consent.manager.util.consent.rtf1 c;
    private final FrameLayout.LayoutParams b = new FrameLayout.LayoutParams(-1, -1);
    private HashMap d;

    public static final /* synthetic */ com.ogury.consent.manager.util.consent.rtf1 access$getConsentCallback$cp() {
        com.ogury.consent.manager.util.consent.rtf1 rtf12 = c;
        if (rtf12 == null) {
            tx6480.a("consentCallback");
        }
        return rtf12;
    }

    public static final /* synthetic */ void access$setConsentCallback$cp(com.ogury.consent.manager.util.consent.rtf1 rtf12) {
        c = rtf12;
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this.d;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int n2) {
        View view;
        if (this.d == null) {
            this.d = new HashMap();
        }
        if ((view = (View)this.d.get((Object)n2)) == null) {
            view = this.findViewById(n2);
            this.d.put((Object)n2, (Object)view);
        }
        return view;
    }

    public void onBackPressed() {
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Context context = (Context)this;
        FrameLayout frameLayout = new FrameLayout(context, null);
        frameLayout.setLayoutParams((ViewGroup.LayoutParams)this.b);
        WebView webView = com.ogury.consent.manager.util.consent.ansi.e();
        if (webView != null) {
            com.ogury.consent.manager.util.consent.rtf1 rtf12 = c;
            if (rtf12 == null) {
                tx6480.a("consentCallback");
            }
            webView.setWebViewClient((WebViewClient)new ansi(context, rtf12));
        }
        WebView webView2 = com.ogury.consent.manager.util.consent.ansi.e();
        if (Build.VERSION.SDK_INT < 16 && webView2 != null) {
            webView2.setLayerType(1, null);
        }
        if (com.ogury.consent.manager.util.consent.ansi.e() != null) {
            frameLayout.addView((View)com.ogury.consent.manager.util.consent.ansi.e(), (ViewGroup.LayoutParams)this.b);
            com.ogury.consent.manager.util.consent.ansi.a(null);
        } else {
            com.ogury.consent.manager.util.consent.rtf1 rtf13 = c;
            if (rtf13 == null) {
                tx6480.a("consentCallback");
            }
            rtf13.a(new ConsentException("system-error", ""));
            cocoasubrtf100.a("cached webview has been destroyed");
            this.finish();
        }
        this.setContentView((View)frameLayout);
    }

    protected void onDestroy() {
        com.ogury.consent.manager.util.consent.ansi.a(null);
        super.onDestroy();
    }

    public static final class rtf1 {
        private rtf1() {
        }

        public /* synthetic */ rtf1(tx5040 tx50402) {
            this();
        }
    }

}

