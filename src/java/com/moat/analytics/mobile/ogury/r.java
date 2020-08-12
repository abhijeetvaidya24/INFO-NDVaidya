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
package com.moat.analytics.mobile.ogury;

import android.media.MediaPlayer;
import android.view.View;
import com.moat.analytics.mobile.ogury.NativeVideoTracker;
import com.moat.analytics.mobile.ogury.TrackerListener;
import com.moat.analytics.mobile.ogury.e;
import com.moat.analytics.mobile.ogury.h;
import com.moat.analytics.mobile.ogury.l;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class r
extends h
implements NativeVideoTracker {
    private WeakReference<MediaPlayer> \u037a;

    r(String string) {
        super(string);
        e.1.\u02cb(3, "NativeVideoTracker", this, "In initialization method.");
        if (string == null || string.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder("PartnerCode is ");
            String string2 = string == null ? "null" : "empty";
            stringBuilder.append(string2);
            String string3 = stringBuilder.toString();
            String string4 = "NativeDisplayTracker creation problem, ".concat(String.valueOf((Object)string3));
            e.1.\u02cb(3, "NativeVideoTracker", this, string4);
            e.1.\u0971("[ERROR] ", string4);
            this.\u02ce = new l(string3);
        }
        e.1.\u0971("[SUCCESS] ", "NativeVideoTracker created");
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
            this.\u0971();
            this.\u02cb();
            if (mediaPlayer == null) throw new l("Null player instance");
        }
        catch (Exception exception) {
            l.\u0971(exception);
            String string = l.\u02cb("trackVideoAd", exception);
            if (this.\u02cf != null) {
                this.\u02cf.onTrackingFailedToStart(string);
            }
            e.1.\u02cb(3, "NativeVideoTracker", this, string);
            e.1.\u0971("[ERROR] ", "NativeVideoTracker ".concat(String.valueOf((Object)string)));
            return false;
        }
        mediaPlayer.getCurrentPosition();
        {
            catch (Exception exception) {
                throw new l("Playback has already completed");
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
    final void \u02ca(List<String> list) throws l {
        WeakReference<MediaPlayer> weakReference = this.\u037a;
        boolean bl = weakReference != null && weakReference.get() != null;
        if (!bl) {
            list.add((Object)"Player is null");
        }
        super.\u02ca(list);
    }

    @Override
    final boolean \u02cb\u0971() {
        WeakReference<MediaPlayer> weakReference = this.\u037a;
        return weakReference != null && weakReference.get() != null;
    }

    @Override
    final String \u02cf() {
        return "NativeVideoTracker";
    }

    @Override
    final Integer \u037a() {
        return ((MediaPlayer)this.\u037a.get()).getCurrentPosition();
    }

    @Override
    final Map<String, Object> \u141d() throws l {
        MediaPlayer mediaPlayer = (MediaPlayer)this.\u037a.get();
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"width", (Object)mediaPlayer.getVideoWidth());
        hashMap.put((Object)"height", (Object)mediaPlayer.getVideoHeight());
        hashMap.put((Object)"duration", (Object)mediaPlayer.getDuration());
        return hashMap;
    }

    @Override
    final boolean \u141d\u0971() {
        return ((MediaPlayer)this.\u037a.get()).isPlaying();
    }
}

