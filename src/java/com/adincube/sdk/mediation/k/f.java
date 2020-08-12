/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  com.adincube.sdk.h.c.c
 *  com.adincube.sdk.h.g
 *  com.adincube.sdk.mediation.k.b
 *  com.adincube.sdk.mediation.k.e
 *  com.adincube.sdk.mediation.n.a
 *  com.facebook.ads.AdSettings
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  org.json.JSONObject
 */
package com.adincube.sdk.mediation.k;

import android.app.Activity;
import android.content.Context;
import com.adincube.sdk.h.g;
import com.adincube.sdk.mediation.c;
import com.adincube.sdk.mediation.e;
import com.adincube.sdk.mediation.i;
import com.adincube.sdk.mediation.i.a;
import com.adincube.sdk.mediation.k.b;
import com.adincube.sdk.mediation.k.f;
import com.adincube.sdk.mediation.k.h;
import com.facebook.ads.AdSettings;
import org.json.JSONObject;

public final class f
implements i {
    Context a;
    h b = null;
    private c c;

    public f() {
        AdSettings.class.getSimpleName();
    }

    @Override
    public final a a(Context context, com.adincube.sdk.h.c.c c2, boolean bl) {
        return new b(this, context, c2, bl);
    }

    @Override
    public final com.adincube.sdk.mediation.n.a a(Activity activity) {
        com.adincube.sdk.mediation.k.e e2 = new com.adincube.sdk.mediation.k.e(this);
        e2.a = activity;
        return e2;
    }

    @Override
    public final void a(Context context) {
    }

    @Override
    public final void a(Context context, JSONObject jSONObject) {
        this.b = new h(jSONObject);
        this.a = context.getApplicationContext();
        this.c = new c(new Runnable(this){
            final /* synthetic */ f a;
            {
                this.a = f2;
            }

            public final void run() {
                if (!com.facebook.ads.AudienceNetworkAds.isInAdsProcess((Context)this.a.a)) {
                    com.facebook.ads.AudienceNetworkAds.initialize((Context)this.a.a);
                }
                AdSettings.setMediationService((String)"AdinCube");
                AdSettings.setIsChildDirected((boolean)this.a.b.k);
                AdSettings.setVideoAutoplay((boolean)this.a.b.l);
            }
        });
    }

    @Override
    public final void a(g g2) {
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
        return "5.1.0";
    }

    @Override
    public final e c() {
        return this.b;
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
        return "Facebook";
    }

    @Override
    public final com.adincube.sdk.mediation.aa.c g() {
        return null;
    }
}

