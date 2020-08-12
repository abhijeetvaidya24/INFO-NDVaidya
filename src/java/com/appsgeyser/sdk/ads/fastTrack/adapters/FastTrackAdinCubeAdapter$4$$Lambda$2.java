/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.appsgeyser.sdk.ads.fastTrack.adapters.FastTrackAdinCubeAdapter
 *  com.appsgeyser.sdk.ads.fastTrack.adapters.FastTrackAdinCubeAdapter$4
 *  java.lang.Object
 *  java.lang.Runnable
 */
package com.appsgeyser.sdk.ads.fastTrack.adapters;

import com.appsgeyser.sdk.ads.fastTrack.adapters.FastTrackAdinCubeAdapter;

final class FastTrackAdinCubeAdapter$4$$Lambda$2
implements Runnable {
    private final FastTrackAdinCubeAdapter.4 arg$1;

    private FastTrackAdinCubeAdapter$4$$Lambda$2(FastTrackAdinCubeAdapter.4 var1_1) {
        this.arg$1 = var1_1;
    }

    public static Runnable lambdaFactory$(FastTrackAdinCubeAdapter.4 var0) {
        return new FastTrackAdinCubeAdapter$4$$Lambda$2(var0);
    }

    public void run() {
        FastTrackAdinCubeAdapter.4.lambda$onError$1((FastTrackAdinCubeAdapter.4)this.arg$1);
    }
}

