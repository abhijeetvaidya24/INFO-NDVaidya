/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.HashMap
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.adcolony.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import com.adcolony.sdk.AdColonyAppOptions;
import com.adcolony.sdk.a;
import com.adcolony.sdk.ad;
import com.adcolony.sdk.af;
import com.adcolony.sdk.ag;
import com.adcolony.sdk.ap;
import com.adcolony.sdk.au;
import com.adcolony.sdk.aw;
import com.adcolony.sdk.l;
import com.adcolony.sdk.w;
import com.adcolony.sdk.y;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint(value={"UseSparseArrays"})
class ae {
    private ArrayList<ag> a = new ArrayList();
    private HashMap<Integer, ag> b = new HashMap();
    private int c = 2;
    private HashMap<String, ArrayList<af>> d = new HashMap();
    private JSONArray e = w.b();
    private int f = 1;

    ae() {
    }

    static /* synthetic */ int a(ae ae2) {
        int n2 = ae2.f;
        ae2.f = n2 + 1;
        return n2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    ag a(int n2) {
        ArrayList<ag> arrayList;
        ArrayList<ag> arrayList2 = arrayList = this.a;
        synchronized (arrayList2) {
            ag ag2 = (ag)this.b.get((Object)n2);
            if (ag2 == null) {
                return null;
            }
            this.a.remove((Object)ag2);
            this.b.remove((Object)n2);
            ag2.b();
            return ag2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    ag a(ag ag2) {
        ArrayList<ag> arrayList;
        ArrayList<ag> arrayList2 = arrayList = this.a;
        synchronized (arrayList2) {
            this.a.add((Object)ag2);
            this.b.put((Object)ag2.a(), (Object)ag2);
            return ag2;
        }
    }

    void a() {
        l l2 = a.a();
        if (!l2.g() && !l2.h()) {
            final Context context = a.c();
            if (context == null) {
                return;
            }
            au.a(new Runnable(){

                public void run() {
                    AdColonyAppOptions adColonyAppOptions = a.a().d();
                    adColonyAppOptions.e();
                    JSONObject jSONObject = adColonyAppOptions.d();
                    JSONObject jSONObject2 = w.a();
                    w.a(jSONObject, "os_name", "android");
                    aw aw2 = new aw(context, 1, false);
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(a.a().n().g());
                    stringBuilder.append("7bf3a1e7bbd31e612eda3310c2cdb8075c43c6b5");
                    w.a(jSONObject2, "filepath", stringBuilder.toString());
                    w.a(jSONObject2, "info", jSONObject);
                    w.b(jSONObject2, "m_origin", 0);
                    w.b(jSONObject2, "m_id", ae.a(ae.this));
                    w.a(jSONObject2, "m_type", "Controller.create");
                    ad ad2 = new ad(jSONObject2);
                    aw2.a(true, ad2);
                }
            });
        }
    }

    void a(String string, af af2) {
        ArrayList arrayList = (ArrayList)this.d.get((Object)string);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.d.put((Object)string, (Object)arrayList);
        }
        arrayList.add((Object)af2);
    }

    /*
     * Exception decompiling
     */
    void a(String var1_1, JSONObject var2_2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 4[CATCHBLOCK]
        // org.benf.cfr.reader.b.a.a.j.a(Op04StructuredStatement.java:432)
        // org.benf.cfr.reader.b.a.a.j.d(Op04StructuredStatement.java:484)
        // org.benf.cfr.reader.b.a.a.i.a(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:692)
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
    void a(JSONObject var1_1) {
        try {
            if (!var1_1.has("m_id")) {
                var8_2 = this.f;
                this.f = var8_2 + 1;
                var1_1.put("m_id", var8_2);
            }
            if (!var1_1.has("m_origin")) {
                var1_1.put("m_origin", 0);
            }
            if ((var3_3 = var1_1.getInt("m_target")) != 0) ** GOTO lbl-1000
            var10_4 = this;
            // MONITORENTER : var10_4
        }
        catch (JSONException var2_6) {
            new y.a().a("JSON error in ADCMessageDispatcher's sendMessage(): ").a(var2_6.toString()).a(y.h);
        }
        this.e.put((Object)var1_1);
        // MONITOREXIT : var10_4
        return;
lbl-1000: // 1 sources:
        {
            var6_5 = (ag)this.b.get((Object)var3_3);
            if (var6_5 == null) return;
            var6_5.a(var1_1);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    void b() {
        block15 : {
            ArrayList<ag> arrayList;
            ae ae2 = this;
            // MONITORENTER : ae2
            ArrayList<ag> arrayList2 = arrayList = this.a;
            // MONITORENTER : arrayList2
            for (int i2 = -1 + this.a.size(); i2 >= 0; --i2) {
                ((ag)this.a.get(i2)).c();
            }
            // MONITOREXIT : arrayList2
            int n2 = this.e.length();
            JSONArray jSONArray = null;
            if (n2 > 0) {
                jSONArray = this.e;
                this.e = w.b();
            }
            if (jSONArray == null) break block15;
            int n3 = jSONArray.length();
            for (int i3 = 0; i3 < n3; ++i3) {
                try {
                    final JSONObject jSONObject = jSONArray.getJSONObject(i3);
                    final String string = jSONObject.getString("m_type");
                    if (jSONObject.getInt("m_origin") >= 2) {
                        au.a(new Runnable(){

                            public void run() {
                                ae.this.a(string, jSONObject);
                            }
                        });
                        continue;
                    }
                    this.a(string, jSONObject);
                    continue;
                }
                catch (JSONException jSONException) {
                    new y.a().a("JSON error from message dispatcher's updateModules(): ").a(jSONException.toString()).a(y.h);
                }
            }
        }
        // MONITOREXIT : ae2
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    void b(String string, af af2) {
        HashMap<String, ArrayList<af>> hashMap;
        HashMap<String, ArrayList<af>> hashMap2 = hashMap = this.d;
        synchronized (hashMap2) {
            ArrayList arrayList = (ArrayList)this.d.get((Object)string);
            if (arrayList != null) {
                arrayList.remove((Object)af2);
            }
            return;
        }
    }

    ArrayList<ag> c() {
        return this.a;
    }

    int d() {
        int n2 = this.c;
        this.c = n2 + 1;
        return n2;
    }

    HashMap<Integer, ag> e() {
        return this.b;
    }

}

