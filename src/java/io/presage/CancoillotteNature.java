/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  org.json.JSONObject
 */
package io.presage;

import io.presage.BriquetteduNord;
import io.presage.Chambertin;
import io.presage.Chaource;
import org.json.JSONObject;

public final class CancoillotteNature {
    public static final CancoillotteNature a = new CancoillotteNature();

    private CancoillotteNature() {
    }

    public static String a(Chaource chaource, Chambertin chambertin, BriquetteduNord briquetteduNord, String string2) {
        boolean bl2;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", (Object)briquetteduNord.a());
        jSONObject.put("ad_sync_type", (Object)"load");
        if (briquetteduNord.b() != null) {
            jSONObject.put("ad_unit_id", (Object)briquetteduNord.b());
        }
        if (bl2 = ((CharSequence)string2).length() > 0) {
            jSONObject.put("app_user_id", (Object)string2);
        }
        StringBuilder stringBuilder = new StringBuilder("{\"connectivity\":\"");
        stringBuilder.append(chambertin.i());
        stringBuilder.append("\",\"at\":\"");
        stringBuilder.append(Chambertin.f());
        stringBuilder.append("\",\"country\":\"");
        stringBuilder.append(chaource.c());
        stringBuilder.append("\",\"build\":30042,\"apps_publishers\":[\"");
        stringBuilder.append(chaource.a());
        stringBuilder.append("\"],\"version\":\"3.0.36-moat\",\"content\":");
        stringBuilder.append((Object)jSONObject);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

