/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup
 *  android.webkit.WebView
 *  com.moat.analytics.mobile.cha.s
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.ref.WeakReference
 *  java.util.Map
 */
package com.moat.analytics.mobile.cha;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.moat.analytics.mobile.cha.MoatFactory;
import com.moat.analytics.mobile.cha.NativeDisplayTracker;
import com.moat.analytics.mobile.cha.NativeVideoTracker;
import com.moat.analytics.mobile.cha.NoOp;
import com.moat.analytics.mobile.cha.WebAdTracker;
import com.moat.analytics.mobile.cha.a;
import com.moat.analytics.mobile.cha.base.functional.Optional;
import com.moat.analytics.mobile.cha.f;
import com.moat.analytics.mobile.cha.l;
import com.moat.analytics.mobile.cha.o;
import com.moat.analytics.mobile.cha.p;
import com.moat.analytics.mobile.cha.q;
import com.moat.analytics.mobile.cha.s;
import com.moat.analytics.mobile.cha.v;
import java.lang.ref.WeakReference;
import java.util.Map;

final class k
extends MoatFactory {
    k() throws o {
        if (((f)f.getInstance()).\u02ca()) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Failed to initialize MoatFactory");
        stringBuilder.append(", SDK was not started");
        String string = stringBuilder.toString();
        a.\u02cf(3, "Factory", this, string);
        a.\u02ca("[ERROR] ", string);
        throw new o("Failed to initialize MoatFactory");
    }

    @Override
    public final <T> T createCustomTracker(l<T> l2) {
        T t2;
        try {
            t2 = l2.create();
        }
        catch (Exception exception) {
            o.\u02ce(exception);
            return l2.createNoOp();
        }
        return t2;
    }

    @Override
    public final NativeDisplayTracker createNativeDisplayTracker(View view, Map<String, String> map) {
        try {
            NativeDisplayTracker nativeDisplayTracker = p.\u02cb(new p.c<NativeDisplayTracker>(this, new WeakReference((Object)view), map){
                private /* synthetic */ Map \u02cb;
                private /* synthetic */ WeakReference \u02cf;
                private /* synthetic */ k \u0971;
                {
                    this.\u0971 = k2;
                    this.\u02cf = weakReference;
                    this.\u02cb = map;
                }

                @Override
                public final Optional<NativeDisplayTracker> \u02cb() {
                    View view = (View)this.\u02cf.get();
                    StringBuilder stringBuilder = new StringBuilder("Attempting to create NativeDisplayTracker for ");
                    stringBuilder.append(a.\u02cf(view));
                    String string = stringBuilder.toString();
                    a.\u02cf(3, "Factory", this, string);
                    a.\u02ca("[INFO] ", string);
                    return Optional.of(new q(view, (Map<String, String>)this.\u02cb));
                }
            }, NativeDisplayTracker.class);
            return nativeDisplayTracker;
        }
        catch (Exception exception) {
            o.\u02ce(exception);
            return new NoOp.c();
        }
    }

    @Override
    public final NativeVideoTracker createNativeVideoTracker(String string) {
        try {
            NativeVideoTracker nativeVideoTracker = p.\u02cb(new p.c<NativeVideoTracker>(this, string){
                private /* synthetic */ String \u02ca;
                private /* synthetic */ k \u0971;
                {
                    this.\u0971 = k2;
                    this.\u02ca = string;
                }

                @Override
                public final Optional<NativeVideoTracker> \u02cb() {
                    a.\u02cf(3, "Factory", this, "Attempting to create NativeVideoTracker");
                    a.\u02ca("[INFO] ", "Attempting to create NativeVideoTracker");
                    return Optional.of(new s(this.\u02ca));
                }
            }, NativeVideoTracker.class);
            return nativeVideoTracker;
        }
        catch (Exception exception) {
            o.\u02ce(exception);
            return new NoOp.b();
        }
    }

    @Override
    public final WebAdTracker createWebAdTracker(ViewGroup viewGroup) {
        try {
            WebAdTracker webAdTracker = p.\u02cb(new p.c<WebAdTracker>(this, new WeakReference((Object)viewGroup)){
                private /* synthetic */ WeakReference \u02ca;
                private /* synthetic */ k \u02cf;
                {
                    this.\u02cf = k2;
                    this.\u02ca = weakReference;
                }

                @Override
                public final Optional<WebAdTracker> \u02cb() throws o {
                    ViewGroup viewGroup = (ViewGroup)this.\u02ca.get();
                    StringBuilder stringBuilder = new StringBuilder("Attempting to create WebAdTracker for adContainer ");
                    stringBuilder.append(a.\u02cf((View)viewGroup));
                    String string = stringBuilder.toString();
                    a.\u02cf(3, "Factory", this, string);
                    a.\u02ca("[INFO] ", string);
                    return Optional.of(new v(viewGroup));
                }
            }, WebAdTracker.class);
            return webAdTracker;
        }
        catch (Exception exception) {
            o.\u02ce(exception);
            return new NoOp.e();
        }
    }

    @Override
    public final WebAdTracker createWebAdTracker(WebView webView) {
        try {
            WebAdTracker webAdTracker = p.\u02cb(new p.c<WebAdTracker>(this, new WeakReference((Object)webView)){
                private /* synthetic */ k \u02ca;
                private /* synthetic */ WeakReference \u02ce;
                {
                    this.\u02ca = k2;
                    this.\u02ce = weakReference;
                }

                @Override
                public final Optional<WebAdTracker> \u02cb() {
                    WebView webView = (WebView)this.\u02ce.get();
                    StringBuilder stringBuilder = new StringBuilder("Attempting to create WebAdTracker for ");
                    stringBuilder.append(a.\u02cf((View)webView));
                    String string = stringBuilder.toString();
                    a.\u02cf(3, "Factory", this, string);
                    a.\u02ca("[INFO] ", string);
                    return Optional.of(new v(webView));
                }
            }, WebAdTracker.class);
            return webAdTracker;
        }
        catch (Exception exception) {
            o.\u02ce(exception);
            return new NoOp.e();
        }
    }

}

