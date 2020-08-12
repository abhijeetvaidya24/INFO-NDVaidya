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

final class FastTrackAdmobAdapter$$Lambda$2
implements Runnable {
    private final FastTrackAdmobAdapter arg$1;

    private FastTrackAdmobAdapter$$Lambda$2(FastTrackAdmobAdapter fastTrackAdmobAdapter) {
        this.arg$1 = fastTrackAdmobAdapter;
    }

    public static Runnable lambdaFactory$(FastTrackAdmobAdapter fastTrackAdmobAdapter) {
        return new FastTrackAdmobAdapter$$Lambda$2(fastTrackAdmobAdapter);
    }

    public void run() {
        FastTrackAdmobAdapter.lambda$new$2((FastTrackAdmobAdapter)this.arg$1);
    }
}

