/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.SystemClock
 *  java.lang.Boolean
 *  java.lang.String
 *  java.lang.StringBuilder
 *  org.json.JSONObject
 */
package com.applovin.impl.mediation.a;

import android.os.SystemClock;
import com.applovin.impl.mediation.a.e;
import com.applovin.impl.mediation.h;
import com.applovin.impl.sdk.e.m;
import com.applovin.impl.sdk.j;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import org.json.JSONObject;

public abstract class a
extends e
implements MaxAd {
    protected h a;

    protected a(JSONObject jSONObject, JSONObject jSONObject2, h h2, j j2) {
        super(jSONObject, jSONObject2, j2);
        this.a = h2;
    }

    private long h() {
        return this.b("load_started_time_ms", 0L);
    }

    public abstract a a(h var1);

    public boolean a() {
        return this.b("is_backup", false);
    }

    public h b() {
        return this.a;
    }

    public String c() {
        return this.b("bid_response", (String)null);
    }

    public String d() {
        return this.b("third_party_ad_placement_id", (String)null);
    }

    public long e() {
        if (this.h() > 0L) {
            return SystemClock.elapsedRealtime() - this.h();
        }
        return -1L;
    }

    public void f() {
        this.c("load_started_time_ms", SystemClock.elapsedRealtime());
    }

    public void g() {
        this.a = null;
    }

    @Override
    public String getAdUnitId() {
        return this.a("ad_unit_id", (String)null);
    }

    @Override
    public MaxAdFormat getFormat() {
        return m.b(this.a("ad_format", (String)null));
    }

    @Override
    public boolean isReady() {
        h h2 = this.a;
        boolean bl = false;
        if (h2 != null) {
            boolean bl2 = h2.c();
            bl = false;
            if (bl2) {
                boolean bl3 = this.a.d();
                bl = false;
                if (bl3) {
                    bl = true;
                }
            }
        }
        return bl;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[MediatedAd adUnitId=");
        stringBuilder.append(this.getAdUnitId());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

