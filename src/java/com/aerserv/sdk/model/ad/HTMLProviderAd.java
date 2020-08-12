/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 */
package com.aerserv.sdk.model.ad;

import com.aerserv.sdk.AerServVirtualCurrency;
import com.aerserv.sdk.model.Placement;
import com.aerserv.sdk.model.ad.AdType;
import com.aerserv.sdk.model.ad.ProviderAd;

public class HTMLProviderAd
implements ProviderAd {
    private AdType adType;
    private Placement placement;
    private String providerName = "ASAerServ";

    public HTMLProviderAd(Placement placement) {
        this(placement, AdType.HTML);
    }

    public HTMLProviderAd(Placement placement, AdType adType) {
        if (placement != null) {
            if (adType != null) {
                this.placement = placement;
                this.adType = adType;
                return;
            }
            throw new IllegalArgumentException("AdType cannot be null");
        }
        throw new IllegalArgumentException("Cannot instantiate HTMLAd. Invalid placement object.");
    }

    @Override
    public AdType getAdType() {
        return this.adType;
    }

    public String getHTML() {
        return this.placement.getAdMarkup();
    }

    @Override
    public boolean getIsShowAdCommandRequiredOnPreload() {
        return false;
    }

    public Placement getPlacement() {
        return this.placement;
    }

    @Override
    public String getProviderName() {
        return this.providerName;
    }

    @Override
    public AerServVirtualCurrency getVirtualCurrency() {
        return this.placement.getVc();
    }
}

