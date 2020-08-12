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
package com.moat.analytics.mobile.aer;

import android.util.Log;
import android.webkit.WebView;
import com.moat.analytics.mobile.aer.WebAdTracker;
import com.moat.analytics.mobile.aer.al;
import com.moat.analytics.mobile.aer.aw;
import com.moat.analytics.mobile.aer.base.functional.a;
import com.moat.analytics.mobile.aer.bc;
import com.moat.analytics.mobile.aer.r;
import java.lang.ref.WeakReference;

class s
implements aw<WebAdTracker> {
    final /* synthetic */ WeakReference a;
    final /* synthetic */ al b;
    final /* synthetic */ r c;

    s(r r2, WeakReference weakReference, al al2) {
        this.c = r2;
        this.a = weakReference;
        this.b = al2;
    }

    @Override
    public a<WebAdTracker> a() {
        WebView webView = (WebView)this.a.get();
        boolean bl2 = this.b.b();
        if (webView == null) {
            if (bl2) {
                Log.e((String)"MoatFactory", (String)"Target ViewGroup is null. Not creating WebAdTracker.");
            }
            return a.a();
        }
        if (bl2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Creating WebAdTracker for ");
            stringBuilder.append(webView.getClass().getSimpleName());
            stringBuilder.append("@");
            stringBuilder.append(webView.hashCode());
            Log.d((String)"MoatFactory", (String)stringBuilder.toString());
        }
        return a.a(new bc(webView, r.a(this.c), this.b));
    }
}

