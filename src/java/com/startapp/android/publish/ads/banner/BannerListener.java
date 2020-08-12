/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  java.lang.Object
 */
package com.startapp.android.publish.ads.banner;

import android.view.View;

public interface BannerListener {
    public void onClick(View var1);

    public void onFailedToReceiveAd(View var1);

    public void onReceiveAd(View var1);
}

