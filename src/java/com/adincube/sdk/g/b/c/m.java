/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.Set
 */
package com.adincube.sdk.g.b.c;

import com.adincube.sdk.g.b.c.i;
import com.adincube.sdk.h.c.b;
import com.adincube.sdk.h.c.e;
import com.adincube.sdk.util.o;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class m {
    private static m b;
    final Set<i> a = new HashSet();
    private boolean c = true;
    private final Map<String, b> d = new HashMap();

    private m() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static m a() {
        if (b != null) return b;
        Class<m> class_ = m.class;
        synchronized (m.class) {
            b = new m();
            // ** MonitorExit[var1] (shouldn't be in output)
            return b;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void a(b b2, String string) {
        Map<String, b> map;
        Map<String, b> map2 = map = this.d;
        synchronized (map2) {
            if ((b)((Object)this.d.get((Object)string)) != b2) return;
            this.d.remove((Object)string);
            Iterator iterator = this.a.iterator();
            while (iterator.hasNext()) {
                final i i2 = (i)iterator.next();
                if (!this.c) {
                    i2.a();
                    continue;
                }
                o.a("NetworkOrderLoadingConflictManager.load", new Runnable(){

                    public final void run() {
                        i2.a();
                    }
                });
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final boolean a(b b2, e e2) {
        Map<String, b> map;
        com.adincube.sdk.mediation.i i2 = e2.f.f();
        if (i2 == null) {
            return true;
        }
        if (i2.e()) {
            return true;
        }
        Map<String, b> map2 = map = this.d;
        synchronized (map2) {
            b b3 = (b)((Object)this.d.get((Object)e2.a));
            if (b3 != null && b3 != b2) {
                return false;
            }
            this.d.put((Object)e2.a, (Object)b2);
            return true;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final boolean b(b b2, e e2) {
        m m2 = this;
        synchronized (m2) {
            com.adincube.sdk.mediation.i i2 = e2.f.f();
            if (i2 == null) return false;
            if (!i2.e()) {
                Map<String, b> map;
                Map<String, b> map2 = map = this.d;
                synchronized (map2) {
                    b b3 = (b)((Object)this.d.get((Object)e2.a));
                    boolean bl = false;
                    if (b3 == null) return bl;
                    bl = false;
                    if (b3 == b2) return bl;
                    return true;
                }
            }
            return false;
        }
    }

}

