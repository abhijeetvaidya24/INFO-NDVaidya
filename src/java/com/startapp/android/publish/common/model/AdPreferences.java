/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.io.Serializable
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Deprecated
 *  java.lang.Double
 *  java.lang.Enum
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Collection
 *  java.util.HashSet
 *  java.util.Set
 */
package com.startapp.android.publish.common.model;

import android.content.Context;
import com.startapp.android.publish.adsCommon.Ad;
import com.startapp.android.publish.adsCommon.SDKAdPreferences;
import com.startapp.android.publish.adsCommon.m;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class AdPreferences
implements Serializable {
    public static final String TYPE_APP_WALL = "APP_WALL";
    public static final String TYPE_BANNER = "BANNER";
    public static final String TYPE_INAPP_EXIT = "INAPP_EXIT";
    public static final String TYPE_SCRINGO_TOOLBAR = "SCRINGO_TOOLBAR";
    public static final String TYPE_TEXT = "TEXT";
    private static final long serialVersionUID = 1L;
    protected String advertiserId = null;
    private String age = null;
    private Boolean ai = null;
    private Boolean as = null;
    private Set<String> categories = null;
    private Set<String> categoriesExclude = null;
    protected String country = null;
    protected boolean forceFullpage = false;
    protected boolean forceOfferWall2D = false;
    protected boolean forceOfferWall3D = false;
    protected boolean forceOverlay = false;
    private SDKAdPreferences.Gender gender = null;
    private boolean hardwareAccelerated = m.a().d();
    private String keywords = null;
    private Double latitude = null;
    private Double longitude = null;
    protected Double minCpm = null;
    protected Set<String> packageInclude = null;
    private String productId = null;
    private String publisherId = null;
    protected String template = null;
    private boolean testMode = false;
    protected Ad.AdType type = null;
    private boolean videoMuted = false;

    public AdPreferences() {
    }

    public AdPreferences(AdPreferences adPreferences) {
        Set<String> set;
        this.country = adPreferences.country;
        this.advertiserId = adPreferences.advertiserId;
        this.template = adPreferences.template;
        this.type = adPreferences.type;
        Set<String> set2 = adPreferences.packageInclude;
        if (set2 != null) {
            this.packageInclude = new HashSet(set2);
        }
        this.minCpm = adPreferences.minCpm;
        this.forceOfferWall3D = adPreferences.forceOfferWall3D;
        this.forceOfferWall2D = adPreferences.forceOfferWall2D;
        this.forceFullpage = adPreferences.forceFullpage;
        this.forceOverlay = adPreferences.forceOverlay;
        this.publisherId = adPreferences.publisherId;
        this.productId = adPreferences.productId;
        this.testMode = adPreferences.testMode;
        this.longitude = adPreferences.longitude;
        this.latitude = adPreferences.latitude;
        this.keywords = adPreferences.keywords;
        this.gender = adPreferences.gender;
        this.age = adPreferences.age;
        this.ai = adPreferences.ai;
        this.as = adPreferences.as;
        this.videoMuted = adPreferences.videoMuted;
        this.hardwareAccelerated = adPreferences.hardwareAccelerated;
        Set<String> set3 = adPreferences.categories;
        if (set3 != null) {
            this.categories = new HashSet(set3);
        }
        if ((set = adPreferences.categoriesExclude) != null) {
            this.categoriesExclude = new HashSet(set);
        }
    }

    @Deprecated
    public AdPreferences(String string, String string2) {
        this.publisherId = string;
        this.productId = string2;
    }

    @Deprecated
    public AdPreferences(String string, String string2, String string3) {
        this.publisherId = string;
        this.productId = string2;
    }

    public AdPreferences addCategory(String string) {
        if (this.categories == null) {
            this.categories = new HashSet();
        }
        this.categories.add((Object)string);
        return this;
    }

    public AdPreferences addCategoryExclude(String string) {
        if (this.categoriesExclude == null) {
            this.categoriesExclude = new HashSet();
        }
        this.categoriesExclude.add((Object)string);
        return this;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null) {
            if (this.getClass() != object.getClass()) {
                return false;
            }
            AdPreferences adPreferences = (AdPreferences)object;
            if (this.forceOfferWall3D != adPreferences.forceOfferWall3D) {
                return false;
            }
            if (this.forceOfferWall2D != adPreferences.forceOfferWall2D) {
                return false;
            }
            if (this.forceFullpage != adPreferences.forceFullpage) {
                return false;
            }
            if (this.forceOverlay != adPreferences.forceOverlay) {
                return false;
            }
            if (this.testMode != adPreferences.testMode) {
                return false;
            }
            if (this.videoMuted != adPreferences.videoMuted) {
                return false;
            }
            if (this.hardwareAccelerated != adPreferences.hardwareAccelerated) {
                return false;
            }
            String string = this.country;
            if (string != null ? !string.equals((Object)adPreferences.country) : adPreferences.country != null) {
                return false;
            }
            String string2 = this.advertiserId;
            if (string2 != null ? !string2.equals((Object)adPreferences.advertiserId) : adPreferences.advertiserId != null) {
                return false;
            }
            String string3 = this.template;
            if (string3 != null ? !string3.equals((Object)adPreferences.template) : adPreferences.template != null) {
                return false;
            }
            if (this.type != adPreferences.type) {
                return false;
            }
            Set<String> set = this.packageInclude;
            if (set != null ? !set.equals(adPreferences.packageInclude) : adPreferences.packageInclude != null) {
                return false;
            }
            Double d2 = this.minCpm;
            if (d2 != null ? !d2.equals((Object)adPreferences.minCpm) : adPreferences.minCpm != null) {
                return false;
            }
            String string4 = this.publisherId;
            if (string4 != null ? !string4.equals((Object)adPreferences.publisherId) : adPreferences.publisherId != null) {
                return false;
            }
            String string5 = this.productId;
            if (string5 != null ? !string5.equals((Object)adPreferences.productId) : adPreferences.productId != null) {
                return false;
            }
            Double d3 = this.longitude;
            if (d3 != null ? !d3.equals((Object)adPreferences.longitude) : adPreferences.longitude != null) {
                return false;
            }
            Double d4 = this.latitude;
            if (d4 != null ? !d4.equals((Object)adPreferences.latitude) : adPreferences.latitude != null) {
                return false;
            }
            String string6 = this.keywords;
            if (string6 != null ? !string6.equals((Object)adPreferences.keywords) : adPreferences.keywords != null) {
                return false;
            }
            if (this.gender != adPreferences.gender) {
                return false;
            }
            String string7 = this.age;
            if (string7 != null ? !string7.equals((Object)adPreferences.age) : adPreferences.age != null) {
                return false;
            }
            Boolean bl = this.ai;
            if (bl != null ? !bl.equals((Object)adPreferences.ai) : adPreferences.ai != null) {
                return false;
            }
            Boolean bl2 = this.as;
            if (bl2 != null ? !bl2.equals((Object)adPreferences.as) : adPreferences.as != null) {
                return false;
            }
            Set<String> set2 = this.categories;
            if (set2 != null ? !set2.equals(adPreferences.categories) : adPreferences.categories != null) {
                return false;
            }
            Set<String> set3 = this.categoriesExclude;
            if (set3 != null) {
                return set3.equals(adPreferences.categoriesExclude);
            }
            return adPreferences.categoriesExclude == null;
        }
        return false;
    }

    public String getAge(Context context) {
        String string = this.age;
        if (string == null) {
            return m.a().g(context).getAge();
        }
        return string;
    }

    public Boolean getAi() {
        return this.ai;
    }

    public Boolean getAs() {
        return this.as;
    }

    public Set<String> getCategories() {
        return this.categories;
    }

    public Set<String> getCategoriesExclude() {
        return this.categoriesExclude;
    }

    public SDKAdPreferences.Gender getGender(Context context) {
        SDKAdPreferences.Gender gender = this.gender;
        if (gender == null) {
            return m.a().g(context).getGender();
        }
        return gender;
    }

    public String getKeywords() {
        return this.keywords;
    }

    public Double getLatitude() {
        return this.latitude;
    }

    public Double getLongitude() {
        return this.longitude;
    }

    public Double getMinCpm() {
        return this.minCpm;
    }

    public String getProductId() {
        return this.productId;
    }

    public String getPublisherId() {
        return this.publisherId;
    }

    public Ad.AdType getType() {
        return this.type;
    }

    public int hashCode() {
        String string = this.country;
        int n2 = string != null ? string.hashCode() : 0;
        int n3 = n2 * 31;
        String string2 = this.advertiserId;
        int n4 = string2 != null ? string2.hashCode() : 0;
        int n5 = 31 * (n3 + n4);
        String string3 = this.template;
        int n6 = string3 != null ? string3.hashCode() : 0;
        int n7 = 31 * (n5 + n6);
        Ad.AdType adType = this.type;
        int n8 = adType != null ? adType.hashCode() : 0;
        int n9 = 31 * (n7 + n8);
        Set<String> set = this.packageInclude;
        int n10 = set != null ? set.hashCode() : 0;
        int n11 = 31 * (31 * (31 * (31 * (31 * (n9 + n10) + this.forceOfferWall3D) + this.forceOfferWall2D) + this.forceFullpage) + this.forceOverlay);
        Double d2 = this.minCpm;
        int n12 = d2 != null ? d2.hashCode() : 0;
        int n13 = 31 * (n11 + n12);
        String string4 = this.publisherId;
        int n14 = string4 != null ? string4.hashCode() : 0;
        int n15 = 31 * (n13 + n14);
        String string5 = this.productId;
        int n16 = string5 != null ? string5.hashCode() : 0;
        int n17 = 31 * (31 * (n15 + n16) + this.testMode);
        Double d3 = this.longitude;
        int n18 = d3 != null ? d3.hashCode() : 0;
        int n19 = 31 * (n17 + n18);
        Double d4 = this.latitude;
        int n20 = d4 != null ? d4.hashCode() : 0;
        int n21 = 31 * (n19 + n20);
        String string6 = this.keywords;
        int n22 = string6 != null ? string6.hashCode() : 0;
        int n23 = 31 * (n21 + n22);
        SDKAdPreferences.Gender gender = this.gender;
        int n24 = gender != null ? gender.hashCode() : 0;
        int n25 = 31 * (n23 + n24);
        String string7 = this.age;
        int n26 = string7 != null ? string7.hashCode() : 0;
        int n27 = 31 * (n25 + n26);
        Boolean bl = this.ai;
        int n28 = bl != null ? bl.hashCode() : 0;
        int n29 = 31 * (n27 + n28);
        Boolean bl2 = this.as;
        int n30 = bl2 != null ? bl2.hashCode() : 0;
        int n31 = 31 * (31 * (31 * (n29 + n30) + this.videoMuted) + this.hardwareAccelerated);
        Set<String> set2 = this.categories;
        int n32 = set2 != null ? set2.hashCode() : 0;
        int n33 = 31 * (n31 + n32);
        Set<String> set3 = this.categoriesExclude;
        int n34 = 0;
        if (set3 != null) {
            n34 = set3.hashCode();
        }
        return n33 + n34;
    }

    protected boolean isHardwareAccelerated() {
        return this.hardwareAccelerated;
    }

    public boolean isSimpleToken() {
        return true;
    }

    public boolean isTestMode() {
        return this.testMode;
    }

    public boolean isVideoMuted() {
        return this.videoMuted;
    }

    public AdPreferences muteVideo() {
        this.videoMuted = true;
        return this;
    }

    public AdPreferences setAge(Integer n2) {
        this.age = Integer.toString((int)n2);
        return this;
    }

    public AdPreferences setAge(String string) {
        this.age = string;
        return this;
    }

    public AdPreferences setAi(Boolean bl) {
        this.ai = bl;
        return this;
    }

    public AdPreferences setAs(Boolean bl) {
        this.as = bl;
        return this;
    }

    public AdPreferences setGender(SDKAdPreferences.Gender gender) {
        this.gender = gender;
        return this;
    }

    public AdPreferences setKeywords(String string) {
        this.keywords = string;
        return this;
    }

    public AdPreferences setLatitude(double d2) {
        this.latitude = d2;
        return this;
    }

    public AdPreferences setLongitude(double d2) {
        this.longitude = d2;
        return this;
    }

    public void setMinCpm(Double d2) {
        this.minCpm = d2;
    }

    @Deprecated
    public AdPreferences setProductId(String string) {
        this.productId = string;
        return this;
    }

    @Deprecated
    public AdPreferences setPublisherId(String string) {
        this.publisherId = string;
        return this;
    }

    public AdPreferences setTestMode(boolean bl) {
        this.testMode = bl;
        return this;
    }

    public void setType(Ad.AdType adType) {
        this.type = adType;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AdPreferences [publisherId=");
        stringBuilder.append(this.publisherId);
        stringBuilder.append(", productId=");
        stringBuilder.append(this.productId);
        stringBuilder.append(", testMode=");
        stringBuilder.append(this.testMode);
        stringBuilder.append(", longitude=");
        stringBuilder.append((Object)this.longitude);
        stringBuilder.append(", latitude=");
        stringBuilder.append((Object)this.latitude);
        stringBuilder.append(", keywords=");
        stringBuilder.append(this.keywords);
        stringBuilder.append(", minCPM=");
        stringBuilder.append((Object)this.minCpm);
        stringBuilder.append(", categories=");
        stringBuilder.append(this.categories);
        stringBuilder.append(", categoriesExclude=");
        stringBuilder.append(this.categoriesExclude);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public static final class Placement
    extends Enum<Placement> {
        private static final /* synthetic */ Placement[] $VALUES;
        public static final /* enum */ Placement DEVICE_SIDEBAR;
        public static final /* enum */ Placement INAPP_BANNER;
        public static final /* enum */ Placement INAPP_BROWSER;
        public static final /* enum */ Placement INAPP_FULL_SCREEN;
        public static final /* enum */ Placement INAPP_NATIVE;
        public static final /* enum */ Placement INAPP_OFFER_WALL;
        public static final /* enum */ Placement INAPP_OVERLAY;
        public static final /* enum */ Placement INAPP_RETURN;
        public static final /* enum */ Placement INAPP_SPLASH;
        private int index;

        static {
            INAPP_FULL_SCREEN = new Placement(1);
            INAPP_BANNER = new Placement(2);
            INAPP_OFFER_WALL = new Placement(3);
            INAPP_SPLASH = new Placement(4);
            INAPP_OVERLAY = new Placement(5);
            INAPP_NATIVE = new Placement(6);
            DEVICE_SIDEBAR = new Placement(7);
            INAPP_RETURN = new Placement(8);
            INAPP_BROWSER = new Placement(9);
            Placement[] arrplacement = new Placement[]{INAPP_FULL_SCREEN, INAPP_BANNER, INAPP_OFFER_WALL, INAPP_SPLASH, INAPP_OVERLAY, INAPP_NATIVE, DEVICE_SIDEBAR, INAPP_RETURN, INAPP_BROWSER};
            $VALUES = arrplacement;
        }

        private Placement(int n3) {
            this.index = n3;
        }

        public static Placement getByIndex(int n2) {
            Placement placement = INAPP_FULL_SCREEN;
            Placement[] arrplacement = Placement.values();
            for (int i2 = 0; i2 < arrplacement.length; ++i2) {
                if (arrplacement[i2].getIndex() != n2) continue;
                placement = arrplacement[i2];
            }
            return placement;
        }

        public static Placement valueOf(String string) {
            return (Placement)Enum.valueOf(Placement.class, (String)string);
        }

        public static Placement[] values() {
            return (Placement[])$VALUES.clone();
        }

        public int getIndex() {
            return this.index;
        }

        public boolean isInterstitial() {
            return this == INAPP_FULL_SCREEN || this == INAPP_OFFER_WALL || this == INAPP_SPLASH || this == INAPP_OVERLAY;
            {
            }
        }
    }

}

