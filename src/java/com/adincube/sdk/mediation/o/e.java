/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  com.adincube.sdk.h.c.c
 *  com.adincube.sdk.h.g
 *  com.adincube.sdk.mediation.n.a
 *  com.adincube.sdk.mediation.o.d
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONObject
 */
package com.adincube.sdk.mediation.o;

import android.app.Activity;
import android.content.Context;
import com.adincube.sdk.h.g;
import com.adincube.sdk.mediation.c;
import com.adincube.sdk.mediation.i;
import com.adincube.sdk.mediation.i.a;
import com.adincube.sdk.mediation.o.b;
import com.adincube.sdk.mediation.o.d;
import com.adincube.sdk.mediation.o.f;
import com.adincube.sdk.mediation.o.h;
import com.adincube.sdk.mediation.o.j;
import com.ironsource.mediationsdk.IronSource;
import org.json.JSONObject;

public final class e
implements i {
    b a = null;
    h b = new h();
    private f c = null;
    private j d = new j();

    public e() {
        IronSource.class.getSimpleName();
    }

    @Override
    public final a a(Context context, com.adincube.sdk.h.c.c c2, boolean bl) {
        return null;
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
        this.c = new f(jSONObject);
        this.a = new b(this.c, this.b);
    }

    @Override
    public final void a(g g2) {
    }

    @Override
    public final boolean a() {
        return this.c != null;
    }

    @Override
    public final c b() {
        return null;
    }

    @Override
    public final String b(Context context) {
        return "6.7.10";
    }

    @Override
    public final com.adincube.sdk.mediation.e c() {
        return this.c;
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
        return "IronSource";
    }

    @Override
    public final com.adincube.sdk.mediation.aa.c g() {
        return this.d;
    }
}

