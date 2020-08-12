/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.util.DisplayMetrics
 *  java.lang.Exception
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Iterator
 *  java.util.List
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.integralads.avid.library.adcolony.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.integralads.avid.library.adcolony.utils.AvidLogs;
import com.integralads.avid.library.adcolony.utils.AvidTimestamp;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AvidJSONUtil {
    static float a;
    private static String[] b;

    static {
        b = new String[]{"x", "y", "width", "height"};
        a = Resources.getSystem().getDisplayMetrics().density;
    }

    static float a(int n2) {
        return (float)n2 / a;
    }

    private static boolean a(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray == null && jSONArray2 == null) {
            return true;
        }
        if (jSONArray == null && jSONArray2 != null || jSONArray != null && jSONArray2 == null) {
            return false;
        }
        return jSONArray.length() == jSONArray2.length();
    }

    private static boolean a(JSONObject jSONObject, JSONObject jSONObject2) {
        for (String string : b) {
            if (jSONObject.optDouble(string) == jSONObject2.optDouble(string)) continue;
            return false;
        }
        return true;
    }

    public static void addAvidId(JSONObject jSONObject, String string) {
        try {
            jSONObject.put("id", (Object)string);
            return;
        }
        catch (JSONException jSONException) {
            AvidLogs.e("Error with setting avid id", (Exception)jSONException);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void addChildState(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            JSONArray jSONArray = jSONObject.optJSONArray("childViews");
            if (jSONArray == null) {
                jSONArray = new JSONArray();
                jSONObject.put("childViews", (Object)jSONArray);
            }
            jSONArray.put((Object)jSONObject2);
            return;
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
            return;
        }
    }

    public static void addFriendlyObstruction(JSONObject jSONObject, List<String> list) {
        JSONArray jSONArray = new JSONArray();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            jSONArray.put((Object)((String)iterator.next()));
        }
        try {
            jSONObject.put("isFriendlyObstructionFor", (Object)jSONArray);
            return;
        }
        catch (JSONException jSONException) {
            AvidLogs.e("Error with setting friendly obstruction", (Exception)jSONException);
            return;
        }
    }

    private static boolean b(JSONObject jSONObject, JSONObject jSONObject2) {
        return jSONObject.optString("id", "").equals((Object)jSONObject2.optString("id", ""));
    }

    private static boolean c(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray jSONArray;
        JSONArray jSONArray2 = jSONObject.optJSONArray("isFriendlyObstructionFor");
        if (!AvidJSONUtil.a(jSONArray2, jSONArray = jSONObject2.optJSONArray("isFriendlyObstructionFor"))) {
            return false;
        }
        if (jSONArray2 == null) {
            return true;
        }
        for (int i2 = 0; i2 < jSONArray2.length(); ++i2) {
            if (jSONArray2.optString(i2, "").equals((Object)jSONArray.optString(i2, ""))) continue;
            return false;
        }
        return true;
    }

    private static boolean d(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray jSONArray;
        JSONArray jSONArray2 = jSONObject.optJSONArray("childViews");
        if (!AvidJSONUtil.a(jSONArray2, jSONArray = jSONObject2.optJSONArray("childViews"))) {
            return false;
        }
        if (jSONArray2 == null) {
            return true;
        }
        for (int i2 = 0; i2 < jSONArray2.length(); ++i2) {
            if (AvidJSONUtil.equalStates(jSONArray2.optJSONObject(i2), jSONArray.optJSONObject(i2))) continue;
            return false;
        }
        return true;
    }

    public static boolean equalStates(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject2 == null) {
            return false;
        }
        boolean bl2 = AvidJSONUtil.a(jSONObject, jSONObject2);
        boolean bl3 = false;
        if (bl2) {
            boolean bl4 = AvidJSONUtil.b(jSONObject, jSONObject2);
            bl3 = false;
            if (bl4) {
                boolean bl5 = AvidJSONUtil.c(jSONObject, jSONObject2);
                bl3 = false;
                if (bl5) {
                    boolean bl6 = AvidJSONUtil.d(jSONObject, jSONObject2);
                    bl3 = false;
                    if (bl6) {
                        bl3 = true;
                    }
                }
            }
        }
        return bl3;
    }

    public static void fixStateFrame(JSONObject jSONObject) {
        JSONArray jSONArray = jSONObject.optJSONArray("childViews");
        if (jSONArray == null) {
            return;
        }
        int n2 = jSONArray.length();
        int n3 = 0;
        int n4 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            JSONObject jSONObject2 = jSONArray.optJSONObject(i2);
            if (jSONObject2 == null) continue;
            int n5 = jSONObject2.optInt("x");
            int n6 = jSONObject2.optInt("y");
            int n7 = jSONObject2.optInt("width");
            int n8 = jSONObject2.optInt("height");
            n3 = Math.max((int)n3, (int)(n5 + n7));
            n4 = Math.max((int)n4, (int)(n6 + n8));
        }
        try {
            jSONObject.put("width", n3);
            jSONObject.put("height", n4);
            return;
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
            return;
        }
    }

    public static JSONObject getEmptyTreeJSONObject() {
        return AvidJSONUtil.getTreeJSONObject(AvidJSONUtil.getViewState(0, 0, 0, 0), AvidTimestamp.getCurrentTime());
    }

    public static JSONObject getTreeJSONObject(JSONObject jSONObject, double d2) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("timestamp", d2);
            jSONObject2.put("rootView", (Object)jSONObject);
            return jSONObject2;
        }
        catch (JSONException jSONException) {
            AvidLogs.e("Error with creating treeJSONObject", (Exception)jSONException);
            return jSONObject2;
        }
    }

    public static JSONObject getViewState(int n2, int n3, int n4, int n5) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", (double)AvidJSONUtil.a(n2));
            jSONObject.put("y", (double)AvidJSONUtil.a(n3));
            jSONObject.put("width", (double)AvidJSONUtil.a(n4));
            jSONObject.put("height", (double)AvidJSONUtil.a(n5));
            return jSONObject;
        }
        catch (JSONException jSONException) {
            AvidLogs.e("Error with creating viewStateObject", (Exception)jSONException);
            return jSONObject;
        }
    }

    public static void init(Context context) {
        if (context != null) {
            a = context.getResources().getDisplayMetrics().density;
        }
    }
}

