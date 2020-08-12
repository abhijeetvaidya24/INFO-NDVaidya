/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.applovin.impl.mediation.a.c
 *  java.lang.Object
 *  java.lang.Runnable
 */
package com.applovin.impl.mediation;

import com.applovin.impl.mediation.a;
import com.applovin.impl.mediation.b;
import com.applovin.impl.mediation.c;
import com.applovin.impl.sdk.j;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdListener;
import com.applovin.sdk.AppLovinSdkUtils;

public class b
implements a.a,
c.a {
    private final a a;
    private final c b;
    private final MaxAdListener c;

    public b(j j2, MaxAdListener maxAdListener) {
        this.c = maxAdListener;
        this.a = new a(j2);
        this.b = new c(j2, this);
    }

    static /* synthetic */ MaxAdListener a(b b2) {
        return b2.c;
    }

    @Override
    public void a(com.applovin.impl.mediation.a.c c2) {
        long l2 = c2.k();
        AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable(this, c2){
            final /* synthetic */ com.applovin.impl.mediation.a.c a;
            final /* synthetic */ b b;
            {
                this.b = b2;
                this.a = c2;
            }

            public void run() {
                b.a(this.b).onAdHidden((MaxAd)this.a);
            }
        }, l2);
    }

    public void a(MaxAd maxAd) {
        this.b.a();
        this.a.a();
    }

    public void b(com.applovin.impl.mediation.a.c c2) {
        long l2 = c2.i();
        if (l2 >= 0L) {
            this.b.a(c2, l2);
        }
        if (c2.j()) {
            this.a.a(c2, this);
        }
    }

    @Override
    public void c(com.applovin.impl.mediation.a.c c2) {
        this.c.onAdHidden((MaxAd)c2);
    }
}

