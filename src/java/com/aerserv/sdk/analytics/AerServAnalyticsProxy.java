/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.util.Collection
 *  java.util.Iterator
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.aerserv.sdk.analytics;

import com.aerserv.sdk.AerServSettings;
import com.aerserv.sdk.analytics.AerServAnalyticsEvent;
import com.aerserv.sdk.utils.AerServLog;
import java.util.Collection;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class AerServAnalyticsProxy {
    private static final String SERVER_URL = "https://debug.aerserv.com/sybok/analytics";

    public static void send(Collection<AerServAnalyticsEvent> collection) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            Iterator iterator = collection.iterator();
            while (iterator.hasNext()) {
                stringBuilder.append((Object)((AerServAnalyticsEvent)iterator.next()).toJson());
                stringBuilder.append("\n");
            }
            final JSONObject jSONObject = new JSONObject();
            jSONObject.put("application", (Object)"Android SDK");
            jSONObject.put("version", (Object)"3.1.1");
            if (AerServSettings.getApplicationId() != null) {
                jSONObject.put("applicationId", (Object)AerServSettings.getApplicationId());
            }
            if (AerServSettings.getSiteId() != null) {
                jSONObject.put("siteId", (Object)AerServSettings.getSiteId());
            }
            jSONObject.put("events", (Object)stringBuilder.toString());
            new Thread(new Runnable(){

                public void run() {
                    AerServAnalyticsProxy.sendByHttp(AerServAnalyticsProxy.SERVER_URL, jSONObject.toString());
                }
            }).start();
            return;
        }
        catch (JSONException jSONException) {
            AerServLog.e(AerServAnalyticsProxy.class.getSimpleName(), "Error converting analytics data to JSON");
            return;
        }
    }

    /*
     * Exception decompiling
     */
    private static void sendByHttp(String var0, String var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl50 : ALOAD_3 : trying to set 1 previously set to 0
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

