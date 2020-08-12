/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  com.adincube.sdk.h.c.c
 *  com.adincube.sdk.h.g
 *  com.adincube.sdk.mediation.e.c
 *  com.adincube.sdk.mediation.e.d
 *  com.adincube.sdk.mediation.n.a
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONObject
 */
package com.adincube.sdk.mediation.e;

import android.app.Activity;
import android.content.Context;
import com.adincube.sdk.h.g;
import com.adincube.sdk.mediation.e.b;
import com.adincube.sdk.mediation.e.c;
import com.adincube.sdk.mediation.e.d;
import com.adincube.sdk.mediation.e.f;
import com.adincube.sdk.mediation.i;
import com.adincube.sdk.mediation.i.a;
import com.amazon.device.ads.AdRegistration;
import org.json.JSONObject;

public final class e
implements i {
    private f a;
    private b b = new b();
    private com.adincube.sdk.mediation.aa.a c = new com.adincube.sdk.mediation.aa.a();

    public e() {
        AdRegistration.class.getSimpleName();
    }

    @Override
    public final a a(Context context, com.adincube.sdk.h.c.c c2, boolean bl) {
        return new c(this, context, c2, bl);
    }

    @Override
    public final com.adincube.sdk.mediation.n.a a(Activity activity) {
        d d2 = new d(this);
        d2.a = activity;
        return d2;
    }

    @Override
    public final void a(Context context) {
        AdRegistration.setAppKey(this.a.k);
    }

    @Override
    public final void a(Context context, JSONObject jSONObject) {
        this.a = new f(jSONObject);
        this.a(context);
    }

    @Override
    public final void a(g g2) {
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
        return AdRegistration.getVersion();
    }

    @Override
    public final com.adincube.sdk.mediation.e c() {
        return this.a;
    }

    @Override
    public final boolean d() {
        return true;
    }

    @Override
    public final boolean e() {
        return true;
    }

    @Override
    public final String f() {
        return "Amazon";
    }

    @Override
    public final com.adincube.sdk.mediation.aa.c g() {
        return this.c;
    }
}

