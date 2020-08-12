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
package com.moat.analytics.mobile.cha;

import android.media.MediaPlayer;
import android.view.View;
import com.moat.analytics.mobile.cha.NativeVideoTracker;
import com.moat.analytics.mobile.cha.TrackerListener;
import com.moat.analytics.mobile.cha.a;
import com.moat.analytics.mobile.cha.i;
import com.moat.analytics.mobile.cha.o;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class s
extends i
implements NativeVideoTracker {
    private WeakReference<MediaPlayer> \u0971\u02ca;

    s(String string) {
        super(string);
        a.\u02cf(3, "NativeVideoTracker", this, "In initialization method.");
        if (string == null || string.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder("PartnerCode is ");
            String string2 = string == null ? "null" : "empty";
            stringBuilder.append(string2);
            String string3 = stringBuilder.toString();
            StringBuilder stringBuilder2 = new StringBuilder("NativeDisplayTracker creation problem, ");
            stringBuilder2.append(string3);
            String string4 = stringBuilder2.toString();
            a.\u02cf(3, "NativeVideoTracker", this, string4);
            a.\u02ca("[ERROR] ", string4);
            this.\u0971 = new o(string3);
        }
        a.\u02ca("[SUCCESS] ", "NativeVideoTracker created");
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
            this.\u02ce();
            this.\u0971();
            if (mediaPlayer == null) throw new o("Null player instance");
        }
        catch (Exception exception) {
            o.\u02ce(exception);
            String string = o.\u02ce("trackVideoAd", exception);
            if (this.\u02ca != null) {
                this.\u02ca.onTrackingFailedToStart(string);
            }
            a.\u02cf(3, "NativeVideoTracker", this, string);
            StringBuilder stringBuilder = new StringBuilder("NativeVideoTracker ");
            stringBuilder.append(string);
            a.\u02ca("[ERROR] ", stringBuilder.toString());
            return false;
        }
        mediaPlayer.getCurrentPosition();
        {
            catch (Exception exception) {
                throw new o("Playback has already completed");
            }
        }
        this.\u0971\u02ca = new WeakReference((Object)mediaPlayer);
        return super.\u0971(map, view);
    }

    @Override
    final String \u02cb() {
        return "NativeVideoTracker";
    }

    @Override
    final void \u02cb(List<String> list) throws o {
        WeakReference<MediaPlayer> weakReference = this.\u0971\u02ca;
        boolean bl = weakReference != null && weakReference.get() != null;
        if (!bl) {
            list.add((Object)"Player is null");
        }
        super.\u02cb(list);
    }

    @Override
    final boolean \u037a() {
        WeakReference<MediaPlayer> weakReference = this.\u0971\u02ca;
        return weakReference != null && weakReference.get() != null;
    }

    @Override
    final Integer \u0971\u02cb() {
        return ((MediaPlayer)this.\u0971\u02ca.get()).getCurrentPosition();
    }

    @Override
    final boolean \u0971\u02ce() {
        return ((MediaPlayer)this.\u0971\u02ca.get()).isPlaying();
    }

    @Override
    final Integer \u0971\u141d() {
        return ((MediaPlayer)this.\u0971\u02ca.get()).getDuration();
    }

    @Override
    final Map<String, Object> \u141d() throws o {
        MediaPlayer mediaPlayer = (MediaPlayer)this.\u0971\u02ca.get();
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"width", (Object)mediaPlayer.getVideoWidth());
        hashMap.put((Object)"height", (Object)mediaPlayer.getVideoHeight());
        hashMap.put((Object)"duration", (Object)mediaPlayer.getDuration());
        return hashMap;
    }
}

