/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.util.Pair
 *  com.appnext.base.a.b.b
 *  com.appnext.base.a.b.c
 *  com.appnext.base.a.c.b
 *  com.appnext.base.a.c.d
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.Date
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.appnext.base.operations;

import android.os.Bundle;
import android.util.Pair;
import com.appnext.base.a;
import com.appnext.base.a.b.c;
import com.appnext.base.a.c.d;
import com.appnext.base.b.d;
import com.appnext.base.b.i;
import com.appnext.base.operations.b;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class a {
    private static final String em = "collectedData";
    private static final String en = "collectedDataType";
    private static final String eo = "lastCollectedData";
    private a el;
    protected c ep;

    public a(c c2, Bundle bundle, Object object) {
        this.ep = c2;
    }

    private static String A(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(eo);
        stringBuilder.append("_");
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    private void a(String string2, List<com.appnext.base.a.b.b> list) {
        JSONArray jSONArray;
        block4 : {
            if (list == null) {
                return;
            }
            try {
                jSONArray = a.d(list);
                if (jSONArray != null) break block4;
                return;
            }
            catch (Throwable throwable) {
                throwable.printStackTrace();
                return;
            }
        }
        i.aQ().putString(a.A(string2), jSONArray.toString());
    }

    private boolean a(Map<String, String> map) {
        Long l2 = System.currentTimeMillis();
        String string2 = this.ep.getKey();
        i i2 = i.aQ();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append("_lastcollectedtime");
        Long.valueOf((long)i2.getLong(stringBuilder.toString(), -1L));
        i i3 = i.aQ();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(string2);
        stringBuilder2.append("_lastcollectedtime");
        i3.putLong(stringBuilder2.toString(), l2);
        return com.appnext.base.b.b.a(string2, map);
    }

    protected static d aB() {
        return com.appnext.base.a.a.X().aa();
    }

    protected static boolean az() {
        return true;
    }

    protected static HashMap<Pair<String, String>, JSONArray> c(HashMap<Pair<String, String>, JSONArray> hashMap) {
        return hashMap;
    }

    private void c(List<String> list) {
        if (list.isEmpty()) {
            return;
        }
        com.appnext.base.a.c.b b2 = com.appnext.base.a.a.X().aa();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            b2.u((String)iterator.next());
        }
    }

    public static void cancel() {
    }

    private static JSONArray d(List<com.appnext.base.a.b.b> list) {
        if (list != null) {
            block5 : {
                if (!list.isEmpty()) break block5;
                return null;
            }
            try {
                JSONArray jSONArray = new JSONArray();
                for (com.appnext.base.a.b.b b2 : list) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(em, (Object)b2.ai());
                    jSONObject.put(en, (Object)b2.getType());
                    jSONArray.put((Object)jSONObject);
                }
                return jSONArray;
            }
            catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
        return null;
    }

    private static JSONObject d(com.appnext.base.a.b.b b2) {
        return com.appnext.base.b.b.a(b2.ai(), b2.aj(), d.a.valueOf(b2.getDataType()));
    }

    protected static Date getDate() {
        return new Date();
    }

    /*
     * Exception decompiling
     */
    protected final long a(List<com.appnext.base.a.b.b> var1) {
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

    public final void a(com.appnext.base.a a2) {
        b.aI().a(this);
        a a3 = this.el;
        if (a3 != null) {
            if (a2 != null) {
                a3.b(a2);
                return;
            }
            a3.aH();
        }
    }

    public final void a(a a2) {
        this.el = a2;
    }

    protected boolean aA() {
        return com.appnext.base.b.b.d(this.ep);
    }

    public abstract void aC();

    public abstract void aD();

    public final boolean aE() {
        boolean bl;
        block3 : {
            bl = false;
            try {
                String string2 = this.ep.getKey();
                i i2 = i.aQ();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string2);
                stringBuilder.append("_lastcollectedtime");
                Long l2 = i2.getLong(stringBuilder.toString(), -1L);
                if (System.currentTimeMillis() - l2 >= 900000L) break block3;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(string2);
                stringBuilder2.append(" less then interval");
                return false;
            }
            catch (Throwable throwable) {}
        }
        bl = this.aF();
        return bl;
    }

    public boolean aF() {
        return true;
    }

    protected d.a aG() {
        return d.a.String;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    protected final void av() {
        var2_1 = System.currentTimeMillis();
        var3_2 = this.ep.getKey();
        var4_3 = i.aQ();
        var5_4 = new StringBuilder();
        var5_4.append(var3_2);
        var5_4.append("_lastcollectedtime");
        var4_3.putLong(var5_4.toString(), var2_1);
        var8_5 = this.getData();
        if (var8_5 != null && !var8_5.isEmpty()) {
            this.a(var8_5);
        }
        var9_6 = this.getKey();
        if (var8_5 == null) ** GOTO lbl23
        {
            catch (Throwable v0) {}
        }
        try {
            var38_7 = a.d(var8_5);
            if (var38_7 != null) {
                i.aQ().putString(a.A(var9_6), var38_7.toString());
            }
            ** GOTO lbl23
        }
        catch (Throwable var10_8) {
            var10_8.printStackTrace();
lbl23: // 3 sources:
            var11_9 = this.ep.getKey();
            try {
                var12_10 = new StringBuilder();
                var12_10.append(var11_9);
                var12_10.append("_lastupdate");
                var32_11 = var12_10.toString();
                i.aQ().putLong(var32_11, System.currentTimeMillis());
                var33_12 = new StringBuilder();
                var33_12.append(var11_9);
                var33_12.append("_cycles");
                var36_13 = var33_12.toString();
                var37_14 = 1 + i.aQ().getInt(var36_13, 0);
                i.aQ().putInt(var36_13, var37_14);
            }
            catch (Throwable v1) {}
            var14_15 = this.aA();
            var15_16 = null;
            if (var14_15) {
                var16_17 = this.ax();
                var15_16 = null;
                if (var16_17 != null) {
                    var17_18 = var16_17.isEmpty();
                    var15_16 = null;
                    if (!var17_18) {
                        var18_19 = System.currentTimeMillis();
                        var19_20 = this.ep.getKey();
                        var20_21 = i.aQ();
                        var21_22 = new StringBuilder();
                        var21_22.append(var19_20);
                        var21_22.append("_lastcollectedtime");
                        Long.valueOf((long)var20_21.getLong(var21_22.toString(), -1L));
                        var25_23 = i.aQ();
                        var26_24 = new StringBuilder();
                        var26_24.append(var19_20);
                        var26_24.append("_lastcollectedtime");
                        var25_23.putLong(var26_24.toString(), var18_19);
                        var29_25 = com.appnext.base.b.b.a(var19_20, var16_17);
                        var15_16 = null;
                        if (!var29_25) {
                            var15_16 = new com.appnext.base.a(a.a.NoInternet$1d8b5b4a);
                        }
                    }
                }
            }
            this.a(var15_16);
            return;
        }
    }

    protected final List<com.appnext.base.a.b.b> aw() {
        return com.appnext.base.a.a.X().aa().w(this.ep.getKey());
    }

    /*
     * Exception decompiling
     */
    protected final Map<String, String> ax() {
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

    protected final c ay() {
        return this.ep;
    }

    protected List<com.appnext.base.a.b.b> b(List<com.appnext.base.a.b.b> list) {
        return list;
    }

    /*
     * Exception decompiling
     */
    protected final boolean e(List<com.appnext.base.a.b.b> var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl37.1 : ICONST_1 : trying to set 1 previously set to 0
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

    protected abstract List<com.appnext.base.a.b.b> getData();

    protected abstract String getKey();

    public static interface a {
        public void aH();

        public void b(com.appnext.base.a var1);
    }

}

