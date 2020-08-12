/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager
 *  android.content.pm.ResolveInfo
 *  android.net.MailTo
 *  android.net.Uri
 *  android.net.http.SslError
 *  android.util.Log
 *  android.webkit.SslErrorHandler
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.net.URISyntaxException
 *  java.util.Map
 */
package com.appsgeyser.multiTabApp.browser;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.MailTo;
import android.net.Uri;
import android.net.http.SslError;
import android.util.Log;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.appsgeyser.multiTabApp.ui.dialog.SslErrorDialog;
import java.net.URISyntaxException;
import java.util.Map;

public class SimpleWebViewClient
extends WebViewClient {
    protected Context _context;

    public SimpleWebViewClient(Context context) {
        this._context = context;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void _handleIntent(String string2, WebView webView) {
        Intent intent = Intent.parseUri((String)string2, (int)1);
        if (intent == null) return;
        try {
            webView.stopLoading();
            if (this._context.getPackageManager().resolveActivity(intent, 65536) != null) {
                this._context.startActivity(intent);
                return;
            }
            String string3 = intent.getStringExtra("browser_fallback_url");
            if (!string3.startsWith("market:") && !string2.startsWith("geo:")) {
                if (string3.contains((CharSequence)"/store/apps/details?id=")) {
                    this._handlePlayStoreLink(string3);
                    return;
                }
                webView.loadUrl(string3);
                return;
            }
            Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse((String)string3));
            this._context.startActivity(intent2);
            return;
        }
        catch (URISyntaxException uRISyntaxException) {
            Log.e((String)"SimpleWebView", (String)"Can't resolve intent://", (Throwable)uRISyntaxException);
        }
    }

    private void _handleMailTo(String string2) {
        MailTo mailTo = MailTo.parse((String)string2);
        if (mailTo.getTo().length() > 0) {
            Map map = mailTo.getHeaders();
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            String[] arrstring = new String[]{mailTo.getTo()};
            intent.putExtra("android.intent.extra.EMAIL", arrstring);
            intent.putExtra("android.intent.extra.SUBJECT", mailTo.getSubject());
            intent.putExtra("android.intent.extra.CC", mailTo.getCc());
            if (map.containsKey((Object)"bcc")) {
                intent.putExtra("android.intent.extra.BCC", (String)map.get((Object)"bcc"));
            }
            intent.putExtra("android.intent.extra.TEXT", mailTo.getBody());
            this._context.startActivity(intent);
        }
    }

    private void _handlePlayStoreLink(String string2) {
        String string3 = string2.substring(23 + string2.indexOf("/store/apps/details?id="));
        Intent intent = new Intent("android.intent.action.VIEW");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("market://details?id=");
        stringBuilder.append(string3);
        intent.setData(Uri.parse((String)stringBuilder.toString()));
        this._context.startActivity(intent);
    }

    private void _handleSmsTo(String string2) {
        String[] arrstring = string2.split(":");
        String string3 = arrstring[1];
        String string4 = arrstring.length > 1 ? arrstring[2] : "";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("smsto:");
        stringBuilder.append(string3);
        Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse((String)stringBuilder.toString()));
        intent.putExtra("address", string3);
        intent.putExtra("sms_body", string4);
        this._context.startActivity(intent);
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        new SslErrorDialog(this._context).execute(webView, sslErrorHandler, sslError);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String string2) {
        block13 : {
            block16 : {
                block15 : {
                    block14 : {
                        block12 : {
                            block11 : {
                                if (!MailTo.isMailTo((String)string2)) break block11;
                                this._handleMailTo(string2);
                                return true;
                            }
                            if (!string2.startsWith("tel:")) break block12;
                            Intent intent = new Intent("android.intent.action.DIAL", Uri.parse((String)string2));
                            this._context.startActivity(intent);
                            return true;
                        }
                        boolean bl = string2.startsWith("market:");
                        if (bl) break block13;
                        if (string2.startsWith("geo:")) break block13;
                        if (!string2.startsWith("smsto:")) break block14;
                        this._handleSmsTo(string2);
                        return true;
                    }
                    if (!string2.startsWith("intent://")) break block15;
                    this._handleIntent(string2, webView);
                    return true;
                }
                if (!string2.contains((CharSequence)"/store/apps/details?id=")) break block16;
                this._handlePlayStoreLink(string2);
                return true;
            }
            if (!(string2.startsWith("http:") || string2.startsWith("https:") || string2.startsWith("file:") || string2.equals((Object)"about:blank"))) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse((String)string2));
                if (this._context.getPackageManager().resolveActivity(intent, 0) != null) {
                    this._context.startActivity(intent);
                    return true;
                }
            }
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse((String)string2));
            this._context.startActivity(intent);
            return true;
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return false;
    }
}

