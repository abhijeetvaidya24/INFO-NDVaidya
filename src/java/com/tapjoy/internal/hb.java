/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.String
 */
package com.tapjoy.internal;

import com.tapjoy.internal.bn;
import com.tapjoy.internal.ft;
import com.tapjoy.internal.gr;
import com.tapjoy.internal.hb;

final class hb
extends gr
implements ft {
    public static final bn a = new bn(){

        public final /* synthetic */ java.lang.Object a(com.tapjoy.internal.bs bs2) {
            bs2.h();
            String string = null;
            String string2 = null;
            String string3 = null;
            int n2 = 1;
            while (bs2.j()) {
                String string4 = bs2.l();
                if ("id".equals((java.lang.Object)string4)) {
                    string = bs2.m();
                    continue;
                }
                if ("name".equals((java.lang.Object)string4)) {
                    string2 = bs2.m();
                    continue;
                }
                if ("quantity".equals((java.lang.Object)string4)) {
                    n2 = bs2.r();
                    continue;
                }
                if ("token".equals((java.lang.Object)string4)) {
                    string3 = bs2.m();
                    continue;
                }
                bs2.s();
            }
            bs2.i();
            return new hb(string, string2, n2, string3);
        }
    };
    private final String b;
    private final String c;
    private final int d;
    private final String e;

    hb(String string, String string2, int n2, String string3) {
        this.b = string;
        this.c = string2;
        this.d = n2;
        this.e = string3;
    }

    @Override
    public final String a() {
        return this.b;
    }

    @Override
    public final String b() {
        return this.c;
    }

    @Override
    public final int c() {
        return this.d;
    }

    @Override
    public final String d() {
        return this.e;
    }
}

