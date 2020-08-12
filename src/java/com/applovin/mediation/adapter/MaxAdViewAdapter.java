/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
 *  com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters
 *  java.lang.Object
 */
package com.applovin.mediation.adapter;

import android.app.Activity;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;

public interface MaxAdViewAdapter {
    public void loadAdViewAd(MaxAdapterResponseParameters var1, MaxAdFormat var2, Activity var3, MaxAdViewAdapterListener var4);
}

