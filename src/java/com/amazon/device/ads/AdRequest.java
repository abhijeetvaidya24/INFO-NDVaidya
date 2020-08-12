/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  com.amazon.device.ads.AAXParameter$PublisherKeywordsParameter
 *  com.amazon.device.ads.AAXParameterGroup$PublisherExtraParametersAAXParameterGroup
 *  com.amazon.device.ads.AAXParameterGroup$UserIdAAXParameterGroup
 *  com.amazon.device.ads.MobileAdsLogger
 *  java.lang.Boolean
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.amazon.device.ads;

import android.annotation.SuppressLint;
import com.amazon.device.ads.AAXParameter;
import com.amazon.device.ads.AAXParameterGroup;
import com.amazon.device.ads.AdSlot;
import com.amazon.device.ads.AdTargetingOptions;
import com.amazon.device.ads.AdvertisingIdentifier;
import com.amazon.device.ads.Configuration;
import com.amazon.device.ads.ConnectionInfo;
import com.amazon.device.ads.DebugProperties;
import com.amazon.device.ads.DeviceInfo;
import com.amazon.device.ads.JSONUtils;
import com.amazon.device.ads.Metrics;
import com.amazon.device.ads.MetricsCollector;
import com.amazon.device.ads.MobileAdsInfoStore;
import com.amazon.device.ads.MobileAdsLogger;
import com.amazon.device.ads.MobileAdsLoggerFactory;
import com.amazon.device.ads.StringUtils;
import com.amazon.device.ads.WebRequest;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

class AdRequest {
    private static final String LOGTAG = "AdRequest";
    private static final AAXParameter<?>[] PARAMETERS;
    private static final AAXParameterGroup[] PARAMETER_GROUPS;
    private AdvertisingIdentifier.Info advertisingIdentifierInfo;
    private final Configuration configuration;
    private final ConnectionInfo connectionInfo;
    private final DebugProperties debugProperties;
    private String instrPixelUrl;
    private final JSONObjectBuilder jsonObjectBuilder;
    private final JSONUtils.JSONUtilities jsonUtilities;
    private final MobileAdsLogger logger;
    private final AdTargetingOptions opt;
    private final String orientation;
    protected final Map<Integer, LOISlot> slots;
    private final WebRequest.WebRequestFactory webRequestFactory;

    static {
        AAXParameter[] arraAXParameter = new AAXParameter[]{AAXParameter.APP_KEY, AAXParameter.CHANNEL, AAXParameter.PUBLISHER_KEYWORDS, AAXParameter.PUBLISHER_ASINS, AAXParameter.USER_AGENT, AAXParameter.SDK_VERSION, AAXParameter.GEOLOCATION, AAXParameter.DEVICE_INFO, AAXParameter.PACKAGE_INFO, AAXParameter.TEST, AAXParameter.OPT_OUT};
        PARAMETERS = arraAXParameter;
        AAXParameterGroup[] arraAXParameterGroup = new AAXParameterGroup[]{AAXParameterGroup.USER_ID, AAXParameterGroup.PUBLISHER_EXTRA_PARAMETERS};
        PARAMETER_GROUPS = arraAXParameterGroup;
    }

    public AdRequest(AdTargetingOptions adTargetingOptions) {
        this(adTargetingOptions, new WebRequest.WebRequestFactory(), MobileAdsInfoStore.getInstance(), Configuration.getInstance(), DebugProperties.getInstance(), new MobileAdsLoggerFactory(), new JSONUtils.JSONUtilities(), new ConnectionInfo(MobileAdsInfoStore.getInstance()));
    }

