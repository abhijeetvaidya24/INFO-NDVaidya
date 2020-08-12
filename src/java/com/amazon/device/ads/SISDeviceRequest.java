/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.String
 *  java.util.HashMap
 *  org.json.JSONObject
 */
package com.amazon.device.ads;

import com.amazon.device.ads.AdvertisingIdentifier;
import com.amazon.device.ads.Configuration;
import com.amazon.device.ads.DeviceInfo;
import com.amazon.device.ads.JSONUtils;
import com.amazon.device.ads.Metrics;
import com.amazon.device.ads.MobileAdsInfoStore;
import com.amazon.device.ads.MobileAdsLoggerFactory;
import com.amazon.device.ads.RegistrationInfo;
import com.amazon.device.ads.SISRequest;
import com.amazon.device.ads.WebRequest;
import java.util.HashMap;
import org.json.JSONObject;

abstract class SISDeviceRequest
extends SISRequest {
    private AdvertisingIdentifier advertisingIdentifier;
    private AdvertisingIdentifier.Info advertisingIdentifierInfo;

    SISDeviceRequest(MobileAdsLoggerFactory mobileAdsLoggerFactory, String string, Metrics.MetricType metricType, String string2, AdvertisingIdentifier advertisingIdentifier, MobileAdsInfoStore mobileAdsInfoStore, Configuration configuration) {
        super(mobileAdsLoggerFactory, string, metricType, string2, mobileAdsInfoStore, configuration);
        this.advertisingIdentifier = advertisingIdentifier;
        this.advertisingIdentifierInfo = this.advertisingIdentifier.getAdvertisingIdentifierInfo();
    }

    private static String convertOptOutBooleanToStringInt(boolean bl) {
        if (bl) {
            return "1";
        }
        return "0";
    }

    protected AdvertisingIdentifier.Info getAdvertisingIdentifierInfo() {
        return this.advertisingIdentifierInfo;
    }

    @Override
    public HashMap<String, String> getPostParameters() {
        return null;
    }

    @Override
    public WebRequest.QueryStringParameters getQueryParameters() {
        WebRequest.QueryStringParameters queryStringParameters = super.getQueryParameters();
        DeviceInfo deviceInfo = this.mobileAdsInfoStore.getDeviceInfo();
        queryStringParameters.putUnencoded("ua", deviceInfo.getUserAgentString());
        queryStringParameters.putUnencoded("dinfo", deviceInfo.getDInfoProperty().toString());
        if (this.advertisingIdentifierInfo.hasAdvertisingIdentifier()) {
            queryStringParameters.putUrlEncoded("idfa", this.advertisingIdentifierInfo.getAdvertisingIdentifier());
            queryStringParameters.putUrlEncoded("oo", SISDeviceRequest.convertOptOutBooleanToStringInt(this.advertisingIdentifierInfo.isLimitAdTrackingEnabled()));
        } else {
            queryStringParameters.putUrlEncoded("sha1_mac", deviceInfo.getMacSha1());
            queryStringParameters.putUrlEncoded("sha1_serial", deviceInfo.getSerialSha1());
            queryStringParameters.putUrlEncoded("sha1_udid", deviceInfo.getUdidSha1());
            queryStringParameters.putUrlEncodedIfTrue("badMac", "true", deviceInfo.isMacBad());
            queryStringParameters.putUrlEncodedIfTrue("badSerial", "true", deviceInfo.isSerialBad());
            queryStringParameters.putUrlEncodedIfTrue("badUdid", "true", deviceInfo.isUdidBad());
        }
        String string = this.advertisingIdentifier.getAndClearTransition();
        boolean bl = string != null;
        queryStringParameters.putUrlEncodedIfTrue("aidts", string, bl);
        return queryStringParameters;
    }

    @Override
    public void onResponseReceived(JSONObject jSONObject) {
        String string = JSONUtils.getStringFromJSON(jSONObject, "adId", "");
        if (string.length() > 0) {
            this.mobileAdsInfoStore.getRegistrationInfo().putAdId(string, this.getAdvertisingIdentifierInfo());
        }
    }
}

