/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.amazon.device.ads.MobileAdsLogger
 *  com.amazon.device.ads.PreferredMarketplaceRetriever$NullPreferredMarketplaceRetriever
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.concurrent.atomic.AtomicBoolean
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.amazon.device.ads;

import android.content.Context;
import com.amazon.device.ads.DebugProperties;
import com.amazon.device.ads.DeviceInfo;
import com.amazon.device.ads.Metrics;
import com.amazon.device.ads.MetricsCollector;
import com.amazon.device.ads.MobileAdsInfoStore;
import com.amazon.device.ads.MobileAdsLogger;
import com.amazon.device.ads.MobileAdsLoggerFactory;
import com.amazon.device.ads.NumberUtils;
import com.amazon.device.ads.PermissionChecker;
import com.amazon.device.ads.PreferredMarketplaceRetriever;
import com.amazon.device.ads.RegistrationInfo;
import com.amazon.device.ads.ResponseReader;
import com.amazon.device.ads.Settings;
import com.amazon.device.ads.StringUtils;
import com.amazon.device.ads.SystemTime;
import com.amazon.device.ads.ThreadUtils;
import com.amazon.device.ads.Version;
import com.amazon.device.ads.WebRequest;
import com.amazon.device.ads.WebRequestUserId;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

class Configuration {
    private static final String AAX_MSDK_CONFIG_ENDPOINT = "/msdk/getConfig";
    private static final String AAX_PROD_US_HOSTNAME = "mads.amazon-adsystem.com";
    protected static final String CONFIG_APP_DEFINED_MARKETPLACE = "config-appDefinedMarketplace";
    protected static final String CONFIG_LASTFETCHTIME = "config-lastFetchTime";
    protected static final String CONFIG_TTL = "config-ttl";
    protected static final String CONFIG_VERSION_NAME = "configVersion";
    protected static final int CURRENT_CONFIG_VERSION = 4;
    private static final String LOGTAG = "Configuration";
    protected static final int MAX_CONFIG_TTL = 172800000;
    protected static final int MAX_NO_RETRY_TTL = 300000;
    private static Configuration instance = new Configuration();
    private String appDefinedMarketplace = null;
    private final DebugProperties debugProperties;
    private final MobileAdsInfoStore infoStore;
    private boolean isAppDefinedMarketplaceSet = false;
    private final AtomicBoolean isFetching = new AtomicBoolean(false);
    private boolean isFirstParty = false;
    private Boolean lastTestModeValue = null;
    private final List<ConfigurationListener> listeners = new ArrayList(5);
    private final MobileAdsLogger logger;
    private final Metrics metrics;
    private final PermissionChecker permissionChecker;
    private PreferredMarketplaceRetriever pfmRetriever = new PreferredMarketplaceRetriever.NullPreferredMarketplaceRetriever();
    private final Settings settings;
    private final SystemTime systemTime;
    private final ThreadUtils.ThreadRunner threadRunner;
    private final WebRequest.WebRequestFactory webRequestFactory;
    private final WebRequestUserId webRequestUserId;

    protected Configuration() {
        this(new MobileAdsLoggerFactory(), new PermissionChecker(), new WebRequest.WebRequestFactory(), DebugProperties.getInstance(), Settings.getInstance(), MobileAdsInfoStore.getInstance(), new SystemTime(), Metrics.getInstance(), ThreadUtils.getThreadRunner(), new WebRequestUserId());
    }

    Configuration(MobileAdsLoggerFactory mobileAdsLoggerFactory, PermissionChecker permissionChecker, WebRequest.WebRequestFactory webRequestFactory, DebugProperties debugProperties, Settings settings, MobileAdsInfoStore mobileAdsInfoStore, SystemTime systemTime, Metrics metrics, ThreadUtils.ThreadRunner threadRunner, WebRequestUserId webRequestUserId) {
        this.logger = mobileAdsLoggerFactory.createMobileAdsLogger(LOGTAG);
        this.permissionChecker = permissionChecker;
        this.webRequestFactory = webRequestFactory;
        this.debugProperties = debugProperties;
        this.settings = settings;
        this.infoStore = mobileAdsInfoStore;
        this.systemTime = systemTime;
        this.metrics = metrics;
        this.threadRunner = threadRunner;
        this.webRequestUserId = webRequestUserId;
    }

