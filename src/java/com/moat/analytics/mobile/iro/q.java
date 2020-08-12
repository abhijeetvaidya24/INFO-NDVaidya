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
package com.moat.analytics.mobile.iro;

import android.media.MediaPlayer;
import android.view.View;
import com.moat.analytics.mobile.iro.NativeVideoTracker;
import com.moat.analytics.mobile.iro.TrackerListener;
import com.moat.analytics.mobile.iro.b;
import com.moat.analytics.mobile.iro.g;
import com.moat.analytics.mobile.iro.o;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class q
extends g
implements NativeVideoTracker {
    private WeakReference<MediaPlayer> \u037a;

    q(String string) {
        super(string);
        b.\u02cf(3, "NativeVideoTracker", this, "In initialization method.");
        if (string == null || string.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder("PartnerCode is ");
            String string2 = string == null ? "null" : "empty";
            stringBuilder.append(string2);
            String string3 = stringBuilder.toString();
            StringBuilder stringBuilder2 = new StringBuilder("NativeDisplayTracker creation problem, ");
            stringBuilder2.append(string3);
            String string4 = stringBuilder2.toString();
            b.\u02cf(3, "NativeVideoTracker", this, string4);
            b.\u02ce("[ERROR] ", string4);
            this.\u02cb = new o(string3);
        }
        b.\u02ce("[SUCCESS] ", "NativeVideoTracker created");
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    @Override
    public final boolean trackVideoAd(Map<String, String> map, MediaPlayer mediaPlayer, View view) {
        try {
            this.\u02cb();
            this.\u02cf();
            if (mediaPlayer == null) throw new o("Null player instance");
        }
        catch (Exception exception) {
            o.\u0971(exception);
            String string = o.\u0971("trackVideoAd", exception);
            if (this.\u02ca != null) {
                this.\u02ca.onTrackingFailedToStart(string);
            }
            b.\u02cf(3, "NativeVideoTracker", this, string);
            StringBuilder stringBuilder = new StringBuilder("NativeVideoTracker ");
            stringBuilder.append(string);
            b.\u02ce("[ERROR] ", stringBuilder.toString());
            return false;
        }
        mediaPlayer.getCurrentPosition();
        {
            catch (Exception exception) {
                throw new o("Playback has already completed");
            }
        }
        this.\u037a = new WeakReference((Object)mediaPlayer);
        return super.\u02cb(map, view);
    }

    @Override
    final Integer \u02bb\u0971() {
        return ((MediaPlayer)this.\u037a.get()).getDuration();
    }

    @Override
    final String \u02ca() {
        return "NativeVideoTracker";
    }

    @Override
    final Map<String, Object> \u02ca\u0971() throws o {
        MediaPlayer mediaPlayer = (MediaPlayer)this.\u037a.get();
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"width", (Object)mediaPlayer.getVideoWidth());
        hashMap.put((Object)"height", (Object)mediaPlayer.getVideoHeight());
        hashMap.put((Object)"duration", (Object)mediaPlayer.getDuration());
        return hashMap;
    }

    @Override
    final Integer \u02cb\u0971() {
        return ((MediaPlayer)this.\u037a.get()).getCurrentPosition();
    }

    @Override
    final void \u02cf(List<String> list) throws o {
        WeakReference<MediaPlayer> weakReference = this.\u037a;
        boolean bl = weakReference != null && weakReference.get() != null;
        if (!bl) {
            list.add((Object)"Player is null");
        }
        super.\u02cf(list);
    }

    @Override
    final boolean \u0971\u02ca() {
        WeakReference<MediaPlayer> weakReference = this.\u037a;
        return weakReference != null && weakReference.get() != null;
    }

    @Override
    final boolean \u0971\u02ce() {
        return ((MediaPlayer)this.\u037a.get()).isPlaying();
    }
}

