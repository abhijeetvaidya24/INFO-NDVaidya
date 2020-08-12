/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
package com.moat.analytics.mobile.aer;

import com.moat.analytics.mobile.aer.f;

class g
implements Runnable {
    final /* synthetic */ f a;

    g(f f2) {
        this.a = f2;
    }

    public void run() {
        this.a.a("Shutting down.");
        f.a(this.a).b();
        f.a(this.a, null);
    }
}

