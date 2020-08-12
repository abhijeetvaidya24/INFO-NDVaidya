/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.gson.annotations.SerializedName
 *  java.lang.Boolean
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 */
package com.appsgeyser.sdk.ads.fastTrack;

import com.google.gson.annotations.SerializedName;
import java.util.Map;

public class FastTrackSdkModel {
    @SerializedName(value="additional_reporting_params")
    private Map<String, String> additionalReportingParams;
    @SerializedName(value="app_id")
    private String appId;
    @SerializedName(value="banner_placement_id")
    private String bannerPlacementId;
    @SerializedName(value="banner_placements_refresh_timer_map")
    private Map<String, Integer> bannerPlacementsRefreshTimerMap;
    @SerializedName(value="content_rating")
    private String contentRating;
    @SerializedName(value="custom_banner_activated")
    private boolean customBannerActivated;
    @SerializedName(value="custom_fullscreen_activated")
    private boolean customFullscreenActivated;
    @SerializedName(value="custom_rewarded_activated")
    private boolean customRewardedActivated;
    @SerializedName(value="banner_refresh_timer")
    private Integer defaultBannerRefreshTimer;
    @SerializedName(value="fullscreen_intensity")
    private Integer defaultFullscreenIntensity;
    @SerializedName(value="fullscreen_frequency_timer")
    private Integer fullscreenFrequencyTimer;
    @SerializedName(value="fullscreen_pending_delay_timer")
    private Integer fullscreenPendingDelayTimer;
    @SerializedName(value="fullscreen_placement_id")
    private String fullscreenPlacementId;
    @SerializedName(value="fullscreen_placements_intensity_map")
    private Map<String, Integer> fullscreenPlacementsIntensityMap;
    @SerializedName(value="name")
    private String name;
    @SerializedName(value="native_ads_placement_id")
    private String nativeAdsPlacementId;
    @SerializedName(value="rewarded_placements_activation_map")
    private Map<String, Boolean> rewardedPlacementsActivationMap;
    @SerializedName(value="rewarded_video_placement_id")
    private String rewardedVideoPlacementId;
    @SerializedName(value="startapp_id")
    private String startAppId;

    public Map<String, String> getAdditionalReportingParams() {
        return this.additionalReportingParams;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getBannerPlacementId() {
        return this.bannerPlacementId;
    }

    public Map<String, Integer> getBannerPlacementsRefreshTimerMap() {
        return this.bannerPlacementsRefreshTimerMap;
    }

    public String getContentRating() {
        return this.contentRating;
    }

    public Integer getDefaultBannerRefreshTimer() {
        return this.defaultBannerRefreshTimer;
    }

    public Integer getDefaultFullscreenIntensity() {
        return this.defaultFullscreenIntensity;
    }

    public Integer getFullscreenFrequencyTimer() {
        return this.fullscreenFrequencyTimer;
    }

    public Integer getFullscreenPendingDelayTimer() {
        return this.fullscreenPendingDelayTimer;
    }

    public String getFullscreenPlacementId() {
        return this.fullscreenPlacementId;
    }

    public Map<String, Integer> getFullscreenPlacementsIntensityMap() {
        return this.fullscreenPlacementsIntensityMap;
    }

    public String getName() {
        return this.name;
    }

    public String getNativeAdsPlacementId() {
        return this.nativeAdsPlacementId;
    }

    public Map<String, Boolean> getRewardedPlacementsActivationMap() {
        return this.rewardedPlacementsActivationMap;
    }

    public String getRewardedVideoPlacementId() {
        return this.rewardedVideoPlacementId;
    }

    public String getStartAppId() {
        return this.startAppId;
    }

    public boolean isCustomBannerActivated() {
        return this.customBannerActivated;
    }

    public boolean isCustomFullscreenActivated() {
        return this.customFullscreenActivated;
    }

    public boolean isCustomRewardedActivated() {
        return this.customRewardedActivated;
    }
}

