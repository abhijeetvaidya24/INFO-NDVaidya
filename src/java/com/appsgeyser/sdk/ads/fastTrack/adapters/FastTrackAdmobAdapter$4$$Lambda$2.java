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
import com.appsgeyser.sdk.ui.AppsgeyserProgressDialog;

final class FastTrackAdmobAdapter$4$$Lambda$2
implements Runnable {
    private final FastTrackAdmobAdapter.4 arg$1;
    private final AppsgeyserProgressDialog arg$2;

    private FastTrackAdmobAdapter$4$$Lambda$2(FastTrackAdmobAdapter.4 var1_1, AppsgeyserProgressDialog appsgeyserProgressDialog) {
        this.arg$1 = var1_1;
        this.arg$2 = appsgeyserProgressDialog;
    }

    public static Runnable lambdaFactory$(FastTrackAdmobAdapter.4 var0, AppsgeyserProgressDialog appsgeyserProgressDialog) {
        return new FastTrackAdmobAdapter$4$$Lambda$2(var0, appsgeyserProgressDialog);
    }

    public void run() {
        FastTrackAdmobAdapter.4.lambda$onAdLoaded$1((FastTrackAdmobAdapter.4)this.arg$1, (AppsgeyserProgressDialog)this.arg$2);
    }
}

