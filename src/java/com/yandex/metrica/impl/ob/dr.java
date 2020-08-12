/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 */
package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.yandex.metrica.impl.ob.dp;

public class dr {
    private static final Object a = new Object();
    private static volatile dr b;
    private dp c;

    private dr(Context context) {
        this.c = new dp(context);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static dr a(Context context) {
        Object object;
        if (b != null) return b;
        Object object2 = object = a;
        synchronized (object2) {
            if (b != null) return b;
            b = new dr(context);
            return b;
        }
    }

    public void a() {
        this.c.b();
    }

    public void b() {
        this.c.a();
    }
}

