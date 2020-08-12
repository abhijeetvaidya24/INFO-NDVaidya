/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup
 *  android.webkit.WebView
 *  com.moat.analytics.mobile.iro.q
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.ref.WeakReference
 *  java.util.Map
 */
package com.moat.analytics.mobile.iro;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.moat.analytics.mobile.iro.MoatFactory;
import com.moat.analytics.mobile.iro.NativeDisplayTracker;
import com.moat.analytics.mobile.iro.NativeVideoTracker;
import com.moat.analytics.mobile.iro.NoOp;
import com.moat.analytics.mobile.iro.WebAdTracker;
import com.moat.analytics.mobile.iro.b;
import com.moat.analytics.mobile.iro.base.functional.Optional;
import com.moat.analytics.mobile.iro.j;
import com.moat.analytics.mobile.iro.m;
import com.moat.analytics.mobile.iro.o;
import com.moat.analytics.mobile.iro.q;
import com.moat.analytics.mobile.iro.r;
import com.moat.analytics.mobile.iro.s;
import com.moat.analytics.mobile.iro.x;
import java.lang.ref.WeakReference;
import java.util.Map;

final class n
extends MoatFactory {
    n() throws o {
        if (((j)j.getInstance()).\u02ca()) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Failed to initialize MoatFactory");
        stringBuilder.append(", SDK was not started");
        String string = stringBuilder.toString();
        b.\u02cf(3, "Factory", this, string);
        b.\u02ce("[ERROR] ", string);
        throw new o("Failed to initialize MoatFactory");
    }

    @Override
    public final <T> T createCustomTracker(m<T> m2) {
        T t2;
        try {
            t2 = m2.create();
        }
        catch (Exception exception) {
            o.\u0971(exception);
            return m2.createNoOp();
        }
        return t2;
    }

    @Override
    public final NativeDisplayTracker createNativeDisplayTracker(View view, Map<String, String> map) {
        try {
            NativeDisplayTracker nativeDisplayTracker = s.\u02ca(new s.a<NativeDisplayTracker>(this, new WeakReference((Object)view), map){
                private /* synthetic */ WeakReference \u02ca;
                private /* synthetic */ Map \u02cb;
                private /* synthetic */ n \u02ce;
                {
                    this.\u02ce = n2;
                    this.\u02ca = weakReference;
                    this.\u02cb = map;
                }

                @Override
                public final Optional<NativeDisplayTracker> \u02cf() {
                    View view = (View)this.\u02ca.get();
                    StringBuilder stringBuilder = new StringBuilder("Attempting to create NativeDisplayTracker for ");
                    stringBuilder.append(b.\u0971(view));
                    String string = stringBuilder.toString();
                    b.\u02cf(3, "Factory", this, string);
                    b.\u02ce("[INFO] ", string);
                    return Optional.of(new r(view, (Map<String, String>)this.\u02cb));
                }
            }, NativeDisplayTracker.class);
            return nativeDisplayTracker;
        }
        catch (Exception exception) {
            o.\u0971(exception);
            return new NoOp.a();
        }
    }

    @Override
    public final NativeVideoTracker createNativeVideoTracker(String string) {
        try {
            NativeVideoTracker nativeVideoTracker = s.\u02ca(new s.a<NativeVideoTracker>(this, string){
                private /* synthetic */ n \u02ca;
                private /* synthetic */ String \u02cf;
                {
                    this.\u02ca = n2;
                    this.\u02cf = string;
                }

                @Override
                public final Optional<NativeVideoTracker> \u02cf() {
                    b.\u02cf(3, "Factory", this, "Attempting to create NativeVideoTracker");
                    b.\u02ce("[INFO] ", "Attempting to create NativeVideoTracker");
                    return Optional.of(new q(this.\u02cf));
                }
            }, NativeVideoTracker.class);
            return nativeVideoTracker;
        }
        catch (Exception exception) {
            o.\u0971(exception);
            return new NoOp.c();
        }
    }

    @Override
    public final WebAdTracker createWebAdTracker(ViewGroup viewGroup) {
        try {
            WebAdTracker webAdTracker = s.\u02ca(new s.a<WebAdTracker>(this, new WeakReference((Object)viewGroup)){
                private /* synthetic */ WeakReference \u02ca;
                private /* synthetic */ n \u02cb;
                {
                    this.\u02cb = n2;
                    this.\u02ca = weakReference;
                }

                @Override
                public final Optional<WebAdTracker> \u02cf() throws o {
                    ViewGroup viewGroup = (ViewGroup)this.\u02ca.get();
                    StringBuilder stringBuilder = new StringBuilder("Attempting to create WebAdTracker for adContainer ");
                    stringBuilder.append(b.\u0971((View)viewGroup));
                    String string = stringBuilder.toString();
                    b.\u02cf(3, "Factory", this, string);
                    b.\u02ce("[INFO] ", string);
                    return Optional.of(new x(viewGroup));
                }
            }, WebAdTracker.class);
            return webAdTracker;
        }
        catch (Exception exception) {
            o.\u0971(exception);
            return new NoOp.b();
        }
    }

    @Override
    public final WebAdTracker createWebAdTracker(WebView webView) {
        try {
            WebAdTracker webAdTracker = s.\u02ca(new s.a<WebAdTracker>(this, new WeakReference((Object)webView)){
                private /* synthetic */ n \u02ca;
                private /* synthetic */ WeakReference \u02ce;
                {
                    this.\u02ca = n2;
                    this.\u02ce = weakReference;
                }

                @Override
                public final Optional<WebAdTracker> \u02cf() {
                    WebView webView = (WebView)this.\u02ce.get();
                    StringBuilder stringBuilder = new StringBuilder("Attempting to create WebAdTracker for ");
                    stringBuilder.append(b.\u0971((View)webView));
                    String string = stringBuilder.toString();
                    b.\u02cf(3, "Factory", this, string);
                    b.\u02ce("[INFO] ", string);
                    return Optional.of(new x(webView));
                }
            }, WebAdTracker.class);
            return webAdTracker;
        }
        catch (Exception exception) {
            o.\u0971(exception);
            return new NoOp.b();
        }
    }

}

