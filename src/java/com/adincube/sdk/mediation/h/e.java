/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  com.adincube.sdk.h.b
 *  com.adincube.sdk.h.c.c
 *  com.adincube.sdk.h.g
 *  com.adincube.sdk.mediation.h.a
 *  com.adincube.sdk.mediation.h.d
 *  com.adincube.sdk.mediation.n.a
 *  com.avocarrot.sdk.Avocarrot
 *  com.avocarrot.sdk.mediation.Gender
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Date
 *  org.json.JSONObject
 */
package com.adincube.sdk.mediation.h;

import android.app.Activity;
import android.content.Context;
import com.adincube.sdk.h.b;
import com.adincube.sdk.mediation.c;
import com.adincube.sdk.mediation.h.a;
import com.adincube.sdk.mediation.h.d;
import com.adincube.sdk.mediation.h.e;
import com.adincube.sdk.mediation.h.g;
import com.adincube.sdk.mediation.h.j;
import com.adincube.sdk.mediation.i;
import com.avocarrot.sdk.Avocarrot;
import com.avocarrot.sdk.mediation.Gender;
import java.util.Date;
import org.json.JSONObject;

public final class e
implements i {
    private g a = null;
    private j b = new j();

    public e() {
        Avocarrot.class.getSimpleName();
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
        this.a = new g(jSONObject);
    }

    @Override
    public final void a(com.adincube.sdk.h.g g2) {
        if (g2.d != null) {
            Avocarrot.setUserBirthday((Date)g2.a());
        }
        if (g2.a != null) {
            int n2 = 1.a[g2.a.ordinal()];
            if (n2 != 1) {
                if (n2 != 2) {
                    return;
                }
                Avocarrot.setUserGender((Gender)Gender.FEMALE);
                return;
            }
            Avocarrot.setUserGender((Gender)Gender.MALE);
        }
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
        return Avocarrot.sdkVersion();
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
        return "Avocarrot";
    }

    @Override
    public final com.adincube.sdk.mediation.aa.c g() {
        return this.b;
    }
}

