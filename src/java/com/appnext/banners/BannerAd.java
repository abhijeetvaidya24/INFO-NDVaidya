/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.appnext.banners.BannerAdData
 *  java.lang.Object
 *  java.lang.String
 */
package com.appnext.banners;

import android.content.Context;
import com.appnext.banners.BannerAdData;
import com.appnext.banners.d;
import com.appnext.core.Ad;
import com.appnext.core.c;
import com.appnext.core.callbacks.OnECPMLoaded;

class BannerAd
extends Ad {
    protected static final String TID = "301";
    protected static final String VID = "2.5.0.472";

    public BannerAd(Context context, String string2) {
        super(context, string2);
    }

    protected BannerAd(Ad ad) {
        super(ad);
    }

    @Override
    public String getAUID() {
        return "1000";
    }

    @Override
    protected c getAdRequest() {
        return super.getAdRequest();
    }

    @Override
    public void getECPM(OnECPMLoaded onECPMLoaded) {
    }

    @Override
    protected String getSessionId() {
        return super.getSessionId();
    }

    @Override
    public String getTID() {
        return TID;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public String getTemId(BannerAdData bannerAdData) {
        if (bannerAdData.getRevenueType().equals((Object)"cpi")) {
            String string2 = d.S().get("BANNER_cpiActiveFlow").toLowerCase();
            switch (string2.hashCode()) {
                default: {
                    return "109";
                }
                case 100: {
                    if (!string2.equals((Object)"d")) return "109";
                    return "109";
                }
                case 99: {
                    if (!string2.equals((Object)"c")) return "109";
                    return "106";
                }
                case 98: {
                    if (!string2.equals((Object)"b")) return "109";
                    return "103";
                }
                case 97: {
                    if (!string2.equals((Object)"a")) return "109";
                    return "100";
                }
            }
        }
        String string3 = d.S().get("BANNER_cpcActiveFlow").toLowerCase();
        int n2 = string3.hashCode();
        if (n2 != 97) {
            if (n2 != 98) return "203";
            if (!string3.equals((Object)"b")) return "203";
            return "203";
        }
        if (!string3.equals((Object)"a")) return "203";
        return "200";
    }

    @Override
    public String getVID() {
        return VID;
    }

    @Override
    public boolean isAdLoaded() {
        return false;
    }

    @Override
    public void loadAd() {
    }

    @Override
    protected void setAdRequest(c c2) {
        super.setAdRequest(c2);
    }

    @Override
    public void showAd() {
    }
}

