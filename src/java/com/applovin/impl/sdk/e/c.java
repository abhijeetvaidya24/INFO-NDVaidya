/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 */
package com.applovin.impl.sdk.e;

import com.applovin.impl.sdk.e.c;
import com.applovin.impl.sdk.e.k;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.t;

public class c
implements t.a {
    private final k a;

    private c(long l2, j j2, Runnable runnable) {
        t t2 = j2.Q();
        this.a = k.a(l2, j2, new Runnable(this, t2, runnable){
            final /* synthetic */ t a;
            final /* synthetic */ Runnable b;
            final /* synthetic */ c c;
            {
                this.c = c2;
                this.a = t2;
                this.b = runnable;
            }

            public void run() {
                this.a.b(this.c);
                this.c.a();
                Runnable runnable = this.b;
                if (runnable != null) {
                    runnable.run();
                }
            }
        });
        t2.a(this);
    }

    public static c a(long l2, j j2, Runnable runnable) {
        return new c(l2, j2, runnable);
    }

    public void a() {
        this.a.d();
    }

    @Override
    public void b() {
        this.a.b();
    }

    @Override
    public void c() {
        this.a.c();
    }
}

