/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.Map
 */
package com.applovin.impl.sdk;

import java.util.HashMap;
import java.util.Map;

public class f {
    private static final Map<String, f> a = new HashMap(1);
    private static final Object b = new Object();
    private final Map<String, Integer> c = new HashMap();
    private final Object d = new Object();

    private f() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static f a(String string2) {
        Object object;
        Object object2 = object = b;
        synchronized (object2) {
            if (a.containsKey((Object)string2)) return (f)a.get((Object)string2);
            f f2 = new f();
            a.put((Object)string2, (Object)f2);
            return (f)a.get((Object)string2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Integer b(String string2) {
        Object object;
        Object object2 = object = this.d;
        synchronized (object2) {
            if (this.c.containsKey((Object)string2)) {
                Integer n2 = (Integer)this.c.get((Object)string2);
                this.c.put((Object)string2, (Object)(1 + n2));
                return (Integer)this.c.get((Object)string2);
            } else {
                this.c.put((Object)string2, (Object)1);
            }
            return (Integer)this.c.get((Object)string2);
        }
    }
}

