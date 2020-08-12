/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 */
package com.ironsource.mediationsdk.utils;

public class SessionDepthManager {
    private static SessionDepthManager mInstance;
    private int mBannerDepth = 1;
    private int mInterstitialDepth = 1;
    private int mOfferwallDepth = 1;
    private int mRewardedVideoDepth = 1;

    public static SessionDepthManager getInstance() {
        Class<SessionDepthManager> class_ = SessionDepthManager.class;
        synchronized (SessionDepthManager.class) {
            if (mInstance == null) {
                mInstance = new SessionDepthManager();
            }
            SessionDepthManager sessionDepthManager = mInstance;
            // ** MonitorExit[var2] (shouldn't be in output)
            return sessionDepthManager;
        }
    }

    public int getSessionDepth(int n2) {
        SessionDepthManager sessionDepthManager = this;
        synchronized (sessionDepthManager) {
            if (n2 != 0) {
                if (n2 != 1) {
                    if (n2 != 2) {
                        if (n2 != 3) {
                            return -1;
                        }
                        int n3 = this.mBannerDepth;
                        return n3;
                    }
                    int n4 = this.mInterstitialDepth;
                    return n4;
                }
                int n5 = this.mRewardedVideoDepth;
                return n5;
            }
            int n6 = this.mOfferwallDepth;
            return n6;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void increaseSessionDepth(int n2) {
        SessionDepthManager sessionDepthManager = this;
        synchronized (sessionDepthManager) {
            if (n2 != 0) {
                if (n2 != 1) {
                    if (n2 != 2) {
                        if (n2 == 3) {
                            this.mBannerDepth = 1 + this.mBannerDepth;
                        }
                    } else {
                        this.mInterstitialDepth = 1 + this.mInterstitialDepth;
                    }
                } else {
                    this.mRewardedVideoDepth = 1 + this.mRewardedVideoDepth;
                }
            } else {
                this.mOfferwallDepth = 1 + this.mOfferwallDepth;
            }
            return;
        }
    }
}

