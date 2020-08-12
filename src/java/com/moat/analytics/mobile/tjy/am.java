/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.media.MediaPlayer
 *  android.view.View
 *  java.lang.Object
 *  java.util.Map
 */
package com.moat.analytics.mobile.tjy;

import android.media.MediaPlayer;
import android.view.View;
import com.moat.analytics.mobile.tjy.MoatAdEvent;
import com.moat.analytics.mobile.tjy.NativeVideoTracker;
import java.util.Map;

class am
implements NativeVideoTracker {
    am() {
    }

    @Override
    public void changeTargetView(View view) {
    }

    @Override
    public void dispatchEvent(MoatAdEvent moatAdEvent) {
    }

    @Override
    public void dispatchEvent(Map map) {
    }

    @Override
    public void setDebug(boolean bl2) {
    }

    @Override
    public boolean trackVideoAd(Map map, MediaPlayer mediaPlayer, View view) {
        return false;
    }
}

