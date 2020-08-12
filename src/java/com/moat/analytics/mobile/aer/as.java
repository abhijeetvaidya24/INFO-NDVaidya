/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 */
package com.moat.analytics.mobile.aer;

import com.moat.analytics.mobile.aer.an;
import com.moat.analytics.mobile.aer.ar;
import com.moat.analytics.mobile.aer.base.exception.a;

class as
implements Runnable {
    final /* synthetic */ an a;
    final /* synthetic */ ar b;

    as(ar ar2, an an2) {
        this.b = ar2;
        this.a = an2;
    }

    public void run() {
        try {
            ar.a(this.b).a(this.a);
            return;
        }
        catch (Exception exception) {
            a.a(exception);
            return;
        }
    }
}

