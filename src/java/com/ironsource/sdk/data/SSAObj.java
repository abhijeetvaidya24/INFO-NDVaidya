/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.ironsource.sdk.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SSAObj {
    private JSONObject mJsonObject;

    public SSAObj() {
        this.mJsonObject = new JSONObject();
    }

    public SSAObj(String string) {
        this.setJsonObject(string);
    }

    private Object fromJson(Object object) throws JSONException {
        if (object == JSONObject.NULL) {
            return null;
        }
        if (object instanceof JSONObject) {
            return this.toMap((JSONObject)object);
        }
        if (object instanceof JSONArray) {
            object = this.toList((JSONArray)object);
        }
        return object;
    }

    private void setJsonObject(String string) {
        try {
            this.mJsonObject = new JSONObject(string);
            return;
        }
        catch (Exception exception) {
            this.mJsonObject = new JSONObject();
            return;
        }
    }

    private Map<String, Object> toMap(JSONObject jSONObject) throws JSONException {
        HashMap hashMap = new HashMap();
        Iterator iterator = jSONObject.keys();
        while (iterator.hasNext()) {
            String string = (String)iterator.next();
            hashMap.put((Object)string, this.fromJson(jSONObject.get(string)));
        }
        return hashMap;
    }

    public boolean containsKey(String string) {
        return this.getJsonObject().has(string);
    }

    public Object get(String string) {
        try {
            Object object = this.getJsonObject().get(string);
            return object;
        }
        catch (JSONException jSONException) {
            return null;
        }
    }

    public boolean getBoolean(String string) {
        try {
            boolean bl2 = this.mJsonObject.getBoolean(string);
            return bl2;
        }
        catch (JSONException jSONException) {
            return false;
        }
    }

    public JSONObject getJsonObject() {
        return this.mJsonObject;
    }

    public String getString(String string) {
        try {
            String string2 = this.mJsonObject.getString(string);
            return string2;
        }
        catch (JSONException jSONException) {
            return null;
        }
    }

    public boolean isNull(String string) {
        return this.getJsonObject().isNull(string);
    }

    public void put(String string, String string2) {
        try {
            this.mJsonObject.put(string, (Object)string2);
        }
        catch (Exception exception) {}
    }

    public void put(String string, JSONObject jSONObject) {
        try {
            this.mJsonObject.put(string, (Object)jSONObject);
        }
        catch (Exception exception) {}
    }

    public List toList(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); ++i2) {
            arrayList.add(this.fromJson(jSONArray.get(i2)));
        }
        return arrayList;
    }

    public String toString() {
        JSONObject jSONObject = this.mJsonObject;
        if (jSONObject == null) {
            return "";
        }
        return jSONObject.toString();
    }
}

