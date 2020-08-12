/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  com.adincube.sdk.h.c.c
 *  com.adincube.sdk.h.g
 *  com.adincube.sdk.mediation.n.a
 *  com.adincube.sdk.mediation.z.c
 *  com.adincube.sdk.mediation.z.d
 *  com.unity3d.ads.UnityAds
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONObject
 */
package com.adincube.sdk.mediation.z;

import android.app.Activity;
import android.content.Context;
import com.adincube.sdk.h.g;
import com.adincube.sdk.mediation.i.a;
import com.adincube.sdk.mediation.z.c;
import com.adincube.sdk.mediation.z.d;
import com.adincube.sdk.mediation.z.f;
import com.adincube.sdk.mediation.z.i;
import com.unity3d.ads.UnityAds;
import org.json.JSONObject;

public final class e
implements com.adincube.sdk.mediation.i {
    f a = null;
    d b = new d();
    private i c = new i();

    public e() {
        UnityAds.class.getSimpleName();
    }

    @Override
    public final a a(Context context, com.adincube.sdk.h.c.c c2, boolean bl) {
        return null;
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
        this.a = new f(jSONObject);
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
        return UnityAds.getVersion();
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
        return false;
    }

    @Override
    public final String f() {
        return "UnityAds";
    }

    @Override
    public final com.adincube.sdk.mediation.aa.c g() {
        return this.c;
    }
}

