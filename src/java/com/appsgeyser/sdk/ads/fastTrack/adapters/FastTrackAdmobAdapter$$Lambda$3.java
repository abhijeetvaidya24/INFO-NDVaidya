/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.appsgeyser.sdk.ads.fastTrack.adapters.FastTrackAdmobAdapter
 *  java.lang.Object
 *  java.lang.Runnable
 */
package com.appsgeyser.sdk.ads.fastTrack.adapters;

import com.appsgeyser.sdk.ads.fastTrack.adapters.FastTrackAdmobAdapter;
import com.appsgeyser.sdk.ui.AppsgeyserProgressDialog;

final class FastTrackAdmobAdapter$$Lambda$3
implements Runnable {
    private final FastTrackAdmobAdapter arg$1;
    private final AppsgeyserProgressDialog arg$2;

    private FastTrackAdmobAdapter$$Lambda$3(FastTrackAdmobAdapter fastTrackAdmobAdapter, AppsgeyserProgressDialog appsgeyserProgressDialog) {
        this.arg$1 = fastTrackAdmobAdapter;
        this.arg$2 = appsgeyserProgressDialog;
    }

    public static Runnable lambdaFactory$(FastTrackAdmobAdapter fastTrackAdmobAdapter, AppsgeyserProgressDialog appsgeyserProgressDialog) {
        return new FastTrackAdmobAdapter$$Lambda$3(fastTrackAdmobAdapter, appsgeyserProgressDialog);
    }

    public void run() {
        FastTrackAdmobAdapter.lambda$showFullscreen$0((FastTrackAdmobAdapter)this.arg$1, (AppsgeyserProgressDialog)this.arg$2);
    }
}

