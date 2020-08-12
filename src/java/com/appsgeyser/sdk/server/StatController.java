/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  android.net.Uri$Builder
 *  android.util.Log
 *  com.yandex.metrica.YandexMetrica
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  org.json.JSONObject
 */
package com.appsgeyser.sdk.server;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.appsgeyser.sdk.configuration.Configuration;
import com.appsgeyser.sdk.server.RequestQueueHolder;
import com.appsgeyser.sdk.utils.DeviceInfoGetter;
import com.yandex.metrica.YandexMetrica;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public class StatController {
    private static StatController instance;
    private HashMap<String, String> items;

    private StatController() {
    }

    public static StatController getInstance() {
        Class<StatController> class_ = StatController.class;
        synchronized (StatController.class) {
            if (instance == null) {
                instance = new StatController();
            }
            StatController statController = instance;
            // ** MonitorExit[var2] (shouldn't be in output)
            return statController;
        }
    }

    private boolean isInitialized() {
        return this.items != null;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private void sendQueryToYandexMetrica(String var1_1, HashMap<String, String> var2_2) {
        var3_3 = null;
        if (var2_2 == null) ** GOTO lbl5
        try {
            var3_3 = new JSONObject(var2_2).toString();
lbl5: // 2 sources:
            YandexMetrica.reportEvent((String)var1_1, var3_3);
            return;
        }
        catch (Exception var4_4) {
            var4_4.printStackTrace();
            return;
        }
    }

    public void init(HashMap<String, String> hashMap) {
        this.items = hashMap;
    }

    public void sendRequestAsyncByKey(String string2) {
        this.sendRequestAsyncByKey(string2, null, null, false);
    }

    public void sendRequestAsyncByKey(String string2, final HashMap<String, String> hashMap, Context context, boolean bl) {
        if (bl && context != null && hashMap != null) {
            String string3;
            HashMap<String, String> hashMap2 = DeviceInfoGetter.getDeviceInfoMap(context);
            if (hashMap2 != null) {
                hashMap.putAll(hashMap2);
            }
            if ((string3 = Configuration.getInstance(context).getTemplateVersion()) != null) {
                hashMap.put((Object)"templateversion", (Object)string3);
            }
        }
        this.sendQueryToYandexMetrica(string2, hashMap);
        if (!this.isInitialized()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("StatController not initialized, skipping stat request on: ");
            stringBuilder.append(string2);
            Log.d((String)"StatController", (String)stringBuilder.toString());
            return;
        }
        final String string4 = (String)this.items.get((Object)string2);
        if (string4 == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Stat url not set, skipping stat request on: ");
            stringBuilder.append(string2);
            Log.d((String)"StatController", (String)stringBuilder.toString());
            return;
        }
        new Thread(){

            public void run() {
                String string2 = string4;
                if (hashMap != null) {
                    Uri.Builder builder = Uri.parse((String)string2).buildUpon();
                    for (Map.Entry entry : hashMap.entrySet()) {
                        builder.appendQueryParameter((String)entry.getKey(), (String)entry.getValue());
                    }
                    string2 = builder.build().toString();
                }
                RequestQueueHolder.addUrl(string2);
            }
        }.start();
    }

}

