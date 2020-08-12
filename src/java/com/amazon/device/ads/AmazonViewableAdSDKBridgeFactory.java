/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.amazon.device.ads;

import com.amazon.device.ads.AdControlAccessor;
import com.amazon.device.ads.AdSDKBridge;
import com.amazon.device.ads.AdSDKBridgeFactory;
import com.amazon.device.ads.AmazonViewableAdSDKBridge;
import com.amazon.device.ads.JavascriptInteractor;

public class AmazonViewableAdSDKBridgeFactory
implements AdSDKBridgeFactory {
    @Override
    public AdSDKBridge createAdSDKBridge(AdControlAccessor adControlAccessor) {
        return new AmazonViewableAdSDKBridge(adControlAccessor, new JavascriptInteractor());
    }
}

