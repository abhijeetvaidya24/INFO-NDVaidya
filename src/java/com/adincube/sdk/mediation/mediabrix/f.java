/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  com.adincube.sdk.h.c.c
 *  com.adincube.sdk.h.g
 *  com.adincube.sdk.mediation.mediabrix.e
 *  com.adincube.sdk.mediation.mediabrix.g
 *  com.adincube.sdk.mediation.n.a
 *  com.mediabrix.android.api.MediabrixAPI
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONObject
 */
package com.adincube.sdk.mediation.mediabrix;

import android.app.Activity;
import android.content.Context;
import com.adincube.sdk.mediation.c;
import com.adincube.sdk.mediation.e;
import com.adincube.sdk.mediation.i;
import com.adincube.sdk.mediation.i.a;
import com.adincube.sdk.mediation.mediabrix.b;
import com.adincube.sdk.mediation.mediabrix.g;
import com.mediabrix.android.api.MediabrixAPI;
import org.json.JSONObject;

public final class f
implements i {
    private g a = null;
    private com.adincube.sdk.mediation.mediabrix.c b = null;

    public f() {
        MediabrixAPI.class.getSimpleName();
    }

    @Override
    public final a a(Context context, com.adincube.sdk.h.c.c c2, boolean bl) {
        return null;
    }

    @Override
    public final com.adincube.sdk.mediation.n.a a(Activity activity) {
        com.adincube.sdk.mediation.mediabrix.e e2 = new com.adincube.sdk.mediation.mediabrix.e(this);
        e2.a = activity;
        b.a().a = e2;
        return e2;
    }

    @Override
    public final void a(Context context) {
        this.h().a(context, this.a.k);
    }

    @Override
    public final void a(Context context, JSONObject jSONObject) {
        this.a = new g(jSONObject);
        this.a(context);
    }

    @Override
    public final void a(com.adincube.sdk.h.g g2) {
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
        return "1.8.0.022";
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
        return "MediaBrix";
    }

    @Override
    public final com.adincube.sdk.mediation.aa.c g() {
        return null;
    }

    public final com.adincube.sdk.mediation.mediabrix.c h() {
        if (this.b == null) {
            this.b = new com.adincube.sdk.mediation.mediabrix.c(b.a());
        }
        return this.b;
    }
}

