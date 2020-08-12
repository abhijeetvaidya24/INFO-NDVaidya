/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.media.MediaPlayer
 *  android.view.View
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.ref.WeakReference
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Map
 */
package com.moat.analytics.mobile.mpub;

import android.media.MediaPlayer;
import android.view.View;
import com.moat.analytics.mobile.mpub.NativeVideoTracker;
import com.moat.analytics.mobile.mpub.TrackerListener;
import com.moat.analytics.mobile.mpub.h;
import com.moat.analytics.mobile.mpub.m;
import com.moat.analytics.mobile.mpub.p;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class u
extends h
implements NativeVideoTracker {
    private WeakReference<MediaPlayer> m;

    u(String string) {
        super(string);
        p.a(3, "NativeVideoTracker", this, "In initialization method.");
        if (string == null || string.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("PartnerCode is ");
            String string2 = string == null ? "null" : "empty";
            stringBuilder.append(string2);
            String string3 = stringBuilder.toString();
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("NativeDisplayTracker creation problem, ");
            stringBuilder2.append(string3);
            p.a("[ERROR] ", 3, "NativeVideoTracker", this, stringBuilder2.toString());
            this.a = new m(string3);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a());
        stringBuilder.append(" created");
        p.a("[SUCCESS] ", stringBuilder.toString());
    }

    private void a(MediaPlayer mediaPlayer) {
        if (mediaPlayer != null) {
            try {
                mediaPlayer.getCurrentPosition();
                return;
            }
            catch (Exception exception) {
                throw new m("Playback has already completed");
            }
        }
        throw new m("Null player instance");
    }

    @Override
    String a() {
        return "NativeVideoTracker";
    }

    @Override
    void a(List<String> list) {
        if (!this.n()) {
            list.add((Object)"Player is null");
        }
        super.a(list);
    }

    @Override
    Map<String, Object> i() {
        MediaPlayer mediaPlayer = (MediaPlayer)this.m.get();
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"width", (Object)mediaPlayer.getVideoWidth());
        hashMap.put((Object)"height", (Object)mediaPlayer.getVideoHeight());
        hashMap.put((Object)"duration", (Object)mediaPlayer.getDuration());
        return hashMap;
    }

    @Override
    boolean n() {
        WeakReference<MediaPlayer> weakReference = this.m;
        return weakReference != null && weakReference.get() != null;
    }

    @Override
    Integer o() {
        return ((MediaPlayer)this.m.get()).getCurrentPosition();
    }

    @Override
    boolean q() {
        return ((MediaPlayer)this.m.get()).isPlaying();
    }

    @Override
    Integer r() {
        return ((MediaPlayer)this.m.get()).getDuration();
    }

    @Override
    public boolean trackVideoAd(Map<String, String> map, MediaPlayer mediaPlayer, View view) {
        try {
            this.c();
            this.d();
            this.a(mediaPlayer);
            this.m = new WeakReference((Object)mediaPlayer);
            boolean bl = super.a(map, view);
            return bl;
        }
        catch (Exception exception) {
            m.a(exception);
            String string = m.a("trackVideoAd", exception);
            if (this.d != null) {
                this.d.onTrackingFailedToStart(string);
            }
            p.a(3, "NativeVideoTracker", this, string);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.a());
            stringBuilder.append(" ");
            stringBuilder.append(string);
            p.a("[ERROR] ", stringBuilder.toString());
            return false;
        }
    }
}

