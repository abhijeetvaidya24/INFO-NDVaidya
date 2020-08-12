/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.aerserv.sdk.controller.listener;

import com.aerserv.sdk.model.ad.ProviderAd;

public interface AdFactoryListener {
    public void adBuildFailed(String var1);

    public void adBuildSucceeded(ProviderAd var1);
}

