/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package io.presage;

import android.content.Context;
import io.presage.Chambertin;
import io.presage.Chaource;
import org.json.JSONArray;
import org.json.JSONObject;

public final class BleudeLaqueuille {
    private final Chambertin a;
    private final Chaource b;

    public BleudeLaqueuille(Context context) {
        this.a = new Chambertin(context);
        this.b = new Chaource(context);
    }

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("connectivity", (Object)this.a.i());
        jSONObject.put("at", (Object)Chambertin.f());
        jSONObject.put("build", 30042);
        jSONObject.put("version", (Object)"3.0.36-moat");
        JSONArray jSONArray = new JSONArray();
        jSONArray.put((Object)this.b.a());
        jSONObject.put("apps_publishers", (Object)jSONArray);
        return jSONObject;
    }
}

