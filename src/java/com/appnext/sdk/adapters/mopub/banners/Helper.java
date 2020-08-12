/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 */
package com.appnext.sdk.adapters.mopub.banners;

import com.appnext.banners.BannerSize;
import java.util.Map;

public class Helper {
    protected static final String AppnextAutoPlayExtraKey = "AppnextAutoPlay";
    protected static final String AppnextBackButtonCanCloseExtraKey = "AppnextBackButtonCanClose";
    protected static final String AppnextBannerSizeExtraKey = "AppnextBannerSize";
    protected static final String AppnextButtonColorExtraKey = "AppnextButtonColor";
    protected static final String AppnextCategoriesExtraKey = "AppnextCategories";
    protected static final String AppnextClickEnabledExtraKey = "AppnextClickEnabled";
    protected static final String AppnextCreativeTypeExtraKey = "AppnextCreativeType";
    protected static final String AppnextLanguageExtraKey = "AppnextLanguage";
    protected static final String AppnextMaxVideoLenExtraKey = "AppnextMaxVideoLen";
    protected static final String AppnextMinVideoLenExtraKey = "AppnextMinVideoLen";
    protected static final String AppnextMuteExtraKey = "AppnextMute";
    protected static final String AppnextOrientationExtraKey = "AppnextOrientation";
    protected static final String AppnextPlacementIdExtraKey = "AppnextPlacementId";
    protected static final String AppnextPostbackExtraKey = "AppnextPostback";
    protected static final String AppnextVideoLengthExtraKey = "AppnextVideoLength";

    protected static String getAppnextPlacementIdExtraKey(Map<String, String> map) {
        if (map != null) {
            return (String)map.get((Object)AppnextPlacementIdExtraKey);
        }
        return null;
    }

    protected static BannerSize getBannerSize(Map<String, String> map) {
        if (map != null) {
            String string2 = (String)map.get((Object)AppnextBannerSizeExtraKey);
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
        return map != null && (map.containsKey((Object)AppnextButtonColorExtraKey) || map.containsKey((Object)AppnextCategoriesExtraKey) || map.containsKey((Object)AppnextPostbackExtraKey) || map.containsKey((Object)AppnextOrientationExtraKey) || map.containsKey((Object)AppnextMinVideoLenExtraKey) || map.containsKey((Object)AppnextMaxVideoLenExtraKey) || map.containsKey((Object)AppnextBackButtonCanCloseExtraKey) || map.containsKey((Object)AppnextMuteExtraKey));
    }
}

