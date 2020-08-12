/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  com.adincube.sdk.h.c.c
 *  com.adincube.sdk.h.g
 *  com.adincube.sdk.mediation.d.a
 *  com.adincube.sdk.mediation.d.e
 *  com.adincube.sdk.mediation.n.a
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  org.json.JSONObject
 */
package com.adincube.sdk.mediation.d;

import android.app.Activity;
import android.content.Context;
import com.adincube.sdk.mediation.c;
import com.adincube.sdk.mediation.d.a;
import com.adincube.sdk.mediation.d.e;
import com.adincube.sdk.mediation.d.f;
import com.adincube.sdk.mediation.d.g;
import com.adincube.sdk.mediation.d.j;
import com.adincube.sdk.mediation.i;
import com.aerserv.sdk.AerServSdk;
import org.json.JSONObject;

public final class f
implements i {
    g a = null;
    boolean b = false;
    private c c;
    private j d = new j();

    public f() {
        AerServSdk.class.getSimpleName();
    }

    @Override
    public final com.adincube.sdk.mediation.i.a a(Context context, com.adincube.sdk.h.c.c c2, boolean bl) {
        return new a(this, context, c2, bl);
    }

    @Override
    public final com.adincube.sdk.mediation.n.a a(Activity activity) {
        e e2 = new e(this);
        e2.a(activity);
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
        this.a = new g(jSONObject);
        this.c = new c(new Runnable(this, context){
            final /* synthetic */ Context a;
            final /* synthetic */ f b;
            {
                this.b = f2;
                this.a = context;
            }

            public final void run() {
                Context context = this.a;
                if (context instanceof Activity) {
                    f f2 = this.b;
                    f2.b = true;
                    AerServSdk.init((Activity)context, f2.a.k);
                }
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
        return "3.1.1";
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
        return "AerServ";
    }

    @Override
    public final com.adincube.sdk.mediation.aa.c g() {
        return this.d;
    }
}

