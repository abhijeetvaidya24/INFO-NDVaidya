/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.moat.analytics.mobile.tjy.az
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.ref.WeakReference
 *  java.lang.reflect.Method
 *  java.util.LinkedList
 *  java.util.Map
 */
package com.moat.analytics.mobile.tjy;

import com.moat.analytics.mobile.tjy.ay;
import com.moat.analytics.mobile.tjy.az;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.Map;

class bb {
    final /* synthetic */ ay a;
    private final WeakReference[] b;
    private final LinkedList c = new LinkedList();
    private final Method d;

    private /* varargs */ bb(ay ay2, Method method, Object ... arrobject) {
        this.a = ay2;
        if (arrobject == null) {
            arrobject = ay.a();
        }
        WeakReference[] arrweakReference = new WeakReference[arrobject.length];
        int n2 = arrobject.length;
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            Object object = arrobject[i2];
            if (object instanceof Map || object instanceof Integer) {
                this.c.add(object);
            }
            int n4 = n3 + 1;
            arrweakReference[n3] = new WeakReference(object);
            n3 = n4;
        }
        this.b = arrweakReference;
        this.d = method;
    }

    /* synthetic */ bb(ay ay2, Method method, Object[] arrobject, az az2) {
        this(ay2, method, arrobject);
    }

    static /* synthetic */ WeakReference[] a(bb bb2) {
        return bb2.b;
    }

    static /* synthetic */ Method b(bb bb2) {
        return bb2.d;
    }
}

