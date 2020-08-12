/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  com.adincube.sdk.d.b.d
 *  com.adincube.sdk.mediation.o.f
 *  com.adincube.sdk.mediation.o.h
 *  com.ironsource.mediationsdk.IronSourceObject
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.Field
 *  java.util.concurrent.atomic.AtomicBoolean
 */
package com.adincube.sdk.mediation.o;

import android.app.Activity;
import com.adincube.sdk.d.b.d;
import com.adincube.sdk.mediation.o.f;
import com.adincube.sdk.mediation.o.h;
import com.adincube.sdk.util.ErrorReportingHelper;
import com.adincube.sdk.util.a;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceObject;
import com.ironsource.mediationsdk.sdk.RewardedVideoListener;
import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicBoolean;

public final class b {
    private f a = null;
    private Boolean b = null;
    private boolean c = false;
    private h d;

    public b(f f2, h h2) {
        this.a = f2;
        this.d = h2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean a() {
        Boolean bl = this.b;
        if (bl != null) {
            return bl;
        }
        try {
            Field field = IronSourceObject.class.getDeclaredField("mAtomicIsFirstInit");
            field.setAccessible(true);
            boolean bl2 = !((AtomicBoolean)field.get((Object)IronSourceObject.getInstance())).get();
            this.b = bl2;
            return this.b;
        }
        catch (Throwable throwable) {
            a.c("Cannot determine if IronSource is already initialized. Considering not initialized by default.", new Object[]{throwable});
            ErrorReportingHelper.report("IronSourceInitializationHelper.isAlreadyInitialized", throwable);
            this.b = false;
        }
        return this.b;
    }

    public final void a(Activity activity) {
        b b2 = this;
        synchronized (b2) {
            if (!this.c) {
                if (!this.a()) {
                    this.c = true;
                    IronSource.setRewardedVideoListener((RewardedVideoListener)this.d);
                    String string = this.a.k;
                    IronSource.AD_UNIT[] arraD_UNIT = new IronSource.AD_UNIT[]{IronSource.AD_UNIT.INTERSTITIAL, IronSource.AD_UNIT.REWARDED_VIDEO};
                    IronSource.init(activity, string, arraD_UNIT);
                } else {
                    throw new d("IronSource");
                }
            }
            return;
        }
    }
}

