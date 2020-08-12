/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  java.io.Serializable
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Map
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.aerserv.sdk.model;

import android.text.TextUtils;
import com.aerserv.sdk.AerServConfig;
import com.aerserv.sdk.AerServEvent;
import com.aerserv.sdk.AerServVirtualCurrency;
import com.aerserv.sdk.analytics.AerServAnalytics;
import com.aerserv.sdk.analytics.AerServAnalyticsUtils;
import com.aerserv.sdk.utils.AerServLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Placement
implements Serializable {
    private static final String LOG_TAG = "com.aerserv.sdk.model.Placement";
    private String adMarkup = "";
    private int asplcid = 0;
    private Integer bannerRefresh = null;
    private long budgetResetTimeSec = 0L;
    private String closeOffset = "";
    private String contentType = "";
    private String endCardMarkup = "";
    private int errorCode = 0;
    private Map<AerServEvent, List<String>> extImpressionEvents = new HashMap();
    private List<Placement> failoverPlacementList = new ArrayList();
    private boolean isMoatEnabled = false;
    private String mediaFile = "";
    private Map<AerServEvent, List<String>> metricsEvents = new HashMap();
    private String sdkBaseEventUrl = null;
    private Long showAdTimeout = null;
    private boolean startAdMuted = false;
    private Map<AerServEvent, List<String>> trackingEvents = new HashMap();
    private AerServVirtualCurrency vc = new AerServVirtualCurrency();
    private String videoClickThruUrl = "";

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private Placement(JSONObject var1_1) {
        super();
        var3_2 = AerServAnalyticsUtils.findValueInUrl(var1_1.toString(), "rid");
        AerServAnalytics.getInstance().setRid(var3_2);
        this.adMarkup = Placement.getStringSafe(var1_1, "adMarkup");
        this.contentType = Placement.getStringSafe(var1_1, "contentType");
        this.trackingEvents = this.buildTrackingEvents(var1_1);
        this.bannerRefresh = this.buildBannerRefresh(var1_1);
        this.closeOffset = Placement.getStringSafe(var1_1, "closeOffset");
        this.errorCode = var1_1.optInt("errorCode");
        this.budgetResetTimeSec = var1_1.optLong("budgetResetTime");
        this.isMoatEnabled = var1_1.optBoolean("isMoatEnabled", false);
        var4_3 = var1_1.optInt("wantsMute", 0) != 0;
        this.startAdMuted = var4_3;
        this.parseEndCardParams();
        this.metricsEvents = Placement.parseMetricsEvents(var1_1);
        this.extImpressionEvents = this.parseExtImpressionEvents(var1_1);
        var5_4 = var1_1.has("showTimeout");
        if (!var5_4) ** GOTO lbl52
        {
            catch (JSONException var2_8) {
                AerServLog.w(Placement.LOG_TAG, "Error while parsing adserver json", (Exception)var2_8);
                return;
            }
        }
        try {
            this.showAdTimeout = var1_1.getLong("showTimeout");
            ** GOTO lbl52
        }
        catch (JSONException var6_5) {
            var7_6 = Placement.LOG_TAG;
            var8_7 = new StringBuilder();
            var8_7.append("Error parsing showTimeout from ad response: ");
            var8_7.append(var6_5.getMessage());
            AerServLog.w(var7_6, var8_7.toString());
lbl52: // 3 sources:
            this.asplcid = var1_1.optInt("asplcid", 0);
            this.sdkBaseEventUrl = Placement.getStringSafe(var1_1, "baseEventUrl");
            return;
        }
    }

    private Integer buildBannerRefresh(JSONObject jSONObject) {
        try {
            Integer n2 = jSONObject.getInt("bannerRefresh");
            return n2;
        }
        catch (Exception exception) {
            return null;
        }
    }

    /*
     * Exception decompiling
     */
    private Map<AerServEvent, List<String>> buildTrackingEvents(JSONObject var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl62.1 : ALOAD_2 : trying to set 1 previously set to 0
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

    private static AerServVirtualCurrency buildVirtualCurrency(JSONObject jSONObject) {
        return new AerServVirtualCurrency(jSONObject);
    }

    private static String getStringSafe(JSONObject jSONObject, String string) {
        try {
            String string2 = jSONObject.getString(string);
            return string2;
        }
        catch (Exception exception) {
            return "";
        }
    }

    /*
     * Exception decompiling
     */
    private void parseEndCardParams() throws JSONException {
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
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private Map<AerServEvent, List<String>> parseExtImpressionEvents(JSONObject jSONObject) {
        JSONObject jSONObject2;
        HashMap hashMap = new HashMap();
        if (!jSONObject.has("extImpressionEvents") || !(jSONObject2 = jSONObject.getJSONObject("extImpressionEvents")).has("bitMapEvents")) return hashMap;
        JSONArray jSONArray = jSONObject2.getJSONArray("bitMapEvents");
        ArrayList arrayList = new ArrayList();
        int n2 = 0;
        do {
            if (n2 >= jSONArray.length()) break;
            arrayList.add((Object)jSONArray.optString(n2, ""));
            ++n2;
        } while (true);
        try {
            hashMap.put((Object)AerServEvent.AD_IMPRESSION, (Object)arrayList);
            return hashMap;
        }
        catch (Exception exception) {
            AerServLog.i(LOG_TAG, "Error parsing ext impression events", exception);
        }
        return hashMap;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static Map<AerServEvent, List<String>> parseMetricsEvents(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        if (!jSONObject.has("metrics")) return hashMap;
        JSONObject jSONObject2 = jSONObject.getJSONObject("metrics");
        AerServEvent aerServEvent = (AerServEvent)((Object)AerServEvent.translate.get((Object)"preloadUrl"));
        AerServEvent aerServEvent2 = (AerServEvent)((Object)AerServEvent.translate.get((Object)"showAttemptUrl"));
        if (aerServEvent == null || aerServEvent2 == null) return hashMap;
        try {
            if (jSONObject2.has("preloadUrl")) {
                Object[] arrobject = new String[]{jSONObject2.getString("preloadUrl")};
                hashMap.put((Object)aerServEvent, (Object)new ArrayList((Collection)Arrays.asList((Object[])arrobject)));
            }
            if (!jSONObject2.has("showAttemptUrl")) return hashMap;
            Object[] arrobject = new String[]{jSONObject2.getString("showAttemptUrl")};
            hashMap.put((Object)aerServEvent2, (Object)new ArrayList((Collection)Arrays.asList((Object[])arrobject)));
            return hashMap;
        }
        catch (Exception exception) {
            AerServLog.i(LOG_TAG, "Error parsing metrics events", exception);
        }
        return hashMap;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Placement parsePlacement(String string, boolean bl) {
        Placement placement;
        block7 : {
            Placement placement2;
            JSONArray jSONArray;
            JSONObject jSONObject;
            try {
                boolean bl2 = TextUtils.isEmpty((CharSequence)string);
                if (bl2) {
                    string = "{}";
                }
                jSONObject = new JSONObject(string);
                jSONArray = jSONObject.optJSONArray("ads");
                placement = null;
                if (jSONArray == null) break block7;
                int n2 = jSONArray.length();
                placement = null;
                if (n2 <= 0) break block7;
                placement2 = null;
            }
            catch (Exception exception) {
                AerServLog.w(LOG_TAG, "Error while parsing adserver json", exception);
                return new Placement(new JSONObject());
            }
            for (int i2 = 0; i2 < jSONArray.length(); ++i2) {
                JSONObject jSONObject2 = jSONArray.optJSONObject(i2);
                Placement placement3 = new Placement(jSONObject2);
                AerServVirtualCurrency aerServVirtualCurrency = Placement.buildVirtualCurrency(jSONObject);
                aerServVirtualCurrency.updateTransactionInformation(jSONObject2.optJSONObject("transaction"));
                placement3.setVc(aerServVirtualCurrency);
                if (bl && placement3.getAsplcid() > 0) continue;
                if (placement2 == null) {
                    placement3.metricsEvents = Placement.parseMetricsEvents(jSONObject);
                    placement3.closeOffset = Placement.getStringSafe(jSONObject, "closeOffset");
                    boolean bl3 = jSONObject.optBoolean("testMode", false);
                    if (bl3) {
                        AerServLog.v(LOG_TAG, "Setting test mode on");
                        AerServConfig.setTestMode(bl3);
                    }
                } else {
                    placement3.metricsEvents = placement2.metricsEvents;
                    placement3.closeOffset = placement2.closeOffset;
                    placement2.failoverPlacementList.add((Object)placement3);
                    continue;
                }
                placement2 = placement3;
            }
            placement = placement2;
        }
        if (placement != null) return placement;
        return new Placement(new JSONObject("{}"));
    }

    public String getAdMarkup() {
        return this.adMarkup;
    }

    public int getAsplcid() {
        return this.asplcid;
    }

    public Integer getBannerRefresh() {
        return this.bannerRefresh;
    }

    public long getBudgetResetTimeSec() {
        return this.budgetResetTimeSec;
    }

    public String getCloseOffset() {
        return this.closeOffset;
    }

    public String getContentType() {
        return this.contentType;
    }

    public String getEndCardMarkup() {
        return this.endCardMarkup;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public Map<AerServEvent, List<String>> getExtImpressionEvents() {
        return this.extImpressionEvents;
    }

    public List<Placement> getFailoverPlacementList() {
        return this.failoverPlacementList;
    }

    public String getMediaFile() {
        return this.mediaFile;
    }

    public Map<AerServEvent, List<String>> getMetricsEvents() {
        return this.metricsEvents;
    }

    public Placement getNextFallback() {
        List<Placement> list = this.failoverPlacementList;
        if (list != null && list.size() != 0) {
            return (Placement)this.failoverPlacementList.remove(0);
        }
        return null;
    }

    public String getSdkBaseEventUrl() {
        return this.sdkBaseEventUrl;
    }

    public Long getShowAdTimeout() {
        return this.showAdTimeout;
    }

    public boolean getStartAdMuted() {
        return this.startAdMuted;
    }

    public Map<AerServEvent, List<String>> getTrackingEvents() {
        return this.trackingEvents;
    }

    public AerServVirtualCurrency getVc() {
        return this.vc;
    }

    public String getVideoClickThruUrl() {
        return this.videoClickThruUrl;
    }

    public boolean isMoatEnabled() {
        return this.isMoatEnabled;
    }

    public void setVc(AerServVirtualCurrency aerServVirtualCurrency) {
        this.vc = aerServVirtualCurrency;
    }
}

