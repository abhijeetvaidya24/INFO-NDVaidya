/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.moat.analytics.mobile.tjy;

import com.moat.analytics.mobile.tjy.ReactiveVideoTrackerPlugin;
import com.moat.analytics.mobile.tjy.ap;
import com.moat.analytics.mobile.tjy.ba;
import com.moat.analytics.mobile.tjy.base.functional.a;
import com.moat.analytics.mobile.tjy.bd;

class bf
implements ba {
    final /* synthetic */ com.moat.analytics.mobile.tjy.a a;
    final /* synthetic */ ap b;
    final /* synthetic */ ReactiveVideoTrackerPlugin c;

    bf(ReactiveVideoTrackerPlugin reactiveVideoTrackerPlugin, com.moat.analytics.mobile.tjy.a a2, ap ap2) {
        this.c = reactiveVideoTrackerPlugin;
        this.a = a2;
        this.b = ap2;
    }

    @Override
    public a a() {
        return a.a(new bd(ReactiveVideoTrackerPlugin.a(this.c), this.a, this.b));
    }
}

