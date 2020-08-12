/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 */
package com.moat.analytics.mobile.tjy;

import com.moat.analytics.mobile.tjy.ar;
import com.moat.analytics.mobile.tjy.av;
import com.moat.analytics.mobile.tjy.base.exception.a;

class aw
implements Runnable {
    final /* synthetic */ ar a;
    final /* synthetic */ av b;

    aw(av av2, ar ar2) {
        this.b = av2;
        this.a = ar2;
    }

    public void run() {
        try {
            av.a(this.b).a(this.a);
            return;
        }
        catch (Exception exception) {
            a.a(exception);
            return;
        }
    }
}

