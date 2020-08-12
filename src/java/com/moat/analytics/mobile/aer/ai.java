/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.media.MediaPlayer
 *  android.view.View
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 */
package com.moat.analytics.mobile.aer;

import android.media.MediaPlayer;
import android.view.View;
import com.moat.analytics.mobile.aer.MoatAdEvent;
import com.moat.analytics.mobile.aer.NativeVideoTracker;
import java.util.Map;

class ai
implements NativeVideoTracker {
    ai() {
    }

    @Override
    public void changeTargetView(View view) {
    }

    @Override
    public void dispatchEvent(MoatAdEvent moatAdEvent) {
    }

    @Override
    public void dispatchEvent(Map<String, Object> map) {
    }

    @Override
    public void setDebug(boolean bl) {
    }

    @Override
    public boolean trackVideoAd(Map<String, String> map, MediaPlayer mediaPlayer, View view) {
        return false;
    }
}

