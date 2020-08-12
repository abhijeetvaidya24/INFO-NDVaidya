/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.util.AttributeSet
 *  android.webkit.URLUtil
 *  android.webkit.WebView
 *  com.appsgeyser.multiTabApp.MainNavigationActivity
 *  java.io.UnsupportedEncodingException
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.net.URLEncoder
 */
package com.appsgeyser.multiTabApp.ui.views;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.webkit.URLUtil;
import android.webkit.WebView;
import com.appsgeyser.multiTabApp.Factory;
import com.appsgeyser.multiTabApp.MainNavigationActivity;
import com.appsgeyser.multiTabApp.ui.navigationwidget.INavigationWidget;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class BrowserWebView
extends WebView {
    private boolean _firstUrl = true;
    private INavigationWidget _navigationWidget = null;
    private Context context;
    private OnScrollChangedCallback mOnScrollChangedCallback;

    public BrowserWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
    }

    private String _getUrlWithAllArguments(String string2) {
        Factory.getInstance().getMainNavigationActivity();
        return string2;
    }

    private String getSearchUrl(String string2) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.getResources().getString(2131755257));
            stringBuilder.append(URLEncoder.encode((String)string2, (String)"UTF-8"));
            String string3 = stringBuilder.toString();
            Factory.getInstance().getMainNavigationActivity();
            String string4 = this._getUrlWithAllArguments(string3);
            return string4;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            unsupportedEncodingException.printStackTrace();
            return string2;
        }
    }

    private void init() {
        this._navigationWidget = Factory.getInstance().getNavigationWidget();
        this._firstUrl = false;
    }

    public void loadUrl(String string2) {
        INavigationWidget iNavigationWidget;
        if (this._firstUrl) {
            this.init();
        }
        if ((iNavigationWidget = this._navigationWidget) != null && iNavigationWidget.isVisible() && !URLUtil.isValidUrl((String)string2)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("http://");
            stringBuilder.append(string2);
            if (stringBuilder.toString().matches("(news|(ht|f)tp(s?)\\://){1}[\\S\\.]+\\.[\\S\\.]+")) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("http://");
                stringBuilder2.append(string2);
                string2 = stringBuilder2.toString();
            } else {
                string2 = this.getSearchUrl(string2);
            }
        }
        if (!string2.contains((CharSequence)"javascript:(function(){  })()")) {
            super.loadUrl(string2);
        }
    }

    protected void onScrollChanged(int n2, int n3, int n4, int n5) {
        super.onScrollChanged(n2, n3, n4, n5);
        OnScrollChangedCallback onScrollChangedCallback = this.mOnScrollChangedCallback;
        if (onScrollChangedCallback != null) {
            onScrollChangedCallback.onScroll(n2, n3, n4, n5);
        }
    }

    public void setOnScrollChangedCallback(OnScrollChangedCallback onScrollChangedCallback) {
        this.mOnScrollChangedCallback = onScrollChangedCallback;
    }

    public static interface OnScrollChangedCallback {
        public void onScroll(int var1, int var2, int var3, int var4);
    }

}

