/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.media.MediaPlayer
 *  android.view.View
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.ref.WeakReference
 *  java.util.HashMap
 *  java.util.Map
 */
package com.moat.analytics.mobile.aer;

import android.media.MediaPlayer;
import android.view.View;
import com.moat.analytics.mobile.aer.NativeVideoTracker;
import com.moat.analytics.mobile.aer.a;
import com.moat.analytics.mobile.aer.al;
import com.moat.analytics.mobile.aer.i;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

class ad
extends i<MediaPlayer>
implements NativeVideoTracker {
    public ad(String string, a a2, al al2) {
        super(string, a2, al2);
    }

    @Override
    protected Map<String, Object> a() {
        MediaPlayer mediaPlayer = (MediaPlayer)this.f.get();
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"width", (Object)mediaPlayer.getVideoWidth());
        hashMap.put((Object)"height", (Object)mediaPlayer.getVideoHeight());
        hashMap.put((Object)"duration", (Object)mediaPlayer.getDuration());
        return hashMap;
    }

    @Override
    public /* synthetic */ boolean a(Map map, Object object, View view) {
        return this.trackVideoAd((Map<String, String>)map, (MediaPlayer)object, view);
    }

    @Override
    public void changeTargetView(View view) {
        super.changeTargetView(view);
    }

    @Override
    protected Integer f() {
        return ((MediaPlayer)this.f.get()).getCurrentPosition();
    }

    @Override
    protected boolean g() {
        return ((MediaPlayer)this.f.get()).isPlaying();
    }

    @Override
    protected Integer h() {
        return ((MediaPlayer)this.f.get()).getDuration();
    }

    @Override
    public boolean trackVideoAd(Map<String, String> map, MediaPlayer mediaPlayer, View view) {
        if (mediaPlayer == null) {
            this.a("Null player instance. Not tracking.");
        }
        try {
            mediaPlayer.getCurrentPosition();
        }
        catch (IllegalStateException illegalStateException) {
            this.a("Playback has already completed. Not tracking.");
            return false;
        }
        return super.a(map, mediaPlayer, view);
    }
}

