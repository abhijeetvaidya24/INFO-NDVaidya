/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
package com.moat.analytics.mobile.tjy;

import com.moat.analytics.mobile.tjy.base.exception.a;
import com.moat.analytics.mobile.tjy.f;

class g
implements Runnable {
    final /* synthetic */ f a;

    g(f f2) {
        this.a = f2;
    }

    public void run() {
        try {
            this.a.a("Shutting down.");
            f.a(this.a).b();
            f.a(this.a, null);
            return;
        }
        catch (Exception exception) {
            a.a(exception);
            return;
        }
    }
}

