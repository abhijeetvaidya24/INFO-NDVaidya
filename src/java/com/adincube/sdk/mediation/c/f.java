/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  com.adincube.sdk.h.c.c
 *  com.adincube.sdk.h.f.d
 *  com.adincube.sdk.h.g
 *  com.adincube.sdk.mediation.c.b
 *  com.adincube.sdk.mediation.c.e
 *  com.adincube.sdk.mediation.n.a
 *  com.google.android.gms.ads.InterstitialAd
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  org.json.JSONObject
 */
package com.adincube.sdk.mediation.c;

import android.app.Activity;
import android.content.Context;
import com.adincube.sdk.h.f.d;
import com.adincube.sdk.h.g;
import com.adincube.sdk.mediation.c;
import com.adincube.sdk.mediation.c.b;
import com.adincube.sdk.mediation.c.e;
import com.adincube.sdk.mediation.c.f;
import com.adincube.sdk.mediation.c.i;
import com.adincube.sdk.mediation.c.k;
import com.adincube.sdk.mediation.c.m;
import com.adincube.sdk.mediation.i.a;
import com.adincube.sdk.util.s;
import com.google.android.gms.ads.InterstitialAd;
import org.json.JSONObject;

public final class f
implements com.adincube.sdk.mediation.i {
    i a = null;
    m b = new m();
    private c c;
    private g d = null;
    private com.adincube.sdk.mediation.aa.b e = new com.adincube.sdk.mediation.aa.b("google-llc");

    public f() {
        InterstitialAd.class.getSimpleName();
    }

    @Override
    public final a a(Context context, com.adincube.sdk.h.c.c c2, boolean bl) {
        return new b(this, context, c2, bl);
    }

    @Override
    public final com.adincube.sdk.mediation.n.a a(Activity activity) {
        e e2 = new e(this);
        e2.a = activity;
        return e2;
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
        this.a = new i(jSONObject);
        this.c = new c(new Runnable(this, context){
            final /* synthetic */ Context a;
            final /* synthetic */ f b;
            {
                this.b = f2;
                this.a = context;
            }

            public final void run() {
                com.adincube.sdk.mediation.c.c c2 = new com.adincube.sdk.mediation.c.c(this.a).a(this.b.a.k).a(this.b.a.o);
                c2.a = this.b.a.p;
                c2.a();
            }
        });
    }

    @Override
    public final void a(g g2) {
        this.d = g2;
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
        return s.a(context);
    }

    @Override
    public final com.adincube.sdk.mediation.e c() {
        return this.a;
    }

    @Override
    public final boolean d() {
        return true;
    }

    @Override
    public final boolean e() {
        return true;
    }

    @Override
    public final String f() {
        return "AdMob";
    }

    @Override
    public final com.adincube.sdk.mediation.aa.c g() {
        return this.e;
    }

    /*
     * Enabled aggressive block sorting
     */
    public final k h() {
        boolean bl;
        k k2 = new k(this.a);
        k2.a = this.d;
        d d2 = this.e.a;
        if (d2 == d.c) {
            bl = false;
        } else {
            if (d2 != d.d && d2 != d.a) {
                return k2;
            }
            bl = true;
        }
        k2.a(bl);
        return k2;
    }
}

