/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.os.Looper
 *  com.startapp.android.publish.adsCommon.f.b
 *  java.lang.Object
 *  java.lang.Runnable
 */
package com.startapp.android.publish.adsCommon.h;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.startapp.android.publish.adsCommon.f.b;
import com.startapp.android.publish.adsCommon.h.a;
import com.startapp.common.d;
import com.startapp.common.g;

public abstract class a
implements d {
    protected final Context a;
    protected final Runnable b;
    protected b c;
    private Handler d;

    public a(Context context, Runnable runnable, b b2) {
        this.a = context;
        this.b = runnable;
        this.c = b2;
        this.d = new Handler(Looper.getMainLooper());
    }

    public void a() {
        g.a(g.a.a, new Runnable(this){
            final /* synthetic */ a a;
            {
                this.a = a2;
            }

            public void run() {
                this.a.b();
            }
        });
    }

    @Override
    public void a(Object object) {
        Handler handler = this.d;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.b.run();
    }

    protected void a(Runnable runnable, long l2) {
        this.d.postDelayed(runnable, l2);
    }

    protected abstract void b();
}

