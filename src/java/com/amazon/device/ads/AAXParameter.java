/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.amazon.device.ads.AAXParameter$AppKeyParameter
 *  com.amazon.device.ads.AAXParameter$DeviceInfoParameter
 *  com.amazon.device.ads.AAXParameter$FloorPriceParameter
 *  com.amazon.device.ads.AAXParameter$GeoLocationParameter
 *  com.amazon.device.ads.AAXParameter$JSONArrayParameter
 *  com.amazon.device.ads.AAXParameter$MaxSizeParameter
 *  com.amazon.device.ads.AAXParameter$OptOutParameter
 *  com.amazon.device.ads.AAXParameter$PackageInfoParameter
 *  com.amazon.device.ads.AAXParameter$PublisherKeywordsParameter
 *  com.amazon.device.ads.AAXParameter$SDKVersionParameter
 *  com.amazon.device.ads.AAXParameter$SizeParameter
 *  com.amazon.device.ads.AAXParameter$SlotIdParameter
 *  com.amazon.device.ads.AAXParameter$SlotParameter
 *  com.amazon.device.ads.AAXParameter$StringParameter
 *  com.amazon.device.ads.AAXParameter$SupportedMediaTypesParameter
 *  com.amazon.device.ads.AAXParameter$TestParameter
 *  com.amazon.device.ads.AAXParameter$UserAgentParameter
 *  com.amazon.device.ads.AAXParameter$VideoOptionsParameter
 *  java.lang.Boolean
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.Map
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.amazon.device.ads;

import com.amazon.device.ads.AAXParameter;
import com.amazon.device.ads.AdRequest;
import com.amazon.device.ads.AdTargetingOptions;
import com.amazon.device.ads.DebugProperties;
import com.amazon.device.ads.StringUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/*
 * Exception performing whole class analysis.
 */
abstract class AAXParameter<T> {
    static final AAXParameter<String> APP_KEY;
    static final AAXParameter<String> CHANNEL;
    static final AAXParameter<JSONObject> DEVICE_INFO;
    static final AAXParameter<Long> FLOOR_PRICE;
    static final AAXParameter<String> GEOLOCATION;
    private static final String LOGTAG = "AAXParameter";
    static final AAXParameter<String> MAX_SIZE;
    static final AAXParameter<Boolean> OPT_OUT;
    static final AAXParameter<JSONObject> PACKAGE_INFO;
    static final AAXParameter<String> PAGE_TYPE;
    static final AAXParameter<JSONArray> PUBLISHER_ASINS;
    static final PublisherKeywordsParameter PUBLISHER_KEYWORDS;
    static final AAXParameter<String> SDK_VERSION;
    static final AAXParameter<String> SIZE;
    static final AAXParameter<String> SLOT;
    static final AAXParameter<JSONArray> SLOTS;
    static final AAXParameter<Integer> SLOT_ID;
    static final AAXParameter<String> SLOT_POSITION;
    static final AAXParameter<JSONArray> SUPPORTED_MEDIA_TYPES;
    static final AAXParameter<Boolean> TEST;
    static final AAXParameter<String> USER_AGENT;
    static final AAXParameter<JSONObject> VIDEO_OPTIONS;
    private final String debugName;
    private final String name;

    static {
        APP_KEY = new /* Unavailable Anonymous Inner Class!! */;
        CHANNEL = new /* Unavailable Anonymous Inner Class!! */;
        PUBLISHER_KEYWORDS = new /* Unavailable Anonymous Inner Class!! */;
        PUBLISHER_ASINS = new /* Unavailable Anonymous Inner Class!! */;
        USER_AGENT = new /* Unavailable Anonymous Inner Class!! */;
        SDK_VERSION = new /* Unavailable Anonymous Inner Class!! */;
        GEOLOCATION = new /* Unavailable Anonymous Inner Class!! */;
        DEVICE_INFO = new /* Unavailable Anonymous Inner Class!! */;
        PACKAGE_INFO = new /* Unavailable Anonymous Inner Class!! */;
        TEST = new /* Unavailable Anonymous Inner Class!! */;
        SLOTS = new /* Unavailable Anonymous Inner Class!! */;
        OPT_OUT = new /* Unavailable Anonymous Inner Class!! */;
        SIZE = new /* Unavailable Anonymous Inner Class!! */;
        PAGE_TYPE = new /* Unavailable Anonymous Inner Class!! */;
        SLOT = new /* Unavailable Anonymous Inner Class!! */;
        SLOT_POSITION = new /* Unavailable Anonymous Inner Class!! */;
        MAX_SIZE = new /* Unavailable Anonymous Inner Class!! */;
        SLOT_ID = new /* Unavailable Anonymous Inner Class!! */;
        FLOOR_PRICE = new /* Unavailable Anonymous Inner Class!! */;
        SUPPORTED_MEDIA_TYPES = new /* Unavailable Anonymous Inner Class!! */;
        VIDEO_OPTIONS = new /* Unavailable Anonymous Inner Class!! */;
    }

