/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.webkit.ValueCallback
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.concurrent.Executors
 *  java.util.concurrent.ScheduledExecutorService
 *  java.util.concurrent.ScheduledFuture
 *  java.util.concurrent.TimeUnit
 */
package com.moat.analytics.mobile.tjy;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.moat.analytics.mobile.tjy.ap;
import com.moat.analytics.mobile.tjy.ar;
import com.moat.analytics.mobile.tjy.l;
import com.moat.analytics.mobile.tjy.m;
import com.moat.analytics.mobile.tjy.o;
import com.moat.analytics.mobile.tjy.p;
import com.moat.analytics.mobile.tjy.q;
import com.moat.analytics.mobile.tjy.s;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class n
implements l {
    private final ScheduledExecutorService a;
    private ScheduledFuture b;
    private ScheduledFuture c;
    private final ap d;
    private int e = 0;
    private boolean f = false;
    private boolean g = false;
    private WebView h;
    private m i;

    n(Context context, ap ap2) {
        this.d = ap2;
        this.a = Executors.newScheduledThreadPool((int)1);
    }

    static /* synthetic */ int a(n n2, int n3) {
        n2.e = n3;
        return n3;
    }

    static /* synthetic */ void a(n n2) {
        n2.e();
    }

    static /* synthetic */ ap b(n n2) {
        return n2.d;
    }

    private void b() {
        try {
            if (this.d.a() == ar.a) {
                return;
            }
            if (this.d.b() && !this.g) {
                Log.d((String)"MoatJavaScriptBridge", (String)"Ready for communication (setting environment variables).");
                this.g = true;
            }
            Object[] arrobject = new Object[]{this.i.b()};
            String string = String.format((String)"javascript:(function(b,f){function g(){function b(a,e){for(k in a)if(a.hasOwnProperty(k)){var c=a[k].fn;if('function'===typeof c)try{e?c(e):c()}catch(d){}}}function d(a,b,c){'function'===typeof a&&(c[b]={ts:+new Date,fn:a})}bjmk={};uqaj={};yhgt={};ryup=dptk=!1;this.a=function(a){this.namespace=a.namespace;this.version=a.version;this.appName=a.appName;this.deviceOS=a.deviceOS;this.isNative=a.isNative;this.versionHash=a.versionHash};this.bpsy=function(a){dptk||ryup||d(a,+new Date,bjmk)};this.qmrv=function(a){ryup||d(a,+new Date,uqaj)};this.lgpr=function(a,b){d(a,b,yhgt)};this.xrnk=function(a){yhgt.hasOwnProperty(a)&&delete yhgt[a]};this.vgft=function(){return dptk};this.lkpu=function(){return ryup};this.mqjh=function(){dptk||ryup||(dptk=!0,b(bjmk))};this.egpw=function(){ryup||(ryup=!0,b(uqaj))};this.sglu=function(a){b(yhgt,a);return 0<Object.keys(yhgt).length}}'undefined'===typeof b.MoatMAK&&(b.MoatMAK=new g,b.MoatMAK.a(f),b.__zMoatInit__=!0)})(window,%s);", (Object[])arrobject);
            this.h.loadUrl(string);
            return;
        }
        catch (Exception exception) {
            if (this.d.b()) {
                Log.e((String)"MoatJavaScriptBridge", (String)"Failed to initialize communication (did not set environment variables).", (Throwable)exception);
            }
            return;
        }
    }

    static /* synthetic */ int c(n n2) {
        return n2.e;
    }

    @TargetApi(value=19)
    private void c() {
        if (this.d.a() == ar.a) {
            return;
        }
        WebView webView = this.h;
        if (!(webView == null || this.f && webView.getUrl() == null)) {
            if (this.h.getUrl() != null) {
                this.f = true;
            }
            String string = String.format((String)"MoatMAK.sglu(%s)", (Object[])new Object[]{this.i.a()});
            if (Build.VERSION.SDK_INT >= 19) {
                this.h.evaluateJavascript(string, (ValueCallback)new p(this));
                return;
            }
            WebView webView2 = this.h;
            StringBuilder stringBuilder = new StringBuilder("javascript:");
            stringBuilder.append(string);
            webView2.loadUrl(stringBuilder.toString());
            return;
        }
        if (this.d.b()) {
            StringBuilder stringBuilder = new StringBuilder("WebView became null");
            String string = this.h == null ? "" : "based on null url";
            stringBuilder.append(string);
            stringBuilder.append(", stopping tracking loop");
            Log.d((String)"MoatJavaScriptBridge", (String)stringBuilder.toString());
        }
        this.g();
    }

    private void d() {
        if (this.d.b()) {
            Log.d((String)"MoatJavaScriptBridge", (String)"Starting metadata reporting loop");
        }
        q q2 = new q(this);
        this.c = this.a.scheduleWithFixedDelay((Runnable)q2, 0L, 50L, TimeUnit.MILLISECONDS);
    }

    static /* synthetic */ void d(n n2) {
        n2.g();
    }

    static /* synthetic */ int e(n n2) {
        int n3 = n2.e;
        n2.e = n3 + 1;
        return n3;
    }

    private void e() {
        ScheduledFuture scheduledFuture = this.c;
        if (scheduledFuture != null) {
            if (!scheduledFuture.isCancelled() && this.d.b()) {
                Log.d((String)"MoatJavaScriptBridge", (String)"Stopping metadata reporting loop");
            }
            this.c.cancel(true);
        }
    }

    private void f() {
        if (this.d.b()) {
            Log.d((String)"MoatJavaScriptBridge", (String)"Starting view update loop");
        }
        s s2 = new s(this);
        this.b = this.a.scheduleWithFixedDelay((Runnable)s2, 0L, (long)this.d.c(), TimeUnit.MILLISECONDS);
    }

    static /* synthetic */ void f(n n2) {
        n2.b();
    }

    private void g() {
        ScheduledFuture scheduledFuture = this.b;
        if (scheduledFuture != null) {
            if (scheduledFuture.isCancelled() && this.d.b()) {
                Log.d((String)"MoatJavaScriptBridge", (String)"Stopping view update loop");
            }
            this.b.cancel(true);
        }
    }

    static /* synthetic */ void g(n n2) {
        n2.c();
    }

    @Override
    public void a() {
        if (this.d.a() == ar.a) {
            return;
        }
        this.e();
        this.g();
    }

    @Override
    public boolean a(WebView webView, m m2) {
        boolean bl2 = this.d.b();
        if (!webView.getSettings().getJavaScriptEnabled()) {
            if (bl2) {
                Log.e((String)"MoatJavaScriptBridge", (String)"JavaScript is not enabled in the given WebView. Can't track.");
            }
            return false;
        }
        this.h = webView;
        this.i = m2;
        this.d();
        this.f();
        this.a.schedule((Runnable)new o(this), 10L, TimeUnit.SECONDS);
        return true;
    }
}

