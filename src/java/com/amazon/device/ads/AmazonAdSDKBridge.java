/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Locale
 *  org.json.JSONObject
 */
package com.amazon.device.ads;

import com.amazon.device.ads.AdControlAccessor;
import com.amazon.device.ads.AdSDKBridge;
import com.amazon.device.ads.JSONUtils;
import com.amazon.device.ads.JavascriptInteractor;
import com.amazon.device.ads.MobileAdsLogger;
import com.amazon.device.ads.MobileAdsLoggerFactory;
import com.amazon.device.ads.SDKEvent;
import com.amazon.device.ads.SDKEventListener;
import com.amazon.device.ads.Version;
import com.amazon.device.ads.WebUtils2;
import java.util.Locale;
import org.json.JSONObject;

class AmazonAdSDKBridge
implements AdSDKBridge {
    private static final String BRIDGE_NAME = "amazonObject";
    private static final String ERROR_EVENT_FORMAT = "amazonBridge.error('%s', '%s');";
    private static final String JAVASCRIPT;
    private static final String LOGTAG = "AmazonAdSDKBridge";
    private final AdControlAccessor adControlAccessor;
    private final JavascriptInteractor javascriptInteractor;
    private final AmazonAdSDKEventListener listener = new AmazonAdSDKEventListener(this);
    private final MobileAdsLogger logger;
    private final WebUtils2 webUtils;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(function (window, console){\n    var version = '1.0',\n    debug = function(msg) {\n        console.log(\"Amazon Javascript log: \" + msg);\n    },\n    is_array = function (obj) {\n        return Object.prototype.toString.call(obj) === '[object Array]';\n    },\n    forEach = function (array, fn) {\n        var i;\n        for (i = 0; i < array.length; i++) {\n            if (i in array) {\n                fn.call(null, array[i], i);\n            }\n        }\n    },\n    listeners = [],\n    events = {\n        backButton: 'backButton'\n    },\n    invokeListeners = function(event, args) {\n        var eventListeners = listeners[event] || [];\n        // fire all the listeners\n        forEach(eventListeners, function(listener){\n            try {\n                listener.apply(null, args);\n            }catch(e){\n                debug(\"Error executing \" + event + \" listener\");\n                debug(e);\n            }\n        });\n    },\n    backButtonEvent = function() {\n        invokeListeners(\"backButton\");\n    };\n    window.amazonBridge = {\n        backButton : backButtonEvent\n    };\n    window.amazon = {\n        // Command Flow\n        addEventListener : function(event, listener){\n            var eventListeners = listeners[event] || [],\n            alreadyRegistered = false;\n            \n            //verify the event is one that will actually occur\n            if (!events.hasOwnProperty(event)){\n                return;\n            }\n            \n            //register first set of listeners for this event\n            if (!is_array(listeners[event])) {\n                listeners[event] = eventListeners;\n            }\n            \n            forEach(eventListeners, function(l){ \n                // Listener already registered, so no need to add it.\n                    if (listener === l){\n                        alreadyRegistered = true;\n                    }\n                }\n            );\n            if (!alreadyRegistered){\n                listeners[event].push(listener);\n            }\n        },\n        removeEventListener : function(event, listener){\n            if (listeners.hasOwnProperty(event)) {\n                var eventListeners = listeners[event];\n                if (eventListeners) {\n                    var idx = eventListeners.indexOf(listener);\n                    if (idx !== -1) {\n                        eventListeners.splice(idx, 1);\n                    }\n                }\n            }\n        },\n        enableCloseButton: function(enable){\n            amazonObject.");
        stringBuilder.append(JavascriptInteractor.getExecutorMethodName());
        stringBuilder.append("(\"EnableCloseButton\", JSON.stringify({\"enable\": enable}));\n");
        stringBuilder.append("        },\n");
        stringBuilder.append("        overrideBackButton: function(override){\n");
        stringBuilder.append("            amazonObject.");
        stringBuilder.append(JavascriptInteractor.getExecutorMethodName());
        stringBuilder.append("(\"OverrideBackButton\", JSON.stringify({\"override\": override}));\n");
        stringBuilder.append("        },\n");
        stringBuilder.append("        openInExternalBrowser: function(url){\n");
        stringBuilder.append("            amazonObject.");
        stringBuilder.append(JavascriptInteractor.getExecutorMethodName());
        stringBuilder.append("(\"OpenInExternalBrowser\", JSON.stringify({\"url\": url}));\n");
        stringBuilder.append("        },\n");
        stringBuilder.append("        getSDKVersion: function(){\n");
        stringBuilder.append("            var json = JSON.parse(amazonObject.");
        stringBuilder.append(JavascriptInteractor.getExecutorMethodName());
        stringBuilder.append("(\"GetSDKVersion\", null));\n");
        stringBuilder.append("            return json.sdkVersion;\n");
        stringBuilder.append("        },\n");
        stringBuilder.append("        getVersion: function(){\n");
        stringBuilder.append("            return version;\n");
        stringBuilder.append("        },\n");
        stringBuilder.append("    };\n");
        stringBuilder.append("})(window, console);");
        JAVASCRIPT = stringBuilder.toString();
    }

    public AmazonAdSDKBridge(AdControlAccessor adControlAccessor, JavascriptInteractor javascriptInteractor) {
        this(adControlAccessor, javascriptInteractor, new WebUtils2(), new MobileAdsLoggerFactory());
    }

    AmazonAdSDKBridge(AdControlAccessor adControlAccessor, JavascriptInteractor javascriptInteractor, WebUtils2 webUtils2, MobileAdsLoggerFactory mobileAdsLoggerFactory) {
        this.adControlAccessor = adControlAccessor;
        this.javascriptInteractor = javascriptInteractor;
        this.webUtils = webUtils2;
        this.logger = mobileAdsLoggerFactory.createMobileAdsLogger(LOGTAG);
        this.javascriptInteractor.addMethodExecutor(new EnableCloseButtonJSIF(this));
        this.javascriptInteractor.addMethodExecutor(new OverrideBackButtonJSIF(this));
        this.javascriptInteractor.addMethodExecutor(new OpenInExternalBrowserJSIF(this));
        this.javascriptInteractor.addMethodExecutor(new SDKVersionJSIF(this));
    }

    private boolean canHaveCloseButton() {
        return this.adControlAccessor.isModal();
    }

    private void enableCloseButton(boolean bl) {
        if (!this.canHaveCloseButton()) {
            return;
        }
        if (bl) {
            this.adControlAccessor.enableCloseButton(true);
            return;
        }
        this.adControlAccessor.removeCloseButton();
    }

    private void fireErrorEvent(String string, String string2) {
        this.adControlAccessor.injectJavascript(String.format((Locale)Locale.US, (String)ERROR_EVENT_FORMAT, (Object[])new Object[]{string, string2}));
    }

    private String getSDKVersion() {
        return Version.getRawSDKVersion();
    }

    private void onBackButton() {
        this.adControlAccessor.injectJavascript("amazonBridge.backButton();");
    }

    private void openInExternalBrowser(String string) {
        if (!this.adControlAccessor.isVisible()) {
            this.fireErrorEvent("Unable to open a URL while the ad is not visible", "open");
            return;
        }
        MobileAdsLogger mobileAdsLogger = this.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Opening URL ");
        stringBuilder.append(string);
        mobileAdsLogger.d(stringBuilder.toString());
        if (this.webUtils.isUrlValid(string)) {
            this.adControlAccessor.openUrl(string);
            return;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("URL ");
        stringBuilder2.append(string);
        stringBuilder2.append(" is not a valid URL");
        String string2 = stringBuilder2.toString();
        this.logger.d(string2);
        this.fireErrorEvent(string2, "open");
    }

    private void overrideBackButton(boolean bl) {
        this.adControlAccessor.overrideBackButton(bl);
    }

    @Override
    public String getJavascript() {
        return JAVASCRIPT;
    }

    @Override
    public JavascriptInteractor.Executor getJavascriptInteractorExecutor() {
        return this.javascriptInteractor.getExecutor();
    }

    @Override
    public String getName() {
        return BRIDGE_NAME;
    }

    @Override
    public SDKEventListener getSDKEventListener() {
        return this.listener;
    }

    @Override
    public boolean hasNativeExecution() {
        return true;
    }

    private static class AmazonAdSDKEventListener
    implements SDKEventListener {
        private final AmazonAdSDKBridge bridge;

        public AmazonAdSDKEventListener(AmazonAdSDKBridge amazonAdSDKBridge) {
            this.bridge = amazonAdSDKBridge;
        }

        @Override
        public void onSDKEvent(SDKEvent sDKEvent, AdControlAccessor adControlAccessor) {
            if (sDKEvent.getEventType().equals((Object)SDKEvent.SDKEventType.BACK_BUTTON_PRESSED)) {
                this.bridge.onBackButton();
            }
        }
    }

    private static class EnableCloseButtonJSIF
    extends JavascriptInteractor.JavascriptMethodExecutor {
        private static final String name = "EnableCloseButton";
        private final AmazonAdSDKBridge bridge;

        public EnableCloseButtonJSIF(AmazonAdSDKBridge amazonAdSDKBridge) {
            super(name);
            this.bridge = amazonAdSDKBridge;
        }

        @Override
        public JSONObject execute(JSONObject jSONObject) {
            this.bridge.enableCloseButton(JSONUtils.getBooleanFromJSON(jSONObject, "enable", true));
            return null;
        }
    }

    private static class OpenInExternalBrowserJSIF
    extends JavascriptInteractor.JavascriptMethodExecutor {
        private static final String name = "OpenInExternalBrowser";
        private final AmazonAdSDKBridge bridge;

        public OpenInExternalBrowserJSIF(AmazonAdSDKBridge amazonAdSDKBridge) {
            super(name);
            this.bridge = amazonAdSDKBridge;
        }

        @Override
        public JSONObject execute(JSONObject jSONObject) {
            this.bridge.openInExternalBrowser(JSONUtils.getStringFromJSON(jSONObject, "url", null));
            return null;
        }
    }

    private static class OverrideBackButtonJSIF
    extends JavascriptInteractor.JavascriptMethodExecutor {
        private static final String name = "OverrideBackButton";
        private final AmazonAdSDKBridge bridge;

        public OverrideBackButtonJSIF(AmazonAdSDKBridge amazonAdSDKBridge) {
            super(name);
            this.bridge = amazonAdSDKBridge;
        }

        @Override
        public JSONObject execute(JSONObject jSONObject) {
            this.bridge.overrideBackButton(JSONUtils.getBooleanFromJSON(jSONObject, "override", false));
            return null;
        }
    }

    private static class SDKVersionJSIF
    extends JavascriptInteractor.JavascriptMethodExecutor {
        private static final String name = "GetSDKVersion";
        private final AmazonAdSDKBridge bridge;

        protected SDKVersionJSIF(AmazonAdSDKBridge amazonAdSDKBridge) {
            super(name);
            this.bridge = amazonAdSDKBridge;
        }

        @Override
        public JSONObject execute(JSONObject jSONObject) {
            JSONObject jSONObject2 = new JSONObject();
            JSONUtils.put(jSONObject2, "sdkVersion", this.bridge.getSDKVersion());
            return jSONObject2;
        }
    }

}