    public static final Configuration getInstance() {
        return instance;
    }

    private String getPreferredMarketplace() {
        return this.pfmRetriever.retrievePreferredMarketplace(MobileAdsInfoStore.getInstance().getApplicationContext());
    }

    private boolean hasAppDefinedMarketplaceChanged() {
        String string = this.settings.getString(CONFIG_APP_DEFINED_MARKETPLACE, null);
        if (this.isAppDefinedMarketplaceSet) {
            this.isAppDefinedMarketplaceSet = false;
            String string2 = this.appDefinedMarketplace;
            if (string2 != null && !string2.equals((Object)string)) {
                this.settings.putLongWithNoFlush(CONFIG_LASTFETCHTIME, 0L);
                this.settings.putStringWithNoFlush(CONFIG_APP_DEFINED_MARKETPLACE, this.appDefinedMarketplace);
                this.settings.flush();
                this.infoStore.getRegistrationInfo().requestNewSISDeviceIdentifier();
                this.logger.d("New application-defined marketplace set. A new configuration will be retrieved.");
                return true;
            }
            if (string != null && this.appDefinedMarketplace == null) {
                this.settings.remove(CONFIG_APP_DEFINED_MARKETPLACE);
                this.infoStore.getRegistrationInfo().requestNewSISDeviceIdentifier();
                this.logger.d("Application-defined marketplace removed. A new configuration will be retrieved.");
                return true;
            }
        }
        return false;
    }

    private void writeSettingFromConfigOption(ConfigOption configOption, JSONObject jSONObject) throws Exception {
        if (configOption.getDataType().equals(String.class)) {
            String string = jSONObject.getString(configOption.getResponseKey());
            if (!configOption.getAllowEmpty() && StringUtils.isNullOrWhiteSpace(string)) {
                throw new IllegalArgumentException("The configuration value must not be empty or contain only white spaces.");
            }
            this.settings.putStringWithNoFlush(configOption.getSettingsName(), string);
            return;
        }
        if (configOption.getDataType().equals(Boolean.class)) {
            boolean bl = jSONObject.getBoolean(configOption.getResponseKey());
            this.settings.putBooleanWithNoFlush(configOption.getSettingsName(), bl);
            return;
        }
        if (configOption.getDataType().equals(Integer.class)) {
            int n = jSONObject.getInt(configOption.getResponseKey());
            this.settings.putIntWithNoFlush(configOption.getSettingsName(), n);
            return;
        }
        if (configOption.getDataType().equals(Long.class)) {
            long l2 = jSONObject.getLong(configOption.getResponseKey());
            this.settings.putLongWithNoFlush(configOption.getSettingsName(), l2);
            return;
        }
        if (configOption.getDataType().equals(JSONObject.class)) {
            JSONObject jSONObject2 = jSONObject.getJSONObject(configOption.getResponseKey());
            this.settings.putJSONObjectWithNoFlush(configOption.getSettingsName(), jSONObject2);
            return;
        }
        throw new IllegalArgumentException("Undefined configuration option type.");
    }

    protected void beginFetch() {
        this.threadRunner.execute(new Runnable(){

            public void run() {
                Configuration.this.fetchConfigurationOnBackgroundThread();
            }
        }, ThreadUtils.ExecutionStyle.SCHEDULE, ThreadUtils.ExecutionThread.BACKGROUND_THREAD);
    }

