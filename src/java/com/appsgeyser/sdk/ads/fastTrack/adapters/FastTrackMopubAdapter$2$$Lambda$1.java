/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.appsgeyser.sdk.ads.fastTrack.adapters.FastTrackMopubAdapter
 *  com.appsgeyser.sdk.ads.fastTrack.adapters.FastTrackMopubAdapter$2
 *  java.lang.Object
 *  java.lang.Runnable
 */
package com.appsgeyser.sdk.ads.fastTrack.adapters;

import com.appsgeyser.sdk.ads.fastTrack.adapters.FastTrackMopubAdapter;

final class FastTrackMopubAdapter$2$$Lambda$1
implements Runnable {
    private final FastTrackMopubAdapter.2 arg$1;

    private FastTrackMopubAdapter$2$$Lambda$1(FastTrackMopubAdapter.2 var1_1) {
        this.arg$1 = var1_1;
    }

    public static Runnable lambdaFactory$(FastTrackMopubAdapter.2 var0) {
        return new FastTrackMopubAdapter$2$$Lambda$1(var0);
    }

    public void run() {
        FastTrackMopubAdapter.2.lambda$onBannerClicked$0((FastTrackMopubAdapter.2)this.arg$1);
    }
}

