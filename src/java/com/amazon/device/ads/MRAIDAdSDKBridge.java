/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.annotation.TargetApi
 *  android.app.Activity
 *  android.app.AlertDialog
 *  android.app.AlertDialog$Builder
 *  android.content.ActivityNotFoundException
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.Intent
 *  android.content.pm.PackageManager
 *  android.graphics.Bitmap
 *  android.os.Bundle
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Date
 *  java.util.Locale
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.amazon.device.ads;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.amazon.device.ads.AdActivity;
import com.amazon.device.ads.AdControlAccessor;
import com.amazon.device.ads.AdControllerFactory;
import com.amazon.device.ads.AdEvent;
import com.amazon.device.ads.AdSDKBridge;
import com.amazon.device.ads.AdUtils2;
import com.amazon.device.ads.AndroidBuildInfo;
import com.amazon.device.ads.AndroidTargetUtils;
import com.amazon.device.ads.CalendarEventParameters;
import com.amazon.device.ads.DisplayUtils;
import com.amazon.device.ads.ExpandProperties;
import com.amazon.device.ads.ForceOrientation;
import com.amazon.device.ads.GraphicsUtils;
import com.amazon.device.ads.ImageResponseReader;
import com.amazon.device.ads.InAppBrowser;
import com.amazon.device.ads.IntentBuilder;
import com.amazon.device.ads.IntentBuilderFactory;
import com.amazon.device.ads.JSONUtils;
import com.amazon.device.ads.JavascriptInteractor;
import com.amazon.device.ads.LayoutFactory;
import com.amazon.device.ads.MRAIDAdSDKBridge;
import com.amazon.device.ads.MRAIDAdSDKEventListener;
import com.amazon.device.ads.MobileAdsLogger;
import com.amazon.device.ads.MobileAdsLoggerFactory;
import com.amazon.device.ads.ModalAdActivityAdapter;
import com.amazon.device.ads.OrientationProperties;
import com.amazon.device.ads.PermissionChecker;
import com.amazon.device.ads.Position;
import com.amazon.device.ads.PreloadCallback;
import com.amazon.device.ads.RelativePosition;
import com.amazon.device.ads.ResizeProperties;
import com.amazon.device.ads.ResponseReader;
import com.amazon.device.ads.SDKEventListener;
import com.amazon.device.ads.Size;
import com.amazon.device.ads.StringUtils;
import com.amazon.device.ads.ThreadUtils;
import com.amazon.device.ads.VideoActionHandler;
import com.amazon.device.ads.ViewUtils;
import com.amazon.device.ads.WebRequest;
import com.amazon.device.ads.WebUtils;
import com.amazon.device.ads.WebUtils2;
import java.util.Date;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