    protected WebRequest createWebRequest() {
        WebRequest webRequest = this.webRequestFactory.createJSONGetWebRequest();
        webRequest.setExternalLogTag(LOGTAG);
        webRequest.enableLog(true);
        webRequest.setHost(this.debugProperties.getDebugPropertyAsString("debug.aaxConfigHostname", AAX_PROD_US_HOSTNAME));
        webRequest.setPath(AAX_MSDK_CONFIG_ENDPOINT);
        webRequest.setMetricsCollector(this.metrics.getMetricsCollector());
        webRequest.setServiceCallLatencyMetric(Metrics.MetricType.AAX_CONFIG_DOWNLOAD_LATENCY);
        webRequest.setUseSecure(this.debugProperties.getDebugPropertyAsBoolean("debug.aaxConfigUseSecure", true));
        RegistrationInfo registrationInfo = this.infoStore.getRegistrationInfo();
        DeviceInfo deviceInfo = this.infoStore.getDeviceInfo();
        webRequest.putUnencodedQueryParameter("appId", registrationInfo.getAppKey());
        webRequest.putUnencodedQueryParameter("dinfo", deviceInfo.getDInfoProperty().toString());
        webRequest.putUnencodedQueryParameter("sdkVer", Version.getSDKVersion());
        webRequest.putUnencodedQueryParameter("fp", Boolean.toString((boolean)this.isFirstParty));
        webRequest.putUnencodedQueryParameter("mkt", this.settings.getString(CONFIG_APP_DEFINED_MARKETPLACE, null));
        webRequest.putUnencodedQueryParameter("pfm", this.getPreferredMarketplace());
        boolean bl = this.settings.getBoolean("testingEnabled", false);
        this.setLastTestModeValue(bl);
        if (bl) {
            webRequest.putUnencodedQueryParameter("testMode", "true");
        }
        webRequest.setAdditionalQueryParamsString(this.debugProperties.getDebugPropertyAsString("debug.aaxConfigParams", null));
        if (!this.webRequestUserId.populateWebRequestUserId(webRequest)) {
            return null;
        }
        return webRequest;
    }

