/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.aerserv.sdk.model.ad;

import com.aerserv.sdk.AerServVirtualCurrency;
import com.aerserv.sdk.model.Placement;
import com.aerserv.sdk.model.ad.AdType;
import com.aerserv.sdk.model.ad.ProviderAd;

public class VideoWithEndCardProviderAd
implements ProviderAd {
    private static final String LOG_TAG = "com.aerserv.sdk.model.ad.VideoWithEndCardProviderAd";
    private static final String providerName = "ASAerServ";
    private String closeOffsetStr = null;
    private String contentType;
    private String endCardMarkup;
    private String mediaFileUrl;
    private boolean muted = false;
    private String videoClickThruUrl;
    private AerServVirtualCurrency virtualCurrency;

    public VideoWithEndCardProviderAd(Placement placement) {
        this.mediaFileUrl = placement.getMediaFile();
        this.endCardMarkup = placement.getEndCardMarkup();
        this.contentType = placement.getContentType();
        this.closeOffsetStr = placement.getCloseOffset();
        this.virtualCurrency = placement.getVc();
        this.videoClickThruUrl = placement.getVideoClickThruUrl();
        this.muted = placement.getStartAdMuted();
    }

    @Override
    public AdType getAdType() {
        return AdType.VIDEO_WITH_END_CARD;
    }

    public String getCloseOffsetStr() {
        return this.closeOffsetStr;
    }

    public String getContentType() {
        return this.contentType;
    }

    public String getEndCardMarkup() {
        return this.endCardMarkup;
    }

    @Override
    public boolean getIsShowAdCommandRequiredOnPreload() {
        return false;
    }

    public String getMediaFileUrl() {
        return this.mediaFileUrl;
    }

    @Override
    public String getProviderName() {
        return providerName;
    }

    public String getVideoClickThruUrl() {
        return this.videoClickThruUrl;
    }

    @Override
    public AerServVirtualCurrency getVirtualCurrency() {
        return this.virtualCurrency;
    }

    public boolean isMuted() {
        return this.muted;
    }
}

