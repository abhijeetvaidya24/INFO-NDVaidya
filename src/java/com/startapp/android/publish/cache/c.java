/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Set
 */
package com.startapp.android.publish.cache;

import com.startapp.android.publish.adsCommon.Ad;
import com.startapp.android.publish.adsCommon.Utils.i;
import com.startapp.android.publish.common.model.AdPreferences;
import java.io.Serializable;
import java.util.Set;

public class c
implements Serializable {
    private static final long serialVersionUID = 1L;
    private String advertiserId = null;
    private Set<String> categories;
    private Set<String> categoriesExclude;
    private String country = null;
    private boolean forceFullpage = false;
    private boolean forceOfferWall2D = false;
    private boolean forceOfferWall3D = false;
    private boolean forceOverlay = false;
    private Double minCpm;
    private AdPreferences.Placement placement;
    private String template = null;
    private boolean testMode = false;
    private Ad.AdType type = null;
    private boolean videoMuted = false;

    public c(AdPreferences.Placement placement, AdPreferences adPreferences) {
        this.placement = placement;
        this.categories = adPreferences.getCategories();
        this.categoriesExclude = adPreferences.getCategoriesExclude();
        this.videoMuted = adPreferences.isVideoMuted();
        this.minCpm = adPreferences.getMinCpm();
        this.forceOfferWall3D = i.a(adPreferences, "forceOfferWall3D");
        this.forceOfferWall2D = i.a(adPreferences, "forceOfferWall2D");
        this.forceFullpage = i.a(adPreferences, "forceFullpage");
        this.forceOverlay = i.a(adPreferences, "forceOverlay");
        this.testMode = i.a(adPreferences, "testMode");
        this.country = i.b(adPreferences, "country");
        this.advertiserId = i.b(adPreferences, "advertiserId");
        this.template = i.b(adPreferences, "template");
        this.type = com.startapp.android.publish.adsCommon.c.a(adPreferences, "type");
    }

    public AdPreferences.Placement a() {
        return this.placement;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (this.getClass() != object.getClass()) {
            return false;
        }
        c c2 = (c)object;
        String string = this.advertiserId;
        if (string == null ? c2.advertiserId != null : !string.equals((Object)c2.advertiserId)) {
            return false;
        }
        Set<String> set = this.categories;
        if (set == null ? c2.categories != null : !set.equals(c2.categories)) {
            return false;
        }
        Set<String> set2 = this.categoriesExclude;
        if (set2 == null ? c2.categoriesExclude != null : !set2.equals(c2.categoriesExclude)) {
            return false;
        }
        String string2 = this.country;
        if (string2 == null ? c2.country != null : !string2.equals((Object)c2.country)) {
            return false;
        }
        if (this.forceFullpage != c2.forceFullpage) {
            return false;
        }
        if (this.forceOfferWall2D != c2.forceOfferWall2D) {
            return false;
        }
        if (this.forceOfferWall3D != c2.forceOfferWall3D) {
            return false;
        }
        if (this.forceOverlay != c2.forceOverlay) {
            return false;
        }
        if (this.placement != c2.placement) {
            return false;
        }
        String string3 = this.template;
        if (string3 == null ? c2.template != null : !string3.equals((Object)c2.template)) {
            return false;
        }
        if (this.testMode != c2.testMode) {
            return false;
        }
        if (this.videoMuted != c2.videoMuted) {
            return false;
        }
        Ad.AdType adType = this.type;
        if (adType == null ? c2.type != null : !adType.equals((Object)c2.type)) {
            return false;
        }
        Double d2 = this.minCpm;
        return !(d2 == null ? c2.minCpm != null : d2 != c2.minCpm);
    }

    public int hashCode() {
        String string = this.advertiserId;
        int n2 = string == null ? 0 : string.hashCode();
        int n3 = 31 * (n2 + 31);
        Set<String> set = this.categories;
        int n4 = set == null ? 0 : set.hashCode();
        int n5 = 31 * (n3 + n4);
        Set<String> set2 = this.categoriesExclude;
        int n6 = set2 == null ? 0 : set2.hashCode();
        int n7 = 31 * (n5 + n6);
        String string2 = this.country;
        int n8 = string2 == null ? 0 : string2.hashCode();
        int n9 = 31 * (n7 + n8);
        Double d2 = this.minCpm;
        int n10 = d2 == null ? 0 : d2.hashCode();
        int n11 = 31 * (n9 + n10);
        boolean bl = this.forceFullpage;
        int n12 = 1231;
        int n13 = bl ? 1231 : 1237;
        int n14 = 31 * (n11 + n13);
        int n15 = this.forceOfferWall2D ? 1231 : 1237;
        int n16 = 31 * (n14 + n15);
        int n17 = this.forceOfferWall3D ? 1231 : 1237;
        int n18 = 31 * (n16 + n17);
        int n19 = this.forceOverlay ? 1231 : 1237;
        int n20 = 31 * (n18 + n19);
        AdPreferences.Placement placement = this.placement;
        int n21 = placement == null ? 0 : placement.hashCode();
        int n22 = 31 * (n20 + n21);
        String string3 = this.template;
        int n23 = string3 == null ? 0 : string3.hashCode();
        int n24 = 31 * (n22 + n23);
        if (!this.testMode) {
            n12 = 1237;
        }
        int n25 = 31 * (n24 + n12);
        Ad.AdType adType = this.type;
        int n26 = adType == null ? 0 : adType.hashCode();
        return n25 + n26;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CacheKey [placement=");
        stringBuilder.append((Object)this.placement);
        stringBuilder.append(", categories=");
        stringBuilder.append(this.categories);
        stringBuilder.append(", categoriesExclude=");
        stringBuilder.append(this.categoriesExclude);
        stringBuilder.append(", forceOfferWall3D=");
        stringBuilder.append(this.forceOfferWall3D);
        stringBuilder.append(", forceOfferWall2D=");
        stringBuilder.append(this.forceOfferWall2D);
        stringBuilder.append(", forceFullpage=");
        stringBuilder.append(this.forceFullpage);
        stringBuilder.append(", forceOverlay=");
        stringBuilder.append(this.forceOverlay);
        stringBuilder.append(", testMode=");
        stringBuilder.append(this.testMode);
        stringBuilder.append(", minCpm=");
        stringBuilder.append((Object)this.minCpm);
        stringBuilder.append(", country=");
        stringBuilder.append(this.country);
        stringBuilder.append(", advertiserId=");
        stringBuilder.append(this.advertiserId);
        stringBuilder.append(", template=");
        stringBuilder.append(this.template);
        stringBuilder.append(", type=");
        stringBuilder.append((Object)this.type);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

