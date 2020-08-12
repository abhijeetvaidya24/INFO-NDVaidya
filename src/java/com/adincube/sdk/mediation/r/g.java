/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  com.adincube.sdk.h.c.c
 *  com.adincube.sdk.h.g
 *  com.adincube.sdk.mediation.n.a
 *  com.adincube.sdk.mediation.r.b
 *  com.adincube.sdk.mediation.r.d
 *  com.mopub.common.MoPub
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONObject
 */
package com.adincube.sdk.mediation.r;

import android.app.Activity;
import android.content.Context;
import com.adincube.sdk.mediation.c;
import com.adincube.sdk.mediation.i.a;
import com.adincube.sdk.mediation.r.b;
import com.adincube.sdk.mediation.r.d;
import com.adincube.sdk.mediation.r.e;
import com.adincube.sdk.mediation.r.f;
import com.adincube.sdk.mediation.r.i;
import com.adincube.sdk.mediation.r.m;
import com.mopub.common.MoPub;
import org.json.JSONObject;

public final class g
implements com.adincube.sdk.mediation.i {
    f a = null;
    private i b = null;
    private e c = new e();
    private m d = new m();

    public g() {
        MoPub.class.getSimpleName();
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
    }

    @Override
    public final void a(Context context, JSONObject jSONObject) {
        this.b = new i(jSONObject);
        this.a = new f(this.b, this.c);
    }

    @Override
    public final void a(com.adincube.sdk.h.g g2) {
        this.c.a = g2;
    }

    @Override
    public final boolean a() {
        return this.b != null;
    }

    @Override
    public final c b() {
        return null;
    }

    @Override
    public final String b(Context context) {
        return "5.5.0";
    }

    @Override
    public final com.adincube.sdk.mediation.e c() {
        return this.b;
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
        return "MoPub";
    }

    @Override
    public final com.adincube.sdk.mediation.aa.c g() {
        return this.d;
    }
}

