/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 */
package com.integralads.avid.library.mopub.video;

public interface AvidVideoPlaybackListener {
    public void recordAdClickThruEvent();

    public void recordAdCompleteEvent();

    public void recordAdDurationChangeEvent(String var1, String var2);

    public void recordAdEnteredFullscreenEvent();

    public void recordAdError(String var1);

    public void recordAdExitedFullscreenEvent();

    public void recordAdExpandedChangeEvent();

    public void recordAdImpressionEvent();

    public void recordAdLoadedEvent();

    public void recordAdPausedEvent();

    public void recordAdPlayingEvent();

    public void recordAdSkippedEvent();

    public void recordAdStartedEvent();

    public void recordAdStoppedEvent();

    public void recordAdUserAcceptInvitationEvent();

    public void recordAdUserCloseEvent();

    public void recordAdUserMinimizeEvent();

    public void recordAdVideoFirstQuartileEvent();

    public void recordAdVideoMidpointEvent();

    public void recordAdVideoStartEvent();

    public void recordAdVideoThirdQuartileEvent();

    public void recordAdVolumeChangeEvent(Integer var1);
}

