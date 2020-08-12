/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.appsgeyser.sdk.ads.fastTrack.adapters.FastTrackMopubAdapter
 *  com.appsgeyser.sdk.ads.fastTrack.adapters.FastTrackMopubAdapter$6
 *  java.lang.Object
 *  java.lang.Runnable
 */
package com.appsgeyser.sdk.ads.fastTrack.adapters;

import com.appsgeyser.sdk.ads.fastTrack.adapters.FastTrackMopubAdapter;

final class FastTrackMopubAdapter$6$$Lambda$1
implements Runnable {
    private final FastTrackMopubAdapter.6 arg$1;

    private FastTrackMopubAdapter$6$$Lambda$1(FastTrackMopubAdapter.6 var1_1) {
        this.arg$1 = var1_1;
    }

    public static Runnable lambdaFactory$(FastTrackMopubAdapter.6 var0) {
        return new FastTrackMopubAdapter$6$$Lambda$1(var0);
    }

    public void run() {
        FastTrackMopubAdapter.6.lambda$onRewardedVideoLoadFailure$0((FastTrackMopubAdapter.6)this.arg$1);
    }
}

