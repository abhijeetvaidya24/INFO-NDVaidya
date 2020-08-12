/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.applovin.impl.sdk.c;

import android.text.TextUtils;
import com.applovin.impl.sdk.b.b;
import com.applovin.impl.sdk.b.d;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class f {
    private final List<a> a;
    private final Object b = new Object();
    private final j c;
    private final p d;

    public f(j j2) {
        this.c = j2;
        this.d = j2.u();
        this.a = new ArrayList();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private void d() {
        Object object;
        JSONArray jSONArray = new JSONArray();
        Object object2 = object = this.b;
        // MONITORENTER : object2
        for (a a2 : this.a) {
            try {
                jSONArray.put((Object)a2.a());
            }
            catch (JSONException jSONException) {
                this.d.a("ErrorManager", false, "Failed to convert error log into json.", jSONException);
                this.a.remove((Object)a2);
            }
        }
        // MONITOREXIT : object2
        {
            catch (Throwable throwable) {}
            {
                // MONITOREXIT : object2
                throw throwable;
            }
        }
        this.c.a(d.i, jSONArray.toString());
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public JSONArray a() {
        Object object;
        Object object2 = object = this.b;
        synchronized (object2) {
            JSONArray jSONArray = new JSONArray();
            Iterator iterator = this.a.iterator();
            while (iterator.hasNext()) {
                a a2 = (a)iterator.next();
                try {
                    jSONArray.put((Object)a2.a());
                }
                catch (JSONException jSONException) {
                    this.d.a("ErrorManager", false, "Failed to convert error log into json.", jSONException);
                }
            }
            return jSONArray;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(String string2, Throwable throwable) {
        Object object;
        if (TextUtils.isEmpty((CharSequence)string2)) {
            return;
        }
        Object object2 = object = this.b;
        synchronized (object2) {
            if (this.a.size() >= this.c.a(b.eK)) {
                return;
            }
            a a2 = new a(string2, throwable);
            this.a.add((Object)a2);
            this.d();
            return;
        }
    }

    /*
     * Exception decompiling
     */
    public void b() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 8[CATCHBLOCK]
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
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void c() {
        Object object;
        Object object2 = object = this.b;
        synchronized (object2) {
            this.a.clear();
            this.c.b(d.i);
            return;
        }
    }

    private static class a {
        private final Long a;
        private final String b;
        private final String c;
        private final String d;

        private a(String string2, Throwable throwable) {
            this.b = string2;
            this.a = System.currentTimeMillis();
            String string3 = throwable != null ? throwable.getClass().getName() : null;
            this.c = string3;
            String string4 = null;
            if (throwable != null) {
                string4 = throwable.getMessage();
            }
            this.d = string4;
        }

        private a(JSONObject jSONObject) throws JSONException {
            this.b = jSONObject.getString("ms");
            this.a = jSONObject.getLong("ts");
            JSONObject jSONObject2 = jSONObject.optJSONObject("ex");
            String string2 = jSONObject2 != null ? jSONObject2.getString("nm") : null;
            this.c = string2;
            String string3 = null;
            if (jSONObject2 != null) {
                string3 = jSONObject2.getString("rn");
            }
            this.d = string3;
        }

        private JSONObject a() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ms", (Object)this.b);
            jSONObject.put("ts", (Object)this.a);
            if (!TextUtils.isEmpty((CharSequence)this.c)) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("nm", (Object)this.c);
                if (!TextUtils.isEmpty((CharSequence)this.d)) {
                    jSONObject2.put("rn", (Object)this.d);
                }
                jSONObject.put("ex", (Object)jSONObject2);
            }
            return jSONObject;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ErrorLog{timestampMillis=");
            stringBuilder.append((Object)this.a);
            stringBuilder.append(",message='");
            stringBuilder.append(this.b);
            stringBuilder.append('\'');
            stringBuilder.append(",throwableName='");
            stringBuilder.append(this.c);
            stringBuilder.append('\'');
            stringBuilder.append(",throwableReason='");
            stringBuilder.append(this.d);
            stringBuilder.append('\'');
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

}

