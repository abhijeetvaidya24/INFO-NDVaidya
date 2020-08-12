/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  com.adincube.sdk.h.c.c
 *  com.adincube.sdk.h.g
 *  com.adincube.sdk.mediation.n.a
 *  com.adincube.sdk.mediation.y.c
 *  com.tapjoy.Tapjoy
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONObject
 */
package com.adincube.sdk.mediation.y;

import android.app.Activity;
import android.content.Context;
import com.adincube.sdk.h.g;
import com.adincube.sdk.mediation.c;
import com.adincube.sdk.mediation.y.a;
import com.adincube.sdk.mediation.y.e;
import com.adincube.sdk.mediation.y.i;
import com.tapjoy.Tapjoy;
import org.json.JSONObject;

public final class d
implements com.adincube.sdk.mediation.i {
    e a = null;
    a b = new a();
    private i c = new i();

    public d() {
        Tapjoy.class.getSimpleName();
    }

    @Override
    public final com.adincube.sdk.mediation.i.a a(Context context, com.adincube.sdk.h.c.c c2, boolean bl) {
        return null;
    }

    @Override
    public final com.adincube.sdk.mediation.n.a a(Activity activity) {
        com.adincube.sdk.mediation.y.c c2 = new com.adincube.sdk.mediation.y.c(this);
        c2.a = activity;
        return c2;
    }

    @Override
    public final void a(Context context) {
        if (context instanceof Activity) {
            Tapjoy.setActivity((Activity)((Activity)context));
        }
    }

    @Override
    public final void a(Context context, JSONObject jSONObject) {
        this.a = new e(jSONObject);
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
        return Tapjoy.getVersion();
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
        return "Tapjoy";
    }

    @Override
    public final com.adincube.sdk.mediation.aa.c g() {
        return this.c;
    }
}

