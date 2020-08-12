/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  com.adincube.sdk.h.c.c
 *  com.adincube.sdk.h.g
 *  com.adincube.sdk.mediation.g.a
 *  com.adincube.sdk.mediation.g.c
 *  com.adincube.sdk.mediation.n.a
 *  com.appnext.ads.interstitial.Interstitial
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONObject
 */
package com.adincube.sdk.mediation.g;

import android.app.Activity;
import android.content.Context;
import com.adincube.sdk.mediation.g.a;
import com.adincube.sdk.mediation.g.c;
import com.adincube.sdk.mediation.g.g;
import com.adincube.sdk.mediation.g.j;
import com.adincube.sdk.mediation.i;
import com.appnext.ads.interstitial.Interstitial;
import org.json.JSONObject;

public final class e
implements i {
    g a = null;
    private j b = new j();

    public e() {
        Interstitial.class.getSimpleName();
    }

    @Override
    public final com.adincube.sdk.mediation.i.a a(Context context, com.adincube.sdk.h.c.c c2, boolean bl) {
        return new a(this, context, c2, bl);
    }

    @Override
    public final com.adincube.sdk.mediation.n.a a(Activity activity) {
        c c2 = new c(this);
        c2.a = activity;
        return c2;
    }

    @Override
    public final void a(Context context) {
    }

    @Override
    public final void a(Context context, JSONObject jSONObject) {
        this.a = new g(jSONObject);
    }

    @Override
    public final void a(com.adincube.sdk.h.g g2) {
    }

    @Override
    public final boolean a() {
        return this.a != null;
    }

    @Override
    public final com.adincube.sdk.mediation.c b() {
        return null;
    }

    @Override
    public final String b(Context context) {
        return "2.3.1.471";
    }

    @Override
    public final com.adincube.sdk.mediation.e c() {
        return this.a;
    }

    @Override
    public final boolean d() {
        return false;
    }

    @Override
    public final boolean e() {
        return true;
    }

    @Override
    public final String f() {
        return "AppNext";
    }

    @Override
    public final com.adincube.sdk.mediation.aa.c g() {
        return this.b;
    }
}

