/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.webkit.WebResourceResponse
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  io.presage.PlaisirauChablis
 *  io.presage.Soumaintrain
 *  io.presage.j$CamembertauCalvados
 *  java.io.ByteArrayInputStream
 *  java.io.InputStream
 *  java.lang.CharSequence
 *  java.lang.IllegalAccessError
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.nio.charset.Charset
 */
package io.presage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import io.presage.BrillatSavarin;
import io.presage.CapGrisNez;
import io.presage.PlaisirauChablis;
import io.presage.RegaldeBourgogne;
import io.presage.Salers;
import io.presage.Soumaintrain;
import io.presage.VieuxLille;
import io.presage.cl;
import io.presage.ds;
import io.presage.dt;
import io.presage.j;
import io.presage.k;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;

@SuppressLint(value={"ViewConstructor"})
public final class j
extends WebView {
    private boolean a;
    private k b;
    private Salers c;
    private final Soumaintrain d;
    private final RegaldeBourgogne e;
    private final dt f;
    private BrillatSavarin g;

    public j(Context context, BrillatSavarin brillatSavarin) {
        super(context);
        this.g = brillatSavarin;
        this.a = true;
        this.c = (Salers)new PlaisirauChablis(this);
        this.e = new RegaldeBourgogne(this);
        this.f = new dt("bunaZiua");
        this.d = this.c();
        this.setAdUnit(this.g.k());
        this.setWebViewClient((WebViewClient)this.d);
    }

    public static final /* synthetic */ void a(j j2, String string) {
        j2.a(string);
    }

    private final void a(String string) {
        CharSequence charSequence = string;
        if (this.f.a(charSequence)) {
            this.e.b();
            k k2 = this.b;
            if (k2 != null) {
                k2.a(this);
            }
        }
        this.c.a(string, this, this.g.k());
    }

    public static final /* synthetic */ WebResourceResponse b() {
        return j.d();
    }

    private final Soumaintrain c() {
        return (Soumaintrain)new CamembertauCalvados(this);
    }

    private static WebResourceResponse d() {
        byte[] arrby = "".getBytes(ds.a);
        cl.a((Object)arrby, "(this as java.lang.String).getBytes(charset)");
        return new WebResourceResponse("text/image", "UTF-8", (InputStream)new ByteArrayInputStream(arrby));
    }

    private final void setAdUnit(CapGrisNez capGrisNez) {
        this.d.a(capGrisNez);
    }

    public final void a() {
        VieuxLille.a(this.g.a());
        k k2 = this.b;
        if (k2 != null) {
            k2.b();
        }
    }

    public final k getClientAdapter() {
        return this.b;
    }

    public final Salers getMraidUrlHandler() {
        return this.c;
    }

    public final boolean getShowSdkCloseButton() {
        return this.a;
    }

    public final void setClientAdapter(k k2) {
        this.b = k2;
    }

    public final void setMraidUrlHandler(Salers salers) {
        this.c = salers;
    }

    public final void setShowSdkCloseButton(boolean bl2) {
        this.a = bl2;
    }

    public final void setWebViewClient(WebViewClient webViewClient) {
        if (true ^ cl.a((Object)this.d, (Object)webViewClient)) {
            new IllegalAccessError("Cannot change the webview client for MraidWebView");
        }
        super.setWebViewClient(webViewClient);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("MraidWebView>> ");
        stringBuilder.append(Integer.toHexString((int)System.identityHashCode((Object)((Object)this))));
        return stringBuilder.toString();
    }
}

