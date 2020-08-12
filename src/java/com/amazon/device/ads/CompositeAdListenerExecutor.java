/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 */
package com.amazon.device.ads;

import android.graphics.Rect;
import com.amazon.device.ads.ActionCode;
import com.amazon.device.ads.Ad;
import com.amazon.device.ads.AdData;
import com.amazon.device.ads.AdError;
import com.amazon.device.ads.AdEvent;
import com.amazon.device.ads.AdListener;
import com.amazon.device.ads.AdListenerExecutor;
import com.amazon.device.ads.AdProperties;
import com.amazon.device.ads.MobileAdsLoggerFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class CompositeAdListenerExecutor
extends AdListenerExecutor {
    private final List<AdListenerExecutor> adListenerExecutors = new ArrayList();

    public CompositeAdListenerExecutor(MobileAdsLoggerFactory mobileAdsLoggerFactory) {
        super(null, mobileAdsLoggerFactory);
    }

    private List<AdListenerExecutor> getAdListenerExecutors() {
        return this.adListenerExecutors;
    }

    public void addAdListenerExecutor(AdListenerExecutor adListenerExecutor) {
        this.adListenerExecutors.add((Object)adListenerExecutor);
    }

    @Override
    public void onAdCollapsed(Ad ad) {
        Iterator iterator = this.getAdListenerExecutors().iterator();
        while (iterator.hasNext()) {
            ((AdListenerExecutor)iterator.next()).onAdCollapsed(ad);
        }
    }

    @Override
    public void onAdDismissed(Ad ad) {
        Iterator iterator = this.getAdListenerExecutors().iterator();
        while (iterator.hasNext()) {
            ((AdListenerExecutor)iterator.next()).onAdDismissed(ad);
        }
    }

    @Override
    public void onAdEvent(AdEvent adEvent) {
        Iterator iterator = this.getAdListenerExecutors().iterator();
        while (iterator.hasNext()) {
            ((AdListenerExecutor)iterator.next()).onAdEvent(adEvent);
        }
    }

    @Override
    public void onAdExpanded(Ad ad) {
        Iterator iterator = this.getAdListenerExecutors().iterator();
        while (iterator.hasNext()) {
            ((AdListenerExecutor)iterator.next()).onAdExpanded(ad);
        }
    }

    @Override
    public void onAdExpired(Ad ad) {
        Iterator iterator = this.getAdListenerExecutors().iterator();
        while (iterator.hasNext()) {
            ((AdListenerExecutor)iterator.next()).onAdExpired(ad);
        }
    }

    @Override
    public void onAdFailedToLoad(Ad ad, AdError adError) {
        Iterator iterator = this.getAdListenerExecutors().iterator();
        while (iterator.hasNext()) {
            ((AdListenerExecutor)iterator.next()).onAdFailedToLoad(ad, adError);
        }
    }

    @Override
    public void onAdLoaded(Ad ad, AdProperties adProperties) {
        Iterator iterator = this.getAdListenerExecutors().iterator();
        while (iterator.hasNext()) {
            ((AdListenerExecutor)iterator.next()).onAdLoaded(ad, adProperties);
        }
    }

    @Override
    public ActionCode onAdReceived(Ad ad, AdData adData) {
        Iterator iterator = this.getAdListenerExecutors().iterator();
        if (iterator.hasNext()) {
            return ((AdListenerExecutor)iterator.next()).onAdReceived(ad, adData);
        }
        return null;
    }

    @Override
    public void onAdResized(Ad ad, Rect rect) {
        Iterator iterator = this.getAdListenerExecutors().iterator();
        while (iterator.hasNext()) {
            ((AdListenerExecutor)iterator.next()).onAdResized(ad, rect);
        }
    }

    @Override
    public void onSpecialUrlClicked(Ad ad, String string) {
        Iterator iterator = this.getAdListenerExecutors().iterator();
        while (iterator.hasNext()) {
            ((AdListenerExecutor)iterator.next()).onSpecialUrlClicked(ad, string);
        }
    }
}

