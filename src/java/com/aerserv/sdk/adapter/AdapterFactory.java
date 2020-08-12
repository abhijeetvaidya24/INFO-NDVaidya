/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.reflect.Method
 *  org.json.JSONObject
 */
package com.aerserv.sdk.adapter;

import com.aerserv.sdk.adapter.Adapter;
import com.aerserv.sdk.utils.AerServLog;
import java.lang.reflect.Method;
import org.json.JSONObject;

public class AdapterFactory {
    public static Adapter getAdapter(String string, String string2, JSONObject jSONObject) {
        try {
            Adapter adapter = (Adapter)Class.forName((String)AdapterFactory.getAdapterClassName(string)).getMethod("getInstance", new Class[]{String.class, JSONObject.class}).invoke(null, new Object[]{string2, jSONObject});
            return adapter;
        }
        catch (Throwable throwable) {
            String string3 = AdapterFactory.class.getSimpleName();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Exception creating adapter for ");
            stringBuilder.append(string);
            stringBuilder.append(": ");
            stringBuilder.append(throwable.getMessage());
            AerServLog.w(string3, stringBuilder.toString());
            return null;
        }
    }

    public static String getAdapterClassName(String string) {
        if ("RhythmOne".equals((Object)string)) {
            string = "RhythmOneSdk";
        } else if ("MoPub".equals((Object)string)) {
            string = "MoPubSdk";
        } else if ("MyTarget".equals((Object)string)) {
            string = "MyTargetSdk";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("com.aerserv.sdk.adapter.");
        stringBuilder.append(string.replaceFirst("AS", ""));
        stringBuilder.append("InterstitialAdapter");
        return stringBuilder.toString();
    }
}

