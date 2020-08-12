/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.widget.ImageView
 *  android.widget.ImageView$ScaleType
 *  java.lang.Boolean
 *  java.lang.Double
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONObject
 */
package com.adincube.sdk.h.d;

import android.widget.ImageView;
import org.json.JSONObject;

public final class b {
    public Integer a = null;
    public Integer b = null;
    public Boolean c = true;
    public ImageView.ScaleType d = ImageView.ScaleType.FIT_CENTER;
    public Boolean e = null;
    public Double f = null;
    public Boolean g = null;
    public Integer h = null;
    public Boolean i = null;

    public b() {
    }

    public b(JSONObject jSONObject) {
        this.e = jSONObject.getBoolean("nmvap");
        this.g = jSONObject.getBoolean("nmvsm");
        this.f = jSONObject.getDouble("nmvmpvpap");
        this.i = jSONObject.getBoolean("nmvsnc");
    }
}

