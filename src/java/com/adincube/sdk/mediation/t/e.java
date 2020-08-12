/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  com.adincube.sdk.h.c.c
 *  com.adincube.sdk.h.g
 *  com.adincube.sdk.mediation.n.a
 *  com.adincube.sdk.mediation.t.d
 *  io.presage.common.PresageSdk
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  org.json.JSONObject
 */
package com.adincube.sdk.mediation.t;

import android.app.Activity;
import android.content.Context;
import com.adincube.sdk.h.g;
import com.adincube.sdk.mediation.c;
import com.adincube.sdk.mediation.i;
import com.adincube.sdk.mediation.t.a;
import com.adincube.sdk.mediation.t.b;
import com.adincube.sdk.mediation.t.d;
import com.adincube.sdk.mediation.t.e;
import com.adincube.sdk.mediation.t.f;
import io.presage.common.PresageSdk;
import org.json.JSONObject;

public final class e
implements i {
    private f a = null;
    private c b;
    private b c = new b();
    private a d = new a();

    public e() {
        PresageSdk.class.getSimpleName();
    }

    @Override
    public final com.adincube.sdk.mediation.i.a a(Context context, com.adincube.sdk.h.c.c c2, boolean bl) {
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
        c c2 = this.b;
        if (c2 != null) {
            c2.a();
        }
    }

    @Override
    public final void a(Context context, JSONObject jSONObject) {
        this.a = new f(jSONObject);
        this.b = new c(new Runnable(this, context){
            final /* synthetic */ Context a;
            final /* synthetic */ e b;
            {
                this.b = e2;
                this.a = context;
            }

            public final void run() {
                if (b.a()) {
                    io.presage.Presage.getInstance().start(com.adincube.sdk.util.d.b(), this.a);
                    return;
                }
                if (a.a()) {
                    PresageSdk.init((Context)this.a.getApplicationContext(), (String)com.adincube.sdk.util.d.b());
                }
            }
        });
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
        return this.b;
    }

    @Override
    public final String b(Context context) {
        return PresageSdk.getAdsSdkVersion();
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
        return "Ogury";
    }

    @Override
    public final com.adincube.sdk.mediation.aa.c g() {
        return null;
    }
}