    @SuppressLint(value={"UseSparseArrays"})
    AdRequest(AdTargetingOptions adTargetingOptions, WebRequest.WebRequestFactory webRequestFactory, MobileAdsInfoStore mobileAdsInfoStore, Configuration configuration, DebugProperties debugProperties, MobileAdsLoggerFactory mobileAdsLoggerFactory, JSONUtils.JSONUtilities jSONUtilities, ConnectionInfo connectionInfo) {
        JSONObject jSONObject;
        this.opt = adTargetingOptions;
        this.webRequestFactory = webRequestFactory;
        this.jsonUtilities = jSONUtilities;
        this.slots = new HashMap();
        this.orientation = mobileAdsInfoStore.getDeviceInfo().getOrientation();
        this.connectionInfo = connectionInfo;
        this.configuration = configuration;
        this.debugProperties = debugProperties;
        this.logger = mobileAdsLoggerFactory.createMobileAdsLogger(LOGTAG);
        HashMap<String, String> hashMap = this.opt.getCopyOfAdvancedOptions();
        if (this.debugProperties.containsDebugProperty("debug.advTargeting") && (jSONObject = this.debugProperties.getDebugPropertyAsJSONObject("debug.advTargeting", null)) != null) {
            hashMap.putAll(this.jsonUtilities.createMapFromJSON(jSONObject));
        }
        AAXParameter.ParameterData parameterData = new AAXParameter.ParameterData().setAdTargetingOptions(this.opt).setAdvancedOptions((Map<String, String>)hashMap).setAdRequest(this);
        this.jsonObjectBuilder = new JSONObjectBuilder(this.logger).setAAXParameters(PARAMETERS).setAAXParameterGroups(PARAMETER_GROUPS).setAdvancedOptions((Map<String, String>)hashMap).setParameterData(parameterData);
    }

    private boolean isSSLRequired() {
        boolean bl = Configuration.getInstance().getBoolean(Configuration.ConfigOption.SEND_GEO);
        return !Configuration.getInstance().getBoolean(Configuration.ConfigOption.TRUNCATE_LAT_LON) && bl && this.getAdTargetingOptions().isGeoLocationEnabled();
    }

    AdTargetingOptions getAdTargetingOptions() {
        return this.opt;
    }

    AdvertisingIdentifier.Info getAdvertisingIdentifierInfo() {
        return this.advertisingIdentifierInfo;
    }

    public String getInstrumentationPixelURL() {
        return this.instrPixelUrl;
    }

    String getOrientation() {
        return this.orientation;
    }

    protected JSONArray getSlots() {
        JSONArray jSONArray = new JSONArray();
        Iterator iterator = this.slots.values().iterator();
        while (iterator.hasNext()) {
            jSONArray.put((Object)((LOISlot)iterator.next()).getJSON());
        }
        return jSONArray;
    }

    public WebRequest getWebRequest() {
        WebRequest webRequest = this.webRequestFactory.createWebRequest();
        boolean bl = this.isSSLRequired() || webRequest.getUseSecure();
        webRequest.setUseSecure(bl);
        webRequest.setExternalLogTag(LOGTAG);
        webRequest.setHttpMethod(WebRequest.HttpMethod.POST);
        webRequest.setHost(this.configuration.getString(Configuration.ConfigOption.AAX_HOSTNAME));
        webRequest.setPath(this.configuration.getString(Configuration.ConfigOption.AD_RESOURCE_PATH));
        webRequest.enableLog(true);
        webRequest.setContentType("application/json");
        webRequest.setDisconnectEnabled(false);
        this.setParametersInWebRequest(webRequest);
        return webRequest;
    }

    public void putSlot(AdSlot adSlot) {
        if (this.getAdvertisingIdentifierInfo().hasSISDeviceIdentifier()) {
            adSlot.getMetricsCollector().incrementMetric(Metrics.MetricType.AD_COUNTER_IDENTIFIED_DEVICE);
        }
        adSlot.setConnectionInfo(this.connectionInfo);
        LOISlot lOISlot = new LOISlot(adSlot, this, this.logger);
        this.slots.put((Object)adSlot.getSlotNumber(), (Object)lOISlot);
    }

