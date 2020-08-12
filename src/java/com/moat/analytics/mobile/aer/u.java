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
package com.moat.analytics.mobile.aer;

import android.util.Log;
import android.view.View;
import com.moat.analytics.mobile.aer.NativeDisplayTracker;
import com.moat.analytics.mobile.aer.ab;
import com.moat.analytics.mobile.aer.al;
import com.moat.analytics.mobile.aer.aw;
import com.moat.analytics.mobile.aer.base.functional.a;
import com.moat.analytics.mobile.aer.r;
import java.lang.ref.WeakReference;

class u
implements aw<NativeDisplayTracker> {
    final /* synthetic */ WeakReference a;
    final /* synthetic */ al b;
    final /* synthetic */ String c;
    final /* synthetic */ r d;

    u(r r2, WeakReference weakReference, al al2, String string) {
        this.d = r2;
        this.a = weakReference;
        this.b = al2;
        this.c = string;
    }

    @Override
    public a<NativeDisplayTracker> a() {
        View view = (View)this.a.get();
        if (view == null) {
            if (this.b.b()) {
                Log.e((String)"MoatFactory", (String)"Target view is null. Not creating NativeDisplayTracker.");
            }
            return a.a();
        }
        if (this.b.b()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Creating NativeDisplayTracker for ");
            stringBuilder.append(view.getClass().getSimpleName());
            stringBuilder.append("@");
            stringBuilder.append(view.hashCode());
            Log.d((String)"MoatFactory", (String)stringBuilder.toString());
        }
        return a.a(new ab(view, this.c, r.a(this.d), this.b));
    }
}

