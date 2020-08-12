/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Iterator
 *  java.util.Set
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.onesignal;

import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class JSONUtils {
    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static JSONObject generateJsonDiff(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, Set<String> set) {
        if (jSONObject == null) {
            return null;
        }
        if (jSONObject2 == null) {
            return jSONObject3;
        }
        Iterator iterator = jSONObject2.keys();
        JSONObject jSONObject4 = jSONObject3 != null ? jSONObject3 : new JSONObject();
        while (iterator.hasNext()) {
            try {
                String string2 = (String)iterator.next();
                Object object = jSONObject2.get(string2);
                if (jSONObject.has(string2)) {
                    if (object instanceof JSONObject) {
                        JSONObject jSONObject5;
                        JSONObject jSONObject6 = jSONObject.getJSONObject(string2);
                        String string3 = JSONUtils.generateJsonDiff(jSONObject6, (JSONObject)object, jSONObject5 = jSONObject3 != null && jSONObject3.has(string2) ? jSONObject3.getJSONObject(string2) : null, set).toString();
                        if (string3.equals((Object)"{}")) continue;
                        jSONObject4.put(string2, (Object)new JSONObject(string3));
                        continue;
                    }
                    if (object instanceof JSONArray) {
                        JSONUtils.handleJsonArray(string2, (JSONArray)object, jSONObject.getJSONArray(string2), jSONObject4);
                        continue;
                    }
                    if (set != null && set.contains((Object)string2)) {
                        jSONObject4.put(string2, object);
                        continue;
                    }
                    Object object2 = jSONObject.get(string2);
                    if (object.equals(object2)) continue;
                    if (object2 instanceof Integer && !"".equals(object)) {
                        if (((Number)object2).doubleValue() == ((Number)object).doubleValue()) continue;
                        jSONObject4.put(string2, object);
                        continue;
                    }
                    jSONObject4.put(string2, object);
                    continue;
                }
                if (object instanceof JSONObject) {
                    jSONObject4.put(string2, (Object)new JSONObject(object.toString()));
                    continue;
                }
                if (object instanceof JSONArray) {
                    JSONUtils.handleJsonArray(string2, (JSONArray)object, null, jSONObject4);
                    continue;
                }
                jSONObject4.put(string2, object);
            }
            catch (JSONException jSONException) {
                jSONException.printStackTrace();
                continue;
            }
            break;
        }
        return jSONObject4;
    }

    /*
     * Exception decompiling
     */
    static JSONObject getJSONObjectWithoutBlankValues(JSONObject var0, String var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl18 : ALOAD : trying to set 1 previously set to 0
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

    private static void handleJsonArray(String string2, JSONArray jSONArray, JSONArray jSONArray2, JSONObject jSONObject) throws JSONException {
        if (!string2.endsWith("_a") && !string2.endsWith("_d")) {
            String string3 = JSONUtils.toStringNE(jSONArray);
            JSONArray jSONArray3 = new JSONArray();
            JSONArray jSONArray4 = new JSONArray();
            String string4 = jSONArray2 == null ? null : JSONUtils.toStringNE(jSONArray2);
            for (int i2 = 0; i2 < jSONArray.length(); ++i2) {
                String string5 = (String)jSONArray.get(i2);
                if (jSONArray2 != null && string4.contains((CharSequence)string5)) continue;
                jSONArray3.put((Object)string5);
            }
            if (jSONArray2 != null) {
                for (int i3 = 0; i3 < jSONArray2.length(); ++i3) {
                    String string6 = jSONArray2.getString(i3);
                    if (string3.contains((CharSequence)string6)) continue;
                    jSONArray4.put((Object)string6);
                }
            }
            if (!jSONArray3.toString().equals((Object)"[]")) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string2);
                stringBuilder.append("_a");
                jSONObject.put(stringBuilder.toString(), (Object)jSONArray3);
            }
            if (!jSONArray4.toString().equals((Object)"[]")) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string2);
                stringBuilder.append("_d");
                jSONObject.put(stringBuilder.toString(), (Object)jSONArray4);
            }
            return;
        }
        jSONObject.put(string2, (Object)jSONArray);
    }

    /*
     * Exception decompiling
     */
    static String toStringNE(JSONArray var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl36.1 : NEW : trying to set 1 previously set to 0
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
}

