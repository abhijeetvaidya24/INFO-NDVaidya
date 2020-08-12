/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.os.Handler
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  com.chartboost.sdk.Tracking.a
 *  com.chartboost.sdk.h$1
 *  com.chartboost.sdk.impl.aj
 *  com.chartboost.sdk.impl.m
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.concurrent.Executor
 *  java.util.concurrent.ScheduledExecutorService
 *  java.util.concurrent.atomic.AtomicReference
 *  org.json.JSONObject
 */
package com.chartboost.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.f;
import com.chartboost.sdk.Libraries.i;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.Model.e;
import com.chartboost.sdk.b;
import com.chartboost.sdk.d;
import com.chartboost.sdk.g;
import com.chartboost.sdk.h;
import com.chartboost.sdk.impl.ad;
import com.chartboost.sdk.impl.ah;
import com.chartboost.sdk.impl.ai;
import com.chartboost.sdk.impl.aj;
import com.chartboost.sdk.impl.ak;
import com.chartboost.sdk.impl.al;
import com.chartboost.sdk.impl.ao;
import com.chartboost.sdk.impl.ap;
import com.chartboost.sdk.impl.aw;
import com.chartboost.sdk.impl.c;
import com.chartboost.sdk.impl.e;
import com.chartboost.sdk.impl.l;
import com.chartboost.sdk.impl.m;
import com.chartboost.sdk.impl.o;
import com.chartboost.sdk.impl.s;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

public class h {
    private static h v;
    public final Executor a;
    final l b;
    public final com.chartboost.sdk.Libraries.d c;
    public final com.chartboost.sdk.impl.e d;
    public final c e;
    final com.chartboost.sdk.impl.e f;
    final c g;
    public final ah h;
    final m i;
    public final ap j;
    final com.chartboost.sdk.impl.e k;
    final c l;
    public final AtomicReference<e> m;
    final SharedPreferences n;
    public final com.chartboost.sdk.Tracking.a o;
    public final Handler p;
    public final com.chartboost.sdk.c q;
    public final ak r;
    boolean s = true;
    boolean t = false;
    boolean u = true;
    private final s w;

    h(Activity activity, String string, String string2, s s2, ScheduledExecutorService scheduledExecutorService, Handler handler, Executor executor) {
        JSONObject jSONObject;
        g g2 = g.a();
        Context context = activity.getApplicationContext();
        this.c = g2.a(new com.chartboost.sdk.Libraries.d(context));
        ai ai2 = g2.a(new ai());
        i i2 = g2.a(new i());
        ao ao2 = g2.a(new ao());
        ah ah2 = new ah((Executor)scheduledExecutorService, ao2, ai2, i2, handler, executor);
        this.h = g2.a(ah2);
        SharedPreferences sharedPreferences = h.a(context);
        try {
            jSONObject = new JSONObject(sharedPreferences.getString("config", "{}"));
        }
        catch (Exception exception) {
            CBLogging.b("Sdk", "Unable to process config");
            exception.printStackTrace();
            jSONObject = new JSONObject();
        }
        AtomicReference atomicReference = new AtomicReference(null);
        if (!b.a((AtomicReference<e>)atomicReference, jSONObject, sharedPreferences)) {
            atomicReference.set((Object)new e(new JSONObject()));
        }
        this.w = s2;
        this.a = scheduledExecutorService;
        this.m = atomicReference;
        this.n = sharedPreferences;
        this.p = handler;
        f f2 = new f(s2, context, (AtomicReference<e>)atomicReference);
        if (!((e)atomicReference.get()).y) {
            com.chartboost.sdk.i.w = "";
        } else {
            h.a(context, null, sharedPreferences);
        }
        ap ap2 = new ap(context, string, this.c, ai2, (AtomicReference<e>)atomicReference, sharedPreferences, i2);
        this.j = g2.a(ap2);
        this.o = g2.a(new com.chartboost.sdk.Tracking.a(atomicReference));
        l l2 = new l((Executor)scheduledExecutorService, f2, this.h, ai2, (AtomicReference<e>)atomicReference, i2, this.o);
        this.b = g2.a(l2);
        d d2 = g2.a(new d(g.a().a(new aw(handler)), this.b, (AtomicReference<e>)atomicReference, handler));
        this.r = g2.a(new ak((Executor)scheduledExecutorService, this.h, ai2, handler));
        com.chartboost.sdk.c c2 = new com.chartboost.sdk.c(activity, ai2, this, this.o, handler, d2);
        this.q = g2.a(c2);
        al al2 = g2.a(new al(f2));
        this.e = c.c();
        this.g = c.a();
        this.l = c.b();
        com.chartboost.sdk.impl.e e2 = new com.chartboost.sdk.impl.e(this.e, scheduledExecutorService, this.b, f2, this.h, ai2, this.j, (AtomicReference<e>)atomicReference, sharedPreferences, i2, this.o, handler, this.q, this.r, d2, al2);
        this.d = g2.a(e2);
        com.chartboost.sdk.impl.e e3 = new com.chartboost.sdk.impl.e(this.g, scheduledExecutorService, this.b, f2, this.h, ai2, this.j, (AtomicReference<e>)atomicReference, sharedPreferences, i2, this.o, handler, this.q, this.r, d2, al2);
        this.f = g2.a(e3);
        com.chartboost.sdk.impl.e e4 = new com.chartboost.sdk.impl.e(this.l, scheduledExecutorService, this.b, f2, this.h, ai2, this.j, (AtomicReference<e>)atomicReference, sharedPreferences, i2, this.o, handler, this.q, this.r, d2, al2);
        this.k = g2.a(e4);
        m m2 = new m(this.b, f2, this.h, this.j, this.o, atomicReference);
        this.i = g2.a(m2);
        com.chartboost.sdk.i.m = context;
        com.chartboost.sdk.i.k = string;
        com.chartboost.sdk.i.l = string2;
        com.chartboost.sdk.i.x = sharedPreferences.getBoolean("cbLimitTrack", com.chartboost.sdk.i.x);
        ai2.a(com.chartboost.sdk.i.m);
        o.a(activity.getApplication(), ((e)atomicReference.get()).J, true ^ ((e)atomicReference.get()).K, true ^ ((e)atomicReference.get()).L);
    }

