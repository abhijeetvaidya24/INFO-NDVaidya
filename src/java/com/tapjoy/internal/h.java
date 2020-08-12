/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.tapjoy.internal.bs
 *  java.lang.Object
 *  java.lang.String
 */
package com.tapjoy.internal;

import com.tapjoy.internal.bs;

public final class h {
    public String a;
    public String b;
    public String c;
    public long d;
    public int e;
    public String f;
    public String g;

    public h(String string2) {
        bs bs2 = bs.b((String)string2);
        bs2.h();
        while (bs2.j()) {
            String string3 = bs2.l();
            if ("orderId".equals((Object)string3)) {
                this.a = bs2.m();
                continue;
            }
            if ("packageName".equals((Object)string3)) {
                this.b = bs2.m();
                continue;
            }
            if ("productId".equals((Object)string3)) {
                this.c = bs2.m();
                continue;
            }
            if ("purchaseTime".equals((Object)string3)) {
                this.d = bs2.q();
                continue;
            }
            if ("purchaseState".equals((Object)string3)) {
                this.e = bs2.r();
                continue;
            }
            if ("developerPayload".equals((Object)string3)) {
                this.f = bs2.m();
                continue;
            }
            if ("purchaseToken".equals((Object)string3)) {
                this.g = bs2.m();
                continue;
            }
            bs2.s();
        }
        bs2.i();
    }
}

