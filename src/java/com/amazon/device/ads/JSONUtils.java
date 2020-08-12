/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.Map
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.amazon.device.ads;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class JSONUtils {
    JSONUtils() {
    }

    public static Map<String, String> createMapFromJSON(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        Iterator iterator = jSONObject.keys();
        while (iterator.hasNext()) {
            String string = (String)iterator.next();
            String string2 = JSONUtils.getStringFromJSON(jSONObject, string, null);
            if (string2 == null) continue;
            hashMap.put((Object)string, (Object)string2);
        }
        return hashMap;
    }

    public static boolean getBooleanFromJSON(JSONObject jSONObject, String string, boolean bl) {
        if (jSONObject.isNull(string)) {
            return bl;
        }
        return jSONObject.optBoolean(string, bl);
    }

    public static int getIntegerFromJSON(JSONObject jSONObject, String string, int n) {
        if (jSONObject.isNull(string)) {
            return n;
        }
        return jSONObject.optInt(string, n);
    }

    public static int getIntegerFromJSONArray(JSONArray jSONArray, int n, int n2) {
        if (jSONArray.isNull(n)) {
            return n2;
        }
        return jSONArray.optInt(n, n2);
    }

    public static JSONArray getJSONArrayFromJSON(JSONObject jSONObject, String string) {
        if (jSONObject.isNull(string)) {
            return null;
        }
        return jSONObject.optJSONArray(string);
    }

    public static JSONObject getJSONObjectFromJSONArray(JSONArray jSONArray, int n) {
        if (jSONArray.isNull(n)) {
            return null;
        }
        try {
            JSONObject jSONObject = jSONArray.getJSONObject(n);
            return jSONObject;
        }
        catch (JSONException jSONException) {
            return null;
        }
    }

    public static JSONObject getJSONObjectFromString(String string) {
        try {
            JSONObject jSONObject = new JSONObject(string);
            return jSONObject;
        }
        catch (JSONException jSONException) {
            return null;
        }
    }

    public static long getLongFromJSON(JSONObject jSONObject, String string, long l2) {
        if (jSONObject.isNull(string)) {
            return l2;
        }
        return jSONObject.optLong(string, l2);
    }

    public static String getStringFromJSON(JSONObject jSONObject, String string, String string2) {
        if (jSONObject.isNull(string)) {
            return string2;
        }
        return jSONObject.optString(string, string2);
    }

    public static void put(JSONObject jSONObject, String string, int n) {
        try {
            jSONObject.put(string, n);
        }
        catch (JSONException jSONException) {}
    }

    public static void put(JSONObject jSONObject, String string, long l2) {
        try {
            jSONObject.put(string, l2);
        }
        catch (JSONException jSONException) {}
    }

    /*
     * Exception decompiling
     */
    public static void put(JSONObject var0, String var1, String var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
        // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
        // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
        // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
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

    public static void put(JSONObject jSONObject, String string, boolean bl) {
        try {
            jSONObject.put(string, bl);
        }
        catch (JSONException jSONException) {}
    }

    public static class JSONUtilities {
        public Map<String, String> createMapFromJSON(JSONObject jSONObject) {
            return JSONUtils.createMapFromJSON(jSONObject);
        }

        public boolean getBooleanFromJSON(JSONObject jSONObject, String string, boolean bl) {
            return JSONUtils.getBooleanFromJSON(jSONObject, string, bl);
        }

        public int getIntegerFromJSON(JSONObject jSONObject, String string, int n) {
            return JSONUtils.getIntegerFromJSON(jSONObject, string, n);
        }

        public int getIntegerFromJSONArray(JSONArray jSONArray, int n, int n2) {
            return JSONUtils.getIntegerFromJSONArray(jSONArray, n, n2);
        }

        public JSONArray getJSONArrayFromJSON(JSONObject jSONObject, String string) {
            return JSONUtils.getJSONArrayFromJSON(jSONObject, string);
        }

        public JSONObject getJSONObjectFromJSONArray(JSONArray jSONArray, int n) {
            return JSONUtils.getJSONObjectFromJSONArray(jSONArray, n);
        }

        public JSONObject getJSONObjectFromString(String string) {
            return JSONUtils.getJSONObjectFromString(string);
        }

        public long getLongFromJSON(JSONObject jSONObject, String string, long l2) {
            return JSONUtils.getLongFromJSON(jSONObject, string, l2);
        }

        public String getStringFromJSON(JSONObject jSONObject, String string, String string2) {
            return JSONUtils.getStringFromJSON(jSONObject, string, string2);
        }

        public void put(JSONObject jSONObject, String string, int n) {
            JSONUtils.put(jSONObject, string, n);
        }

        public void put(JSONObject jSONObject, String string, long l2) {
            JSONUtils.put(jSONObject, string, l2);
        }

        public void put(JSONObject jSONObject, String string, String string2) {
            JSONUtils.put(jSONObject, string, string2);
        }

        public void put(JSONObject jSONObject, String string, boolean bl) {
            JSONUtils.put(jSONObject, string, bl);
        }
    }

}

