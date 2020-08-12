/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.moat.analytics.mobile.tjy.n
 *  java.lang.Object
 *  java.lang.Runnable
 */
package com.moat.analytics.mobile.tjy;

import com.moat.analytics.mobile.tjy.base.exception.a;
import com.moat.analytics.mobile.tjy.base.exception.b;
import com.moat.analytics.mobile.tjy.n;
import com.moat.analytics.mobile.tjy.s;

class t
implements Runnable {
    final /* synthetic */ s a;

    t(s s2) {
        this.a = s2;
    }

    public void run() {
        try {
            n.g((n)this.a.a);
            return;
        }
        catch (b b2) {
            a.a(b2);
            return;
        }
    }
}

