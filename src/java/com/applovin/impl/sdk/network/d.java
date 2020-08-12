/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  com.applovin.impl.sdk.network.PostbackServiceImpl
 *  com.applovin.impl.sdk.network.d$1
 *  com.applovin.impl.sdk.network.f
 *  com.applovin.impl.sdk.network.f$a
 *  java.lang.Boolean
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.LinkedHashSet
 *  java.util.Map
 *  java.util.Set
 *  org.json.JSONObject
 */
package com.applovin.impl.sdk.network;

import android.content.Context;
import android.content.SharedPreferences;
import com.applovin.impl.sdk.b.b;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.network.PostbackServiceImpl;
import com.applovin.impl.sdk.network.d;
import com.applovin.impl.sdk.network.e;
import com.applovin.impl.sdk.network.f;
import com.applovin.impl.sdk.p;
import com.applovin.sdk.AppLovinPostbackListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public class d {
    private final j a;
    private final p b;
    private ArrayList<e> c;
    private ArrayList<e> d;
    private final Object e;
    private final SharedPreferences f;

    public d(j j2) {
        if (j2 != null) {
            this.a = j2;
            this.b = j2.u();
            this.f = j2.w().getSharedPreferences("com.applovin.sdk.impl.postbackQueue.domain", 0);
            this.e = new Object();
            this.c = this.c();
            this.d = new ArrayList();
            return;
        }
        throw new IllegalArgumentException("No sdk specified");
    }

    static /* synthetic */ p a(d d2) {
        return d2.b;
    }

    static /* synthetic */ void a(d d2, e e2) {
        d2.d(e2);
    }

    static /* synthetic */ void b(d d2, e e2) {
        d2.e(e2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void b(e e2) {
        Object object;
        Object object2 = object = this.e;
        synchronized (object2) {
            int n2 = this.a.a(b.dH);
            if (this.c.size() < n2) {
                this.c.add((Object)e2);
                this.d();
                p p2 = this.b;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Enqueued postback: ");
                stringBuilder.append((Object)e2);
                p2.a("PersistentPostbackManager", stringBuilder.toString());
            } else {
                p p3 = this.b;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Persistent queue has reached maximum size; postback retried in memory only.");
                stringBuilder.append((Object)e2);
                p3.c("PersistentPostbackManager", stringBuilder.toString());
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private ArrayList<e> c() {
        Set set = (Set)this.a.b(com.applovin.impl.sdk.b.d.g, new LinkedHashSet(0), this.f);
        ArrayList arrayList = new ArrayList(Math.max((int)1, (int)set.size()));
        int n2 = this.a.a(b.dI);
        p p2 = this.b;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Deserializing ");
        stringBuilder.append(set.size());
        stringBuilder.append(" postback(s).");
        p2.a("PersistentPostbackManager", stringBuilder.toString());
        Iterator iterator = set.iterator();
        do {
            if (!iterator.hasNext()) {
                p p3 = this.b;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Successfully loaded postback queue with ");
                stringBuilder2.append(arrayList.size());
                stringBuilder2.append(" postback(s).");
                p3.a("PersistentPostbackManager", stringBuilder2.toString());
                return arrayList;
            }
            String string2 = (String)iterator.next();
            try {
                e e2 = new e(new JSONObject(string2), this.a);
                if (this.a.a(b.dJ).booleanValue() && e2.f() < n2 || e2.f() > n2) {
                    arrayList.add((Object)e2);
                    continue;
                }
                p p4 = this.b;
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append("Skipping deserialization because maximum attempt count exceeded for postback: ");
                stringBuilder3.append((Object)e2);
                p4.a("PersistentPostbackManager", stringBuilder3.toString());
            }
            catch (Throwable throwable) {
                p p5 = this.b;
                StringBuilder stringBuilder4 = new StringBuilder();
                stringBuilder4.append("Unable to deserialize postback request from json: ");
                stringBuilder4.append(string2);
                p5.b("PersistentPostbackManager", stringBuilder4.toString(), throwable);
                continue;
            }
            break;
        } while (true);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void c(e e2) {
        Object object;
        p p2 = this.b;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Preparing to submit postback...");
        stringBuilder.append((Object)e2);
        p2.a("PersistentPostbackManager", stringBuilder.toString());
        if (this.a.c()) {
            this.b.a("PersistentPostbackManager", "Skipping postback dispatch because SDK is still initializing - postback will be dispatched afterwards");
            return;
        }
        Object object2 = object = this.e;
        synchronized (object2) {
            e2.g();
            this.d();
        }
        int n2 = this.a.a(b.dI);
        if (e2.f() > n2) {
            p p3 = this.b;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Exceeded maximum persisted attempt count of ");
            stringBuilder2.append(n2);
            stringBuilder2.append(". Dequeuing postback: ");
            stringBuilder2.append((Object)e2);
            p3.c("PersistentPostbackManager", stringBuilder2.toString());
            this.d(e2);
            return;
        }
        JSONObject jSONObject = e2.c() != null ? new JSONObject(e2.c()) : null;
        f f2 = f.b((j)this.a).d(e2.a()).b(e2.d()).f(e2.b()).b(jSONObject).b(e2.e()).b();
        this.a.J().dispatchPostbackRequest(f2, (AppLovinPostbackListener)new 1(this, e2));
    }

    private void d() {
        p p2;
        String string2;
        if (com.applovin.impl.sdk.e.e.b()) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(this.c.size());
            for (e e2 : this.c) {
                try {
                    linkedHashSet.add((Object)e2.i().toString());
                }
                catch (Throwable throwable) {
                    this.b.b("PersistentPostbackManager", "Unable to serialize postback request to JSON.", throwable);
                }
            }
            this.a.a(com.applovin.impl.sdk.b.d.g, linkedHashSet, this.f);
            p2 = this.b;
            string2 = "Wrote updated postback queue to disk.";
        } else {
            p2 = this.b;
            string2 = "Skipping writing postback queue to disk due to old Android version...";
        }
        p2.a("PersistentPostbackManager", string2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void d(e e2) {
        Object object;
        Object object2 = object = this.e;
        synchronized (object2) {
            this.c.remove((Object)e2);
            this.d();
        }
        p p2 = this.b;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Dequeued successfully transmitted postback: ");
        stringBuilder.append((Object)e2);
        p2.a("PersistentPostbackManager", stringBuilder.toString());
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void e(e e2) {
        Object object;
        Object object2 = object = this.e;
        synchronized (object2) {
            this.d.add((Object)e2);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a() {
        Object object;
        Object object2 = object = this.e;
        synchronized (object2) {
            if (this.c == null) return;
            Iterator iterator = new ArrayList(this.c).iterator();
            while (iterator.hasNext()) {
                this.c((e)iterator.next());
            }
            return;
        }
    }

    public void a(e e2) {
        this.a(e2, true);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(e e2, boolean bl) {
        Object object;
        if (!com.applovin.impl.sdk.e.j.b(e2.a())) {
            return;
        }
        if (bl) {
            e2.h();
        }
        Object object2 = object = this.e;
        synchronized (object2) {
            this.b(e2);
            this.c(e2);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b() {
        Object object;
        Object object2 = object = this.e;
        synchronized (object2) {
            Iterator iterator = this.d.iterator();
            do {
                if (!iterator.hasNext()) {
                    this.d.clear();
                    return;
                }
                this.c((e)iterator.next());
            } while (true);
        }
    }
}

