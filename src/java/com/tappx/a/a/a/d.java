/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.tappx.a.a.a.d.aa
 *  com.tappx.a.a.a.d.aa$a
 *  com.tappx.a.a.a.d.c
 *  com.tappx.a.a.a.d.d
 *  com.tappx.a.a.a.d.e
 *  com.tappx.a.a.a.d.j
 *  com.tappx.a.a.a.d.j$a
 *  com.tappx.a.a.a.d.p
 *  com.tappx.a.a.a.d.p$a
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
import com.tappx.a.a.a.d.aa;
import com.tappx.a.a.a.d.c;
import com.tappx.a.a.a.d.e;
import com.tappx.a.a.a.d.j;
import com.tappx.a.a.a.d.p;
import com.tappx.a.a.a.i.a.a;
import com.tappx.a.a.a.j.b;
import java.util.ArrayList;
import java.util.List;

public class d {
    private static volatile d a;
    private final Context b;

    private d(Context context) {
        this.b = context;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static d a(Context context) {
        d d2 = a;
        if (d2 != null) {
            return d2;
        }
        Class<d> class_ = d.class;
        synchronized (d.class) {
            d d3 = a;
            if (d3 != null) return d3;
            a = new d(context.getApplicationContext());
            return a;
        }
    }

    @Deprecated
    public static void a(d d2) {
        a = d2;
    }

    private List<c$a> f() {
        ArrayList arrayList = new ArrayList();
        arrayList.add((Object)new p$a(this.d()));
        arrayList.add((Object)new aa$a(this.d(), this.e().d()));
        arrayList.add((Object)new j$a(this.d()));
        return arrayList;
    }

    public com.tappx.a.a.a.d.d a() {
        return new e(this.f());
    }

    public com.tappx.a.a.a.j.e b() {
        com.tappx.a.a.a.j.e e2 = new com.tappx.a.a.a.j.e(a.a.e, a.a.f, a.a.g);
        return e2;
    }

    public b c() {
        return new b(this.e().c());
    }

    public a d() {
        return this.e().f();
    }

    com.tappx.a.a.a.e e() {
        return com.tappx.a.a.a.e.a(this.b);
    }
}

