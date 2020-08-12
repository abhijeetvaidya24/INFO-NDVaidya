/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  com.adincube.sdk.h.c.c
 *  com.adincube.sdk.h.g
 *  com.adincube.sdk.mediation.ac.c
 *  com.adincube.sdk.mediation.n.a
 *  com.vungle.warren.Vungle
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONObject
 */
package com.adincube.sdk.mediation.ac;

import android.app.Activity;
import android.content.Context;
import com.adincube.sdk.h.g;
import com.adincube.sdk.mediation.ac.c;
import com.adincube.sdk.mediation.ac.d;
import com.adincube.sdk.mediation.ac.f;
import com.adincube.sdk.mediation.ac.i;
import com.adincube.sdk.mediation.i.a;
import com.vungle.warren.Vungle;
import org.json.JSONObject;

public final class e
implements com.adincube.sdk.mediation.i {
    d a = null;
    f b = null;
    private i c = new i(this);

    public e() {
        Vungle.class.getSimpleName();
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
        this.b = new f(jSONObject);
        this.a = new d(context.getApplicationContext(), this.b);
    }

    @Override
    public final void a(g g2) {
    }

    @Override
    public final boolean a() {
        return this.b != null;
    }

    @Override
    public final com.adincube.sdk.mediation.c b() {
        return null;
    }

    @Override
    public final String b(Context context) {
        return "6.3.24";
    }

    @Override
    public final com.adincube.sdk.mediation.e c() {
        return this.b;
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
        return "Vungle";
    }

    @Override
    public final com.adincube.sdk.mediation.aa.c g() {
        return this.c;
    }
}

