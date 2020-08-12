/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.amazon.device.ads.MobileAdsLogger
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
package com.amazon.device.ads;

import com.amazon.device.ads.AdControlAccessor;
import com.amazon.device.ads.AdWebViewClient;
import com.amazon.device.ads.DeviceInfo;
import com.amazon.device.ads.MobileAdsLogger;
import com.amazon.device.ads.MobileAdsLoggerFactory;
import com.amazon.device.ads.PreloadCallback;
import com.amazon.device.ads.ResponseReader;
import com.amazon.device.ads.ThreadUtils;
import com.amazon.device.ads.WebRequest;
import com.amazon.device.ads.WebUtils2;

class AdUrlLoader {
    private static final String LOGTAG = "AdUrlLoader";
    private final AdControlAccessor adControlAccessor;
    private final AdWebViewClient adWebViewClient;
    private final DeviceInfo deviceInfo;
    private final MobileAdsLogger logger;
    private final ThreadUtils.ThreadRunner threadRunner;
    private final WebRequest.WebRequestFactory webRequestFactory;
    private final WebUtils2 webUtils;

    public AdUrlLoader(ThreadUtils.ThreadRunner threadRunner, AdWebViewClient adWebViewClient, WebRequest.WebRequestFactory webRequestFactory, AdControlAccessor adControlAccessor, WebUtils2 webUtils2, MobileAdsLoggerFactory mobileAdsLoggerFactory, DeviceInfo deviceInfo) {
        this.threadRunner = threadRunner;
        this.adWebViewClient = adWebViewClient;
        this.webRequestFactory = webRequestFactory;
        this.adControlAccessor = adControlAccessor;
        this.webUtils = webUtils2;
        this.logger = mobileAdsLoggerFactory.createMobileAdsLogger(LOGTAG);
        this.deviceInfo = deviceInfo;
    }

    private void loadUrlInThread(final String string, final boolean bl, final PreloadCallback preloadCallback) {
        WebRequest.WebResponse webResponse;
        WebRequest webRequest = this.webRequestFactory.createWebRequest();
        webRequest.setExternalLogTag(LOGTAG);
        webRequest.enableLogUrl(true);
        webRequest.setUrlString(string);
        webRequest.putHeader("User-Agent", this.deviceInfo.getUserAgentString());
        try {
            webResponse = webRequest.makeCall();
        }
        catch (WebRequest.WebRequestException webRequestException) {
            MobileAdsLogger mobileAdsLogger = this.logger;
            Object[] arrobject = new Object[]{string, webRequestException.getMessage()};
            mobileAdsLogger.e("Could not load URL (%s) into AdContainer: %s", arrobject);
            webResponse = null;
        }
        if (webResponse != null) {
            final String string2 = webResponse.getResponseReader().readAsString();
            if (string2 != null) {
                ThreadUtils.ThreadRunner threadRunner = this.threadRunner;
                Runnable runnable = new Runnable(){

                    public void run() {
                        AdUrlLoader.this.adControlAccessor.loadHtml(string, string2, bl, preloadCallback);
                    }
                };
                threadRunner.execute(runnable, ThreadUtils.ExecutionStyle.RUN_ASAP, ThreadUtils.ExecutionThread.MAIN_THREAD);
                return;
            }
            this.logger.e("Could not load URL (%s) into AdContainer.", new Object[]{string});
        }
    }

    public AdWebViewClient getAdWebViewClient() {
        return this.adWebViewClient;
    }

    public void loadUrl(final String string, final boolean bl, final PreloadCallback preloadCallback) {
        String string2 = this.webUtils.getScheme(string);
        if (!string2.equals((Object)"http") && !string2.equals((Object)"https")) {
            this.openUrl(string);
            return;
        }
        this.threadRunner.execute(new Runnable(){

            public void run() {
                AdUrlLoader.this.loadUrlInThread(string, bl, preloadCallback);
            }
        }, ThreadUtils.ExecutionStyle.RUN_ASAP, ThreadUtils.ExecutionThread.BACKGROUND_THREAD);
    }

    public void openUrl(String string) {
        this.adWebViewClient.openUrl(string);
    }

    public void putUrlExecutorInAdWebViewClient(String string, AdWebViewClient.UrlExecutor urlExecutor) {
        this.adWebViewClient.putUrlExecutor(string, urlExecutor);
    }

    public void setAdWebViewClientListener(AdWebViewClient.AdWebViewClientListener adWebViewClientListener) {
        this.adWebViewClient.setListener(adWebViewClientListener);
    }

}

