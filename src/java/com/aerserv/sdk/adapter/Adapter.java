/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.util.concurrent.atomic.AtomicBoolean
 *  org.json.JSONObject
 */
package com.aerserv.sdk.adapter;

import android.app.Activity;
import com.aerserv.sdk.adapter.AdapterListener;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public abstract class Adapter {
    private AtomicBoolean adManuallyLoadedFlag = new AtomicBoolean();

    public boolean CASAdManuallyLoadedFlag(boolean bl) {
        return this.adManuallyLoadedFlag.compareAndSet(bl ^ true, bl);
    }

    public abstract void cleanup(Activity var1);

    public abstract boolean hasAd(boolean var1);

    public abstract boolean hasPartnerAdLoadFailedDueToConnectionError();

    public abstract Boolean hasPartnerAdLoaded(boolean var1);

    public abstract Boolean hasPartnerAdShown(boolean var1);

    public abstract void loadPartnerAd(Activity var1, JSONObject var2, boolean var3, boolean var4);

    public void removeInstance() {
    }

    public abstract void showPartnerAd(Activity var1, boolean var2, AdapterListener var3);

    public abstract boolean supportsRewardedCallback();
}

