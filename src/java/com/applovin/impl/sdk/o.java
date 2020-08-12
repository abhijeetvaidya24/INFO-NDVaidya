/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.List
 *  java.util.concurrent.atomic.AtomicBoolean
 */
package com.applovin.impl.sdk;

import com.applovin.impl.sdk.b.b;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.p;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class o {
    private final j a;
    private final AtomicBoolean b = new AtomicBoolean();
    private final List<a> c = Collections.synchronizedList((List)new ArrayList());
    private long d;
    private final Object e = new Object();
    private final AtomicBoolean f = new AtomicBoolean();
    private long g;

    o(j j2) {
        this.a = j2;
    }

    public void a(a a2) {
        this.c.add((Object)a2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(boolean bl) {
        Object object;
        Object object2 = object = this.e;
        synchronized (object2) {
            this.f.set(bl);
            if (bl) {
                this.g = System.currentTimeMillis();
                p p2 = this.a.u();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Setting fullscreen ad pending display: ");
                stringBuilder.append(this.g);
                p2.a("FullScreenAdTracker", stringBuilder.toString());
                final long l2 = this.a.a(b.cN);
                if (l2 >= 0L) {
                    AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable(){

                        public void run() {
                            if (!o.this.a()) {
                                return;
                            }
                            if (System.currentTimeMillis() - o.this.g >= l2) {
                                o.this.a.u().a("FullScreenAdTracker", "Resetting \"pending display\" state...");
                                o.this.f.set(false);
                            }
                        }
                    }, l2);
                }
            } else {
                this.g = 0L;
                p p3 = this.a.u();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Setting fullscreen ad not pending display: ");
                stringBuilder.append(System.currentTimeMillis());
                p3.a("FullScreenAdTracker", stringBuilder.toString());
            }
            return;
        }
    }

    public boolean a() {
        return this.f.get();
    }

    public void b(a a2) {
        this.c.remove((Object)a2);
    }

    public boolean b() {
        return this.b.get();
    }

    public void c() {
        if (this.b.compareAndSet(false, true)) {
            this.d = System.currentTimeMillis();
            p p2 = this.a.u();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Setting fullscreen ad displayed: ");
            stringBuilder.append(this.d);
            p2.a("FullScreenAdTracker", stringBuilder.toString());
            Iterator iterator = new ArrayList(this.c).iterator();
            while (iterator.hasNext()) {
                ((a)iterator.next()).h();
            }
            final long l2 = this.a.a(b.cO);
            if (l2 >= 0L) {
                AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable(){

                    public void run() {
                        if (!o.this.b.get()) {
                            return;
                        }
                        if (System.currentTimeMillis() - o.this.d >= l2) {
                            o.this.a.u().a("FullScreenAdTracker", "Resetting \"display\" state...");
                            o.this.d();
                        }
                    }
                }, l2);
            }
        }
    }

    public void d() {
        if (this.b.compareAndSet(true, false)) {
            p p2 = this.a.u();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Setting fullscreen ad hidden: ");
            stringBuilder.append(System.currentTimeMillis());
            p2.a("FullScreenAdTracker", stringBuilder.toString());
            Iterator iterator = new ArrayList(this.c).iterator();
            while (iterator.hasNext()) {
                ((a)iterator.next()).i();
            }
        }
    }

    static interface a {
        public void h();

        public void i();
    }

}

