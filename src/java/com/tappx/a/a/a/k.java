/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.tappx.a.a.a.d.ab
 *  com.tappx.a.a.a.d.ab$a
 *  com.tappx.a.a.a.d.k
 *  com.tappx.a.a.a.d.k$a
 *  com.tappx.a.a.a.d.r
 *  com.tappx.a.a.a.d.r$a
 *  com.tappx.a.a.a.d.t
 *  com.tappx.a.a.a.d.u
 *  com.tappx.a.a.a.d.v
 *  java.lang.Class
 *  java.lang.Deprecated
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.List
 */
package com.tappx.a.a.a;

import android.content.Context;
import com.tappx.a.a.a.a.a;
import com.tappx.a.a.a.b.i;
import com.tappx.a.a.a.d.ab;
import com.tappx.a.a.a.d.k;
import com.tappx.a.a.a.d.r;
import com.tappx.a.a.a.d.t;
import com.tappx.a.a.a.d.u;
import com.tappx.a.a.a.d.v;
import com.tappx.a.a.a.i.a.a;
import com.tappx.a.a.a.j.e;
import java.util.ArrayList;
import java.util.List;

public class k {
    private static volatile k a;
    private final com.tappx.a.a.a.e b;

    public k(Context context) {
        this.b = com.tappx.a.a.a.e.a(context);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static k a(Context context) {
        k k2 = a;
        if (k2 != null) {
            return k2;
        }
        Class<k> class_ = k.class;
        synchronized (k.class) {
            k k3 = a;
            if (k3 != null) return k3;
            return new k(context);
        }
    }

    @Deprecated
    public static void a(k k2) {
        a = k2;
    }

    private List<t.a> c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add((Object)new r.a(this.e()));
        arrayList.add((Object)new ab.a(this.e(), this.d()));
        arrayList.add((Object)new k.a(this.e()));
        return arrayList;
    }

    private i d() {
        return this.b.d();
    }

    private a e() {
        return this.b.f();
    }

    public e a() {
        e e2 = new e(a.a.h, a.a.i, a.a.j);
        return e2;
    }

    public u b() {
        return new v(this.c());
    }
}

