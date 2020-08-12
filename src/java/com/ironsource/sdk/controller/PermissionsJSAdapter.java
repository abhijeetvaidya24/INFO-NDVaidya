/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.ironsource.sdk.controller.IronSourceWebView
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.ironsource.sdk.controller;

import android.content.Context;
import com.ironsource.environment.ApplicationContext;
import com.ironsource.sdk.controller.IronSourceWebView;
import com.ironsource.sdk.data.SSAObj;
import com.ironsource.sdk.utils.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PermissionsJSAdapter {
    private static final String TAG = "PermissionsJSAdapter";
    private Context mContext;

    public PermissionsJSAdapter(Context context) {
        this.mContext = context;
    }

    private FunctionCall fetchFunctionCall(String string) throws JSONException {
        JSONObject jSONObject = new JSONObject(string);
        FunctionCall functionCall = new FunctionCall();
        functionCall.name = jSONObject.optString("functionName");
        functionCall.params = jSONObject.optJSONObject("functionParams");
        functionCall.successCallback = jSONObject.optString("success");
        functionCall.failureCallback = jSONObject.optString("fail");
        return functionCall;
    }

    void call(String string, IronSourceWebView.JSInterface.JSCallbackTask jSCallbackTask) throws Exception {
        FunctionCall functionCall = this.fetchFunctionCall(string);
        if ("getPermissions".equals((Object)functionCall.name)) {
            this.getPermissions(functionCall.params, functionCall, jSCallbackTask);
            return;
        }
        if ("isPermissionGranted".equals((Object)functionCall.name)) {
            this.isPermissionGranted(functionCall.params, functionCall, jSCallbackTask);
            return;
        }
        String string2 = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PermissionsJSAdapter unhandled API request ");
        stringBuilder.append(string);
        Logger.i(string2, stringBuilder.toString());
    }

    public void getPermissions(JSONObject jSONObject, FunctionCall functionCall, IronSourceWebView.JSInterface.JSCallbackTask jSCallbackTask) {
        SSAObj sSAObj = new SSAObj();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("permissions");
            sSAObj.put("permissions", ApplicationContext.getPermissions(this.mContext, jSONArray));
            jSCallbackTask.sendMessage(true, functionCall.successCallback, sSAObj);
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            String string = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("PermissionsJSAdapter getPermissions JSON Exception when getting permissions parameter ");
            stringBuilder.append(exception.getMessage());
            Logger.i(string, stringBuilder.toString());
            sSAObj.put("errMsg", exception.getMessage());
            jSCallbackTask.sendMessage(false, functionCall.failureCallback, sSAObj);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void isPermissionGranted(JSONObject jSONObject, FunctionCall functionCall, IronSourceWebView.JSInterface.JSCallbackTask jSCallbackTask) {
        SSAObj sSAObj = new SSAObj();
        try {
            String string = jSONObject.getString("permission");
            sSAObj.put("permission", string);
            boolean bl2 = ApplicationContext.isValidPermission(this.mContext, string);
            if (bl2) {
                sSAObj.put("status", String.valueOf((boolean)ApplicationContext.isPermissionGranted(this.mContext, string)));
                jSCallbackTask.sendMessage(true, functionCall.successCallback, sSAObj);
                return;
            }
            sSAObj.put("status", "unhandledPermission");
            jSCallbackTask.sendMessage(false, functionCall.failureCallback, sSAObj);
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            sSAObj.put("errMsg", exception.getMessage());
            jSCallbackTask.sendMessage(false, functionCall.failureCallback, sSAObj);
            return;
        }
    }

    private static class FunctionCall {
        String failureCallback;
        String name;
        JSONObject params;
        String successCallback;

        private FunctionCall() {
        }
    }

}

