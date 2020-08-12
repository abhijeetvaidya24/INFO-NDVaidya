/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.System
 */
package com.ironsource.mediationsdk;

import android.os.Handler;
import android.os.Looper;
import com.ironsource.mediationsdk.IronSourceBannerLayout;
import com.ironsource.mediationsdk.logger.IronSourceError;

public class BannerCallbackThrottler {
    private static BannerCallbackThrottler sInstance;
    private boolean mIsWaitingForInvocation = false;
    private long mLastInvoked = 0L;

    private BannerCallbackThrottler() {
    }

    public static BannerCallbackThrottler getInstance() {
        Class<BannerCallbackThrottler> class_ = BannerCallbackThrottler.class;
        synchronized (BannerCallbackThrottler.class) {
            if (sInstance == null) {
                sInstance = new BannerCallbackThrottler();
            }
            BannerCallbackThrottler bannerCallbackThrottler = sInstance;
            // ** MonitorExit[var2] (shouldn't be in output)
            return bannerCallbackThrottler;
        }
    }

    private void invokeCallback(IronSourceBannerLayout ironSourceBannerLayout, IronSourceError ironSourceError) {
        this.mLastInvoked = System.currentTimeMillis();
        ironSourceBannerLayout.sendBannerAdLoadFailed(ironSourceError);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingInvocation() {
        BannerCallbackThrottler bannerCallbackThrottler = this;
        synchronized (bannerCallbackThrottler) {
            return this.mIsWaitingForInvocation;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void sendBannerAdLoadFailed(final IronSourceBannerLayout ironSourceBannerLayout, final IronSourceError ironSourceError) {
        BannerCallbackThrottler bannerCallbackThrottler = this;
        synchronized (bannerCallbackThrottler) {
            if (this.mIsWaitingForInvocation) {
                return;
            }
            long l2 = System.currentTimeMillis() - this.mLastInvoked;
            if (l2 > 15000L) {
                this.invokeCallback(ironSourceBannerLayout, ironSourceError);
                return;
            }
            this.mIsWaitingForInvocation = true;
            long l3 = 15000L - l2;
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable(){

                public void run() {
                    BannerCallbackThrottler.this.invokeCallback(ironSourceBannerLayout, ironSourceError);
                    BannerCallbackThrottler.this.mIsWaitingForInvocation = false;
                }
            }, l3);
            return;
        }
    }

}

