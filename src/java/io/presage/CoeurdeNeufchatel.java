/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.util.DisplayMetrics
 *  java.lang.Float
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONObject
 */
package io.presage;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import io.presage.Chambertin;
import io.presage.Chaource;
import io.presage.EmmentalGrandCru;
import io.presage.cl;
import org.json.JSONObject;

public final class CoeurdeNeufchatel {
    private final Chambertin a;
    private final Chaource b;

    public CoeurdeNeufchatel(Chambertin chambertin, Chaource chaource) {
        this.a = chambertin;
        this.b = chaource;
    }

    private static JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", (Object)Chambertin.h());
        jSONObject.put("screen", (Object)CoeurdeNeufchatel.b());
        jSONObject.put("os_version", (Object)Chambertin.a());
        jSONObject.put("vm_name", (Object)Chambertin.c());
        jSONObject.put("phone_arch", (Object)Chambertin.d());
        jSONObject.put("vm_version", (Object)Chambertin.b());
        return jSONObject;
    }

    private static JSONObject b() {
        Resources resources = Resources.getSystem();
        cl.a((Object)resources, "Resources.getSystem()");
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("density", (Object)Float.valueOf((float)displayMetrics.density));
        jSONObject.put("height", displayMetrics.heightPixels);
        jSONObject.put("width", displayMetrics.widthPixels);
        return jSONObject;
    }

    private final JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("ACCESS_NETWORK_STATE", this.b.a("android.permission.ACCESS_NETWORK_STATE"));
        jSONObject.put("RECEIVE_BOOT_COMPLETED", this.b.a("android.permission.RECEIVE_BOOT_COMPLETED"));
        jSONObject.put("SYSTEM_ALERT_WINDOW", this.b.a("android.permission.SYSTEM_ALERT_WINDOW"));
        jSONObject.put("GET_ACCOUNTS", this.b.a("android.permission.GET_ACCOUNTS"));
        return jSONObject;
    }

    public final JSONObject a(EmmentalGrandCru emmentalGrandCru) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("timezone", (Object)Chambertin.e());
        jSONObject.put("aaid", (Object)emmentalGrandCru.a());
        jSONObject.put("language_code", (Object)this.b.b());
        jSONObject.put("country_code", (Object)this.b.c());
        jSONObject.put("install_unknown_sources", this.a.g());
        jSONObject.put("aaid_optin", emmentalGrandCru.b());
        jSONObject.put("fake_aaid", emmentalGrandCru.c());
        jSONObject.put("device", (Object)CoeurdeNeufchatel.a());
        jSONObject.put("permissions", (Object)this.c());
        return jSONObject;
    }
}

