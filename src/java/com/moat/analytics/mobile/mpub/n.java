/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup
 *  android.webkit.WebView
 *  com.moat.analytics.mobile.mpub.u
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.ref.WeakReference
 *  java.util.Map
 */
package com.moat.analytics.mobile.mpub;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.moat.analytics.mobile.mpub.MoatFactory;
import com.moat.analytics.mobile.mpub.MoatPlugin;
import com.moat.analytics.mobile.mpub.NativeDisplayTracker;
import com.moat.analytics.mobile.mpub.NativeVideoTracker;
import com.moat.analytics.mobile.mpub.WebAdTracker;
import com.moat.analytics.mobile.mpub.a.b.a;
import com.moat.analytics.mobile.mpub.aa;
import com.moat.analytics.mobile.mpub.k;
import com.moat.analytics.mobile.mpub.m;
import com.moat.analytics.mobile.mpub.p;
import com.moat.analytics.mobile.mpub.t;
import com.moat.analytics.mobile.mpub.u;
import com.moat.analytics.mobile.mpub.v;
import com.moat.analytics.mobile.mpub.x;
import java.lang.ref.WeakReference;
import java.util.Map;

class n
extends MoatFactory {
    n() {
        if (this.a()) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Failed to initialize MoatFactory");
        stringBuilder.append(", SDK was not started");
        p.a("[ERROR] ", 3, "Factory", this, stringBuilder.toString());
        throw new m("Failed to initialize MoatFactory");
    }

    private NativeDisplayTracker a(View view, Map<String, String> map) {
        return x.a(new x.a<NativeDisplayTracker>(new WeakReference((Object)view), map){
            final /* synthetic */ WeakReference a;
            final /* synthetic */ Map b;
            {
                this.a = weakReference;
                this.b = map;
            }

            @Override
            public a<NativeDisplayTracker> a() {
                View view = (View)this.a.get();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Attempting to create NativeDisplayTracker for ");
                stringBuilder.append(p.a(view));
                p.a("[INFO] ", 3, "Factory", this, stringBuilder.toString());
                return a.a(new t(view, (Map<String, String>)this.b));
            }
        }, NativeDisplayTracker.class);
    }

    private NativeVideoTracker a(final String string) {
        return x.a(new x.a<NativeVideoTracker>(){

            @Override
            public a<NativeVideoTracker> a() {
                p.a("[INFO] ", 3, "Factory", this, "Attempting to create NativeVideoTracker");
                return a.a(new u(string));
            }
        }, NativeVideoTracker.class);
    }

    private WebAdTracker a(ViewGroup viewGroup) {
        return x.a(new x.a<WebAdTracker>(new WeakReference((Object)viewGroup)){
            final /* synthetic */ WeakReference a;
            {
                this.a = weakReference;
            }

            @Override
            public a<WebAdTracker> a() {
                ViewGroup viewGroup = (ViewGroup)this.a.get();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Attempting to create WebAdTracker for adContainer ");
                stringBuilder.append(p.a((View)viewGroup));
                p.a("[INFO] ", 3, "Factory", this, stringBuilder.toString());
                return a.a(new aa(viewGroup));
            }
        }, WebAdTracker.class);
    }

    private WebAdTracker a(WebView webView) {
        return x.a(new x.a<WebAdTracker>(new WeakReference((Object)webView)){
            final /* synthetic */ WeakReference a;
            {
                this.a = weakReference;
            }

            @Override
            public a<WebAdTracker> a() {
                WebView webView = (WebView)this.a.get();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Attempting to create WebAdTracker for ");
                stringBuilder.append(p.a((View)webView));
                p.a("[INFO] ", 3, "Factory", this, stringBuilder.toString());
                return a.a(new aa(webView));
            }
        }, WebAdTracker.class);
    }

    private <T> T a(MoatPlugin<T> moatPlugin) {
        return moatPlugin.a();
    }

    private boolean a() {
        return ((k)k.getInstance()).a();
    }

    @Override
    public <T> T createCustomTracker(MoatPlugin<T> moatPlugin) {
        T t2;
        try {
            t2 = this.a(moatPlugin);
        }
        catch (Exception exception) {
            m.a(exception);
            return moatPlugin.b();
        }
        return t2;
    }

    @Override
    public NativeDisplayTracker createNativeDisplayTracker(View view, Map<String, String> map) {
        try {
            NativeDisplayTracker nativeDisplayTracker = this.a(view, map);
            return nativeDisplayTracker;
        }
        catch (Exception exception) {
            m.a(exception);
            return new v.c();
        }
    }

    @Override
    public NativeVideoTracker createNativeVideoTracker(String string) {
        try {
            NativeVideoTracker nativeVideoTracker = this.a(string);
            return nativeVideoTracker;
        }
        catch (Exception exception) {
            m.a(exception);
            return new v.d();
        }
    }

    @Override
    public WebAdTracker createWebAdTracker(ViewGroup viewGroup) {
        try {
            WebAdTracker webAdTracker = this.a(viewGroup);
            return webAdTracker;
        }
        catch (Exception exception) {
            m.a(exception);
            return new v.e();
        }
    }

    @Override
    public WebAdTracker createWebAdTracker(WebView webView) {
        try {
            WebAdTracker webAdTracker = this.a(webView);
            return webAdTracker;
        }
        catch (Exception exception) {
            m.a(exception);
            return new v.e();
        }
    }

}

