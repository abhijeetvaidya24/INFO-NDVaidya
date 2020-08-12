/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.moat.analytics.mobile.iro;

public interface TrackerListener {
    public void onTrackingFailedToStart(String var1);

    public void onTrackingStarted(String var1);

    public void onTrackingStopped(String var1);
}

