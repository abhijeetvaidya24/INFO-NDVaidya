/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.SparseArray
 *  java.lang.Class
 *  java.lang.Object
 */
package com.tappx.a.a.b.a;

import android.util.SparseArray;
import com.tappx.a.a.b.a.d;

public class c {
    private static final SparseArray<d.a> a = new SparseArray();
    private static volatile int b = 0;

    private static int a() {
        Class<c> class_ = c.class;
        synchronized (c.class) {
            int n2 = b;
            b = 1 + b;
            // ** MonitorExit[var2] (shouldn't be in output)
            return n2;
        }
    }

    public static int a(d.a a2) {
        int n2 = c.a();
        a.append(n2, (Object)a2);
        return n2;
    }

    public static d.a a(int n2) {
        return (d.a)a.get(n2);
    }

    public static void b(int n2) {
        a.remove(n2);
    }
}

