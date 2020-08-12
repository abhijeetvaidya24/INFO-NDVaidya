/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.media.MediaPlayer
 *  android.view.View
 *  java.lang.Deprecated
 *  java.lang.Double
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 */
package com.moat.analytics.mobile.ogury;

import android.app.Activity;
import android.media.MediaPlayer;
import android.view.View;
import com.moat.analytics.mobile.ogury.MoatAdEvent;
import com.moat.analytics.mobile.ogury.TrackerListener;
import com.moat.analytics.mobile.ogury.VideoTrackerListener;
import java.util.Map;

public interface NativeVideoTracker {
    public void changeTargetView(View var1);

    public void dispatchEvent(MoatAdEvent var1);

    public void removeListener();

    public void removeVideoListener();

    @Deprecated
    public void setActivity(Activity var1);

    public void setListener(TrackerListener var1);

    public void setPlayerVolume(Double var1);

    public void setVideoListener(VideoTrackerListener var1);

    public void stopTracking();

    public boolean trackVideoAd(Map<String, String> var1, MediaPlayer var2, View var3);
}

