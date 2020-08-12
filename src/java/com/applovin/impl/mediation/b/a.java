/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.concurrent.ExecutorService
 *  java.util.concurrent.Executors
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.applovin.impl.mediation.b;

import android.app.Activity;
import com.applovin.impl.mediation.a.e;
import com.applovin.impl.mediation.b.a;
import com.applovin.impl.sdk.b.b;
import com.applovin.impl.sdk.b.d;
import com.applovin.impl.sdk.c.i;
import com.applovin.impl.sdk.e.g;
import com.applovin.impl.sdk.e.j;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a
extends com.applovin.impl.sdk.d.a {
    private final Activity a;

    public a(Activity activity, com.applovin.impl.sdk.j j2) {
        super("TaskAutoInitAdapters", j2);
        if (activity != null) {
            this.a = activity;
            return;
        }
        throw new IllegalArgumentException("No activity specified");
    }

    static /* synthetic */ Activity a(a a2) {
        return a2.a;
    }

    static /* synthetic */ void a(a a2, String string) {
        a2.a(string);
    }

    static /* synthetic */ com.applovin.impl.sdk.j b(a a2) {
        return a2.b;
    }

    @Override
    public i a() {
        return i.A;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void run() {
        String string = this.b.a(d.q);
        if (j.b(string)) {
            void var3_9;
            String string2;
            block7 : {
                JSONObject jSONObject = new JSONObject(string);
                JSONArray jSONArray = g.a(jSONObject, "auto_init_adapters", null, this.b);
                if (jSONArray.length() <= 0) break block7;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Auto-initing ");
                stringBuilder.append(jSONArray.length());
                stringBuilder.append(" adapter(s)...");
                this.a(stringBuilder.toString());
                ExecutorService executorService = Executors.newFixedThreadPool((int)this.b.a(com.applovin.impl.sdk.b.a.q));
                int n2 = 0;
                do {
                    if (n2 >= jSONArray.length()) return;
                    executorService.execute(new Runnable(this, new e(jSONArray.getJSONObject(n2), jSONObject, this.b)){
                        final /* synthetic */ e a;
                        final /* synthetic */ a b;
                        {
                            this.b = a2;
                            this.a = e2;
                        }

                        public void run() {
                            a a2 = this.b;
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Auto-initing adapter: ");
                            stringBuilder.append((Object)this.a);
                            a.a(a2, stringBuilder.toString());
                            a.b(this.b).a(a.a(this.b)).initializeAdapter(this.a, a.a(this.b));
                        }
                    });
                    ++n2;
                } while (true);
            }
            try {
                this.d("No auto-init adapters found");
                return;
            }
            catch (Throwable throwable) {
                string2 = "Failed to auto-init adapters";
            }
            catch (JSONException jSONException) {
                string2 = "Failed to parse auto-init adapters JSON";
            }
            this.a(string2, (Throwable)var3_9);
            return;
        }
        this.a("No auto-init adapters provided", null);
    }
}

