/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  com.startapp.android.publish.common.metaData.MetaData$a
 *  com.startapp.android.publish.common.metaData.MetaDataRequest
 *  java.io.File
 *  java.io.Serializable
 *  java.lang.CharSequence
 *  java.lang.Enum
 *  java.lang.Integer
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Set
 *  java.util.concurrent.TimeUnit
 */
package com.startapp.android.publish.common.metaData;

import android.content.Context;
import android.os.Build;
import com.startapp.android.publish.adsCommon.AdsConstants;
import com.startapp.android.publish.adsCommon.Utils.i;
import com.startapp.android.publish.adsCommon.k;
import com.startapp.android.publish.common.metaData.LocationConfig;
import com.startapp.android.publish.common.metaData.MetaData;
import com.startapp.android.publish.common.metaData.MetaDataRequest;
import com.startapp.android.publish.common.metaData.c;
import com.startapp.android.publish.common.metaData.d;
import com.startapp.android.publish.common.metaData.g;
import com.startapp.android.publish.common.metaData.h;
import com.startapp.android.publish.common.model.AdPreferences;
import com.startapp.common.Constants;
import com.startapp.common.a;
import com.startapp.common.a.e;
import com.startapp.common.c.f;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/*
 * Exception performing whole class analysis.
 */
public class MetaData
implements Serializable {
    public static final String DEFAULT_AD_PLATFORM_HOST;
    public static final boolean DEFAULT_ALWAYS_SEND_TOKEN = true;
    public static final String DEFAULT_ASSETS_BASE_URL_SECURED = "";
    public static final boolean DEFAULT_BT_ENABLED = false;
    public static final boolean DEFAULT_COMPRESSION_ENABLED = false;
    public static final boolean DEFAULT_INAPPBROWSER = true;
    public static final Set<String> DEFAULT_INSTALLERS_LIST;
    public static final Set<Integer> DEFAULT_INVALID_NETWORK_CODES_INFO_EVENTS;
    public static final long DEFAULT_LAST_KNOWN_LOCATION_THRESHOLD = 30L;
    public static final String DEFAULT_LOCATION_SOURCE = "API";
    public static final String DEFAULT_METADATA_HOST;
    public static final boolean DEFAULT_OM_SDK_STATE = false;
    public static final boolean DEFAULT_PERIODIC_INFOEVENT_ENABLED = false;
    public static final int DEFAULT_PERIODIC_INFOEVENT_INTERVAL = 360;
    public static final int[] DEFAULT_PERIODIC_INFOEVENT_INTERVALS;
    public static final boolean DEFAULT_PERIODIC_INFOEVENT_ON_RUN_TIME = false;
    public static final boolean DEFAULT_PERIODIC_METADATA_ENABLED = false;
    public static final int DEFAULT_PERIODIC_METADATA_INTERVAL = 360;
    public static final Set<String> DEFAULT_PRE_INSTALLED_PACKAGES;
    public static final String DEFAULT_PROFILE_ID;
    public static final int DEFAULT_SESSION_MAX_BACKGROUND_TIME = 1800;
    public static final boolean DEFAULT_SIMPLE_TOKEN_ENABLED = true;
    public static final int DEFAULT_STOP_AUTO_LOAD_AMOUNT = 3;
    public static final int DEFAULT_STOP_AUTO_LOAD_PRE_CAHE_AMOUNT = 3;
    public static final boolean DEFAULT_WF_SCAN_ENABLED = false;
    public static final String KEY_METADATA = "metaData";
    private static transient MetaData instance;
    private static transient Object lock;
    private static final long serialVersionUID = 1L;
    private static transient c task;
    private long IABDisplayImpressionDelayInSeconds;
    private long IABVideoImpressionDelayInSeconds;
    @f(a=true)
    private h SimpleToken;
    private boolean SupportIABViewability;
    private String adPlatformBannerHostSecured;
    public String adPlatformHostSecured;
    private String adPlatformNativeHostSecured;
    private String adPlatformOverlayHostSecured;
    private String adPlatformReturnHostSecured;
    private String adPlatformSplashHostSecured;
    private boolean alwaysSendToken;
    @f(a=true)
    public com.startapp.android.publish.adsCommon.f.a analytics;
    private String assetsBaseUrlSecured;
    @f(a=true)
    private com.startapp.android.publish.common.metaData.b btConfig;
    private boolean btEnabled;
    private boolean chromeCustomeTabsExternal;
    private boolean chromeCustomeTabsInternal;
    private boolean compressionEnabled;
    private boolean dns;
    private boolean inAppBrowser;
    @f(b="Lcom/startapp/android/publish/common/metaData/MetaData$b;")
    private b inAppBrowserPreLoad;
    @f(b="Ljava/util/HashSet;")
    private Set<String> installersList;
    @f(b="Ljava/util/HashSet;")
    private Set<Integer> invalidForRetry;
    @f(b="Ljava/util/HashSet;")
    private Set<Integer> invalidNetworkCodesInfoEvents;
    private boolean isToken1Mandatory;
    private transient boolean loading;
    @f(a=true)
    private LocationConfig location;
    public String metaDataHostSecured;
    private transient List<d> metaDataListeners;
    private String metadataUpdateVersion;
    private boolean omSdkEnabled;
    private int[] periodicEventIntMin;
    private boolean periodicInfoEventEnabled;
    private int periodicInfoEventIntervalInMinutes;
    private boolean periodicInfoEventOnRunTimeEnabled;
    private boolean periodicMetaDataEnabled;
    private int periodicMetaDataIntervalInMinutes;
    @f(b="Ljava/util/HashSet;")
    private Set<String> preInstalledPackages;
    private String profileId;
    private transient boolean ready;
    @f(a=true)
    private g sensorsConfig;
    private int sessionMaxBackgroundTime;
    private boolean simpleToken2;
    private int stopAutoLoadAmount;
    private int stopAutoLoadPreCacheAmount;
    private boolean trueNetEnabled;
    private long userAgentDelayInSeconds;
    private boolean userAgentEnabled;
    private boolean webViewSecured;
    private boolean wfScanEnabled;

    static {
        lock = new Object();
        Object[] arrobject = new String[]{Constants.a};
        DEFAULT_INSTALLERS_LIST = new HashSet((Collection)Arrays.asList((Object[])arrobject));
        DEFAULT_METADATA_HOST = new String(new byte[]{104, 116, 116, 112, 115, 58, 47, 47, 105, 110, 105, 116, 46, 115, 116, 97, 114, 116, 97, 112, 112, 115, 101, 114, 118, 105, 99, 101, 46, 99, 111, 109, 47, 49, 46, 53, 47});
        DEFAULT_AD_PLATFORM_HOST = new String(new byte[]{104, 116, 116, 112, 115, 58, 47, 47, 114, 101, 113, 46, 115, 116, 97, 114, 116, 97, 112, 112, 115, 101, 114, 118, 105, 99, 101, 46, 99, 111, 109, 47, 49, 46, 53, 47});
        DEFAULT_PROFILE_ID = null;
        DEFAULT_PERIODIC_INFOEVENT_INTERVALS = new int[]{60, 60, 240};
        Object[] arrobject2 = new String[]{new String(new byte[]{99, 111, 109, 46, 102, 97, 99, 101, 98, 111, 111, 107, 46, 107, 97, 116, 97, 110, 97}), new String(new byte[]{99, 111, 109, 46, 121, 97, 110, 100, 101, 120, 46, 98, 114, 111, 119, 115, 101, 114})};
        DEFAULT_PRE_INSTALLED_PACKAGES = new HashSet((Collection)Arrays.asList((Object[])arrobject2));
        Object[] arrobject3 = new Integer[]{204};
        DEFAULT_INVALID_NETWORK_CODES_INFO_EVENTS = new HashSet((Collection)Arrays.asList((Object[])arrobject3));
        instance = new MetaData();
    }

    private MetaData() {
        this.SimpleToken = new h();
        this.metaDataHostSecured = DEFAULT_METADATA_HOST;
        this.adPlatformHostSecured = DEFAULT_AD_PLATFORM_HOST;
        this.sessionMaxBackgroundTime = 1800;
        this.profileId = DEFAULT_PROFILE_ID;
        this.installersList = DEFAULT_INSTALLERS_LIST;
        this.preInstalledPackages = DEFAULT_PRE_INSTALLED_PACKAGES;
        this.simpleToken2 = true;
        this.alwaysSendToken = true;
        this.isToken1Mandatory = true;
        this.compressionEnabled = false;
        this.btEnabled = false;
        this.periodicMetaDataEnabled = false;
        this.periodicMetaDataIntervalInMinutes = 360;
        this.periodicInfoEventEnabled = false;
        this.periodicInfoEventOnRunTimeEnabled = false;
        this.periodicInfoEventIntervalInMinutes = 360;
        this.periodicEventIntMin = DEFAULT_PERIODIC_INFOEVENT_INTERVALS;
        this.inAppBrowser = true;
        this.SupportIABViewability = true;
        this.IABDisplayImpressionDelayInSeconds = 1L;
        this.IABVideoImpressionDelayInSeconds = 2L;
        this.userAgentDelayInSeconds = 5L;
        this.userAgentEnabled = true;
        this.sensorsConfig = new g();
        this.btConfig = new com.startapp.android.publish.common.metaData.b();
        this.assetsBaseUrlSecured = DEFAULT_ASSETS_BASE_URL_SECURED;
        this.invalidForRetry = new HashSet();
        this.invalidNetworkCodesInfoEvents = DEFAULT_INVALID_NETWORK_CODES_INFO_EVENTS;
        this.analytics = new com.startapp.android.publish.adsCommon.f.a();
        this.location = new LocationConfig();
        this.wfScanEnabled = false;
        this.loading = false;
        this.ready = false;
        this.metaDataListeners = new ArrayList();
        this.metadataUpdateVersion = AdsConstants.h;
        this.dns = false;
        this.stopAutoLoadAmount = 3;
        this.stopAutoLoadPreCacheAmount = 3;
        this.trueNetEnabled = false;
        this.webViewSecured = true;
        this.omSdkEnabled = false;
        this.chromeCustomeTabsInternal = true;
        this.chromeCustomeTabsExternal = true;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public static void failedLoading() {
        ArrayList arrayList;
        Object object;
        Object object2 = object = lock;
        // MONITORENTER : object2
        if (MetaData.getInstance().metaDataListeners != null) {
            arrayList = new ArrayList(MetaData.getInstance().metaDataListeners);
            MetaData.getInstance().metaDataListeners.clear();
        } else {
            arrayList = null;
        }
        MetaData.getInstance().loading = false;
        // MONITOREXIT : object2
        if (arrayList == null) return;
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            ((d)iterator.next()).b();
        }
        return;
        {
            catch (Throwable throwable) {}
            {
                // MONITOREXIT : object2
                throw throwable;
            }
        }
    }

    public static String getHostForWebview(String string, int n2, boolean bl) {
        int n3;
        String string2 = n2 <= 26 && !bl ? "http" : "https";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append("://");
        if (!string.startsWith(stringBuilder.toString()) && (n3 = string.indexOf(58)) != -1) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(string2);
            stringBuilder2.append(string.substring(n3));
            string = stringBuilder2.toString();
        }
        return string;
    }

    public static MetaData getInstance() {
        return instance;
    }

    public static Object getLock() {
        return lock;
    }

    public static void init(Context context) {
        MetaData metaData = e.a(context, "StartappMetadata", MetaData.class);
        MetaData metaData2 = new MetaData();
        if (metaData != null) {
            boolean bl = i.a(metaData, metaData2);
            if (!metaData.isMetaDataVersionChanged() && bl) {
                com.startapp.android.publish.adsCommon.f.f.a(context, com.startapp.android.publish.adsCommon.f.d.k, "MetaData", DEFAULT_ASSETS_BASE_URL_SECURED, DEFAULT_ASSETS_BASE_URL_SECURED);
            }
            metaData.initTransientFields();
            instance = metaData;
        } else {
            instance = metaData2;
        }
        MetaData.getInstance().applyAdPlatformProtocolToHosts();
    }

    private void initTransientFields() {
        this.loading = false;
        this.ready = false;
        this.metaDataListeners = new ArrayList();
    }

    public static boolean isLoadedFromServer(Context context) {
        return context.getFileStreamPath("StartappMetadata").exists();
    }

    private boolean isMetaDataVersionChanged() {
        return true ^ AdsConstants.h.equals((Object)this.metadataUpdateVersion);
    }

    public static void preCacheResources(Context context, String string) {
        if (string != null && !string.equals((Object)DEFAULT_ASSETS_BASE_URL_SECURED)) {
            if (!com.startapp.android.publish.adsCommon.Utils.a.a(context, "close_button.png", ".png") && !i.a()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string);
                stringBuilder.append("close_button");
                stringBuilder.append(".png");
                new com.startapp.common.a(stringBuilder.toString(), (a.a)new /* Unavailable Anonymous Inner Class!! */, 0).a();
            }
            if (i.a(256L)) {
                for (String string2 : AdsConstants.k) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(string2);
                    stringBuilder.append(".png");
                    if (com.startapp.android.publish.adsCommon.Utils.a.a(context, stringBuilder.toString(), ".png")) continue;
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(string);
                    stringBuilder2.append(string2);
                    stringBuilder2.append(".png");
                    new com.startapp.common.a(stringBuilder2.toString(), (a.a)new /* Unavailable Anonymous Inner Class!! */, 0).a();
                }
            }
            if (i.a(64L)) {
                for (String string3 : AdsConstants.l) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(string3);
                    stringBuilder.append(".png");
                    if (com.startapp.android.publish.adsCommon.Utils.a.a(context, stringBuilder.toString(), ".png")) continue;
                    StringBuilder stringBuilder3 = new StringBuilder();
                    stringBuilder3.append(string);
                    stringBuilder3.append(string3);
                    stringBuilder3.append(".png");
                    new com.startapp.common.a(stringBuilder3.toString(), (a.a)new /* Unavailable Anonymous Inner Class!! */, 0).a();
                }
                if (!com.startapp.android.publish.adsCommon.Utils.a.a(context, "logo.png", ".png")) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(string);
                    stringBuilder.append("logo");
                    stringBuilder.append(".png");
                    new com.startapp.common.a(stringBuilder.toString(), (a.a)new /* Unavailable Anonymous Inner Class!! */, 0).a();
                    return;
                }
            } else if (i.a(32L)) {
                for (String string4 : AdsConstants.l) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(string4);
                    stringBuilder.append(".png");
                    if (com.startapp.android.publish.adsCommon.Utils.a.a(context, stringBuilder.toString(), ".png")) continue;
                    StringBuilder stringBuilder4 = new StringBuilder();
                    stringBuilder4.append(string);
                    stringBuilder4.append(string4);
                    stringBuilder4.append(".png");
                    new com.startapp.common.a(stringBuilder4.toString(), (a.a)new /* Unavailable Anonymous Inner Class!! */, 0).a();
                }
            }
        }
    }

    private String replaceAdProtocol(String string, String string2) {
        if (string != null) {
            return string.replace((CharSequence)"%AdPlatformProtocol%", (CharSequence)"1.5");
        }
        return string2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void update(Context context, MetaData metaData) {
        Object object;
        Object object2 = object = lock;
        synchronized (object2) {
            metaData.metaDataListeners = MetaData.getInstance().metaDataListeners;
            instance = metaData;
            if (Constants.a().booleanValue()) {
                com.startapp.common.a.g.a(3, "MetaData received:");
                com.startapp.common.a.g.a(3, com.startapp.common.c.b.a(metaData));
            }
            MetaData.getInstance().applyAdPlatformProtocolToHosts();
            metaData.metadataUpdateVersion = AdsConstants.h;
            e.b(context, "StartappMetadata", metaData);
            com.startapp.common.a.g.a(3, "MetaData saved:");
            MetaData.getInstance().loading = false;
            MetaData.getInstance().ready = true;
            if (MetaData.getInstance().metaDataListeners != null) {
                ArrayList arrayList = new ArrayList(MetaData.getInstance().metaDataListeners);
                MetaData.getInstance().metaDataListeners.clear();
                Iterator iterator = arrayList.iterator();
                while (iterator.hasNext()) {
                    ((d)iterator.next()).a();
                }
            }
            k.b(context, "totalSessions", 1 + k.a(context, "totalSessions", 0));
            task = null;
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void addMetaDataListener(d d2) {
        Object object;
        Object object2 = object = lock;
        synchronized (object2) {
            this.metaDataListeners.add((Object)d2);
            return;
        }
    }

    public void applyAdPlatformProtocolToHosts() {
        this.adPlatformHostSecured = this.replaceAdProtocol(this.adPlatformHostSecured, DEFAULT_AD_PLATFORM_HOST);
        this.metaDataHostSecured = this.replaceAdProtocol(this.metaDataHostSecured, DEFAULT_METADATA_HOST);
        this.adPlatformBannerHostSecured = this.replaceAdProtocol(this.adPlatformBannerHostSecured, null);
        this.adPlatformSplashHostSecured = this.replaceAdProtocol(this.adPlatformSplashHostSecured, null);
        this.adPlatformReturnHostSecured = this.replaceAdProtocol(this.adPlatformReturnHostSecured, null);
        this.adPlatformOverlayHostSecured = this.replaceAdProtocol(this.adPlatformOverlayHostSecured, null);
        this.adPlatformNativeHostSecured = this.replaceAdProtocol(this.adPlatformNativeHostSecured, null);
    }

    public boolean canShowAd() {
        return true ^ this.dns;
    }

    public String getAdPlatformHost() {
        if (AdsConstants.OVERRIDE_HOST != null) {
            return AdsConstants.OVERRIDE_HOST;
        }
        String string = this.adPlatformHostSecured;
        if (string != null) {
            return string;
        }
        return DEFAULT_AD_PLATFORM_HOST;
    }

    public String getAdPlatformHost(AdPreferences.Placement placement) {
        int n2 = 1.a[placement.ordinal()];
        if (n2 != 1) {
            if (n2 != 2) {
                if (n2 != 3) {
                    if (n2 != 4) {
                        if (n2 != 5) {
                            return this.getAdPlatformHost();
                        }
                        String string = this.adPlatformSplashHostSecured;
                        if (string != null) {
                            return string;
                        }
                        return this.getAdPlatformHost();
                    }
                    String string = this.adPlatformReturnHostSecured;
                    if (string != null) {
                        return string;
                    }
                    return this.getAdPlatformHost();
                }
                String string = this.adPlatformNativeHostSecured;
                if (string != null) {
                    return string;
                }
                return this.getAdPlatformHost();
            }
            String string = this.adPlatformOverlayHostSecured;
            if (string != null) {
                return string;
            }
            return this.getAdPlatformHost();
        }
        String string = this.adPlatformBannerHostSecured;
        if (string != null) {
            return string;
        }
        return this.getAdPlatformHost();
    }

    public com.startapp.android.publish.adsCommon.f.a getAnalyticsConfig() {
        return this.analytics;
    }

    public String getAssetsBaseUrl() {
        String string = this.assetsBaseUrlSecured;
        if (string != null) {
            return string;
        }
        return DEFAULT_ASSETS_BASE_URL_SECURED;
    }

    public com.startapp.android.publish.common.metaData.b getBluetoothConfig() {
        return this.btConfig;
    }

    public boolean getChromeCustomeTabsExternal() {
        return this.chromeCustomeTabsExternal;
    }

    public boolean getChromeCustomeTabsInternal() {
        return this.chromeCustomeTabsInternal;
    }

    public String getHostForWebview() {
        return MetaData.getHostForWebview(MetaData.getInstance().getAdPlatformHost(), Build.VERSION.SDK_INT, this.webViewSecured);
    }

    public long getIABDisplayImpressionDelayInSeconds() {
        return this.IABDisplayImpressionDelayInSeconds;
    }

    public long getIABVideoImpressionDelayInSeconds() {
        return this.IABVideoImpressionDelayInSeconds;
    }

    public b getInAppBrowserPreLoad() {
        return this.inAppBrowserPreLoad;
    }

    public Set<String> getInstallersList() {
        return this.installersList;
    }

    public Set<Integer> getInvalidForRetry() {
        Set<Integer> set = this.invalidForRetry;
        if (set != null) {
            return set;
        }
        return new HashSet();
    }

    public Set<Integer> getInvalidNetworkCodesInfoEvents() {
        Set<Integer> set = this.invalidNetworkCodesInfoEvents;
        if (set != null) {
            return set;
        }
        return DEFAULT_INVALID_NETWORK_CODES_INFO_EVENTS;
    }

    public LocationConfig getLocationConfig() {
        return this.location;
    }

    public String getMetaDataHost() {
        if (AdsConstants.OVERRIDE_HOST != null) {
            return AdsConstants.OVERRIDE_HOST;
        }
        return this.metaDataHostSecured;
    }

    public int getPeriodicInfoEventIntervalInMinutes(Context context) {
        int n2;
        int[] arrn = this.periodicEventIntMin;
        if (arrn == null || arrn.length < 3) {
            this.periodicEventIntMin = DEFAULT_PERIODIC_INFOEVENT_INTERVALS;
        }
        if (com.startapp.common.a.c.a(context, "android.permission.ACCESS_FINE_LOCATION")) {
            n2 = this.periodicEventIntMin[0];
            if (n2 <= 0) {
                return DEFAULT_PERIODIC_INFOEVENT_INTERVALS[0];
            }
        } else if (com.startapp.common.a.c.a(context, "android.permission.ACCESS_COARSE_LOCATION")) {
            n2 = this.periodicEventIntMin[1];
            if (n2 <= 0) {
                return DEFAULT_PERIODIC_INFOEVENT_INTERVALS[1];
            }
        } else {
            n2 = this.periodicEventIntMin[2];
        }
        return n2;
    }

    public int getPeriodicMetaDataInterval() {
        return this.periodicMetaDataIntervalInMinutes;
    }

    public Set<String> getPreInstalledPackages() {
        Set<String> set = this.preInstalledPackages;
        if (set == null) {
            set = DEFAULT_PRE_INSTALLED_PACKAGES;
        }
        return Collections.unmodifiableSet(set);
    }

    public String getProfileId() {
        return this.profileId;
    }

    public g getSensorsConfig() {
        return this.sensorsConfig;
    }

    public long getSessionMaxBackgroundTime() {
        return TimeUnit.SECONDS.toMillis((long)this.sessionMaxBackgroundTime);
    }

    public h getSimpleTokenConfig() {
        return this.SimpleToken;
    }

    public int getStopAutoLoadAmount() {
        return this.stopAutoLoadAmount;
    }

    public int getStopAutoLoadPreCacheAmount() {
        return this.stopAutoLoadPreCacheAmount;
    }

    public boolean getTrueNetEnabled() {
        return this.trueNetEnabled;
    }

    public long getUserAgentDelayInSeconds() {
        return this.userAgentDelayInSeconds;
    }

    public boolean isAlwaysSendToken() {
        return this.alwaysSendToken;
    }

    public boolean isCompressionEnabled() {
        return this.compressionEnabled;
    }

    public boolean isInAppBrowser() {
        return i.a(256L) && this.inAppBrowser;
    }

    public boolean isLoading() {
        return this.loading;
    }

    public boolean isOmsdkEnabled() {
        return this.omSdkEnabled;
    }

    public boolean isPeriodicInfoEventEnabled() {
        return this.periodicInfoEventEnabled;
    }

    public boolean isPeriodicInfoEventOnRunTimeEnabled() {
        return this.periodicInfoEventOnRunTimeEnabled;
    }

    public boolean isPeriodicMetaDataEnabled() {
        return this.periodicMetaDataEnabled;
    }

    public boolean isReady() {
        return this.ready;
    }

    public boolean isSimpleToken2() {
        return this.simpleToken2;
    }

    public boolean isSupportIABViewability() {
        return this.SupportIABViewability;
    }

    public boolean isToken1Mandatory() {
        return this.isToken1Mandatory;
    }

    public boolean isUserAgentEnabled() {
        return this.userAgentEnabled;
    }

    public boolean isWfScanEnabled() {
        return this.wfScanEnabled;
    }

    public void loadFromServer(Context context, AdPreferences adPreferences, MetaDataRequest.a a2, boolean bl, d d2) {
        this.loadFromServer(context, adPreferences, a2, bl, d2, false);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void loadFromServer(Context context, AdPreferences adPreferences, MetaDataRequest.a a2, boolean bl, d d2, boolean bl2) {
        Object object;
        if (!bl && d2 != null) {
            d2.a();
        }
        Object object2 = object = lock;
        synchronized (object2) {
            if (MetaData.getInstance().isReady() && !bl2) {
                // MONITOREXIT [2, 7] lbl6 : w: MONITOREXIT : var9_8
                if (bl && d2 != null) {
                    d2.a();
                }
                return;
            }
            if (!MetaData.getInstance().isLoading() || bl2) {
                this.loading = true;
                this.ready = false;
                if (task != null) {
                    task.b();
                }
                task = new c(context, adPreferences, a2);
                task.a();
            }
            if (bl && d2 != null) {
                MetaData.getInstance().addMetaDataListener(d2);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void removeMetaDataListener(d d2) {
        Object object;
        Object object2 = object = lock;
        synchronized (object2) {
            this.metaDataListeners.remove((Object)d2);
            return;
        }
    }

    public void setAlwaysSendToken(boolean bl) {
        this.alwaysSendToken = bl;
    }

    public void setCompressionEnabled(boolean bl) {
        this.compressionEnabled = bl;
    }

    public void setInAppBrowser(boolean bl) {
        this.inAppBrowser = bl;
    }

    public void setInAppBrowserPreLoad(b b2) {
        this.inAppBrowserPreLoad = b2;
    }

    public void setInstallersList(Set<String> set) {
        this.installersList = set;
    }

    public void setPeriodicInfoEventEnabled(boolean bl) {
        this.periodicInfoEventEnabled = bl;
    }

    public void setPeriodicInfoEventIntervalInMinutes(int n2) {
        this.periodicInfoEventIntervalInMinutes = n2;
    }

    public void setPeriodicMetaDataEnabled(boolean bl) {
        this.periodicMetaDataEnabled = bl;
    }

    public void setPeriodicMetaDataInterval(int n2) {
        this.periodicMetaDataIntervalInMinutes = n2;
    }

    public void setPreInstalledPackages(Set<String> set) {
        this.preInstalledPackages = set;
    }

    public void setReady(boolean bl) {
        this.ready = bl;
    }

    public void setSimpleToken2(boolean bl) {
        this.simpleToken2 = bl;
    }

    protected void setSimpleTokenConfig(h h2) {
        this.SimpleToken = h2;
    }

    public static final class b
    extends Enum<b> {
        public static final /* enum */ b a = new b();
        public static final /* enum */ b b = new b();
        public static final /* enum */ b c = new b();
        private static final /* synthetic */ b[] d;

        static {
            b[] arrb = new b[]{a, b, c};
            d = arrb;
        }

        public static b valueOf(String string) {
            return (b)Enum.valueOf(b.class, (String)string);
        }

        public static b[] values() {
            return (b[])d.clone();
        }
    }

}

