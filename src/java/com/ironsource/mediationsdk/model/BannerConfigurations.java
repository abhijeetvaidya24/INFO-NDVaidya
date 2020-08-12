/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.ironsource.mediationsdk.model.BannerPlacement
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 */
package com.ironsource.mediationsdk.model;

import com.ironsource.mediationsdk.model.ApplicationEvents;
import com.ironsource.mediationsdk.model.BannerPlacement;
import java.util.ArrayList;

public class BannerConfigurations {
    private int mBNAdaptersSmartLoadAmount;
    private long mBNAdaptersTimeOutInMilliseconds;
    private ApplicationEvents mBNEvents;
    private ArrayList<BannerPlacement> mBNPlacements;
    private int mBNRefreshInterval;
    private BannerPlacement mDefaultBNPlacement;

    public BannerConfigurations() {
        this.mBNEvents = new ApplicationEvents();
        this.mBNPlacements = new ArrayList();
    }

    public BannerConfigurations(int n2, long l2, ApplicationEvents applicationEvents, int n3) {
        this.mBNPlacements = new ArrayList();
        this.mBNAdaptersSmartLoadAmount = n2;
        this.mBNAdaptersTimeOutInMilliseconds = l2;
        this.mBNEvents = applicationEvents;
        this.mBNRefreshInterval = n3;
    }

    public void addBannerPlacement(BannerPlacement bannerPlacement) {
        if (bannerPlacement != null) {
            this.mBNPlacements.add((Object)bannerPlacement);
            if (bannerPlacement.getPlacementId() == 0) {
                this.mDefaultBNPlacement = bannerPlacement;
            }
        }
    }

    public long getBannerAdaptersSmartLoadTimeout() {
        return this.mBNAdaptersTimeOutInMilliseconds;
    }

    public ApplicationEvents getBannerEventsConfigurations() {
        return this.mBNEvents;
    }

    public BannerPlacement getBannerPlacement(String string) {
        for (BannerPlacement bannerPlacement : this.mBNPlacements) {
            if (!bannerPlacement.getPlacementName().equals((Object)string)) continue;
            return bannerPlacement;
        }
        return null;
    }

    public int getBannerRefreshInterval() {
        return this.mBNRefreshInterval;
    }

    public BannerPlacement getDefaultBannerPlacement() {
        return this.mDefaultBNPlacement;
    }
}

