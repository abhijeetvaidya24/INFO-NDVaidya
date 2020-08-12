/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.view.View
 *  android.view.ViewGroup
 *  android.webkit.WebView
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.ref.WeakReference
 *  java.util.concurrent.atomic.AtomicReference
 */
package com.moat.analytics.mobile.aer;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.moat.analytics.mobile.aer.MoatFactory;
import com.moat.analytics.mobile.aer.NativeDisplayTracker;
import com.moat.analytics.mobile.aer.NativeVideoTracker;
import com.moat.analytics.mobile.aer.WebAdTracker;
import com.moat.analytics.mobile.aer.ac;
import com.moat.analytics.mobile.aer.ae;
import com.moat.analytics.mobile.aer.ah;
import com.moat.analytics.mobile.aer.ai;
import com.moat.analytics.mobile.aer.aj;
import com.moat.analytics.mobile.aer.ak;
import com.moat.analytics.mobile.aer.al;
import com.moat.analytics.mobile.aer.ao;
import com.moat.analytics.mobile.aer.au;
import com.moat.analytics.mobile.aer.base.exception.a;
import com.moat.analytics.mobile.aer.bd;
import com.moat.analytics.mobile.aer.bl;
import com.moat.analytics.mobile.aer.bm;
import com.moat.analytics.mobile.aer.c;
import com.moat.analytics.mobile.aer.s;
import com.moat.analytics.mobile.aer.t;
import com.moat.analytics.mobile.aer.u;
import com.moat.analytics.mobile.aer.v;
import com.moat.analytics.mobile.aer.w;
import com.moat.analytics.mobile.aer.x;
import com.moat.analytics.mobile.aer.y;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicReference;

class r
extends MoatFactory {
    private static final AtomicReference<al> c = new AtomicReference();
    private final bl a = new bm();
    private final com.moat.analytics.mobile.aer.a b;

    r(Activity activity) {
        if (c.get() == null) {
            al al2 = new aj();
            try {
                ao ao2 = new ao(x.a);
                al2 = ao2;
            }
            catch (Exception exception) {
                a.a(exception);
            }
            c.compareAndSet(null, (Object)al2);
        }
        this.b = new c(activity, (al)c.get());
        this.b.b();
    }

    private NativeDisplayTracker a(View view, String string) {
        com.moat.analytics.mobile.aer.base.asserts.a.a((Object)view);
        al al2 = (al)c.get();
        return au.a(al2, new u(this, new WeakReference((Object)view), al2, string), new ac());
    }

    private NativeVideoTracker a(String string) {
        al al2 = (al)c.get();
        return au.a(al2, new v(this, al2, string), new ae());
    }

    private WebAdTracker a(ViewGroup viewGroup) {
        com.moat.analytics.mobile.aer.base.asserts.a.a((Object)viewGroup);
        al al2 = (al)c.get();
        return au.a(al2, new t(this, new WeakReference((Object)viewGroup), al2), new bd());
    }

    private WebAdTracker a(WebView webView) {
        com.moat.analytics.mobile.aer.base.asserts.a.a((Object)webView);
        WeakReference weakReference = new WeakReference((Object)webView);
        al al2 = (al)c.get();
        return au.a(al2, new s(this, weakReference, al2), new bd());
    }

    static /* synthetic */ com.moat.analytics.mobile.aer.a a(r r2) {
        return r2.b;
    }

    static /* synthetic */ bl b(r r2) {
        return r2.a;
    }

    public <T> T a(y<T> y2) {
        return y2.a(this.b, (al)c.get());
    }

    @Override
    public <T> T createCustomTracker(y<T> y2) {
        T t2;
        try {
            t2 = this.a(y2);
        }
        catch (Exception exception) {
            a.a(exception);
            return y2.a();
        }
        return t2;
    }

    @Override
    public NativeDisplayTracker createNativeDisplayTracker(View view, String string) {
        try {
            NativeDisplayTracker nativeDisplayTracker = this.a(view, string);
            return nativeDisplayTracker;
        }
        catch (Exception exception) {
            a.a(exception);
            return new ah();
        }
    }

    @Override
    public NativeVideoTracker createNativeVideoTracker(String string) {
        try {
            NativeVideoTracker nativeVideoTracker = this.a(string);
            return nativeVideoTracker;
        }
        catch (Exception exception) {
            a.a(exception);
            return new ai();
        }
    }

    @Override
    public WebAdTracker createWebAdTracker(ViewGroup viewGroup) {
        try {
            WebAdTracker webAdTracker = this.a(viewGroup);
            return webAdTracker;
        }
        catch (Exception exception) {
            a.a(exception);
            return new ak();
        }
    }

    @Override
    public WebAdTracker createWebAdTracker(WebView webView) {
        try {
            WebAdTracker webAdTracker = this.a(webView);
            return webAdTracker;
        }
        catch (Exception exception) {
            a.a(exception);
            return new ak();
        }
    }

    @Override
    public WebAdTracker createWebDisplayTracker(ViewGroup viewGroup) {
        return this.createWebAdTracker(viewGroup);
    }

    @Override
    public WebAdTracker createWebDisplayTracker(WebView webView) {
        return this.createWebAdTracker(webView);
    }
}

