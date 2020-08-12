/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Point
 *  android.os.Build
 *  android.os.Build$VERSION
 *  com.yandex.metrica.impl.am
 *  java.lang.Class
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import com.yandex.metrica.impl.am;
import org.json.JSONException;
import org.json.JSONObject;

public class cj {
    private final String a;
    private final String b;
    private final String c;
    private final Point d;

    public cj(Context context) {
        this.a = Build.MANUFACTURER;
        this.b = Build.MODEL;
        String string2 = Build.VERSION.SDK_INT > 8 ? Build.SERIAL : "";
        this.c = string2;
        int n2 = am.a((Context)context).y;
        int n3 = am.a((Context)context).x;
        this.d = new Point(Math.min((int)n2, (int)n3), Math.max((int)n2, (int)n3));
    }

    public cj(String string2) throws JSONException {
        JSONObject jSONObject = new JSONObject(string2);
        this.a = jSONObject.getString("manufacturer");
        this.b = jSONObject.getString("model");
        this.c = jSONObject.getString("serial");
        this.d = new Point(jSONObject.getInt("width"), jSONObject.getInt("height"));
    }

    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("manufacturer", (Object)this.a);
        jSONObject.put("model", (Object)this.b);
        jSONObject.put("serial", (Object)this.c);
        jSONObject.put("width", this.d.x);
        jSONObject.put("height", this.d.y);
        return jSONObject;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null) {
            if (this.getClass() != object.getClass()) {
                return false;
            }
            cj cj2 = (cj)object;
            String string2 = this.a;
            if (string2 != null ? !string2.equals((Object)cj2.a) : cj2.a != null) {
                return false;
            }
            String string3 = this.b;
            if (string3 != null ? !string3.equals((Object)cj2.b) : cj2.b != null) {
                return false;
            }
            String string4 = this.c;
            if (string4 != null ? !string4.equals((Object)cj2.c) : cj2.c != null) {
                return false;
            }
            Point point = this.d;
            if (point != null) {
                return point.equals((Object)cj2.d);
            }
            if (cj2.d == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String string2 = this.a;
        int n2 = string2 != null ? string2.hashCode() : 0;
        int n3 = n2 * 31;
        String string3 = this.b;
        int n4 = string3 != null ? string3.hashCode() : 0;
        int n5 = 31 * (n3 + n4);
        String string4 = this.c;
        int n6 = string4 != null ? string4.hashCode() : 0;
        int n7 = 31 * (n5 + n6);
        Point point = this.d;
        int n8 = 0;
        if (point != null) {
            n8 = point.hashCode();
        }
        return n7 + n8;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("DeviceShapshot{mManufacturer='");
        stringBuilder.append(this.a);
        stringBuilder.append('\'');
        stringBuilder.append(", mModel='");
        stringBuilder.append(this.b);
        stringBuilder.append('\'');
        stringBuilder.append(", mSerial='");
        stringBuilder.append(this.c);
        stringBuilder.append('\'');
        stringBuilder.append(", mScreenSize=");
        stringBuilder.append((Object)this.d);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

