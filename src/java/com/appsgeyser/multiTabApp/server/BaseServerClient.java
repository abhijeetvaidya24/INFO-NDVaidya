/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.android.volley.Request
 *  com.android.volley.RequestQueue
 *  com.android.volley.Response
 *  com.android.volley.Response$ErrorListener
 *  com.android.volley.Response$Listener
 *  com.android.volley.RetryPolicy
 *  com.android.volley.toolbox.StringRequest
 *  com.appsgeyser.multiTabApp.MainNavigationActivity
 *  com.appsgeyser.multiTabApp.server.BaseServerClient$1
 *  com.appsgeyser.multiTabApp.server.BaseServerClient$2
 *  com.appsgeyser.multiTabApp.server.BaseServerClient$HandleRedirectRetryPolicy
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.net.HttpURLConnection
 */
package com.appsgeyser.multiTabApp.server;

import android.content.Context;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.toolbox.StringRequest;
import com.appsgeyser.multiTabApp.MainNavigationActivity;
import com.appsgeyser.multiTabApp.configuration.WebWidgetConfiguration;
import com.appsgeyser.multiTabApp.server.BaseServerClient;
import com.appsgeyser.multiTabApp.server.RequestQueueHolder;
import java.net.HttpURLConnection;

/*
 * Exception performing whole class analysis.
 */
public class BaseServerClient {
    protected MainNavigationActivity _activity;
    protected WebWidgetConfiguration _config;
    protected Context _context;

    public BaseServerClient(MainNavigationActivity mainNavigationActivity) {
        this._activity = mainNavigationActivity;
        this._context = mainNavigationActivity;
        this._config = mainNavigationActivity.getConfig();
    }

    public void sendRequestAsync(String string2, Integer n2, OnRequestDoneListener onRequestDoneListener) {
        HttpURLConnection.setFollowRedirects((boolean)true);
        StringRequest stringRequest = new StringRequest(string2, (Response.Listener)new 1(this, onRequestDoneListener, string2, n2), (Response.ErrorListener)new 2(this));
        stringRequest.setRetryPolicy((RetryPolicy)new /* Unavailable Anonymous Inner Class!! */);
        stringRequest.setTag((Object)n2);
        RequestQueueHolder.getInstance(this._context).getQueue().add((Request)stringRequest);
    }

    public static interface OnRequestDoneListener {
        public void onRequestDone(String var1, int var2, String var3);
    }

}

