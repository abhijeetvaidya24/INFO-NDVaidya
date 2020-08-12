/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  org.json.JSONObject
 */
package com.amazon.device.ads;

import org.json.JSONObject;

class ViewabilityInfo {
    private boolean isAdOnScreen;
    private JSONObject jsonObject;

    public ViewabilityInfo(boolean bl, JSONObject jSONObject) {
        this.jsonObject = jSONObject;
        this.isAdOnScreen = bl;
    }

    public JSONObject getJsonObject() {
        return this.jsonObject;
    }

    public boolean isAdOnScreen() {
        return this.isAdOnScreen;
    }
}

