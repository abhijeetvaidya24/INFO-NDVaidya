/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONObject
 */
package com.integralads.avid.library.adcolony.session.internal.jsbridge;

import org.json.JSONObject;

public class AvidEvent {
    private int a;
    private String b;
    private JSONObject c;

    public AvidEvent() {
    }

    public AvidEvent(int n2, String string, JSONObject jSONObject) {
        this.a = n2;
        this.b = string;
        this.c = jSONObject;
    }

    public JSONObject getData() {
        return this.c;
    }

    public String getType() {
        return this.b;
    }
}

