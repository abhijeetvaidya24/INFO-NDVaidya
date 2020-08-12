/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  android.view.ViewGroup
 *  android.webkit.WebView
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.ref.WeakReference
 */
package com.moat.analytics.mobile.tjy;

import android.util.Log;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.moat.analytics.mobile.tjy.ap;
import com.moat.analytics.mobile.tjy.ba;
import com.moat.analytics.mobile.tjy.base.functional.a;
import com.moat.analytics.mobile.tjy.bj;
import com.moat.analytics.mobile.tjy.v;
import java.lang.ref.WeakReference;

class x
implements ba {
    final /* synthetic */ WeakReference a;
    final /* synthetic */ ap b;
    final /* synthetic */ v c;

    x(v v2, WeakReference weakReference, ap ap2) {
        this.c = v2;
        this.a = weakReference;
        this.b = ap2;
    }

    @Override
    public a a() {
        ViewGroup viewGroup = (ViewGroup)this.a.get();
        boolean bl2 = this.b.b();
        if (viewGroup == null) {
            if (bl2) {
                Log.e((String)"MoatFactory", (String)"Target ViewGroup is null. Not creating WebAdTracker.");
            }
            return a.a();
        }
        if (bl2) {
            StringBuilder stringBuilder = new StringBuilder("Creating WebAdTracker for ");
            stringBuilder.append(viewGroup.getClass().getSimpleName());
            stringBuilder.append("@");
            stringBuilder.append(viewGroup.hashCode());
            Log.d((String)"MoatFactory", (String)stringBuilder.toString());
        }
        a a2 = v.b(this.c).a(viewGroup);
        boolean bl3 = a2.c();
        if (bl2) {
            StringBuilder stringBuilder = new StringBuilder("WebView ");
            String string = bl3 ? "" : "not ";
            stringBuilder.append(string);
            stringBuilder.append("found inside of ad container.");
            Log.e((String)"MoatFactory", (String)stringBuilder.toString());
        }
        return a.a(new bj((WebView)a2.c(null), v.a(this.c), this.b));
    }
}

