/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Color
 *  android.text.TextUtils
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.util.TypedValue
 *  android.view.View
 *  android.widget.RelativeLayout
 *  android.widget.TextView
 *  com.applovin.impl.mediation.ads.MaxAdViewImpl
 *  com.applovin.mediation.MaxAdViewAdListener
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.String
 */
package com.applovin.mediation.ads;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.applovin.impl.mediation.ads.MaxAdViewImpl;
import com.applovin.impl.sdk.e.m;
import com.applovin.impl.sdk.j;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.sdk.AppLovinSdk;

public class MaxAdView
extends RelativeLayout {
    private MaxAdViewImpl a;

    public MaxAdView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaxAdView(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        String string2 = attributeSet.getAttributeValue("http://schemas.applovin.com/android/1.0", "adUnitId");
        if (string2 != null) {
            if (!TextUtils.isEmpty((CharSequence)string2)) {
                if (context instanceof Activity) {
                    Activity activity = (Activity)context;
                    this.a(string2, AppLovinSdk.getInstance((Context)activity), activity);
                    return;
                }
                throw new IllegalArgumentException("Max ad view context is not an activity");
            }
            throw new IllegalArgumentException("Empty ad unit ID specified");
        }
        throw new IllegalArgumentException("No ad unit ID specified");
    }

    public MaxAdView(String string2, Activity activity) {
        this(string2, AppLovinSdk.getInstance((Context)activity), activity);
    }

    public MaxAdView(String string2, AppLovinSdk appLovinSdk, Activity activity) {
        super((Context)activity);
        this.a(string2, appLovinSdk, activity);
    }

    private void a(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int n2 = displayMetrics.widthPixels;
        int n3 = (int)TypedValue.applyDimension((int)1, (float)50.0f, (DisplayMetrics)displayMetrics);
        TextView textView = new TextView(context);
        textView.setBackgroundColor(Color.rgb((int)220, (int)220, (int)220));
        textView.setTextColor(-16777216);
        textView.setText((CharSequence)"Max Ad");
        textView.setGravity(17);
        this.addView((View)textView, n2, n3);
    }

    private void a(String string2, AppLovinSdk appLovinSdk, Activity activity) {
        if (!this.isInEditMode()) {
            this.a = new MaxAdViewImpl(string2, this, m.a(appLovinSdk), activity);
            return;
        }
        this.a((Context)activity);
    }

    public void destroy() {
        this.a.destroy();
    }

    public void loadAd() {
        this.a.loadAd();
    }

    public void setExtraParameter(String string2, String string3) {
        this.a.setExtraParameter(string2, string3);
    }

    public void setListener(MaxAdViewAdListener maxAdViewAdListener) {
        this.a.setListener((MaxAdListener)maxAdViewAdListener);
    }

    public void startAutoRefresh() {
        this.a.startAutoRefresh();
    }

    public void stopAutoRefresh() {
        this.a.stopAutoRefresh();
    }
}

