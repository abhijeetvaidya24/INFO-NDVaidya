/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  com.adincube.sdk.h.c.c
 *  com.adincube.sdk.h.g
 *  com.adincube.sdk.mediation.n.a
 *  com.adincube.sdk.mediation.x.a
 *  com.adincube.sdk.mediation.x.b
 *  com.startapp.android.publish.adsCommon.StartAppSDK
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  org.json.JSONObject
 */
package com.adincube.sdk.mediation.x;

import android.app.Activity;
import android.content.Context;
import com.adincube.sdk.h.g;
import com.adincube.sdk.mediation.i;
import com.adincube.sdk.mediation.x.a;
import com.adincube.sdk.mediation.x.b;
import com.adincube.sdk.mediation.x.c;
import com.adincube.sdk.mediation.x.e;
import com.adincube.sdk.mediation.x.f;
import com.startapp.android.publish.adsCommon.StartAppSDK;
import org.json.JSONObject;

public final class c
implements i {
    e a = null;
    private com.adincube.sdk.mediation.c b;
    private f c = new f();

    public c() {
        StartAppSDK.class.getSimpleName();
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
        com.adincube.sdk.mediation.c c2 = this.b;
        if (c2 != null) {
            c2.a();
        }
    }

    @Override
    public final void a(Context context, JSONObject jSONObject) {
        this.a = new e(jSONObject);
        this.b = new com.adincube.sdk.mediation.c(new Runnable(this, context){
            final /* synthetic */ Context a;
            final /* synthetic */ c b;
            {
                this.b = c2;
                this.a = context;
            }

            public final void run() {
                StartAppSDK.init((Context)this.a, (String)this.b.a.k, (boolean)false);
                com.startapp.android.publish.adsCommon.StartAppAd.disableSplash();
                com.startapp.android.publish.adsCommon.StartAppAd.disableAutoInterstitial();
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
    public final com.adincube.sdk.mediation.c b() {
        return this.b;
    }

    @Override
    public final String b(Context context) {
        return "3.9.0";
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
        return "StartApp";
    }

    @Override
    public final com.adincube.sdk.mediation.aa.c g() {
        return this.c;
    }
}

