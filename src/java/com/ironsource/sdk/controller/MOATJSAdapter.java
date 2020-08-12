/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.webkit.WebView
 *  com.ironsource.sdk.analytics.moat.MOATManager$EventsListener
 *  com.ironsource.sdk.controller.IronSourceWebView
 *  com.ironsource.sdk.controller.MOATJSAdapter$1
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.ironsource.sdk.controller;

import android.app.Application;
import android.webkit.WebView;
import com.ironsource.sdk.analytics.moat.MOATManager;
import com.ironsource.sdk.controller.IronSourceWebView;
import com.ironsource.sdk.controller.MOATJSAdapter;
import org.json.JSONException;
import org.json.JSONObject;

public class MOATJSAdapter {
    private Application mApplication;

    public MOATJSAdapter(Application application) {
        this.mApplication = application;
    }

    private MOATManager.EventsListener createEventListener(IronSourceWebView.JSInterface.JSCallbackTask jSCallbackTask, String string, String string2) {
        return new 1(this, jSCallbackTask, string, string2);
    }

    private FunctionCall fetchFunctionCall(String string) throws JSONException {
        JSONObject jSONObject = new JSONObject(string);
        FunctionCall functionCall = new FunctionCall();
        functionCall.name = jSONObject.optString("moatFunction");
        functionCall.params = jSONObject.optJSONObject("moatParams");
        functionCall.successCallback = jSONObject.optString("success");
        functionCall.failCallback = jSONObject.optString("fail");
        return functionCall;
    }

    void call(String string, IronSourceWebView.JSInterface.JSCallbackTask jSCallbackTask, WebView webView) throws Exception {
        FunctionCall functionCall = this.fetchFunctionCall(string);
        if ("initWithOptions".equals((Object)functionCall.name)) {
            MOATManager.initWithOptions(functionCall.params, this.mApplication);
            return;
        }
        if ("createAdTracker".equals((Object)functionCall.name) && webView != null) {
            MOATManager.createAdTracker(webView);
            return;
        }
        if ("startTracking".equals((Object)functionCall.name)) {
            MOATManager.setEventListener(this.createEventListener(jSCallbackTask, functionCall.successCallback, functionCall.failCallback));
            MOATManager.startTracking();
            return;
        }
        if ("stopTracking".equals((Object)functionCall.name)) {
            MOATManager.setEventListener(this.createEventListener(jSCallbackTask, functionCall.successCallback, functionCall.failCallback));
            MOATManager.stopTracking();
        }
    }

    private static class FunctionCall {
        String failCallback;
        String name;
        JSONObject params;
        String successCallback;

        private FunctionCall() {
        }
    }

}

