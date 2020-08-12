/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  com.aerserv.sdk.adapter.SimultaneousAdLoader$1
 *  com.aerserv.sdk.adapter.SimultaneousAdLoader$2
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.math.BigDecimal
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Queue
 *  java.util.concurrent.CountDownLatch
 *  java.util.concurrent.TimeUnit
 *  org.json.JSONObject
 */
package com.aerserv.sdk.adapter;

import android.app.Activity;
import android.content.Context;
import com.aerserv.sdk.adapter.Adapter;
import com.aerserv.sdk.adapter.AdapterAdRefresher;
import com.aerserv.sdk.adapter.ISupportDynamicPrice;
import com.aerserv.sdk.adapter.SimultaneousAdLoader;
import com.aerserv.sdk.adapter.ThirdPartyProvider;
import com.aerserv.sdk.controller.listener.FetchAdapterDynamicPriceListener;
import com.aerserv.sdk.model.Asplc;
import com.aerserv.sdk.proxy.SybokProxy;
import com.aerserv.sdk.utils.AerServLog;
import com.aerserv.sdk.utils.SDKEventHelper;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class SimultaneousAdLoader {
    private static final String LOG_TAG = "SimultaneousAdLoader";

    public static void getDynamicPrices(Context context, ThirdPartyProvider thirdPartyProvider, Asplc asplc, int n2) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        String string = asplc.getAdapterName();
        try {
            thirdPartyProvider.loadAd(context, null, (FetchAdapterDynamicPriceListener)new 2(thirdPartyProvider, asplc, countDownLatch), n2);
        }
        catch (Exception exception) {
            String string2 = LOG_TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("error loading ad for ");
            stringBuilder.append(string);
            stringBuilder.append(" ");
            stringBuilder.append(asplc.getAsplcId());
            stringBuilder.append(": ");
            stringBuilder.append(exception.getMessage());
            AerServLog.w(string2, stringBuilder.toString());
            countDownLatch.countDown();
            exception.printStackTrace();
        }
        long l2 = n2;
        try {
            countDownLatch.await(l2, TimeUnit.MILLISECONDS);
            if (countDownLatch.getCount() > 0L) {
                AerServLog.w(LOG_TAG, "time out");
                return;
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void getDynamicPrices(Context context, Queue<Asplc> queue, List<Asplc> list, int n2, String string, String string2, String string3, int n3, boolean bl) {
        CountDownLatch countDownLatch = new CountDownLatch(list.size());
        Iterator iterator = list.iterator();
        int n4 = 0;
        while (iterator.hasNext()) {
            Iterator iterator2;
            Asplc asplc = (Asplc)iterator.next();
            String string4 = asplc.getAdapterName();
            if (n4 >= n2) {
                String string5 = LOG_TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string4);
                stringBuilder.append(" ");
                stringBuilder.append(asplc.getAsplcId());
                stringBuilder.append(" over limit. skip.");
                AerServLog.d(string5, stringBuilder.toString());
                if (queue != null && !"AdColony".equals((Object)string4) && !"AppNext".equals((Object)string4)) {
                    queue.add((Object)asplc);
                }
                countDownLatch.countDown();
                iterator2 = iterator;
            } else {
                JSONObject jSONObject = asplc.getJsonObject();
                iterator2 = iterator;
                ThirdPartyProvider thirdPartyProvider = ThirdPartyProvider.getInstance(asplc, string4, string2, string3, jSONObject, bl);
                if (thirdPartyProvider == null) {
                    String string6 = LOG_TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Could not get Provider class for ");
                    stringBuilder.append(string4);
                    stringBuilder.append(" ");
                    stringBuilder.append(asplc.getAsplcId());
                    AerServLog.d(string6, stringBuilder.toString());
                    countDownLatch.countDown();
                } else if (thirdPartyProvider.hasAd(asplc.hasVcEnabled())) {
                    String string7 = LOG_TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(string4);
                    stringBuilder.append(" ");
                    stringBuilder.append(asplc.getAsplcId());
                    stringBuilder.append(" has ad, skip.");
                    AerServLog.d(string7, stringBuilder.toString());
                    if (thirdPartyProvider.getAdapter().CASAdManuallyLoadedFlag(true)) {
                        String string8 = LOG_TAG;
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(string4);
                        stringBuilder2.append(" ");
                        stringBuilder2.append(asplc.getAsplcId());
                        stringBuilder2.append(" This cached ad was loaded either without our knowledge, or was loaded after timeout. Send another pair of events");
                        AerServLog.d(string8, stringBuilder2.toString());
                        SDKEventHelper.sendEvent(asplc.getSdkEventUrl(), string4, string, "12", string2);
                        SDKEventHelper.sendEvent(asplc.getSdkEventUrl(), string4, string, "34", string2);
                    }
                    AdapterAdRefresher.addAdapter(thirdPartyProvider.getAdapter(), (Activity)context, asplc, string2, asplc.hasVcEnabled(), bl);
                    if (queue != null) {
                        queue.add((Object)asplc);
                    }
                    if (thirdPartyProvider.getAdapter() instanceof ISupportDynamicPrice) {
                        asplc.setDynamicPrice(((ISupportDynamicPrice)((Object)thirdPartyProvider.getAdapter())).getDynamicPrice());
                    }
                    countDownLatch.countDown();
                } else {
                    try {
                        thirdPartyProvider.loadAd(context, queue, (FetchAdapterDynamicPriceListener)new 1(thirdPartyProvider, asplc, countDownLatch), n3 - 10);
                        ++n4;
                    }
                    catch (Exception exception) {
                        String string9 = LOG_TAG;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("error loading ad for ");
                        stringBuilder.append(string4);
                        stringBuilder.append(" ");
                        stringBuilder.append(asplc.getAsplcId());
                        stringBuilder.append(": ");
                        stringBuilder.append(exception.getMessage());
                        AerServLog.w(string9, stringBuilder.toString());
                        countDownLatch.countDown();
                        exception.printStackTrace();
                    }
                }
            }
            iterator = iterator2;
        }
        long l2 = n3;
        try {
            countDownLatch.await(l2, TimeUnit.MILLISECONDS);
            if (countDownLatch.getCount() <= 0L) return;
            if (queue != null) {
                AerServLog.w(LOG_TAG, "step2: time out");
                SybokProxy.sendTimeoutLogSybok(string, 2, n3, string2);
                return;
            }
            AerServLog.w(LOG_TAG, "time out");
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}

