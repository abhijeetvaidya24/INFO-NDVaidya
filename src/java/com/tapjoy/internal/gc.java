/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.SharedPreferences
 *  android.opengl.GLSurfaceView
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.SystemClock
 *  android.util.Base64
 *  com.tapjoy.internal.bm
 *  com.tapjoy.internal.cj
 *  com.tapjoy.internal.dy
 *  com.tapjoy.internal.dy$a
 *  com.tapjoy.internal.eb
 *  com.tapjoy.internal.ed
 *  com.tapjoy.internal.ee
 *  com.tapjoy.internal.ef
 *  com.tapjoy.internal.ej
 *  com.tapjoy.internal.ek
 *  com.tapjoy.internal.ek$a
 *  com.tapjoy.internal.fk
 *  com.tapjoy.internal.gc$1
 *  com.tapjoy.internal.gd
 *  com.tapjoy.internal.ge
 *  com.tapjoy.internal.gk
 *  com.tapjoy.internal.ho
 *  com.tapjoy.internal.m
 *  com.tapjoy.internal.q
 *  java.io.File
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.net.MalformedURLException
 *  java.net.URL
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.HashSet
 *  java.util.LinkedHashMap
 *  java.util.List
 *  java.util.Locale
 *  java.util.Map
 *  java.util.Set
 *  java.util.concurrent.ExecutorService
 *  java.util.concurrent.Executors
 *  java.util.concurrent.ScheduledFuture
 *  java.util.concurrent.atomic.AtomicBoolean
 */
package com.tapjoy.internal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Base64;
import com.tapjoy.internal.bm;
import com.tapjoy.internal.cf;
import com.tapjoy.internal.ci;
import com.tapjoy.internal.cj;
import com.tapjoy.internal.ck;
import com.tapjoy.internal.ct;
import com.tapjoy.internal.dn;
import com.tapjoy.internal.dy;
import com.tapjoy.internal.eb;
import com.tapjoy.internal.ed;
import com.tapjoy.internal.ee;
import com.tapjoy.internal.ef;
import com.tapjoy.internal.ej;
import com.tapjoy.internal.ek;
import com.tapjoy.internal.ev;
import com.tapjoy.internal.f;
import com.tapjoy.internal.fd;
import com.tapjoy.internal.fi;
import com.tapjoy.internal.fk;
import com.tapjoy.internal.fu;
import com.tapjoy.internal.fz;
import com.tapjoy.internal.ga;
import com.tapjoy.internal.gb;
import com.tapjoy.internal.gc;
import com.tapjoy.internal.gd;
import com.tapjoy.internal.ge;
import com.tapjoy.internal.gf;
import com.tapjoy.internal.gg;
import com.tapjoy.internal.gk;
import com.tapjoy.internal.gl;
import com.tapjoy.internal.gm;
import com.tapjoy.internal.gp;
import com.tapjoy.internal.gw;
import com.tapjoy.internal.ho;
import com.tapjoy.internal.m;
import com.tapjoy.internal.q;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicBoolean;

public final class gc {
    private static final gc q;
    private static gc r;
    private static Handler w;
    private static File x;
    public final gk a = new gk(this);
    public gl b;
    public boolean c = false;
    public String d = null;
    public Context e;
    public gf f;
    public gb g;
    public gp h;
    public ga i;
    public String j;
    public boolean k;
    public String l;
    public String m;
    public boolean n = false;
    public String o;
    public gd p = gd.a(null);
    private boolean s = false;
    private boolean t = false;
    private String u;
    private String v;

    static {
        gc gc2;
        q = gc2 = new gc();
        r = gc2;
    }

    private gc() {
    }

    static /* synthetic */ Context a(gc gc2) {
        return gc2.e;
    }

    public static gc a() {
        return r;
    }

