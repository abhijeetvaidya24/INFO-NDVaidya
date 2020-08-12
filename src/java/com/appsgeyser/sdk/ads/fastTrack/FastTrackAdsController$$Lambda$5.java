/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
package com.appsgeyser.sdk.ads.fastTrack;

import com.appsgeyser.sdk.ads.fastTrack.FastTrackAdsController;

final class FastTrackAdsController$$Lambda$5
implements Runnable {
    private final FastTrackAdsController arg$1;
    private final String arg$2;
    private final String arg$3;
    private final boolean arg$4;

    private FastTrackAdsController$$Lambda$5(FastTrackAdsController fastTrackAdsController, String string2, String string3, boolean bl) {
        this.arg$1 = fastTrackAdsController;
        this.arg$2 = string2;
        this.arg$3 = string3;
        this.arg$4 = bl;
    }

    public static Runnable lambdaFactory$(FastTrackAdsController fastTrackAdsController, String string2, String string3, boolean bl) {
        return new FastTrackAdsController$$Lambda$5(fastTrackAdsController, string2, string3, bl);
    }

    public void run() {
        FastTrackAdsController.lambda$showFullscreen$3(this.arg$1, this.arg$2, this.arg$3, this.arg$4);
    }
}

