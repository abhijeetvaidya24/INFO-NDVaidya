/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Iterator
 *  java.util.Queue
 */
package com.moat.analytics.mobile.aer;

import com.moat.analytics.mobile.aer.am;
import com.moat.analytics.mobile.aer.an;
import com.moat.analytics.mobile.aer.ao;
import com.moat.analytics.mobile.aer.at;
import java.util.Iterator;
import java.util.Queue;

class aq
implements at {
    final /* synthetic */ ao a;

    aq(ao ao2) {
        this.a = ao2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(an an2) {
        if (ao.c() != an2) {
            Queue queue;
            Queue queue2 = queue = ao.d();
            synchronized (queue2) {
                ao.a(an2);
                Iterator iterator = ao.d().iterator();
                while (iterator.hasNext()) {
                    am am2 = (am)iterator.next();
                    if (an2 == an.b) {
                        am2.a();
                    } else {
                        am2.b();
                    }
                    iterator.remove();
                }
            }
        }
        ao.a(this.a);
    }
}

