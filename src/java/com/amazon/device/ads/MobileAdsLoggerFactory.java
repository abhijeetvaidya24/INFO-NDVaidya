/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.amazon.device.ads.LogcatLogger
 *  com.amazon.device.ads.MobileAdsLogger
 *  java.lang.Object
 *  java.lang.String
 */
package com.amazon.device.ads;

import com.amazon.device.ads.LogcatLogger;
import com.amazon.device.ads.Logger;
import com.amazon.device.ads.MobileAdsLogger;

class MobileAdsLoggerFactory {
    MobileAdsLoggerFactory() {
    }

    public MobileAdsLogger createMobileAdsLogger(String string) {
        return new MobileAdsLogger((Logger)new LogcatLogger()).withLogTag(string);
    }
}

