/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Arrays
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.Hashtable
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  java.util.concurrent.ConcurrentHashMap
 */
package com.tapjoy.internal;

import com.tapjoy.internal.fm;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class fb
extends fm {
    static final Map a = Collections.unmodifiableMap((Map)new HashMap());
    private final fm.a c = this.a("BuildConfig");
    private final fm.a d = this.a("ServerFinal");
    private final fm.a e = this.a("AppRuntime");
    private final fm.a f;
    private final fm.a g;

    fb() {
        this.e.b = new ConcurrentHashMap();
        this.f = this.a("ConnectFlags");
        this.g = this.a("ServerDefault");
        fm.a a2 = this.a("SDKDefault");
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"placement_request_content_retry_timeout", (Object)-1);
        Object[] arrobject = new Number[]{0L, 500L, 10000L, 2.0};
        hashMap.put((Object)"placement_request_content_retry_backoff", (Object)Arrays.asList((Object[])arrobject));
        a2.b = hashMap;
    }

    public final void a(Hashtable hashtable) {
        HashMap hashMap = new HashMap();
        for (Map.Entry entry : hashtable.entrySet()) {
            String string = (String)a.get(entry.getKey());
            if (string == null) {
                string = (String)entry.getKey();
            }
            this.e.b.remove((Object)string);
            hashMap.put((Object)string, entry.getValue());
        }
        this.f.b = hashMap;
        this.setChanged();
    }

    public final void a(Map map) {
        Map map2;
        Map map3 = null;
        if (map != null) {
            map3 = (Map)map.get((Object)"final");
            map2 = (Map)map.get((Object)"default");
        } else {
            map2 = null;
        }
        this.d.b = map3;
        this.g.b = map2;
        this.setChanged();
    }
}

