/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONObject
 */
package com.applovin.impl.mediation.c;

import com.applovin.impl.sdk.b.a;
import com.applovin.impl.sdk.b.d;
import com.applovin.impl.sdk.e.f;
import com.applovin.impl.sdk.e.g;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.p;
import org.json.JSONObject;

public class b
extends f {
    public static String a(j j2) {
        return f.a(j2.a(a.a), "1.0/mediate", j2);
    }

    public static void a(JSONObject jSONObject, j j2) {
        if (g.a(jSONObject, "signal_providers")) {
            j2.a(d.p, jSONObject.toString());
            j2.u().b("MediationConnectionUtils", "Updated signal provider(s)");
        }
    }

    public static String b(j j2) {
        return f.a(j2.a(a.b), "1.0/mediate", j2);
    }

    public static void b(JSONObject jSONObject, j j2) {
        if (g.a(jSONObject, "auto_init_adapters")) {
            j2.a(d.q, jSONObject.toString());
            j2.u().b("MediationConnectionUtils", "Updated auto-init adapter(s)");
        }
    }
}

