/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.view.View
 *  java.lang.Deprecated
 *  java.lang.Double
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 */
package com.moat.analytics.mobile.cha;

import android.app.Activity;
import android.view.View;
import com.moat.analytics.mobile.cha.MoatAdEvent;
import com.moat.analytics.mobile.cha.TrackerListener;
import com.moat.analytics.mobile.cha.VideoTrackerListener;
import java.util.Map;

public interface ReactiveVideoTracker {
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

    public boolean trackVideoAd(Map<String, String> var1, Integer var2, View var3);
}

