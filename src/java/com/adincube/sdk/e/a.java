/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Looper
 *  com.adincube.sdk.d.a.a
 *  com.adincube.sdk.d.a.h
 *  com.adincube.sdk.d.a.p
 *  com.adincube.sdk.g.b.b.c
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.Set
 *  java.util.concurrent.Callable
 */
package com.adincube.sdk.e;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import com.adincube.sdk.AdinCubeInterstitialEventListener;
import com.adincube.sdk.d.a.p;
import com.adincube.sdk.e.a;
import com.adincube.sdk.g.b.b.a;
import com.adincube.sdk.g.b.b.b;
import com.adincube.sdk.g.b.b.c;
import com.adincube.sdk.g.b.c.m;
import com.adincube.sdk.g.b.e;
import com.adincube.sdk.g.b.f;
import com.adincube.sdk.g.b.g;
import com.adincube.sdk.g.b.h;
import com.adincube.sdk.g.b.j;
import com.adincube.sdk.g.b.k;
import com.adincube.sdk.g.g.d;
import com.adincube.sdk.util.ErrorReportingHelper;
import com.adincube.sdk.util.a;
import com.adincube.sdk.util.o;
import java.util.Set;
import java.util.concurrent.Callable;

public class a {
    private static a a;
    private com.adincube.sdk.g.a b = com.adincube.sdk.g.a.a();
    private d c = d.a();
    private com.adincube.sdk.g.a.b d = com.adincube.sdk.g.a.b.a();
    private b e = b.b();
    private c f = null;
    private long g = 0L;
    private com.adincube.sdk.g.b.b.a h = null;
    private a.a i = new a.a(this){
        final /* synthetic */ a a;
        {
            this.a = a2;
        }

        public final void a() {
            a.a(this.a);
        }
    };

    private a() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static a a() {
        if (a != null) return a;
        Class<a> class_ = a.class;
        synchronized (a.class) {
            if (a != null) return a;
            a = new a();
            // ** MonitorExit[var1] (shouldn't be in output)
            return a;
        }
    }

