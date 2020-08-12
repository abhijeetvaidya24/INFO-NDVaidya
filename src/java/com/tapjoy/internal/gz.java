/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.String
 */
package com.tapjoy.internal;

import com.tapjoy.internal.bn;
import com.tapjoy.internal.fs;
import com.tapjoy.internal.gr;
import com.tapjoy.internal.gz;

final class gz
extends gr
implements fs {
    public static final bn a = new bn(){

        public final /* synthetic */ java.lang.Object a(com.tapjoy.internal.bs bs2) {
            String string;
            bs2.h();
            String string2 = string = "";
            while (bs2.j()) {
                String string3 = bs2.l();
                if ("campaign_id".equals((java.lang.Object)string3)) {
                    string = bs2.c("");
                    continue;
                }
                if ("product_id".equals((java.lang.Object)string3)) {
                    string2 = bs2.c("");
                    continue;
                }
                bs2.s();
            }
            bs2.i();
            return new gz(string, string2);
        }
    };
    private final String b;
    private final String c;

    gz(String string, String string2) {
        this.b = string;
        this.c = string2;
    }

    @Override
    public final String a() {
        return this.b;
    }

    @Override
    public final String b() {
        return this.c;
    }
}

