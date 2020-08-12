/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 */
package com.aerserv.sdk.view.vastplayer;

import com.aerserv.sdk.AerServEvent;
import com.aerserv.sdk.controller.listener.PlayPauseListener;

public interface VpaidPlayerListener {
    public void onAerServEvent(AerServEvent var1);

    public void onComplete();

    public void onFailure();

    public void onPlayPauseListenerCreated(PlayPauseListener var1);

    public void onStop();

    public void onTime(int var1, int var2, Integer var3);
}

