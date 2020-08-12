/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters
 *  java.lang.Object
 *  java.lang.String
 */
package com.applovin.mediation.adapter;

import android.app.Activity;
import com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters;

public interface MaxAdapter {
    public String getAdapterVersion();

    public String getSdkVersion();

    public void initialize(MaxAdapterInitializationParameters var1, Activity var2, OnCompletionListener var3);

    public void onDestroy();

    public static interface OnCompletionListener {
        public void onCompletion();
    }

}

