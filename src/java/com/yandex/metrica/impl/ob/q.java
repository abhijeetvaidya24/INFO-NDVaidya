/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.yandex.metrica.impl.a
 *  com.yandex.metrica.impl.a$a
 *  com.yandex.metrica.impl.ob.ca
 *  com.yandex.metrica.impl.ob.t
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 */
package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.a;
import com.yandex.metrica.impl.ob.ca;
import com.yandex.metrica.impl.ob.r;
import com.yandex.metrica.impl.ob.t;
import java.util.HashMap;

public class q {
    private final HashMap<String, a> a = new HashMap();

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public a a(t t2, ca ca2) {
        q q2 = this;
        synchronized (q2) {
            a a2 = (a)this.a.get((Object)t2.l().toString());
            if (a2 == null) {
                a.a a3 = ca2.a();
                a2 = new a(a3.a, a3.b);
                this.a.put((Object)t2.l().toString(), (Object)a2);
            }
            return a2;
        }
    }

    public boolean a(a.a a2, ca ca2) {
        if (a2.b > ca2.a().b) {
            ca2.a(a2).h();
            return true;
        }
        return false;
    }

    public void b(a.a a2, ca ca2) {
        q q2 = this;
        synchronized (q2) {
            ca2.a(a2).h();
            return;
        }
    }
}

