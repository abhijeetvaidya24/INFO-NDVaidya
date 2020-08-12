/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.moat.analytics.mobile.aer.ad
 *  java.lang.Object
 *  java.lang.String
 */
package com.moat.analytics.mobile.aer;

import android.util.Log;
import com.moat.analytics.mobile.aer.NativeVideoTracker;
import com.moat.analytics.mobile.aer.ad;
import com.moat.analytics.mobile.aer.al;
import com.moat.analytics.mobile.aer.aw;
import com.moat.analytics.mobile.aer.base.functional.a;
import com.moat.analytics.mobile.aer.r;

class v
implements aw<NativeVideoTracker> {
    final /* synthetic */ al a;
    final /* synthetic */ String b;
    final /* synthetic */ r c;

    v(r r2, al al2, String string) {
        this.c = r2;
        this.a = al2;
        this.b = string;
    }

    @Override
    public a<NativeVideoTracker> a() {
        if (this.a.b()) {
            Log.d((String)"MoatFactory", (String)"Creating NativeVideo tracker.");
        }
        return a.a(new ad(this.b, r.a(this.c), this.a));
    }
}

