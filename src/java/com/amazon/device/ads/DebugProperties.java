/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.amazon.device.ads.MobileAdsLogger
 *  java.lang.Boolean
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 *  java.util.Properties
 *  org.json.JSONObject
 */
package com.amazon.device.ads;

import com.amazon.device.ads.JSONUtils;
import com.amazon.device.ads.MobileAdsLogger;
import com.amazon.device.ads.MobileAdsLoggerFactory;
import java.util.Map;
import java.util.Properties;
import org.json.JSONObject;

class DebugProperties {
    public static final String DEBUG_AAX_AD_PARAMS = "debug.aaxAdParams";
    public static final String DEBUG_AAX_CONFIG_HOSTNAME = "debug.aaxConfigHostname";
    public static final String DEBUG_AAX_CONFIG_PARAMS = "debug.aaxConfigParams";
    public static final String DEBUG_AAX_CONFIG_USE_SECURE = "debug.aaxConfigUseSecure";
    public static final String DEBUG_ADID = "debug.adid";
    public static final String DEBUG_ADVTARGETING = "debug.advTargeting";
    public static final String DEBUG_APPID = "debug.appid";
    public static final String DEBUG_CAN_TIMEOUT = "debug.canTimeout";
    public static final String DEBUG_CHANNEL = "debug.channel";
    public static final String DEBUG_CONFIG_FEATURE_USE_GPS_ADVERTISING_ID = "debug.fUseGPSAID";
    public static final String DEBUG_DINFO = "debug.dinfo";
    public static final String DEBUG_DIRECTEDID = "debug.directedId";
    public static final String DEBUG_ECPM = "debug.ec";
    public static final String DEBUG_GEOLOC = "debug.geoloc";
    public static final String DEBUG_IDFA = "debug.idfa";
    public static final String DEBUG_LOGGING = "debug.logging";
    public static final String DEBUG_MADS_USE_SECURE = "debug.madsUseSecure";
    public static final String DEBUG_MD5UDID = "debug.md5udid";
    public static final String DEBUG_MXSZ = "debug.mxsz";
    public static final String DEBUG_NORETRYTTL = "debug.noRetryTTL";
    public static final String DEBUG_NORETRYTTL_MAX = "debug.noRetryTTLMax";
    public static final String DEBUG_OPT_OUT = "debug.optOut";
    public static final String DEBUG_PA = "debug.pa";
    public static final String DEBUG_PJ = "debug.pj";
    public static final String DEBUG_PK = "debug.pk";
    public static final String DEBUG_PKG = "debug.pkg";
    public static final String DEBUG_PT = "debug.pt";
    public static final String DEBUG_SHA1UDID = "debug.sha1udid";
    public static final String DEBUG_SHOULD_FETCH_CONFIG = "debug.shouldFetchConfig";
    public static final String DEBUG_SHOULD_IDENTIFY_USER = "debug.shouldIdentifyUser";
    public static final String DEBUG_SHOULD_REGISTER_SIS = "debug.shouldRegisterSIS";
    public static final String DEBUG_SIS_CHECKIN_INTERVAL = "debug.sisCheckinInterval";
    public static final String DEBUG_SIZE = "debug.size";
    public static final String DEBUG_SLOT = "debug.slot";
    public static final String DEBUG_SLOTS = "debug.slots";
    public static final String DEBUG_SLOT_ID = "debug.slotId";
    public static final String DEBUG_SP = "debug.sp";
    public static final String DEBUG_SUPPORTED_MEDIA_TYPES = "debug.supportedMediaTypes";
    public static final String DEBUG_TEST = "debug.test";
    public static final String DEBUG_UA = "debug.ua";
    public static final String DEBUG_USESECURE = "debug.useSecure";
    public static final String DEBUG_VER = "debug.ver";
    public static final String DEBUG_VIDEO_OPTIONS = "debug.videoOptions";
    public static final String DEBUG_VIEWABLE_INTERVAL = "debug.viewableInterval";
    public static final String DEBUG_WEBVIEWS = "debug.webViews";
    private static final String LOGTAG;
    private static final DebugProperties instance;
    private final Properties debugProperties = new Properties();
    private final JSONUtils.JSONUtilities jsonUtilities;
    private final MobileAdsLogger logger;

    static {
        instance = new DebugProperties();
        LOGTAG = DebugProperties.class.getSimpleName();
    }

    public DebugProperties() {
        this(new JSONUtils.JSONUtilities(), new MobileAdsLoggerFactory());
    }

    DebugProperties(JSONUtils.JSONUtilities jSONUtilities, MobileAdsLoggerFactory mobileAdsLoggerFactory) {
        this.jsonUtilities = jSONUtilities;
        this.logger = mobileAdsLoggerFactory.createMobileAdsLogger(LOGTAG);
    }

    public static DebugProperties getInstance() {
        return instance;
    }

    public void clearDebugProperties() {
        this.debugProperties.clear();
    }

    public boolean containsDebugProperty(String string) {
        return this.debugProperties.containsKey((Object)string);
    }

    public Boolean getDebugPropertyAsBoolean(String string, Boolean bl) {
        String string2 = this.debugProperties.getProperty(string);
        if (string2 == null) {
            return bl;
        }
        try {
            Boolean bl2 = Boolean.parseBoolean((String)string2);
            return bl2;
        }
        catch (NumberFormatException numberFormatException) {
            this.logger.e("Unable to parse boolean debug property - property: %s, value: %s", new Object[]{string, string2});
            return bl;
        }
    }

    public Integer getDebugPropertyAsInteger(String string, Integer n) {
        String string2 = this.debugProperties.getProperty(string);
        if (string2 == null) {
            return n;
        }
        try {
            Integer n2 = Integer.parseInt((String)string2);
            return n2;
        }
        catch (NumberFormatException numberFormatException) {
            this.logger.e("Unable to parse integer debug property - property: %s, value: %s", new Object[]{string, string2});
            return n;
        }
    }

    public JSONObject getDebugPropertyAsJSONObject(String string, JSONObject jSONObject) {
        String string2 = this.debugProperties.getProperty(string);
        if (string2 == null) {
            return jSONObject;
        }
        return this.jsonUtilities.getJSONObjectFromString(string2);
    }

    public Long getDebugPropertyAsLong(String string, Long l2) {
        String string2 = this.debugProperties.getProperty(string);
        if (string2 == null) {
            return l2;
        }
        try {
            Long l3 = Long.parseLong((String)string2);
            return l3;
        }
        catch (NumberFormatException numberFormatException) {
            this.logger.e("Unable to parse long debug property - property: %s, value: %s", new Object[]{string, string2});
            return l2;
        }
    }

    public String getDebugPropertyAsString(String string, String string2) {
        return this.debugProperties.getProperty(string, string2);
    }

    public void overwriteDebugProperties(JSONObject jSONObject) {
        this.clearDebugProperties();
        Map<String, String> map = this.jsonUtilities.createMapFromJSON(jSONObject);
        this.debugProperties.putAll(map);
    }

    public void setDebugProperty(String string, String string2) {
        this.debugProperties.put((Object)string, (Object)string2);
    }
}

