/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.aerserv.sdk.AerServConfig$1
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Deprecated
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Map
 */
package com.aerserv.sdk;

import android.content.Context;
import com.aerserv.sdk.AerServConfig;
import com.aerserv.sdk.AerServEventListener;
import com.aerserv.sdk.utils.AerServLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AerServConfig {
    private static String baseUrl = "https://ads.aerserv.com/as/sdk/v3/";
    private static boolean debug = false;
    private static String platformId = "0";
    public static final String productionBaseUrl = "https://ads.aerserv.com/as/sdk/v3/";
    private static final String stagingBaseUrl = "https://staging.ads.aerserv.com/as/sdk/v3/";
    private static boolean testMode;
    private static boolean verbose;
    private boolean backButton = false;
    private int backButtonTimeout = 0;
    private Context context;
    private AerServEventListener eventListener = new 1(this);
    private List<String> keywords = new ArrayList();
    private String plc;
    private boolean precache = true;
    private boolean preload = false;
    private Map<String, String> pubKeys = new HashMap();
    private int refreshInterval = 30;
    private Integer timeout = null;
    private Boolean useHeaderBidding = false;
    private String userId = "";

    public AerServConfig(Context context, String string) {
        if (context == null) {
            AerServLog.w(this.getClass().getSimpleName(), "AerServConfig cannot be constructed with a null context");
        }
        if (string == null || string.equals((Object)"") || !string.matches("[0-9]+")) {
            String string2 = this.getClass().getSimpleName();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("AerServConfig cannot be constructed with bad PLC \"");
            stringBuilder.append(string);
            stringBuilder.append("\"");
            AerServLog.w(string2, stringBuilder.toString());
        }
        this.context = context;
        this.plc = string;
    }

    public static String getBaseUrl() {
        return baseUrl;
    }

    public static String getPlatformId() {
        return platformId;
    }

    public static boolean isDebug() {
        return testMode || debug;
        {
        }
    }

    public static boolean isTestMode() {
        return testMode;
    }

    public static boolean isVerbose() {
        return testMode || verbose;
        {
        }
    }

    public static void setBaseUrlTo(String string) {
        baseUrl = string;
    }

    public static void setPlatformId(String string) {
        platformId = string;
    }

    public static void setTestMode(boolean bl) {
        testMode = bl;
    }

    public static void setToProductionUrl() {
        baseUrl = productionBaseUrl;
    }

    public static void setToStagingUrl() {
        baseUrl = stagingBaseUrl;
    }

    public AerServConfig enableBackButton(boolean bl) {
        this.backButton = bl;
        return this;
    }

    public int getBackButtonTimeout() {
        return this.backButtonTimeout;
    }

    public Context getContext() {
        return this.context;
    }

    public AerServEventListener getEventListener() {
        return this.eventListener;
    }

    public List<String> getKeywords() {
        return this.keywords;
    }

    public String getPlc() {
        return this.plc;
    }

    public Map<String, String> getPubKeys() {
        return this.pubKeys;
    }

    public int getRefreshInterval() {
        return this.refreshInterval;
    }

    public Integer getTimeout() {
        return this.timeout;
    }

    public boolean getUseHeaderBidding() {
        return this.useHeaderBidding;
    }

    public String getUserId() {
        return this.userId;
    }

    public boolean isBackButtonEnabled() {
        return this.backButton;
    }

    public boolean isPrecache() {
        return this.precache;
    }

    public boolean isPreload() {
        return Boolean.TRUE.equals((Object)this.preload) || Boolean.TRUE.equals((Object)this.useHeaderBidding);
        {
        }
    }

    public AerServConfig setBackButtonTimeout(int n2) {
        this.backButtonTimeout = n2;
        return this;
    }

    public AerServConfig setBaseUrl(String string) {
        baseUrl = string;
        return this;
    }

    public AerServConfig setDebug(boolean bl) {
        debug = bl;
        return this;
    }

    public AerServConfig setEventListener(AerServEventListener aerServEventListener) {
        this.eventListener = aerServEventListener;
        return this;
    }

    public AerServConfig setKeywords(List<String> list) {
        if (list != null) {
            this.keywords = list;
        }
        return this;
    }

    public AerServConfig setPrecache(boolean bl) {
        this.precache = bl;
        return this;
    }

    public AerServConfig setPreload(boolean bl) {
        this.preload = bl;
        return this;
    }

    public AerServConfig setProductionBaseUrl() {
        baseUrl = productionBaseUrl;
        return this;
    }

    public AerServConfig setPubKeys(Map<String, String> map) {
        if (map != null) {
            this.pubKeys = map;
        }
        return this;
    }

    public AerServConfig setRefreshInterval(int n2) {
        if (n2 == 0 || n2 >= 10) {
            this.refreshInterval = n2;
        }
        return this;
    }

    public AerServConfig setStagingBaseUrl() {
        baseUrl = stagingBaseUrl;
        return this;
    }

    @Deprecated
    public AerServConfig setTimeout(int n2) {
        this.timeout = n2;
        return this;
    }

    public AerServConfig setUseHeaderBidding(boolean bl) {
        this.useHeaderBidding = bl;
        return this;
    }

    public AerServConfig setUserId(String string) {
        this.userId = string;
        return this;
    }

    public AerServConfig setVerbose(boolean bl) {
        verbose = bl;
        return this;
    }

    public String toString() {
        Object[] arrobject = new Object[]{this.context.toString(), this.plc, debug, this.preload, this.timeout};
        return String.format((String)"Context: %s, PLC: %s, Debug: %b, Preload: %b, Timeout: %d", (Object[])arrobject);
    }
}

