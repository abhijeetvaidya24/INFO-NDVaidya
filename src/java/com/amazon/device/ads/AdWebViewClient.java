/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.net.Uri
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  com.amazon.device.ads.AdWebViewClient$AmazonMobileExecutor
 *  com.amazon.device.ads.AdWebViewClient$DefaultExecutor
 *  com.amazon.device.ads.MobileAdsLogger
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.Set
 *  java.util.concurrent.CopyOnWriteArrayList
 */
package com.amazon.device.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.amazon.device.ads.AdControlAccessor;
import com.amazon.device.ads.AdSDKBridge;
import com.amazon.device.ads.AdSDKBridgeFactory;
import com.amazon.device.ads.AdSDKBridgeList;
import com.amazon.device.ads.AdWebViewClient;
import com.amazon.device.ads.AmazonDeviceLauncher;
import com.amazon.device.ads.AndroidBuildInfo;
import com.amazon.device.ads.AndroidTargetUtils;
import com.amazon.device.ads.BridgeSelector;
import com.amazon.device.ads.MobileAdsLogger;
import com.amazon.device.ads.MobileAdsLoggerFactory;
import com.amazon.device.ads.ThreadUtils;
import com.amazon.device.ads.WebUtils2;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/*
 * Exception performing whole class analysis.
 */
