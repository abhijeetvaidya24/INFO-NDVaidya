/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.applovin.impl.sdk.AppLovinAdBase
 *  com.applovin.impl.sdk.ad.h
 *  com.applovin.mediation.MaxAdViewAdListener
 *  com.applovin.mediation.MaxRewardedAdListener
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Map
 */
package com.applovin.impl.sdk.e;

import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinAdViewEventListener;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.p;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.MaxRewardedAdListener;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Map;

public class h {
    public static void a(final AppLovinAdViewEventListener appLovinAdViewEventListener, final AppLovinAd appLovinAd, final AppLovinAdView appLovinAdView, final j j2) {
        if (appLovinAd != null && appLovinAdViewEventListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable(){

                public void run() {
                    try {
                        appLovinAdViewEventListener.adOpenedFullscreen(h.b(appLovinAd), appLovinAdView);
                        return;
                    }
                    catch (Throwable throwable) {
                        j2.u().c("ListenerCallbackInvoker", "Unable to notify ad event listener about fullscreen opened event", throwable);
                        return;
                    }
                }
            });
        }
    }

    public static void a(final MaxAdListener maxAdListener, final MaxAd maxAd, final int n2, final j j2) {
        if (maxAd != null && maxAdListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable(){

                public void run() {
                    try {
                        maxAdListener.onAdDisplayFailed(maxAd, n2);
                        return;
                    }
                    catch (Throwable throwable) {
                        j2.u().c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad failing to display", throwable);
                        return;
                    }
                }
            });
        }
    }

    public static void a(final MaxAdListener maxAdListener, final MaxAd maxAd, final j j2) {
        if (maxAd != null && maxAdListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable(){

                public void run() {
                    try {
                        maxAdListener.onAdLoaded(maxAd);
                        return;
                    }
                    catch (Throwable throwable) {
                        j2.u().c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being loaded", throwable);
                        return;
                    }
                }
            });
        }
    }

    public static void a(final MaxAdListener maxAdListener, final MaxAd maxAd, final MaxReward maxReward, final j j2) {
        if (maxAd != null && maxAdListener != null && maxAdListener instanceof MaxRewardedAdListener) {
            AppLovinSdkUtils.runOnUiThread(new Runnable(){

                public void run() {
                    try {
                        ((MaxRewardedAdListener)maxAdListener).onUserRewarded(maxAd, maxReward);
                        return;
                    }
                    catch (Throwable throwable) {
                        j2.u().c("ListenerCallbackInvoker", "Unable to notify ad event listener about user being rewarded", throwable);
                        return;
                    }
                }
            });
        }
    }

    public static void a(final MaxAdListener maxAdListener, final String string2, final int n2, final j j2) {
        if (string2 != null && maxAdListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable(){

                public void run() {
                    try {
                        maxAdListener.onAdLoadFailed(string2, n2);
                        return;
                    }
                    catch (Throwable throwable) {
                        j2.u().c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad failing to load", throwable);
                        return;
                    }
                }
            });
        }
    }

    public static void a(final AppLovinAdClickListener appLovinAdClickListener, final AppLovinAd appLovinAd, final j j2) {
        if (appLovinAd != null && appLovinAdClickListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable(){

                public void run() {
                    try {
                        appLovinAdClickListener.adClicked(h.b(appLovinAd));
                        return;
                    }
                    catch (Throwable throwable) {
                        j2.u().c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being clicked", throwable);
                        return;
                    }
                }
            });
        }
    }

    public static void a(final AppLovinAdDisplayListener appLovinAdDisplayListener, final AppLovinAd appLovinAd, final j j2) {
        if (appLovinAd != null && appLovinAdDisplayListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable(){

                public void run() {
                    try {
                        appLovinAdDisplayListener.adDisplayed(h.b(appLovinAd));
                        return;
                    }
                    catch (Throwable throwable) {
                        j2.u().c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being displayed", throwable);
                        return;
                    }
                }
            });
        }
    }

    public static void a(final AppLovinAdRewardListener appLovinAdRewardListener, final AppLovinAd appLovinAd, final int n2, final j j2) {
        if (appLovinAd != null && appLovinAdRewardListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable(){

                public void run() {
                    try {
                        appLovinAdRewardListener.validationRequestFailed(h.b(appLovinAd), n2);
                        return;
                    }
                    catch (Throwable throwable) {
                        j2.u().c("ListenerCallbackInvoker", "Unable to notify ad reward listener about reward validation request failing", throwable);
                        return;
                    }
                }
            });
        }
    }

    public static void a(final AppLovinAdRewardListener appLovinAdRewardListener, final AppLovinAd appLovinAd, final j j2) {
        if (appLovinAd != null && appLovinAdRewardListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable(){

                public void run() {
                    try {
                        appLovinAdRewardListener.userDeclinedToViewAd(h.b(appLovinAd));
                        return;
                    }
                    catch (Throwable throwable) {
                        j2.u().c("ListenerCallbackInvoker", "Unable to notify ad reward listener about user declining to view ad", throwable);
                        return;
                    }
                }
            });
        }
    }

    public static void a(final AppLovinAdRewardListener appLovinAdRewardListener, final AppLovinAd appLovinAd, final Map<String, String> map, final j j2) {
        if (appLovinAd != null && appLovinAdRewardListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable(){

                public void run() {
                    try {
                        appLovinAdRewardListener.userRewardVerified(h.b(appLovinAd), (Map<String, String>)map);
                        return;
                    }
                    catch (Throwable throwable) {
                        j2.u().c("ListenerCallbackInvoker", "Unable to notify ad reward listener about successful reward validation request", throwable);
                        return;
                    }
                }
            });
        }
    }

    public static void a(final AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, final AppLovinAd appLovinAd, final double d2, final boolean bl, final j j2) {
        if (appLovinAd != null && appLovinAdVideoPlaybackListener != null) {
            Runnable runnable = new Runnable(){

                public void run() {
                    try {
                        appLovinAdVideoPlaybackListener.videoPlaybackEnded(h.b(appLovinAd), d2, bl);
                        return;
                    }
                    catch (Throwable throwable) {
                        j2.u().c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad playback ended", throwable);
                        return;
                    }
                }
            };
            AppLovinSdkUtils.runOnUiThread(runnable);
        }
    }

    public static void a(final AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, final AppLovinAd appLovinAd, final j j2) {
        if (appLovinAd != null && appLovinAdVideoPlaybackListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable(){

                public void run() {
                    try {
                        appLovinAdVideoPlaybackListener.videoPlaybackBegan(h.b(appLovinAd));
                        return;
                    }
                    catch (Throwable throwable) {
                        j2.u().c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad playback began", throwable);
                        return;
                    }
                }
            });
        }
    }

    private static AppLovinAd b(AppLovinAd appLovinAd) {
        AppLovinAdBase appLovinAdBase = (AppLovinAdBase)appLovinAd;
        if (appLovinAdBase.getDummyAd() != null) {
            appLovinAd = appLovinAdBase.getDummyAd();
        }
        return appLovinAd;
    }

    public static void b(final AppLovinAdViewEventListener appLovinAdViewEventListener, final AppLovinAd appLovinAd, final AppLovinAdView appLovinAdView, final j j2) {
        if (appLovinAd != null && appLovinAdViewEventListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable(){

                public void run() {
                    try {
                        appLovinAdViewEventListener.adClosedFullscreen(h.b(appLovinAd), appLovinAdView);
                        return;
                    }
                    catch (Throwable throwable) {
                        j2.u().c("ListenerCallbackInvoker", "Unable to notify ad event listener about fullscreen closed event", throwable);
                        return;
                    }
                }
            });
        }
    }

    public static void b(final MaxAdListener maxAdListener, final MaxAd maxAd, final j j2) {
        if (maxAd != null && maxAdListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable(){

                public void run() {
                    try {
                        maxAdListener.onAdDisplayed(maxAd);
                        return;
                    }
                    catch (Throwable throwable) {
                        j2.u().c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being displayed", throwable);
                        return;
                    }
                }
            });
        }
    }

    public static void b(final AppLovinAdDisplayListener appLovinAdDisplayListener, final AppLovinAd appLovinAd, final j j2) {
        if (appLovinAd != null && appLovinAdDisplayListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable(){

                public void run() {
                    try {
                        appLovinAdDisplayListener.adHidden(h.b(appLovinAd));
                        return;
                    }
                    catch (Throwable throwable) {
                        j2.u().c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being hidden", throwable);
                        return;
                    }
                }
            });
        }
    }

    public static void b(final AppLovinAdRewardListener appLovinAdRewardListener, final AppLovinAd appLovinAd, final Map<String, String> map, final j j2) {
        if (appLovinAd != null && appLovinAdRewardListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable(){

                public void run() {
                    try {
                        appLovinAdRewardListener.userOverQuota(h.b(appLovinAd), (Map<String, String>)map);
                        return;
                    }
                    catch (Throwable throwable) {
                        j2.u().c("ListenerCallbackInvoker", "Unable to notify ad reward listener about exceeding quota", throwable);
                        return;
                    }
                }
            });
        }
    }

    public static void c(final AppLovinAdViewEventListener appLovinAdViewEventListener, final AppLovinAd appLovinAd, final AppLovinAdView appLovinAdView, final j j2) {
        if (appLovinAd != null && appLovinAdViewEventListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable(){

                public void run() {
                    try {
                        appLovinAdViewEventListener.adLeftApplication(h.b(appLovinAd), appLovinAdView);
                        return;
                    }
                    catch (Throwable throwable) {
                        j2.u().c("ListenerCallbackInvoker", "Unable to notify ad event listener about application leave event", throwable);
                        return;
                    }
                }
            });
        }
    }

    public static void c(final MaxAdListener maxAdListener, final MaxAd maxAd, final j j2) {
        if (maxAd != null && maxAdListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable(){

                public void run() {
                    try {
                        maxAdListener.onAdHidden(maxAd);
                        return;
                    }
                    catch (Throwable throwable) {
                        j2.u().c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being hidden", throwable);
                        return;
                    }
                }
            });
        }
    }

    public static void c(final AppLovinAdRewardListener appLovinAdRewardListener, final AppLovinAd appLovinAd, final Map<String, String> map, final j j2) {
        if (appLovinAd != null && appLovinAdRewardListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable(){

                public void run() {
                    try {
                        appLovinAdRewardListener.userRewardRejected(h.b(appLovinAd), (Map<String, String>)map);
                        return;
                    }
                    catch (Throwable throwable) {
                        j2.u().c("ListenerCallbackInvoker", "Unable to notify ad reward listener about reward validation request being rejected", throwable);
                        return;
                    }
                }
            });
        }
    }

    public static void d(final MaxAdListener maxAdListener, final MaxAd maxAd, final j j2) {
        if (maxAd != null && maxAdListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable(){

                public void run() {
                    try {
                        maxAdListener.onAdClicked(maxAd);
                        return;
                    }
                    catch (Throwable throwable) {
                        j2.u().c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being clicked", throwable);
                        return;
                    }
                }
            });
        }
    }

    public static void e(final MaxAdListener maxAdListener, final MaxAd maxAd, final j j2) {
        if (maxAd != null && maxAdListener != null && maxAdListener instanceof MaxRewardedAdListener) {
            AppLovinSdkUtils.runOnUiThread(new Runnable(){

                public void run() {
                    try {
                        ((MaxRewardedAdListener)maxAdListener).onRewardedVideoStarted(maxAd);
                        return;
                    }
                    catch (Throwable throwable) {
                        j2.u().c("ListenerCallbackInvoker", "Unable to notify ad event listener about rewarded video starting", throwable);
                        return;
                    }
                }
            });
        }
    }

    public static void f(final MaxAdListener maxAdListener, final MaxAd maxAd, final j j2) {
        if (maxAd != null && maxAdListener != null && maxAdListener instanceof MaxRewardedAdListener) {
            AppLovinSdkUtils.runOnUiThread(new Runnable(){

                public void run() {
                    try {
                        ((MaxRewardedAdListener)maxAdListener).onRewardedVideoCompleted(maxAd);
                        return;
                    }
                    catch (Throwable throwable) {
                        j2.u().c("ListenerCallbackInvoker", "Unable to notify ad event listener about rewarded video completing", throwable);
                        return;
                    }
                }
            });
        }
    }

    public static void g(final MaxAdListener maxAdListener, final MaxAd maxAd, final j j2) {
        if (maxAd != null && maxAdListener != null && maxAdListener instanceof MaxAdViewAdListener) {
            AppLovinSdkUtils.runOnUiThread(new Runnable(){

                public void run() {
                    try {
                        ((MaxAdViewAdListener)maxAdListener).onAdExpanded(maxAd);
                        return;
                    }
                    catch (Throwable throwable) {
                        j2.u().c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being expanded", throwable);
                        return;
                    }
                }
            });
        }
    }

    public static void h(final MaxAdListener maxAdListener, final MaxAd maxAd, final j j2) {
        if (maxAd != null && maxAdListener != null && maxAdListener instanceof MaxAdViewAdListener) {
            AppLovinSdkUtils.runOnUiThread(new Runnable(){

                public void run() {
                    try {
                        ((MaxAdViewAdListener)maxAdListener).onAdCollapsed(maxAd);
                        return;
                    }
                    catch (Throwable throwable) {
                        j2.u().c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being collapsed", throwable);
                        return;
                    }
                }
            });
        }
    }

}

