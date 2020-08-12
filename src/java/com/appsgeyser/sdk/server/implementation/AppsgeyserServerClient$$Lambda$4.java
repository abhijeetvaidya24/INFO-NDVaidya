/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.view.View$OnClickListener
 *  com.appsgeyser.sdk.rateme.RatingDialog
 *  java.lang.Object
 */
package com.appsgeyser.sdk.server.implementation;

import android.content.Context;
import android.view.View;
import com.appsgeyser.sdk.rateme.RatingDialog;
import com.appsgeyser.sdk.server.implementation.AppsgeyserServerClient;

final class AppsgeyserServerClient$$Lambda$4
implements View.OnClickListener {
    private final Context arg$1;
    private final RatingDialog arg$2;

    private AppsgeyserServerClient$$Lambda$4(Context context, RatingDialog ratingDialog) {
        this.arg$1 = context;
        this.arg$2 = ratingDialog;
    }

    public static View.OnClickListener lambdaFactory$(Context context, RatingDialog ratingDialog) {
        return new AppsgeyserServerClient$$Lambda$4(context, ratingDialog);
    }

    public void onClick(View view) {
        AppsgeyserServerClient.lambda$null$1(this.arg$1, this.arg$2, view);
    }
}

