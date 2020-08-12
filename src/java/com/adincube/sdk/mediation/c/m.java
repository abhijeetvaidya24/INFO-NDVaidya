/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.adincube.sdk.h.c.b
 *  com.google.android.gms.ads.reward.RewardItem
 *  com.google.android.gms.ads.reward.RewardedVideoAdListener
 *  java.lang.Object
 *  java.lang.Throwable
 *  java.util.Collection
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.Set
 */
package com.adincube.sdk.mediation.c;

import com.adincube.sdk.h.c.b;
import com.adincube.sdk.util.ErrorReportingHelper;
import com.adincube.sdk.util.a;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class m
implements RewardedVideoAdListener {
    private RewardedVideoAdListener a = null;
    private Set<RewardedVideoAdListener> b = new HashSet();

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public final void onRewarded(RewardItem rewardItem) {
        try {
            Set<RewardedVideoAdListener> set;
            Set<RewardedVideoAdListener> set2 = set = this.b;
            // MONITORENTER : set2
        }
        catch (Throwable throwable) {
            a.c("AdMobRewardedVideoAdListenerHelper.onRewarded", new Object[]{throwable});
            ErrorReportingHelper.report("AdMobRewardedVideoAdListenerHelper.onRewarded", b.d, throwable);
            return;
        }
        Iterator iterator = new HashSet(this.b).iterator();
        do {
            if (!iterator.hasNext()) {
                // MONITOREXIT : set2
                return;
            }
            ((RewardedVideoAdListener)iterator.next()).onRewarded(rewardItem);
        } while (true);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public final void onRewardedVideoAdClosed() {
        try {
            Set<RewardedVideoAdListener> set;
            Set<RewardedVideoAdListener> set2 = set = this.b;
            // MONITORENTER : set2
        }
        catch (Throwable throwable) {
            a.c("AdMobRewardedVideoAdListenerHelper.onRewardedVideoAdClosed", new Object[]{throwable});
            ErrorReportingHelper.report("AdMobRewardedVideoAdListenerHelper.onRewardedVideoAdClosed", b.d, throwable);
            return;
        }
        Iterator iterator = new HashSet(this.b).iterator();
        do {
            if (!iterator.hasNext()) {
                // MONITOREXIT : set2
                return;
            }
            ((RewardedVideoAdListener)iterator.next()).onRewardedVideoAdClosed();
        } while (true);
    }

    public final void onRewardedVideoAdFailedToLoad(int n2) {
        try {
            if (this.a != null) {
                this.a.onRewardedVideoAdFailedToLoad(n2);
            }
            return;
        }
        catch (Throwable throwable) {
            a.c("AdMobRewardedVideoAdListenerHelper.onRewardedVideoAdFailedToLoad", new Object[]{throwable});
            ErrorReportingHelper.report("AdMobRewardedVideoAdListenerHelper.onRewardedVideoAdFailedToLoad", b.d, throwable);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public final void onRewardedVideoAdLeftApplication() {
        try {
            Set<RewardedVideoAdListener> set;
            Set<RewardedVideoAdListener> set2 = set = this.b;
            // MONITORENTER : set2
        }
        catch (Throwable throwable) {
            a.c("AdMobRewardedVideoAdListenerHelper.onRewardedVideoAdLeftApplication", new Object[]{throwable});
            ErrorReportingHelper.report("AdMobRewardedVideoAdListenerHelper.onRewardedVideoAdLeftApplication", b.d, throwable);
            return;
        }
        Iterator iterator = new HashSet(this.b).iterator();
        do {
            if (!iterator.hasNext()) {
                // MONITOREXIT : set2
                return;
            }
            ((RewardedVideoAdListener)iterator.next()).onRewardedVideoAdLeftApplication();
        } while (true);
    }

    public final void onRewardedVideoAdLoaded() {
        try {
            if (this.a != null) {
                this.a.onRewardedVideoAdLoaded();
            }
            return;
        }
        catch (Throwable throwable) {
            a.c("AdMobRewardedVideoAdListenerHelper.onRewardedVideoAdLoaded", new Object[]{throwable});
            ErrorReportingHelper.report("AdMobRewardedVideoAdListenerHelper.onRewardedVideoAdLoaded", b.d, throwable);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public final void onRewardedVideoAdOpened() {
        try {
            Set<RewardedVideoAdListener> set;
            Set<RewardedVideoAdListener> set2 = set = this.b;
            // MONITORENTER : set2
        }
        catch (Throwable throwable) {
            a.c("AdMobRewardedVideoAdListenerHelper.onRewardedVideoAdOpened", new Object[]{throwable});
            ErrorReportingHelper.report("AdMobRewardedVideoAdListenerHelper.onRewardedVideoAdOpened", b.d, throwable);
            return;
        }
        Iterator iterator = new HashSet(this.b).iterator();
        do {
            if (!iterator.hasNext()) {
                // MONITOREXIT : set2
                return;
            }
            ((RewardedVideoAdListener)iterator.next()).onRewardedVideoAdOpened();
        } while (true);
    }

    public final void onRewardedVideoCompleted() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public final void onRewardedVideoStarted() {
        try {
            Set<RewardedVideoAdListener> set;
            Set<RewardedVideoAdListener> set2 = set = this.b;
            // MONITORENTER : set2
        }
        catch (Throwable throwable) {
            a.c("AdMobRewardedVideoAdListenerHelper.onRewardedVideoStarted", new Object[]{throwable});
            ErrorReportingHelper.report("AdMobRewardedVideoAdListenerHelper.onRewardedVideoStarted", b.d, throwable);
            return;
        }
        Iterator iterator = new HashSet(this.b).iterator();
        do {
            if (!iterator.hasNext()) {
                // MONITOREXIT : set2
                return;
            }
            ((RewardedVideoAdListener)iterator.next()).onRewardedVideoStarted();
        } while (true);
    }
}

