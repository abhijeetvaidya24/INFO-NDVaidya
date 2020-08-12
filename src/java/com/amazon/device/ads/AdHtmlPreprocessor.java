/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.amazon.device.ads.MobileAdsLogger
 *  java.lang.CharSequence
 *  java.lang.Float
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Iterator
 *  java.util.Set
 */
package com.amazon.device.ads;

import com.amazon.device.ads.AdControlAccessor;
import com.amazon.device.ads.AdSDKBridge;
import com.amazon.device.ads.AdSDKBridgeFactory;
import com.amazon.device.ads.AdSDKBridgeList;
import com.amazon.device.ads.AdUtils2;
import com.amazon.device.ads.BridgeSelector;
import com.amazon.device.ads.JavascriptInteractor;
import com.amazon.device.ads.MobileAdsLogger;
import com.amazon.device.ads.MobileAdsLoggerFactory;
import com.amazon.device.ads.SDKEventListener;
import com.amazon.device.ads.StringUtils;
import java.util.Iterator;
import java.util.Set;

class AdHtmlPreprocessor {
    private static final String LOGTAG = "AdHtmlPreprocessor";
    private final AdControlAccessor adControlAccessor;
    private final AdUtils2 adUtils;
    private final AdSDKBridgeList bridgeList;
    private final BridgeSelector bridgeSelector;
    private final MobileAdsLogger logger;

    public AdHtmlPreprocessor(BridgeSelector bridgeSelector, AdSDKBridgeList adSDKBridgeList, AdControlAccessor adControlAccessor, MobileAdsLoggerFactory mobileAdsLoggerFactory, AdUtils2 adUtils2) {
        this.bridgeSelector = bridgeSelector;
        this.bridgeList = adSDKBridgeList;
        this.adControlAccessor = adControlAccessor;
        this.logger = mobileAdsLoggerFactory.createMobileAdsLogger(LOGTAG);
        this.adUtils = adUtils2;
    }

    private void addAdSDKBridge(AdSDKBridge adSDKBridge) {
        this.bridgeList.addBridge(adSDKBridge);
    }

    private String addHeadData(String string, String string2) {
        String string3 = StringUtils.getFirstMatch("<[Hh][Ee][Aa][Dd](\\s*>|\\s[^>]*>)", string);
        boolean bl = StringUtils.containsRegEx("<[Mm][Ee][Tt][Aa](\\s[^>]*\\s|\\s)[Nn][Aa][Mm][Ee]\\s*=\\s*[\"'][Vv][Ii][Ee][Ww][Pp][Oo][Rr][Tt][\"']", string);
        String string4 = "";
        if (!bl) {
            if (this.adControlAccessor.getScalingMultiplier() >= 0.0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string4);
                stringBuilder.append("<meta name=\"viewport\" content=\"width=");
                stringBuilder.append(this.adControlAccessor.getWindowWidth());
                stringBuilder.append(", height=");
                stringBuilder.append(this.adControlAccessor.getWindowHeight());
                stringBuilder.append(", initial-scale=");
                stringBuilder.append(this.adUtils.getViewportInitialScale(this.adControlAccessor.getScalingMultiplier()));
                stringBuilder.append(", minimum-scale=");
                stringBuilder.append(this.adControlAccessor.getScalingMultiplier());
                stringBuilder.append(", maximum-scale=");
                stringBuilder.append(this.adControlAccessor.getScalingMultiplier());
                stringBuilder.append("\"/>");
                string4 = stringBuilder.toString();
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string4);
                stringBuilder.append("<meta name=\"viewport\" content=\"width=device-width, height=device-height, user-scalable=no, initial-scale=1.0\"/>");
                string4 = stringBuilder.toString();
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string4);
        stringBuilder.append("<style>html,body{margin:0;padding:0;height:100%;border:none;}</style>");
        String string5 = stringBuilder.toString();
        if (string2.length() > 0) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(string5);
            stringBuilder2.append("<script type='text/javascript'>");
            stringBuilder2.append(string2);
            stringBuilder2.append("</script>");
            string5 = stringBuilder2.toString();
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(string3);
        stringBuilder3.append(string5);
        return string.replace((CharSequence)string3, (CharSequence)stringBuilder3.toString());
    }

    private String ensureHtmlTags(String string) {
        boolean bl = StringUtils.containsRegEx("\\A\\s*<![Dd][Oo][Cc][Tt][Yy][Pp][Ee]\\s+[Hh][Tt][Mm][Ll][\\s>]", string);
        String string2 = "";
        String string3 = !bl ? "<!DOCTYPE html>" : string2;
        if (!StringUtils.containsRegEx("<[Hh][Tt][Mm][Ll][\\s>]", string)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string3);
            stringBuilder.append("<html>");
            string3 = stringBuilder.toString();
            string2 = "</html>";
        }
        if (!StringUtils.containsRegEx("<[Hh][Ee][Aa][Dd][\\s>]", string)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string3);
            stringBuilder.append("<head></head>");
            string3 = stringBuilder.toString();
        }
        if (!StringUtils.containsRegEx("<[Bb][Oo][Dd][Yy][\\s>]", string)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string3);
            stringBuilder.append("<body>");
            string3 = stringBuilder.toString();
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("</body>");
            stringBuilder2.append(string2);
            string2 = stringBuilder2.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string3);
        stringBuilder.append(string);
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public String preprocessHtml(String string, boolean bl) {
        Iterator iterator = this.bridgeSelector.getBridgeFactories(string).iterator();
        while (iterator.hasNext()) {
            this.addAdSDKBridge(((AdSDKBridgeFactory)iterator.next()).createAdSDKBridge(this.adControlAccessor));
        }
        MobileAdsLogger mobileAdsLogger = this.logger;
        Object[] arrobject = new Object[]{Float.valueOf((float)this.adUtils.getScalingFactorAsFloat()), this.adControlAccessor.getWindowWidth(), this.adControlAccessor.getWindowHeight(), (int)((float)this.adControlAccessor.getAdWidth() * this.adUtils.getScalingFactorAsFloat()), (int)((float)this.adControlAccessor.getAdHeight() * this.adUtils.getScalingFactorAsFloat()), this.adControlAccessor.getScalingMultiplier()};
        mobileAdsLogger.d("Scaling Params: scalingDensity: %f, windowWidth: %d, windowHeight: %d, adWidth: %d, adHeight: %d, scale: %f", arrobject);
        Iterator<AdSDKBridge> iterator2 = this.bridgeList.iterator();
        String string2 = "";
        while (iterator2.hasNext()) {
            AdSDKBridge adSDKBridge = (AdSDKBridge)iterator2.next();
            if (adSDKBridge.getSDKEventListener() != null) {
                this.adControlAccessor.addSDKEventListener(adSDKBridge.getSDKEventListener());
            }
            if (adSDKBridge.getJavascript() != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string2);
                stringBuilder.append(adSDKBridge.getJavascript());
                string2 = stringBuilder.toString();
            }
            if (!adSDKBridge.hasNativeExecution()) continue;
            this.adControlAccessor.addJavascriptInterface(adSDKBridge.getJavascriptInteractorExecutor(), bl, adSDKBridge.getName());
        }
        return this.addHeadData(this.ensureHtmlTags(string), string2);
    }
}

