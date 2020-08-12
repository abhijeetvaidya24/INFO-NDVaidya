/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  android.net.Uri$Builder
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.List
 *  java.util.concurrent.atomic.AtomicBoolean
 */
package com.applovin.impl.sdk.ad;

import android.content.Context;
import android.net.Uri;
import com.applovin.impl.sdk.ad.NativeAdImpl;
import com.applovin.impl.sdk.ad.d;
import com.applovin.impl.sdk.ad.j;
import com.applovin.impl.sdk.e.m;
import com.applovin.impl.sdk.network.PostbackServiceImpl;
import com.applovin.impl.sdk.network.e;
import com.applovin.impl.sdk.network.f;
import com.applovin.impl.sdk.p;
import com.applovin.nativeAds.AppLovinNativeAd;
import com.applovin.sdk.AppLovinPostbackListener;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class NativeAdImpl
implements j,
AppLovinNativeAd {
    public static final String QUERY_PARAM_IS_FIRST_PLAY = "fp";
    public static final String QUERY_PARAM_VIDEO_PERCENT_VIEWED = "pv";
    private final com.applovin.impl.sdk.j a;
    private final d b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;
    private final String h;
    private final String i;
    private final String j;
    private final String k;
    private final String l;
    private final String m;
    private final String n;
    private final String o;
    private final List<com.applovin.impl.sdk.c.a> p;
    private final List<com.applovin.impl.sdk.c.a> q;
    private final String r;
    private final long s;
    private final List<String> t;
    private String u;
    private String v;
    private float w;
    private String x;
    private AtomicBoolean y = new AtomicBoolean();

    private NativeAdImpl(d d2, String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, float f2, String string11, String string12, String string13, String string14, String string15, List<com.applovin.impl.sdk.c.a> list, List<com.applovin.impl.sdk.c.a> list2, String string16, String string17, long l2, List<String> list3, com.applovin.impl.sdk.j j2) {
        this.b = d2;
        this.c = string;
        this.d = string2;
        this.e = string3;
        this.f = string4;
        this.g = string5;
        this.h = string6;
        this.i = string7;
        this.j = string8;
        this.u = string9;
        this.v = string10;
        this.w = f2;
        this.x = string11;
        this.l = string12;
        this.m = string13;
        this.n = string14;
        this.o = string15;
        this.p = list;
        this.q = list2;
        this.r = string16;
        this.k = string17;
        this.s = l2;
        this.t = list3;
        this.a = j2;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null) {
            if (this.getClass() != object.getClass()) {
                return false;
            }
            NativeAdImpl nativeAdImpl = (NativeAdImpl)object;
            d d2 = this.b;
            if (d2 != null ? !d2.equals(nativeAdImpl.b) : nativeAdImpl.b != null) {
                return false;
            }
            String string = this.j;
            if (string != null ? !string.equals((Object)nativeAdImpl.j) : nativeAdImpl.j != null) {
                return false;
            }
            String string2 = this.r;
            if (string2 != null ? !string2.equals((Object)nativeAdImpl.r) : nativeAdImpl.r != null) {
                return false;
            }
            String string3 = this.l;
            if (string3 != null ? !string3.equals((Object)nativeAdImpl.l) : nativeAdImpl.l != null) {
                return false;
            }
            String string4 = this.k;
            if (string4 != null ? !string4.equals((Object)nativeAdImpl.k) : nativeAdImpl.k != null) {
                return false;
            }
            String string5 = this.i;
            if (string5 != null ? !string5.equals((Object)nativeAdImpl.i) : nativeAdImpl.i != null) {
                return false;
            }
            String string6 = this.m;
            if (string6 != null ? !string6.equals((Object)nativeAdImpl.m) : nativeAdImpl.m != null) {
                return false;
            }
            String string7 = this.d;
            if (string7 != null ? !string7.equals((Object)nativeAdImpl.d) : nativeAdImpl.d != null) {
                return false;
            }
            String string8 = this.e;
            if (string8 != null ? !string8.equals((Object)nativeAdImpl.e) : nativeAdImpl.e != null) {
                return false;
            }
            String string9 = this.f;
            if (string9 != null ? !string9.equals((Object)nativeAdImpl.f) : nativeAdImpl.f != null) {
                return false;
            }
            String string10 = this.g;
            if (string10 != null ? !string10.equals((Object)nativeAdImpl.g) : nativeAdImpl.g != null) {
                return false;
            }
            String string11 = this.h;
            if (string11 != null ? !string11.equals((Object)nativeAdImpl.h) : nativeAdImpl.h != null) {
                return false;
            }
            String string12 = this.o;
            if (string12 != null ? !string12.equals((Object)nativeAdImpl.o) : nativeAdImpl.o != null) {
                return false;
            }
            String string13 = this.n;
            if (string13 != null ? !string13.equals((Object)nativeAdImpl.n) : nativeAdImpl.n != null) {
                return false;
            }
            List<com.applovin.impl.sdk.c.a> list = this.p;
            if (list != null ? !list.equals(nativeAdImpl.p) : nativeAdImpl.p != null) {
                return false;
            }
            List<com.applovin.impl.sdk.c.a> list2 = this.q;
            if (list2 != null ? !list2.equals(nativeAdImpl.q) : nativeAdImpl.q != null) {
                return false;
            }
            List<String> list3 = this.t;
            return !(list3 != null ? !list3.equals(nativeAdImpl.t) : nativeAdImpl.t != null);
        }
        return false;
    }

    @Override
    public long getAdId() {
        return this.s;
    }

    public d getAdZone() {
        return this.b;
    }

    @Override
    public String getCaptionText() {
        return this.j;
    }

    public String getClCode() {
        return this.r;
    }

    @Override
    public String getClickUrl() {
        return this.l;
    }

    @Override
    public String getCtaText() {
        return this.k;
    }

    @Override
    public String getDescriptionText() {
        return this.i;
    }

    @Override
    public String getIconUrl() {
        return this.u;
    }

    @Override
    public String getImageUrl() {
        return this.v;
    }

    @Override
    public String getImpressionTrackingUrl() {
        return this.m;
    }

    public List<String> getResourcePrefixes() {
        return this.t;
    }

    public String getSourceIconUrl() {
        return this.d;
    }

    public String getSourceImageUrl() {
        return this.e;
    }

    public String getSourceStarRatingImageUrl() {
        return this.f;
    }

    public String getSourceVideoUrl() {
        return this.g;
    }

    @Override
    public float getStarRating() {
        return this.w;
    }

    @Override
    public String getTitle() {
        return this.h;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public String getVideoEndTrackingUrl(int n2, boolean bl) {
        Uri uri;
        if (this.o == null) {
            uri = Uri.EMPTY;
            do {
                return uri.toString();
                break;
            } while (true);
        }
        if (n2 < 0 || n2 > 100) {
            this.a.u().c("AppLovinNativeAd", "Invalid percent viewed supplied.", new IllegalArgumentException("Percent viewed must be an integer between 0 and 100."));
        }
        uri = Uri.parse((String)this.o).buildUpon().appendQueryParameter(QUERY_PARAM_VIDEO_PERCENT_VIEWED, Integer.toString((int)n2)).appendQueryParameter(QUERY_PARAM_IS_FIRST_PLAY, Boolean.toString((boolean)bl)).build();
        return uri.toString();
    }

    @Override
    public String getVideoStartTrackingUrl() {
        return this.n;
    }

    @Override
    public String getVideoUrl() {
        return this.x;
    }

    @Override
    public String getZoneId() {
        return this.c;
    }

    public int hashCode() {
        String string = this.d;
        int n2 = string != null ? string.hashCode() : 0;
        int n3 = n2 * 31;
        String string2 = this.e;
        int n4 = string2 != null ? string2.hashCode() : 0;
        int n5 = 31 * (n3 + n4);
        String string3 = this.f;
        int n6 = string3 != null ? string3.hashCode() : 0;
        int n7 = 31 * (n5 + n6);
        String string4 = this.g;
        int n8 = string4 != null ? string4.hashCode() : 0;
        int n9 = 31 * (n7 + n8);
        String string5 = this.h;
        int n10 = string5 != null ? string5.hashCode() : 0;
        int n11 = 31 * (n9 + n10);
        String string6 = this.i;
        int n12 = string6 != null ? string6.hashCode() : 0;
        int n13 = 31 * (n11 + n12);
        String string7 = this.j;
        int n14 = string7 != null ? string7.hashCode() : 0;
        int n15 = 31 * (n13 + n14);
        String string8 = this.k;
        int n16 = string8 != null ? string8.hashCode() : 0;
        int n17 = 31 * (n15 + n16);
        String string9 = this.l;
        int n18 = string9 != null ? string9.hashCode() : 0;
        int n19 = 31 * (n17 + n18);
        String string10 = this.m;
        int n20 = string10 != null ? string10.hashCode() : 0;
        int n21 = 31 * (n19 + n20);
        String string11 = this.n;
        int n22 = string11 != null ? string11.hashCode() : 0;
        int n23 = 31 * (n21 + n22);
        String string12 = this.o;
        int n24 = string12 != null ? string12.hashCode() : 0;
        int n25 = 31 * (n23 + n24);
        List<com.applovin.impl.sdk.c.a> list = this.p;
        int n26 = list != null ? list.hashCode() : 0;
        int n27 = 31 * (n25 + n26);
        List<com.applovin.impl.sdk.c.a> list2 = this.q;
        int n28 = list2 != null ? list2.hashCode() : 0;
        int n29 = 31 * (n27 + n28);
        String string13 = this.r;
        int n30 = string13 != null ? string13.hashCode() : 0;
        int n31 = 31 * (n29 + n30);
        d d2 = this.b;
        int n32 = d2 != null ? d2.hashCode() : 0;
        int n33 = 31 * (n31 + n32);
        List<String> list3 = this.t;
        int n34 = 0;
        if (list3 != null) {
            n34 = list3.hashCode();
        }
        return n33 + n34;
    }

    @Override
    public boolean isImagePrecached() {
        String string = this.u;
        boolean bl = string != null && !string.equals((Object)this.d);
        String string2 = this.v;
        boolean bl2 = string2 != null && !string2.equals((Object)this.e);
        return bl && bl2;
    }

    @Override
    public boolean isVideoPrecached() {
        String string = this.x;
        return string != null && !string.equals((Object)this.g);
    }

    @Override
    public void launchClickTarget(Context context) {
        for (com.applovin.impl.sdk.c.a a2 : this.q) {
            this.a.F().a(e.j().a(a2.a()).b(a2.b()).a(false).a());
        }
        m.a(context, Uri.parse((String)this.l), this.a);
    }

    public void setIconUrl(String string) {
        this.u = string;
    }

    public void setImageUrl(String string) {
        this.v = string;
    }

    public void setStarRating(float f2) {
        this.w = f2;
    }

    public void setVideoUrl(String string) {
        this.x = string;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AppLovinNativeAd{clCode='");
        stringBuilder.append(this.r);
        stringBuilder.append('\'');
        stringBuilder.append(", adZone='");
        stringBuilder.append((Object)this.b);
        stringBuilder.append('\'');
        stringBuilder.append(", sourceIconUrl='");
        stringBuilder.append(this.d);
        stringBuilder.append('\'');
        stringBuilder.append(", sourceImageUrl='");
        stringBuilder.append(this.e);
        stringBuilder.append('\'');
        stringBuilder.append(", sourceStarRatingImageUrl='");
        stringBuilder.append(this.f);
        stringBuilder.append('\'');
        stringBuilder.append(", sourceVideoUrl='");
        stringBuilder.append(this.g);
        stringBuilder.append('\'');
        stringBuilder.append(", title='");
        stringBuilder.append(this.h);
        stringBuilder.append('\'');
        stringBuilder.append(", descriptionText='");
        stringBuilder.append(this.i);
        stringBuilder.append('\'');
        stringBuilder.append(", captionText='");
        stringBuilder.append(this.j);
        stringBuilder.append('\'');
        stringBuilder.append(", ctaText='");
        stringBuilder.append(this.k);
        stringBuilder.append('\'');
        stringBuilder.append(", iconUrl='");
        stringBuilder.append(this.u);
        stringBuilder.append('\'');
        stringBuilder.append(", imageUrl='");
        stringBuilder.append(this.v);
        stringBuilder.append('\'');
        stringBuilder.append(", starRating='");
        stringBuilder.append(this.w);
        stringBuilder.append('\'');
        stringBuilder.append(", videoUrl='");
        stringBuilder.append(this.x);
        stringBuilder.append('\'');
        stringBuilder.append(", clickUrl='");
        stringBuilder.append(this.l);
        stringBuilder.append('\'');
        stringBuilder.append(", impressionTrackingUrl='");
        stringBuilder.append(this.m);
        stringBuilder.append('\'');
        stringBuilder.append(", videoStartTrackingUrl='");
        stringBuilder.append(this.n);
        stringBuilder.append('\'');
        stringBuilder.append(", videoEndTrackingUrl='");
        stringBuilder.append(this.o);
        stringBuilder.append('\'');
        stringBuilder.append(", impressionPostbacks=");
        stringBuilder.append(this.p);
        stringBuilder.append('\'');
        stringBuilder.append(", clickTrackingPostbacks=");
        stringBuilder.append(this.q);
        stringBuilder.append('\'');
        stringBuilder.append(", resourcePrefixes=");
        stringBuilder.append(this.t);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    @Override
    public void trackImpression() {
        this.trackImpression(null);
    }

    @Override
    public void trackImpression(AppLovinPostbackListener appLovinPostbackListener) {
        if (!this.y.getAndSet(true)) {
            this.a.u().a("AppLovinNativeAd", "Tracking impression...");
            for (com.applovin.impl.sdk.c.a a2 : this.p) {
                this.a.J().dispatchPostbackRequest(f.b(this.a).d(a2.a()).f(a2.b()).b(false).b(), appLovinPostbackListener);
            }
        } else if (appLovinPostbackListener != null) {
            appLovinPostbackListener.onPostbackFailure(this.m, -702);
        }
    }

}

