/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Locale
 *  org.json.JSONObject
 */
package com.amazon.device.ads;

import com.amazon.device.ads.ForceOrientation;
import com.amazon.device.ads.JSONUtils;
import java.util.Locale;
import org.json.JSONObject;

class OrientationProperties {
    private Boolean allowOrientationChange = true;
    private ForceOrientation forceOrientation = ForceOrientation.NONE;
    private final JSONUtils.JSONUtilities jsonUtils;

    public OrientationProperties() {
        this(new JSONUtils.JSONUtilities());
    }

    OrientationProperties(JSONUtils.JSONUtilities jSONUtilities) {
        this.jsonUtils = jSONUtilities;
    }

    public void fromJSONObject(JSONObject jSONObject) {
        this.allowOrientationChange = this.jsonUtils.getBooleanFromJSON(jSONObject, "allowOrientationChange", this.allowOrientationChange);
        this.forceOrientation = ForceOrientation.valueOf(this.jsonUtils.getStringFromJSON(jSONObject, "forceOrientation", this.forceOrientation.toString()).toUpperCase(Locale.US));
    }

    public ForceOrientation getForceOrientation() {
        return this.forceOrientation;
    }

    public Boolean isAllowOrientationChange() {
        return this.allowOrientationChange;
    }

    public void setAllowOrientationChange(Boolean bl) {
        this.allowOrientationChange = bl;
    }

    public void setForceOrientation(ForceOrientation forceOrientation) {
        this.forceOrientation = forceOrientation;
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        this.jsonUtils.put(jSONObject, "forceOrientation", this.forceOrientation.toString());
        this.jsonUtils.put(jSONObject, "allowOrientationChange", this.allowOrientationChange);
        return jSONObject;
    }

    public String toString() {
        return this.toJSONObject().toString();
    }
}

