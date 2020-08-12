/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.amazon.device.ads.AdController
 *  java.lang.IllegalStateException
 *  java.lang.Object
 */
package com.amazon.device.ads;

import android.content.Context;
import com.amazon.device.ads.AdControlAccessor;
import com.amazon.device.ads.AdController;
import com.amazon.device.ads.AdSize;

class AdControllerFactory {
    private static AdControlAccessor cachedAdControlAccessor;
    private static AdController cachedAdController;

    AdControllerFactory() {
    }

    public static void cacheAdControlAccessor(AdControlAccessor adControlAccessor) {
        cachedAdControlAccessor = adControlAccessor;
    }

    public static void cacheAdController(AdController adController) {
        cachedAdController = adController;
    }

    public static AdControlAccessor getCachedAdControlAccessor() {
        return cachedAdControlAccessor;
    }

    public static AdController getCachedAdController() {
        return cachedAdController;
    }

    public static AdControlAccessor removeCachedAdControlAccessor() {
        AdControlAccessor adControlAccessor = cachedAdControlAccessor;
        cachedAdControlAccessor = null;
        return adControlAccessor;
    }

    public static AdController removeCachedAdController() {
        AdController adController = cachedAdController;
        cachedAdController = null;
        return adController;
    }

    public AdController buildAdController(Context context, AdSize adSize) {
        try {
            AdController adController = new AdController(context, adSize);
            return adController;
        }
        catch (IllegalStateException illegalStateException) {
            return null;
        }
    }
}

