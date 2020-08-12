/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.adincube.sdk.h.f.d
 *  com.adincube.sdk.mediation.ac.a
 *  com.adincube.sdk.mediation.ac.f
 *  com.vungle.warren.InitCallback
 *  com.vungle.warren.LoadAdCallback
 *  com.vungle.warren.Vungle
 *  com.vungle.warren.Vungle$Consent
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashSet
 *  java.util.Set
 */
package com.adincube.sdk.mediation.ac;

import android.content.Context;
import com.adincube.sdk.mediation.ac.a;
import com.adincube.sdk.mediation.ac.f;
import com.vungle.warren.InitCallback;
import com.vungle.warren.LoadAdCallback;
import com.vungle.warren.Vungle;
import java.util.HashSet;
import java.util.Set;

public class d {
    boolean a = false;
    com.adincube.sdk.h.f.d b;
    final LoadAdCallback c = new LoadAdCallback(){};
    private Context d = null;
    private f e = null;
    private Set<String> f = new HashSet();
    private Set<a> g = new HashSet();
    private Set<a> h = new HashSet();
    private boolean i = false;
    private final InitCallback j = new InitCallback(){};

    public d(Context context, f f2) {
        this.d = context;
        this.e = f2;
    }

    private void b() {
        d d2 = this;
        synchronized (d2) {
            if (!this.a && !this.i) {
                this.i = true;
                Vungle.init((String)this.e.l, (Context)this.d, (InitCallback)this.j);
                this.a();
            }
            return;
        }
    }

    final void a() {
        if (this.b == com.adincube.sdk.h.f.d.c) {
            Vungle.updateConsentStatus((Vungle.Consent)Vungle.Consent.OPTED_IN, (String)"");
            return;
        }
        if (this.b == com.adincube.sdk.h.f.d.d) {
            Vungle.updateConsentStatus((Vungle.Consent)Vungle.Consent.OPTED_OUT, (String)"");
        }
    }

    public final void a(a a2) {
        d d2 = this;
        synchronized (d2) {
            if (this.a) {
                this.h.add((Object)a2);
                return;
            }
            this.b();
            this.g.add((Object)a2);
            return;
        }
    }

    public final void a(String string) {
        d d2 = this;
        synchronized (d2) {
            if (this.a) {
                Vungle.loadAd((String)string, (LoadAdCallback)this.c);
                return;
            }
            this.b();
            this.f.add((Object)string);
            return;
        }
    }

    public final void b(a a2) {
        d d2 = this;
        synchronized (d2) {
            this.g.remove((Object)a2);
            if (this.a) {
                this.h.remove((Object)a2);
            }
            return;
        }
    }

}

