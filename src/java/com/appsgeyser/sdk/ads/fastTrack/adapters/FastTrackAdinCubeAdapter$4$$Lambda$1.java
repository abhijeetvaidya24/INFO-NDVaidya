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
import com.appsgeyser.sdk.ui.AppsgeyserProgressDialog;

final class FastTrackAdinCubeAdapter$4$$Lambda$1
implements Runnable {
    private final FastTrackAdinCubeAdapter.4 arg$1;
    private final AppsgeyserProgressDialog arg$2;

    private FastTrackAdinCubeAdapter$4$$Lambda$1(FastTrackAdinCubeAdapter.4 var1_1, AppsgeyserProgressDialog appsgeyserProgressDialog) {
        this.arg$1 = var1_1;
        this.arg$2 = appsgeyserProgressDialog;
    }

    public static Runnable lambdaFactory$(FastTrackAdinCubeAdapter.4 var0, AppsgeyserProgressDialog appsgeyserProgressDialog) {
        return new FastTrackAdinCubeAdapter$4$$Lambda$1(var0, appsgeyserProgressDialog);
    }

    public void run() {
        FastTrackAdinCubeAdapter.4.lambda$onAdCached$0((FastTrackAdinCubeAdapter.4)this.arg$1, (AppsgeyserProgressDialog)this.arg$2);
    }
}

