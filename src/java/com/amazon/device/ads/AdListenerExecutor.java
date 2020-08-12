/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  com.amazon.device.ads.MobileAdsLogger
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.amazon.device.ads;

import android.graphics.Rect;
import com.amazon.device.ads.ActionCode;
import com.amazon.device.ads.Ad;
import com.amazon.device.ads.AdData;
import com.amazon.device.ads.AdError;
import com.amazon.device.ads.AdEvent;
import com.amazon.device.ads.AdListener;
import com.amazon.device.ads.AdProperties;
import com.amazon.device.ads.MobileAdsLogger;
import com.amazon.device.ads.MobileAdsLoggerFactory;
import com.amazon.device.ads.OnAdEventCommand;
import com.amazon.device.ads.OnAdExpiredCommand;
import com.amazon.device.ads.OnAdReceivedCommand;
import com.amazon.device.ads.OnAdResizedCommand;
import com.amazon.device.ads.OnSpecialUrlClickedCommand;
import com.amazon.device.ads.ThreadUtils;

class AdListenerExecutor {
    private static final String LOGTAG = "AdListenerExecutor";
    private final AdListener adListener;
    private final MobileAdsLogger logger;
    private OnAdEventCommand onAdEventCommand;
    private OnAdExpiredCommand onAdExpiredCommand;
    private OnAdReceivedCommand onAdReceivedCommand;
    private OnAdResizedCommand onAdResizedCommand;
    private OnSpecialUrlClickedCommand onSpecialUrlClickedCommand;
    private final ThreadUtils.ThreadRunner threadRunner;

    public AdListenerExecutor(AdListener adListener, MobileAdsLoggerFactory mobileAdsLoggerFactory) {
        this(adListener, ThreadUtils.getThreadRunner(), mobileAdsLoggerFactory);
    }

    AdListenerExecutor(AdListener adListener, ThreadUtils.ThreadRunner threadRunner, MobileAdsLoggerFactory mobileAdsLoggerFactory) {
        this.adListener = adListener;
        this.threadRunner = threadRunner;
        this.logger = mobileAdsLoggerFactory.createMobileAdsLogger(LOGTAG);
    }

    protected void execute(Runnable runnable) {
        this.threadRunner.execute(runnable, ThreadUtils.ExecutionStyle.SCHEDULE, ThreadUtils.ExecutionThread.MAIN_THREAD);
    }

    AdListener getAdListener() {
        return this.adListener;
    }

    public void onAdCollapsed(final Ad ad) {
        this.execute(new Runnable(){

            public void run() {
                AdListenerExecutor.this.getAdListener().onAdCollapsed(ad);
            }
        });
    }

    public void onAdDismissed(final Ad ad) {
        this.execute(new Runnable(){

            public void run() {
                AdListenerExecutor.this.getAdListener().onAdDismissed(ad);
            }
        });
    }

    public void onAdEvent(AdEvent adEvent) {
        OnAdEventCommand onAdEventCommand = this.onAdEventCommand;
        if (onAdEventCommand == null) {
            MobileAdsLogger mobileAdsLogger = this.logger;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Ad listener called - Ad Event: ");
            stringBuilder.append((Object)adEvent);
            mobileAdsLogger.d(stringBuilder.toString());
            return;
        }
        onAdEventCommand.onAdEvent(adEvent);
    }

    public void onAdExpanded(final Ad ad) {
        this.execute(new Runnable(){

            public void run() {
                AdListenerExecutor.this.getAdListener().onAdExpanded(ad);
            }
        });
    }

    public void onAdExpired(Ad ad) {
        OnAdExpiredCommand onAdExpiredCommand = this.onAdExpiredCommand;
        if (onAdExpiredCommand == null) {
            this.logger.d("Ad listener called - Ad Expired.");
            return;
        }
        onAdExpiredCommand.onAdExpired(ad);
    }

    public void onAdFailedToLoad(final Ad ad, final AdError adError) {
        this.execute(new Runnable(){

            public void run() {
                AdListenerExecutor.this.getAdListener().onAdFailedToLoad(ad, adError);
            }
        });
    }

    public void onAdLoaded(final Ad ad, final AdProperties adProperties) {
        this.execute(new Runnable(){

            public void run() {
                AdListenerExecutor.this.getAdListener().onAdLoaded(ad, adProperties);
            }
        });
    }

    public ActionCode onAdReceived(Ad ad, AdData adData) {
        OnAdReceivedCommand onAdReceivedCommand = this.onAdReceivedCommand;
        if (onAdReceivedCommand == null) {
            this.logger.d("Ad listener called - Ad Received.");
            return ActionCode.DISPLAY;
        }
        return onAdReceivedCommand.onAdReceived(ad, adData);
    }

    public void onAdResized(Ad ad, Rect rect) {
        OnAdResizedCommand onAdResizedCommand = this.onAdResizedCommand;
        if (onAdResizedCommand == null) {
            this.logger.d("Ad listener called - Ad Resized.");
            return;
        }
        onAdResizedCommand.onAdResized(ad, rect);
    }

    public void onSpecialUrlClicked(Ad ad, String string) {
        OnSpecialUrlClickedCommand onSpecialUrlClickedCommand = this.onSpecialUrlClickedCommand;
        if (onSpecialUrlClickedCommand == null) {
            this.logger.d("Ad listener called - Special Url Clicked.");
            return;
        }
        onSpecialUrlClickedCommand.onSpecialUrlClicked(ad, string);
    }

    public void setOnAdEventCommand(OnAdEventCommand onAdEventCommand) {
        this.onAdEventCommand = onAdEventCommand;
    }

    public void setOnAdExpiredCommand(OnAdExpiredCommand onAdExpiredCommand) {
        this.onAdExpiredCommand = onAdExpiredCommand;
    }

    public void setOnAdReceivedCommand(OnAdReceivedCommand onAdReceivedCommand) {
        this.onAdReceivedCommand = onAdReceivedCommand;
    }

    public void setOnAdResizedCommand(OnAdResizedCommand onAdResizedCommand) {
        this.onAdResizedCommand = onAdResizedCommand;
    }

    public void setOnSpecialUrlClickedCommand(OnSpecialUrlClickedCommand onSpecialUrlClickedCommand) {
        this.onSpecialUrlClickedCommand = onSpecialUrlClickedCommand;
    }

}

