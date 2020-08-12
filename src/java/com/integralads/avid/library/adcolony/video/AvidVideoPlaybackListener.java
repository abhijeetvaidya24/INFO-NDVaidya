/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 */
package com.integralads.avid.library.adcolony.video;

public interface AvidVideoPlaybackListener {
    public void recordAdClickThruEvent();

    public void recordAdCompleteEvent();

    public void recordAdImpressionEvent();

    public void recordAdLoadedEvent();

    public void recordAdPausedEvent();

    public void recordAdPlayingEvent();

    public void recordAdSkippedEvent();

    public void recordAdStartedEvent();

    public void recordAdStoppedEvent();

    public void recordAdUserCloseEvent();

    public void recordAdVideoFirstQuartileEvent();

    public void recordAdVideoMidpointEvent();

    public void recordAdVideoStartEvent();

    public void recordAdVideoThirdQuartileEvent();

    public void recordAdVolumeChangeEvent(Integer var1);
}

