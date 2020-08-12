/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.amazon.device.ads.AdController
 *  java.lang.Object
 */
package com.amazon.device.ads;

import com.amazon.device.ads.AdController;
import com.amazon.device.ads.ViewabilityObserver;

public class ViewabilityObserverFactory {
    public ViewabilityObserver buildViewabilityObserver(AdController adController) {
        return new ViewabilityObserver(adController);
    }
}

