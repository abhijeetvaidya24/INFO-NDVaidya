/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.applovin.impl.sdk.d.z$1
 *  java.lang.String
 *  java.util.Map
 *  org.json.JSONObject
 */
package com.applovin.impl.sdk.d;

import com.applovin.impl.sdk.b.b;
import com.applovin.impl.sdk.d.a;
import com.applovin.impl.sdk.d.q;
import com.applovin.impl.sdk.d.z;
import com.applovin.impl.sdk.e.f;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.network.a;
import com.applovin.impl.sdk.network.b;
import java.util.Map;
import org.json.JSONObject;

abstract class z
extends a {
    z(String string, j j2) {
        super(string, j2);
    }

    void a(String string, JSONObject jSONObject, int n2, a.b b2) {
        1 var5_5 = new 1(this, com.applovin.impl.sdk.network.b.a(this.b).a(f.a(string, this.b)).c(f.b(string, this.b)).a(f.c(this.b)).b("POST").a(jSONObject).a(new JSONObject()).a((JSONObject)n2).a(), this.b, b2);
        var5_5.a(b.aD);
        var5_5.b(b.aE);
        this.b.C().a((a)var5_5);
    }
}

