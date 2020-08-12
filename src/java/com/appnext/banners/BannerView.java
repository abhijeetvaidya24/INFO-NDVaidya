/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  com.appnext.banners.g
 */
package com.appnext.banners;

import android.content.Context;
import android.util.AttributeSet;
import com.appnext.banners.BannerAdRequest;
import com.appnext.banners.BaseBannerView;
import com.appnext.banners.e;
import com.appnext.banners.g;
import com.appnext.core.callbacks.OnECPMLoaded;

public class BannerView
extends BaseBannerView {
    public BannerView(Context context) {
        super(context);
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BannerView(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
    }

    public BannerView(Context context, AttributeSet attributeSet, int n2, int n3) {
        super(context, attributeSet, n2, n3);
    }

    @Override
    protected e getBannerAdapter() {
        if (this.bannerAdapter == null) {
            this.bannerAdapter = new g();
        }
        return this.bannerAdapter;
    }

    @Override
    public void getECPM(BannerAdRequest bannerAdRequest, OnECPMLoaded onECPMLoaded) {
        super.getECPM(bannerAdRequest, onECPMLoaded);
    }
}

