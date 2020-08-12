/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.concurrent.ExecutorService
 *  java.util.concurrent.Executors
 */
package com.adincube.sdk.g.c;

import com.adincube.sdk.j.b;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class a {
    private static a a;
    private Map<b.b, ExecutorService> b = new HashMap();

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static a a() {
        if (a != null) return a;
        Class<a> class_ = a.class;
        synchronized (a.class) {
            a = new a();
            // ** MonitorExit[var1] (shouldn't be in output)
            return a;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final ExecutorService a(b.b b2) {
        Map<b.b, ExecutorService> map;
        Map<b.b, ExecutorService> map2 = map = this.b;
        synchronized (map2) {
            Object object = (ExecutorService)this.b.get((Object)b2);
            if (object == null) {
                int n2 = 1.a[b2.ordinal()];
                object = n2 != 1 ? (n2 != 2 ? (n2 != 3 ? null : Executors.newCachedThreadPool()) : Executors.newFixedThreadPool((int)3)) : Executors.newSingleThreadExecutor();
                this.b.put((Object)b2, object);
            }
            return object;
        }
    }

}

