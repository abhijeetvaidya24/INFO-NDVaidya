/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.amazon.device.ads.AdvertisingIdParameter
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 */
package com.amazon.device.ads;

import com.amazon.device.ads.AdvertisingIdParameter;
import com.amazon.device.ads.Settings;
import com.amazon.device.ads.UserIdParameter;
import com.amazon.device.ads.WebRequest;

class WebRequestUserId {
    private final AdvertisingIdParameter adIdParam;
    private final Settings settings;
    private UserIdParameter userIdParam;

    public WebRequestUserId() {
        this(Settings.getInstance(), new AdvertisingIdParameter());
    }

    WebRequestUserId(Settings settings, AdvertisingIdParameter advertisingIdParameter) {
        this.settings = settings;
        this.adIdParam = advertisingIdParameter;
    }

    private void setupUserIdParam() {
        if (this.userIdParam == null) {
            this.userIdParam = this.settings.getObject("userIdParam", this.adIdParam, UserIdParameter.class);
        }
    }

    public boolean populateWebRequestUserId(WebRequest webRequest) {
        UserIdParameter userIdParameter;
        AdvertisingIdParameter advertisingIdParameter;
        this.setupUserIdParam();
        boolean bl = this.userIdParam.evaluate(webRequest);
        if (!bl && (userIdParameter = this.userIdParam) != (advertisingIdParameter = this.adIdParam)) {
            bl = advertisingIdParameter.evaluate(webRequest);
        }
        return bl;
    }
}

