/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.ironsource.mediationsdk.events;

import android.text.TextUtils;
import com.ironsource.eventsmodule.EventData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

abstract class AbstractEventsFormatter {
    private final String EVENTS_KEY_DEFAULT = "events";
    private final String EVENTS_KEY_IS = "InterstitialEvents";
    private final String EVENTS_KEY_RV = "events";
    private final String KEY_AD_UNIT = "adUnit";
    private final String KEY_EVENT_ID = "eventId";
    private final String KEY_TIMESTAMP = "timestamp";
    int mAdUnit;
    JSONObject mGeneralProperties;
    private String mServerUrl;

    AbstractEventsFormatter() {
    }

    private String getEventsKey(int n2) {
        if (n2 != 2) {
            if (n2 != 3) {
                // empty if block
            }
            return "events";
        }
        return "InterstitialEvents";
    }

    /*
     * Exception decompiling
     */
    String createDataToSend(JSONArray var1) {
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

    JSONObject createJSONForEvent(EventData eventData) {
        try {
            JSONObject jSONObject = new JSONObject(eventData.getAdditionalData());
            jSONObject.put("eventId", eventData.getEventId());
            jSONObject.put("timestamp", eventData.getTimeStamp());
            return jSONObject;
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
            return null;
        }
    }

    public abstract String format(ArrayList<EventData> var1, JSONObject var2);

    protected abstract String getDefaultEventsUrl();

    String getEventsServerUrl() {
        if (TextUtils.isEmpty((CharSequence)this.mServerUrl)) {
            return this.getDefaultEventsUrl();
        }
        return this.mServerUrl;
    }

    public abstract String getFormatterType();

    void setEventsServerUrl(String string) {
        this.mServerUrl = string;
    }
}

