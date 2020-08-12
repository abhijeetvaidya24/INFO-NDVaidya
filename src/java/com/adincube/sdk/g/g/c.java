/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Locale
 *  java.util.Map
 */
package com.adincube.sdk.g.g;

import com.adincube.sdk.d.e.a;
import com.adincube.sdk.g.g.b;
import com.adincube.sdk.util.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class c {
    private static c d;
    public com.adincube.sdk.a.a a = null;
    private Map<b, com.adincube.sdk.a.a> b = new HashMap();
    private com.adincube.sdk.a.a c = null;

    public c() {
        for (b b2 : b.a()) {
            com.adincube.sdk.a.a a2 = b2.e;
            if (a2 == null) continue;
            this.b.put((Object)b2, (Object)a2);
            if (!b2.d) continue;
            this.c = a2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static c a() {
        if (d != null) return d;
        Class<c> class_ = c.class;
        synchronized (c.class) {
            if (d != null) return d;
            d = new c();
            // ** MonitorExit[var1] (shouldn't be in output)
            return d;
        }
    }

    public static void a(com.adincube.sdk.a.a a2) {
        try {
            if (!a2.c()) {
                if (f.a() != null) {
                    a2.b();
                    return;
                }
                Locale locale = Locale.US;
                Object[] arrobject = new Object[]{a2.a()};
                throw new a(String.format((Locale)locale, (String)"No context available to initialize '%s' consent manager provider.", (Object[])arrobject));
            }
            return;
        }
        catch (Throwable throwable) {
            Locale locale = Locale.US;
            Object[] arrobject = new Object[]{a2.a()};
            throw new a(String.format((Locale)locale, (String)"Failed to initialize '%s' consent manager provider due to internal error.", (Object[])arrobject), throwable);
        }
        catch (a a3) {
            throw a3;
        }
    }

    public final List<com.adincube.sdk.a.a> b() {
        com.adincube.sdk.a.a a2;
        ArrayList arrayList = new ArrayList();
        com.adincube.sdk.a.a a3 = this.a;
        if (a3 != null) {
            arrayList.add((Object)a3);
        }
        if ((a2 = this.c) != null) {
            arrayList.add((Object)a2);
        }
        return arrayList;
    }
}

