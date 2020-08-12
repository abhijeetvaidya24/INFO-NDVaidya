/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.ironsource.sdk.controller;

public interface VideoEventsListener {
    public void onVideoEnded();

    public void onVideoPaused();

    public void onVideoResumed();

    public void onVideoStarted();

    public void onVideoStopped();
}