class AdWebViewClient
extends WebViewClient {
    protected static final String AAX_REDIRECT_BETA = "aax-beta.integ.amazon.com";
    protected static final String AAX_REDIRECT_GAMMA = "aax-us-east.amazon-adsystem.com";
    protected static final String AAX_REDIRECT_PROD = "aax-us-east.amazon-adsystem.com";
    public static final String AMAZON_MOBILE = "amazonmobile";
    protected static final String CORNERSTONE_BEST_ENDPOINT_BETA = "d16g-cornerstone-bes.integ.amazon.com";
    protected static final String CORNERSTONE_BEST_ENDPOINT_PROD = "pda-bes.amazon.com";
    public static final String GEO = "geo";
    public static final String GOOGLE_STREETVIEW = "google.streetview";
    private static final String LOGTAG = "AdWebViewClient";
    public static final String MAILTO = "mailto";
    public static final String SMS = "sms";
    public static final String TELEPHONE = "tel";
    public static final String VOICEMAIL = "voicemail";
    protected static final HashSet<String> intentSchemes;
    protected static Set<String> redirectHosts;
    private final AdControlAccessor adControlAccessor;
    private final AndroidBuildInfo androidBuildInfo;
    private final AdSDKBridgeList bridgeList;
    private final Context context;
    private AdWebViewClientListener listener;
    private final MobileAdsLogger logger;
    private final MobileAdsLoggerFactory loggerFactory;
    private CopyOnWriteArrayList<String> resourceList;
    private final HashMap<String, UrlExecutor> urlExecutors;
    private final WebUtils2 webUtils;

    static {
        intentSchemes = new HashSet();
        intentSchemes.add((Object)TELEPHONE);
        intentSchemes.add((Object)VOICEMAIL);
        intentSchemes.add((Object)SMS);
        intentSchemes.add((Object)MAILTO);
        intentSchemes.add((Object)GEO);
        intentSchemes.add((Object)GOOGLE_STREETVIEW);
        redirectHosts = new HashSet();
        redirectHosts.add((Object)"aax-us-east.amazon-adsystem.com");
        redirectHosts.add((Object)"aax-us-east.amazon-adsystem.com");
        redirectHosts.add((Object)AAX_REDIRECT_BETA);
        redirectHosts.add((Object)CORNERSTONE_BEST_ENDPOINT_PROD);
        redirectHosts.add((Object)CORNERSTONE_BEST_ENDPOINT_BETA);
    }

    public AdWebViewClient(Context context, AdSDKBridgeList adSDKBridgeList, AdControlAccessor adControlAccessor, WebUtils2 webUtils2, MobileAdsLoggerFactory mobileAdsLoggerFactory, AndroidBuildInfo androidBuildInfo) {
        this.resourceList = new CopyOnWriteArrayList();
        this.context = context;
        this.urlExecutors = new HashMap();
        this.bridgeList = adSDKBridgeList;
        this.adControlAccessor = adControlAccessor;
        this.webUtils = webUtils2;
        this.loggerFactory = mobileAdsLoggerFactory;
        this.logger = this.loggerFactory.createMobileAdsLogger(LOGTAG);
        this.androidBuildInfo = androidBuildInfo;
        this.setupUrlExecutors();
    }

    static /* synthetic */ String access$100() {
        return LOGTAG;
    }

    private boolean checkResources() {
        Iterator iterator = this.resourceList.iterator();
        boolean bl = false;
        while (iterator.hasNext()) {
            String string = (String)iterator.next();
            Set<AdSDKBridgeFactory> set = BridgeSelector.getInstance().getBridgeFactoriesForResourceLoad(string);
            if (set.size() <= 0) continue;
            Iterator iterator2 = set.iterator();
            while (iterator2.hasNext()) {
                AdSDKBridge adSDKBridge = ((AdSDKBridgeFactory)iterator2.next()).createAdSDKBridge(this.adControlAccessor);
                if (this.bridgeList.contains(adSDKBridge)) continue;
                bl = true;
                this.bridgeList.addBridge(adSDKBridge);
            }
        }
        if (bl) {
            ThreadUtils.executeOnMainThread(new Runnable(){

                public void run() {
                    AdWebViewClient.this.adControlAccessor.reload();
                }
            });
        }
        return bl;
    }

    private void setupUrlExecutors() {
        this.urlExecutors.put((Object)AMAZON_MOBILE, (Object)new /* Unavailable Anonymous Inner Class!! */);
        DefaultExecutor defaultExecutor = new /* Unavailable Anonymous Inner Class!! */;
        Iterator iterator = intentSchemes.iterator();
        while (iterator.hasNext()) {
            this.putUrlExecutor((String)iterator.next(), (UrlExecutor)defaultExecutor);
        }
    }

    protected String getScheme(String string) {
        return this.webUtils.getScheme(string);
    }

    protected boolean interpretScheme(String string, String string2) {
        if (string2 != null) {
            if (string2.equals((Object)"about") && string.equalsIgnoreCase("about:blank")) {
                return false;
            }
            if (this.urlExecutors.containsKey((Object)string2)) {
                return ((UrlExecutor)this.urlExecutors.get((Object)string2)).execute(string);
            }
            this.logger.d("Scheme %s unrecognized. Launching as intent.", new Object[]{string2});
            return this.webUtils.launchActivityForIntentLink(string, this.context);
        }
        return false;
    }

    boolean isHoneycombVersion() {
        return AndroidTargetUtils.isBetweenAndroidAPIs(this.androidBuildInfo, 11, 13);
    }

    public void onLoadResource(WebView webView, String string) {
        this.resourceList.add((Object)string);
        this.logger.d("Loading resource: %s", new Object[]{string});
        this.listener.onLoadResource(webView, string);
    }

    public void onPageFinished(WebView webView, String string) {
        this.logger.d("Page Finished %s", new Object[]{string});
        if (this.checkResources()) {
            return;
        }
        AdWebViewClientListener adWebViewClientListener = this.listener;
        if (adWebViewClientListener == null) {
            this.logger.w("Call to onPageFinished() ignored because listener is null.");
            return;
        }
        adWebViewClientListener.onPageFinished(webView, string);
    }

    public void onPageStarted(WebView webView, String string, Bitmap bitmap) {
        super.onPageStarted(webView, string, bitmap);
        this.listener.onPageStarted(webView, string);
    }

    public void onReceivedError(WebView webView, int n, String string, String string2) {
        this.logger.e("Error: %s", new Object[]{string});
        super.onReceivedError(webView, n, string, string2);
        this.listener.onReceivedError(webView, n, string, string2);
    }

    public boolean openUrl(String string) {
        Uri uri = Uri.parse((String)string);
        boolean bl = !redirectHosts.contains((Object)uri.getHost()) || this.isHoneycombVersion();
        if (this.interpretScheme(string, this.getScheme(string))) {
            return true;
        }
        return bl;
    }

    public void putUrlExecutor(String string, UrlExecutor urlExecutor) {
        this.urlExecutors.put((Object)string, (Object)urlExecutor);
    }

    public void setListener(AdWebViewClientListener adWebViewClientListener) {
        this.listener = adWebViewClientListener;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String string) {
        return this.openUrl(string);
    }

    static interface AdWebViewClientListener {
        public void onLoadResource(WebView var1, String var2);

        public void onPageFinished(WebView var1, String var2);

        public void onPageStarted(WebView var1, String var2);

        public void onReceivedError(WebView var1, int var2, String var3, String var4);
    }

    static interface UrlExecutor {
        public boolean execute(String var1);
    }

}

