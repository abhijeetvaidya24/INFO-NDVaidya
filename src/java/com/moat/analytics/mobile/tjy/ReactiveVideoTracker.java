/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  java.lang.Integer
 *  java.lang.Object
 *  java.util.Map
 */
package com.moat.analytics.mobile.tjy;

import android.view.View;
import com.moat.analytics.mobile.tjy.MoatAdEvent;
import java.util.Map;

public interface ReactiveVideoTracker {
    public void changeTargetView(View var1);

    public void dispatchEvent(MoatAdEvent var1);

    public void setDebug(boolean var1);

    public boolean trackVideoAd(Map var1, Integer var2, View var3);
}

