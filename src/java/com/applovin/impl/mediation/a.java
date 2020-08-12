/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.os.Bundle
 *  com.applovin.impl.mediation.a.c
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.applovin.impl.mediation;

import android.app.Activity;
import android.os.Bundle;
import com.applovin.impl.mediation.a.c;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.p;

public class a
extends com.applovin.impl.sdk.e.a {
    private final com.applovin.impl.sdk.a a;
    private final p b;
    private a c;
    private c d;
    private int e;
    private boolean f;

    a(j j2) {
        this.b = j2.u();
        this.a = j2.S();
    }

    public void a() {
        this.b.a("AdActivityObserver", "Cancelling...");
        this.a.b(this);
        this.c = null;
        this.d = null;
        this.e = 0;
        this.f = false;
    }

    public void a(c c2, a a2) {
        p p2 = this.b;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Starting for ad ");
        stringBuilder.append(c2.getAdUnitId());
        stringBuilder.append("...");
        p2.a("AdActivityObserver", stringBuilder.toString());
        this.a();
        this.c = a2;
        this.d = c2;
        this.a.a(this);
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (!this.f) {
            this.f = true;
        }
        this.e = 1 + this.e;
        p p2 = this.b;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Created Activity: ");
        stringBuilder.append((Object)activity);
        stringBuilder.append(", counter is ");
        stringBuilder.append(this.e);
        p2.a("AdActivityObserver", stringBuilder.toString());
    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        if (!this.f) {
            return;
        }
        this.e = -1 + this.e;
        p p2 = this.b;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Destroyed Activity: ");
        stringBuilder.append((Object)activity);
        stringBuilder.append(", counter is ");
        stringBuilder.append(this.e);
        p2.a("AdActivityObserver", stringBuilder.toString());
        if (this.e <= 0) {
            this.b.a("AdActivityObserver", "Last ad Activity destroyed");
            if (this.c != null) {
                this.b.a("AdActivityObserver", "Invoking callback...");
                this.c.a(this.d);
            }
            this.a();
        }
    }

}

