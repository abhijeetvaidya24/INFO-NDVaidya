/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.io.Serializable
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.Set
 *  java.util.concurrent.TimeUnit
 */
package com.startapp.android.publish.adsCommon;

import android.content.Context;
import com.startapp.android.publish.adsCommon.AdsConstants;
import com.startapp.android.publish.adsCommon.Utils.i;
import com.startapp.android.publish.adsCommon.a.e;
import com.startapp.android.publish.adsCommon.f.d;
import com.startapp.android.publish.adsCommon.f.f;
import com.startapp.android.publish.adsCommon.n;
import com.startapp.android.publish.common.metaData.MetaDataStyle;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class b
implements Serializable {
    public static final Integer a;
    public static final Integer b;
    public static final Set<String> c;
    public static final Integer d;
    public static final Integer e;
    public static final Integer f;
    private static transient Object g;
    private static transient b h;
    private static final long serialVersionUID = 1L;
    private String acMetadataUpdateVersion = AdsConstants.h;
    @com.startapp.common.c.f(a=true)
    private e adRules;
    private boolean appPresence;
    private boolean autoInterstitialEnabled;
    private Integer backgroundGradientBottom;
    private Integer backgroundGradientTop;
    private int defaultActivitiesBetweenAds;
    private int defaultSecondsBetweenAds;
    private boolean disableInAppStore;
    private boolean disableReturnAd;
    private boolean disableSplashAd;
    private boolean disableTwoClicks;
    private boolean enableForceExternalBrowser;
    private boolean enableSmartRedirect;
    private boolean enforceForeground;
    private int forceExternalBrowserDaysInterval;
    private Integer fullpageOfferWallProbability;
    private Integer fullpageOverlayProbability;
    private Integer homeProbability3D;
    private Integer itemDescriptionTextColor;
    @com.startapp.common.c.f(b="Ljava/util/HashSet;")
    private Set<String> itemDescriptionTextDecoration;
    private Integer itemDescriptionTextSize;
    private Integer itemGradientBottom;
    private Integer itemGradientTop;
    private Integer itemTitleTextColor;
    @com.startapp.common.c.f(b="Ljava/util/HashSet;")
    private Set<String> itemTitleTextDecoration;
    private Integer itemTitleTextSize;
    private Integer maxAds;
    private Integer poweredByBackgroundColor;
    private Integer poweredByTextColor;
    private Integer probability3D;
    private long returnAdMinBackgroundTime;
    private long smartRedirectLoadedTimeout;
    private int smartRedirectTimeout;
    @com.startapp.common.c.f(b="Ljava/util/HashMap;", c="Lcom/startapp/android/publish/common/metaData/MetaDataStyle;")
    private HashMap<String, MetaDataStyle> templates;
    private Integer titleBackgroundColor;
    private String titleContent;
    private Integer titleLineColor;
    private Integer titleTextColor;
    @com.startapp.common.c.f(b="Ljava/util/HashSet;")
    private Set<String> titleTextDecoration;
    private Integer titleTextSize;
    @com.startapp.common.c.f(a=true)
    private n video;

    static {
        Integer n2;
        g = new Object();
        a = 18;
        b = n2 = Integer.valueOf((int)-1);
        c = new HashSet((Collection)Arrays.asList((Object[])new String[]{"BOLD"}));
        d = -16777216;
        e = -14803426;
        f = n2;
        h = new b();
    }

    public b() {
        Integer n2;
        Integer n3;
        this.probability3D = n2 = Integer.valueOf((int)0);
        this.homeProbability3D = 80;
        this.fullpageOfferWallProbability = 100;
        this.fullpageOverlayProbability = n2;
        this.backgroundGradientTop = n3 = Integer.valueOf((int)-14606047);
        this.backgroundGradientBottom = n3;
        this.maxAds = 10;
        this.titleBackgroundColor = -14803426;
        this.titleContent = "Recommended for you";
        this.titleTextSize = a;
        this.titleTextColor = b;
        this.titleTextDecoration = c;
        this.titleLineColor = d;
        this.itemGradientTop = -14014151;
        this.itemGradientBottom = -8750199;
        this.itemTitleTextSize = MetaDataStyle.DEFAULT_ITEM_TITLE_TEXT_SIZE;
        this.itemTitleTextColor = MetaDataStyle.DEFAULT_ITEM_TITLE_TEXT_COLOR;
        this.itemTitleTextDecoration = MetaDataStyle.DEFAULT_ITEM_TITLE_TEXT_DECORATION;
        this.itemDescriptionTextSize = MetaDataStyle.DEFAULT_ITEM_DESC_TEXT_SIZE;
        this.itemDescriptionTextColor = MetaDataStyle.DEFAULT_ITEM_DESC_TEXT_COLOR;
        this.itemDescriptionTextDecoration = MetaDataStyle.DEFAULT_ITEM_DESC_TEXT_DECORATION;
        this.templates = new HashMap();
        this.adRules = new e();
        this.poweredByBackgroundColor = e;
        this.poweredByTextColor = f;
        this.returnAdMinBackgroundTime = 300L;
        this.disableReturnAd = false;
        this.disableSplashAd = false;
        this.smartRedirectTimeout = 5;
        this.smartRedirectLoadedTimeout = 1000L;
        this.enableSmartRedirect = true;
        this.autoInterstitialEnabled = true;
        this.defaultActivitiesBetweenAds = 1;
        this.defaultSecondsBetweenAds = 0;
        this.disableTwoClicks = false;
        this.appPresence = true;
        this.disableInAppStore = false;
        this.video = new n();
        this.forceExternalBrowserDaysInterval = 7;
        this.enableForceExternalBrowser = true;
        this.enforceForeground = false;
    }

    private boolean O() {
        return true ^ AdsConstants.h.equals((Object)this.acMetadataUpdateVersion);
    }

    private void P() {
        this.adRules.b();
    }

    public static b a() {
        return h;
    }

    public static void a(Context context) {
        b b2 = com.startapp.common.a.e.a(context, "StartappAdsMetadata", b.class);
        b b3 = new b();
        if (b2 != null) {
            boolean bl = i.a(b2, b3);
            if (!b2.O() && bl) {
                f.a(context, d.k, "AdsCommonMetaData", "", "");
            }
            b2.P();
            h = b2;
            return;
        }
        h = b3;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(Context context, b b2) {
        Object object;
        Object object2 = object = g;
        synchronized (object2) {
            b2.acMetadataUpdateVersion = AdsConstants.h;
            h = b2;
            com.startapp.common.a.e.a(context, "StartappAdsMetadata", (Serializable)b2);
            return;
        }
    }

    public long A() {
        return TimeUnit.SECONDS.toMillis((long)this.smartRedirectTimeout);
    }

    public long B() {
        return this.smartRedirectLoadedTimeout;
    }

    public boolean C() {
        return this.enableSmartRedirect;
    }

    public boolean D() {
        return this.disableTwoClicks;
    }

    public boolean E() {
        return this.appPresence;
    }

    public e F() {
        return this.adRules;
    }

    public boolean G() {
        return this.disableInAppStore;
    }

    public n H() {
        return this.video;
    }

    public boolean I() {
        return this.autoInterstitialEnabled;
    }

    public int J() {
        return this.defaultActivitiesBetweenAds;
    }

    public int K() {
        return this.defaultSecondsBetweenAds;
    }

    public int L() {
        return this.forceExternalBrowserDaysInterval;
    }

    public boolean M() {
        return this.enableForceExternalBrowser;
    }

    public boolean N() {
        return this.enforceForeground;
    }

    public MetaDataStyle a(String string) {
        return (MetaDataStyle)this.templates.get((Object)string);
    }

    public int b() {
        return this.fullpageOfferWallProbability;
    }

    public int c() {
        return this.fullpageOverlayProbability;
    }

    public int d() {
        return this.probability3D;
    }

    public int e() {
        return this.backgroundGradientTop;
    }

    public int f() {
        return this.backgroundGradientBottom;
    }

    public int g() {
        return this.maxAds;
    }

    public Integer h() {
        return this.titleBackgroundColor;
    }

    public String i() {
        return this.titleContent;
    }

    public Integer j() {
        return this.titleTextSize;
    }

    public Integer k() {
        return this.titleTextColor;
    }

    public Set<String> l() {
        return this.titleTextDecoration;
    }

    public Integer m() {
        return this.titleLineColor;
    }

    public int n() {
        return this.itemGradientTop;
    }

    public int o() {
        return this.itemGradientBottom;
    }

    public Integer p() {
        return this.itemTitleTextSize;
    }

    public Integer q() {
        return this.itemTitleTextColor;
    }

    public Set<String> r() {
        return this.itemTitleTextDecoration;
    }

    public Integer s() {
        return this.itemDescriptionTextSize;
    }

    public Integer t() {
        return this.itemDescriptionTextColor;
    }

    public Set<String> u() {
        return this.itemDescriptionTextDecoration;
    }

    public Integer v() {
        return this.poweredByBackgroundColor;
    }

    public Integer w() {
        return this.poweredByTextColor;
    }

    public long x() {
        return TimeUnit.SECONDS.toMillis(this.returnAdMinBackgroundTime);
    }

    public boolean y() {
        return this.disableReturnAd;
    }

    public boolean z() {
        return this.disableSplashAd;
    }
}

