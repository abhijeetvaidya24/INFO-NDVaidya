/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.LinkedHashMap
 *  java.util.Map
 */
package com.ironsource.sdk.controller;

import android.text.TextUtils;
import com.ironsource.sdk.data.DemandSource;
import com.ironsource.sdk.data.SSAEnums;
import com.ironsource.sdk.listeners.OnAdProductListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class DemandSourceManager {
    private Map<String, DemandSource> mInterstitialDemandSourceMap = new LinkedHashMap();
    private Map<String, DemandSource> mRewardedVideoDemandSourceMap = new LinkedHashMap();

    private Map<String, DemandSource> getMapByProductType(SSAEnums.ProductType productType) {
        if (productType.name().equalsIgnoreCase(SSAEnums.ProductType.RewardedVideo.name())) {
            return this.mRewardedVideoDemandSourceMap;
        }
        if (productType.name().equalsIgnoreCase(SSAEnums.ProductType.Interstitial.name())) {
            return this.mInterstitialDemandSourceMap;
        }
        return null;
    }

    private void put(SSAEnums.ProductType productType, String string, DemandSource demandSource) {
        Map<String, DemandSource> map;
        if (!TextUtils.isEmpty((CharSequence)string) && demandSource != null && (map = this.getMapByProductType(productType)) != null) {
            map.put((Object)string, (Object)demandSource);
        }
    }

    public DemandSource createDemandSource(SSAEnums.ProductType productType, String string, Map<String, String> map, OnAdProductListener onAdProductListener) {
        DemandSource demandSource = new DemandSource(string, map, onAdProductListener);
        this.put(productType, string, demandSource);
        return demandSource;
    }

    public DemandSource getDemandSourceByName(SSAEnums.ProductType productType, String string) {
        Map<String, DemandSource> map;
        if (!TextUtils.isEmpty((CharSequence)string) && (map = this.getMapByProductType(productType)) != null) {
            return (DemandSource)map.get((Object)string);
        }
        return null;
    }

    public Collection<DemandSource> getDemandSources(SSAEnums.ProductType productType) {
        Map<String, DemandSource> map = this.getMapByProductType(productType);
        if (map != null) {
            return map.values();
        }
        return new ArrayList();
    }
}

