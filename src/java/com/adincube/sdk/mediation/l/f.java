/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  com.adincube.sdk.h.b
 *  com.adincube.sdk.h.c.c
 *  com.adincube.sdk.h.g
 *  com.adincube.sdk.mediation.l.a
 *  com.adincube.sdk.mediation.l.d
 *  com.adincube.sdk.mediation.n.a
 *  com.flurry.android.FlurryAgent
 *  com.flurry.android.FlurryAgentListener
 *  com.flurry.android.ads.FlurryAdInterstitialListener
 *  com.flurry.android.ads.FlurryGender
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  org.json.JSONObject
 */
package com.adincube.sdk.mediation.l;

import android.app.Activity;
import android.content.Context;
import com.adincube.sdk.h.b;
import com.adincube.sdk.h.g;
import com.adincube.sdk.mediation.c;
import com.adincube.sdk.mediation.e;
import com.adincube.sdk.mediation.i;
import com.adincube.sdk.mediation.l.a;
import com.adincube.sdk.mediation.l.d;
import com.adincube.sdk.mediation.l.f;
import com.adincube.sdk.mediation.l.h;
import com.adincube.sdk.mediation.l.k;
import com.adincube.sdk.mediation.l.l;
import com.flurry.android.FlurryAgent;
import com.flurry.android.FlurryAgentListener;
import com.flurry.android.ads.FlurryAdInterstitialListener;
import com.flurry.android.ads.FlurryGender;
import org.json.JSONObject;

public final class f
implements i {
    h a = null;
    l b = new l(this);
    k c = new k();
    final FlurryAgentListener d = new FlurryAgentListener(this){
        final /* synthetic */ f a;
        {
            this.a = f2;
        }
    };
    private g e = null;
    private c f;

    public f() {
        FlurryAgent.class.getSimpleName();
        FlurryAdInterstitialListener.class.getSimpleName();
    }

    @Override
    public final com.adincube.sdk.mediation.i.a a(Context context, com.adincube.sdk.h.c.c c2, boolean bl) {
        return new a(this, context, c2, bl);
    }

    @Override
    public final com.adincube.sdk.mediation.n.a a(Activity activity) {
        d d2 = new d(this);
        d2.a = activity;
        return d2;
    }

    @Override
    public final void a(Context context) {
    }

    @Override
    public final void a(Context context, JSONObject jSONObject) {
        this.a = new h(jSONObject);
        this.f = new c(new Runnable(this, context){
            final /* synthetic */ Context a;
            final /* synthetic */ f b;
            {
                this.b = f2;
                this.a = context;
            }

            public final void run() {
                new com.flurry.android.FlurryAgent$Builder().withConsent((com.flurry.android.Consent)this.b.b.a).withLogEnabled(true).withListener(this.b.d).withCaptureUncaughtExceptions(false).build(this.a, this.b.a.k);
            }
        });
    }

    @Override
    public final void a(g g2) {
        this.e = g2;
        if (g2.d != null) {
            FlurryAgent.setAge((int)g2.d);
        }
        if (g2.a != null) {
            int n2 = 3.a[g2.a.ordinal()];
            if (n2 != 1) {
                if (n2 != 2) {
                    return;
                }
                FlurryAgent.setGender((byte)((byte)FlurryGender.FEMALE.getCode()));
                return;
            }
            FlurryAgent.setGender((byte)((byte)FlurryGender.MALE.getCode()));
        }
    }

    @Override
    public final boolean a() {
        return this.a != null;
    }

    @Override
    public final c b() {
        return this.f;
    }

    @Override
    public final String b(Context context) {
        return FlurryAgent.getReleaseVersion();
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
        return "Flurry";
    }

    @Override
    public final com.adincube.sdk.mediation.aa.c g() {
        return this.b;
    }
}

