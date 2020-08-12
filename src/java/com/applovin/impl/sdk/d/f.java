/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Boolean
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.List
 */
package com.applovin.impl.sdk.d;

import android.content.Context;
import com.applovin.impl.sdk.ad.NativeAdImpl;
import com.applovin.impl.sdk.b.b;
import com.applovin.impl.sdk.c.e;
import com.applovin.impl.sdk.d.a;
import com.applovin.impl.sdk.e.m;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.p;
import com.applovin.nativeAds.AppLovinNativeAd;
import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import com.applovin.nativeAds.AppLovinNativeAdPrecacheListener;
import java.util.List;

abstract class f
extends a {
    protected final AppLovinNativeAdPrecacheListener a;
    private final List<NativeAdImpl> c;
    private final AppLovinNativeAdLoadListener d;
    private int e;

    f(String string, List<NativeAdImpl> list, j j2, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        super(string, j2);
        this.c = list;
        this.d = appLovinNativeAdLoadListener;
        this.a = null;
    }

    f(String string, List<NativeAdImpl> list, j j2, AppLovinNativeAdPrecacheListener appLovinNativeAdPrecacheListener) {
        super(string, j2);
        if (list != null) {
            this.c = list;
            this.d = null;
            this.a = appLovinNativeAdPrecacheListener;
            return;
        }
        throw new IllegalArgumentException("Native ads cannot be null");
    }

    private void a(int n2) {
        AppLovinNativeAdLoadListener appLovinNativeAdLoadListener = this.d;
        if (appLovinNativeAdLoadListener != null) {
            appLovinNativeAdLoadListener.onNativeAdsFailedToLoad(n2);
        }
    }

    private void a(List<AppLovinNativeAd> list) {
        AppLovinNativeAdLoadListener appLovinNativeAdLoadListener = this.d;
        if (appLovinNativeAdLoadListener != null) {
            appLovinNativeAdLoadListener.onNativeAdsLoaded(list);
        }
    }

    protected String a(String string, n n2, List<String> list) {
        String string2;
        block5 : {
            if (!com.applovin.impl.sdk.e.j.b(string)) {
                this.a("Asked to cache file with null/empty URL, nothing to do.");
                return null;
            }
            if (!m.a(string, list)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Domain is not whitelisted, skipping precache for URL ");
                stringBuilder.append(string);
                this.a(stringBuilder.toString());
                return null;
            }
            try {
                string2 = n2.a(this.d(), string, null, list, true, true, null);
                if (string2 != null) break block5;
            }
            catch (Exception exception) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unable to cache icon resource ");
                stringBuilder.append(string);
                this.a(stringBuilder.toString(), exception);
                return null;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to cache icon resource ");
            stringBuilder.append(string);
            this.c(stringBuilder.toString());
            return null;
        }
        return string2;
    }

    protected abstract void a(NativeAdImpl var1);

    protected abstract void a(NativeAdImpl var1, int var2);

    protected abstract boolean a(NativeAdImpl var1, n var2);

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        for (NativeAdImpl nativeAdImpl : this.c) {
            this.a("Beginning resource caching phase...");
            if (this.a(nativeAdImpl, this.b.N())) {
                this.e = 1 + this.e;
                this.a(nativeAdImpl);
                continue;
            }
            this.d("Unable to cache resources");
        }
        try {
            List<NativeAdImpl> list;
            if (this.e == this.c.size()) {
                list = this.c;
            } else {
                if (this.b.a(b.dD).booleanValue()) {
                    this.d("Mismatch between successful populations and requested size");
                    this.a(-6);
                    return;
                }
                list = this.c;
            }
            this.a(list);
            return;
        }
        catch (Throwable throwable) {
            this.b().u().c(this.c(), "Encountered exception while notifying publisher code", throwable);
            return;
        }
    }
}

