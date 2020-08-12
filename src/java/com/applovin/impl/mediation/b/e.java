/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  com.applovin.impl.mediation.a.b
 *  com.applovin.impl.mediation.a.c
 *  com.applovin.impl.mediation.a.d
 *  java.lang.IllegalArgumentException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.applovin.impl.mediation.b;

import android.app.Activity;
import com.applovin.impl.mediation.MediationServiceImpl;
import com.applovin.impl.mediation.a.b;
import com.applovin.impl.mediation.a.c;
import com.applovin.impl.mediation.a.d;
import com.applovin.impl.mediation.f;
import com.applovin.impl.sdk.c.i;
import com.applovin.impl.sdk.c.j;
import com.applovin.impl.sdk.d.a;
import com.applovin.impl.sdk.e.h;
import com.applovin.impl.sdk.e.m;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import org.json.JSONException;
import org.json.JSONObject;

public class e
extends a {
    private final String a;
    private final JSONObject c;
    private final JSONObject d;
    private final f e;
    private final MaxAdListener f;
    private final Activity g;

    e(String string, f f2, JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.sdk.j j2, Activity activity, MaxAdListener maxAdListener) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TaskLoadAdapterAd ");
        stringBuilder.append(string);
        super(stringBuilder.toString(), j2);
        this.c = jSONObject;
        this.d = jSONObject2;
        this.a = string;
        this.e = f2;
        this.g = activity;
        this.f = maxAdListener;
    }

    private com.applovin.impl.mediation.a.a f() throws JSONException {
        String string = this.d.getString("ad_format");
        MaxAdFormat maxAdFormat = m.b(string);
        if (maxAdFormat != MaxAdFormat.BANNER && maxAdFormat != MaxAdFormat.MREC && maxAdFormat != MaxAdFormat.LEADER) {
            if (maxAdFormat == MaxAdFormat.NATIVE) {
                return new d(this.c, this.d, this.b);
            }
            if (maxAdFormat != MaxAdFormat.INTERSTITIAL && maxAdFormat != MaxAdFormat.REWARDED) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported ad format: ");
                stringBuilder.append(string);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            return new c(this.c, this.d, this.b);
        }
        return new b(this.c, this.d, this.b);
    }

    @Override
    public i a() {
        return i.D;
    }

    public void run() {
        try {
            com.applovin.impl.mediation.a.a a2 = this.f();
            this.b.a(this.g).loadThirdPartyMediatedAd(this.a, a2, this.g, this.f);
            return;
        }
        catch (Throwable throwable) {
            this.a("Unable to process adapter ad", throwable);
            this.b.E().a(this.a());
            h.a(this.f, this.a, -5001, this.b);
            return;
        }
    }
}

