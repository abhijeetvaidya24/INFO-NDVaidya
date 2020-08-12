/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.System
 */
package com.moat.analytics.mobile.tjy;

import com.moat.analytics.mobile.tjy.aq;
import com.moat.analytics.mobile.tjy.ay;

class az
implements aq {
    final /* synthetic */ ay a;
    private long b = System.currentTimeMillis();

    az(ay ay2) {
        this.a = ay2;
    }

    @Override
    public void a() {
        ay.a(this.a);
    }

    @Override
    public void b() {
    }

    @Override
    public boolean c() {
        return ay.b(this.a);
    }

    @Override
    public long d() {
        return this.b;
    }
}

