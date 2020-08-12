/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  java.lang.Object
 */
package com.applovin.mediation.adapter.listeners;

import android.view.View;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.mediation.adapter.listeners.MaxAdapterListener;

public interface MaxAdViewAdapterListener
extends MaxAdapterListener {
    public void onAdViewAdClicked();

    public void onAdViewAdCollapsed();

    public void onAdViewAdDisplayFailed(MaxAdapterError var1);

    public void onAdViewAdDisplayed();

    public void onAdViewAdExpanded();

    public void onAdViewAdHidden();

    public void onAdViewAdLoadFailed(MaxAdapterError var1);

    public void onAdViewAdLoaded(View var1);
}

