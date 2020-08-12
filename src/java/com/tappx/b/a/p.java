/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.UnsupportedEncodingException
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Map
 *  org.json.JSONArray
 *  org.json.JSONException
 */
package com.tappx.b.a;

import com.tappx.b.a.j;
import com.tappx.b.a.r;
import com.tappx.b.k;
import com.tappx.b.m;
import com.tappx.b.p;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

public class p
extends r<JSONArray> {
    public p(int n2, String string, JSONArray jSONArray, p.b<JSONArray> b2, p.a a2) {
        String string2 = jSONArray == null ? null : jSONArray.toString();
        super(n2, string, string2, b2, a2);
    }

    public p(String string, p.b<JSONArray> b2, p.a a2) {
        super(0, string, null, b2, a2);
    }

    @Override
    protected com.tappx.b.p<JSONArray> a(k k2) {
        try {
            com.tappx.b.p<JSONArray> p2 = com.tappx.b.p.a(new JSONArray(new String(k2.b, j.a(k2.c, "utf-8"))), j.a(k2));
            return p2;
        }
        catch (JSONException jSONException) {
            return com.tappx.b.p.a(new m(jSONException));
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            return com.tappx.b.p.a(new m(unsupportedEncodingException));
        }
    }
}

