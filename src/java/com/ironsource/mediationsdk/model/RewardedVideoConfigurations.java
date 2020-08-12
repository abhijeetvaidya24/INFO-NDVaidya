/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 */
package com.ironsource.mediationsdk.model;

import com.ironsource.mediationsdk.model.ApplicationEvents;
import com.ironsource.mediationsdk.model.Placement;
import java.util.ArrayList;

public class RewardedVideoConfigurations {
    private String mBackFillProviderName;
    private Placement mDefaultRVPlacement;
    private String mPremiumProviderName;
    private int mRVAdaptersSmartLoadAmount;
    private int mRVAdaptersTimeOutInSeconds;
    private ApplicationEvents mRVEvents;
    private ArrayList<Placement> mRVPlacements = new ArrayList();

    public RewardedVideoConfigurations() {
        this.mRVEvents = new ApplicationEvents();
    }

    public RewardedVideoConfigurations(int n2, int n3, ApplicationEvents applicationEvents) {
        this.mRVAdaptersSmartLoadAmount = n2;
        this.mRVAdaptersTimeOutInSeconds = n3;
        this.mRVEvents = applicationEvents;
    }

    public void addRewardedVideoPlacement(Placement placement) {
        if (placement != null) {
            this.mRVPlacements.add((Object)placement);
            if (placement.getPlacementId() == 0) {
                this.mDefaultRVPlacement = placement;
            }
        }
    }

    public String getBackFillProviderName() {
        return this.mBackFillProviderName;
    }

    public Placement getDefaultRewardedVideoPlacement() {
        return this.mDefaultRVPlacement;
    }

    public String getPremiumProviderName() {
        return this.mPremiumProviderName;
    }

    public int getRewardedVideoAdaptersSmartLoadAmount() {
        return this.mRVAdaptersSmartLoadAmount;
    }

    public int getRewardedVideoAdaptersSmartLoadTimeout() {
        return this.mRVAdaptersTimeOutInSeconds;
    }

    public ApplicationEvents getRewardedVideoEventsConfigurations() {
        return this.mRVEvents;
    }

    public Placement getRewardedVideoPlacement(String string) {
        for (Placement placement : this.mRVPlacements) {
            if (!placement.getPlacementName().equals((Object)string)) continue;
            return placement;
        }
        return null;
    }

    public void setBackFillProviderName(String string) {
        this.mBackFillProviderName = string;
    }

    public void setPremiumProviderName(String string) {
        this.mPremiumProviderName = string;
    }
}

