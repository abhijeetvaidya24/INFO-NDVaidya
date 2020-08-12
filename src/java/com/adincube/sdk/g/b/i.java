/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.List
 */
package com.adincube.sdk.g.b;

import com.adincube.sdk.g.b.g;
import com.adincube.sdk.h.c.b;
import com.adincube.sdk.h.c.d;
import com.adincube.sdk.h.c.e;
import com.adincube.sdk.mediation.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class i {
    private b a;
    private g b;

    public i(b b2, g g2) {
        this.a = b2;
        this.b = g2;
    }

    /*
     * Enabled aggressive block sorting
     */
    private static int a(List<Integer> list, g.a a2, long l2, long l3) {
        long l4 = 0L;
        if (l2 <= l4) return (Integer)list.get(-1 + list.size());
        if (a2.c == null) {
            return (Integer)list.get(-1 + list.size());
        }
        long l5 = l3 - a2.e;
        if (l5 >= l4) {
            l4 = l5 / l2;
        }
        int n2 = 0;
        int n3 = (Integer)list.get(0);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            if ((long)n2 > l4) return n3;
            int n4 = (Integer)iterator.next();
            if (n4 >= a2.c) {
                if ((!a2.d || n4 < a2.c) && (a2.d || n4 <= a2.c)) continue;
                ++n2;
            }
            n3 = n4;
        }
        return n3;
    }

    private static List<Integer> a(List<e> list) {
        ArrayList arrayList = new ArrayList();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer n2 = ((e)iterator.next()).f.b().b;
            if (n2 == null) continue;
            arrayList.add((Object)n2);
        }
        Collections.reverse((List)arrayList);
        return arrayList;
    }

    private static List<e> a(List<e> list, int n2) {
        ArrayList arrayList = new ArrayList();
        for (e e2 : list) {
            Integer n3 = e2.f.b().b;
            if (n3 == null || n3 <= n2) continue;
            arrayList.add((Object)e2);
        }
        return arrayList;
    }

    final void a(d d2, String string, com.adincube.sdk.mediation.e e2, long l2) {
        Long l3 = e2.f;
        if (l3 == null) {
            return;
        }
        g.a a2 = this.b.a(this.a, string);
        if (a2 == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (e e3 : d2.d) {
            if (!e3.b().equals((Object)string)) continue;
            arrayList.add((Object)e3);
        }
        List<Integer> list = i.a((List<e>)arrayList);
        if (list.isEmpty()) {
            return;
        }
        List<e> list2 = i.a((List<e>)arrayList, i.a(list, a2, l3, l2));
        if (list2.isEmpty()) {
            return;
        }
        d2.d.removeAll(list2);
        StringBuilder stringBuilder = new StringBuilder();
        for (e e4 : list2) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append((Object)e4.f.b().b);
        }
        Object[] arrobject = new Object[]{string, stringBuilder};
    }
}

