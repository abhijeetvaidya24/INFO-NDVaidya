/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  com.adincube.sdk.g.a
 *  com.adincube.sdk.h.b.b
 *  com.adincube.sdk.h.c.c
 *  com.adincube.sdk.h.g
 *  com.adincube.sdk.mediation.n.a
 *  com.adincube.sdk.mediation.w.a
 *  com.adincube.sdk.mediation.w.c
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONObject
 */
package com.adincube.sdk.mediation.w;

import android.app.Activity;
import android.content.Context;
import com.adincube.sdk.h.b.b;
import com.adincube.sdk.h.g;
import com.adincube.sdk.mediation.e;
import com.adincube.sdk.mediation.i;
import com.adincube.sdk.mediation.w.a;
import com.adincube.sdk.mediation.w.c;
import com.adincube.sdk.mediation.w.f;
import org.json.JSONObject;

public final class d
implements i {
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
    }

    @Override
    public final void a(g g2) {
    }

    @Override
    public final boolean a() {
        return true;
    }

    @Override
    public final com.adincube.sdk.mediation.c b() {
        return null;
    }

    @Override
    public final String b(Context context) {
        return "2.7.5";
    }

    @Override
    public final e c() {
        return com.adincube.sdk.g.a.a().a((boolean)true, (boolean)true).S;
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
        return "RTB";
    }

    @Override
    public final com.adincube.sdk.mediation.aa.c g() {
        return null;
    }
}

