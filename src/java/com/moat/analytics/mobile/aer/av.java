/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.System
 */
package com.moat.analytics.mobile.aer;

import com.moat.analytics.mobile.aer.am;
import com.moat.analytics.mobile.aer.au;

class av
implements am {
    final /* synthetic */ au a;
    private long b = System.currentTimeMillis();

    av(au au2) {
        this.a = au2;
    }

    @Override
    public void a() {
        au.a(this.a);
    }

    @Override
    public void b() {
    }

    @Override
    public boolean c() {
        return au.b(this.a);
    }

    @Override
    public long d() {
        return this.b;
    }
}

