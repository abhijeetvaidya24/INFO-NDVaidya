/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.appsgeyser.sdk.ads.fastTrack.adapters.FastTrackAdmobAdapter
 *  com.appsgeyser.sdk.ads.fastTrack.adapters.FastTrackAdmobAdapter$4
 *  java.lang.Object
 *  java.lang.Runnable
 */
package com.appsgeyser.sdk.ads.fastTrack.adapters;

import com.appsgeyser.sdk.ads.fastTrack.adapters.FastTrackAdmobAdapter;

final class FastTrackAdmobAdapter$4$$Lambda$1
implements Runnable {
    private final FastTrackAdmobAdapter.4 arg$1;

    private FastTrackAdmobAdapter$4$$Lambda$1(FastTrackAdmobAdapter.4 var1_1) {
        this.arg$1 = var1_1;
    }

    public static Runnable lambdaFactory$(FastTrackAdmobAdapter.4 var0) {
        return new FastTrackAdmobAdapter$4$$Lambda$1(var0);
    }

    public void run() {
        FastTrackAdmobAdapter.4.lambda$onAdFailedToLoad$0((FastTrackAdmobAdapter.4)this.arg$1);
    }
}

