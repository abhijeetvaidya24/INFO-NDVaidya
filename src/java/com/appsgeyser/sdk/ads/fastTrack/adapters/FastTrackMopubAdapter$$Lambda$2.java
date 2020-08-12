/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.appsgeyser.sdk.ads.fastTrack.adapters.FastTrackMopubAdapter
 *  java.lang.Object
 *  java.lang.Runnable
 */
package com.appsgeyser.sdk.ads.fastTrack.adapters;

import com.appsgeyser.sdk.ads.fastTrack.adapters.FastTrackMopubAdapter;

final class FastTrackMopubAdapter$$Lambda$2
implements Runnable {
    private final FastTrackMopubAdapter arg$1;

    private FastTrackMopubAdapter$$Lambda$2(FastTrackMopubAdapter fastTrackMopubAdapter) {
        this.arg$1 = fastTrackMopubAdapter;
    }

    public static Runnable lambdaFactory$(FastTrackMopubAdapter fastTrackMopubAdapter) {
        return new FastTrackMopubAdapter$$Lambda$2(fastTrackMopubAdapter);
    }

    public void run() {
        FastTrackMopubAdapter.lambda$new$2((FastTrackMopubAdapter)this.arg$1);
    }
}

