/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  com.moat.analytics.mobile.tjy.i
 *  java.lang.Boolean
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.ref.WeakReference
 */
package com.moat.analytics.mobile.tjy;

import android.os.Handler;
import com.moat.analytics.mobile.tjy.base.exception.a;
import com.moat.analytics.mobile.tjy.i;
import java.lang.ref.WeakReference;

class j
implements Runnable {
    final /* synthetic */ i a;

    j(i i2) {
        this.a = i2;
    }

    public void run() {
        try {
            if (this.a.f.get() != null && !this.a.e()) {
                if (Boolean.valueOf((boolean)this.a.i()).booleanValue()) {
                    this.a.d.postDelayed((Runnable)this, 200L);
                    return;
                }
                this.a.c();
                return;
            }
            this.a.c();
            return;
        }
        catch (Exception exception) {
            this.a.c();
            a.a(exception);
            return;
        }
    }
}

