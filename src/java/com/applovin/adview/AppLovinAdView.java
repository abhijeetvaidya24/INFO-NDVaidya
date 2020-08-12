/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Color
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.util.Log
 *  android.util.TypedValue
 *  android.view.View
 *  android.widget.RelativeLayout
 *  android.widget.TextView
 *  com.applovin.impl.adview.AdViewControllerImpl
 *  com.applovin.sdk.AppLovinAd
 *  com.applovin.sdk.AppLovinAdClickListener
 *  com.applovin.sdk.AppLovinAdDisplayListener
 *  com.applovin.sdk.AppLovinAdLoadListener
 *  com.applovin.sdk.AppLovinAdSize
 *  com.applovin.sdk.AppLovinAdVideoPlaybackListener
 *  com.applovin.sdk.AppLovinSdk
 *  java.lang.CharSequence
 *  java.lang.Deprecated
 *  java.lang.String
 */
package com.applovin.adview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.applovin.adview.AdViewController;
import com.applovin.adview.AppLovinAdViewEventListener;
import com.applovin.impl.adview.AdViewControllerImpl;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdk;

public class AppLovinAdView
extends RelativeLayout {
    public static final String NAMESPACE = "http://schemas.applovin.com/android/1.0";
    private AdViewController a;

    public AppLovinAdView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppLovinAdView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.a(null, null, null, context, attributeSet);
    }

    public AppLovinAdView(AppLovinAdSize appLovinAdSize, Context context) {
        this(appLovinAdSize, null, context);
    }

    public AppLovinAdView(AppLovinAdSize appLovinAdSize, String string, Context context) {
        super(context);
        this.a(appLovinAdSize, string, null, context, null);
    }

    public AppLovinAdView(AppLovinSdk appLovinSdk, AppLovinAdSize appLovinAdSize, Context context) {
        this(appLovinSdk, appLovinAdSize, null, context);
    }

    public AppLovinAdView(AppLovinSdk appLovinSdk, AppLovinAdSize appLovinAdSize, String string, Context context) {
        super(context);
        this.a(appLovinAdSize, string, appLovinSdk, context, null);
    }

    private void a(AttributeSet attributeSet, Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int n = displayMetrics.widthPixels;
        int n2 = (int)TypedValue.applyDimension((int)1, (float)50.0f, (DisplayMetrics)displayMetrics);
        TextView textView = new TextView(context);
        textView.setBackgroundColor(Color.rgb((int)220, (int)220, (int)220));
        textView.setTextColor(-16777216);
        textView.setText((CharSequence)"AppLovin Ad");
        textView.setGravity(17);
        this.addView((View)textView, n, n2);
    }

    private void a(AppLovinAdSize appLovinAdSize, String string, AppLovinSdk appLovinSdk, Context context, AttributeSet attributeSet) {
        if (!this.isInEditMode()) {
            AdViewControllerImpl adViewControllerImpl = new AdViewControllerImpl();
            adViewControllerImpl.initializeAdView(this, context, appLovinAdSize, string, appLovinSdk, attributeSet);
            this.a = adViewControllerImpl;
            return;
        }
        this.a(attributeSet, context);
    }

    public void destroy() {
        AdViewController adViewController = this.a;
        if (adViewController != null) {
            adViewController.destroy();
        }
    }

    @Deprecated
    public AdViewController getAdViewController() {
        return this.a;
    }

    public AppLovinAdSize getSize() {
        AdViewController adViewController = this.a;
        if (adViewController != null) {
            return adViewController.getSize();
        }
        return null;
    }

    public String getZoneId() {
        AdViewController adViewController = this.a;
        if (adViewController != null) {
            return adViewController.getZoneId();
        }
        return null;
    }

    @Deprecated
    public boolean isAdReadyToDisplay() {
        AdViewController adViewController = this.a;
        return adViewController != null && adViewController.isAdReadyToDisplay();
    }

    public void loadNextAd() {
        AdViewController adViewController = this.a;
        if (adViewController != null) {
            adViewController.loadNextAd();
            return;
        }
        Log.i((String)"AppLovinSdk", (String)"Unable to load next ad: AppLovinAdView is not initialized.");
    }

    protected void onDetachedFromWindow() {
        AdViewController adViewController = this.a;
        if (adViewController != null) {
            adViewController.onDetachedFromWindow();
        }
        super.onDetachedFromWindow();
    }

    protected void onVisibilityChanged(View view, int n) {
        super.onVisibilityChanged(view, n);
        AdViewController adViewController = this.a;
        if (adViewController != null) {
            adViewController.onVisibilityChanged(n);
        }
    }

    public void pause() {
        AdViewController adViewController = this.a;
        if (adViewController != null) {
            adViewController.pause();
        }
    }

    public void renderAd(AppLovinAd appLovinAd) {
        this.renderAd(appLovinAd, null);
    }

    @Deprecated
    public void renderAd(AppLovinAd appLovinAd, String string) {
        AdViewController adViewController = this.a;
        if (adViewController != null) {
            adViewController.renderAd(appLovinAd, string);
        }
    }

    public void resume() {
        AdViewController adViewController = this.a;
        if (adViewController != null) {
            adViewController.resume();
        }
    }

    public void setAdClickListener(AppLovinAdClickListener appLovinAdClickListener) {
        AdViewController adViewController = this.a;
        if (adViewController != null) {
            adViewController.setAdClickListener(appLovinAdClickListener);
        }
    }

    public void setAdDisplayListener(AppLovinAdDisplayListener appLovinAdDisplayListener) {
        AdViewController adViewController = this.a;
        if (adViewController != null) {
            adViewController.setAdDisplayListener(appLovinAdDisplayListener);
        }
    }

    public void setAdLoadListener(AppLovinAdLoadListener appLovinAdLoadListener) {
        AdViewController adViewController = this.a;
        if (adViewController != null) {
            adViewController.setAdLoadListener(appLovinAdLoadListener);
        }
    }

    public void setAdVideoPlaybackListener(AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        AdViewController adViewController = this.a;
        if (adViewController != null) {
            adViewController.setAdVideoPlaybackListener(appLovinAdVideoPlaybackListener);
        }
    }

    public void setAdViewEventListener(AppLovinAdViewEventListener appLovinAdViewEventListener) {
        AdViewController adViewController = this.a;
        if (adViewController != null) {
            adViewController.setAdViewEventListener(appLovinAdViewEventListener);
        }
    }

    public void setAutoDestroy(boolean bl) {
        AdViewController adViewController = this.a;
        if (adViewController != null) {
            adViewController.setAutoDestroy(bl);
        }
    }
}

