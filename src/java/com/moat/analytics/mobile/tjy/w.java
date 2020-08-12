/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  android.webkit.WebView
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.ref.WeakReference
 */
package com.moat.analytics.mobile.tjy;

import android.util.Log;
import android.webkit.WebView;
import com.moat.analytics.mobile.tjy.ap;
import com.moat.analytics.mobile.tjy.ba;
import com.moat.analytics.mobile.tjy.base.functional.a;
import com.moat.analytics.mobile.tjy.bj;
import com.moat.analytics.mobile.tjy.v;
import java.lang.ref.WeakReference;

class w
implements ba {
    final /* synthetic */ WeakReference a;
    final /* synthetic */ ap b;
    final /* synthetic */ v c;

    w(v v2, WeakReference weakReference, ap ap2) {
        this.c = v2;
        this.a = weakReference;
        this.b = ap2;
    }

    @Override
    public a a() {
        WebView webView = (WebView)this.a.get();
        boolean bl2 = this.b.b();
        if (webView == null) {
            if (bl2) {
                Log.e((String)"MoatFactory", (String)"Target ViewGroup is null. Not creating WebAdTracker.");
            }
            return a.a();
        }
        if (bl2) {
            StringBuilder stringBuilder = new StringBuilder("Creating WebAdTracker for ");
            stringBuilder.append(webView.getClass().getSimpleName());
            stringBuilder.append("@");
            stringBuilder.append(webView.hashCode());
            Log.d((String)"MoatFactory", (String)stringBuilder.toString());
        }
        return a.a(new bj(webView, v.a(this.c), this.b));
    }
}

