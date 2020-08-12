/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.moat.analytics.mobile.tjy;

import com.moat.analytics.mobile.tjy.ReactiveVideoTracker;
import com.moat.analytics.mobile.tjy.a;
import com.moat.analytics.mobile.tjy.ac;
import com.moat.analytics.mobile.tjy.ap;
import com.moat.analytics.mobile.tjy.ay;
import com.moat.analytics.mobile.tjy.be;
import com.moat.analytics.mobile.tjy.bf;
import com.moat.analytics.mobile.tjy.bg;

public class ReactiveVideoTrackerPlugin
implements ac {
    private final String a;

    public ReactiveVideoTrackerPlugin(String string) {
        this.a = string;
    }

    static /* synthetic */ String a(ReactiveVideoTrackerPlugin reactiveVideoTrackerPlugin) {
        return reactiveVideoTrackerPlugin.a;
    }

    @Override
    public /* synthetic */ Object a() {
        return this.b();
    }

    @Override
    public /* synthetic */ Object a(a a2, ap ap2) {
        return this.b(a2, ap2);
    }

    public ReactiveVideoTracker b() {
        return new bg();
    }

    public ReactiveVideoTracker b(a a2, ap ap2) {
        return (ReactiveVideoTracker)ay.a(ap2, new bf(this, a2, ap2), new be());
    }
}

