/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  java.lang.Deprecated
 *  java.lang.Object
 */
package com.moat.analytics.mobile.ogury;

import android.app.Activity;
import com.moat.analytics.mobile.ogury.TrackerListener;

public interface WebAdTracker {
    public void removeListener();

    @Deprecated
    public void setActivity(Activity var1);

    public void setListener(TrackerListener var1);

    public void startTracking();

    public void stopTracking();
}

