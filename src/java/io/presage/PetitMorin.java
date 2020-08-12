/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  java.lang.Object
 */
package io.presage;

import android.app.Application;
import com.moat.analytics.mobile.ogury.MoatAnalytics;
import com.moat.analytics.mobile.ogury.MoatFactory;
import io.presage.cl;

public final class PetitMorin {
    private boolean a;
    private final MoatAnalytics b;

    public PetitMorin(MoatAnalytics moatAnalytics) {
        this.b = moatAnalytics;
    }

    public static MoatFactory a() {
        MoatFactory moatFactory = MoatFactory.create();
        cl.a((Object)moatFactory, "MoatFactory.create()");
        return moatFactory;
    }

    public final void a(Application application) {
        this.a = true;
        this.b.start(application);
    }
}

