/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.amazon.device.ads.AdListenerExecutorFactory$1
 *  com.amazon.device.ads.AdListenerExecutorFactory$2
 *  com.amazon.device.ads.ExtendedAdListener
 *  java.lang.Object
 */
package com.amazon.device.ads;

import com.amazon.device.ads.AdListener;
import com.amazon.device.ads.AdListenerExecutor;
import com.amazon.device.ads.AdListenerExecutorFactory;
import com.amazon.device.ads.ExtendedAdListener;
import com.amazon.device.ads.MobileAdsLoggerFactory;
import com.amazon.device.ads.OnAdExpiredCommand;
import com.amazon.device.ads.OnAdResizedCommand;

class AdListenerExecutorFactory {
    private final AdListenerExecutorConstructor adListenerExecutorConstructor;
    private final MobileAdsLoggerFactory loggerFactory;

    public AdListenerExecutorFactory(MobileAdsLoggerFactory mobileAdsLoggerFactory) {
        this(mobileAdsLoggerFactory, new AdListenerExecutorConstructor());
    }

    public AdListenerExecutorFactory(MobileAdsLoggerFactory mobileAdsLoggerFactory, AdListenerExecutorConstructor adListenerExecutorConstructor) {
        this.loggerFactory = mobileAdsLoggerFactory;
        this.adListenerExecutorConstructor = adListenerExecutorConstructor;
    }

    private void createAdExpiredCommand(AdListenerExecutor adListenerExecutor) {
        adListenerExecutor.setOnAdExpiredCommand((OnAdExpiredCommand)new 2(this, adListenerExecutor));
    }

    private void createAdResizedCommand(AdListenerExecutor adListenerExecutor) {
        adListenerExecutor.setOnAdResizedCommand((OnAdResizedCommand)new 1(this, adListenerExecutor));
    }

    public AdListenerExecutor createAdListenerExecutor(AdListener adListener) {
        return this.createAdListenerExecutor(adListener, this.loggerFactory);
    }

    public AdListenerExecutor createAdListenerExecutor(AdListener adListener, MobileAdsLoggerFactory mobileAdsLoggerFactory) {
        AdListenerExecutor adListenerExecutor = this.adListenerExecutorConstructor.createAdListenerExecutor(adListener, mobileAdsLoggerFactory);
        if (adListener instanceof ExtendedAdListener) {
            this.createAdResizedCommand(adListenerExecutor);
            this.createAdExpiredCommand(adListenerExecutor);
        }
        return adListenerExecutor;
    }

    protected MobileAdsLoggerFactory getLoggerFactory() {
        return this.loggerFactory;
    }

    static class AdListenerExecutorConstructor {
        AdListenerExecutorConstructor() {
        }

        public AdListenerExecutor createAdListenerExecutor(AdListener adListener, MobileAdsLoggerFactory mobileAdsLoggerFactory) {
            return new AdListenerExecutor(adListener, mobileAdsLoggerFactory);
        }
    }

}

