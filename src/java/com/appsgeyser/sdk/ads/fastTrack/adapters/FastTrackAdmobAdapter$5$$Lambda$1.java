/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.appsgeyser.sdk.ads.fastTrack.adapters.FastTrackAdmobAdapter
 *  com.appsgeyser.sdk.ads.fastTrack.adapters.FastTrackAdmobAdapter$5
 *  java.lang.Object
 *  java.lang.Runnable
 */
package com.appsgeyser.sdk.ads.fastTrack.adapters;

import com.appsgeyser.sdk.ads.fastTrack.adapters.FastTrackAdmobAdapter;

final class FastTrackAdmobAdapter$5$$Lambda$1
implements Runnable {
    private final FastTrackAdmobAdapter.5 arg$1;

    private FastTrackAdmobAdapter$5$$Lambda$1(FastTrackAdmobAdapter.5 var1_1) {
        this.arg$1 = var1_1;
    }

    public static Runnable lambdaFactory$(FastTrackAdmobAdapter.5 var0) {
        return new FastTrackAdmobAdapter$5$$Lambda$1(var0);
    }

    public void run() {
        FastTrackAdmobAdapter.5.lambda$onRewardedVideoAdFailedToLoad$0((FastTrackAdmobAdapter.5)this.arg$1);
    }
}

