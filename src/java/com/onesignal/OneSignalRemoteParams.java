/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.onesignal.OneSignalRemoteParams$1
 *  com.onesignal.OneSignalRemoteParams$2
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.onesignal;

import com.onesignal.OneSignal;
import com.onesignal.OneSignalRemoteParams;
import com.onesignal.OneSignalRestClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class OneSignalRemoteParams {
    private static int androidParamsReties;

    static /* synthetic */ int access$000() {
        return androidParamsReties;
    }

    static /* synthetic */ int access$008() {
        int n2 = androidParamsReties;
        androidParamsReties = n2 + 1;
        return n2;
    }

    static /* synthetic */ void access$100(String string2, CallBack callBack) {
        OneSignalRemoteParams.processJson(string2, callBack);
    }

    static void makeAndroidParamsRequest(CallBack callBack) {
        1 var1_1 = new 1(callBack);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("apps/");
        stringBuilder.append(OneSignal.appId);
        stringBuilder.append("/android_params.js");
        String string2 = stringBuilder.toString();
        String string3 = OneSignal.getUserId();
        if (string3 != null) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(string2);
            stringBuilder2.append("?player_id=");
            stringBuilder2.append(string3);
            string2 = stringBuilder2.toString();
        }
        OneSignal.Log(OneSignal.LOG_LEVEL.DEBUG, "Starting request to get Android parameters.");
        OneSignalRestClient.get(string2, (OneSignalRestClient.ResponseHandler)var1_1, "CACHE_KEY_REMOTE_PARAMS");
    }

    private static void processJson(String string2, CallBack callBack) {
        void var3_5;
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(string2);
        }
        catch (JSONException jSONException) {
        }
        catch (NullPointerException nullPointerException) {
            // empty catch block
        }
        callBack.complete((Params)new 2(jSONObject));
        return;
        OneSignal.Log(OneSignal.LOG_LEVEL.FATAL, "Error parsing android_params!: ", (Throwable)var3_5);
        OneSignal.LOG_LEVEL lOG_LEVEL = OneSignal.LOG_LEVEL.FATAL;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Response that errored from android_params!: ");
        stringBuilder.append(string2);
        OneSignal.Log(lOG_LEVEL, stringBuilder.toString());
    }

    static interface CallBack {
        public void complete(Params var1);
    }

    static class Params {
        boolean enterprise;
        boolean firebaseAnalytics;
        String googleProjectNumber;
        JSONArray notificationChannels;
        boolean restoreTTLFilter;
        boolean useEmailAuth;

        Params() {
        }
    }

}