    AdRequest setAdvertisingIdentifierInfo(AdvertisingIdentifier.Info info) {
        this.advertisingIdentifierInfo = info;
        return this;
    }

    public void setInstrumentationPixelURL(String string) {
        this.instrPixelUrl = string;
    }

    protected void setParametersInWebRequest(WebRequest webRequest) {
        this.jsonObjectBuilder.build();
        JSONArray jSONArray = AAXParameter.SLOTS.getValue(this.jsonObjectBuilder.getParameterData());
        if (jSONArray == null) {
            jSONArray = this.getSlots();
        }
        this.jsonObjectBuilder.putIntoJSON(AAXParameter.SLOTS, (Object)jSONArray);
        JSONObject jSONObject = this.jsonObjectBuilder.getJSON();
        String string = this.debugProperties.getDebugPropertyAsString("debug.aaxAdParams", null);
        if (!StringUtils.isNullOrEmpty(string)) {
            webRequest.setAdditionalQueryParamsString(string);
        }
        this.setRequestBodyString(webRequest, jSONObject);
    }

    protected void setRequestBodyString(WebRequest webRequest, JSONObject jSONObject) {
        webRequest.setRequestBodyString(jSONObject.toString());
    }

    static class AdRequestBuilder {
        private AdTargetingOptions adTargetingOptions;
        private AdvertisingIdentifier.Info advertisingIdentifierInfo;

        AdRequestBuilder() {
        }

        public AdRequest build() {
            return new AdRequest(this.adTargetingOptions).setAdvertisingIdentifierInfo(this.advertisingIdentifierInfo);
        }

        public AdRequestBuilder withAdTargetingOptions(AdTargetingOptions adTargetingOptions) {
            this.adTargetingOptions = adTargetingOptions;
            return this;
        }

        public AdRequestBuilder withAdvertisingIdentifierInfo(AdvertisingIdentifier.Info info) {
            this.advertisingIdentifierInfo = info;
            return this;
        }
    }

    static class JSONObjectBuilder {
        private AAXParameterGroup[] aaxParameterGroups;
        private AAXParameter<?>[] aaxParameters;
        private Map<String, String> advancedOptions;
        private final JSONObject json;
        private final MobileAdsLogger logger;
        private AAXParameter.ParameterData parameterData;

        JSONObjectBuilder(MobileAdsLogger mobileAdsLogger) {
            this(mobileAdsLogger, new JSONObject());
        }

        JSONObjectBuilder(MobileAdsLogger mobileAdsLogger, JSONObject jSONObject) {
            this.logger = mobileAdsLogger;
            this.json = jSONObject;
        }

        void build() {
            AAXParameterGroup[] arraAXParameterGroup = this.aaxParameterGroups;
            int n = 0;
            if (arraAXParameterGroup != null) {
                int n2 = arraAXParameterGroup.length;
                for (int i2 = 0; i2 < n2; ++i2) {
                    arraAXParameterGroup[i2].evaluate(this.parameterData, this.json);
                }
            }
            AAXParameter<?>[] arraAXParameter = this.aaxParameters;
            int n3 = arraAXParameter.length;
            while (n < n3) {
                AAXParameter<?> aAXParameter = arraAXParameter[n];
                this.putIntoJSON(aAXParameter, aAXParameter.getValue(this.parameterData));
                ++n;
            }
            Map<String, String> map = this.advancedOptions;
            if (map != null) {
                for (Map.Entry entry : map.entrySet()) {
                    if (StringUtils.isNullOrWhiteSpace((String)entry.getValue())) continue;
                    this.putIntoJSON((String)entry.getKey(), entry.getValue());
                }
            }
        }

        JSONObject getJSON() {
            return this.json;
        }

        AAXParameter.ParameterData getParameterData() {
            return this.parameterData;
        }

        void putIntoJSON(AAXParameter<?> aAXParameter, Object object) {
            this.putIntoJSON(aAXParameter.getName(), object);
        }

