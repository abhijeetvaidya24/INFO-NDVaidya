/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.adincube.sdk.d.a.j
 *  com.adincube.sdk.d.a.k
 *  com.adincube.sdk.d.a.n
 *  java.lang.Class
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.Set
 */
package com.adincube.sdk.g;

import android.content.Context;
import com.adincube.sdk.d.a.j;
import com.adincube.sdk.d.a.k;
import com.adincube.sdk.d.a.n;
import com.adincube.sdk.g.b.e.a.b;
import com.adincube.sdk.util.b.f;
import com.adincube.sdk.util.b.g;
import com.adincube.sdk.util.d;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class a {
    private static com.adincube.sdk.h.b.b c;
    private static a d;
    public com.adincube.sdk.g.b.e.a.a a = new b("cfg");
    public Set<a> b = new HashSet();

    private a() {
    }

    public static a a() {
        Class<a> class_ = a.class;
        synchronized (a.class) {
            if (d == null) {
                d = new a();
            }
            a a2 = d;
            // ** MonitorExit[var2] (shouldn't be in output)
            return a2;
        }
    }

    public static void a(Context context, boolean bl) {
        if (f.a(context, "android.permission.INTERNET")) {
            if (d.b() != null) {
                if (bl) {
                    boolean bl2 = f.a(context, "android.permission.ACCESS_NETWORK_STATE");
                    boolean bl3 = true;
                    if (bl2 && g.a(context) == null) {
                        bl3 = false;
                    }
                    if (bl3) {
                        return;
                    }
                    throw new n();
                }
                return;
            }
            throw new j();
        }
        throw new k();
    }

    public final com.adincube.sdk.h.b.b a(boolean bl, boolean bl2) {
        a a2 = this;
        synchronized (a2) {
            block11 : {
                block10 : {
                    block9 : {
                        com.adincube.sdk.h.b.b b2;
                        block8 : {
                            Context context = com.adincube.sdk.util.f.a();
                            if (context != null) break block8;
                            return null;
                        }
                        if (c == null) {
                            c = this.a.a();
                        }
                        if ((b2 = c) != null) break block9;
                        return null;
                    }
                    boolean bl3 = a.c.b;
                    if (!bl3 || bl) break block10;
                    return null;
                }
                boolean bl4 = a.c.c;
                if (!bl4 || bl2) break block11;
                return null;
            }
            com.adincube.sdk.h.b.b b3 = c;
            return b3;
        }
    }

    public final Long a(boolean bl) {
        com.adincube.sdk.h.b.b b2 = this.a(bl, false);
        if (b2 == null) {
            return null;
        }
        return b2.a;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public final void a(com.adincube.sdk.h.b.b var1_1) {
        var6_2 = this;
        // MONITORENTER : var6_2
        if (a.c != null && a.c.a >= var1_1.a) ** GOTO lbl15
        a.c = var1_1;
        var7_4 = var3_3 = this.b;
        // MONITORENTER : var7_4
        var5_5 = this.b.iterator();
        while (var5_5.hasNext()) {
            ((a)var5_5.next()).a(var1_1);
        }
        // MONITOREXIT : var7_4
        this.a.a(var1_1);
lbl15: // 2 sources:
        // MONITOREXIT : var6_2
        return;
    }

    public final void b() {
        if (this.a(true, true) != null) {
            c = null;
            this.a.b();
        }
    }

    public static interface a {
        public void a(com.adincube.sdk.h.b.b var1);
    }

}

