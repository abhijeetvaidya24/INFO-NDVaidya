/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
package com.applovin.impl.sdk;

import com.applovin.impl.sdk.b.b;
import com.applovin.impl.sdk.e;
import com.applovin.impl.sdk.e.k;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.o;
import com.applovin.impl.sdk.p;
import com.applovin.impl.sdk.t;

public class e
implements o.a,
t.a {
    private k a;
    private final Object b = new Object();
    private final j c;
    private final a d;
    private long e;

    public e(j j2, a a2) {
        this.d = a2;
        this.c = j2;
    }

    static /* synthetic */ void a(e e2) {
        e2.j();
    }

    static /* synthetic */ a b(e e2) {
        return e2.d;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void j() {
        Object object;
        Object object2 = object = this.b;
        synchronized (object2) {
            this.a = null;
            this.c.Q().b(this);
            this.c.R().b(this);
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
        Object object2 = object = this.b;
        synchronized (object2) {
            this.e();
            this.e = l2;
            this.a = k.a(l2, this.c, new Runnable(this){
                final /* synthetic */ e a;
                {
                    this.a = e2;
                }

                public void run() {
                    e.a(this.a);
                    e.b(this.a).onAdRefresh();
                }
            });
            this.c.Q().a(this);
            this.c.R().a(this);
            if (this.c.a(com.applovin.impl.sdk.b.a.A).booleanValue() && (this.c.R().b() || this.c.Q().a())) {
                this.a.b();
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean a() {
        Object object;
        Object object2 = object = this.b;
        synchronized (object2) {
            if (this.a == null) return false;
            return true;
        }
    }

    @Override
    public void b() {
        if (this.c.a(com.applovin.impl.sdk.b.a.z).booleanValue()) {
            this.f();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    @Override
    public void c() {
        Object object;
        if (this.c.a(com.applovin.impl.sdk.b.a.z) == false) return;
        Object object2 = object = this.b;
        // MONITORENTER : object2
        if (this.c.R().b()) {
            this.c.u().a("AdRefreshManager", "Waiting for the full screen ad to be dismissed to resume the timer.");
            // MONITOREXIT : object2
            return;
        }
        k k2 = this.a;
        boolean bl = false;
        if (k2 != null) {
            long l2 = this.e - this.d();
            long l3 = this.c.a(com.applovin.impl.sdk.b.a.y);
            if (l3 >= 0L && l2 > l3) {
                this.e();
                bl = true;
            } else {
                this.a.c();
            }
        }
        // MONITOREXIT : object2
        if (!bl) return;
        this.d.onAdRefresh();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public long d() {
        Object object;
        Object object2 = object = this.b;
        synchronized (object2) {
            if (this.a == null) return -1L;
            return this.a.a();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void e() {
        Object object;
        Object object2 = object = this.b;
        synchronized (object2) {
            if (this.a != null) {
                this.a.d();
                this.j();
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void f() {
        Object object;
        Object object2 = object = this.b;
        synchronized (object2) {
            if (this.a != null) {
                this.a.b();
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void g() {
        Object object;
        Object object2 = object = this.b;
        synchronized (object2) {
            if (this.a != null) {
                this.a.c();
            }
            return;
        }
    }

    @Override
    public void h() {
        if (this.c.a(com.applovin.impl.sdk.b.a.A).booleanValue()) {
            this.f();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void i() {
        Object object;
        if (!this.c.a(com.applovin.impl.sdk.b.a.A).booleanValue()) {
            return;
        }
        Object object2 = object = this.b;
        synchronized (object2) {
            if (this.c.Q().a()) {
                this.c.u().a("AdRefreshManager", "Waiting for the application to enter foreground to resume the timer.");
                return;
            }
            if (this.a != null) {
                this.a.c();
            }
            return;
        }
    }

}

