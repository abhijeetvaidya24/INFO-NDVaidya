/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.MutableContextWrapper
 *  android.content.res.Configuration
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.text.TextUtils
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.webkit.JavascriptInterface
 *  android.webkit.WebChromeClient
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  com.aerserv.sdk.model.vast.InLine
 *  com.aerserv.sdk.model.vast.LinearCreative
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.List
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.aerserv.sdk.view.component;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import com.aerserv.sdk.AerServEvent;
import com.aerserv.sdk.AerServSettings;
import com.aerserv.sdk.AerServVirtualCurrency;
import com.aerserv.sdk.controller.command.FireEventCommand;
import com.aerserv.sdk.controller.listener.AerServEventListenerLocator;
import com.aerserv.sdk.controller.listener.PlayPauseListener;
import com.aerserv.sdk.model.ad.VASTProviderAd;
import com.aerserv.sdk.model.vast.EventType;
import com.aerserv.sdk.model.vast.InLine;
import com.aerserv.sdk.model.vast.LinearCreative;
import com.aerserv.sdk.model.vast.TrackingEvents;
import com.aerserv.sdk.model.vast.Vpaid;
import com.aerserv.sdk.utils.AerServLog;
import com.aerserv.sdk.utils.VersionUtils;
import com.aerserv.sdk.utils.WebViewJSRunner;
import com.aerserv.sdk.view.component.VpaidWebView;
import com.aerserv.sdk.view.vastplayer.VpaidPlayer;
import com.aerserv.sdk.view.vastplayer.VpaidPlayerListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class VpaidWebView
extends WebView
implements VpaidPlayer {
    private static final String AD_LINEAR_CHANGE_KEY = "adLinearChange";
    private static final Integer AD_LINEAR_CHANGE_TIMEOUT;
    private static final String CREATIVE_JAVASCRIPT_KEY = "JS";
    private static final String CREATIVE_KEY = "creative";
    private static final String DEBUG_KEY = "debug";
    private static final String ENDCARD_KEY = "endcard";
    private static final Integer ENDCARD_TIMEOUT;
    private static final String HEARTBEAT_KEY = "heartbeat";
    private static final Integer HEARTBEAT_TIMEOUT;
    private static final String INIT_AD_KEY = "initAd";
    private static final Integer INIT_AD_TIMEOUT;
    private static final boolean IS_DEBUG_MODE = false;
    private static final String KBITRATE = "1000";
    private static final String KBITRATE_KEY = "kBitRate";
    private static final String LOG_TAG = "VpaidWebView";
    private static final String PARAMETER_KEY = "parameter";
    private static final String READY_KEY = "ready";
    private static final Integer READY_TIMEOUT;
    private static final Integer SLEEP_TIME;
    private static final String START_AD_KEY = "startAd";
    private static final Integer START_AD_TIMEOUT;
    private static final String STOP_AD_KEY = "stopAd";
    private static final Integer STOP_AD_TIMEOUT;
    private static final String SUPPORTED_VPAID_VERSION = "2.0";
    private static final String TIMEOUT_KEY = "timeout";
    private static final String VIEW_MODE = "normal";
    private static final String VIEW_MODE_KEY = "viewMode";
    private static final String VPAID_BRIDGE_JS = "https://d3tplke66d0j4g.cloudfront.net/sdk-vpaid/0.3/VPAIDBridge.js";
    private static final String VPAID_BRIDGE_JS_KEY = "bridgeJSUrl";
    private static final String VPAID_HTML = "https://d3tplke66d0j4g.cloudfront.net/sdk-vpaid/0.3/VPAID.html";
    private static final String VPAID_HTML_KEY = "htmlUrl";
    private static final String VPAID_JS = "https://d3tplke66d0j4g.cloudfront.net/sdk-vpaid/0.3/VPAID.js";
    private static final String VPAID_JS_KEY = "jsUrl";
    private static final String VPAID_POSTER = "https://d3tplke66d0j4g.cloudfront.net/img/poster.gif";
    private static final String VPAID_POSTER_KEY = "posterUrl";
    private static final String VPAID_VERSION_KEY = "version";
    private static JSONObject config_settings;
    private static VpaidWebView instance;
    private static MutableContextWrapper mutableContext;
    private VASTProviderAd ad;
    private List<String> allImpressionEvents;
    private TrackingEvents allProgressEvents;
    private boolean closeVisible = false;
    private String controllerId;
    private volatile float currentTime;
    private final Object currentTimeMonitor = new Object();
    private float duration;
    private final Object eventMonitor = new Object();
    private boolean handShook = false;
    private boolean hasDismissed = false;
    private boolean isLoaded;
    private volatile boolean killed;
    private final Object killedMonitor = new Object();
    private volatile boolean paused = false;
    private volatile int periods = 0;
    private VpaidWebView self = this;
    private VpaidPlayerListener vpaidPlayerListener;

    static {
        Integer n2;
        AD_LINEAR_CHANGE_TIMEOUT = n2 = Integer.valueOf((int)3000);
        ENDCARD_TIMEOUT = n2;
        HEARTBEAT_TIMEOUT = 0;
        INIT_AD_TIMEOUT = 5000;
        READY_TIMEOUT = 500;
        SLEEP_TIME = 1000;
        START_AD_TIMEOUT = n2;
        STOP_AD_TIMEOUT = n2;
        config_settings = null;
        instance = null;
        mutableContext = null;
    }

    private VpaidWebView(Context context) {
        super(context);
        this.getSettings().setJavaScriptEnabled(true);
        this.getSettings().setUseWideViewPort(true);
        this.setVerticalScrollBarEnabled(false);
        this.setHorizontalScrollBarEnabled(false);
        this.setBackgroundColor(-16777216);
        if (VersionUtils.checkVersion(21)) {
            this.getSettings().setMixedContentMode(0);
        }
        VpaidWebView.setConfigSettings();
        this.setWebViewClient(new WebViewClient(this){
            final /* synthetic */ VpaidWebView this$0;
            {
                this.this$0 = vpaidWebView;
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            public void onPageFinished(WebView webView, String string) {
                webView.addJavascriptInterface((Object)VpaidWebView.access$200(this.this$0), "aerserv_bridge");
                try {
                    java.util.HashMap hashMap = new java.util.HashMap();
                    if (VpaidWebView.access$300(VpaidWebView.access$000()) != null) {
                        hashMap.put((Object)"JS", (Object)VpaidWebView.access$300(this.this$0).getVpaid().getMediaFile().getMediaUri());
                        String string2 = VpaidWebView.access$300(this.this$0).getVpaid().getCreative().getAdParameters() != null ? VpaidWebView.access$300(VpaidWebView.access$000()).getVpaid().getCreative().getAdParameters() : "";
                        hashMap.put((Object)"parameter", (Object)string2);
                        hashMap.put((Object)"viewMode", (Object)"normal");
                        hashMap.put((Object)"kBitRate", (Object)"1000");
                    }
                    JSONObject jSONObject = new JSONObject(VpaidWebView.access$400().toString());
                    jSONObject.put("creative", (Object)new JSONObject((java.util.Map)hashMap));
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("var config = ");
                    stringBuilder.append(jSONObject.toString());
                    WebViewJSRunner.runIt(webView, stringBuilder.toString());
                }
                catch (JSONException jSONException) {
                    jSONException.printStackTrace();
                }
                WebViewJSRunner.runIt(webView, "aerserv_ready();");
                VpaidWebView.access$602(this.this$0, 0.0f);
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            public void onPageStarted(WebView webView, String string, android.graphics.Bitmap bitmap) {
                String string2;
                java.util.HashMap hashMap;
                webView.addJavascriptInterface((Object)VpaidWebView.access$200(this.this$0), "aerserv_bridge");
                try {
                    hashMap = new java.util.HashMap();
                    hashMap.put((Object)"JS", (Object)VpaidWebView.access$300(this.this$0).getVpaid().getMediaFile().getMediaUri());
                    string2 = VpaidWebView.access$300(this.this$0).getVpaid().getCreative().getAdParameters() != null ? VpaidWebView.access$300(this.this$0).getVpaid().getCreative().getAdParameters() : "";
                }
                catch (JSONException jSONException) {
                    AerServLog.d(VpaidWebView.access$500(), "A problem occurred when evaluating the vpaid configuration.");
                    return;
                }
                hashMap.put((Object)"parameter", (Object)string2);
                hashMap.put((Object)"viewMode", (Object)"normal");
                hashMap.put((Object)"kBitRate", (Object)"1000");
                JSONObject jSONObject = new JSONObject(VpaidWebView.access$400().toString());
                jSONObject.put("creative", (Object)new JSONObject((java.util.Map)hashMap));
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("var config = ");
                stringBuilder.append(jSONObject.toString());
                WebViewJSRunner.runIt(webView, stringBuilder.toString());
            }
        });
        this.setWebChromeClient(new WebChromeClient());
        if (Build.VERSION.SDK_INT >= 17) {
            this.getSettings().setMediaPlaybackRequiresUserGesture(false);
        }
    }

    static /* synthetic */ boolean access$100(VpaidWebView vpaidWebView) {
        return vpaidWebView.paused;
    }

    static /* synthetic */ Object access$1000(VpaidWebView vpaidWebView) {
        return vpaidWebView.currentTimeMonitor;
    }

    static /* synthetic */ VpaidPlayerListener access$1100(VpaidWebView vpaidWebView) {
        return vpaidWebView.vpaidPlayerListener;
    }

    static /* synthetic */ int access$1200(VpaidWebView vpaidWebView) {
        return vpaidWebView.periods;
    }

    static /* synthetic */ int access$1202(VpaidWebView vpaidWebView, int n2) {
        vpaidWebView.periods = n2;
        return n2;
    }

    static /* synthetic */ int access$1208(VpaidWebView vpaidWebView) {
        int n2 = vpaidWebView.periods;
        vpaidWebView.periods = n2 + 1;
        return n2;
    }

    static /* synthetic */ boolean access$1300(VpaidWebView vpaidWebView) {
        return vpaidWebView.closeVisible;
    }

    static /* synthetic */ boolean access$1302(VpaidWebView vpaidWebView, boolean bl) {
        vpaidWebView.closeVisible = bl;
        return bl;
    }

    static /* synthetic */ Integer access$1400() {
        return SLEEP_TIME;
    }

    static /* synthetic */ TrackingEvents access$1500(VpaidWebView vpaidWebView) {
        return vpaidWebView.allProgressEvents;
    }

    static /* synthetic */ VpaidWebView access$200(VpaidWebView vpaidWebView) {
        return vpaidWebView.self;
    }

    static /* synthetic */ VASTProviderAd access$300(VpaidWebView vpaidWebView) {
        return vpaidWebView.ad;
    }

    static /* synthetic */ JSONObject access$400() {
        return config_settings;
    }

    static /* synthetic */ String access$500() {
        return LOG_TAG;
    }

    static /* synthetic */ float access$600(VpaidWebView vpaidWebView) {
        return vpaidWebView.currentTime;
    }

    static /* synthetic */ float access$602(VpaidWebView vpaidWebView, float f2) {
        vpaidWebView.currentTime = f2;
        return f2;
    }

    static /* synthetic */ Object access$700(VpaidWebView vpaidWebView) {
        return vpaidWebView.killedMonitor;
    }

    static /* synthetic */ boolean access$800(VpaidWebView vpaidWebView) {
        return vpaidWebView.killed;
    }

    static /* synthetic */ boolean access$802(VpaidWebView vpaidWebView, boolean bl) {
        vpaidWebView.killed = bl;
        return bl;
    }

    static /* synthetic */ float access$900(VpaidWebView vpaidWebView) {
        return vpaidWebView.duration;
    }

    private void cleanup() {
        ((Activity)mutableContext.getBaseContext()).runOnUiThread(new Runnable(this){
            final /* synthetic */ VpaidWebView this$0;
            {
                this.this$0 = vpaidWebView;
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            public void run() {
                Object object;
                Object object2 = object = VpaidWebView.access$700(this.this$0);
                synchronized (object2) {
                    VpaidWebView.access$802(this.this$0, true);
                }
                this.this$0.removeAllViews();
                this.this$0.destroyDrawingCache();
                this.this$0.clearCache(true);
                this.this$0.clearHistory();
            }
        });
    }

    public static VpaidWebView create(Context context, VpaidPlayerListener vpaidPlayerListener, VASTProviderAd vASTProviderAd, String string) {
        MutableContextWrapper mutableContextWrapper = mutableContext;
        if (mutableContextWrapper == null) {
            mutableContext = new MutableContextWrapper(context);
        } else {
            mutableContextWrapper.setBaseContext(context);
        }
        if (instance == null) {
            instance = new VpaidWebView((Context)mutableContext);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13, -1);
        instance.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        VpaidWebView vpaidWebView = instance;
        vpaidWebView.vpaidPlayerListener = vpaidPlayerListener;
        vpaidWebView.ad = vASTProviderAd;
        vpaidWebView.controllerId = string;
        vpaidWebView.allProgressEvents = new TrackingEvents();
        VpaidWebView.instance.allProgressEvents.addAll((Collection)vASTProviderAd.getVpaid().getCreative().getTrackingEventsByEventType(EventType.PROGRESS));
        VpaidWebView.instance.allProgressEvents.addAll((Collection)vASTProviderAd.getAllWrapperLinearCreativeTrackingEventsByType(EventType.PROGRESS));
        VpaidWebView.instance.allImpressionEvents = new ArrayList();
        VpaidWebView.instance.allImpressionEvents.addAll((Collection)vASTProviderAd.getVpaid().getAd().getImpressionUris());
        VpaidWebView.instance.allImpressionEvents.addAll(vASTProviderAd.getAllWrapperImpressionUris());
        VpaidWebView vpaidWebView2 = instance;
        vpaidWebView2.killed = false;
        vpaidWebView2.paused = false;
        vpaidWebView2.periods = 0;
        vpaidWebView2.duration = 0.0f;
        vpaidWebView2.currentTime = 0.0f;
        vpaidWebView2.hasDismissed = false;
        vpaidPlayerListener.onPlayPauseListenerCreated(new PlayPauseListener(){

            @Override
            public void onPause() {
                instance.paused = true;
                instance.pause();
            }

            @Override
            public void onPlay() {
                instance.paused = false;
                instance.resume();
            }
        });
        return instance;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void setConfigSettings() {
        try {
            JSONObject jSONObject = AerServSettings.getVpaidConfig();
            if (jSONObject != null) {
                AerServLog.d(LOG_TAG, "Server-side config found for vpaid.");
                config_settings = AerServSettings.getVpaidConfig();
                config_settings.put(VPAID_HTML_KEY, (Object)config_settings.optString(VPAID_HTML_KEY, VPAID_HTML));
                config_settings.put(VPAID_JS_KEY, (Object)config_settings.optString(VPAID_JS_KEY, VPAID_JS));
                config_settings.put(VPAID_BRIDGE_JS_KEY, (Object)config_settings.optString(VPAID_BRIDGE_JS_KEY, VPAID_BRIDGE_JS));
                return;
            }
            AerServLog.d(LOG_TAG, "Server-side config not found for vpaid. Using default values.");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(READY_KEY, (Object)READY_TIMEOUT).put(HEARTBEAT_KEY, (Object)HEARTBEAT_TIMEOUT).put(INIT_AD_KEY, (Object)INIT_AD_TIMEOUT).put(START_AD_KEY, (Object)START_AD_TIMEOUT).put(STOP_AD_KEY, (Object)STOP_AD_TIMEOUT).put(AD_LINEAR_CHANGE_KEY, (Object)AD_LINEAR_CHANGE_TIMEOUT).put(ENDCARD_KEY, (Object)ENDCARD_TIMEOUT);
            config_settings = new JSONObject();
            config_settings.put(VPAID_VERSION_KEY, (Object)SUPPORTED_VPAID_VERSION).put(DEBUG_KEY, false).put(TIMEOUT_KEY, (Object)jSONObject2).put(VPAID_HTML_KEY, (Object)VPAID_HTML).put(VPAID_POSTER_KEY, (Object)VPAID_POSTER).put(VPAID_JS_KEY, (Object)VPAID_JS).put(VPAID_BRIDGE_JS_KEY, (Object)VPAID_BRIDGE_JS);
            return;
        }
        catch (JSONException jSONException) {
            AerServLog.d(LOG_TAG, "A problem occurred when evaluating the vpaid configuration settings.");
            return;
        }
    }

    private void startVideoTimer() {
        WebViewJSRunner.runIt(this, "aerserv_bridge.onGetAdDurationCallback(ad.getAdDuration());");
        WebViewJSRunner.runIt(this, "aerserv_bridge.onGetAdRemainingTimeCallback(ad.getAdRemainingTime());");
        new Thread(new Runnable(this){
            final /* synthetic */ VpaidWebView this$0;
            {
                this.this$0 = vpaidWebView;
            }

            /*
             * Exception decompiling
             */
            public void run(}
        java.lang.IllegalStateException: Parameters not created
        
        