/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONObject
 */
package io.presage;

import io.presage.TommeCrayeuse;
import io.presage.cl;
import org.json.JSONObject;

public final class TommedAuvergne {
    public static final TommedAuvergne a = new TommedAuvergne();

    private TommedAuvergne() {
    }

    public static final TommeCrayeuse a(String string2) {
        TommeCrayeuse tommeCrayeuse = new TommeCrayeuse();
        JSONObject jSONObject = new JSONObject(string2);
        String string3 = jSONObject.optString("url", "");
        cl.a((Object)string3, "jsonObject.optString(\"url\", \"\")");
        tommeCrayeuse.a(string3);
        String string4 = jSONObject.optString("content", "");
        cl.a((Object)string4, "jsonObject.optString(\"content\", \"\")");
        tommeCrayeuse.b(string4);
        String string5 = jSONObject.optString("webViewId", "");
        cl.a((Object)string5, "jsonObject.optString(\"webViewId\", \"\")");
        tommeCrayeuse.c(string5);
        JSONObject jSONObject2 = jSONObject.optJSONObject("size");
        int n2 = -1;
        int n3 = jSONObject2 != null ? jSONObject2.optInt("width", n2) : -1;
        tommeCrayeuse.b(n3);
        JSONObject jSONObject3 = jSONObject.optJSONObject("size");
        int n4 = jSONObject3 != null ? jSONObject3.optInt("height", n2) : -1;
        tommeCrayeuse.a(n4);
        JSONObject jSONObject4 = jSONObject.optJSONObject("position");
        int n5 = jSONObject4 != null ? jSONObject4.optInt("x", n2) : -1;
        tommeCrayeuse.d(n5);
        JSONObject jSONObject5 = jSONObject.optJSONObject("position");
        if (jSONObject5 != null) {
            n2 = jSONObject5.optInt("y", n2);
        }
        tommeCrayeuse.c(n2);
        tommeCrayeuse.a(jSONObject.optBoolean("enableTracking", false));
        tommeCrayeuse.b(jSONObject.optBoolean("keepAlive", false));
        tommeCrayeuse.c(jSONObject.optBoolean("isLandingPage", false));
        return tommeCrayeuse;
    }
}

