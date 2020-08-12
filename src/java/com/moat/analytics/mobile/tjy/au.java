/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Iterator
 *  java.util.Queue
 */
package com.moat.analytics.mobile.tjy;

import android.util.Log;
import com.moat.analytics.mobile.tjy.aq;
import com.moat.analytics.mobile.tjy.ar;
import com.moat.analytics.mobile.tjy.as;
import com.moat.analytics.mobile.tjy.ax;
import java.util.Iterator;
import java.util.Queue;

class au
implements ax {
    final /* synthetic */ as a;

    au(as as2) {
        this.a = as2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(ar ar2) {
        if (as.d() != ar2) {
            Queue queue;
            Queue queue2 = queue = as.e();
            synchronized (queue2) {
                if (ar2 == ar.b && as.f()) {
                    Log.d((String)"MoatOnOff", (String)"Moat enabled - Version 1.7.10");
                }
                as.a(ar2);
                Iterator iterator = as.e().iterator();
                while (iterator.hasNext()) {
                    aq aq2 = (aq)iterator.next();
                    if (ar2 == ar.b) {
                        aq2.a();
                    } else {
                        aq2.b();
                    }
                    iterator.remove();
                }
            }
        }
        as.a(this.a);
    }
}

