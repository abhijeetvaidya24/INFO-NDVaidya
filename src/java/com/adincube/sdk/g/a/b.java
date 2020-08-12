/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.util.concurrent.Semaphore
 */
package com.adincube.sdk.g.a;

import android.content.Context;
import android.os.Build;
import com.adincube.sdk.g.a.a;
import com.adincube.sdk.g.a.c;
import com.adincube.sdk.g.a.d;
import com.adincube.sdk.util.o;
import java.util.concurrent.Semaphore;

public final class b {
    private static b c;
    public com.adincube.sdk.h.a a = null;
    public Semaphore b = new Semaphore(0);

    public static b a() {
        Class<b> class_ = b.class;
        synchronized (b.class) {
            if (c == null) {
                c = new b();
            }
            b b2 = c;
            // ** MonitorExit[var2] (shouldn't be in output)
            return b2;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final void a(Context context) {
        b b2 = this;
        synchronized (b2) {
            boolean bl;
            Context context2;
            block8 : {
                com.adincube.sdk.h.a a2;
                block7 : {
                    block6 : {
                        context2 = context.getApplicationContext();
                        com.adincube.sdk.h.a a3 = this.a;
                        if (a3 == null) break block6;
                        return;
                    }
                    a2 = com.adincube.sdk.util.e.a.c(context2);
                    if (a2.a()) break block7;
                    bl = false;
                    break block8;
                }
                this.a(context2, a2);
                return;
            }
            if (bl) return;
            new Thread(new Runnable(){

                public final void run() {
                    try {
                        a a2 = "amazon".equalsIgnoreCase(Build.MANUFACTURER) ? new c() : new d();
                        com.adincube.sdk.h.a a3 = a2.a(context2);
                        o.a("AdvertisingInfoManager.notifyAdvertiserInfoFetched", new Runnable(context2, a3){
                            final /* synthetic */ Context a;
                            final /* synthetic */ com.adincube.sdk.h.a b;
                            {
                                this.a = context;
                                this.b = a2;
                            }

                            public final void run() {
                                b.this.a(this.a, this.b);
                            }
                        });
                        return;
                    }
                    catch (Throwable throwable) {
                        com.adincube.sdk.util.a.c("AdvertisingInfoManager.extractAdvertisingInfoFromEnv", new Object[]{throwable});
                        return;
                    }
                }
            }).start();
            return;
        }
    }

    final void a(Context context, com.adincube.sdk.h.a a2) {
        b b2 = this;
        synchronized (b2) {
            Object[] arrobject = new Object[]{a2.a, a2.b};
            this.a = a2;
            if (a2.a()) {
                com.adincube.sdk.util.e.a.a(context, a2);
            }
            this.b.release();
            return;
        }
    }

    public final com.adincube.sdk.h.a b() {
        b b2 = this;
        synchronized (b2) {
            com.adincube.sdk.h.a a2 = this.a;
            return a2;
        }
    }

}

