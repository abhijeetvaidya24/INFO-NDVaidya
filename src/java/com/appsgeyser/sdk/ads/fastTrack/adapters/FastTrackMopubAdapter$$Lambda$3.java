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
import com.appsgeyser.sdk.ui.AppsgeyserProgressDialog;

final class FastTrackMopubAdapter$$Lambda$3
implements Runnable {
    private final FastTrackMopubAdapter arg$1;
    private final AppsgeyserProgressDialog arg$2;

    private FastTrackMopubAdapter$$Lambda$3(FastTrackMopubAdapter fastTrackMopubAdapter, AppsgeyserProgressDialog appsgeyserProgressDialog) {
        this.arg$1 = fastTrackMopubAdapter;
        this.arg$2 = appsgeyserProgressDialog;
    }

    public static Runnable lambdaFactory$(FastTrackMopubAdapter fastTrackMopubAdapter, AppsgeyserProgressDialog appsgeyserProgressDialog) {
        return new FastTrackMopubAdapter$$Lambda$3(fastTrackMopubAdapter, appsgeyserProgressDialog);
    }

    public void run() {
        FastTrackMopubAdapter.lambda$showFullscreen$0((FastTrackMopubAdapter)this.arg$1, (AppsgeyserProgressDialog)this.arg$2);
    }
}

