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

class o
implements Runnable {
    final /* synthetic */ n a;

    o(n n2) {
        this.a = n2;
    }

    public void run() {
        try {
            n.a((n)this.a);
            return;
        }
        catch (Exception exception) {
            a.a(exception);
            return;
        }
    }
}

