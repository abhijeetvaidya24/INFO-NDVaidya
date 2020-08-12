/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  com.adincube.sdk.h.c.c
 *  com.adincube.sdk.h.g
 *  com.adincube.sdk.mediation.n.a
 *  java.lang.Object
 *  java.lang.String
 *  net.pubnative.library.request.PubnativeRequest
 *  org.json.JSONObject
 */
package com.adincube.sdk.mediation.u;

import android.app.Activity;
import android.content.Context;
import com.adincube.sdk.h.g;
import com.adincube.sdk.mediation.c;
import com.adincube.sdk.mediation.e;
import com.adincube.sdk.mediation.i;
import com.adincube.sdk.mediation.i.a;
import com.adincube.sdk.mediation.u.d;
import net.pubnative.library.request.PubnativeRequest;
import org.json.JSONObject;

public final class b
implements i {
    d a = null;

    public b() {
        PubnativeRequest.class.getSimpleName();
    }

    @Override
    public final a a(Context context, com.adincube.sdk.h.c.c c2, boolean bl) {
        return null;
    }

    @Override
    public final com.adincube.sdk.mediation.n.a a(Activity activity) {
        return null;
    }

    @Override
    public final void a(Context context) {
    }

    @Override
    public final void a(Context context, JSONObject jSONObject) {
        this.a = new d(jSONObject);
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
        return "2.3.14";
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
        return "PubNative";
    }

    @Override
    public final com.adincube.sdk.mediation.aa.c g() {
        return null;
    }
}