class MRAIDAdSDKBridge
implements AdSDKBridge {
    private static final int CLOSE_BUTTON_SIZE = 50;
    private static final String CONTENT_DESCRIPTION_RESIZED_VIEW = "resizedView";
    private static final String ERROR_EVENT_FORMAT = "mraidBridge.error('%s', '%s');";
    private static final String JAVASCRIPT;
    private static final String LOGTAG = "MRAIDAdSDKBridge";
    private static final String MRAID_BRIDGE_NAME = "mraidObject";
    private static final String PLACEMENT_TYPE_INLINE = "inline";
    private static final String PLACEMENT_TYPE_INTERSTITIAL = "interstitial";
    private final AdControlAccessor adControlAccessor;
    private final AdUtils2 adUtils;
    private final AlertDialogFactory alertDialogFactory;
    private final AndroidBuildInfo buildInfo;
    private final Position defaultPosition;
    private final ExpandProperties expandProperties;
    private boolean expandedWithUrl = true;
    private final GraphicsUtils graphicsUtils;
    private final IntentBuilderFactory intentBuilderFactory;
    private final JavascriptInteractor javascriptInteractor;
    private final LayoutFactory layoutFactory;
    private final MobileAdsLogger logger;
    private final OrientationProperties orientationProperties;
    private final PermissionChecker permissionChecker;
    private final ResizeProperties resizeProperties;
    private ViewGroup resizedView;
    private FrameLayout rootView;
    private SDKEventListener sdkEventListener;
    private final ThreadUtils.ThreadRunner threadRunner;
    private final ViewUtils viewUtils;
    private final WebRequest.WebRequestFactory webRequestFactory;
    private final WebUtils2 webUtils;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(function (window, console) {\n    var is_array = function (obj) {\n        return Object.prototype.toString.call(obj) === '[object Array]';\n    },\n    registerViewabilityInterest = function(){\n       mraidObject.");
        stringBuilder.append(JavascriptInteractor.getExecutorMethodName());
        stringBuilder.append("(\"RegisterViewabilityInterest\", null);\n");
        stringBuilder.append("    },\n");
        stringBuilder.append("    deregisterViewabilityInterest = function(){\n");
        stringBuilder.append("       mraidObject.");
        stringBuilder.append(JavascriptInteractor.getExecutorMethodName());
        stringBuilder.append("(\"DeregisterViewabilityInterest\", null);\n");
        stringBuilder.append("    },\n");
        stringBuilder.append("    forEach = function (array, fn) {\n");
        stringBuilder.append("        var i;\n");
        stringBuilder.append("        for (i = 0; i < array.length; i++) {\n");
        stringBuilder.append("            if (i in array) {\n");
        stringBuilder.append("                fn.call(null, array[i], i);\n");
        stringBuilder.append("            }\n");
        stringBuilder.append("        }\n");
        stringBuilder.append("    },\n");
        stringBuilder.append("    events = {\n");
        stringBuilder.append("            error: 'error',\n");
        stringBuilder.append("            ready: 'ready',\n");
        stringBuilder.append("            sizeChange: 'sizeChange',\n");
        stringBuilder.append("            stateChange: 'stateChange',\n");
        stringBuilder.append("            viewableChange: 'viewableChange'\n");
        stringBuilder.append("    },\n");
        stringBuilder.append("    states = [\"loading\",\"default\",\"expanded\",\"resized\",\"hidden\"],\n");
        stringBuilder.append("    placementTypes = [\"inline\", \"interstitial\"],\n");
        stringBuilder.append("    listeners = [],\n");
        stringBuilder.append("    version = '2.0',\n");
        stringBuilder.append("    currentState = \"loading\",\n");
        stringBuilder.append("    currentlyViewable = false,\n");
        stringBuilder.append("    supportedFeatures = null,\n");
        stringBuilder.append("    orientationProperties = {\"allowOrientationChange\":true,\"forceOrientation\":\"none\"},\n");
        stringBuilder.append("    // Error Event fires listeners\n");
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
        stringBuilder.append("    },\n");
        stringBuilder.append("    debug = function(msg) {\n");
        stringBuilder.append("        console.log(\"MRAID log: \" + msg);\n");
        stringBuilder.append("    },\n");
        stringBuilder.append("    readyEvent = function() {\n");
        stringBuilder.append("        debug(\"MRAID ready\");\n");
        stringBuilder.append("        invokeListeners(\"ready\");\n");
        stringBuilder.append("    },\n");
        stringBuilder.append("    errorEvent = function(message, action) {\n");
        stringBuilder.append("        debug(\"error: \" + message + \" action: \" + action);\n");
        stringBuilder.append("        var args = [message, action];\n");
        stringBuilder.append("        invokeListeners(\"error\", args);\n");
        stringBuilder.append("    },\n");
        stringBuilder.append("    stateChangeEvent = function(state) {\n");
        stringBuilder.append("        debug(\"stateChange: \" + state);\n");
        stringBuilder.append("        var args = [state];\n");
        stringBuilder.append("        currentState = state;\n");
        stringBuilder.append("        invokeListeners(\"stateChange\", args);\n");
        stringBuilder.append("    },\n");
        stringBuilder.append("    viewableChangeEvent = function(viewable) {\n");
        stringBuilder.append("        if (viewable != currentlyViewable) {");
        stringBuilder.append("            debug(\"viewableChange: \" + viewable);\n");
        stringBuilder.append("            var args = [viewable];\n");
        stringBuilder.append("            invokeListeners(\"viewableChange\", args);\n");
        stringBuilder.append("            currentlyViewable = viewable;\n");
        stringBuilder.append("        }\n");
        stringBuilder.append("    }, \n");
        stringBuilder.append("    sizeChangeEvent = function(width, height) {\n");
        stringBuilder.append("        debug(\"sizeChange: \" + width + \"x\" + height);\n");
        stringBuilder.append("        var args = [width, height];\n");
        stringBuilder.append("        invokeListeners(\"sizeChange\", args);\n");
        stringBuilder.append("    };\n");
        stringBuilder.append("    window.mraidBridge = {\n");
        stringBuilder.append("            error : errorEvent,\n");
        stringBuilder.append("            ready : readyEvent,\n");
        stringBuilder.append("            stateChange : stateChangeEvent,\n");
        stringBuilder.append("            sizeChange : sizeChangeEvent,\n");
        stringBuilder.append("            viewableChange : viewableChangeEvent\n");
        stringBuilder.append("    };\n");
        stringBuilder.append("    // Define the mraid object\n");
        stringBuilder.append("    window.mraid = {\n");
        stringBuilder.append("            // Command Flow\n");
        stringBuilder.append("            addEventListener : function(event, listener){\n");
        stringBuilder.append("                var eventListeners = listeners[event] || [],\n");
        stringBuilder.append("                alreadyRegistered = false;\n");
        stringBuilder.append("                \n");
        stringBuilder.append("                //verify the event is one that will actually occur\n");
        stringBuilder.append("                if (!events.hasOwnProperty(event)){\n");
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
        stringBuilder.append("                    debug('Registering Listener for ' + event + ': ' + listener)\n");
        stringBuilder.append("                    listeners[event].push(listener);\n");
        stringBuilder.append("                    if (event = 'viewableChange'){ \n");
        stringBuilder.append("                       registerViewabilityInterest();  \n");
        stringBuilder.append("                    } \n");
        stringBuilder.append("                }\n");
        stringBuilder.append("            },\n");
        stringBuilder.append("            removeEventListener : function(event, listener){\n");
        stringBuilder.append("                if (listeners.hasOwnProperty(event)) {\n");
        stringBuilder.append("                    var eventListeners = listeners[event];\n");
        stringBuilder.append("                    if (eventListeners) {\n");
        stringBuilder.append("                        var idx = eventListeners.indexOf(listener);\n");
        stringBuilder.append("                        if (idx !== -1) {\n");
        stringBuilder.append("                           eventListeners.splice(idx, 1);\n");
        stringBuilder.append("                           if (event = 'viewableChange'){ \n");
        stringBuilder.append("                               deregisterViewabilityInterest();  \n");
        stringBuilder.append("                           } \n");
        stringBuilder.append("                        }\n");
        stringBuilder.append("                    }\n");
        stringBuilder.append("                }\n");
        stringBuilder.append("            },\n");
        stringBuilder.append("            useCustomClose: function(bool){\n");
        stringBuilder.append("                mraidObject.");
        stringBuilder.append(JavascriptInteractor.getExecutorMethodName());
        stringBuilder.append("(\"UseCustomClose\", JSON.stringify({useCustomClose: bool}));\n");
        stringBuilder.append("            },\n");
        stringBuilder.append("            // Support\n");
        stringBuilder.append("            supports: function(feature){\n");
        stringBuilder.append("                if (!supportedFeatures)\n");
        stringBuilder.append("                {\n");
        stringBuilder.append("                    supportedFeatures = JSON.parse(mraidObject.");
        stringBuilder.append(JavascriptInteractor.getExecutorMethodName());
        stringBuilder.append("(\"Supports\", null));\n");
        stringBuilder.append("                }\n");
        stringBuilder.append("                return supportedFeatures[feature];\n");
        stringBuilder.append("            },\n");
        stringBuilder.append("            // Properties\n");
        stringBuilder.append("            getVersion: function(){\n");
        stringBuilder.append("                return version;\n");
        stringBuilder.append("            },\n");
        stringBuilder.append("            getState: function(){\n");
        stringBuilder.append("                return currentState;\n");
        stringBuilder.append("            },\n");
        stringBuilder.append("            getPlacementType: function(){\n");
        stringBuilder.append("                var json = JSON.parse(mraidObject.");
        stringBuilder.append(JavascriptInteractor.getExecutorMethodName());
        stringBuilder.append("(\"GetPlacementType\", null));\n");
        stringBuilder.append("                return json.placementType;\n");
        stringBuilder.append("            },\n");
        stringBuilder.append("            isViewable: function(){\n");
        stringBuilder.append("                var json = JSON.parse(mraidObject.");
        stringBuilder.append(JavascriptInteractor.getExecutorMethodName());
        stringBuilder.append("(\"IsViewable\", null));\n");
        stringBuilder.append("                return json.isViewable;\n");
        stringBuilder.append("            },\n");
        stringBuilder.append("            getExpandProperties: function(){\n");
        stringBuilder.append("                return JSON.parse(mraidObject.");
        stringBuilder.append(JavascriptInteractor.getExecutorMethodName());
        stringBuilder.append("(\"GetExpandProperties\", null));\n");
        stringBuilder.append("            },\n");
        stringBuilder.append("            setExpandProperties: function(properties){\n");
        stringBuilder.append("                //Backwards compatibility with MRAID 1.0 creatives\n");
        stringBuilder.append("                if (!!properties.lockOrientation){\n");
        stringBuilder.append("                    mraid.setOrientationProperties({\"allowOrientationChange\":false});\n");
        stringBuilder.append("                }\n");
        stringBuilder.append("                mraidObject.");
        stringBuilder.append(JavascriptInteractor.getExecutorMethodName());
        stringBuilder.append("(\"SetExpandProperties\", JSON.stringify(properties));\n");
        stringBuilder.append("            },\n");
        stringBuilder.append("            getOrientationProperties: function(){\n");
        stringBuilder.append("                return orientationProperties;\n");
        stringBuilder.append("            },\n");
        stringBuilder.append("            setOrientationProperties: function(properties){\n");
        stringBuilder.append("                mraidObject.");
        stringBuilder.append(JavascriptInteractor.getExecutorMethodName());
        stringBuilder.append("(\"SetOrientationProperties\", JSON.stringify(properties));\n");
        stringBuilder.append("            },\n");
        stringBuilder.append("            getResizeProperties: function(){\n");
        stringBuilder.append("                return JSON.parse(mraidObject.");
        stringBuilder.append(JavascriptInteractor.getExecutorMethodName());
        stringBuilder.append("(\"GetResizeProperties\", null));\n");
        stringBuilder.append("            },\n");
        stringBuilder.append("            setResizeProperties: function(properties){\n");
        stringBuilder.append("                mraidObject.");
        stringBuilder.append(JavascriptInteractor.getExecutorMethodName());
        stringBuilder.append("(\"SetResizeProperties\", JSON.stringify(properties));\n");
        stringBuilder.append("            },\n");
        stringBuilder.append("            getCurrentPosition: function(){\n");
        stringBuilder.append("                return JSON.parse(mraidObject.");
        stringBuilder.append(JavascriptInteractor.getExecutorMethodName());
        stringBuilder.append("(\"GetCurrentPosition\", null));\n");
        stringBuilder.append("            },\n");
        stringBuilder.append("            getMaxSize: function(){\n");
        stringBuilder.append("                return JSON.parse(mraidObject.");
        stringBuilder.append(JavascriptInteractor.getExecutorMethodName());
        stringBuilder.append("(\"GetMaxSize\", null));\n");
        stringBuilder.append("            },\n");
        stringBuilder.append("            getDefaultPosition: function(){\n");
        stringBuilder.append("                return JSON.parse(mraidObject.");
        stringBuilder.append(JavascriptInteractor.getExecutorMethodName());
        stringBuilder.append("(\"GetDefaultPosition\", null));\n");
        stringBuilder.append("            },\n");
        stringBuilder.append("            getScreenSize: function(){\n");
        stringBuilder.append("                return JSON.parse(mraidObject.");
        stringBuilder.append(JavascriptInteractor.getExecutorMethodName());
        stringBuilder.append("(\"GetScreenSize\", null));\n");
        stringBuilder.append("            },\n");
        stringBuilder.append("            // Operations\n");
        stringBuilder.append("            open: function(url) {\n");
        stringBuilder.append("                mraidObject.");
        stringBuilder.append(JavascriptInteractor.getExecutorMethodName());
        stringBuilder.append("(\"Open\", JSON.stringify({url: url}));\n");
        stringBuilder.append("            },\n");
        stringBuilder.append("            close: function() {\n");
        stringBuilder.append("                mraidObject.");
        stringBuilder.append(JavascriptInteractor.getExecutorMethodName());
        stringBuilder.append("(\"Close\", null);\n");
        stringBuilder.append("            },\n");
        stringBuilder.append("            expand: function(url) {\n");
        stringBuilder.append("                if (url !== undefined) {\n");
        stringBuilder.append("                    mraidObject.");
        stringBuilder.append(JavascriptInteractor.getExecutorMethodName());
        stringBuilder.append("(\"Expand\", JSON.stringify({url: url}));\n");
        stringBuilder.append("                } else {\n");
        stringBuilder.append("                    mraidObject.");
        stringBuilder.append(JavascriptInteractor.getExecutorMethodName());
        stringBuilder.append("(\"Expand\", JSON.stringify({url: \"\"}));\n");
        stringBuilder.append("                }\n");
        stringBuilder.append("            },\n");
        stringBuilder.append("            resize: function() {\n");
        stringBuilder.append("                mraidObject.");
        stringBuilder.append(JavascriptInteractor.getExecutorMethodName());
        stringBuilder.append("(\"Resize\", null);\n");
        stringBuilder.append("            },\n");
        stringBuilder.append("            createCalendarEvent: function(eventObject) {\n");
        stringBuilder.append("                mraidObject.");
        stringBuilder.append(JavascriptInteractor.getExecutorMethodName());
        stringBuilder.append("(\"CreateCalendarEvent\", JSON.stringify(eventObject));\n");
        stringBuilder.append("            },\n");
        stringBuilder.append("            playVideo: function(url){\n");
        stringBuilder.append("                mraidObject.");
        stringBuilder.append(JavascriptInteractor.getExecutorMethodName());
        stringBuilder.append("(\"PlayVideo\", JSON.stringify({url: url}));\n");
        stringBuilder.append("            },\n");
        stringBuilder.append("            storePicture: function(url){\n");
        stringBuilder.append("                mraidObject.");
        stringBuilder.append(JavascriptInteractor.getExecutorMethodName());
        stringBuilder.append("(\"StorePicture\", JSON.stringify({url: url}));\n");
        stringBuilder.append("            }\n");
        stringBuilder.append("    };\n");
        stringBuilder.append("})(window, console);\n");
        stringBuilder.append("");
        JAVASCRIPT = stringBuilder.toString();
    }

    MRAIDAdSDKBridge(AdControlAccessor adControlAccessor, JavascriptInteractor javascriptInteractor) {
        this(adControlAccessor, javascriptInteractor, new PermissionChecker(), new MobileAdsLoggerFactory(), new WebRequest.WebRequestFactory(), ThreadUtils.getThreadRunner(), new GraphicsUtils(), new Object(){

            public AlertDialog.Builder createBuilder(Context context) {
                return new AlertDialog.Builder(context);
            }
        }, new WebUtils2(), new AdUtils2(), new IntentBuilderFactory(), new ExpandProperties(), new OrientationProperties(), new Position(), new ResizeProperties(), new AndroidBuildInfo(), new LayoutFactory(), new ViewUtils());
    }

    MRAIDAdSDKBridge(AdControlAccessor adControlAccessor, JavascriptInteractor javascriptInteractor, PermissionChecker permissionChecker, MobileAdsLoggerFactory mobileAdsLoggerFactory, WebRequest.WebRequestFactory webRequestFactory, ThreadUtils.ThreadRunner threadRunner, GraphicsUtils graphicsUtils, AlertDialogFactory alertDialogFactory, WebUtils2 webUtils2, AdUtils2 adUtils2, IntentBuilderFactory intentBuilderFactory, ExpandProperties expandProperties, OrientationProperties orientationProperties, Position position, ResizeProperties resizeProperties, AndroidBuildInfo androidBuildInfo, LayoutFactory layoutFactory, ViewUtils viewUtils) {
        this.adControlAccessor = adControlAccessor;
        this.javascriptInteractor = javascriptInteractor;
        this.logger = mobileAdsLoggerFactory.createMobileAdsLogger(LOGTAG);
        this.permissionChecker = permissionChecker;
        this.webRequestFactory = webRequestFactory;
        this.threadRunner = threadRunner;
        this.graphicsUtils = graphicsUtils;
        this.alertDialogFactory = alertDialogFactory;
        this.webUtils = webUtils2;
        this.adUtils = adUtils2;
        this.intentBuilderFactory = intentBuilderFactory;
        this.expandProperties = expandProperties;
        this.orientationProperties = orientationProperties;
        this.defaultPosition = position;
        this.resizeProperties = resizeProperties;
        this.buildInfo = androidBuildInfo;
        this.layoutFactory = layoutFactory;
        this.viewUtils = viewUtils;
        this.populateJavascriptExecutorsInInteractor();
    }

    static /* synthetic */ void access$1000(MRAIDAdSDKBridge mRAIDAdSDKBridge, ResizeProperties resizeProperties, Size size, Size size2) {
        mRAIDAdSDKBridge.resizeAdHelper(resizeProperties, size, size2);
    }

    static /* synthetic */ ViewUtils access$1100(MRAIDAdSDKBridge mRAIDAdSDKBridge) {
        return mRAIDAdSDKBridge.viewUtils;
    }

    static /* synthetic */ ViewGroup access$1200(MRAIDAdSDKBridge mRAIDAdSDKBridge) {
        return mRAIDAdSDKBridge.resizedView;
    }

    static /* synthetic */ void access$200(MRAIDAdSDKBridge mRAIDAdSDKBridge, String string) {
        mRAIDAdSDKBridge.fetchPicture(string);
    }

    static /* synthetic */ void access$300(MRAIDAdSDKBridge mRAIDAdSDKBridge, Bitmap bitmap) {
        mRAIDAdSDKBridge.savePicture(bitmap);
    }

    static /* synthetic */ Context access$400(MRAIDAdSDKBridge mRAIDAdSDKBridge) {
        return mRAIDAdSDKBridge.getContext();
    }

    static /* synthetic */ GraphicsUtils access$500(MRAIDAdSDKBridge mRAIDAdSDKBridge) {
        return mRAIDAdSDKBridge.graphicsUtils;
    }

    static /* synthetic */ void access$600(MRAIDAdSDKBridge mRAIDAdSDKBridge, String string, String string2) {
        mRAIDAdSDKBridge.fireErrorEvent(string, string2);
    }

    static /* synthetic */ void access$700(MRAIDAdSDKBridge mRAIDAdSDKBridge, AdControlAccessor adControlAccessor) {
        mRAIDAdSDKBridge.collapseExpandedAdOnThread(adControlAccessor);
    }

    static /* synthetic */ void access$800(MRAIDAdSDKBridge mRAIDAdSDKBridge, ResizeProperties resizeProperties, Size size) {
        mRAIDAdSDKBridge.resizeAdOnThread(resizeProperties, size);
    }

    static /* synthetic */ AdControlAccessor access$900(MRAIDAdSDKBridge mRAIDAdSDKBridge) {
        return mRAIDAdSDKBridge.adControlAccessor;
    }

    @SuppressLint(value={"InlinedApi"})
    private void collapseExpandedAdOnThread(AdControlAccessor adControlAccessor) {
        adControlAccessor.setAdActivity(null);
        if (this.expandedWithUrl) {
            this.logger.d("Expanded With URL");
            adControlAccessor.popView();
        } else {
            this.logger.d("Not Expanded with URL");
        }
        adControlAccessor.moveViewBackToParent((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1, 17));
        adControlAccessor.removeCloseButton();
        adControlAccessor.fireAdEvent(new AdEvent(AdEvent.AdEventType.CLOSED));
        adControlAccessor.injectJavascript("mraidBridge.stateChange('default');");
        adControlAccessor.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(this, adControlAccessor){
            final /* synthetic */ MRAIDAdSDKBridge this$0;
            final /* synthetic */ AdControlAccessor val$adControlAccessor;
            {
                this.this$0 = mRAIDAdSDKBridge;
                this.val$adControlAccessor = adControlAccessor;
            }

            public void onGlobalLayout() {
                this.val$adControlAccessor.removeOnGlobalLayoutListener(this);
                this.this$0.reportSizeChangeEvent();
            }
        });
    }

    private Size computeResizeSizeInPixels(ResizeProperties resizeProperties) {
        int n2 = resizeProperties.getWidth();
        int n3 = resizeProperties.getHeight();
        return new Size(this.adUtils.deviceIndependentPixelToPixel(n2), this.adUtils.deviceIndependentPixelToPixel(n3));
    }

    @TargetApi(value=14)
    private void createCalendarIntent(CalendarEventParameters calendarEventParameters) {
        Intent intent = new Intent("android.intent.action.INSERT").setType("vnd.android.cursor.item/event");
        intent.putExtra("title", calendarEventParameters.getDescription());
        if (!StringUtils.isNullOrEmpty(calendarEventParameters.getLocation())) {
            intent.putExtra("eventLocation", calendarEventParameters.getLocation());
        }
        if (!StringUtils.isNullOrEmpty(calendarEventParameters.getSummary())) {
            intent.putExtra("description", calendarEventParameters.getSummary());
        }
        intent.putExtra("beginTime", calendarEventParameters.getStart().getTime());
        if (calendarEventParameters.getEnd() != null) {
            intent.putExtra("endTime", calendarEventParameters.getEnd().getTime());
        }
        this.getContext().startActivity(intent);
    }

    private void createResizedView() {
        if (this.resizedView == null) {
            if (this.rootView == null) {
                this.rootView = (FrameLayout)this.adControlAccessor.getRootView();
            }
            this.resizedView = this.layoutFactory.createLayout(this.getContext(), LayoutFactory.LayoutType.RELATIVE_LAYOUT, CONTENT_DESCRIPTION_RESIZED_VIEW);
        }
    }

    private void deregisterViewabilityInterest() {
        this.adControlAccessor.deregisterViewabilityInterest();
    }

    private void fetchPicture(String string) {
        WebRequest.WebResponse webResponse;
        block3 : {
            WebRequest webRequest = this.webRequestFactory.createWebRequest();
            webRequest.enableLog(true);
            webRequest.setUrlString(string);
            try {
                webResponse = webRequest.makeCall();
                if (webResponse != null) break block3;
            }
            catch (WebRequest.WebRequestException webRequestException) {
                this.fireErrorEvent("Server could not be contacted to download picture.", "storePicture");
                return;
            }
            this.fireErrorEvent("Server could not be contacted to download picture.", "storePicture");
            return;
        }
        Bitmap bitmap = new ImageResponseReader(webResponse.getResponseReader(), this.graphicsUtils).readAsBitmap();
        if (bitmap == null) {
            this.fireErrorEvent("Picture could not be retrieved from server.", "storePicture");
            return;
        }
        this.threadRunner.execute(new Runnable(this, bitmap){
            final /* synthetic */ MRAIDAdSDKBridge this$0;
            final /* synthetic */ Bitmap val$bitmap;
            {
                this.this$0 = mRAIDAdSDKBridge;
                this.val$bitmap = bitmap;
            }

            public void run() {
                MRAIDAdSDKBridge.access$300(this.this$0, this.val$bitmap);
            }
        }, ThreadUtils.ExecutionStyle.SCHEDULE, ThreadUtils.ExecutionThread.MAIN_THREAD);
    }

    private void fireErrorEvent(String string, String string2) {
        this.adControlAccessor.injectJavascript(String.format((Locale)Locale.US, (String)ERROR_EVENT_FORMAT, (Object[])new Object[]{string, string2}));
    }

    private AdControlAccessor getAdControlAccessor() {
        return this.adControlAccessor;
    }

    private Context getContext() {
        return this.adControlAccessor.getContext();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private boolean isValidClosePosition(RelativePosition var1_1, int var2_2, int var3_3, Size var4_4, int var5_5, int var6_6) {
        block9 : {
            block10 : {
                var7_7 = this.adUtils.deviceIndependentPixelToPixel(50);
                switch (12.$SwitchMap$com$amazon$device$ads$RelativePosition[var1_1.ordinal()]) {
                    default: {
                        var8_8 = 0;
                        var2_2 = 0;
                        var3_3 = 0;
                        var9_9 = 0;
                        break block9;
                    }
                    case 7: {
                        var15_10 = var2_2 + var4_4.getHeight() / 2;
                        var16_11 = var7_7 / 2;
                        var17_12 = var15_10 - var16_11;
                        var3_3 = var3_3 + var4_4.getWidth() / 2 - var16_11;
                        var18_13 = var17_12 + var7_7;
                        var9_9 = var3_3 + var7_7;
                        var2_2 = var17_12;
                        var8_8 = var18_13;
                        break block9;
                    }
                    case 6: {
                        var8_8 = var2_2 + var4_4.getHeight();
                        var3_3 = var3_3 + var4_4.getWidth() / 2 - var7_7 / 2;
                        ** GOTO lbl33
                    }
                    case 5: {
                        var8_8 = var2_2 + var4_4.getHeight();
                        var13_14 = var3_3 + var4_4.getWidth();
                        var14_15 = var8_8 - var7_7;
                        var12_16 = var13_14 - var7_7;
                        var9_9 = var13_14;
                        var2_2 = var14_15;
                        ** GOTO lbl44
                    }
                    case 4: {
                        var8_8 = var2_2 + var4_4.getHeight();
lbl33: // 2 sources:
                        var2_2 = var8_8 - var7_7;
                        break block10;
                    }
                    case 3: {
                        var3_3 = var3_3 + var4_4.getWidth() / 2 - var7_7 / 2;
                        break;
                    }
                    case 2: {
                        var10_17 = var3_3 + var4_4.getWidth();
                        var11_18 = var2_2 + var7_7;
                        var12_16 = var10_17 - var7_7;
                        var9_9 = var10_17;
                        var8_8 = var11_18;
lbl44: // 2 sources:
                        var3_3 = var12_16;
                        break block9;
                    }
                    case 1: 
                }
                var8_8 = var2_2 + var7_7;
            }
            var9_9 = var3_3 + var7_7;
        }
        if (var2_2 < 0) return false;
        if (var3_3 < 0) return false;
        if (var8_8 > var6_6) return false;
        if (var9_9 <= var5_5) return true;
        return false;
    }

    private boolean isViewable() {
        return this.adControlAccessor.isViewable();
    }

    private void launchExpandActivity(String string, ExpandProperties expandProperties) {
        if (this.intentBuilderFactory.createIntentBuilder().withClass(AdActivity.class).withContext(this.adControlAccessor.getContext().getApplicationContext()).withExtra("adapter", ModalAdActivityAdapter.class.getName()).withExtra("url", string).withExtra("expandProperties", expandProperties.toString()).withExtra("orientationProperties", this.orientationProperties.toString()).fireIntent()) {
            this.logger.d("Successfully expanded ad");
        }
    }

    private void populateJavascriptExecutorsInInteractor() {
        this.javascriptInteractor.addMethodExecutor(new CloseJSIF(this));
        this.javascriptInteractor.addMethodExecutor(new CreateCalendarEventJSIF(this));
        this.javascriptInteractor.addMethodExecutor(new ExpandJSIF(this));
        this.javascriptInteractor.addMethodExecutor(new GetCurrentPositionJSIF(this));
        this.javascriptInteractor.addMethodExecutor(new GetDefaultPositionJSIF(this));
        this.javascriptInteractor.addMethodExecutor(new GetExpandPropertiesJSIF(this));
        this.javascriptInteractor.addMethodExecutor(new GetMaxSizeJSIF(this));
        this.javascriptInteractor.addMethodExecutor(new GetPlacementTypeJSIF(this));
        this.javascriptInteractor.addMethodExecutor(new GetResizePropertiesJSIF(this));
        this.javascriptInteractor.addMethodExecutor(new GetScreenSizeJSIF(this));
        this.javascriptInteractor.addMethodExecutor(new OpenJSIF(this));
        this.javascriptInteractor.addMethodExecutor(new PlayVideoJSIF(this));
        this.javascriptInteractor.addMethodExecutor(new ResizeJSIF(this));
        this.javascriptInteractor.addMethodExecutor(new SetExpandPropertiesJSIF(this));
        this.javascriptInteractor.addMethodExecutor(new SetOrientationPropertiesJSIF(this));
        this.javascriptInteractor.addMethodExecutor(new SetResizePropertiesJSIF(this));
        this.javascriptInteractor.addMethodExecutor(new StorePictureJSIF(this));
        this.javascriptInteractor.addMethodExecutor(new SupportsJSIF(this));
        this.javascriptInteractor.addMethodExecutor(new UseCustomCloseJSIF(this));
        this.javascriptInteractor.addMethodExecutor(new IsViewableJSIF(this));
        this.javascriptInteractor.addMethodExecutor(new RegisterViewabilityInterestJSIF(this));
        this.javascriptInteractor.addMethodExecutor(new DeregisterViewabilityInterestJSIF(this));
    }

    private void registerViewabilityInterest() {
        this.adControlAccessor.registerViewabilityInterest();
    }

    private void resizeAdHelper(ResizeProperties resizeProperties, Size size, Size size2) {
        if (size2 == null) {
            this.logger.d("Size is null");
            return;
        }
        this.createResizedView();
        int n2 = this.adUtils.deviceIndependentPixelToPixel(this.defaultPosition.getX() + resizeProperties.getOffsetX());
        int n3 = this.adUtils.deviceIndependentPixelToPixel(this.defaultPosition.getY() + resizeProperties.getOffsetY());
        RelativePosition relativePosition = RelativePosition.fromString(resizeProperties.getCustomClosePosition());
        int n4 = this.adUtils.deviceIndependentPixelToPixel(size2.getWidth());
        int n5 = this.adUtils.deviceIndependentPixelToPixel(size2.getHeight());
        if (!resizeProperties.getAllowOffscreen()) {
            if (size.getWidth() > n4) {
                size.setWidth(n4);
            }
            if (size.getHeight() > n5) {
                size.setHeight(n5);
            }
            if (n2 < 0) {
                n2 = 0;
            } else if (n2 + size.getWidth() > n4) {
                n2 = n4 - size.getWidth();
            }
            if (n3 < 0) {
                n3 = 0;
            } else if (n3 + size.getHeight() > n5) {
                n3 = n5 - size.getHeight();
            }
        } else if (!this.isValidClosePosition(relativePosition, n3, n2, size, n4, n5)) {
            this.fireErrorEvent("Resize failed because close event area must be entirely on screen.", "resize");
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(size.getWidth(), size.getHeight());
        this.adControlAccessor.moveViewToViewGroup(this.resizedView, (ViewGroup.LayoutParams)layoutParams, false);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(size.getWidth(), size.getHeight());
        layoutParams2.gravity = 48;
        layoutParams2.leftMargin = n2;
        layoutParams2.topMargin = n3;
        if (this.rootView.equals((Object)this.resizedView.getParent())) {
            this.resizedView.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
        } else {
            this.rootView.addView((View)this.resizedView, (ViewGroup.LayoutParams)layoutParams2);
        }
        this.adControlAccessor.enableCloseButton(false, relativePosition);
        ViewTreeObserver viewTreeObserver = this.resizedView.getViewTreeObserver();
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(this, viewTreeObserver){
            final /* synthetic */ MRAIDAdSDKBridge this$0;
            final /* synthetic */ ViewTreeObserver val$vto;
            {
                this.this$0 = mRAIDAdSDKBridge;
                this.val$vto = viewTreeObserver;
            }

            public void onGlobalLayout() {
                MRAIDAdSDKBridge.access$1100(this.this$0).removeOnGlobalLayoutListener(this.val$vto, this);
                int[] arrn = new int[2];
                MRAIDAdSDKBridge.access$1200(this.this$0).getLocationOnScreen(arrn);
                android.graphics.Rect rect = new android.graphics.Rect(arrn[0], arrn[1], arrn[0] + MRAIDAdSDKBridge.access$1200(this.this$0).getWidth(), arrn[1] + MRAIDAdSDKBridge.access$1200(this.this$0).getHeight());
                AdEvent adEvent = new AdEvent(AdEvent.AdEventType.RESIZED);
                adEvent.setParameter("positionOnScreen", (Object)rect);
                MRAIDAdSDKBridge.access$900(this.this$0).fireAdEvent(adEvent);
                MRAIDAdSDKBridge.access$900(this.this$0).injectJavascript("mraidBridge.stateChange('resized');");
                this.this$0.reportSizeChangeEvent();
            }
        });
    }

    private void resizeAdOnThread(ResizeProperties resizeProperties, Size size) {
        Size size2 = this.adControlAccessor.getMaxSize();
        if (size2 == null) {
            this.adControlAccessor.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(this, resizeProperties, size){
                final /* synthetic */ MRAIDAdSDKBridge this$0;
                final /* synthetic */ ResizeProperties val$resizeProperties;
                final /* synthetic */ Size val$resizeSize;
                {
                    this.this$0 = mRAIDAdSDKBridge;
                    this.val$resizeProperties = resizeProperties;
                    this.val$resizeSize = size;
                }

                public void onGlobalLayout() {
                    MRAIDAdSDKBridge.access$900(this.this$0).removeOnGlobalLayoutListener(this);
                    Size size = MRAIDAdSDKBridge.access$900(this.this$0).getMaxSize();
                    MRAIDAdSDKBridge.access$1000(this.this$0, this.val$resizeProperties, this.val$resizeSize, size);
                }
            });
            return;
        }
        this.resizeAdHelper(resizeProperties, size, size2);
    }

    private void savePicture(Bitmap bitmap) {
        AlertDialog.Builder builder = this.alertDialogFactory.createBuilder(this.getContext());
        builder.setTitle((CharSequence)"Would you like to save the image to your gallery?");
        builder.setPositiveButton((CharSequence)"Yes", new DialogInterface.OnClickListener(this, bitmap){
            final /* synthetic */ MRAIDAdSDKBridge this$0;
            final /* synthetic */ Bitmap val$bitmap;
            {
                this.this$0 = mRAIDAdSDKBridge;
                this.val$bitmap = bitmap;
            }

            public void onClick(DialogInterface dialogInterface, int n2) {
                String string = MRAIDAdSDKBridge.access$500(this.this$0).insertImageInMediaStore(MRAIDAdSDKBridge.access$400(this.this$0), this.val$bitmap, "AdImage", "Image created by rich media ad.");
                if (StringUtils.isNullOrEmpty(string)) {
                    MRAIDAdSDKBridge.access$600(this.this$0, "Picture could not be stored to device.", "storePicture");
                    return;
                }
                android.media.MediaScannerConnection.scanFile((Context)MRAIDAdSDKBridge.access$400(this.this$0), (String[])new String[]{string}, null, null);
            }
        });
        builder.setNegativeButton((CharSequence)"No", new DialogInterface.OnClickListener(this){
            final /* synthetic */ MRAIDAdSDKBridge this$0;
            {
                this.this$0 = mRAIDAdSDKBridge;
            }

            public void onClick(DialogInterface dialogInterface, int n2) {
                MRAIDAdSDKBridge.access$600(this.this$0, "User chose not to store image.", "storePicture");
            }
        });
        builder.show();
    }

    private void showNativeCloseButtonIfNeeded() {
        if (this.adControlAccessor.isModal()) {
            this.adControlAccessor.showNativeCloseButtonImage(true ^ this.expandProperties.getUseCustomClose());
        }
    }

    public void close() {
        if (!this.adControlAccessor.closeAd()) {
            this.fireErrorEvent("Unable to close ad in its current state.", "close");
        }
    }

    void collapseExpandedAd(AdControlAccessor adControlAccessor) {
        MobileAdsLogger mobileAdsLogger = this.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Collapsing expanded ad ");
        stringBuilder.append((Object)this);
        mobileAdsLogger.d(stringBuilder.toString());
        this.threadRunner.execute(new Runnable(this, adControlAccessor){
            final /* synthetic */ MRAIDAdSDKBridge this$0;
            final /* synthetic */ AdControlAccessor val$adControlAccessor;
            {
                this.this$0 = mRAIDAdSDKBridge;
                this.val$adControlAccessor = adControlAccessor;
            }

            public void run() {
                MRAIDAdSDKBridge.access$700(this.this$0, this.val$adControlAccessor);
            }
        }, ThreadUtils.ExecutionStyle.RUN_ASAP, ThreadUtils.ExecutionThread.MAIN_THREAD);
    }

    public void createCalendarEvent(String string, String string2, String string3, String string4, String string5) {
        CalendarEventParameters calendarEventParameters;
        if (!AndroidTargetUtils.isAtLeastAndroidAPI(14)) {
            this.logger.d("API version does not support calendar operations.");
            this.fireErrorEvent("API version does not support calendar operations.", "createCalendarEvent");
            return;
        }
        try {
            calendarEventParameters = new CalendarEventParameters(string, string2, string3, string4, string5);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            this.logger.d(illegalArgumentException.getMessage());
            this.fireErrorEvent(illegalArgumentException.getMessage(), "createCalendarEvent");
            return;
        }
        this.createCalendarIntent(calendarEventParameters);
    }

    public void expand(String string) {
        if (this.adControlAccessor.isInterstitial()) {
            this.fireErrorEvent("Unable to expand an interstitial ad placement", "expand");
            return;
        }
        if (this.adControlAccessor.isModal()) {
            this.fireErrorEvent("Unable to expand while expanded.", "expand");
            return;
        }
        if (!this.adControlAccessor.isVisible()) {
            this.fireErrorEvent("Unable to expand ad while it is not visible.", "expand");
            return;
        }
        if (this.expandProperties.getWidth() < 50 && this.expandProperties.getWidth() != -1 || this.expandProperties.getHeight() < 50 && this.expandProperties.getHeight() != -1) {
            this.fireErrorEvent("Expand size is too small, must leave room for close.", "expand");
            return;
        }
        if (!StringUtils.isNullOrWhiteSpace(string)) {
            if (this.webUtils.isUrlValid(string)) {
                final ExpandProperties expandProperties = this.expandProperties.toClone();
                this.adControlAccessor.preloadUrl(string, new PreloadCallback(){

                    @Override
                    public void onPreloadComplete(String string) {
                        MRAIDAdSDKBridge.this.getAdControlAccessor().injectJavascriptPreload("mraidBridge.stateChange('expanded');");
                        MRAIDAdSDKBridge.this.getAdControlAccessor().injectJavascriptPreload("mraidBridge.ready();");
                        AdControllerFactory.cacheAdControlAccessor(MRAIDAdSDKBridge.this.getAdControlAccessor());
                        MRAIDAdSDKBridge.this.launchExpandActivity(string, expandProperties);
                    }
                });
                return;
            }
            this.fireErrorEvent("Unable to expand with invalid URL.", "expand");
            return;
        }
        AdControllerFactory.cacheAdControlAccessor(this.adControlAccessor);
        this.launchExpandActivity(null, this.expandProperties);
    }

    public JSONObject getCurrentPosition() {
        if (this.adControlAccessor.getCurrentPosition() == null) {
            this.fireErrorEvent("Current position is unavailable because the ad has not yet been displayed.", "getCurrentPosition");
            return new Position(new Size(0, 0), 0, 0).toJSONObject();
        }
        return this.adControlAccessor.getCurrentPosition().toJSONObject();
    }

    public JSONObject getDefaultPosition() {
        return this.defaultPosition.toJSONObject();
    }

    public JSONObject getExpandPropertiesForCreative() {
        Size size;
        ExpandProperties expandProperties = this.expandProperties.toClone();
        if (expandProperties.getWidth() == -1) {
            size = this.adControlAccessor.getScreenSize();
            expandProperties.setWidth(size.getWidth());
        } else {
            size = null;
        }
        if (expandProperties.getHeight() == -1) {
            if (size == null) {
                size = this.adControlAccessor.getScreenSize();
            }
            expandProperties.setHeight(size.getHeight());
        }
        return expandProperties.toJSONObject();
    }

    @Override
    public String getJavascript() {
        return JAVASCRIPT;
    }

    @Override
    public JavascriptInteractor.Executor getJavascriptInteractorExecutor() {
        return this.javascriptInteractor.getExecutor();
    }

    public JSONObject getMaxSize() {
        Size size = this.adControlAccessor.getMaxSize();
        if (size == null) {
            return new Size(0, 0).toJSONObject();
        }
        return size.toJSONObject();
    }

    @Override
    public String getName() {
        return MRAID_BRIDGE_NAME;
    }

    public String getOrientationProperties() {
        return this.orientationProperties.toString();
    }

    public String getPlacementType() {
        if (this.adControlAccessor.isInterstitial()) {
            return PLACEMENT_TYPE_INTERSTITIAL;
        }
        return PLACEMENT_TYPE_INLINE;
    }

    public JSONObject getResizeProperties() {
        return this.resizeProperties.toJSONObject();
    }

    @Override
    public SDKEventListener getSDKEventListener() {
        if (this.sdkEventListener == null) {
            this.sdkEventListener = new MRAIDAdSDKEventListener(this);
        }
        return this.sdkEventListener;
    }

    public JSONObject getScreenSize() {
        Size size = this.adControlAccessor.getScreenSize();
        if (size == null) {
            return new Size(0, 0).toJSONObject();
        }
        return size.toJSONObject();
    }

    public JSONObject getSupportedFeatures() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        try {
            jSONObject.put("sms", this.getContext().getPackageManager().hasSystemFeature("android.hardware.telephony"));
            jSONObject.put("tel", this.getContext().getPackageManager().hasSystemFeature("android.hardware.telephony"));
            jSONObject.put("calendar", AndroidTargetUtils.isAtLeastAndroidAPI(14));
            jSONObject.put("storePicture", this.permissionChecker.hasWriteExternalStoragePermission(this.getContext()));
            jSONObject.put("inlineVideo", AndroidTargetUtils.isAtLeastAndroidAPI(11));
        }
        catch (JSONException jSONException) {}
        return jSONObject;
    }

    @Override
    public boolean hasNativeExecution() {
        return true;
    }

    public void open(String string) {
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
            String string2 = WebUtils.getScheme(string);
            if (!"http".equals((Object)string2) && !"https".equals((Object)string2)) {
                this.adControlAccessor.loadUrl(string);
                return;
            }
            new Object(){
                private static final String LOGTAG = "InAppBrowserBuilder";
                private final com.amazon.device.ads.Assets assets;
                private Context context;
                private final MobileAdsLogger logger;
                private boolean showOpenExternalBrowserButton;
                private String url;
                {
                    this(com.amazon.device.ads.Assets.getInstance(), new MobileAdsLoggerFactory());
                }
                {
                    this.assets = assets;
                    this.logger = mobileAdsLoggerFactory.createMobileAdsLogger(LOGTAG);
                }

                public void show() {
                    if (this.context != null) {
                        if (!StringUtils.isNullOrWhiteSpace(this.url)) {
                            if (!this.assets.ensureAssetsCreated()) {
                                MobileAdsLogger mobileAdsLogger = this.logger;
                                Object[] arrobject = new Object[]{this.url};
                                mobileAdsLogger.e("Could not load application assets, failed to open URI: %s", arrobject);
                                return;
                            }
                            Intent intent = new Intent(this.context, AdActivity.class);
                            intent.putExtra("adapter", InAppBrowser.class.getName());
                            intent.putExtra(InAppBrowser.URL_EXTRA, this.url);
                            intent.putExtra(InAppBrowser.SHOW_OPEN_EXTERNAL_BROWSER_BTN, this.showOpenExternalBrowserButton);
                            intent.addFlags(268435456);
                            this.context.startActivity(intent);
                            return;
                        }
                        throw new IllegalArgumentException("Url must not be null or white space");
                    }
                    throw new IllegalArgumentException("Context must not be null");
                }

                public InAppBrowser.InAppBrowserBuilder withContext(Context context) {
                    this.context = context;
                    return this;
                }

                public InAppBrowser.InAppBrowserBuilder withExternalBrowserButton() {
                    this.showOpenExternalBrowserButton = true;
                    return this;
                }

                public InAppBrowser.InAppBrowserBuilder withUrl(String string) {
                    this.url = string;
                    return this;
                }
            }.withContext(this.getContext()).withExternalBrowserButton().withUrl(string).show();
            return;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("URL ");
        stringBuilder2.append(string);
        stringBuilder2.append(" is not a valid URL");
        String string3 = stringBuilder2.toString();
        this.logger.d(string3);
        this.fireErrorEvent(string3, "open");
    }

    void orientationPropertyChange() {
        if (this.adControlAccessor.isVisible()) {
            if (!this.adControlAccessor.isModal()) {
                return;
            }
            Activity activity = this.adControlAccessor.getAdActivity();
            if (activity == null) {
                this.logger.e("unable to handle orientation property change on a non-expanded ad");
                return;
            }
            int n2 = activity.getRequestedOrientation();
            Position position = this.adControlAccessor.getCurrentPosition();
            MobileAdsLogger mobileAdsLogger = this.logger;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Current Orientation: ");
            stringBuilder.append(n2);
            mobileAdsLogger.d(stringBuilder.toString());
            int n3 = 12.$SwitchMap$com$amazon$device$ads$ForceOrientation[this.orientationProperties.getForceOrientation().ordinal()];
            if (n3 != 1) {
                if (n3 == 2) {
                    activity.setRequestedOrientation(6);
                }
            } else {
                activity.setRequestedOrientation(7);
            }
            if (ForceOrientation.NONE.equals((Object)this.orientationProperties.getForceOrientation())) {
                if (this.orientationProperties.isAllowOrientationChange().booleanValue()) {
                    if (activity.getRequestedOrientation() != -1) {
                        activity.setRequestedOrientation(-1);
                    }
                } else if (this.adControlAccessor.isModal()) {
                    activity.setRequestedOrientation(DisplayUtils.determineCanonicalScreenOrientation((Context)activity, this.buildInfo));
                }
            }
            int n4 = activity.getRequestedOrientation();
            MobileAdsLogger mobileAdsLogger2 = this.logger;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("New Orientation: ");
            stringBuilder2.append(n4);
            mobileAdsLogger2.d(stringBuilder2.toString());
            if (n4 != n2 && position != null) {
                Position position2 = this.adControlAccessor.getCurrentPosition();
                if (position.getSize().getWidth() != position2.getSize().getWidth()) {
                    this.adControlAccessor.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(this){
                        final /* synthetic */ MRAIDAdSDKBridge this$0;
                        {
                            this.this$0 = mRAIDAdSDKBridge;
                        }

                        public void onGlobalLayout() {
                            MRAIDAdSDKBridge.access$900(this.this$0).removeOnGlobalLayoutListener(this);
                            this.this$0.reportSizeChangeEvent();
                        }
                    });
                }
            }
        }
    }

    public void playVideo(String string) {
        if (!this.adControlAccessor.isVisible()) {
            this.fireErrorEvent("Unable to play a video while the ad is not visible", "playVideo");
            return;
        }
        if (StringUtils.isNullOrEmpty(string)) {
            this.fireErrorEvent("Unable to play a video without a URL", "playVideo");
            return;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putString("url", string);
            Intent intent = new Intent(this.getContext(), AdActivity.class);
            intent.putExtra("adapter", VideoActionHandler.class.getName());
            intent.putExtras(bundle);
            this.getContext().startActivity(intent);
            return;
        }
        catch (ActivityNotFoundException activityNotFoundException) {
            this.logger.d("Failed to open VideoAction activity");
            this.fireErrorEvent("Internal SDK Failure. Unable to launch VideoActionHandler", "playVideo");
            return;
        }
    }

    void reportSizeChangeEvent() {
        Position position = this.adControlAccessor.getCurrentPosition();
        if (position != null) {
            AdControlAccessor adControlAccessor = this.adControlAccessor;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("mraidBridge.sizeChange(");
            stringBuilder.append(position.getSize().getWidth());
            stringBuilder.append(",");
            stringBuilder.append(position.getSize().getHeight());
            stringBuilder.append(");");
            adControlAccessor.injectJavascript(stringBuilder.toString());
        }
    }

    public void resize() {
        if (this.adControlAccessor.isInterstitial()) {
            this.fireErrorEvent("Unable to resize an interstitial ad placement.", "resize");
            return;
        }
        if (this.adControlAccessor.isModal()) {
            this.fireErrorEvent("Unable to resize while expanded.", "resize");
            return;
        }
        if (!this.adControlAccessor.isVisible()) {
            this.fireErrorEvent("Unable to resize ad while it is not visible.", "resize");
            return;
        }
        ResizeProperties resizeProperties = this.resizeProperties;
        if (resizeProperties != null && resizeProperties.areResizePropertiesSet()) {
            this.resizeAd(this.resizeProperties);
            return;
        }
        this.fireErrorEvent("Resize properties must be set before calling resize.", "resize");
    }

    void resizeAd(ResizeProperties resizeProperties) {
        Size size = this.computeResizeSizeInPixels(resizeProperties);
        this.threadRunner.execute(new Runnable(this, resizeProperties, size){
            final /* synthetic */ MRAIDAdSDKBridge this$0;
            final /* synthetic */ ResizeProperties val$resizeProperties;
            final /* synthetic */ Size val$resizeSize;
            {
                this.this$0 = mRAIDAdSDKBridge;
                this.val$resizeProperties = resizeProperties;
                this.val$resizeSize = size;
            }

            public void run() {
                MRAIDAdSDKBridge.access$800(this.this$0, this.val$resizeProperties, this.val$resizeSize);
            }
        }, ThreadUtils.ExecutionStyle.RUN_ASAP, ThreadUtils.ExecutionThread.MAIN_THREAD);
    }

    public void setExpandProperties(JSONObject jSONObject) {
        this.expandProperties.fromJSONObject(jSONObject);
        this.showNativeCloseButtonIfNeeded();
    }

    public void setOrientationProperties(JSONObject jSONObject) {
        if (this.adControlAccessor.isInterstitial() && !this.adControlAccessor.isModal()) {
            this.adControlAccessor.orientationChangeAttemptedWhenNotAllowed();
        }
        this.orientationProperties.fromJSONObject(jSONObject);
        this.orientationPropertyChange();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void setResizeProperties(JSONObject jSONObject) {
        if (!this.resizeProperties.fromJSONObject(jSONObject)) {
            this.fireErrorEvent("Invalid resize properties", "setResizeProperties");
            return;
        }
        if (this.resizeProperties.getWidth() >= 50 && this.resizeProperties.getHeight() >= 50) {
            Size size = this.adControlAccessor.getMaxSize();
            if (this.resizeProperties.getWidth() <= size.getWidth() && this.resizeProperties.getHeight() <= size.getHeight()) {
                if (!this.resizeProperties.getAllowOffscreen()) return;
                Size size2 = this.computeResizeSizeInPixels(this.resizeProperties);
                int n2 = this.adUtils.deviceIndependentPixelToPixel(this.defaultPosition.getX() + this.resizeProperties.getOffsetX());
                int n3 = this.adUtils.deviceIndependentPixelToPixel(this.defaultPosition.getY() + this.resizeProperties.getOffsetY());
                if (this.isValidClosePosition(RelativePosition.fromString(this.resizeProperties.getCustomClosePosition()), n3, n2, size2, this.adUtils.deviceIndependentPixelToPixel(size.getWidth()), this.adUtils.deviceIndependentPixelToPixel(size.getHeight()))) return;
                this.fireErrorEvent("Invalid resize properties. Close event area must be entirely on screen.", "setResizeProperties");
                this.resizeProperties.reset();
                return;
            }
            this.fireErrorEvent("Resize properties width and height cannot be larger than the maximum size.", "setResizeProperties");
            this.resizeProperties.reset();
            return;
        }
        this.fireErrorEvent("Resize properties width and height must be greater than 50dp in order to fit the close button.", "setResizeProperties");
        this.resizeProperties.reset();
    }

    public void setUseCustomClose(boolean bl) {
        this.expandProperties.setUseCustomClose(bl);
        this.showNativeCloseButtonIfNeeded();
    }

    public void storePicture(String string) {
        if (!this.permissionChecker.hasWriteExternalStoragePermission(this.getContext())) {
            this.fireErrorEvent("Picture could not be stored because permission was denied.", "storePicture");
            return;
        }
        this.threadRunner.execute(new Runnable(this, string){
            final /* synthetic */ MRAIDAdSDKBridge this$0;
            final /* synthetic */ String val$url;
            {
                this.this$0 = mRAIDAdSDKBridge;
                this.val$url = string;
            }

            public void run() {
                MRAIDAdSDKBridge.access$200(this.this$0, this.val$url);
            }
        }, ThreadUtils.ExecutionStyle.RUN_ASAP, ThreadUtils.ExecutionThread.BACKGROUND_THREAD);
    }

    void updateDefaultPosition(int n2, int n3, int n4, int n5) {
        this.defaultPosition.setSize(new Size(n2, n3));
        this.defaultPosition.setX(n4);
        this.defaultPosition.setY(n5);
    }

    private static class CloseJSIF
    extends JavascriptInteractor.JavascriptMethodExecutor {
        private static final String name = "Close";
        private final MRAIDAdSDKBridge bridge;

        public CloseJSIF(MRAIDAdSDKBridge mRAIDAdSDKBridge) {
            super(name);
            this.bridge = mRAIDAdSDKBridge;
        }

        @Override
        public JSONObject execute(JSONObject jSONObject) {
            this.bridge.close();
            return null;
        }
    }

    private static class CreateCalendarEventJSIF
    extends JavascriptInteractor.JavascriptMethodExecutor {
        private static final String name = "CreateCalendarEvent";
        private final MRAIDAdSDKBridge bridge;

        public CreateCalendarEventJSIF(MRAIDAdSDKBridge mRAIDAdSDKBridge) {
            super(name);
            this.bridge = mRAIDAdSDKBridge;
        }

        @Override
        public JSONObject execute(JSONObject jSONObject) {
            this.bridge.createCalendarEvent(JSONUtils.getStringFromJSON(jSONObject, "description", null), JSONUtils.getStringFromJSON(jSONObject, "location", null), JSONUtils.getStringFromJSON(jSONObject, "summary", null), JSONUtils.getStringFromJSON(jSONObject, "start", null), JSONUtils.getStringFromJSON(jSONObject, "end", null));
            return null;
        }
    }

    private static class DeregisterViewabilityInterestJSIF
    extends JavascriptInteractor.JavascriptMethodExecutor {
        private static final String name = "DeregisterViewabilityInterest";
        private final MRAIDAdSDKBridge bridge;

        public DeregisterViewabilityInterestJSIF(MRAIDAdSDKBridge mRAIDAdSDKBridge) {
            super(name);
            this.bridge = mRAIDAdSDKBridge;
        }

        @Override
        protected JSONObject execute(JSONObject jSONObject) {
            this.bridge.deregisterViewabilityInterest();
            return null;
        }
    }

    private static class ExpandJSIF
    extends JavascriptInteractor.JavascriptMethodExecutor {
        private static final String name = "Expand";
        private final MRAIDAdSDKBridge bridge;

        public ExpandJSIF(MRAIDAdSDKBridge mRAIDAdSDKBridge) {
            super(name);
            this.bridge = mRAIDAdSDKBridge;
        }

        @Override
        public JSONObject execute(JSONObject jSONObject) {
            this.bridge.expand(JSONUtils.getStringFromJSON(jSONObject, "url", null));
            return null;
        }
    }

    private static class GetCurrentPositionJSIF
    extends JavascriptInteractor.JavascriptMethodExecutor {
        private static final String name = "GetCurrentPosition";
        private final MRAIDAdSDKBridge bridge;

        public GetCurrentPositionJSIF(MRAIDAdSDKBridge mRAIDAdSDKBridge) {
            super(name);
            this.bridge = mRAIDAdSDKBridge;
        }

        @Override
        public JSONObject execute(JSONObject jSONObject) {
            return this.bridge.getCurrentPosition();
        }
    }

    private static class GetDefaultPositionJSIF
    extends JavascriptInteractor.JavascriptMethodExecutor {
        private static final String name = "GetDefaultPosition";
        private final MRAIDAdSDKBridge bridge;

        public GetDefaultPositionJSIF(MRAIDAdSDKBridge mRAIDAdSDKBridge) {
            super(name);
            this.bridge = mRAIDAdSDKBridge;
        }

        @Override
        public JSONObject execute(JSONObject jSONObject) {
            return this.bridge.getDefaultPosition();
        }
    }

    private static class GetExpandPropertiesJSIF
    extends JavascriptInteractor.JavascriptMethodExecutor {
        private static final String name = "GetExpandProperties";
        private final MRAIDAdSDKBridge bridge;

        public GetExpandPropertiesJSIF(MRAIDAdSDKBridge mRAIDAdSDKBridge) {
            super(name);
            this.bridge = mRAIDAdSDKBridge;
        }

        @Override
        public JSONObject execute(JSONObject jSONObject) {
            return this.bridge.getExpandPropertiesForCreative();
        }
    }

    private static class GetMaxSizeJSIF
    extends JavascriptInteractor.JavascriptMethodExecutor {
        private static final String name = "GetMaxSize";
        private final MRAIDAdSDKBridge bridge;

        public GetMaxSizeJSIF(MRAIDAdSDKBridge mRAIDAdSDKBridge) {
            super(name);
            this.bridge = mRAIDAdSDKBridge;
        }

        @Override
        public JSONObject execute(JSONObject jSONObject) {
            return this.bridge.getMaxSize();
        }
    }

    private static class GetPlacementTypeJSIF
    extends JavascriptInteractor.JavascriptMethodExecutor {
        private static final String name = "GetPlacementType";
        private final MRAIDAdSDKBridge bridge;

        public GetPlacementTypeJSIF(MRAIDAdSDKBridge mRAIDAdSDKBridge) {
            super(name);
            this.bridge = mRAIDAdSDKBridge;
        }

        @Override
        public JSONObject execute(JSONObject jSONObject) {
            JSONObject jSONObject2 = new JSONObject();
            JSONUtils.put(jSONObject2, "placementType", this.bridge.getPlacementType());
            return jSONObject2;
        }
    }

    private static class GetResizePropertiesJSIF
    extends JavascriptInteractor.JavascriptMethodExecutor {
        private static final String name = "GetResizeProperties";
        private final MRAIDAdSDKBridge bridge;

        public GetResizePropertiesJSIF(MRAIDAdSDKBridge mRAIDAdSDKBridge) {
            super(name);
            this.bridge = mRAIDAdSDKBridge;
        }

        @Override
        public JSONObject execute(JSONObject jSONObject) {
            return this.bridge.getResizeProperties();
        }
    }

    private static class GetScreenSizeJSIF
    extends JavascriptInteractor.JavascriptMethodExecutor {
        private static final String name = "GetScreenSize";
        private final MRAIDAdSDKBridge bridge;

        public GetScreenSizeJSIF(MRAIDAdSDKBridge mRAIDAdSDKBridge) {
            super(name);
            this.bridge = mRAIDAdSDKBridge;
        }

        @Override
        public JSONObject execute(JSONObject jSONObject) {
            return this.bridge.getScreenSize();
        }
    }

    private static class IsViewableJSIF
    extends JavascriptInteractor.JavascriptMethodExecutor {
        private static final String name = "IsViewable";
        private final MRAIDAdSDKBridge bridge;

        public IsViewableJSIF(MRAIDAdSDKBridge mRAIDAdSDKBridge) {
            super(name);
            this.bridge = mRAIDAdSDKBridge;
        }

        @Override
        public JSONObject execute(JSONObject jSONObject) {
            JSONObject jSONObject2 = new JSONObject();
            JSONUtils.put(jSONObject2, "isViewable", this.bridge.isViewable());
            return jSONObject2;
        }
    }

    private static class OpenJSIF
    extends JavascriptInteractor.JavascriptMethodExecutor {
        private static final String name = "Open";
        private final MRAIDAdSDKBridge bridge;

        public OpenJSIF(MRAIDAdSDKBridge mRAIDAdSDKBridge) {
            super(name);
            this.bridge = mRAIDAdSDKBridge;
        }

        @Override
        public JSONObject execute(JSONObject jSONObject) {
            this.bridge.open(JSONUtils.getStringFromJSON(jSONObject, "url", null));
            return null;
        }
    }

    private static class PlayVideoJSIF
    extends JavascriptInteractor.JavascriptMethodExecutor {
        private static final String name = "PlayVideo";
        private final MRAIDAdSDKBridge bridge;

        public PlayVideoJSIF(MRAIDAdSDKBridge mRAIDAdSDKBridge) {
            super(name);
            this.bridge = mRAIDAdSDKBridge;
        }

        @Override
        public JSONObject execute(JSONObject jSONObject) {
            this.bridge.playVideo(JSONUtils.getStringFromJSON(jSONObject, "url", null));
            return null;
        }
    }

    private static class RegisterViewabilityInterestJSIF
    extends JavascriptInteractor.JavascriptMethodExecutor {
        private static final String name = "RegisterViewabilityInterest";
        private final MRAIDAdSDKBridge bridge;

        public RegisterViewabilityInterestJSIF(MRAIDAdSDKBridge mRAIDAdSDKBridge) {
            super(name);
            this.bridge = mRAIDAdSDKBridge;
        }

        @Override
        protected JSONObject execute(JSONObject jSONObject) {
            this.bridge.registerViewabilityInterest();
            return null;
        }
    }

    private static class ResizeJSIF
    extends JavascriptInteractor.JavascriptMethodExecutor {
        private static final String name = "Resize";
        private final MRAIDAdSDKBridge bridge;

        public ResizeJSIF(MRAIDAdSDKBridge mRAIDAdSDKBridge) {
            super(name);
            this.bridge = mRAIDAdSDKBridge;
        }

        @Override
        public JSONObject execute(JSONObject jSONObject) {
            this.bridge.resize();
            return null;
        }
    }

    private static class SetExpandPropertiesJSIF
    extends JavascriptInteractor.JavascriptMethodExecutor {
        private static final String name = "SetExpandProperties";
        private final MRAIDAdSDKBridge bridge;

        public SetExpandPropertiesJSIF(MRAIDAdSDKBridge mRAIDAdSDKBridge) {
            super(name);
            this.bridge = mRAIDAdSDKBridge;
        }

        @Override
        public JSONObject execute(JSONObject jSONObject) {
            this.bridge.setExpandProperties(jSONObject);
            return null;
        }
    }

    private static class SetOrientationPropertiesJSIF
    extends JavascriptInteractor.JavascriptMethodExecutor {
        private static final String name = "SetOrientationProperties";
        private final MRAIDAdSDKBridge bridge;

        public SetOrientationPropertiesJSIF(MRAIDAdSDKBridge mRAIDAdSDKBridge) {
            super(name);
            this.bridge = mRAIDAdSDKBridge;
        }

        @Override
        public JSONObject execute(JSONObject jSONObject) {
            this.bridge.setOrientationProperties(jSONObject);
            return null;
        }
    }

    private static class SetResizePropertiesJSIF
    extends JavascriptInteractor.JavascriptMethodExecutor {
        private static final String name = "SetResizeProperties";
        private final MRAIDAdSDKBridge bridge;

        public SetResizePropertiesJSIF(MRAIDAdSDKBridge mRAIDAdSDKBridge) {
            super(name);
            this.bridge = mRAIDAdSDKBridge;
        }

        @Override
        public JSONObject execute(JSONObject jSONObject) {
            this.bridge.setResizeProperties(jSONObject);
            return null;
        }
    }

    private static class StorePictureJSIF
    extends JavascriptInteractor.JavascriptMethodExecutor {
        private static final String name = "StorePicture";
        private final MRAIDAdSDKBridge bridge;

        public StorePictureJSIF(MRAIDAdSDKBridge mRAIDAdSDKBridge) {
            super(name);
            this.bridge = mRAIDAdSDKBridge;
        }

        @Override
        public JSONObject execute(JSONObject jSONObject) {
            this.bridge.storePicture(JSONUtils.getStringFromJSON(jSONObject, "url", null));
            return null;
        }
    }

    private static class SupportsJSIF
    extends JavascriptInteractor.JavascriptMethodExecutor {
        private static final String name = "Supports";
        private final MRAIDAdSDKBridge bridge;

        public SupportsJSIF(MRAIDAdSDKBridge mRAIDAdSDKBridge) {
            super(name);
            this.bridge = mRAIDAdSDKBridge;
        }

        @Override
        public JSONObject execute(JSONObject jSONObject) {
            return this.bridge.getSupportedFeatures();
        }
    }

    private static class UseCustomCloseJSIF
    extends JavascriptInteractor.JavascriptMethodExecutor {
        private static final String name = "UseCustomClose";
        private final MRAIDAdSDKBridge bridge;

        public UseCustomCloseJSIF(MRAIDAdSDKBridge mRAIDAdSDKBridge) {
            super(name);
            this.bridge = mRAIDAdSDKBridge;
        }

        @Override
        public JSONObject execute(JSONObject jSONObject) {
            this.bridge.setUseCustomClose(JSONUtils.getBooleanFromJSON(jSONObject, "useCustomClose", false));
            return null;
        }
    }

}

