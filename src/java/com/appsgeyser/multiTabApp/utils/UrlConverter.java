/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.AssetFileDescriptor
 *  android.content.res.AssetManager
 *  android.webkit.WebView
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.net.MalformedURLException
 *  java.net.URL
 */
package com.appsgeyser.multiTabApp.utils;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.webkit.WebView;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class UrlConverter {
    private WebView _parentWebView;

    public UrlConverter(WebView webView) {
        this._parentWebView = webView;
    }

    public String toAbsolute(String string2) {
        try {
            if (!string2.contains((CharSequence)"://")) {
                URL uRL = new URL(this._parentWebView.getUrl());
                if (string2.startsWith("/")) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(uRL.getProtocol());
                    stringBuilder.append("://");
                    stringBuilder.append(uRL.getHost());
                    stringBuilder.append(string2);
                    return stringBuilder.toString();
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(uRL.getProtocol());
                stringBuilder.append("://");
                stringBuilder.append(uRL.getFile().replaceAll("/[^/]+$", "/"));
                stringBuilder.append(string2);
                string2 = stringBuilder.toString();
            }
            return string2;
        }
        catch (MalformedURLException malformedURLException) {
            malformedURLException.printStackTrace();
            return "";
        }
    }

    public AssetFileDescriptor toFileDescriptor(String string2) {
        String string3 = this.toAbsolute(string2);
        if (string3.length() == 0) {
            return null;
        }
        try {
            if (string3.startsWith("file:///")) {
                AssetFileDescriptor assetFileDescriptor = this._parentWebView.getContext().getAssets().openFd(string3.replace((CharSequence)"file:///android_asset/", (CharSequence)""));
                return assetFileDescriptor;
            }
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        return null;
    }

    public InputStream toStream(String string2) {
        String string3 = this.toAbsolute(string2);
        if (string3.length() == 0) {
            return null;
        }
        try {
            InputStream inputStream = string3.startsWith("file:///") ? this._parentWebView.getContext().getAssets().open(string3.replace((CharSequence)"file:///android_asset/", (CharSequence)"")) : new URL(string3).openStream();
            return inputStream;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            return null;
        }
    }
}