    public static gc a(Context context) {
        gc gc2 = r;
        gc2.b(context);
        return gc2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public static String a(Context context, Intent intent) {
        gf gf2;
        String string2 = f.a(intent);
        if (string2 == null) return string2;
        gc gc2 = r;
        gc2.b(context);
        if (!ct.c(gc2.f.c())) {
            if (!intent.getBooleanExtra("fiverocks:force", false)) return string2;
        }
        gf gf3 = gf2 = gc2.f;
        // MONITORENTER : gf3
        gf2.c.d.a(string2);
        gf2.b.d = string2;
        // MONITOREXIT : gf3
        if (string2.length() <= 0) return string2;
        gb gb2 = gc2.g;
        gb2.a(gb2.a(eb.APP, "referrer"));
        return string2;
    }

    public static void a(GLSurfaceView gLSurfaceView) {
        if (!fz.a((Object)gLSurfaceView, "setGLSurfaceView: The given GLSurfaceView was null")) {
            return;
        }
        fu.a(gLSurfaceView);
    }

    public static void a(Runnable runnable) {
        Class<gc> class_ = gc.class;
        synchronized (gc.class) {
            if (w == null) {
                w = new Handler(Looper.getMainLooper());
            }
            w.post(runnable);
            // ** MonitorExit[var3_1] (shouldn't be in output)
            return;
        }
    }

    public static File c(Context context) {
        Class<gc> class_ = gc.class;
        synchronized (gc.class) {
            if (x == null) {
                x = context.getDir("fiverocks", 0);
            }
            File file = x;
            // ** MonitorExit[var3_1] (shouldn't be in output)
            return file;
        }
    }

    static File d(Context context) {
        return new File(gc.c(context), "install");
    }

    public final ee a(boolean bl2) {
        if (bl2) {
            this.f.a();
        }
        return this.f.b();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void a(Context context, String string2, String string3, String string4, String string5, String string6) {
        gc gc2 = this;
        synchronized (gc2) {
            int n2;
            gg gg2;
            block17 : {
                block16 : {
                    URL uRL;
                    boolean bl2 = this.k;
                    if (bl2) {
                        return;
                    }
                    this.b(context);
                    Context context2 = this.e;
                    n2 = 1;
                    boolean bl3 = context2 != null;
                    boolean bl4 = fz.a(bl3, "The given context was null");
                    if (!bl4) {
                        return;
                    }
                    if (string5 == null || string5.length() != 24 || !string5.matches("[0-9a-f]{24}")) {
                        Object[] arrobject = new Object[n2];
                        arrobject[0] = string5;
                        fz.b("Invalid App ID: {}", arrobject);
                        return;
                    }
                    boolean bl5 = true;
                    if (!bl5) {
                        return;
                    }
                    if (string6 == null || string6.length() != 20 || !string6.matches("[0-9A-Za-z\\-_]{20}")) {
                        Object[] arrobject = new Object[n2];
                        arrobject[0] = string6;
                        fz.b("Invalid App Key: {}", arrobject);
                        return;
                    }
                    boolean bl6 = true;
                    if (!bl6) {
                        return;
                    }
                    this.l = string2;
                    this.m = string3;
                    this.u = string5;
                    this.v = string6;
                    try {
                        uRL = new URL(string4);
                    }
                    catch (MalformedURLException malformedURLException) {
                        throw new IllegalArgumentException((Throwable)malformedURLException);
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("TapjoySDK");
                    stringBuilder.append(" ");
                    stringBuilder.append(string3);
                    stringBuilder.append(" (");
                    stringBuilder.append(Build.MODEL);
                    stringBuilder.append("; Android ");
                    stringBuilder.append(Build.VERSION.RELEASE);
                    stringBuilder.append("; ");
                    stringBuilder.append((Object)Locale.getDefault());
                    stringBuilder.append(")");
                    cj cj2 = new cj(stringBuilder.toString(), uRL);
                    cf.b = cj2;
                    cf.a = Executors.newCachedThreadPool();
                    ga ga2 = this.i;
                    ga2.b = cj2;
                    ga2.a();
                    new Object[n2][0] = string4;
                    this.k = n2;
                    gg2 = new gg(gc.d(this.e));
                    if (gg2.b() == null) break block16;
                    break block17;
                }
                n2 = 0;
            }
            if (n2 == 0 && gg2.a()) {
                gb gb2 = this.g;
                gb2.a(gb2.a(eb.APP, "install"));
            }
            gf gf2 = this.f;
            if (!ct.c(string5) && !string5.equals((Object)gf2.c.D.a())) {
                gf2.c.D.a(string5);
                gf2.c.a(false);
            }
            this.b();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void a(String string2) {
        gc gc2 = this;
        synchronized (gc2) {
            if (this.k) {
                if (string2 == null && this.o != null) {
                    string2 = this.o;
                }
                this.o = null;
                if (string2 != null) {
                    ee ee2 = this.f.b();
                    Object[] arrobject = new Object[]{ee2.d.h, this.d, string2};
                    fz.a("GCM registration id of device {} updated for sender {}: {}", arrobject);
                    new ho(ee2, string2).a((ck)new 1(this, string2), cf.a);
                    return;
                }
            } else if (string2 != null) {
                this.o = string2;
            }
            return;
        }
    }

    final void a(Map map) {
        gb gb2 = this.g;
        dy.a a2 = gb2.a(eb.CAMPAIGN, "impression");
        if (map != null) {
            a2.r = bm.a((Object)map);
        }
        gb2.a(a2);
    }

    final void a(Map map, long l2) {
        gb gb2 = this.g;
        dy.a a2 = gb2.a(eb.CAMPAIGN, "view");
        a2.i = l2;
        if (map != null) {
            a2.r = bm.a((Object)map);
        }
        gb2.a(a2);
    }

    final void a(Map map, String string2) {
        gb gb2 = this.g;
        dy.a a2 = gb2.a(eb.CAMPAIGN, "click");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.put((Object)"region", (Object)string2);
        a2.r = bm.a((Object)linkedHashMap);
        gb2.a(a2);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public final void a(Set var1_1) {
        if (!this.c("setUserTags")) {
            return;
        }
        if (var1_1 != null && !var1_1.isEmpty()) {
            var6_2 = new HashSet();
            for (String var8_4 : var1_1) {
                if (var8_4 == null || (var9_5 = var8_4.trim()).isEmpty() || var9_5.length() > 200) continue;
                var6_2.add((Object)var9_5);
                if (var6_2.size() < 200) continue;
            }
            var1_1 = var6_2;
        }
        var11_7 = var2_6 = this.f;
        // MONITORENTER : var11_7
        if (var1_1 == null) ** GOTO lbl20
        if (!var1_1.isEmpty()) {
            var4_8 = Base64.encodeToString((byte[])ej.c.b((Object)new ej((List)new ArrayList((Collection)var1_1))), (int)2);
            var2_6.c.z.a(var4_8);
            var2_6.b.A.clear();
            var2_6.b.A.addAll((Collection)var1_1);
            return;
        }
lbl20: // 3 sources:
        var2_6.c.z.c();
        var2_6.b.A.clear();
        // MONITOREXIT : var11_7
        return;
    }

    public final void b() {
        gc gc2 = this;
        synchronized (gc2) {
            if (this.k) {
                ge.b((Context)this.e).e(this.d);
                this.a((String)null);
            }
            return;
        }
    }

    final void b(Context context) {
        gc gc2 = this;
        synchronized (gc2) {
            if (this.e == null) {
                Context context2;
                this.e = context2 = context.getApplicationContext();
                fd.a().a(context2);
                this.f = gf.a(context2);
                File file = new File(gc.c(context2), "events2");
                if (this.i == null) {
                    this.i = new ga(file);
                }
                this.g = new gb(this.f, this.i);
                this.h = new gp(this.g);
                this.b = new gl(context2);
                fi.a(new fk(new File(gc.c(context2), "usages"), this.g));
                gw gw2 = gw.a;
                gw2.b = context2.getApplicationContext();
                gw2.c = context2.getSharedPreferences("tapjoyCacheDataMMF2E", 0);
                gw2.d = context2.getSharedPreferences("tapjoyCacheDataMMF2U", 0);
                gw2.a();
            }
            return;
        }
    }

    public final boolean b(String string2) {
        if (!this.k && this.j == null || this.e == null) {
            if (fz.a) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string2);
                stringBuilder.append(": Should be called after initializing the SDK");
                fz.b(stringBuilder.toString());
            }
            return false;
        }
        return true;
    }

    public final Set c() {
        if (!this.c("getUserTags")) {
            return new HashSet();
        }
        return this.f.e();
    }

    public final boolean c(String string2) {
        if (this.e == null) {
            if (fz.a) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string2);
                stringBuilder.append(": Should be called after initializing the SDK");
                fz.b(stringBuilder.toString());
            }
            return false;
        }
        return true;
    }

    public final boolean d() {
        gp gp2 = this.h;
        return gp2 != null && gp2.b.get();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final boolean e() {
        gk gk2;
        gf gf2;
        gp gp2 = this.h;
        if (gp2.c != null) {
            gp2.c.cancel(false);
            gp2.c = null;
        }
        if (!gp2.b.compareAndSet(false, true)) return false;
        fz.a("New session started");
        gb gb2 = gp2.a;
        ef ef2 = gb2.a.d();
        gf gf3 = gf2 = gb2.a;
        synchronized (gf3) {
            int n2 = 1 + gf2.c.h.b();
            gf2.c.h.a(n2);
            gf2.b.h = n2;
        }
        dy.a a2 = gb2.a(eb.APP, "bootup");
        gb2.c = SystemClock.elapsedRealtime();
        if (ef2 != null) {
            a2.s = ef2;
        }
        gb2.a(a2);
        ev.c.notifyObservers();
        boolean bl2 = true;
        if (!bl2) return false;
        gk gk3 = gk2 = this.a;
        synchronized (gk3) {
            gk2.b = null;
        }
        gw.a.a();
        return true;
    }
}

