/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.media.MediaPlayer
 *  android.view.View
 *  java.lang.Object
 *  java.lang.String
 */
package com.aerserv.sdk.utils;

import android.media.MediaPlayer;
import android.view.View;
import com.moat.analytics.mobile.aer.NativeDisplayTracker;
import com.moat.analytics.mobile.aer.NativeVideoTracker;

public class MoatData {
    private String advertiserId;
    private String appName;
    private String campaignId = "AerServ";
    private String creativeId;
    private boolean enabled;
    private String lineItemId;
    private MediaPlayer mediaPlayer;
    private String moatVastId = null;
    private NativeDisplayTracker nativeDisplayTracker;
    private NativeVideoTracker nativeVideoTracker;
    private String placement;
    private boolean started = false;
    private View view;

    public String getAdvertiserId() {
        return this.advertiserId;
    }

    public String getAppName() {
        return this.appName;
    }

    public String getCampaignId() {
        return this.campaignId;
    }

    public String getCreativeId() {
        return this.creativeId;
    }

    public String getLineItemId() {
        return this.lineItemId;
    }

    public MediaPlayer getMediaPlayer() {
        return this.mediaPlayer;
    }

    public String getMoatVastId() {
        return this.moatVastId;
    }

    public NativeDisplayTracker getNativeDisplayTracker() {
        return this.nativeDisplayTracker;
    }

    public NativeVideoTracker getNativeVideoTracker() {
        return this.nativeVideoTracker;
    }

    public String getPlacement() {
        return this.placement;
    }

    public View getView() {
        return this.view;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public boolean isStarted() {
        return this.started;
    }

    public void setAdvertiserId(String string) {
        this.advertiserId = string;
    }

    public void setAppName(String string) {
        this.appName = string;
    }

    public void setCampaignId(String string) {
        this.campaignId = string;
    }

    public void setCreativeId(String string) {
        this.creativeId = string;
    }

    public void setEnabled(boolean bl) {
        this.enabled = bl;
    }

    public void setLineItemId(String string) {
        this.lineItemId = string;
    }

    public void setMediaPlayer(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }

    public void setMoatVastId(String string) {
        this.moatVastId = string;
    }

    public void setNativeDisplayTracker(NativeDisplayTracker nativeDisplayTracker) {
        this.nativeDisplayTracker = nativeDisplayTracker;
    }

    public void setNativeVideoTracker(NativeVideoTracker nativeVideoTracker) {
        this.nativeVideoTracker = nativeVideoTracker;
    }

    public void setPlacement(String string) {
        this.placement = string;
    }

    public void setStarted(boolean bl) {
        this.started = bl;
    }

    public void setView(View view) {
        this.view = view;
    }
}

