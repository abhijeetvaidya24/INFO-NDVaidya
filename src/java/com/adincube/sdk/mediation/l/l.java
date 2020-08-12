/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.adincube.sdk.h.f.c
 *  com.adincube.sdk.h.f.d
 *  com.flurry.android.Consent
 *  com.flurry.android.FlurryAgent
 *  com.flurry.android.FlurryConsent
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.Map
 */
package com.adincube.sdk.mediation.l;

import android.content.Context;
import com.adincube.sdk.h.f.c;
import com.adincube.sdk.h.f.d;
import com.adincube.sdk.mediation.e;
import com.adincube.sdk.mediation.l.f;
import com.adincube.sdk.mediation.l.h;
import com.adincube.sdk.util.r;
import com.flurry.android.Consent;
import com.flurry.android.FlurryAgent;
import com.flurry.android.FlurryConsent;
import java.util.HashMap;
import java.util.Map;

public final class l
implements com.adincube.sdk.mediation.aa.c {
    FlurryConsent a = null;
    private f b;
    private String c = null;

    public l(f f2) {
        this.b = f2;
    }

    @Override
    public final void a(Context context, d d2) {
    }

    @Override
    public final void a(Context context, String string) {
        if (!r.a(this.c, string)) {
            FlurryConsent flurryConsent;
            this.c = string;
            if (this.b.a.a == c.d) {
                flurryConsent = new FlurryConsent(false, null);
            } else {
                HashMap hashMap = new HashMap(1);
                hashMap.put((Object)"IAB", (Object)string);
                flurryConsent = new FlurryConsent(true, (Map)hashMap);
            }
            if (this.a != null) {
                FlurryAgent.updateFlurryConsent((Consent)flurryConsent);
            }
            this.a = flurryConsent;
        }
    }

    @Override
    public final boolean a() {
        return true;
    }

    @Override
    public final String b() {
        return null;
    }
}

