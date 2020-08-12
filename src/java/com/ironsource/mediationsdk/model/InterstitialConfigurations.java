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
import com.ironsource.mediationsdk.model.InterstitialPlacement;
import java.util.ArrayList;

public class InterstitialConfigurations {
    private String mBackFillProviderName;
    private InterstitialPlacement mDefaultISPlacement;
    private int mISAdaptersSmartLoadAmount;
    private int mISAdaptersTimeOutInSeconds;
    private ApplicationEvents mISEvents;
    private ArrayList<InterstitialPlacement> mISPlacements = new ArrayList();
    private String mPremiumProviderName;

    public InterstitialConfigurations() {
        this.mISEvents = new ApplicationEvents();
    }

    public InterstitialConfigurations(int n2, int n3, ApplicationEvents applicationEvents) {
        this.mISAdaptersSmartLoadAmount = n2;
        this.mISAdaptersTimeOutInSeconds = n3;
        this.mISEvents = applicationEvents;
    }

    public void addInterstitialPlacement(InterstitialPlacement interstitialPlacement) {
        if (interstitialPlacement != null) {
            this.mISPlacements.add((Object)interstitialPlacement);
            if (interstitialPlacement.getPlacementId() == 0) {
                this.mDefaultISPlacement = interstitialPlacement;
            }
        }
    }

    public String getBackFillProviderName() {
        return this.mBackFillProviderName;
    }

    public InterstitialPlacement getDefaultInterstitialPlacement() {
        return this.mDefaultISPlacement;
    }

    public int getInterstitialAdaptersSmartLoadAmount() {
        return this.mISAdaptersSmartLoadAmount;
    }

    public int getInterstitialAdaptersSmartLoadTimeout() {
        return this.mISAdaptersTimeOutInSeconds;
    }

    public ApplicationEvents getInterstitialEventsConfigurations() {
        return this.mISEvents;
    }

    public InterstitialPlacement getInterstitialPlacement(String string) {
        for (InterstitialPlacement interstitialPlacement : this.mISPlacements) {
            if (!interstitialPlacement.getPlacementName().equals((Object)string)) continue;
            return interstitialPlacement;
        }
        return null;
    }

    public String getPremiumProviderName() {
        return this.mPremiumProviderName;
    }

    public void setBackFillProviderName(String string) {
        this.mBackFillProviderName = string;
    }

    public void setPremiumProviderName(String string) {
        this.mPremiumProviderName = string;
    }
}

