/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.ref.WeakReference
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.Set
 */
package com.tapjoy.internal;

import android.app.Activity;
import android.app.Application;
import com.tapjoy.internal.bd;
import com.tapjoy.internal.cd;
import com.tapjoy.internal.cw;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

public final class d {
    private static Application a;
    private static int b;
    private static final cd c;
    private static final Set d;
    private static final cd e;

    static {
        c = new cd();
        d = Collections.synchronizedSet((Set)new bd());
        e = new cd();
    }

    public static Activity a() {
        Activity activity = (Activity)e.a();
        if (activity == null) {
            activity = d.c();
        }
        return activity;
    }

    public static void a(Activity activity) {
        c.a((Object)activity);
    }

    public static void a(Application application) {
        Class<d> class_ = d.class;
        synchronized (d.class) {
            if (a != application) {
                a = application;
            }
            // ** MonitorExit[var2_1] (shouldn't be in output)
            return;
        }
    }

    public static void b(Activity activity) {
        b = 1 + b;
        c.a((Object)activity);
        d.add((Object)activity);
    }

    public static boolean b() {
        return b > 0;
    }

    public static Activity c() {
        Activity activity = (Activity)c.a();
        if (activity != null) {
            return activity;
        }
        return (Activity)cw.a(d.iterator());
    }

    public static void c(Activity activity) {
        b = -1 + b;
        d.c.a = null;
        d.remove((Object)activity);
        if (b < 0) {
            b = 0;
        }
    }
}

