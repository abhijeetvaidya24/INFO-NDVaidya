/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONObject
 */
package com.amazon.device.ads;

import com.amazon.device.ads.JSONUtils;
import org.json.JSONObject;

class ExpandProperties {
    private int height = -1;
    private final boolean isModal = true;
    private final JSONUtils.JSONUtilities jsonUtils;
    private boolean useCustomClose = false;
    private int width = -1;

    public ExpandProperties() {
        this(new JSONUtils.JSONUtilities());
    }

    ExpandProperties(JSONUtils.JSONUtilities jSONUtilities) {
        this.jsonUtils = jSONUtilities;
    }

    public void fromJSONObject(JSONObject jSONObject) {
        this.width = this.jsonUtils.getIntegerFromJSON(jSONObject, "width", this.width);
        this.height = this.jsonUtils.getIntegerFromJSON(jSONObject, "height", this.height);
        this.useCustomClose = this.jsonUtils.getBooleanFromJSON(jSONObject, "useCustomClose", this.useCustomClose);
    }

    public int getHeight() {
        return this.height;
    }

    public Boolean getIsModal() {
        return true;
    }

    public Boolean getUseCustomClose() {
        return this.useCustomClose;
    }

    public int getWidth() {
        return this.width;
    }

    public void setHeight(int n) {
        this.height = n;
    }

    public void setUseCustomClose(Boolean bl) {
        this.useCustomClose = bl;
    }

    public void setWidth(int n) {
        this.width = n;
    }

    public ExpandProperties toClone() {
        ExpandProperties expandProperties = new ExpandProperties();
        expandProperties.width = this.width;
        expandProperties.height = this.height;
        expandProperties.useCustomClose = this.useCustomClose;
        return expandProperties;
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        this.jsonUtils.put(jSONObject, "width", this.width);
        this.jsonUtils.put(jSONObject, "height", this.height);
        this.jsonUtils.put(jSONObject, "useCustomClose", this.useCustomClose);
        JSONUtils.JSONUtilities jSONUtilities = this.jsonUtils;
        this.getClass();
        jSONUtilities.put(jSONObject, "isModal", true);
        return jSONObject;
    }

    public String toString() {
        return this.toJSONObject().toString();
    }
}

