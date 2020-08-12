/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.res.Configuration
 *  java.lang.Object
 *  java.lang.String
 */
package com.aerserv.sdk.view.vastplayer;

import android.content.res.Configuration;

public interface VpaidPlayer {
    public void AdClickThru(String var1, String var2, String var3);

    public void AdError(String var1);

    public void AdExpandedChange();

    public void AdImpression();

    public void AdInteraction();

    public void AdLinearChange();

    public void AdLoaded();

    public void AdLog(String var1);

    public void AdPaused();

    public void AdPlaying();

    public void AdRemainingTimeChange();

    public void AdSkipped();

    public void AdStarted();

    public void AdStopped();

    public void AdUserAcceptInvitation();

    public void AdUserClose();

    public void AdUserMinimize();

    public void AdVideoComplete();

    public void AdVideoFirstQuartile();

    public void AdVideoMidpoint();

    public void AdVideoStart();

    public void AdVideoThirdQuartile();

    public void AdVolumeChange();

    public void heartbeat();

    public void load();

    public void onResize(Configuration var1);

    public void pause();

    public void play();

    public void resume();

    public void stop();
}

