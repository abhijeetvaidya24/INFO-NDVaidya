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
import com.appsgeyser.sdk.ui.AppsgeyserProgressDialog;

final class FastTrackAdinCubeAdapter$$Lambda$2
implements Runnable {
    private final FastTrackAdinCubeAdapter arg$1;
    private final AppsgeyserProgressDialog arg$2;

    private FastTrackAdinCubeAdapter$$Lambda$2(FastTrackAdinCubeAdapter fastTrackAdinCubeAdapter, AppsgeyserProgressDialog appsgeyserProgressDialog) {
        this.arg$1 = fastTrackAdinCubeAdapter;
        this.arg$2 = appsgeyserProgressDialog;
    }

    public static Runnable lambdaFactory$(FastTrackAdinCubeAdapter fastTrackAdinCubeAdapter, AppsgeyserProgressDialog appsgeyserProgressDialog) {
        return new FastTrackAdinCubeAdapter$$Lambda$2(fastTrackAdinCubeAdapter, appsgeyserProgressDialog);
    }

    public void run() {
        FastTrackAdinCubeAdapter.lambda$showFullscreen$0((FastTrackAdinCubeAdapter)this.arg$1, (AppsgeyserProgressDialog)this.arg$2);
    }
}

