/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  com.yandex.metrica.impl.b
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.ref.WeakReference
 */
package com.yandex.metrica.impl;

import android.os.Handler;
import com.yandex.metrica.impl.b;
import com.yandex.metrica.impl.w;
import java.lang.ref.WeakReference;

class x
implements Runnable {
    private final WeakReference<Handler> a;
    private final WeakReference<b> b;

    x(Handler handler, b b2) {
        this.a = new WeakReference((Object)handler);
        this.b = new WeakReference((Object)b2);
    }

    public void run() {
        Handler handler = (Handler)this.a.get();
        b b2 = (b)this.b.get();
        if (handler != null && b2 != null && b2.c()) {
            w.a(handler, b2, this);
        }
    }
}

