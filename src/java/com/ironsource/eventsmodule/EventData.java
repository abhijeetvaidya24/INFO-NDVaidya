/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.ironsource.eventsmodule;

import org.json.JSONException;
import org.json.JSONObject;

public class EventData {
    private JSONObject mAdditionalData;
    private int mEventId = -1;
    private long mTimeStamp = -1L;

    public EventData(int n2, long l2, JSONObject jSONObject) {
        this.mEventId = n2;
        this.mTimeStamp = l2;
        if (jSONObject == null) {
            this.mAdditionalData = new JSONObject();
            return;
        }
        this.mAdditionalData = jSONObject;
    }

    public EventData(int n2, JSONObject jSONObject) {
        this.mEventId = n2;
        this.mTimeStamp = System.currentTimeMillis();
        if (jSONObject == null) {
            this.mAdditionalData = new JSONObject();
            return;
        }
        this.mAdditionalData = jSONObject;
    }

    public void addToAdditionalData(String string, Object object) {
        try {
            this.mAdditionalData.put(string, object);
            return;
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
            return;
        }
    }

    public String getAdditionalData() {
        return this.mAdditionalData.toString();
    }

    public JSONObject getAdditionalDataJSON() {
        return this.mAdditionalData;
    }

    public int getEventId() {
        return this.mEventId;
    }

    public long getTimeStamp() {
        return this.mTimeStamp;
    }
}

