/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Point
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.DisplayMetrics
 *  android.view.Display
 *  android.view.WindowManager
 *  java.lang.Exception
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Iterator
 *  java.util.List
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.b.a.a.a.e;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.b.a.a.a.e.c;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b {
    static float a;
    private static WindowManager b;
    private static String[] c;

    static {
        c = new String[]{"x", "y", "width", "height"};
        a = Resources.getSystem().getDisplayMetrics().density;
    }

    static float a(int n2) {
        return (float)n2 / a;
    }

    public static JSONObject a(int n2, int n3, int n4, int n5) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", (double)b.a(n2));
            jSONObject.put("y", (double)b.a(n3));
            jSONObject.put("width", (double)b.a(n4));
            jSONObject.put("height", (double)b.a(n5));
            return jSONObject;
        }
        catch (JSONException jSONException) {
            c.a("Error with creating viewStateObject", (Exception)((Object)jSONException));
            return jSONObject;
        }
    }

    public static void a(Context context) {
        if (context != null) {
            a = context.getResources().getDisplayMetrics().density;
            b = (WindowManager)context.getSystemService("window");
        }
    }

    public static void a(JSONObject jSONObject) {
        a a2 = b.b(jSONObject);
        try {
            jSONObject.put("width", (double)a2.a);
            jSONObject.put("height", (double)a2.b);
            return;
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
            return;
        }
    }

    public static void a(JSONObject jSONObject, String string2) {
        try {
            jSONObject.put("adSessionId", (Object)string2);
            return;
        }
        catch (JSONException jSONException) {
            c.a("Error with setting ad session id", (Exception)((Object)jSONException));
            return;
        }
    }

    public static void a(JSONObject jSONObject, String string2, Object object) {
        try {
            jSONObject.put(string2, object);
            return;
        }
        catch (JSONException jSONException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("JSONException during JSONObject.put for name [");
            stringBuilder.append(string2);
            stringBuilder.append("]");
            c.a(stringBuilder.toString(), (Exception)((Object)jSONException));
            return;
        }
    }

    public static void a(JSONObject jSONObject, List<String> list) {
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
            c.a("Error with setting friendly obstruction", (Exception)((Object)jSONException));
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(JSONObject jSONObject, JSONObject jSONObject2) {
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

    private static boolean a(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray == null && jSONArray2 == null) {
            return true;
        }
        if (jSONArray != null) {
            if (jSONArray2 == null) {
                return false;
            }
            return jSONArray.length() == jSONArray2.length();
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    private static a b(JSONObject jSONObject) {
        float f2;
        int n2 = Build.VERSION.SDK_INT;
        float f3 = 0.0f;
        int n3 = 0;
        if (n2 >= 17) {
            if (b != null) {
                Point point = new Point(0, 0);
                b.getDefaultDisplay().getRealSize(point);
                f3 = b.a(point.x);
                f2 = b.a(point.y);
                return new a(f3, f2);
            }
        } else {
            JSONArray jSONArray = jSONObject.optJSONArray("childViews");
            if (jSONArray != null) {
                int n4 = jSONArray.length();
                float f4 = 0.0f;
                do {
                    if (n3 >= n4) {
                        f2 = f4;
                        return new a(f3, f2);
                    }
                    JSONObject jSONObject2 = jSONArray.optJSONObject(n3);
                    if (jSONObject2 != null) {
                        double d2 = jSONObject2.optDouble("x");
                        double d3 = jSONObject2.optDouble("y");
                        double d4 = jSONObject2.optDouble("width");
                        double d5 = jSONObject2.optDouble("height");
                        f3 = Math.max((float)f3, (float)((float)(d2 + d4)));
                        f4 = Math.max((float)f4, (float)((float)(d3 + d5)));
                    }
                    ++n3;
                } while (true);
            }
        }
        f2 = 0.0f;
        return new a(f3, f2);
    }

    public static boolean b(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null && jSONObject2 == null) {
            return true;
        }
        if (jSONObject != null) {
            if (jSONObject2 == null) {
                return false;
            }
            return b.c(jSONObject, jSONObject2) && b.d(jSONObject, jSONObject2) && b.e(jSONObject, jSONObject2) && b.f(jSONObject, jSONObject2);
        }
        return false;
    }

    private static boolean c(JSONObject jSONObject, JSONObject jSONObject2) {
        for (String string2 : c) {
            if (jSONObject.optDouble(string2) == jSONObject2.optDouble(string2)) continue;
            return false;
        }
        return true;
    }

    private static boolean d(JSONObject jSONObject, JSONObject jSONObject2) {
        return jSONObject.optString("adSessionId", "").equals((Object)jSONObject2.optString("adSessionId", ""));
    }

    private static boolean e(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray jSONArray = jSONObject.optJSONArray("isFriendlyObstructionFor");
        JSONArray jSONArray2 = jSONObject2.optJSONArray("isFriendlyObstructionFor");
        if (jSONArray == null && jSONArray2 == null) {
            return true;
        }
        if (!b.a(jSONArray, jSONArray2)) {
            return false;
        }
        for (int i2 = 0; i2 < jSONArray.length(); ++i2) {
            if (jSONArray.optString(i2, "").equals((Object)jSONArray2.optString(i2, ""))) continue;
            return false;
        }
        return true;
    }

    private static boolean f(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray jSONArray = jSONObject.optJSONArray("childViews");
        JSONArray jSONArray2 = jSONObject2.optJSONArray("childViews");
        if (jSONArray == null && jSONArray2 == null) {
            return true;
        }
        if (!b.a(jSONArray, jSONArray2)) {
            return false;
        }
        for (int i2 = 0; i2 < jSONArray.length(); ++i2) {
            if (b.b(jSONArray.optJSONObject(i2), jSONArray2.optJSONObject(i2))) continue;
            return false;
        }
        return true;
    }

    private static class a {
        final float a;
        final float b;

        a(float f2, float f3) {
            this.a = f2;
            this.b = f3;
        }
    }

}

