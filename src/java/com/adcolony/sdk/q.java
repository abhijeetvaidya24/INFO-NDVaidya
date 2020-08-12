/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.adcolony.sdk.a
 *  com.adcolony.sdk.ad
 *  com.adcolony.sdk.af
 *  com.adcolony.sdk.n
 *  com.adcolony.sdk.p
 *  com.adcolony.sdk.p$a
 *  com.adcolony.sdk.w
 *  com.adcolony.sdk.y
 *  com.adcolony.sdk.y$a
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.LinkedList
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  java.util.concurrent.BlockingQueue
 *  java.util.concurrent.LinkedBlockingQueue
 *  java.util.concurrent.RejectedExecutionException
 *  java.util.concurrent.ThreadPoolExecutor
 *  java.util.concurrent.TimeUnit
 *  org.json.JSONObject
 */
package com.adcolony.sdk;

import com.adcolony.sdk.a;
import com.adcolony.sdk.ad;
import com.adcolony.sdk.af;
import com.adcolony.sdk.n;
import com.adcolony.sdk.p;
import com.adcolony.sdk.w;
import com.adcolony.sdk.y;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

class q
implements p.a {
    private BlockingQueue<Runnable> a = new LinkedBlockingQueue();
    private ThreadPoolExecutor b;
    private LinkedList<p> c;
    private String d;

    q() {
        ThreadPoolExecutor threadPoolExecutor;
        this.b = threadPoolExecutor = new ThreadPoolExecutor(4, 16, 60L, TimeUnit.SECONDS, this.a);
        this.c = new LinkedList();
        this.d = a.a().m().E();
    }

    void a() {
        a.a((String)"WebServices.download", (af)new af(){

            public void a(ad ad2) {
                q q2 = q.this;
                q2.a(new p(ad2, (p.a)q2));
            }
        });
        a.a((String)"WebServices.get", (af)new af(){

            public void a(ad ad2) {
                q q2 = q.this;
                q2.a(new p(ad2, (p.a)q2));
            }
        });
        a.a((String)"WebServices.post", (af)new af(){

            public void a(ad ad2) {
                q q2 = q.this;
                q2.a(new p(ad2, (p.a)q2));
            }
        });
    }

    void a(int n2) {
        this.b.setCorePoolSize(n2);
    }

    void a(p p2) {
        if (this.d.equals((Object)"")) {
            this.c.push((Object)p2);
            return;
        }
        try {
            this.b.execute((Runnable)p2);
            return;
        }
        catch (RejectedExecutionException rejectedExecutionException) {
            y.a a2 = new y.a().a("RejectedExecutionException: ThreadPoolExecutor unable to ");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("execute download for url ");
            stringBuilder.append(p2.a);
            a2.a(stringBuilder.toString()).a(y.h);
            this.a(p2, p2.a(), null);
            return;
        }
    }

    public void a(p p2, ad ad2, Map<String, List<String>> map) {
        JSONObject jSONObject = w.a();
        w.a((JSONObject)jSONObject, (String)"url", (String)p2.a);
        w.a((JSONObject)jSONObject, (String)"success", (boolean)p2.c);
        w.b((JSONObject)jSONObject, (String)"status", (int)p2.e);
        w.a((JSONObject)jSONObject, (String)"body", (String)p2.b);
        w.b((JSONObject)jSONObject, (String)"size", (int)p2.d);
        if (map != null) {
            JSONObject jSONObject2 = w.a();
            for (Map.Entry entry : map.entrySet()) {
                String string = ((List)entry.getValue()).toString();
                String string2 = string.substring(1, string.length() - 1);
                if (entry.getKey() == null) continue;
                w.a((JSONObject)jSONObject2, (String)((String)entry.getKey()), (String)string2);
            }
            w.a((JSONObject)jSONObject, (String)"headers", (JSONObject)jSONObject2);
        }
        ad2.a(jSONObject).b();
    }

    void a(String string) {
        this.d = string;
        while (!this.c.isEmpty()) {
            this.a((p)this.c.removeLast());
        }
    }

    int b() {
        return this.b.getCorePoolSize();
    }

}

