/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup
 *  android.webkit.WebView
 *  com.moat.analytics.mobile.ogury.r
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.ref.WeakReference
 *  java.util.Map
 */
package com.moat.analytics.mobile.ogury;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.moat.analytics.mobile.ogury.MoatFactory;
import com.moat.analytics.mobile.ogury.NativeDisplayTracker;
import com.moat.analytics.mobile.ogury.NativeVideoTracker;
import com.moat.analytics.mobile.ogury.NoOp;
import com.moat.analytics.mobile.ogury.WebAdTracker;
import com.moat.analytics.mobile.ogury.base.functional.Optional;
import com.moat.analytics.mobile.ogury.e;
import com.moat.analytics.mobile.ogury.i;
import com.moat.analytics.mobile.ogury.l;
import com.moat.analytics.mobile.ogury.n;
import com.moat.analytics.mobile.ogury.p;
import com.moat.analytics.mobile.ogury.r;
import com.moat.analytics.mobile.ogury.t;
import com.moat.analytics.mobile.ogury.w;
import java.lang.ref.WeakReference;
import java.util.Map;

final class o
extends MoatFactory {
    o() throws l {
        if (((i)i.getInstance()).\u02cf()) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Failed to initialize MoatFactory");
        stringBuilder.append(", SDK was not started");
        String string = stringBuilder.toString();
        e.1.\u02cb(3, "Factory", this, string);
        e.1.\u0971("[ERROR] ", string);
        throw new l("Failed to initialize MoatFactory");
    }

    @Override
    public final <T> T createCustomTracker(n<T> n2) {
        T t2;
        try {
            t2 = n2.create();
        }
        catch (Exception exception) {
            l.\u0971(exception);
            return n2.createNoOp();
        }
        return t2;
    }

    @Override
    public final NativeDisplayTracker createNativeDisplayTracker(View view, Map<String, String> map) {
        try {
            NativeDisplayTracker nativeDisplayTracker = p.\u02cb(new p.b<NativeDisplayTracker>(this, new WeakReference((Object)view), map){
                private /* synthetic */ WeakReference \u02ca;
                private /* synthetic */ o \u02ce;
                private /* synthetic */ Map \u02cf;
                {
                    this.\u02ce = o2;
                    this.\u02ca = weakReference;
                    this.\u02cf = map;
                }

                @Override
                public final Optional<NativeDisplayTracker> \u02cf() {
                    View view = (View)this.\u02ca.get();
                    StringBuilder stringBuilder = new StringBuilder("Attempting to create NativeDisplayTracker for ");
                    stringBuilder.append(e.1.\u02cf(view));
                    String string = stringBuilder.toString();
                    e.1.\u02cb(3, "Factory", this, string);
                    e.1.\u0971("[INFO] ", string);
                    return Optional.of(new t(view, (Map<String, String>)this.\u02cf));
                }
            }, NativeDisplayTracker.class);
            return nativeDisplayTracker;
        }
        catch (Exception exception) {
            l.\u0971(exception);
            return new NoOp.d();
        }
    }

    @Override
    public final NativeVideoTracker createNativeVideoTracker(String string) {
        try {
            NativeVideoTracker nativeVideoTracker = p.\u02cb(new p.b<NativeVideoTracker>(this, string){
                private /* synthetic */ o \u02ce;
                private /* synthetic */ String \u0971;
                {
                    this.\u02ce = o2;
                    this.\u0971 = string;
                }

                @Override
                public final Optional<NativeVideoTracker> \u02cf() {
                    e.1.\u02cb(3, "Factory", this, "Attempting to create NativeVideoTracker");
                    e.1.\u0971("[INFO] ", "Attempting to create NativeVideoTracker");
                    return Optional.of(new r(this.\u0971));
                }
            }, NativeVideoTracker.class);
            return nativeVideoTracker;
        }
        catch (Exception exception) {
            l.\u0971(exception);
            return new NoOp.a();
        }
    }

    @Override
    public final WebAdTracker createWebAdTracker(ViewGroup viewGroup) {
        try {
            WebAdTracker webAdTracker = p.\u02cb(new p.b<WebAdTracker>(this, new WeakReference((Object)viewGroup)){
                private /* synthetic */ WeakReference \u02ca;
                private /* synthetic */ o \u0971;
                {
                    this.\u0971 = o2;
                    this.\u02ca = weakReference;
                }

                @Override
                public final Optional<WebAdTracker> \u02cf() throws l {
                    ViewGroup viewGroup = (ViewGroup)this.\u02ca.get();
                    StringBuilder stringBuilder = new StringBuilder("Attempting to create WebAdTracker for adContainer ");
                    stringBuilder.append(e.1.\u02cf((View)viewGroup));
                    String string = stringBuilder.toString();
                    e.1.\u02cb(3, "Factory", this, string);
                    e.1.\u0971("[INFO] ", string);
                    return Optional.of(new w(viewGroup));
                }
            }, WebAdTracker.class);
            return webAdTracker;
        }
        catch (Exception exception) {
            l.\u0971(exception);
            return new NoOp.b();
        }
    }

    @Override
    public final WebAdTracker createWebAdTracker(WebView webView) {
        try {
            WebAdTracker webAdTracker = p.\u02cb(new p.b<WebAdTracker>(this, new WeakReference((Object)webView)){
                private /* synthetic */ o \u02ce;
                private /* synthetic */ WeakReference \u0971;
                {
                    this.\u02ce = o2;
                    this.\u0971 = weakReference;
                }

                @Override
                public final Optional<WebAdTracker> \u02cf() {
                    WebView webView = (WebView)this.\u0971.get();
                    StringBuilder stringBuilder = new StringBuilder("Attempting to create WebAdTracker for ");
                    stringBuilder.append(e.1.\u02cf((View)webView));
                    String string = stringBuilder.toString();
                    e.1.\u02cb(3, "Factory", this, string);
                    e.1.\u0971("[INFO] ", string);
                    return Optional.of(new w(webView));
                }
            }, WebAdTracker.class);
            return webAdTracker;
        }
        catch (Exception exception) {
            l.\u0971(exception);
            return new NoOp.b();
        }
    }

}

