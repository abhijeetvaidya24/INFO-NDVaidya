/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.amazon.device.ads.AdController
 *  java.lang.Object
 */
package com.amazon.device.ads;

import com.amazon.device.ads.AdController;
import com.amazon.device.ads.ViewabilityChecker;

public class ViewabilityCheckerFactory {
    public ViewabilityChecker buildViewabilityChecker(AdController adController) {
        return new ViewabilityChecker(adController);
    }
}

