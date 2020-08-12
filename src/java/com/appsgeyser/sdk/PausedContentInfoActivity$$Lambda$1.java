/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  java.lang.Object
 */
package com.appsgeyser.sdk;

import android.view.View;
import com.appsgeyser.sdk.PausedContentInfoActivity;

final class PausedContentInfoActivity$$Lambda$1
implements View.OnClickListener {
    private final PausedContentInfoActivity arg$1;

    private PausedContentInfoActivity$$Lambda$1(PausedContentInfoActivity pausedContentInfoActivity) {
        this.arg$1 = pausedContentInfoActivity;
    }

    public static View.OnClickListener lambdaFactory$(PausedContentInfoActivity pausedContentInfoActivity) {
        return new PausedContentInfoActivity$$Lambda$1(pausedContentInfoActivity);
    }

    public void onClick(View view) {
        PausedContentInfoActivity.lambda$onCreate$0(this.arg$1, view);
    }
}

