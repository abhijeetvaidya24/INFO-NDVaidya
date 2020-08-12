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
import java.util.Properties;

public interface ProviderListener {
    public void onExpand(Properties var1, String var2);

    public void onPlayPauseListenerCreated(PlayPauseListener var1);

    public void onProviderAdReturned();

    public void onProviderAttempt();

    public void onProviderConnectionError();

    public void onProviderFailShow();

    public void onProviderFailure();

    public void onProviderFinished();

    public void onProviderImpression();

    public void onProviderNoAd();

    public void removeOnPlayPauseListener();
}

