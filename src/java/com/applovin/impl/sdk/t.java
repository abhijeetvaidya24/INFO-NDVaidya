/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.content.Context
 *  android.os.Bundle
 *  com.applovin.impl.sdk.EventServiceImpl
 *  java.lang.Boolean
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Date
 *  java.util.Iterator
 *  java.util.List
 *  java.util.concurrent.TimeUnit
 *  java.util.concurrent.atomic.AtomicBoolean
 */
package com.applovin.impl.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.applovin.impl.sdk.EventServiceImpl;
import com.applovin.impl.sdk.b.b;
import com.applovin.impl.sdk.c.g;
import com.applovin.impl.sdk.c.h;
import com.applovin.impl.sdk.e.e;
import com.applovin.impl.sdk.j;
import com.applovin.sdk.AppLovinEventService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class t {
    private static final String[] a = new String[]{"paused", "saved_instance_state"};
    private static final String[] b = new String[]{"saved_instance_state", "paused"};
    private static final String[] c = new String[]{"paused", "stopped"};
    private static final String[] d = new String[]{"paused", "saved_instance_state", "stopped", "started"};
    private static final String[] e = new String[]{"paused", "stopped", "saved_instance_state", "started"};
    private static final String[] f = new String[]{"saved_instance_state", "paused", "stopped", "started"};
    private final j g;
    private final List<String> h = new ArrayList();
    private final AtomicBoolean i = new AtomicBoolean();
    private final AtomicBoolean j = new AtomicBoolean();
    private final AtomicBoolean k = new AtomicBoolean();
    private volatile boolean l;
    private Date m;
    private Date n;
    private final List<a> o = new ArrayList();
    private final Object p = new Object();

    t(j j2) {
        this.g = j2;
    }

    private void a(boolean bl) {
        this.l = true;
        this.l();
        if (bl) {
            return;
        }
        if (this.g.a(b.ei).booleanValue()) {
            boolean bl2 = this.g.a(b.ef);
            long l2 = this.g.a(b.eh);
            long l3 = TimeUnit.MINUTES.toMillis(l2);
            if (this.m == null || System.currentTimeMillis() - this.m.getTime() >= l3) {
                ((EventServiceImpl)this.g.p()).a("paused", false);
                if (bl2) {
                    this.m = new Date();
                }
            }
            if (!bl2) {
                this.m = new Date();
            }
        }
    }

    private static boolean a(List<String> list, String[] arrstring) {
        int n2 = list.size();
        int n3 = arrstring.length;
        if (n2 != 0) {
            if (n3 == 0) {
                return false;
            }
            if (n2 >= arrstring.length) {
                int n4;
                for (int i2 = n4 = n2 - n3; i2 < n3; ++i2) {
                    if (((String)list.get(i2)).equals((Object)arrstring[i2 - n4])) continue;
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    private void f() {
        this.h.add((Object)"paused");
    }

    private void g() {
        if (t.a(this.h, c)) {
            this.a(this.k.get());
        }
        this.h.add((Object)"saved_instance_state");
    }

    private void h() {
        if (t.a(this.h, a) || t.a(this.h, b)) {
            this.a(this.k.get());
        }
        this.h.add((Object)"stopped");
    }

    private void i() {
        if (this.h.isEmpty()) {
            return;
        }
        List<String> list = this.h;
        String string2 = (String)list.get(-1 + list.size());
        if (!"stopped".equals((Object)string2) && !"saved_instance_state".equals((Object)string2)) {
            this.h.clear();
            return;
        }
        this.h.add((Object)"started");
    }

    private void j() {
        if (t.a(this.h, d) || t.a(this.h, e) || t.a(this.h, f)) {
            boolean bl = this.g.a(b.ef);
            long l2 = this.g.a(b.eg);
            this.l = false;
            this.m();
            if (this.k.getAndSet(false)) {
                return;
            }
            long l3 = TimeUnit.MINUTES.toMillis(l2);
            if (this.n == null || System.currentTimeMillis() - this.n.getTime() >= l3) {
                ((EventServiceImpl)this.g.p()).a("resumed", false);
                if (bl) {
                    this.n = new Date();
                }
            }
            if (!bl) {
                this.n = new Date();
            }
            this.g.D().a(g.n);
            this.j.set(true);
        }
        this.h.clear();
    }

    private void k() {
        this.h.clear();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private void l() {
        Object object;
        Object object2 = object = this.p;
        // MONITORENTER : object2
        ArrayList arrayList = new ArrayList(this.o);
        // MONITOREXIT : object2
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            ((a)iterator.next()).b();
        }
        return;
        {
            catch (Throwable throwable) {}
            {
                // MONITOREXIT : object2
                throw throwable;
            }
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private void m() {
        Object object;
        Object object2 = object = this.p;
        // MONITORENTER : object2
        ArrayList arrayList = new ArrayList(this.o);
        // MONITOREXIT : object2
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            ((a)iterator.next()).c();
        }
        return;
        {
            catch (Throwable throwable) {}
            {
                // MONITOREXIT : object2
                throw throwable;
            }
        }
    }

    void a(Context context) {
        if (context != null && e.b() && this.g.a(b.ee).booleanValue() && !this.i.getAndSet(true)) {
            if (!(context instanceof Application)) {
                context = context.getApplicationContext();
            }
            ((Application)context).registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks(){

                public void onActivityCreated(Activity activity, Bundle bundle) {
                    t.this.k();
                }

                public void onActivityDestroyed(Activity activity) {
                    t.this.k();
                }

                public void onActivityPaused(Activity activity) {
                    t.this.f();
                }

                public void onActivityResumed(Activity activity) {
                    t.this.j();
                }

                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    t.this.g();
                }

                public void onActivityStarted(Activity activity) {
                    t.this.i();
                }

                public void onActivityStopped(Activity activity) {
                    t.this.h();
                }
            });
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(a a2) {
        Object object;
        Object object2 = object = this.p;
        synchronized (object2) {
            this.o.add((Object)a2);
            return;
        }
    }

    public boolean a() {
        return this.l;
    }

    public void b() {
        this.k.set(true);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b(a a2) {
        Object object;
        Object object2 = object = this.p;
        synchronized (object2) {
            this.o.remove((Object)a2);
            return;
        }
    }

    public void c() {
        this.k.set(false);
    }

    boolean d() {
        return this.i.get();
    }

    boolean e() {
        return this.j.getAndSet(false);
    }

    public static interface a {
        public void b();

        public void c();
    }

}

