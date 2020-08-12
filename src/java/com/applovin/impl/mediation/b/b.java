/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.text.TextUtils
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.InterruptedException
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.List
 *  java.util.concurrent.CountDownLatch
 *  java.util.concurrent.ExecutorService
 *  java.util.concurrent.Executors
 *  java.util.concurrent.TimeUnit
 *  java.util.concurrent.atomic.AtomicBoolean
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.applovin.impl.mediation.b;

import android.app.Activity;
import android.text.TextUtils;
import com.applovin.impl.mediation.a.f;
import com.applovin.impl.mediation.a.g;
import com.applovin.impl.mediation.b.b;
import com.applovin.impl.sdk.b.d;
import com.applovin.impl.sdk.c.i;
import com.applovin.impl.sdk.e.j;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b
extends com.applovin.impl.sdk.d.a {
    private static String a;
    private final Activity c;
    private final a d;

    static {
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put((Object)b.a("APPLOVIN_NETWORK", "com.applovin.mediation.adapters.AppLovinMediationAdapter"));
            b.a("FACEBOOK_NETWORK", "com.applovin.mediation.adapters.FacebookMediationAdapter").put("run_on_ui_thread", false);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("signal_providers", (Object)jSONArray);
            a = jSONObject.toString();
        }
        catch (JSONException jSONException) {}
    }

    public b(Activity activity, com.applovin.impl.sdk.j j2, a a2) {
        super("TaskCollectSignals", j2);
        if (activity != null) {
            this.c = activity;
            this.d = a2;
            return;
        }
        throw new IllegalArgumentException("No activity specified");
    }

    static /* synthetic */ Activity a(b b2) {
        return b2.c;
    }

    private String a(String string, com.applovin.impl.sdk.b.b<Integer> b2) {
        if (TextUtils.isEmpty((CharSequence)string)) {
            return "";
        }
        int n2 = this.b.a(b2);
        if (n2 > 0) {
            return string.substring(0, Math.min((int)string.length(), (int)n2));
        }
        return "";
    }

    private static JSONObject a(String string, String string2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", (Object)string);
        jSONObject.put("class", (Object)string2);
        jSONObject.put("adapter_timeout_ms", 30000);
        jSONObject.put("max_signal_length", 32768);
        jSONObject.put("scode", (Object)"");
        return jSONObject;
    }

    private void a(g g2, f.a a2) {
        Runnable runnable = new Runnable(this, g2, a2){
            final /* synthetic */ g a;
            final /* synthetic */ f.a b;
            final /* synthetic */ b c;
            {
                this.c = b2;
                this.a = g2;
                this.b = a2;
            }

            public void run() {
                b.b(this.c).a(b.a(this.c)).collectSignal(this.a, b.a(this.c), this.b);
            }
        };
        if (g2.w()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Running signal collection for ");
            stringBuilder.append((Object)g2);
            stringBuilder.append(" on the main thread");
            this.a(stringBuilder.toString());
            this.c.runOnUiThread(runnable);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Running signal collection for ");
        stringBuilder.append((Object)g2);
        stringBuilder.append(" on the background thread");
        this.a(stringBuilder.toString());
        runnable.run();
    }

    static /* synthetic */ void a(b b2, g g2, f.a a2) {
        b2.a(g2, a2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(Collection<f> collection) {
        JSONArray jSONArray = new JSONArray();
        Iterator iterator = collection.iterator();
        do {
            if (!iterator.hasNext()) {
                this.a(jSONArray);
                return;
            }
            f f2 = (f)iterator.next();
            try {
                String string;
                String string2;
                JSONObject jSONObject = new JSONObject();
                g g2 = f2.a();
                jSONObject.put("name", (Object)g2.u());
                jSONObject.put("class", (Object)g2.t());
                jSONObject.put("adapter_version", (Object)this.a(f2.c(), com.applovin.impl.sdk.b.a.m));
                jSONObject.put("sdk_version", (Object)this.a(f2.b(), com.applovin.impl.sdk.b.a.n));
                JSONObject jSONObject2 = new JSONObject();
                if (j.b(f2.e())) {
                    string = "error_message";
                    string2 = f2.e();
                } else {
                    string = "signal";
                    string2 = this.a(f2.d(), com.applovin.impl.sdk.b.a.o);
                }
                jSONObject2.put(string, (Object)string2);
                jSONObject.put("data", (Object)jSONObject2);
                jSONArray.put((Object)jSONObject);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Collected signal from ");
                stringBuilder.append((Object)g2);
                this.a(stringBuilder.toString());
            }
            catch (JSONException jSONException) {
                this.a("Failed to create signal data", jSONException);
                continue;
            }
            break;
        } while (true);
    }

    private void a(JSONArray jSONArray) {
        a a2 = this.d;
        if (a2 != null) {
            a2.a(jSONArray);
        }
    }

    static /* synthetic */ com.applovin.impl.sdk.j b(b b2) {
        return b2.b;
    }

    private void b(String string, Throwable throwable) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("No signals collected: ");
        stringBuilder.append(string);
        this.a(stringBuilder.toString(), throwable);
        this.a(new JSONArray());
    }

    @Override
    public i a() {
        return i.B;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        String string;
        void var3_15;
        String string2 = this.b.b(d.p, a);
        if (!j.b(string2)) {
            this.b("No signal providers provided", null);
            return;
        }
        try {
            CountDownLatch countDownLatch;
            ExecutorService executorService;
            AtomicBoolean atomicBoolean;
            List list;
            JSONObject jSONObject = new JSONObject(string2);
            JSONArray jSONArray = com.applovin.impl.sdk.e.g.a(jSONObject, "signal_providers", null, this.b);
            if (jSONArray.length() > 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Collecting signals from ");
                stringBuilder.append(jSONArray.length());
                stringBuilder.append(" signal providers(s)...");
                this.a(stringBuilder.toString());
                list = com.applovin.impl.sdk.e.d.a(jSONArray.length());
                atomicBoolean = new AtomicBoolean(true);
                countDownLatch = new CountDownLatch(jSONArray.length());
                executorService = Executors.newFixedThreadPool((int)this.b.a(com.applovin.impl.sdk.b.a.j));
            } else {
                this.b("No signal providers found", null);
                return;
            }
            for (int i2 = 0; i2 < jSONArray.length(); ++i2) {
                g g2 = new g(jSONArray.getJSONObject(i2), jSONObject, this.b);
                Runnable runnable = new Runnable(this, g2, atomicBoolean, list, countDownLatch){
                    final /* synthetic */ g a;
                    final /* synthetic */ AtomicBoolean b;
                    final /* synthetic */ List c;
                    final /* synthetic */ CountDownLatch d;
                    final /* synthetic */ b e;
                    {
                        this.e = b2;
                        this.a = g2;
                        this.b = atomicBoolean;
                        this.c = list;
                        this.d = countDownLatch;
                    }

                    public void run() {
                        b.a(this.e, this.a, new f.a(this){
                            final /* synthetic */ 1 a;
                            {
                                this.a = var1_1;
                            }

                            public void a(f f2) {
                                if (this.a.b.get() && f2 != null) {
                                    this.a.c.add((Object)f2);
                                }
                                this.a.d.countDown();
                            }
                        });
                    }
                };
                executorService.execute(runnable);
            }
            countDownLatch.await(this.b.a(com.applovin.impl.sdk.b.a.l).longValue(), TimeUnit.MILLISECONDS);
            atomicBoolean.set(false);
            if (this.b.a(com.applovin.impl.sdk.b.a.k).booleanValue()) {
                executorService.shutdown();
            }
            this.a((Collection<f>)list);
            return;
        }
        catch (Throwable throwable) {
            string = "Failed to collect signals";
        }
        catch (InterruptedException interruptedException) {
            string = "Failed to wait for signals";
        }
        catch (JSONException jSONException) {
            string = "Failed to parse signals JSON";
        }
        this.b(string, (Throwable)var3_15);
    }

}

