/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.AsyncTask
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.List
 *  java.util.Map
 *  java.util.concurrent.Executor
 *  org.json.JSONObject
 */
package com.aerserv.sdk.proxy;

import android.os.AsyncTask;
import com.aerserv.sdk.AerServSettings;
import com.aerserv.sdk.http.HttpPostListenerTask;
import com.aerserv.sdk.http.HttpTaskListener;
import com.aerserv.sdk.utils.AerServLog;
import com.aerserv.sdk.utils.VersionUtils;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;

public class PreInitProxy {
    private static final String LOG_TAG = "PreInitProxy";
    private HttpPostListenerTask httpTask = null;

    public void cancel() {
        HttpPostListenerTask httpPostListenerTask = this.httpTask;
        if (httpPostListenerTask != null) {
            httpPostListenerTask.disconnect();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void fetchConfig(String string, String string2, HttpTaskListener httpTaskListener) {
        if (!VersionUtils.checkVersion(14)) {
            httpTaskListener.onHttpTaskSuccess(null, 0, null, null);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("application", (Object)"Android SDK");
            jSONObject.put("version", (Object)"3.1.1");
            if (string != null && !string.trim().isEmpty()) {
                jSONObject.put("siteId", (Object)string.trim());
            } else if (string2 != null && !string2.isEmpty()) {
                jSONObject.put("placementId", (Object)string2.trim());
            }
            this.httpTask = new HttpPostListenerTask("https://ads.aerserv.com/as/sdk/configure/", jSONObject.toString(), httpTaskListener, -120 + AerServSettings.getInitTimeout());
            this.httpTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
            return;
        }
        catch (Exception exception) {
            String string3 = LOG_TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("pre-init: Error: ");
            stringBuilder.append(exception.getMessage());
            AerServLog.w(string3, stringBuilder.toString(), exception);
            return;
        }
    }
}