    private static SharedPreferences a(Context context) {
        return context.getSharedPreferences("cbPrefs", 0);
    }

    public static h a() {
        return v;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static void a(Context var0, WebView var1_1, SharedPreferences var2_2) {
        var3_3 = com.chartboost.sdk.i.w;
        if (var1_1 != null) ** GOTO lbl6
        try {
            block3 : {
                var5_4 = !var2_2.contains("user_agent") ? new WebView(var0.getApplicationContext()).getSettings().getUserAgentString() : var2_2.getString("user_agent", com.chartboost.sdk.i.w);
                break block3;
lbl6: // 1 sources:
                var5_4 = var1_1.getSettings().getUserAgentString();
            }
            var3_3 = var5_4;
        }
        catch (Exception v0) {}
        com.chartboost.sdk.i.w = var3_3;
        var2_2.edit().putString("user_agent", var3_3).apply();
    }

    static void a(Context context, boolean bl) {
        com.chartboost.sdk.i.x = bl;
        SharedPreferences sharedPreferences = h.a(context);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean("cbLimitTrack", bl).apply();
        }
    }

    static void a(h h2) {
        v = h2;
    }

    public static void b(Runnable runnable) {
        s s2 = s.a();
        if (!s2.e()) {
            s2.a.post(runnable);
            return;
        }
        runnable.run();
    }

    static boolean f() {
        h h2 = h.a();
        if (h2 != null && ((e)h2.m.get()).c) {
            try {
                throw new Exception("Chartboost Integration Warning: your account has been disabled for this session. This app has no active publishing campaigns, please create a publishing campaign in the Chartboost dashboard and wait at least 30 minutes to re-enable. If you need assistance, please visit http://chartboo.st/publishing .");
            }
            catch (Exception exception) {
                exception.printStackTrace();
                return false;
            }
        }
        return true;
    }

    private void g() {
        this.o.a();
        if (!this.u) {
            this.a(new a(3));
        }
    }

    void a(Activity activity) {
        if (this.w.a(23)) {
            b.a((Context)activity);
        }
        if (!this.u && !this.q.e()) {
            this.b.c();
        }
    }

    void a(Runnable runnable) {
        this.s = true;
        1 var2_2 = new 1(this, runnable);
        aj aj2 = new aj("/api/config", this.j, this.o, 1, (aj.a)var2_2);
        aj2.l = true;
        this.h.a(aj2);
    }

    void b() {
        if (com.chartboost.sdk.i.m == null) {
            CBLogging.b("Sdk", "The context must be set through the Chartboost method onCreate() before calling startSession().");
            return;
        }
        this.g();
    }

    void c() {
        this.p.postDelayed((Runnable)new a(0), 500L);
    }

    void d() {
        this.o.b();
    }

    void e() {
        if (!this.t) {
            if (com.chartboost.sdk.i.c != null) {
                com.chartboost.sdk.i.c.didInitialize();
            }
            this.t = true;
        }
    }

    public class a
    implements Runnable {
        final int a;
        String b = null;
        boolean c = false;
        boolean d = false;

        a(int n2) {
            this.a = n2;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public void run() {
            try {
                int n2 = this.a;
                if (n2 == 0) {
                    h.this.d();
                    return;
                }
                if (n2 == 1) {
                    com.chartboost.sdk.i.t = this.c;
                    return;
                }
                if (n2 != 2) {
                    if (n2 == 3) {
                        aj aj2 = new aj("api/install", h.this.j, h.this.o, 2, null);
                        aj2.l = true;
                        h.this.h.a(aj2);
                        Executor executor = h.this.a;
                        com.chartboost.sdk.impl.e e2 = h.this.d;
                        e2.getClass();
                        e.a a2 = new e.a(e2, 0, null, null, null);
                        executor.execute((Runnable)a2);
                        Executor executor2 = h.this.a;
                        com.chartboost.sdk.impl.e e3 = h.this.f;
                        e3.getClass();
                        e.a a3 = new e.a(e3, 0, null, null, null);
                        executor2.execute((Runnable)a3);
                        Executor executor3 = h.this.a;
                        com.chartboost.sdk.impl.e e4 = h.this.k;
                        e4.getClass();
                        e.a a4 = new e.a(e4, 0, null, null, null);
                        executor3.execute((Runnable)a4);
                        h.this.a.execute((Runnable)new a(4));
                        h.this.u = false;
                        return;
                    }
                    if (n2 == 4) {
                        h.this.i.a();
                        return;
                    }
                    if (n2 != 5) {
                        return;
                    }
                    if (com.chartboost.sdk.i.c == null) return;
                    com.chartboost.sdk.i.c.didFailToLoadMoreApps(this.b, CBError.CBImpressionError.END_POINT_DISABLED);
                    return;
                }
                com.chartboost.sdk.i.v = this.d;
                if (this.d && h.f()) {
                    h.this.i.a();
                    return;
                }
                h.this.i.b();
                return;
            }
            catch (Exception exception) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("run (");
                stringBuilder.append(this.a);
                stringBuilder.append(")");
                com.chartboost.sdk.Tracking.a.a(a.class, (String)stringBuilder.toString(), (Exception)exception);
            }
        }
    }

}

