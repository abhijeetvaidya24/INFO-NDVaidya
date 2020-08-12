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
package com.integralads.avid.library.adcolony.video;

import com.integralads.avid.library.adcolony.base.AvidBaseListenerImpl;
import com.integralads.avid.library.adcolony.session.internal.InternalAvidAdSession;
import com.integralads.avid.library.adcolony.session.internal.jsbridge.AvidBridgeManager;
import com.integralads.avid.library.adcolony.video.AvidVideoPlaybackListener;
import org.json.JSONException;
import org.json.JSONObject;

public class AvidVideoPlaybackListenerImpl
extends AvidBaseListenerImpl
implements AvidVideoPlaybackListener {
    public AvidVideoPlaybackListenerImpl(InternalAvidAdSession internalAvidAdSession, AvidBridgeManager avidBridgeManager) {
        super(internalAvidAdSession, avidBridgeManager);
    }

    private void a() {
        if (this.getAvidAdSession().isReady()) {
            return;
        }
        throw new IllegalStateException("The AVID ad session is not ready. Please ensure you have called recordReadyEvent for the deferred AVID ad session before recording any video event.");
    }

    private void a(String string, JSONObject jSONObject) {
        this.assertSessionIsNotEnded();
        this.a();
        this.getAvidBridgeManager().publishVideoEvent(string, jSONObject);
    }

    @Override
    public void recordAdClickThruEvent() {
        this.a("AdClickThru", null);
    }

    @Override
    public void recordAdCompleteEvent() {
        this.a("AdVideoComplete", null);
    }

    @Override
    public void recordAdImpressionEvent() {
        this.a("AdImpression", null);
    }

    @Override
    public void recordAdLoadedEvent() {
        this.a("AdLoaded", null);
    }

    @Override
    public void recordAdPausedEvent() {
        this.a("AdPaused", null);
    }

    @Override
    public void recordAdPlayingEvent() {
        this.a("AdPlaying", null);
    }

    @Override
    public void recordAdSkippedEvent() {
        this.a("AdSkipped", null);
    }

    @Override
    public void recordAdStartedEvent() {
        this.a("AdStarted", null);
    }

    @Override
    public void recordAdStoppedEvent() {
        this.a("AdStopped", null);
    }

    @Override
    public void recordAdUserCloseEvent() {
        this.a("AdUserClose", null);
    }

    @Override
    public void recordAdVideoFirstQuartileEvent() {
        this.a("AdVideoFirstQuartile", null);
    }

    @Override
    public void recordAdVideoMidpointEvent() {
        this.a("AdVideoMidpoint", null);
    }

    @Override
    public void recordAdVideoStartEvent() {
        this.a("AdVideoStart", null);
    }

    @Override
    public void recordAdVideoThirdQuartileEvent() {
        this.a("AdVideoThirdQuartile", null);
    }

    @Override
    public void recordAdVolumeChangeEvent(Integer n2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("volume", (Object)n2);
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
        }
        this.a("AdVolumeChange", jSONObject);
    }
}