    static /* synthetic */ com.adincube.sdk.g.b.b.a a(a a2) {
        a2.h = null;
        return null;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static void a(com.adincube.sdk.d.a.c c2, a.a a2, boolean bl) {
        try {
            c2.a(a2);
            if (!bl) return;
        }
        catch (Throwable throwable) {
            com.adincube.sdk.util.a.c("AdinCubeInterstitial.displayError", new Object[]{throwable});
            ErrorReportingHelper.report("AdinCubeInterstitial.displayError", throwable);
            return;
        }
        b.b().a(c2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private c d() {
        if (this.f != null) return this.f;
        a a2 = this;
        synchronized (a2) {
            c c2;
            if (this.f != null) return this.f;
            com.adincube.sdk.util.e.b b2 = com.adincube.sdk.util.e.b.a();
            h h2 = h.a();
            com.adincube.sdk.g.b.e.b.a a3 = new com.adincube.sdk.g.b.e.b.a(com.adincube.sdk.h.c.b.a);
            e e2 = new e(com.adincube.sdk.h.c.b.a, this.b);
            m m2 = m.a();
            f f2 = f.a(com.adincube.sdk.h.c.b.a);
            g g2 = g.a();
            d d2 = d.a();
            k k2 = k.a();
            com.adincube.sdk.g.b.c c3 = new com.adincube.sdk.g.b.c(com.adincube.sdk.h.c.b.a, this.b, e2, g2, h2, d2);
            this.f = c2 = new c(this.b, b2, (com.adincube.sdk.g.b.d)this.e, h2, (com.adincube.sdk.g.b.e.b.b)a3, (j)c3, m2, f2, g2, d2, k2);
            return this.f;
        }
    }

    public final void a(final Activity activity) {
        p p2;
        block8 : {
            com.adincube.sdk.util.f.a((Context)activity);
            if (!Looper.getMainLooper().equals((Object)Looper.myLooper())) {
                o.a(new Runnable(){

                    public final void run() {
                        a.this.a(activity);
                    }
                });
                return;
            }
            com.adincube.sdk.util.a.a("AdinCube.Interstitial.init()", new Object[0]);
            com.adincube.sdk.util.b.a.a();
            if (activity == null) break block8;
            this.d.a((Context)activity);
            com.adincube.sdk.util.e.a.a((Context)activity);
            com.adincube.sdk.util.k.a((Context)activity);
            com.adincube.sdk.g.a.a((Context)activity, false);
            if (com.adincube.sdk.util.e.a.a()) {
                com.adincube.sdk.util.a.a("Configuration changed.", new Object[0]);
                com.adincube.sdk.util.e.b.a().b();
                com.adincube.sdk.g.a.a().b();
                com.adincube.sdk.util.d.a();
                com.adincube.sdk.util.e.a.b();
            }
            this.d().c();
            this.g = System.currentTimeMillis();
            p2 = null;
        }
        try {
            throw new com.adincube.sdk.d.a.a("init()");
        }
        catch (Throwable throwable) {
            ErrorReportingHelper.report("AdinCubeInterstitial.init", throwable);
            p2 = new p(throwable);
        }
        catch (com.adincube.sdk.d.a.c c2) {
            // empty catch block
        }
        if (p2 != null) {
            a.a((com.adincube.sdk.d.a.c)p2, a.a.d, false);
        }
    }

    public final boolean b(final Activity activity) {
        boolean bl;
        p p2;
        block8 : {
            block7 : {
                bl = true;
                com.adincube.sdk.util.f.a((Context)activity);
                if (!Looper.getMainLooper().equals((Object)Looper.myLooper())) {
                    return o.a(new Callable<Boolean>(){

                        public final /* synthetic */ Object call() {
                            return a.this.b(activity);
                        }
                    });
                }
                com.adincube.sdk.util.a.a("AdinCube.Interstitial.isReady()", new Object[0]);
                com.adincube.sdk.util.b.a.a();
                if (activity == null) break block7;
                this.d.a((Context)activity);
                com.adincube.sdk.util.k.a((Context)activity);
                com.adincube.sdk.g.a.a((Context)activity, bl);
                this.d().g();
                p2 = null;
                break block8;
            }
            try {
                throw new com.adincube.sdk.d.a.a("isReady()");
            }
            catch (Throwable throwable) {
                ErrorReportingHelper.report("AdinCubeInterstitial.isReady", throwable);
                p2 = new p(throwable);
            }
            catch (com.adincube.sdk.d.a.c c2) {
                // empty catch block
            }
            bl = false;
        }
        if (p2 != null) {
            a.a((com.adincube.sdk.d.a.c)p2, p2.b(), false);
        }
        return bl;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public final void c(final Activity var1_1) {
        block25 : {
            block27 : {
                block26 : {
                    try {
                        com.adincube.sdk.util.f.a((Context)var1_1);
                        if (!Looper.getMainLooper().equals((Object)Looper.myLooper())) {
                            o.a(new Runnable(){

                                public final void run() {
                                    a.this.c(var1_1);
                                }
                            });
                            return;
                        }
                        com.adincube.sdk.util.a.a("AdinCube.Interstitial.show()", new Object[0]);
                        com.adincube.sdk.util.b.a.a();
                        if (var1_1 == null) throw new com.adincube.sdk.d.a.a("show()");
                        if (this.h != null) {
                            com.adincube.sdk.util.a.a("Previous show call has been deferred.", new Object[0]);
                            return;
                        }
                        var17_2 = this.b.a(true, true);
                        var18_3 = System.currentTimeMillis();
                    }
                    catch (Throwable var16_19) {
                        ErrorReportingHelper.report("AdinCubeInterstitial.show", var16_19);
                        var4_14 = new p(var16_19);
                        break block25;
                    }
                    catch (com.adincube.sdk.d.a.c var15_20) {
                        var4_14 = var15_20;
                        break block25;
                    }
                    catch (com.adincube.sdk.d.a.h var2_18) {
                        var3_16 = false;
                        break block26;
                    }
                    var20_4 = com.adincube.sdk.g.b.b.a.b();
                    var22_6 = var20_4 <= var18_3 && var20_4 + (var34_5 = var17_2 != null ? var17_2.x : 1000L) > var18_3;
                    if (var22_6) {
                        com.adincube.sdk.util.a.b("Calling show() after init() will automatically display an ad when one is available.\nPlease remove any call to show() in onAdLoaded callback.", new Object[0]);
                        return;
                    }
                    if (com.adincube.sdk.util.f.c(var1_1)) ** GOTO lbl-1000
                    var27_7 = this.b.a(true, true);
                    var28_8 = System.currentTimeMillis();
                    if (this.g <= var28_8 && (var30_9 = this.g) + (var32_10 = var27_7 != null ? var27_7.y : 3000L) > var28_8) {
                        var23_11 = true;
                    } else lbl-1000: // 2 sources:
                    {
                        var23_11 = false;
                    }
                    try {
                        com.adincube.sdk.g.a.a((Context)var1_1, true);
                        com.adincube.sdk.util.k.a((Context)var1_1);
                        var25_12 = this.d();
                        var26_13 = var23_11 == false;
                    }
                    catch (com.adincube.sdk.d.a.h var24_15) {
                        var3_16 = var23_11;
                        var2_17 = var24_15;
                    }
                }
                if (!var3_16) break block27;
                this.h = new com.adincube.sdk.g.b.b.a(var1_1, this.b, this.e, this.d());
                this.h.b = this.i;
                var7_21 = this.h;
                com.adincube.sdk.util.a.a("SDK is currently caching next interstitial. show() has been deferred until next ad is available.", new Object[0]);
                var7_21.c = System.currentTimeMillis();
                var10_22 = var7_21.a;
                var11_23 = var7_21.d;
                var36_25 = var12_24 = var10_22.b;
                // MONITORENTER : var36_25
                var10_22.b.add((Object)var11_23);
                // MONITOREXIT : var36_25
                try {
                    var7_21.a();
                    var9_26 = null;
                    ** GOTO lbl68
                }
                catch (Throwable var8_27) {
                    try {
                        ErrorReportingHelper.report("DeferredInterstitial.defer", com.adincube.sdk.h.c.b.a, var8_27);
                        var9_26 = new p(var8_27);
lbl68: // 2 sources:
                        if (var9_26 != null) {
                            com.adincube.sdk.g.b.b.a.a((com.adincube.sdk.d.a.c)var9_26);
                        }
                        var6_28 = null;
                    }
                    catch (Throwable var5_29) {
                        ErrorReportingHelper.report("AdinCubeInterstitial.deferShowUntilAdCached", var5_29);
                        var6_28 = new p(var5_29);
                    }
                }
                var4_14 = null;
                if (var6_28 != null) {
                    a.a((com.adincube.sdk.d.a.c)var6_28, a.a.d, true);
                    var4_14 = null;
                }
                break block25;
            }
            var4_14 = var2_17;
            break block25;
            var25_12.a(var26_13, false);
            var4_14 = null;
        }
        if (var4_14 == null) return;
        a.a(var4_14, a.a.d, true);
    }

}

