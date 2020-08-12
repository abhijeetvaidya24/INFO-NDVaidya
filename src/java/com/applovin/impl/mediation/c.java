/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.applovin.impl.mediation.a.c
 *  com.applovin.impl.sdk.e.c
 *  com.applovin.impl.sdk.j
 *  com.applovin.impl.sdk.p
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.applovin.impl.mediation;

import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.p;

public class c {
    private final j a;
    private final p b;
    private final a c;
    private com.applovin.impl.sdk.e.c d;

    c(j j2, a a2) {
        this.a = j2;
        this.b = j2.u();
        this.c = a2;
    }

    public void a() {
        this.b.a("AdHiddenCallbackTimeoutManager", "Cancelling timeout");
        com.applovin.impl.sdk.e.c c2 = this.d;
        if (c2 != null) {
            c2.a();
            this.d = null;
        }
    }

    public void a(final com.applovin.impl.mediation.a.c c2, long l2) {
        p p2 = this.b;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Scheduling in ");
        stringBuilder.append(l2);
        stringBuilder.append("ms...");
        p2.a("AdHiddenCallbackTimeoutManager", stringBuilder.toString());
        this.d = com.applovin.impl.sdk.e.c.a((long)l2, (j)this.a, (Runnable)new Runnable(){

            public void run() {
                c.this.b.a("AdHiddenCallbackTimeoutManager", "Timing out...");
                c.this.c.c(c2);
            }
        });
    }

    public static interface a {
        public void c(com.applovin.impl.mediation.a.c var1);
    }

}

