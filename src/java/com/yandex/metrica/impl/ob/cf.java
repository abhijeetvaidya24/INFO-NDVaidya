/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.yandex.metrica.impl.be
 *  com.yandex.metrica.impl.be$a
 *  java.lang.Class
 *  java.lang.Long
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 */
package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.be;
import com.yandex.metrica.impl.ob.ce;
import com.yandex.metrica.impl.ob.cj;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class cf {
    private final String a;
    private final cj b;
    private int c;
    private final List<ce> d;
    private final List<ce> e;
    private final List<ce> f;

    cf(String string2, cj cj2) {
        this.a = string2;
        this.b = cj2;
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = new ArrayList();
    }

    public void a(ce ce2) {
        this.c += ce2.c().b;
        this.d.add((Object)ce2);
        int n2 = 1.a[ce2.a(this.b).ordinal()];
        if (n2 != 1) {
            if (n2 != 2) {
                return;
            }
            this.f.add((Object)ce2);
            return;
        }
        this.e.add((Object)ce2);
    }

    public boolean a() {
        return !this.f.isEmpty();
    }

    public int b() {
        return this.d.size();
    }

    public String c() {
        return this.a;
    }

    public List<ce> d() {
        return this.d;
    }

    public Long e() {
        Long l2 = Long.MAX_VALUE;
        Iterator iterator = this.d.iterator();
        while (iterator.hasNext()) {
            Long l3 = ((ce)iterator.next()).c().c;
            if (l3.compareTo(l2) >= 0) continue;
            l2 = l3;
        }
        return l2;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null && this.getClass() == object.getClass()) {
            cf cf2 = (cf)object;
            return this.a.equals((Object)cf2.a);
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

}

