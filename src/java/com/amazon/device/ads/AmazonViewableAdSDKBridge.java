/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  org.json.JSONObject
 */
package com.amazon.device.ads;

import com.amazon.device.ads.AdControlAccessor;
import com.amazon.device.ads.AdSDKBridge;
import com.amazon.device.ads.AmazonAdSDKViewableEventListener;
import com.amazon.device.ads.JSONUtils;
import com.amazon.device.ads.JavascriptInteractor;
import com.amazon.device.ads.MobileAdsLogger;
import com.amazon.device.ads.MobileAdsLoggerFactory;
import com.amazon.device.ads.SDKEventListener;
import com.amazon.device.ads.Settings;
import com.amazon.device.ads.Version;
import org.json.JSONObject;

class AmazonViewableAdSDKBridge
implements AdSDKBridge {
    private static final String BRIDGE_NAME = "viewableAdSDKBridge";
    private static final String INSTRUMENTATION_JAVASCRIPT_API;
    private static final String JAVASCRIPT_API;
    private static final String LOGTAG = "AmazonViewableAdSDKBridge";
    private final AdControlAccessor adControlAccessor;
    private final JavascriptInteractor javascriptInteractor;
    private final MobileAdsLogger logger;
    private SDKEventListener sdkEventListener;
    private final Settings settings;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(function (window, console) {\n    var is_array = function (obj) {\n        return Object.prototype.toString.call(obj) === '[object Array]';\n    },\n    addViewTreeObservers = function(){\n       viewableAdSDKBridge.");
        stringBuilder.append(JavascriptInteractor.getExecutorMethodName());
        stringBuilder.append("(\"AddObserversToViewTree\", null);\n");
        stringBuilder.append("    },\n");
        stringBuilder.append("    removeViewTreeObservers = function(){\n");
        stringBuilder.append("       viewableAdSDKBridge.");
        stringBuilder.append(JavascriptInteractor.getExecutorMethodName());
        stringBuilder.append("(\"RemoveObserversFromViewTree\", null);\n");
        stringBuilder.append("    },\n");
        stringBuilder.append("    forEach = function (array, fn) {\n");
        stringBuilder.append("        var i;\n");
        stringBuilder.append("        for (i = 0; i < array.length; i++) {\n");
        stringBuilder.append("            if (i in array) {\n");
        stringBuilder.append("                fn.call(null, array[i], i);\n");
        stringBuilder.append("            }\n");
        stringBuilder.append("        }\n");
        stringBuilder.append("    },\n");
        stringBuilder.append("    listeners = [],\n");
        stringBuilder.append("    version = 1.1,\n");
        stringBuilder.append("    invokeListeners = function(event, args) {\n");
        stringBuilder.append("        var eventListeners = listeners[event] || [];\n");
        stringBuilder.append("        // fire all the listeners\n");
        stringBuilder.append("        forEach(eventListeners, function(listener){\n");
        stringBuilder.append("            try {\n");
        stringBuilder.append("                listener.apply(null, args);\n");
        stringBuilder.append("            }catch(e){\n");
        stringBuilder.append("                debug(\"Error executing \" + event + \" listener\");\n");
        stringBuilder.append("                debug(e);\n");
        stringBuilder.append("            }\n");
        stringBuilder.append("        });\n");
        stringBuilder.append("    }\n");
        stringBuilder.append("    debug = function(msg) {\n");
        stringBuilder.append("        console.log(\"SDK JS API log: \" + msg);\n");
        stringBuilder.append("    },\n");
        stringBuilder.append("    viewabilityChangeEvent = function(viewable) {\n");
        stringBuilder.append("        debug(\"viewableChange: \" + viewable);\n");
        stringBuilder.append("        var jsonObject = JSON.parse(viewable);\n");
        stringBuilder.append("        var args = [jsonObject];\n");
        stringBuilder.append("        invokeListeners(\"Viewability\", args);\n");
        stringBuilder.append("    }, \n");
        stringBuilder.append("    window.viewableBridge = {\n");
        stringBuilder.append("       viewabilityChange : viewabilityChangeEvent\n");
        stringBuilder.append("    },\n");
        stringBuilder.append("    /* we can add new event properties in future */  \n");
        stringBuilder.append("    window.Event = {\n");
        stringBuilder.append("            Viewability: 'Viewability'\n");
        stringBuilder.append("    },\n");
        stringBuilder.append("    // Define the amazonmobileadsviewablebridge object\n");
        stringBuilder.append("    window.amazonmobileadsviewablebridge = {\n");
        stringBuilder.append("            // Command Flow\n");
        stringBuilder.append("            addEventListener : function(event, listener){\n");
        stringBuilder.append("                var eventListeners = listeners[event] || [],\n");
        stringBuilder.append("                alreadyRegistered = false;\n");
        stringBuilder.append("                \n");
        stringBuilder.append("                //verify the event is one that will actually occur/ verfiy it's supported by SDK\n");
        stringBuilder.append("                if (!Event.hasOwnProperty(event)){\n");
        stringBuilder.append("                    return;\n");
        stringBuilder.append("                }\n");
        stringBuilder.append("                \n");
        stringBuilder.append("                //register first set of listeners for this event\n");
        stringBuilder.append("                if (!is_array(listeners[event])) {\n");
        stringBuilder.append("                    listeners[event] = eventListeners;\n");
        stringBuilder.append("                }\n");
        stringBuilder.append("                \n");
        stringBuilder.append("                forEach(eventListeners, function(l){ \n");
        stringBuilder.append("                    // Listener already registered, so no need to add it.\n");
        stringBuilder.append("                        if (listener === l){\n");
        stringBuilder.append("                            alreadyRegistered = true;\n");
        stringBuilder.append("                        }\n");
        stringBuilder.append("                    }\n");
        stringBuilder.append("                );\n");
        stringBuilder.append("                if (!alreadyRegistered){\n");
        stringBuilder.append("                    listeners[event].push(listener);\n");
        stringBuilder.append("                    if (event = Event.Viewability){ \n");
        stringBuilder.append("                       addViewTreeObservers();  \n");
        stringBuilder.append("                   } \n");
        stringBuilder.append("                }\n");
        stringBuilder.append("            },\n");
        stringBuilder.append("            removeEventListener : function(event, listener){\n");
        stringBuilder.append("                if (listeners.hasOwnProperty(event)) {\n");
        stringBuilder.append("                    var eventListeners = listeners[event];\n");
        stringBuilder.append("                    if (eventListeners) {\n");
        stringBuilder.append("                        var idx = eventListeners.indexOf(listener);\n");
        stringBuilder.append("                        if (idx !== -1) {\n");
        stringBuilder.append("                            eventListeners.splice(idx, 1);\n");
        stringBuilder.append("                            if (event = Event.Viewability){ \n");
        stringBuilder.append("                               removeViewTreeObservers();  \n");
        stringBuilder.append("                             } \n");
        stringBuilder.append("                        }\n");
        stringBuilder.append("                    }\n");
        stringBuilder.append("                }\n");
        stringBuilder.append("            },\n");
        stringBuilder.append("            getSDKVersion: function(){\n");
        stringBuilder.append("               var json = JSON.parse(viewableAdSDKBridge.");
        stringBuilder.append(JavascriptInteractor.getExecutorMethodName());
        stringBuilder.append("(\"GetSDKVersion\", null));\n");
        stringBuilder.append("               return json.sdkVersion;\n");
        stringBuilder.append("            },\n");
        stringBuilder.append("            getVersion: function(){\n");
        stringBuilder.append("                return version;\n");
        stringBuilder.append("            },\n");
        stringBuilder.append("    };\n");
        stringBuilder.append("})(window, console);\n");
        JAVASCRIPT_API = stringBuilder.toString();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("function(){\n                var json = JSON.parse(viewableAdSDKBridge.");
        stringBuilder2.append(JavascriptInteractor.getExecutorMethodName());
        stringBuilder2.append("(\"GetInstrumentationURL\", null));\n");
        stringBuilder2.append("                return json.instrumentationPixelUrl;\n");
        stringBuilder2.append("            }");
        INSTRUMENTATION_JAVASCRIPT_API = stringBuilder2.toString();
    }

    public AmazonViewableAdSDKBridge(AdControlAccessor adControlAccessor, JavascriptInteractor javascriptInteractor) {
        this(adControlAccessor, javascriptInteractor, Settings.getInstance(), new MobileAdsLoggerFactory());
    }

    AmazonViewableAdSDKBridge(AdControlAccessor adControlAccessor, JavascriptInteractor javascriptInteractor, Settings settings, MobileAdsLoggerFactory mobileAdsLoggerFactory) {
        this.adControlAccessor = adControlAccessor;
        this.javascriptInteractor = javascriptInteractor;
        this.logger = mobileAdsLoggerFactory.createMobileAdsLogger(LOGTAG);
        this.settings = settings;
        this.javascriptInteractor.addMethodExecutor(new AddObserversToViewTree(this));
        this.javascriptInteractor.addMethodExecutor(new RemoveObserversFromViewTree(this));
        this.javascriptInteractor.addMethodExecutor(new GetInstrumentationURL(this));
        this.javascriptInteractor.addMethodExecutor(new SDKVersionJSIF(this));
    }

    private String appendViewabilityJavascript() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(JAVASCRIPT_API);
        stringBuilder.append(this.getViewabilityJavascript());
        return stringBuilder.toString();
    }

    private void deregisterViewabilityInterest() {
        this.adControlAccessor.deregisterViewabilityInterest();
    }

    private String getInstrumentationURL() {
        return this.adControlAccessor.getInstrumentationPixelUrl();
    }

    private String getSDKVersion() {
        return Version.getRawSDKVersion();
    }

    private String getViewabilityJavascript() {
        String string = this.settings.getString("viewableJSSettingsNameAmazonAdSDK", null);
        if (string == null) {
            this.logger.w("Viewability Javascript is null");
            return "";
        }
        Object[] arrobject = new Object[]{INSTRUMENTATION_JAVASCRIPT_API, this.adControlAccessor.getSlotID()};
        return String.format((String)string, (Object[])arrobject);
    }

    private void registerViewabilityInterest() {
        this.adControlAccessor.registerViewabilityInterest();
    }

    @Override
    public String getJavascript() {
        return this.appendViewabilityJavascript();
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
        if (this.sdkEventListener == null) {
            this.sdkEventListener = new AmazonAdSDKViewableEventListener();
        }
        return this.sdkEventListener;
    }

    @Override
    public boolean hasNativeExecution() {
        return true;
    }

    private static class AddObserversToViewTree
    extends JavascriptInteractor.JavascriptMethodExecutor {
        private static final String name = "AddObserversToViewTree";
        private final AmazonViewableAdSDKBridge bridge;

        public AddObserversToViewTree(AmazonViewableAdSDKBridge amazonViewableAdSDKBridge) {
            super(name);
            this.bridge = amazonViewableAdSDKBridge;
        }

        @Override
        protected JSONObject execute(JSONObject jSONObject) {
            this.bridge.registerViewabilityInterest();
            return null;
        }
    }

    private static class GetInstrumentationURL
    extends JavascriptInteractor.JavascriptMethodExecutor {
        private static final String name = "GetInstrumentationURL";
        private final AmazonViewableAdSDKBridge bridge;

        public GetInstrumentationURL(AmazonViewableAdSDKBridge amazonViewableAdSDKBridge) {
            super(name);
            this.bridge = amazonViewableAdSDKBridge;
        }

        @Override
        protected JSONObject execute(JSONObject jSONObject) {
            JSONObject jSONObject2 = new JSONObject();
            JSONUtils.put(jSONObject2, "instrumentationPixelUrl", this.bridge.getInstrumentationURL());
            return jSONObject2;
        }
    }

    private static class RemoveObserversFromViewTree
    extends JavascriptInteractor.JavascriptMethodExecutor {
        private static final String name = "RemoveObserversFromViewTree";
        private final AmazonViewableAdSDKBridge bridge;

        public RemoveObserversFromViewTree(AmazonViewableAdSDKBridge amazonViewableAdSDKBridge) {
            super(name);
            this.bridge = amazonViewableAdSDKBridge;
        }

        @Override
        protected JSONObject execute(JSONObject jSONObject) {
            this.bridge.deregisterViewabilityInterest();
            return null;
        }
    }

    private static class SDKVersionJSIF
    extends JavascriptInteractor.JavascriptMethodExecutor {
        private static final String name = "GetSDKVersion";
        private final AmazonViewableAdSDKBridge bridge;

        protected SDKVersionJSIF(AmazonViewableAdSDKBridge amazonViewableAdSDKBridge) {
            super(name);
            this.bridge = amazonViewableAdSDKBridge;
        }

        @Override
        public JSONObject execute(JSONObject jSONObject) {
            JSONObject jSONObject2 = new JSONObject();
            JSONUtils.put(jSONObject2, "sdkVersion", this.bridge.getSDKVersion());
            return jSONObject2;
        }
    }

}

