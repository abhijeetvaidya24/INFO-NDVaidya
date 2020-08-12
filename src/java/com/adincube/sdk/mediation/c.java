/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 */
package com.adincube.sdk.mediation;

public final class c {
    public Runnable a;
    public boolean b;

    public c(Runnable runnable) {
        this.a = runnable;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void a() {
        if (!this.b) {
            return;
        }
        c c2 = this;
        synchronized (c2) {
            if (this.b) {
                this.a.run();
            }
            return;
        }
    }
}

