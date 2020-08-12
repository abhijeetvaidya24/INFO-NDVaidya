/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.appnext.ads.fullscreen.FullscreenConfig
 *  com.appnext.ads.fullscreen.RewardedConfig
 *  com.appnext.ads.fullscreen.VideoConfig
 *  java.lang.Boolean
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.Map
 */
package com.appnext.sdk.adapters.mopub.ads;

import com.appnext.ads.fullscreen.FullscreenConfig;
import com.appnext.ads.fullscreen.RewardedConfig;
import com.appnext.ads.fullscreen.VideoConfig;
import com.appnext.banners.BannerSize;
import com.appnext.core.Configuration;
import java.util.Map;

public class Helper {
    protected static String getAppnextPlacementIdExtraKey(Map<String, String> map) {
        if (map != null) {
            return (String)map.get((Object)"AppnextPlacementId");
        }
        return null;
    }

    protected static BannerSize getBannerSize(Map<String, String> map) {
        if (map != null) {
            String string2 = (String)map.get((Object)"AppnextBannerSize");
            if (string2.equals((Object)"LARGE_BANNER")) {
                return BannerSize.LARGE_BANNER;
            }
            if (string2.equals((Object)"MEDIUM_RECTANGLE")) {
                return BannerSize.MEDIUM_RECTANGLE;
            }
            if (string2.equals((Object)"BANNER")) {
                return BannerSize.BANNER;
            }
            throw new IllegalArgumentException("Wrong size");
        }
        return BannerSize.BANNER;
    }

    protected static boolean hasAdConfigServerExtras(Map<String, String> map) {
        return map != null && (map.containsKey((Object)"AppnextButtonColor") || map.containsKey((Object)"AppnextCategories") || map.containsKey((Object)"AppnextPostback") || map.containsKey((Object)"AppnextOrientation") || map.containsKey((Object)"AppnextMinVideoLen") || map.containsKey((Object)"AppnextMaxVideoLen") || map.containsKey((Object)"AppnextBackButtonCanClose") || map.containsKey((Object)"AppnextMute"));
    }

    protected static boolean hasVideoConfigServerExtras(Map<String, String> map) {
        return map != null && (map.containsKey((Object)"AppnextProgressType") || map.containsKey((Object)"AppnextProgressColor") || map.containsKey((Object)"AppnextVideoLength") || map.containsKey((Object)"AppnextShowClose") || map.containsKey((Object)"AppnextCloseDelay"));
    }

    protected static void setConfigFromExtras(Configuration configuration, Map<String, String> map) {
        if (configuration != null) {
            if (map == null) {
                return;
            }
            if (map.containsKey((Object)"AppnextCategories")) {
                try {
                    configuration.setCategories((String)map.get((Object)"AppnextCategories"));
                }
                catch (Throwable throwable) {
                    new StringBuilder("setCategories: ").append(throwable.getMessage());
                }
            }
            if (map.containsKey((Object)"AppnextPostback")) {
                try {
                    configuration.setPostback((String)map.get((Object)"AppnextPostback"));
                }
                catch (Throwable throwable) {
                    new StringBuilder("setPostback: ").append(throwable.getMessage());
                }
            }
            if (map.containsKey((Object)"AppnextOrientation")) {
                try {
                    configuration.setOrientation((String)map.get((Object)"AppnextOrientation"));
                }
                catch (Throwable throwable) {
                    new StringBuilder("setOrientation: ").append(throwable.getMessage());
                }
            }
            if (map.containsKey((Object)"AppnextMinVideoLen")) {
                try {
                    configuration.setMinVideoLength(Integer.parseInt((String)((String)map.get((Object)"AppnextMinVideoLen"))));
                }
                catch (Throwable throwable) {
                    new StringBuilder("setMinVideoLength: ").append(throwable.getMessage());
                }
            }
            if (map.containsKey((Object)"AppnextMaxVideoLen")) {
                try {
                    configuration.setMaxVideoLength(Integer.parseInt((String)((String)map.get((Object)"AppnextMaxVideoLen"))));
                }
                catch (Throwable throwable) {
                    new StringBuilder("setMaxVideoLength: ").append(throwable.getMessage());
                }
            }
            if (map.containsKey((Object)"AppnextMute")) {
                try {
                    configuration.setMute(Boolean.parseBoolean((String)((String)map.get((Object)"AppnextMute"))));
                }
                catch (Throwable throwable) {
                    new StringBuilder("setMute: ").append(throwable.getMessage());
                }
            }
            if (map.containsKey((Object)"AppnextLanguage")) {
                try {
                    configuration.setLanguage((String)map.get((Object)"AppnextLanguage"));
                    return;
                }
                catch (Throwable throwable) {
                    new StringBuilder("setLanguage: ").append(throwable.getMessage());
                }
            }
        }
    }

    protected static void setFullscreenConfigFromExtras(FullscreenConfig fullscreenConfig, Map<String, String> map) {
        if (fullscreenConfig != null) {
            if (map == null) {
                return;
            }
            if (map.containsKey((Object)"AppnextBackButtonCanClose")) {
                try {
                    fullscreenConfig.setBackButtonCanClose(Boolean.parseBoolean((String)((String)map.get((Object)"AppnextBackButtonCanClose"))));
                    return;
                }
                catch (Throwable throwable) {
                    new StringBuilder("setBackButtonCanClose: ").append(throwable.getMessage());
                }
            }
        }
    }

    protected static void setRewardedVideoConfigFromExtras(RewardedConfig rewardedConfig, Map<String, String> map) {
        if (rewardedConfig != null) {
            if (map == null) {
                return;
            }
            if (map.containsKey((Object)"AppnextVideoMode")) {
                try {
                    rewardedConfig.setMode((String)map.get((Object)"AppnextVideoMode"));
                    if (rewardedConfig.getMode().equals((Object)"multi") && map.containsKey((Object)"AppnextMultiTimerLength")) {
                        rewardedConfig.setMultiTimerLength(Integer.parseInt((String)((String)map.get((Object)"AppnextMultiTimerLength"))));
                    }
                }
                catch (Throwable throwable) {
                    new StringBuilder("setVideoMode: ").append(throwable.getMessage());
                }
            }
            if (map.containsKey((Object)"AppnextRollCapTime")) {
                try {
                    rewardedConfig.setRollCaptionTime(Integer.parseInt((String)((String)map.get((Object)"AppnextRollCapTime"))));
                }
                catch (Throwable throwable) {
                    new StringBuilder("setRollCaptionTime: ").append(throwable.getMessage());
                }
            }
            if (map.containsKey((Object)"AppnextShowCta")) {
                try {
                    rewardedConfig.setShowCta(Boolean.parseBoolean((String)((String)map.get((Object)"AppnextShowCta"))));
                    return;
                }
                catch (Throwable throwable) {
                    new StringBuilder("setShowCta: ").append(throwable.getMessage());
                }
            }
        }
    }

    protected static void setVideoConfigFromExtras(VideoConfig videoConfig, Map<String, String> map) {
        if (videoConfig != null) {
            if (map == null) {
                return;
            }
            if (map.containsKey((Object)"AppnextVideoLength")) {
                try {
                    videoConfig.setVideoLength((String)map.get((Object)"AppnextVideoLength"));
                    return;
                }
                catch (Throwable throwable) {
                    new StringBuilder("setVideoLength: ").append(throwable.getMessage());
                }
            }
        }
    }
}

