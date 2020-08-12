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
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 */
package com.adincube.sdk.g.b;

import com.adincube.sdk.h.c.b;
import com.adincube.sdk.h.c.d;
import com.adincube.sdk.h.c.e;
import com.adincube.sdk.mediation.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class f {
    private static Map<b, f> b = new HashMap();
    private List<String> a = new ArrayList();

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static f a(b b2) {
        f f2 = (f)b.get((Object)b2);
        if (f2 != null) {
            return f2;
        }
        Class<f> class_ = f.class;
        synchronized (f.class) {
            f f3 = (f)b.get((Object)b2);
            if (f3 == null) {
                f3 = new f();
                b.put((Object)b2, (Object)f3);
            }
            // ** MonitorExit[var5_2] (shouldn't be in output)
            return f3;
        }
    }

    public final void a(d d2) {
        f f2 = this;
        synchronized (f2) {
            try {
                Iterator iterator = d2.d.iterator();
                while (iterator.hasNext()) {
                    e e2 = (e)iterator.next();
                    if (!this.a.contains((Object)e2.a)) continue;
                    new Object[1][0] = e2.b();
                    iterator.remove();
                }
                return;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    public final void a(com.adincube.sdk.mediation.b b2) {
        if (b2 == null) {
            return;
        }
        this.a(b2.f().f());
    }

    public final void a(String string) {
        f f2 = this;
        synchronized (f2) {
            new Object[1][0] = string;
            this.a.add((Object)string);
            return;
        }
    }
}

