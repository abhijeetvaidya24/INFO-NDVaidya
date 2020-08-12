/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.ConnectivityManager
 *  android.net.NetworkInfo
 *  com.android.volley.Request
 *  com.android.volley.RequestQueue
 *  com.android.volley.Response
 *  com.android.volley.Response$ErrorListener
 *  com.android.volley.Response$Listener
 *  com.android.volley.RetryPolicy
 *  com.android.volley.toolbox.StringRequest
 *  com.appsgeyser.sdk.server.network.NetworkManager$1
 *  com.appsgeyser.sdk.server.network.NetworkManager$2
 *  com.appsgeyser.sdk.server.network.NetworkManager$3
 *  com.appsgeyser.sdk.server.network.NetworkManager$4
 *  com.appsgeyser.sdk.server.network.NetworkManager$5
 *  com.appsgeyser.sdk.server.network.NetworkManager$6
 *  com.appsgeyser.sdk.server.network.NetworkManager$7
 *  com.appsgeyser.sdk.server.network.NetworkManager$HandleRedirectRetryPolicy
 *  java.lang.Enum
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.net.HttpURLConnection
 *  java.util.Map
 */
package com.appsgeyser.sdk.server.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.toolbox.StringRequest;
import com.appsgeyser.sdk.server.RequestQueueHolder;
import com.appsgeyser.sdk.server.implementation.OnRequestDoneListener;
import com.appsgeyser.sdk.server.network.NetworkManager;
import java.net.HttpURLConnection;
import java.util.Map;

/*
 * Exception performing whole class analysis.
 */
public class NetworkManager {
    private static final NetworkManager INSTANCE;

    static {
        INSTANCE = new NetworkManager();
    }

    public static NetworkManager getInstance() {
        return INSTANCE;
    }

    public static boolean isOnline(Context context) {
        NetworkInfo networkInfo = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

    public Response.ErrorListener getDefaultErrorListener(Integer n2, Context context) {
        return new 6(this, n2, context);
    }

    public OnRequestDoneListener getEmptyRequestDoneListener(Context context) {
        return new 7(this, context);
    }

    public void sendRequestAsync(String string2, Integer n2, Context context, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        HttpURLConnection.setFollowRedirects((boolean)true);
        StringRequest stringRequest = new StringRequest(string2, listener, errorListener);
        stringRequest.setRetryPolicy((RetryPolicy)new /* Unavailable Anonymous Inner Class!! */);
        stringRequest.setTag((Object)n2);
        RequestQueueHolder.getInstance(context).getQueue().add((Request)stringRequest);
    }

    public void sendRequestAsync(String string2, Integer n2, Context context, OnRequestDoneListener onRequestDoneListener, Response.ErrorListener errorListener) {
        this.sendRequestAsync(string2, n2, context, (Response.Listener<String>)new 1(this, onRequestDoneListener, string2, n2), (Response.ErrorListener)new 2(this, errorListener));
    }

    public void sendRequestAsyncPost(String string2, Integer n2, Context context, Response.Listener<String> listener, Response.ErrorListener errorListener, Map<String, String> map) {
        HttpURLConnection.setFollowRedirects((boolean)true);
        5 var7_7 = new 5(this, 1, string2, listener, errorListener, map);
        var7_7.setRetryPolicy((RetryPolicy)new /* Unavailable Anonymous Inner Class!! */);
        var7_7.setTag((Object)n2);
        RequestQueueHolder.getInstance(context).getQueue().add((Request)var7_7);
    }

    public void sendRequestAsyncPost(String string2, Integer n2, Context context, OnRequestDoneListener onRequestDoneListener, Response.ErrorListener errorListener, Map<String, String> map) {
        this.sendRequestAsyncPost(string2, n2, context, (Response.Listener<String>)new 3(this, onRequestDoneListener, string2, n2), (Response.ErrorListener)new 4(this, errorListener), map);
    }

    public static final class RequestType
    extends Enum<RequestType> {
        private static final /* synthetic */ RequestType[] $VALUES;
        public static final /* enum */ RequestType AFTERINSTALL = new RequestType();
        public static final /* enum */ RequestType APPMODE;
        public static final /* enum */ RequestType CLICK;
        public static final /* enum */ RequestType CONFIG_PHP;
        public static final /* enum */ RequestType IMPRESSION;
        public static final /* enum */ RequestType NATIVE_ADS;
        public static final /* enum */ RequestType RMA;
        public static final /* enum */ RequestType UPDATE;
        public static final /* enum */ RequestType USAGE;

        static {
            USAGE = new RequestType();
            UPDATE = new RequestType();
            CLICK = new RequestType();
            APPMODE = new RequestType();
            CONFIG_PHP = new RequestType();
            NATIVE_ADS = new RequestType();
            IMPRESSION = new RequestType();
            RMA = new RequestType();
            RequestType[] arrrequestType = new RequestType[]{AFTERINSTALL, USAGE, UPDATE, CLICK, APPMODE, CONFIG_PHP, NATIVE_ADS, IMPRESSION, RMA};
            $VALUES = arrrequestType;
        }

        public static RequestType valueOf(String string2) {
            return (RequestType)Enum.valueOf(RequestType.class, (String)string2);
        }

        public static RequestType[] values() {
            return (RequestType[])$VALUES.clone();
        }
    }

}

