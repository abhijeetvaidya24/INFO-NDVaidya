/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  com.applovin.mediation.adapter.parameters.MaxAdapterSignalCollectionParameters
 *  java.lang.Object
 */
package com.applovin.mediation.adapter;

import android.app.Activity;
import com.applovin.mediation.adapter.listeners.MaxSignalCollectionListener;
import com.applovin.mediation.adapter.parameters.MaxAdapterSignalCollectionParameters;

public interface MaxSignalProvider {
    public void collectSignal(MaxAdapterSignalCollectionParameters var1, Activity var2, MaxSignalCollectionListener var3);
}

