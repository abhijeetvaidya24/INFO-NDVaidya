/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  com.adincube.sdk.h.c.c
 *  com.adincube.sdk.h.g
 *  com.adincube.sdk.mediation.j.b
 *  com.adincube.sdk.mediation.j.d
 *  com.adincube.sdk.mediation.n.a
 *  com.google.android.gms.ads.doubleclick.PublisherAdRequest
 *  java.lang.Boolean
 *  java.lang.Float
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONObject
 */
package com.adincube.sdk.mediation.j;

import android.app.Activity;
import android.content.Context;
import com.adincube.sdk.h.g;
import com.adincube.sdk.mediation.c;
import com.adincube.sdk.mediation.i;
import com.adincube.sdk.mediation.i.a;
import com.adincube.sdk.mediation.j.b;
import com.adincube.sdk.mediation.j.d;
import com.adincube.sdk.mediation.j.f;
import com.adincube.sdk.mediation.j.h;
import com.adincube.sdk.util.s;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import org.json.JSONObject;

public final class e
implements i {
    private f a = null;
    private g b = null;

    public e() {
        PublisherAdRequest.class.getSimpleName();
    }

    @Override
    public final a a(Context context, com.adincube.sdk.h.c.c c2, boolean bl) {
        return new b(this, context, c2, bl);
    }

    @Override
    public final com.adincube.sdk.mediation.n.a a(Activity activity) {
        d d2 = new d(this);
        d2.a = activity;
        return d2;
    }

    @Override
    public final void a(Context context) {
        com.adincube.sdk.mediation.c.c c2 = new com.adincube.sdk.mediation.c.c(context).a(this.a.m);
        c2.a = this.a.n;
        c2.a();
    }

    @Override
    public final void a(Context context, JSONObject jSONObject) {
        this.a = new f(jSONObject);
    }

    @Override
    public final void a(g g2) {
        this.b = g2;
    }

    @Override
    public final boolean a() {
        return this.a != null;
    }

    @Override
    public final c b() {
        return null;
    }

    @Override
    public final String b(Context context) {
        return s.a(context);
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
        return "DoubleClick";
    }

    @Override
    public final com.adincube.sdk.mediation.aa.c g() {
        return null;
    }

    public final h h() {
        h h2 = new h(this.a);
        h2.a = this.b;
        return h2;
    }
}

