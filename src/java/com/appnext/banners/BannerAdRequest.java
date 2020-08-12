/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.String
 */
package com.appnext.banners;

import com.appnext.core.c;
import java.io.Serializable;

public class BannerAdRequest
extends c
implements Serializable {
    public static final String TYPE_ALL = "all";
    public static final String TYPE_STATIC = "static";
    public static final String TYPE_VIDEO = "video";
    public static final String VIDEO_LENGTH_LONG = "30";
    public static final String VIDEO_LENGTH_SHORT = "15";
    private boolean autoPlay = false;
    private int cS = 0;
    private int cT = 0;
    private String categories = "";
    private boolean clickEnabled = true;
    private String creativeType = "all";
    private boolean mute = true;
    private String postback = "";
    private String videoLength = "15";

    public BannerAdRequest() {
    }

    BannerAdRequest(BannerAdRequest bannerAdRequest) {
        this.categories = bannerAdRequest.categories;
        this.postback = bannerAdRequest.postback;
        this.creativeType = bannerAdRequest.creativeType;
        this.autoPlay = bannerAdRequest.autoPlay;
        this.mute = bannerAdRequest.mute;
        this.videoLength = bannerAdRequest.videoLength;
        this.cS = bannerAdRequest.cS;
        this.cT = bannerAdRequest.cT;
        this.clickEnabled = bannerAdRequest.clickEnabled;
    }

    public String getCategories() {
        return this.categories;
    }

    public String getCreativeType() {
        return this.creativeType;
    }

    public String getPostback() {
        return this.postback;
    }

    public int getVidMax() {
        return this.cT;
    }

    public int getVidMin() {
        return this.cS;
    }

    public String getVideoLength() {
        return this.videoLength;
    }

    public boolean isAutoPlay() {
        return this.autoPlay;
    }

    public boolean isClickEnabled() {
        return this.clickEnabled;
    }

    public boolean isMute() {
        return this.mute;
    }

    public BannerAdRequest setAutoPlay(boolean bl) {
        this.autoPlay = bl;
        return this;
    }

    public BannerAdRequest setCategories(String string2) {
        this.categories = string2;
        return this;
    }

    public BannerAdRequest setClickEnabled(boolean bl) {
        this.clickEnabled = bl;
        return this;
    }

    public BannerAdRequest setCreativeType(String string2) {
        this.creativeType = string2;
        return this;
    }

    public BannerAdRequest setMute(boolean bl) {
        this.mute = bl;
        return this;
    }

    public BannerAdRequest setPostback(String string2) {
        this.postback = string2;
        return this;
    }

    public BannerAdRequest setVidMax(int n2) {
        this.cT = n2;
        return this;
    }

    public BannerAdRequest setVidMin(int n2) {
        this.cS = n2;
        return this;
    }

    public BannerAdRequest setVideoLength(String string2) {
        this.videoLength = string2;
        return this;
    }
}

