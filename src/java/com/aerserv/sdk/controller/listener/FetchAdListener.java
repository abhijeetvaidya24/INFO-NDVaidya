/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.aerserv.sdk.controller.listener;

import com.aerserv.sdk.model.Placement;
import com.aerserv.sdk.model.ad.ProviderAd;

public interface FetchAdListener {
    public void onAdFailed(String var1);

    public void onAdSucceeded(ProviderAd var1, Placement var2);
}

