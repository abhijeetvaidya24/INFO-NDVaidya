/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.moat.analytics.mobile.aer.av
 *  java.lang.Object
 *  java.lang.ref.WeakReference
 *  java.lang.reflect.Method
 */
package com.moat.analytics.mobile.aer;

import com.moat.analytics.mobile.aer.au;
import com.moat.analytics.mobile.aer.av;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;

class ax {
    final /* synthetic */ au a;
    private final WeakReference[] b;
    private final Method c;

    private /* varargs */ ax(au au2, Method method, Object ... arrobject) {
        this.a = au2;
        if (arrobject == null) {
            arrobject = au.a();
        }
        WeakReference[] arrweakReference = new WeakReference[arrobject.length];
        int n2 = arrobject.length;
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            Object object = arrobject[i2];
            int n4 = n3 + 1;
            arrweakReference[n3] = new WeakReference(object);
            n3 = n4;
        }
        this.b = arrweakReference;
        this.c = method;
    }

    /* synthetic */ ax(au au2, Method method, Object[] arrobject, av av2) {
        this(au2, method, arrobject);
    }

    static /* synthetic */ WeakReference[] a(ax ax2) {
        return ax2.b;
    }

    static /* synthetic */ Method b(ax ax2) {
        return ax2.c;
    }
}

