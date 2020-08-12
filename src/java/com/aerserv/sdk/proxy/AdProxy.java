/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.AsyncTask
 *  com.aerserv.sdk.proxy.AdProxy$1
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package com.aerserv.sdk.proxy;

import android.os.AsyncTask;
import com.aerserv.sdk.controller.listener.FetchAdListener;
import com.aerserv.sdk.http.HttpTask;
import com.aerserv.sdk.http.HttpTaskListener;
import com.aerserv.sdk.proxy.AdProxy;
import java.util.List;

public class AdProxy {
    public void getAd(String string, List<String> list, FetchAdListener fetchAdListener, boolean bl) {
        new HttpTask(string, (HttpTaskListener)new 1(this, bl, fetchAdListener)).execute(new Object[0]);
    }
}

