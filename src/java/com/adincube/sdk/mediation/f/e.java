/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  com.adincube.sdk.h.c.c
 *  com.adincube.sdk.h.g
 *  com.adincube.sdk.mediation.f.b
 *  com.adincube.sdk.mediation.f.d
 *  com.adincube.sdk.mediation.n.a
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  org.json.JSONObject
 */
package com.adincube.sdk.mediation.f;

import android.app.Activity;
import android.content.Context;
import com.adincube.sdk.mediation.c;
import com.adincube.sdk.mediation.f.b;
import com.adincube.sdk.mediation.f.d;
import com.adincube.sdk.mediation.f.e;
import com.adincube.sdk.mediation.f.g;
import com.adincube.sdk.mediation.f.j;
import com.adincube.sdk.mediation.i;
import com.adincube.sdk.mediation.i.a;
import com.applovin.sdk.AppLovinSdk;
import org.json.JSONObject;

public final class e
implements i {
    g a;
    AppLovinSdk b = null;
    private c c;
    private j d = new j();

    public e() {
        AppLovinSdk.class.getSimpleName();
    }

    @Override
    public final a a(Context context, com.adincube.sdk.h.c.c c2, boolean bl) {
        return new b(this, context, c2, bl);
    }

    @Override
    public final com.adincube.sdk.mediation.n.a a(Activity activity) {
        d d2 = new d(this);
        d2.a = activity;
        return d2;
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
        this.a = new g(jSONObject);
        this.c = new c(new Runnable(this, context){
            final /* synthetic */ Context a;
            final /* synthetic */ e b;
            {
                this.b = e2;
                this.a = context;
            }

            public final void run() {
                e e2 = this.b;
                String string = e2.a.k;
                com.applovin.sdk.AppLovinSdkSettings appLovinSdkSettings = new com.applovin.sdk.AppLovinSdkSettings();
                appLovinSdkSettings.setAutoPreloadTypes("NONE");
                appLovinSdkSettings.setAutoPreloadSizes("NONE");
                e2.b = AppLovinSdk.getInstance(string, appLovinSdkSettings, this.a);
            }
        });
    }

    @Override
    public final void a(com.adincube.sdk.h.g g2) {
    }

    @Override
    public final boolean a() {
        return this.b != null;
    }

    @Override
    public final c b() {
        return this.c;
    }

    @Override
    public final String b(Context context) {
        return "9.2.1";
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
        return "AppLovin";
    }

    @Override
    public final com.adincube.sdk.mediation.aa.c g() {
        return this.d;
    }
}

