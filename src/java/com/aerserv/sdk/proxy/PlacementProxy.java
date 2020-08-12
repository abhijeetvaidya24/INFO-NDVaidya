/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.AsyncTask
 *  com.aerserv.sdk.proxy.PlacementProxy$1
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 *  java.util.Map
 */
package com.aerserv.sdk.proxy;

import android.content.Context;
import android.os.AsyncTask;
import com.aerserv.sdk.controller.listener.FetchPlacementListener;
import com.aerserv.sdk.http.HttpPostListenerTask;
import com.aerserv.sdk.http.HttpTaskListener;
import com.aerserv.sdk.proxy.PlacementProxy;
import com.aerserv.sdk.utils.UrlBuilder;
import java.util.List;
import java.util.Map;

public class PlacementProxy {
    private static final String LOG_TAG = "PlacementProxy";
    private HttpPostListenerTask httpPostListenerTask;
    private int statusCode = 0;

    static /* synthetic */ String access$000() {
        return LOG_TAG;
    }

    static /* synthetic */ int access$102(PlacementProxy placementProxy, int n2) {
        placementProxy.statusCode = n2;
        return n2;
    }

    public void cancel() {
        HttpPostListenerTask httpPostListenerTask = this.httpPostListenerTask;
        if (httpPostListenerTask != null) {
            httpPostListenerTask.disconnect();
        }
    }

    public void fetchPlacement(Context context, String string, FetchPlacementListener fetchPlacementListener, List<String> list, String string2, String string3, Map<String, String> map, String string4, boolean bl, boolean bl2, String string5, boolean bl3, boolean bl4, String string6, int n2, boolean bl5, String string7) {
        UrlBuilder urlBuilder = new UrlBuilder(context, string, list, map, string4, bl, bl2, string5, bl3, bl4, string6);
        this.httpPostListenerTask = new HttpPostListenerTask(urlBuilder.buildUrl(), string7, (HttpTaskListener)new 1(this, bl5, fetchPlacementListener), n2 - 120);
        this.httpPostListenerTask.execute(new Object[0]);
    }

    public int getStatusCode() {
        return this.statusCode;
    }
}

