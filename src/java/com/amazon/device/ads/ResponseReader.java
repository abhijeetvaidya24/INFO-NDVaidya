/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.amazon.device.ads.MobileAdsLogger
 *  java.io.InputStream
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  org.json.JSONObject
 */
package com.amazon.device.ads;

import com.amazon.device.ads.JSONUtils;
import com.amazon.device.ads.MobileAdsLogger;
import com.amazon.device.ads.MobileAdsLoggerFactory;
import com.amazon.device.ads.StringUtils;
import java.io.InputStream;
import org.json.JSONObject;

class ResponseReader {
    private static final String LOGTAG = "ResponseReader";
    private boolean enableLog = false;
    private final MobileAdsLogger logger = new MobileAdsLoggerFactory().createMobileAdsLogger(LOGTAG);
    private final InputStream stream;

    ResponseReader(InputStream inputStream) {
        this.stream = inputStream;
    }

    public void enableLog(boolean bl) {
        this.enableLog = bl;
    }

    public InputStream getInputStream() {
        return this.stream;
    }

    public JSONObject readAsJSON() {
        return JSONUtils.getJSONObjectFromString(this.readAsString());
    }

    public String readAsString() {
        String string = StringUtils.readStringFromInputStream(this.stream);
        if (this.enableLog) {
            this.logger.d("Response Body: %s", new Object[]{string});
        }
        return string;
    }

    public void setExternalLogTag(String string) {
        if (string == null) {
            this.logger.withLogTag(LOGTAG);
            return;
        }
        MobileAdsLogger mobileAdsLogger = this.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(LOGTAG);
        stringBuilder.append(" ");
        stringBuilder.append(string);
        mobileAdsLogger.withLogTag(stringBuilder.toString());
    }
}

