/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  com.adincube.sdk.d.a.p
 *  com.adincube.sdk.g.b.b.c
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.Set
 */
package com.adincube.sdk.g.b.b;

import android.app.Activity;
import android.content.Context;
import com.adincube.sdk.AdinCubeInterstitialEventListener;
import com.adincube.sdk.d.a.p;
import com.adincube.sdk.g.b.b.a;
import com.adincube.sdk.g.b.b.b;
import com.adincube.sdk.g.b.b.c;
import com.adincube.sdk.util.ErrorReportingHelper;
import com.adincube.sdk.util.f;
import com.adincube.sdk.util.o;
import java.util.Set;

public final class a {
    private static long e;
    public b a = null;
    public a b = null;
    public long c = 0L;
    public AdinCubeInterstitialEventListener d = new AdinCubeInterstitialEventListener(this){
        final /* synthetic */ a a;
        {
            this.a = a2;
        }

        public final void onAdCached() {
            a.b(this.a);
        }

        public final void onAdClicked() {
        }

        public final void onAdHidden() {
        }

        public final void onAdShown() {
        }

        public final void onError(java.lang.String string) {
        }
    };
    private Activity f = null;
    private com.adincube.sdk.g.a g = null;
    private c h = null;
    private boolean i = false;

    public a(Activity activity, com.adincube.sdk.g.a a2, b b2, c c2) {
        this.f = activity;
        this.g = a2;
        this.a = b2;
        this.h = c2;
    }

    public static void a(com.adincube.sdk.d.a.c c2) {
        try {
            c2.a();
            b.b().a(c2);
            return;
        }
        catch (Throwable throwable) {
            com.adincube.sdk.util.a.c("DeferredInterstitial.displayError", new Object[]{throwable});
            ErrorReportingHelper.report("DeferredInterstitial.displayError", com.adincube.sdk.h.c.b.a, throwable);
            return;
        }
    }

    public static long b() {
        return e;
    }

    static /* synthetic */ void b(a a2) {
        a2.c();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private void c() {
        p p2;
        block10 : {
            Throwable throwable2222;
            block9 : {
                block8 : {
                    block7 : {
                        boolean bl = this.i;
                        if (!bl) break block7;
                        this.d();
                        return;
                    }
                    if (!f.c(this.f)) break block8;
                    this.d();
                    this.d();
                    return;
                }
                try {
                    f.a((Context)this.f);
                    this.h.a(true, true);
                    e = System.currentTimeMillis();
                }
                catch (com.adincube.sdk.d.a.c c2) {
                    this.d();
                }
                this.d();
                p2 = null;
                break block10;
                {
                    p p3;
                    catch (Throwable throwable2222) {
                        break block9;
                    }
                    catch (Throwable throwable3) {}
                    {
                        ErrorReportingHelper.report("DeferredInterstitial.show", com.adincube.sdk.h.c.b.a, throwable3);
                        p3 = new p(throwable3);
                    }
                    this.d();
                    p2 = p3;
                    break block10;
                }
            }
            this.d();
            throw throwable2222;
        }
        if (p2 == null) return;
        a.a((com.adincube.sdk.d.a.c)p2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private void d() {
        AdinCubeInterstitialEventListener adinCubeInterstitialEventListener;
        b b2;
        try {
            Set<AdinCubeInterstitialEventListener> set;
            this.i = true;
            this.f = null;
            b2 = this.a;
            adinCubeInterstitialEventListener = this.d;
            Set<AdinCubeInterstitialEventListener> set2 = set = b2.b;
            // MONITORENTER : set2
        }
        catch (Throwable throwable) {
            com.adincube.sdk.util.a.c("DeferredInterstitial.finish", new Object[]{throwable});
            ErrorReportingHelper.report("DeferredInterstitial.finish", com.adincube.sdk.h.c.b.a, throwable);
            return;
        }
        b2.b.remove((Object)adinCubeInterstitialEventListener);
        // MONITOREXIT : set2
        if (this.b == null) return;
        this.b.a();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void a() {
        long l2;
        try {
            if (this.i) {
                return;
            }
            if (f.c(this.f)) {
                this.d();
                return;
            }
            com.adincube.sdk.h.b.b b2 = this.g.a(true, true);
            l2 = b2 != null ? b2.z : 8000L;
        }
        catch (Throwable throwable) {
            com.adincube.sdk.util.a.c("DeferredInterstitial.waitUntilShownOrTimeout", new Object[]{throwable});
            ErrorReportingHelper.report("DeferredInterstitial.waitUntilShownOrTimeout", com.adincube.sdk.h.c.b.a, throwable);
            return;
        }
        long l3 = System.currentTimeMillis();
        if (l3 >= this.c && l2 + this.c >= l3) {
            o.a(new Runnable(){

                public final void run() {
                    a.this.a();
                }
            }, 1000L);
            return;
        }
        new Object[1][0] = l3 - this.c;
        this.c();
    }

    public static interface a {
        public void a();
    }

}

