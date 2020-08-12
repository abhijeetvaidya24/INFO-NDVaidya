/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.media.MediaPlayer
 *  android.view.View
 *  java.lang.Deprecated
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 */
package com.moat.analytics.mobile.aer;

import android.media.MediaPlayer;
import android.view.View;
import com.moat.analytics.mobile.aer.MoatAdEvent;
import java.util.Map;

public interface NativeVideoTracker {
    public void changeTargetView(View var1);

    public void dispatchEvent(MoatAdEvent var1);

    @Deprecated
    public void dispatchEvent(Map<String, Object> var1);

    public void setDebug(boolean var1);

    public boolean trackVideoAd(Map<String, String> var1, MediaPlayer var2, View var3);
}

