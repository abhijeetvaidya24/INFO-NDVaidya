/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.applovin.impl.sdk.d;

import com.applovin.impl.sdk.ad.b;
import com.applovin.impl.sdk.ad.d;
import com.applovin.impl.sdk.c.i;
import com.applovin.impl.sdk.d.a;
import com.applovin.impl.sdk.d.q;
import com.applovin.impl.sdk.d.s;
import com.applovin.impl.sdk.d.t;
import com.applovin.impl.sdk.e.g;
import com.applovin.impl.sdk.e.m;
import com.applovin.impl.sdk.j;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import org.json.JSONArray;
import org.json.JSONObject;

public class r
extends a
implements AppLovinAdLoadListener {
    private final JSONObject a;
    private final d c;
    private final b d;
    private final AppLovinAdLoadListener e;

    public r(JSONObject jSONObject, d d2, b b2, AppLovinAdLoadListener appLovinAdLoadListener, j j2) {
        super("TaskProcessAdResponse", j2);
        if (jSONObject != null) {
            if (d2 != null) {
                this.a = jSONObject;
                this.c = d2;
                this.d = b2;
                this.e = appLovinAdLoadListener;
                return;
            }
            throw new IllegalArgumentException("No zone specified");
        }
        throw new IllegalArgumentException("No response specified");
    }

    private void a(int n2) {
        m.a(this.e, this.c, n2, this.b);
    }

    private void a(AppLovinAd appLovinAd) {
        try {
            if (this.e != null) {
                this.e.adReceived(appLovinAd);
                return;
            }
        }
        catch (Throwable throwable) {
            this.a("Unable process a ad received notification", throwable);
        }
    }

    private void a(JSONObject jSONObject) {
        String string = g.a(jSONObject, "type", "undefined", this.b);
        if ("applovin".equalsIgnoreCase(string)) {
            this.a("Starting task for AppLovin ad...");
            q q2 = this.b.C();
            t t2 = new t(jSONObject, this.a, this.d, this, this.b);
            q2.a(t2);
            return;
        }
        if ("vast".equalsIgnoreCase(string)) {
            this.a("Starting task for VAST ad...");
            this.b.C().a(s.a(jSONObject, this.a, this.d, this, this.b));
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unable to process ad of unknown type: ");
        stringBuilder.append(string);
        this.c(stringBuilder.toString());
        this.failedToReceiveAd(-800);
    }

    private void f() {
        this.a(-6);
    }

    @Override
    public i a() {
        return i.q;
    }

    @Override
    public void adReceived(AppLovinAd appLovinAd) {
        this.a(appLovinAd);
    }

    @Override
    public void failedToReceiveAd(int n2) {
        this.f();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public void run() {
        this.a("Processing ad response...");
        var2_1 = this.a.getJSONArray("ads");
        if (var2_1.length() <= 0) ** GOTO lbl20
        this.a("Processing ad...");
        {
            catch (Throwable var1_2) {
                this.a("Encountered error while processing ad response", var1_2);
                this.f();
                this.b.E().a(this.a());
                return;
            }
        }
        try {
            this.a(var2_1.getJSONObject(0));
            return;
        }
        catch (Throwable v0) {
            this.d("Encountered error while processing ad");
            this.f();
            this.b.E().a(this.a());
            return;
lbl20: // 1 sources:
            this.c("No ads were returned from the server");
            this.a(204);
            return;
        }
    }
}

