/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 */
package com.aerserv.sdk.model.ad;

import com.aerserv.sdk.AerServVirtualCurrency;
import com.aerserv.sdk.model.ad.AdType;
import java.io.Serializable;

public interface ProviderAd
extends Serializable {
    public static final String PROPERTIES_KEY = "providerAd";

    public AdType getAdType();

    public boolean getIsShowAdCommandRequiredOnPreload();

    public String getProviderName();

    public AerServVirtualCurrency getVirtualCurrency();
}

