/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.tapjoy.internal;

import com.tapjoy.internal.et;
import com.tapjoy.internal.fi;

public final class ez {
    public et a;
    public volatile fi.a b;
    public int c;
    public volatile fi.a d;
    public volatile fi.a e;

    public final void a() {
        this.a(16);
        fi.a a2 = this.d;
        if (a2 != null) {
            this.d = null;
            a2.b().c();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void a(int n2) {
        ez ez2 = this;
        synchronized (ez2) {
            fi.a a2 = this.b;
            if (a2 != null && this.c < n2) {
                this.c = n2 | this.c;
                a2.a("state", (Object)this.c).b().c();
            }
            return;
        }
    }
}

