/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  com.adincube.sdk.h.c.c
 *  com.adincube.sdk.h.g
 *  com.adincube.sdk.mediation.chartboost.a
 *  com.adincube.sdk.mediation.chartboost.c
 *  com.adincube.sdk.mediation.chartboost.g
 *  com.adincube.sdk.mediation.n.a
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONObject
 */
package com.adincube.sdk.mediation.chartboost;

import android.app.Activity;
import android.content.Context;
import com.adincube.sdk.mediation.chartboost.a;
import com.adincube.sdk.mediation.chartboost.c;
import com.adincube.sdk.mediation.chartboost.e;
import com.adincube.sdk.mediation.chartboost.g;
import com.adincube.sdk.mediation.chartboost.h;
import com.adincube.sdk.mediation.i;
import com.chartboost.sdk.Chartboost;
import org.json.JSONObject;

public final class d
implements i {
    e a = null;
    private c b = null;
    private g c = null;
    private h d = new h();
    private a e = null;

    public d() {
        Chartboost.class.getSimpleName();
    }

    @Override
    public final com.adincube.sdk.mediation.i.a a(Context context, com.adincube.sdk.h.c.c c2, boolean bl) {
        return null;
    }

    @Override
    public final com.adincube.sdk.mediation.n.a a(Activity activity) {
        c c2 = this.b;
        c2.a = activity;
        return c2;
    }

    @Override
    public final void a(Context context) {
    }

    @Override
    public final void a(Context context, JSONObject jSONObject) {
        this.a = new e(jSONObject);
        this.b = new c(this);
        this.c = new g(this);
        this.e = a.a();
        this.e.a(this.b);
        this.e.a(this.c);
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
        return Chartboost.getSDKVersion();
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
        return "Chartboost";
    }

    @Override
    public final com.adincube.sdk.mediation.aa.c g() {
        return this.d;
    }
}

