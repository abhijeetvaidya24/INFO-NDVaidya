/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  org.json.JSONObject
 */
package com.amazon.device.ads;

import com.amazon.device.ads.JSONUtils;
import org.json.JSONObject;

class Size {
    private int height;
    private int width;

    public Size(int n, int n2) {
        this.width = n;
        this.height = n2;
    }

    public Size(String string) {
        String[] arrstring;
        int n;
        int n2 = 0;
        if (string != null && (arrstring = string.split("x")) != null && arrstring.length == 2) {
            int n3 = Math.max((int)Size.parseInt(arrstring[0], 0), (int)0);
            n = Math.max((int)Size.parseInt(arrstring[1], 0), (int)0);
            n2 = n3;
        } else {
            n = 0;
        }
        this.width = n2;
        this.height = n;
    }

    private static int parseInt(String string, int n) {
        try {
            int n2 = Integer.parseInt((String)string);
            return n2;
        }
        catch (NumberFormatException numberFormatException) {
            return n;
        }
    }

    public boolean equals(Object object) {
        boolean bl = object instanceof Size;
        boolean bl2 = false;
        if (bl) {
            Size size = (Size)object;
            int n = this.width;
            int n2 = size.width;
            bl2 = false;
            if (n == n2) {
                int n3 = this.height;
                int n4 = size.height;
                bl2 = false;
                if (n3 == n4) {
                    bl2 = true;
                }
            }
        }
        return bl2;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public void setHeight(int n) {
        this.height = n;
    }

    public void setWidth(int n) {
        this.width = n;
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        JSONUtils.put(jSONObject, "width", this.width);
        JSONUtils.put(jSONObject, "height", this.height);
        return jSONObject;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.width);
        stringBuilder.append("x");
        stringBuilder.append(this.height);
        return stringBuilder.toString();
    }
}

