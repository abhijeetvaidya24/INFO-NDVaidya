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
package com.moat.analytics.mobile.tjy;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.moat.analytics.mobile.tjy.MoatFactory;
import com.moat.analytics.mobile.tjy.NativeDisplayTracker;
import com.moat.analytics.mobile.tjy.NativeVideoTracker;
import com.moat.analytics.mobile.tjy.WebAdTracker;
import com.moat.analytics.mobile.tjy.aa;
import com.moat.analytics.mobile.tjy.ab;
import com.moat.analytics.mobile.tjy.ac;
import com.moat.analytics.mobile.tjy.ag;
import com.moat.analytics.mobile.tjy.ai;
import com.moat.analytics.mobile.tjy.al;
import com.moat.analytics.mobile.tjy.am;
import com.moat.analytics.mobile.tjy.an;
import com.moat.analytics.mobile.tjy.ao;
import com.moat.analytics.mobile.tjy.ap;
import com.moat.analytics.mobile.tjy.as;
import com.moat.analytics.mobile.tjy.ay;
import com.moat.analytics.mobile.tjy.base.asserts.a;
import com.moat.analytics.mobile.tjy.bk;
import com.moat.analytics.mobile.tjy.bl;
import com.moat.analytics.mobile.tjy.bm;
import com.moat.analytics.mobile.tjy.c;
import com.moat.analytics.mobile.tjy.w;
import com.moat.analytics.mobile.tjy.x;
import com.moat.analytics.mobile.tjy.y;
import com.moat.analytics.mobile.tjy.z;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicReference;

class v
extends MoatFactory {
    private static final AtomicReference c = new AtomicReference();
    private final bl a = new bm();
    private final com.moat.analytics.mobile.tjy.a b;

    v(Activity activity) {
        if (c.get() == null) {
            ap ap2 = new an();
            try {
                as as2 = new as(ab.a);
                ap2 = as2;
            }
            catch (Exception exception) {
                com.moat.analytics.mobile.tjy.base.exception.a.a(exception);
            }
            c.compareAndSet(null, (Object)ap2);
        }
        this.b = new c(activity, (ap)c.get());
        this.b.b();
    }

    private NativeDisplayTracker a(View view, String string) {
        a.a((Object)view);
        ap ap2 = (ap)c.get();
        return (NativeDisplayTracker)ay.a(ap2, new y(this, new WeakReference((Object)view), ap2, string), new ag());
    }

    private NativeVideoTracker a(String string) {
        ap ap2 = (ap)c.get();
        return (NativeVideoTracker)ay.a(ap2, new z(this, ap2, string), new ai());
    }

    private WebAdTracker a(ViewGroup viewGroup) {
        a.a((Object)viewGroup);
        ap ap2 = (ap)c.get();
        return (WebAdTracker)ay.a(ap2, new x(this, new WeakReference((Object)viewGroup), ap2), new bk());
    }

    private WebAdTracker a(WebView webView) {
        a.a((Object)webView);
        WeakReference weakReference = new WeakReference((Object)webView);
        ap ap2 = (ap)c.get();
        return (WebAdTracker)ay.a(ap2, new w(this, weakReference, ap2), new bk());
    }

    static /* synthetic */ com.moat.analytics.mobile.tjy.a a(v v2) {
        return v2.b;
    }

    static /* synthetic */ bl b(v v2) {
        return v2.a;
    }

    public Object a(ac ac2) {
        return ac2.a(this.b, (ap)c.get());
    }

    @Override
    public Object createCustomTracker(ac ac2) {
        try {
            Object object = this.a(ac2);
            return object;
        }
        catch (Exception exception) {
            com.moat.analytics.mobile.tjy.base.exception.a.a(exception);
            return ac2.a();
        }
    }

    @Override
    public NativeDisplayTracker createNativeDisplayTracker(View view, String string) {
        try {
            NativeDisplayTracker nativeDisplayTracker = this.a(view, string);
            return nativeDisplayTracker;
        }
        catch (Exception exception) {
            com.moat.analytics.mobile.tjy.base.exception.a.a(exception);
            return new al();
        }
    }

    @Override
    public NativeVideoTracker createNativeVideoTracker(String string) {
        try {
            NativeVideoTracker nativeVideoTracker = this.a(string);
            return nativeVideoTracker;
        }
        catch (Exception exception) {
            com.moat.analytics.mobile.tjy.base.exception.a.a(exception);
            return new am();
        }
    }

    @Override
    public WebAdTracker createWebAdTracker(ViewGroup viewGroup) {
        try {
            WebAdTracker webAdTracker = this.a(viewGroup);
            return webAdTracker;
        }
        catch (Exception exception) {
            com.moat.analytics.mobile.tjy.base.exception.a.a(exception);
            return new ao();
        }
    }

    @Override
    public WebAdTracker createWebAdTracker(WebView webView) {
        try {
            WebAdTracker webAdTracker = this.a(webView);
            return webAdTracker;
        }
        catch (Exception exception) {
            com.moat.analytics.mobile.tjy.base.exception.a.a(exception);
            return new ao();
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

