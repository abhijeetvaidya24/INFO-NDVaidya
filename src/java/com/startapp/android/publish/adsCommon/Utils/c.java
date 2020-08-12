/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.Collection
 *  java.util.Set
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.startapp.android.publish.adsCommon.Utils;

import com.startapp.android.publish.adsCommon.Utils.e;
import java.util.Collection;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c
extends e {
    private JSONObject a = new JSONObject();

    @Override
    public void a(String string, Object object, boolean bl, boolean bl2) {
        if (bl && object == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Required key: [");
            stringBuilder.append(string);
            stringBuilder.append("] is missing");
            throw new com.startapp.common.e(stringBuilder.toString(), null);
        }
        if (object != null && !object.toString().equals((Object)"")) {
            try {
                this.a.put(string, object);
                return;
            }
            catch (JSONException jSONException) {
                if (!bl) {
                    return;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("failed converting to json object value: [");
                stringBuilder.append(object);
                stringBuilder.append("]");
                throw new com.startapp.common.e(stringBuilder.toString(), jSONException);
            }
        }
    }

    @Override
    public void a(String string, Set<String> set, boolean bl, boolean bl2) {
        if (bl && (set == null || set.size() == 0)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Required key: [");
            stringBuilder.append(string);
            stringBuilder.append("] is missing");
            throw new com.startapp.common.e(stringBuilder.toString(), null);
        }
        if (set != null && set.size() > 0) {
            try {
                this.a.put(string, (Object)new JSONArray(set));
                return;
            }
            catch (JSONException jSONException) {
                if (!bl) {
                    return;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("failed converting to json array values: [");
                stringBuilder.append(set);
                stringBuilder.append("]");
                throw new com.startapp.common.e(stringBuilder.toString(), jSONException);
            }
        }
    }

    public String toString() {
        return this.a.toString();
    }
}

