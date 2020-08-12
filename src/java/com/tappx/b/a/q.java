/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.UnsupportedEncodingException
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Map
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.tappx.b.a;

import com.tappx.b.a.j;
import com.tappx.b.a.r;
import com.tappx.b.k;
import com.tappx.b.m;
import com.tappx.b.p;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class q
extends r<JSONObject> {
    public q(int n2, String string, JSONObject jSONObject, p.b<JSONObject> b2, p.a a2) {
        String string2 = jSONObject == null ? null : jSONObject.toString();
        super(n2, string, string2, b2, a2);
    }

    public q(String string, JSONObject jSONObject, p.b<JSONObject> b2, p.a a2) {
        int n2 = jSONObject == null ? 0 : 1;
        this(n2, string, jSONObject, b2, a2);
    }

    @Override
    protected p<JSONObject> a(k k2) {
        try {
            p<JSONObject> p2 = p.a(new JSONObject(new String(k2.b, j.a(k2.c, "utf-8"))), j.a(k2));
            return p2;
        }
        catch (JSONException jSONException) {
            return p.a(new m(jSONException));
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            return p.a(new m(unsupportedEncodingException));
        }
    }
}

