/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  com.moat.analytics.mobile.tjy.n
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 */
package com.moat.analytics.mobile.tjy;

import android.os.Handler;
import android.os.Looper;
import com.moat.analytics.mobile.tjy.base.exception.a;
import com.moat.analytics.mobile.tjy.n;
import com.moat.analytics.mobile.tjy.t;

class s
implements Runnable {
    final /* synthetic */ n a;

    s(n n2) {
        this.a = n2;
    }

    public void run() {
        try {
            new Handler(Looper.getMainLooper()).post((Runnable)new t(this));
            return;
        }
        catch (Exception exception) {
            a.a(exception);
            return;
        }
    }
}

