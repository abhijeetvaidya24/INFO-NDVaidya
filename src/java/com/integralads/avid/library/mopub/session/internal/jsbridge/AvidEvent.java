/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONObject
 */
package com.integralads.avid.library.mopub.session.internal.jsbridge;

import org.json.JSONObject;

public class AvidEvent {
    private JSONObject data;
    private int tag;
    private String type;

    public AvidEvent() {
    }

    public AvidEvent(int n2, String string) {
        this(n2, string, null);
    }

    public AvidEvent(int n2, String string, JSONObject jSONObject) {
        this.tag = n2;
        this.type = string;
        this.data = jSONObject;
    }

    public JSONObject getData() {
        return this.data;
    }

    public int getTag() {
        return this.tag;
    }

    public String getType() {
        return this.type;
    }

    public void setData(JSONObject jSONObject) {
        this.data = jSONObject;
    }

    public void setTag(int n2) {
        this.tag = n2;
    }

    public void setType(String string) {
        this.type = string;
    }
}

