/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.graphics.Rect
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewParent
 *  android.view.Window
 *  android.webkit.JsPromptResult
 *  android.webkit.JsResult
 *  android.webkit.WebChromeClient
 *  android.webkit.WebView
 *  java.lang.Object
 *  java.lang.String
 */
package com.tappx.a.a.b;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.tappx.a.a.a.c.a;

public class an {
    public static int a(View view, Rect rect) {
        float f2 = rect.height() * rect.width();
        float f3 = view.getHeight() * view.getWidth();
        if (f3 <= 0.0f) {
            return 0;
        }
        return (int)(f2 * 100.0f / f3);
    }

    private static View a(Context context) {
        if (!(context instanceof Activity)) {
            return null;
        }
        return ((Activity)context).getWindow().getDecorView().findViewById(16908290);
    }

    public static View a(Context context, View view) {
        View view2 = an.a(context);
        View view3 = an.b(view);
        if (view2 != null) {
            return view2;
        }
        return view3;
    }

    public static void a(View view) {
        if (view != null) {
            if (view.getParent() == null) {
                return;
            }
            if (view.getParent() instanceof ViewGroup) {
                ((ViewGroup)view.getParent()).removeView(view);
            }
        }
    }

    public static void a(WebView webView) {
        webView.setWebChromeClient(new WebChromeClient(){

            public boolean onJsAlert(WebView webView, String string2, String string3, JsResult jsResult) {
                a.d(string3, new Object[0]);
                jsResult.confirm();
                return true;
            }

            public boolean onJsBeforeUnload(WebView webView, String string2, String string3, JsResult jsResult) {
                a.d(string3, new Object[0]);
                jsResult.confirm();
                return true;
            }

            public boolean onJsConfirm(WebView webView, String string2, String string3, JsResult jsResult) {
                a.d(string3, new Object[0]);
                jsResult.confirm();
                return true;
            }

            public boolean onJsPrompt(WebView webView, String string2, String string3, String string4, JsPromptResult jsPromptResult) {
                a.d(string3, new Object[0]);
                jsPromptResult.confirm();
                return true;
            }
        });
    }

    private static View b(View view) {
        if (view == null) {
            return null;
        }
        View view2 = view.getRootView();
        if (view2 == null) {
            return null;
        }
        View view3 = view2.findViewById(16908290);
        if (view3 != null) {
            view2 = view3;
        }
        return view2;
    }

}

