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
import com.appsgeyser.sdk.ui.AppsgeyserProgressDialog;

final class FastTrackMopubAdapter$5$$Lambda$1
implements Runnable {
    private final FastTrackMopubAdapter.5 arg$1;
    private final AppsgeyserProgressDialog arg$2;

    private FastTrackMopubAdapter$5$$Lambda$1(FastTrackMopubAdapter.5 var1_1, AppsgeyserProgressDialog appsgeyserProgressDialog) {
        this.arg$1 = var1_1;
        this.arg$2 = appsgeyserProgressDialog;
    }

    public static Runnable lambdaFactory$(FastTrackMopubAdapter.5 var0, AppsgeyserProgressDialog appsgeyserProgressDialog) {
        return new FastTrackMopubAdapter$5$$Lambda$1(var0, appsgeyserProgressDialog);
    }

    public void run() {
        FastTrackMopubAdapter.5.lambda$onInterstitialLoaded$0((FastTrackMopubAdapter.5)this.arg$1, (AppsgeyserProgressDialog)this.arg$2);
    }
}

