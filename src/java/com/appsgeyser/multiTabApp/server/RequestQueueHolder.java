/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.android.volley.RequestQueue
 *  com.android.volley.toolbox.Volley
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 */
package com.appsgeyser.multiTabApp.server;

import android.content.Context;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import java.util.ArrayList;

public class RequestQueueHolder {
    private static volatile boolean _ready;
    private static ArrayList<String> deferredUrls;
    private static RequestQueueHolder instance;
    private RequestQueue _queue = null;

    private RequestQueueHolder(Context context) {
        this._queue = Volley.newRequestQueue((Context)context);
        _ready = true;
    }

    public static RequestQueueHolder getInstance(Context context) {
        if (instance == null) {
            instance = new RequestQueueHolder(context);
        }
        return instance;
    }

    public RequestQueue getQueue() {
        return this._queue;
    }
}

