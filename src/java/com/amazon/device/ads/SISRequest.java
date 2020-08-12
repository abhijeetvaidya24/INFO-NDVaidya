/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.amazon.device.ads.MobileAdsLogger
 *  com.amazon.device.ads.SISDeviceRequest
 *  com.amazon.device.ads.SISGenerateDIDRequest
 *  com.amazon.device.ads.SISRegisterEventRequest
 *  com.amazon.device.ads.SISUpdateDeviceInfoRequest
 *  java.lang.Enum
 *  java.lang.IllegalArgumentException
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.HashMap
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.amazon.device.ads;

import com.amazon.device.ads.AdvertisingIdentifier;
import com.amazon.device.ads.AppInfo;
import com.amazon.device.ads.Configuration;
import com.amazon.device.ads.DeviceInfo;
import com.amazon.device.ads.Metrics;
import com.amazon.device.ads.MobileAdsInfoStore;
import com.amazon.device.ads.MobileAdsLogger;
import com.amazon.device.ads.MobileAdsLoggerFactory;
import com.amazon.device.ads.RegistrationInfo;
import com.amazon.device.ads.SISDeviceRequest;
import com.amazon.device.ads.SISGenerateDIDRequest;
import com.amazon.device.ads.SISRegisterEventRequest;
import com.amazon.device.ads.SISUpdateDeviceInfoRequest;
import com.amazon.device.ads.Version;
import com.amazon.device.ads.WebRequest;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

abstract class SISRequest {
    private final Metrics.MetricType callMetricType;
    private final Configuration configuration;
    private final String logTag;
    protected final MobileAdsLogger logger;
    protected MobileAdsInfoStore mobileAdsInfoStore;
    private final String path;

    SISRequest(MobileAdsLoggerFactory mobileAdsLoggerFactory, String string, Metrics.MetricType metricType, String string2, MobileAdsInfoStore mobileAdsInfoStore, Configuration configuration) {
        this.logTag = string;
        this.logger = mobileAdsLoggerFactory.createMobileAdsLogger(this.logTag);
        this.callMetricType = metricType;
        this.path = string2;
        this.mobileAdsInfoStore = mobileAdsInfoStore;
        this.configuration = configuration;
    }

    Metrics.MetricType getCallMetricType() {
        return this.callMetricType;
    }

    String getLogTag() {
        return this.logTag;
    }

    MobileAdsLogger getLogger() {
        return this.logger;
    }

    String getPath() {
        return this.path;
    }

    abstract HashMap<String, String> getPostParameters();

    WebRequest.QueryStringParameters getQueryParameters() {
        WebRequest.QueryStringParameters queryStringParameters = new WebRequest.QueryStringParameters();
        queryStringParameters.putUrlEncoded("dt", this.mobileAdsInfoStore.getDeviceInfo().getDeviceType());
        queryStringParameters.putUrlEncoded("app", this.mobileAdsInfoStore.getRegistrationInfo().getAppName());
        queryStringParameters.putUrlEncoded("appId", this.mobileAdsInfoStore.getRegistrationInfo().getAppKey());
        queryStringParameters.putUrlEncoded("sdkVer", Version.getSDKVersion());
        queryStringParameters.putUrlEncoded("aud", this.configuration.getString(Configuration.ConfigOption.SIS_DOMAIN));
        queryStringParameters.putUnencoded("pkg", this.mobileAdsInfoStore.getAppInfo().getPackageInfoJSONString());
        return queryStringParameters;
    }

    abstract void onResponseReceived(JSONObject var1);

    static final class SISDeviceRequestType
    extends Enum<SISDeviceRequestType> {
        private static final /* synthetic */ SISDeviceRequestType[] $VALUES;
        public static final /* enum */ SISDeviceRequestType GENERATE_DID = new SISDeviceRequestType();
        public static final /* enum */ SISDeviceRequestType UPDATE_DEVICE_INFO = new SISDeviceRequestType();

        static {
            SISDeviceRequestType[] arrsISDeviceRequestType = new SISDeviceRequestType[]{GENERATE_DID, UPDATE_DEVICE_INFO};
            $VALUES = arrsISDeviceRequestType;
        }

        public static SISDeviceRequestType valueOf(String string) {
            return (SISDeviceRequestType)Enum.valueOf(SISDeviceRequestType.class, (String)string);
        }

        public static SISDeviceRequestType[] values() {
            return (SISDeviceRequestType[])$VALUES.clone();
        }
    }

    static class SISRequestFactory {
        SISRequestFactory() {
        }

        public SISDeviceRequest createDeviceRequest(SISDeviceRequestType sISDeviceRequestType, AdvertisingIdentifier advertisingIdentifier) {
            int n = 1.$SwitchMap$com$amazon$device$ads$SISRequest$SISDeviceRequestType[sISDeviceRequestType.ordinal()];
            if (n != 1) {
                if (n == 2) {
                    return new SISUpdateDeviceInfoRequest(advertisingIdentifier);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("SISRequestType ");
                stringBuilder.append((Object)sISDeviceRequestType);
                stringBuilder.append(" is not a SISDeviceRequest");
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            return new SISGenerateDIDRequest(advertisingIdentifier);
        }

        public SISRegisterEventRequest createRegisterEventRequest(AdvertisingIdentifier.Info info, JSONArray jSONArray) {
            return new SISRegisterEventRequest(info, jSONArray);
        }
    }

}

