/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONObject
 */
package com.ironsource.mediationsdk.model;

import org.json.JSONObject;

public class ServerSegmetData {
    private JSONObject mCustomSegments;
    private String mSegmentId;
    private String mSegmentName;

    public ServerSegmetData(String string, String string2, JSONObject jSONObject) {
        this.mSegmentName = string;
        this.mSegmentId = string2;
        this.mCustomSegments = jSONObject;
    }

    public JSONObject getCustomSegments() {
        return this.mCustomSegments;
    }

    public String getSegmentId() {
        return this.mSegmentId;
    }

    public String getSegmentName() {
        return this.mSegmentName;
    }
}

