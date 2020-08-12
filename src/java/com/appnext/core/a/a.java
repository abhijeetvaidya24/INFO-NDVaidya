/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.HashMap
 *  java.util.Iterator
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.appnext.core.a;

import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    private HashMap<String, String> hV;
    private HashMap<String, HashMap<String, String>> hW = new HashMap();

    public a(String string2) {
        try {
            JSONObject jSONObject = new JSONObject(string2);
            this.hV = a.d(jSONObject.getJSONObject("settings"));
            this.hW.put((Object)"new", a.d(jSONObject.getJSONObject("new")));
            this.hW.put((Object)"existing", a.d(jSONObject.getJSONObject("existing")));
        }
        catch (Throwable throwable) {}
    }

    private static HashMap<String, String> d(JSONObject jSONObject) throws JSONException {
        HashMap hashMap = new HashMap();
        Iterator iterator = jSONObject.keys();
        while (iterator.hasNext()) {
            String string2 = (String)iterator.next();
            hashMap.put((Object)string2, (Object)jSONObject.getString(string2));
        }
        return hashMap;
    }

    public final String d(String string2) {
        return (String)this.hV.get((Object)string2);
    }

    public final String t(String string2, String string3) {
        if (this.hW.containsKey((Object)string2)) {
            return (String)((HashMap)this.hW.get((Object)string2)).get((Object)string3);
        }
        return null;
    }
}

