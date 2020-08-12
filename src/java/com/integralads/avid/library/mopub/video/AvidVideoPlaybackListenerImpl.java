/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.integralads.avid.library.mopub.video;

import com.integralads.avid.library.mopub.base.AvidBaseListenerImpl;
import com.integralads.avid.library.mopub.session.internal.InternalAvidAdSession;
import com.integralads.avid.library.mopub.session.internal.jsbridge.AvidBridgeManager;
import com.integralads.avid.library.mopub.video.AvidVideoPlaybackListener;
import org.json.JSONException;
import org.json.JSONObject;

public class AvidVideoPlaybackListenerImpl
extends AvidBaseListenerImpl
implements AvidVideoPlaybackListener {
    public static final String AD_CLICK_THRU = "AdClickThru";
    public static final String AD_DURATION = "adDuration";
    public static final String AD_DURATION_CHANGE = "AdDurationChange";
    public static final String AD_ENTERED_FULLSCREEN = "AdEnteredFullscreen";
    public static final String AD_ERROR = "AdError";
    public static final String AD_EXITED_FULLSCREEN = "AdExitedFullscreen";
    public static final String AD_EXPANDED_CHANGE = "AdExpandedChange";
    public static final String AD_IMPRESSION = "AdImpression";
    public static final String AD_LOADED = "AdLoaded";
    public static final String AD_PAUSED = "AdPaused";
    public static final String AD_PLAYING = "AdPlaying";
    public static final String AD_REMAINING_TIME = "adDuration";
    public static final String AD_SKIPPED = "AdSkipped";
    public static final String AD_STARTED = "AdStarted";
    public static final String AD_STOPPED = "AdStopped";
    public static final String AD_USER_ACCEPT_INVITATION = "AdUserAcceptInvitation";
    public static final String AD_USER_CLOSE = "AdUserClose";
    public static final String AD_USER_MINIMIZE = "AdUserMinimize";
    public static final String AD_VIDEO_COMPLETE = "AdVideoComplete";
    public static final String AD_VIDEO_FIRST_QUARTILE = "AdVideoFirstQuartile";
    public static final String AD_VIDEO_MIDPOINT = "AdVideoMidpoint";
    public static final String AD_VIDEO_START = "AdVideoStart";
    public static final String AD_VIDEO_THIRD_QUARTILE = "AdVideoThirdQuartile";
    public static final String AD_VOLUME_CHANGE = "AdVolumeChange";
    public static final String MESSAGE = "message";
    public static final String VOLUME = "volume";

    public AvidVideoPlaybackListenerImpl(InternalAvidAdSession internalAvidAdSession, AvidBridgeManager avidBridgeManager) {
        super(internalAvidAdSession, avidBridgeManager);
    }

    private void assertSessionIsReady() {
        if (this.getAvidAdSession().isReady()) {
            return;
        }
        throw new IllegalStateException("The AVID ad session is not ready. Please ensure you have called recordReadyEvent for the deferred AVID ad session before recording any video event.");
    }

    private void publishVideoEvent(String string, JSONObject jSONObject) {
        this.assertSessionIsNotEnded();
        this.assertSessionIsReady();
        this.getAvidBridgeManager().publishVideoEvent(string, jSONObject);
    }

    @Override
    public void recordAdClickThruEvent() {
        this.publishVideoEvent(AD_CLICK_THRU, null);
    }

    @Override
    public void recordAdCompleteEvent() {
        this.publishVideoEvent(AD_VIDEO_COMPLETE, null);
    }

    @Override
    public void recordAdDurationChangeEvent(String string, String string2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("adDuration", (Object)string);
            jSONObject.put("adDuration", (Object)string2);
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
        }
        this.publishVideoEvent(AD_DURATION_CHANGE, jSONObject);
    }

    @Override
    public void recordAdEnteredFullscreenEvent() {
        this.publishVideoEvent(AD_ENTERED_FULLSCREEN, null);
    }

    @Override
    public void recordAdError(String string) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(MESSAGE, (Object)string);
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
        }
        this.publishVideoEvent(AD_ERROR, jSONObject);
    }

    @Override
    public void recordAdExitedFullscreenEvent() {
        this.publishVideoEvent(AD_EXITED_FULLSCREEN, null);
    }

    @Override
    public void recordAdExpandedChangeEvent() {
        this.publishVideoEvent(AD_EXPANDED_CHANGE, null);
    }

    @Override
    public void recordAdImpressionEvent() {
        this.publishVideoEvent(AD_IMPRESSION, null);
    }

    @Override
    public void recordAdLoadedEvent() {
        this.publishVideoEvent(AD_LOADED, null);
    }

    @Override
    public void recordAdPausedEvent() {
        this.publishVideoEvent(AD_PAUSED, null);
    }

    @Override
    public void recordAdPlayingEvent() {
        this.publishVideoEvent(AD_PLAYING, null);
    }

    @Override
    public void recordAdSkippedEvent() {
        this.publishVideoEvent(AD_SKIPPED, null);
    }

    @Override
    public void recordAdStartedEvent() {
        this.publishVideoEvent(AD_STARTED, null);
    }

    @Override
    public void recordAdStoppedEvent() {
        this.publishVideoEvent(AD_STOPPED, null);
    }

    @Override
    public void recordAdUserAcceptInvitationEvent() {
        this.publishVideoEvent(AD_USER_ACCEPT_INVITATION, null);
    }

    @Override
    public void recordAdUserCloseEvent() {
        this.publishVideoEvent(AD_USER_CLOSE, null);
    }

    @Override
    public void recordAdUserMinimizeEvent() {
        this.publishVideoEvent(AD_USER_MINIMIZE, null);
    }

    @Override
    public void recordAdVideoFirstQuartileEvent() {
        this.publishVideoEvent(AD_VIDEO_FIRST_QUARTILE, null);
    }

    @Override
    public void recordAdVideoMidpointEvent() {
        this.publishVideoEvent(AD_VIDEO_MIDPOINT, null);
    }

    @Override
    public void recordAdVideoStartEvent() {
        this.publishVideoEvent(AD_VIDEO_START, null);
    }

    @Override
    public void recordAdVideoThirdQuartileEvent() {
        this.publishVideoEvent(AD_VIDEO_THIRD_QUARTILE, null);
    }

    @Override
    public void recordAdVolumeChangeEvent(Integer n2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(VOLUME, (Object)n2);
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
        }
        this.publishVideoEvent(AD_VOLUME_CHANGE, jSONObject);
    }
}

