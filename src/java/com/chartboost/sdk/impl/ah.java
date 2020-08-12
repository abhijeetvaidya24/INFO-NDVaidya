/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.util.concurrent.Executor
 */
package com.chartboost.sdk.impl;

import android.os.Handler;
import com.chartboost.sdk.Libraries.i;
import com.chartboost.sdk.impl.ad;
import com.chartboost.sdk.impl.ai;
import com.chartboost.sdk.impl.an;
import com.chartboost.sdk.impl.ao;
import java.util.concurrent.Executor;

public class ah {
    private final Executor a;
    private final Executor b;
    private final ao c;
    private final ai d;
    private final i e;
    private final Handler f;

    public ah(Executor executor, ao ao2, ai ai2, i i2, Handler handler, Executor executor2) {
        this.a = executor2;
        this.b = executor;
        this.c = ao2;
        this.d = ai2;
        this.e = i2;
        this.f = handler;
    }

    public <T> void a(ad<T> ad2) {
        Executor executor = this.a;
        an<T> an2 = new an<T>(this.b, this.c, this.d, this.e, this.f, ad2);
        executor.execute(an2);
    }
}

