/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.amazon.device.ads.MobileAdsLogger
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.HashMap
 *  java.util.Map$Entry
 *  java.util.Set
 *  org.json.JSONObject
 */
package com.amazon.device.ads;

import com.amazon.device.ads.Configuration;
import com.amazon.device.ads.JSONUtils;
import com.amazon.device.ads.Metrics;
import com.amazon.device.ads.MetricsCollector;
import com.amazon.device.ads.MobileAdsLogger;
import com.amazon.device.ads.ResponseReader;
import com.amazon.device.ads.SISRequest;
import com.amazon.device.ads.SISRequestorCallback;
import com.amazon.device.ads.WebRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

class SISRequestor {
    protected static final String API_LEVEL_ENDPOINT = "/api3";
    private final Configuration configuration;
    private final SISRequestorCallback sisRequestorCallback;
    private final SISRequest[] sisRequests;
    private final WebRequest.WebRequestFactory webRequestFactory;

    public /* varargs */ SISRequestor(SISRequestorCallback sISRequestorCallback, SISRequest ... arrsISRequest) {
        this(new WebRequest.WebRequestFactory(), sISRequestorCallback, Configuration.getInstance(), arrsISRequest);
    }

    /* varargs */ SISRequestor(WebRequest.WebRequestFactory webRequestFactory, SISRequestorCallback sISRequestorCallback, Configuration configuration, SISRequest ... arrsISRequest) {
        this.webRequestFactory = webRequestFactory;
        this.sisRequestorCallback = sISRequestorCallback;
        this.configuration = configuration;
        this.sisRequests = arrsISRequest;
    }

    private void callSIS(SISRequest sISRequest) {
        WebRequest.WebResponse webResponse;
        WebRequest webRequest = this.getWebRequest(sISRequest);
        try {
            webResponse = webRequest.makeCall();
        }
        catch (WebRequest.WebRequestException webRequestException) {}
        JSONObject jSONObject = webResponse.getResponseReader().readAsJSON();
        if (jSONObject == null) {
            return;
        }
        int n = JSONUtils.getIntegerFromJSON(jSONObject, "rcode", 0);
        String string = JSONUtils.getStringFromJSON(jSONObject, "msg", "");
        if (n == 1) {
            MobileAdsLogger mobileAdsLogger = sISRequest.getLogger();
            Object[] arrobject = new Object[]{n, string};
            mobileAdsLogger.i("Result - code: %d, msg: %s", arrobject);
            sISRequest.onResponseReceived(jSONObject);
            return;
        }
        MobileAdsLogger mobileAdsLogger = sISRequest.getLogger();
        Object[] arrobject = new Object[]{n, string};
        mobileAdsLogger.w("Result - code: %d, msg: %s", arrobject);
    }

    private String getEndpoint(SISRequest sISRequest) {
        String string = this.configuration.getString(Configuration.ConfigOption.SIS_URL);
        if (string != null) {
            int n = string.indexOf("/");
            string = n > -1 ? string.substring(n) : "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(API_LEVEL_ENDPOINT);
        stringBuilder.append(sISRequest.getPath());
        return stringBuilder.toString();
    }

    private String getHostname() {
        int n;
        String string = this.configuration.getString(Configuration.ConfigOption.SIS_URL);
        if (string != null && (n = string.indexOf("/")) > -1) {
            string = string.substring(0, n);
        }
        return string;
    }

    private SISRequestorCallback getSisRequestorCallback() {
        return this.sisRequestorCallback;
    }

    private WebRequest getWebRequest(SISRequest sISRequest) {
        WebRequest webRequest = this.webRequestFactory.createWebRequest();
        webRequest.setExternalLogTag(sISRequest.getLogTag());
        webRequest.setHttpMethod(WebRequest.HttpMethod.POST);
        webRequest.setHost(this.getHostname());
        webRequest.setPath(this.getEndpoint(sISRequest));
        webRequest.enableLog(true);
        HashMap<String, String> hashMap = sISRequest.getPostParameters();
        if (hashMap != null) {
            for (Map.Entry entry : hashMap.entrySet()) {
                webRequest.putPostParameter((String)entry.getKey(), (String)entry.getValue());
            }
        }
        webRequest.setQueryStringParameters(sISRequest.getQueryParameters());
        webRequest.setMetricsCollector(Metrics.getInstance().getMetricsCollector());
        webRequest.setServiceCallLatencyMetric(sISRequest.getCallMetricType());
        return webRequest;
    }

    public void startCallSIS() {
        SISRequest[] arrsISRequest = this.sisRequests;
        int n = arrsISRequest.length;
        for (int i2 = 0; i2 < n; ++i2) {
            this.callSIS(arrsISRequest[i2]);
        }
        SISRequestorCallback sISRequestorCallback = this.getSisRequestorCallback();
        if (sISRequestorCallback != null) {
            sISRequestorCallback.onSISCallComplete();
        }
    }

    static class SISRequestorFactory {
        SISRequestorFactory() {
        }

        public /* varargs */ SISRequestor createSISRequestor(SISRequestorCallback sISRequestorCallback, SISRequest ... arrsISRequest) {
            return new SISRequestor(sISRequestorCallback, arrsISRequest);
        }

        public /* varargs */ SISRequestor createSISRequestor(SISRequest ... arrsISRequest) {
            return this.createSISRequestor((SISRequestorCallback)null, arrsISRequest);
        }
    }

}

