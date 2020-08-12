/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  com.adincube.sdk.h.c.c
 *  com.adincube.sdk.h.g
 *  com.adincube.sdk.mediation.n.a
 *  com.adincube.sdk.mediation.q.a
 *  com.mobvista.msdk.MobVistaSDK
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  org.json.JSONObject
 */
package com.adincube.sdk.mediation.q;

import android.app.Activity;
import android.content.Context;
import com.adincube.sdk.mediation.c;
import com.adincube.sdk.mediation.e;
import com.adincube.sdk.mediation.i;
import com.adincube.sdk.mediation.q.a;
import com.adincube.sdk.mediation.q.b;
import com.adincube.sdk.mediation.q.d;
import com.adincube.sdk.mediation.q.g;
import com.mobvista.msdk.MobVistaSDK;
import org.json.JSONObject;

public final class b
implements i {
    d a = null;
    MobVistaSDK b;
    private c c;
    private g d = new g(this);

    public b() {
        MobVistaSDK.class.getSimpleName();
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
        c c2 = this.c;
        if (c2 != null) {
            c2.a();
        }
    }

    @Override
    public final void a(Context context, JSONObject jSONObject) {
        this.a = new d(jSONObject);
        this.c = new c(new Runnable(this, context){
            final /* synthetic */ Context a;
            final /* synthetic */ b b;
            {
                this.b = b2;
                this.a = context;
            }

            public final void run() {
                this.b.b = com.mobvista.msdk.out.MobVistaSDKFactory.getMobVistaSDK();
                java.util.Map map = this.b.b.getMVConfigurationMap(this.b.a.k, this.b.a.l);
                this.b.b.init(map, this.a);
            }
        });
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
        return this.c;
    }

    @Override
    public final String b(Context context) {
        return "8.11.2";
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
        return "Mobvista";
    }

    @Override
    public final com.adincube.sdk.mediation.aa.c g() {
        return this.d;
    }
}