    /*
     * Unable to fully structure code
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    protected void fetchConfigurationOnBackgroundThread() {
        block14 : {
            this.logger.d("In configuration fetcher background thread.");
            if (!this.permissionChecker.hasInternetPermission(this.infoStore.getApplicationContext())) {
                this.logger.e("Network task cannot commence because the INTERNET permission is missing from the app's manifest.");
                this.onFetchFailure();
                return;
            }
            var1_1 = this.createWebRequest();
            if (var1_1 == null) {
                this.onFetchFailure();
                return;
            }
            var2_2 = var1_1.makeCall();
            var3_3 = var2_2.getResponseReader().readAsJSON();
            var10_4 = this.getConfigOptions();
            var11_5 = var10_4.length;
            var12_6 = 0;
lbl17: // 2 sources:
            do {
                block15 : {
                    block16 : {
                        if (var12_6 >= var11_5) ** GOTO lbl32
                        var13_7 = var10_4[var12_6];
                        if (!var3_3.isNull(var13_7.getResponseKey())) ** GOTO lbl30
                        if (var13_7.getAllowEmpty()) {
                            this.settings.removeWithNoFlush(ConfigOption.access$000(var13_7));
                        } else {
                            var14_8 = new StringBuilder();
                            var14_8.append("The configuration value for ");
                            var14_8.append(var13_7.getResponseKey());
                            var14_8.append(" must be present and not null.");
                            throw new Exception(var14_8.toString());
lbl30: // 1 sources:
                            this.writeSettingFromConfigOption(var13_7, var3_3);
                        }
                        break block14;
lbl32: // 1 sources:
                        if (!var3_3.isNull(ConfigOption.DEBUG_PROPERTIES.getResponseKey())) {
                            this.debugProperties.overwriteDebugProperties(var3_3.getJSONObject(ConfigOption.DEBUG_PROPERTIES.getResponseKey()));
                        } else {
                            this.settings.removeWithNoFlush(ConfigOption.access$000(ConfigOption.DEBUG_PROPERTIES));
                            this.debugProperties.clearDebugProperties();
                        }
                        if (var3_3.isNull("ttl")) break block15;
                        var18_9 = NumberUtils.convertToMillisecondsFromSeconds(var3_3.getInt("ttl"));
                        if (var18_9 <= 172800000L) break block16;
                        var18_9 = 172800000L;
                    }
                    this.settings.putLongWithNoFlush("config-ttl", var18_9);
                    this.settings.putLongWithNoFlush("config-lastFetchTime", this.systemTime.currentTimeMillis());
                    this.settings.putIntWithNoFlush("configVersion", 4);
                    this.settings.flush();
                    this.logger.d("Configuration fetched and saved.");
                    this.onFetchSuccess();
                    return;
                }
                try {
                    throw new Exception("The configuration value must be present and not null.");
                }
                catch (Exception var7_10) {
                    var8_11 = this.logger;
                    var9_12 = new Object[]{var7_10.getMessage()};
                    var8_11.e("Unexpected error during parsing: %s", var9_12);
                    this.onFetchFailure();
                    return;
                }
                catch (JSONException var4_13) {
                    var5_14 = this.logger;
                    var6_15 = new Object[]{var4_13.getMessage()};
                    var5_14.e("Unable to parse JSON response: %s", var6_15);
                    this.onFetchFailure();
                    return;
                }
                break;
            } while (true);
            catch (WebRequest.WebRequestException v0) {
                this.onFetchFailure();
                return;
            }
        }
        ++var12_6;
        ** while (true)
    }

    protected ConfigurationListener[] getAndClearListeners() {
        Configuration configuration = this;
        synchronized (configuration) {
            Object[] arrobject = new ConfigurationListener[this.listeners.size()];
            ConfigurationListener[] arrconfigurationListener = (ConfigurationListener[])this.listeners.toArray(arrobject);
            this.listeners.clear();
            return arrconfigurationListener;
        }
    }

    public boolean getBoolean(ConfigOption configOption) {
        return this.getBooleanWithDefault(configOption, false);
    }

    public boolean getBooleanWithDefault(ConfigOption configOption, boolean bl) {
        return this.settings.getBoolean(configOption.getSettingsName(), bl);
    }

    protected ConfigOption[] getConfigOptions() {
        return ConfigOption.configOptions;
    }

    public int getInt(ConfigOption configOption) {
        return this.getIntWithDefault(configOption, 0);
    }

    public int getIntWithDefault(ConfigOption configOption, int n) {
        return this.settings.getInt(configOption.getSettingsName(), n);
    }

    public JSONObject getJSONObject(ConfigOption configOption) {
        return this.getJSONObjectWithDefault(configOption, null);
    }

    public JSONObject getJSONObjectWithDefault(ConfigOption configOption, JSONObject jSONObject) {
        return this.settings.getJSONObject(configOption.getSettingsName(), jSONObject);
    }

    public long getLong(ConfigOption configOption) {
        return this.getLongWithDefault(configOption, 0L);
    }

    public long getLongWithDefault(ConfigOption configOption, long l2) {
        return this.settings.getLong(configOption.getSettingsName(), l2);
    }

    PreferredMarketplaceRetriever getPreferredMarketplaceRetriever() {
        return this.pfmRetriever;
    }

    public String getString(ConfigOption configOption) {
        return this.settings.getString(configOption.getSettingsName(), null);
    }

    public String getStringWithDefault(ConfigOption configOption, String string) {
        return this.settings.getString(configOption.getSettingsName(), string);
    }

    public boolean hasValue(ConfigOption configOption) {
        return true ^ StringUtils.isNullOrWhiteSpace(this.getString(configOption));
    }

    protected boolean isFetching() {
        return this.isFetching.get();
    }

    boolean isFirstParty() {
        return this.isFirstParty;
    }

    protected void onFetchFailure() {
        Configuration configuration = this;
        synchronized (configuration) {
            int n;
            ConfigurationListener[] arrconfigurationListener;
            this.metrics.getMetricsCollector().incrementMetric(Metrics.MetricType.AAX_CONFIG_DOWNLOAD_FAILED);
            try {
                this.setIsFetching(false);
                arrconfigurationListener = this.getAndClearListeners();
                n = arrconfigurationListener.length;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
            for (int i2 = 0; i2 < n; ++i2) {
                arrconfigurationListener[i2].onConfigurationFailure();
            }
            return;
        }
    }

    protected void onFetchSuccess() {
        Configuration configuration = this;
        synchronized (configuration) {
            int n;
            ConfigurationListener[] arrconfigurationListener;
            try {
                this.setIsFetching(false);
                arrconfigurationListener = this.getAndClearListeners();
                n = arrconfigurationListener.length;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
            for (int i2 = 0; i2 < n; ++i2) {
                arrconfigurationListener[i2].onConfigurationReady();
            }
            return;
        }
    }

    public void queueConfigurationListener(ConfigurationListener configurationListener) {
        Configuration configuration = this;
        synchronized (configuration) {
            this.queueConfigurationListener(configurationListener, true);
            return;
        }
    }

    public void queueConfigurationListener(ConfigurationListener configurationListener, boolean bl) {
        Configuration configuration = this;
        synchronized (configuration) {
            if (this.isFetching()) {
                this.listeners.add((Object)configurationListener);
            } else if (this.shouldFetch()) {
                this.listeners.add((Object)configurationListener);
                if (bl) {
                    this.logger.d("Starting configuration fetching...");
                    this.setIsFetching(true);
                    this.beginFetch();
                }
            } else {
                configurationListener.onConfigurationReady();
            }
            return;
        }
    }

    public void setAppDefinedMarketplace(String string) {
        this.appDefinedMarketplace = string;
        this.isAppDefinedMarketplaceSet = true;
    }

    protected void setIsFetching(boolean bl) {
        this.isFetching.set(bl);
    }

    public void setIsFirstParty(boolean bl) {
        this.isFirstParty = bl;
    }

    protected void setLastTestModeValue(boolean bl) {
        this.lastTestModeValue = bl;
    }

    public void setPreferredMarketplaceRetriever(PreferredMarketplaceRetriever preferredMarketplaceRetriever) {
        this.pfmRetriever = preferredMarketplaceRetriever;
    }

    protected boolean shouldFetch() {
        long l2;
        if (this.hasAppDefinedMarketplaceChanged()) {
            return true;
        }
        if (this.settings.getInt(CONFIG_VERSION_NAME, 0) != 4) {
            return true;
        }
        long l3 = this.settings.getLong(CONFIG_LASTFETCHTIME, 0L);
        if (l3 == 0L) {
            this.logger.d("No configuration found. A new configuration will be retrieved.");
            return true;
        }
        long l4 = this.systemTime.currentTimeMillis();
        if (l4 - l3 > (l2 = this.settings.getLong(CONFIG_TTL, 172800000L))) {
            this.logger.d("The configuration has expired. A new configuration will be retrieved.");
            return true;
        }
        if (this.settings.getWrittenLong("amzn-ad-iu-last-checkin", 0L) - l3 > 0L) {
            this.logger.d("A new user has been identified. A new configuration will be retrieved.");
            return true;
        }
        Boolean bl = this.lastTestModeValue;
        if (bl != null && bl.booleanValue() != this.settings.getBoolean("testingEnabled", false)) {
            this.logger.d("The testing mode has changed. A new configuration will be retrieved.");
            return true;
        }
        return this.debugProperties.getDebugPropertyAsBoolean("debug.shouldFetchConfig", false) != false;
    }

    public static class ConfigOption {
        public static final ConfigOption AAX_HOSTNAME = new ConfigOption("config-aaxHostname", String.class, "aaxHostname");
        public static final ConfigOption AD_PREF_URL;
        public static final ConfigOption AD_RESOURCE_PATH;
        public static final ConfigOption BASE_URL;
        public static final ConfigOption DEBUG_PROPERTIES;
        public static final ConfigOption IDENTIFY_USER_INTERVAL;
        public static final ConfigOption IDENTIFY_USER_SESSION_INTERVAL;
        public static final ConfigOption MADS_HOSTNAME;
        public static final ConfigOption SEND_GEO;
        public static final ConfigOption SIS_DOMAIN;
        public static final ConfigOption SIS_URL;
        public static final ConfigOption TRUNCATE_LAT_LON;
        public static final ConfigOption VIEWABLE_INTERVAL;
        public static final ConfigOption VIEWABLE_JAVASCRIPT_URL;
        public static final ConfigOption VIEWABLE_JS_VERSION_CONFIG;
        public static final ConfigOption WHITELISTED_CUSTOMER;
        public static final ConfigOption[] configOptions;
        private final boolean allowEmpty;
        private final Class<?> dataType;
        private final String responseKey;
        private final String settingsName;

        static {
            AD_RESOURCE_PATH = new ConfigOption("config-adResourcePath", String.class, "adResourcePath");
            SIS_URL = new ConfigOption("config-sisURL", String.class, "sisURL");
            AD_PREF_URL = new ConfigOption("config-adPrefURL", String.class, "adPrefURL");
            MADS_HOSTNAME = new ConfigOption("config-madsHostname", String.class, "madsHostname", true);
            SIS_DOMAIN = new ConfigOption("config-sisDomain", String.class, "sisDomain");
            SEND_GEO = new ConfigOption("config-sendGeo", Boolean.class, "sendGeo");
            TRUNCATE_LAT_LON = new ConfigOption("config-truncateLatLon", Boolean.class, "truncateLatLon");
            WHITELISTED_CUSTOMER = new ConfigOption("config-whitelistedCustomer", Boolean.class, "whitelistedCustomer");
            IDENTIFY_USER_INTERVAL = new ConfigOption("config-identifyUserInterval", Long.class, "identifyUserInterval");
            IDENTIFY_USER_SESSION_INTERVAL = new ConfigOption("config-identifyUserSessionIdInterval", Long.class, "identifyUserSessionIdInterval", true);
            VIEWABLE_JAVASCRIPT_URL = new ConfigOption("config-viewableJavascriptCDNURL", String.class, "viewableJavascriptCDNURL");
            VIEWABLE_JS_VERSION_CONFIG = new ConfigOption("config-viewableJSVersionConfig", Integer.class, "viewableJSVersion");
            VIEWABLE_INTERVAL = new ConfigOption("config-viewableInterval", Long.class, "viewableInterval", true);
            DEBUG_PROPERTIES = new ConfigOption("config-debugProperties", JSONObject.class, "debugProperties", true);
            BASE_URL = new ConfigOption("config-baseURL", String.class, "baseURL", true);
            ConfigOption[] arrconfigOption = new ConfigOption[]{AAX_HOSTNAME, AD_RESOURCE_PATH, SIS_URL, AD_PREF_URL, MADS_HOSTNAME, SIS_DOMAIN, SEND_GEO, TRUNCATE_LAT_LON, WHITELISTED_CUSTOMER, IDENTIFY_USER_INTERVAL, IDENTIFY_USER_SESSION_INTERVAL, VIEWABLE_JAVASCRIPT_URL, VIEWABLE_JS_VERSION_CONFIG, DEBUG_PROPERTIES, VIEWABLE_INTERVAL, BASE_URL};
            configOptions = arrconfigOption;
        }

        protected ConfigOption(String string, Class<?> class_, String string2) {
            this(string, class_, string2, false);
        }

        protected ConfigOption(String string, Class<?> class_, String string2, boolean bl) {
            this.settingsName = string;
            this.responseKey = string2;
            this.dataType = class_;
            this.allowEmpty = bl;
        }

        private String getSettingsName() {
            return this.settingsName;
        }

        boolean getAllowEmpty() {
            return this.allowEmpty;
        }

        Class<?> getDataType() {
            return this.dataType;
        }

        String getResponseKey() {
            return this.responseKey;
        }
    }

    static interface ConfigurationListener {
        public void onConfigurationFailure();

        public void onConfigurationReady();
    }

}

