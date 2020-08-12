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

public final class g {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public long g;

    public g(String string2) {
        bs bs2 = bs.b((String)string2);
        bs2.h();
        while (bs2.j()) {
            String string3 = bs2.l();
            if ("productId".equals((Object)string3)) {
                this.a = bs2.m();
                continue;
            }
            if ("type".equals((Object)string3)) {
                this.b = bs2.m();
                continue;
            }
            if ("price".equals((Object)string3)) {
                this.c = bs2.m();
                continue;
            }
            if ("title".equals((Object)string3)) {
                this.d = bs2.m();
                continue;
            }
            if ("description".equals((Object)string3)) {
                this.e = bs2.m();
                continue;
            }
            if ("price_currency_code".equals((Object)string3)) {
                this.f = bs2.m();
                continue;
            }
            if ("price_amount_micros".equals((Object)string3)) {
                this.g = bs2.q();
                continue;
            }
            bs2.s();
        }
        bs2.i();
    }
}

