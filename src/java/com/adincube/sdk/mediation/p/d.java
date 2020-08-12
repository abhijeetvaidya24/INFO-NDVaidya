/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  com.adincube.sdk.h.c.c
 *  com.adincube.sdk.h.g
 *  com.adincube.sdk.mediation.n.a
 *  com.adincube.sdk.mediation.p.a
 *  com.adincube.sdk.mediation.p.b
 *  com.my.target.SDKVersion
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONObject
 */
package com.adincube.sdk.mediation.p;

import android.app.Activity;
import android.content.Context;
import com.adincube.sdk.h.g;
import com.adincube.sdk.mediation.c;
import com.adincube.sdk.mediation.e;
import com.adincube.sdk.mediation.i;
import com.adincube.sdk.mediation.p.a;
import com.adincube.sdk.mediation.p.b;
import com.adincube.sdk.mediation.p.f;
import com.my.target.SDKVersion;
import org.json.JSONObject;

public final class d
implements i {
    private f a = null;

    public d() {
        SDKVersion.class.getSimpleName();
    }

    @Override
    public final com.adincube.sdk.mediation.i.a a(Context context, com.adincube.sdk.h.c.c c2, boolean bl) {
        return new a(this, context, c2, bl);
    }

    @Override
    public final com.adincube.sdk.mediation.n.a a(Activity activity) {
        b b2 = new b(this);
        b2.a = activity;
        return b2;
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
    public final c b() {
        return null;
    }

    @Override
    public final String b(Context context) {
        return "4.5.10";
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
        return "MailRu";
    }

    @Override
    public final com.adincube.sdk.mediation.aa.c g() {
        return null;
    }
}

