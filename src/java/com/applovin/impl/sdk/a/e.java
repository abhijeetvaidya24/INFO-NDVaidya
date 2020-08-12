/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.applovin.impl.sdk.ad.g
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.Map
 */
package com.applovin.impl.sdk.a;

import com.applovin.impl.sdk.ad.g;
import java.util.HashMap;
import java.util.Map;

public class e {
    private static e d;
    private final Map<g, String> a = new HashMap(1);
    private final Map<g, Map<String, String>> b = new HashMap(1);
    private final Object c = new Object();

    private e() {
    }

    public static e a() {
        Class<e> class_ = e.class;
        synchronized (e.class) {
            if (d == null) {
                d = new e();
            }
            e e2 = d;
            // ** MonitorExit[var2] (shouldn't be in output)
            return e2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Map<String, String> a(g g2) {
        Object object;
        Object object2 = object = this.c;
        synchronized (object2) {
            return (Map)this.b.remove((Object)g2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(g g2, String string2) {
        Object object;
        Object object2 = object = this.c;
        synchronized (object2) {
            this.a.put((Object)g2, (Object)string2);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(g g2, Map<String, String> map) {
        Object object;
        Object object2 = object = this.c;
        synchronized (object2) {
            this.b.put((Object)g2, map);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String b(g g2) {
        Object object;
        Object object2 = object = this.c;
        synchronized (object2) {
            return (String)this.a.remove((Object)g2);
        }
    }
}

