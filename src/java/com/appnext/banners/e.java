/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.graphics.Rect
 *  android.net.Uri
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewParent
 *  com.appnext.banners.BannerAdRequest
 *  com.appnext.core.callbacks.OnECPMLoaded
 *  java.lang.Double
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 */
package com.appnext.banners;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.appnext.banners.BannerAdRequest;
import com.appnext.banners.BannerListener;
import com.appnext.banners.BannerSize;
import com.appnext.core.callbacks.OnECPMLoaded;

public abstract class e {
    private BannerListener bannerListener;
    private BannerSize bannerSize;
    protected Context context;
    private String language;
    private String placementId;
    protected ViewGroup rootView;

    private boolean isViewPartiallyVisible(View view) {
        try {
            if (this.rootView.getParent() == null) {
            }
            Rect rect = new Rect();
            ((ViewGroup)this.rootView.getParent()).getHitRect(rect);
            boolean bl = view.getLocalVisibleRect(rect);
            return bl;
        }
        finally {
            return false;
        }
    }

    public abstract void click();

    public void destroy() {
        this.context = null;
    }

    public BannerListener getBannerListener() {
        return this.bannerListener;
    }

    public BannerSize getBannerSize() {
        return this.bannerSize;
    }

    public abstract void getECPM(BannerAdRequest var1, OnECPMLoaded var2);

    public String getLanguage() {
        return this.language;
    }

    public String getPlacementId() {
        return this.placementId;
    }

    public int getVisiblePercent(View view) {
        if (!this.isViewPartiallyVisible((View)this.rootView)) {
            return 0;
        }
        if (this.rootView.getWindowVisibility() != 8) {
            if (this.rootView.getWindowVisibility() == 4) {
                return 0;
            }
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            double d2 = rect.width() * rect.height();
            double d3 = view.getWidth() * view.getHeight();
            Double.isNaN((double)d2);
            double d4 = d2 * 100.0;
            Double.isNaN((double)d3);
            return (int)(d4 / d3);
        }
        return 0;
    }

    public abstract void impression();

    public void init(ViewGroup viewGroup) {
        this.rootView = viewGroup;
        this.context = viewGroup.getContext();
    }

    public boolean isClickEnabled() {
        return false;
    }

    public abstract void loadAd(BannerAdRequest var1);

    public void onScrollChanged(int n2) {
    }

    protected void onWindowVisibilityChanged(int n2) {
    }

    protected void openLink(String string2) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse((String)string2));
        intent.addFlags(268435456);
        this.context.startActivity(intent);
    }

    public void parseAttributeSet(AttributeSet attributeSet) {
    }

    public void pause() {
    }

    public void play() {
    }

    public void setBannerListener(BannerListener bannerListener) {
        this.bannerListener = bannerListener;
    }

    public void setBannerSize(BannerSize bannerSize) {
        if (bannerSize != null) {
            if (this.bannerSize == null) {
                this.bannerSize = bannerSize;
                return;
            }
            throw new IllegalStateException("The banner size can only be set once.");
        }
        throw new IllegalArgumentException("The placement id cannot be null.");
    }

    public void setClickEnabled(boolean bl) {
    }

    public void setLanguage(String string2) {
        this.language = string2;
    }

    public void setPlacementId(String string2) {
        if (string2 != null) {
            if (this.placementId == null) {
                this.placementId = string2;
                return;
            }
            throw new IllegalStateException("The placement id can only be set once.");
        }
        throw new IllegalArgumentException("The placement id cannot be null.");
    }
}