    AAXParameter(String string, String string2) {
        this.name = string;
        this.debugName = string2;
    }

    static /* synthetic */ String access$100() {
        return LOGTAG;
    }

    private T getValueHelper(ParameterData parameterData, boolean bl) {
        Object var4_5;
        T t2 = this.hasDebugPropertiesValue() ? (T)this.getFromDebugProperties() : null;
        if (parameterData.advancedOptions != null) {
            String string = bl ? (String)parameterData.advancedOptions.remove((Object)this.name) : (String)parameterData.advancedOptions.get((Object)this.name);
            if (t2 == null && !StringUtils.isNullOrEmpty(string)) {
                t2 = this.parseFromString(string);
            }
        }
        if (t2 == null) {
            t2 = this.getDerivedValue(parameterData);
        }
        if ((var4_5 = this.applyPostParameterProcessing(t2, parameterData)) instanceof String && StringUtils.isNullOrWhiteSpace(var4_5)) {
            var4_5 = null;
        }
        return var4_5;
    }

    protected T applyPostParameterProcessing(T t2, ParameterData parameterData) {
        return t2;
    }

    protected String getDebugName() {
        return this.debugName;
    }

    protected T getDerivedValue(ParameterData parameterData) {
        return null;
    }

    protected abstract T getFromDebugProperties();

    String getName() {
        return this.name;
    }

    T getValue(ParameterData parameterData) {
        return this.getValueHelper(parameterData, true);
    }

    T getValueDoNotRemove(ParameterData parameterData) {
        return this.getValueHelper(parameterData, false);
    }

    protected boolean hasDebugPropertiesValue() {
        return DebugProperties.getInstance().containsDebugProperty(this.debugName);
    }

    protected abstract T parseFromString(String var1);

    static class ParameterData {
        private AdRequest adRequest;
        private AdTargetingOptions adTargetingOptions;
        private Map<String, String> advancedOptions;
        private AdRequest.LOISlot loiSlot;
        private Map<String, String> temporaryOptions = new HashMap();

        static /* synthetic */ AdTargetingOptions access$200(ParameterData parameterData) {
            return parameterData.adTargetingOptions;
        }

        static /* synthetic */ AdRequest access$300(ParameterData parameterData) {
            return parameterData.adRequest;
        }

        AdRequest getAdRequest() {
            return this.adRequest;
        }

        Map<String, String> getInternalAdvancedOptions() {
            return this.advancedOptions;
        }

        ParameterData setAdRequest(AdRequest adRequest) {
            this.adRequest = adRequest;
            return this;
        }

        ParameterData setAdTargetingOptions(AdTargetingOptions adTargetingOptions) {
            this.adTargetingOptions = adTargetingOptions;
            return this;
        }

        ParameterData setAdvancedOptions(Map<String, String> map) {
            this.advancedOptions = map;
            return this;
        }

        ParameterData setLOISlot(AdRequest.LOISlot lOISlot) {
            this.loiSlot = lOISlot;
            return this;
        }
    }

    private static class VideoAdsEnabledChecker {
        private final ParameterData parameterData;

        public VideoAdsEnabledChecker(ParameterData parameterData) {
            this.parameterData = parameterData;
        }

        public boolean isVideoAdsEnabled() {
            if (!this.parameterData.loiSlot.getAdTargetingOptions().isVideoEnabledSettable()) {
                return false;
            }
            if (this.parameterData.advancedOptions.containsKey((Object)"enableVideoAds")) {
                String string = (String)this.parameterData.advancedOptions.remove((Object)"enableVideoAds");
                this.parameterData.temporaryOptions.put((Object)"enableVideoAds", (Object)string);
                return Boolean.parseBoolean((String)string);
            }
            if (this.parameterData.temporaryOptions.containsKey((Object)"enableVideoAds")) {
                return Boolean.parseBoolean((String)((String)this.parameterData.temporaryOptions.get((Object)"enableVideoAds")));
            }
            return this.parameterData.loiSlot.getAdTargetingOptions().isVideoAdsEnabled();
        }
    }

}

