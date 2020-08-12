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
package com.integralads.avid.library.mopub.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.integralads.avid.library.mopub.utils.AvidLogs;
import com.integralads.avid.library.mopub.utils.AvidTimestamp;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AvidJSONUtil {
    private static String[] KEYS = new String[]{"x", "y", "width", "height"};
    public static final String KEY_CHILD_VIEWS = "childViews";
    public static final String KEY_HEIGHT = "height";
    public static final String KEY_ID = "id";
    public static final String KEY_IS_FRIENDLY_OBSTRUCTION_FOR = "isFriendlyObstructionFor";
    public static final String KEY_ROOT_VIEW = "rootView";
    public static final String KEY_TIMESTAMP = "timestamp";
    public static final String KEY_WIDTH = "width";
    public static final String KEY_X = "x";
    public static final String KEY_Y = "y";
    static float density = Resources.getSystem().getDisplayMetrics().density;

    public static void addAvidId(JSONObject jSONObject, String string) {
        try {
            jSONObject.put(KEY_ID, (Object)string);
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
            JSONArray jSONArray = jSONObject.optJSONArray(KEY_CHILD_VIEWS);
            if (jSONArray == null) {
                jSONArray = new JSONArray();
                jSONObject.put(KEY_CHILD_VIEWS, (Object)jSONArray);
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
            jSONObject.put(KEY_IS_FRIENDLY_OBSTRUCTION_FOR, (Object)jSONArray);
            return;
        }
        catch (JSONException jSONException) {
            AvidLogs.e("Error with setting friendly obstruction", (Exception)jSONException);
            return;
        }
    }

    private static boolean compareChildren(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray jSONArray;
        JSONArray jSONArray2 = jSONObject.optJSONArray(KEY_CHILD_VIEWS);
        if (!AvidJSONUtil.compareJSONArrays(jSONArray2, jSONArray = jSONObject2.optJSONArray(KEY_CHILD_VIEWS))) {
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

    private static boolean compareFriendlySessionIds(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray jSONArray;
        JSONArray jSONArray2 = jSONObject.optJSONArray(KEY_IS_FRIENDLY_OBSTRUCTION_FOR);
        if (!AvidJSONUtil.compareJSONArrays(jSONArray2, jSONArray = jSONObject2.optJSONArray(KEY_IS_FRIENDLY_OBSTRUCTION_FOR))) {
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

    private static boolean compareJSONArrays(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray == null && jSONArray2 == null) {
            return true;
        }
        if (jSONArray == null && jSONArray2 != null || jSONArray != null && jSONArray2 == null) {
            return false;
        }
        return jSONArray.length() == jSONArray2.length();
    }

    private static boolean compareRequiredValues(JSONObject jSONObject, JSONObject jSONObject2) {
        for (String string : KEYS) {
            if (jSONObject.optDouble(string) == jSONObject2.optDouble(string)) continue;
            return false;
        }
        return true;
    }

    private static boolean compareSessionId(JSONObject jSONObject, JSONObject jSONObject2) {
        return jSONObject.optString(KEY_ID, "").equals((Object)jSONObject2.optString(KEY_ID, ""));
    }

    public static boolean equalStates(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject2 == null) {
            return false;
        }
        boolean bl2 = AvidJSONUtil.compareRequiredValues(jSONObject, jSONObject2);
        boolean bl3 = false;
        if (bl2) {
            boolean bl4 = AvidJSONUtil.compareSessionId(jSONObject, jSONObject2);
            bl3 = false;
            if (bl4) {
                boolean bl5 = AvidJSONUtil.compareFriendlySessionIds(jSONObject, jSONObject2);
                bl3 = false;
                if (bl5) {
                    boolean bl6 = AvidJSONUtil.compareChildren(jSONObject, jSONObject2);
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
        JSONArray jSONArray = jSONObject.optJSONArray(KEY_CHILD_VIEWS);
        if (jSONArray == null) {
            return;
        }
        int n2 = jSONArray.length();
        int n3 = 0;
        int n4 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            JSONObject jSONObject2 = jSONArray.optJSONObject(i2);
            if (jSONObject2 == null) continue;
            int n5 = jSONObject2.optInt(KEY_X);
            int n6 = jSONObject2.optInt(KEY_Y);
            int n7 = jSONObject2.optInt(KEY_WIDTH);
            int n8 = jSONObject2.optInt(KEY_HEIGHT);
            n3 = Math.max((int)n3, (int)(n5 + n7));
            n4 = Math.max((int)n4, (int)(n6 + n8));
        }
        try {
            jSONObject.put(KEY_WIDTH, n3);
            jSONObject.put(KEY_HEIGHT, n4);
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
            jSONObject2.put(KEY_TIMESTAMP, d2);
            jSONObject2.put(KEY_ROOT_VIEW, (Object)jSONObject);
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
            jSONObject.put(KEY_X, (double)AvidJSONUtil.pxToDp(n2));
            jSONObject.put(KEY_Y, (double)AvidJSONUtil.pxToDp(n3));
            jSONObject.put(KEY_WIDTH, (double)AvidJSONUtil.pxToDp(n4));
            jSONObject.put(KEY_HEIGHT, (double)AvidJSONUtil.pxToDp(n5));
            return jSONObject;
        }
        catch (JSONException jSONException) {
            AvidLogs.e("Error with creating viewStateObject", (Exception)jSONException);
            return jSONObject;
        }
    }

    public static void init(Context context) {
        if (context != null) {
            density = context.getResources().getDisplayMetrics().density;
        }
    }

    static float pxToDp(int n2) {
        return (float)n2 / density;
    }
}

