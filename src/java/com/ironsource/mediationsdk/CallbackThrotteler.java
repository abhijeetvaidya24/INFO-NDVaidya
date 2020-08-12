/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.text.TextUtils
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.System
 *  java.util.HashMap
 *  java.util.Map
 */
package com.ironsource.mediationsdk;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.ISDemandOnlyInterstitialListener;
import com.ironsource.mediationsdk.sdk.InterstitialListener;
import java.util.HashMap;
import java.util.Map;

public class CallbackThrotteler {
    private ISDemandOnlyInterstitialListener mDemandOnlyListener = null;
    private Map<String, Boolean> mIsWaitingForInvocation = new HashMap();
    private Map<String, Long> mLastInvoked = new HashMap();
    private InterstitialListener mListener = null;

    private boolean hasPendingInvocationInternal(String string) {
        if (TextUtils.isEmpty((CharSequence)string)) {
            return false;
        }
        if (!this.mIsWaitingForInvocation.containsKey((Object)string)) {
            return false;
        }
        return (Boolean)this.mIsWaitingForInvocation.get((Object)string);
    }

    private void invokeCallback(String string, IronSourceError ironSourceError) {
        this.mLastInvoked.put((Object)string, (Object)System.currentTimeMillis());
        if (string.equalsIgnoreCase("mediation")) {
            InterstitialListener interstitialListener = this.mListener;
            if (interstitialListener != null) {
                interstitialListener.onInterstitialAdLoadFailed(ironSourceError);
                return;
            }
        } else {
            ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListener = this.mDemandOnlyListener;
            if (iSDemandOnlyInterstitialListener != null) {
                iSDemandOnlyInterstitialListener.onInterstitialAdLoadFailed(string, ironSourceError);
            }
        }
    }

    private void onInterstitialAdLoadFailedInternal(final String string, final IronSourceError ironSourceError) {
        if (this.hasPendingInvocationInternal(string)) {
            return;
        }
        if (!this.mLastInvoked.containsKey((Object)string)) {
            this.invokeCallback(string, ironSourceError);
            return;
        }
        long l2 = System.currentTimeMillis() - (Long)this.mLastInvoked.get((Object)string);
        if (l2 > 15000L) {
            this.invokeCallback(string, ironSourceError);
            return;
        }
        this.mIsWaitingForInvocation.put((Object)string, (Object)true);
        long l3 = 15000L - l2;
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable(){

            public void run() {
                CallbackThrotteler.this.invokeCallback(string, ironSourceError);
                CallbackThrotteler.this.mIsWaitingForInvocation.put((Object)string, (Object)false);
            }
        }, l3);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingInvocation() {
        CallbackThrotteler callbackThrotteler = this;
        synchronized (callbackThrotteler) {
            return this.hasPendingInvocationInternal("mediation");
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingInvocation(String string) {
        CallbackThrotteler callbackThrotteler = this;
        synchronized (callbackThrotteler) {
            return this.hasPendingInvocationInternal(string);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onInterstitialAdLoadFailed(IronSourceError ironSourceError) {
        CallbackThrotteler callbackThrotteler = this;
        synchronized (callbackThrotteler) {
            this.onInterstitialAdLoadFailedInternal("mediation", ironSourceError);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onInterstitialAdLoadFailed(String string, IronSourceError ironSourceError) {
        CallbackThrotteler callbackThrotteler = this;
        synchronized (callbackThrotteler) {
            this.onInterstitialAdLoadFailedInternal(string, ironSourceError);
            return;
        }
    }

    public void setISDemandOnlyInterstitialListener(ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListener) {
        this.mDemandOnlyListener = iSDemandOnlyInterstitialListener;
    }

    public void setInterstitialListener(InterstitialListener interstitialListener) {
        this.mListener = interstitialListener;
    }

}

