/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  android.view.View
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.ref.WeakReference
 */
package com.moat.analytics.mobile.tjy;

import android.util.Log;
import android.view.View;
import com.moat.analytics.mobile.tjy.af;
import com.moat.analytics.mobile.tjy.ap;
import com.moat.analytics.mobile.tjy.ba;
import com.moat.analytics.mobile.tjy.base.functional.a;
import com.moat.analytics.mobile.tjy.v;
import java.lang.ref.WeakReference;

class y
implements ba {
    final /* synthetic */ WeakReference a;
    final /* synthetic */ ap b;
    final /* synthetic */ String c;
    final /* synthetic */ v d;

    y(v v2, WeakReference weakReference, ap ap2, String string) {
        this.d = v2;
        this.a = weakReference;
        this.b = ap2;
        this.c = string;
    }

    @Override
    public a a() {
        View view = (View)this.a.get();
        if (view == null) {
            if (this.b.b()) {
                Log.e((String)"MoatFactory", (String)"Target view is null. Not creating NativeDisplayTracker.");
            }
            return a.a();
        }
        if (this.b.b()) {
            StringBuilder stringBuilder = new StringBuilder("Creating NativeDisplayTracker for ");
            stringBuilder.append(view.getClass().getSimpleName());
            stringBuilder.append("@");
            stringBuilder.append(view.hashCode());
            Log.d((String)"MoatFactory", (String)stringBuilder.toString());
        }
        return a.a(new af(view, this.c, v.a(this.d), this.b));
    }
}

