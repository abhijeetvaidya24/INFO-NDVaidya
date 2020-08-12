/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.moat.analytics.mobile.tjy.n
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 */
package com.moat.analytics.mobile.tjy;

import com.moat.analytics.mobile.tjy.base.exception.a;
import com.moat.analytics.mobile.tjy.n;
import com.moat.analytics.mobile.tjy.q;

class r
implements Runnable {
    final /* synthetic */ q a;

    r(q q2) {
        this.a = q2;
    }

    public void run() {
        try {
            n.f((n)this.a.a);
            return;
        }
        catch (Exception exception) {
            a.a(exception);
            return;
        }
    }
}

