/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  java.lang.Object
 *  java.lang.ref.WeakReference
 */
package com.applovin.impl.sdk;

import android.os.Handler;
import android.os.Looper;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import java.lang.ref.WeakReference;

public class c {
    private static final Handler a = new Handler(Looper.getMainLooper());
    private WeakReference<AppLovinAdDisplayListener> b = new WeakReference(null);
    private WeakReference<AppLovinAdClickListener> c = new WeakReference(null);
    private WeakReference<AppLovinAdRewardListener> d = new WeakReference(null);

    public void a(AppLovinAdClickListener appLovinAdClickListener) {
        this.c = new WeakReference((Object)appLovinAdClickListener);
    }

    public void a(AppLovinAdDisplayListener appLovinAdDisplayListener) {
        this.b = new WeakReference((Object)appLovinAdDisplayListener);
    }
}

