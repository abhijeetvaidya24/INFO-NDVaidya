/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  com.appnext.base.a.b.b
 *  com.appnext.base.a.b.c
 *  com.appnext.base.a.c.b
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.Date
 *  java.util.List
 *  java.util.Map
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.appnext.base.b;

import android.text.TextUtils;
import com.appnext.base.a.a;
import com.appnext.base.a.b.c;
import com.appnext.base.b.d;
import com.appnext.base.b.h;
import com.appnext.base.b.i;
import com.appnext.base.b.j;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b {
    private static List<com.appnext.base.a.b.b> E(String string2) {
        try {
            List list = a.X().aa().v(string2);
            return list;
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    public static boolean F(String string2) {
        List<com.appnext.base.a.b.b> list = b.E(string2);
        return list == null || list.size() == 0;
        {
        }
    }

    public static void G(String string2) {
        if (string2 == null) {
            return;
        }
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append("_cycles");
            String string3 = stringBuilder.toString();
            i.aQ().putInt(string3, 0);
        }
        catch (Throwable throwable) {}
    }

    public static void H(String string2) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append("_lastupdate");
            String string3 = stringBuilder.toString();
            i.aQ().putLong(string3, System.currentTimeMillis());
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(string2);
            stringBuilder2.append("_cycles");
            String string4 = stringBuilder2.toString();
            int n2 = 1 + i.aQ().getInt(string4, 0);
            i.aQ().putInt(string4, n2);
        }
        catch (Throwable throwable) {}
    }

    public static JSONArray a(List<com.appnext.base.a.b.b> list, boolean bl) {
        try {
            JSONArray jSONArray = new JSONArray();
            for (com.appnext.base.a.b.b b2 : list) {
                String string2;
                String string3 = b2.ai();
                if (string3.isEmpty() || TextUtils.isEmpty((CharSequence)(string2 = h.aO().K(string3)))) continue;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("pk", (Object)b2.ah());
                jSONObject.put("t", (Object)b2.getType());
                jSONObject.put("cd", (Object)string2);
                jSONObject.put("cdt", (Object)b2.getDataType());
                jSONArray.put((Object)jSONObject);
            }
            return jSONArray;
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    public static JSONObject a(String string2, Date date, d.a a2) {
        JSONObject jSONObject;
        String string3;
        block3 : {
            jSONObject = new JSONObject();
            try {
                string3 = h.aO().M(string2);
                if (!TextUtils.isEmpty((CharSequence)string3)) break block3;
                return jSONObject;
            }
            catch (Throwable throwable) {}
        }
        jSONObject.put("data", j.b(string3, a2));
        jSONObject.put("date", (Object)j.a(date));
        return jSONObject;
    }

    public static boolean a(String string2, Map<String, String> map) {
        try {
            boolean bl = j.b(string2, map);
            return bl;
        }
        catch (Throwable throwable) {
            return false;
        }
    }

    /*
     * Exception decompiling
     */
    public static boolean d(c var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl39.1 : ICONST_1 : trying to set 1 previously set to 0
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

