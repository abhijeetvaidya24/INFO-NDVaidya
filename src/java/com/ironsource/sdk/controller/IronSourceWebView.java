/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.app.Activity
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.content.MutableContextWrapper
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.Color
 *  android.location.Location
 *  android.net.Uri
 *  android.os.AsyncTask
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.CountDownTimer
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 *  android.text.TextUtils
 *  android.util.Log
 *  android.view.KeyEvent
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnTouchListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.webkit.ConsoleMessage
 *  android.webkit.DownloadListener
 *  android.webkit.JavascriptInterface
 *  android.webkit.ValueCallback
 *  android.webkit.WebBackForwardList
 *  android.webkit.WebChromeClient
 *  android.webkit.WebChromeClient$CustomViewCallback
 *  android.webkit.WebResourceResponse
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  android.webkit.WebView$WebViewTransport
 *  android.webkit.WebViewClient
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  com.ironsource.sdk.controller.InterstitialActivity
 *  java.io.File
 *  java.io.UnsupportedEncodingException
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.Enum
 *  java.lang.Exception
 *  java.lang.Float
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.StackTraceElement
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.net.URLDecoder
 *  java.nio.charset.Charset
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Locale
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.ironsource.sdk.controller;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.MutableContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.location.Location;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.DownloadListener;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.ironsource.environment.ApplicationContext;
import com.ironsource.environment.ConnectivityService;
import com.ironsource.environment.DeviceStatus;
import com.ironsource.environment.LocationService;
import com.ironsource.environment.UrlHandler;
import com.ironsource.sdk.constants.Constants;
import com.ironsource.sdk.controller.ControllerActivity;
import com.ironsource.sdk.controller.ControllerView;
import com.ironsource.sdk.controller.DemandSourceManager;
import com.ironsource.sdk.controller.InterstitialActivity;
import com.ironsource.sdk.controller.IronSourceWebView;
import com.ironsource.sdk.controller.MOATJSAdapter;
import com.ironsource.sdk.controller.OpenUrlActivity;
import com.ironsource.sdk.controller.PermissionsJSAdapter;
import com.ironsource.sdk.controller.ProductParametersCollection;
import com.ironsource.sdk.controller.VideoEventsListener;
import com.ironsource.sdk.data.AdUnitsReady;
import com.ironsource.sdk.data.AdUnitsState;
import com.ironsource.sdk.data.DemandSource;
import com.ironsource.sdk.data.ProductParameters;
import com.ironsource.sdk.data.SSABCParameters;
import com.ironsource.sdk.data.SSAEnums;
import com.ironsource.sdk.data.SSAFile;
import com.ironsource.sdk.data.SSAObj;
import com.ironsource.sdk.listeners.OnGenericFunctionListener;
import com.ironsource.sdk.listeners.OnOfferWallListener;
import com.ironsource.sdk.listeners.OnWebViewChangeListener;
import com.ironsource.sdk.listeners.internals.DSAdProductListener;
import com.ironsource.sdk.listeners.internals.DSInterstitialListener;
import com.ironsource.sdk.listeners.internals.DSRewardedVideoListener;
import com.ironsource.sdk.precache.DownloadManager;
import com.ironsource.sdk.utils.DeviceProperties;
import com.ironsource.sdk.utils.IronSourceAsyncHttpRequestTask;
import com.ironsource.sdk.utils.IronSourceSharedPrefHelper;
import com.ironsource.sdk.utils.IronSourceStorageUtils;
import com.ironsource.sdk.utils.Logger;
import com.ironsource.sdk.utils.SDKUtils;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class IronSourceWebView
extends WebView
implements DownloadListener,
DownloadManager.OnPreCacheCompletion {
    public static String APP_IDS = "appIds";
    public static int DISPLAY_WEB_VIEW_INTENT = 0;
    public static String EXTERNAL_URL = "external_url";
    public static String IS_INSTALLED = "isInstalled";
    public static String IS_STORE = "is_store";
    public static String IS_STORE_CLOSE = "is_store_close";
    private static String JSON_KEY_FAIL = "fail";
    private static String JSON_KEY_SUCCESS = "success";
    public static int OPEN_URL_INTENT = 1;
    public static String REQUEST_ID = "requestId";
    public static String RESULT = "result";
    public static String SECONDARY_WEB_VIEW = "secondary_web_view";
    public static String WEBVIEW_TYPE = "webview_type";
    public static int mDebugMode;
    private final String GENERIC_MESSAGE = "We're sorry, some error occurred. we will investigate it";
    private String PUB_TAG = "IronSource";
    private String TAG = IronSourceWebView.class.getSimpleName();
    private DownloadManager downloadManager;
    private Boolean isKitkatAndAbove = null;
    private boolean isRemoveCloseEventHandler;
    private String mCacheDirectory;
    private OnWebViewChangeListener mChangeListener;
    private CountDownTimer mCloseEventTimer;
    private BroadcastReceiver mConnectionReceiver = new BroadcastReceiver(this){
        final /* synthetic */ IronSourceWebView this$0;
        {
            this.this$0 = ironSourceWebView;
        }

        public void onReceive(Context context, Intent intent) {
            if (IronSourceWebView.access$1500(this.this$0) == SSAEnums.ControllerState.Ready) {
                String string = ConnectivityService.isConnectedWifi(context) ? "wifi" : (ConnectivityService.isConnectedMobile(context) ? "3g" : "none");
                this.this$0.deviceStatusChanged(string);
            }
        }
    };
    private ArrayList<String> mControllerCommandsQueue;
    private String mControllerKeyPressed = "interrupt";
    private FrameLayout mControllerLayout;
    private SSAEnums.ControllerState mControllerState = SSAEnums.ControllerState.None;
    Context mCurrentActivityContext;
    private View mCustomView;
    private WebChromeClient.CustomViewCallback mCustomViewCallback;
    private FrameLayout mCustomViewContainer;
    private DSInterstitialListener mDSInterstitialListener;
    private DSRewardedVideoListener mDSRewardedVideoListener;
    private DemandSourceManager mDemandSourceManager;
    private boolean mGlobalControllerTimeFinish;
    private CountDownTimer mGlobalControllerTimer;
    private int mHiddenForceCloseHeight = 50;
    private String mHiddenForceCloseLocation = "top-right";
    private int mHiddenForceCloseWidth = 50;
    private String mISAppKey;
    private String mISUserId;
    private boolean mIsActivityThemeTranslucent = false;
    private boolean mIsImmersive = false;
    private CountDownTimer mLoadControllerTimer;
    private MOATJSAdapter mMoatJsAdapter;
    private String mOWAppKey;
    private String mOWCreditsAppKey;
    private boolean mOWCreditsMiss;
    private String mOWCreditsUserId;
    private Map<String, String> mOWExtraParameters;
    private String mOWUserId;
    private boolean mOWmiss;
    private OnGenericFunctionListener mOnGenericFunctionListener;
    private OnOfferWallListener mOnOfferWallListener;
    private String mOrientationState;
    private PermissionsJSAdapter mPermissionsJsAdapter;
    private ProductParametersCollection mProductParametersCollection = new ProductParametersCollection();
    private String mRVAppKey;
    private String mRVUserId;
    private String mRequestParameters;
    private AdUnitsState mSavedState;
    private Object mSavedStateLocker = new Object();
    private State mState;
    Handler mUiHandler;
    private VideoEventsListener mVideoEventsListener;
    private ChromeClient mWebChromeClient;

    public IronSourceWebView(Context context, DemandSourceManager demandSourceManager) {
        super(context.getApplicationContext());
        Logger.i(this.TAG, "C'tor");
        this.mControllerCommandsQueue = new ArrayList();
        this.mCacheDirectory = this.initializeCacheDirectory(context.getApplicationContext());
        this.mCurrentActivityContext = context;
        this.mDemandSourceManager = demandSourceManager;
        this.initLayout(this.mCurrentActivityContext);
        this.mSavedState = new AdUnitsState();
        this.downloadManager = this.getDownloadManager();
        this.downloadManager.setOnPreCacheCompletion(this);
        this.mWebChromeClient = new WebChromeClient(){

            public View getVideoLoadingProgressView() {
                FrameLayout frameLayout = new FrameLayout(IronSourceWebView.this.getCurrentActivityContext());
                frameLayout.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
                return frameLayout;
            }

            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(consoleMessage.message());
                stringBuilder.append(" -- From line ");
                stringBuilder.append(consoleMessage.lineNumber());
                stringBuilder.append(" of ");
                stringBuilder.append(consoleMessage.sourceId());
                Logger.i("MyApplication", stringBuilder.toString());
                return true;
            }

            public boolean onCreateWindow(WebView webView, boolean bl, boolean bl2, Message message) {
                WebView webView2 = new WebView(webView.getContext());
                webView2.setWebChromeClient((WebChromeClient)this);
                webView2.setWebViewClient(new WebViewClient(){

                    public boolean shouldOverrideUrlLoading(WebView webView, String string) {
                        Context context = IronSourceWebView.this.getCurrentActivityContext();
                        Intent intent = new Intent(context, OpenUrlActivity.class);
                        intent.putExtra(IronSourceWebView.EXTERNAL_URL, string);
                        intent.putExtra(IronSourceWebView.SECONDARY_WEB_VIEW, false);
                        context.startActivity(intent);
                        return true;
                    }
                });
                ((WebView.WebViewTransport)message.obj).setWebView(webView2);
                message.sendToTarget();
                Logger.i("onCreateWindow", "onCreateWindow");
                return true;
            }

            public void onHideCustomView() {
                Logger.i("Test", "onHideCustomView");
                if (IronSourceWebView.this.mCustomView == null) {
                    return;
                }
                IronSourceWebView.this.mCustomView.setVisibility(8);
                IronSourceWebView.this.mCustomViewContainer.removeView(IronSourceWebView.this.mCustomView);
                IronSourceWebView.this.mCustomView = null;
                IronSourceWebView.this.mCustomViewContainer.setVisibility(8);
                IronSourceWebView.this.mCustomViewCallback.onCustomViewHidden();
                IronSourceWebView.this.setVisibility(0);
            }

            public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
                Logger.i("Test", "onShowCustomView");
                IronSourceWebView.this.setVisibility(8);
                if (IronSourceWebView.this.mCustomView != null) {
                    Logger.i("Test", "mCustomView != null");
                    customViewCallback.onCustomViewHidden();
                    return;
                }
                Logger.i("Test", "mCustomView == null");
                IronSourceWebView.this.mCustomViewContainer.addView(view);
                IronSourceWebView.this.mCustomView = view;
                IronSourceWebView.this.mCustomViewCallback = customViewCallback;
                IronSourceWebView.this.mCustomViewContainer.setVisibility(0);
            }
        };
        this.setWebViewClient(new WebViewClient(){

            public void onPageFinished(WebView webView, String string) {
                Logger.i("onPageFinished", string);
                if (string.contains((CharSequence)"adUnit") || string.contains((CharSequence)"index.html")) {
                    IronSourceWebView.this.pageFinished();
                }
                super.onPageFinished(webView, string);
            }

            public void onPageStarted(WebView webView, String string, Bitmap bitmap) {
                Logger.i("onPageStarted", string);
                super.onPageStarted(webView, string, bitmap);
            }

            public void onReceivedError(WebView webView, int n2, String string, String string2) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string2);
                stringBuilder.append(" ");
                stringBuilder.append(string);
                Logger.i("onReceivedError", stringBuilder.toString());
                super.onReceivedError(webView, n2, string, string2);
            }

            /*
             * Exception decompiling
             */
            public WebResourceResponse shouldInterceptRequest(WebView var1, String var2) {
                // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl64.1 : ALOAD_0 : trying to set 0 previously set to 1
                // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
                // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
                // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
                // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
                // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
                // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
                // org.benf.cfr.reader.entities.g.p(Method.java:396)
                // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
                // org.benf.cfr.reader.entities.d.c(ClassFile.java:773)
                // org.benf.cfr.reader.entities.d.e(ClassFile.java:870)
                // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
                // org.benf.cfr.reader.b.a(Driver.java:128)
                // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
                // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
                // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
                // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
                // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
                // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
                // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
                // java.lang.Thread.run(Thread.java:919)
                throw new IllegalStateException("Decompilation failed");
            }

            public boolean shouldOverrideUrlLoading(WebView webView, String string) {
                Logger.i("shouldOverrideUrlLoading", string);
                try {
                    if (IronSourceWebView.this.handleSearchKeysURLs(string)) {
                        IronSourceWebView.this.interceptedUrlToStore();
                        return true;
                    }
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
                return super.shouldOverrideUrlLoading(webView, string);
            }
        });
        this.setWebChromeClient((WebChromeClient)this.mWebChromeClient);
        this.setWebViewSettings();
        this.addJavascriptInterface((Object)this.createJSInterface(context), "Android");
        this.setDownloadListener((DownloadListener)this);
        this.setOnTouchListener(new View.OnTouchListener(){

            /*
             * Unable to fully structure code
             * Enabled aggressive block sorting
             * Lifted jumps to return sites
             */
            public boolean onTouch(View var1_1, MotionEvent var2_2) {
                block4 : {
                    block5 : {
                        block3 : {
                            if (var2_2.getAction() != 1) return false;
                            var3_3 = var2_2.getX();
                            var4_4 = var2_2.getY();
                            var5_5 = IronSourceWebView.access$300(IronSourceWebView.this);
                            var6_6 = new StringBuilder();
                            var6_6.append("X:");
                            var8_7 = (int)var3_3;
                            var6_6.append(var8_7);
                            var6_6.append(" Y:");
                            var11_8 = (int)var4_4;
                            var6_6.append(var11_8);
                            Logger.i(var5_5, var6_6.toString());
                            var13_9 = DeviceStatus.getDeviceWidth();
                            var14_10 = DeviceStatus.getDeviceHeight();
                            var15_11 = IronSourceWebView.access$300(IronSourceWebView.this);
                            var16_12 = new StringBuilder();
                            var16_12.append("Width:");
                            var16_12.append(var13_9);
                            var16_12.append(" Height:");
                            var16_12.append(var14_10);
                            Logger.i(var15_11, var16_12.toString());
                            var21_13 = SDKUtils.dpToPx(IronSourceWebView.access$400(IronSourceWebView.this));
                            var22_14 = SDKUtils.dpToPx(IronSourceWebView.access$500(IronSourceWebView.this));
                            if (!"top-right".equalsIgnoreCase(IronSourceWebView.access$600(IronSourceWebView.this))) break block3;
                            var8_7 = var13_9 - var8_7;
                            break block4;
                        }
                        if ("top-left".equalsIgnoreCase(IronSourceWebView.access$600(IronSourceWebView.this))) break block4;
                        if (!"bottom-right".equalsIgnoreCase(IronSourceWebView.access$600(IronSourceWebView.this))) break block5;
                        var8_7 = var13_9 - var8_7;
                        ** GOTO lbl-1000
                    }
                    if ("bottom-left".equalsIgnoreCase(IronSourceWebView.access$600(IronSourceWebView.this))) lbl-1000: // 2 sources:
                    {
                        var11_8 = var14_10 - var11_8;
                    } else {
                        var8_7 = 0;
                        var11_8 = 0;
                    }
                }
                if (var8_7 > var21_13) return false;
                if (var11_8 > var22_14) return false;
                IronSourceWebView.access$702(IronSourceWebView.this, false);
                if (IronSourceWebView.access$800(IronSourceWebView.this) != null) {
                    IronSourceWebView.access$800(IronSourceWebView.this).cancel();
                }
                var24_15 = IronSourceWebView.this;
                var25_16 = new CountDownTimer(2000L, 500L){

                    public void onFinish() {
                        Logger.i(IronSourceWebView.this.TAG, "Close Event Timer Finish");
                        if (IronSourceWebView.this.isRemoveCloseEventHandler) {
                            IronSourceWebView.this.isRemoveCloseEventHandler = false;
                            return;
                        }
                        IronSourceWebView.this.engageEnd("forceClose");
                    }

                    public void onTick(long l2) {
                        String string = IronSourceWebView.this.TAG;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Close Event Timer Tick ");
                        stringBuilder.append(l2);
                        Logger.i(string, stringBuilder.toString());
                    }
                };
                IronSourceWebView.access$802(var24_15, var25_16.start());
                return false;
            }

        });
        this.mUiHandler = this.createMainThreadHandler();
    }

    static /* synthetic */ SSAEnums.ControllerState access$1500(IronSourceWebView ironSourceWebView) {
        return ironSourceWebView.mControllerState;
    }

    static /* synthetic */ int access$400(IronSourceWebView ironSourceWebView) {
        return ironSourceWebView.mHiddenForceCloseWidth;
    }

    static /* synthetic */ int access$500(IronSourceWebView ironSourceWebView) {
        return ironSourceWebView.mHiddenForceCloseHeight;
    }

    static /* synthetic */ String access$600(IronSourceWebView ironSourceWebView) {
        return ironSourceWebView.mHiddenForceCloseLocation;
    }

    static /* synthetic */ Boolean access$6700(IronSourceWebView ironSourceWebView) {
        return ironSourceWebView.isKitkatAndAbove;
    }

    static /* synthetic */ Boolean access$6702(IronSourceWebView ironSourceWebView, Boolean bl) {
        ironSourceWebView.isKitkatAndAbove = bl;
        return bl;
    }

    static /* synthetic */ void access$6800(IronSourceWebView ironSourceWebView, String string) {
        ironSourceWebView.evaluateJavascriptKitKat(string);
    }

    static /* synthetic */ CountDownTimer access$802(IronSourceWebView ironSourceWebView, CountDownTimer countDownTimer) {
        ironSourceWebView.mCloseEventTimer = countDownTimer;
        return countDownTimer;
    }

    static /* synthetic */ boolean access$902(IronSourceWebView ironSourceWebView, boolean bl) {
        ironSourceWebView.mGlobalControllerTimeFinish = bl;
        return bl;
    }

    private void closeWebView() {
        OnWebViewChangeListener onWebViewChangeListener = this.mChangeListener;
        if (onWebViewChangeListener != null) {
            onWebViewChangeListener.onCloseRequested();
        }
    }

    private boolean controllerCommandSupportsQueue(String string) {
        ArrayList arrayList = new ArrayList();
        arrayList.add((Object)"updateConsentInfo");
        return arrayList.contains((Object)string);
    }

    private String createInitProductJSMethod(SSAEnums.ProductType productType, DemandSource demandSource) {
        if (productType != SSAEnums.ProductType.RewardedVideo && productType != SSAEnums.ProductType.Interstitial && productType != SSAEnums.ProductType.OfferWall) {
            if (productType == SSAEnums.ProductType.OfferWallCredits) {
                return this.generateJSToInject("getUserCredits", this.parseToJson("productType", "OfferWall", "applicationKey", this.mOWCreditsAppKey, "applicationUserId", this.mOWCreditsUserId, null, null, null, false), "null", "onGetUserCreditsFail");
            }
            return "";
        }
        HashMap hashMap = new HashMap();
        ProductParameters productParameters = this.mProductParametersCollection.getProductParameters(productType);
        if (productParameters != null) {
            hashMap.put((Object)"applicationKey", (Object)productParameters.appKey);
            hashMap.put((Object)"applicationUserId", (Object)productParameters.userId);
        }
        if (demandSource != null) {
            if (demandSource.getExtraParams() != null) {
                hashMap.putAll(demandSource.getExtraParams());
            }
            hashMap.put((Object)"demandSourceName", (Object)demandSource.getDemandSourceName());
        } else if (this.getExtraParamsByProduct(productType) != null) {
            hashMap.putAll(this.getExtraParamsByProduct(productType));
        }
        String string = this.flatMapToJsonAsString((Map<String, String>)hashMap);
        Constants.JSMethods jSMethods = Constants.JSMethods.getInitMethodByProduct(productType);
        return this.generateJSToInject(jSMethods.methodName, string, jSMethods.successCallbackName, jSMethods.failureCallbackName);
    }

    private SSAObj createLocationObject(String string, Location location) {
        SSAObj sSAObj = new SSAObj(string);
        if (location != null) {
            sSAObj.put("provider", location.getProvider());
            sSAObj.put("latitude", Double.toString((double)location.getLatitude()));
            sSAObj.put("longitude", Double.toString((double)location.getLongitude()));
            sSAObj.put("altitude", Double.toString((double)location.getAltitude()));
            sSAObj.put("time", Long.toString((long)location.getTime()));
            sSAObj.put("accuracy", Float.toString((float)location.getAccuracy()));
            sSAObj.put("bearing", Float.toString((float)location.getBearing()));
            sSAObj.put("speed", Float.toString((float)location.getSpeed()));
            return sSAObj;
        }
        sSAObj.put("error", "location data is not available");
        return sSAObj;
    }

    private String createShowProductJSMethod(SSAEnums.ProductType productType, JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"sessionDepth", (Object)Integer.toString((int)jSONObject.optInt("sessionDepth")));
        String string = jSONObject.optString("demandSourceName");
        DemandSource demandSource = this.mDemandSourceManager.getDemandSourceByName(productType, string);
        if (demandSource != null) {
            if (demandSource.getExtraParams() != null) {
                hashMap.putAll(demandSource.getExtraParams());
            }
            if (!TextUtils.isEmpty((CharSequence)string)) {
                hashMap.put((Object)"demandSourceName", (Object)string);
            }
        } else if (this.getExtraParamsByProduct(productType) != null) {
            hashMap.putAll(this.getExtraParamsByProduct(productType));
        }
        String string2 = this.flatMapToJsonAsString((Map<String, String>)hashMap);
        Constants.JSMethods jSMethods = Constants.JSMethods.getShowMethodByProduct(productType);
        return this.generateJSToInject(jSMethods.methodName, string2, jSMethods.successCallbackName, jSMethods.failureCallbackName);
    }

    @SuppressLint(value={"NewApi"})
    private void evaluateJavascriptKitKat(String string) {
        this.evaluateJavascript(string, null);
    }

    private String extractFailFunctionToCall(String string) {
        return new SSAObj(string).getString(JSON_KEY_FAIL);
    }

    private String extractSuccessFunctionToCall(String string) {
        return new SSAObj(string).getString(JSON_KEY_SUCCESS);
    }

    private String flatMapToJsonAsString(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null) {
            Iterator iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry entry = (Map.Entry)iterator.next();
                try {
                    jSONObject.putOpt((String)entry.getKey(), (Object)SDKUtils.encodeString((String)entry.getValue()));
                }
                catch (JSONException jSONException) {
                    String string = this.TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("flatMapToJsonAsStringfailed ");
                    stringBuilder.append(jSONException.toString());
                    Logger.i(string, stringBuilder.toString());
                }
                iterator.remove();
            }
        }
        return jSONObject.toString();
    }

    private String generateJSToInject(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SSA_CORE.SDKController.runFunction('");
        stringBuilder.append(string);
        stringBuilder.append("');");
        return stringBuilder.toString();
    }

    private String generateJSToInject(String string, String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SSA_CORE.SDKController.runFunction('");
        stringBuilder.append(string);
        stringBuilder.append("?parameters=");
        stringBuilder.append(string2);
        stringBuilder.append("');");
        return stringBuilder.toString();
    }

    private String generateJSToInject(String string, String string2, String string3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SSA_CORE.SDKController.runFunction('");
        stringBuilder.append(string);
        stringBuilder.append("','");
        stringBuilder.append(string2);
        stringBuilder.append("','");
        stringBuilder.append(string3);
        stringBuilder.append("');");
        return stringBuilder.toString();
    }

    private String generateJSToInject(String string, String string2, String string3, String string4) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SSA_CORE.SDKController.runFunction('");
        stringBuilder.append(string);
        stringBuilder.append("?parameters=");
        stringBuilder.append(string2);
        stringBuilder.append("','");
        stringBuilder.append(string3);
        stringBuilder.append("','");
        stringBuilder.append(string4);
        stringBuilder.append("');");
        return stringBuilder.toString();
    }

    private DSAdProductListener getAdProductListenerByProductType(SSAEnums.ProductType productType) {
        if (productType == SSAEnums.ProductType.Interstitial) {
            return this.mDSInterstitialListener;
        }
        if (productType == SSAEnums.ProductType.RewardedVideo) {
            return this.mDSRewardedVideoListener;
        }
        return null;
    }

    private Object[] getApplicationParams(String string, String string2) {
        boolean bl;
        String string3;
        JSONObject jSONObject = new JSONObject();
        boolean bl2 = TextUtils.isEmpty((CharSequence)string);
        String string4 = "";
        Map<String, String> map = null;
        if (!bl2) {
            SSAEnums.ProductType productType = this.getStringProductTypeAsEnum(string);
            if (productType != SSAEnums.ProductType.RewardedVideo && productType != SSAEnums.ProductType.Interstitial) {
                if (productType == SSAEnums.ProductType.OfferWall) {
                    string4 = this.mOWAppKey;
                    string3 = this.mOWUserId;
                    map = this.mOWExtraParameters;
                } else {
                    string3 = string4;
                    map = null;
                }
            } else {
                ProductParameters productParameters = this.mProductParametersCollection.getProductParameters(productType);
                String string5 = productParameters.appKey;
                String string6 = productParameters.userId;
                DemandSource demandSource = this.mDemandSourceManager.getDemandSourceByName(productType, string2);
                map = null;
                if (demandSource != null) {
                    map = demandSource.getExtraParams();
                    map.put((Object)"demandSourceName", (Object)string2);
                }
                string3 = string6;
                string4 = string5;
            }
            try {
                jSONObject.put("productType", (Object)string);
            }
            catch (JSONException jSONException) {
                jSONException.printStackTrace();
                new IronSourceAsyncHttpRequestTask().execute((Object[])new String[]{"https://www.supersonicads.com/mobile/sdk5/log?method=noProductType"});
            }
            bl = false;
        } else {
            string3 = string4;
            bl = true;
        }
        if (!TextUtils.isEmpty((CharSequence)string3)) {
            try {
                jSONObject.put(SDKUtils.encodeString("applicationUserId"), (Object)SDKUtils.encodeString(string3));
            }
            catch (JSONException jSONException) {
                jSONException.printStackTrace();
                new IronSourceAsyncHttpRequestTask().execute((Object[])new String[]{"https://www.supersonicads.com/mobile/sdk5/log?method=encodeAppUserId"});
            }
        } else {
            bl = true;
        }
        if (!TextUtils.isEmpty((CharSequence)string4)) {
            try {
                jSONObject.put(SDKUtils.encodeString("applicationKey"), (Object)SDKUtils.encodeString(string4));
            }
            catch (JSONException jSONException) {
                jSONException.printStackTrace();
                new IronSourceAsyncHttpRequestTask().execute((Object[])new String[]{"https://www.supersonicads.com/mobile/sdk5/log?method=encodeAppKey"});
            }
        } else {
            bl = true;
        }
        if (map != null && !map.isEmpty()) {
            for (Map.Entry entry : map.entrySet()) {
                if (((String)entry.getKey()).equalsIgnoreCase("sdkWebViewCache")) {
                    this.setWebviewCache((String)entry.getValue());
                }
                try {
                    jSONObject.put(SDKUtils.encodeString((String)entry.getKey()), (Object)SDKUtils.encodeString((String)entry.getValue()));
                }
                catch (JSONException jSONException) {
                    jSONException.printStackTrace();
                    new IronSourceAsyncHttpRequestTask().execute((Object[])new String[]{"https://www.supersonicads.com/mobile/sdk5/log?method=extraParametersToJson"});
                }
            }
        }
        Object[] arrobject = new Object[]{jSONObject.toString(), bl};
        return arrobject;
    }

    /*
     * Exception decompiling
     */
    private Object[] getAppsStatus(String var1, String var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
        // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
        // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
        // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:919)
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private Object[] getDeviceParams(Context context) {
        JSONObject jSONObject;
        boolean bl;
        block28 : {
            void var4_31;
            block29 : {
                DeviceProperties deviceProperties;
                block27 : {
                    String string;
                    deviceProperties = DeviceProperties.getInstance(context);
                    jSONObject = new JSONObject();
                    jSONObject.put("appOrientation", (Object)SDKUtils.translateRequestedOrientation(DeviceStatus.getActivityRequestedOrientation(this.getCurrentActivityContext())));
                    String string2 = deviceProperties.getDeviceOem();
                    if (string2 != null) {
                        jSONObject.put(SDKUtils.encodeString("deviceOEM"), (Object)SDKUtils.encodeString(string2));
                    }
                    if ((string = deviceProperties.getDeviceModel()) != null) {
                        jSONObject.put(SDKUtils.encodeString("deviceModel"), (Object)SDKUtils.encodeString(string));
                        bl = false;
                        break block27;
                    }
                    bl = true;
                }
                try {
                    String string10;
                    String string6;
                    String string7;
                    boolean bl2;
                    String string4;
                    String string9;
                    String string3;
                    String string8;
                    String string5;
                    String string;
                    SDKUtils.loadGoogleAdvertiserInfo(context);
                    String string11 = SDKUtils.getAdvertiserId();
                    Boolean bl3 = SDKUtils.isLimitAdTrackingEnabled();
                    boolean bl4 = TextUtils.isEmpty((CharSequence)string11);
                    if (!bl4) {
                        Logger.i(this.TAG, "add AID and LAT");
                        jSONObject.put("isLimitAdTrackingEnabled", (Object)bl3);
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("deviceIds");
                        stringBuilder.append("[");
                        stringBuilder.append("AID");
                        stringBuilder.append("]");
                        jSONObject.put(stringBuilder.toString(), (Object)SDKUtils.encodeString(string11));
                    }
                    if ((string5 = deviceProperties.getDeviceOsType()) != null) {
                        jSONObject.put(SDKUtils.encodeString("deviceOs"), (Object)SDKUtils.encodeString(string5));
                    } else {
                        bl = true;
                    }
                    if ((string4 = deviceProperties.getDeviceOsVersion()) != null) {
                        String string12 = string4.replaceAll("[^0-9/.]", "");
                        jSONObject.put(SDKUtils.encodeString("deviceOSVersion"), (Object)string12);
                    } else {
                        bl = true;
                    }
                    if ((string = String.valueOf((int)deviceProperties.getDeviceApiLevel())) != null) {
                        jSONObject.put(SDKUtils.encodeString("deviceApiLevel"), (Object)string);
                    } else {
                        bl = true;
                    }
                    if ((string7 = DeviceProperties.getSupersonicSdkVersion()) != null) {
                        jSONObject.put(SDKUtils.encodeString("SDKVersion"), (Object)SDKUtils.encodeString(string7));
                    }
                    if (deviceProperties.getDeviceCarrier() != null && deviceProperties.getDeviceCarrier().length() > 0) {
                        jSONObject.put(SDKUtils.encodeString("mobileCarrier"), (Object)SDKUtils.encodeString(deviceProperties.getDeviceCarrier()));
                    }
                    if (!TextUtils.isEmpty((CharSequence)(string8 = ConnectivityService.getConnectionType(context)))) {
                        jSONObject.put(SDKUtils.encodeString("connectionType"), (Object)SDKUtils.encodeString(string8));
                    } else {
                        bl = true;
                    }
                    if (!TextUtils.isEmpty((CharSequence)(string3 = context.getResources().getConfiguration().locale.getLanguage()))) {
                        jSONObject.put(SDKUtils.encodeString("deviceLanguage"), (Object)SDKUtils.encodeString(string3.toUpperCase()));
                    }
                    if (SDKUtils.isExternalStorageAvailable()) {
                        long l2 = DeviceStatus.getAvailableMemorySizeInMegaBytes(this.mCacheDirectory);
                        jSONObject.put(SDKUtils.encodeString("diskFreeSize"), (Object)SDKUtils.encodeString(String.valueOf((long)l2)));
                    } else {
                        bl = true;
                    }
                    if (!(bl2 = TextUtils.isEmpty((CharSequence)(string9 = String.valueOf((int)DeviceStatus.getDeviceWidth()))))) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(SDKUtils.encodeString("deviceScreenSize"));
                        stringBuilder.append("[");
                        stringBuilder.append(SDKUtils.encodeString("width"));
                        stringBuilder.append("]");
                        jSONObject.put(stringBuilder.toString(), (Object)SDKUtils.encodeString(string9));
                    } else {
                        bl = true;
                    }
                    String string13 = String.valueOf((int)DeviceStatus.getDeviceHeight());
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(SDKUtils.encodeString("deviceScreenSize"));
                    stringBuilder.append("[");
                    stringBuilder.append(SDKUtils.encodeString("height"));
                    stringBuilder.append("]");
                    jSONObject.put(stringBuilder.toString(), (Object)SDKUtils.encodeString(string13));
                    String string14 = ApplicationContext.getPackageName(this.getContext());
                    if (!TextUtils.isEmpty((CharSequence)string14)) {
                        jSONObject.put(SDKUtils.encodeString("bundleId"), (Object)SDKUtils.encodeString(string14));
                    }
                    if (!TextUtils.isEmpty((CharSequence)(string10 = String.valueOf((float)DeviceStatus.getDeviceDensity())))) {
                        jSONObject.put(SDKUtils.encodeString("deviceScreenScale"), (Object)SDKUtils.encodeString(string10));
                    }
                    if (!TextUtils.isEmpty((CharSequence)(string6 = String.valueOf((boolean)DeviceStatus.isRootedDevice())))) {
                        jSONObject.put(SDKUtils.encodeString("unLocked"), (Object)SDKUtils.encodeString(string6));
                    }
                    float f2 = DeviceProperties.getInstance(context).getDeviceVolume(context);
                    if (!TextUtils.isEmpty((CharSequence)string6)) {
                        jSONObject.put(SDKUtils.encodeString("deviceVolume"), (double)f2);
                    }
                    Context context2 = this.getCurrentActivityContext();
                    if (Build.VERSION.SDK_INT >= 19 && context2 instanceof Activity) {
                        jSONObject.put(SDKUtils.encodeString("immersiveMode"), DeviceStatus.isImmersiveSupported((Activity)context2));
                    }
                    jSONObject.put(SDKUtils.encodeString("batteryLevel"), DeviceStatus.getBatteryLevel(context2));
                    jSONObject.put(SDKUtils.encodeString("mcc"), ConnectivityService.getNetworkMCC(context2));
                    jSONObject.put(SDKUtils.encodeString("mnc"), ConnectivityService.getNetworkMNC(context2));
                    jSONObject.put(SDKUtils.encodeString("phoneType"), ConnectivityService.getPhoneType(context2));
                    jSONObject.put(SDKUtils.encodeString("simOperator"), (Object)SDKUtils.encodeString(ConnectivityService.getSimOperator(context2)));
                    jSONObject.put(SDKUtils.encodeString("lastUpdateTime"), ApplicationContext.getLastUpdateTime(context2));
                    jSONObject.put(SDKUtils.encodeString("firstInstallTime"), ApplicationContext.getFirstInstallTime(context2));
                    jSONObject.put(SDKUtils.encodeString("appVersion"), (Object)SDKUtils.encodeString(ApplicationContext.getApplicationVersionName(context2)));
                    break block28;
                }
                catch (JSONException jSONException) {
                    break block29;
                }
                catch (JSONException jSONException) {
                    bl = false;
                }
            }
            var4_31.printStackTrace();
            IronSourceAsyncHttpRequestTask ironSourceAsyncHttpRequestTask = new IronSourceAsyncHttpRequestTask();
            Object[] arrobject = new String[1];
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("https://www.supersonicads.com/mobile/sdk5/log?method=");
            stringBuilder.append(var4_31.getStackTrace()[0].getMethodName());
            arrobject[0] = stringBuilder.toString();
            ironSourceAsyncHttpRequestTask.execute(arrobject);
        }
        Object[] arrobject = new Object[]{jSONObject.toString(), bl};
        return arrobject;
    }

    private Map<String, String> getExtraParamsByProduct(SSAEnums.ProductType productType) {
        if (productType == SSAEnums.ProductType.OfferWall) {
            return this.mOWExtraParameters;
        }
        return null;
    }

    private String getRequestParameters(JSONObject jSONObject) {
        Uri uri;
        String string;
        DeviceProperties deviceProperties = DeviceProperties.getInstance(this.getContext());
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = DeviceProperties.getSupersonicSdkVersion();
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            stringBuilder.append("SDKVersion");
            stringBuilder.append("=");
            stringBuilder.append(string2);
            stringBuilder.append("&");
        }
        if (!TextUtils.isEmpty((CharSequence)(string = deviceProperties.getDeviceOsType()))) {
            stringBuilder.append("deviceOs");
            stringBuilder.append("=");
            stringBuilder.append(string);
        }
        if ((uri = Uri.parse((String)SDKUtils.getControllerUrl())) != null) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(uri.getScheme());
            stringBuilder2.append(":");
            String string3 = stringBuilder2.toString();
            String string4 = uri.getHost();
            int n2 = uri.getPort();
            if (n2 != -1) {
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append(string4);
                stringBuilder3.append(":");
                stringBuilder3.append(n2);
                string4 = stringBuilder3.toString();
            }
            stringBuilder.append("&");
            stringBuilder.append("protocol");
            stringBuilder.append("=");
            stringBuilder.append(string3);
            stringBuilder.append("&");
            stringBuilder.append("domain");
            stringBuilder.append("=");
            stringBuilder.append(string4);
            if (jSONObject.keys().hasNext()) {
                try {
                    String string5 = new JSONObject(jSONObject, new String[]{"isSecured", "applicationKey"}).toString();
                    if (!TextUtils.isEmpty((CharSequence)string5)) {
                        stringBuilder.append("&");
                        stringBuilder.append("controllerConfig");
                        stringBuilder.append("=");
                        stringBuilder.append(string5);
                    }
                }
                catch (JSONException jSONException) {
                    jSONException.printStackTrace();
                }
            }
            stringBuilder.append("&");
            stringBuilder.append("debug");
            stringBuilder.append("=");
            stringBuilder.append(this.getDebugMode());
        }
        return stringBuilder.toString();
    }

    private SSAEnums.ProductType getStringProductTypeAsEnum(String string) {
        if (TextUtils.isEmpty((CharSequence)string)) {
            return null;
        }
        if (string.equalsIgnoreCase(SSAEnums.ProductType.Interstitial.toString())) {
            return SSAEnums.ProductType.Interstitial;
        }
        if (string.equalsIgnoreCase(SSAEnums.ProductType.RewardedVideo.toString())) {
            return SSAEnums.ProductType.RewardedVideo;
        }
        if (string.equalsIgnoreCase(SSAEnums.ProductType.OfferWall.toString())) {
            return SSAEnums.ProductType.OfferWall;
        }
        return null;
    }

    private WebView getWebview() {
        return this;
    }

    private void initLayout(Context context) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.mControllerLayout = new FrameLayout(context);
        this.mCustomViewContainer = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        this.mCustomViewContainer.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
        this.mCustomViewContainer.setVisibility(8);
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView((View)this);
        this.mControllerLayout.addView((View)this.mCustomViewContainer, (ViewGroup.LayoutParams)layoutParams);
        this.mControllerLayout.addView((View)frameLayout);
    }

    private void initProduct(String string, String string2, SSAEnums.ProductType productType, DemandSource demandSource, String string3) {
        if (!TextUtils.isEmpty((CharSequence)string2) && !TextUtils.isEmpty((CharSequence)string)) {
            if (this.mControllerState == SSAEnums.ControllerState.Ready) {
                IronSourceSharedPrefHelper.getSupersonicPrefHelper().setApplicationKey(string, productType);
                IronSourceSharedPrefHelper.getSupersonicPrefHelper().setUserID(string2, productType);
                this.injectJavascript(this.createInitProductJSMethod(productType, demandSource));
                return;
            }
            this.setMissProduct(productType, demandSource);
            if (this.mControllerState == SSAEnums.ControllerState.Failed) {
                this.triggerOnControllerInitProductFail(SDKUtils.createErrorMessage(string3, "Initiating Controller"), productType, demandSource.getDemandSourceName());
                return;
            }
            if (this.mGlobalControllerTimeFinish) {
                this.downloadController();
            }
            return;
        }
        this.triggerOnControllerInitProductFail("User id or Application key are missing", productType, demandSource.getDemandSourceName());
    }

    private void injectJavascript(String string) {
        if (TextUtils.isEmpty((CharSequence)string)) {
            return;
        }
        int n2 = this.getDebugMode();
        int n3 = SSAEnums.DebugMode.MODE_0.getValue();
        String string2 = "console.log(\"JS exeption: \" + JSON.stringify(e));";
        if (n2 != n3 && (this.getDebugMode() < SSAEnums.DebugMode.MODE_1.getValue() || this.getDebugMode() > SSAEnums.DebugMode.MODE_3.getValue())) {
            string2 = "empty";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("try{");
        stringBuilder.append(string);
        stringBuilder.append("}catch(e){");
        stringBuilder.append(string2);
        stringBuilder.append("}");
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("javascript:");
        stringBuilder2.append(stringBuilder.toString());
        this.runOnUiThread(new Runnable(this, stringBuilder2.toString(), stringBuilder){
            final /* synthetic */ IronSourceWebView this$0;
            final /* synthetic */ StringBuilder val$scriptBuilder;
            final /* synthetic */ String val$url;
            {
                this.this$0 = ironSourceWebView;
                this.val$url = string;
                this.val$scriptBuilder = stringBuilder;
            }

            /*
             * Unable to fully structure code
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Lifted jumps to return sites
             */
            public void run() {
                Logger.i(IronSourceWebView.access$300(this.this$0), this.val$url);
                if (IronSourceWebView.access$6700(this.this$0) != null) {
                    if (IronSourceWebView.access$6700(this.this$0).booleanValue()) {
                        IronSourceWebView.access$6800(this.this$0, this.val$scriptBuilder.toString());
                        return;
                    }
                    this.this$0.loadUrl(this.val$url);
                    return;
                }
                var7_1 = Build.VERSION.SDK_INT;
                if (var7_1 < 19) ** GOTO lbl46
                {
                    catch (Throwable var1_8) {
                        var2_9 = IronSourceWebView.access$300(this.this$0);
                        var3_10 = new StringBuilder();
                        var3_10.append("injectJavascript: ");
                        var3_10.append(var1_8.toString());
                        Logger.e(var2_9, var3_10.toString());
                        new IronSourceAsyncHttpRequestTask().execute((Object[])new String[]{"https://www.supersonicads.com/mobile/sdk5/log?method=injectJavaScript"});
                        return;
                    }
                }
                try {
                    IronSourceWebView.access$6800(this.this$0, this.val$scriptBuilder.toString());
                    IronSourceWebView.access$6702(this.this$0, true);
                    return;
                }
                catch (Throwable var17_2) {
                    var18_3 = IronSourceWebView.access$300(this.this$0);
                    var19_4 = new StringBuilder();
                    var19_4.append("evaluateJavascrip Exception: SDK version=");
                    var19_4.append(Build.VERSION.SDK_INT);
                    var19_4.append(" ");
                    var19_4.append((Object)var17_2);
                    Logger.e(var18_3, var19_4.toString());
                    this.this$0.loadUrl(this.val$url);
                    IronSourceWebView.access$6702(this.this$0, false);
                    return;
                    catch (java.lang.NoSuchMethodError var9_5) {
                        var10_6 = IronSourceWebView.access$300(this.this$0);
                        var11_7 = new StringBuilder();
                        var11_7.append("evaluateJavascrip NoSuchMethodError: SDK version=");
                        var11_7.append(Build.VERSION.SDK_INT);
                        var11_7.append(" ");
                        var11_7.append((Object)var9_5);
                        Logger.e(var10_6, var11_7.toString());
                        this.this$0.loadUrl(this.val$url);
                        IronSourceWebView.access$6702(this.this$0, false);
                        return;
                    }
lbl46: // 1 sources:
                    this.this$0.loadUrl(this.val$url);
                    IronSourceWebView.access$6702(this.this$0, false);
                    return;
                }
            }
        });
    }

    private void injectJavascript(String string, String string2) {
        if (!this.isControllerStateReady() && this.controllerCommandSupportsQueue(string)) {
            this.mControllerCommandsQueue.add((Object)string2);
            return;
        }
        this.injectJavascript(string2);
    }

    private void invokePendingCommands() {
        while (this.mControllerCommandsQueue.size() > 0) {
            this.injectJavascript((String)this.mControllerCommandsQueue.get(0));
            this.mControllerCommandsQueue.remove(0);
        }
    }

    private boolean isControllerStateReady() {
        return SSAEnums.ControllerState.Ready.equals((Object)this.mControllerState);
    }

    private String parseToJson(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, boolean bl) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty((CharSequence)string) && !TextUtils.isEmpty((CharSequence)string2)) {
                jSONObject.put(string, (Object)SDKUtils.encodeString(string2));
            }
            if (!TextUtils.isEmpty((CharSequence)string3) && !TextUtils.isEmpty((CharSequence)string4)) {
                jSONObject.put(string3, (Object)SDKUtils.encodeString(string4));
            }
            if (!TextUtils.isEmpty((CharSequence)string5) && !TextUtils.isEmpty((CharSequence)string6)) {
                jSONObject.put(string5, (Object)SDKUtils.encodeString(string6));
            }
            if (!TextUtils.isEmpty((CharSequence)string7) && !TextUtils.isEmpty((CharSequence)string8)) {
                jSONObject.put(string7, (Object)SDKUtils.encodeString(string8));
            }
            if (!TextUtils.isEmpty((CharSequence)string9)) {
                jSONObject.put(string9, bl);
            }
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
            IronSourceAsyncHttpRequestTask ironSourceAsyncHttpRequestTask = new IronSourceAsyncHttpRequestTask();
            Object[] arrobject = new String[1];
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("https://www.supersonicads.com/mobile/sdk5/log?method=");
            stringBuilder.append(jSONException.getStackTrace()[0].getMethodName());
            arrobject[0] = stringBuilder.toString();
            ironSourceAsyncHttpRequestTask.execute(arrobject);
        }
        return jSONObject.toString();
    }

    /*
     * Exception decompiling
     */
    private void responseBack(String var1, boolean var2, String var3, String var4) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
        // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
        // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
        // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:919)
        throw new IllegalStateException("Decompilation failed");
    }

    private void sendProductErrorMessage(SSAEnums.ProductType productType, String string) {
        int n2 = 8.$SwitchMap$com$ironsource$sdk$data$SSAEnums$ProductType[productType.ordinal()];
        String string2 = n2 != 1 ? (n2 != 2 ? (n2 != 3 ? (n2 != 4 ? "" : "Show OW Credits") : "Init OW") : "Init IS") : "Init RV";
        this.triggerOnControllerInitProductFail(SDKUtils.createErrorMessage(string2, "Initiating Controller"), productType, string);
    }

    private void setDisplayZoomControls(WebSettings webSettings) {
        if (Build.VERSION.SDK_INT > 11) {
            webSettings.setDisplayZoomControls(false);
        }
    }

    public static void setEXTERNAL_URL(String string) {
        EXTERNAL_URL = string;
    }

    @SuppressLint(value={"NewApi"})
    private void setMediaPlaybackJellyBean(WebSettings webSettings) {
        if (Build.VERSION.SDK_INT >= 17) {
            webSettings.setMediaPlaybackRequiresUserGesture(false);
        }
    }

    @SuppressLint(value={"NewApi"})
    private void setWebDebuggingEnabled() {
        if (Build.VERSION.SDK_INT >= 19) {
            IronSourceWebView.setWebContentsDebuggingEnabled((boolean)true);
        }
    }

    private void setWebDebuggingEnabled(JSONObject jSONObject) {
        if (jSONObject.optBoolean("inspectWebview")) {
            this.setWebDebuggingEnabled();
        }
    }

    private void setWebViewSettings() {
        WebSettings webSettings = this.getSettings();
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        this.setVerticalScrollBarEnabled(false);
        this.setHorizontalScrollBarEnabled(false);
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.getSettings().setAllowFileAccessFromFileURLs(true);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        webSettings.setBuiltInZoomControls(false);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setSupportMultipleWindows(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setGeolocationEnabled(true);
        webSettings.setGeolocationDatabasePath("/data/data/org.itri.html5webview/databases/");
        webSettings.setDomStorageEnabled(true);
        try {
            this.setDisplayZoomControls(webSettings);
            this.setMediaPlaybackJellyBean(webSettings);
            return;
        }
        catch (Throwable throwable) {
            String string = this.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("setWebSettings - ");
            stringBuilder.append(throwable.toString());
            Logger.e(string, stringBuilder.toString());
            return;
        }
    }

    private void setWebviewBackground(String string) {
        String string2 = new SSAObj(string).getString("color");
        int n2 = !"transparent".equalsIgnoreCase(string2) ? Color.parseColor((String)string2) : 0;
        this.setBackgroundColor(n2);
    }

    private void setWebviewCache(String string) {
        if (string.equalsIgnoreCase("0")) {
            this.getSettings().setCacheMode(2);
            return;
        }
        this.getSettings().setCacheMode(-1);
    }

    /*
     * Enabled aggressive block sorting
     */
    private boolean shouldNotifyDeveloper(String string) {
        boolean bl;
        block10 : {
            block12 : {
                block11 : {
                    block9 : {
                        if (TextUtils.isEmpty((CharSequence)string)) {
                            Logger.d(this.TAG, "Trying to trigger a listener - no product was found");
                            return false;
                        }
                        if (!string.equalsIgnoreCase(SSAEnums.ProductType.Interstitial.toString())) break block9;
                        DSInterstitialListener dSInterstitialListener = this.mDSInterstitialListener;
                        bl = false;
                        if (dSInterstitialListener != null) {
                            return true;
                        }
                        break block10;
                    }
                    if (!string.equalsIgnoreCase(SSAEnums.ProductType.RewardedVideo.toString())) break block11;
                    DSRewardedVideoListener dSRewardedVideoListener = this.mDSRewardedVideoListener;
                    bl = false;
                    if (dSRewardedVideoListener != null) {
                        return true;
                    }
                    break block10;
                }
                if (string.equalsIgnoreCase(SSAEnums.ProductType.OfferWall.toString())) break block12;
                boolean bl2 = string.equalsIgnoreCase(SSAEnums.ProductType.OfferWallCredits.toString());
                bl = false;
                if (!bl2) break block10;
            }
            OnOfferWallListener onOfferWallListener = this.mOnOfferWallListener;
            bl = false;
            if (onOfferWallListener != null) {
                return true;
            }
        }
        if (bl) return bl;
        String string2 = this.TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Trying to trigger a listener - no listener was found for product ");
        stringBuilder.append(string);
        Logger.d(string2, stringBuilder.toString());
        return bl;
    }

    private void toastingErrMsg(String string, String string2) {
        String string3 = new SSAObj(string2).getString("errMsg");
        if (!TextUtils.isEmpty((CharSequence)string3)) {
            this.runOnUiThread(new Runnable(this, string, string3){
                final /* synthetic */ IronSourceWebView this$0;
                final /* synthetic */ String val$message;
                final /* synthetic */ String val$methodName;
                {
                    this.this$0 = ironSourceWebView;
                    this.val$methodName = string;
                    this.val$message = string2;
                }

                public void run() {
                    if (this.this$0.getDebugMode() == SSAEnums.DebugMode.MODE_3.getValue()) {
                        Context context = this.this$0.getCurrentActivityContext();
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(this.val$methodName);
                        stringBuilder.append(" : ");
                        stringBuilder.append(this.val$message);
                        android.widget.Toast.makeText((Context)context, (CharSequence)stringBuilder.toString(), (int)1).show();
                    }
                }
            });
        }
    }

    private void triggerOnControllerInitProductFail(String string, SSAEnums.ProductType productType, String string2) {
        if (this.shouldNotifyDeveloper(productType.toString())) {
            this.runOnUiThread(new Runnable(this, productType, string2, string){
                final /* synthetic */ IronSourceWebView this$0;
                final /* synthetic */ String val$demandSourceName;
                final /* synthetic */ String val$message;
                final /* synthetic */ SSAEnums.ProductType val$type;
                {
                    this.this$0 = ironSourceWebView;
                    this.val$type = productType;
                    this.val$demandSourceName = string;
                    this.val$message = string2;
                }

                public void run() {
                    if (SSAEnums.ProductType.RewardedVideo != this.val$type && SSAEnums.ProductType.Interstitial != this.val$type) {
                        if (SSAEnums.ProductType.OfferWall == this.val$type) {
                            IronSourceWebView.access$3000(this.this$0).onOfferwallInitFail(this.val$message);
                            return;
                        }
                        if (SSAEnums.ProductType.OfferWallCredits == this.val$type) {
                            IronSourceWebView.access$3000(this.this$0).onGetOWCreditsFailed(this.val$message);
                            return;
                        }
                    } else {
                        if (TextUtils.isEmpty((CharSequence)this.val$demandSourceName)) {
                            return;
                        }
                        DSAdProductListener dSAdProductListener = IronSourceWebView.access$5700(this.this$0, this.val$type);
                        String string = IronSourceWebView.access$300(this.this$0);
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("onAdProductInitFailed (message:");
                        stringBuilder.append(this.val$message);
                        stringBuilder.append(")(");
                        stringBuilder.append((Object)((Object)this.val$type));
                        stringBuilder.append(")");
                        Log.d((String)string, (String)stringBuilder.toString());
                        if (dSAdProductListener != null) {
                            dSAdProductListener.onAdProductInitFailed(this.val$type, this.val$demandSourceName, this.val$message);
                        }
                    }
                }
            });
        }
    }

    public void addMoatJSInterface(MOATJSAdapter mOATJSAdapter) {
        this.mMoatJsAdapter = mOATJSAdapter;
    }

    public void addPermissionsJSInterface(PermissionsJSAdapter permissionsJSAdapter) {
        this.mPermissionsJsAdapter = permissionsJSAdapter;
    }

    public void assetCached(String string, String string2) {
        this.injectJavascript(this.generateJSToInject("assetCached", this.parseToJson("file", string, "path", string2, null, null, null, null, null, false)));
    }

    public void assetCachedFailed(String string, String string2, String string3) {
        this.injectJavascript(this.generateJSToInject("assetCachedFailed", this.parseToJson("file", string, "path", string2, "errMsg", string3, null, null, null, false)));
    }

    JSInterface createJSInterface(Context context) {
        return new Object(context){
            volatile int udiaResults = 0;

            private void callJavaScriptFunction(String string, String string2) {
                if (!TextUtils.isEmpty((CharSequence)string)) {
                    String string3 = IronSourceWebView.this.generateJSToInject(string, string2);
                    IronSourceWebView.this.injectJavascript(string3);
                }
            }

            private void injectGetUDIA(String string, JSONArray jSONArray) {
                if (!TextUtils.isEmpty((CharSequence)string)) {
                    String string2 = IronSourceWebView.this.generateJSToInject(string, jSONArray.toString(), "onGetUDIASuccess", "onGetUDIAFail");
                    IronSourceWebView.this.injectJavascript(string2);
                }
            }

            private void sendResults(String string, JSONArray jSONArray) {
                String string2 = IronSourceWebView.this.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("sendResults: ");
                stringBuilder.append(this.udiaResults);
                Logger.i(string2, stringBuilder.toString());
                if (this.udiaResults <= 0) {
                    this.injectGetUDIA(string, jSONArray);
                }
            }

            private void setInterstitialAvailability(String string, boolean bl) {
                DemandSource demandSource = IronSourceWebView.this.mDemandSourceManager.getDemandSourceByName(SSAEnums.ProductType.Interstitial, string);
                if (demandSource != null) {
                    demandSource.setAvailabilityState(bl);
                }
                if (IronSourceWebView.this.shouldNotifyDeveloper(SSAEnums.ProductType.Interstitial.toString())) {
                    IronSourceWebView ironSourceWebView = IronSourceWebView.this;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(bl);
                    stringBuilder.append(" with demand ");
                    stringBuilder.append(string);
                    ironSourceWebView.toastingErrMsg("onInterstitialAvailability", String.valueOf((Object)stringBuilder.toString()));
                }
            }

            @JavascriptInterface
            public void adClicked(String string) {
                String string2 = IronSourceWebView.this.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("adClicked(");
                stringBuilder.append(string);
                stringBuilder.append(")");
                Logger.i(string2, stringBuilder.toString());
                SSAObj sSAObj = new SSAObj(string);
                String string3 = sSAObj.getString("productType");
                final String string4 = sSAObj.getString("demandSourceName");
                if (TextUtils.isEmpty((CharSequence)string4)) {
                    return;
                }
                final SSAEnums.ProductType productType = IronSourceWebView.this.getStringProductTypeAsEnum(string3);
                final DSAdProductListener dSAdProductListener = IronSourceWebView.this.getAdProductListenerByProductType(productType);
                if (productType != null && dSAdProductListener != null) {
                    IronSourceWebView.this.runOnUiThread(new Runnable(){

                        public void run() {
                            dSAdProductListener.onAdProductClick(productType, string4);
                        }
                    });
                }
            }

            /*
             * Unable to fully structure code
             * Enabled aggressive block sorting
             * Lifted jumps to return sites
             */
            @JavascriptInterface
            public void adCredited(final String var1_1) {
                var2_2 = IronSourceWebView.access$5400(IronSourceWebView.this);
                var3_3 = new StringBuilder();
                var3_3.append("adCredited(");
                var3_3.append(var1_1);
                var3_3.append(")");
                Log.d((String)var2_2, (String)var3_3.toString());
                var8_4 = new SSAObj(var1_1);
                var9_5 = var8_4.getString("credits");
                var10_6 = false;
                var11_7 = var9_5 != null ? Integer.parseInt((String)var9_5) : 0;
                var12_8 = var8_4.getString("total");
                var13_9 = var12_8 != null ? Integer.parseInt((String)var12_8) : 0;
                var14_10 = var8_4.getString("demandSourceName");
                var15_11 = var8_4.getString("productType");
                if (var8_4.getBoolean("externalPoll")) {
                    var16_12 = IronSourceWebView.access$3200(IronSourceWebView.this);
                    var17_13 = IronSourceWebView.access$3300(IronSourceWebView.this);
                } else {
                    var16_12 = IronSourceWebView.access$2700(IronSourceWebView.this);
                    var17_13 = IronSourceWebView.access$2800(IronSourceWebView.this);
                }
                var18_14 = var16_12;
                var19_15 = var17_13;
                var20_16 = var15_11.equalsIgnoreCase(SSAEnums.ProductType.OfferWall.toString());
                var21_17 = null;
                if (!var20_16) ** GOTO lbl43
                if (!(var8_4.isNull("signature") || var8_4.isNull("timestamp") || var8_4.isNull("totalCreditsFlag"))) {
                    var26_18 = var8_4.getString("signature");
                    var27_19 = new StringBuilder();
                    var27_19.append(var12_8);
                    var27_19.append(var18_14);
                    var27_19.append(var19_15);
                    if (var26_18.equalsIgnoreCase(SDKUtils.getMD5(var27_19.toString()))) {
                        var10_6 = true;
                    } else {
                        IronSourceWebView.access$4500(IronSourceWebView.this, var1_1, false, "Controller signature is not equal to SDK signature", null);
                    }
                    var31_20 = var8_4.getBoolean("totalCreditsFlag");
                    var21_17 = var8_4.getString("timestamp");
                    var22_21 = var31_20;
                    var23_22 = var10_6;
                } else {
                    IronSourceWebView.access$4500(IronSourceWebView.this, var1_1, false, "One of the keys are missing: signature/timestamp/totalCreditsFlag", null);
                    return;
lbl43: // 1 sources:
                    var22_21 = false;
                    var23_22 = false;
                }
                if (IronSourceWebView.access$4700(IronSourceWebView.this, var15_11) == false) return;
                var24_23 = IronSourceWebView.this;
                var25_24 = new Runnable(){

                    public void run() {
                        if (var15_11.equalsIgnoreCase(SSAEnums.ProductType.RewardedVideo.toString())) {
                            IronSourceWebView.this.mDSRewardedVideoListener.onRVAdCredited(var14_10, var11_7);
                            return;
                        }
                        if (var15_11.equalsIgnoreCase(SSAEnums.ProductType.OfferWall.toString()) && var23_22 && IronSourceWebView.this.mOnOfferWallListener.onOWAdCredited(var11_7, var13_9, var22_21) && !TextUtils.isEmpty((CharSequence)var21_17)) {
                            if (IronSourceSharedPrefHelper.getSupersonicPrefHelper().setLatestCompeltionsTime(var21_17, var18_14, var19_15)) {
                                IronSourceWebView.this.responseBack(var1_1, true, null, null);
                                return;
                            }
                            IronSourceWebView.this.responseBack(var1_1, false, "Time Stamp could not be stored", null);
                        }
                    }
                };
                var24_23.runOnUiThread(var25_24);
            }

            @JavascriptInterface
            public void adUnitsReady(String string) {
                String string2 = IronSourceWebView.this.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("adUnitsReady(");
                stringBuilder.append(string);
                stringBuilder.append(")");
                Logger.i(string2, stringBuilder.toString());
                final String string3 = new SSAObj(string).getString("demandSourceName");
                final AdUnitsReady adUnitsReady = new AdUnitsReady(string);
                if (!adUnitsReady.isNumOfAdUnitsExist()) {
                    IronSourceWebView.this.responseBack(string, false, "Num Of Ad Units Do Not Exist", null);
                    return;
                }
                IronSourceWebView.this.responseBack(string, true, null, null);
                final String string4 = adUnitsReady.getProductType();
                if (IronSourceWebView.this.shouldNotifyDeveloper(string4)) {
                    IronSourceWebView.this.runOnUiThread(new Runnable(){

                        public void run() {
                            int n2 = Integer.parseInt((String)adUnitsReady.getNumOfAdUnits());
                            if (string4.equalsIgnoreCase(SSAEnums.ProductType.RewardedVideo.toString())) {
                                if (n2 > 0) {
                                    Log.d((String)IronSourceWebView.this.TAG, (String)"onRVInitSuccess()");
                                    IronSourceWebView.this.mDSRewardedVideoListener.onAdProductInitSuccess(SSAEnums.ProductType.RewardedVideo, string3, adUnitsReady);
                                    return;
                                }
                                IronSourceWebView.this.mDSRewardedVideoListener.onRVNoMoreOffers(string3);
                            }
                        }
                    });
                }
            }

            @JavascriptInterface
            public String addTesterParametersToConfig(String string, String string2) throws JSONException {
                JSONObject jSONObject = new JSONObject(string);
                JSONObject jSONObject2 = new JSONObject(string2);
                jSONObject.putOpt("testerABGroup", jSONObject2.get("testerABGroup"));
                jSONObject.putOpt("testFriendlyName", jSONObject2.get("testFriendlyName"));
                return jSONObject.toString();
            }

            @JavascriptInterface
            public void alert(String string) {
            }

            @JavascriptInterface
            public boolean areTesterParametersValid(String string) {
                if (!TextUtils.isEmpty((CharSequence)string) && !string.contains((CharSequence)"-1")) {
                    try {
                        boolean bl;
                        JSONObject jSONObject = new JSONObject(string);
                        if (!jSONObject.getString("testerABGroup").isEmpty() && !(bl = jSONObject.getString("testFriendlyName").isEmpty())) {
                            return true;
                        }
                    }
                    catch (JSONException jSONException) {
                        jSONException.printStackTrace();
                    }
                }
                return false;
            }

            @JavascriptInterface
            public void checkInstalledApps(String string) {
                String string2;
                String string3;
                block6 : {
                    block5 : {
                        block4 : {
                            String string4 = IronSourceWebView.this.TAG;
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("checkInstalledApps(");
                            stringBuilder.append(string);
                            stringBuilder.append(")");
                            Logger.i(string4, stringBuilder.toString());
                            string3 = IronSourceWebView.this.extractSuccessFunctionToCall(string);
                            String string5 = IronSourceWebView.this.extractFailFunctionToCall(string);
                            SSAObj sSAObj = new SSAObj(string);
                            String string6 = sSAObj.getString(IronSourceWebView.APP_IDS);
                            String string7 = sSAObj.getString(IronSourceWebView.REQUEST_ID);
                            Object[] arrobject = IronSourceWebView.this.getAppsStatus(string6, string7);
                            string2 = (String)arrobject[0];
                            if (!((Boolean)arrobject[1]).booleanValue()) break block4;
                            if (TextUtils.isEmpty((CharSequence)string5)) break block5;
                            string3 = string5;
                            break block6;
                        }
                        if (!TextUtils.isEmpty((CharSequence)string3)) break block6;
                    }
                    string3 = null;
                }
                if (!TextUtils.isEmpty((CharSequence)string3)) {
                    String string8 = IronSourceWebView.this.generateJSToInject(string3, string2, "onCheckInstalledAppsSuccess", "onCheckInstalledAppsFail");
                    IronSourceWebView.this.injectJavascript(string8);
                }
            }

            @JavascriptInterface
            public void createCalendarEvent(String string) {
                String string2 = IronSourceWebView.this.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("createCalendarEvent(");
                stringBuilder.append(string);
                stringBuilder.append(")");
                Logger.i(string2, stringBuilder.toString());
            }

            @JavascriptInterface
            public void deleteFile(String string) {
                String string2 = IronSourceWebView.this.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("deleteFile(");
                stringBuilder.append(string);
                stringBuilder.append(")");
                Logger.i(string2, stringBuilder.toString());
                SSAFile sSAFile = new SSAFile(string);
                if (!IronSourceStorageUtils.isPathExist(IronSourceWebView.this.mCacheDirectory, sSAFile.getPath())) {
                    IronSourceWebView.this.responseBack(string, false, "File not exist", "1");
                    return;
                }
                boolean bl = IronSourceStorageUtils.deleteFile(IronSourceWebView.this.mCacheDirectory, sSAFile.getPath(), sSAFile.getFile());
                IronSourceWebView.this.responseBack(string, bl, null, null);
            }

            @JavascriptInterface
            public void deleteFolder(String string) {
                String string2 = IronSourceWebView.this.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("deleteFolder(");
                stringBuilder.append(string);
                stringBuilder.append(")");
                Logger.i(string2, stringBuilder.toString());
                SSAFile sSAFile = new SSAFile(string);
                if (!IronSourceStorageUtils.isPathExist(IronSourceWebView.this.mCacheDirectory, sSAFile.getPath())) {
                    IronSourceWebView.this.responseBack(string, false, "Folder not exist", "1");
                    return;
                }
                boolean bl = IronSourceStorageUtils.deleteFolder(IronSourceWebView.this.mCacheDirectory, sSAFile.getPath());
                IronSourceWebView.this.responseBack(string, bl, null, null);
            }

            @JavascriptInterface
            public void displayWebView(String string) {
                String string2 = IronSourceWebView.this.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("displayWebView(");
                stringBuilder.append(string);
                stringBuilder.append(")");
                Logger.i(string2, stringBuilder.toString());
                IronSourceWebView.this.responseBack(string, true, null, null);
                SSAObj sSAObj = new SSAObj(string);
                boolean bl = (Boolean)sSAObj.get("display");
                String string3 = sSAObj.getString("productType");
                boolean bl2 = sSAObj.getBoolean("standaloneView");
                String string4 = sSAObj.getString("demandSourceName");
                if (bl) {
                    IronSourceWebView.this.mIsImmersive = sSAObj.getBoolean("immersive");
                    IronSourceWebView.this.mIsActivityThemeTranslucent = sSAObj.getBoolean("activityThemeTranslucent");
                    if (IronSourceWebView.this.getState() != State.Display) {
                        boolean bl3;
                        IronSourceWebView.this.setState(State.Display);
                        String string5 = IronSourceWebView.this.TAG;
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("State: ");
                        stringBuilder2.append((Object)IronSourceWebView.this.mState);
                        Logger.i(string5, stringBuilder2.toString());
                        Context context = IronSourceWebView.this.getCurrentActivityContext();
                        String string6 = IronSourceWebView.this.getOrientationState();
                        int n2 = DeviceStatus.getApplicationRotation(context);
                        if (bl2) {
                            ControllerView controllerView = new ControllerView(context);
                            controllerView.addView((View)IronSourceWebView.this.mControllerLayout);
                            controllerView.showInterstitial(IronSourceWebView.this);
                            return;
                        }
                        Intent intent = IronSourceWebView.this.mIsActivityThemeTranslucent ? new Intent(context, InterstitialActivity.class) : new Intent(context, ControllerActivity.class);
                        if (SSAEnums.ProductType.RewardedVideo.toString().equalsIgnoreCase(string3)) {
                            if ("application".equals((Object)string6)) {
                                string6 = SDKUtils.translateRequestedOrientation(DeviceStatus.getActivityRequestedOrientation(IronSourceWebView.this.getCurrentActivityContext()));
                            }
                            intent.putExtra("productType", SSAEnums.ProductType.RewardedVideo.toString());
                            IronSourceWebView.this.mSavedState.adOpened(SSAEnums.ProductType.RewardedVideo.ordinal());
                            IronSourceWebView.this.mSavedState.setDisplayedDemandSourceName(string4);
                            bl3 = true;
                        } else if (SSAEnums.ProductType.OfferWall.toString().equalsIgnoreCase(string3)) {
                            intent.putExtra("productType", SSAEnums.ProductType.OfferWall.toString());
                            IronSourceWebView.this.mSavedState.adOpened(SSAEnums.ProductType.OfferWall.ordinal());
                            bl3 = false;
                        } else {
                            boolean bl4 = SSAEnums.ProductType.Interstitial.toString().equalsIgnoreCase(string3);
                            bl3 = false;
                            if (bl4) {
                                boolean bl5 = "application".equals((Object)string6);
                                bl3 = false;
                                if (bl5) {
                                    string6 = SDKUtils.translateRequestedOrientation(DeviceStatus.getActivityRequestedOrientation(IronSourceWebView.this.getCurrentActivityContext()));
                                }
                            }
                        }
                        if (bl3 && IronSourceWebView.this.shouldNotifyDeveloper(SSAEnums.ProductType.RewardedVideo.toString())) {
                            IronSourceWebView.this.mDSRewardedVideoListener.onAdProductOpen(SSAEnums.ProductType.RewardedVideo, string4);
                        }
                        intent.setFlags(536870912);
                        intent.putExtra("immersive", IronSourceWebView.this.mIsImmersive);
                        intent.putExtra("orientation_set_flag", string6);
                        intent.putExtra("rotation_set_flag", n2);
                        context.startActivity(intent);
                        return;
                    }
                    String string7 = IronSourceWebView.this.TAG;
                    StringBuilder stringBuilder3 = new StringBuilder();
                    stringBuilder3.append("State: ");
                    stringBuilder3.append((Object)IronSourceWebView.this.mState);
                    Logger.i(string7, stringBuilder3.toString());
                    return;
                }
                IronSourceWebView.this.setState(State.Gone);
                IronSourceWebView.this.closeWebView();
            }

            @JavascriptInterface
            public void getApplicationInfo(String string) {
                String string2;
                String string3;
                block6 : {
                    block5 : {
                        block4 : {
                            String string4 = IronSourceWebView.this.TAG;
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("getApplicationInfo(");
                            stringBuilder.append(string);
                            stringBuilder.append(")");
                            Logger.i(string4, stringBuilder.toString());
                            string3 = IronSourceWebView.this.extractSuccessFunctionToCall(string);
                            String string5 = IronSourceWebView.this.extractFailFunctionToCall(string);
                            SSAObj sSAObj = new SSAObj(string);
                            String string6 = sSAObj.getString("productType");
                            String string7 = sSAObj.getString("demandSourceName");
                            new Object[2];
                            Object[] arrobject = IronSourceWebView.this.getApplicationParams(string6, string7);
                            string2 = (String)arrobject[0];
                            if (!((Boolean)arrobject[1]).booleanValue()) break block4;
                            if (TextUtils.isEmpty((CharSequence)string5)) break block5;
                            string3 = string5;
                            break block6;
                        }
                        if (!TextUtils.isEmpty((CharSequence)string3)) break block6;
                    }
                    string3 = null;
                }
                if (!TextUtils.isEmpty((CharSequence)string3)) {
                    String string8 = IronSourceWebView.this.generateJSToInject(string3, string2, "onGetApplicationInfoSuccess", "onGetApplicationInfoFail");
                    IronSourceWebView.this.injectJavascript(string8);
                }
            }

            @JavascriptInterface
            public void getAppsInstallTime(String string) {
                String string2;
                String string3;
                block9 : {
                    String string4;
                    block10 : {
                        block8 : {
                            boolean bl;
                            SSAObj sSAObj = new SSAObj(string);
                            try {
                                String string5 = sSAObj.getString("systemApps");
                                string2 = DeviceStatus.getAppsInstallTime(IronSourceWebView.this.getContext(), Boolean.parseBoolean((String)string5)).toString();
                                bl = false;
                            }
                            catch (Exception exception) {
                                String string6 = IronSourceWebView.this.TAG;
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("getAppsInstallTime failed(");
                                stringBuilder.append(exception.getLocalizedMessage());
                                stringBuilder.append(")");
                                Logger.i(string6, stringBuilder.toString());
                                string2 = exception.getLocalizedMessage();
                                bl = true;
                            }
                            if (!bl) break block8;
                            string4 = IronSourceWebView.this.extractFailFunctionToCall(string);
                            boolean bl2 = TextUtils.isEmpty((CharSequence)string4);
                            string3 = null;
                            if (bl2) break block9;
                            break block10;
                        }
                        string4 = IronSourceWebView.this.extractSuccessFunctionToCall(string);
                        boolean bl = TextUtils.isEmpty((CharSequence)string4);
                        string3 = null;
                        if (bl) break block9;
                    }
                    string3 = string4;
                }
                if (!TextUtils.isEmpty(string3)) {
                    try {
                        string2 = URLDecoder.decode((String)string2, (String)Charset.defaultCharset().name());
                    }
                    catch (UnsupportedEncodingException unsupportedEncodingException) {
                        unsupportedEncodingException.printStackTrace();
                    }
                    String string7 = IronSourceWebView.this.generateJSToInject(string3, string2);
                    IronSourceWebView.this.injectJavascript(string7);
                }
            }

            @JavascriptInterface
            public void getCachedFilesMap(String string) {
                String string2 = IronSourceWebView.this.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("getCachedFilesMap(");
                stringBuilder.append(string);
                stringBuilder.append(")");
                Logger.i(string2, stringBuilder.toString());
                String string3 = IronSourceWebView.this.extractSuccessFunctionToCall(string);
                if (!TextUtils.isEmpty((CharSequence)string3)) {
                    SSAObj sSAObj = new SSAObj(string);
                    if (!sSAObj.containsKey("path")) {
                        IronSourceWebView.this.responseBack(string, false, "path key does not exist", null);
                        return;
                    }
                    String string4 = (String)sSAObj.get("path");
                    if (!IronSourceStorageUtils.isPathExist(IronSourceWebView.this.mCacheDirectory, string4)) {
                        IronSourceWebView.this.responseBack(string, false, "path file does not exist on disk", null);
                        return;
                    }
                    String string5 = IronSourceStorageUtils.getCachedFilesMap(IronSourceWebView.this.mCacheDirectory, string4);
                    String string6 = IronSourceWebView.this.generateJSToInject(string3, string5, "onGetCachedFilesMapSuccess", "onGetCachedFilesMapFail");
                    IronSourceWebView.this.injectJavascript(string6);
                }
            }

            /*
             * Exception decompiling
             */
            @JavascriptInterface
            public void getControllerConfig(String var1) {
                // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl54 : ALOAD_0 : trying to set 1 previously set to 0
                // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
                // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
                // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
                // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
                // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
                // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
                // org.benf.cfr.reader.entities.g.p(Method.java:396)
                // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
                // org.benf.cfr.reader.entities.d.c(ClassFile.java:773)
                // org.benf.cfr.reader.entities.d.e(ClassFile.java:870)
                // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
                // org.benf.cfr.reader.b.a(Driver.java:128)
                // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
                // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
                // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
                // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
                // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
                // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
                // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
                // java.lang.Thread.run(Thread.java:919)
                throw new IllegalStateException("Decompilation failed");
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @JavascriptInterface
            public void getDemandSourceState(String string) {
                String string2 = IronSourceWebView.this.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("getMediationState(");
                stringBuilder.append(string);
                stringBuilder.append(")");
                Logger.i(string2, stringBuilder.toString());
                SSAObj sSAObj = new SSAObj(string);
                String string3 = sSAObj.getString("demandSourceName");
                String string4 = sSAObj.getString("productType");
                if (string4 == null) return;
                if (string3 == null) return;
                try {
                    String string5;
                    SSAEnums.ProductType productType = SDKUtils.getProductType(string4);
                    if (productType == null) return;
                    DemandSource demandSource = IronSourceWebView.this.mDemandSourceManager.getDemandSourceByName(productType, string3);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("productType", (Object)string4);
                    jSONObject.put("demandSourceName", (Object)string3);
                    if (demandSource != null && !demandSource.isMediationState(-1)) {
                        string5 = IronSourceWebView.this.extractSuccessFunctionToCall(string);
                        jSONObject.put("state", demandSource.getMediationState());
                    } else {
                        string5 = IronSourceWebView.this.extractFailFunctionToCall(string);
                    }
                    this.callJavaScriptFunction(string5, jSONObject.toString());
                    return;
                }
                catch (Exception exception) {
                    IronSourceWebView.this.responseBack(string, false, exception.getMessage(), null);
                    exception.printStackTrace();
                }
            }

            @JavascriptInterface
            public void getDeviceLocation(String string) {
                String string2 = IronSourceWebView.this.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("getDeviceLocation(");
                stringBuilder.append(string);
                stringBuilder.append(")");
                Logger.i(string2, stringBuilder.toString());
                try {
                    SSAObj sSAObj = IronSourceWebView.this.createLocationObject(string, LocationService.getLastLocation(IronSourceWebView.this.getContext()));
                    IronSourceWebView.this.responseBack(sSAObj.toString(), true, null, null);
                    return;
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                    return;
                }
            }

            @JavascriptInterface
            public void getDevicePreciseLocation(String string) {
                String string2 = IronSourceWebView.this.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("getDevicePreciseLocation(");
                stringBuilder.append(string);
                stringBuilder.append(")");
                Logger.i(string2, stringBuilder.toString());
                try {
                    LocationService.getPreciseLocation(IronSourceWebView.this.getContext(), new LocationService.ISLocationListener(this, string){
                        final /* synthetic */ JSInterface this$1;
                        final /* synthetic */ String val$value;
                        {
                            this.this$1 = jSInterface;
                            this.val$value = string;
                        }

                        public void onLocationChanged(Location location) {
                            SSAObj sSAObj = IronSourceWebView.access$6600(this.this$1.IronSourceWebView.this, this.val$value, location);
                            IronSourceWebView.access$4500(this.this$1.IronSourceWebView.this, sSAObj.toString(), true, null, null);
                        }
                    });
                    return;
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                    return;
                }
            }

            @JavascriptInterface
            public void getDeviceStatus(String string) {
                String string2;
                String string3;
                block6 : {
                    block5 : {
                        block4 : {
                            String string4 = IronSourceWebView.this.TAG;
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("getDeviceStatus(");
                            stringBuilder.append(string);
                            stringBuilder.append(")");
                            Logger.i(string4, stringBuilder.toString());
                            string3 = IronSourceWebView.this.extractSuccessFunctionToCall(string);
                            String string5 = IronSourceWebView.this.extractFailFunctionToCall(string);
                            new Object[2];
                            IronSourceWebView ironSourceWebView = IronSourceWebView.this;
                            Object[] arrobject = ironSourceWebView.getDeviceParams(ironSourceWebView.getContext());
                            string2 = (String)arrobject[0];
                            if (!((Boolean)arrobject[1]).booleanValue()) break block4;
                            if (TextUtils.isEmpty((CharSequence)string5)) break block5;
                            string3 = string5;
                            break block6;
                        }
                        if (!TextUtils.isEmpty((CharSequence)string3)) break block6;
                    }
                    string3 = null;
                }
                if (!TextUtils.isEmpty((CharSequence)string3)) {
                    String string6 = IronSourceWebView.this.generateJSToInject(string3, string2, "onGetDeviceStatusSuccess", "onGetDeviceStatusFail");
                    IronSourceWebView.this.injectJavascript(string6);
                }
            }

            @JavascriptInterface
            public void getDeviceVolume(String string) {
                String string2 = IronSourceWebView.this.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("getDeviceVolume(");
                stringBuilder.append(string);
                stringBuilder.append(")");
                Logger.i(string2, stringBuilder.toString());
                try {
                    float f2 = DeviceProperties.getInstance(IronSourceWebView.this.getCurrentActivityContext()).getDeviceVolume(IronSourceWebView.this.getCurrentActivityContext());
                    SSAObj sSAObj = new SSAObj(string);
                    sSAObj.put("deviceVolume", String.valueOf((float)f2));
                    IronSourceWebView.this.responseBack(sSAObj.toString(), true, null, null);
                    return;
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                    return;
                }
            }

            @JavascriptInterface
            public void getOrientation(String string) {
                String string2 = IronSourceWebView.this.extractSuccessFunctionToCall(string);
                String string3 = SDKUtils.getOrientation(IronSourceWebView.this.getCurrentActivityContext()).toString();
                if (!TextUtils.isEmpty((CharSequence)string2)) {
                    String string4 = IronSourceWebView.this.generateJSToInject(string2, string3, "onGetOrientationSuccess", "onGetOrientationFail");
                    IronSourceWebView.this.injectJavascript(string4);
                }
            }

            /*
             * Exception decompiling
             */
            @JavascriptInterface
            public void getUDIA(String var1) {
                // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
                // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
                // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
                // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
                // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
                // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
                // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
                // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
                // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
                // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
                // org.benf.cfr.reader.entities.g.p(Method.java:396)
                // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
                // org.benf.cfr.reader.entities.d.c(ClassFile.java:773)
                // org.benf.cfr.reader.entities.d.e(ClassFile.java:870)
                // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
                // org.benf.cfr.reader.b.a(Driver.java:128)
                // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
                // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
                // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
                // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
                // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
                // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
                // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
                // java.lang.Thread.run(Thread.java:919)
                throw new IllegalStateException("Decompilation failed");
            }

            @JavascriptInterface
            public void getUserData(String string) {
                String string2 = IronSourceWebView.this.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("getUserData(");
                stringBuilder.append(string);
                stringBuilder.append(")");
                Logger.i(string2, stringBuilder.toString());
                SSAObj sSAObj = new SSAObj(string);
                if (!sSAObj.containsKey("key")) {
                    IronSourceWebView.this.responseBack(string, false, "key does not exist", null);
                    return;
                }
                String string3 = IronSourceWebView.this.extractSuccessFunctionToCall(string);
                String string4 = sSAObj.getString("key");
                String string5 = IronSourceSharedPrefHelper.getSupersonicPrefHelper().getUserData(string4);
                String string6 = IronSourceWebView.this.parseToJson(string4, string5, null, null, null, null, null, null, null, false);
                String string7 = IronSourceWebView.this.generateJSToInject(string3, string6);
                IronSourceWebView.this.injectJavascript(string7);
            }

            @JavascriptInterface
            public void getUserUniqueId(String string) {
                String string2 = IronSourceWebView.this.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("getUserUniqueId(");
                stringBuilder.append(string);
                stringBuilder.append(")");
                Logger.i(string2, stringBuilder.toString());
                SSAObj sSAObj = new SSAObj(string);
                if (!sSAObj.containsKey("productType")) {
                    IronSourceWebView.this.responseBack(string, false, "productType does not exist", null);
                    return;
                }
                String string3 = IronSourceWebView.this.extractSuccessFunctionToCall(string);
                if (!TextUtils.isEmpty((CharSequence)string3)) {
                    String string4 = sSAObj.getString("productType");
                    String string5 = IronSourceSharedPrefHelper.getSupersonicPrefHelper().getUniqueId(string4);
                    String string6 = IronSourceWebView.this.parseToJson("userUniqueId", string5, "productType", string4, null, null, null, null, null, false);
                    String string7 = IronSourceWebView.this.generateJSToInject(string3, string6, "onGetUserUniqueIdSuccess", "onGetUserUniqueIdFail");
                    IronSourceWebView.this.injectJavascript(string7);
                }
            }

            void handleControllerStageFailed() {
                IronSourceWebView.this.mControllerState = SSAEnums.ControllerState.Failed;
                for (DemandSource demandSource : IronSourceWebView.this.mDemandSourceManager.getDemandSources(SSAEnums.ProductType.RewardedVideo)) {
                    if (demandSource.getDemandSourceInitState() != 1) continue;
                    IronSourceWebView.this.sendProductErrorMessage(SSAEnums.ProductType.RewardedVideo, demandSource.getDemandSourceName());
                }
                for (DemandSource demandSource : IronSourceWebView.this.mDemandSourceManager.getDemandSources(SSAEnums.ProductType.Interstitial)) {
                    if (demandSource.getDemandSourceInitState() != 1) continue;
                    IronSourceWebView.this.sendProductErrorMessage(SSAEnums.ProductType.Interstitial, demandSource.getDemandSourceName());
                }
                if (IronSourceWebView.this.mOWmiss) {
                    IronSourceWebView.this.sendProductErrorMessage(SSAEnums.ProductType.OfferWall, null);
                }
                if (IronSourceWebView.this.mOWCreditsMiss) {
                    IronSourceWebView.this.sendProductErrorMessage(SSAEnums.ProductType.OfferWallCredits, null);
                }
            }

            void handleControllerStageLoaded() {
                IronSourceWebView.this.mControllerState = SSAEnums.ControllerState.Loaded;
            }

            void handleControllerStageReady() {
                IronSourceWebView.this.mControllerState = SSAEnums.ControllerState.Ready;
                IronSourceWebView.this.mGlobalControllerTimer.cancel();
                IronSourceWebView.this.mLoadControllerTimer.cancel();
                IronSourceWebView.this.invokePendingCommands();
                for (DemandSource demandSource : IronSourceWebView.this.mDemandSourceManager.getDemandSources(SSAEnums.ProductType.RewardedVideo)) {
                    if (demandSource.getDemandSourceInitState() != 1) continue;
                    IronSourceWebView ironSourceWebView = IronSourceWebView.this;
                    ironSourceWebView.initRewardedVideo(ironSourceWebView.mRVAppKey, IronSourceWebView.this.mRVUserId, demandSource, IronSourceWebView.this.mDSRewardedVideoListener);
                }
                for (DemandSource demandSource : IronSourceWebView.this.mDemandSourceManager.getDemandSources(SSAEnums.ProductType.Interstitial)) {
                    if (demandSource.getDemandSourceInitState() != 1) continue;
                    IronSourceWebView ironSourceWebView = IronSourceWebView.this;
                    ironSourceWebView.initInterstitial(ironSourceWebView.mISAppKey, IronSourceWebView.this.mISUserId, demandSource, IronSourceWebView.this.mDSInterstitialListener);
                }
                if (IronSourceWebView.this.mOWmiss) {
                    IronSourceWebView ironSourceWebView = IronSourceWebView.this;
                    ironSourceWebView.initOfferWall(ironSourceWebView.mOWAppKey, IronSourceWebView.this.mOWUserId, (Map<String, String>)IronSourceWebView.this.mOWExtraParameters, IronSourceWebView.this.mOnOfferWallListener);
                }
                if (IronSourceWebView.this.mOWCreditsMiss) {
                    IronSourceWebView ironSourceWebView = IronSourceWebView.this;
                    ironSourceWebView.getOfferWallCredits(ironSourceWebView.mOWCreditsAppKey, IronSourceWebView.this.mOWCreditsUserId, IronSourceWebView.this.mOnOfferWallListener);
                }
                IronSourceWebView ironSourceWebView = IronSourceWebView.this;
                ironSourceWebView.restoreState(ironSourceWebView.mSavedState);
            }

            @JavascriptInterface
            public void initController(String string) {
                String string2 = IronSourceWebView.this.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("initController(");
                stringBuilder.append(string);
                stringBuilder.append(")");
                Logger.i(string2, stringBuilder.toString());
                SSAObj sSAObj = new SSAObj(string);
                if (sSAObj.containsKey("stage")) {
                    String string3 = sSAObj.getString("stage");
                    if ("ready".equalsIgnoreCase(string3)) {
                        this.handleControllerStageReady();
                    } else if ("loaded".equalsIgnoreCase(string3)) {
                        this.handleControllerStageLoaded();
                    } else if ("failed".equalsIgnoreCase(string3)) {
                        this.handleControllerStageFailed();
                    } else {
                        Logger.i(IronSourceWebView.this.TAG, "No STAGE mentioned! Should not get here!");
                    }
                    IronSourceWebView.this.runOnUiThread(new Runnable(){

                        public void run() {
                            if (Build.VERSION.SDK_INT >= 16) {
                                try {
                                    IronSourceWebView.this.getSettings().setAllowFileAccessFromFileURLs(false);
                                    return;
                                }
                                catch (Exception exception) {
                                    exception.printStackTrace();
                                }
                            }
                        }
                    });
                }
            }

            @JavascriptInterface
            public void locationServicesEnabled(String string) {
                String string2 = IronSourceWebView.this.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("locationServicesEnabled(");
                stringBuilder.append(string);
                stringBuilder.append(")");
                Logger.i(string2, stringBuilder.toString());
                try {
                    boolean bl = LocationService.locationServicesEnabled(IronSourceWebView.this.getContext());
                    SSAObj sSAObj = new SSAObj(string);
                    sSAObj.put("status", String.valueOf((boolean)bl));
                    IronSourceWebView.this.responseBack(sSAObj.toString(), true, null, null);
                    return;
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                    return;
                }
            }

            @JavascriptInterface
            public void moatAPI(final String string) {
                IronSourceWebView.this.runOnUiThread(new Runnable(){

                    public void run() {
                        try {
                            String string2 = IronSourceWebView.this.TAG;
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("moatAPI(");
                            stringBuilder.append(string);
                            stringBuilder.append(")");
                            Logger.i(string2, stringBuilder.toString());
                            SSAObj sSAObj = new SSAObj(string);
                            IronSourceWebView.this.mMoatJsAdapter.call(sSAObj.toString(), new JSCallbackTask(), IronSourceWebView.this.getWebview());
                            return;
                        }
                        catch (Exception exception) {
                            exception.printStackTrace();
                            String string3 = IronSourceWebView.this.TAG;
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("moatAPI failed with exception ");
                            stringBuilder.append(exception.getMessage());
                            Logger.i(string3, stringBuilder.toString());
                            return;
                        }
                    }
                });
            }

            @JavascriptInterface
            public void onAdWindowsClosed(String string) {
                String string2 = IronSourceWebView.this.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onAdWindowsClosed(");
                stringBuilder.append(string);
                stringBuilder.append(")");
                Logger.i(string2, stringBuilder.toString());
                IronSourceWebView.this.mSavedState.adClosed();
                IronSourceWebView.this.mSavedState.setDisplayedDemandSourceName(null);
                SSAObj sSAObj = new SSAObj(string);
                String string3 = sSAObj.getString("productType");
                final String string4 = sSAObj.getString("demandSourceName");
                final SSAEnums.ProductType productType = IronSourceWebView.this.getStringProductTypeAsEnum(string3);
                String string5 = IronSourceWebView.this.PUB_TAG;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("onAdClosed() with type ");
                stringBuilder2.append((Object)productType);
                Log.d((String)string5, (String)stringBuilder2.toString());
                if (IronSourceWebView.this.shouldNotifyDeveloper(string3) && string3 != null) {
                    IronSourceWebView.this.runOnUiThread(new Runnable(){

                        public void run() {
                            if (productType != SSAEnums.ProductType.RewardedVideo && productType != SSAEnums.ProductType.Interstitial) {
                                if (productType == SSAEnums.ProductType.OfferWall) {
                                    IronSourceWebView.this.mOnOfferWallListener.onOWAdClosed();
                                    return;
                                }
                            } else {
                                DSAdProductListener dSAdProductListener = IronSourceWebView.this.getAdProductListenerByProductType(productType);
                                if (dSAdProductListener != null) {
                                    dSAdProductListener.onAdProductClose(productType, string4);
                                }
                            }
                        }
                    });
                }
            }

            @JavascriptInterface
            public void onGenericFunctionFail(String string) {
                String string2 = IronSourceWebView.this.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onGenericFunctionFail(");
                stringBuilder.append(string);
                stringBuilder.append(")");
                Logger.i(string2, stringBuilder.toString());
                if (IronSourceWebView.this.mOnGenericFunctionListener == null) {
                    Logger.d(IronSourceWebView.this.TAG, "genericFunctionListener was not found");
                    return;
                }
                final String string3 = new SSAObj(string).getString("errMsg");
                IronSourceWebView.this.runOnUiThread(new Runnable(){

                    public void run() {
                        IronSourceWebView.this.mOnGenericFunctionListener.onGFFail(string3);
                    }
                });
                IronSourceWebView.this.responseBack(string, true, null, null);
                IronSourceWebView.this.toastingErrMsg("onGenericFunctionFail", string);
            }

            @JavascriptInterface
            public void onGenericFunctionSuccess(String string) {
                String string2 = IronSourceWebView.this.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onGenericFunctionSuccess(");
                stringBuilder.append(string);
                stringBuilder.append(")");
                Logger.i(string2, stringBuilder.toString());
                if (IronSourceWebView.this.mOnGenericFunctionListener == null) {
                    Logger.d(IronSourceWebView.this.TAG, "genericFunctionListener was not found");
                    return;
                }
                IronSourceWebView.this.runOnUiThread(new Runnable(){

                    public void run() {
                        IronSourceWebView.this.mOnGenericFunctionListener.onGFSuccess();
                    }
                });
                IronSourceWebView.this.responseBack(string, true, null, null);
            }

            @JavascriptInterface
            public void onGetApplicationInfoFail(String string) {
                String string2 = IronSourceWebView.this.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onGetApplicationInfoFail(");
                stringBuilder.append(string);
                stringBuilder.append(")");
                Logger.i(string2, stringBuilder.toString());
                IronSourceWebView.this.responseBack(string, true, null, null);
                IronSourceWebView.this.toastingErrMsg("onGetApplicationInfoFail", string);
            }

            @JavascriptInterface
            public void onGetApplicationInfoSuccess(String string) {
                String string2 = IronSourceWebView.this.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onGetApplicationInfoSuccess(");
                stringBuilder.append(string);
                stringBuilder.append(")");
                Logger.i(string2, stringBuilder.toString());
                IronSourceWebView.this.responseBack(string, true, null, null);
                IronSourceWebView.this.toastingErrMsg("onGetApplicationInfoSuccess", string);
            }

            @JavascriptInterface
            public void onGetCachedFilesMapFail(String string) {
                String string2 = IronSourceWebView.this.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onGetCachedFilesMapFail(");
                stringBuilder.append(string);
                stringBuilder.append(")");
                Logger.i(string2, stringBuilder.toString());
                IronSourceWebView.this.responseBack(string, true, null, null);
                IronSourceWebView.this.toastingErrMsg("onGetCachedFilesMapFail", string);
            }

            @JavascriptInterface
            public void onGetCachedFilesMapSuccess(String string) {
                String string2 = IronSourceWebView.this.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onGetCachedFilesMapSuccess(");
                stringBuilder.append(string);
                stringBuilder.append(")");
                Logger.i(string2, stringBuilder.toString());
                IronSourceWebView.this.responseBack(string, true, null, null);
                IronSourceWebView.this.toastingErrMsg("onGetCachedFilesMapSuccess", string);
            }

            @JavascriptInterface
            public void onGetDeviceStatusFail(String string) {
                String string2 = IronSourceWebView.this.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onGetDeviceStatusFail(");
                stringBuilder.append(string);
                stringBuilder.append(")");
                Logger.i(string2, stringBuilder.toString());
                IronSourceWebView.this.responseBack(string, true, null, null);
                IronSourceWebView.this.toastingErrMsg("onGetDeviceStatusFail", string);
            }

            @JavascriptInterface
            public void onGetDeviceStatusSuccess(String string) {
                String string2 = IronSourceWebView.this.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onGetDeviceStatusSuccess(");
                stringBuilder.append(string);
                stringBuilder.append(")");
                Logger.i(string2, stringBuilder.toString());
                IronSourceWebView.this.responseBack(string, true, null, null);
                IronSourceWebView.this.toastingErrMsg("onGetDeviceStatusSuccess", string);
            }

            @JavascriptInterface
            public void onGetUDIAFail(String string) {
                String string2 = IronSourceWebView.this.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onGetUDIAFail(");
                stringBuilder.append(string);
                stringBuilder.append(")");
                Logger.i(string2, stringBuilder.toString());
            }

            @JavascriptInterface
            public void onGetUDIASuccess(String string) {
                String string2 = IronSourceWebView.this.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onGetUDIASuccess(");
                stringBuilder.append(string);
                stringBuilder.append(")");
                Logger.i(string2, stringBuilder.toString());
            }

            @JavascriptInterface
            public void onGetUserCreditsFail(String string) {
                String string2 = IronSourceWebView.this.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onGetUserCreditsFail(");
                stringBuilder.append(string);
                stringBuilder.append(")");
                Logger.i(string2, stringBuilder.toString());
                final String string3 = new SSAObj(string).getString("errMsg");
                if (IronSourceWebView.this.shouldNotifyDeveloper(SSAEnums.ProductType.OfferWall.toString())) {
                    IronSourceWebView.this.runOnUiThread(new Runnable(){

                        public void run() {
                            String string = string3;
                            if (string == null) {
                                string = "We're sorry, some error occurred. we will investigate it";
                            }
                            IronSourceWebView.this.mOnOfferWallListener.onGetOWCreditsFailed(string);
                        }
                    });
                }
                IronSourceWebView.this.responseBack(string, true, null, null);
                IronSourceWebView.this.toastingErrMsg("onGetUserCreditsFail", string);
            }

            @JavascriptInterface
            public void onGetUserUniqueIdFail(String string) {
                String string2 = IronSourceWebView.this.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onGetUserUniqueIdFail(");
                stringBuilder.append(string);
                stringBuilder.append(")");
                Logger.i(string2, stringBuilder.toString());
            }

            @JavascriptInterface
            public void onGetUserUniqueIdSuccess(String string) {
                String string2 = IronSourceWebView.this.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onGetUserUniqueIdSuccess(");
                stringBuilder.append(string);
                stringBuilder.append(")");
                Logger.i(string2, stringBuilder.toString());
            }

            @JavascriptInterface
            public void onInitInterstitialFail(String string) {
                String string2 = IronSourceWebView.this.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onInitInterstitialFail(");
                stringBuilder.append(string);
                stringBuilder.append(")");
                Logger.i(string2, stringBuilder.toString());
                SSAObj sSAObj = new SSAObj(string);
                final String string3 = sSAObj.getString("errMsg");
                final String string4 = sSAObj.getString("demandSourceName");
                if (TextUtils.isEmpty((CharSequence)string4)) {
                    Logger.i(IronSourceWebView.this.TAG, "onInitInterstitialSuccess failed with no demand source");
                    return;
                }
                DemandSource demandSource = IronSourceWebView.this.mDemandSourceManager.getDemandSourceByName(SSAEnums.ProductType.Interstitial, string4);
                if (demandSource != null) {
                    demandSource.setDemandSourceInitState(3);
                }
                if (IronSourceWebView.this.shouldNotifyDeveloper(SSAEnums.ProductType.Interstitial.toString())) {
                    IronSourceWebView.this.runOnUiThread(new Runnable(){

                        public void run() {
                            String string = string3;
                            if (string == null) {
                                string = "We're sorry, some error occurred. we will investigate it";
                            }
                            String string2 = IronSourceWebView.this.TAG;
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("onInterstitialInitFail(message:");
                            stringBuilder.append(string);
                            stringBuilder.append(")");
                            Log.d((String)string2, (String)stringBuilder.toString());
                            IronSourceWebView.this.mDSInterstitialListener.onAdProductInitFailed(SSAEnums.ProductType.Interstitial, string4, string);
                        }
                    });
                }
                IronSourceWebView.this.responseBack(string, true, null, null);
                IronSourceWebView.this.toastingErrMsg("onInitInterstitialFail", string);
            }

            @JavascriptInterface
            public void onInitInterstitialSuccess(String string) {
                Logger.i(IronSourceWebView.this.TAG, "onInitInterstitialSuccess()");
                IronSourceWebView.this.toastingErrMsg("onInitInterstitialSuccess", "true");
                final String string2 = new SSAObj(string).getString("demandSourceName");
                if (TextUtils.isEmpty((CharSequence)string2)) {
                    Logger.i(IronSourceWebView.this.TAG, "onInitInterstitialSuccess failed with no demand source");
                    return;
                }
                if (IronSourceWebView.this.shouldNotifyDeveloper(SSAEnums.ProductType.Interstitial.toString())) {
                    IronSourceWebView.this.runOnUiThread(new Runnable(){

                        public void run() {
                            Log.d((String)IronSourceWebView.this.TAG, (String)"onInterstitialInitSuccess()");
                            IronSourceWebView.this.mDSInterstitialListener.onAdProductInitSuccess(SSAEnums.ProductType.Interstitial, string2, null);
                        }
                    });
                }
            }

            @JavascriptInterface
            public void onInitOfferWallFail(String string) {
                String string2 = IronSourceWebView.this.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onInitOfferWallFail(");
                stringBuilder.append(string);
                stringBuilder.append(")");
                Logger.i(string2, stringBuilder.toString());
                IronSourceWebView.this.mSavedState.setOfferwallInitSuccess(false);
                final String string3 = new SSAObj(string).getString("errMsg");
                if (IronSourceWebView.this.mSavedState.reportInitOfferwall()) {
                    IronSourceWebView.this.mSavedState.setOfferwallReportInit(false);
                    if (IronSourceWebView.this.shouldNotifyDeveloper(SSAEnums.ProductType.OfferWall.toString())) {
                        IronSourceWebView.this.runOnUiThread(new Runnable(){

                            public void run() {
                                String string = string3;
                                if (string == null) {
                                    string = "We're sorry, some error occurred. we will investigate it";
                                }
                                String string2 = IronSourceWebView.this.TAG;
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("onOfferWallInitFail(message:");
                                stringBuilder.append(string);
                                stringBuilder.append(")");
                                Log.d((String)string2, (String)stringBuilder.toString());
                                IronSourceWebView.this.mOnOfferWallListener.onOfferwallInitFail(string);
                            }
                        });
                    }
                }
                IronSourceWebView.this.responseBack(string, true, null, null);
                IronSourceWebView.this.toastingErrMsg("onInitOfferWallFail", string);
            }

            @JavascriptInterface
            public void onInitOfferWallSuccess(String string) {
                IronSourceWebView.this.toastingErrMsg("onInitOfferWallSuccess", "true");
                IronSourceWebView.this.mSavedState.setOfferwallInitSuccess(true);
                if (IronSourceWebView.this.mSavedState.reportInitOfferwall()) {
                    IronSourceWebView.this.mSavedState.setOfferwallReportInit(false);
                    if (IronSourceWebView.this.shouldNotifyDeveloper(SSAEnums.ProductType.OfferWall.toString())) {
                        IronSourceWebView.this.runOnUiThread(new Runnable(){

                            public void run() {
                                Log.d((String)IronSourceWebView.this.TAG, (String)"onOfferWallInitSuccess()");
                                IronSourceWebView.this.mOnOfferWallListener.onOfferwallInitSuccess();
                            }
                        });
                    }
                }
            }

            @JavascriptInterface
            public void onInitRewardedVideoFail(String string) {
                String string2 = IronSourceWebView.this.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onInitRewardedVideoFail(");
                stringBuilder.append(string);
                stringBuilder.append(")");
                Logger.i(string2, stringBuilder.toString());
                SSAObj sSAObj = new SSAObj(string);
                final String string3 = sSAObj.getString("errMsg");
                final String string4 = sSAObj.getString("demandSourceName");
                DemandSource demandSource = IronSourceWebView.this.mDemandSourceManager.getDemandSourceByName(SSAEnums.ProductType.RewardedVideo, string4);
                if (demandSource != null) {
                    demandSource.setDemandSourceInitState(3);
                }
                if (IronSourceWebView.this.shouldNotifyDeveloper(SSAEnums.ProductType.RewardedVideo.toString())) {
                    IronSourceWebView.this.runOnUiThread(new Runnable(){

                        public void run() {
                            String string = string3;
                            if (string == null) {
                                string = "We're sorry, some error occurred. we will investigate it";
                            }
                            String string2 = IronSourceWebView.this.TAG;
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("onRVInitFail(message:");
                            stringBuilder.append(string);
                            stringBuilder.append(")");
                            Log.d((String)string2, (String)stringBuilder.toString());
                            IronSourceWebView.this.mDSRewardedVideoListener.onAdProductInitFailed(SSAEnums.ProductType.RewardedVideo, string4, string);
                        }
                    });
                }
                IronSourceWebView.this.responseBack(string, true, null, null);
                IronSourceWebView.this.toastingErrMsg("onInitRewardedVideoFail", string);
            }

            @JavascriptInterface
            public void onInitRewardedVideoSuccess(String string) {
                String string2 = IronSourceWebView.this.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onInitRewardedVideoSuccess(");
                stringBuilder.append(string);
                stringBuilder.append(")");
                Logger.i(string2, stringBuilder.toString());
                SSABCParameters sSABCParameters = new SSABCParameters(string);
                IronSourceSharedPrefHelper.getSupersonicPrefHelper().setSSABCParameters(sSABCParameters);
                IronSourceWebView.this.responseBack(string, true, null, null);
                IronSourceWebView.this.toastingErrMsg("onInitRewardedVideoSuccess", string);
            }

            @JavascriptInterface
            public void onLoadInterstitialFail(String string) {
                String string2 = IronSourceWebView.this.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onLoadInterstitialFail(");
                stringBuilder.append(string);
                stringBuilder.append(")");
                Logger.i(string2, stringBuilder.toString());
                SSAObj sSAObj = new SSAObj(string);
                final String string3 = sSAObj.getString("errMsg");
                final String string4 = sSAObj.getString("demandSourceName");
                IronSourceWebView.this.responseBack(string, true, null, null);
                if (TextUtils.isEmpty((CharSequence)string4)) {
                    return;
                }
                if (IronSourceWebView.this.shouldNotifyDeveloper(SSAEnums.ProductType.Interstitial.toString())) {
                    IronSourceWebView.this.runOnUiThread(new Runnable(){

                        public void run() {
                            String string = string3;
                            if (string == null) {
                                string = "We're sorry, some error occurred. we will investigate it";
                            }
                            IronSourceWebView.this.mDSInterstitialListener.onInterstitialLoadFailed(string4, string);
                        }
                    });
                }
                IronSourceWebView.this.toastingErrMsg("onLoadInterstitialFail", "true");
            }

            @JavascriptInterface
            public void onLoadInterstitialSuccess(String string) {
                String string2 = IronSourceWebView.this.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onLoadInterstitialSuccess(");
                stringBuilder.append(string);
                stringBuilder.append(")");
                Logger.i(string2, stringBuilder.toString());
                final String string3 = new SSAObj(string).getString("demandSourceName");
                this.setInterstitialAvailability(string3, true);
                IronSourceWebView.this.responseBack(string, true, null, null);
                if (IronSourceWebView.this.shouldNotifyDeveloper(SSAEnums.ProductType.Interstitial.toString())) {
                    IronSourceWebView.this.runOnUiThread(new Runnable(){

                        public void run() {
                            IronSourceWebView.this.mDSInterstitialListener.onInterstitialLoadSuccess(string3);
                        }
                    });
                }
                IronSourceWebView.this.toastingErrMsg("onLoadInterstitialSuccess", "true");
            }

            @JavascriptInterface
            public void onOfferWallGeneric(String string) {
                String string2 = IronSourceWebView.this.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onOfferWallGeneric(");
                stringBuilder.append(string);
                stringBuilder.append(")");
                Logger.i(string2, stringBuilder.toString());
                if (IronSourceWebView.this.shouldNotifyDeveloper(SSAEnums.ProductType.OfferWall.toString())) {
                    IronSourceWebView.this.mOnOfferWallListener.onOWGeneric("", "");
                }
            }

            @JavascriptInterface
            public void onShowInterstitialFail(String string) {
                String string2 = IronSourceWebView.this.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onShowInterstitialFail(");
                stringBuilder.append(string);
                stringBuilder.append(")");
                Logger.i(string2, stringBuilder.toString());
                SSAObj sSAObj = new SSAObj(string);
                final String string3 = sSAObj.getString("errMsg");
                final String string4 = sSAObj.getString("demandSourceName");
                IronSourceWebView.this.responseBack(string, true, null, null);
                if (TextUtils.isEmpty((CharSequence)string4)) {
                    return;
                }
                this.setInterstitialAvailability(string4, false);
                if (IronSourceWebView.this.shouldNotifyDeveloper(SSAEnums.ProductType.Interstitial.toString())) {
                    IronSourceWebView.this.runOnUiThread(new Runnable(){

                        public void run() {
                            String string = string3;
                            if (string == null) {
                                string = "We're sorry, some error occurred. we will investigate it";
                            }
                            IronSourceWebView.this.mDSInterstitialListener.onInterstitialShowFailed(string4, string);
                        }
                    });
                }
                IronSourceWebView.this.toastingErrMsg("onShowInterstitialFail", string);
            }

            @JavascriptInterface
            public void onShowInterstitialSuccess(String string) {
                String string2 = IronSourceWebView.this.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onShowInterstitialSuccess(");
                stringBuilder.append(string);
                stringBuilder.append(")");
                Logger.i(string2, stringBuilder.toString());
                IronSourceWebView.this.responseBack(string, true, null, null);
                final String string3 = new SSAObj(string).getString("demandSourceName");
                if (TextUtils.isEmpty((CharSequence)string3)) {
                    Logger.i(IronSourceWebView.this.TAG, "onShowInterstitialSuccess called with no demand");
                    return;
                }
                IronSourceWebView.this.mSavedState.adOpened(SSAEnums.ProductType.Interstitial.ordinal());
                IronSourceWebView.this.mSavedState.setDisplayedDemandSourceName(string3);
                if (IronSourceWebView.this.shouldNotifyDeveloper(SSAEnums.ProductType.Interstitial.toString())) {
                    IronSourceWebView.this.runOnUiThread(new Runnable(){

                        public void run() {
                            IronSourceWebView.this.mDSInterstitialListener.onAdProductOpen(SSAEnums.ProductType.Interstitial, string3);
                            IronSourceWebView.this.mDSInterstitialListener.onInterstitialShowSuccess(string3);
                        }
                    });
                    IronSourceWebView.this.toastingErrMsg("onShowInterstitialSuccess", string);
                }
                this.setInterstitialAvailability(string3, false);
            }

            @JavascriptInterface
            public void onShowOfferWallFail(String string) {
                String string2 = IronSourceWebView.this.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onShowOfferWallFail(");
                stringBuilder.append(string);
                stringBuilder.append(")");
                Logger.i(string2, stringBuilder.toString());
                final String string3 = new SSAObj(string).getString("errMsg");
                if (IronSourceWebView.this.shouldNotifyDeveloper(SSAEnums.ProductType.OfferWall.toString())) {
                    IronSourceWebView.this.runOnUiThread(new Runnable(){

                        public void run() {
                            String string = string3;
                            if (string == null) {
                                string = "We're sorry, some error occurred. we will investigate it";
                            }
                            IronSourceWebView.this.mOnOfferWallListener.onOWShowFail(string);
                        }
                    });
                }
                IronSourceWebView.this.responseBack(string, true, null, null);
                IronSourceWebView.this.toastingErrMsg("onShowOfferWallFail", string);
            }

            @JavascriptInterface
            public void onShowOfferWallSuccess(String string) {
                String string2 = IronSourceWebView.this.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onShowOfferWallSuccess(");
                stringBuilder.append(string);
                stringBuilder.append(")");
                Logger.i(string2, stringBuilder.toString());
                IronSourceWebView.this.mSavedState.adOpened(SSAEnums.ProductType.OfferWall.ordinal());
                final String string3 = SDKUtils.getValueFromJsonObject(string, "placementId");
                if (IronSourceWebView.this.shouldNotifyDeveloper(SSAEnums.ProductType.OfferWall.toString())) {
                    IronSourceWebView.this.runOnUiThread(new Runnable(){

                        public void run() {
                            IronSourceWebView.this.mOnOfferWallListener.onOWShowSuccess(string3);
                        }
                    });
                }
                IronSourceWebView.this.responseBack(string, true, null, null);
                IronSourceWebView.this.toastingErrMsg("onShowOfferWallSuccess", string);
            }

            @JavascriptInterface
            public void onShowRewardedVideoFail(String string) {
                String string2 = IronSourceWebView.this.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onShowRewardedVideoFail(");
                stringBuilder.append(string);
                stringBuilder.append(")");
                Logger.i(string2, stringBuilder.toString());
                SSAObj sSAObj = new SSAObj(string);
                final String string3 = sSAObj.getString("errMsg");
                final String string4 = sSAObj.getString("demandSourceName");
                if (IronSourceWebView.this.shouldNotifyDeveloper(SSAEnums.ProductType.RewardedVideo.toString())) {
                    IronSourceWebView.this.runOnUiThread(new Runnable(){

                        public void run() {
                            String string = string3;
                            if (string == null) {
                                string = "We're sorry, some error occurred. we will investigate it";
                            }
                            String string2 = IronSourceWebView.this.TAG;
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("onRVShowFail(message:");
                            stringBuilder.append(string3);
                            stringBuilder.append(")");
                            Log.d((String)string2, (String)stringBuilder.toString());
                            IronSourceWebView.this.mDSRewardedVideoListener.onRVShowFail(string4, string);
                        }
                    });
                }
                IronSourceWebView.this.responseBack(string, true, null, null);
                IronSourceWebView.this.toastingErrMsg("onShowRewardedVideoFail", string);
            }

            @JavascriptInterface
            public void onShowRewardedVideoSuccess(String string) {
                String string2 = IronSourceWebView.this.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onShowRewardedVideoSuccess(");
                stringBuilder.append(string);
                stringBuilder.append(")");
                Logger.i(string2, stringBuilder.toString());
                IronSourceWebView.this.responseBack(string, true, null, null);
                IronSourceWebView.this.toastingErrMsg("onShowRewardedVideoSuccess", string);
            }

            @JavascriptInterface
            public void onUDIAFail(String string) {
                String string2 = IronSourceWebView.this.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onUDIAFail(");
                stringBuilder.append(string);
                stringBuilder.append(")");
                Logger.i(string2, stringBuilder.toString());
            }

            @JavascriptInterface
            public void onUDIASuccess(String string) {
                String string2 = IronSourceWebView.this.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onUDIASuccess(");
                stringBuilder.append(string);
                stringBuilder.append(")");
                Logger.i(string2, stringBuilder.toString());
            }

            @JavascriptInterface
            public void onVideoStatusChanged(String string) {
                String string2 = IronSourceWebView.this.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onVideoStatusChanged(");
                stringBuilder.append(string);
                stringBuilder.append(")");
                Log.d((String)string2, (String)stringBuilder.toString());
                SSAObj sSAObj = new SSAObj(string);
                String string3 = sSAObj.getString("productType");
                if (IronSourceWebView.this.mVideoEventsListener != null && !TextUtils.isEmpty((CharSequence)string3) && SSAEnums.ProductType.RewardedVideo.toString().equalsIgnoreCase(string3)) {
                    String string4 = sSAObj.getString("status");
                    if ("started".equalsIgnoreCase(string4)) {
                        IronSourceWebView.this.mVideoEventsListener.onVideoStarted();
                        return;
                    }
                    if ("paused".equalsIgnoreCase(string4)) {
                        IronSourceWebView.this.mVideoEventsListener.onVideoPaused();
                        return;
                    }
                    if ("playing".equalsIgnoreCase(string4)) {
                        IronSourceWebView.this.mVideoEventsListener.onVideoResumed();
                        return;
                    }
                    if ("ended".equalsIgnoreCase(string4)) {
                        IronSourceWebView.this.mVideoEventsListener.onVideoEnded();
                        return;
                    }
                    if ("stopped".equalsIgnoreCase(string4)) {
                        IronSourceWebView.this.mVideoEventsListener.onVideoStopped();
                        return;
                    }
                    String string5 = IronSourceWebView.this.TAG;
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("onVideoStatusChanged: unknown status: ");
                    stringBuilder2.append(string4);
                    Logger.i(string5, stringBuilder2.toString());
                }
            }

            @JavascriptInterface
            public void openUrl(String string) {
                String string2 = IronSourceWebView.this.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("openUrl(");
                stringBuilder.append(string);
                stringBuilder.append(")");
                Logger.i(string2, stringBuilder.toString());
                SSAObj sSAObj = new SSAObj(string);
                String string3 = sSAObj.getString("url");
                String string4 = sSAObj.getString("method");
                Context context = IronSourceWebView.this.getCurrentActivityContext();
                try {
                    if (string4.equalsIgnoreCase("external_browser")) {
                        UrlHandler.openUrl(context, string3);
                        return;
                    }
                    if (string4.equalsIgnoreCase("webview")) {
                        Intent intent = new Intent(context, OpenUrlActivity.class);
                        intent.putExtra(IronSourceWebView.EXTERNAL_URL, string3);
                        intent.putExtra(IronSourceWebView.SECONDARY_WEB_VIEW, true);
                        intent.putExtra("immersive", IronSourceWebView.this.mIsImmersive);
                        context.startActivity(intent);
                        return;
                    }
                    if (string4.equalsIgnoreCase("store")) {
                        Intent intent = new Intent(context, OpenUrlActivity.class);
                        intent.putExtra(IronSourceWebView.EXTERNAL_URL, string3);
                        intent.putExtra(IronSourceWebView.IS_STORE, true);
                        intent.putExtra(IronSourceWebView.SECONDARY_WEB_VIEW, true);
                        context.startActivity(intent);
                        return;
                    }
                }
                catch (Exception exception) {
                    IronSourceWebView.this.responseBack(string, false, exception.getMessage(), null);
                    exception.printStackTrace();
                }
            }

            @JavascriptInterface
            public void permissionsAPI(String string) {
                try {
                    String string2 = IronSourceWebView.this.TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("permissionsAPI(");
                    stringBuilder.append(string);
                    stringBuilder.append(")");
                    Logger.i(string2, stringBuilder.toString());
                    SSAObj sSAObj = new SSAObj(string);
                    IronSourceWebView.this.mPermissionsJsAdapter.call(sSAObj.toString(), new JSCallbackTask());
                    return;
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                    String string3 = IronSourceWebView.this.TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("permissionsAPI failed with exception ");
                    stringBuilder.append(exception.getMessage());
                    Logger.i(string3, stringBuilder.toString());
                    return;
                }
            }

            @JavascriptInterface
            public void postAdEventNotification(String string) {
                try {
                    String string2 = IronSourceWebView.this.TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("postAdEventNotification(");
                    stringBuilder.append(string);
                    stringBuilder.append(")");
                    Logger.i(string2, stringBuilder.toString());
                    SSAObj sSAObj = new SSAObj(string);
                    final String string3 = sSAObj.getString("eventName");
                    if (TextUtils.isEmpty((CharSequence)string3)) {
                        IronSourceWebView.this.responseBack(string, false, "eventName does not exist", null);
                        return;
                    }
                    final String string4 = sSAObj.getString("dsName");
                    final JSONObject jSONObject = (JSONObject)sSAObj.get("extData");
                    String string5 = sSAObj.getString("productType");
                    final SSAEnums.ProductType productType = IronSourceWebView.this.getStringProductTypeAsEnum(string5);
                    if (IronSourceWebView.this.shouldNotifyDeveloper(string5)) {
                        String string6 = IronSourceWebView.this.extractSuccessFunctionToCall(string);
                        if (!TextUtils.isEmpty((CharSequence)string6)) {
                            String string7 = IronSourceWebView.this.parseToJson("productType", string5, "eventName", string3, "demandSourceName", string4, null, null, null, false);
                            String string8 = IronSourceWebView.this.generateJSToInject(string6, string7, "postAdEventNotificationSuccess", "postAdEventNotificationFail");
                            IronSourceWebView.this.injectJavascript(string8);
                        }
                        IronSourceWebView ironSourceWebView = IronSourceWebView.this;
                        Runnable runnable = new Runnable(){

                            public void run() {
                                if (productType != SSAEnums.ProductType.Interstitial && productType != SSAEnums.ProductType.RewardedVideo) {
                                    if (productType == SSAEnums.ProductType.OfferWall) {
                                        IronSourceWebView.this.mOnOfferWallListener.onOfferwallEventNotificationReceived(string3, jSONObject);
                                        return;
                                    }
                                } else {
                                    DSAdProductListener dSAdProductListener = IronSourceWebView.this.getAdProductListenerByProductType(productType);
                                    if (dSAdProductListener != null) {
                                        dSAdProductListener.onAdProductEventNotificationReceived(productType, string4, string3, jSONObject);
                                    }
                                }
                            }
                        };
                        ironSourceWebView.runOnUiThread(runnable);
                        return;
                    }
                    IronSourceWebView.this.responseBack(string, false, "productType does not exist", null);
                    return;
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                    return;
                }
            }

            @JavascriptInterface
            public void removeCloseEventHandler(String string) {
                String string2 = IronSourceWebView.this.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("removeCloseEventHandler(");
                stringBuilder.append(string);
                stringBuilder.append(")");
                Logger.i(string2, stringBuilder.toString());
                if (IronSourceWebView.this.mCloseEventTimer != null) {
                    IronSourceWebView.this.mCloseEventTimer.cancel();
                }
                IronSourceWebView.this.isRemoveCloseEventHandler = true;
            }

            @JavascriptInterface
            public void saveFile(String string) {
                String string2;
                String string3 = IronSourceWebView.this.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("saveFile(");
                stringBuilder.append(string);
                stringBuilder.append(")");
                Logger.i(string3, stringBuilder.toString());
                SSAFile sSAFile = new SSAFile(string);
                if (DeviceStatus.getAvailableMemorySizeInMegaBytes(IronSourceWebView.this.mCacheDirectory) <= 0L) {
                    IronSourceWebView.this.responseBack(string, false, "no_disk_space", null);
                    return;
                }
                if (!SDKUtils.isExternalStorageAvailable()) {
                    IronSourceWebView.this.responseBack(string, false, "sotrage_unavailable", null);
                    return;
                }
                if (IronSourceStorageUtils.isFileCached(IronSourceWebView.this.mCacheDirectory, sSAFile)) {
                    IronSourceWebView.this.responseBack(string, false, "file_already_exist", null);
                    return;
                }
                if (!ConnectivityService.isConnected(IronSourceWebView.this.getContext())) {
                    IronSourceWebView.this.responseBack(string, false, "no_network_connection", null);
                    return;
                }
                IronSourceWebView.this.responseBack(string, true, null, null);
                String string4 = sSAFile.getLastUpdateTime();
                if (string4 != null && !TextUtils.isEmpty((CharSequence)(string2 = String.valueOf((Object)string4)))) {
                    String string5 = sSAFile.getPath();
                    if (string5.contains((CharSequence)"/")) {
                        String[] arrstring = sSAFile.getPath().split("/");
                        string5 = arrstring[arrstring.length - 1];
                    }
                    IronSourceSharedPrefHelper.getSupersonicPrefHelper().setCampaignLastUpdate(string5, string2);
                }
                IronSourceWebView.this.downloadManager.downloadFile(sSAFile);
            }

            @JavascriptInterface
            public void setAllowFileAccessFromFileURLs(String string) {
                String string2 = IronSourceWebView.this.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("setAllowFileAccessFromFileURLs(");
                stringBuilder.append(string);
                stringBuilder.append(")");
                Logger.i(string2, stringBuilder.toString());
                final boolean bl = new SSAObj(string).getBoolean("allowFileAccess");
                IronSourceWebView.this.runOnUiThread(new Runnable(){

                    public void run() {
                        if (Build.VERSION.SDK_INT >= 16) {
                            try {
                                IronSourceWebView.this.getSettings().setAllowFileAccessFromFileURLs(bl);
                                return;
                            }
                            catch (Exception exception) {
                                exception.printStackTrace();
                            }
                        }
                    }
                });
            }

            @JavascriptInterface
            public void setBackButtonState(String string) {
                String string2 = IronSourceWebView.this.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("setBackButtonState(");
                stringBuilder.append(string);
                stringBuilder.append(")");
                Logger.i(string2, stringBuilder.toString());
                String string3 = new SSAObj(string).getString("state");
                IronSourceSharedPrefHelper.getSupersonicPrefHelper().setBackButtonState(string3);
            }

            @JavascriptInterface
            public void setForceClose(String string) {
                String string2 = IronSourceWebView.this.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("setForceClose(");
                stringBuilder.append(string);
                stringBuilder.append(")");
                Logger.i(string2, stringBuilder.toString());
                SSAObj sSAObj = new SSAObj(string);
                String string3 = sSAObj.getString("width");
                String string4 = sSAObj.getString("height");
                IronSourceWebView.this.mHiddenForceCloseWidth = Integer.parseInt((String)string3);
                IronSourceWebView.this.mHiddenForceCloseHeight = Integer.parseInt((String)string4);
                IronSourceWebView.this.mHiddenForceCloseLocation = sSAObj.getString("position");
            }

            @JavascriptInterface
            public void setMixedContentAlwaysAllow(String string) {
                String string2 = IronSourceWebView.this.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("setMixedContentAlwaysAllow(");
                stringBuilder.append(string);
                stringBuilder.append(")");
                Logger.i(string2, stringBuilder.toString());
                IronSourceWebView.this.runOnUiThread(new Runnable(){

                    public void run() {
                        if (Build.VERSION.SDK_INT >= 21) {
                            IronSourceWebView.this.getSettings().setMixedContentMode(0);
                        }
                    }
                });
            }

            @JavascriptInterface
            public void setOrientation(String string) {
                String string2 = IronSourceWebView.this.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("setOrientation(");
                stringBuilder.append(string);
                stringBuilder.append(")");
                Logger.i(string2, stringBuilder.toString());
                String string3 = new SSAObj(string).getString("orientation");
                IronSourceWebView.this.setOrientationState(string3);
                int n2 = DeviceStatus.getApplicationRotation(IronSourceWebView.this.getCurrentActivityContext());
                if (IronSourceWebView.this.mChangeListener != null) {
                    IronSourceWebView.this.mChangeListener.onOrientationChanged(string3, n2);
                }
            }

            @JavascriptInterface
            public void setStoreSearchKeys(String string) {
                String string2 = IronSourceWebView.this.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("setStoreSearchKeys(");
                stringBuilder.append(string);
                stringBuilder.append(")");
                Logger.i(string2, stringBuilder.toString());
                IronSourceSharedPrefHelper.getSupersonicPrefHelper().setSearchKeys(string);
            }

            @JavascriptInterface
            public void setUserData(String string) {
                String string2 = IronSourceWebView.this.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("setUserData(");
                stringBuilder.append(string);
                stringBuilder.append(")");
                Logger.i(string2, stringBuilder.toString());
                SSAObj sSAObj = new SSAObj(string);
                if (!sSAObj.containsKey("key")) {
                    IronSourceWebView.this.responseBack(string, false, "key does not exist", null);
                    return;
                }
                if (!sSAObj.containsKey("value")) {
                    IronSourceWebView.this.responseBack(string, false, "value does not exist", null);
                    return;
                }
                String string3 = sSAObj.getString("key");
                String string4 = sSAObj.getString("value");
                if (IronSourceSharedPrefHelper.getSupersonicPrefHelper().setUserData(string3, string4)) {
                    String string5 = IronSourceWebView.this.extractSuccessFunctionToCall(string);
                    String string6 = IronSourceWebView.this.parseToJson(string3, string4, null, null, null, null, null, null, null, false);
                    String string7 = IronSourceWebView.this.generateJSToInject(string5, string6);
                    IronSourceWebView.this.injectJavascript(string7);
                    return;
                }
                IronSourceWebView.this.responseBack(string, false, "SetUserData failed writing to shared preferences", null);
            }

            @JavascriptInterface
            public void setUserUniqueId(String string) {
                String string2 = IronSourceWebView.this.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("setUserUniqueId(");
                stringBuilder.append(string);
                stringBuilder.append(")");
                Logger.i(string2, stringBuilder.toString());
                SSAObj sSAObj = new SSAObj(string);
                if (sSAObj.containsKey("userUniqueId") && sSAObj.containsKey("productType")) {
                    String string3 = sSAObj.getString("userUniqueId");
                    String string4 = sSAObj.getString("productType");
                    if (IronSourceSharedPrefHelper.getSupersonicPrefHelper().setUniqueId(string3, string4)) {
                        IronSourceWebView.this.responseBack(string, true, null, null);
                        return;
                    }
                    IronSourceWebView.this.responseBack(string, false, "setUserUniqueId failed", null);
                    return;
                }
                IronSourceWebView.this.responseBack(string, false, "uniqueId or productType does not exist", null);
            }

            @JavascriptInterface
            public void setWebviewBackgroundColor(String string) {
                String string2 = IronSourceWebView.this.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("setWebviewBackgroundColor(");
                stringBuilder.append(string);
                stringBuilder.append(")");
                Logger.i(string2, stringBuilder.toString());
                IronSourceWebView.this.setWebviewBackground(string);
            }

            @JavascriptInterface
            public void toggleUDIA(String string) {
                String string2 = IronSourceWebView.this.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("toggleUDIA(");
                stringBuilder.append(string);
                stringBuilder.append(")");
                Logger.i(string2, stringBuilder.toString());
                SSAObj sSAObj = new SSAObj(string);
                if (!sSAObj.containsKey("toggle")) {
                    IronSourceWebView.this.responseBack(string, false, "toggle key does not exist", null);
                    return;
                }
                int n2 = Integer.parseInt((String)sSAObj.getString("toggle"));
                if (n2 == 0) {
                    return;
                }
                String string3 = Integer.toBinaryString((int)n2);
                if (TextUtils.isEmpty((CharSequence)string3)) {
                    IronSourceWebView.this.responseBack(string, false, "fialed to convert toggle", null);
                    return;
                }
                if (string3.toCharArray()[3] == '0') {
                    IronSourceSharedPrefHelper.getSupersonicPrefHelper().setShouldRegisterSessions(true);
                    return;
                }
                IronSourceSharedPrefHelper.getSupersonicPrefHelper().setShouldRegisterSessions(false);
            }

            class JSCallbackTask {
                JSCallbackTask() {
                }

                void sendMessage(boolean bl, String string, SSAObj sSAObj) {
                    String string2 = bl ? JSON_KEY_SUCCESS : JSON_KEY_FAIL;
                    sSAObj.put(string2, string);
                    IronSourceWebView.this.responseBack(sSAObj.toString(), bl, null, null);
                }

                void sendMessage(boolean bl, String string, String string2) {
                    SSAObj sSAObj = new SSAObj();
                    String string3 = bl ? JSON_KEY_SUCCESS : JSON_KEY_FAIL;
                    sSAObj.put(string3, string);
                    sSAObj.put("data", string2);
                    IronSourceWebView.this.responseBack(sSAObj.toString(), bl, null, null);
                }
            }

        };
    }

    Handler createMainThreadHandler() {
        return new Handler(Looper.getMainLooper());
    }

    public void destroy() {
        super.destroy();
        DownloadManager downloadManager = this.downloadManager;
        if (downloadManager != null) {
            downloadManager.release();
        }
        if (this.mConnectionReceiver != null) {
            this.mConnectionReceiver = null;
        }
        this.mUiHandler = null;
        this.mCurrentActivityContext = null;
    }

    public void deviceStatusChanged(String string) {
        this.injectJavascript(this.generateJSToInject("deviceStatusChanged", this.parseToJson("connectionType", string, null, null, null, null, null, null, null, false)));
    }

    public void downloadController() {
        IronSourceStorageUtils.deleteFile(this.mCacheDirectory, "", "mobileController.html");
        String string = SDKUtils.getControllerUrl();
        SSAFile sSAFile = new SSAFile(string, "");
        CountDownTimer countDownTimer = new CountDownTimer(this, 200000L, 1000L){
            final /* synthetic */ IronSourceWebView this$0;
            {
                this.this$0 = ironSourceWebView;
                super(l2, l3);
            }

            public void onFinish() {
                Logger.i(IronSourceWebView.access$300(this.this$0), "Global Controller Timer Finish");
                IronSourceWebView.access$902(this.this$0, true);
            }

            public void onTick(long l2) {
                String string = IronSourceWebView.access$300(this.this$0);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Global Controller Timer Tick ");
                stringBuilder.append(l2);
                Logger.i(string, stringBuilder.toString());
            }
        };
        this.mGlobalControllerTimer = countDownTimer.start();
        if (!this.downloadManager.isMobileControllerThreadLive()) {
            String string2 = this.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Download Mobile Controller: ");
            stringBuilder.append(string);
            Logger.i(string2, stringBuilder.toString());
            this.downloadManager.downloadMobileControllerFile(sSAFile);
            return;
        }
        Logger.i(this.TAG, "Download Mobile Controller: already alive");
    }

    public void engageEnd(String string) {
        if (string.equals((Object)"forceClose")) {
            this.closeWebView();
        }
        this.injectJavascript(this.generateJSToInject("engageEnd", this.parseToJson("action", string, null, null, null, null, null, null, null, false)));
    }

    public void enterBackground() {
        if (this.mControllerState == SSAEnums.ControllerState.Ready) {
            this.injectJavascript(this.generateJSToInject("enterBackground"));
        }
    }

    public void enterForeground() {
        if (this.mControllerState == SSAEnums.ControllerState.Ready) {
            this.injectJavascript(this.generateJSToInject("enterForeground"));
        }
    }

    public String getControllerKeyPressed() {
        String string = this.mControllerKeyPressed;
        this.setControllerKeyPressed("interrupt");
        return string;
    }

    public Context getCurrentActivityContext() {
        return ((MutableContextWrapper)this.mCurrentActivityContext).getBaseContext();
    }

    public int getDebugMode() {
        return mDebugMode;
    }

    DownloadManager getDownloadManager() {
        return DownloadManager.getInstance(this.mCacheDirectory);
    }

    public FrameLayout getLayout() {
        return this.mControllerLayout;
    }

    public void getOfferWallCredits(String string, String string2, OnOfferWallListener onOfferWallListener) {
        this.mOWCreditsAppKey = string;
        this.mOWCreditsUserId = string2;
        this.mProductParametersCollection.setProductParameters(SSAEnums.ProductType.OfferWallCredits, string, string2);
        this.mOnOfferWallListener = onOfferWallListener;
        this.initProduct(this.mOWCreditsAppKey, this.mOWCreditsUserId, SSAEnums.ProductType.OfferWallCredits, null, "Show OW Credits");
    }

    public String getOrientationState() {
        return this.mOrientationState;
    }

    public AdUnitsState getSavedState() {
        return this.mSavedState;
    }

    public State getState() {
        return this.mState;
    }

    public boolean handleSearchKeysURLs(String string) throws Exception {
        List<String> list = IronSourceSharedPrefHelper.getSupersonicPrefHelper().getSearchKeys();
        if (list != null) {
            try {
                if (!list.isEmpty()) {
                    Iterator iterator = list.iterator();
                    while (iterator.hasNext()) {
                        if (!string.contains((CharSequence)((String)iterator.next()))) continue;
                        UrlHandler.openUrl(this.getCurrentActivityContext(), string);
                        return true;
                    }
                }
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return false;
    }

    public void hideCustomView() {
        this.mWebChromeClient.onHideCustomView();
    }

    public boolean inCustomView() {
        return this.mCustomView != null;
    }

    public void initInterstitial(String string, String string2, DemandSource demandSource, DSInterstitialListener dSInterstitialListener) {
        this.mISAppKey = string;
        this.mISUserId = string2;
        this.mProductParametersCollection.setProductParameters(SSAEnums.ProductType.Interstitial, string, string2);
        this.mDSInterstitialListener = dSInterstitialListener;
        this.mSavedState.setInterstitialAppKey(this.mISAppKey);
        this.mSavedState.setInterstitialUserId(this.mISUserId);
        this.initProduct(this.mISAppKey, this.mISUserId, SSAEnums.ProductType.Interstitial, demandSource, "Init IS");
    }

    public void initOfferWall(String string, String string2, Map<String, String> map, OnOfferWallListener onOfferWallListener) {
        this.mOWAppKey = string;
        this.mOWUserId = string2;
        this.mProductParametersCollection.setProductParameters(SSAEnums.ProductType.OfferWall, string, string2);
        this.mOWExtraParameters = map;
        this.mOnOfferWallListener = onOfferWallListener;
        this.mSavedState.setOfferWallExtraParams(this.mOWExtraParameters);
        this.mSavedState.setOfferwallReportInit(true);
        this.initProduct(this.mOWAppKey, this.mOWUserId, SSAEnums.ProductType.OfferWall, null, "Init OW");
    }

    public void initRewardedVideo(String string, String string2, DemandSource demandSource, DSRewardedVideoListener dSRewardedVideoListener) {
        this.mRVAppKey = string;
        this.mRVUserId = string2;
        this.mProductParametersCollection.setProductParameters(SSAEnums.ProductType.RewardedVideo, string, string2);
        this.mDSRewardedVideoListener = dSRewardedVideoListener;
        this.mSavedState.setRVAppKey(string);
        this.mSavedState.setRVUserId(string2);
        this.initProduct(string, string2, SSAEnums.ProductType.RewardedVideo, demandSource, "Init RV");
    }

    String initializeCacheDirectory(Context context) {
        return IronSourceStorageUtils.initializeCacheDirectory(context.getApplicationContext());
    }

    public void interceptedUrlToStore() {
        this.injectJavascript(this.generateJSToInject("interceptedUrlToStore"));
    }

    public boolean isInterstitialAdAvailable(String string) {
        DemandSource demandSource = this.mDemandSourceManager.getDemandSourceByName(SSAEnums.ProductType.Interstitial, string);
        return demandSource != null && demandSource.getAvailabilityState();
    }

    public void load(int n2) {
        try {
            this.loadUrl("about:blank");
        }
        catch (Throwable throwable) {
            String string = this.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("WebViewController:: load: ");
            stringBuilder.append(throwable.toString());
            Logger.e(string, stringBuilder.toString());
            new IronSourceAsyncHttpRequestTask().execute((Object[])new String[]{"https://www.supersonicads.com/mobile/sdk5/log?method=webviewLoadBlank"});
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("file://");
        stringBuilder.append(this.mCacheDirectory);
        stringBuilder.append(File.separator);
        stringBuilder.append("mobileController.html");
        String string = stringBuilder.toString();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(this.mCacheDirectory);
        stringBuilder2.append(File.separator);
        stringBuilder2.append("mobileController.html");
        if (new File(stringBuilder2.toString()).exists()) {
            JSONObject jSONObject = SDKUtils.getControllerConfigAsJSONObject();
            this.setWebDebuggingEnabled(jSONObject);
            this.mRequestParameters = this.getRequestParameters(jSONObject);
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(string);
            stringBuilder3.append("?");
            stringBuilder3.append(this.mRequestParameters);
            String string2 = stringBuilder3.toString();
            CountDownTimer countDownTimer = new CountDownTimer(this, 50000L, 1000L, n2){
                final /* synthetic */ IronSourceWebView this$0;
                final /* synthetic */ int val$loadAttemp;
                {
                    this.this$0 = ironSourceWebView;
                    this.val$loadAttemp = n2;
                    super(l2, l3);
                }

                public void onFinish() {
                    Logger.i(IronSourceWebView.access$300(this.this$0), "Loading Controller Timer Finish");
                    if (this.val$loadAttemp == 3) {
                        IronSourceWebView.access$1600(this.this$0).cancel();
                        for (DemandSource demandSource : IronSourceWebView.access$1900(this.this$0).getDemandSources(SSAEnums.ProductType.RewardedVideo)) {
                            if (demandSource.getDemandSourceInitState() != 1) continue;
                            IronSourceWebView.access$3500(this.this$0, SSAEnums.ProductType.RewardedVideo, demandSource.getDemandSourceName());
                        }
                        for (DemandSource demandSource : IronSourceWebView.access$1900(this.this$0).getDemandSources(SSAEnums.ProductType.Interstitial)) {
                            if (demandSource.getDemandSourceInitState() != 1) continue;
                            IronSourceWebView.access$3500(this.this$0, SSAEnums.ProductType.Interstitial, demandSource.getDemandSourceName());
                        }
                        if (IronSourceWebView.access$2600(this.this$0)) {
                            IronSourceWebView.access$3500(this.this$0, SSAEnums.ProductType.OfferWall, null);
                        }
                        if (IronSourceWebView.access$3100(this.this$0)) {
                            IronSourceWebView.access$3500(this.this$0, SSAEnums.ProductType.OfferWallCredits, null);
                            return;
                        }
                    } else {
                        this.this$0.load(2);
                    }
                }

                public void onTick(long l2) {
                    String string = IronSourceWebView.access$300(this.this$0);
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Loading Controller Timer Tick ");
                    stringBuilder.append(l2);
                    Logger.i(string, stringBuilder.toString());
                }
            };
            this.mLoadControllerTimer = countDownTimer.start();
            try {
                this.loadUrl(string2);
            }
            catch (Throwable throwable) {
                String string3 = this.TAG;
                StringBuilder stringBuilder4 = new StringBuilder();
                stringBuilder4.append("WebViewController:: load: ");
                stringBuilder4.append(throwable.toString());
                Logger.e(string3, stringBuilder4.toString());
                new IronSourceAsyncHttpRequestTask().execute((Object[])new String[]{"https://www.supersonicads.com/mobile/sdk5/log?method=webviewLoadWithPath"});
            }
            String string4 = this.TAG;
            StringBuilder stringBuilder5 = new StringBuilder();
            stringBuilder5.append("load(): ");
            stringBuilder5.append(string2);
            Logger.i(string4, stringBuilder5.toString());
            return;
        }
        Logger.i(this.TAG, "load(): Mobile Controller HTML Does not exist");
        new IronSourceAsyncHttpRequestTask().execute((Object[])new String[]{"https://www.supersonicads.com/mobile/sdk5/log?method=htmlControllerDoesNotExistOnFileSystem"});
    }

    public void loadInterstitial(String string) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty((CharSequence)string)) {
            hashMap.put((Object)"demandSourceName", (Object)string);
        }
        String string2 = this.flatMapToJsonAsString((Map<String, String>)hashMap);
        if (!this.isInterstitialAdAvailable(string)) {
            this.mSavedState.setReportLoadInterstitial(string, true);
            this.injectJavascript(this.generateJSToInject("loadInterstitial", string2, "onLoadInterstitialSuccess", "onLoadInterstitialFail"));
            return;
        }
        if (this.shouldNotifyDeveloper(SSAEnums.ProductType.Interstitial.toString())) {
            this.runOnUiThread(new Runnable(this, string){
                final /* synthetic */ IronSourceWebView this$0;
                final /* synthetic */ String val$demandSourceName;
                {
                    this.this$0 = ironSourceWebView;
                    this.val$demandSourceName = string;
                }

                public void run() {
                    IronSourceWebView.access$2500(this.this$0).onInterstitialLoadSuccess(this.val$demandSourceName);
                }
            });
        }
    }

    public void nativeNavigationPressed(String string) {
        this.injectJavascript(this.generateJSToInject("nativeNavigationPressed", this.parseToJson("action", string, null, null, null, null, null, null, null, false)));
    }

    public void notifyLifeCycle(String string, String string2) {
        this.injectJavascript(this.generateJSToInject("onNativeLifeCycleEvent", this.parseToJson("lifeCycleEvent", string2, "productType", string, null, null, null, null, null, false)));
    }

    public void onDownloadStart(String string, String string2, String string3, String string4, long l2) {
        String string5 = this.TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(" ");
        stringBuilder.append(string4);
        Logger.i(string5, stringBuilder.toString());
    }

    @Override
    public void onFileDownloadFail(SSAFile sSAFile) {
        if (sSAFile.getFile().contains((CharSequence)"mobileController.html")) {
            this.mGlobalControllerTimer.cancel();
            for (DemandSource demandSource : this.mDemandSourceManager.getDemandSources(SSAEnums.ProductType.RewardedVideo)) {
                if (demandSource.getDemandSourceInitState() != 1) continue;
                this.sendProductErrorMessage(SSAEnums.ProductType.RewardedVideo, demandSource.getDemandSourceName());
            }
            for (DemandSource demandSource : this.mDemandSourceManager.getDemandSources(SSAEnums.ProductType.Interstitial)) {
                if (demandSource.getDemandSourceInitState() != 1) continue;
                this.sendProductErrorMessage(SSAEnums.ProductType.Interstitial, demandSource.getDemandSourceName());
            }
            if (this.mOWmiss) {
                this.sendProductErrorMessage(SSAEnums.ProductType.OfferWall, null);
            }
            if (this.mOWCreditsMiss) {
                this.sendProductErrorMessage(SSAEnums.ProductType.OfferWallCredits, null);
                return;
            }
        } else {
            this.assetCachedFailed(sSAFile.getFile(), sSAFile.getPath(), sSAFile.getErrMsg());
        }
    }

    @Override
    public void onFileDownloadSuccess(SSAFile sSAFile) {
        if (sSAFile.getFile().contains((CharSequence)"mobileController.html")) {
            this.load(1);
            return;
        }
        this.assetCached(sSAFile.getFile(), sSAFile.getPath());
    }

    public boolean onKeyDown(int n2, KeyEvent keyEvent) {
        if (n2 == 4) {
            if (!this.mChangeListener.onBackButtonPressed()) {
                return super.onKeyDown(n2, keyEvent);
            }
            return true;
        }
        return super.onKeyDown(n2, keyEvent);
    }

    public void pageFinished() {
        this.injectJavascript(this.generateJSToInject("pageFinished"));
    }

    public void pause() {
        if (Build.VERSION.SDK_INT > 10) {
            try {
                this.onPause();
                return;
            }
            catch (Throwable throwable) {
                String string = this.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("WebViewController: pause() - ");
                stringBuilder.append((Object)throwable);
                Logger.i(string, stringBuilder.toString());
                new IronSourceAsyncHttpRequestTask().execute((Object[])new String[]{"https://www.supersonicads.com/mobile/sdk5/log?method=webviewPause"});
            }
        }
    }

    public void registerConnectionReceiver(Context context) {
        context.registerReceiver(this.mConnectionReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public void removeVideoEventsListener() {
        this.mVideoEventsListener = null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void restoreState(AdUnitsState adUnitsState) {
        Object object;
        Object object2 = object = this.mSavedStateLocker;
        synchronized (object2) {
            if (adUnitsState.shouldRestore() && this.mControllerState.equals((Object)SSAEnums.ControllerState.Ready)) {
                String string = this.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("restoreState(state:");
                stringBuilder.append((Object)adUnitsState);
                stringBuilder.append(")");
                Log.d((String)string, (String)stringBuilder.toString());
                int n2 = adUnitsState.getDisplayedProduct();
                if (n2 != -1) {
                    if (n2 == SSAEnums.ProductType.RewardedVideo.ordinal()) {
                        Log.d((String)this.TAG, (String)"onRVAdClosed()");
                        SSAEnums.ProductType productType = SSAEnums.ProductType.RewardedVideo;
                        String string2 = adUnitsState.getDisplayedDemandSourceName();
                        DSAdProductListener dSAdProductListener = this.getAdProductListenerByProductType(productType);
                        if (dSAdProductListener != null && !TextUtils.isEmpty((CharSequence)string2)) {
                            dSAdProductListener.onAdProductClose(productType, string2);
                        }
                    } else if (n2 == SSAEnums.ProductType.Interstitial.ordinal()) {
                        Log.d((String)this.TAG, (String)"onInterstitialAdClosed()");
                        SSAEnums.ProductType productType = SSAEnums.ProductType.Interstitial;
                        String string3 = adUnitsState.getDisplayedDemandSourceName();
                        DSAdProductListener dSAdProductListener = this.getAdProductListenerByProductType(productType);
                        if (dSAdProductListener != null && !TextUtils.isEmpty((CharSequence)string3)) {
                            dSAdProductListener.onAdProductClose(productType, string3);
                        }
                    } else if (n2 == SSAEnums.ProductType.OfferWall.ordinal()) {
                        Log.d((String)this.TAG, (String)"onOWAdClosed()");
                        if (this.mOnOfferWallListener != null) {
                            this.mOnOfferWallListener.onOWAdClosed();
                        }
                    }
                    adUnitsState.adOpened(-1);
                    adUnitsState.setDisplayedDemandSourceName(null);
                } else {
                    Log.d((String)this.TAG, (String)"No ad was opened");
                }
                String string4 = adUnitsState.getInterstitialAppKey();
                String string5 = adUnitsState.getInterstitialUserId();
                for (DemandSource demandSource : this.mDemandSourceManager.getDemandSources(SSAEnums.ProductType.Interstitial)) {
                    if (demandSource.getDemandSourceInitState() != 2) continue;
                    String string6 = this.TAG;
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("initInterstitial(appKey:");
                    stringBuilder2.append(string4);
                    stringBuilder2.append(", userId:");
                    stringBuilder2.append(string5);
                    stringBuilder2.append(", demandSource:");
                    stringBuilder2.append(demandSource.getDemandSourceName());
                    stringBuilder2.append(")");
                    Log.d((String)string6, (String)stringBuilder2.toString());
                    this.initInterstitial(string4, string5, demandSource, this.mDSInterstitialListener);
                }
                String string7 = adUnitsState.getRVAppKey();
                String string8 = adUnitsState.getRVUserId();
                for (DemandSource demandSource : this.mDemandSourceManager.getDemandSources(SSAEnums.ProductType.RewardedVideo)) {
                    if (demandSource.getDemandSourceInitState() != 2) continue;
                    String string9 = demandSource.getDemandSourceName();
                    Log.d((String)this.TAG, (String)"onRVNoMoreOffers()");
                    this.mDSRewardedVideoListener.onRVNoMoreOffers(string9);
                    String string10 = this.TAG;
                    StringBuilder stringBuilder3 = new StringBuilder();
                    stringBuilder3.append("initRewardedVideo(appKey:");
                    stringBuilder3.append(string7);
                    stringBuilder3.append(", userId:");
                    stringBuilder3.append(string8);
                    stringBuilder3.append(", demandSource:");
                    stringBuilder3.append(string9);
                    stringBuilder3.append(")");
                    Log.d((String)string10, (String)stringBuilder3.toString());
                    this.initRewardedVideo(string7, string8, demandSource, this.mDSRewardedVideoListener);
                }
                adUnitsState.setShouldRestore(false);
            }
            this.mSavedState = adUnitsState;
            return;
        }
    }

    public void resume() {
        if (Build.VERSION.SDK_INT > 10) {
            try {
                this.onResume();
                return;
            }
            catch (Throwable throwable) {
                String string = this.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("WebViewController: onResume() - ");
                stringBuilder.append((Object)throwable);
                Logger.i(string, stringBuilder.toString());
                new IronSourceAsyncHttpRequestTask().execute((Object[])new String[]{"https://www.supersonicads.com/mobile/sdk5/log?method=webviewResume"});
            }
        }
    }

    void runOnUiThread(Runnable runnable) {
        this.mUiHandler.post(runnable);
    }

    public WebBackForwardList saveState(Bundle bundle) {
        return super.saveState(bundle);
    }

    public void setControllerKeyPressed(String string) {
        this.mControllerKeyPressed = string;
    }

    public void setDebugMode(int n2) {
        mDebugMode = n2;
    }

    void setMissProduct(SSAEnums.ProductType productType, DemandSource demandSource) {
        if (productType != SSAEnums.ProductType.RewardedVideo && productType != SSAEnums.ProductType.Interstitial) {
            if (productType == SSAEnums.ProductType.OfferWall) {
                this.mOWmiss = true;
            } else if (productType == SSAEnums.ProductType.OfferWallCredits) {
                this.mOWCreditsMiss = true;
            }
        } else if (demandSource != null) {
            demandSource.setDemandSourceInitState(1);
        }
        String string = this.TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("setMissProduct(");
        stringBuilder.append((Object)productType);
        stringBuilder.append(")");
        Logger.i(string, stringBuilder.toString());
    }

    public void setOnWebViewControllerChangeListener(OnWebViewChangeListener onWebViewChangeListener) {
        this.mChangeListener = onWebViewChangeListener;
    }

    public void setOrientationState(String string) {
        this.mOrientationState = string;
    }

    public void setState(State state) {
        this.mState = state;
    }

    public void setVideoEventsListener(VideoEventsListener videoEventsListener) {
        this.mVideoEventsListener = videoEventsListener;
    }

    public void showInterstitial(JSONObject jSONObject) {
        this.injectJavascript(this.createShowProductJSMethod(SSAEnums.ProductType.Interstitial, jSONObject));
    }

    public void showOfferWall(Map<String, String> map) {
        this.mOWExtraParameters = map;
        this.injectJavascript(this.generateJSToInject("showOfferWall", "onShowOfferWallSuccess", "onShowOfferWallFail"));
    }

    public void showRewardedVideo(JSONObject jSONObject) {
        this.injectJavascript(this.createShowProductJSMethod(SSAEnums.ProductType.RewardedVideo, jSONObject));
    }

    public void unregisterConnectionReceiver(Context context) {
        try {
            context.unregisterReceiver(this.mConnectionReceiver);
            return;
        }
        catch (Exception exception) {
            String string = this.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("unregisterConnectionReceiver - ");
            stringBuilder.append((Object)exception);
            Log.e((String)string, (String)stringBuilder.toString());
            IronSourceAsyncHttpRequestTask ironSourceAsyncHttpRequestTask = new IronSourceAsyncHttpRequestTask();
            Object[] arrobject = new String[1];
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("https://www.supersonicads.com/mobile/sdk5/log?method=");
            stringBuilder2.append(exception.getStackTrace()[0].getMethodName());
            arrobject[0] = stringBuilder2.toString();
            ironSourceAsyncHttpRequestTask.execute(arrobject);
        }
        catch (IllegalArgumentException illegalArgumentException) {}
    }

    public void updateConsentInfo(JSONObject jSONObject) {
        String string = jSONObject != null ? jSONObject.toString() : null;
        this.injectJavascript("updateConsentInfo", this.generateJSToInject("updateConsentInfo", string));
    }

    public void viewableChange(boolean bl, String string) {
        this.injectJavascript(this.generateJSToInject("viewableChange", this.parseToJson("webview", string, null, null, null, null, null, null, "isViewable", bl)));
    }

}

