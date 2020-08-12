/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONObject
 */
package com.amazon.device.ads;

import com.amazon.device.ads.JSONUtils;
import org.json.JSONObject;

class ResizeProperties {
    private static final boolean ALLOW_OFFSCREEN_DEFAULT = true;
    private static final String CUSTOM_CLOSE_POSITION_DEFAULT = "top-right";
    public static final int DIMENSION_NOT_SET = -1;
    private boolean allowOffscreen = true;
    private String customClosePosition = "top-right";
    private int height = -1;
    private final JSONUtils.JSONUtilities jsonUtils;
    private int offsetX = -1;
    private int offsetY = -1;
    private int width = -1;

    public ResizeProperties() {
        this(new JSONUtils.JSONUtilities());
    }

    ResizeProperties(JSONUtils.JSONUtilities jSONUtilities) {
        this.jsonUtils = jSONUtilities;
    }

    private void setDimensionIfSet(JSONObject jSONObject, String string, int n) {
        if (n != -1) {
            this.jsonUtils.put(jSONObject, string, n);
        }
    }

    public boolean areResizePropertiesSet() {
        return this.width != -1 && this.height != -1 && this.offsetX != -1 && this.offsetY != -1;
    }

    public boolean fromJSONObject(JSONObject jSONObject) {
        this.width = this.jsonUtils.getIntegerFromJSON(jSONObject, "width", this.width);
        this.height = this.jsonUtils.getIntegerFromJSON(jSONObject, "height", this.height);
        this.offsetX = this.jsonUtils.getIntegerFromJSON(jSONObject, "offsetX", this.offsetX);
        this.offsetY = this.jsonUtils.getIntegerFromJSON(jSONObject, "offsetY", this.offsetY);
        this.customClosePosition = this.jsonUtils.getStringFromJSON(jSONObject, "customClosePosition", this.customClosePosition);
        this.allowOffscreen = this.jsonUtils.getBooleanFromJSON(jSONObject, "allowOffscreen", this.allowOffscreen);
        if (this.areResizePropertiesSet()) {
            return true;
        }
        this.reset();
        return false;
    }

    public boolean getAllowOffscreen() {
        return this.allowOffscreen;
    }

    public String getCustomClosePosition() {
        return this.customClosePosition;
    }

    public int getHeight() {
        return this.height;
    }

    public int getOffsetX() {
        return this.offsetX;
    }

    public int getOffsetY() {
        return this.offsetY;
    }

    public int getWidth() {
        return this.width;
    }

    public void reset() {
        this.width = -1;
        this.height = -1;
        this.offsetX = -1;
        this.offsetY = -1;
        this.customClosePosition = CUSTOM_CLOSE_POSITION_DEFAULT;
        this.allowOffscreen = true;
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        this.setDimensionIfSet(jSONObject, "width", this.width);
        this.setDimensionIfSet(jSONObject, "height", this.height);
        this.setDimensionIfSet(jSONObject, "offsetX", this.offsetX);
        this.setDimensionIfSet(jSONObject, "offsetY", this.offsetY);
        this.jsonUtils.put(jSONObject, "customClosePosition", this.customClosePosition);
        this.jsonUtils.put(jSONObject, "allowOffscreen", this.allowOffscreen);
        return jSONObject;
    }
}

