/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.graphics.Canvas
 *  android.graphics.Rect
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewParent
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnScrollChangedListener
 *  com.appnext.banners.BannerAdRequest
 *  com.appnext.banners.BaseBannerView$2
 *  com.appnext.banners.d
 *  com.appnext.core.callbacks.OnECPMLoaded
 *  com.appnext.core.p
 *  com.appnext.core.p$a
 *  java.lang.Double
 *  java.lang.IllegalArgumentException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package com.appnext.banners;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import com.appnext.banners.BannerAdRequest;
import com.appnext.banners.BannerListener;
import com.appnext.banners.BannerSize;
import com.appnext.banners.BaseBannerView;
import com.appnext.banners.R;
import com.appnext.banners.d;
import com.appnext.banners.e;
import com.appnext.core.callbacks.OnECPMLoaded;
import com.appnext.core.p;

public abstract class BaseBannerView
extends ViewGroup {
    protected e bannerAdapter;
    private BannerListener bannerListener;
    private String language;
    ViewTreeObserver.OnScrollChangedListener onScrollChangedListener = new ViewTreeObserver.OnScrollChangedListener(){

        public final void onScrollChanged() {
            BaseBannerView.this.impression();
            BaseBannerView.this.onScrollChanged();
        }
    };

    public BaseBannerView(Context context) {
        super(context);
        if (context != null) {
            this.parseAttributeSet(null);
            return;
        }
        throw new IllegalArgumentException("The context cannot be null.");
    }

    public BaseBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.parseAttributeSet(attributeSet);
    }

    public BaseBannerView(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        this.parseAttributeSet(attributeSet);
    }

    public BaseBannerView(Context context, AttributeSet attributeSet, int n2, int n3) {
        super(context, attributeSet, n2, n3);
        this.parseAttributeSet(attributeSet);
    }

    private void impression() {
        this.getBannerAdapter().impression();
    }

    private boolean isViewPartiallyVisible(View view) {
        try {
            if (this.getParent() == null) {
            }
            Rect rect = new Rect();
            ((ViewGroup)this.getParent()).getHitRect(rect);
            boolean bl = view.getLocalVisibleRect(rect);
            return bl;
        }
        finally {
            return false;
        }
    }

    private void onScrollChanged() {
        this.getBannerAdapter().onScrollChanged(this.getVisiblePercent((View)this));
    }

    /*
     * Enabled aggressive block sorting
     */
    private void parseAttributeSet(AttributeSet attributeSet) {
        String string2;
        if (this.isInEditMode()) {
            return;
        }
        this.getBannerAdapter().init(this);
        d.S().r("tid", "301");
        d.S().a(this.getContext(), null);
        this.getViewTreeObserver().addOnScrollChangedListener(this.onScrollChangedListener);
        if (attributeSet == null) {
            return;
        }
        TypedArray typedArray = this.getResources().obtainAttributes(attributeSet, R.styleable.BannersAttrs);
        String string3 = typedArray.getString(R.styleable.BannersAttrs_bannerSize);
        if (string3 != null) {
            int n2 = -1;
            int n3 = string3.hashCode();
            if (n3 != -1966536496) {
                if (n3 != -96588539) {
                    if (n3 == 1951953708 && string3.equals((Object)"BANNER")) {
                        n2 = 0;
                    }
                } else if (string3.equals((Object)"MEDIUM_RECTANGLE")) {
                    n2 = 2;
                }
            } else if (string3.equals((Object)"LARGE_BANNER")) {
                n2 = 1;
            }
            if (n2 != 0) {
                if (n2 != 1) {
                    if (n2 != 2) {
                        StringBuilder stringBuilder = new StringBuilder("Wrong banner size ");
                        stringBuilder.append(string3);
                        throw new IllegalArgumentException(stringBuilder.toString());
                    }
                    this.setBannerSize(BannerSize.MEDIUM_RECTANGLE);
                } else {
                    this.setBannerSize(BannerSize.LARGE_BANNER);
                }
            } else {
                this.setBannerSize(BannerSize.BANNER);
            }
        }
        if ((string2 = typedArray.getString(R.styleable.BannersAttrs_placementId)) != null) {
            this.setPlacementId(string2);
        }
        typedArray.recycle();
        this.getBannerAdapter().setBannerListener((BannerListener)new 2(this));
        this.getBannerAdapter().parseAttributeSet(attributeSet);
    }

    private void pause() {
        try {
            this.getBannerAdapter().pause();
        }
        catch (Throwable throwable) {}
    }

    private void play() {
        try {
            this.getBannerAdapter().play();
        }
        catch (Throwable throwable) {}
    }

    public void destroy() {
        this.getBannerAdapter().destroy();
        this.bannerAdapter = null;
        try {
            this.getViewTreeObserver().removeOnScrollChangedListener(this.onScrollChangedListener);
        }
        catch (Throwable throwable) {}
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        this.impression();
    }

    protected void finalize() throws Throwable {
        Object.super.finalize();
        this.destroy();
    }

    protected abstract e getBannerAdapter();

    BannerListener getBannerListener() {
        return this.bannerListener;
    }

    protected void getECPM(BannerAdRequest bannerAdRequest, OnECPMLoaded onECPMLoaded) {
        this.getBannerAdapter().getECPM(bannerAdRequest, onECPMLoaded);
    }

    public String getLanguage() {
        return this.language;
    }

    String getPlacementId() {
        return this.getBannerAdapter().getPlacementId();
    }

    public int getVisiblePercent(View view) {
        if (!this.isViewPartiallyVisible((View)this)) {
            return 0;
        }
        if (this.getWindowVisibility() != 8) {
            if (this.getWindowVisibility() == 4) {
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

    public boolean isClickEnabled() {
        return this.getBannerAdapter().isClickEnabled();
    }

    public void loadAd(BannerAdRequest bannerAdRequest) {
        this.getBannerAdapter().loadAd(bannerAdRequest);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.impression();
    }

    protected void onLayout(boolean bl, int n2, int n3, int n4, int n5) {
        View view = this.getChildAt(0);
        if (view != null && view.getVisibility() != 8) {
            int n6 = view.getMeasuredWidth();
            int n7 = view.getMeasuredHeight();
            int n8 = (n4 - n2 - n6) / 2;
            int n9 = (n5 - n3 - n7) / 2;
            view.layout(n8, n9, n6 + n8, n7 + n9);
        }
    }

    protected void onMeasure(int n2, int n3) {
        int n4;
        int n5 = 0;
        View view = this.getChildAt(0);
        if (view != null && view.getVisibility() != 8) {
            this.measureChild(view, n2, n3);
            n5 = view.getMeasuredWidth();
            n4 = view.getMeasuredHeight();
        } else if (this.getBannerAdapter().getBannerSize() != null) {
            Context context = this.getContext();
            int n6 = (int)((float)this.getBannerAdapter().getBannerSize().getWidth() * context.getResources().getDisplayMetrics().scaledDensity);
            n4 = (int)((float)this.getBannerAdapter().getBannerSize().getHeight() * context.getResources().getDisplayMetrics().scaledDensity);
            n5 = n6;
        } else {
            n4 = 0;
        }
        this.setMeasuredDimension(View.resolveSize((int)Math.max((int)n5, (int)this.getSuggestedMinimumWidth()), (int)n2), View.resolveSize((int)Math.max((int)n4, (int)this.getSuggestedMinimumHeight()), (int)n3));
    }

    protected void onWindowVisibilityChanged(int n2) {
        super.onWindowVisibilityChanged(n2);
        try {
            this.getBannerAdapter().onWindowVisibilityChanged(n2);
        }
        catch (Throwable throwable) {}
    }

    public void setBannerListener(BannerListener bannerListener) {
        this.getBannerAdapter().setBannerListener(bannerListener);
    }

    public void setBannerSize(BannerSize bannerSize) {
        this.getBannerAdapter().setBannerSize(bannerSize);
    }

    public void setClickEnabled(boolean bl) {
        this.getBannerAdapter().setClickEnabled(bl);
    }

    public void setLanguage(String string2) {
        this.language = string2;
        this.bannerAdapter.setLanguage(string2);
    }

    public void setParams(String string2, String string3) {
        d.S().s(string2, string3);
    }

    public void setPlacementId(String string2) {
        this.getBannerAdapter().setPlacementId(string2);
    }

}

