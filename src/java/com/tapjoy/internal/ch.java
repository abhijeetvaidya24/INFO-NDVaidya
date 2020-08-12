/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.Throwable
 */
package com.tapjoy.internal;

import com.tapjoy.internal.cf;
import com.tapjoy.internal.ck;
import com.tapjoy.internal.cl;

public final class ch
implements Runnable {
    private final cf a;
    private final ck b;

    protected ch(cf cf2, ck ck2) {
        this.a = cf2;
        this.b = ck2;
    }

    public final void run() {
        Object object;
        ck ck2;
        try {
            object = this.a.f();
            ck2 = this.b;
        }
        catch (Throwable throwable) {
            ck ck3 = this.b;
            if (ck3 != null && !(ck3 instanceof cl)) {
                ck3.a(this.a);
            }
            return;
        }
        if (ck2 != null && !(ck2 instanceof cl)) {
            ck2.a(this.a, object);
        }
    }
}

