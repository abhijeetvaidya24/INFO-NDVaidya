/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.appsgeyser.sdk.ads.fastTrack.adapters.FastTrackAdinCubeAdapter
 *  java.lang.Object
 *  java.lang.Runnable
 */
package com.appsgeyser.sdk.ads.fastTrack.adapters;

import com.appsgeyser.sdk.ads.fastTrack.adapters.FastTrackAdinCubeAdapter;

final class FastTrackAdinCubeAdapter$$Lambda$1
implements Runnable {
    private final FastTrackAdinCubeAdapter arg$1;

    private FastTrackAdinCubeAdapter$$Lambda$1(FastTrackAdinCubeAdapter fastTrackAdinCubeAdapter) {
        this.arg$1 = fastTrackAdinCubeAdapter;
    }

    public static Runnable lambdaFactory$(FastTrackAdinCubeAdapter fastTrackAdinCubeAdapter) {
        return new FastTrackAdinCubeAdapter$$Lambda$1(fastTrackAdinCubeAdapter);
    }

    public void run() {
        FastTrackAdinCubeAdapter.lambda$new$1((FastTrackAdinCubeAdapter)this.arg$1);
    }
}

