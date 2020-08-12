/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.tapjoy.TapjoyLog
 *  com.tapjoy.TapjoyUtil
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.tapjoy;

import com.tapjoy.TapjoyLog;
import com.tapjoy.TapjoyUtil;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class TapjoyCachedAssetData
implements Serializable {
    private long a;
    private long b;
    private String c;
    private String d;
    private String e;
    private long f;
    private String g;
    private String h;

    public TapjoyCachedAssetData(String string, String string2, long l2) {
        this(string, string2, l2, System.currentTimeMillis() / 1000L);
    }

    public TapjoyCachedAssetData(String string, String string2, long l2, long l3) {
        this.setAssetURL(string);
        this.setLocalFilePath(string2);
        this.b = l2;
        this.a = l3;
        this.f = l3 + l2;
    }

    /*
     * Exception decompiling
     */
    public static TapjoyCachedAssetData fromJSONObject(JSONObject var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl36 : LDC : trying to set 1 previously set to 0
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

    public static TapjoyCachedAssetData fromRawJSONString(String string) {
        try {
            TapjoyCachedAssetData tapjoyCachedAssetData = TapjoyCachedAssetData.fromJSONObject(new JSONObject(string));
            return tapjoyCachedAssetData;
        }
        catch (JSONException jSONException) {
            TapjoyLog.i((String)"TapjoyCachedAssetData", (String)"Can not build TapjoyVideoObject -- error reading json string");
            return null;
        }
    }

    public String getAssetURL() {
        return this.c;
    }

    public String getLocalFilePath() {
        return this.d;
    }

    public String getLocalURL() {
        return this.e;
    }

    public String getMimeType() {
        return this.g;
    }

    public String getOfferId() {
        return this.h;
    }

    public long getTimeOfDeathInSeconds() {
        return this.f;
    }

    public long getTimeToLiveInSeconds() {
        return this.b;
    }

    public long getTimestampInSeconds() {
        return this.a;
    }

    public void resetTimeToLive(long l2) {
        this.b = l2;
        this.f = l2 + System.currentTimeMillis() / 1000L;
    }

    public void setAssetURL(String string) {
        this.c = string;
        this.g = TapjoyUtil.determineMimeType((String)string);
    }

    public void setLocalFilePath(String string) {
        this.d = string;
        StringBuilder stringBuilder = new StringBuilder("file://");
        stringBuilder.append(string);
        this.e = stringBuilder.toString();
    }

    public void setOfferID(String string) {
        this.h = string;
    }

    public JSONObject toJSON() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        try {
            jSONObject.put("timestamp", this.getTimestampInSeconds());
            jSONObject.put("timeToLive", this.getTimeToLiveInSeconds());
            jSONObject.put("assetURL", (Object)this.getAssetURL());
            jSONObject.put("localFilePath", (Object)this.getLocalFilePath());
            jSONObject.put("offerID", (Object)this.getOfferId());
        }
        catch (JSONException jSONException) {}
        return jSONObject;
    }

    public String toRawJSONString() {
        return this.toJSON().toString();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nURL=");
        stringBuilder.append(this.e);
        stringBuilder.append("\n");
        stringBuilder.append("AssetURL=");
        stringBuilder.append(this.c);
        stringBuilder.append("\n");
        stringBuilder.append("MimeType=");
        stringBuilder.append(this.g);
        stringBuilder.append("\n");
        stringBuilder.append("Timestamp=");
        stringBuilder.append(this.getTimestampInSeconds());
        stringBuilder.append("\n");
        stringBuilder.append("TimeOfDeath=");
        stringBuilder.append(this.f);
        stringBuilder.append("\n");
        stringBuilder.append("TimeToLive=");
        stringBuilder.append(this.b);
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}

