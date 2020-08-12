/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Properties
 */
package com.aerserv.sdk.controller.listener;

import com.aerserv.sdk.controller.listener.PlayPauseListener;
import com.aerserv.sdk.controller.listener.ProviderListener;
import com.aerserv.sdk.utils.AerServLog;
import java.util.Properties;

public class DefaultProviderListener
implements ProviderListener {
    private static final String LOG_TAG = "DefaultProviderListener";

    @Override
    public void onExpand(Properties properties, String string) {
        AerServLog.w(LOG_TAG, "onExpand called but ignored");
    }

    @Override
    public void onPlayPauseListenerCreated(PlayPauseListener playPauseListener) {
        AerServLog.w(LOG_TAG, "onPlayPauseListenerCreated called on provider listener but ignored");
    }

    @Override
    public void onProviderAdReturned() {
        AerServLog.w(LOG_TAG, "onProviderAdReturned called on provider listener but ignored");
    }

    @Override
    public void onProviderAttempt() {
        AerServLog.w(LOG_TAG, "onProviderAttempt called on provider listener but ignored");
    }

    @Override
    public void onProviderConnectionError() {
        AerServLog.w(LOG_TAG, "onProviderConnectionError called on provider listener but ignored");
    }

    @Override
    public void onProviderFailShow() {
        AerServLog.w(LOG_TAG, "onProviderFailShow called on provider listener but ignored");
    }

    @Override
    public void onProviderFailure() {
        AerServLog.w(LOG_TAG, "onProviderFailure called on provider listener but ignored");
    }

    @Override
    public void onProviderFinished() {
        AerServLog.w(LOG_TAG, "onProviderFinished called on provider listener but ignored");
    }

    @Override
    public void onProviderImpression() {
        AerServLog.w(LOG_TAG, "onProviderImpression called on provider listener but ignored");
    }

    @Override
    public void onProviderNoAd() {
        AerServLog.w(LOG_TAG, "onProviderNoAd called on provider listener but ignored");
    }

    @Override
    public void removeOnPlayPauseListener() {
        AerServLog.w(LOG_TAG, "onPlayPauseListener removed");
    }
}

