/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  com.moat.analytics.mobile.aer.i
 *  java.lang.Boolean
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.ref.WeakReference
 */
package com.moat.analytics.mobile.aer;

import android.os.Handler;
import com.moat.analytics.mobile.aer.base.exception.a;
import com.moat.analytics.mobile.aer.i;
import java.lang.ref.WeakReference;

class j
implements Runnable {
    final /* synthetic */ i a;

    j(i i2) {
        this.a = i2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        try {
            i i2;
            if (this.a.f.get() != null && !this.a.e()) {
                if (Boolean.valueOf((boolean)this.a.i()).booleanValue()) {
                    this.a.d.postDelayed((Runnable)this, 200L);
                    return;
                }
                i2 = this.a;
            } else {
                i2 = this.a;
            }
            i2.c();
            return;
        }
        catch (Exception exception) {
            this.a.c();
            a.a(exception);
            return;
        }
    }
}

