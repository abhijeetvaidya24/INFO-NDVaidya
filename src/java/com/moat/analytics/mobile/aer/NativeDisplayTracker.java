/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 */
package com.moat.analytics.mobile.aer;

import java.util.Map;

public interface NativeDisplayTracker {
    public void stopTracking();

    public boolean track(Map<String, String> var1);
}

