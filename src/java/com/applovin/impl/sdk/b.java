/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.System
 */
package com.applovin.impl.sdk;

import com.applovin.impl.sdk.b;
import com.applovin.impl.sdk.e.k;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.t;

public class b
implements t.a {
    private final j a;
    private final a b;
    private k c;
    private final Object d = new Object();
    private long e;

    public b(j j2, a a2) {
        this.a = j2;
        this.b = a2;
    }

    static /* synthetic */ a a(b b2) {
        return b2.b;
    }

    private void d() {
        k k2 = this.c;
        if (k2 != null) {
            k2.d();
            this.c = null;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a() {
        Object object;
        Object object2 = object = this.d;
        synchronized (object2) {
            this.d();
            this.a.Q().b(this);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(long l2) {
        Object object;
        Object object2 = object = this.d;
        synchronized (object2) {
            this.a();
            this.e = l2 + System.currentTimeMillis();
            this.a.Q().a(this);
            this.c = k.a(l2, this.a, new Runnable(this){
                final /* synthetic */ b a;
                {
                    this.a = b2;
                }

                public void run() {
                    this.a.a();
                    b.a(this.a).onAdExpired();
                }
            });
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void b() {
        Object object;
        Object object2 = object = this.d;
        synchronized (object2) {
            this.d();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void c() {
        boolean bl;
        Object object;
        Object object2 = object = this.d;
        synchronized (object2) {
            long l2 = this.e - System.currentTimeMillis();
            if (l2 > 0L) {
                this.a(l2);
                return;
            }
            this.a();
            bl = true;
        }
        if (!bl) return;
        this.b.onAdExpired();
    }

}

