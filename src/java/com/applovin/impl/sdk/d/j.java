/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.applovin.impl.sdk.d.j$1
 *  java.lang.IllegalArgumentException
 *  java.lang.String
 */
package com.applovin.impl.sdk.d;

import com.applovin.impl.sdk.c.i;
import com.applovin.impl.sdk.d.a;
import com.applovin.impl.sdk.d.j;
import com.applovin.impl.sdk.d.q;
import com.applovin.impl.sdk.network.b;
import com.applovin.impl.sdk.network.f;
import com.applovin.sdk.AppLovinPostbackListener;

public class j
extends a {
    private final f a;
    private final AppLovinPostbackListener c;
    private final q.a d;

    public j(f f2, q.a a2, com.applovin.impl.sdk.j j2, AppLovinPostbackListener appLovinPostbackListener) {
        super("TaskDispatchPostback", j2);
        if (f2 != null) {
            this.a = f2;
            this.c = appLovinPostbackListener;
            this.d = a2;
            return;
        }
        throw new IllegalArgumentException("No request specified");
    }

    static /* synthetic */ AppLovinPostbackListener a(j j2) {
        return j2.c;
    }

    @Override
    public i a() {
        return i.c;
    }

    public void run() {
        String string = this.a.a();
        if (!com.applovin.impl.sdk.e.j.b(string)) {
            this.b("Requested URL is not valid; nothing to do...");
            AppLovinPostbackListener appLovinPostbackListener = this.c;
            if (appLovinPostbackListener != null) {
                appLovinPostbackListener.onPostbackFailure(string, -900);
            }
            return;
        }
        1 var2_3 = new 1(this, (b)this.a, this.b(), string);
        var2_3.a(this.d);
        this.b().C().a((a)var2_3);
    }
}

