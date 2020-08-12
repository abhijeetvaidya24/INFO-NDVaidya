/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  com.adincube.sdk.h.c.c
 *  com.adincube.sdk.h.g
 *  com.adincube.sdk.mediation.a.a
 *  com.adincube.sdk.mediation.n.a
 *  com.purplebrain.adbuddiz.sdk.AdBuddiz
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONObject
 */
package com.adincube.sdk.mediation.a;

import android.app.Activity;
import android.content.Context;
import com.adincube.sdk.h.g;
import com.adincube.sdk.mediation.a.a;
import com.adincube.sdk.mediation.aa.c;
import com.adincube.sdk.mediation.e;
import com.adincube.sdk.mediation.i;
import com.purplebrain.adbuddiz.sdk.AdBuddiz;
import org.json.JSONObject;

public final class b
implements i {
    private com.adincube.sdk.mediation.a.c a = null;

    public b() {
        AdBuddiz.class.getSimpleName();
    }

    @Override
    public final com.adincube.sdk.mediation.i.a a(Context context, com.adincube.sdk.h.c.c c2, boolean bl) {
        return null;
    }

    @Override
    public final com.adincube.sdk.mediation.n.a a(Activity activity) {
        a a2 = new a(this);
        a2.a = activity;
        return a2;
    }

    @Override
    public final void a(Context context) {
        AdBuddiz.setPublisherKey((String)this.a.k);
    }

    @Override
    public final void a(Context context, JSONObject jSONObject) {
        this.a = new com.adincube.sdk.mediation.a.c(jSONObject);
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
        return AdBuddiz.getVersion();
    }

    @Override
    public final e c() {
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
        return "AdBuddiz";
    }

    @Override
    public final c g() {
        return null;
    }
}

