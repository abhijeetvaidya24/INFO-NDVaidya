/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Iterator
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.adcolony.sdk;

import com.adcolony.sdk.a;
import com.adcolony.sdk.t;
import com.adcolony.sdk.y;
import java.io.IOException;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class w {
    static int a(JSONObject jSONObject, String string, int n2) {
        try {
            int n3 = jSONObject.getInt(string);
            return n3;
        }
        catch (JSONException jSONException) {
            return n2;
        }
    }

    static JSONArray a(JSONArray jSONArray, String[] arrstring, boolean bl) {
        for (String string : arrstring) {
            if (bl && w.b(jSONArray, string)) continue;
            w.a(jSONArray, string);
        }
        return jSONArray;
    }

    static JSONArray a(String[] arrstring) {
        JSONArray jSONArray = w.b();
        int n2 = arrstring.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            w.a(jSONArray, arrstring[i2]);
        }
        return jSONArray;
    }

    static JSONObject a() {
        return new JSONObject();
    }

    static JSONObject a(String string) {
        return w.a(string, null);
    }

    static JSONObject a(String string, String string2) {
        try {
            JSONObject jSONObject = new JSONObject(string);
            return jSONObject;
        }
        catch (JSONException jSONException) {
            String string3;
            if (string2 == null) {
                string3 = "";
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string2);
                stringBuilder.append(": ");
                stringBuilder.append(jSONException.toString());
                string3 = stringBuilder.toString();
            }
            new y.a().a(string3).a(y.h);
            return new JSONObject();
        }
    }

    /*
     * Exception decompiling
     */
    static JSONObject a(JSONObject var0, JSONObject var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl19.1 : ALOAD_0 : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:919)
        throw new IllegalStateException("Decompilation failed");
    }

    static void a(JSONArray jSONArray, Object object) {
        jSONArray.put(object);
    }

    static void a(JSONArray jSONArray, String string) {
        jSONArray.put((Object)string);
    }

    static boolean a(JSONObject jSONObject, String string, double d2) {
        try {
            jSONObject.put(string, d2);
            return true;
        }
        catch (JSONException jSONException) {
            new y.a().a("JSON error in ADCJSON putDouble(): ").a(jSONException.toString()).a(y.h);
            return false;
        }
    }

    static boolean a(JSONObject jSONObject, String string, long l2) {
        try {
            jSONObject.put(string, l2);
            return true;
        }
        catch (JSONException jSONException) {
            new y.a().a("JSON error in ADCJSON putLong(): ").a(jSONException.toString()).a(y.h);
            return false;
        }
    }

    static boolean a(JSONObject jSONObject, String string, String string2) {
        try {
            jSONObject.put(string, (Object)string2);
            return true;
        }
        catch (JSONException jSONException) {
            new y.a().a("JSON error in ADCJSON putString(): ").a(jSONException.toString()).a(y.h);
            return false;
        }
    }

    static boolean a(JSONObject jSONObject, String string, JSONArray jSONArray) {
        try {
            jSONObject.put(string, (Object)jSONArray);
            return true;
        }
        catch (JSONException jSONException) {
            new y.a().a("JSON error in ADCJSON putArray(): ").a(jSONException.toString()).a(y.h);
            return false;
        }
    }

    static boolean a(JSONObject jSONObject, String string, JSONObject jSONObject2) {
        try {
            jSONObject.put(string, (Object)jSONObject2);
            return true;
        }
        catch (JSONException jSONException) {
            new y.a().a("JSON error in ADCJSON putObject(): ").a(jSONException.toString()).a(y.h);
            return false;
        }
    }

    static boolean a(JSONObject jSONObject, String string, boolean bl) {
        try {
            jSONObject.put(string, bl);
            return true;
        }
        catch (JSONException jSONException) {
            new y.a().a("JSON error in ADCJSON putBoolean(): ").a(jSONException.toString()).a(y.h);
            return false;
        }
    }

    static String[] a(JSONArray jSONArray) {
        String[] arrstring = new String[jSONArray.length()];
        for (int i2 = 0; i2 < jSONArray.length(); ++i2) {
            arrstring[i2] = w.c(jSONArray, i2);
        }
        return arrstring;
    }

    static String b(JSONObject jSONObject, String string) {
        try {
            String string2 = jSONObject.getString(string);
            return string2;
        }
        catch (JSONException jSONException) {
            return "";
        }
    }

    static JSONArray b() {
        return new JSONArray();
    }

    static JSONArray b(String string) {
        try {
            JSONArray jSONArray = new JSONArray(string);
            return jSONArray;
        }
        catch (JSONException jSONException) {
            new y.a().a(jSONException.toString()).a(y.h);
            return new JSONArray();
        }
    }

    static boolean b(JSONArray jSONArray, String string) {
        for (int i2 = 0; i2 < jSONArray.length(); ++i2) {
            if (!w.c(jSONArray, i2).equals((Object)string)) continue;
            return true;
        }
        return false;
    }

    static boolean b(JSONObject jSONObject, String string, int n2) {
        try {
            jSONObject.put(string, n2);
            return true;
        }
        catch (JSONException jSONException) {
            new y.a().a("JSON error in ADCJSON putInteger(): ").a(jSONException.toString()).a(y.h);
            return false;
        }
    }

    static int c(JSONObject jSONObject, String string) {
        try {
            int n2 = jSONObject.getInt(string);
            return n2;
        }
        catch (JSONException jSONException) {
            return 0;
        }
    }

    static String c(JSONArray jSONArray, int n2) {
        try {
            String string = jSONArray.getString(n2);
            return string;
        }
        catch (JSONException jSONException) {
            return "";
        }
    }

    static JSONObject c(String string) {
        try {
            String string2 = a.a().j().a(string, false).toString();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("loadObject from filepath ");
            stringBuilder.append(string);
            JSONObject jSONObject = w.a(string2, stringBuilder.toString());
            return jSONObject;
        }
        catch (IOException iOException) {
            new y.a().a("IOException in ADCJSON's loadObject: ").a(iOException.toString()).a(y.h);
            return w.a();
        }
    }

    static JSONObject d(JSONArray jSONArray, int n2) {
        try {
            JSONObject jSONObject = jSONArray.getJSONObject(n2);
            return jSONObject;
        }
        catch (JSONException jSONException) {
            return new JSONObject();
        }
    }

    static boolean d(JSONObject jSONObject, String string) {
        try {
            boolean bl = jSONObject.getBoolean(string);
            return bl;
        }
        catch (JSONException jSONException) {
            return false;
        }
    }

    static double e(JSONObject jSONObject, String string) {
        try {
            double d2 = jSONObject.getDouble(string);
            return d2;
        }
        catch (JSONException jSONException) {
            return 0.0;
        }
    }

    static JSONObject f(JSONObject jSONObject, String string) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(string);
            return jSONObject2;
        }
        catch (JSONException jSONException) {
            return new JSONObject();
        }
    }

    static JSONArray g(JSONObject jSONObject, String string) {
        try {
            JSONArray jSONArray = jSONObject.getJSONArray(string);
            return jSONArray;
        }
        catch (JSONException jSONException) {
            return new JSONArray();
        }
    }

    static boolean h(JSONObject jSONObject, String string) {
        try {
            a.a().j().a(string, jSONObject.toString(), false);
            return true;
        }
        catch (IOException iOException) {
            new y.a().a("IOException in ADCJSON's saveObject: ").a(iOException.toString()).a(y.h);
            return false;
        }
    }

    static boolean i(JSONObject jSONObject, String string) {
        Iterator iterator = jSONObject.keys();
        while (iterator.hasNext()) {
            if (!string.equals(iterator.next())) continue;
            return true;
        }
        return false;
    }
}

