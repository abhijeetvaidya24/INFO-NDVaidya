/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.adcolony.sdk.AdColonyInterstitial
 *  com.adcolony.sdk.AdColonyInterstitialListener
 *  com.adcolony.sdk.AdColonyZone
 *  com.adincube.sdk.mediation.n.a
 *  com.adincube.sdk.mediation.n.b
 *  com.adincube.sdk.mediation.v.a
 *  com.adincube.sdk.mediation.v.b
 *  java.lang.String
 */
package com.adincube.sdk.mediation.b;

import com.adcolony.sdk.AdColonyInterstitial;
import com.adcolony.sdk.AdColonyInterstitialListener;
import com.adcolony.sdk.AdColonyZone;
import com.adincube.sdk.mediation.a;
import com.adincube.sdk.mediation.j;

public final class b
extends AdColonyInterstitialListener {
    a a = null;
    com.adincube.sdk.mediation.n.b b = null;
    com.adincube.sdk.mediation.v.b c = null;
    AdColonyInterstitial d = null;
    private com.adincube.sdk.mediation.b e = null;

    public b(com.adincube.sdk.mediation.b b2) {
        this.e = b2;
    }

    public final void a() {
        AdColonyInterstitial adColonyInterstitial = this.d;
        if (adColonyInterstitial != null) {
            adColonyInterstitial.destroy();
        }
        this.d = null;
    }

    public final void onClicked(AdColonyInterstitial adColonyInterstitial) {
        com.adincube.sdk.mediation.v.b b2;
        com.adincube.sdk.mediation.n.b b3 = this.b;
        if (b3 != null) {
            b3.a((com.adincube.sdk.mediation.n.a)this.e);
        }
        if ((b2 = this.c) != null) {
            b2.a((com.adincube.sdk.mediation.v.a)this.e);
        }
    }

    public final void onClosed(AdColonyInterstitial adColonyInterstitial) {
        com.adincube.sdk.mediation.v.b b2;
        com.adincube.sdk.mediation.n.b b3 = this.b;
        if (b3 != null) {
            b3.d(this.e);
        }
        if ((b2 = this.c) != null) {
            b2.d(this.e);
        }
    }

    public final void onExpiring(AdColonyInterstitial adColonyInterstitial) {
    }

    public final void onIAPEvent(AdColonyInterstitial adColonyInterstitial, String string, int n2) {
    }

    public final void onLeftApplication(AdColonyInterstitial adColonyInterstitial) {
    }

    public final void onOpened(AdColonyInterstitial adColonyInterstitial) {
        com.adincube.sdk.mediation.v.b b2;
        com.adincube.sdk.mediation.n.b b3 = this.b;
        if (b3 != null) {
            b3.r();
        }
        if ((b2 = this.c) != null) {
            b2.s();
        }
    }

    public final void onRequestFilled(AdColonyInterstitial adColonyInterstitial) {
        this.d = adColonyInterstitial;
        a a2 = this.a;
        if (a2 != null) {
            a2.a();
        }
    }

    public final void onRequestNotFilled(AdColonyZone adColonyZone) {
        if (this.a != null) {
            j j2 = new j(this.e, j.a.b);
            this.a.a(j2);
        }
    }
}

