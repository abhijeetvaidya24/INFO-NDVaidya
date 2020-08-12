/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.AsyncTask
 *  com.aerserv.sdk.proxy.FetchAsplcProxy$1
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 *  java.util.Map
 */
package com.aerserv.sdk.proxy;

import android.content.Context;
import android.os.AsyncTask;
import com.aerserv.sdk.controller.listener.FetchAsplcListener;
import com.aerserv.sdk.http.HttpTask;
import com.aerserv.sdk.http.HttpTaskListener;
import com.aerserv.sdk.proxy.FetchAsplcProxy;
import com.aerserv.sdk.utils.UrlBuilder;
import java.util.List;
import java.util.Map;

public class FetchAsplcProxy {
    private static final String LOG_TAG = "FetchAsplcProxy";
    private HttpTask httpTask = null;
    private int statusCode = 0;

    static /* synthetic */ String access$000() {
        return LOG_TAG;
    }

    static /* synthetic */ int access$102(FetchAsplcProxy fetchAsplcProxy, int n2) {
        fetchAsplcProxy.statusCode = n2;
        return n2;
    }

    public void cancel() {
        HttpTask httpTask = this.httpTask;
        if (httpTask != null) {
            httpTask.disconnect();
        }
    }

    public void fetchAdapterList(Context context, String string, FetchAsplcListener fetchAsplcListener, List<String> list, String string2, String string3, Map<String, String> map, String string4, boolean bl, boolean bl2, String string5, boolean bl3, boolean bl4, String string6, int n2) {
        UrlBuilder urlBuilder = new UrlBuilder(context, string, list, map, string4, bl, bl2, string5, bl3, bl4, string6);
        this.httpTask = new HttpTask(urlBuilder.buildUrl(), (HttpTaskListener)new 1(this, fetchAsplcListener), n2 - 120);
        this.httpTask.execute(new Object[0]);
    }

    public int getStatusCode() {
        return this.statusCode;
    }
}

