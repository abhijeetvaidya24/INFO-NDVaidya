/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  com.adincube.sdk.h.c.c
 *  com.adincube.sdk.h.g
 *  com.adincube.sdk.mediation.m.b
 *  com.adincube.sdk.mediation.m.c
 *  com.adincube.sdk.mediation.n.a
 *  com.inmobi.sdk.InMobiSdk
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONObject
 */
package com.adincube.sdk.mediation.m;

import android.app.Activity;
import android.content.Context;
import com.adincube.sdk.h.g;
import com.adincube.sdk.mediation.c;
import com.adincube.sdk.mediation.e;
import com.adincube.sdk.mediation.i;
import com.adincube.sdk.mediation.i.a;
import com.adincube.sdk.mediation.m.b;
import com.inmobi.sdk.InMobiSdk;
import org.json.JSONObject;

public final class d
implements i {
    private com.adincube.sdk.mediation.m.e a = null;

    public d() {
        InMobiSdk.class.getSimpleName();
    }

    @Override
    public final a a(Context context, com.adincube.sdk.h.c.c c2, boolean bl) {
        return new b(this, context, c2, bl);
    }

    @Override
    public final com.adincube.sdk.mediation.n.a a(Activity activity) {
        com.adincube.sdk.mediation.m.c c2 = new com.adincube.sdk.mediation.m.c(this);
        c2.a = activity;
        return c2;
    }

    @Override
    public final void a(Context context) {
        InMobiSdk.init((Context)context, (String)this.a.k);
    }

    @Override
    public final void a(Context context, JSONObject jSONObject) {
        this.a = new com.adincube.sdk.mediation.m.e(jSONObject);
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
    public final c b() {
        return null;
    }

    @Override
    public final String b(Context context) {
        return InMobiSdk.getVersion();
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
        return "InMobi";
    }

    @Override
    public final com.adincube.sdk.mediation.aa.c g() {
        return null;
    }
}

