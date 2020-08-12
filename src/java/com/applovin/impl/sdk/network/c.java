/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.applovin.impl.sdk.network;

import android.content.Context;
import android.text.TextUtils;
import com.applovin.impl.sdk.b.d;
import com.applovin.impl.sdk.b.e;
import com.applovin.impl.sdk.e.m;
import org.json.JSONException;
import org.json.JSONObject;

public class c {
    private static final Object a = new Object();

    /*
     * Exception decompiling
     */
    private static JSONObject a(String var0, Context var1) {
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

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    static void a(int var0, String var1_1, Context var2_2) {
        if (TextUtils.isEmpty((CharSequence)var1_1)) {
            return;
        }
        var15_4 = var3_3 = c.a;
        // MONITORENTER : var15_4
        var5_5 = m.c(var1_1);
        var6_6 = c.a(var5_5, var2_2);
        var7_7 = Integer.toString((int)var0);
        var8_8 = var6_6.optJSONObject(var5_5);
        var9_9 = var8_8.optInt(var7_7);
        var10_10 = var9_9 + 1;
        try {
            var8_8.put(var7_7, var10_10);
            ** GOTO lbl-1000
        }
        catch (JSONException v0) {
            try lbl-1000: // 2 sources:
            {
                var6_6.put(var5_5, (Object)var8_8);
            }
            catch (JSONException v1) {}
        }
        c.a(var6_6, var2_2);
        // MONITOREXIT : var15_4
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(Context context) {
        Object object;
        Object object2 = object = a;
        synchronized (object2) {
            e.a(d.k, context);
            return;
        }
    }

    private static void a(JSONObject jSONObject, Context context) {
        e.a(d.k, jSONObject.toString(), context);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static JSONObject b(Context context) {
        Object object;
        Object object2 = object = a;
        synchronized (object2) {
            try {
                try {
                    return new JSONObject(e.b(d.k, "{}", context));
                }
                catch (JSONException jSONException) {
                    return new JSONObject();
                }
            }
            catch (Throwable throwable) {}
            throw throwable;
        }
    }
}