        /*
         * Exception decompiling
         */
        void putIntoJSON(String var1, Object var2) {
            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
            // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl24 : RETURN : trying to set 0 previously set to 1
            // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
            // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
            // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
            // org.benf.cfr.reader.entities.g.p(Method.java:396)
            // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
            // org.benf.cfr.reader.entities.d.c(ClassFile.java:773)
            // org.benf.cfr.reader.entities.d.e(ClassFile.java:870)
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

        JSONObjectBuilder setAAXParameterGroups(AAXParameterGroup[] arraAXParameterGroup) {
            this.aaxParameterGroups = arraAXParameterGroup;
            return this;
        }

        JSONObjectBuilder setAAXParameters(AAXParameter<?>[] arraAXParameter) {
            this.aaxParameters = arraAXParameter;
            return this;
        }

        JSONObjectBuilder setAdvancedOptions(Map<String, String> map) {
            this.advancedOptions = map;
            return this;
        }

        JSONObjectBuilder setParameterData(AAXParameter.ParameterData parameterData) {
            this.parameterData = parameterData;
            return this;
        }
    }

    static class LOISlot {
        static final AAXParameter<?>[] PARAMETERS;
        private final AdSlot adSlot;
        private final DebugProperties debugProperties;
        private final JSONObjectBuilder jsonObjectBuilder;
        private final JSONUtils.JSONUtilities jsonUtilities;
        private final AdTargetingOptions opt;

        static {
            AAXParameter[] arraAXParameter = new AAXParameter[]{AAXParameter.SIZE, AAXParameter.PAGE_TYPE, AAXParameter.SLOT, AAXParameter.SLOT_POSITION, AAXParameter.MAX_SIZE, AAXParameter.SLOT_ID, AAXParameter.FLOOR_PRICE, AAXParameter.SUPPORTED_MEDIA_TYPES, AAXParameter.VIDEO_OPTIONS};
            PARAMETERS = arraAXParameter;
        }

        LOISlot(AdSlot adSlot, AdRequest adRequest, MobileAdsLogger mobileAdsLogger) {
            this(adSlot, adRequest, mobileAdsLogger, new JSONObjectBuilder(mobileAdsLogger), DebugProperties.getInstance(), new JSONUtils.JSONUtilities());
        }

        LOISlot(AdSlot adSlot, AdRequest adRequest, MobileAdsLogger mobileAdsLogger, JSONObjectBuilder jSONObjectBuilder, DebugProperties debugProperties, JSONUtils.JSONUtilities jSONUtilities) {
            JSONObject jSONObject;
            this.opt = adSlot.getAdTargetingOptions();
            this.adSlot = adSlot;
            this.debugProperties = debugProperties;
            this.jsonUtilities = jSONUtilities;
            HashMap<String, String> hashMap = this.opt.getCopyOfAdvancedOptions();
            if (this.debugProperties.containsDebugProperty("debug.advTargeting") && (jSONObject = this.debugProperties.getDebugPropertyAsJSONObject("debug.advTargeting", null)) != null) {
                hashMap.putAll(this.jsonUtilities.createMapFromJSON(jSONObject));
            }
            AAXParameter.ParameterData parameterData = new AAXParameter.ParameterData().setAdTargetingOptions(this.opt).setAdvancedOptions((Map<String, String>)hashMap).setLOISlot(this).setAdRequest(adRequest);
            this.jsonObjectBuilder = jSONObjectBuilder.setAAXParameters(PARAMETERS).setAdvancedOptions((Map<String, String>)hashMap).setParameterData(parameterData);
        }

        AdSlot getAdSlot() {
            return this.adSlot;
        }

        AdTargetingOptions getAdTargetingOptions() {
            return this.opt;
        }

        JSONObject getJSON() {
            this.jsonObjectBuilder.build();
            return this.jsonObjectBuilder.getJSON();
        }
    }

}

