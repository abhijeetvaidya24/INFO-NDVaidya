/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.appsgeyser.sdk.ads.fastTrack.adapters.FastTrackMopubAdapter
 *  com.appsgeyser.sdk.ads.fastTrack.adapters.FastTrackMopubAdapter$5
 *  java.lang.Object
 *  java.lang.Runnable
 */
package com.appsgeyser.sdk.ads.fastTrack.adapters;

import com.appsgeyser.sdk.ads.fastTrack.adapters.FastTrackMopubAdapter;

final class FastTrackMopubAdapter$5$$Lambda$2
implements Runnable {
    private final FastTrackMopubAdapter.5 arg$1;

    private FastTrackMopubAdapter$5$$Lambda$2(FastTrackMopubAdapter.5 var1_1) {
        this.arg$1 = var1_1;
    }

    public static Runnable lambdaFactory$(FastTrackMopubAdapter.5 var0) {
        return new FastTrackMopubAdapter$5$$Lambda$2(var0);
    }

    public void run() {
        FastTrackMopubAdapter.5.lambda$onInterstitialFailed$1((FastTrackMopubAdapter.5)this.arg$1);
    }
}

