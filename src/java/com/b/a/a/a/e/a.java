/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  org.json.JSONObject
 */
package com.b.a.a.a.e;

import android.os.Build;
import com.b.a.a.a.e.b;
import org.json.JSONObject;

public final class a {
    public static String a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Build.MANUFACTURER);
        stringBuilder.append("; ");
        stringBuilder.append(Build.MODEL);
        return stringBuilder.toString();
    }

    public static String b() {
        return Integer.toString((int)Build.VERSION.SDK_INT);
    }

    public static String c() {
        return "Android";
    }

    public static JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        b.a(jSONObject, "deviceType", a.a());
        b.a(jSONObject, "osVersion", a.b());
        b.a(jSONObject, "os", a.c());
        return jSONObject;
    }
}

