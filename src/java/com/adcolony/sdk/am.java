/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 *  java.lang.Integer
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.concurrent.ExecutorService
 *  java.util.concurrent.Executors
 *  org.json.JSONObject
 */
package com.adcolony.sdk;

import com.adcolony.sdk.AdColony;
import com.adcolony.sdk.a;
import com.adcolony.sdk.aa;
import com.adcolony.sdk.ad;
import com.adcolony.sdk.ae;
import com.adcolony.sdk.af;
import com.adcolony.sdk.ag;
import com.adcolony.sdk.ah;
import com.adcolony.sdk.aj;
import com.adcolony.sdk.am;
import com.adcolony.sdk.au;
import com.adcolony.sdk.aw;
import com.adcolony.sdk.l;
import com.adcolony.sdk.w;
import com.adcolony.sdk.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;

class am
implements Runnable {
    private final long a = 30000L;
    private final int b = 17;
    private final int c = 15000;
    private final int d = 1000;
    private long e;
    private long f;
    private long g;
    private long h;
    private long i;
    private long j;
    private long k;
    private long l;
    private boolean m = true;
    private boolean n = true;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;

    am() {
    }

    private void a(long l2) {
        try {
            Thread.sleep((long)l2);
        }
        catch (InterruptedException interruptedException) {}
    }

    static /* synthetic */ boolean a(am am2, boolean bl) {
        am2.s = bl;
        return bl;
    }

    private void f() {
        this.b(false);
    }

    private void g() {
        this.c(false);
    }

    public void a() {
        a.a("SessionInfo.stopped", new af(this){
            final /* synthetic */ am a;
            {
                this.a = am2;
            }

            public void a(ad ad2) {
                am.a(this.a, true);
            }
        });
    }

    void a(boolean bl) {
        if (this.p) {
            return;
        }
        if (this.q) {
            a.a().b(false);
            this.q = false;
        }
        this.e = 0L;
        this.f = 0L;
        this.p = true;
        this.m = true;
        this.s = false;
        new Thread((Runnable)this).start();
        if (bl) {
            JSONObject jSONObject = w.a();
            w.a(jSONObject, "id", au.e());
            new ad("SessionInfo.on_start", 1, jSONObject).b();
            aw aw2 = (aw)a.a().p().e().get((Object)1);
            if (aw2 != null) {
                aw2.g();
            }
        }
        if (AdColony.a.isShutdown()) {
            AdColony.a = Executors.newSingleThreadExecutor();
        }
        aa.a();
    }

    void b() {
        this.p = false;
        this.m = false;
        if (aa.l != null) {
            aa.l.a();
        }
        JSONObject jSONObject = w.a();
        double d2 = this.e;
        Double.isNaN((double)d2);
        w.a(jSONObject, "session_length", d2 / 1000.0);
        new ad("SessionInfo.on_stop", 1, jSONObject).b();
        a.f();
        AdColony.a.shutdown();
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
    void b(boolean bl) {
        ArrayList<ag> arrayList;
        ArrayList<ag> arrayList2 = arrayList = a.a().p().c();
        // MONITORENTER : arrayList2
        for (ag ag2 : arrayList) {
            JSONObject jSONObject = w.a();
            w.a(jSONObject, "from_window_focus", bl);
            new ad("SessionInfo.on_pause", ag2.a(), jSONObject).b();
        }
        // MONITOREXIT : arrayList2
        {
            catch (Throwable throwable) {}
            {
                // MONITOREXIT : arrayList2
                throw throwable;
            }
        }
        this.n = true;
        a.f();
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
    void c(boolean bl) {
        ArrayList<ag> arrayList;
        ArrayList<ag> arrayList2 = arrayList = a.a().p().c();
        // MONITORENTER : arrayList2
        for (ag ag2 : arrayList) {
            JSONObject jSONObject = w.a();
            w.a(jSONObject, "from_window_focus", bl);
            new ad("SessionInfo.on_resume", ag2.a(), jSONObject).b();
        }
        // MONITOREXIT : arrayList2
        {
            catch (Throwable throwable) {}
            {
                // MONITOREXIT : arrayList2
                throw throwable;
            }
        }
        aa.a();
        this.n = false;
    }

    boolean c() {
        return this.m;
    }

    void d(boolean bl) {
        this.m = bl;
    }

    void e(boolean bl) {
        this.o = bl;
    }

    boolean e() {
        return this.p;
    }

    void f(boolean bl) {
        this.t = bl;
    }

    public void run() {
        while (!this.r) {
            this.h = System.currentTimeMillis();
            a.f();
            if (this.f >= 30000L) break;
            if (!this.m) {
                if (this.o && !this.n) {
                    this.o = false;
                    this.f();
                }
                long l2 = this.f;
                long l3 = this.l == 0L ? 0L : System.currentTimeMillis() - this.l;
                this.f = l2 + l3;
                this.l = System.currentTimeMillis();
            } else {
                if (this.o && this.n) {
                    this.o = false;
                    this.g();
                }
                this.f = 0L;
                this.l = 0L;
            }
            this.g = 17L;
            this.a(this.g);
            long l4 = this.i = System.currentTimeMillis() - this.h;
            if (l4 > 0L && l4 < 6000L) {
                this.e = l4 + this.e;
            }
            l l5 = a.a();
            long l6 = System.currentTimeMillis();
            if (l6 - this.k > 15000L) {
                this.k = l6;
            }
            if (!a.d() || l6 - this.j <= 1000L) continue;
            this.j = l6;
            String string = l5.d.c();
            if (string.equals((Object)l5.v())) continue;
            l5.a(string);
            JSONObject jSONObject = w.a();
            w.a(jSONObject, "network_type", l5.v());
            new ad("Network.on_status_change", 1, jSONObject).b();
        }
        new y.a().a("AdColony session ending, releasing Context.").a(y.c);
        a.a().b(true);
        a.a(null);
        this.q = true;
        this.t = true;
        this.b();
        au.a a2 = new au.a(10.0);
        while (!this.s && !a2.b()) {
            if (!this.t) {
                return;
            }
            a.f();
            this.a(100L);
        }
    }
}

